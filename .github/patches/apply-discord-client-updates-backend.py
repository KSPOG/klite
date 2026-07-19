from __future__ import annotations

from pathlib import Path

ROOT = Path(__file__).resolve().parents[2] if '.github' in Path(__file__).parts else Path.cwd()


def read(path: str) -> str:
    return (ROOT / path).read_text(encoding='utf-8')


def write(path: str, content: str) -> None:
    target = ROOT / path
    target.parent.mkdir(parents=True, exist_ok=True)
    target.write_text(content, encoding='utf-8', newline='\n')


def replace_once(path: str, old: str, new: str) -> None:
    content = read(path)
    count = content.count(old)
    if count != 1:
        raise RuntimeError(f'{path}: expected one replacement anchor, found {count}: {old[:120]!r}')
    write(path, content.replace(old, new, 1))


def ensure_absent(path: str) -> None:
    if (ROOT / path).exists():
        raise RuntimeError(f'{path}: file already exists')


ensure_absent('marketplace-site/migrations/0008_client_updates.sql')
write('marketplace-site/migrations/0008_client_updates.sql', '''PRAGMA foreign_keys = ON;

CREATE TABLE discord_client_update_settings (
  id INTEGER PRIMARY KEY CHECK (id = 1),
  channel_id TEXT CHECK (channel_id IS NULL OR length(channel_id) BETWEEN 17 AND 20),
  role_id TEXT CHECK (role_id IS NULL OR length(role_id) BETWEEN 17 AND 20),
  enabled INTEGER NOT NULL DEFAULT 0 CHECK (enabled IN (0, 1)),
  updated_by TEXT NOT NULL REFERENCES users(id),
  updated_at INTEGER NOT NULL
);

CREATE TABLE discord_client_update_log (
  id TEXT PRIMARY KEY,
  version TEXT NOT NULL,
  updates_text TEXT NOT NULL,
  channel_id TEXT NOT NULL,
  role_id TEXT,
  message_id TEXT NOT NULL,
  posted_by TEXT NOT NULL REFERENCES users(id),
  posted_at INTEGER NOT NULL
);

CREATE INDEX discord_client_update_log_posted_at_idx
  ON discord_client_update_log(posted_at DESC);
''')

