PRAGMA foreign_keys = ON;

CREATE TABLE password_reset_states (
  state_hash TEXT PRIMARY KEY,
  user_id TEXT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  expires_at INTEGER NOT NULL
);

CREATE INDEX password_reset_states_expires_idx
  ON password_reset_states(expires_at);

CREATE TABLE password_reset_tokens (
  token_hash TEXT PRIMARY KEY,
  user_id TEXT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  expires_at INTEGER NOT NULL,
  consumed_at INTEGER
);

CREATE INDEX password_reset_tokens_expires_idx
  ON password_reset_tokens(expires_at);
