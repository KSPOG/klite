import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

test("records promotion metadata before the immutable approved transition", async () => {
  const source = await readFile(
    new URL("../worker/plugin-source-submissions.js", import.meta.url),
    "utf8"
  );
  const promotionUpdate = source.indexOf("UPDATE plugin_submission_artifacts");
  const approvalUpdate = source.indexOf("SET status = 'approved'");

  assert.notEqual(promotionUpdate, -1);
  assert.notEqual(approvalUpdate, -1);
  assert.ok(
    promotionUpdate < approvalUpdate,
    "promotion metadata must be recorded before migration 0009 makes artifact rows immutable"
  );
});
