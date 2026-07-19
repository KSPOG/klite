import assert from "node:assert/strict";
import fs from "node:fs";
import path from "node:path";
import test from "node:test";
import { fileURLToPath } from "node:url";

const directory = path.dirname(fileURLToPath(import.meta.url));
const siteRoot = path.resolve(directory, "..");
const audit = fs.readFileSync(path.join(siteRoot, "README-control-audit.md"), "utf8");

test("website audit documents fixed and verified control areas", () => {
  assert.match(audit, /Owner account and role-management routes/i);
  assert.match(audit, /Discord-only authentication/i);
  assert.doesNotMatch(audit, /password recovery/i);
  assert.match(audit, /API-reference search/i);
  assert.match(audit, /Changelog category filters/i);
});
