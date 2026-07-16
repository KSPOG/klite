const encoder = new TextEncoder();
const PASSWORD_ITERATIONS = 600_000;
const WEB_SESSION_SECONDS = 7 * 24 * 60 * 60;
const CLIENT_SESSION_SECONDS = 30 * 24 * 60 * 60;
const DISCORD_STATE_SECONDS = 10 * 60;
const LINK_CODE_SECONDS = 10 * 60;
const MAX_AUTH_ATTEMPTS = 10;
const AUTH_WINDOW_SECONDS = 15 * 60;

export default {
  async fetch(request, env) {
    try {
      const url = new URL(request.url);
      if (!url.pathname.startsWith("/api/")) {
        return env.ASSETS.fetch(request);
      }
      return await route(request, env, url);
    } catch (error) {
      console.error("Unhandled marketplace API error", error);
      return apiError(500, "internal_error", "The request could not be completed.");
    }
  }
};

async function route(request, env, url) {
  if (request.method === "POST" && url.pathname === "/api/auth/register") {
    return register(request, env);
  }
  if (request.method === "POST" && url.pathname === "/api/auth/login") {
    return login(request, env);
  }
  if (request.method === "POST" && url.pathname === "/api/auth/logout") {
    return logout(request, env);
  }
  if (request.method === "GET" && url.pathname === "/api/account") {
    return account(request, env);
  }
  if (request.method === "POST" && url.pathname === "/api/discord/link/start") {
    return discordLinkStart(request, env);
  }
  if (request.method === "GET" && url.pathname === "/api/discord/callback") {
    return discordCallback(url, env);
  }
  if (request.method === "POST" && url.pathname === "/api/discord/link-code") {
    return createDiscordLinkCode(request, env);
  }
  if (request.method === "POST" && url.pathname === "/api/discord/interactions") {
    return discordInteraction(request, env);
  }
  if (request.method === "GET" && url.pathname === "/api/client/entitlements") {
    return clientEntitlements(request, env);
  }
  if (url.pathname === "/api/developer/submissions" && request.method === "GET") {
    return developerSubmissions(request, env);
  }
  if (url.pathname === "/api/developer/submissions" && request.method === "POST") {
    return createPluginSubmission(request, env);
  }
  if (url.pathname === "/api/review/submissions" && request.method === "GET") {
    return reviewSubmissions(request, env);
  }
  const reviewMatch = url.pathname.match(/^\/api\/review\/submissions\/([a-f0-9-]+)\/decision$/);
  if (reviewMatch && request.method === "POST") {
    return reviewPluginSubmission(request, env, reviewMatch[1]);
  }
  return apiError(404, "not_found", "API endpoint not found.");
}

async function register(request, env) {
  const body = await readJson(request);
  if (!body) {
    return apiError(400, "invalid_json", "A JSON request body is required.");
  }
  const email = normalizeEmail(body.email);
  const username = normalizeUsername(body.username);
  const passwordError = validatePassword(body.password);
  if (!email || !username || passwordError) {
    return apiError(400, "invalid_registration", passwordError || "Enter a valid email and username.");
  }
  if (await rateLimited(env, request, email)) {
    return apiError(429, "rate_limited", "Too many account attempts. Try again later.");
  }

  const now = nowSeconds();
  const userId = crypto.randomUUID();
  const passwordHash = await hashPassword(body.password, env.PASSWORD_PEPPER);
  try {
    await env.DB.prepare(
      "INSERT INTO users (id, email, username, password_hash, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?)"
    ).bind(userId, email, username, passwordHash, now, now).run();
  } catch (error) {
    if (isConstraintError(error)) {
      return apiError(409, "account_exists", "That email or username is already registered.");
    }
    throw error;
  }

  const session = await createSession(env, userId, "web");
  return json({ account: { id: userId, email, username, discord: null }, entitlements: [] }, 201, {
    "set-cookie": webSessionCookie(session.token, session.maxAge)
  });
}

