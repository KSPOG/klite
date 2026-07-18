import marketplaceWorker from "../../worker/index.js";
import { handleCredits } from "../../worker/credits.js";
import {
  exchangeDiscordClientLogin,
  handleDiscordLoginCallback,
  startDiscordLogin
} from "../../worker/discord-auth.js";
import { handlePagesAuth } from "../../worker/pages-auth.js";
import { handlePasswordReset } from "../../worker/pages-password-reset.js";
import { handleControlPlane } from "../../worker/pages-control-plane.js";
import { handlePublicArtifact } from "../../worker/pages-public-artifacts.js";

const JSON_HEADERS = {
  "content-type": "application/json; charset=utf-8",
  "cache-control": "no-store",
  "x-content-type-options": "nosniff"
};

const STATIC_API_DOCUMENTATION_PATHS = new Set([
  "/api/",
  "/api/index.html",
  "/api/styles.css",
  "/api/app.js"
]);

function apiError(status, code, message) {
  return new Response(JSON.stringify({ error: { code, message } }), {
    status,
    headers: JSON_HEADERS
  });
}

function discordConfigurationError(env) {
  const missing = [];
  if (!env.DISCORD_CLIENT_ID) missing.push("DISCORD_CLIENT_ID");
  if (!env.DISCORD_CLIENT_SECRET) missing.push("DISCORD_CLIENT_SECRET");
  if (!env.DISCORD_GUILD_ID) missing.push("DISCORD_GUILD_ID");
  if (missing.length === 0) return null;

  return apiError(
    503,
    "discord_configuration_missing",
    `Discord login is not configured. Add the following Cloudflare Pages variables or secrets and redeploy: ${missing.join(", ")}.`
  );
}

export async function onRequest(context) {
  const { request } = context;
  const requestUrl = new URL(request.url);

  if (!requestUrl.pathname.startsWith("/api/")) {
    return context.next();
  }

  // The API documentation page shares the /api prefix with the JSON backend.
  // Let Pages serve these files from public/api instead of passing them into the
  // worker, which would otherwise return JSON for CSS and JavaScript requests.
  if ((request.method === "GET" || request.method === "HEAD")
    && STATIC_API_DOCUMENTATION_PATHS.has(requestUrl.pathname)) {
    return context.next();
  }

  if (!context.env.DB) {
    return apiError(
      503,
      "database_binding_missing",
      "The marketplace database is not connected. Add the D1 binding named DB to the Cloudflare Pages project, then redeploy."
    );
  }

  const env = {
    ...context.env,
    PUBLIC_ORIGIN: context.env.PUBLIC_ORIGIN || requestUrl.origin
  };

  try {
    const isDiscordStart = request.method === "POST"
      && requestUrl.pathname === "/api/auth/discord/start";
    const isDiscordExchange = request.method === "POST"
      && requestUrl.pathname === "/api/auth/discord/exchange";
    const isDiscordCallback = request.method === "GET"
      && requestUrl.pathname === "/api/discord/callback";

    if (isDiscordStart || isDiscordExchange || isDiscordCallback) {
      const configurationError = discordConfigurationError(env);
      if (configurationError) return configurationError;
    }

    if (isDiscordStart) {
      return await startDiscordLogin(request, env);
    }

    if (isDiscordExchange) {
      return await exchangeDiscordClientLogin(request, env);
    }

    if (isDiscordCallback) {
      const loginResponse = await handleDiscordLoginCallback(requestUrl, env);
      if (loginResponse) return loginResponse;
    }

    const creditResponse = await handleCredits(request, env, requestUrl);
    if (creditResponse) return creditResponse;

    if (!env.PASSWORD_PEPPER) {
      return apiError(
        503,
        "password_pepper_missing",
        "Marketplace authentication is not configured. Add the PASSWORD_PEPPER secret to the Cloudflare Pages project, then redeploy."
      );
    }

    const resetResponse = await handlePasswordReset(request, env, requestUrl);
    if (resetResponse) return resetResponse;

    const authResponse = await handlePagesAuth(request, env, requestUrl);
    if (authResponse) return authResponse;

    const controlPlaneResponse = await handleControlPlane(request, env, requestUrl);
    if (controlPlaneResponse) return controlPlaneResponse;

    const publicArtifactResponse = await handlePublicArtifact(request, env, requestUrl);
    if (publicArtifactResponse) return publicArtifactResponse;

    const response = await marketplaceWorker.fetch(request, env);
    if (response.status >= 500) {
      const payload = await response.clone().json().catch(() => null);
      if (payload?.error?.code === "internal_error") {
        return apiError(
          500,
          "marketplace_backend_error",
          "The marketplace backend failed. Check the Pages Function logs for the underlying exception."
        );
      }
    }
    return response;
  } catch (error) {
    console.error("Unhandled KLite Pages Function error", error);
    return apiError(
      500,
      "pages_function_error",
      "The marketplace Pages Function failed. Check the Cloudflare Pages Function logs for the underlying exception."
    );
  }
}
