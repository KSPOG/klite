const DISCORD_API = "https://discord.com/api/v10";
const TEXT_CHANNEL_TYPES = new Set([0, 5]);

export async function discordBotDashboard(env, userId) {
  const context = await requireDiscordDevContext(env, userId);
  if (!context) {
    return null;
  }

  const applicationId = env.DISCORD_APPLICATION_ID || env.DISCORD_CLIENT_ID;
  const [bot, guild, channels, commands, announcement, history, linked, sessions, announcements] =
    await Promise.all([
      discordApi(env, "/users/@me"),
      discordApi(env, `/guilds/${env.DISCORD_GUILD_ID}?with_counts=true`),
      discordApi(env, `/guilds/${env.DISCORD_GUILD_ID}/channels`),
      applicationId
        ? discordApi(env,
          `/applications/${applicationId}/guilds/${env.DISCORD_GUILD_ID}/commands`)
        : Promise.resolve([]),
      env.DB.prepare(
        "SELECT channel_id, enabled, updated_at FROM discord_announcement_settings WHERE id = 1"
      ).first(),
      env.DB.prepare(
        "SELECT plugin_id, version, event_type, channel_id, message_id, announced_at "
          + "FROM plugin_announcement_log ORDER BY announced_at DESC LIMIT 20"
      ).all(),
      count(env, "SELECT COUNT(*) AS total FROM discord_accounts"),
      count(env, "SELECT COUNT(*) AS total FROM sessions WHERE expires_at > ?", nowSeconds()),
      count(env, "SELECT COUNT(*) AS total FROM plugin_announcement_log")
    ]);
  const botMember = await discordApi(
    env, `/guilds/${env.DISCORD_GUILD_ID}/members/${bot.id}`
  );

  return {
    access: {
      discordUserId: context.discordId,
      devRoleId: context.devRoleId,
      devRoleName: context.roles.find((role) => role.id === context.devRoleId)?.name || "Dev"
    },
    bot: {
      id: bot.id,
      username: bot.username,
      globalName: bot.global_name || null,
      avatar: bot.avatar || null,
      verified: Boolean(bot.verified),
      guildRoleIds: botMember.roles || [],
      joinedAt: botMember.joined_at || null,
      pending: Boolean(botMember.pending)
    },
    guild: {
      id: guild.id,
      name: guild.name,
      icon: guild.icon || null,
      ownerId: guild.owner_id,
      memberCount: guild.approximate_member_count || null,
      presenceCount: guild.approximate_presence_count || null,
      description: guild.description || null,
      verificationLevel: guild.verification_level
    },
    settings: settingsPayload(context.settings, announcement, context.devRoleId),
    roles: context.roles
      .map(rolePayload)
      .sort((left, right) => right.position - left.position),
    channels: channels
      .filter((channel) => TEXT_CHANNEL_TYPES.has(channel.type))
      .map((channel) => ({
        id: channel.id,
        name: channel.name,
        type: channel.type,
        position: channel.position,
        parentId: channel.parent_id || null,
        nsfw: Boolean(channel.nsfw)
      }))
      .sort((left, right) => left.position - right.position),
    commands: commands.map((command) => ({
      id: command.id,
      name: command.name,
      description: command.description,
      version: command.version,
      defaultMemberPermissions: command.default_member_permissions || null,
      dmPermission: command.dm_permission ?? null
    })),
    announcementHistory: (history.results || []).map((entry) => ({
      pluginId: entry.plugin_id,
      version: entry.version,
      eventType: entry.event_type,
      channelId: entry.channel_id,
      messageId: entry.message_id,
      announcedAt: entry.announced_at
    })),
    stats: {
      linkedAccounts: linked,
      activeSessions: sessions,
      announcementsSent: announcements
    }
  };
}

