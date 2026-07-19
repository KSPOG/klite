import assert from "node:assert/strict";
import fs from "node:fs";
import path from "node:path";
import test from "node:test";
import { fileURLToPath } from "node:url";

const directory = path.dirname(fileURLToPath(import.meta.url));
const siteRoot = path.resolve(directory, "..");
const migration = fs.readFileSync(
  path.join(siteRoot, "migrations/0009_password_reset.sql"), "utf8"
);

test("password recovery migration creates state and one-time token storage", () => {
  assert.match(migration, /CREATE TABLE password_reset_states/);
  assert.match(migration, /CREATE TABLE password_reset_tokens/);
  assert.match(migration, /consumed_at INTEGER/);
  assert.match(migration, /REFERENCES users\(id\) ON DELETE CASCADE/);
});
