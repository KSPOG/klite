import assert from "node:assert/strict";
import test from "node:test";

import { handleDiscordDashboardActions } from "../worker/discord-dashboard-actions.js";
import { DISCORD_COMMANDS } from "../worker/discord-commands.js";

const ORIGIN = "https://klite-marketplace.pages.dev";
const APPLICATION_ID = "12345678901234567";
const GUILD_ID = "22345678901234567";
const CHANNEL_ID = "32345678901234567";
const ROLE_ID = "42345678901234567";
const MESSAGE_ID = "52345678901234567";

const env = {
  DISCORD_APPLICATION_ID: APPLICATION_ID,
  DISCORD_BOT_TOKEN: "bot-token",
  DISCORD_GUILD_ID: GUILD_ID
};

test("dashboard command action registers and re-reads guild commands", async () => {
  const originalFetch = globalThis.fetch;
  globalThis.fetch = async () => Response.json(DISCORD_COMMANDS.map((command, index) => ({
    id: String(index + 1),
    name: command.name,
    description: command.description
  })));
  let dashboardReads = 0;
  const services = {
    async loadDashboard() {
      dashboardReads += 1;
      return Response.json({
        commands: dashboardReads === 1 ? [] : DISCORD_COMMANDS.map((command) => ({ name: command.name }))
      });
    }
  };

  try {
    const request = new Request(`${ORIGIN}/api/discord-bot/commands/register`, { method: "POST" });
    const response = await handleDiscordDashboardActions(request, env, new URL(request.url), services);
    assert.equal(response.status, 200);
    const payload = await response.json();
    assert.equal(payload.registered, DISCORD_COMMANDS.length);
    assert.deepEqual(payload.commandNames, DISCORD_COMMANDS.map((command) => command.name));
    assert.equal(dashboardReads, 2);
  } finally {
    globalThis.fetch = originalFetch;
  }
});

test("client update action verifies the live Discord message and role mention", async () => {
  const originalFetch = globalThis.fetch;
  globalThis.fetch = async (url) => {
    assert.equal(
      String(url),
      `https://discord.com/api/v10/channels/${CHANNEL_ID}/messages/${MESSAGE_ID}`
    );
    return Response.json({
      id: MESSAGE_ID,
      channel_id: CHANNEL_ID,
      content: `<@&${ROLE_ID}>\n**Client version:** 1.0.95\n**Updates:**\n- Fixed updates`,
      mention_roles: [ROLE_ID]
    });
  };
  const dashboard = {
    channels: [{ id: CHANNEL_ID, name: "client-updates" }],
    roles: [{ id: ROLE_ID, name: "Client Updates" }],
    clientUpdates: {
      history: [{
        version: "1.0.95",
        updates: "- Fixed updates",
        channelId: CHANNEL_ID,
        roleId: ROLE_ID,
        messageId: MESSAGE_ID,
        postedAt: 1
      }]
    }
  };
  let forwardedBody = null;
  const services = {
    async updateSettings(body) {
      forwardedBody = body;
      return Response.json(dashboard);
    }
  };

  try {
    const request = new Request(`${ORIGIN}/api/discord-bot/client-updates/post`, {
      method: "POST",
      headers: { "content-type": "application/json" },
      body: JSON.stringify({ clientUpdateVersion: "1.0.95" })
    });
    const response = await handleDiscordDashboardActions(request, env, new URL(request.url), services);
    assert.equal(response.status, 200);
    const payload = await response.json();
    assert.equal(forwardedBody.postClientUpdate, true);
    assert.equal(payload.post.verified, true);
    assert.equal(payload.post.notificationVerified, true);
    assert.equal(
      payload.post.jumpUrl,
      `https://discord.com/channels/${GUILD_ID}/${CHANNEL_ID}/${MESSAGE_ID}`
    );
  } finally {
    globalThis.fetch = originalFetch;
  }
});

test("client update action reports when Discord suppresses the role notification", async () => {
  const originalFetch = globalThis.fetch;
  globalThis.fetch = async () => Response.json({
    id: MESSAGE_ID,
    channel_id: CHANNEL_ID,
    content: `<@&${ROLE_ID}>\n**Client version:** 1.0.95\n**Updates:**\n- Fixed updates`,
    mention_roles: []
  });
  const services = {
    async updateSettings() {
      return Response.json({
        channels: [{ id: CHANNEL_ID, name: "client-updates" }],
        roles: [{ id: ROLE_ID, name: "Client Updates" }],
        clientUpdates: {
          history: [{
            version: "1.0.95",
            channelId: CHANNEL_ID,
            roleId: ROLE_ID,
            messageId: MESSAGE_ID
          }]
        }
      });
    }
  };

  try {
    const request = new Request(`${ORIGIN}/api/discord-bot/client-updates/post`, {
      method: "POST",
      headers: { "content-type": "application/json" },
      body: JSON.stringify({ clientUpdateVersion: "1.0.95" })
    });
    const response = await handleDiscordDashboardActions(request, env, new URL(request.url), services);
    const payload = await response.json();
    assert.equal(payload.post.verified, true);
    assert.equal(payload.post.notificationVerified, false);
    assert.match(payload.post.warning, /mentionable|permission to mention roles/);
  } finally {
    globalThis.fetch = originalFetch;
  }
});
