/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.SwingUtilities;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.ExternalPluginsChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginInstantiationException;
import net.runelite.client.plugins.PluginManager;

/** Owns the fetch, in-memory load, enable, disable, and unload lifecycle of marketplace plugins. */
@Singleton
class KLiteStreamedPluginService
{
	private final KLiteMarketplaceArtifactClient artifactClient;
	private final PluginManager pluginManager;
	private final EventBus eventBus;
	private final Map<String, LoadedPluginSet> loadedPlugins = new HashMap<>();
	private final Set<String> loadingPlugins = new HashSet<>();
	private final List<Runnable> changeListeners = new CopyOnWriteArrayList<>();

	@Inject
	KLiteStreamedPluginService(KLiteMarketplaceArtifactClient artifactClient,
		PluginManager pluginManager, EventBus eventBus)
	{
		this.artifactClient = artifactClient;
		this.pluginManager = pluginManager;
		this.eventBus = eventBus;
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

		return artifactClient.fetch(marketplacePlugin)
			.thenAccept(bytes -> loadArtifact(marketplacePlugin, bytes))
			.whenComplete((ignored, error) ->
			{
				synchronized (this)
				{
					loadingPlugins.remove(marketplacePlugin.getId());
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
		return execute(() -> startOnEdt(pluginSet.plugins));
	}

	CompletableFuture<Void> stop(String pluginId)
	{
		LoadedPluginSet pluginSet = getLoaded(pluginId);
		if (pluginSet == null)
		{
			return CompletableFuture.completedFuture(null);
		}
		return execute(() -> stopOnEdt(pluginSet.plugins, false));
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
		return execute(() -> unload(pluginSet));
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
				: new IllegalStateException(ex.getMessage(), ex));
		}
	}

	private void loadArtifact(KLiteMarketplacePlugin marketplacePlugin, byte[] bytes)
	{
		KLiteInMemoryPluginClassLoader classLoader = null;
		List<Plugin> plugins = new ArrayList<>();
		try
		{
			classLoader = new KLiteInMemoryPluginClassLoader(bytes,
				PluginManager.class.getClassLoader(), marketplacePlugin.getArtifact().getEntrypoints());
			List<Class<?>> entrypoints = new ArrayList<>();
			for (String entrypoint : marketplacePlugin.getArtifact().getEntrypoints())
			{
				entrypoints.add(classLoader.loadClass(entrypoint));
			}
			plugins = pluginManager.loadPlugins(entrypoints, null);
			if (plugins.size() != entrypoints.size())
			{
				throw new PluginInstantiationException(
					"Not every declared entrypoint is a valid plugin");
			}

			// This discovers plugin-provided Config interfaces, applies defaults, and makes
			// them available to RuneLite's normal configuration UI before the plugin starts.
			pluginManager.loadDefaultPluginConfiguration(plugins);
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
		catch (IOException | ClassNotFoundException | PluginInstantiationException ex)
		{
			cleanupFailedLoad(classLoader, plugins);
			throw new IllegalStateException("Unable to load marketplace plugin", ex);
		}
		catch (RuntimeException | LinkageError ex)
		{
			cleanupFailedLoad(classLoader, plugins);
			throw new IllegalStateException("Unable to load marketplace plugin", ex);
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
			catch (PluginInstantiationException ignored)
			{
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
			Throwable cause = ex.getCause();
			if (cause instanceof PluginOperationRuntimeException)
			{
				throw new PluginInstantiationException(cause.getCause());
			}
			throw new PluginInstantiationException(cause);
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
