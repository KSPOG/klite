const encoder = new TextEncoder();

const CREDIT_PACKS = Object.freeze([
  { id: "credits-500", usdCents: 572, credits: 500, bonusPercent: 0 },
  { id: "credits-1050", usdCents: 1144, credits: 1050, bonusPercent: 5 },
  { id: "credits-2200", usdCents: 2288, credits: 2200, bonusPercent: 10 },
  { id: "credits-4000", usdCents: 4004, credits: 4000, bonusPercent: 14 },
  { id: "credits-5750", usdCents: 5720, credits: 5750, bonusPercent: 15 },
  { id: "credits-12000", usdCents: 11440, credits: 12000, bonusPercent: 20 }
]);
const PACKS_BY_ID = new Map(CREDIT_PACKS.map((pack) => [pack.id, pack]));

export async function handleCredits(request, env, url = new URL(request.url)) {
  if (request.method === "GET" && url.pathname === "/api/credits/packs") {
    return json({ currency: "USD", packs: publicPacks() });
  }
  if (request.method === "POST" && url.pathname === "/api/webhooks/lemonsqueezy") {
    return handleLemonSqueezyWebhook(request, env);
  }
  if (request.method === "GET" && url.pathname === "/api/credits/prices") {
    return json({ prices: await activePluginPrices(env) });
  }
  if (!url.pathname.startsWith("/api/credits")) return null;

  const user = await authenticatedUser(request, env);
  if (!user) {
    if (url.pathname.startsWith("/api/credits")) {
      return apiError(401, "authentication_required", "Sign in to manage KLite credits.");
    }
    return null;
  }

  if (request.method === "GET" && url.pathname === "/api/credits") {
    return json(await creditAccountPayload(env, user.id));
  }
  if (request.method === "POST" && url.pathname === "/api/credits/checkout") {
    return createCreditCheckout(request, env, user);
  }
  if (request.method === "POST" && url.pathname === "/api/credits/purchase") {
    return purchasePlugin(request, env, user);
  }
  if (request.method === "GET" && url.pathname === "/api/credits/admin") {
    return adminCreditDashboard(env, user);
  }
  const adjustmentMatch = url.pathname.match(
    /^\/api\/credits\/admin\/users\/([a-f0-9-]+)\/adjustments$/i
  );
  if (adjustmentMatch && request.method === "POST") {
    return adjustUserCredits(request, env, user, adjustmentMatch[1]);
  }
  const priceMatch = url.pathname.match(/^\/api\/credits\/admin\/prices\/([a-z0-9][a-z0-9-]{2,63})$/);
  if (priceMatch && request.method === "PUT") {
    return updatePluginPrice(request, env, user, priceMatch[1]);
  }
  return null;
}