async function login(request, env) {
  const body = await readJson(request);
  if (!body || typeof body.password !== "string") {
    return apiError(400, "invalid_login", "Email and password are required.");
  }
  const email = normalizeEmail(body.email);
  if (!email) {
    return apiError(400, "invalid_login", "Email and password are required.");
  }
  if (await rateLimited(env, request, email)) {
    return apiError(429, "rate_limited", "Too many login attempts. Try again later.");
  }

  const user = await env.DB.prepare(
    "SELECT id, email, username, password_hash FROM users WHERE email = ?"
  ).bind(email).first();
  const valid = user
    ? await verifyPassword(body.password, user.password_hash, env.PASSWORD_PEPPER)
    : await consumePasswordCheck(body.password, env.PASSWORD_PEPPER);
  if (!valid) {
    return apiError(401, "invalid_credentials", "Email or password is incorrect.");
  }

  await clearRateLimit(env, request, email);

  const kind = body.client === true ? "client" : "web";
  const session = await createSession(env, user.id, kind);
  const payload = { account: await accountPayload(env, user.id), entitlements: await entitlements(env, user.id) };
  if (kind === "client") {
    payload.token = session.token;
    payload.expiresAt = session.expiresAt;
    return json(payload);
  }
  return json(payload, 200, { "set-cookie": webSessionCookie(session.token, session.maxAge) });
}

async function logout(request, env) {
  const token = sessionToken(request);
  if (token) {
    await env.DB.prepare("DELETE FROM sessions WHERE token_hash = ?")
      .bind(await sha256(token)).run();
  }
  return json({ ok: true }, 200, {
    "set-cookie": "klite_session=; Path=/; HttpOnly; Secure; SameSite=Strict; Max-Age=0"
  });
}

async function account(request, env) {
  const session = await requireSession(request, env);
  if (!session) {
    return apiError(401, "authentication_required", "Sign in to continue.");
  }
  return json({
    account: await accountPayload(env, session.user_id),
    entitlements: await entitlements(env, session.user_id)
  });
}

async function discordLinkStart(request, env) {
  const session = await requireSession(request, env);
  if (!session) {
    return apiError(401, "authentication_required", "Sign in to link Discord.");
  }
  const state = randomToken(32);
  const expiresAt = nowSeconds() + DISCORD_STATE_SECONDS;
  await env.DB.prepare(
    "INSERT INTO discord_oauth_states (state_hash, user_id, expires_at) VALUES (?, ?, ?)"
  ).bind(await sha256(state), session.user_id, expiresAt).run();

  const authorize = new URL("https://discord.com/oauth2/authorize");
  authorize.searchParams.set("client_id", env.DISCORD_CLIENT_ID);
  authorize.searchParams.set("redirect_uri", `${env.PUBLIC_ORIGIN}/api/discord/callback`);
  authorize.searchParams.set("response_type", "code");
  authorize.searchParams.set("scope", "identify guilds.members.read");
  authorize.searchParams.set("state", state);
  authorize.searchParams.set("prompt", "consent");
  return json({ authorizeUrl: authorize.toString(), expiresAt });
}

