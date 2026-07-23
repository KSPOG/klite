export const MAX_PLUGIN_ARTIFACT_BYTES = 20 * 1024 * 1024;

const ACCEPTED_CONTENT_TYPES = new Set([
  "",
  "application/java-archive",
  "application/octet-stream",
  "application/zip",
  "application/x-java-archive"
]);

export async function preparePluginArtifact(file, identity) {
  const error = validatePluginArtifactFile(file);
  if (error) {
    return { error };
  }

  const bytes = new Uint8Array(await file.arrayBuffer());
  if (!hasZipHeader(bytes)) {
    return { error: "The uploaded file is not a valid JAR archive." };
  }

  const sha256 = await sha256Hex(bytes);
  return {
    bytes,
    sha256,
    size: bytes.byteLength,
    filename: safeJarFilename(file.name, identity.pluginId, identity.version),
    contentType: "application/java-archive",
    objectKey: submissionArtifactObjectKey(identity.userId, identity.submissionId, sha256)
  };
}

export function validatePluginArtifactFile(file) {
  if (!file || typeof file.arrayBuffer !== "function") {
    return "Choose the compiled plugin JAR to submit.";
  }
  if (typeof file.name !== "string" || !file.name.toLowerCase().endsWith(".jar")) {
    return "Plugin uploads must use the .jar file extension.";
  }
  if (!Number.isSafeInteger(file.size) || file.size <= 0) {
    return "The plugin JAR is empty.";
  }
  if (file.size > MAX_PLUGIN_ARTIFACT_BYTES) {
    return "The plugin JAR must be 20 MiB or smaller.";
  }
  const type = String(file.type || "").toLowerCase();
  return ACCEPTED_CONTENT_TYPES.has(type)
    ? null
    : "The selected file does not have a supported JAR content type.";
}

export function hasZipHeader(bytes) {
  if (!bytes || bytes.byteLength < 4 || bytes[0] !== 0x50 || bytes[1] !== 0x4b) {
    return false;
  }
  return (bytes[2] === 0x03 && bytes[3] === 0x04)
    || (bytes[2] === 0x05 && bytes[3] === 0x06)
    || (bytes[2] === 0x07 && bytes[3] === 0x08);
}

export function submissionArtifactObjectKey(userId, submissionId, sha256) {
  const owner = String(userId).replace(/[^a-zA-Z0-9-]/g, "");
  const submission = String(submissionId).replace(/[^a-zA-Z0-9-]/g, "");
  return `submissions/${owner}/${submission}/${sha256}.jar`;
}

export function safeJarFilename(filename, pluginId, version) {
  const cleaned = String(filename || "")
    .replace(/[\u0000-\u001f\u007f"\\/:*?<>|]/g, "-")
    .replace(/\s+/g, " ")
    .trim();
  if (cleaned && cleaned.toLowerCase().endsWith(".jar") && cleaned.length <= 160) {
    return cleaned;
  }
  return `${pluginId}-${version}.jar`;
}

export function artifactDownloadHeaders(artifact) {
  const filename = safeJarFilename(
    artifact.original_filename,
    artifact.plugin_id || "plugin",
    artifact.version || "submission"
  );
  return {
    "content-type": "application/java-archive",
    "content-length": String(artifact.size),
    "content-disposition": `attachment; filename="${filename}"`,
    "cache-control": "private, no-store",
    "x-content-type-options": "nosniff",
    "x-klite-artifact-sha256": artifact.sha256
  };
}

async function sha256Hex(bytes) {
  const digest = await crypto.subtle.digest("SHA-256", bytes);
  return Array.from(new Uint8Array(digest))
    .map((value) => value.toString(16).padStart(2, "0"))
    .join("");
}
