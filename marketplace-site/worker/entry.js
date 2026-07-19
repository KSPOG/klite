import core from "./index.js";
import { handleCredits } from "./credits.js";
import {
  exchangeDiscordClientLogin,
  handleDiscordLoginCallback,
  startDiscordLogin
} from "./discord-auth.js";
import { handleDiscordDashboardActions } from "./discord-dashboard-actions.js";
import {
  handleWebsiteControls,
  loadWebsiteDashboard,
  updateWebsiteDashboardSettings
} from "./website-controls.js";

const API_PAGE_ASSETS = new Set([
  "/api/",
  "/api/index.html",
  "/api/app.js",
  "/api/controls.js"
]);
const API_REFERENCE_STYLESHEET = "/api-reference.css";
const HOMEPAGE_ASSETS = new Set(["/", "/index.html"]);
const WEBSITE_CONTROL_SCRIPT = "/website-control-fixes.js?v=20260719-1";
const DASHBOARD_ACTION_SCRIPT = "/discord-dashboard-actions.js?v=20260719-1";

export default {
  async fetch(request, env, context) {
    const url = new URL(request.url);
    const controlEnv = websiteControlEnvironment(env);
    const isAssetRequest = request.method === "GET" || request.method === "HEAD";

    if (isAssetRequest && url.pathname === "/api") {
      const target = new URL(request.url);
      target.pathname = "/api/";
      return Response.redirect(target.toString(), 308);
    }

    if (isAssetRequest && url.pathname === "/api/api.css") {
      const assetUrl = new URL(request.url);
      assetUrl.pathname = API_REFERENCE_STYLESHEET;
      assetUrl.search = "";
      return env.ASSETS.fetch(new Request(assetUrl, request));
    }

    if (isAssetRequest && API_PAGE_ASSETS.has(url.pathname)) {
      const response = await env.ASSETS.fetch(request);
      return request.method === "GET" && response.ok
          && response.headers.get("content-type")?.includes("text/html")
        ? injectScripts(response, [WEBSITE_CONTROL_SCRIPT])
        : response;
    }

    const loadCoreAccount = () => core.fetch(
      internalRequest(request, "/api/account", "GET"), env, context
    );
    const loadCoreDashboard = () => core.fetch(
      internalRequest(request, "/api/discord-bot/dashboard", "GET"), env, context
    );
    const updateCoreSettings = (body) => core.fetch(
      internalRequest(request, "/api/discord-bot/settings", "PUT", body), env, context
    );
    const loadDashboard = () => loadWebsiteDashboard(request, controlEnv, loadCoreDashboard);
    const updateSettings = (body) => updateWebsiteDashboardSettings(
      request, controlEnv, body, updateCoreSettings
    );

    try {
      const websiteControl = await handleWebsiteControls(request, controlEnv, url, {
        loadAccount: loadCoreAccount,
        loadDashboard: loadCoreDashboard
      });
      if (websiteControl) return websiteControl;

      const dashboardAction = await handleDiscordDashboardActions(request, controlEnv, url, {
        loadDashboard,
        updateSettings
      });
      if (dashboardAction) return dashboardAction;

      const creditResponse = await handleCredits(request, env, url);
      if (creditResponse) return creditResponse;

      if (request.method === "POST" && url.pathname === "/api/auth/discord/start") {
        return await startDiscordLogin(request, env);
      }
      if (request.method === "POST" && url.pathname === "/api/auth/discord/exchange") {
        return await exchangeDiscordClientLogin(request, env);
      }
      if (request.method === "GET" && url.pathname === "/api/discord/callback") {
        const loginResponse = await handleDiscordLoginCallback(url, env);
        if (loginResponse) return loginResponse;
      }
    } catch (error) {
      console.error("Unhandled marketplace entry route error", error);
      return new Response(JSON.stringify({
        error: {
          code: "entry_route_failed",
          message: error.message || "The request could not be completed."
        }
      }), {
        status: 500,
        headers: {
          "content-type": "application/json; charset=utf-8",
          "cache-control": "no-store",
          "x-content-type-options": "nosniff"
        }
      });
    }

    const response = await core.fetch(request, env, context);
    if (request.method === "GET" && response.ok
        && response.headers.get("content-type")?.includes("text/html")) {
      const scripts = [WEBSITE_CONTROL_SCRIPT];
      if (HOMEPAGE_ASSETS.has(url.pathname)) scripts.push(DASHBOARD_ACTION_SCRIPT);
      return injectScripts(response, scripts);
    }
    return response;
  },

  async scheduled(controller, env, context) {
    if (typeof core.scheduled === "function") {
      return core.scheduled(controller, env, context);
    }
    return undefined;
  }
};

function websiteControlEnvironment(env) {
  if (env.OWNER_RECOVERY_KEY || !env.SITE_OWNER_RECOVERY_KEY) return env;
  return Object.assign({}, env, {
    OWNER_RECOVERY_KEY: env.SITE_OWNER_RECOVERY_KEY
  });
}

function internalRequest(source, pathname, method, body) {
  const target = new URL(source.url);
  target.pathname = pathname;
  target.search = "";
  const headers = new Headers();
  const cookie = source.headers.get("cookie");
  const authorization = source.headers.get("authorization");
  if (cookie) headers.set("cookie", cookie);
  if (authorization) headers.set("authorization", authorization);
  headers.set("accept", "application/json");
  if (body !== undefined) headers.set("content-type", "application/json");
  return new Request(target, {
    method,
    headers,
    body: body === undefined ? undefined : JSON.stringify(body)
  });
}

async function injectScripts(response, sources) {
  let html = await response.text();
  for (const source of sources) {
    if (html.includes(source)) continue;
    const script = `<script src="${source}" defer></script>`;
    html = html.includes("</body>")
      ? html.replace("</body>", `  ${script}\n</body>`)
      : `${html}\n${script}`;
  }
  const headers = new Headers(response.headers);
  headers.delete("content-length");
  headers.delete("content-encoding");
  headers.delete("etag");
  return new Response(html, {
    status: response.status,
    statusText: response.statusText,
    headers
  });
}
