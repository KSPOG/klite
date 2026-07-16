import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

const catalogUrl = new URL("../public/plugins.json", import.meta.url);

test("publishes the copper and tin miner as a streamed free plugin", async () => {
  const catalog = JSON.parse(await readFile(catalogUrl, "utf8"));
  const plugin = catalog.plugins.find((entry) => entry.id === "copper-tin-miner");

  assert.ok(plugin, "copper-tin-miner is missing from the marketplace catalog");
  assert.equal(plugin.status, "available");
  assert.equal(plugin.type, "Free");
  assert.equal(plugin.access, "Free");
  assert.equal(plugin.descriptor.version, "1.0.0");
  assert.equal(plugin.artifact.version, plugin.descriptor.version);
  assert.equal(plugin.artifact.size, 7_459);
  assert.equal(
    plugin.artifact.sha256,
    "626255fc638da012d02b02b9fa56dbcef0311dded9b12bcfa9d724f43b0783b8"
  );
  assert.deepEqual(plugin.artifact.entrypoints, [
    "net.runelite.client.plugins.klite.examples.miner.CopperTinMinerPlugin"
  ]);
});