async function createCreditCheckout(request, env, user) {
  if (!livePaymentsEnabled(env)) {
    return apiError(503, "credit_checkout_live_mode_required",
      "Credit checkout is unavailable until live payment processing is configured.");
  }
  const missing = [
    "LEMON_SQUEEZY_API_KEY",
    "LEMON_SQUEEZY_STORE_ID",
    "LEMON_SQUEEZY_CREDIT_VARIANT_ID",
    "LEMON_SQUEEZY_WEBHOOK_SECRET"
  ].filter((key) => !env[key]);
  if (missing.length) {
    return apiError(503, "credit_checkout_not_configured",
      `Credit checkout is not configured. Missing: ${missing.join(", ")}.`);
  }

  const body = await readJson(request);
  const pack = PACKS_BY_ID.get(body?.packId);
  if (!pack) {
    return apiError(400, "invalid_credit_pack", "Choose a valid KLite credit pack.");
  }

  const orderId = crypto.randomUUID();
  const now = nowSeconds();
  await env.DB.prepare(
    `INSERT INTO credit_checkout_orders
      (id, user_id, pack_id, usd_cents, credits, status, provider, created_at, updated_at)
     VALUES (?, ?, ?, ?, ?, 'pending', 'lemonsqueezy', ?, ?)`
  ).bind(orderId, user.id, pack.id, pack.usdCents, pack.credits, now, now).run();

  const origin = new URL(env.PUBLIC_ORIGIN || request.url).origin;
  const variantId = String(env.LEMON_SQUEEZY_CREDIT_VARIANT_ID);
  const checkoutPayload = {
    data: {
      type: "checkouts",
      attributes: {
        test_mode: false,
        custom_price: pack.usdCents,
        product_options: {
          name: `KLite ${pack.credits.toLocaleString("en-US")} Credits`,
          description: pack.bonusPercent
            ? `${pack.credits.toLocaleString("en-US")} KLite marketplace credits including a ${pack.bonusPercent}% pack bonus.`
            : `${pack.credits.toLocaleString("en-US")} KLite marketplace credits.`,
          redirect_url: `${origin}/?credits=payment_pending#account`,
          receipt_button_text: "Return to KLite",
          receipt_link_url: `${origin}/#account`,
          receipt_thank_you_note: "Your KLite credits are added after the verified payment webhook is received.",
          enabled_variants: [Number(variantId)]
        },
        checkout_options: {
          embed: false,
          media: false,
          logo: true,
          desc: true,
          discount: false,
          background_color: "#02070d",
          headings_color: "#f1f5f7",
          primary_text_color: "#aebdc7"
        },
        checkout_data: {
          email: user.email,
          name: user.username,
          custom: {
            klite_order_id: orderId,
            klite_user_id: user.id,
            klite_pack_id: pack.id
          }
        }
      },
      relationships: {
        store: { data: { type: "stores", id: String(env.LEMON_SQUEEZY_STORE_ID) } },
        variant: { data: { type: "variants", id: variantId } }
      }
    }
  };

  const response = await fetch("https://api.lemonsqueezy.com/v1/checkouts", {
    method: "POST",
    headers: {
      accept: "application/vnd.api+json",
      "content-type": "application/vnd.api+json",
      authorization: `Bearer ${env.LEMON_SQUEEZY_API_KEY}`
    },
    body: JSON.stringify(checkoutPayload)
  });
  const payload = await response.json().catch(() => ({}));
  if (!response.ok || !payload?.data?.attributes?.url
      || payload.data.attributes.test_mode !== false) {
    await env.DB.prepare(
      "UPDATE credit_checkout_orders SET status = 'failed', updated_at = ? WHERE id = ?"
    ).bind(nowSeconds(), orderId).run();
    console.error("Unable to create Lemon Squeezy credit checkout", response.status, payload);
    return apiError(502, "credit_checkout_failed", "The secure credit checkout could not be created.");
  }

  const checkoutId = String(payload.data.id || "");
  const checkoutUrl = String(payload.data.attributes.url);
  await env.DB.prepare(
    `UPDATE credit_checkout_orders
     SET provider_checkout_id = ?, checkout_url = ?, updated_at = ? WHERE id = ?`
  ).bind(checkoutId, checkoutUrl, nowSeconds(), orderId).run();
  return json({ checkoutUrl, orderId, pack: publicPack(pack) }, 201);
}

