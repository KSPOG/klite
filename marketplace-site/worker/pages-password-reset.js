const encoder = new TextEncoder();
const RESET_STATE_SECONDS = 10 * 60;
const RESET_TOKEN_SECONDS = 15 * 60;
const PASSWORD_ITERATIONS = 100_000;

export async function handlePasswordReset(request, env, url = new URL(request.url)) {
  if (request.method === "POST" && url.pathname === "/api/auth/reset/start") {
    return startPasswordReset(request, env, url);
  }
  if (request.method === "GET" && url.pathname === "/api/auth/reset/callback") {
    return completeDiscordVerification(url, env);
  }
  if (request.method === "POST" && url.pathname === "/api/auth/reset/complete") {
    return completePasswordReset(request, env);
  }
  return null;
}

async function startPasswordReset(request, env, url) {
  const body = await readJson(request);
  const email = normalizeEmail(body?.email);
  if (!email) {
    return apiError(400, "invalid_email", "Enter the email address for the account.");
  }

  const cutoff = nowSeconds() - 15 * 60;
  const identityHash = await sha256(`password-reset\0${request.headers.get("cf-connecting-ip") || "unknown"}\0${email}`);
  await env.DB.prepare("DELETE FROM auth_attempts WHERE attempted_at <= ?").bind(cutoff).run();
  const attempts = await env.DB.prepare(
    "SELECT COUNT(*) AS total FROM auth_attempts WHERE identity_hash = ? AND attempted_at > ?"
  ).bind(identityHash, cutoff).first();
  if (Number(attempts?.total || 0) >= 6) {
    return apiError(429, "rate_limited", "Too many reset attempts. Try again later.");
  }
  await env.DB.prepare("INSERT INTO auth_attempts (identity_hash, attempted_at) VALUES (?, ?)")
    .bind(identityHash, nowSeconds()).run();

  const account = await env.DB.prepare(
    `SELECT users.id, users.username, discord_accounts.discord_id
     FROM users LEFT JOIN discord_accounts ON discord_accounts.user_id = users.id
     WHERE users.email = ?`
  ).bind(email).first();

  const recoveryKey = typeof body?.recoveryKey === "string" ? body.recoveryKey : "";
  if (account && isSiteOwnerAccount(account, env) && recoveryKey) {
    if (!await recoveryKeyMatches(recoveryKey, env.SITE_OWNER_RECOVERY_KEY)) {
      return apiError(403, "invalid_owner_recovery_key", "The owner recovery key is incorrect.");
    }
    const resetToken = await issueResetToken(env, account.id);
    return json({
      started: true,
      resetToken,
      message: "Owner recovery verified. Choose a new password."
    });
  }

  if (!account?.discord_id) {
    return json({
      started: true,
      authorizeUrl: null,
      message: "Password recovery requires a previously linked Discord account. The KLite owner may instead use the configured owner recovery key."
    });
  }

  if (!env.DISCORD_CLIENT_ID || !env.DISCORD_CLIENT_SECRET) {
    return apiError(503, "password_reset_unavailable",
      "Password reset through Discord is unavailable until Discord OAuth is configured.");
  }

  const state = randomToken(32);
  const stateHash = await sha256(state);
  const expiresAt = nowSeconds() + RESET_STATE_SECONDS;
  await env.DB.prepare("DELETE FROM password_reset_states WHERE user_id = ? OR expires_at <= ?")
    .bind(account.id, nowSeconds()).run();
  await env.DB.prepare(
    "INSERT INTO password_reset_states (state_hash, user_id, expires_at, created_at) VALUES (?, ?, ?, ?)"
  ).bind(stateHash, account.id, expiresAt, nowSeconds()).run();

  const redirectUri = `${new URL(env.PUBLIC_ORIGIN).origin}/api/auth/reset/callback`;
  const authorize = new URL("https://discord.com/oauth2/authorize");
  authorize.searchParams.set("client_id", env.DISCORD_CLIENT_ID);
  authorize.searchParams.set("redirect_uri", redirectUri);
  authorize.searchParams.set("response_type", "code");
  authorize.searchParams.set("scope", "identify");
  authorize.searchParams.set("state", state);
  authorize.searchParams.set("prompt", "consent");
  return json({ started: true, authorizeUrl: authorize.toString(), expiresAt });
}

async function completeDiscordVerification(url, env) {
  const failure = (code) => redirectReset(env, `error=${encodeURIComponent(code)}`);
  const code = url.searchParams.get("code");
  const state = url.searchParams.get("state");
  if (!code || !state) {
    return failure("missing_discord_response");
  }

  const stateHash = await sha256(state);
  const pending = await env.DB.prepare(
    "SELECT user_id FROM password_reset_states WHERE state_hash = ? AND expires_at > ?"
  ).bind(stateHash, nowSeconds()).first();
  if (!pending) {
    return failure("reset_request_expired");
  }
  await env.DB.prepare("DELETE FROM password_reset_states WHERE state_hash = ?")
    .bind(stateHash).run();

  const redirectUri = `${new URL(env.PUBLIC_ORIGIN).origin}/api/auth/reset/callback`;
  const tokenResponse = await fetch("https://discord.com/api/v10/oauth2/token", {
    method: "POST",
    headers: { "content-type": "application/x-www-form-urlencoded" },
    body: new URLSearchParams({
      client_id: env.DISCORD_CLIENT_ID,
      client_secret: env.DISCORD_CLIENT_SECRET,
      grant_type: "authorization_code",
      code,
      redirect_uri: redirectUri
    })
  });
  if (!tokenResponse.ok) {
    return failure("discord_exchange_failed");
  }
  const oauth = await tokenResponse.json();
  const profileResponse = await fetch("https://discord.com/api/v10/users/@me", {
    headers: { authorization: `Bearer ${oauth.access_token}` }
  });
  if (!profileResponse.ok) {
    return failure("discord_profile_failed");
  }
  const discord = await profileResponse.json();
  const linked = await env.DB.prepare(
    "SELECT 1 AS valid FROM discord_accounts WHERE user_id = ? AND discord_id = ?"
  ).bind(pending.user_id, discord.id).first();
  if (!linked?.valid) {
    return failure("discord_account_mismatch");
  }

  const resetToken = await issueResetToken(env, pending.user_id);
  return redirectReset(env, `token=${encodeURIComponent(resetToken)}`);
}

