import {
  notifyDiscordAccountLinked,
  pluginDeveloperRoleId
} from "./discord-dashboard.js";

const encoder = new TextEncoder();
const DISCORD_STATE_SECONDS = 10 * 60;
const CLIENT_CODE_SECONDS = 2 * 60;
const WEB_SESSION_SECONDS = 7 * 24 * 60 * 60;
const CLIENT_SESSION_SECONDS = 30 * 24 * 60 * 60;
const MAX_JSON_BYTES = 16_384;
let schemaReady = null;

export async function startDiscordLogin(request, env) {
  await ensureDiscordLoginSchema(env);
  const body = await readOptionalJson(request);
  if (body === null) {
    return apiError(400, "invalid_json", "A valid JSON request body is required.");
  }

  const client = body.client === true;
  const redirectUri = client ? normalizeLoopbackRedirect(body.redirectUri) : null;
  const codeChallenge = client ? normalizeCodeChallenge(body.codeChallenge) : null;
  if (client && (!redirectUri || !codeChallenge)) {
    return apiError(400, "invalid_client_login",
      "The client redirect URI and PKCE challenge are invalid.");
  }

  await cleanupExpiredDiscordLogins(env);
  const state = randomToken(32);
  const expiresAt = nowSeconds() + DISCORD_STATE_SECONDS;
  await env.DB.prepare(
    `INSERT INTO discord_login_states
      (state_hash, flow, client_redirect_uri, code_challenge, expires_at)
     VALUES (?, ?, ?, ?, ?)`
  ).bind(await sha256Hex(state), client ? "client" : "web",
    redirectUri, codeChallenge, expiresAt).run();

  const authorize = new URL("https://discord.com/oauth2/authorize");
  authorize.searchParams.set("client_id", env.DISCORD_CLIENT_ID);
  authorize.searchParams.set("redirect_uri", `${env.PUBLIC_ORIGIN}/api/discord/callback`);
  authorize.searchParams.set("response_type", "code");
  authorize.searchParams.set("scope", "identify email guilds.members.read");
  authorize.searchParams.set("state", state);

  return json({
    authorizeUrl: authorize.toString(),
    state,
    expiresAt
  });
}

export async function handleDiscordLoginCallback(url, env) {
  await ensureDiscordLoginSchema(env);
  const state = url.searchParams.get("state");
  if (!state) {
    return null;
  }

  const stateHash = await sha256Hex(state);
  const loginState = await env.DB.prepare(
    `SELECT flow, client_redirect_uri, code_challenge, expires_at
     FROM discord_login_states
     WHERE state_hash = ? AND expires_at > ?`
  ).bind(stateHash, nowSeconds()).first();
  if (!loginState) {
    return null;
  }

  const oauthError = url.searchParams.get("error");
  const code = url.searchParams.get("code");
  if (oauthError || !code) {
    await deleteDiscordLoginState(env, stateHash);
    return loginFailure(env, loginState, state,
      oauthError === "access_denied" ? "discord_cancelled" : "discord_authorization_failed");
  }

  try {
    const discord = await exchangeDiscordCode(env, code);
    const membership = await fetchDiscordMembership(env, discord.accessToken);
    const userId = await resolveDiscordUser(env, discord.profile, membership);
    if (!userId) {
      await deleteDiscordLoginState(env, stateHash);
      return loginFailure(env, loginState, state, "discord_verified_email_required");
    }

    if (loginState.flow === "client") {
      const oneTimeCode = randomToken(32);
      const expiresAt = Math.min(loginState.expires_at, nowSeconds() + CLIENT_CODE_SECONDS);
      await env.DB.prepare(
        `INSERT INTO discord_client_login_codes
          (code_hash, state_hash, user_id, expires_at)
         VALUES (?, ?, ?, ?)`
      ).bind(await sha256Hex(oneTimeCode), stateHash, userId, expiresAt).run();
      return redirectLoopback(loginState.client_redirect_uri, {
        code: oneTimeCode,
        state
      });
    }

    await deleteDiscordLoginState(env, stateHash);
    const session = await createSession(env, userId, "web");
    const location = new URL("/", env.PUBLIC_ORIGIN);
    location.hash = "account";
    return new Response(null, {
      status: 302,
      headers: {
        location: location.toString(),
        "cache-control": "no-store",
        "set-cookie": webSessionCookie(session.token, session.maxAge)
      }
    });
  } catch (error) {
    console.error("Discord login failed", error);
    await deleteDiscordLoginState(env, stateHash);
    return loginFailure(env, loginState, state, "discord_login_failed");
  }
}