async function handleLemonSqueezyWebhook(request, env) {
  if (!livePaymentsEnabled(env)) {
    return apiError(503, "credit_webhook_live_mode_required",
      "Live credit payment verification is not configured.");
  }
  if (!env.LEMON_SQUEEZY_WEBHOOK_SECRET) {
    return apiError(503, "credit_webhook_not_configured", "Credit payment verification is not configured.");
  }
  const rawBody = await request.text();
  const signature = (request.headers.get("x-signature") || "").trim().toLowerCase();
  const expected = await hmacHex(env.LEMON_SQUEEZY_WEBHOOK_SECRET, rawBody);
  if (!signature || !constantTimeTextEqual(signature, expected)) {
    return apiError(401, "invalid_webhook_signature", "Invalid payment webhook signature.");
  }

  let payload;
  try {
    payload = JSON.parse(rawBody);
  } catch {
    return apiError(400, "invalid_webhook_json", "Invalid payment webhook payload.");
  }
  const eventName = request.headers.get("x-event-name") || payload?.meta?.event_name;
  if (eventName !== "order_created") {
    return json({ ok: true, ignored: true });
  }

  const attributes = payload?.data?.attributes || {};
  if (attributes.test_mode !== false) {
    return apiError(409, "test_mode_payment_rejected",
      "Test-mode payments cannot grant KLite credits.");
  }

  const custom = payload?.meta?.custom_data || {};
  const orderId = String(custom.klite_order_id || "");
  const userId = String(custom.klite_user_id || "");
  const packId = String(custom.klite_pack_id || "");
  const providerOrderId = String(payload?.data?.id || "");
  if (!orderId || !userId || !packId || !providerOrderId) {
    return apiError(400, "missing_webhook_metadata", "Payment metadata is incomplete.");
  }

  const order = await env.DB.prepare(
    `SELECT id, user_id, pack_id, usd_cents, credits, status
     FROM credit_checkout_orders WHERE id = ? AND provider = 'lemonsqueezy'`
  ).bind(orderId).first();
  if (!order || order.user_id !== userId || order.pack_id !== packId) {
    return apiError(404, "credit_order_not_found", "The credit order could not be matched.");
  }

  const currency = String(attributes.currency || "").toUpperCase();
  const subtotal = Number(attributes.subtotal_usd ?? attributes.subtotal);
  if (currency !== "USD" || !Number.isInteger(subtotal) || subtotal !== Number(order.usd_cents)) {
    console.error("Credit order amount mismatch", orderId, currency, subtotal, order.usd_cents);
    return apiError(409, "credit_order_amount_mismatch", "The paid amount does not match the credit pack.");
  }

  const now = nowSeconds();
  const transactionId = `topup:lemonsqueezy:${providerOrderId}`;
  await env.DB.batch([
    env.DB.prepare(
      `UPDATE credit_checkout_orders
       SET status = 'paid', provider_order_id = ?, paid_at = ?, updated_at = ?
       WHERE id = ? AND status = 'pending'`
    ).bind(providerOrderId, now, now, orderId),
    env.DB.prepare(
      `INSERT OR IGNORE INTO credit_transactions
        (id, user_id, delta, kind, description, pack_id, provider, provider_reference, created_at)
       SELECT ?, user_id, credits, 'top_up', ?, pack_id, 'lemonsqueezy', ?, ?
       FROM credit_checkout_orders
       WHERE id = ? AND status = 'paid' AND provider_order_id = ?`
    ).bind(transactionId,
      `${Number(order.credits).toLocaleString("en-US")} credit top-up`,
      providerOrderId, now, orderId, providerOrderId)
  ]);
  return json({ ok: true });
}

