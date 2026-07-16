import assert from "node:assert/strict";
import { webcrypto } from "node:crypto";
import test from "node:test";

globalThis.crypto ??= webcrypto;

const {
  hashPassword,
  normalizeEmail,
  normalizeUsername,
  normalizePluginId,
  normalizeSourceUrl,
  normalizeVersion,
  pluginArtifact,
  validatePassword,
  verifyDiscordRequest,
  verifyPassword
} = await import("../worker/index.js");

test("normalizes valid account identifiers", () => {
  assert.equal(normalizeEmail("  Person@Example.COM "), "person@example.com");
  assert.equal(normalizeUsername(" KLite_User "), "KLite_User");
  assert.equal(normalizeEmail("not-an-email"), null);
  assert.equal(normalizeUsername("two words"), null);
});

test("enforces password length boundaries", () => {
  assert.match(validatePassword("short"), /at least 12/);
  assert.equal(validatePassword("correct horse battery staple"), null);
  assert.match(validatePassword("x".repeat(129)), /128/);
});

test("validates plugin submission identifiers and source metadata", () => {
  assert.equal(normalizePluginId(" My-Plugin "), "my-plugin");
  assert.equal(normalizePluginId("../plugin"), null);
  assert.equal(normalizeVersion("1.2.3-beta.1"), "1.2.3-beta.1");
  assert.equal(normalizeVersion("latest"), null);
  assert.equal(
    normalizeSourceUrl("https://github.com/example/plugin"),
    "https://github.com/example/plugin"
  );
  assert.equal(normalizeSourceUrl("http://example.com/plugin"), null);
  assert.equal(normalizeSourceUrl("https://user:secret@example.com/plugin"), null);
});

test("password hashes are salted and verified with the Worker pepper", async () => {
  const first = await hashPassword("correct horse battery staple", "test-pepper");
  const second = await hashPassword("correct horse battery staple", "test-pepper");

  assert.notEqual(first, second);
  assert.equal(await verifyPassword("correct horse battery staple", first, "test-pepper"), true);
  assert.equal(await verifyPassword("wrong password", first, "test-pepper"), false);
  assert.equal(await verifyPassword("correct horse battery staple", first, "wrong-pepper"), false);
});

test("rejects unsigned and stale Discord interactions", async () => {
  const unsigned = new Request("https://example.com/api/discord/interactions", { method: "POST" });
  assert.equal(await verifyDiscordRequest(unsigned, "{}", "00".repeat(32)), false);

  const stale = new Request("https://example.com/api/discord/interactions", {
    method: "POST",
    headers: {
      "x-signature-ed25519": "00".repeat(64),
      "x-signature-timestamp": "1"
    }
  });
  assert.equal(await verifyDiscordRequest(stale, "{}", "00".repeat(32)), false);
});

test("streams free plugin artifacts from private object storage", async () => {
  const bytes = new Uint8Array([0x50, 0x4b, 3, 4]);
  const artifact = {
    version: "1.0.0",
    object_key: "test-plugin/1.0.0.jar",
    sha256: "ab".repeat(32),
    size: bytes.length,
    access_type: "Free"
  };
  const env = {
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
        ? { body: bytes, size: bytes.length }
        : null
    }
  };

  const response = await pluginArtifact(
    new Request("https://example.com/api/client/plugins/test-plugin/artifact?version=1.0.0"),
    env,
    "test-plugin"
  );

  assert.equal(response.status, 200);
  assert.equal(response.headers.get("content-type"), "application/java-archive");
  assert.equal(response.headers.get("cache-control"), "private, no-store");
  assert.deepEqual(new Uint8Array(await response.arrayBuffer()), bytes);
});

test("requires a client login before serving paid plugin artifacts", async () => {
  const artifact = {
    version: "1.0.0",
    object_key: "paid/1.0.0.jar",
    sha256: "cd".repeat(32),
    size: 4,
    access_type: "Premium"
  };
  const env = {
    DB: {
      prepare() {
        return {
          bind() {
            return { first: async () => artifact };
          }
        };
      }
    }
  };
  const response = await pluginArtifact(
    new Request("https://example.com/api/client/plugins/paid/artifact?version=1.0.0"),
    env,
    "paid"
  );
  assert.equal(response.status, 401);
});
