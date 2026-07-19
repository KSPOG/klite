import assert from "node:assert/strict";
import test from "node:test";

import { installPayload } from "../worker/website-controls.js";

test("installation payload matches the dashboard renderer contract", () => {
  const result = installPayload({
    PUBLIC_ORIGIN: "https://klite.example",
    DISCORD_CLIENT_ID: "12345678901234567",
    DISCORD_CLIENT_SECRET: "secret",
    DISCORD_PUBLIC_KEY: "public-key",
    DISCORD_BOT_TOKEN: "bot-token",
    DISCORD_GUILD_ID: "22345678901234567"
  }, true);

  for (const key of [
    "installed",
    "configured",
    "missing",
    "inviteUrl",
    "guildId",
    "interactionEndpoint",
    "passwordResetRedirect"
  ]) {
    assert.ok(Object.hasOwn(result, key), `missing install payload field ${key}`);
  }
});
