import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import path from "node:path";
import test from "node:test";
import { fileURLToPath } from "node:url";

const testDirectory = path.dirname(fileURLToPath(import.meta.url));
const siteDirectory = path.resolve(testDirectory, "..");

test("developer dashboard contains the private raw Java source workflow", async () => {
  const [html, app, stylesheet] = await Promise.all([
    readFile(path.join(siteDirectory, "public/index.html"), "utf8"),
    readFile(path.join(siteDirectory, "public/app.js"), "utf8"),
    readFile(path.join(siteDirectory, "public/home.css"), "utf8")
  ]);

  assert.match(html, /id="submission-sources"[^>]+type="file"[^>]+accept="\.java/);
  assert.match(html, /multiple required/);
  assert.match(html, /Upload source for review/);
  assert.match(app, /new FormData\(\)/);
  assert.match(app, /Review raw source on GitHub/);
  assert.match(app, /\/api\/\$\{scope\}\/submissions\/\$\{submission\.id\}\/source/);
  assert.match(app, /body\.append\("sources"/);
  assert.match(stylesheet, /\.plugin-upload-field/);
  assert.match(stylesheet, /\.submission-artifact/);
});
