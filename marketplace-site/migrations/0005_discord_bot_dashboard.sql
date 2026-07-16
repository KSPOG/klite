PRAGMA foreign_keys = ON;

CREATE TABLE discord_bot_settings (
  id INTEGER PRIMARY KEY CHECK (id = 1),
  dev_role_id TEXT NOT NULL CHECK (length(dev_role_id) BETWEEN 17 AND 20),
  plugin_dev_role_id TEXT CHECK (plugin_dev_role_id IS NULL OR length(plugin_dev_role_id) BETWEEN 17 AND 20),
  marketplace_reviewer_role_id TEXT CHECK (marketplace_reviewer_role_id IS NULL OR length(marketplace_reviewer_role_id) BETWEEN 17 AND 20),
  member_role_id TEXT CHECK (member_role_id IS NULL OR length(member_role_id) BETWEEN 17 AND 20),
  audit_channel_id TEXT CHECK (audit_channel_id IS NULL OR length(audit_channel_id) BETWEEN 17 AND 20),
  welcome_channel_id TEXT CHECK (welcome_channel_id IS NULL OR length(welcome_channel_id) BETWEEN 17 AND 20),
  bot_enabled INTEGER NOT NULL DEFAULT 1 CHECK (bot_enabled IN (0, 1)),
  auto_assign_member_role INTEGER NOT NULL DEFAULT 0 CHECK (auto_assign_member_role IN (0, 1)),
  updated_by TEXT NOT NULL REFERENCES users(id),
  updated_at INTEGER NOT NULL
);