async function purchasePlugin(request, env, user) {
  const body = await readJson(request);
  const pluginId = normalizePluginId(body?.pluginId);
  if (!pluginId) {
    return apiError(400, "invalid_plugin", "Choose a valid premium plugin.");
  }

  const price = await env.DB.prepare(
    "SELECT price_credits FROM plugin_credit_prices WHERE plugin_id = ? AND active = 1"
  ).bind(pluginId).first();
  if (!price) {
    return apiError(404, "plugin_price_not_found", "This plugin is not currently available for credit purchase.");
  }
  const artifact = await env.DB.prepare(
    `SELECT access_type FROM plugin_artifacts
     WHERE plugin_id = ? AND revoked_at IS NULL
       AND access_type IN ('Supporter', 'Premium')
     ORDER BY published_at DESC LIMIT 1`
  ).bind(pluginId).first();
  if (!artifact) {
    return apiError(409, "premium_plugin_unavailable", "This premium plugin is not currently published.");
  }
  const owned = await env.DB.prepare(
    `SELECT 1 AS allowed FROM plugin_entitlements
     WHERE user_id = ? AND plugin_id = ? AND revoked_at IS NULL
       AND (expires_at IS NULL OR expires_at > ?)`
  ).bind(user.id, pluginId, nowSeconds()).first();
  if (owned?.allowed) {
    return apiError(409, "plugin_already_owned", "This plugin is already owned by your account.");
  }

  const balance = await creditBalance(env, user.id);
  const required = Number(price.price_credits);
  if (balance < required) {
    return apiError(409, "insufficient_credits", `This purchase requires ${required.toLocaleString("en-US")} credits.`);
  }

  const transactionId = crypto.randomUUID();
  const now = nowSeconds();
  await env.DB.batch([
    env.DB.prepare(
      `INSERT INTO credit_transactions
        (id, user_id, delta, kind, description, plugin_id, created_at)
       SELECT ?, ?, ?, 'plugin_purchase', ?, ?, ?
       WHERE (SELECT COALESCE(SUM(delta), 0) FROM credit_transactions WHERE user_id = ?) >= ?
         AND NOT EXISTS (
           SELECT 1 FROM plugin_entitlements
           WHERE user_id = ? AND plugin_id = ? AND revoked_at IS NULL
             AND (expires_at IS NULL OR expires_at > ?)
         )`
    ).bind(transactionId, user.id, -required,
      `Purchased ${pluginId}`, pluginId, now,
      user.id, required, user.id, pluginId, now),
    env.DB.prepare(
      `INSERT INTO plugin_entitlements
        (user_id, plugin_id, access_level, granted_at, expires_at, revoked_at)
       SELECT ?, ?, 'paid', ?, NULL, NULL
       WHERE EXISTS (SELECT 1 FROM credit_transactions WHERE id = ?)
       ON CONFLICT(user_id, plugin_id) DO UPDATE SET
         access_level = excluded.access_level,
         granted_at = excluded.granted_at,
         expires_at = NULL,
         revoked_at = NULL`
    ).bind(user.id, pluginId, now, transactionId)
  ]);

  const transaction = await env.DB.prepare(
    "SELECT 1 AS completed FROM credit_transactions WHERE id = ?"
  ).bind(transactionId).first();
  if (!transaction?.completed) {
    return apiError(409, "purchase_conflict", "The purchase could not be completed. Refresh your balance and try again.");
  }
  return json({ ok: true, pluginId, balance: await creditBalance(env, user.id) });
}

async function adminCreditDashboard(env, user) {
  if (!isSiteOwner(user, env)) {
    return apiError(403, "site_owner_required", "Only the KLite site owner can manage credits.");
  }
  const [prices, transactions, users] = await Promise.all([
    env.DB.prepare(
      `SELECT plugin_id, price_credits, active, updated_at
       FROM plugin_credit_prices ORDER BY plugin_id`
    ).all(),
    env.DB.prepare(
      `SELECT credit_transactions.id, users.username, credit_transactions.user_id,
        delta, kind, description, plugin_id, pack_id, provider, provider_reference,
        credit_transactions.created_at
       FROM credit_transactions JOIN users ON users.id = credit_transactions.user_id
       ORDER BY credit_transactions.created_at DESC LIMIT 100`
    ).all(),
    env.DB.prepare(
      `SELECT users.id, users.username, users.email,
        COALESCE(SUM(credit_transactions.delta), 0) AS balance
       FROM users
       LEFT JOIN credit_transactions ON credit_transactions.user_id = users.id
       GROUP BY users.id, users.username, users.email
       ORDER BY lower(users.username), lower(users.email)
       LIMIT 250`
    ).all()
  ]);
  return json({
    prices: (prices.results || []).map(pricePayload),
    transactions: (transactions.results || []).map(transactionPayload),
    users: (users.results || []).map((row) => ({
      id: row.id,
      username: row.username,
      email: row.email,
      balance: Number(row.balance || 0)
    }))
  });
}

