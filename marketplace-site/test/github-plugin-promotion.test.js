import assert from "node:assert/strict";
import { webcrypto } from "node:crypto";
import test from "node:test";

import { promotePluginSource } from "../worker/github-plugin-repository.js";
import { preparePluginSource } from "../worker/plugin-submission-source.js";

globalThis.crypto ??= webcrypto;

test("revalidates private source and creates a review PR in the main repository", async () => {
  const source = `
package com.example;
@PluginDescriptor(name = "Example")
public class ExamplePlugin extends Plugin {}
`.trimStart();
  const bundle = await preparePluginSource([
    new File([source], "ExamplePlugin.java", { type: "text/plain" })
  ]);
  const manifest = {
    schemaVersion: 1,
    submissionId: "submission-1",
    userId: "developer-1",
    pluginId: "example-plugin",
    name: "Example Plugin",
    version: "1.0.0",
    sourceUrl: "https://example.com/source",
    description: "A complete source submission used for promotion testing.",
    entrypoint: bundle.entrypoint,
    sha256: bundle.sha256,
    size: bundle.size,
    files: bundle.files.map((file) => ({ path: file.path, size: file.size }))
  };
  const artifact = {
    submission_id: "submission-1",
    object_key: "submissions/submission-1/submission.json",
    sha256: bundle.sha256,
    size: bundle.size,
    source_file_count: bundle.fileCount,
    source_repository: "KSPOG/klite-plugin-submissions",
    source_ref: "main",
    source_commit: "private-commit",
    source_path: "submissions/submission-1"
  };
  const submission = {
    ...artifact,
    id: "submission-1",
    plugin_id: "example-plugin",
    name: "Example Plugin",
    version: "1.0.0"
  };

  const originalFetch = globalThis.fetch;
  const calls = [];
  const blobs = new Map();
  let blobNumber = 0;
  globalThis.fetch = async (url, options = {}) => {
    const parsed = new URL(url);
    const method = options.method || "GET";
    const body = options.body ? JSON.parse(options.body) : null;
    calls.push({ method, path: parsed.pathname, search: parsed.search, body });

    if (method === "GET" && parsed.pathname.endsWith(
      "/contents/submissions/submission-1/submission.json"
    )) {
      assert.equal(parsed.searchParams.get("ref"), "private-commit");
      return githubResponse({
        type: "file",
        encoding: "base64",
        content: encodeText(`${JSON.stringify(manifest)}\n`)
      });
    }
    if (method === "GET" && parsed.pathname.endsWith(
      "/contents/submissions/submission-1/src/main/java/com/example/ExamplePlugin.java"
    )) {
      assert.equal(parsed.searchParams.get("ref"), "private-commit");
      return githubResponse({
        type: "file",
        encoding: "base64",
        content: encodeText(source)
      });
    }
    if (method === "GET" && parsed.pathname.endsWith("/contents/settings.gradle.kts")) {
      return githubResponse({
        type: "file",
        encoding: "base64",
        content: encodeText('rootProject.name = "runelite"\n')
      });
    }
    if (method === "GET" && parsed.pathname.endsWith("/git/ref/heads/main")) {
      return githubResponse({ object: { sha: "main-commit" } });
    }
    if (method === "GET" && parsed.pathname.endsWith("/git/commits/main-commit")) {
      return githubResponse({ sha: "main-commit", tree: { sha: "main-tree" } });
    }
    if (method === "POST" && parsed.pathname.endsWith("/git/blobs")) {
      blobNumber += 1;
      const sha = `blob-${blobNumber}`;
      blobs.set(sha, body.content);
      return githubResponse({ sha }, 201);
    }
    if (method === "POST" && parsed.pathname.endsWith("/git/trees")) {
      return githubResponse({ sha: "promotion-tree" }, 201);
    }
    if (method === "POST" && parsed.pathname.endsWith("/git/commits")) {
      return githubResponse({ sha: "promotion-commit" }, 201);
    }
    if (method === "POST" && parsed.pathname.endsWith("/git/refs")) {
      return githubResponse({ object: { sha: "promotion-commit" } }, 201);
    }
    if (method === "POST" && parsed.pathname.endsWith("/pulls")) {
      return githubResponse({
        number: 42,
        html_url: "https://github.com/KSPOG/klite/pull/42"
      }, 201);
    }
    return githubResponse({ message: "unexpected request" }, 500);
  };

  try {
    const promotion = await promotePluginSource({
      GITHUB_SUBMISSIONS_TOKEN: "private-test-token",
      GITHUB_PROMOTION_TOKEN: "main-test-token",
      GITHUB_SUBMISSIONS_REPOSITORY: "KSPOG/klite-plugin-submissions",
      GITHUB_MAIN_REPOSITORY: "KSPOG/klite"
    }, submission, artifact);

    assert.equal(promotion.commitSha, "promotion-commit");
    assert.equal(promotion.pullRequestNumber, 42);
    const treeCall = calls.find((call) =>
      call.method === "POST" && call.path.endsWith("/git/trees"));
    assert.deepEqual(treeCall.body.tree.map((entry) => entry.path), [
      "plugins/example-plugin/src/main/java/com/example/ExamplePlugin.java",
      "plugins/example-plugin/build.gradle.kts",
      "plugins/example-plugin/KLITE_SUBMISSION.json",
      "settings.gradle.kts"
    ]);
    const settingsEntry = treeCall.body.tree.find((entry) =>
      entry.path === "settings.gradle.kts");
    assert.match(decodeText(blobs.get(settingsEntry.sha)), /community-example-plugin/);
    const pullCall = calls.find((call) =>
      call.method === "POST" && call.path.endsWith("/pulls"));
    assert.equal(pullCall.body.base, "main");
    assert.match(pullCall.body.body, new RegExp(bundle.sha256));
  } finally {
    globalThis.fetch = originalFetch;
  }
});

function encodeText(value) {
  return Buffer.from(value, "utf8").toString("base64");
}

function decodeText(value) {
  return Buffer.from(value, "base64").toString("utf8");
}

function githubResponse(body, status = 200) {
  return new Response(JSON.stringify(body), {
    status,
    headers: { "content-type": "application/json" }
  });
}
