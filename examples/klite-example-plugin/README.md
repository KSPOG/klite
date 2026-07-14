# KLite Example plugin

This is a source-only reference plugin for the future KLite marketplace package
format. It is deliberately stored outside `runelite-client/src/main`, so it is
not compiled into, installed with, or enabled by the KLite client.

The example adds a small informational overlay and performs no automation. Its
`PluginDescriptor` also sets `enabledByDefault = false`, so a future verified
installer must still require the user to enable it explicitly after installation.

The annotation demonstrates authors, version, minimum client version, default-enablement, and external-plugin metadata. The marketplace currently publishes this entry as `coming-soon`. Do not change
it to `available` until the signed artifact, checksum verification, installation,
and uninstall flows have been implemented.
