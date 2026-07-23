export const MAX_PLUGIN_SOURCE_BYTES = 20 * 1024 * 1024;
export const MAX_PLUGIN_SOURCE_FILE_BYTES = 1024 * 1024;
export const MAX_PLUGIN_SOURCE_FILES = 100;

const JAVA_CONTENT_TYPES = new Set([
  "",
  "application/octet-stream",
  "text/plain",
  "text/x-java-source"
]);
const JAVA_FILENAME = /^[A-Za-z_$][A-Za-z0-9_$]*\.java$/;
const PACKAGE_DECLARATION =
  /^\s*package\s+([A-Za-z_$][A-Za-z0-9_$]*(?:\.[A-Za-z_$][A-Za-z0-9_$]*)*)\s*;/m;
const PLUGIN_ENTRYPOINT =
  /@PluginDescriptor\b[\s\S]*?\bclass\s+([A-Za-z_$][A-Za-z0-9_$]*)\b[\s\S]*?\bextends\s+Plugin\b/;

export async function preparePluginSource(files) {
  const selected = Array.from(files || []);
  if (selected.length === 0) {
    return { error: "Choose the raw Java source files for the plugin." };
  }
  if (selected.length > MAX_PLUGIN_SOURCE_FILES) {
    return { error: `A submission can contain at most ${MAX_PLUGIN_SOURCE_FILES} Java files.` };
  }

  const prepared = [];
  let totalSize = 0;
  let entrypoint = null;
  const seenPaths = new Set();
  for (const file of selected) {
    const validationError = validatePluginSourceFile(file);
    if (validationError) {
      return { error: validationError };
    }
    totalSize += file.size;
    if (totalSize > MAX_PLUGIN_SOURCE_BYTES) {
      return { error: "The complete Java source submission must be 20 MiB or smaller." };
    }

    const bytes = new Uint8Array(await file.arrayBuffer());
    let source;
    try {
      source = new TextDecoder("utf-8", { fatal: true }).decode(bytes);
    } catch {
      return { error: `${file.name} is not valid UTF-8 source code.` };
    }
    if (source.includes("\u0000")) {
      return { error: `${file.name} contains invalid binary data.` };
    }

    const packageMatch = source.match(PACKAGE_DECLARATION);
    if (!packageMatch) {
      return { error: `${file.name} must declare a Java package.` };
    }
    const relativePath =
      `src/main/java/${packageMatch[1].replaceAll(".", "/")}/${file.name}`;
    if (seenPaths.has(relativePath)) {
      return { error: `The source path ${relativePath} was submitted more than once.` };
    }
    seenPaths.add(relativePath);

    const pluginMatch = source.match(PLUGIN_ENTRYPOINT);
    if (pluginMatch && file.name === `${pluginMatch[1]}.java`) {
      const candidate = `${packageMatch[1]}.${pluginMatch[1]}`;
      if (entrypoint && entrypoint !== candidate) {
        return { error: "Submit exactly one @PluginDescriptor class that extends Plugin." };
      }
      entrypoint = candidate;
    }
    prepared.push({
      bytes,
      filename: file.name,
      path: relativePath,
      size: bytes.byteLength
    });
  }

  if (!entrypoint) {
    return {
      error: "The source must contain one @PluginDescriptor class that extends Plugin."
    };
  }

  prepared.sort((left, right) => left.path.localeCompare(right.path));
  const sha256 = await sourceBundleSha256(prepared);
  return {
    entrypoint,
    files: prepared,
    fileCount: prepared.length,
    sha256,
    size: totalSize
  };
}

export function validatePluginSourceFile(file) {
  if (!file || typeof file.arrayBuffer !== "function") {
    return "Choose the raw Java source files for the plugin.";
  }
  if (typeof file.name !== "string" || !JAVA_FILENAME.test(file.name)) {
    return "Every uploaded plugin source file must use a safe .java filename.";
  }
  if (!Number.isSafeInteger(file.size) || file.size <= 0) {
    return `${file.name} is empty.`;
  }
  if (file.size > MAX_PLUGIN_SOURCE_FILE_BYTES) {
    return `${file.name} must be 1 MiB or smaller.`;
  }
  const type = String(file.type || "").toLowerCase();
  return JAVA_CONTENT_TYPES.has(type)
    ? null
    : `${file.name} does not have a supported Java source content type.`;
}

export function sourceSubmissionDownloadHeaders(submission) {
  const pluginId = String(submission.plugin_id || "plugin")
    .replace(/[^a-z0-9-]/gi, "-");
  const version = String(submission.version || "submission")
    .replace(/[^a-z0-9._-]/gi, "-");
  return {
    "content-type": "application/json; charset=utf-8",
    "content-disposition":
      `attachment; filename="${pluginId}-${version}-source-manifest.json"`,
    "cache-control": "private, no-store",
    "x-content-type-options": "nosniff",
    "x-klite-source-sha256": submission.sha256
  };
}

async function sourceBundleSha256(files) {
  const encoder = new TextEncoder();
  const parts = [];
  let length = 0;
  for (const file of files) {
    const path = encoder.encode(`${file.path}\u0000${file.size}\u0000`);
    parts.push(path, file.bytes);
    length += path.byteLength + file.bytes.byteLength;
  }
  const combined = new Uint8Array(length);
  let offset = 0;
  for (const part of parts) {
    combined.set(part, offset);
    offset += part.byteLength;
  }
  const digest = await crypto.subtle.digest("SHA-256", combined);
  return Array.from(new Uint8Array(digest))
    .map((value) => value.toString(16).padStart(2, "0"))
    .join("");
}
