PRAGMA foreign_keys = ON;

CREATE TABLE discord_client_update_settings (
  id INTEGER PRIMARY KEY CHECK (id = 1),
  channel_id TEXT CHECK (channel_id IS NULL OR length(channel_id) BETWEEN 17 AND 20),
  role_id TEXT CHECK (role_id IS NULL OR length(role_id) BETWEEN 17 AND 20),
  enabled INTEGER NOT NULL DEFAULT 0 CHECK (enabled IN (0, 1)),
  updated_by TEXT NOT NULL REFERENCES users(id),
  updated_at INTEGER NOT NULL
);

CREATE TABLE discord_client_update_log (
  id TEXT PRIMARY KEY,
  version TEXT NOT NULL,
  updates_text TEXT NOT NULL,
  channel_id TEXT NOT NULL,
  role_id TEXT,
  message_id TEXT NOT NULL,
  posted_by TEXT NOT NULL REFERENCES users(id),
  posted_at INTEGER NOT NULL
);

CREATE INDEX discord_client_update_log_posted_at_idx
  ON discord_client_update_log(posted_at DESC);