export async function updateDiscordBotSettings(env, userId, input) {
  const context = await requireDiscordDevContext(env, userId);
  if (!context) {
    return null;
  }
  const normalized = normalizeDiscordBotSettings(input);
  if (!normalized) {
    throw new DiscordSettingsError("invalid_settings", "Enter valid bot settings.");
  }

  const roleById = new Map(context.roles.map((role) => [role.id, role]));
  const devRole = roleById.get(normalized.devRoleId);
  if (!devRole || devRole.name !== "Dev") {
    throw new DiscordSettingsError(
      "invalid_dev_role", "Dashboard access must use the Discord role named Dev."
    );
  }
  if (!context.member.roles.includes(normalized.devRoleId)) {
    throw new DiscordSettingsError(
      "dev_role_lockout",
      "You must hold the selected Dev role before it can control dashboard access."
    );
  }
  for (const roleId of [
    normalized.pluginDevRoleId,
    normalized.marketplaceReviewerRoleId,
    normalized.memberRoleId
  ]) {
    if (roleId && !roleById.has(roleId)) {
      throw new DiscordSettingsError("invalid_role", "A selected role no longer exists.");
    }
  }

  const channels = await discordApi(env, `/guilds/${env.DISCORD_GUILD_ID}/channels`);
  const channelIds = new Set(channels
    .filter((channel) => TEXT_CHANNEL_TYPES.has(channel.type))
    .map((channel) => channel.id));
  for (const channelId of [
    normalized.announcementChannelId,
    normalized.auditChannelId,
    normalized.welcomeChannelId
  ]) {
    if (channelId && !channelIds.has(channelId)) {
      throw new DiscordSettingsError(
        "invalid_channel", "A selected channel is not a server text channel."
      );
    }
  }
  if (normalized.announcementsEnabled && !normalized.announcementChannelId) {
    throw new DiscordSettingsError(
      "announcement_channel_required", "Choose an announcement channel before enabling posts."
    );
  }

  const now = nowSeconds();
  await env.DB.prepare(
    `INSERT INTO discord_bot_settings
      (id, dev_role_id, plugin_dev_role_id, marketplace_reviewer_role_id,
       member_role_id, audit_channel_id, welcome_channel_id, bot_enabled,
       auto_assign_member_role, updated_by, updated_at)
     VALUES (1, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
     ON CONFLICT(id) DO UPDATE SET dev_role_id = excluded.dev_role_id,
       plugin_dev_role_id = excluded.plugin_dev_role_id,
       marketplace_reviewer_role_id = excluded.marketplace_reviewer_role_id,
       member_role_id = excluded.member_role_id,
       audit_channel_id = excluded.audit_channel_id,
       welcome_channel_id = excluded.welcome_channel_id,
       bot_enabled = excluded.bot_enabled,
       auto_assign_member_role = excluded.auto_assign_member_role,
       updated_by = excluded.updated_by, updated_at = excluded.updated_at`
  ).bind(
    normalized.devRoleId,
    normalized.pluginDevRoleId,
    normalized.marketplaceReviewerRoleId,
    normalized.memberRoleId,
    normalized.auditChannelId,
    normalized.welcomeChannelId,
    normalized.botEnabled ? 1 : 0,
    normalized.autoAssignMemberRole ? 1 : 0,
    userId,
    now
  ).run();

  if (normalized.announcementChannelId) {
    await env.DB.prepare(
      `INSERT INTO discord_announcement_settings
        (id, channel_id, enabled, configured_by, configured_at, updated_at)
       VALUES (1, ?, ?, ?, ?, ?)
       ON CONFLICT(id) DO UPDATE SET channel_id = excluded.channel_id,
         enabled = excluded.enabled, configured_by = excluded.configured_by,
         updated_at = excluded.updated_at`
    ).bind(
      normalized.announcementChannelId,
      normalized.announcementsEnabled ? 1 : 0,
      userId,
      now,
      now
    ).run();
  } else {
    await env.DB.prepare("DELETE FROM discord_announcement_settings WHERE id = 1").run();
  }
  if (normalized.botEnabled && normalized.auditChannelId) {
    await discordApi(env, `/channels/${normalized.auditChannelId}/messages`, {
      method: "POST",
      body: {
        content: `Discord bot settings updated by <@${context.discordId}>.`,
        allowed_mentions: { parse: [] }
      }
    });
  }
  return discordBotDashboard(env, userId);
}

export async function notifyDiscordAccountLinked(env, discordId) {
  const settings = await botSettings(env);
  if (!settings || settings.bot_enabled !== 1) {
    return;
  }
  if (settings.auto_assign_member_role === 1 && settings.member_role_id) {
    await discordApi(env,
      `/guilds/${env.DISCORD_GUILD_ID}/members/${discordId}/roles/${settings.member_role_id}`,
      { method: "PUT" });
  }
  if (settings.welcome_channel_id) {
    await discordApi(env, `/channels/${settings.welcome_channel_id}/messages`, {
      method: "POST",
      body: {
        content: `<@${discordId}> linked a KLite marketplace account.`,
        allowed_mentions: { parse: ["users"], users: [discordId] }
      }
    });
  }
}

export async function pluginDeveloperRoleId(env) {
  try {
    const settings = await env.DB.prepare(
      "SELECT plugin_dev_role_id FROM discord_bot_settings WHERE id = 1"
    ).first();
    return settings?.plugin_dev_role_id || env.DISCORD_PLUGIN_DEV_ROLE_ID || null;
  } catch {
    return env.DISCORD_PLUGIN_DEV_ROLE_ID || null;
  }
}

