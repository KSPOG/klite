import {
  MAX_PLUGIN_SOURCE_BYTES,
  preparePluginSource,
  sourceSubmissionDownloadHeaders
} from "./plugin-submission-source.js";
import {
  GitHubRepositoryError,
  hasGitHubSubmissionStorage,
  promotePluginSource,
  readPluginSourceManifest,
  storePluginSource
} from "./github-plugin-repository.js";

export async function handlePluginSourceSubmissions(request, env, url, dependencies) {
  const { apiError, requireCapability, requireWebsiteRole } = dependencies;

  if (url.pathname === "/api/developer/submissions" && request.method === "GET") {
    const session = await requireCapability(request, env, "plugin_dev");
    if (!session) return developerRequired(apiError);
    return listDeveloperSubmissions(env, session.user_id, dependencies.json);
  }

  if (url.pathname === "/api/developer/submissions" && request.method === "POST") {
    const session = await requireCapability(request, env, "plugin_dev");
    if (!session) return developerRequired(apiError);
    return createPluginSubmission(request, env, session, dependencies);
  }

  const developerSource =
    url.pathname.match(/^\/api\/developer\/submissions\/([a-f0-9-]+)\/source$/);
  if (developerSource && request.method === "GET") {
    const session = await requireCapability(request, env, "plugin_dev");
    if (!session) return developerRequired(apiError);
    return downloadSubmissionManifest(
      env,
      developerSource[1],
      apiError,
      session.user_id
    );
  }

  if (url.pathname === "/api/review/submissions" && request.method === "GET") {
    const session = await requireWebsiteRole(request, env, "marketplace_reviewer");
    if (!session) return reviewerRequired(apiError);
    return listReviewSubmissions(env, dependencies.json);
  }

  const reviewSource =
    url.pathname.match(/^\/api\/review\/submissions\/([a-f0-9-]+)\/source$/);
  if (reviewSource && request.method === "GET") {
    const session = await requireWebsiteRole(request, env, "marketplace_reviewer");
    if (!session) return reviewerRequired(apiError);
    return downloadSubmissionManifest(env, reviewSource[1], apiError);
  }

  const reviewDecision =
    url.pathname.match(/^\/api\/review\/submissions\/([a-f0-9-]+)\/decision$/);
  if (reviewDecision && request.method === "POST") {
    const session = await requireWebsiteRole(request, env, "marketplace_reviewer");
    if (!session) return reviewerRequired(apiError);
    return reviewPluginSubmission(
      request,
      env,
      reviewDecision[1],
      session,
      dependencies
    );
  }

  return null;
}

async function listDeveloperSubmissions(env, userId, json) {
  const result = await env.DB.prepare(
    `SELECT plugin_submissions.id, plugin_id, name, version, source_url, description, status,
      review_notes, submitted_at, updated_at, reviewed_at,
      original_filename AS artifact_filename, sha256 AS artifact_sha256,
      size AS artifact_size, uploaded_at AS artifact_uploaded_at,
      source_file_count, source_entrypoint, promoted_repository, promoted_ref,
      promoted_commit, promotion_pr_url
     FROM plugin_submissions
     LEFT JOIN plugin_submission_artifacts
       ON plugin_submission_artifacts.submission_id = plugin_submissions.id
     WHERE user_id = ? ORDER BY updated_at DESC`
  ).bind(userId).all();
  return json({ submissions: (result.results || []).map(submissionPayload) });
}

