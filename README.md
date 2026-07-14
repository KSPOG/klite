# KLite

KLite is a focused desktop client built directly on the open-source RuneLite
codebase. It keeps RuneLite's module boundaries and plugin model so upstream
security, compatibility, and API changes can be incorporated with minimal
fork-specific conflict.

KLite does **not** include Microbot source, automation APIs, scripting engines,
or botting features. Microbot was reviewed only as an architectural example of
how a downstream RuneLite distribution can keep custom code inside the client
module.

## Current KLite layer

- `net.runelite.client.KLite` is the distribution-owned entry point.
- The window title and shaded artifact are branded as KLite.
- `KLite Core` is a built-in plugin with an optional build/status overlay.
- The rest of the tree remains close to upstream RuneLite for maintainability.

## Requirements

- JDK 11 (selected by the upstream Gradle build)
- Git

The Gradle wrapper is included, so a separate Gradle installation is not
required.

## Build and run

On Windows:

```powershell
.\gradlew.bat :client:compileJava
.\gradlew.bat :client:runKLite
```

Build the executable shaded JAR:

```powershell
.\gradlew.bat :client:shadowJar
```

The artifact is written to `runelite-client/build/libs/klite-<version>.jar`.

## Architecture

RuneLite's main modules are preserved:

- `runelite-api`: stable interfaces exposed to plugins.
- `runelite-client`: application, UI, plugin runtime, and KLite-owned code.
- `runelite-gradle-plugin`: tooling used to assemble the injected client.
- `cache` and `runelite-jshell`: upstream cache and developer tooling.

KLite-specific code belongs under
`runelite-client/src/main/java/net/runelite/client/plugins/klite` or behind the
`net.runelite.client.KLite` entry point. Avoid broad edits to upstream classes
unless a feature cannot be implemented through RuneLite's public plugin and
dependency-injection APIs.

See [docs/UPSTREAM.md](docs/UPSTREAM.md) for the update workflow.

## License and third-party services

KLite retains RuneLite's BSD 2-Clause license and copyright notices. RuneLite's
remote services, Plugin Hub, and game configuration endpoints remain in use.
KLite is not affiliated with Jagex or the RuneLite project.