ensure_absent('marketplace-site/worker/client-updates.js')
write('marketplace-site/worker/client-updates.js', r'''const DISCORD_API = "https://discord.com/api/v10";
const VERSION_PATTERN = /^(0|[1-9]\d*)\.(0|[1-9]\d*)\.(0|[1-9]\d*)(?:[-+][0-9A-Za-z.-]+)?$/;

export async function clientUpdateDashboardData(env) {
  let setting = null;
  let history = { results: [] };
  try {
    [setting, history] = await Promise.all([
      env.DB.prepare(
        "SELECT channel_id, role_id, enabled, updated_at "
          + "FROM discord_client_update_settings WHERE id = 1"
      ).first(),
      env.DB.prepare(
        "SELECT version, updates_text, channel_id, role_id, message_id, posted_at "
          + "FROM discord_client_update_log ORDER BY posted_at DESC LIMIT 20"
      ).all()
    ]);
  } catch {
    // Migration 0008 may not yet be applied during a rolling deployment.
  }

  return {
    setting: setting ? {
      channelId: setting.channel_id || null,
      roleId: setting.role_id || null,
      enabled: setting.enabled === 1,
      updatedAt: setting.updated_at || null
    } : { channelId: null, roleId: null, enabled: false, updatedAt: null },
    currentRelease: await currentClientRelease(env),
    history: (history.results || []).map((row) => ({
      version: row.version,
      updates: row.updates_text,
      channelId: row.channel_id,
      roleId: row.role_id || null,
      messageId: row.message_id,
      postedAt: row.posted_at
    }))
  };
}

export async function saveClientUpdateSettings(env, userId, settings) {
  const now = nowSeconds();
  await env.DB.prepare(
    `INSERT INTO discord_client_update_settings
      (id, channel_id, role_id, enabled, updated_by, updated_at)
     VALUES (1, ?, ?, ?, ?, ?)
     ON CONFLICT(id) DO UPDATE SET channel_id = excluded.channel_id,
       role_id = excluded.role_id, enabled = excluded.enabled,
       updated_by = excluded.updated_by, updated_at = excluded.updated_at`
  ).bind(
    settings.channelId,
    settings.roleId,
    settings.enabled ? 1 : 0,
    userId,
    now
  ).run();
}

export async function postClientUpdateAnnouncement(env, userId, input) {
  const version = normalizeVersion(input?.version);
  const updates = normalizeUpdates(input?.updates);
  if (!version) {
    throw clientUpdateError("invalid_client_version", "Enter a valid client version such as 1.0.95.");
  }
  if (!updates) {
    throw clientUpdateError("client_updates_required", "Enter the changes included in this client update.");
  }

  const setting = await env.DB.prepare(
    "SELECT channel_id, role_id, enabled FROM discord_client_update_settings WHERE id = 1"
  ).first();
  if (!setting || setting.enabled !== 1 || !setting.channel_id) {
    throw clientUpdateError(
      "client_updates_disabled",
      "Configure and enable the client update channel before posting."
    );
  }

  const payload = buildClientUpdateMessage(version, updates, setting.role_id || null);
  const message = await discordApi(env, `/channels/${setting.channel_id}/messages`, {
    method: "POST",
    body: payload
  });
  const now = nowSeconds();
  await env.DB.prepare(
    `INSERT INTO discord_client_update_log
      (id, version, updates_text, channel_id, role_id, message_id, posted_by, posted_at)
     VALUES (?, ?, ?, ?, ?, ?, ?, ?)`
  ).bind(
    crypto.randomUUID(), version, updates, setting.channel_id,
    setting.role_id || null, message.id, userId, now
  ).run();
  return { version, channelId: setting.channel_id, roleId: setting.role_id || null, messageId: message.id };
}

export async function setClientUpdateNotificationRole(env, discordId, guildId, action) {
  if (guildId !== env.DISCORD_GUILD_ID) {
    throw clientUpdateError(
      "wrong_guild", "Use this command inside the configured KLite Discord server."
    );
  }
  const setting = await env.DB.prepare(
    "SELECT role_id, enabled FROM discord_client_update_settings WHERE id = 1"
  ).first();
  if (!setting?.role_id || setting.enabled !== 1) {
    throw clientUpdateError(
      "notification_role_unavailable",
      "Client update notifications are not configured yet."
    );
  }
  if (!new Set(["subscribe", "unsubscribe"]).has(action)) {
    throw clientUpdateError(
      "invalid_notification_action", "Choose subscribe or unsubscribe."
    );
  }

  const path = `/guilds/${env.DISCORD_GUILD_ID}/members/${discordId}/roles/${setting.role_id}`;
  await discordApi(env, path, { method: action === "subscribe" ? "PUT" : "DELETE" });
  return action === "subscribe"
    ? "You will now be notified about KLite client updates."
    : "You will no longer be notified about KLite client updates.";
}

export function buildClientUpdateMessage(version, updates, roleId) {
  const mention = roleId ? `<@&${roleId}>\n` : "";
  return {
    content: `${mention}**Client version:** ${version}\n**Updates:**\n${updates}`,
    allowed_mentions: {
      parse: [],
      roles: roleId ? [roleId] : []
    }
  };
}

export function normalizeVersion(value) {
  if (typeof value !== "string") {
    return null;
  }
  const version = value.trim();
  return VERSION_PATTERN.test(version) && version.length <= 64 ? version : null;
}

export function normalizeUpdates(value) {
  if (typeof value !== "string") {
    return null;
  }
  const updates = value
    .replace(/[\u0000-\u0008\u000b\u000c\u000e-\u001f\u007f]/g, " ")
    .replace(/\r\n?/g, "\n")
    .trim();
  return updates ? updates.slice(0, 3_000) : null;
}

async function currentClientRelease(env) {
  try {
    const response = await env.ASSETS.fetch(
      new Request(new URL("/client/windows/latest.json", env.PUBLIC_ORIGIN))
    );
    if (!response.ok) {
      return null;
    }
    const manifest = await response.json();
    const version = normalizeVersion(manifest?.version);
    return version ? {
      version,
      buildSha: typeof manifest.buildSha === "string" ? manifest.buildSha : null,
      publishedAt: typeof manifest.publishedAt === "string" ? manifest.publishedAt : null
    } : null;
  } catch {
    return null;
  }
}

async function discordApi(env, path, options = {}) {
  if (!env.DISCORD_BOT_TOKEN) {
    throw clientUpdateError("discord_bot_unavailable", "The Discord bot is not configured.");
  }
  const response = await fetch(`${DISCORD_API}${path}`, {
    method: options.method || "GET",
    headers: {
      authorization: `Bot ${env.DISCORD_BOT_TOKEN}`,
      ...(options.body ? { "content-type": "application/json" } : {})
    },
    body: options.body ? JSON.stringify(options.body) : undefined
  });
  if (!response.ok) {
    const details = await response.text();
    throw clientUpdateError(
      "discord_client_update_failed",
      `Discord rejected the client update request (${response.status}): ${details.slice(0, 160)}`
    );
  }
  return response.status === 204 ? null : response.json();
}

function clientUpdateError(code, message) {
  const error = new Error(message);
  error.code = code;
  return error;
}

function nowSeconds() {
  return Math.floor(Date.now() / 1000);
}
''')

