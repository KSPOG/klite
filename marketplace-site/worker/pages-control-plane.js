import { syncPluginAnnouncements } from "./announcements.js";

const encoder = new TextEncoder();
const DISCORD_API = "https://discord.com/api/v10";
const TEXT_CHANNEL_TYPES = new Set([0, 5]);
const BOT_PERMISSIONS = "268520448";
const ALLOWED_MANAGED_ROLES = new Set(["plugin_dev", "marketplace_reviewer"]);

export async function handleControlPlane(request, env, url = new URL(request.url)) {
  if (request.method === "GET" && url.pathname === "/api/account") {
    return accountResponse(request, env);
  }
  if (request.method === "GET" && url.pathname === "/api/discord-bot/dashboard") {
    return discordDashboardResponse(request, env);
  }
  if (request.method === "PUT" && url.pathname === "/api/discord-bot/settings") {
    return updateDiscordSettingsResponse(request, env);
  }
  if (request.method === "POST" && url.pathname === "/api/discord-bot/roles/dev") {
    return createDevRoleResponse(request, env);
  }
  if (request.method === "POST" && url.pathname === "/api/discord-bot/commands/register") {
    return registerCommandsResponse(request, env);
  }
  if (request.method === "POST" && url.pathname === "/api/discord-bot/announcements/sync") {
    return syncAnnouncementsResponse(request, env);
  }
  if (request.method === "GET" && url.pathname === "/api/admin/users") {
    return adminUsersResponse(request, env, url);
  }
  const roleMatch = url.pathname.match(/^\/api\/admin\/users\/([a-f0-9-]+)\/roles$/i);
  if (roleMatch && request.method === "PUT") {
    return updateUserRolesResponse(request, env, roleMatch[1]);
  }
  if (request.method === "GET" && url.pathname === "/api/review/submissions") {
    return reviewQueueResponse(request, env);
  }
  const decisionMatch = url.pathname.match(/^\/api\/review\/submissions\/([a-f0-9-]+)\/decision$/i);
  if (decisionMatch && request.method === "POST") {
    return reviewDecisionResponse(request, env, decisionMatch[1]);
  }
  return null;
}

async function accountResponse(request, env) {
  const context = await authenticatedContext(request, env);
  if (!context) {
    return apiError(401, "authentication_required", "Sign in to continue.");
  }
  return json({
    account: accountPayload(context),
    entitlements: await entitlements(env, context.user.id)
  });
}

async function discordDashboardResponse(request, env) {
  const context = await requireBotAdministrator(request, env);
  if (!context) {
    return apiError(403, "discord_admin_required",
      "The KLite owner or a linked member with the configured dashboard role is required.");
  }
  return json(await buildDiscordDashboard(env, context));
}

async function updateDiscordSettingsResponse(request, env) {
  const context = await requireBotAdministrator(request, env);
  if (!context) {
    return apiError(403, "discord_admin_required", "Discord bot administrator access is required.");
  }
  const dashboard = await buildDiscordDashboard(env, context);
  if (!dashboard.install.installed) {
    return apiError(409, "bot_not_installed", "Install the bot in the designated server before saving settings.");
  }
  const body = await readJson(request);
  const normalized = normalizeDiscordBotSettings(body);
  if (!normalized) {
    return apiError(400, "invalid_settings", "Enter valid Discord bot settings.");
  }

  const roleIds = new Set(dashboard.roles.map((role) => role.id));
  const channelIds = new Set(dashboard.channels.map((channel) => channel.id));
  if (!roleIds.has(normalized.devRoleId)) {
    return apiError(400, "invalid_dev_role", "Choose a dashboard administrator role from the designated server.");
  }
  for (const roleId of [normalized.pluginDevRoleId, normalized.marketplaceReviewerRoleId, normalized.memberRoleId]) {
    if (roleId && !roleIds.has(roleId)) {
      return apiError(400, "invalid_role", "A selected Discord role no longer exists.");
    }
  }
  for (const channelId of [normalized.announcementChannelId, normalized.auditChannelId, normalized.welcomeChannelId]) {
    if (channelId && !channelIds.has(channelId)) {
      return apiError(400, "invalid_channel", "A selected Discord channel no longer exists.");
    }
  }
  if (normalized.announcementsEnabled && !normalized.announcementChannelId) {
    return apiError(400, "announcement_channel_required",
      "Choose an announcement channel before enabling marketplace announcements.");
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
    context.user.id,
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
    ).bind(normalized.announcementChannelId, normalized.announcementsEnabled ? 1 : 0,
      context.user.id, now, now).run();
  } else {
    await env.DB.prepare("DELETE FROM discord_announcement_settings WHERE id = 1").run();
  }
  return json(await buildDiscordDashboard(env, context));
}

