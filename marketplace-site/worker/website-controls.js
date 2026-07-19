import { hashPassword, validatePassword } from "./index.js";
import {
  clientUpdateDashboardData,
  postClientUpdateAnnouncement,
  saveClientUpdateSettings
} from "./client-updates.js";
import {
  DiscordSettingsError,
  normalizeDiscordBotSettings
} from "./discord-dashboard.js";

const DISCORD_API = "https://discord.com/api/v10";
const TEXT_CHANNEL_TYPES = new Set([0, 5]);
const MANAGED_WEBSITE_ROLES = new Set(["plugin_dev", "marketplace_reviewer"]);
const RESET_STATE_SECONDS = 10 * 60;
const RESET_TOKEN_SECONDS = 15 * 60;
const encoder = new TextEncoder();
let resetSchemaReady = null;

export async function handleWebsiteControls(request, env, url, services) {
  if (request.method === "GET" && url.pathname === "/api/account") {
    return decorateAccountResponse(await services.loadAccount(), request, env);
  }
  if (request.method === "GET" && url.pathname === "/api/discord-bot/dashboard") {
    return loadWebsiteDashboard(request, env, services.loadDashboard);
  }
  if (request.method === "PUT" && url.pathname === "/api/discord-bot/settings") {
    const owner = await requireSiteOwner(request, env);
    if (!owner) return null;
    const body = await readJson(request);
    if (!body) return apiError(400, "invalid_json", "A JSON request body is required.");
    return updateOwnerDiscordSettings(env, owner.user_id, body);
  }
  if (request.method === "POST" && url.pathname === "/api/discord-bot/roles/dev") {
    return createDiscordDevRole(request, env);
  }
  if (request.method === "GET" && url.pathname === "/api/admin/users") {
    return listManagedUsers(request, env, url);
  }
  const userRolesMatch = url.pathname.match(/^\/api\/admin\/users\/([a-f0-9-]+)\/roles$/);
  if (request.method === "PUT" && userRolesMatch) {
    return updateManagedUserRoles(request, env, userRolesMatch[1]);
  }
  if (request.method === "POST" && url.pathname === "/api/auth/reset/start") {
    return startPasswordReset(request, env);
  }
  if (request.method === "GET" && url.pathname === "/api/auth/reset/callback") {
    return completePasswordResetAuthorization(url, env);
  }
  if (request.method === "POST" && url.pathname === "/api/auth/reset/complete") {
    return completePasswordReset(request, env);
  }
  return null;
}

export async function loadWebsiteDashboard(request, env, loadCoreDashboard) {
  const owner = await requireSiteOwner(request, env);
  const response = await loadCoreDashboard();
  if (response.ok) {
    const payload = await response.json();
    payload.access = {
      ...payload.access,
      method: owner ? "site_owner" : "discord_role"
    };
    payload.install = installPayload(env, true);
    return responseWithJson(response, payload);
  }
  if (!owner) return response;
  try {
    return json(await ownerDiscordDashboard(env, owner.user_id));
  } catch (error) {
    console.error("Unable to build the owner Discord dashboard", error);
    return apiError(502, "discord_unavailable",
      error.message || "Discord bot information is temporarily unavailable.");
  }
}

export async function updateWebsiteDashboardSettings(request, env, input, updateCoreSettings) {
  const owner = await requireSiteOwner(request, env);
  if (!owner) return updateCoreSettings(input);
  return updateOwnerDiscordSettings(env, owner.user_id, input);
}

async function decorateAccountResponse(response, request, env) {
  if (!response.ok) return response;
  const payload = await response.json();
  const accountId = payload.account?.id;
  if (!accountId) return responseWithJson(response, payload);
  const owner = await env.DB.prepare(
    "SELECT 1 AS allowed FROM user_roles WHERE user_id = ? AND role = 'site_owner'"
  ).bind(accountId).first();
  if (owner?.allowed) {
    payload.account.roles = [...new Set([...(payload.account.roles || []), "site_owner"])];
    payload.account.capabilities = [...new Set([...(payload.account.capabilities || []), "site_owner"])];
  }
  return responseWithJson(response, payload);
}