async function discordCallback(url, env) {
  const code = url.searchParams.get("code");
  const state = url.searchParams.get("state");
  if (!code || !state) {
    return redirectAccount(env, "discord_error");
  }
  const stateHash = await sha256(state);
  const linkState = await env.DB.prepare(
    "SELECT user_id FROM discord_oauth_states WHERE state_hash = ? AND expires_at > ?"
  ).bind(stateHash, nowSeconds()).first();
  if (!linkState) {
    return redirectAccount(env, "discord_state_expired");
  }
  await env.DB.prepare("DELETE FROM discord_oauth_states WHERE state_hash = ?").bind(stateHash).run();

  const tokenResponse = await fetch("https://discord.com/api/v10/oauth2/token", {
    method: "POST",
    headers: { "content-type": "application/x-www-form-urlencoded" },
    body: new URLSearchParams({
      client_id: env.DISCORD_CLIENT_ID,
      client_secret: env.DISCORD_CLIENT_SECRET,
      grant_type: "authorization_code",
      code,
      redirect_uri: `${env.PUBLIC_ORIGIN}/api/discord/callback`
    })
  });
  if (!tokenResponse.ok) {
    return redirectAccount(env, "discord_exchange_failed");
  }
  const oauth = await tokenResponse.json();
  const userResponse = await fetch("https://discord.com/api/v10/users/@me", {
    headers: { authorization: `Bearer ${oauth.access_token}` }
  });
  if (!userResponse.ok) {
    return redirectAccount(env, "discord_profile_failed");
  }
  const discord = await userResponse.json();
  const memberResponse = await fetch(
    `https://discord.com/api/v10/users/@me/guilds/${env.DISCORD_GUILD_ID}/member`,
    { headers: { authorization: `Bearer ${oauth.access_token}` } }
  );
  const member = memberResponse.ok ? await memberResponse.json() : null;
  const hasPluginDevRole = Array.isArray(member?.roles)
    && member.roles.includes(env.DISCORD_PLUGIN_DEV_ROLE_ID);
  const linked = await linkDiscordAccount(env, linkState.user_id, discord,
    hasPluginDevRole, Boolean(member));
  return redirectAccount(env, linked ? "discord_linked" : "discord_already_linked");
}

async function createDiscordLinkCode(request, env) {
  const session = await requireSession(request, env);
  if (!session) {
    return apiError(401, "authentication_required", "Sign in to create a link code.");
  }
  const code = randomCode(8);
  const expiresAt = nowSeconds() + LINK_CODE_SECONDS;
  await env.DB.prepare("DELETE FROM discord_link_codes WHERE user_id = ? OR expires_at <= ?")
    .bind(session.user_id, nowSeconds()).run();
  await env.DB.prepare(
    "INSERT INTO discord_link_codes (code_hash, user_id, expires_at) VALUES (?, ?, ?)"
  ).bind(await sha256(code), session.user_id, expiresAt).run();
  return json({ code, expiresAt });
}

async function discordInteraction(request, env) {
  const rawBody = await request.text();
  if (!await verifyDiscordRequest(request, rawBody, env.DISCORD_PUBLIC_KEY)) {
    return apiError(401, "invalid_signature", "Invalid Discord signature.");
  }
  const interaction = JSON.parse(rawBody);
  if (interaction.type === 1) {
    return json({ type: 1 });
  }
  if (interaction.type !== 2) {
    return discordMessage("Unsupported interaction.");
  }
  const discordUser = interaction.member?.user || interaction.user;
  if (!discordUser?.id) {
    return discordMessage("Discord user information was not provided.");
  }
  if (interaction.data?.name === "link") {
    const code = interaction.data.options?.find((option) => option.name === "code")?.value;
    return discordLinkCommand(env, discordUser, code,
      interaction.guild_id, interaction.member?.roles);
  }
  if (interaction.data?.name === "account") {
    return discordAccountCommand(env, discordUser.id,
      interaction.guild_id, interaction.member?.roles);
  }
  return discordMessage("Unknown command.");
}