async function createDevRoleResponse(request, env) {
  const context = await requireBotAdministrator(request, env);
  if (!context) return apiError(403, "discord_admin_required", "Discord bot administrator access is required.");
  const dashboard = await buildDiscordDashboard(env, context);
  if (!dashboard.install.installed) {
    return apiError(409, "bot_not_installed", "Install the bot before creating its dashboard role.");
  }
  const existing = dashboard.roles.find((role) => role.name === "Dev");
  if (!existing) {
    await discordApi(env, `/guilds/${env.DISCORD_GUILD_ID}/roles`, {
      method: "POST",
      body: { name: "Dev", permissions: "0", mentionable: false, hoist: false }
    });
  }
  return json(await buildDiscordDashboard(env, context));
}

async function registerCommandsResponse(request, env) {
  const context = await requireBotAdministrator(request, env);
  if (!context) return apiError(403, "discord_admin_required", "Discord bot administrator access is required.");
  const applicationId = env.DISCORD_APPLICATION_ID || env.DISCORD_CLIENT_ID;
  if (!applicationId || !env.DISCORD_GUILD_ID || !env.DISCORD_BOT_TOKEN) {
    return apiError(503, "discord_not_configured", "Discord application, server, and bot token settings are required.");
  }
  const commands = commandDefinitions();
  const result = await discordApi(env,
    `/applications/${applicationId}/guilds/${env.DISCORD_GUILD_ID}/commands`, {
      method: "PUT",
      body: commands
    });
  return json({ registered: Array.isArray(result) ? result.length : commands.length,
    dashboard: await buildDiscordDashboard(env, context) });
}

async function syncAnnouncementsResponse(request, env) {
  const context = await requireBotAdministrator(request, env);
  if (!context) return apiError(403, "discord_admin_required", "Discord bot administrator access is required.");
  try {
    return json(await syncPluginAnnouncements(env, context.user.id));
  } catch (error) {
    console.error("Unable to synchronize Discord announcements", error);
    return apiError(502, "announcement_sync_failed", "Marketplace announcements could not be synchronized.");
  }
}

async function adminUsersResponse(request, env, url) {
  const context = await authenticatedContext(request, env);
  if (!context?.owner) return apiError(403, "site_owner_required", "Only the KLite site owner can manage reviewers.");
  const query = (url.searchParams.get("query") || "").trim().slice(0, 100);
  const pattern = `%${query.toLowerCase()}%`;
  const rows = await env.DB.prepare(
    `SELECT users.id, users.username, users.email,
       GROUP_CONCAT(user_roles.role) AS roles
     FROM users LEFT JOIN user_roles ON user_roles.user_id = users.id
     WHERE ? = '' OR lower(users.username) LIKE ? OR lower(users.email) LIKE ?
     GROUP BY users.id, users.username, users.email
     ORDER BY lower(users.username) LIMIT 100`
  ).bind(query, pattern, pattern).all();
  return json({ users: (rows.results || []).map((row) => ({
    id: row.id,
    username: row.username,
    email: row.email,
    owner: isSiteOwner(row, env),
    roles: row.roles ? row.roles.split(",").filter(Boolean) : []
  })) });
}

