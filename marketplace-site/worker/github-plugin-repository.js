const GITHUB_API = "https://api.github.com";
const DEFAULT_SUBMISSIONS_REPOSITORY = "KSPOG/klite-plugin-submissions";
const DEFAULT_MAIN_REPOSITORY = "KSPOG/klite";
const DEFAULT_BRANCH = "main";
const MAX_GITHUB_FILES = 110;

export class GitHubRepositoryError extends Error {
  constructor(code, message, status = 502) {
    super(message);
    this.name = "GitHubRepositoryError";
    this.code = code;
    this.status = status;
  }
}

export function githubSubmissionConfig(env) {
  const repository =
    normalizeRepository(env.GITHUB_SUBMISSIONS_REPOSITORY)
    || DEFAULT_SUBMISSIONS_REPOSITORY;
  const mainRepository =
    normalizeRepository(env.GITHUB_MAIN_REPOSITORY)
    || DEFAULT_MAIN_REPOSITORY;
  const token = String(env.GITHUB_SUBMISSIONS_TOKEN || "").trim();
  const promotionToken = String(env.GITHUB_PROMOTION_TOKEN || "").trim();
  return {
    branch: normalizeBranch(env.GITHUB_SUBMISSIONS_BRANCH) || DEFAULT_BRANCH,
    mainBranch: normalizeBranch(env.GITHUB_MAIN_BRANCH) || DEFAULT_BRANCH,
    mainRepository,
    promotionToken,
    repository,
    token
  };
}

export function hasGitHubSubmissionStorage(env) {
  return Boolean(githubSubmissionConfig(env).token);
}

export async function storePluginSource(env, submission, sourceBundle) {
  const config = githubSubmissionConfig(env);
  if (!config.token) {
    throw new GitHubRepositoryError(
      "plugin_storage_unavailable",
      "Private GitHub plugin submission storage is not connected.",
      503
    );
  }
  const root = `submissions/${submission.id}`;
  const manifestPath = `${root}/submission.json`;
  const manifest = {
    schemaVersion: 1,
    submissionId: submission.id,
    userId: submission.userId,
    pluginId: submission.pluginId,
    name: submission.name,
    version: submission.version,
    sourceUrl: submission.sourceUrl,
    description: submission.description,
    entrypoint: sourceBundle.entrypoint,
    sha256: sourceBundle.sha256,
    size: sourceBundle.size,
    files: sourceBundle.files.map((file) => ({
      path: file.path,
      size: file.size
    }))
  };
  const files = [
    ...sourceBundle.files.map((file) => ({
      path: `${root}/${file.path}`,
      bytes: file.bytes
    })),
    {
      path: manifestPath,
      bytes: new TextEncoder().encode(`${JSON.stringify(manifest, null, 2)}\n`)
    }
  ];
  const commit = await commitFilesToExistingBranch({
    branch: config.branch,
    files,
    message: `Stage plugin submission ${submission.pluginId} ${submission.version}`,
    repository: config.repository,
    token: config.token
  });
  return {
    branch: config.branch,
    commitSha: commit.sha,
    manifestPath,
    repository: config.repository,
    reviewUrl:
      `https://github.com/${config.repository}/tree/${encodeURIComponent(config.branch)}/${root}`,
    root
  };
}

export async function readPluginSourceManifest(env, artifact) {
  const config = githubSubmissionConfig(env);
  if (!config.token) {
    throw new GitHubRepositoryError(
      "plugin_storage_unavailable",
      "Private GitHub plugin submission storage is not connected.",
      503
    );
  }
  const repository = artifact.source_repository || config.repository;
  const ref = artifact.source_commit || artifact.source_ref || config.branch;
  const response = await githubRequest(
    repository,
    config.token,
    `/contents/${encodeRepositoryPath(artifact.object_key)}?ref=${encodeURIComponent(ref)}`
  );
  if (response.type !== "file" || response.encoding !== "base64") {
    throw new GitHubRepositoryError(
      "plugin_source_unavailable",
      "The private plugin source manifest is unavailable.",
      503
    );
  }
  let manifest;
  try {
    manifest = JSON.parse(decodeBase64Text(response.content));
  } catch {
    throw new GitHubRepositoryError(
      "plugin_source_invalid",
      "The private plugin source manifest is invalid.",
      503
    );
  }
  validateStoredManifest(manifest, artifact);
  return manifest;
}