async function discordLinkCommand(env, discordUser, code, guildId, memberRoles) {
  if (typeof code !== "string" || !/^[A-Z0-9]{8}$/.test(code.toUpperCase())) {
    return discordMessage("Generate a fresh link code on the KLite account page, then run `/link code:`.");
  }
  const codeHash = await sha256(code.toUpperCase());
  const pending = await env.DB.prepare(
    "SELECT user_id FROM discord_link_codes WHERE code_hash = ? AND expires_at > ? AND consumed_at IS NULL"
  ).bind(codeHash, nowSeconds()).first();
  if (!pending) {
    return discordMessage("That link code is invalid or expired.");
  }
  const consumed = await env.DB.prepare(
    "UPDATE discord_link_codes SET consumed_at = ? WHERE code_hash = ? AND consumed_at IS NULL"
  ).bind(nowSeconds(), codeHash).run();
  if (!consumed.meta?.changes) {
    return discordMessage("That link code has already been used.");
  }
  const roleVerified = guildId === env.DISCORD_GUILD_ID && Array.isArray(memberRoles);
  const linked = await linkDiscordAccount(env, pending.user_id, discordUser,
    roleVerified && memberRoles.includes(env.DISCORD_PLUGIN_DEV_ROLE_ID), roleVerified);
  if (!linked) {
    return discordMessage("That Discord user is already linked to another KLite account.");
  }
  return discordMessage("Discord is now linked to your KLite account.");
}

async function discordAccountCommand(env, discordId, guildId, memberRoles) {
  const roleVerified = guildId === env.DISCORD_GUILD_ID && Array.isArray(memberRoles);
  if (roleVerified) {
    await env.DB.prepare(
      "UPDATE discord_accounts SET plugin_dev_role = ?, role_verified_at = ? WHERE discord_id = ?"
    ).bind(memberRoles.includes(env.DISCORD_PLUGIN_DEV_ROLE_ID) ? 1 : 0,
      nowSeconds(), discordId).run();
  }
  const account = await env.DB.prepare(
    "SELECT users.username FROM discord_accounts JOIN users ON users.id = discord_accounts.user_id WHERE discord_accounts.discord_id = ?"
  ).bind(discordId).first();
  return discordMessage(account
    ? `Linked KLite account: **${escapeDiscord(account.username)}**`
    : "No KLite account is linked. Sign in on the marketplace and create a Discord link code.");
}

async function clientEntitlements(request, env) {
  const session = await requireSession(request, env, "client");
  if (!session) {
    return apiError(401, "client_authentication_required", "Sign in from the KLite client.");
  }
  return json({
    account: await accountPayload(env, session.user_id),
    entitlements: await entitlements(env, session.user_id)
  });
}

async function accountPayload(env, userId) {
  const row = await env.DB.prepare(
    `SELECT users.id, users.email, users.username,
      discord_accounts.discord_id, discord_accounts.username AS discord_username,
      discord_accounts.global_name, discord_accounts.avatar,
      discord_accounts.plugin_dev_role, discord_accounts.role_verified_at
     FROM users LEFT JOIN discord_accounts ON discord_accounts.user_id = users.id
     WHERE users.id = ?`
  ).bind(userId).first();
  if (!row) {
    return null;
  }
  const roleRows = await env.DB.prepare(
    "SELECT role FROM user_roles WHERE user_id = ? ORDER BY role"
  ).bind(userId).all();
  const roles = (roleRows.results || []).map((item) => item.role);
  const discordPluginDev = row.plugin_dev_role === 1
    && row.role_verified_at > nowSeconds() - 24 * 60 * 60;
  const capabilities = [];
  if (roles.includes("plugin_dev") && discordPluginDev) {
    capabilities.push("plugin_dev");
  }
  if (roles.includes("marketplace_reviewer")) {
    capabilities.push("marketplace_review");
  }
  return {
    id: row.id,
    email: row.email,
    username: row.username,
    discord: row.discord_id ? {
      id: row.discord_id,
      username: row.discord_username,
      globalName: row.global_name,
      avatar: row.avatar
    } : null,
    roles,
    capabilities
  };
}

async function entitlements(env, userId) {
  const now = nowSeconds();
  const result = await env.DB.prepare(
    `SELECT plugin_id, access_level, granted_at, expires_at
     FROM plugin_entitlements
     WHERE user_id = ? AND revoked_at IS NULL AND (expires_at IS NULL OR expires_at > ?)
     ORDER BY plugin_id`
  ).bind(userId, now).all();
  return (result.results || []).map((row) => ({
    pluginId: row.plugin_id,
    accessLevel: row.access_level,
    grantedAt: row.granted_at,
    expiresAt: row.expires_at
  }));
}