async function updateUserRolesResponse(request, env, userId) {
  const context = await authenticatedContext(request, env);
  if (!context?.owner) return apiError(403, "site_owner_required", "Only the KLite site owner can manage reviewers.");
  const target = await env.DB.prepare("SELECT id, username, email FROM users WHERE id = ?").bind(userId).first();
  if (!target) return apiError(404, "user_not_found", "Marketplace account not found.");
  const body = await readJson(request);
  const roles = normalizeRequestedRoles(body?.roles);
  if (!roles) return apiError(400, "invalid_roles", "Only Plugin Dev and Marketplace Reviewer roles can be managed here.");
  await env.DB.prepare("DELETE FROM user_roles WHERE user_id = ? AND role IN ('plugin_dev', 'marketplace_reviewer')")
    .bind(userId).run();
  for (const role of roles) {
    await env.DB.prepare(
      "INSERT INTO user_roles (user_id, role, granted_by, granted_at) VALUES (?, ?, ?, ?)"
    ).bind(userId, role, context.user.id, nowSeconds()).run();
  }
  return json({ user: { ...target, owner: isSiteOwner(target, env), roles } });
}

async function reviewQueueResponse(request, env) {
  const context = await authenticatedContext(request, env);
  if (!context || (!context.owner && !context.roles.includes("marketplace_reviewer"))) {
    return apiError(403, "reviewer_required", "Marketplace reviewer access is required.");
  }
  const rows = await env.DB.prepare(
    `SELECT plugin_submissions.id, plugin_id, name, version, source_url, description,
      status, review_notes, submitted_at, plugin_submissions.updated_at, reviewed_at,
      users.username AS submitter
     FROM plugin_submissions JOIN users ON users.id = plugin_submissions.user_id
     WHERE status IN ('pending', 'changes_requested')
     ORDER BY plugin_submissions.updated_at ASC LIMIT 100`
  ).all();
  return json({ submissions: (rows.results || []).map(submissionPayload) });
}

async function reviewDecisionResponse(request, env, submissionId) {
  const context = await authenticatedContext(request, env);
  if (!context || (!context.owner && !context.roles.includes("marketplace_reviewer"))) {
    return apiError(403, "reviewer_required", "Marketplace reviewer access is required.");
  }
  const body = await readJson(request);
  const decision = body?.decision;
  const notes = typeof body?.notes === "string" ? body.notes.trim() : "";
  if (!["approved", "rejected", "changes_requested"].includes(decision)
      || notes.length > 2000 || (decision !== "approved" && notes.length < 10)) {
    return apiError(400, "invalid_review",
      "Choose a valid decision and provide at least 10 characters of notes when not approving.");
  }
  const now = nowSeconds();
  const result = await env.DB.prepare(
    `UPDATE plugin_submissions
     SET status = ?, review_notes = ?, reviewed_by = ?, reviewed_at = ?, updated_at = ?
     WHERE id = ? AND status IN ('pending', 'changes_requested')`
  ).bind(decision, notes || null, context.user.id, now, now, submissionId).run();
  if (!result.meta?.changes) {
    return apiError(409, "submission_not_reviewable", "The submission was already reviewed or does not exist.");
  }
  return json({ ok: true, status: decision });
}

