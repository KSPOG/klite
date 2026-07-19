import assert from "node:assert/strict";
import test from "node:test";

import {
  handleWebsiteControls,
  installPayload,
  loadWebsiteDashboard
} from "../worker/website-controls.js";

const USER_ID = "11111111-1111-4111-8111-111111111111";
const SESSION_TOKEN = "session-token";

function request(path, method = "GET", body) {
  return new Request(`https://klite.example${path}`, {
    method,
    headers: {
      cookie: `klite_session=${SESSION_TOKEN}`,
      ...(body === undefined ? {} : { "content-type": "application/json" })
    },
    body: body === undefined ? undefined : JSON.stringify(body)
  });
}

function ownerEnvironment() {
  return {
    PUBLIC_ORIGIN: "https://klite.example",
    PASSWORD_PEPPER: "pepper",
    DISCORD_CLIENT_ID: "12345678901234567",
    DISCORD_GUILD_ID: "22345678901234567",
    DB: {
      prepare(query) {
        return {
          bind(...values) {
            this.values = values;
            return this;
          },
          async first() {
            if (query.includes("FROM sessions")) {
              return { user_id: USER_ID, kind: "web", expires_at: 9_999_999_999 };
            }
            if (query.includes("role = 'site_owner'")) return { allowed: 1 };
            if (query.includes("FROM users WHERE id")) {
              return { id: USER_ID, username: "KSP", email: "owner@example.com" };
            }
            return null;
          },
          async all() {
            return { results: [] };
          },
          async run() {
            return { meta: { changes: 1 } };
          }
        };
      },
      async batch(statements) {
        return statements.map(() => ({ success: true }));
      }
    }
  };
}

test("account responses gain site owner capability for the real owner", async () => {
  const env = ownerEnvironment();
  const source = Response.json({
    account: {
      id: USER_ID,
      username: "KSP",
      email: "owner@example.com",
      roles: [],
      capabilities: []
    },
    entitlements: []
  });
  const response = await handleWebsiteControls(
    request("/api/account"), env, new URL("https://klite.example/api/account"), {
      loadAccount: async () => source,
      loadDashboard: async () => new Response(null, { status: 403 })
    }
  );
  const payload = await response.json();
  assert.deepEqual(payload.account.roles, ["site_owner"]);
  assert.deepEqual(payload.account.capabilities, ["site_owner"]);
});

test("owner dashboard responses always include installation metadata", async () => {
  const env = ownerEnvironment();
  const coreDashboard = Response.json({
    access: { devRoleName: "Dev" },
    bot: {},
    guild: {},
    settings: {},
    roles: [],
    channels: [],
    commands: [],
    clientUpdates: { history: [] },
    announcementHistory: [],
    stats: { linkedAccounts: 0, activeSessions: 1, announcementsSent: 0 }
  });
  const response = await loadWebsiteDashboard(
    request("/api/discord-bot/dashboard"), env, async () => coreDashboard
  );
  const payload = await response.json();
  assert.equal(payload.access.method, "site_owner");
  assert.equal(payload.install.guildId, env.DISCORD_GUILD_ID);
  assert.equal(payload.install.installed, true);
});

test("unmatched website paths remain available to downstream routers", async () => {
  const env = ownerEnvironment();
  const response = await handleWebsiteControls(
    request("/api/not-a-control"), env, new URL("https://klite.example/api/not-a-control"), {
      loadAccount: async () => Response.json({}),
      loadDashboard: async () => Response.json({})
    }
  );
  assert.equal(response, null);
});

test("install metadata reports missing Discord configuration", () => {
  const payload = installPayload({ PUBLIC_ORIGIN: "https://klite.example" }, false);
  assert.equal(payload.installed, false);
  assert.equal(payload.configured, false);
  assert.ok(payload.missing.includes("DISCORD_BOT_TOKEN"));
  assert.equal(payload.inviteUrl, null);
});