async function listManagedUsers(request, env, url) {
  const owner = await requireSiteOwner(request, env);
  if (!owner) return apiError(403, "site_owner_required", "KLite owner access is required.");
  const query = String(url.searchParams.get("query") || "").trim().toLowerCase().slice(0, 120);
  const pattern = `%${query}%`;
  const result = await env.DB.prepare(
    `SELECT users.id, users.email, users.username, GROUP_CONCAT(user_roles.role) AS roles
     FROM users
     LEFT JOIN user_roles ON user_roles.user_id = users.id
     WHERE (? = '' OR lower(users.username) LIKE ? OR lower(users.email) LIKE ?)
     GROUP BY users.id, users.email, users.username
     ORDER BY lower(users.username), lower(users.email)
     LIMIT 100`
  ).bind(query, pattern, pattern).all();
  return json({
    users: (result.results || []).map((row) => {
      const roles = String(row.roles || "").split(",").filter(Boolean);
      return {
        id: row.id,
        email: row.email,
        username: row.username,
        roles,
        owner: roles.includes("site_owner")
      };
    })
  });
}

async function updateManagedUserRoles(request, env, userId) {
  const owner = await requireSiteOwner(request, env);
  if (!owner) return apiError(403, "site_owner_required", "KLite owner access is required.");
  const body = await readJson(request);
  const roles = Array.isArray(body?.roles) ? [...new Set(body.roles)] : null;
  if (!roles || roles.some((role) => !MANAGED_WEBSITE_ROLES.has(role))) {
    return apiError(400, "invalid_roles", "Choose only Plugin Dev or marketplace reviewer access.");
  }
  const target = await env.DB.prepare(
    "SELECT id, email, username FROM users WHERE id = ?"
  ).bind(userId).first();
  if (!target) return apiError(404, "user_not_found", "The marketplace account no longer exists.");

  const statements = [env.DB.prepare(
    "DELETE FROM user_roles WHERE user_id = ? AND role IN ('plugin_dev', 'marketplace_reviewer')"
  ).bind(userId)];
  for (const role of roles) {
    statements.push(env.DB.prepare(
      "INSERT OR IGNORE INTO user_roles (user_id, role, granted_by, granted_at) VALUES (?, ?, ?, ?)"
    ).bind(userId, role, owner.user_id, nowSeconds()));
  }
  await env.DB.batch(statements);
  const rows = await env.DB.prepare(
    "SELECT role FROM user_roles WHERE user_id = ? ORDER BY role"
  ).bind(userId).all();
  const currentRoles = (rows.results || []).map((row) => row.role);
  return json({
    user: {
      ...target,
      roles: currentRoles,
      owner: currentRoles.includes("site_owner")
    }
  });
}