async function buildDiscordDashboard(env, context) {
  const applicationId = env.DISCORD_APPLICATION_ID || env.DISCORD_CLIENT_ID || null;
  const guildId = normalizeSnowflake(env.DISCORD_GUILD_ID);
  const missing = [];
  if (!applicationId) missing.push("DISCORD_APPLICATION_ID or DISCORD_CLIENT_ID");
  if (!guildId) missing.push("DISCORD_GUILD_ID");
  if (!env.DISCORD_BOT_TOKEN) missing.push("DISCORD_BOT_TOKEN");

  const inviteUrl = applicationId && guildId
    ? buildBotInviteUrl(applicationId, guildId, BOT_PERMISSIONS) : null;
  const bot = env.DISCORD_BOT_TOKEN
    ? await discordApiOptional(env, "/users/@me") : null;
  const guild = env.DISCORD_BOT_TOKEN && guildId
    ? await discordApiOptional(env, `/guilds/${guildId}?with_counts=true`) : null;
  const installed = Boolean(guild);
  const settings = await botSettings(env);
  const announcement = await env.DB.prepare(
    "SELECT channel_id, enabled, updated_at FROM discord_announcement_settings WHERE id = 1"
  ).first();

  let roles = [];
  let channels = [];
  let commands = [];
  let botMember = null;
  if (installed) {
    [roles, channels, commands, botMember] = await Promise.all([
      discordApi(env, `/guilds/${guildId}/roles`),
      discordApi(env, `/guilds/${guildId}/channels`),
      applicationId
        ? discordApi(env, `/applications/${applicationId}/guilds/${guildId}/commands`)
        : Promise.resolve([]),
      bot?.id ? discordApiOptional(env, `/guilds/${guildId}/members/${bot.id}`) : Promise.resolve(null)
    ]);
  }

  const history = await env.DB.prepare(
    `SELECT plugin_id, version, event_type, channel_id, message_id, announced_at
     FROM plugin_announcement_log ORDER BY announced_at DESC LIMIT 20`
  ).all();
  const linked = await count(env, "SELECT COUNT(*) AS total FROM discord_accounts");
  const sessions = await count(env, "SELECT COUNT(*) AS total FROM sessions WHERE expires_at > ?", nowSeconds());
  const announcements = await count(env, "SELECT COUNT(*) AS total FROM plugin_announcement_log");
  const devRoleId = settings?.dev_role_id
    || normalizeSnowflake(env.DISCORD_DEV_ROLE_ID)
    || roles.find((role) => role.name === "Dev")?.id
    || null;
  const devRole = roles.find((role) => role.id === devRoleId);

  return {
    access: {
      method: context.owner ? "site_owner" : "discord_role",
      discordUserId: context.user.discord_id || null,
      devRoleId,
      devRoleName: context.owner ? "KLite site owner" : (devRole?.name || "dashboard role")
    },
    install: {
      configured: missing.length === 0,
      missing,
      installed,
      inviteUrl,
      guildId,
      interactionEndpoint: `${new URL(env.PUBLIC_ORIGIN).origin}/api/discord/interactions`,
      passwordResetRedirect: `${new URL(env.PUBLIC_ORIGIN).origin}/api/auth/reset/callback`
    },
    bot: {
      id: bot?.id || applicationId || null,
      username: bot?.username || "KLite Discord bot",
      globalName: bot?.global_name || null,
      avatar: bot?.avatar || null,
      verified: Boolean(bot?.verified),
      guildRoleIds: botMember?.roles || [],
      joinedAt: botMember?.joined_at || null,
      pending: Boolean(botMember?.pending)
    },
    guild: {
      id: guild?.id || guildId,
      name: guild?.name || (guildId ? "Bot not installed" : "Server not configured"),
      icon: guild?.icon || null,
      ownerId: guild?.owner_id || null,
      memberCount: guild?.approximate_member_count || null,
      presenceCount: guild?.approximate_presence_count || null,
      description: guild?.description || null,
      verificationLevel: guild?.verification_level ?? null
    },
    settings: settingsPayload(settings, announcement, devRoleId),
    roles: roles.map(rolePayload).sort((left, right) => right.position - left.position),
    channels: channels.filter((channel) => TEXT_CHANNEL_TYPES.has(channel.type)).map((channel) => ({
      id: channel.id,
      name: channel.name,
      type: channel.type,
      position: channel.position,
      parentId: channel.parent_id || null,
      nsfw: Boolean(channel.nsfw)
    })).sort((left, right) => left.position - right.position),
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
    stats: { linkedAccounts: linked, activeSessions: sessions, announcementsSent: announcements }
  };
}

async function requireBotAdministrator(request, env) {
  const context = await authenticatedContext(request, env);
  if (!context) return null;
  if (context.owner) return context;
  if (!context.user.discord_id || !env.DISCORD_BOT_TOKEN || !env.DISCORD_GUILD_ID) return null;
  const [settings, roles, member] = await Promise.all([
    botSettings(env),
    discordApiOptional(env, `/guilds/${env.DISCORD_GUILD_ID}/roles`),
    discordApiOptional(env, `/guilds/${env.DISCORD_GUILD_ID}/members/${context.user.discord_id}`)
  ]);
  const devRoleId = settings?.dev_role_id
    || normalizeSnowflake(env.DISCORD_DEV_ROLE_ID)
    || roles?.find((role) => role.name === "Dev")?.id
    || null;
  return devRoleId && Array.isArray(member?.roles) && member.roles.includes(devRoleId)
    ? context : null;
}

