import assert from "node:assert/strict";
import test from "node:test";

import {
  refreshPluginDeveloperRole,
  refreshPluginDeveloperRoleSafely
} from "../worker/discord-role-verification.js";

const USER_ID = "11111111-1111-4111-8111-111111111111";
const DISCORD_ID = "222222222222222222";
const GUILD_ID = "333333333333333333";
const ROLE_ID = "444444444444444444";

function environment() {
  const updates = [];
  return {
    updates,
    env: {
      DISCORD_BOT_TOKEN: "test-token",
      DISCORD_GUILD_ID: GUILD_ID,
      DB: {
        prepare(query) {
          return {
            values: [],
            bind(...values) {
              this.values = values;
              return this;
            },
            async first() {
              if (query.includes("SELECT discord_id")) {
                return { discord_id: DISCORD_ID };
              }
              if (query.includes("SELECT plugin_dev_role_id")) {
                return { plugin_dev_role_id: ROLE_ID };
              }
              return null;
            },
            async run() {
              if (query.includes("UPDATE discord_accounts")) {
                updates.push(this.values);
              }
              return { meta: { changes: 1 } };
            }
          };
        }
      }
    }
  };
}

test("refreshes Plugin Dev membership from the current Discord guild member", async () => {
  const { env, updates } = environment();
  const calls = [];
  const result = await refreshPluginDeveloperRole(env, USER_ID, {
    fetchImpl: async (url, options) => {
      calls.push({ url, options });
      return Response.json({ roles: [ROLE_ID] });
    }
  });

  assert.equal(result.refreshed, true);
  assert.equal(result.hasRole, true);
  assert.equal(calls[0].url,
    `https://discord.com/api/v10/guilds/${GUILD_ID}/members/${DISCORD_ID}`);
  assert.equal(calls[0].options.headers.authorization, "Bot test-token");
  assert.equal(updates.length, 1);
  assert.equal(updates[0][0], 1);
  assert.equal(updates[0][2], USER_ID);
});

test("records a current negative verification when the member lacks the role", async () => {
  const { env, updates } = environment();
  const result = await refreshPluginDeveloperRole(env, USER_ID, {
    fetchImpl: async () => Response.json({ roles: [] })
  });

  assert.equal(result.refreshed, true);
  assert.equal(result.hasRole, false);
  assert.equal(updates[0][0], 0);
});

test("preserves cached membership when Discord is temporarily unavailable", async () => {
  const { env, updates } = environment();
  const originalWarn = console.warn;
  console.warn = () => {};
  try {
    const result = await refreshPluginDeveloperRoleSafely(env, USER_ID, {
      fetchImpl: async () => new Response(null, { status: 503 })
    });
    assert.deepEqual(result, { refreshed: false, reason: "discord_unavailable" });
    assert.equal(updates.length, 0);
  } finally {
    console.warn = originalWarn;
  }
});
