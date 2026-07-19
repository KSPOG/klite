import assert from "node:assert/strict";
import fs from "node:fs";
import path from "node:path";
import test from "node:test";
import { fileURLToPath } from "node:url";

const directory = path.dirname(fileURLToPath(import.meta.url));
const siteRoot = path.resolve(directory, "..");

function read(relativePath) {
  return fs.readFileSync(path.join(siteRoot, relativePath), "utf8");
}

test("website controls use the configured site owner recovery key", () => {
  const entry = read("worker/entry.js");
  const example = read(".dev.vars.example");
  assert.match(example, /SITE_OWNER_RECOVERY_KEY=/);
  assert.match(entry, /SITE_OWNER_RECOVERY_KEY/);
  assert.match(entry, /OWNER_RECOVERY_KEY/);
  assert.match(entry, /new Proxy\(env/);
});