async function createPluginSubmission(request, env, session, dependencies) {
  const {
    apiError,
    isConstraintError,
    json,
    normalizePluginId,
    normalizeSourceUrl,
    normalizeText,
    normalizeVersion,
    nowSeconds
  } = dependencies;

  if (!hasGitHubSubmissionStorage(env)) {
    return apiError(503, "plugin_storage_unavailable",
      "Private GitHub plugin submission storage is not connected.");
  }
  if (!request.headers.get("content-type")?.toLowerCase().startsWith("multipart/form-data")) {
    return apiError(415, "multipart_required",
      "Submit plugin metadata and raw Java source as multipart form data.");
  }
  const declaredLength = Number(request.headers.get("content-length") || 0);
  if (declaredLength > MAX_PLUGIN_SOURCE_BYTES + 256 * 1024) {
    return apiError(413, "plugin_source_too_large",
      "The complete plugin source submission must be 20 MiB or smaller.");
  }
  const form = await request.formData().catch(() => null);
  if (!form) {
    return apiError(400, "invalid_submission_form", "The plugin submission form is invalid.");
  }

  const pluginId = normalizePluginId(form.get("pluginId"));
  const name = normalizeText(form.get("name"), 3, 80);
  const version = normalizeVersion(form.get("version"));
  const sourceUrl = normalizeSourceUrl(form.get("sourceUrl"));
  const description = normalizeText(form.get("description"), 30, 2000);
  if (!pluginId || !name || !version || !sourceUrl || !description) {
    return apiError(400, "invalid_submission",
      "Enter a valid plugin ID, name, semantic version, HTTPS source URL, and description.");
  }

  const sourceBundle = await preparePluginSource(form.getAll("sources"));
  if (sourceBundle.error) {
    return apiError(400, "invalid_plugin_source", sourceBundle.error);
  }

  const now = nowSeconds();
  const id = crypto.randomUUID();
  let storedSource;
  try {
    storedSource = await storePluginSource(env, {
      description,
      id,
      name,
      pluginId,
      sourceUrl,
      userId: session.user_id,
      version
    }, sourceBundle);
  } catch (error) {
    return githubErrorResponse(error, apiError);
  }

  try {
    const submission = env.DB.prepare(
      `INSERT INTO plugin_submissions
        (id, user_id, plugin_id, name, version, source_url, description, submitted_at, updated_at)
       VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)`
    ).bind(id, session.user_id, pluginId, name, version, sourceUrl,
      description, now, now);
    const storedArtifact = env.DB.prepare(
      `INSERT INTO plugin_submission_artifacts
        (submission_id, object_key, original_filename, content_type, sha256, size,
         uploaded_at, storage_provider, source_repository, source_ref, source_commit,
         source_path, source_file_count, source_entrypoint)
       VALUES (?, ?, ?, ?, ?, ?, ?, 'github', ?, ?, ?, ?, ?, ?)`
    ).bind(
      id,
      storedSource.manifestPath,
      `${sourceBundle.fileCount} Java source files`,
      "application/vnd.klite.plugin-source+json",
      sourceBundle.sha256,
      sourceBundle.size,
      now,
      storedSource.repository,
      storedSource.branch,
      storedSource.commitSha,
      storedSource.root,
      sourceBundle.fileCount,
      sourceBundle.entrypoint
    );
    await env.DB.batch([submission, storedArtifact]);
  } catch (error) {
    if (isConstraintError(error)) {
      return apiError(409, "submission_exists",
        "This plugin version has already been submitted.");
    }
    throw error;
  }

  const row = await env.DB.prepare(
    `${submissionSelect()}
     WHERE plugin_submissions.id = ?`
  ).bind(id).first();
  return json({ submission: submissionPayload(row) }, 201);
}

async function listReviewSubmissions(env, json) {
  const result = await env.DB.prepare(
    `SELECT plugin_submissions.id, plugin_id, name, version, source_url, description,
      status, review_notes, submitted_at, plugin_submissions.updated_at, reviewed_at,
      users.username AS submitter, original_filename AS artifact_filename,
      sha256 AS artifact_sha256, size AS artifact_size,
      uploaded_at AS artifact_uploaded_at, source_file_count, source_entrypoint,
      source_repository, source_ref, source_commit, source_path,
      promoted_repository, promoted_ref, promoted_commit, promotion_pr_url
     FROM plugin_submissions JOIN users ON users.id = plugin_submissions.user_id
     LEFT JOIN plugin_submission_artifacts
       ON plugin_submission_artifacts.submission_id = plugin_submissions.id
     WHERE status IN ('pending', 'changes_requested')
     ORDER BY plugin_submissions.updated_at ASC LIMIT 100`
  ).all();
  return json({
    submissions: (result.results || []).map((row) => submissionPayload(row, true))
  });
}

async function reviewPluginSubmission(
  request,
  env,
  submissionId,
  session,
  dependencies
) {
  const { apiError, json, nowSeconds, readJson } = dependencies;
  const body = await readJson(request);
  const decision = body?.decision;
  const notes = typeof body?.notes === "string" ? body.notes.trim() : "";
  if (!["approved", "rejected", "changes_requested"].includes(decision)
      || notes.length > 2000 || (decision !== "approved" && notes.length < 10)) {
    return apiError(400, "invalid_review",
      "Choose a valid decision and provide at least 10 characters of notes when not approving.");
  }

  if (decision === "approved") {
    return approvePluginSubmission(
      env,
      submissionId,
      session,
      notes,
      dependencies
    );
  }

  const now = nowSeconds();
  const result = await env.DB.prepare(
    `UPDATE plugin_submissions
     SET status = ?, review_notes = ?, reviewed_by = ?, reviewed_at = ?, updated_at = ?
     WHERE id = ? AND status IN ('pending', 'changes_requested')`
  ).bind(decision, notes, session.user_id, now, now, submissionId).run();
  if (!result.meta?.changes) {
    return apiError(409, "submission_not_reviewable",
      "The submission was already reviewed or does not exist.");
  }
  return json({ ok: true, status: decision });
}