export async function promotePluginSource(env, submission, artifact) {
  const config = githubSubmissionConfig(env);
  if (!config.promotionToken) {
    throw new GitHubRepositoryError(
      "plugin_promotion_unavailable",
      "GitHub promotion access is not connected.",
      503
    );
  }
  const manifest = await readPluginSourceManifest(env, artifact);
  const sourceFiles = [];
  for (const file of manifest.files) {
    const storedPath = `${artifact.source_path}/${file.path}`;
    const stored = await githubRequest(
      artifact.source_repository || config.repository,
      config.token,
      `/contents/${encodeRepositoryPath(storedPath)}?ref=${
        encodeURIComponent(artifact.source_commit || artifact.source_ref)
      }`
    );
    if (stored.type !== "file" || stored.encoding !== "base64") {
      throw new GitHubRepositoryError(
        "plugin_source_unavailable",
        `The reviewed source file ${file.path} is unavailable.`,
        503
      );
    }
    const bytes = base64ToBytes(stored.content);
    sourceFiles.push({
      bytes,
      path: `plugins/${submission.plugin_id}/${file.path}`,
      sourcePath: file.path
    });
  }
  const verified = await sourceFileDigest(sourceFiles);
  if (verified.sha256 !== manifest.sha256 || verified.size !== manifest.size) {
    throw new GitHubRepositoryError(
      "plugin_source_invalid",
      "The private plugin source failed SHA-256 verification.",
      503
    );
  }

  const settingsFile = await githubRequest(
    config.mainRepository,
    config.promotionToken,
    `/contents/settings.gradle.kts?ref=${encodeURIComponent(config.mainBranch)}`
  );
  if (settingsFile.type !== "file" || settingsFile.encoding !== "base64") {
    throw new GitHubRepositoryError(
      "plugin_promotion_unavailable",
      "The main repository Gradle settings file is unavailable.",
      503
    );
  }

  const branch = promotionBranch(submission);
  const generated = generatedProjectFiles(
    submission,
    manifest,
    decodeBase64Text(settingsFile.content)
  );
  const commit = await createBranchWithFiles({
    baseBranch: config.mainBranch,
    branch,
    files: [...sourceFiles, ...generated],
    message: `Promote ${submission.name} ${submission.version}`,
    repository: config.mainRepository,
    token: config.promotionToken
  });
  const pullRequest = await githubRequest(
    config.mainRepository,
    config.promotionToken,
    "/pulls",
    {
      method: "POST",
      body: {
        base: config.mainBranch,
        body: promotionPullRequestBody(submission, manifest),
        head: branch,
        title: `Add ${submission.name} ${submission.version}`
      }
    }
  );
  return {
    branch,
    commitSha: commit.sha,
    pullRequestNumber: pullRequest.number,
    pullRequestUrl: pullRequest.html_url,
    repository: config.mainRepository
  };
}

async function commitFilesToExistingBranch(options) {
  const blobs = await createBlobs(options.repository, options.token, options.files);
  for (let attempt = 0; attempt < 3; attempt += 1) {
    const base = await branchBase(
      options.repository,
      options.token,
      options.branch
    );
    const commit = await createCommitFromBlobs(options, blobs, base);
    try {
      await githubRequest(
        options.repository,
        options.token,
        `/git/refs/heads/${encodeRef(options.branch)}`,
        { method: "PATCH", body: { force: false, sha: commit.sha } }
      );
      return commit;
    } catch (error) {
      if (!(error instanceof GitHubRepositoryError)
          || !["github_conflict", "github_validation_failed"].includes(error.code)
          || attempt === 2) {
        throw error;
      }
    }
  }
  throw new GitHubRepositoryError(
    "github_conflict",
    "The private submission repository changed during the upload.",
    409
  );
}

async function createBranchWithFiles(options) {
  const base = await branchBase(
    options.repository,
    options.token,
    options.baseBranch
  );
  const blobs = await createBlobs(options.repository, options.token, options.files);
  const commit = await createCommitFromBlobs(options, blobs, base);
  await githubRequest(options.repository, options.token, "/git/refs", {
    method: "POST",
    body: { ref: `refs/heads/${options.branch}`, sha: commit.sha }
  });
  return commit;
}

