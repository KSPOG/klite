import marketplaceWorker from "../../worker/index.js";

const JSON_HEADERS = {
  "content-type": "application/json; charset=utf-8",
  "cache-control": "no-store",
  "x-content-type-options": "nosniff"
};

function apiError(status, code, message) {
  return new Response(JSON.stringify({ error: { code, message } }), {
    status,
    headers: JSON_HEADERS
  });
}

/**
 * Cloudflare Pages Function adapter for the existing marketplace Worker.
 *
 * The Pages project is connected to GitHub, so /api/* must be routed through
 * the functions directory. Static files continue to come from public/.
 */
export async function onRequest(context) {
  const { request } = context;
  const requestUrl = new URL(request.url);

  if (!requestUrl.pathname.startsWith("/api/")) {
    return context.next();
  }

  if (!context.env.DB) {
    return apiError(
      503,
      "database_binding_missing",
      "The marketplace database is not connected. Add the D1 binding named DB to the Cloudflare Pages project, then redeploy."
    );
  }

  if (!context.env.PASSWORD_PEPPER) {
    return apiError(
      503,
      "password_pepper_missing",
      "Marketplace authentication is not configured. Add the PASSWORD_PEPPER secret to the Cloudflare Pages project, then redeploy."
    );
  }

  // PUBLIC_ORIGIN is safe to derive for the Pages deployment when the dashboard
  // variable has not been configured yet. Explicit dashboard configuration still
  // takes precedence, including custom domains.
  const env = {
    ...context.env,
    PUBLIC_ORIGIN: context.env.PUBLIC_ORIGIN || requestUrl.origin
  };

  try {
    const response = await marketplaceWorker.fetch(request, env);

    // The Worker intentionally hides unhandled exceptions behind a generic 500.
    // Convert that response into an actionable deployment diagnostic so the
    // existing frontend can display the real configuration problem.
    if (response.status >= 500) {
      const payload = await response.clone().json().catch(() => null);
      if (payload?.error?.code === "internal_error") {
        return apiError(
          500,
          "marketplace_backend_error",
          "The marketplace backend failed. Verify that all D1 migrations were applied and that the DB and PASSWORD_PEPPER Pages bindings are configured. Check the Pages Function logs for the underlying exception."
        );
      }
    }

    return response;
  } catch (error) {
    console.error("Unhandled KLite Pages Function error", error);
    return apiError(
      500,
      "pages_function_error",
      "The marketplace Pages Function failed. Check the Cloudflare Pages Function logs and project bindings."
    );
  }
}