async function createDiscordDevRole(request, env) {
  const owner = await requireSiteOwner(request, env);
  if (!owner) return apiError(403, "site_owner_required", "KLite owner access is required.");
  if (!env.DISCORD_BOT_TOKEN || !env.DISCORD_GUILD_ID) {
    return apiError(503, "discord_bot_unavailable", "The Discord bot is not configured.");
  }
  try {
    const roles = await discordApi(env, `/guilds/${env.DISCORD_GUILD_ID}/roles`);
    let role = roles.find((item) => item.name === "Dev");
    if (!role) {
      role = await discordApi(env, `/guilds/${env.DISCORD_GUILD_ID}/roles`, {
        method: "POST",
        body: {
          name: "Dev",
          permissions: "0",
          hoist: true,
          mentionable: false
        }
      });
    }

    const account = await env.DB.prepare(
      "SELECT discord_id FROM discord_accounts WHERE user_id = ?"
    ).bind(owner.user_id).first();
    if (account?.discord_id) {
      await discordApi(env,
        `/guilds/${env.DISCORD_GUILD_ID}/members/${account.discord_id}/roles/${role.id}`,
        { method: "PUT" });
    }

    const updated = await env.DB.prepare(
      "UPDATE discord_bot_settings SET dev_role_id = ?, updated_by = ?, updated_at = ? WHERE id = 1"
    ).bind(role.id, owner.user_id, nowSeconds()).run();
    if (!updated.meta?.changes) {
      await env.DB.prepare(
        `INSERT INTO discord_bot_settings
          (id, dev_role_id, plugin_dev_role_id, marketplace_reviewer_role_id,
           member_role_id, audit_channel_id, welcome_channel_id, bot_enabled,
           auto_assign_member_role, updated_by, updated_at)
         VALUES (1, ?, NULL, NULL, NULL, NULL, NULL, 1, 0, ?, ?)`
      ).bind(role.id, owner.user_id, nowSeconds()).run();
    }
    return json(await ownerDiscordDashboard(env, owner.user_id));
  } catch (error) {
    console.error("Unable to create the Discord Dev role", error);
    return apiError(502, "discord_role_creation_failed",
      error.message || "The Discord Dev role could not be created.");
  }
}

