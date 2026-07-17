/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.RuneLite;

/** Saves loaded and enabled marketplace plugins independently for each KLite account. */
@Singleton
@Slf4j
public final class KLiteMarketplacePersistenceService
{
	private static final File DIRECTORY = new File(RuneLite.RUNELITE_DIR, "klite");
	private static final File STATE_FILE = new File(DIRECTORY, "marketplace-plugin-state.json");

	private final Gson gson;
	private final KLiteAccountService accountService;
	private final KLiteMarketplaceClient marketplaceClient;
	private final KLiteStreamedPluginService streamedPluginService;
	private volatile boolean started;
	private volatile boolean restoring;
	private volatile String activeAccountKey;

	@Inject
	KLiteMarketplacePersistenceService(Gson gson, KLiteAccountService accountService,
		KLiteMarketplaceClient marketplaceClient,
		KLiteStreamedPluginService streamedPluginService)
	{
		this.gson = gson;
		this.accountService = accountService;
		this.marketplaceClient = marketplaceClient;
		this.streamedPluginService = streamedPluginService;
	}

	public synchronized void start()
	{
		if (started)
		{
			return;
		}
		started = true;
		streamedPluginService.addChangeListener(this::saveCurrentState);
		accountService.addChangeListener(this::accountChanged);
		log.info("Restoring the protected KLite marketplace account session");
		accountService.restoreSession().whenComplete((account, error) ->
		{
			if (error != null)
			{
				log.warn("Unable to restore the protected KLite account session", unwrap(error));
			}
			else if (account.isPresent())
			{
				log.info("Restored KLite marketplace account {}", account.get().getUsername());
			}
			else
			{
				log.info("No saved KLite marketplace account session was available");
			}
		});
	}

	public void shutdown()
	{
		saveCurrentState();
	}

	private void accountChanged(Optional<KLiteAccountState> account)
	{
		if (account.isEmpty())
		{
			activeAccountKey = null;
			restoring = true;
			unloadAll().whenComplete((ignored, error) ->
			{
				restoring = false;
				if (error != null)
				{
					log.warn("Unable to unload marketplace plugins after account sign-out", unwrap(error));
				}
			});
			return;
		}

		String accountKey = accountKey(account.get().getEmail());
		if (accountKey.equals(activeAccountKey) && restoring)
		{
			return;
		}

		StoredPluginState state = readState();
		StoredAccountPlugins saved = state.accounts.get(accountKey);
		StoredAccountPlugins currentlyLoaded = snapshotCurrentPlugins();
		StoredAccountPlugins desired = merge(saved, currentlyLoaded);
		activeAccountKey = accountKey;

		// Plugins loaded before sign-in are adopted by the account instead of being
		// discarded. Existing account preferences are merged with the current list.
		if (!currentlyLoaded.loaded.isEmpty())
		{
			state.accounts.put(accountKey, desired);
			writeState(state);
			log.info("Associated {} currently loaded marketplace plugin(s) with account {}",
				currentlyLoaded.loaded.size(), account.get().getUsername());
		}

		if (desired.loaded.isEmpty())
		{
			log.info("Account {} has no saved marketplace plugins to restore",
				account.get().getUsername());
			return;
		}
		restore(accountKey, desired);
	}

	private void restore(String accountKey, StoredAccountPlugins saved)
	{
		restoring = true;
		log.info("Restoring {} marketplace plugin(s) for the signed-in KLite account",
			saved.loaded.size());
		unloadAll()
			.thenCompose(ignored -> marketplaceClient.fetchCatalog())
			.thenCompose(catalog -> restorePlugins(catalog, saved))
			.whenComplete((ignored, error) ->
			{
				restoring = false;
				if (!accountKey.equals(activeAccountKey))
				{
					return;
				}
				if (error != null)
				{
					log.warn("Unable to restore saved KLite marketplace plugins", unwrap(error));
				}
				else
				{
					saveCurrentState();
					log.info("Saved KLite marketplace plugins were restored successfully");
				}
			});
	}

	private CompletableFuture<Void> restorePlugins(KLiteMarketplaceCatalog catalog,
		StoredAccountPlugins saved)
	{
		Map<String, KLiteMarketplacePlugin> pluginsById = new HashMap<>();
		for (KLiteMarketplacePlugin plugin : catalog.getPlugins())
		{
			pluginsById.put(plugin.getId(), plugin);
		}

		CompletableFuture<Void> chain = CompletableFuture.completedFuture(null);
		for (String pluginId : saved.loaded)
		{
			KLiteMarketplacePlugin plugin = pluginsById.get(pluginId);
			if (plugin == null || !"available".equals(plugin.getStatus()))
			{
				log.warn("Saved marketplace plugin {} is no longer available and was skipped", pluginId);
				continue;
			}
			chain = chain.thenCompose(ignored -> streamedPluginService.load(plugin));
			if (saved.enabled.contains(pluginId))
			{
				chain = chain.thenCompose(ignored -> streamedPluginService.start(pluginId));
			}
		}
		return chain;
	}