async function approvePluginSubmission(
  env,
  submissionId,
  session,
  notes,
  dependencies
) {
  const { apiError, json, nowSeconds } = dependencies;
  const artifact = await env.DB.prepare(
    `SELECT plugin_submission_artifacts.*, plugin_submissions.plugin_id,
      plugin_submissions.name, plugin_submissions.version,
      plugin_submissions.source_url, plugin_submissions.description
     FROM plugin_submission_artifacts
     JOIN plugin_submissions ON plugin_submissions.id = submission_id
     WHERE submission_id = ?
       AND plugin_submissions.status IN ('pending', 'changes_requested')`
  ).bind(submissionId).first();
  if (!artifact || artifact.storage_provider !== "github") {
    return apiError(409, "plugin_source_required",
      "Upload and review the raw Java source before approving this submission.");
  }

  let promotion;
  try {
    promotion = await promotePluginSource(env, {
      ...artifact,
      id: submissionId
    }, artifact);
  } catch (error) {
    return githubErrorResponse(error, apiError);
  }

  const now = nowSeconds();
  await env.DB.prepare(
    `UPDATE plugin_submission_artifacts
     SET promoted_repository = ?, promoted_ref = ?, promoted_commit = ?,
       promotion_pr_url = ?, promoted_at = ?
     WHERE submission_id = ?`
  ).bind(
    promotion.repository,
    promotion.branch,
    promotion.commitSha,
    promotion.pullRequestUrl,
    now,
    submissionId
  ).run();
  const result = await env.DB.prepare(
    `UPDATE plugin_submissions
     SET status = 'approved', review_notes = ?, reviewed_by = ?, reviewed_at = ?, updated_at = ?
     WHERE id = ? AND status IN ('pending', 'changes_requested')`
  ).bind(notes || null, session.user_id, now, now, submissionId).run();
  if (!result.meta?.changes) {
    return apiError(409, "submission_not_reviewable",
      "The submission was already reviewed or does not exist.");
  }
  return json({
    ok: true,
    status: "approved",
    pullRequest: {
      number: promotion.pullRequestNumber,
      url: promotion.pullRequestUrl
    }
  });
}

async function downloadSubmissionManifest(env, submissionId, apiError, ownerId = null) {
  if (!hasGitHubSubmissionStorage(env)) {
    return apiError(503, "plugin_storage_unavailable",
      "Private GitHub plugin submission storage is not connected.");
  }
  const ownershipClause = ownerId ? " AND plugin_submissions.user_id = ?" : "";
  const statement = env.DB.prepare(
    `SELECT plugin_submissions.plugin_id, plugin_submissions.version,
      plugin_submission_artifacts.submission_id, object_key, original_filename,
      sha256, size, storage_provider, source_repository, source_ref,
      source_commit, source_path, source_file_count, source_entrypoint
     FROM plugin_submission_artifacts
     JOIN plugin_submissions ON plugin_submissions.id = submission_id
     WHERE submission_id = ?${ownershipClause}`
  );
  const artifact = ownerId
    ? await statement.bind(submissionId, ownerId).first()
    : await statement.bind(submissionId).first();
  if (!artifact) {
    return apiError(404, "plugin_source_not_found",
      "The submitted plugin source was not found.");
  }
  let manifest;
  try {
    manifest = await readPluginSourceManifest(env, artifact);
  } catch (error) {
    return githubErrorResponse(error, apiError);
  }
  return new Response(`${JSON.stringify(manifest, null, 2)}\n`, {
    status: 200,
    headers: sourceSubmissionDownloadHeaders(artifact)
  });
}

function submissionSelect() {
  return `SELECT plugin_submissions.id, plugin_id, name, version, source_url, description,
      status, review_notes, submitted_at, updated_at, reviewed_at,
      original_filename AS artifact_filename, sha256 AS artifact_sha256,
      size AS artifact_size, uploaded_at AS artifact_uploaded_at,
      source_file_count, source_entrypoint, promoted_repository, promoted_ref,
      promoted_commit, promotion_pr_url
     FROM plugin_submissions
     JOIN plugin_submission_artifacts
       ON plugin_submission_artifacts.submission_id = plugin_submissions.id`;
}

function submissionPayload(row, includeReviewUrl = false) {
  return {
    id: row.id,
    pluginId: row.plugin_id,
    name: row.name,
    version: row.version,
    sourceUrl: row.source_url,
    description: row.description,
    status: row.status,
    reviewNotes: row.review_notes,
    submitter: row.submitter,
    submittedAt: row.submitted_at,
    updatedAt: row.updated_at,
    reviewedAt: row.reviewed_at,
    artifact: row.artifact_sha256 ? {
      entrypoint: row.source_entrypoint,
      fileCount: row.source_file_count,
      filename: row.artifact_filename,
      reviewUrl: includeReviewUrl && row.source_repository && row.source_path
        ? `https://github.com/${row.source_repository}/tree/${
          encodeURIComponent(row.source_commit || row.source_ref)
        }/${row.source_path}`
        : null,
      sha256: row.artifact_sha256,
      size: row.artifact_size,
      uploadedAt: row.artifact_uploaded_at
    } : null,
    promotion: row.promotion_pr_url ? {
      commit: row.promoted_commit,
      pullRequestUrl: row.promotion_pr_url,
      ref: row.promoted_ref,
      repository: row.promoted_repository
    } : null
  };
}

function githubErrorResponse(error, apiError) {
  if (error instanceof GitHubRepositoryError) {
    return apiError(error.status, error.code, error.message);
  }
  throw error;
}

function developerRequired(apiError) {
  return apiError(403, "plugin_developer_required",
    "A verified website and Discord Plugin Dev role is required.");
}

function reviewerRequired(apiError) {
  return apiError(403, "reviewer_required", "Marketplace reviewer access is required.");
}
