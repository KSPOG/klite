PRAGMA foreign_keys = ON;

CREATE TABLE discord_login_states (
  state_hash TEXT PRIMARY KEY,
  flow TEXT NOT NULL CHECK (flow IN ('web', 'client')),
  client_redirect_uri TEXT,
  code_challenge TEXT,
  expires_at INTEGER NOT NULL
);
CREATE INDEX discord_login_states_expires_at_idx
  ON discord_login_states(expires_at);

CREATE TABLE discord_client_login_codes (
  code_hash TEXT PRIMARY KEY,
  state_hash TEXT NOT NULL REFERENCES discord_login_states(state_hash) ON DELETE CASCADE,
  user_id TEXT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  expires_at INTEGER NOT NULL,
  consumed_at INTEGER
);
CREATE INDEX discord_client_login_codes_state_idx
  ON discord_client_login_codes(state_hash);
CREATE INDEX discord_client_login_codes_expires_at_idx
  ON discord_client_login_codes(expires_at);
