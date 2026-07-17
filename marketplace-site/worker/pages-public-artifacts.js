const encoder = new TextEncoder();
const PUBLIC_ACCESS_TYPES = new Set(["Free", "Public"]);
const PLUGIN_ID_PATTERN = /^[a-z0-9](?:[a-z0-9-]{0,62}[a-z0-9])?$/;
const VERSION_PATTERN = /^[0-9]+\.[0-9]+\.[0-9]+(?:[-+][0-9A-Za-z.-]+)?$/;
const MAX_ARTIFACT_BYTES = 20 * 1024 * 1024;

/**
 * Serves immutable Free/Public plugin JARs from the Pages static deployment.
 * Supporter and Premium artifacts continue through the authenticated D1/R2 route.
 *
 * @returns {Promise<Response|null>} A verified artifact response, or null when the
 * request is not for a statically hosted public artifact.
 */
export async function handlePublicArtifact(request, env, url = new URL(request.url)) {
  if (request.method !== "GET") {
    return null;
  }

  const match = url.pathname.match(
    /^\/api\/client\/plugins\/([a-z0-9][a-z0-9-]{0,63})\/artifact$/
  );
  if (!match) {
    return null;
  }

  const pluginId = match[1];
  const version = url.searchParams.get("version") || "";
  if (!PLUGIN_ID_PATTERN.test(pluginId) || !VERSION_PATTERN.test(version)) {
    return null;
  }

  const origin = new URL(env.PUBLIC_ORIGIN || url.origin).origin;
  const catalogResponse = await fetch(new URL("/plugins.json", origin), {
    headers: { accept: "application/json", "cache-control": "no-store" }
  });
  if (!catalogResponse.ok) {
    return apiError(503, "catalog_unavailable", "The marketplace catalog is temporarily unavailable.");
  }

  const catalog = await catalogResponse.json().catch(() => null);
  const plugin = Array.isArray(catalog?.plugins)
    ? catalog.plugins.find((entry) => entry?.id === pluginId)
    : null;
  const accessType = plugin?.type || plugin?.access;
  const artifact = plugin?.artifact;
  if (!plugin
      || plugin.status !== "available"
      || !PUBLIC_ACCESS_TYPES.has(accessType)
      || artifact?.version !== version
      || typeof artifact.sha256 !== "string"
      || !/^[a-f0-9]{64}$/.test(artifact.sha256)
      || !Number.isInteger(artifact.size)
      || artifact.size <= 0
      || artifact.size > MAX_ARTIFACT_BYTES) {
    return null;
  }

  const artifactPath = `/artifacts/${pluginId}-${version}.jar`;
  const staticResponse = await fetch(new URL(artifactPath, origin), {
    headers: { accept: "application/java-archive", "cache-control": "no-store" }
  });
  if (!staticResponse.ok) {
    console.error("Published public plugin artifact is missing", pluginId, version);
    return apiError(503, "artifact_unavailable", "The plugin artifact is temporarily unavailable.");
  }

  const bytes = new Uint8Array(await staticResponse.arrayBuffer());
  if (bytes.byteLength !== artifact.size) {
    console.error("Published public plugin artifact size mismatch", pluginId, version);
    return apiError(503, "artifact_invalid", "The plugin artifact failed server validation.");
  }

  const actualHash = await sha256Hex(bytes);
  if (!constantTimeEqual(actualHash, artifact.sha256)) {
    console.error("Published public plugin artifact hash mismatch", pluginId, version);
    return apiError(503, "artifact_invalid", "The plugin artifact failed server validation.");
  }

  return new Response(bytes, {
    status: 200,
    headers: {
      "content-type": "application/java-archive",
      "content-length": String(bytes.byteLength),
      "cache-control": "private, no-store",
      "x-content-type-options": "nosniff",
      "x-klite-plugin-version": version,
      "x-klite-plugin-sha256": artifact.sha256
    }
  });
}

async function sha256Hex(bytes) {
  const digest = await crypto.subtle.digest("SHA-256", bytes);
  return Array.from(new Uint8Array(digest), (value) => value.toString(16).padStart(2, "0")).join("");
}

function constantTimeEqual(left, right) {
  const leftBytes = encoder.encode(left);
  const rightBytes = encoder.encode(right);
  let difference = leftBytes.length ^ rightBytes.length;
  const length = Math.min(leftBytes.length, rightBytes.length);
  for (let index = 0; index < length; index += 1) {
    difference |= leftBytes[index] ^ rightBytes[index];
  }
  return difference === 0;
}

function apiError(status, code, message) {
  return new Response(JSON.stringify({ error: { code, message } }), {
    status,
    headers: {
      "content-type": "application/json; charset=utf-8",
      "cache-control": "no-store",
      "x-content-type-options": "nosniff"
    }
  });
}
