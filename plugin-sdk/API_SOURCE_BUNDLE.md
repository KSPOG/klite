# KLite public API source bundle

`plugin-sdk/build_api_sources.py` packages the exact Java types displayed by the website API reference:

- Client API
- Automation runtime
- Web walker

The builder compares the source tree with `marketplace-site/worker/api-reference.generated.js` and fails when either side contains a type the other side does not. The resulting archive is:

```text
dist/plugin-sdk/KLite-Public-API-Sources.zip
```

After the Plugin SDK publisher succeeds on `main`, the source publisher uploads the verified ZIP to the rolling `plugin-sdk` GitHub release and downloads it again for a byte-for-byte comparison.

The bundle intentionally excludes marketplace, account, launcher, updater, and other private implementation packages.
