import assert from "node:assert/strict";
import fs from "node:fs";
import path from "node:path";
import test from "node:test";
import { fileURLToPath } from "node:url";

import { installPayload } from "../worker/website-controls.js";

const testDirectory = path.dirname(fileURLToPath(import.meta.url));
const siteRoot = path.resolve(testDirectory, "..");

function read(relativePath) {
  return fs.readFileSync(path.join(siteRoot, relativePath), "utf8");
}

const frontendScripts = [
  "public/app.js",
  "public/enhancements.js",
  "public/site-shell.js",
  "public/homepage-status.js",
  "public/credits.js",
  "public/credits-admin.js",
  "public/account-routes.js",
  "public/secondary-page-header.js",
  "public/discord-dashboard-actions.js",
  "public/website-control-fixes.js",
  "public/api/app.js",
  "public/api/controls.js",
  "public/docs/docs.js",
  "public/changelog/changelog.js"
];

const routeSources = [
  "worker/index.js",
  "worker/entry.js",
  "worker/credits.js",
  "worker/discord-auth.js",
  "worker/discord-dashboard-actions.js",
  "worker/website-controls.js"
];

test("every browser API prefix is represented by a Worker route", () => {
  const frontend = frontendScripts.map(read).join("\n");
  const routes = routeSources.map(read).join("\n").replaceAll("\\/", "/");
  const prefixes = new Set();
  for (const match of frontend.matchAll(/["'`]((?:\/api\/)[^"'`\s]*)/g)) {
    const prefix = match[1]
      .split("${", 1)[0]
      .split("?", 1)[0]
      .replace(/[),;]+$/, "");
    if (prefix.length > "/api/".length) prefixes.add(prefix);
  }

  const missing = [...prefixes].filter((prefix) => !routes.includes(prefix));
  assert.deepEqual(missing, [], `browser API routes without a Worker handler: ${missing.join(", ")}`);
});

test("every static button and form ID is referenced by website JavaScript", () => {
  const html = [
    "public/index.html",
    "public/api/index.html",
    "public/docs/index.html",
    "public/changelog/index.html"
  ].map(read).join("\n");
  const scripts = frontendScripts.map(read).join("\n");
  const ids = new Set();
  for (const match of html.matchAll(/<(?:button|form)\b[^>]*\bid="([^"]+)"/g)) {
    ids.add(match[1]);
  }
  const missing = [...ids].filter((id) => !scripts.includes(`#${id}`));
  assert.deepEqual(missing, [], `controls without a JavaScript reference: ${missing.join(", ")}`);
});

test("owner and Discord dashboard controls have concrete backend routes", () => {
  const source = read("worker/website-controls.js");
  for (const route of [
    "/api/admin/users",
    "/api/discord-bot/roles/dev",
    "/api/auth/reset/start",
    "/api/auth/reset/callback",
    "/api/auth/reset/complete"
  ]) {
    assert.match(source, new RegExp(route.replaceAll("/", "\\/")));
  }
  assert.match(source, /payload\.install = installPayload/);
  assert.match(source, /method: owner \? "site_owner" : "discord_role"/);
});

test("Discord installation metadata exposes the exact required controls", () => {
  const payload = installPayload({
    PUBLIC_ORIGIN: "https://klite.example",
    DISCORD_CLIENT_ID: "12345678901234567",
    DISCORD_CLIENT_SECRET: "secret",
    DISCORD_PUBLIC_KEY: "public-key",
    DISCORD_BOT_TOKEN: "bot-token",
    DISCORD_GUILD_ID: "22345678901234567"
  }, true);

  assert.equal(payload.installed, true);
  assert.equal(payload.configured, true);
  assert.deepEqual(payload.missing, []);
  assert.match(payload.inviteUrl, /applications\.commands/);
  assert.equal(payload.interactionEndpoint, "https://klite.example/api/discord/interactions");
  assert.equal(payload.passwordResetRedirect, "https://klite.example/api/auth/reset/callback");
});