export function normalizeDiscordBotSettings(input) {
  if (!input || typeof input !== "object") {
    return null;
  }
  const devRoleId = normalizeSnowflake(input.devRoleId);
  if (!devRoleId
      || typeof input.botEnabled !== "boolean"
      || typeof input.autoAssignMemberRole !== "boolean"
      || typeof input.announcementsEnabled !== "boolean") {
    return null;
  }
  const optionalKeys = [
    "pluginDevRoleId",
    "marketplaceReviewerRoleId",
    "memberRoleId",
    "announcementChannelId",
    "auditChannelId",
    "welcomeChannelId"
  ];
  const result = {
    devRoleId,
    botEnabled: input.botEnabled,
    autoAssignMemberRole: input.autoAssignMemberRole,
    announcementsEnabled: input.announcementsEnabled
  };
  for (const key of optionalKeys) {
    const value = normalizeOptionalSnowflake(input[key]);
    if (value === undefined) {
      return null;
    }
    result[key] = value;
  }
  return result;
}

export function normalizeSnowflake(value) {
  if (typeof value !== "string") {
    return null;
  }
  const normalized = value.trim();
  return /^\d{17,20}$/.test(normalized) ? normalized : null;
}

export class DiscordSettingsError extends Error {
  constructor(code, message) {
    super(message);
    this.code = code;
  }
}

async function requireDiscordDevContext(env, userId) {
  if (!env.DISCORD_BOT_TOKEN || !env.DISCORD_GUILD_ID) {
    return null;
  }
  const account = await env.DB.prepare(
    "SELECT discord_id FROM discord_accounts WHERE user_id = ?"
  ).bind(userId).first();
  if (!account?.discord_id) {
    return null;
  }
  const [settings, roles, member] = await Promise.all([
    botSettings(env),
    discordApi(env, `/guilds/${env.DISCORD_GUILD_ID}/roles`),
    discordApi(env, `/guilds/${env.DISCORD_GUILD_ID}/members/${account.discord_id}`)
      .catch(() => null)
  ]);
  const devRoleId = settings?.dev_role_id
    || normalizeSnowflake(env.DISCORD_DEV_ROLE_ID)
    || roles.find((role) => role.name === "Dev")?.id
    || null;
  if (!devRoleId || !Array.isArray(member?.roles) || !member.roles.includes(devRoleId)) {
    return null;
  }
  return {
    discordId: account.discord_id,
    devRoleId,
    settings,
    roles,
    member
  };
}

async function botSettings(env) {
  try {
    return await env.DB.prepare(
      `SELECT dev_role_id, plugin_dev_role_id, marketplace_reviewer_role_id,
        member_role_id, audit_channel_id, welcome_channel_id, bot_enabled,
        auto_assign_member_role, updated_at
       FROM discord_bot_settings WHERE id = 1`
    ).first();
  } catch {
    return null;
  }
}

function settingsPayload(settings, announcement, devRoleId) {
  return {
    devRoleId: settings?.dev_role_id || devRoleId,
    pluginDevRoleId: settings?.plugin_dev_role_id || null,
    marketplaceReviewerRoleId: settings?.marketplace_reviewer_role_id || null,
    memberRoleId: settings?.member_role_id || null,
    announcementChannelId: announcement?.channel_id || null,
    announcementsEnabled: announcement?.enabled === 1,
    auditChannelId: settings?.audit_channel_id || null,
    welcomeChannelId: settings?.welcome_channel_id || null,
    botEnabled: settings ? settings.bot_enabled === 1 : true,
    autoAssignMemberRole: settings?.auto_assign_member_role === 1,
    updatedAt: settings?.updated_at || null
  };
}

function rolePayload(role) {
  return {
    id: role.id,
    name: role.name,
    color: role.color,
    position: role.position,
    managed: Boolean(role.managed),
    mentionable: Boolean(role.mentionable),
    permissions: role.permissions
  };
}

async function discordApi(env, path, options = {}) {
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
    throw new Error(`Discord API ${response.status}: ${details.slice(0, 160)}`);
  }
  return response.status === 204 ? null : response.json();
}

async function count(env, query, value) {
  const statement = env.DB.prepare(query);
  const row = value === undefined
    ? await statement.first()
    : await statement.bind(value).first();
  return Number(row?.total || 0);
}

function normalizeOptionalSnowflake(value) {
  if (value === null || value === "" || value === undefined) {
    return null;
  }
  return normalizeSnowflake(value) || undefined;
}

function nowSeconds() {
  return Math.floor(Date.now() / 1000);
}