async function authenticatedContext(request, env) {
  const token = sessionToken(request);
  if (!token) return null;
  const tokenHash = await sha256(token);
  const session = await env.DB.prepare(
    "SELECT user_id, kind, expires_at FROM sessions WHERE token_hash = ? AND expires_at > ?"
  ).bind(tokenHash, nowSeconds()).first();
  if (!session) return null;
  await env.DB.prepare("UPDATE sessions SET last_used_at = ? WHERE token_hash = ?")
    .bind(nowSeconds(), tokenHash).run();
  const user = await env.DB.prepare(
    `SELECT users.id, users.email, users.username,
      discord_accounts.discord_id, discord_accounts.username AS discord_username,
      discord_accounts.global_name, discord_accounts.avatar,
      discord_accounts.plugin_dev_role, discord_accounts.role_verified_at
     FROM users LEFT JOIN discord_accounts ON discord_accounts.user_id = users.id
     WHERE users.id = ?`
  ).bind(session.user_id).first();
  if (!user) return null;
  const roleRows = await env.DB.prepare("SELECT role FROM user_roles WHERE user_id = ? ORDER BY role")
    .bind(user.id).all();
  const roles = (roleRows.results || []).map((row) => row.role);
  return { session, user, roles, owner: isSiteOwner(user, env) };
}

function accountPayload(context) {
  const capabilities = [];
  const verifiedPluginDev = context.user.plugin_dev_role === 1
    && context.user.role_verified_at > nowSeconds() - 24 * 60 * 60;
  if (context.roles.includes("plugin_dev") && verifiedPluginDev) capabilities.push("plugin_dev");
  if (context.roles.includes("marketplace_reviewer") || context.owner) capabilities.push("marketplace_review");
  if (context.owner) capabilities.push("site_owner", "discord_bot_admin");
  return {
    id: context.user.id,
    email: context.user.email,
    username: context.user.username,
    discord: context.user.discord_id ? {
      id: context.user.discord_id,
      username: context.user.discord_username,
      globalName: context.user.global_name,
      avatar: context.user.avatar
    } : null,
    roles: context.roles,
    capabilities
  };
}

export function isSiteOwner(user, env = {}) {
  if (!user) return false;
  const configuredId = typeof env.SITE_OWNER_USER_ID === "string" ? env.SITE_OWNER_USER_ID.trim() : "";
  if (configuredId && user.id === configuredId) return true;
  const configuredUsername = typeof env.SITE_OWNER_USERNAME === "string" && env.SITE_OWNER_USERNAME.trim()
    ? env.SITE_OWNER_USERNAME.trim() : "KSP";
  return String(user.username || "").toLowerCase() === configuredUsername.toLowerCase();
}

export function buildBotInviteUrl(applicationId, guildId, permissions = BOT_PERMISSIONS) {
  if (!normalizeSnowflake(String(applicationId)) || !normalizeSnowflake(String(guildId))) return null;
  const url = new URL("https://discord.com/oauth2/authorize");
  url.searchParams.set("client_id", String(applicationId));
  url.searchParams.set("scope", "bot applications.commands");
  url.searchParams.set("permissions", String(permissions));
  url.searchParams.set("guild_id", String(guildId));
  url.searchParams.set("disable_guild_select", "true");
  url.searchParams.set("integration_type", "0");
  return url.toString();
}

export function normalizeRequestedRoles(input) {
  if (!Array.isArray(input)) return null;
  const unique = [...new Set(input)];
  return unique.every((role) => ALLOWED_MANAGED_ROLES.has(role)) ? unique.sort() : null;
}

