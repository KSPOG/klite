/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.walker;

import com.google.gson.Gson;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.LongSupplier;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.client.config.ConfigManager;

/**
 * Persists the last complete bank container in the active RuneScape profile.
 * Reads are served from an immutable snapshot and are safe for pathfinder threads.
 */
@Singleton
@Slf4j
public class WebWalkBankCache
{
	static final String CONFIG_GROUP = "kliteWebWalker";
	static final String CONFIG_KEY = "bankCacheV1";
	private static final int FORMAT_VERSION = 1;

	private final Client client;
	private final ConfigManager configManager;
	private final Gson gson;
	private final LongSupplier currentTimeMillis;

	private volatile WebWalkBankSnapshot snapshot = WebWalkBankSnapshot.unknown(0L);

	@Inject
	WebWalkBankCache(Client client, ConfigManager configManager, Gson gson)
	{
		this(client, configManager, gson, System::currentTimeMillis);
	}

	WebWalkBankCache(Client client, ConfigManager configManager, Gson gson,
		LongSupplier currentTimeMillis)
	{
		this.client = client;
		this.configManager = configManager;
		this.gson = gson;
		this.currentTimeMillis = currentTimeMillis;
	}

	public WebWalkBankSnapshot snapshot()
	{
		long accountHash = client.getAccountHash();
		WebWalkBankSnapshot current = snapshot;
		if (current.getAccountHash() != accountHash)
		{
			return load(accountHash);
		}
		return current;
	}

	public long quantity(int itemId)
	{
		return itemId < 0 ? 0L : snapshot().quantity(itemId);
	}

	public boolean contains(int itemId)
	{
		return quantity(itemId) > 0;
	}

	public synchronized void update(ItemContainer bank)
	{
		long accountHash = client.getAccountHash();
		if (accountHash == 0L)
		{
			snapshot = WebWalkBankSnapshot.unknown(0L);
			return;
		}

		Map<Integer, Long> quantities = new HashMap<>();
		for (Item item : bank.getItems())
		{
			if (item != null && item.getId() >= 0 && item.getQuantity() > 0)
			{
				quantities.merge(item.getId(), (long) item.getQuantity(), Long::sum);
			}
		}

		long updatedAt = currentTimeMillis.getAsLong();
		WebWalkBankSnapshot updated = new WebWalkBankSnapshot(
			true, accountHash, updatedAt, quantities);
		StoredBankCache stored = new StoredBankCache(
			FORMAT_VERSION, accountHash, updatedAt, quantities);
		configManager.setRSProfileConfiguration(CONFIG_GROUP, CONFIG_KEY, gson.toJson(stored));
		snapshot = updated;
	}

	public synchronized void onAccountChanged()
	{
		load(client.getAccountHash());
	}

	public void clearMemory()
	{
		snapshot = WebWalkBankSnapshot.unknown(0L);
	}

	private synchronized WebWalkBankSnapshot load(long accountHash)
	{
		if (accountHash == 0L)
		{
			snapshot = WebWalkBankSnapshot.unknown(0L);
			return snapshot;
		}

		String json = configManager.getRSProfileConfiguration(CONFIG_GROUP, CONFIG_KEY);
		if (json == null || json.isBlank())
		{
			snapshot = WebWalkBankSnapshot.unknown(accountHash);
			return snapshot;
		}

		try
		{
			StoredBankCache stored = gson.fromJson(json, StoredBankCache.class);
			if (stored == null || stored.version != FORMAT_VERSION
				|| stored.accountHash != accountHash || stored.updatedAtEpochMillis < 0)
			{
				snapshot = WebWalkBankSnapshot.unknown(accountHash);
				return snapshot;
			}

			Map<Integer, Long> quantities = sanitize(stored.itemQuantities);
			snapshot = new WebWalkBankSnapshot(
				true, accountHash, stored.updatedAtEpochMillis, quantities);
		}
		catch (RuntimeException ex)
		{
			log.warn("Unable to read the KLite bank cache for the current account", ex);
			snapshot = WebWalkBankSnapshot.unknown(accountHash);
		}
		return snapshot;
	}

	private static Map<Integer, Long> sanitize(Map<Integer, Long> quantities)
	{
		if (quantities == null || quantities.isEmpty())
		{
			return Collections.emptyMap();
		}
		Map<Integer, Long> sanitized = new HashMap<>();
		for (Map.Entry<Integer, Long> entry : quantities.entrySet())
		{
			Integer itemId = entry.getKey();
			Long quantity = entry.getValue();
			if (itemId != null && itemId >= 0 && quantity != null && quantity > 0)
			{
				sanitized.put(itemId, quantity);
			}
		}
		return sanitized;
	}

	private static final class StoredBankCache
	{
		private final int version;
		private final long accountHash;
		private final long updatedAtEpochMillis;
		private final Map<Integer, Long> itemQuantities;

		private StoredBankCache(int version, long accountHash, long updatedAtEpochMillis,
			Map<Integer, Long> itemQuantities)
		{
			this.version = version;
			this.accountHash = accountHash;
			this.updatedAtEpochMillis = updatedAtEpochMillis;
			this.itemQuantities = itemQuantities;
		}
	}
}
