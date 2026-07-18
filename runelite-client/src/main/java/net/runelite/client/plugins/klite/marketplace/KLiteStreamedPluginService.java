/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.SwingUtilities;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.ExternalPluginsChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginInstantiationException;
import net.runelite.client.plugins.PluginManager;

/** Owns the fetch, in-memory load, enable, disable, unload, and diagnostic lifecycle of marketplace plugins. */
@Singleton
class KLiteStreamedPluginService
{
	private static final int MAX_DIAGNOSTIC_ENTRIES = 250;
	private static final DateTimeFormatter LOG_TIME = DateTimeFormatter.ofPattern("HH:mm:ss");

	private final KLiteMarketplaceArtifactClient artifactClient;
	private final PluginManager pluginManager;
	private final EventBus eventBus;
	private final Map<String, LoadedPluginSet> loadedPlugins = new HashMap<>();
	private final Set<String> loadingPlugins = new HashSet<>();
	private final List<Runnable> changeListeners = new CopyOnWriteArrayList<>();
	private final List<String> diagnosticEntries = new CopyOnWriteArrayList<>();

	@Inject
	KLiteStreamedPluginService(KLiteMarketplaceArtifactClient artifactClient,
		PluginManager pluginManager, EventBus eventBus)
	{
		this.artifactClient = artifactClient;
		this.pluginManager = pluginManager;
		this.eventBus = eventBus;
		logInfo("KLite marketplace diagnostics initialized.");
	}

	synchronized boolean isLoaded(String pluginId)
	{
		return loadedPlugins.containsKey(pluginId);
	}

	synchronized boolean isRunning(String pluginId)
	{
		LoadedPluginSet pluginSet = loadedPlugins.get(pluginId);
		return pluginSet != null && pluginSet.plugins.stream().anyMatch(pluginManager::isPluginActive);
	}

	synchronized boolean isLoading(String pluginId)
	{
		return loadingPlugins.contains(pluginId);
	}

	synchronized List<LoadedMarketplacePlugin> loadedMarketplacePlugins()
	{
		List<LoadedMarketplacePlugin> result = new ArrayList<>();
		for (LoadedPluginSet pluginSet : loadedPlugins.values())
		{
			result.add(new LoadedMarketplacePlugin(pluginSet.marketplacePlugin,
				pluginSet.plugins, pluginSet.plugins.stream().anyMatch(pluginManager::isPluginActive),
				pluginSet.plugins.stream().anyMatch(plugin -> pluginManager.getPluginConfigProxy(plugin) != null)));
		}
		result.sort(Comparator.comparing(item -> item.marketplacePlugin.getName(),
			String.CASE_INSENSITIVE_ORDER));
		return Collections.unmodifiableList(result);
	}

	void addChangeListener(Runnable listener)
	{
		changeListeners.add(listener);
	}

	String diagnosticsText()
	{
		if (diagnosticEntries.isEmpty())
		{
			return "No KLite marketplace diagnostic entries have been recorded.";
		}
		return String.join(System.lineSeparator() + System.lineSeparator(), diagnosticEntries);
	}

	void clearDiagnostics()
	{
		diagnosticEntries.clear();
		logInfo("KLite marketplace diagnostics cleared.");
	}

	CompletableFuture<Void> load(KLiteMarketplacePlugin marketplacePlugin)
	{
		synchronized (this)
		{
			if (loadedPlugins.containsKey(marketplacePlugin.getId())
				|| !loadingPlugins.add(marketplacePlugin.getId()))
			{
				return failedFuture(new IllegalStateException("Plugin is already loaded or loading"));
			}
		}

		logInfo("Load requested for " + marketplacePlugin.getName() + " v"
			+ marketplacePlugin.getVersion() + " [" + marketplacePlugin.getId() + "].");
		return artifactClient.fetch(marketplacePlugin)
			.thenApply(bytes ->
			{
				logInfo("Downloaded and verified " + bytes.length + " bytes for "
					+ marketplacePlugin.getName() + ".");
				return bytes;
			})
			.thenAccept(bytes -> loadArtifact(marketplacePlugin, bytes))
			.whenComplete((ignored, error) ->
			{
				synchronized (this)
				{
					loadingPlugins.remove(marketplacePlugin.getId());
				}
				if (error == null)
				{
					logInfo(marketplacePlugin.getName()
						+ " loaded successfully and remains disabled until Enable is pressed.");
				}
				else
				{
					logError("Marketplace load failed for " + marketplacePlugin.getName(), unwrap(error));
				}
				notifyChanged();
			});
	}

