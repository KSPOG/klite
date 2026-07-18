import core from "./index.js";
import { handleCredits } from "./credits.js";
import {
  exchangeDiscordClientLogin,
  handleDiscordLoginCallback,
  startDiscordLogin
} from "./discord-auth.js";

const API_PAGE_ASSETS = new Set([
  "/api/",
  "/api/index.html",
  "/api/api.css",
  "/api/app.js",
  "/api/controls.js"
]);

export default {
  async fetch(request, env, context) {
    const url = new URL(request.url);

    if ((request.method === "GET" || request.method === "HEAD") && url.pathname === "/api") {
      const target = new URL(request.url);
      target.pathname = "/api/";
      return Response.redirect(target.toString(), 308);
    }

    if ((request.method === "GET" || request.method === "HEAD") && API_PAGE_ASSETS.has(url.pathname)) {
      return env.ASSETS.fetch(request);
    }

    try {
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
      console.error("Unhandled Discord authentication error", error);
      return new Response(JSON.stringify({
        error: {
          code: "discord_authentication_failed",
          message: "Discord authentication could not be completed."
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

    return core.fetch(request, env, context);
  },

  async scheduled(controller, env, context) {
    if (typeof core.scheduled === "function") {
      return core.scheduled(controller, env, context);
    }
    return undefined;
  }
};