export async function adjustUserCredits(request, env, owner, userId) {
  if (!isSiteOwner(owner, env)) {
    return apiError(403, "site_owner_required", "Only the KLite site owner can adjust user credits.");
  }
  const target = await env.DB.prepare(
    "SELECT id, username, email FROM users WHERE id = ?"
  ).bind(userId).first();
  if (!target) return apiError(404, "user_not_found", "The marketplace account was not found.");

  const body = await readJson(request);
  const delta = Number(body?.delta);
  const reason = typeof body?.reason === "string"
    ? body.reason.replace(/[\u0000-\u001f\u007f]/g, " ").replace(/\s+/g, " ").trim()
    : "";
  if (!Number.isSafeInteger(delta) || delta === 0 || Math.abs(delta) > 10_000_000) {
    return apiError(
      400,
      "invalid_credit_adjustment",
      "Enter a non-zero whole-number adjustment between -10,000,000 and 10,000,000."
    );
  }
  if (reason.length < 10 || reason.length > 240) {
    return apiError(
      400,
      "invalid_adjustment_reason",
      "Enter an audit reason between 10 and 240 characters."
    );
  }

  const balance = await creditBalance(env, userId);
  if (balance + delta < 0) {
    return apiError(
      409,
      "negative_credit_balance",
      `This adjustment would reduce the balance below zero. Current balance: ${balance.toLocaleString("en-US")} credits.`
    );
  }

  const transactionId = crypto.randomUUID();
  const result = await env.DB.prepare(
    `INSERT INTO credit_transactions
      (id, user_id, delta, kind, description, provider, provider_reference, created_at)
     SELECT ?, ?, ?, 'adjustment', ?, 'klite_admin', ?, ?
     WHERE (SELECT COALESCE(SUM(delta), 0) FROM credit_transactions WHERE user_id = ?) + ? >= 0`
  ).bind(
    transactionId,
    userId,
    delta,
    reason,
    `${owner.id}:${transactionId}`,
    nowSeconds(),
    userId,
    delta
  ).run();
  if (!result.meta?.changes) {
    return apiError(
      409,
      "credit_balance_changed",
      "The balance changed while the adjustment was being applied. Refresh and try again."
    );
  }
  return json({
    user: {
      ...target,
      balance: await creditBalance(env, userId)
    },
    transaction: {
      id: transactionId,
      delta,
      kind: "adjustment",
      description: reason
    }
  });
}

async function updatePluginPrice(request, env, user, pluginId) {
  if (!isSiteOwner(user, env)) {
    return apiError(403, "site_owner_required", "Only the KLite site owner can manage credit prices.");
  }
  const body = await readJson(request);
  const priceCredits = Number(body?.priceCredits);
  const active = body?.active;
  if (!Number.isInteger(priceCredits) || priceCredits < 1 || priceCredits > 10_000_000
      || typeof active !== "boolean") {
    return apiError(400, "invalid_plugin_price", "Enter a whole-number credit price and active state.");
  }
  await env.DB.prepare(
    `INSERT INTO plugin_credit_prices
      (plugin_id, price_credits, active, updated_by, updated_at)
     VALUES (?, ?, ?, ?, ?)
     ON CONFLICT(plugin_id) DO UPDATE SET
       price_credits = excluded.price_credits,
       active = excluded.active,
       updated_by = excluded.updated_by,
       updated_at = excluded.updated_at`
  ).bind(pluginId, priceCredits, active ? 1 : 0, user.id, nowSeconds()).run();
  return json({ price: { pluginId, priceCredits, active } });
}

async function creditAccountPayload(env, userId) {
  const [balance, transactions, prices] = await Promise.all([
    creditBalance(env, userId),
    env.DB.prepare(
      `SELECT id, delta, kind, description, plugin_id, pack_id, provider, provider_reference, created_at
       FROM credit_transactions WHERE user_id = ? ORDER BY created_at DESC LIMIT 50`
    ).bind(userId).all(),
    activePluginPrices(env)
  ]);
  return {
    currency: "USD",
    balance,
    packs: publicPacks(),
    prices,
    transactions: (transactions.results || []).map(transactionPayload)
  };
}

async function activePluginPrices(env) {
  const rows = await env.DB.prepare(
    "SELECT plugin_id, price_credits FROM plugin_credit_prices WHERE active = 1 ORDER BY plugin_id"
  ).all();
  return (rows.results || []).map((row) => ({
    pluginId: row.plugin_id,
    priceCredits: Number(row.price_credits)
  }));
}

async function creditBalance(env, userId) {
  const row = await env.DB.prepare(
    "SELECT COALESCE(SUM(delta), 0) AS balance FROM credit_transactions WHERE user_id = ?"
  ).bind(userId).first();
  return Number(row?.balance || 0);
}

