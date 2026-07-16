/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.RuneLite;
import net.runelite.client.plugins.PluginManager;

/** Watches locally built plugin jars and reloads them for verified plugin developers. */
@Singleton
@Slf4j
class KLiteDeveloperHotReloadService
{
	private static final File PLUGIN_DIRECTORY =
		new File(RuneLite.RUNELITE_DIR, "sideloaded-plugins");

	private final ScheduledExecutorService executor;
	private final PluginManager pluginManager;
	private final KLiteAccountService accountService;

	@Nullable
	private ScheduledFuture<?> watcher;
	private Map<String, String> observed = Collections.emptyMap();
	private Map<String, String> loaded = Collections.emptyMap();
	private long nextAuthorizationRefresh;

	@Inject
	KLiteDeveloperHotReloadService(ScheduledExecutorService executor,
		PluginManager pluginManager, KLiteAccountService accountService)
	{
		this.executor = executor;
		this.pluginManager = pluginManager;
		this.accountService = accountService;
	}

	synchronized boolean setEnabled(boolean enabled)
	{
		if (!enabled)
		{
			disable();
			return false;
		}
		if (!hasDeveloperCapability())
		{
			return false;
		}
		if (watcher != null)
		{
			return true;
		}
		if (!PLUGIN_DIRECTORY.exists() && !PLUGIN_DIRECTORY.mkdirs())
		{
			log.warn("Unable to create plugin hot-reload directory {}", PLUGIN_DIRECTORY);
			return false;
		}
		observed = snapshot();
		loaded = Collections.emptyMap();
		nextAuthorizationRefresh = System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(5);
		watcher = executor.scheduleWithFixedDelay(this::poll, 1, 1, TimeUnit.SECONDS);
		return true;
	}

	synchronized boolean isEnabled()
	{
		return watcher != null;
	}

	synchronized void disable()
	{
		if (watcher != null)
		{
			watcher.cancel(false);
			watcher = null;
		}
		observed = Collections.emptyMap();
		loaded = Collections.emptyMap();
	}

	private void poll()
	{
		if (!hasDeveloperCapability())
		{
			disable();
			return;
		}
		long now = System.currentTimeMillis();
		if (now >= nextAuthorizationRefresh)
		{
			nextAuthorizationRefresh = now + TimeUnit.MINUTES.toMillis(5);
			accountService.refreshEntitlements().whenComplete((account, error) ->
			{
				if (error != null || !account.hasCapability("plugin_dev"))
				{
					disable();
				}
			});
		}

		Map<String, String> current = snapshot();
		if (current.equals(observed) && !current.equals(loaded))
		{
			try
			{
				pluginManager.reloadSideLoadPlugins();
				loaded = current;
			}
			catch (RuntimeException ex)
			{
				log.warn("Unable to hot reload side-loaded plugins", ex);
			}
		}
		observed = current;
	}

	private boolean hasDeveloperCapability()
	{
		return accountService.currentAccount()
			.map(account -> account.hasCapability("plugin_dev"))
			.orElse(false);
	}

	private static Map<String, String> snapshot()
	{
		File[] files = PLUGIN_DIRECTORY.listFiles((directory, name) -> name.endsWith(".jar"));
		if (files == null)
		{
			return Collections.emptyMap();
		}
		Arrays.sort(files, (left, right) -> left.getName().compareTo(right.getName()));
		Map<String, String> result = new LinkedHashMap<>();
		for (File file : files)
		{
			result.put(file.getAbsolutePath(), file.length() + ":" + file.lastModified());
		}
		return Collections.unmodifiableMap(result);
	}

	static File pluginDirectory()
	{
		return PLUGIN_DIRECTORY;
	}
}
