import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import path from "node:path";
import test from "node:test";
import { fileURLToPath } from "node:url";

const testDirectory = path.dirname(fileURLToPath(import.meta.url));
const siteDirectory = path.resolve(testDirectory, "..");

test("Pages executes the verified Windows download function", async () => {
  const routes = JSON.parse(
    await readFile(path.join(siteDirectory, "public", "_routes.json"), "utf8"),
  );

  assert.ok(routes.include.includes("/download/windows"));
});
