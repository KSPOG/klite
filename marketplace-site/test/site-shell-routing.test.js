import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import path from "node:path";
import test from "node:test";
import { fileURLToPath } from "node:url";

const testDirectory = path.dirname(fileURLToPath(import.meta.url));
const siteDirectory = path.resolve(testDirectory, "..");

test("site routes hard-hide inactive panels instead of relying on theme CSS", async () => {
  const shell = await readFile(path.join(siteDirectory, "public/site-shell.js"), "utf8");

  assert.match(shell, /function applyRouteVisibility\(panel, selectedRoute\)/);
  assert.match(shell, /panel\.style\.setProperty\("display", "none", "important"\)/);
  assert.match(shell, /panel\.style\.removeProperty\("display"\)/);
  assert.match(shell, /panel\.inert = inactive/);
  assert.equal(
    (shell.match(/applyRouteVisibility\(panel, (?:selected|currentSiteRoute)\)/g) ?? []).length,
    2,
    "initial route changes and mutation-driven updates must use the same isolation logic",
  );
});

test("Discord dashboard navigation exposes every existing control group", async () => {
  const shell = await readFile(path.join(siteDirectory, "public/site-shell.js"), "utf8");

  for (const target of [
    "discord-bootstrap-slot",
    "discord-bot-status-grid",
    "discord-bot-settings-form",
    "discord-client-update-history",
    "announcement-history",
    "discord-command-list",
    "discord-role-list",
    "discord-channel-list",
  ]) {
    assert.match(shell, new RegExp(`target: "${target}"`), `missing Discord target ${target}`);
  }
});

test("Discord channel inventory is generated from the dashboard channel selectors", async () => {
  const shell = await readFile(path.join(siteDirectory, "public/site-shell.js"), "utf8");

  assert.match(shell, /function ensureDiscordChannelInventory\(\)/);
  assert.match(shell, /function syncDiscordChannelInventory\(channelList, channelCount\)/);
  assert.match(shell, /discord-channel-count/);
  assert.match(shell, /Configured for:/);
});
