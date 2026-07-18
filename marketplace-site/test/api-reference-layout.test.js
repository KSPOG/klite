import fs from "node:fs";
import path from "node:path";
import test from "node:test";
import assert from "node:assert/strict";
import { fileURLToPath } from "node:url";

const testDirectory = path.dirname(fileURLToPath(import.meta.url));
const siteRoot = path.resolve(testDirectory, "..");

function read(relativePath) {
  return fs.readFileSync(path.join(siteRoot, relativePath), "utf8");
}

test("API page loads its dedicated responsive reference stylesheet", () => {
  const html = read("public/api/index.html");
  const css = read("public/api-reference.css");

  assert.match(html, /href="api\.css\?v=20260718-1"/);
  assert.match(css, /\.api-type\s*>\s*summary\s*\{/);
  assert.match(css, /grid-template-columns:\s*minmax\(0, 1fr\) auto/);
  assert.match(css, /\.api-type-title-copy\s*\{/);
  assert.match(css, /\.api-type-badges\s*\{/);
  assert.match(css, /@media \(max-width: 720px\)/);
});

test("API browser exposes working expand, collapse, and reset controls", () => {
  const html = read("public/api/index.html");
  const controls = read("public/api/controls.js");

  assert.match(html, /id="api-expand-all"/);
  assert.match(html, /id="api-collapse-all"/);
  assert.match(html, /id="api-reset-filters"/);
  assert.match(html, /src="controls\.js\?v=1"/);
  assert.match(controls, /details\.api-type/);
  assert.match(controls, /sectionFilter\.value = "Client API"/);
  assert.doesNotThrow(() => new Function(controls));
});

test("API page links the downloadable public API source bundle", () => {
  const html = read("public/api/index.html");
  assert.match(
    html,
    /releases\/download\/plugin-sdk\/KLite-Public-API-Sources\.zip/
  );
});

test("Cloudflare serves API page files before dynamic API routes", () => {
  const worker = read("worker/entry.js");
  const configuration = read("wrangler.jsonc");

  assert.match(configuration, /"run_worker_first": \["\/api", "\/api\/\*"\]/);
  assert.match(worker, /const API_PAGE_ASSETS = new Set/);
  assert.match(worker, /const API_REFERENCE_STYLESHEET = "\/api-reference\.css"/);
  assert.match(worker, /url\.pathname === "\/api\/api\.css"/);
  assert.match(worker, /assetUrl\.pathname = API_REFERENCE_STYLESHEET/);
  assert.match(worker, /env\.ASSETS\.fetch\(new Request\(assetUrl, request\)\)/);
  assert.match(worker, /"\/api\/app\.js"/);
  assert.match(worker, /"\/api\/controls\.js"/);
  assert.match(worker, /url\.pathname === "\/api"/);
  assert.match(worker, /target\.pathname = "\/api\/"/);
  assert.match(worker, /return env\.ASSETS\.fetch\(request\)/);
});