	/** Backward-compatible alias. Loading no longer starts the plugin. */
	CompletableFuture<Void> run(KLiteMarketplacePlugin marketplacePlugin)
	{
		return load(marketplacePlugin);
	}

	CompletableFuture<Void> start(String pluginId)
	{
		LoadedPluginSet pluginSet = getLoaded(pluginId);
		if (pluginSet == null)
		{
			return failedFuture(new IllegalStateException("Plugin is not loaded"));
		}
		logInfo("Enabling " + pluginSet.marketplacePlugin.getName() + ".");
		return execute(() -> startOnEdt(pluginSet.plugins)).whenComplete((ignored, error) ->
		{
			if (error == null)
			{
				logInfo(pluginSet.marketplacePlugin.getName() + " enabled successfully.");
			}
			else
			{
				logError("Unable to enable " + pluginSet.marketplacePlugin.getName(), unwrap(error));
			}
		});
	}

	CompletableFuture<Void> stop(String pluginId)
	{
		LoadedPluginSet pluginSet = getLoaded(pluginId);
		if (pluginSet == null)
		{
			return CompletableFuture.completedFuture(null);
		}
		logInfo("Disabling " + pluginSet.marketplacePlugin.getName() + ".");
		return execute(() -> stopOnEdt(pluginSet.plugins, false)).whenComplete((ignored, error) ->
		{
			if (error == null)
			{
				logInfo(pluginSet.marketplacePlugin.getName() + " disabled successfully.");
			}
			else
			{
				logError("Unable to disable " + pluginSet.marketplacePlugin.getName(), unwrap(error));
			}
		});
	}

	CompletableFuture<Void> unload(String pluginId)
	{
		LoadedPluginSet pluginSet;
		synchronized (this)
		{
			if (loadingPlugins.contains(pluginId))
			{
				return failedFuture(new IllegalStateException("Plugin is still loading"));
			}
			pluginSet = loadedPlugins.remove(pluginId);
		}
		if (pluginSet == null)
		{
			return CompletableFuture.completedFuture(null);
		}
		logInfo("Unloading " + pluginSet.marketplacePlugin.getName() + ".");
		return execute(() -> unload(pluginSet)).whenComplete((ignored, error) ->
		{
			if (error == null)
			{
				logInfo(pluginSet.marketplacePlugin.getName() + " unloaded and its class loader was released.");
			}
			else
			{
				logError("Unable to unload " + pluginSet.marketplacePlugin.getName(), unwrap(error));
			}
		});
	}

	private synchronized LoadedPluginSet getLoaded(String pluginId)
	{
		return loadedPlugins.get(pluginId);
	}

	private CompletableFuture<Void> execute(CheckedOperation operation)
	{
		try
		{
			operation.run();
			notifyChanged();
			return CompletableFuture.completedFuture(null);
		}
		catch (Exception ex)
		{
			notifyChanged();
			return failedFuture(ex instanceof RuntimeException ? ex
				: new IllegalStateException(describe(ex), ex));
		}
	}