async function branchBase(repository, token, branch) {
  const reference = await githubRequest(
    repository,
    token,
    `/git/ref/heads/${encodeRef(branch)}`
  );
  const commit = await githubRequest(
    repository,
    token,
    `/git/commits/${encodeURIComponent(reference.object.sha)}`
  );
  return { commitSha: commit.sha, treeSha: commit.tree.sha };
}

async function createBlobs(repository, token, files) {
  if (!Array.isArray(files) || files.length === 0 || files.length > MAX_GITHUB_FILES) {
    throw new GitHubRepositoryError(
      "invalid_plugin_source",
      "The source submission contains an unsupported number of files.",
      400
    );
  }
  const blobs = [];
  for (let offset = 0; offset < files.length; offset += 8) {
    const batch = files.slice(offset, offset + 8);
    const created = await Promise.all(batch.map(async (file) => {
      const blob = await githubRequest(repository, token, "/git/blobs", {
        method: "POST",
        body: { content: bytesToBase64(file.bytes), encoding: "base64" }
      });
      return { path: file.path, sha: blob.sha };
    }));
    blobs.push(...created);
  }
  return blobs;
}

async function createCommitFromBlobs(options, blobs, base) {
  const tree = await githubRequest(options.repository, options.token, "/git/trees", {
    method: "POST",
    body: {
      base_tree: base.treeSha,
      tree: blobs.map((blob) => ({
        mode: "100644",
        path: blob.path,
        sha: blob.sha,
        type: "blob"
      }))
    }
  });
  return githubRequest(options.repository, options.token, "/git/commits", {
    method: "POST",
    body: {
      message: options.message,
      parents: [base.commitSha],
      tree: tree.sha
    }
  });
}

async function githubRequest(repository, token, path, options = {}) {
  const response = await fetch(`${GITHUB_API}/repos/${repository}${path}`, {
    method: options.method || "GET",
    headers: {
      accept: "application/vnd.github+json",
      authorization: `Bearer ${token}`,
      "content-type": "application/json",
      "user-agent": "KLite-Marketplace",
      "x-github-api-version": "2022-11-28"
    },
    body: options.body ? JSON.stringify(options.body) : undefined
  });
  if (response.ok) {
    return response.status === 204 ? null : response.json();
  }
  const code = response.status === 409
    ? "github_conflict"
    : response.status === 422
      ? "github_validation_failed"
      : response.status === 404
        ? "github_resource_not_found"
        : "github_request_failed";
  throw new GitHubRepositoryError(
    code,
    `GitHub repository operation failed with HTTP ${response.status}.`,
    response.status === 409 || response.status === 422 ? 409 : 502
  );
}

function validateStoredManifest(manifest, artifact) {
  if (!manifest || manifest.schemaVersion !== 1
      || manifest.submissionId !== artifact.submission_id
      || manifest.sha256 !== artifact.sha256
      || manifest.size !== artifact.size
      || !Array.isArray(manifest.files)
      || manifest.files.length !== artifact.source_file_count
      || manifest.files.some((file) =>
        !file || !Number.isSafeInteger(file.size) || file.size <= 0
        || typeof file.path !== "string"
        || !/^src\/main\/java\/(?:[A-Za-z_$][A-Za-z0-9_$]*\/)+[A-Za-z_$][A-Za-z0-9_$]*\.java$/
          .test(file.path)
      )) {
    throw new GitHubRepositoryError(
      "plugin_source_invalid",
      "The private plugin source manifest failed verification.",
      503
    );
  }
}

