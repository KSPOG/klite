import {
  artifactDownloadHeaders,
  MAX_PLUGIN_ARTIFACT_BYTES,
  preparePluginArtifact
} from "./plugin-submission-artifacts.js";

export async function handlePluginSubmissions(request, env, url, dependencies) {
  const {
    apiError,
    isConstraintError,
    json,
    normalizePluginId,
    normalizeSourceUrl,
    normalizeText,
    normalizeVersion,
    nowSeconds,
    requireCapability,
    requireWebsiteRole
  } = dependencies;

  if (url.pathname === "/api/developer/submissions" && request.method === "GET") {
    const session = await requireCapability(request, env, "plugin_dev");
    if (!session) return developerRequired(apiError);
    return listDeveloperSubmissions(env, session.user_id, json);
  }

  if (url.pathname === "/api/developer/submissions" && request.method === "POST") {
    const session = await requireCapability(request, env, "plugin_dev");
    if (!session) return developerRequired(apiError);
    return createPluginSubmission(request, env, session, dependencies);
  }

  const developerArtifact =
    url.pathname.match(/^\/api\/developer\/submissions\/([a-f0-9-]+)\/artifact$/);
  if (developerArtifact && request.method === "GET") {
    const session = await requireCapability(request, env, "plugin_dev");
    if (!session) return developerRequired(apiError);
    return streamSubmissionArtifact(
      env,
      developerArtifact[1],
      apiError,
      session.user_id
    );
  }

  if (url.pathname === "/api/review/submissions" && request.method === "GET") {
    const session = await requireWebsiteRole(request, env, "marketplace_reviewer");
    if (!session) return reviewerRequired(apiError);
    return listReviewSubmissions(env, json);
  }

  const reviewArtifact =
    url.pathname.match(/^\/api\/review\/submissions\/([a-f0-9-]+)\/artifact$/);
  if (reviewArtifact && request.method === "GET") {
    const session = await requireWebsiteRole(request, env, "marketplace_reviewer");
    if (!session) return reviewerRequired(apiError);
    return streamSubmissionArtifact(env, reviewArtifact[1], apiError);
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
      size AS artifact_size, uploaded_at AS artifact_uploaded_at
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

  if (!env.PLUGIN_ARTIFACTS) {
    return apiError(503, "plugin_storage_unavailable",
      "Private plugin upload storage is not connected.");
  }
  if (!request.headers.get("content-type")?.toLowerCase().startsWith("multipart/form-data")) {
    return apiError(415, "multipart_required",
      "Submit plugin metadata and the compiled JAR as multipart form data.");
  }
  const declaredLength = Number(request.headers.get("content-length") || 0);
  if (declaredLength > MAX_PLUGIN_ARTIFACT_BYTES + 64 * 1024) {
    return apiError(413, "plugin_artifact_too_large",
      "The complete plugin submission must be 20 MiB or smaller.");
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

  const now = nowSeconds();
  const id = crypto.randomUUID();
  const artifact = await preparePluginArtifact(form.get("artifact"), {
    userId: session.user_id,
    submissionId: id,
    pluginId,
    version
  });
  if (artifact.error) {
    return apiError(400, "invalid_plugin_artifact", artifact.error);
  }

  await env.PLUGIN_ARTIFACTS.put(artifact.objectKey, artifact.bytes, {
    httpMetadata: { contentType: artifact.contentType },
    customMetadata: {
      submissionId: id,
      pluginId,
      version,
      sha256: artifact.sha256
    }
  });

  try {
    const submission = env.DB.prepare(
      `INSERT INTO plugin_submissions
        (id, user_id, plugin_id, name, version, source_url, description, submitted_at, updated_at)
       VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)`
    ).bind(id, session.user_id, pluginId, name, version, sourceUrl,
      description, now, now);
    const storedArtifact = env.DB.prepare(
      `INSERT INTO plugin_submission_artifacts
        (submission_id, object_key, original_filename, content_type, sha256, size, uploaded_at)
       VALUES (?, ?, ?, ?, ?, ?, ?)`
    ).bind(id, artifact.objectKey, artifact.filename, artifact.contentType,
      artifact.sha256, artifact.size, now);
    await env.DB.batch([submission, storedArtifact]);
  } catch (error) {
    await env.PLUGIN_ARTIFACTS.delete(artifact.objectKey).catch(() => undefined);
    if (isConstraintError(error)) {
      return apiError(409, "submission_exists",
        "This plugin version has already been submitted.");
    }
    throw error;
  }

  const row = await env.DB.prepare(
    `SELECT plugin_submissions.id, plugin_id, name, version, source_url, description, status,
      review_notes, submitted_at, updated_at, reviewed_at,
      original_filename AS artifact_filename, sha256 AS artifact_sha256,
      size AS artifact_size, uploaded_at AS artifact_uploaded_at
     FROM plugin_submissions
     JOIN plugin_submission_artifacts
       ON plugin_submission_artifacts.submission_id = plugin_submissions.id
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
      uploaded_at AS artifact_uploaded_at
     FROM plugin_submissions JOIN users ON users.id = plugin_submissions.user_id
     LEFT JOIN plugin_submission_artifacts
       ON plugin_submission_artifacts.submission_id = plugin_submissions.id
     WHERE status IN ('pending', 'changes_requested')
     ORDER BY plugin_submissions.updated_at ASC LIMIT 100`
  ).all();
  return json({ submissions: (result.results || []).map(submissionPayload) });
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
    const artifact = await env.DB.prepare(
      "SELECT 1 AS available FROM plugin_submission_artifacts WHERE submission_id = ?"
    ).bind(submissionId).first();
    if (!artifact?.available) {
      return apiError(409, "plugin_artifact_required",
        "Upload and review the compiled plugin JAR before approving this submission.");
    }
  }
  const now = nowSeconds();
  const result = await env.DB.prepare(
    `UPDATE plugin_submissions
     SET status = ?, review_notes = ?, reviewed_by = ?, reviewed_at = ?, updated_at = ?
     WHERE id = ? AND status IN ('pending', 'changes_requested')`
  ).bind(decision, notes || null, session.user_id, now, now, submissionId).run();
  if (!result.meta?.changes) {
    return apiError(409, "submission_not_reviewable",
      "The submission was already reviewed or does not exist.");
  }
  return json({ ok: true, status: decision });
}

async function streamSubmissionArtifact(env, submissionId, apiError, ownerId = null) {
  if (!env.PLUGIN_ARTIFACTS) {
    return apiError(503, "plugin_storage_unavailable",
      "Private plugin upload storage is not connected.");
  }
  const ownershipClause = ownerId ? " AND plugin_submissions.user_id = ?" : "";
  const statement = env.DB.prepare(
    `SELECT plugin_submissions.plugin_id, plugin_submissions.version,
      object_key, original_filename, sha256, size
     FROM plugin_submission_artifacts
     JOIN plugin_submissions ON plugin_submissions.id = submission_id
     WHERE submission_id = ?${ownershipClause}`
  );
  const artifact = ownerId
    ? await statement.bind(submissionId, ownerId).first()
    : await statement.bind(submissionId).first();
  if (!artifact) {
    return apiError(404, "plugin_artifact_not_found", "The submitted plugin JAR was not found.");
  }
  const object = await env.PLUGIN_ARTIFACTS.get(artifact.object_key);
  if (!object?.body || object.size !== artifact.size) {
    return apiError(503, "plugin_artifact_unavailable",
      "The submitted plugin JAR is temporarily unavailable.");
  }
  return new Response(object.body, {
    status: 200,
    headers: artifactDownloadHeaders(artifact)
  });
}

function submissionPayload(row) {
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
      filename: row.artifact_filename,
      sha256: row.artifact_sha256,
      size: row.artifact_size,
      uploadedAt: row.artifact_uploaded_at
    } : null
  };
}

function developerRequired(apiError) {
  return apiError(403, "plugin_developer_required",
    "A verified website and Discord Plugin Dev role is required.");
}

function reviewerRequired(apiError) {
  return apiError(403, "reviewer_required", "Marketplace reviewer access is required.");
}
