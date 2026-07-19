import assert from "node:assert/strict";
import test from "node:test";

import {
  buildClientUpdateMessage,
  normalizeUpdates,
  normalizeVersion
} from "../worker/client-updates.js";

const ROLE_ID = "12345678901234567";

test("builds the requested client version and updates message", () => {
  assert.deepEqual(buildClientUpdateMessage("1.0.95", "- Added AutoLogin", ROLE_ID), {
    content: `<@&${ROLE_ID}>\n**Client version:** 1.0.95\n**Updates:**\n- Added AutoLogin`,
    allowed_mentions: { parse: [], roles: [ROLE_ID] }
  });
});

test("normalizes client update versions and notes", () => {
  assert.equal(normalizeVersion(" 1.0.95 "), "1.0.95");
  assert.equal(normalizeVersion("latest"), null);
  assert.equal(normalizeUpdates(" line one\r\nline two "), "line one\nline two");
  assert.equal(normalizeUpdates("  "), null);
});