function generatedProjectFiles(submission, manifest, settings) {
  const pluginRoot = `plugins/${submission.plugin_id}`;
  const build = `plugins {
    java
}

group = "community.klite.plugins"
version = "${submission.version}"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

dependencies {
    compileOnly(project(":client"))
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
    options.release.set(11)
}

tasks.jar {
    archiveFileName.set("${submission.plugin_id}-${submission.version}.jar")
    isPreserveFileTimestamps = false
    isReproducibleFileOrder = true
}
`;
  const review = {
    schemaVersion: 1,
    submissionId: submission.id,
    sourceRepository: submission.source_repository,
    sourceCommit: submission.source_commit,
    sourceSha256: manifest.sha256,
    entrypoint: manifest.entrypoint
  };
  const projectName = `community-${submission.plugin_id}`;
  const projectDirectory = `./plugins/${submission.plugin_id}`;
  const projectDeclaration =
    `include("${projectName}")\n`
    + `project(":${projectName}").projectDir = file("${projectDirectory}")`;
  const nextSettings = settings.includes(`projectDir = file("${projectDirectory}")`)
    ? settings
    : `${settings.trimEnd()}\n${projectDeclaration}\n`;
  return [
    {
      path: `${pluginRoot}/build.gradle.kts`,
      bytes: new TextEncoder().encode(build)
    },
    {
      path: `${pluginRoot}/KLITE_SUBMISSION.json`,
      bytes: new TextEncoder().encode(`${JSON.stringify(review, null, 2)}\n`)
    },
    {
      path: "settings.gradle.kts",
      bytes: new TextEncoder().encode(nextSettings)
    }
  ];
}

async function sourceFileDigest(files) {
  const encoder = new TextEncoder();
  const parts = [];
  let length = 0;
  let size = 0;
  const sorted = [...files].sort((left, right) =>
    left.sourcePath.localeCompare(right.sourcePath));
  for (const file of sorted) {
    const path = encoder.encode(`${file.sourcePath}\u0000${file.bytes.byteLength}\u0000`);
    parts.push(path, file.bytes);
    length += path.byteLength + file.bytes.byteLength;
    size += file.bytes.byteLength;
  }
  const combined = new Uint8Array(length);
  let offset = 0;
  for (const part of parts) {
    combined.set(part, offset);
    offset += part.byteLength;
  }
  const digest = await crypto.subtle.digest("SHA-256", combined);
  return {
    sha256: Array.from(new Uint8Array(digest))
      .map((value) => value.toString(16).padStart(2, "0"))
      .join(""),
    size
  };
}

function promotionPullRequestBody(submission, manifest) {
  return [
    "## KLite plugin submission",
    "",
    `- Plugin: \`${submission.plugin_id}\``,
    `- Version: \`${submission.version}\``,
    `- Entrypoint: \`${manifest.entrypoint}\``,
    `- Source digest: \`${manifest.sha256}\``,
    `- Submission: \`${submission.id}\``,
    "",
    "This pull request was created after marketplace reviewer approval.",
    "The submitted source must still pass repository CI before merge."
  ].join("\n");
}

function promotionBranch(submission) {
  const id = String(submission.id).replace(/[^a-zA-Z0-9-]/g, "").slice(0, 12);
  return `plugin-submission/${submission.plugin_id}-${submission.version}-${id}`
    .replace(/[^a-zA-Z0-9/._-]/g, "-");
}

function normalizeRepository(value) {
  const candidate = String(value || "").trim();
  return /^[A-Za-z0-9_.-]+\/[A-Za-z0-9_.-]+$/.test(candidate) ? candidate : null;
}

function normalizeBranch(value) {
  const candidate = String(value || "").trim();
  return candidate && !candidate.includes("..") && !candidate.endsWith(".lock")
    && /^[A-Za-z0-9/._-]+$/.test(candidate)
    ? candidate
    : null;
}

function encodeRepositoryPath(path) {
  return String(path).split("/").map(encodeURIComponent).join("/");
}

function encodeRef(ref) {
  return String(ref).split("/").map(encodeURIComponent).join("/");
}

function bytesToBase64(bytes) {
  let binary = "";
  for (let offset = 0; offset < bytes.length; offset += 0x8000) {
    binary += String.fromCharCode(...bytes.subarray(offset, offset + 0x8000));
  }
  return btoa(binary);
}

function base64ToBytes(value) {
  const binary = atob(String(value || "").replace(/\s/g, ""));
  const bytes = new Uint8Array(binary.length);
  for (let index = 0; index < binary.length; index += 1) {
    bytes[index] = binary.charCodeAt(index);
  }
  return bytes;
}

function decodeBase64Text(value) {
  return new TextDecoder().decode(base64ToBytes(value));
}
