PRAGMA foreign_keys = ON;

ALTER TABLE discord_accounts ADD COLUMN plugin_dev_role INTEGER NOT NULL DEFAULT 0;
ALTER TABLE discord_accounts ADD COLUMN role_verified_at INTEGER;

CREATE TABLE user_roles (
  user_id TEXT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  role TEXT NOT NULL CHECK (role IN ('plugin_dev', 'marketplace_reviewer')),
  granted_by TEXT,
  granted_at INTEGER NOT NULL,
  PRIMARY KEY (user_id, role)
);
CREATE INDEX user_roles_role_idx ON user_roles(role, user_id);

CREATE TABLE plugin_submissions (
  id TEXT PRIMARY KEY,
  user_id TEXT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  plugin_id TEXT NOT NULL,
  name TEXT NOT NULL,
  version TEXT NOT NULL,
  source_url TEXT NOT NULL,
  description TEXT NOT NULL,
  status TEXT NOT NULL DEFAULT 'pending'
    CHECK (status IN ('pending', 'changes_requested', 'approved', 'rejected')),
  review_notes TEXT,
  reviewed_by TEXT REFERENCES users(id) ON DELETE SET NULL,
  submitted_at INTEGER NOT NULL,
  updated_at INTEGER NOT NULL,
  reviewed_at INTEGER,
  UNIQUE (user_id, plugin_id, version)
);
CREATE INDEX plugin_submissions_owner_idx
  ON plugin_submissions(user_id, updated_at DESC);
CREATE INDEX plugin_submissions_review_idx
  ON plugin_submissions(status, updated_at ASC);

CREATE TRIGGER plugin_submission_approved_immutable
BEFORE UPDATE OF plugin_id, name, version, source_url, description
ON plugin_submissions
WHEN OLD.status = 'approved'
BEGIN
  SELECT RAISE(ABORT, 'approved submissions are immutable');
END;

CREATE TRIGGER plugin_submission_review_reset
AFTER UPDATE OF plugin_id, name, version, source_url, description
ON plugin_submissions
WHEN OLD.status = 'changes_requested'
BEGIN
  UPDATE plugin_submissions
  SET status = 'pending', review_notes = NULL, reviewed_by = NULL, reviewed_at = NULL
  WHERE id = NEW.id;
END;
