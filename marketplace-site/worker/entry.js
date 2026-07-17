import core from "./index.js";
import {
  exchangeDiscordClientLogin,
  handleDiscordLoginCallback,
  startDiscordLogin
} from "./discord-auth.js";

export default {
  async fetch(request, env, context) {
    const url = new URL(request.url);

    if (request.method === "POST" && url.pathname === "/api/auth/discord/start") {
      return startDiscordLogin(request, env);
    }
    if (request.method === "POST" && url.pathname === "/api/auth/discord/exchange") {
      return exchangeDiscordClientLogin(request, env);
    }
    if (request.method === "GET" && url.pathname === "/api/discord/callback") {
      const loginResponse = await handleDiscordLoginCallback(url, env);
      if (loginResponse) {
        return loginResponse;
      }
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
