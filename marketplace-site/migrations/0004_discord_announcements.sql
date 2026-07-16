PRAGMA foreign_keys = ON;

CREATE TABLE discord_announcement_settings (
  id INTEGER PRIMARY KEY CHECK (id = 1),
  channel_id TEXT NOT NULL CHECK (length(channel_id) BETWEEN 17 AND 20),
  enabled INTEGER NOT NULL DEFAULT 1 CHECK (enabled IN (0, 1)),
  configured_by TEXT NOT NULL REFERENCES users(id),
  configured_at INTEGER NOT NULL,
  updated_at INTEGER NOT NULL
);

CREATE TABLE plugin_announcement_state (
  plugin_id TEXT PRIMARY KEY,
  announced_version TEXT NOT NULL,
  announced_updated_at TEXT NOT NULL,
  message_id TEXT,
  announced_at INTEGER NOT NULL
);

CREATE TABLE plugin_announcement_log (
  id TEXT PRIMARY KEY,
  plugin_id TEXT NOT NULL,
  version TEXT NOT NULL,
  event_type TEXT NOT NULL CHECK (event_type IN ('new', 'update')),
  channel_id TEXT NOT NULL,
  message_id TEXT NOT NULL,
  announced_by TEXT,
  announced_at INTEGER NOT NULL
);
CREATE INDEX plugin_announcement_log_time_idx
  ON plugin_announcement_log(announced_at DESC);
