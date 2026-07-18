const fs = require("node:fs");
const path = require("node:path");
const test = require("node:test");
const assert = require("node:assert/strict");

const repositoryRoot = path.resolve(__dirname, "..", "..");

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
  assert.match(builder, /verify_reference_parity/);
});

test("the rolling SDK release publishes and verifies the source ZIP", () => {
  const workflow = read(".github/workflows/publish-public-api-sources.yml");
  assert.match(workflow, /Publish KLite Plugin SDK/);
  assert.match(workflow, /gh release upload plugin-sdk "\$SOURCE_ZIP" --clobber/);
  assert.match(workflow, /gh release download plugin-sdk/);
  assert.match(workflow, /cmp \\\n\s+dist\/plugin-sdk\/KLite-Public-API-Sources\.zip/);
});
