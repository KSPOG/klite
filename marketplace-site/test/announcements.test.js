import assert from "node:assert/strict";
import test from "node:test";

import {
  buildDiscordAnnouncement,
  normalizeDiscordChannelId,
  syncPluginAnnouncements
} from "../worker/announcements.js";
import { API_REFERENCE } from "../worker/api-reference.generated.js";

test("accepts only Discord snowflake channel IDs", () => {
  assert.equal(normalizeDiscordChannelId(" 12345678901234567 "), "12345678901234567");
  assert.equal(normalizeDiscordChannelId("123"), null);
  assert.equal(normalizeDiscordChannelId("1234567890123456x"), null);
  assert.equal(normalizeDiscordChannelId(null), null);
});

test("builds complete Discord embeds without mentions", () => {
  const payload = buildDiscordAnnouncement(
    { PUBLIC_ORIGIN: "https://klite.example" },
    {
      id: "test-plugin",
      descriptor: {
        name: "Test Plugin",
        description: "A reviewed plugin.",
        version: "2.0.0",
        minClientVersion: "1.0.0",
        tags: ["automation", "example"],
        authors: ["Developer"]
      },
      categories: ["Other"],
      type: "Premium",
      status: "available",
      homepageUrl: "https://example.com/plugin",
      iconPath: "assets/plugins/test-plugin.png",
      updatedAt: "2026-07-16T00:00:00Z"
    },
    "update"
  );

  assert.deepEqual(payload.allowed_mentions, { parse: [] });
  assert.equal(payload.embeds[0].title, "Plugin updated: Test Plugin");
  assert.equal(payload.embeds[0].url, "https://example.com/plugin");
  assert.equal(payload.embeds[0].thumbnail.url,
    "https://klite.example/assets/plugins/test-plugin.png");
  assert.equal(payload.embeds[0].fields[0].value, "2.0.0");
  assert.equal(payload.embeds[0].fields[1].value, "Premium");
  assert.equal(payload.embeds[0].fields.find((field) => field.name === "Tags").value,
    "automation, example");
});

test("generated authenticated reference excludes marketplace internals", () => {
  assert.ok(API_REFERENCE.typeCount >= 80);
  assert.ok(API_REFERENCE.methodCount >= 400);
  assert.equal(API_REFERENCE.sections.some((section) =>
    section.types.some((type) => type.packageName.includes(".marketplace"))), false);
  assert.ok(API_REFERENCE.sections.some((section) =>
    section.types.some((type) => type.name === "KLiteClientApi")));
});

test("announces a new available plugin once and persists its version", async () => {
  let state = null;
  const log = [];
  let botEnabled = 1;
  const statements = [];
  const env = {
    PUBLIC_ORIGIN: "https://klite.example",
    DISCORD_BOT_TOKEN: "test-token",
    ASSETS: {
      fetch: async () => new Response(JSON.stringify({
        plugins: [{
          id: "test-plugin",
          status: "available",
          descriptor: {
            name: "Test Plugin",
            description: "A reviewed plugin.",
            version: "1.0.0",
            minClientVersion: "1.0.0",
            authors: ["Developer"]
          },
          categories: ["Other"],
          type: "Free",
          updatedAt: "2026-07-16T00:00:00Z"
        }]
      }))
    },
    DB: {
      prepare(sql) {
        return {
          bind(...values) {
            return {
              first: async () => sql.includes("plugin_announcement_state") ? state : null,
              run: async () => {
                statements.push({ sql, values });
                if (sql.includes("plugin_announcement_state")) {
                  state = {
                    announced_version: values[1],
                    announced_updated_at: values[2]
                  };
                }
                if (sql.includes("plugin_announcement_log")) {
                  log.push(values);
                }
                return { success: true };
              }
            };
          },
          first: async () => sql.includes("discord_bot_settings")
            ? { bot_enabled: botEnabled }
            : { channel_id: "12345678901234567", enabled: 1 }
        };
      }
    }
  };
  const originalFetch = globalThis.fetch;
  globalThis.fetch = async () => new Response(JSON.stringify({ id: "message-1" }), {
    status: 200,
    headers: { "content-type": "application/json" }
  });
  try {
    assert.deepEqual(await syncPluginAnnouncements(env, "developer-id"),
      { announced: 1, available: 1 });
    assert.deepEqual(await syncPluginAnnouncements(env, "developer-id"),
      { announced: 0, available: 1 });
    botEnabled = 0;
    assert.deepEqual(await syncPluginAnnouncements(env, "developer-id"),
      { announced: 0, skipped: "bot_disabled" });
  } finally {
    globalThis.fetch = originalFetch;
  }
  assert.equal(state.announced_version, "1.0.0");
  assert.equal(log.length, 1);
  assert.ok(statements.some((entry) => entry.sql.includes("plugin_announcement_state")));
});
