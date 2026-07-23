PRAGMA foreign_keys = ON;

-- Unapproved developer uploads are held privately in R2. Reviewers receive
-- time-bound authenticated access through the website; these object keys are
-- never exposed as public marketplace assets.
CREATE TABLE plugin_submission_artifacts (
  submission_id TEXT PRIMARY KEY
    REFERENCES plugin_submissions(id) ON DELETE CASCADE,
  object_key TEXT NOT NULL UNIQUE,
  original_filename TEXT NOT NULL,
  content_type TEXT NOT NULL,
  sha256 TEXT NOT NULL CHECK (length(sha256) = 64),
  size INTEGER NOT NULL CHECK (size > 0 AND size <= 20971520),
  uploaded_at INTEGER NOT NULL
);

CREATE INDEX plugin_submission_artifacts_sha_idx
  ON plugin_submission_artifacts(sha256);

CREATE TRIGGER plugin_submission_artifact_approved_insert
BEFORE INSERT ON plugin_submission_artifacts
WHEN (SELECT status FROM plugin_submissions WHERE id = NEW.submission_id) = 'approved'
BEGIN
  SELECT RAISE(ABORT, 'approved submission artifacts are immutable');
END;

CREATE TRIGGER plugin_submission_artifact_approved_update
BEFORE UPDATE ON plugin_submission_artifacts
WHEN (SELECT status FROM plugin_submissions WHERE id = OLD.submission_id) = 'approved'
BEGIN
  SELECT RAISE(ABORT, 'approved submission artifacts are immutable');
END;

CREATE TRIGGER plugin_submission_artifact_approved_delete
BEFORE DELETE ON plugin_submission_artifacts
WHEN (SELECT status FROM plugin_submissions WHERE id = OLD.submission_id) = 'approved'
BEGIN
  SELECT RAISE(ABORT, 'approved submission artifacts are immutable');
END;