function normalizeDiscordBotSettings(input) {
  if (!input || typeof input !== "object") return null;
  const devRoleId = normalizeSnowflake(input.devRoleId);
  if (!devRoleId || typeof input.botEnabled !== "boolean"
      || typeof input.autoAssignMemberRole !== "boolean"
      || typeof input.announcementsEnabled !== "boolean") return null;
  const result = {
    devRoleId,
    botEnabled: input.botEnabled,
    autoAssignMemberRole: input.autoAssignMemberRole,
    announcementsEnabled: input.announcementsEnabled
  };
  for (const key of ["pluginDevRoleId", "marketplaceReviewerRoleId", "memberRoleId",
    "announcementChannelId", "auditChannelId", "welcomeChannelId"]) {
    const normalized = normalizeOptionalSnowflake(input[key]);
    if (normalized === undefined) return null;
    result[key] = normalized;
  }
  return result;
}

function commandDefinitions() {
  return [
    {
      name: "link",
      description: "Link your Discord user to a KLite marketplace account",
      options: [{
        type: 3,
        name: "code",
        description: "One-time code generated on the KLite account page",
        required: true,
        min_length: 8,
        max_length: 8
      }]
    },
    { name: "account", description: "Show the KLite account linked to your Discord user" }
  ];
}

async function entitlements(env, userId) {
  const rows = await env.DB.prepare(
    `SELECT plugin_id, access_level, granted_at, expires_at
     FROM plugin_entitlements
     WHERE user_id = ? AND revoked_at IS NULL AND (expires_at IS NULL OR expires_at > ?)
     ORDER BY plugin_id`
  ).bind(userId, nowSeconds()).all();
  return (rows.results || []).map((row) => ({
    pluginId: row.plugin_id,
    accessLevel: row.access_level,
    grantedAt: row.granted_at,
    expiresAt: row.expires_at
  }));
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

function submissionPayload(row) {
  return {
    id: row.id,
    pluginId: row.plugin_id,
    name: row.name,
    version: row.version,
    sourceUrl: row.source_url,
    description: row.description,
    status: row.status,
    reviewNotes: row.review_notes,
    submitter: row.submitter,
    submittedAt: row.submitted_at,
    updatedAt: row.updated_at,
    reviewedAt: row.reviewed_at
  };
}

async function discordApiOptional(env, path) {
  try {
    return await discordApi(env, path);
  } catch (error) {
    const message = String(error?.message || error);
    if (message.includes("Discord API 403") || message.includes("Discord API 404")) return null;
    throw error;
  }
}

async function discordApi(env, path, options = {}) {
  if (!env.DISCORD_BOT_TOKEN) throw new Error("DISCORD_BOT_TOKEN is not configured");
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
    throw new Error(`Discord API ${response.status}: ${details.slice(0, 200)}`);
  }
  return response.status === 204 ? null : response.json();
}

async function count(env, query, value) {
  const statement = env.DB.prepare(query);
  const row = value === undefined ? await statement.first() : await statement.bind(value).first();
  return Number(row?.total || 0);
}

function sessionToken(request) {
  const authorization = request.headers.get("authorization");
  if (authorization?.startsWith("Bearer ")) return authorization.slice(7).trim();
  const cookie = request.headers.get("cookie") || "";
  const match = cookie.match(/(?:^|;\s*)klite_session=([^;]+)/);
  return match ? decodeURIComponent(match[1]) : null;
}

function normalizeSnowflake(value) {
  if (typeof value !== "string") return null;
  const normalized = value.trim();
  return /^\d{17,20}$/.test(normalized) ? normalized : null;
}

function normalizeOptionalSnowflake(value) {
  if (value === null || value === "" || value === undefined) return null;
  return normalizeSnowflake(value) || undefined;
}

async function readJson(request) {
  try {
    if (!request.headers.get("content-type")?.toLowerCase().startsWith("application/json")) return null;
    return JSON.parse(await request.text());
  } catch {
    return null;
  }
}

async function sha256(value) {
  const digest = await crypto.subtle.digest("SHA-256", encoder.encode(value));
  return Array.from(new Uint8Array(digest), (item) => item.toString(16).padStart(2, "0")).join("");
}

function nowSeconds() {
  return Math.floor(Date.now() / 1000);
}

function apiError(status, code, message) {
  return json({ error: { code, message } }, status);
}

function json(body, status = 200) {
  return new Response(JSON.stringify(body), {
    status,
    headers: {
      "content-type": "application/json; charset=utf-8",
      "cache-control": "no-store",
      "x-content-type-options": "nosniff"
    }
  });
}
