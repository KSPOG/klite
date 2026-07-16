PRAGMA foreign_keys = ON;

CREATE TABLE users (
  id TEXT PRIMARY KEY,
  email TEXT NOT NULL COLLATE NOCASE UNIQUE,
  username TEXT NOT NULL COLLATE NOCASE UNIQUE,
  password_hash TEXT NOT NULL,
  created_at INTEGER NOT NULL,
  updated_at INTEGER NOT NULL
);

CREATE TABLE sessions (
  token_hash TEXT PRIMARY KEY,
  user_id TEXT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  kind TEXT NOT NULL CHECK (kind IN ('web', 'client')),
  created_at INTEGER NOT NULL,
  expires_at INTEGER NOT NULL,
  last_used_at INTEGER NOT NULL
);
CREATE INDEX sessions_user_id_idx ON sessions(user_id);
CREATE INDEX sessions_expires_at_idx ON sessions(expires_at);

CREATE TABLE discord_accounts (
  user_id TEXT PRIMARY KEY REFERENCES users(id) ON DELETE CASCADE,
  discord_id TEXT NOT NULL UNIQUE,
  username TEXT NOT NULL,
  global_name TEXT,
  avatar TEXT,
  linked_at INTEGER NOT NULL
);

CREATE TABLE discord_oauth_states (
  state_hash TEXT PRIMARY KEY,
  user_id TEXT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  expires_at INTEGER NOT NULL
);

CREATE TABLE discord_link_codes (
  code_hash TEXT PRIMARY KEY,
  user_id TEXT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  expires_at INTEGER NOT NULL,
  consumed_at INTEGER
);
CREATE INDEX discord_link_codes_user_id_idx ON discord_link_codes(user_id);

CREATE TABLE plugin_entitlements (
  user_id TEXT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  plugin_id TEXT NOT NULL,
  access_level TEXT NOT NULL DEFAULT 'paid',
  granted_at INTEGER NOT NULL,
  expires_at INTEGER,
  revoked_at INTEGER,
  PRIMARY KEY (user_id, plugin_id)
);
CREATE INDEX plugin_entitlements_active_idx
  ON plugin_entitlements(user_id, revoked_at, expires_at);

CREATE TABLE auth_attempts (
  identity_hash TEXT NOT NULL,
  attempted_at INTEGER NOT NULL
);
CREATE INDEX auth_attempts_identity_time_idx ON auth_attempts(identity_hash, attempted_at);