export async function exchangeDiscordClientLogin(request, env) {
  await ensureDiscordLoginSchema(env);
  const body = await readOptionalJson(request);
  if (!body || typeof body.code !== "string"
      || typeof body.state !== "string" || typeof body.codeVerifier !== "string") {
    return apiError(400, "invalid_exchange", "The Discord login exchange is invalid.");
  }

  const codeHash = await sha256Hex(body.code);
  const stateHash = await sha256Hex(body.state);
  const pending = await env.DB.prepare(
    `SELECT discord_client_login_codes.user_id,
       discord_client_login_codes.expires_at,
       discord_client_login_codes.consumed_at,
       discord_login_states.code_challenge
     FROM discord_client_login_codes
     JOIN discord_login_states
       ON discord_login_states.state_hash = discord_client_login_codes.state_hash
     WHERE discord_client_login_codes.code_hash = ?
       AND discord_client_login_codes.state_hash = ?
       AND discord_login_states.flow = 'client'`
  ).bind(codeHash, stateHash).first();

  const verifierChallenge = await sha256Base64Url(body.codeVerifier);
  if (!pending || pending.consumed_at || pending.expires_at <= nowSeconds()
      || pending.code_challenge !== verifierChallenge) {
    return apiError(401, "invalid_exchange", "The Discord login code is invalid or expired.");
  }

  const consumed = await env.DB.prepare(
    `UPDATE discord_client_login_codes
     SET consumed_at = ?
     WHERE code_hash = ? AND state_hash = ? AND consumed_at IS NULL AND expires_at > ?`
  ).bind(nowSeconds(), codeHash, stateHash, nowSeconds()).run();
  if (!consumed.meta?.changes) {
    return apiError(401, "invalid_exchange", "The Discord login code has already been used.");
  }

  const session = await createSession(env, pending.user_id, "client");
  const payload = {
    account: await accountPayload(env, pending.user_id),
    entitlements: await entitlements(env, pending.user_id),
    token: session.token,
    expiresAt: session.expiresAt
  };
  await deleteDiscordLoginState(env, stateHash);
  return json(payload);
}

async function ensureDiscordLoginSchema(env) {
  if (!schemaReady) {
    schemaReady = (async () => {
      await env.DB.prepare(
        `CREATE TABLE IF NOT EXISTS discord_login_states (
          state_hash TEXT PRIMARY KEY,
          flow TEXT NOT NULL CHECK (flow IN ('web', 'client')),
          client_redirect_uri TEXT,
          code_challenge TEXT,
          expires_at INTEGER NOT NULL
        )`
      ).run();
      await env.DB.prepare(
        `CREATE INDEX IF NOT EXISTS discord_login_states_expires_at_idx
         ON discord_login_states(expires_at)`
      ).run();
      await env.DB.prepare(
        `CREATE TABLE IF NOT EXISTS discord_client_login_codes (
          code_hash TEXT PRIMARY KEY,
          state_hash TEXT NOT NULL
            REFERENCES discord_login_states(state_hash) ON DELETE CASCADE,
          user_id TEXT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
          expires_at INTEGER NOT NULL,
          consumed_at INTEGER
        )`
      ).run();
      await env.DB.prepare(
        `CREATE INDEX IF NOT EXISTS discord_client_login_codes_state_idx
         ON discord_client_login_codes(state_hash)`
      ).run();
      await env.DB.prepare(
        `CREATE INDEX IF NOT EXISTS discord_client_login_codes_expires_at_idx
         ON discord_client_login_codes(expires_at)`
      ).run();
    })().catch((error) => {
      schemaReady = null;
      throw error;
    });
  }
  return schemaReady;
}

async function exchangeDiscordCode(env, code) {
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
    throw new Error(`Discord token exchange returned HTTP ${tokenResponse.status}`);
  }

  const oauth = await tokenResponse.json();
  const profileResponse = await fetch("https://discord.com/api/v10/users/@me", {
    headers: { authorization: `Bearer ${oauth.access_token}` }
  });
  if (!profileResponse.ok) {
    throw new Error(`Discord profile request returned HTTP ${profileResponse.status}`);
  }
  return {
    accessToken: oauth.access_token,
    profile: await profileResponse.json()
  };
}

async function fetchDiscordMembership(env, accessToken) {
  const response = await fetch(
    `https://discord.com/api/v10/users/@me/guilds/${env.DISCORD_GUILD_ID}/member`,
    { headers: { authorization: `Bearer ${accessToken}` } }
  );
  if (!response.ok) {
    return { member: null, verified: false, pluginDev: false };
  }
  const member = await response.json();
  const roleId = await pluginDeveloperRoleId(env);
  return {
    member,
    verified: true,
    pluginDev: Boolean(roleId && Array.isArray(member.roles) && member.roles.includes(roleId))
  };
}

