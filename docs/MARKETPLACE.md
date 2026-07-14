# KLite Plugin Marketplace

KLite Core adds a shield-branded sidebar section for installed KLite plugins.
Its **Open Marketplace** action launches a standalone marketplace window. The
window reads the public catalog from `https://klite-marketplace.pages.dev` and
validates its versioned metadata before displaying it. No remote plugin is
downloaded, installed, or executed.

## Current behavior

- The KLite shield opens a dedicated sidebar panel.
- Installed marketplace plugins will be listed in that panel.
- The marketplace opens independently from the RuneLite configuration panel.
- The KLite shield identifies the sidebar and marketplace content.
- The window provides loading, error, refresh, and search states for the remote
  catalog.
- Catalog entries can display reviewed PNG or JPEG artwork hosted by the same
  marketplace origin; invalid or unavailable images use the KLite fallback.
- The source-only **KLite Example** plugin demonstrates the future package
  format. It is not compiled into or installed with the client.
- Closing KLite Core also closes and disposes the marketplace window.

## Future catalog requirements

Before remote plugins are enabled, the marketplace needs a KLite-owned catalog
service and a documented trust policy. At minimum, a future implementation
should verify signed manifests and artifacts, enforce client-version
compatibility, isolate downloads in the existing external-plugin directory,
and show publisher and permission information before installation.

The current metadata-only state is deliberate. It prevents the UI from
suggesting that remote code has been verified or installed when it has not.