	private CompletableFuture<Void> unloadAll()
	{
		List<CompletableFuture<Void>> operations = new ArrayList<>();
		for (KLiteStreamedPluginService.LoadedMarketplacePlugin loaded
			: streamedPluginService.loadedMarketplacePlugins())
		{
			operations.add(streamedPluginService.unload(
				loaded.getMarketplacePlugin().getId()));
		}
		return CompletableFuture.allOf(operations.toArray(new CompletableFuture<?>[0]));
	}

	private synchronized void saveCurrentState()
	{
		if (restoring)
		{
			return;
		}
		Optional<KLiteAccountState> account = accountService.currentAccount();
		if (account.isEmpty())
		{
			return;
		}
		String key = accountKey(account.get().getEmail());
		StoredPluginState state = readState();
		state.accounts.put(key, snapshotCurrentPlugins());
		writeState(state);
	}

	private StoredAccountPlugins snapshotCurrentPlugins()
	{
		List<String> loaded = new ArrayList<>();
		List<String> enabled = new ArrayList<>();
		for (KLiteStreamedPluginService.LoadedMarketplacePlugin plugin
			: streamedPluginService.loadedMarketplacePlugins())
		{
			String pluginId = plugin.getMarketplacePlugin().getId();
			loaded.add(pluginId);
			if (plugin.isRunning())
			{
				enabled.add(pluginId);
			}
		}
		Collections.sort(loaded);
		Collections.sort(enabled);
		return new StoredAccountPlugins(loaded, enabled);
	}

	private static StoredAccountPlugins merge(StoredAccountPlugins saved,
		StoredAccountPlugins currentlyLoaded)
	{
		Set<String> loaded = new LinkedHashSet<>();
		Set<String> enabled = new LinkedHashSet<>();
		if (saved != null)
		{
			loaded.addAll(saved.loaded);
			enabled.addAll(saved.enabled);
		}
		loaded.addAll(currentlyLoaded.loaded);
		enabled.addAll(currentlyLoaded.enabled);
		List<String> loadedList = new ArrayList<>(loaded);
		List<String> enabledList = new ArrayList<>(enabled);
		Collections.sort(loadedList);
		Collections.sort(enabledList);
		return new StoredAccountPlugins(loadedList, enabledList);
	}

	private StoredPluginState readState()
	{
		if (!STATE_FILE.isFile())
		{
			return new StoredPluginState();
		}
		try
		{
			StoredPluginState state = gson.fromJson(
				Files.readString(STATE_FILE.toPath(), StandardCharsets.UTF_8),
				StoredPluginState.class);
			if (state == null)
			{
				return new StoredPluginState();
			}
			if (state.accounts == null)
			{
				state.accounts = new HashMap<>();
			}
			return state;
		}
		catch (IOException | RuntimeException exception)
		{
			log.warn("Unable to read saved KLite marketplace plugin state", exception);
			return new StoredPluginState();
		}
	}

	private void writeState(StoredPluginState state)
	{
		try
		{
			Files.createDirectories(DIRECTORY.toPath());
			File temporary = new File(DIRECTORY, STATE_FILE.getName() + ".tmp");
			Files.writeString(temporary.toPath(), gson.toJson(state), StandardCharsets.UTF_8);
			Files.move(temporary.toPath(), STATE_FILE.toPath(),
				StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
		}
		catch (IOException exception)
		{
			log.warn("Unable to save KLite marketplace plugin state", exception);
		}
	}

	private static String accountKey(String email)
	{
		try
		{
			byte[] digest = MessageDigest.getInstance("SHA-256")
				.digest(email.trim().toLowerCase().getBytes(StandardCharsets.UTF_8));
			StringBuilder result = new StringBuilder(digest.length * 2);
			for (byte value : digest)
			{
				result.append(String.format("%02x", value & 0xff));
			}
			return result.toString();
		}
		catch (NoSuchAlgorithmException exception)
		{
			throw new IllegalStateException("SHA-256 is unavailable", exception);
		}
	}

	private static Throwable unwrap(Throwable error)
	{
		Throwable current = error;
		while (current instanceof CompletionException && current.getCause() != null)
		{
			current = current.getCause();
		}
		return current;
	}

	@SuppressWarnings("unused")
	private static final class StoredPluginState
	{
		private int schemaVersion = 1;
		private Map<String, StoredAccountPlugins> accounts = new HashMap<>();
	}

	private static final class StoredAccountPlugins
	{
		private List<String> loaded = new ArrayList<>();
		private List<String> enabled = new ArrayList<>();

		private StoredAccountPlugins()
		{
		}

		private StoredAccountPlugins(List<String> loaded, List<String> enabled)
		{
			this.loaded = new ArrayList<>(loaded);
			this.enabled = new ArrayList<>(enabled);
		}
	}
}
