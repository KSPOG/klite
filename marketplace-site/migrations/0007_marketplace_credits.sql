PRAGMA foreign_keys = ON;

-- Credits are an integer-only marketplace currency. The balance is derived from
-- the immutable ledger so retries and webhook re-deliveries cannot double-spend
-- or silently rewrite a user's balance.
CREATE TABLE credit_transactions (
  id TEXT PRIMARY KEY,
  user_id TEXT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  delta INTEGER NOT NULL CHECK (delta <> 0),
  kind TEXT NOT NULL CHECK (kind IN ('top_up', 'plugin_purchase', 'refund', 'adjustment')),
  description TEXT NOT NULL,
  plugin_id TEXT,
  pack_id TEXT,
  provider TEXT,
  provider_reference TEXT,
  created_at INTEGER NOT NULL
);

CREATE INDEX credit_transactions_user_time_idx
  ON credit_transactions(user_id, created_at DESC);
CREATE UNIQUE INDEX credit_transactions_provider_event_idx
  ON credit_transactions(provider, provider_reference, kind);

CREATE TABLE credit_checkout_orders (
  id TEXT PRIMARY KEY,
  user_id TEXT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  pack_id TEXT NOT NULL,
  usd_cents INTEGER NOT NULL CHECK (usd_cents > 0),
  credits INTEGER NOT NULL CHECK (credits > 0),
  status TEXT NOT NULL CHECK (status IN ('pending', 'paid', 'failed', 'refunded')),
  provider TEXT NOT NULL,
  provider_checkout_id TEXT,
  provider_order_id TEXT UNIQUE,
  checkout_url TEXT,
  created_at INTEGER NOT NULL,
  paid_at INTEGER,
  updated_at INTEGER NOT NULL
);

CREATE INDEX credit_checkout_orders_user_time_idx
  ON credit_checkout_orders(user_id, created_at DESC);
CREATE INDEX credit_checkout_orders_status_idx
  ON credit_checkout_orders(status, updated_at);

CREATE TABLE plugin_credit_prices (
  plugin_id TEXT PRIMARY KEY,
  price_credits INTEGER NOT NULL CHECK (price_credits > 0),
  active INTEGER NOT NULL DEFAULT 1 CHECK (active IN (0, 1)),
  updated_by TEXT REFERENCES users(id) ON DELETE SET NULL,
  updated_at INTEGER NOT NULL
);
