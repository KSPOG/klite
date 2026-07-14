# KLite Plugin Marketplace site

This directory contains the static website deployed to Cloudflare Pages.

## Catalog

Published plugins are listed in `plugins.json`. Keep the catalog machine-readable so the KLite client can consume the same reviewed metadata in a later release.

The initial schema is intentionally small and is validated by the client. Each
entry includes an ID, display metadata, publication status, minimum compatible
client version, optional HTTPS homepage, and an optional reviewed image under
assets/plugins/. A signed artifact URL, checksum,
compatibility range, and review metadata must be added before client-side
installation is enabled.

## Local preview

Serve this directory with any static HTTP server. For example:

```powershell
npx serve marketplace-site
```

Do not open `index.html` directly from the filesystem because the browser may block the catalog fetch.

## Deploy

```powershell
npx wrangler pages deploy marketplace-site --project-name klite-marketplace
```
