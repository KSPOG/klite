import assert from "node:assert/strict";
import { createHash } from "node:crypto";
import { readFile } from "node:fs/promises";
import test from "node:test";

const catalogUrl = new URL("../public/plugins.json", import.meta.url);
const artifactUrl = new URL("../public/artifacts/copper-tin-miner-0.0.2.jar", import.meta.url);
const pluginSourceUrl = new URL(
  "../../examples/klite-copper-tin-miner/src/main/java/net/runelite/client/plugins/klite/examples/miner/CopperTinMinerPlugin.java",
  import.meta.url
);
const pluginBuildUrl = new URL("../../examples/klite-copper-tin-miner/build.gradle.kts", import.meta.url);

test("publishes Copper and Tin Miner 0.0.2 as a verified streamed free plugin", async () => {
  const [catalogText, artifact, pluginSource, pluginBuild] = await Promise.all([
    readFile(catalogUrl, "utf8"),
    readFile(artifactUrl),
    readFile(pluginSourceUrl, "utf8"),
    readFile(pluginBuildUrl, "utf8"),
  ]);
  const catalog = JSON.parse(catalogText);
  const plugin = catalog.plugins.find((entry) => entry.id === "copper-tin-miner");

  assert.ok(plugin, "copper-tin-miner is missing from the marketplace catalog");
  assert.equal(plugin.status, "available");
  assert.equal(plugin.type, "Free");
  assert.equal(plugin.access, "Free");
  assert.equal(plugin.descriptor.version, "0.0.2");
  assert.equal(plugin.artifact.version, plugin.descriptor.version);
  assert.equal(plugin.artifact.size, artifact.byteLength);
  assert.equal(plugin.artifact.sha256, createHash("sha256").update(artifact).digest("hex"));
  assert.match(pluginSource, /VERSION = "0\.0\.2";/);
  assert.match(pluginBuild, /archiveFileName = "klite-copper-tin-miner-0\.0\.2\.jar"/);
  assert.deepEqual(plugin.artifact.entrypoints, [
    "net.runelite.client.plugins.klite.examples.miner.CopperTinMinerPlugin"
  ]);
});