async function resolveDiscordUser(env, discord, membership) {
  if (!discord?.id || !discord?.username) {
    throw new Error("Discord returned an invalid user profile");
  }

  const linked = await env.DB.prepare(
    "SELECT user_id FROM discord_accounts WHERE discord_id = ?"
  ).bind(discord.id).first();
  let userId = linked?.user_id || null;

  if (!userId) {
    const email = discord.verified === true ? normalizeEmail(discord.email) : null;
    if (!email) {
      return null;
    }

    const byEmail = await env.DB.prepare(
      "SELECT id FROM users WHERE email = ?"
    ).bind(email).first();
    userId = byEmail?.id || null;

    if (!userId) {
      userId = crypto.randomUUID();
      const username = await uniqueUsername(env, discord);
      const now = nowSeconds();
      const disabledPassword = `discord-only$${randomToken(48)}`;
      try {
        await env.DB.prepare(
          `INSERT INTO users
            (id, email, username, password_hash, created_at, updated_at)
           VALUES (?, ?, ?, ?, ?, ?)`
        ).bind(userId, email, username, disabledPassword, now, now).run();
      } catch (error) {
        if (!isConstraintError(error)) {
          throw error;
        }
        const raced = await env.DB.prepare(
          "SELECT id FROM users WHERE email = ?"
        ).bind(email).first();
        if (!raced) {
          throw error;
        }
        userId = raced.id;
      }
    }
  }

  const existingForDiscord = await env.DB.prepare(
    "SELECT user_id FROM discord_accounts WHERE discord_id = ?"
  ).bind(discord.id).first();
  if (existingForDiscord && existingForDiscord.user_id !== userId) {
    throw new Error("Discord account is already linked to another KLite account");
  }

  await env.DB.prepare(
    `INSERT INTO discord_accounts
      (user_id, discord_id, username, global_name, avatar, linked_at,
       plugin_dev_role, role_verified_at)
     VALUES (?, ?, ?, ?, ?, ?, ?, ?)
     ON CONFLICT(user_id) DO UPDATE SET
       discord_id = excluded.discord_id,
       username = excluded.username,
       global_name = excluded.global_name,
       avatar = excluded.avatar,
       linked_at = excluded.linked_at,
       plugin_dev_role = excluded.plugin_dev_role,
       role_verified_at = excluded.role_verified_at`
  ).bind(userId, discord.id, discord.username, discord.global_name || null,
    discord.avatar || null, nowSeconds(), membership.pluginDev ? 1 : 0,
    membership.verified ? nowSeconds() : null).run();

  try {
    await notifyDiscordAccountLinked(env, discord.id);
  } catch (error) {
    console.error("Unable to apply Discord account-login automation", error);
  }
  return userId;
}

async function uniqueUsername(env, discord) {
  const source = String(discord.global_name || discord.username || "discorduser")
    .normalize("NFKD")
    .replace(/[^\x00-\x7F]/g, "")
    .replace(/[^A-Za-z0-9_-]/g, "");
  let base = source.length >= 3 ? source.slice(0, 18) : "discorduser";
  const idSuffix = String(discord.id).slice(-6).replace(/\D/g, "") || "user";

  for (let attempt = 0; attempt < 50; attempt += 1) {
    const suffix = attempt === 0 ? `_${idSuffix}` : `_${idSuffix}${attempt}`;
    const candidate = `${base.slice(0, Math.max(3, 24 - suffix.length))}${suffix}`;
    const existing = await env.DB.prepare(
      "SELECT 1 AS present FROM users WHERE username = ?"
    ).bind(candidate).first();
    if (!existing?.present) {
      return candidate;
    }
  }
  return `discord_${randomToken(8).replace(/[^A-Za-z0-9]/g, "").slice(0, 12)}`;
}