async function linkDiscordAccount(env, userId, discord, pluginDevRole = false, roleVerified = false) {
  const existing = await env.DB.prepare(
    "SELECT user_id FROM discord_accounts WHERE discord_id = ?"
  ).bind(discord.id).first();
  if (existing && existing.user_id !== userId) {
    return false;
  }
  await env.DB.prepare(
    `INSERT INTO discord_accounts
       (user_id, discord_id, username, global_name, avatar, linked_at, plugin_dev_role, role_verified_at)
     VALUES (?, ?, ?, ?, ?, ?, ?, ?)
     ON CONFLICT(user_id) DO UPDATE SET discord_id = excluded.discord_id,
       username = excluded.username, global_name = excluded.global_name,
       avatar = excluded.avatar, linked_at = excluded.linked_at,
       plugin_dev_role = excluded.plugin_dev_role,
       role_verified_at = excluded.role_verified_at`
  ).bind(userId, discord.id, discord.username, discord.global_name || null,
    discord.avatar || null, nowSeconds(), pluginDevRole ? 1 : 0,
    roleVerified ? nowSeconds() : null).run();
  return true;
}

async function developerSubmissions(request, env) {
  const session = await requireCapability(request, env, "plugin_dev");
  if (!session) {
    return apiError(403, "plugin_developer_required",
      "A verified website and Discord Plugin Dev role is required.");
  }
  const result = await env.DB.prepare(
    `SELECT id, plugin_id, name, version, source_url, description, status,
      review_notes, submitted_at, updated_at, reviewed_at
     FROM plugin_submissions WHERE user_id = ? ORDER BY updated_at DESC`
  ).bind(session.user_id).all();
  return json({ submissions: (result.results || []).map(submissionPayload) });
}

async function createPluginSubmission(request, env) {
  const session = await requireCapability(request, env, "plugin_dev");
  if (!session) {
    return apiError(403, "plugin_developer_required",
      "A verified website and Discord Plugin Dev role is required.");
  }
  const body = await readJson(request);
  const pluginId = normalizePluginId(body?.pluginId);
  const name = normalizeText(body?.name, 3, 80);
  const version = normalizeVersion(body?.version);
  const sourceUrl = normalizeSourceUrl(body?.sourceUrl);
  const description = normalizeText(body?.description, 30, 2000);
  if (!pluginId || !name || !version || !sourceUrl || !description) {
    return apiError(400, "invalid_submission",
      "Enter a valid plugin ID, name, semantic version, HTTPS source URL, and description.");
  }
  const now = nowSeconds();
  const id = crypto.randomUUID();
  try {
    await env.DB.prepare(
      `INSERT INTO plugin_submissions
        (id, user_id, plugin_id, name, version, source_url, description, submitted_at, updated_at)
       VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)`
    ).bind(id, session.user_id, pluginId, name, version, sourceUrl,
      description, now, now).run();
  } catch (error) {
    if (isConstraintError(error)) {
      return apiError(409, "submission_exists",
        "This plugin version has already been submitted.");
    }
    throw error;
  }
  const row = await env.DB.prepare(
    `SELECT id, plugin_id, name, version, source_url, description, status,
      review_notes, submitted_at, updated_at, reviewed_at
     FROM plugin_submissions WHERE id = ?`
  ).bind(id).first();
  return json({ submission: submissionPayload(row) }, 201);
}

async function reviewSubmissions(request, env) {
  const session = await requireWebsiteRole(request, env, "marketplace_reviewer");
  if (!session) {
    return apiError(403, "reviewer_required", "Marketplace reviewer access is required.");
  }
  const result = await env.DB.prepare(
    `SELECT plugin_submissions.id, plugin_id, name, version, source_url, description,
      status, review_notes, submitted_at, plugin_submissions.updated_at, reviewed_at,
      users.username AS submitter
     FROM plugin_submissions JOIN users ON users.id = plugin_submissions.user_id
     WHERE status IN ('pending', 'changes_requested')
     ORDER BY plugin_submissions.updated_at ASC LIMIT 100`
  ).all();
  return json({ submissions: (result.results || []).map(submissionPayload) });
}

