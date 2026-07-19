import assert from "node:assert/strict";
import fs from "node:fs";
import path from "node:path";
import test from "node:test";
import { fileURLToPath } from "node:url";

const testDirectory = path.dirname(fileURLToPath(import.meta.url));
const repositoryRoot = path.resolve(testDirectory, "..", "..");

function read(relativePath) {
  return fs.readFileSync(path.join(repositoryRoot, relativePath), "utf8");
}

test("public API source bundle follows the documented API surface", () => {
  const builder = read("plugin-sdk/build_api_sources.py");
  assert.match(builder, /KLite-Public-API-Sources\.zip/);
  assert.match(builder, /api-reference\.generated\.js/);
  assert.match(builder, /\("Client API", "api"\)/);
  assert.match(builder, /\("Automation runtime", "automation"\)/);
  assert.match(builder, /\("Web walker", "walker"\)/);
  assert.match(builder, /select_documented_types/);
  assert.match(builder, /Documented API types have no matching Java source/);
});

test("the rolling SDK release publishes and verifies the source ZIP", () => {
  const workflow = read(".github/workflows/publish-public-api-sources.yml");
  assert.match(workflow, /Publish KLite Plugin SDK/);
  assert.match(workflow, /gh release upload plugin-sdk "\$SOURCE_ZIP" --clobber/);
  assert.match(workflow, /gh release download plugin-sdk/);
  assert.match(workflow, /cmp \\\n\s+dist\/plugin-sdk\/KLite-Public-API-Sources\.zip/);
});
