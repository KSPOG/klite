# KLite Plugin Marketplace

KLite Core adds a shield-branded sidebar section for installed KLite plugins.
Its **Open Marketplace** action launches a standalone marketplace window. The
window is intentionally a catalog shell today: no remote plugin is downloaded,
installed, or executed.

## Current behavior

- The KLite shield opens a dedicated sidebar panel.
- Installed marketplace plugins will be listed in that panel.
- The marketplace opens independently from the RuneLite configuration panel.
- The KLite shield identifies the sidebar and marketplace content.
- The window reports that its catalog source is not configured.
- Closing KLite Core also closes and disposes the marketplace window.

## Future catalog requirements

Before remote plugins are enabled, the marketplace needs a KLite-owned catalog
service and a documented trust policy. At minimum, a future implementation
should verify signed manifests and artifacts, enforce client-version
compatibility, isolate downloads in the existing external-plugin directory,
and show publisher and permission information before installation.

The current empty state is deliberate. It prevents the UI from suggesting that
RuneLite's public Plugin Hub is a KLite-controlled distribution channel.
