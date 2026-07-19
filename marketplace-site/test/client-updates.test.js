import assert from "node:assert/strict";
import test from "node:test";

import {
  buildClientUpdateMessage,
  normalizeUpdates,
  normalizeVersion,
  setClientUpdateNotificationRole
} from "../worker/client-updates.js";

const GUILD_ID = "22345678901234567";
const ROLE_ID = "12345678901234567";
const USER_ID = "32345678901234567";

test("builds the requested client version and updates message", () => {
  assert.deepEqual(buildClientUpdateMessage("1.0.95", "- Added AutoLogin", ROLE_ID), {
    content: `<@&${ROLE_ID}>\n**Client version:** 1.0.95\n**Updates:**\n- Added AutoLogin`,
    allowed_mentions: { parse: [], roles: [ROLE_ID] }
  });
});

test("normalizes client update versions and notes", () => {
  assert.equal(normalizeVersion(" 1.0.95 "), "1.0.95");
  assert.equal(normalizeVersion("latest"), null);
  assert.equal(normalizeUpdates(" line one\r\nline two "), "line one\nline two");
  assert.equal(normalizeUpdates("  "), null);
});

test("assigns and removes the configured opt-in notification role", async () => {
  const calls = [];
  const originalFetch = globalThis.fetch;
  globalThis.fetch = async (url, options) => {
    calls.push({ url: String(url), method: options.method });
    return new Response(null, { status: 204 });
  };
  const env = {
    DISCORD_BOT_TOKEN: "bot-token",
    DISCORD_GUILD_ID: GUILD_ID,
    DB: {
      prepare() {
        return { first: async () => ({ role_id: ROLE_ID, enabled: 1 }) };
      }
    }
  };

  try {
    assert.match(
      await setClientUpdateNotificationRole(env, USER_ID, GUILD_ID, "subscribe"),
      /will now be notified/
    );
    assert.match(
      await setClientUpdateNotificationRole(env, USER_ID, GUILD_ID, "unsubscribe"),
      /will no longer be notified/
    );
  } finally {
    globalThis.fetch = originalFetch;
  }

  const endpoint = `https://discord.com/api/v10/guilds/${GUILD_ID}/members/${USER_ID}/roles/${ROLE_ID}`;
  assert.deepEqual(calls, [
    { url: endpoint, method: "PUT" },
    { url: endpoint, method: "DELETE" }
  ]);
});