async function accountPayload(env, userId) {
  const row = await env.DB.prepare(
    `SELECT users.id, users.email, users.username,
      discord_accounts.discord_id, discord_accounts.username AS discord_username,
      discord_accounts.global_name, discord_accounts.avatar,
      discord_accounts.plugin_dev_role, discord_accounts.role_verified_at
     FROM users
     LEFT JOIN discord_accounts ON discord_accounts.user_id = users.id
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
  if (roles.includes("site_owner")) {
    capabilities.push("site_owner");
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
  const result = await env.DB.prepare(
    `SELECT plugin_id, access_level, granted_at, expires_at
     FROM plugin_entitlements
     WHERE user_id = ? AND revoked_at IS NULL
       AND (expires_at IS NULL OR expires_at > ?)
     ORDER BY plugin_id`
  ).bind(userId, nowSeconds()).all();
  return (result.results || []).map((row) => ({
    pluginId: row.plugin_id,
    accessLevel: row.access_level,
    grantedAt: row.granted_at,
    expiresAt: row.expires_at
  }));
}

async function createSession(env, userId, kind) {
  const token = randomToken(32);
  const now = nowSeconds();
  const maxAge = kind === "client" ? CLIENT_SESSION_SECONDS : WEB_SESSION_SECONDS;
  const expiresAt = now + maxAge;
  await env.DB.prepare(
    `INSERT INTO sessions
      (token_hash, user_id, kind, created_at, expires_at, last_used_at)
     VALUES (?, ?, ?, ?, ?, ?)`
  ).bind(await sha256Hex(token), userId, kind, now, expiresAt, now).run();
  return { token, expiresAt, maxAge };
}

async function cleanupExpiredDiscordLogins(env) {
  const now = nowSeconds();
  await env.DB.prepare(
    "DELETE FROM discord_client_login_codes WHERE expires_at <= ? OR consumed_at IS NOT NULL"
  ).bind(now).run();
  await env.DB.prepare(
    "DELETE FROM discord_login_states WHERE expires_at <= ?"
  ).bind(now).run();
}

async function deleteDiscordLoginState(env, stateHash) {
  await env.DB.prepare(
    "DELETE FROM discord_client_login_codes WHERE state_hash = ?"
  ).bind(stateHash).run();
  await env.DB.prepare(
    "DELETE FROM discord_login_states WHERE state_hash = ?"
  ).bind(stateHash).run();
}

function loginFailure(env, loginState, state, error) {
  if (loginState.flow === "client" && loginState.client_redirect_uri) {
    return redirectLoopback(loginState.client_redirect_uri, { error, state });
  }
  const location = new URL("/", env.PUBLIC_ORIGIN);
  location.searchParams.set("login", error);
  location.hash = "account";
  return new Response(null, {
    status: 302,
    headers: { location: location.toString(), "cache-control": "no-store" }
  });
}

function redirectLoopback(redirectUri, parameters) {
  const location = new URL(redirectUri);
  for (const [name, value] of Object.entries(parameters)) {
    location.searchParams.set(name, value);
  }
  return new Response(null, {
    status: 302,
    headers: { location: location.toString(), "cache-control": "no-store" }
  });
}

function normalizeLoopbackRedirect(value) {
  if (typeof value !== "string" || value.length > 300) {
    return null;
  }
  try {
    const url = new URL(value);
    const port = Number(url.port);
    const validHost = url.hostname === "127.0.0.1" || url.hostname === "localhost";
    const validPort = Number.isInteger(port) && port >= 1024 && port <= 65535;
    return url.protocol === "http:" && validHost && validPort
      && url.pathname === "/klite/discord/callback"
      && !url.username && !url.password && !url.search && !url.hash
      ? url.toString() : null;
  } catch {
    return null;
  }
}

function normalizeCodeChallenge(value) {
  return typeof value === "string" && /^[A-Za-z0-9_-]{43}$/.test(value)
    ? value : null;
}

function normalizeEmail(value) {
  if (typeof value !== "string") {
    return null;
  }
  const email = value.trim().toLowerCase();
  return email.length <= 254 && /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)
    ? email : null;
}

async function readOptionalJson(request) {
  const type = request.headers.get("content-type")?.toLowerCase() || "";
  if (!type.startsWith("application/json")) {
    return {};
  }
  const declaredLength = Number(request.headers.get("content-length") || 0);
  if (declaredLength > MAX_JSON_BYTES) {
    return null;
  }
  try {
    const raw = await request.text();
    if (encoder.encode(raw).byteLength > MAX_JSON_BYTES) {
      return null;
    }
    return raw ? JSON.parse(raw) : {};
  } catch {
    return null;
  }
}

function webSessionCookie(token, maxAge) {
  return `klite_session=${encodeURIComponent(token)}; Path=/; HttpOnly; Secure; SameSite=Strict; Max-Age=${maxAge}`;
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

async function sha256Hex(value) {
  const digest = await crypto.subtle.digest("SHA-256", encoder.encode(value));
  return Array.from(new Uint8Array(digest),
    (byte) => byte.toString(16).padStart(2, "0")).join("");
}

async function sha256Base64Url(value) {
  const digest = await crypto.subtle.digest("SHA-256", encoder.encode(value));
  return toBase64Url(new Uint8Array(digest));
}

function toBase64Url(bytes) {
  let binary = "";
  for (const value of bytes) {
    binary += String.fromCharCode(value);
  }
  return btoa(binary).replace(/\+/g, "-").replace(/\//g, "_").replace(/=+$/, "");
}

function isConstraintError(error) {
  return String(error?.message || error).toLowerCase().includes("constraint");
}