replace_once(
    'marketplace-site/worker/discord-dashboard.js',
    'const DISCORD_API = "https://discord.com/api/v10";\n',
    'import {\n'
    '  clientUpdateDashboardData,\n'
    '  postClientUpdateAnnouncement,\n'
    '  saveClientUpdateSettings\n'
    '} from "./client-updates.js";\n\n'
    'const DISCORD_API = "https://discord.com/api/v10";\n'
)
replace_once(
    'marketplace-site/worker/discord-dashboard.js',
    '  const botMember = await discordApi(\n    env, `/guilds/${env.DISCORD_GUILD_ID}/members/${bot.id}`\n  );\n\n  return {',
    '  const [botMember, clientUpdates] = await Promise.all([\n'
    '    discordApi(env, `/guilds/${env.DISCORD_GUILD_ID}/members/${bot.id}`),\n'
    '    clientUpdateDashboardData(env)\n'
    '  ]);\n\n  return {'
)
replace_once(
    'marketplace-site/worker/discord-dashboard.js',
    '    settings: settingsPayload(context.settings, announcement, context.devRoleId),\n',
    '    settings: settingsPayload(context.settings, announcement, context.devRoleId,\n'
    '      clientUpdates.setting),\n'
)
replace_once(
    'marketplace-site/worker/discord-dashboard.js',
    '    announcementHistory: (history.results || []).map((entry) => ({\n',
    '    clientUpdates,\n'
    '    announcementHistory: (history.results || []).map((entry) => ({\n'
)
replace_once(
    'marketplace-site/worker/discord-dashboard.js',
    '    normalized.marketplaceReviewerRoleId,\n    normalized.memberRoleId\n',
    '    normalized.marketplaceReviewerRoleId,\n'
    '    normalized.memberRoleId,\n'
    '    normalized.clientUpdateRoleId\n'
)
replace_once(
    'marketplace-site/worker/discord-dashboard.js',
    '  const channels = await discordApi(env, `/guilds/${env.DISCORD_GUILD_ID}/channels`);\n',
    '  const clientUpdateRole = normalized.clientUpdateRoleId\n'
    '    ? roleById.get(normalized.clientUpdateRoleId) : null;\n'
    '  if (clientUpdateRole?.managed) {\n'
    '    throw new DiscordSettingsError(\n'
    '      "managed_client_update_role",\n'
    '      "The client update notification role must be a normal assignable server role."\n'
    '    );\n'
    '  }\n\n'
    '  const channels = await discordApi(env, `/guilds/${env.DISCORD_GUILD_ID}/channels`);\n'
)
replace_once(
    'marketplace-site/worker/discord-dashboard.js',
    '    normalized.announcementChannelId,\n    normalized.auditChannelId,\n',
    '    normalized.announcementChannelId,\n'
    '    normalized.clientUpdateChannelId,\n'
    '    normalized.auditChannelId,\n'
)
replace_once(
    'marketplace-site/worker/discord-dashboard.js',
    '  if (normalized.announcementsEnabled && !normalized.announcementChannelId) {\n',
    '  if (normalized.clientUpdatesEnabled\n'
    '      && (!normalized.clientUpdateChannelId || !normalized.clientUpdateRoleId)) {\n'
    '    throw new DiscordSettingsError(\n'
    '      "client_update_configuration_required",\n'
    '      "Choose both a client update channel and notification role before enabling posts."\n'
    '    );\n'
    '  }\n'
    '  if (normalized.announcementsEnabled && !normalized.announcementChannelId) {\n'
)
replace_once(
    'marketplace-site/worker/discord-dashboard.js',
    '  if (normalized.announcementChannelId) {\n',
    '  await saveClientUpdateSettings(env, userId, {\n'
    '    channelId: normalized.clientUpdateChannelId,\n'
    '    roleId: normalized.clientUpdateRoleId,\n'
    '    enabled: normalized.clientUpdatesEnabled\n'
    '  });\n\n'
    '  if (normalized.announcementChannelId) {\n'
)
replace_once(
    'marketplace-site/worker/discord-dashboard.js',
    '  if (normalized.botEnabled && normalized.auditChannelId) {\n',
    '  if (normalized.postClientUpdate) {\n'
    '    try {\n'
    '      await postClientUpdateAnnouncement(env, userId, {\n'
    '        version: normalized.clientUpdateVersion,\n'
    '        updates: normalized.clientUpdateNotes\n'
    '      });\n'
    '    } catch (error) {\n'
    '      throw new DiscordSettingsError(error.code || "client_update_failed", error.message);\n'
    '    }\n'
    '  }\n\n'
    '  if (normalized.botEnabled && normalized.auditChannelId) {\n'
)
replace_once(
    'marketplace-site/worker/discord-dashboard.js',
    '      || typeof input.autoAssignMemberRole !== "boolean"\n      || typeof input.announcementsEnabled !== "boolean") {\n',
    '      || typeof input.autoAssignMemberRole !== "boolean"\n'
    '      || typeof input.announcementsEnabled !== "boolean"\n'
    '      || typeof input.clientUpdatesEnabled !== "boolean"\n'
    '      || (input.postClientUpdate !== undefined\n'
    '        && typeof input.postClientUpdate !== "boolean")) {\n'
)
replace_once(
    'marketplace-site/worker/discord-dashboard.js',
    '    "memberRoleId",\n    "announcementChannelId",\n',
    '    "memberRoleId",\n'
    '    "clientUpdateRoleId",\n'
    '    "announcementChannelId",\n'
    '    "clientUpdateChannelId",\n'
)
replace_once(
    'marketplace-site/worker/discord-dashboard.js',
    '    autoAssignMemberRole: input.autoAssignMemberRole,\n    announcementsEnabled: input.announcementsEnabled\n',
    '    autoAssignMemberRole: input.autoAssignMemberRole,\n'
    '    announcementsEnabled: input.announcementsEnabled,\n'
    '    clientUpdatesEnabled: input.clientUpdatesEnabled,\n'
    '    postClientUpdate: input.postClientUpdate === true,\n'
    '    clientUpdateVersion: typeof input.clientUpdateVersion === "string"\n'
    '      ? input.clientUpdateVersion.trim() : "",\n'
    '    clientUpdateNotes: typeof input.clientUpdateNotes === "string"\n'
    '      ? input.clientUpdateNotes : ""\n'
)
replace_once(
    'marketplace-site/worker/discord-dashboard.js',
    'function settingsPayload(settings, announcement, devRoleId) {\n',
    'function settingsPayload(settings, announcement, devRoleId, clientUpdates) {\n'
)
replace_once(
    'marketplace-site/worker/discord-dashboard.js',
    '    announcementChannelId: announcement?.channel_id || null,\n    announcementsEnabled: announcement?.enabled === 1,\n',
    '    announcementChannelId: announcement?.channel_id || null,\n'
    '    announcementsEnabled: announcement?.enabled === 1,\n'
    '    clientUpdateChannelId: clientUpdates?.channelId || null,\n'
    '    clientUpdateRoleId: clientUpdates?.roleId || null,\n'
    '    clientUpdatesEnabled: clientUpdates?.enabled === true,\n'
)

