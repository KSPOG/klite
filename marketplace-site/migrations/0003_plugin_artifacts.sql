PRAGMA foreign_keys = ON;

-- Only reviewed, immutable artifacts are referenced here. Binary bytes live in
-- the private PLUGIN_ARTIFACTS R2 bucket and are never exposed as static assets.
CREATE TABLE plugin_artifacts (
  plugin_id TEXT NOT NULL,
  version TEXT NOT NULL,
  object_key TEXT NOT NULL UNIQUE,
  sha256 TEXT NOT NULL CHECK (length(sha256) = 64),
  size INTEGER NOT NULL CHECK (size > 0 AND size <= 20971520),
  access_type TEXT NOT NULL CHECK (access_type IN ('Public', 'Free', 'Supporter', 'Premium')),
  published_at INTEGER NOT NULL,
  revoked_at INTEGER,
  PRIMARY KEY (plugin_id, version)
);

CREATE INDEX plugin_artifacts_current_idx
  ON plugin_artifacts(plugin_id, revoked_at, published_at DESC);
