# KLite Copper & Tin Miner

This external marketplace test plugin alternates between copper and tin rocks
around `WorldPoint(3285, 3362, 0)`. When the inventory becomes full, it uses the
KLite web walker to reach Varrock East bank, deposits every inventory item whose
definition is not a pickaxe, and returns to the mine.

The plugin starts its cooperative automation task when the marketplace starts
the plugin and stops it when the marketplace stops the plugin. KLite automation
must not already be running another task.

Build the streamed marketplace artifact with:

```powershell
.\gradlew.bat :copper-tin-miner:jar
```

The output is
`examples/klite-copper-tin-miner/build/libs/klite-copper-tin-miner-1.0.0.jar`.

The reproducible artifact metadata published in `plugins.json` is:

- size: `7459` bytes
- SHA-256: `626255fc638da012d02b02b9fa56dbcef0311dded9b12bcfa9d724f43b0783b8`
- object key: `plugins/copper-tin-miner/1.0.0.jar`

After enabling R2 and provisioning the marketplace D1 database, publish the
private artifact and register it from `marketplace-site`:

```powershell
npx wrangler r2 object put klite-plugin-artifacts/plugins/copper-tin-miner/1.0.0.jar --file=../examples/klite-copper-tin-miner/build/libs/klite-copper-tin-miner-1.0.0.jar --remote
npx wrangler d1 execute klite-marketplace --remote --command "INSERT INTO plugin_artifacts (plugin_id, version, object_key, sha256, size, access_type, published_at, revoked_at) VALUES ('copper-tin-miner', '1.0.0', 'plugins/copper-tin-miner/1.0.0.jar', '626255fc638da012d02b02b9fa56dbcef0311dded9b12bcfa9d724f43b0783b8', 7459, 'Free', unixepoch(), NULL) ON CONFLICT(plugin_id, version) DO UPDATE SET object_key = excluded.object_key, sha256 = excluded.sha256, size = excluded.size, access_type = excluded.access_type, published_at = excluded.published_at, revoked_at = NULL;"
```