async function reviewPluginSubmission(request, env, submissionId) {
  const session = await requireWebsiteRole(request, env, "marketplace_reviewer");
  if (!session) {
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
  const result = await env.DB.prepare(
    `UPDATE plugin_submissions
     SET status = ?, review_notes = ?, reviewed_by = ?, reviewed_at = ?, updated_at = ?
     WHERE id = ? AND status IN ('pending', 'changes_requested')`
  ).bind(decision, notes || null, session.user_id, nowSeconds(), nowSeconds(), submissionId).run();
  if (!result.meta?.changes) {
    return apiError(409, "submission_not_reviewable",
      "The submission was already reviewed or does not exist.");
  }
  return json({ ok: true, status: decision });
}

async function requireCapability(request, env, capability) {
  const session = await requireSession(request, env);
  if (!session) {
    return null;
  }
  const account = await accountPayload(env, session.user_id);
  return account?.capabilities.includes(capability) ? session : null;
}

async function requireWebsiteRole(request, env, role) {
  const session = await requireSession(request, env);
  if (!session) {
    return null;
  }
  const match = await env.DB.prepare(
    "SELECT 1 AS allowed FROM user_roles WHERE user_id = ? AND role = ?"
  ).bind(session.user_id, role).first();
  return match?.allowed ? session : null;
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

export function normalizePluginId(value) {
  if (typeof value !== "string") {
    return null;
  }
  const pluginId = value.trim().toLowerCase();
  return /^[a-z0-9][a-z0-9-]{2,63}$/.test(pluginId) ? pluginId : null;
}

export function normalizeVersion(value) {
  if (typeof value !== "string") {
    return null;
  }
  const version = value.trim();
  return /^(0|[1-9]\d*)\.(0|[1-9]\d*)\.(0|[1-9]\d*)(?:[-+][0-9A-Za-z.-]+)?$/.test(version)
    && version.length <= 64 ? version : null;
}

export function normalizeSourceUrl(value) {
  if (typeof value !== "string" || value.length > 500) {
    return null;
  }
  try {
    const url = new URL(value);
    return url.protocol === "https:" && !url.username && !url.password
      ? url.toString() : null;
  } catch {
    return null;
  }
}

function normalizeText(value, minimum, maximum) {
  if (typeof value !== "string") {
    return null;
  }
  const text = value.trim();
  return text.length >= minimum && text.length <= maximum ? text : null;
}

async function requireSession(request, env, requiredKind = null) {
  const token = sessionToken(request);
  if (!token) {
    return null;
  }
  const tokenHash = await sha256(token);
  const session = await env.DB.prepare(
    "SELECT user_id, kind, expires_at FROM sessions WHERE token_hash = ? AND expires_at > ?"
  ).bind(tokenHash, nowSeconds()).first();
  if (!session || (requiredKind && session.kind !== requiredKind)) {
    return null;
  }
  await env.DB.prepare("UPDATE sessions SET last_used_at = ? WHERE token_hash = ?")
    .bind(nowSeconds(), tokenHash).run();
  return session;
}

async function createSession(env, userId, kind) {
  const token = randomToken(32);
  const now = nowSeconds();
  const maxAge = kind === "client" ? CLIENT_SESSION_SECONDS : WEB_SESSION_SECONDS;
  const expiresAt = now + maxAge;
  await env.DB.prepare(
    "INSERT INTO sessions (token_hash, user_id, kind, created_at, expires_at, last_used_at) VALUES (?, ?, ?, ?, ?, ?)"
  ).bind(await sha256(token), userId, kind, now, expiresAt, now).run();
  return { token, expiresAt, maxAge };
}

async function rateLimited(env, request, identity) {
  const cutoff = nowSeconds() - AUTH_WINDOW_SECONDS;
  const ip = request.headers.get("cf-connecting-ip") || "unknown";
  const identityHash = await sha256(`${ip}\0${identity}`);
  await env.DB.prepare("DELETE FROM auth_attempts WHERE attempted_at <= ?").bind(cutoff).run();
  const count = await env.DB.prepare(
    "SELECT COUNT(*) AS total FROM auth_attempts WHERE identity_hash = ? AND attempted_at > ?"
  ).bind(identityHash, cutoff).first();
  if ((count?.total || 0) >= MAX_AUTH_ATTEMPTS) {
    return true;
  }
  await env.DB.prepare("INSERT INTO auth_attempts (identity_hash, attempted_at) VALUES (?, ?)")
    .bind(identityHash, nowSeconds()).run();
  return false;
}

async function clearRateLimit(env, request, identity) {
  const ip = request.headers.get("cf-connecting-ip") || "unknown";
  const identityHash = await sha256(`${ip}\0${identity}`);
  await env.DB.prepare("DELETE FROM auth_attempts WHERE identity_hash = ?")
    .bind(identityHash).run();
}

async function consumePasswordCheck(password, pepper) {
  await hashPassword(password, pepper, "AAAAAAAAAAAAAAAAAAAAAA");
  return false;
}

export async function hashPassword(password, pepper, salt = randomToken(16)) {
  if (!pepper) {
    throw new Error("PASSWORD_PEPPER is not configured");
  }
  const key = await crypto.subtle.importKey(
    "raw", encoder.encode(`${password}\0${pepper}`), "PBKDF2", false, ["deriveBits"]
  );
  const bits = await crypto.subtle.deriveBits(
    { name: "PBKDF2", hash: "SHA-256", salt: fromBase64Url(salt), iterations: PASSWORD_ITERATIONS },
    key,
    256
  );
  return `pbkdf2-sha256$${PASSWORD_ITERATIONS}$${salt}$${toBase64Url(new Uint8Array(bits))}`;
}

export async function verifyPassword(password, encoded, pepper) {
  const parts = typeof encoded === "string" ? encoded.split("$") : [];
  if (parts.length !== 4 || parts[0] !== "pbkdf2-sha256" || Number(parts[1]) !== PASSWORD_ITERATIONS) {
    return false;
  }
  const candidate = await hashPassword(password, pepper, parts[2]);
  return constantTimeEqual(encoder.encode(candidate), encoder.encode(encoded));
}

export function normalizeEmail(value) {
  if (typeof value !== "string") {
    return null;
  }
  const email = value.trim().toLowerCase();
  return email.length <= 254 && /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email) ? email : null;
}

export function normalizeUsername(value) {
  if (typeof value !== "string") {
    return null;
  }
  const username = value.trim();
  return /^[A-Za-z0-9_-]{3,24}$/.test(username) ? username : null;
}

export function validatePassword(value) {
  if (typeof value !== "string" || value.length < 12) {
    return "Use a password with at least 12 characters.";
  }
  if (value.length > 128) {
    return "Password cannot exceed 128 characters.";
  }
  return null;
}

export async function verifyDiscordRequest(request, rawBody, publicKeyHex) {
  const signatureHex = request.headers.get("x-signature-ed25519");
  const timestamp = request.headers.get("x-signature-timestamp");
  if (!signatureHex || !timestamp || !publicKeyHex || !/^\d+$/.test(timestamp)) {
    return false;
  }
  if (Math.abs(nowSeconds() - Number(timestamp)) > 5 * 60) {
    return false;
  }
  try {
    const key = await crypto.subtle.importKey(
      "raw", fromHex(publicKeyHex), { name: "Ed25519" }, false, ["verify"]
    );
    return crypto.subtle.verify(
      { name: "Ed25519" }, key, fromHex(signatureHex), encoder.encode(timestamp + rawBody)
    );
  } catch {
    return false;
  }
}

async function readJson(request) {
  if (!request.headers.get("content-type")?.toLowerCase().startsWith("application/json")) {
    return null;
  }
  const declaredLength = Number(request.headers.get("content-length") || 0);
  if (declaredLength > 16_384) {
    return null;
  }
  try {
    const rawBody = await request.text();
    if (encoder.encode(rawBody).byteLength > 16_384) {
      return null;
    }
    return JSON.parse(rawBody);
  } catch {
    return null;
  }
}

function sessionToken(request) {
  const authorization = request.headers.get("authorization");
  if (authorization?.startsWith("Bearer ")) {
    return authorization.slice(7).trim();
  }
  const cookie = request.headers.get("cookie") || "";
  const match = cookie.match(/(?:^|;\s*)klite_session=([^;]+)/);
  return match ? decodeURIComponent(match[1]) : null;
}

function webSessionCookie(token, maxAge) {
  return `klite_session=${encodeURIComponent(token)}; Path=/; HttpOnly; Secure; SameSite=Strict; Max-Age=${maxAge}`;
}

function redirectAccount(env, status) {
  const location = new URL("/", env.PUBLIC_ORIGIN);
  location.searchParams.set("account", status);
  location.hash = "account";
  return new Response(null, { status: 302, headers: { location: location.toString(), "cache-control": "no-store" } });
}

function discordMessage(content) {
  return json({ type: 4, data: { content, flags: 64, allowed_mentions: { parse: [] } } });
}

function escapeDiscord(value) {
  return String(value).replace(/([\\*_~`|>])/g, "\\$1");
}

function apiError(status, code, message) {
  return json({ error: { code, message } }, status);
}

function json(body, status = 200, headers = {}) {
  return new Response(JSON.stringify(body), {
    status,
    headers: {
      "content-type": "application/json; charset=utf-8",
      "cache-control": "no-store",
      "x-content-type-options": "nosniff",
      ...headers
    }
  });
}

function nowSeconds() {
  return Math.floor(Date.now() / 1000);
}

function randomToken(byteLength) {
  const bytes = new Uint8Array(byteLength);
  crypto.getRandomValues(bytes);
  return toBase64Url(bytes);
}

function randomCode(length) {
  const alphabet = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";
  const bytes = new Uint8Array(length);
  crypto.getRandomValues(bytes);
  return Array.from(bytes, (value) => alphabet[value % alphabet.length]).join("");
}

async function sha256(value) {
  const digest = await crypto.subtle.digest("SHA-256", encoder.encode(value));
  return toHex(new Uint8Array(digest));
}

function toHex(bytes) {
  return Array.from(bytes, (value) => value.toString(16).padStart(2, "0")).join("");
}

function fromHex(value) {
  if (!/^[0-9a-f]+$/i.test(value) || value.length % 2 !== 0) {
    throw new Error("Invalid hexadecimal value");
  }
  return Uint8Array.from(value.match(/.{2}/g), (byte) => Number.parseInt(byte, 16));
}

function toBase64Url(bytes) {
  let binary = "";
  for (const value of bytes) {
    binary += String.fromCharCode(value);
  }
  return btoa(binary).replace(/\+/g, "-").replace(/\//g, "_").replace(/=+$/, "");
}

function fromBase64Url(value) {
  const base64 = value.replace(/-/g, "+").replace(/_/g, "/").padEnd(Math.ceil(value.length / 4) * 4, "=");
  return Uint8Array.from(atob(base64), (character) => character.charCodeAt(0));
}

function constantTimeEqual(left, right) {
  if (left.length !== right.length) {
    return false;
  }
  let different = 0;
  for (let index = 0; index < left.length; index += 1) {
    different |= left[index] ^ right[index];
  }
  return different === 0;
}

function isConstraintError(error) {
  return String(error?.message || error).toLowerCase().includes("constraint");
}
