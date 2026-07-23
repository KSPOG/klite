import assert from "node:assert/strict";
import test from "node:test";

import { handlePluginSubmissions } from "../worker/plugin-submissions.js";

test("reviewers cannot approve a submission without an uploaded JAR", async () => {
  let updates = 0;
  const environment = {
    DB: {
      prepare(sql) {
        return {
          bind() {
            return {
              async first() {
                return null;
              },
              async run() {
                updates += 1;
                return { meta: { changes: 1 } };
              }
            };
          }
        };
      }
    }
  };
  const response = await handlePluginSubmissions(
    new Request("https://example.com/api/review/submissions/a0000000-0000-0000-0000-000000000001/decision", {
      method: "POST",
      headers: { "content-type": "application/json" },
      body: JSON.stringify({ decision: "approved", notes: "" })
    }),
    environment,
    new URL("https://example.com/api/review/submissions/a0000000-0000-0000-0000-000000000001/decision"),
    dependencies()
  );

  assert.equal(response.status, 409);
  assert.equal(updates, 0);
  const payload = await response.json();
  assert.equal(payload.error.code, "plugin_artifact_required");
});

test("review artifact downloads are authenticated and never publicly cached", async () => {
  const bytes = new Uint8Array([0x50, 0x4b, 0x03, 0x04]);
  const artifact = {
    plugin_id: "test-plugin",
    version: "1.0.0",
    object_key: "submissions/user/submission/hash.jar",
    original_filename: "test-plugin.jar",
    sha256: "ab".repeat(32),
    size: bytes.byteLength
  };
  const environment = {
    DB: {
      prepare() {
        return {
          bind() {
            return { first: async () => artifact };
          }
        };
      }
    },
    PLUGIN_ARTIFACTS: {
      get: async (key) => key === artifact.object_key
        ? { body: bytes, size: bytes.byteLength }
        : null
    }
  };
  const response = await handlePluginSubmissions(
    new Request("https://example.com/api/review/submissions/a0000000-0000-0000-0000-000000000001/artifact"),
    environment,
    new URL("https://example.com/api/review/submissions/a0000000-0000-0000-0000-000000000001/artifact"),
    dependencies()
  );

  assert.equal(response.status, 200);
  assert.equal(response.headers.get("cache-control"), "private, no-store");
  assert.equal(response.headers.get("x-klite-artifact-sha256"), artifact.sha256);
  assert.deepEqual(new Uint8Array(await response.arrayBuffer()), bytes);
});

function dependencies() {
  return {
    apiError(status, code, message) {
      return json({ error: { code, message } }, status);
    },
    json,
    nowSeconds: () => 100,
    readJson: async (request) => request.json(),
    requireCapability: async () => ({ user_id: "developer-1" }),
    requireWebsiteRole: async () => ({ user_id: "reviewer-1" })
  };
}

function json(body, status = 200) {
  return new Response(JSON.stringify(body), {
    status,
    headers: { "content-type": "application/json" }
  });
}
