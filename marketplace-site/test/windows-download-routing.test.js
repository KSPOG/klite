import assert from "node:assert/strict";
import { access, readFile } from "node:fs/promises";
import path from "node:path";
import test from "node:test";
import { fileURLToPath } from "node:url";

import { onRequest } from "../functions/download/windows.js";

const testDirectory = path.dirname(fileURLToPath(import.meta.url));
const siteDirectory = path.resolve(testDirectory, "..");

const manifest = {
  schemaVersion: 1,
  platform: "windows-x64",
  version: "1.0.91",
  buildSha: "a".repeat(40),
  downloadUrl: "https://klite-marketplace.pages.dev/download/windows",
  assetName: `KLite-Setup-1.0.91-${"b".repeat(16)}.exe`,
  sha256: "b".repeat(64),
  size: 123456,
  launcher: "KLiteLauncher.exe",
};

test("Pages does not bypass the verified Windows download function", async () => {
  const redirectsPath = path.join(siteDirectory, "public", "_redirects");
  let redirects = "";
  try {
    await access(redirectsPath);
    redirects = await readFile(redirectsPath, "utf8");
  } catch (error) {
    assert.equal(error.code, "ENOENT");
  }
  assert.doesNotMatch(redirects, /^\/download\/windows\/?\s/m);
});

test("updater HEAD requests expose the verified installer metadata", async (t) => {
  const originalFetch = globalThis.fetch;
  t.after(() => { globalThis.fetch = originalFetch; });
  globalThis.fetch = async () => Response.json(manifest);
  const response = await onRequest({
    request: new Request("https://klite-marketplace.pages.dev/download/windows", { method: "HEAD" }),
  });
  assert.equal(response.status, 200);
  assert.equal(response.headers.get("x-klite-installer-asset"), manifest.assetName);
  assert.equal(response.headers.get("x-klite-installer-sha256"), manifest.sha256);
  assert.equal(response.headers.get("content-length"), String(manifest.size));
});

test("browser downloads still redirect to the rolling launcher installer", async () => {
  const response = await onRequest({
    request: new Request("https://klite-marketplace.pages.dev/download/windows?browser=1"),
  });
  assert.equal(response.status, 302);
  assert.equal(response.headers.get("location"),
    "https://github.com/KSPOG/klite/releases/download/windows-client/KLite-Setup.exe");
});
