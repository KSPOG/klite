import assert from "node:assert/strict";
import { webcrypto } from "node:crypto";
import test from "node:test";

import {
  artifactDownloadHeaders,
  hasZipHeader,
  MAX_PLUGIN_ARTIFACT_BYTES,
  preparePluginArtifact,
  safeJarFilename,
  submissionArtifactObjectKey,
  validatePluginArtifactFile
} from "../worker/plugin-submission-artifacts.js";
import { handlePluginSubmissions } from "../worker/plugin-submissions.js";

globalThis.crypto ??= webcrypto;

test("accepts JAR uploads and derives a private content-addressed object key", async () => {
  const file = new File(
    [new Uint8Array([0x50, 0x4b, 0x03, 0x04, 1, 2, 3, 4])],
    "Copper Miner.jar",
    { type: "application/java-archive" }
  );
  const artifact = await preparePluginArtifact(file, {
    userId: "user-1",
    submissionId: "submission-1",
    pluginId: "copper-miner",
    version: "1.0.0"
  });

  assert.equal(artifact.error, undefined);
  assert.equal(artifact.filename, "Copper Miner.jar");
  assert.match(artifact.sha256, /^[a-f0-9]{64}$/);
  assert.equal(
    artifact.objectKey,
    `submissions/user-1/submission-1/${artifact.sha256}.jar`
  );
});

test("rejects non-JAR files, oversized files, and invalid archive headers", async () => {
  const textFile = new File(["not a jar"], "plugin.txt", { type: "text/plain" });
  assert.match(validatePluginArtifactFile(textFile), /\.jar/);

  const oversized = {
    name: "plugin.jar",
    size: MAX_PLUGIN_ARTIFACT_BYTES + 1,
    type: "application/java-archive",
    arrayBuffer: async () => new ArrayBuffer(0)
  };
  assert.match(validatePluginArtifactFile(oversized), /20 MiB/);

  const invalid = new File(
    [new Uint8Array([1, 2, 3, 4])],
    "plugin.jar",
    { type: "application/java-archive" }
  );
  assert.match((await preparePluginArtifact(invalid, {
    userId: "user",
    submissionId: "submission",
    pluginId: "plugin",
    version: "1.0.0"
  })).error, /valid JAR/);
  assert.equal(hasZipHeader(new Uint8Array([0x50, 0x4b, 0x03, 0x04])), true);
});

test("normalizes private object keys, filenames, and download headers", () => {
  assert.equal(
    submissionArtifactObjectKey("../user", "submission/1", "ab".repeat(32)),
    `submissions/user/submission1/${"ab".repeat(32)}.jar`
  );
  assert.equal(safeJarFilename("bad\r\nname.jar", "plugin", "1.0.0"), "bad--name.jar");
  const headers = artifactDownloadHeaders({
    original_filename: "plugin.jar",
    plugin_id: "plugin",
    version: "1.0.0",
    size: 42,
    sha256: "cd".repeat(32)
  });
  assert.equal(headers["content-type"], "application/java-archive");
  assert.equal(headers["content-length"], "42");
  assert.equal(headers["cache-control"], "private, no-store");
});

test("developer multipart submissions store the JAR before creating the review entry", async () => {
  const uploaded = [];
  const batches = [];
  const database = {
    prepare(sql) {
      return {
        bind(...values) {
          return {
            sql,
            values,
            async first() {
              return {
                id: values[0],
                plugin_id: "test-plugin",
                name: "Test Plugin",
                version: "1.2.3",
                source_url: "https://example.com/test-plugin",
                description: "A complete test plugin submission description.",
                status: "pending",
                submitted_at: 100,
                updated_at: 100,
                artifact_filename: "test-plugin.jar",
                artifact_sha256: "ab".repeat(32),
                artifact_size: 8,
                artifact_uploaded_at: 100
              };
            }
          };
        }
      };
    },
    async batch(statements) {
      batches.push(statements);
      return statements.map(() => ({ success: true }));
    }
  };
  const environment = {
    DB: database,
    PLUGIN_ARTIFACTS: {
      async put(key, bytes, options) {
        uploaded.push({ key, bytes, options });
      },
      async delete() {}
    }
  };
  const body = new FormData();
  body.set("pluginId", "test-plugin");
  body.set("name", "Test Plugin");
  body.set("version", "1.2.3");
  body.set("sourceUrl", "https://example.com/test-plugin");
  body.set("description", "A complete test plugin submission description.");
  body.set("artifact", new File(
    [new Uint8Array([0x50, 0x4b, 0x03, 0x04, 1, 2, 3, 4])],
    "test-plugin.jar",
    { type: "application/java-archive" }
  ));

  const response = await handlePluginSubmissions(
    new Request("https://example.com/api/developer/submissions", {
      method: "POST",
      body
    }),
    environment,
    new URL("https://example.com/api/developer/submissions"),
    dependencies()
  );

  assert.equal(response.status, 201);
  assert.equal(uploaded.length, 1);
  assert.match(uploaded[0].key, /^submissions\/user-1\/[a-f0-9-]+\/[a-f0-9]{64}\.jar$/);
  assert.equal(batches.length, 1);
  assert.equal(batches[0].length, 2);
  const payload = await response.json();
  assert.equal(payload.submission.artifact.filename, "test-plugin.jar");
});

function dependencies() {
  return {
    apiError(status, code, message) {
      return json({ error: { code, message } }, status);
    },
    isConstraintError: () => false,
    json,
    normalizePluginId: (value) => /^[a-z0-9][a-z0-9-]{2,63}$/.test(value) ? value : null,
    normalizeSourceUrl: (value) => value.startsWith("https://") ? value : null,
    normalizeText: (value, minimum, maximum) =>
      value.length >= minimum && value.length <= maximum ? value : null,
    normalizeVersion: (value) => /^\d+\.\d+\.\d+$/.test(value) ? value : null,
    nowSeconds: () => 100,
    readJson: async (request) => request.json(),
    requireCapability: async () => ({ user_id: "user-1" }),
    requireWebsiteRole: async () => ({ user_id: "reviewer-1" })
  };
}

function json(body, status = 200) {
  return new Response(JSON.stringify(body), {
    status,
    headers: { "content-type": "application/json" }
  });
}
