import assert from "node:assert/strict";
import test from "node:test";

import {
  DISCORD_COMMANDS,
  listGuildDiscordCommands,
  registerGuildDiscordCommands,
  verifyRegisteredCommands
} from "../worker/discord-commands.js";

const APPLICATION_ID = "12345678901234567";
const GUILD_ID = "22345678901234567";

test("registers and verifies commands in the designated guild", async () => {
  const calls = [];
  const originalFetch = globalThis.fetch;
  globalThis.fetch = async (url, options = {}) => {
    calls.push({ url: String(url), method: options.method || "GET", body: options.body });
    return Response.json(DISCORD_COMMANDS.map((command, index) => ({
      id: String(index + 1),
      name: command.name,
      description: command.description
    })));
  };

  const env = {
    DISCORD_APPLICATION_ID: APPLICATION_ID,
    DISCORD_BOT_TOKEN: "bot-token",
    DISCORD_GUILD_ID: GUILD_ID
  };

  try {
    verifyRegisteredCommands(await registerGuildDiscordCommands(env));
    verifyRegisteredCommands(await listGuildDiscordCommands(env));
  } finally {
    globalThis.fetch = originalFetch;
  }

  const endpoint = `https://discord.com/api/v10/applications/${APPLICATION_ID}/guilds/${GUILD_ID}/commands`;
  assert.equal(calls.length, 2);
  assert.equal(calls[0].url, endpoint);
  assert.equal(calls[0].method, "PUT");
  assert.deepEqual(JSON.parse(calls[0].body), DISCORD_COMMANDS);
  assert.equal(calls[1].url, endpoint);
  assert.equal(calls[1].method, "GET");
});

test("rejects incomplete Discord registration responses", () => {
  assert.throws(
    () => verifyRegisteredCommands([{ name: "link" }]),
    /did not register: \/account, \/client-updates/
  );
});
