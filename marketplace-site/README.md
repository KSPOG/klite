# KLite Plugin Marketplace site

This directory contains the static website deployed to Cloudflare Pages.

## Catalog

Published plugins are listed in `plugins.json`. Keep the catalog machine-readable so the KLite client can consume the same reviewed metadata in a later release.

Schema v3 stores plugin-owned metadata in a descriptor object mirroring
@PluginDescriptor: name, description, tags, authors, version, minimum client
version, default enablement, and external-plugin state. Marketplace-owned
metadata remains outside the descriptor: ID, categories, distribution type,
publication status, homepage, release/update timestamps, explicit trend scores, and reviewed artwork under assets/plugins/.

A signed artifact URL, checksum, compatibility range, and review metadata must
be added before client-side installation is enabled.

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