async function issueResetToken(env, userId) {
  const resetToken = randomToken(32);
  const resetTokenHash = await sha256(resetToken);
  const expiresAt = nowSeconds() + RESET_TOKEN_SECONDS;
  await env.DB.prepare("DELETE FROM password_reset_tokens WHERE user_id = ? OR expires_at <= ?")
    .bind(userId, nowSeconds()).run();
  await env.DB.prepare(
    "INSERT INTO password_reset_tokens (token_hash, user_id, expires_at, created_at) VALUES (?, ?, ?, ?)"
  ).bind(resetTokenHash, userId, expiresAt, nowSeconds()).run();
  return resetToken;
}

function isSiteOwnerAccount(account, env) {
  const configuredId = typeof env.SITE_OWNER_USER_ID === "string" ? env.SITE_OWNER_USER_ID.trim() : "";
  if (configuredId && account.id === configuredId) return true;
  const configuredUsername = typeof env.SITE_OWNER_USERNAME === "string" && env.SITE_OWNER_USERNAME.trim()
    ? env.SITE_OWNER_USERNAME.trim() : "KSP";
  return String(account.username || "").toLowerCase() === configuredUsername.toLowerCase();
}

async function recoveryKeyMatches(provided, expected) {
  if (typeof expected !== "string" || expected.length < 16 || typeof provided !== "string") return false;
  const [left, right] = await Promise.all([sha256(provided), sha256(expected)]);
  let difference = left.length ^ right.length;
  for (let index = 0; index < Math.min(left.length, right.length); index += 1) {
    difference |= left.charCodeAt(index) ^ right.charCodeAt(index);
  }
  return difference === 0;
}

async function completePasswordReset(request, env) {
  const body = await readJson(request);
  const token = typeof body?.token === "string" ? body.token.trim() : "";
  const passwordError = validatePassword(body?.password);
  if (!token || passwordError) {
    return apiError(400, "invalid_reset", passwordError || "The reset token is required.");
  }
  const tokenHash = await sha256(token);
  const pending = await env.DB.prepare(
    "SELECT user_id FROM password_reset_tokens WHERE token_hash = ? AND consumed_at IS NULL AND expires_at > ?"
  ).bind(tokenHash, nowSeconds()).first();
  if (!pending) {
    return apiError(400, "reset_expired", "This password reset link is invalid or expired.");
  }

  const passwordHash = await hashPassword(body.password, env.PASSWORD_PEPPER);
  const now = nowSeconds();
  const consumed = await env.DB.prepare(
    "UPDATE password_reset_tokens SET consumed_at = ? WHERE token_hash = ? AND consumed_at IS NULL"
  ).bind(now, tokenHash).run();
  if (!consumed.meta?.changes) {
    return apiError(400, "reset_expired", "This password reset link was already used.");
  }
  await env.DB.prepare("UPDATE users SET password_hash = ?, updated_at = ? WHERE id = ?")
    .bind(passwordHash, now, pending.user_id).run();
  await env.DB.prepare("DELETE FROM sessions WHERE user_id = ?").bind(pending.user_id).run();
  return json({ ok: true, message: "Password updated. Sign in with the new password." });
}

function redirectReset(env, hash) {
  const location = new URL("/", env.PUBLIC_ORIGIN);
  location.hash = `reset-${hash}`;
  return new Response(null, {
    status: 302,
    headers: { location: location.toString(), "cache-control": "no-store" }
  });
}

function normalizeEmail(value) {
  if (typeof value !== "string") return null;
  const email = value.trim().toLowerCase();
  return email.length <= 254 && /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email) ? email : null;
}

function validatePassword(value) {
  if (typeof value !== "string" || value.length < 12) return "Use a password with at least 12 characters.";
  if (value.length > 128) return "Password cannot exceed 128 characters.";
  return null;
}

async function hashPassword(password, pepper, salt = randomToken(16)) {
  if (!pepper) throw new Error("PASSWORD_PEPPER is not configured");
  const key = await crypto.subtle.importKey(
    "raw", encoder.encode(`${password}\0${pepper}`), "PBKDF2", false, ["deriveBits"]
  );
  const bits = await crypto.subtle.deriveBits({
    name: "PBKDF2",
    hash: "SHA-256",
    salt: fromBase64Url(salt),
    iterations: PASSWORD_ITERATIONS
  }, key, 256);
  return `pbkdf2-sha256$${PASSWORD_ITERATIONS}$${salt}$${toBase64Url(new Uint8Array(bits))}`;
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

function randomToken(length) {
  const bytes = new Uint8Array(length);
  crypto.getRandomValues(bytes);
  return toBase64Url(bytes);
}

function toBase64Url(bytes) {
  let binary = "";
  for (const value of bytes) binary += String.fromCharCode(value);
  return btoa(binary).replace(/\+/g, "-").replace(/\//g, "_").replace(/=+$/, "");
}

function fromBase64Url(value) {
  const base64 = value.replace(/-/g, "+").replace(/_/g, "/").padEnd(Math.ceil(value.length / 4) * 4, "=");
  return Uint8Array.from(atob(base64), (character) => character.charCodeAt(0));
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
