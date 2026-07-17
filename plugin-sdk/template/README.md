# KLite Plugin Starter

This project builds KLite plugins without cloning or receiving the KLite client source code.

The bundled `libs/KLite-Plugin-SDK.jar` is a **compile-only API archive**. It contains the RuneLite API and the approved KLite plugin contracts needed by IntelliJ and `javac`. It does not contain the complete KLite client implementation, launcher, marketplace backend, account system, or updater.

SDK version: `@SDK_VERSION@`

## Requirements

- Windows 10 or 11
- KLite `1.0.85` or newer
- JDK 11
- IntelliJ IDEA with the Gradle plugin enabled

## Open in IntelliJ

1. Extract the complete starter ZIP to a normal development folder.
2. In IntelliJ, select **File → Open** and select the extracted folder.
3. Choose **Open as Project** when prompted.
4. Set the Gradle JVM to JDK 11 under **Settings → Build Tools → Gradle**.
5. Allow the initial Gradle synchronization to finish.

Do not add the installed KLite executable or client JAR as an IntelliJ dependency. The SDK is the only KLite compile dependency the plugin project should need.

## Rename the starter

Update these values before development:

- `group`, `version`, `pluginId`, `pluginDisplayName`, `pluginAuthor`, and `pluginDescription` in `build.gradle.kts`
- The Java package and `StarterPlugin` class name
- `pluginMainClass` in `build.gradle.kts`
- The values inside `@PluginDescriptor`

`pluginId` must use lowercase letters, numbers, and hyphens. Keep it stable after publishing because KLite uses it as the plugin identity.

## Enable the development runtime

1. Install and start KLite.
2. Open the **KLite Core** configuration.
3. Open **Plugin development**.
4. Enable **Enable development plugins**.

KLite then watches:

```text
%USERPROFILE%\.runelite\klite-dev-plugins
```

Development JARs are unreviewed local code and run with the same operating-system permissions as KLite. Only load code you trust.

## Build and install from IntelliJ

Open the Gradle tool window and run:

```text
Tasks → KLite development → installDevPlugin
```

Or run from PowerShell:

```powershell
.\gradlew.bat installDevPlugin
```

The task performs these steps:

1. Compiles the plugin against the compile-only SDK.
2. Builds a production-shaped external plugin JAR.
3. Verifies that KLite/RuneLite runtime classes were not bundled into the JAR.
4. Copies a uniquely named JAR into the local development directory.
5. Allows the running KLite client to unload the previous copy and load the new copy automatically.

The normal build output is also available under:

```text
build\libs
```

## Plugin metadata

Every external plugin JAR must contain `runelite_plugin.json`. The starter generates it from the values in `build.gradle.kts`.

The `plugins` array must contain the fully qualified name of every plugin entry class in the JAR. Each entry class must extend `net.runelite.client.plugins.Plugin` and use `@PluginDescriptor`.

## API usage

The main public entry point is:

```java
@Inject
private KLiteClientApi clientApi;
```

KLite API calls normally return `CompletableFuture<T>`. Chain asynchronous work rather than blocking the client thread:

```java
clientApi.inventoryFreeSlots()
    .thenAccept(freeSlots -> log.info("Free slots: {}", freeSlots));
```

Use the authenticated API reference on the KLite website for available types and methods.

## Publishing rules

Before submitting a plugin:

- Do not package `KLite-Plugin-SDK.jar` into the plugin JAR.
- Do not shade RuneLite, KLite, Guice, `javax.inject`, or SLF4J classes.
- Do not access client implementation classes outside the published SDK surface.
- Keep `runelite_plugin.json` and `@PluginDescriptor` metadata consistent.
- Submit the source repository and the exact built JAR for review.

The development loader is only for local testing. Marketplace distribution still requires review and approval.
