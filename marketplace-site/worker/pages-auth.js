const encoder = new TextEncoder();

const PASSWORD_ITERATIONS = 100_000;
const MIN_SUPPORTED_ITERATIONS = 50_000;
const MAX_SUPPORTED_ITERATIONS = 1_000_000;
const WEB_SESSION_SECONDS = 7 * 24 * 60 * 60;
const CLIENT_SESSION_SECONDS = 30 * 24 * 60 * 60;
const MAX_AUTH_ATTEMPTS = 10;
const AUTH_WINDOW_SECONDS = 15 * 60;

/**
 * Handles the authentication endpoints for Cloudflare Pages.
 *
 * The standalone marketplace Worker uses a higher PBKDF2 work factor. Pages
 * deployments run under a tighter request CPU budget, so the Pages adapter
 * uses a deployment-appropriate work factor while retaining compatibility
 * with hashes that store another supported iteration count.
 *
 * @returns {Promise<Response|null>} A response for an auth endpoint, otherwise null.
 */
export async function handlePagesAuth(request, env, url = new URL(request.url)) {
  if (request.method === "POST" && url.pathname === "/api/auth/register") {
    return register(request, env);
  }
  if (request.method === "POST" && url.pathname === "/api/auth/login") {
    return login(request, env);
  }
  return null;
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
    return apiError(
      400,
      "invalid_registration",
      passwordError || "Enter a valid email and username."
    );
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

  await clearRateLimit(env, request, email);
  const session = await createSession(env, userId, "web");
  const payload = {
    account: await accountPayload(env, userId),
    entitlements: await entitlements(env, userId)
  };

  return json(payload, 201, {
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
  const payload = {
    account: await accountPayload(env, user.id),
    entitlements: await entitlements(env, user.id)
  };

  if (kind === "client") {
    payload.token = session.token;
    payload.expiresAt = session.expiresAt;
    return json(payload);
  }

  return json(payload, 200, {
    "set-cookie": webSessionCookie(session.token, session.maxAge)
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
    "INSERT INTO sessions (token_hash, user_id, kind, created_at, expires_at, last_used_at) VALUES (?, ?, ?, ?, ?, ?)"
  ).bind(await sha256(token), userId, kind, now, expiresAt, now).run();

  return { token, expiresAt, maxAge };
}

async function rateLimited(env, request, identity) {
  const cutoff = nowSeconds() - AUTH_WINDOW_SECONDS;
  const ip = request.headers.get("cf-connecting-ip") || "unknown";
  const identityHash = await sha256(`${ip}\0${identity}`);

  await env.DB.prepare("DELETE FROM auth_attempts WHERE attempted_at <= ?")
    .bind(cutoff).run();
  const count = await env.DB.prepare(
    "SELECT COUNT(*) AS total FROM auth_attempts WHERE identity_hash = ? AND attempted_at > ?"
  ).bind(identityHash, cutoff).first();

  if (Number(count?.total || 0) >= MAX_AUTH_ATTEMPTS) {
    return true;
  }

  await env.DB.prepare(
    "INSERT INTO auth_attempts (identity_hash, attempted_at) VALUES (?, ?)"
  ).bind(identityHash, nowSeconds()).run();
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

async function hashPassword(
  password,
  pepper,
  salt = randomToken(16),
  iterations = PASSWORD_ITERATIONS
) {
  if (!pepper) {
    throw new Error("PASSWORD_PEPPER is not configured");
  }
  if (!Number.isInteger(iterations)
      || iterations < MIN_SUPPORTED_ITERATIONS
      || iterations > MAX_SUPPORTED_ITERATIONS) {
    throw new Error("Unsupported PBKDF2 iteration count");
  }

  const key = await crypto.subtle.importKey(
    "raw",
    encoder.encode(`${password}\0${pepper}`),
    "PBKDF2",
    false,
    ["deriveBits"]
  );
  const bits = await crypto.subtle.deriveBits(
    {
      name: "PBKDF2",
      hash: "SHA-256",
      salt: fromBase64Url(salt),
      iterations
    },
    key,
    256
  );

  return `pbkdf2-sha256$${iterations}$${salt}$${toBase64Url(new Uint8Array(bits))}`;
}

async function verifyPassword(password, encoded, pepper) {
  const parts = typeof encoded === "string" ? encoded.split("$") : [];
  const iterations = Number(parts[1]);
  if (parts.length !== 4
      || parts[0] !== "pbkdf2-sha256"
      || !Number.isInteger(iterations)
      || iterations < MIN_SUPPORTED_ITERATIONS
      || iterations > MAX_SUPPORTED_ITERATIONS) {
    return false;
  }

  const candidate = await hashPassword(password, pepper, parts[2], iterations);
  return constantTimeEqual(encoder.encode(candidate), encoder.encode(encoded));
}

function normalizeEmail(value) {
  if (typeof value !== "string") {
    return null;
  }
  const email = value.trim().toLowerCase();
  return email.length <= 254 && /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)
    ? email
    : null;
}

function normalizeUsername(value) {
  if (typeof value !== "string") {
    return null;
  }
  const username = value.trim();
  return /^[A-Za-z0-9_-]{3,24}$/.test(username) ? username : null;
}

function validatePassword(value) {
  if (typeof value !== "string" || value.length < 12) {
    return "Use a password with at least 12 characters.";
  }
  if (value.length > 128) {
    return "Password cannot exceed 128 characters.";
  }
  return null;
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

async function sha256(value) {
  const digest = await crypto.subtle.digest("SHA-256", encoder.encode(value));
  return Array.from(new Uint8Array(digest), (byte) =>
    byte.toString(16).padStart(2, "0")
  ).join("");
}

function toBase64Url(bytes) {
  let binary = "";
  for (const value of bytes) {
    binary += String.fromCharCode(value);
  }
  return btoa(binary)
    .replace(/\+/g, "-")
    .replace(/\//g, "_")
    .replace(/=+$/, "");
}

function fromBase64Url(value) {
  const base64 = value
    .replace(/-/g, "+")
    .replace(/_/g, "/")
    .padEnd(Math.ceil(value.length / 4) * 4, "=");
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