async function authenticatedUser(request, env) {
  const token = sessionToken(request);
  if (!token) return null;
  const tokenHash = await sha256(token);
  const row = await env.DB.prepare(
    `SELECT users.id, users.email, users.username, sessions.kind
     FROM sessions JOIN users ON users.id = sessions.user_id
     WHERE sessions.token_hash = ? AND sessions.expires_at > ?`
  ).bind(tokenHash, nowSeconds()).first();
  if (!row) return null;
  await env.DB.prepare("UPDATE sessions SET last_used_at = ? WHERE token_hash = ?")
    .bind(nowSeconds(), tokenHash).run();
  return row;
}

function isSiteOwner(user, env) {
  const configuredId = typeof env.SITE_OWNER_USER_ID === "string" ? env.SITE_OWNER_USER_ID.trim() : "";
  if (configuredId && user.id === configuredId) return true;
  const configuredUsername = typeof env.SITE_OWNER_USERNAME === "string" && env.SITE_OWNER_USERNAME.trim()
    ? env.SITE_OWNER_USERNAME.trim() : "KSP";
  return String(user.username || "").toLowerCase() === configuredUsername.toLowerCase();
}

function publicPacks() {
  return CREDIT_PACKS.map(publicPack);
}

function publicPack(pack) {
  return {
    id: pack.id,
    usdCents: pack.usdCents,
    usd: (pack.usdCents / 100).toFixed(2),
    credits: pack.credits,
    bonusPercent: pack.bonusPercent
  };
}

function pricePayload(row) {
  return {
    pluginId: row.plugin_id,
    priceCredits: Number(row.price_credits),
    active: row.active === 1,
    updatedAt: row.updated_at
  };
}

function transactionPayload(row) {
  return {
    id: row.id,
    username: row.username,
    userId: row.user_id,
    delta: Number(row.delta),
    kind: row.kind,
    description: row.description,
    pluginId: row.plugin_id,
    packId: row.pack_id,
    provider: row.provider,
    providerReference: row.provider_reference,
    createdAt: row.created_at
  };
}

function normalizePluginId(value) {
  if (typeof value !== "string") return null;
  const pluginId = value.trim().toLowerCase();
  return /^[a-z0-9][a-z0-9-]{2,63}$/.test(pluginId) ? pluginId : null;
}

async function readJson(request) {
  if (!request.headers.get("content-type")?.toLowerCase().startsWith("application/json")) return null;
  const declaredLength = Number(request.headers.get("content-length") || 0);
  if (declaredLength > 16_384) return null;
  try {
    const raw = await request.text();
    if (encoder.encode(raw).byteLength > 16_384) return null;
    return JSON.parse(raw);
  } catch {
    return null;
  }
}

function sessionToken(request) {
  const authorization = request.headers.get("authorization");
  if (authorization?.startsWith("Bearer ")) return authorization.slice(7).trim();
  const match = (request.headers.get("cookie") || "").match(/(?:^|;\s*)klite_session=([^;]+)/);
  return match ? decodeURIComponent(match[1]) : null;
}

async function sha256(value) {
  const digest = await crypto.subtle.digest("SHA-256", encoder.encode(value));
  return toHex(new Uint8Array(digest));
}

async function hmacHex(secret, value) {
  const key = await crypto.subtle.importKey(
    "raw", encoder.encode(secret), { name: "HMAC", hash: "SHA-256" }, false, ["sign"]
  );
  const signature = await crypto.subtle.sign("HMAC", key, encoder.encode(value));
  return toHex(new Uint8Array(signature));
}

function toHex(bytes) {
  return Array.from(bytes, (value) => value.toString(16).padStart(2, "0")).join("");
}

function constantTimeTextEqual(left, right) {
  const a = encoder.encode(left);
  const b = encoder.encode(right);
  if (a.length !== b.length) return false;
  let difference = 0;
  for (let index = 0; index < a.length; index += 1) difference |= a[index] ^ b[index];
  return difference === 0;
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

export function livePaymentsEnabled(env) {
  return String(env?.LEMON_SQUEEZY_LIVE_MODE || "").trim().toLowerCase() === "true";
}
