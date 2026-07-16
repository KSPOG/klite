import assert from "node:assert/strict";
import test from "node:test";

import {
  discordBotDashboard,
  normalizeDiscordBotSettings,
  normalizeSnowflake
} from "../worker/discord-dashboard.js";

const DEV_ROLE_ID = "12345678901234567";
const USER_ID = "22345678901234567";
const BOT_ID = "32345678901234567";
const GUILD_ID = "42345678901234567";

test("normalizes Discord bot role and channel settings", () => {
  assert.equal(normalizeSnowflake(` ${DEV_ROLE_ID} `), DEV_ROLE_ID);
  assert.equal(normalizeSnowflake("not-a-role"), null);
  assert.deepEqual(normalizeDiscordBotSettings({
    devRoleId: DEV_ROLE_ID,
    pluginDevRoleId: null,
    marketplaceReviewerRoleId: "",
    memberRoleId: null,
    announcementChannelId: null,
    auditChannelId: null,
    welcomeChannelId: null,
    botEnabled: true,
    autoAssignMemberRole: false,
    announcementsEnabled: false
  }), {
    devRoleId: DEV_ROLE_ID,
    pluginDevRoleId: null,
    marketplaceReviewerRoleId: null,
    memberRoleId: null,
    announcementChannelId: null,
    auditChannelId: null,
    welcomeChannelId: null,
    botEnabled: true,
    autoAssignMemberRole: false,
    announcementsEnabled: false
  });
});

test("shows the dashboard only when the linked member currently has Dev", async () => {
  const originalFetch = globalThis.fetch;
  globalThis.fetch = async (url) => discordResponse(new URL(url).pathname);
  try {
    activeRoles = [DEV_ROLE_ID];
    const dashboard = await discordBotDashboard(testEnvironment(), "website-user");
    assert.equal(dashboard.access.devRoleName, "Dev");
    assert.equal(dashboard.bot.id, BOT_ID);
    assert.equal(dashboard.guild.id, GUILD_ID);

    activeRoles = [];
    const denied = await discordBotDashboard(testEnvironment(), "website-user");
    assert.equal(denied, null);
  } finally {
    globalThis.fetch = originalFetch;
  }
});

function testEnvironment() {
  return {
    DISCORD_BOT_TOKEN: "bot-token",
    DISCORD_GUILD_ID: GUILD_ID,
    DISCORD_CLIENT_ID: BOT_ID,
    DB: {
      prepare(query) {
        return {
          bind() {
            return this;
          },
          async first() {
            if (query.includes("FROM discord_accounts")) {
              return { discord_id: USER_ID };
            }
            if (query.includes("FROM discord_bot_settings")) {
              return { dev_role_id: DEV_ROLE_ID, bot_enabled: 1 };
            }
            if (query.includes("COUNT(*)")) {
              return { total: 1 };
            }
            return null;
          },
          async all() {
            return { results: [] };
          }
        };
      }
    }
  };
}

function discordResponse(path) {
  if (path.endsWith("/roles")) {
    return Response.json([{ id: DEV_ROLE_ID, name: "Dev", position: 10,
      color: 0, managed: false, mentionable: true, permissions: "8" }]);
  }
  if (path.endsWith(`/members/${USER_ID}`)) {
    return Response.json({ roles: currentEnvironmentRoles() });
  }
  if (path === "/api/v10/users/@me") {
    return Response.json({ id: BOT_ID, username: "KLite Bot", verified: true });
  }
  if (path === `/api/v10/guilds/${GUILD_ID}`) {
    return Response.json({ id: GUILD_ID, name: "KLite", owner_id: USER_ID,
      approximate_member_count: 10, approximate_presence_count: 4,
      verification_level: 2 });
  }
  if (path.endsWith("/channels") || path.endsWith("/commands")) {
    return Response.json([]);
  }
  if (path.endsWith(`/members/${BOT_ID}`)) {
    return Response.json({ roles: [DEV_ROLE_ID], joined_at: "2026-01-01T00:00:00Z" });
  }
  return new Response("Not found", { status: 404 });
}

let activeRoles = [];

function currentEnvironmentRoles() {
  return activeRoles;
}
