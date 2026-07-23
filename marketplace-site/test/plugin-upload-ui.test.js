import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import path from "node:path";
import test from "node:test";
import { fileURLToPath } from "node:url";

const testDirectory = path.dirname(fileURLToPath(import.meta.url));
const siteDirectory = path.resolve(testDirectory, "..");

test("developer dashboard contains the private plugin JAR upload workflow", async () => {
  const [html, app, stylesheet] = await Promise.all([
    readFile(path.join(siteDirectory, "public/index.html"), "utf8"),
    readFile(path.join(siteDirectory, "public/app.js"), "utf8"),
    readFile(path.join(siteDirectory, "public/home.css"), "utf8")
  ]);

  assert.match(html, /id="submission-artifact"[^>]+type="file"[^>]+accept="\.jar/);
  assert.match(html, /Upload and submit for review/);
  assert.match(html, /stored privately/);
  assert.match(app, /new FormData\(\)/);
  assert.match(app, /Download JAR for review/);
  assert.match(app, /\/api\/\$\{scope\}\/submissions\/\$\{submission\.id\}\/artifact/);
  assert.match(stylesheet, /\.plugin-upload-field/);
  assert.match(stylesheet, /\.submission-artifact/);
});