async function ownerDiscordDashboard(env, userId) {
  const applicationId = env.DISCORD_APPLICATION_ID || env.DISCORD_CLIENT_ID || null;
  const bot = env.DISCORD_BOT_TOKEN
    ? await discordMaybe(env, "/users/@me") : null;
  const guild = env.DISCORD_BOT_TOKEN && env.DISCORD_GUILD_ID
    ? await discordMaybe(env, `/guilds/${env.DISCORD_GUILD_ID}?with_counts=true`) : null;
  const installed = Boolean(bot && guild);

  let roles = [];
  let channels = [];
  let commands = [];
  let botMember = null;
  if (installed) {
    [roles, channels, commands, botMember] = await Promise.all([
      discordMaybe(env, `/guilds/${env.DISCORD_GUILD_ID}/roles`, []),
      discordMaybe(env, `/guilds/${env.DISCORD_GUILD_ID}/channels`, []),
      applicationId
        ? discordMaybe(env,
          `/applications/${applicationId}/guilds/${env.DISCORD_GUILD_ID}/commands`, [])
        : Promise.resolve([]),
      discordMaybe(env, `/guilds/${env.DISCORD_GUILD_ID}/members/${bot.id}`)
    ]);
  }

  const [settings, announcement, history, linked, sessions, announcements, account, clientUpdates] =
    await Promise.all([
      safeFirst(env,
        `SELECT dev_role_id, plugin_dev_role_id, marketplace_reviewer_role_id,
          member_role_id, audit_channel_id, welcome_channel_id, bot_enabled,
          auto_assign_member_role, updated_at
         FROM discord_bot_settings WHERE id = 1`),
      safeFirst(env,
        "SELECT channel_id, enabled, updated_at FROM discord_announcement_settings WHERE id = 1"),
      safeAll(env,
        `SELECT plugin_id, version, event_type, channel_id, message_id, announced_at
         FROM plugin_announcement_log ORDER BY announced_at DESC LIMIT 20`),
      count(env, "SELECT COUNT(*) AS total FROM discord_accounts"),
      count(env, "SELECT COUNT(*) AS total FROM sessions WHERE expires_at > ?", nowSeconds()),
      count(env, "SELECT COUNT(*) AS total FROM plugin_announcement_log"),
      safeFirst(env, "SELECT discord_id FROM discord_accounts WHERE user_id = ?", userId),
      clientUpdateDashboardData(env)
    ]);

  const devRoleId = settings?.dev_role_id
    || normalizeSnowflake(env.DISCORD_DEV_ROLE_ID)
    || roles.find((role) => role.name === "Dev")?.id
    || null;
  return {
    access: {
      method: "site_owner",
      discordUserId: account?.discord_id || null,
      devRoleId,
      devRoleName: roles.find((role) => role.id === devRoleId)?.name || "Dev"
    },
    install: installPayload(env, installed),
    bot: {
      id: bot?.id || applicationId || "not-configured",
      username: bot?.username || "KLite Bot",
      globalName: bot?.global_name || null,
      avatar: bot?.avatar || null,
      verified: Boolean(bot?.verified),
      guildRoleIds: botMember?.roles || [],
      joinedAt: botMember?.joined_at || null,
      pending: Boolean(botMember?.pending)
    },
    guild: {
      id: guild?.id || env.DISCORD_GUILD_ID || "not-configured",
      name: guild?.name || "Configured Discord server",
      icon: guild?.icon || null,
      ownerId: guild?.owner_id || null,
      memberCount: guild?.approximate_member_count || null,
      presenceCount: guild?.approximate_presence_count || null,
      description: guild?.description || null,
      verificationLevel: guild?.verification_level ?? null
    },
    settings: {
      devRoleId,
      pluginDevRoleId: settings?.plugin_dev_role_id || null,
      marketplaceReviewerRoleId: settings?.marketplace_reviewer_role_id || null,
      memberRoleId: settings?.member_role_id || null,
      announcementChannelId: announcement?.channel_id || null,
      announcementsEnabled: announcement?.enabled === 1,
      clientUpdateChannelId: clientUpdates.setting?.channelId || null,
      clientUpdateRoleId: clientUpdates.setting?.roleId || null,
      clientUpdatesEnabled: clientUpdates.setting?.enabled === true,
      auditChannelId: settings?.audit_channel_id || null,
      welcomeChannelId: settings?.welcome_channel_id || null,
      botEnabled: settings ? settings.bot_enabled === 1 : true,
      autoAssignMemberRole: settings?.auto_assign_member_role === 1,
      updatedAt: settings?.updated_at || null
    },
    roles: roles.map(rolePayload).sort((left, right) => right.position - left.position),
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
    clientUpdates,
    announcementHistory: history.map((entry) => ({
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

async function updateOwnerDiscordSettings(env, userId, input) {
  try {
    const normalized = normalizeDiscordBotSettings(input);
    if (!normalized) {
      throw new DiscordSettingsError("invalid_settings", "Enter valid bot settings.");
    }
    if (!env.DISCORD_BOT_TOKEN || !env.DISCORD_GUILD_ID) {
      return apiError(503, "discord_bot_unavailable", "The Discord bot is not configured.");
    }
    const [roles, channels] = await Promise.all([
      discordApi(env, `/guilds/${env.DISCORD_GUILD_ID}/roles`),
      discordApi(env, `/guilds/${env.DISCORD_GUILD_ID}/channels`)
    ]);
    const roleById = new Map(roles.map((role) => [role.id, role]));
    const devRole = roleById.get(normalized.devRoleId);
    if (!devRole || devRole.name !== "Dev") {
      throw new DiscordSettingsError(
        "invalid_dev_role", "Dashboard access must use the Discord role named Dev."
      );
    }
    for (const roleId of [
      normalized.pluginDevRoleId,
      normalized.marketplaceReviewerRoleId,
      normalized.memberRoleId,
      normalized.clientUpdateRoleId
    ]) {
      if (roleId && !roleById.has(roleId)) {
        throw new DiscordSettingsError("invalid_role", "A selected role no longer exists.");
      }
    }
    if (normalized.clientUpdateRoleId && roleById.get(normalized.clientUpdateRoleId)?.managed) {
      throw new DiscordSettingsError(
        "managed_client_update_role",
        "The client update notification role must be a normal assignable server role."
      );
    }
    const channelIds = new Set(channels
      .filter((channel) => TEXT_CHANNEL_TYPES.has(channel.type))
      .map((channel) => channel.id));
    for (const channelId of [
      normalized.announcementChannelId,
      normalized.clientUpdateChannelId,
      normalized.auditChannelId,
      normalized.welcomeChannelId
    ]) {
      if (channelId && !channelIds.has(channelId)) {
        throw new DiscordSettingsError(
          "invalid_channel", "A selected channel is not a server text channel."
        );
      }
    }
    if (normalized.clientUpdatesEnabled
        && (!normalized.clientUpdateChannelId || !normalized.clientUpdateRoleId)) {
      throw new DiscordSettingsError(
        "client_update_configuration_required",
        "Choose both a client update channel and notification role before enabling posts."
      );
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

    await saveClientUpdateSettings(env, userId, {
      channelId: normalized.clientUpdateChannelId,
      roleId: normalized.clientUpdateRoleId,
      enabled: normalized.clientUpdatesEnabled
    });
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
    if (normalized.postClientUpdate) {
      await postClientUpdateAnnouncement(env, userId, {
        version: normalized.clientUpdateVersion,
        updates: normalized.clientUpdateNotes
      });
    }
    const account = await env.DB.prepare(
      "SELECT discord_id FROM discord_accounts WHERE user_id = ?"
    ).bind(userId).first();
    if (normalized.botEnabled && normalized.auditChannelId) {
      await discordApi(env, `/channels/${normalized.auditChannelId}/messages`, {
        method: "POST",
        body: {
          content: account?.discord_id
            ? `Discord bot settings updated by <@${account.discord_id}>.`
            : "Discord bot settings updated by the KLite site owner.",
          allowed_mentions: { parse: [] }
        }
      });
    }
    return json(await ownerDiscordDashboard(env, userId));
  } catch (error) {
    if (error instanceof DiscordSettingsError || error?.code) {
      return apiError(400, error.code || "invalid_settings", error.message);
    }
    console.error("Unable to update owner Discord settings", error);
    return apiError(502, "discord_unavailable",
      error.message || "Discord bot settings could not be updated.");
  }
}

async function startPasswordReset(request, env) {
  await ensureResetSchema(env);
  const body = await readJson(request);
  const email = normalizeEmail(body?.email);
  if (!email) return apiError(400, "invalid_email", "Enter a valid marketplace email address.");
  const user = await env.DB.prepare(
    `SELECT users.id, users.email, discord_accounts.discord_id
     FROM users
     LEFT JOIN discord_accounts ON discord_accounts.user_id = users.id
     WHERE users.email = ?`
  ).bind(email).first();

  if (user && body?.recoveryKey && env.OWNER_RECOVERY_KEY
      && await constantTimeTextEqual(String(body.recoveryKey), String(env.OWNER_RECOVERY_KEY))) {
    const owner = await env.DB.prepare(
      "SELECT 1 AS allowed FROM user_roles WHERE user_id = ? AND role = 'site_owner'"
    ).bind(user.id).first();
    if (owner?.allowed) {
      return json({ resetToken: await issueResetToken(env, user.id) });
    }
  }

  if (!user?.discord_id || !env.DISCORD_CLIENT_ID || !env.DISCORD_CLIENT_SECRET) {
    return json({
      message: "If this account can be recovered, continue through its linked Discord identity."
    });
  }
  const state = randomToken(32);
  await env.DB.prepare("DELETE FROM password_reset_states WHERE user_id = ?").bind(user.id).run();
  await env.DB.prepare(
    "INSERT INTO password_reset_states (state_hash, user_id, expires_at) VALUES (?, ?, ?)"
  ).bind(await sha256(state), user.id, nowSeconds() + RESET_STATE_SECONDS).run();
  const authorize = new URL("https://discord.com/oauth2/authorize");
  authorize.searchParams.set("client_id", env.DISCORD_CLIENT_ID);
  authorize.searchParams.set("redirect_uri", passwordResetRedirect(env));
  authorize.searchParams.set("response_type", "code");
  authorize.searchParams.set("scope", "identify email");
  authorize.searchParams.set("state", state);
  authorize.searchParams.set("prompt", "consent");
  return json({ authorizeUrl: authorize.toString() });
}

async function completePasswordResetAuthorization(url, env) {
  await ensureResetSchema(env);
  const state = url.searchParams.get("state");
  const code = url.searchParams.get("code");
  const oauthError = url.searchParams.get("error");
  if (!state || !code || oauthError) return redirectReset(env, null, "discord_authorization_failed");
  const stateHash = await sha256(state);
  const pending = await env.DB.prepare(
    `SELECT password_reset_states.user_id, users.email, discord_accounts.discord_id
     FROM password_reset_states
     JOIN users ON users.id = password_reset_states.user_id
     LEFT JOIN discord_accounts ON discord_accounts.user_id = users.id
     WHERE password_reset_states.state_hash = ? AND password_reset_states.expires_at > ?`
  ).bind(stateHash, nowSeconds()).first();
  if (!pending?.discord_id) return redirectReset(env, null, "reset_state_expired");

  try {
    const tokenResponse = await fetch("https://discord.com/api/v10/oauth2/token", {
      method: "POST",
      headers: { "content-type": "application/x-www-form-urlencoded" },
      body: new URLSearchParams({
        client_id: env.DISCORD_CLIENT_ID,
        client_secret: env.DISCORD_CLIENT_SECRET,
        grant_type: "authorization_code",
        code,
        redirect_uri: passwordResetRedirect(env)
      })
    });
    if (!tokenResponse.ok) throw new Error(`Discord token exchange returned ${tokenResponse.status}`);
    const oauth = await tokenResponse.json();
    const profileResponse = await fetch("https://discord.com/api/v10/users/@me", {
      headers: { authorization: `Bearer ${oauth.access_token}` }
    });
    if (!profileResponse.ok) throw new Error(`Discord profile request returned ${profileResponse.status}`);
    const profile = await profileResponse.json();
    const emailMatches = profile.verified === true
      && normalizeEmail(profile.email) === normalizeEmail(pending.email);
    if (profile.id !== pending.discord_id || !emailMatches) {
      return redirectReset(env, null, "discord_identity_mismatch");
    }
    await env.DB.prepare("DELETE FROM password_reset_states WHERE state_hash = ?")
      .bind(stateHash).run();
    return redirectReset(env, await issueResetToken(env, pending.user_id), null);
  } catch (error) {
    console.error("Password reset Discord verification failed", error);
    return redirectReset(env, null, "discord_verification_failed");
  }
}

async function completePasswordReset(request, env) {
  await ensureResetSchema(env);
  const body = await readJson(request);
  const passwordError = validatePassword(body?.password);
  if (typeof body?.token !== "string" || passwordError) {
    return apiError(400, "invalid_password_reset", passwordError || "The reset token is required.");
  }
  const tokenHash = await sha256(body.token);
  const pending = await env.DB.prepare(
    `SELECT user_id FROM password_reset_tokens
     WHERE token_hash = ? AND expires_at > ? AND consumed_at IS NULL`
  ).bind(tokenHash, nowSeconds()).first();
  if (!pending) return apiError(400, "reset_token_invalid", "The password reset link is invalid or expired.");
  const consumed = await env.DB.prepare(
    `UPDATE password_reset_tokens SET consumed_at = ?
     WHERE token_hash = ? AND expires_at > ? AND consumed_at IS NULL`
  ).bind(nowSeconds(), tokenHash, nowSeconds()).run();
  if (!consumed.meta?.changes) {
    return apiError(400, "reset_token_invalid", "The password reset link is invalid or expired.");
  }
  await env.DB.prepare(
    "UPDATE users SET password_hash = ?, updated_at = ? WHERE id = ?"
  ).bind(await hashPassword(body.password, env.PASSWORD_PEPPER), nowSeconds(), pending.user_id).run();
  return json({ message: "Password updated. You can now sign in." });
}

async function issueResetToken(env, userId) {
  const token = randomToken(32);
  await env.DB.prepare("DELETE FROM password_reset_tokens WHERE user_id = ?").bind(userId).run();
  await env.DB.prepare(
    `INSERT INTO password_reset_tokens
      (token_hash, user_id, expires_at, consumed_at) VALUES (?, ?, ?, NULL)`
  ).bind(await sha256(token), userId, nowSeconds() + RESET_TOKEN_SECONDS).run();
  return token;
}

async function ensureResetSchema(env) {
  if (!resetSchemaReady) {
    resetSchemaReady = (async () => {
      await env.DB.prepare(
        `CREATE TABLE IF NOT EXISTS password_reset_states (
          state_hash TEXT PRIMARY KEY,
          user_id TEXT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
          expires_at INTEGER NOT NULL
        )`
      ).run();
      await env.DB.prepare(
        `CREATE TABLE IF NOT EXISTS password_reset_tokens (
          token_hash TEXT PRIMARY KEY,
          user_id TEXT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
          expires_at INTEGER NOT NULL,
          consumed_at INTEGER
        )`
      ).run();
      await env.DB.prepare(
        "CREATE INDEX IF NOT EXISTS password_reset_states_expires_idx ON password_reset_states(expires_at)"
      ).run();
      await env.DB.prepare(
        "CREATE INDEX IF NOT EXISTS password_reset_tokens_expires_idx ON password_reset_tokens(expires_at)"
      ).run();
    })().catch((error) => {
      resetSchemaReady = null;
      throw error;
    });
  }
  return resetSchemaReady;
}

export function installPayload(env, installed) {
  const required = [
    "DISCORD_CLIENT_ID",
    "DISCORD_CLIENT_SECRET",
    "DISCORD_PUBLIC_KEY",
    "DISCORD_BOT_TOKEN",
    "DISCORD_GUILD_ID"
  ];
  const missing = required.filter((name) => !env[name]);
  const applicationId = env.DISCORD_APPLICATION_ID || env.DISCORD_CLIENT_ID || null;
  let inviteUrl = null;
  if (applicationId && env.DISCORD_GUILD_ID) {
    const invite = new URL("https://discord.com/oauth2/authorize");
    invite.searchParams.set("client_id", applicationId);
    invite.searchParams.set("scope", "bot applications.commands");
    invite.searchParams.set("permissions", "268651520");
    invite.searchParams.set("guild_id", env.DISCORD_GUILD_ID);
    invite.searchParams.set("disable_guild_select", "true");
    inviteUrl = invite.toString();
  }
  return {
    installed: Boolean(installed),
    configured: missing.length === 0,
    missing,
    inviteUrl,
    guildId: env.DISCORD_GUILD_ID || null,
    interactionEndpoint: `${origin(env)}/api/discord/interactions`,
    passwordResetRedirect: passwordResetRedirect(env)
  };
}

async function requireSiteOwner(request, env) {
  const session = await sessionForRequest(request, env);
  if (!session) return null;
  const role = await env.DB.prepare(
    "SELECT 1 AS allowed FROM user_roles WHERE user_id = ? AND role = 'site_owner'"
  ).bind(session.user_id).first();
  return role?.allowed ? session : null;
}

async function sessionForRequest(request, env) {
  const token = sessionToken(request);
  if (!token) return null;
  const tokenHash = await sha256(token);
  const session = await env.DB.prepare(
    "SELECT user_id, kind, expires_at FROM sessions WHERE token_hash = ? AND expires_at > ?"
  ).bind(tokenHash, nowSeconds()).first();
  if (!session) return null;
  await env.DB.prepare("UPDATE sessions SET last_used_at = ? WHERE token_hash = ?")
    .bind(nowSeconds(), tokenHash).run();
  return session;
}

function sessionToken(request) {
  const authorization = request.headers.get("authorization");
  if (authorization?.startsWith("Bearer ")) return authorization.slice(7).trim();
  const cookie = request.headers.get("cookie") || "";
  const match = cookie.match(/(?:^|;\s*)klite_session=([^;]+)/);
  return match ? decodeURIComponent(match[1]) : null;
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
  if (!env.DISCORD_BOT_TOKEN) throw codedError("discord_bot_unavailable", "The Discord bot token is not configured.");
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
    throw codedError("discord_api_failed", `Discord API ${response.status}: ${details.slice(0, 240)}`);
  }
  return response.status === 204 ? null : response.json();
}

async function discordMaybe(env, path, fallback = null) {
  try {
    return await discordApi(env, path);
  } catch {
    return fallback;
  }
}

async function safeFirst(env, query, value) {
  try {
    const statement = env.DB.prepare(query);
    return value === undefined ? statement.first() : statement.bind(value).first();
  } catch {
    return null;
  }
}

async function safeAll(env, query) {
  try {
    const result = await env.DB.prepare(query).all();
    return result.results || [];
  } catch {
    return [];
  }
}

async function count(env, query, value) {
  const row = await safeFirst(env, query, value);
  return Number(row?.total || 0);
}

function normalizeSnowflake(value) {
  const normalized = typeof value === "string" ? value.trim() : "";
  return /^\d{17,20}$/.test(normalized) ? normalized : null;
}

function normalizeEmail(value) {
  if (typeof value !== "string") return null;
  const email = value.trim().toLowerCase();
  return email.length <= 254 && /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email) ? email : null;
}

async function readJson(request) {
  if (!request.headers.get("content-type")?.toLowerCase().startsWith("application/json")) return null;
  try {
    const raw = await request.text();
    if (encoder.encode(raw).byteLength > 16_384) return null;
    return JSON.parse(raw);
  } catch {
    return null;
  }
}

function redirectReset(env, token, error) {
  const location = new URL("/", origin(env));
  location.hash = token
    ? `reset-token=${encodeURIComponent(token)}`
    : `reset-error=${encodeURIComponent(error || "reset_failed")}`;
  return new Response(null, {
    status: 302,
    headers: { location: location.toString(), "cache-control": "no-store" }
  });
}

function passwordResetRedirect(env) {
  return `${origin(env)}/api/auth/reset/callback`;
}

function origin(env) {
  return new URL(env.PUBLIC_ORIGIN || "https://klite-marketplace.pages.dev").origin;
}

function responseWithJson(response, payload) {
  const headers = new Headers(response.headers);
  headers.delete("content-length");
  headers.set("content-type", "application/json; charset=utf-8");
  headers.set("cache-control", "no-store");
  return new Response(JSON.stringify(payload), {
    status: response.status,
    statusText: response.statusText,
    headers
  });
}

function codedError(code, message) {
  const error = new Error(message);
  error.code = code;
  return error;
}

async function sha256(value) {
  const digest = await crypto.subtle.digest("SHA-256", encoder.encode(value));
  return Array.from(new Uint8Array(digest),
    (byte) => byte.toString(16).padStart(2, "0")).join("");
}

async function constantTimeTextEqual(left, right) {
  const leftDigest = await crypto.subtle.digest("SHA-256", encoder.encode(left));
  const rightDigest = await crypto.subtle.digest("SHA-256", encoder.encode(right));
  const a = new Uint8Array(leftDigest);
  const b = new Uint8Array(rightDigest);
  let difference = a.length ^ b.length;
  for (let index = 0; index < Math.max(a.length, b.length); index += 1) {
    difference |= (a[index] || 0) ^ (b[index] || 0);
  }
  return difference === 0;
}

function randomToken(byteLength) {
  const bytes = new Uint8Array(byteLength);
  crypto.getRandomValues(bytes);
  let binary = "";
  for (const value of bytes) binary += String.fromCharCode(value);
  return btoa(binary).replace(/\+/g, "-").replace(/\//g, "_").replace(/=+$/, "");
}

function apiError(status, code, message) {
  return json({ error: { code, message } }, status);
}

function json(payload, status = 200) {
  return new Response(JSON.stringify(payload), {
    status,
    headers: {
      "content-type": "application/json; charset=utf-8",
      "cache-control": "no-store",
      "x-content-type-options": "nosniff"
    }
  });
}

function nowSeconds() {
  return Math.floor(Date.now() / 1000);
}
