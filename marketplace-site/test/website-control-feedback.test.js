import assert from "node:assert/strict";
import fs from "node:fs";
import path from "node:path";
import test from "node:test";
import { fileURLToPath } from "node:url";

const directory = path.dirname(fileURLToPath(import.meta.url));
const siteRoot = path.resolve(directory, "..");
const read = (relative) => fs.readFileSync(path.join(siteRoot, relative), "utf8");

test("account controls expose visible loading and failure feedback", () => {
  const source = read("public/website-control-fixes.js");
  for (const selector of [
    "#discord-oauth-button",
    "#discord-code-button",
    "#sign-out-button"
  ]) {
    assert.match(source, new RegExp(selector));
  }
  assert.match(source, /unhandledrejection/);
  assert.match(source, /aria-busy/);
  assert.match(source, /website-control-notice/);
  assert.match(source, /removeLegacyAuthSurface/);
  assert.doesNotMatch(source, /recover-account-button/);
});

test("credit administration keeps authorization errors visible", () => {
  const source = read("public/credits-admin.js");
  assert.doesNotMatch(source, /error\.status === 403\) panel\.remove/);
  assert.match(source, /KLite owner access was not accepted/);
  assert.match(source, /credit-admin-refresh/);
});
