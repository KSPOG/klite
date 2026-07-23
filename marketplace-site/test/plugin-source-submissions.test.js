import assert from "node:assert/strict";
import { webcrypto } from "node:crypto";
import test from "node:test";

import {
  MAX_PLUGIN_SOURCE_FILE_BYTES,
  preparePluginSource,
  validatePluginSourceFile
} from "../worker/plugin-submission-source.js";
import {
  GitHubRepositoryError,
  hasGitHubSubmissionStorage,
  storePluginSource
} from "../worker/github-plugin-repository.js";

globalThis.crypto ??= webcrypto;

test("validates raw Java classes and derives package paths and entrypoint", async () => {
  const plugin = javaFile("ExamplePlugin.java", `
package com.example.klite;

import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(name = "Example")
public final class ExamplePlugin extends Plugin {}
`);
  const task = javaFile("ExampleTask.java", `
package com.example.klite.tasks;

public final class ExampleTask {}
`);

  const bundle = await preparePluginSource([task, plugin]);

  assert.equal(bundle.error, undefined);
  assert.equal(bundle.fileCount, 2);
  assert.equal(bundle.entrypoint, "com.example.klite.ExamplePlugin");
  assert.deepEqual(bundle.files.map((file) => file.path), [
    "src/main/java/com/example/klite/ExamplePlugin.java",
    "src/main/java/com/example/klite/tasks/ExampleTask.java"
  ]);
  assert.match(bundle.sha256, /^[a-f0-9]{64}$/);
});

test("rejects invalid Java source collections before repository access", async () => {
  assert.match(validatePluginSourceFile(
    new File(["text"], "plugin.txt", { type: "text/plain" })
  ), /\.java/);
  assert.match(validatePluginSourceFile({
    name: "Plugin.java",
    size: MAX_PLUGIN_SOURCE_FILE_BYTES + 1,
    type: "text/plain",
    arrayBuffer: async () => new ArrayBuffer(0)
  }), /1 MiB/);

  const noPackage = javaFile("Plugin.java",
    "@PluginDescriptor(name=\"x\") class Plugin extends net.runelite.client.plugins.Plugin {}");
  assert.match((await preparePluginSource([noPackage])).error, /declare a Java package/);

  const noEntrypoint = javaFile("Helper.java",
    "package com.example; public final class Helper {}");
  assert.match((await preparePluginSource([noEntrypoint])).error, /@PluginDescriptor/);
});

test("commits a complete source submission atomically to the private repository", async () => {
  const originalFetch = globalThis.fetch;
  const calls = [];
  let blob = 0;
  globalThis.fetch = async (url, options = {}) => {
    const method = options.method || "GET";
    const path = new URL(url).pathname;
    calls.push({ method, path, body: options.body ? JSON.parse(options.body) : null });
    if (method === "GET" && path.endsWith("/git/ref/heads/main")) {
      return githubResponse({ object: { sha: "base-commit" } });
    }
    if (method === "GET" && path.endsWith("/git/commits/base-commit")) {
      return githubResponse({ sha: "base-commit", tree: { sha: "base-tree" } });
    }
    if (method === "POST" && path.endsWith("/git/blobs")) {
      blob += 1;
      return githubResponse({ sha: `blob-${blob}` }, 201);
    }
    if (method === "POST" && path.endsWith("/git/trees")) {
      return githubResponse({ sha: "submission-tree" }, 201);
    }
    if (method === "POST" && path.endsWith("/git/commits")) {
      return githubResponse({ sha: "submission-commit" }, 201);
    }
    if (method === "PATCH" && path.endsWith("/git/refs/heads/main")) {
      return githubResponse({ object: { sha: "submission-commit" } });
    }
    return githubResponse({ message: "unexpected" }, 500);
  };

  try {
    const bundle = await preparePluginSource([javaFile("ExamplePlugin.java", `
package com.example;
@PluginDescriptor(name = "Example")
public class ExamplePlugin extends Plugin {}
`)]);
    const stored = await storePluginSource({
      GITHUB_SUBMISSIONS_TOKEN: "test-token",
      GITHUB_SUBMISSIONS_REPOSITORY: "KSPOG/klite-plugin-submissions"
    }, {
      id: "submission-1",
      userId: "user-1",
      pluginId: "example-plugin",
      name: "Example Plugin",
      version: "1.0.0",
      sourceUrl: "https://example.com/source",
      description: "A complete source submission used for testing."
    }, bundle);

    assert.equal(stored.repository, "KSPOG/klite-plugin-submissions");
    assert.equal(stored.commitSha, "submission-commit");
    assert.equal(stored.manifestPath, "submissions/submission-1/submission.json");
    const treeCall = calls.find((call) => call.path.endsWith("/git/trees"));
    assert.deepEqual(treeCall.body.tree.map((entry) => entry.path), [
      "submissions/submission-1/src/main/java/com/example/ExamplePlugin.java",
      "submissions/submission-1/submission.json"
    ]);
    assert.equal(calls.at(-1).method, "PATCH");
  } finally {
    globalThis.fetch = originalFetch;
  }
});

test("requires a configured private repository token", async () => {
  assert.equal(hasGitHubSubmissionStorage({}), false);
  await assert.rejects(
    storePluginSource({}, { id: "submission" }, { files: [] }),
    (error) =>
      error instanceof GitHubRepositoryError
      && error.code === "plugin_storage_unavailable"
  );
});

function javaFile(name, source) {
  return new File([source.trimStart()], name, { type: "text/plain" });
}

function githubResponse(body, status = 200) {
  return new Response(JSON.stringify(body), {
    status,
    headers: { "content-type": "application/json" }
  });
}
