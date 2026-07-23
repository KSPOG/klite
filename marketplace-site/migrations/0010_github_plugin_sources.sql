PRAGMA foreign_keys = ON;

-- Raw Java source is staged in the private GitHub submission repository.
-- D1 stores immutable references and verification metadata; it never stores
-- developer source or GitHub credentials.
ALTER TABLE plugin_submission_artifacts
  ADD COLUMN storage_provider TEXT NOT NULL DEFAULT 'r2'
    CHECK (storage_provider IN ('r2', 'github'));
ALTER TABLE plugin_submission_artifacts ADD COLUMN source_repository TEXT;
ALTER TABLE plugin_submission_artifacts ADD COLUMN source_ref TEXT;
ALTER TABLE plugin_submission_artifacts ADD COLUMN source_commit TEXT;
ALTER TABLE plugin_submission_artifacts ADD COLUMN source_path TEXT;
ALTER TABLE plugin_submission_artifacts
  ADD COLUMN source_file_count INTEGER CHECK (
    source_file_count IS NULL OR
    (source_file_count > 0 AND source_file_count <= 100)
  );
ALTER TABLE plugin_submission_artifacts ADD COLUMN source_entrypoint TEXT;
ALTER TABLE plugin_submission_artifacts ADD COLUMN promoted_repository TEXT;
ALTER TABLE plugin_submission_artifacts ADD COLUMN promoted_ref TEXT;
ALTER TABLE plugin_submission_artifacts ADD COLUMN promoted_commit TEXT;
ALTER TABLE plugin_submission_artifacts ADD COLUMN promotion_pr_url TEXT;
ALTER TABLE plugin_submission_artifacts ADD COLUMN promoted_at INTEGER;

CREATE INDEX plugin_submission_artifacts_provider_idx
  ON plugin_submission_artifacts(storage_provider, uploaded_at);
