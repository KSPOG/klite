import test from "node:test";
import assert from "node:assert/strict";
import {
  buildBotInviteUrl,
  isSiteOwner,
  normalizeRequestedRoles
} from "../worker/pages-control-plane.js";

test("site owner defaults to the KSP username case-insensitively", () => {
  assert.equal(isSiteOwner({ id: "1", username: "KSP" }), true);
  assert.equal(isSiteOwner({ id: "2", username: "ksp" }), true);
  assert.equal(isSiteOwner({ id: "3", username: "other" }), false);
});

test("site owner can be pinned by user ID", () => {
  assert.equal(isSiteOwner(
    { id: "owner-id", username: "renamed" },
    { SITE_OWNER_USER_ID: "owner-id", SITE_OWNER_USERNAME: "KSP" }
  ), true);
});

test("bot invite is locked to the configured guild", () => {
  const invite = buildBotInviteUrl("123456789012345678", "987654321098765432");
  const url = new URL(invite);
  assert.equal(url.hostname, "discord.com");
  assert.equal(url.searchParams.get("client_id"), "123456789012345678");
  assert.equal(url.searchParams.get("guild_id"), "987654321098765432");
  assert.equal(url.searchParams.get("disable_guild_select"), "true");
  assert.match(url.searchParams.get("scope"), /bot/);
  assert.match(url.searchParams.get("scope"), /applications\.commands/);
});

test("managed roles only accept the supported website roles", () => {
  assert.deepEqual(normalizeRequestedRoles(["marketplace_reviewer", "plugin_dev"]),
    ["marketplace_reviewer", "plugin_dev"]);
  assert.equal(normalizeRequestedRoles(["site_owner"]), null);
  assert.equal(normalizeRequestedRoles("marketplace_reviewer"), null);
});
