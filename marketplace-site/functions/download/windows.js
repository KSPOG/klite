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

  const manifestUrl = new URL("/client/windows/latest.json", context.request.url);
  const manifestResponse = await fetch(manifestUrl, {
    headers: {
      accept: "application/json",
      "cache-control": "no-store"
    }
  });

  if (!manifestResponse.ok) {
    return jsonError(
      503,
      "update_manifest_unavailable",
      "The KLite Windows update manifest is temporarily unavailable."
    );
  }

  const manifest = await manifestResponse.json().catch(() => null);
  const expectedAsset = manifest
    && VERSION_PATTERN.test(manifest.version || "")
    && SHA256_PATTERN.test(manifest.sha256 || "")
      ? `KLite-Setup-${manifest.version}-${manifest.sha256.slice(0, 16).toLowerCase()}.exe`
      : null;

  if (!manifest
      || manifest.schemaVersion !== 1
      || manifest.platform !== "windows-x64"
      || !VERSION_PATTERN.test(manifest.version || "")
      || !BUILD_SHA_PATTERN.test(manifest.buildSha || "")
      || !SHA256_PATTERN.test(manifest.sha256 || "")
      || !Number.isInteger(manifest.size)
      || manifest.size <= 0
      || manifest.size > MAX_INSTALLER_BYTES
      || !ASSET_PATTERN.test(manifest.assetName || "")
      || manifest.assetName !== expectedAsset) {
    return jsonError(
      503,
      "update_manifest_invalid",
      "The KLite Windows update is being published. Try again shortly."
    );
  }

  const location = `${RELEASE_BASE}${manifest.assetName}`;
  return new Response(null, {
    status: 302,
    headers: {
      location,
      "cache-control": "private, no-store",
      "x-content-type-options": "nosniff",
      "x-klite-build-sha": manifest.buildSha,
      "x-klite-installer-sha256": manifest.sha256,
      "x-klite-installer-size": String(manifest.size)
    }
  });
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
