import core from "./index.js";
import { handleCredits } from "./credits.js";
import {
  exchangeDiscordClientLogin,
  handleDiscordLoginCallback,
  startDiscordLogin
} from "./discord-auth.js";
import { handleDiscordDashboardActions } from "./discord-dashboard-actions.js";

const API_PAGE_ASSETS = new Set([
  "/api/",
  "/api/index.html",
  "/api/app.js",
  "/api/controls.js"
]);
const API_REFERENCE_STYLESHEET = "/api-reference.css";
const HOMEPAGE_ASSETS = new Set(["/", "/index.html"]);
const DASHBOARD_ACTION_SCRIPT = "/discord-dashboard-actions.js?v=20260719-1";

export default {
  async fetch(request, env, context) {
    const url = new URL(request.url);
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
      return env.ASSETS.fetch(request);
    }

    try {
      const dashboardAction = await handleDiscordDashboardActions(request, env, url, {
        loadDashboard: () => core.fetch(
          internalRequest(request, "/api/discord-bot/dashboard", "GET"), env, context
        ),
        updateSettings: (body) => core.fetch(
          internalRequest(request, "/api/discord-bot/settings", "PUT", body), env, context
        )
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
        if (loginResponse) {
          return loginResponse;
        }
      }
    } catch (error) {
      console.error("Unhandled marketplace entry route error", error);
      return new Response(JSON.stringify({
        error: {
          code: "entry_route_failed",
          message: "The request could not be completed."
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
    if (request.method === "GET" && HOMEPAGE_ASSETS.has(url.pathname)
        && response.ok && response.headers.get("content-type")?.includes("text/html")) {
      return injectDashboardActionScript(response);
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

function internalRequest(source, pathname, method, body) {
  const target = new URL(source.url);
  target.pathname = pathname;
  target.search = "";
  const headers = new Headers();
  const cookie = source.headers.get("cookie");
  if (cookie) headers.set("cookie", cookie);
  headers.set("accept", "application/json");
  if (body !== undefined) headers.set("content-type", "application/json");
  return new Request(target, {
    method,
    headers,
    body: body === undefined ? undefined : JSON.stringify(body)
  });
}

async function injectDashboardActionScript(response) {
  const html = await response.text();
  if (html.includes(DASHBOARD_ACTION_SCRIPT)) {
    return new Response(html, response);
  }
  const script = `<script src="${DASHBOARD_ACTION_SCRIPT}" defer></script>`;
  const content = html.includes("</body>")
    ? html.replace("</body>", `  ${script}\n</body>`)
    : `${html}\n${script}`;
  const headers = new Headers(response.headers);
  headers.delete("content-length");
  return new Response(content, {
    status: response.status,
    statusText: response.statusText,
    headers
  });
}