replace_once(
    'marketplace-site/worker/index.js',
    'import {\n  syncPluginAnnouncements\n} from "./announcements.js";\n\n',
    'import {\n  syncPluginAnnouncements\n} from "./announcements.js";\n'
    'import {\n  setClientUpdateNotificationRole\n} from "./client-updates.js";\n\n'
)
replace_once(
    'marketplace-site/worker/index.js',
    '  if (interaction.data?.name === "account") {\n'
    '    return discordAccountCommand(env, discordUser.id,\n'
    '      interaction.guild_id, interaction.member?.roles);\n'
    '  }\n'
    '  return discordMessage("Unknown command.");\n',
    '  if (interaction.data?.name === "account") {\n'
    '    return discordAccountCommand(env, discordUser.id,\n'
    '      interaction.guild_id, interaction.member?.roles);\n'
    '  }\n'
    '  if (interaction.data?.name === "client-updates") {\n'
    '    const action = interaction.data.options\n'
    '      ?.find((option) => option.name === "action")?.value;\n'
    '    try {\n'
    '      return discordMessage(await setClientUpdateNotificationRole(\n'
    '        env, discordUser.id, interaction.guild_id, action));\n'
    '    } catch (error) {\n'
    '      return discordMessage(error.message || "Client update notifications could not be changed.");\n'
    '    }\n'
    '  }\n'
    '  return discordMessage("Unknown command.");\n'
)

replace_once(
    'marketplace-site/scripts/register-discord-commands.mjs',
    '  {\n    name: "account",\n    description: "Show the KLite account linked to your Discord user"\n  }\n];\n',
    '  {\n'
    '    name: "account",\n'
    '    description: "Show the KLite account linked to your Discord user"\n'
    '  },\n'
    '  {\n'
    '    name: "client-updates",\n'
    '    description: "Subscribe to or unsubscribe from KLite client update notifications",\n'
    '    options: [\n'
    '      {\n'
    '        type: 3,\n'
    '        name: "action",\n'
    '        description: "Choose whether to receive client update notifications",\n'
    '        required: true,\n'
    '        choices: [\n'
    '          { name: "Subscribe", value: "subscribe" },\n'
    '          { name: "Unsubscribe", value: "unsubscribe" }\n'
    '        ]\n'
    '      }\n'
    '    ]\n'
    '  }\n'
    '];\n'
)

print('Applied Discord client-update backend features.')
