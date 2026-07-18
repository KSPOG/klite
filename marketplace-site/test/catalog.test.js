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
  assert.equal(plugin.artifact.size, 7_490);
  assert.equal(
    plugin.artifact.sha256,
    "cfb6226c9bb6e0b052204846659e38604a337e7f51b87408f985bf40cf2ac805"
  );
  assert.deepEqual(plugin.artifact.entrypoints, [
    "net.runelite.client.plugins.klite.examples.miner.CopperTinMinerPlugin"
  ]);
});
