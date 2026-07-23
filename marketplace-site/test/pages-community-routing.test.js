import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

test("Cloudflare Pages uses the complete Community control handlers", async () => {
  const source = await readFile(
    new URL("../functions/api/[[path]].js", import.meta.url),
    "utf8"
  );
  assert.match(source, /handleWebsiteControls/);
  assert.match(source, /handleDiscordDashboardActions/);
  assert.match(source, /updateWebsiteDashboardSettings/);
  assert.match(source, /loadWebsiteDashboard/);
  assert.ok(
    source.indexOf('requestUrl.pathname.startsWith("/api/review/submissions")')
      < source.indexOf("handleControlPlane(request, env, requestUrl)"),
    "secure submission routes must run before the legacy Pages control plane"
  );
});

test("the deployed homepage loads Community control repair scripts directly", async () => {
  const source = await readFile(new URL("../public/index.html", import.meta.url), "utf8");
  assert.match(source, /\/website-control-fixes\.js\?v=release-20260723-1/);
  assert.match(source, /\/discord-dashboard-actions\.js\?v=release-20260723-1/);
});

test("credit administration exposes audited user adjustments", async () => {
  const [worker, browser] = await Promise.all([
    readFile(new URL("../worker/credits.js", import.meta.url), "utf8"),
    readFile(new URL("../public/credits-admin.js", import.meta.url), "utf8")
  ]);
  assert.match(worker, /credit_transactions/);
  assert.match(worker, /'adjustment'/);
  assert.match(worker, /'klite_admin'/);
  assert.match(browser, /credit-adjustment-form/);
  assert.match(browser, /Apply adjustment/);
});