	private void loadArtifact(KLiteMarketplacePlugin marketplacePlugin, byte[] bytes)
	{
		KLiteInMemoryPluginClassLoader classLoader = null;
		List<Plugin> plugins = new ArrayList<>();
		try
		{
			List<String> declaredEntrypoints = marketplacePlugin.getArtifact().getEntrypoints();
			logInfo("Inspecting declared entrypoints: " + String.join(", ", declaredEntrypoints));
			classLoader = new KLiteInMemoryPluginClassLoader(bytes,
				PluginManager.class.getClassLoader(), declaredEntrypoints);
			logInfo("Artifact archive passed namespace, size, duplicate, and protected-class validation.");

			List<Class<?>> entrypoints = new ArrayList<>();
			for (String entrypoint : declaredEntrypoints)
			{
				logInfo("Resolving entrypoint class " + entrypoint + ".");
				entrypoints.add(classLoader.loadClass(entrypoint));
			}
			logInfo("Resolved " + entrypoints.size() + " marketplace entrypoint class(es).");

			plugins = pluginManager.loadPlugins(entrypoints, null);
			if (plugins.size() != entrypoints.size())
			{
				throw new PluginInstantiationException(
					"Not every declared entrypoint is a valid plugin");
			}
			logInfo("RuneLite instantiated " + plugins.size() + " plugin instance(s).");

			// This discovers plugin-provided Config interfaces, applies defaults, and makes
			// them available to RuneLite's normal configuration UI before the plugin starts.
			pluginManager.loadDefaultPluginConfiguration(plugins);
			logInfo("Plugin configuration interfaces and defaults were discovered.");
			for (Plugin plugin : plugins)
			{
				pluginManager.setPluginEnabled(plugin, false);
			}
			synchronized (this)
			{
				loadedPlugins.put(marketplacePlugin.getId(),
					new LoadedPluginSet(marketplacePlugin, classLoader, plugins));
			}
			notifyChanged();
		}
		catch (IOException | ClassNotFoundException | PluginInstantiationException
			| RuntimeException | LinkageError ex)
		{
			cleanupFailedLoad(classLoader, plugins);
			throw new IllegalStateException("Unable to load marketplace plugin: " + describe(ex), ex);
		}
	}

	private void startOnEdt(List<Plugin> plugins) throws PluginInstantiationException
	{
		runOnEdt(() ->
		{
			for (Plugin plugin : plugins)
			{
				pluginManager.setPluginEnabled(plugin, true);
				pluginManager.startPlugin(plugin);
			}
		});
	}

	private void stopOnEdt(List<Plugin> plugins, boolean remove) throws PluginInstantiationException
	{
		runOnEdt(() ->
		{
			for (Plugin plugin : plugins)
			{
				if (pluginManager.isPluginActive(plugin))
				{
					pluginManager.stopPlugin(plugin);
				}
				pluginManager.setPluginEnabled(plugin, false);
				if (remove)
				{
					pluginManager.remove(plugin);
				}
			}
		});
	}

	@SuppressWarnings("PMD.UseTryWithResources") // The loader is owned by the loaded plugin set.
	private void unload(LoadedPluginSet pluginSet) throws PluginInstantiationException
	{
		try
		{
			stopOnEdt(pluginSet.plugins, true);
		}
		finally
		{
			pluginSet.classLoader.close();
			notifyChanged();
		}
	}

	private void cleanupFailedLoad(KLiteInMemoryPluginClassLoader classLoader, List<Plugin> plugins)
	{
		if (!plugins.isEmpty())
		{
			try
			{
				stopOnEdt(plugins, true);
			}
			catch (PluginInstantiationException cleanupError)
			{
				logError("Cleanup after a failed marketplace load also failed", cleanupError);
				plugins.forEach(pluginManager::remove);
			}
		}
		if (classLoader != null)
		{
			classLoader.close();
		}
	}

	private void runOnEdt(PluginOperation operation) throws PluginInstantiationException
	{
		if (SwingUtilities.isEventDispatchThread())
		{
			operation.run();
			return;
		}
		try
		{
			SwingUtilities.invokeAndWait(() ->
			{
				try
				{
					operation.run();
				}
				catch (PluginInstantiationException ex)
				{
					throw new PluginOperationRuntimeException(ex);
				}
			});
		}
		catch (InterruptedException ex)
		{
			Thread.currentThread().interrupt();
			throw new PluginInstantiationException(ex);
		}
		catch (InvocationTargetException ex)
		{
			throw new PluginInstantiationException(ex);
		}
	}

