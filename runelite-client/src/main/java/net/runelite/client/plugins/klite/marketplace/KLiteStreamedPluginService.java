/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.SwingUtilities;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.ExternalPluginsChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginInstantiationException;
import net.runelite.client.plugins.PluginManager;

/** Owns the fetch, in-memory load, and unload lifecycle of marketplace plugins. */
@Singleton
class KLiteStreamedPluginService
{
	private final KLiteMarketplaceArtifactClient artifactClient;
	private final PluginManager pluginManager;
	private final EventBus eventBus;
	private final Map<String, LoadedPluginSet> loadedPlugins = new HashMap<>();
	private final Set<String> loadingPlugins = new HashSet<>();

	@Inject
	KLiteStreamedPluginService(KLiteMarketplaceArtifactClient artifactClient,
		PluginManager pluginManager, EventBus eventBus)
	{
		this.artifactClient = artifactClient;
		this.pluginManager = pluginManager;
		this.eventBus = eventBus;
	}

	synchronized boolean isRunning(String pluginId)
	{
		return loadedPlugins.containsKey(pluginId);
	}

	synchronized boolean isLoading(String pluginId)
	{
		return loadingPlugins.contains(pluginId);
	}

	CompletableFuture<Void> run(KLiteMarketplacePlugin marketplacePlugin)
	{
		synchronized (this)
		{
			if (loadedPlugins.containsKey(marketplacePlugin.getId())
				|| !loadingPlugins.add(marketplacePlugin.getId()))
			{
				return failedFuture(new IllegalStateException("Plugin is already running or loading"));
			}
		}

		return artifactClient.fetch(marketplacePlugin)
			.thenAccept(bytes -> load(marketplacePlugin, bytes))
			.whenComplete((ignored, error) ->
			{
				synchronized (this)
				{
					loadingPlugins.remove(marketplacePlugin.getId());
				}
			});
	}

	CompletableFuture<Void> stop(String pluginId)
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
		try
		{
			unload(pluginSet);
			return CompletableFuture.completedFuture(null);
		}
		catch (RuntimeException ex)
		{
			return failedFuture(ex);
		}
	}

	private void load(KLiteMarketplacePlugin marketplacePlugin, byte[] bytes)
	{
		KLiteInMemoryPluginClassLoader classLoader = null;
		List<Plugin> plugins = new ArrayList<>();
		try
		{
			classLoader = new KLiteInMemoryPluginClassLoader(
				bytes, PluginManager.class.getClassLoader());
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
			pluginManager.loadDefaultPluginConfiguration(plugins);
			startOnEdt(plugins);
			synchronized (this)
			{
				loadedPlugins.put(marketplacePlugin.getId(),
					new LoadedPluginSet(classLoader, plugins));
			}
			eventBus.post(new ExternalPluginsChanged());
		}
		catch (IOException | ClassNotFoundException | PluginInstantiationException ex)
		{
			cleanupFailedLoad(classLoader, plugins);
			throw new IllegalStateException("Unable to load marketplace plugin", ex);
		}
		catch (RuntimeException ex)
		{
			cleanupFailedLoad(classLoader, plugins);
			throw ex;
		}
	}

	private void startOnEdt(List<Plugin> plugins) throws PluginInstantiationException
	{
		try
		{
			SwingUtilities.invokeAndWait(() ->
			{
				for (Plugin plugin : plugins)
				{
					pluginManager.setPluginEnabled(plugin, true);
					try
					{
						pluginManager.startPlugin(plugin);
					}
					catch (PluginInstantiationException ex)
					{
						throw new PluginStartRuntimeException(ex);
					}
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

	@SuppressWarnings("PMD.UseTryWithResources") // The loader is owned by the loaded plugin set.
	private void unload(LoadedPluginSet pluginSet)
	{
		try
		{
			SwingUtilities.invokeAndWait(() ->
			{
				for (Plugin plugin : pluginSet.plugins)
				{
					try
					{
						pluginManager.stopPlugin(plugin);
					}
					catch (PluginInstantiationException ignored)
					{
						// Continue unloading the remaining classes and resources.
					}
					pluginManager.setPluginEnabled(plugin, false);
					pluginManager.remove(plugin);
				}
			});
		}
		catch (InterruptedException ex)
		{
			Thread.currentThread().interrupt();
			throw new IllegalStateException("Plugin unload was interrupted", ex);
		}
		catch (InvocationTargetException ex)
		{
			throw new IllegalStateException("Unable to unload marketplace plugin", ex.getCause());
		}
		finally
		{
			pluginSet.classLoader.close();
			eventBus.post(new ExternalPluginsChanged());
		}
	}

	private void cleanupFailedLoad(KLiteInMemoryPluginClassLoader classLoader, List<Plugin> plugins)
	{
		if (!plugins.isEmpty())
		{
			unload(new LoadedPluginSet(classLoader, plugins));
		}
		else if (classLoader != null)
		{
			classLoader.close();
		}
	}

	private static <T> CompletableFuture<T> failedFuture(Throwable error)
	{
		CompletableFuture<T> future = new CompletableFuture<>();
		future.completeExceptionally(error);
		return future;
	}

	private static final class LoadedPluginSet
	{
		private final KLiteInMemoryPluginClassLoader classLoader;
		private final List<Plugin> plugins;

		private LoadedPluginSet(KLiteInMemoryPluginClassLoader classLoader, List<Plugin> plugins)
		{
			this.classLoader = classLoader;
			this.plugins = plugins;
		}
	}

	private static final class PluginStartRuntimeException extends RuntimeException
	{
		private PluginStartRuntimeException(Throwable cause)
		{
			super(cause);
		}
	}
}
