const RELEASE_BASE = "https://github.com/KSPOG/klite/releases/download/windows-client/";
const VERSION_PATTERN = /^1\.0\.\d+$/;
const BUILD_SHA_PATTERN = /^[a-f0-9]{40}$/i;
const SHA256_PATTERN = /^[a-f0-9]{64}$/i;
const ASSET_PATTERN = /^KLite-Setup-1\.0\.\d+-[a-f0-9]{16}\.exe$/i;
const MAX_INSTALLER_BYTES = 300 * 1024 * 1024;

export async function onRequest(context) {
  if (context.request.method !== "GET" && context.request.method !== "HEAD") {
    return jsonError(405, "method_not_allowed", "Only GET and HEAD are supported.", {
      allow: "GET, HEAD"
    });
  }

  const manifest = await loadManifest(context);
  const validationError = validateManifest(manifest);
  if (validationError) {
    return jsonError(503, "update_manifest_invalid", validationError);
  }

  const responseHeaders = installerHeaders(manifest);
  if (context.request.method === "HEAD") {
    return new Response(null, { status: 200, headers: responseHeaders });
  }

  const assetUrl = new URL(`${RELEASE_BASE}${manifest.assetName}`);
  // The content hash is part of both the filename and query string. The query
  // prevents an intermediary from reusing a cached response for an older asset.
  assetUrl.searchParams.set("klite_sha256", manifest.sha256.toLowerCase());

  const assetResponse = await fetch(assetUrl, {
    method: "GET",
    redirect: "follow",
    headers: {
      accept: "application/octet-stream",
      "accept-encoding": "identity",
      "cache-control": "no-store",
      "user-agent": "KLite-Update-Proxy/1.0"
    },
    cf: {
      cacheEverything: false,
      cacheTtl: 0
    }
  });

  if (!assetResponse.ok || !assetResponse.body) {
    console.error("Unable to fetch the published Windows installer", {
      status: assetResponse.status,
      assetName: manifest.assetName
    });
    return jsonError(
      503,
      "installer_unavailable",
      "The verified KLite Windows installer is temporarily unavailable."
    );
  }

  const upstreamLength = parseContentLength(assetResponse.headers.get("content-length"));
  if (upstreamLength !== null && upstreamLength !== manifest.size) {
    console.error("Published Windows installer length does not match the manifest", {
      assetName: manifest.assetName,
      expected: manifest.size,
      actual: upstreamLength
    });
    return jsonError(
      503,
      "installer_length_mismatch",
      "The KLite Windows installer is being synchronized. Try again shortly."
    );
  }

  const upstreamType = (assetResponse.headers.get("content-type") || "").toLowerCase();
  if (upstreamType.includes("text/html") || upstreamType.includes("application/json")) {
    console.error("Published Windows installer returned an unexpected content type", {
      assetName: manifest.assetName,
      contentType: upstreamType
    });
    return jsonError(
      503,
      "installer_response_invalid",
      "The KLite Windows installer host returned an invalid response."
    );
  }

  return new Response(assetResponse.body, {
    status: 200,
    headers: responseHeaders
  });
}

async function loadManifest(context) {
  const manifestUrl = new URL("/client/windows/latest.json", context.request.url);
  manifestUrl.searchParams.set("t", String(Date.now()));
  const response = await fetch(manifestUrl, {
    headers: {
      accept: "application/json",
      "cache-control": "no-store"
    },
    cf: {
      cacheEverything: false,
      cacheTtl: 0
    }
  });

  if (!response.ok) {
    return null;
  }
  return response.json().catch(() => null);
}

function validateManifest(manifest) {
  const expectedAsset = manifest
    && VERSION_PATTERN.test(manifest.version || "")
    && SHA256_PATTERN.test(manifest.sha256 || "")
      ? `KLite-Setup-${manifest.version}-${manifest.sha256.slice(0, 16).toLowerCase()}.exe`
      : null;

  if (!manifest) {
    return "The KLite Windows update manifest is temporarily unavailable.";
  }
  if (manifest.schemaVersion !== 1
      || manifest.platform !== "windows-x64"
      || !VERSION_PATTERN.test(manifest.version || "")
      || !BUILD_SHA_PATTERN.test(manifest.buildSha || "")
      || !SHA256_PATTERN.test(manifest.sha256 || "")
      || !Number.isInteger(manifest.size)
      || manifest.size <= 0
      || manifest.size > MAX_INSTALLER_BYTES
      || !ASSET_PATTERN.test(manifest.assetName || "")
      || manifest.assetName !== expectedAsset) {
    return "The KLite Windows update is being published. Try again shortly.";
  }
  return null;
}

function installerHeaders(manifest) {
  return {
    "content-type": "application/octet-stream",
    "content-length": String(manifest.size),
    "content-disposition": `attachment; filename="${manifest.assetName}"`,
    "cache-control": "private, no-store, no-cache, must-revalidate, max-age=0",
    pragma: "no-cache",
    expires: "0",
    "content-encoding": "identity",
    "x-content-type-options": "nosniff",
    "x-klite-build-sha": manifest.buildSha,
    "x-klite-installer-sha256": manifest.sha256.toLowerCase(),
    "x-klite-installer-size": String(manifest.size),
    "x-klite-installer-asset": manifest.assetName
  };
}

function parseContentLength(value) {
  if (value === null || value === "") {
    return null;
  }
  const parsed = Number(value);
  return Number.isSafeInteger(parsed) && parsed >= 0 ? parsed : null;
}

function jsonError(status, code, message, extraHeaders = {}) {
  return new Response(JSON.stringify({ error: { code, message } }), {
    status,
    headers: {
      "content-type": "application/json; charset=utf-8",
      "cache-control": "no-store",
      "x-content-type-options": "nosniff",
      ...extraHeaders
    }
  });
}
