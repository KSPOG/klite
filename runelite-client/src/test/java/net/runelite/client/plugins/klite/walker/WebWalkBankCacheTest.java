/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.walker;

import com.google.gson.Gson;
import java.util.Map;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.client.config.ConfigManager;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class WebWalkBankCacheTest
{
	private static final long ACCOUNT_HASH = 123456789L;

	private Client client;
	private ConfigManager configManager;
	private Gson gson;

	@Before
	public void setUp()
	{
		client = mock(Client.class);
		configManager = mock(ConfigManager.class);
		gson = new Gson();
		when(client.getAccountHash()).thenReturn(ACCOUNT_HASH);
	}

	@Test
	public void bankUpdatePersistsAndSurvivesServiceRestart()
	{
		ItemContainer bank = mock(ItemContainer.class);
		when(bank.getItems()).thenReturn(new Item[]{
			new Item(100, Integer.MAX_VALUE),
			new Item(100, 10),
			new Item(200, 3),
			new Item(-1, 0)
		});
		WebWalkBankCache cache = new WebWalkBankCache(
			client, configManager, gson, () -> 42_000L);

		cache.update(bank);

		WebWalkBankSnapshot current = cache.snapshot();
		assertTrue(current.isKnown());
		assertEquals(ACCOUNT_HASH, current.getAccountHash());
		assertEquals(42_000L, current.getUpdatedAtEpochMillis());
		assertEquals((long) Integer.MAX_VALUE + 10L, current.quantity(100));
		assertEquals(3L, current.quantity(200));

		ArgumentCaptor<String> persistedJson = ArgumentCaptor.forClass(String.class);
		verify(configManager).setRSProfileConfiguration(
			eq(WebWalkBankCache.CONFIG_GROUP), eq(WebWalkBankCache.CONFIG_KEY),
			persistedJson.capture());
		when(configManager.getRSProfileConfiguration(
			WebWalkBankCache.CONFIG_GROUP, WebWalkBankCache.CONFIG_KEY))
			.thenReturn(persistedJson.getValue());

		WebWalkBankCache afterRestart = new WebWalkBankCache(
			client, configManager, gson, () -> 99_000L);
		WebWalkBankSnapshot restored = afterRestart.snapshot();

		assertTrue(restored.isKnown());
		assertEquals(42_000L, restored.getUpdatedAtEpochMillis());
		assertEquals((long) Integer.MAX_VALUE + 10L, afterRestart.quantity(100));
		assertTrue(afterRestart.contains(200));
	}

	@Test
	public void storedAccountHashPreventsCrossAccountReuse()
	{
		String stored = "{\"version\":1,\"accountHash\":" + ACCOUNT_HASH
			+ ",\"updatedAtEpochMillis\":100,\"itemQuantities\":{\"100\":5}}";
		when(configManager.getRSProfileConfiguration(
			WebWalkBankCache.CONFIG_GROUP, WebWalkBankCache.CONFIG_KEY)).thenReturn(stored);
		when(client.getAccountHash()).thenReturn(999L);
		WebWalkBankCache cache = new WebWalkBankCache(
			client, configManager, gson, () -> 1L);

		WebWalkBankSnapshot snapshot = cache.snapshot();

		assertFalse(snapshot.isKnown());
		assertEquals(999L, snapshot.getAccountHash());
		assertEquals(0L, cache.quantity(100));
	}

	@Test
	public void snapshotCannotBeMutatedByPathfinderConsumers()
	{
		WebWalkBankSnapshot snapshot = new WebWalkBankSnapshot(
			true, ACCOUNT_HASH, 100L, Map.of(100, 5L));

		try
		{
			snapshot.getItemQuantities().put(200, 1L);
			fail("Expected bank quantities to be immutable");
		}
		catch (UnsupportedOperationException expected)
		{
			assertEquals(0L, snapshot.quantity(200));
		}
	}

	@Test
	public void noAccountDoesNotPersistBankData()
	{
		when(client.getAccountHash()).thenReturn(0L);
		ItemContainer bank = mock(ItemContainer.class);
		when(bank.getItems()).thenReturn(new Item[]{new Item(100, 1)});
		WebWalkBankCache cache = new WebWalkBankCache(
			client, configManager, gson, () -> 1L);

		cache.update(bank);

		assertFalse(cache.snapshot().isKnown());
		verify(configManager, org.mockito.Mockito.never()).setRSProfileConfiguration(
			eq(WebWalkBankCache.CONFIG_GROUP), eq(WebWalkBankCache.CONFIG_KEY),
			org.mockito.ArgumentMatchers.anyString());
	}
}
