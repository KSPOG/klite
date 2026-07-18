# KLite Copper & Tin Miner

This external marketplace test plugin alternates between copper and tin rocks
around `WorldPoint(3285, 3362, 0)`. When the inventory becomes full, it uses the
KLite web walker to reach Varrock East bank, deposits every inventory item whose
definition is not a pickaxe, and returns to the mine.

The plugin starts its cooperative automation task when the marketplace starts
the plugin and stops it when the marketplace stops the plugin. KLite automation
must not already be running another task.

## Version

The marketplace plugin version is intentionally `0.0.2`. Its minimum supported
KLite client version is independently set to `1.0.0`; these values must not be
conflated.

Build the reproducible streamed marketplace artifact with:

```powershell
.\gradlew.bat :copper-tin-miner:jar
```

The output is:

`examples/klite-copper-tin-miner/build/libs/klite-copper-tin-miner-0.0.2.jar`

The verified artifact committed at
`marketplace-site/public/artifacts/copper-tin-miner-0.0.2.jar` has:

- size: `15505` bytes
- SHA-256: `b22bf114ca047de996dda2000a8b3bb5be206c6014e3a5279045bb61bb1d8d34`

The `Publish free marketplace artifacts` GitHub Actions workflow rebuilds this
artifact when the example changes. It requires both the source descriptor and
`plugins.json` to remain on `0.0.2`, then updates the committed artifact hash,
size, and catalog timestamp together.
