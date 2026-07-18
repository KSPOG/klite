from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]


def replace_exact(path: Path, old: str, new: str, label: str) -> None:
    text = path.read_text("utf-8")
    if new in text and old not in text:
        return
    if old not in text:
        raise RuntimeError(f"Unable to locate {label} in {path}")
    path.write_text(text.replace(old, new, 1), "utf-8")


# PMD: remove the unused LoadedDevelopmentPlugin.jar field. The candidate JAR
# is still used during discovery/loading; the loaded record only needs its
# fingerprint, class loader, and instantiated plugins.
development_manager = ROOT / "runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java"
replace_exact(
    development_manager,
    """\t\t\tloadedPlugins.put(candidate.internalName,\n\t\t\t\tnew LoadedDevelopmentPlugin(candidate.jar, candidate.fingerprint, classLoader, plugins));""",
    """\t\t\tloadedPlugins.put(candidate.internalName,\n\t\t\t\tnew LoadedDevelopmentPlugin(candidate.fingerprint, classLoader, plugins));""",
    "LoadedDevelopmentPlugin construction",
)
replace_exact(
    development_manager,
    """\tprivate static final class LoadedDevelopmentPlugin\n\t{\n\t\tprivate final File jar;\n\t\tprivate final String fingerprint;\n\t\tprivate final DevelopmentPluginClassLoader classLoader;\n\t\tprivate final List<Plugin> plugins;\n\n\t\tprivate LoadedDevelopmentPlugin(File jar, String fingerprint,\n\t\t\tDevelopmentPluginClassLoader classLoader, List<Plugin> plugins)\n\t\t{\n\t\t\tthis.jar = jar;\n\t\t\tthis.fingerprint = fingerprint;\n\t\t\tthis.classLoader = classLoader;\n\t\t\tthis.plugins = plugins;\n\t\t}\n\t}""",
    """\tprivate static final class LoadedDevelopmentPlugin\n\t{\n\t\tprivate final String fingerprint;\n\t\tprivate final DevelopmentPluginClassLoader classLoader;\n\t\tprivate final List<Plugin> plugins;\n\n\t\tprivate LoadedDevelopmentPlugin(String fingerprint,\n\t\t\tDevelopmentPluginClassLoader classLoader, List<Plugin> plugins)\n\t\t{\n\t\t\tthis.fingerprint = fingerprint;\n\t\t\tthis.classLoader = classLoader;\n\t\t\tthis.plugins = plugins;\n\t\t}\n\t}""",
    "unused loaded JAR field",
)

# PMD: Java 11 diamond operator.
log_buffer = ROOT / "runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java"
replace_exact(
    log_buffer,
    "new AppenderBase<ILoggingEvent>()",
    "new AppenderBase<>()",
    "AppenderBase diamond operator",
)

# This is intentionally instance data because Gson persists it with each stored
# marketplace state document. Making it static would remove it from JSON.
persistence = ROOT / "runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java"
replace_exact(
    persistence,
    "\t\tprivate int schemaVersion = 1;",
    "\t\t@SuppressWarnings(\"PMD.ImmutableField\")\n\t\tprivate int schemaVersion = 1;",
    "persisted schemaVersion",
)

# PMD: both load-failure branches performed identical cleanup and wrapping.
streamed = ROOT / "runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java"
replace_exact(
    streamed,
    """\t\tcatch (IOException | ClassNotFoundException | PluginInstantiationException ex)\n\t\t{\n\t\t\tcleanupFailedLoad(classLoader, plugins);\n\t\t\tthrow new IllegalStateException(\"Unable to load marketplace plugin: \" + describe(ex), ex);\n\t\t}\n\t\tcatch (RuntimeException | LinkageError ex)\n\t\t{\n\t\t\tcleanupFailedLoad(classLoader, plugins);\n\t\t\tthrow new IllegalStateException(\"Unable to load marketplace plugin: \" + describe(ex), ex);\n\t\t}""",
    """\t\tcatch (IOException | ClassNotFoundException | PluginInstantiationException\n\t\t\t| RuntimeException | LinkageError ex)\n\t\t{\n\t\t\tcleanupFailedLoad(classLoader, plugins);\n\t\t\tthrow new IllegalStateException(\"Unable to load marketplace plugin: \" + describe(ex), ex);\n\t\t}""",
    "identical marketplace load catches",
)

# Preserve InvocationTargetException itself as the cause. Its cause chain still
# contains PluginOperationRuntimeException and the original plugin exception.
replace_exact(
    streamed,
    """\t\tcatch (InvocationTargetException ex)\n\t\t{\n\t\t\tThrowable cause = ex.getCause();\n\t\t\tif (cause instanceof PluginOperationRuntimeException)\n\t\t\t{\n\t\t\t\tthrow new PluginInstantiationException(cause.getCause());\n\t\t\t}\n\t\t\tthrow new PluginInstantiationException(cause);\n\t\t}""",
    """\t\tcatch (InvocationTargetException ex)\n\t\t{\n\t\t\tthrow new PluginInstantiationException(ex);\n\t\t}""",
    "InvocationTargetException stack preservation",
)