	private void notifyChanged()
	{
		eventBus.post(new ExternalPluginsChanged());
		for (Runnable listener : changeListeners)
		{
			SwingUtilities.invokeLater(listener);
		}
	}

	private synchronized void appendDiagnostic(String level, String message)
	{
		diagnosticEntries.add("[" + LOG_TIME.format(LocalDateTime.now()) + "] [" + level + "] " + message);
		while (diagnosticEntries.size() > MAX_DIAGNOSTIC_ENTRIES)
		{
			diagnosticEntries.remove(0);
		}
	}

	private void logInfo(String message)
	{
		appendDiagnostic("INFO", message);
	}

	private void logError(String message, Throwable error)
	{
		StringWriter trace = new StringWriter();
		error.printStackTrace(new PrintWriter(trace));
		appendDiagnostic("ERROR", message + ": " + describe(error)
			+ System.lineSeparator() + trace);
	}

	static String describe(Throwable error)
	{
		Throwable current = unwrap(error);
		Throwable best = current;
		while (current.getCause() != null && current.getCause() != current)
		{
			current = current.getCause();
			if (current.getMessage() != null && !current.getMessage().trim().isEmpty())
			{
				best = current;
			}
		}
		String message = best.getMessage();
		return best.getClass().getSimpleName()
			+ (message == null || message.trim().isEmpty() ? "" : ": " + message.trim());
	}

	private static Throwable unwrap(Throwable error)
	{
		Throwable current = error;
		while ((current instanceof CompletionException || current instanceof InvocationTargetException)
			&& current.getCause() != null)
		{
			current = current.getCause();
		}
		return current;
	}

	private static <T> CompletableFuture<T> failedFuture(Throwable error)
	{
		CompletableFuture<T> future = new CompletableFuture<>();
		future.completeExceptionally(error);
		return future;
	}

	static final class LoadedMarketplacePlugin
	{
		private final KLiteMarketplacePlugin marketplacePlugin;
		private final List<Plugin> plugins;
		private final boolean running;
		private final boolean configurable;

		private LoadedMarketplacePlugin(KLiteMarketplacePlugin marketplacePlugin,
			List<Plugin> plugins, boolean running, boolean configurable)
		{
			this.marketplacePlugin = marketplacePlugin;
			this.plugins = Collections.unmodifiableList(new ArrayList<>(plugins));
			this.running = running;
			this.configurable = configurable;
		}

		KLiteMarketplacePlugin getMarketplacePlugin()
		{
			return marketplacePlugin;
		}

		List<Plugin> getPlugins()
		{
			return plugins;
		}

		Plugin getPrimaryPlugin()
		{
			return plugins.isEmpty() ? null : plugins.get(0);
		}

		boolean isRunning()
		{
			return running;
		}

		boolean isConfigurable()
		{
			return configurable;
		}
	}

	private static final class LoadedPluginSet
	{
		private final KLiteMarketplacePlugin marketplacePlugin;
		private final KLiteInMemoryPluginClassLoader classLoader;
		private final List<Plugin> plugins;

		private LoadedPluginSet(KLiteMarketplacePlugin marketplacePlugin,
			KLiteInMemoryPluginClassLoader classLoader, List<Plugin> plugins)
		{
			this.marketplacePlugin = marketplacePlugin;
			this.classLoader = classLoader;
			this.plugins = plugins;
		}
	}

	@FunctionalInterface
	private interface CheckedOperation
	{
		void run() throws Exception;
	}

	@FunctionalInterface
	private interface PluginOperation
	{
		void run() throws PluginInstantiationException;
	}

	private static final class PluginOperationRuntimeException extends RuntimeException
	{
		private PluginOperationRuntimeException(Throwable cause)
		{
			super(cause);
		}
	}
}
