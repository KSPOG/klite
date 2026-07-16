/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.client.callback.ClientThread;
import org.junit.Before;
import org.junit.Test;

public class DefaultKLiteClientApiItemContainerTest
{
	private static final int OTHER_TRADE_CONTAINER = 90 | 0x8000;

	private Client client;
	private DefaultKLiteClientApi api;

	@Before
	public void setUp()
	{
		client = mock(Client.class);
		when(client.isClientThread()).thenReturn(true);
		api = new DefaultKLiteClientApi(
			client, new KLiteThreadGateway(client, mock(ClientThread.class)));
	}

	@Test
	public void arbitraryContainerReturnsDetachedItemsAndMetadata() throws Exception
	{
		ItemContainer container = mock(ItemContainer.class);
		Item first = new Item(100, 3);
		Item empty = new Item(-1, 0);
		Item second = new Item(100, 5);
		Item[] liveItems = {first, null, empty, second};
		when(client.getItemContainer(OTHER_TRADE_CONTAINER)).thenReturn(container);
		when(container.getId()).thenReturn(OTHER_TRADE_CONTAINER);
		when(container.size()).thenReturn(4);
		when(container.count()).thenReturn(2);
		when(container.getItems()).thenReturn(liveItems);

		KLiteItemContainerSnapshot snapshot =
			api.itemContainer(OTHER_TRADE_CONTAINER).get().get();
		liveItems[0] = null;

		assertEquals(OTHER_TRADE_CONTAINER, snapshot.getId());
		assertEquals(4, snapshot.getSize());
		assertEquals(2, snapshot.getFilledSlots());
		assertEquals(Arrays.asList(
			new KLiteItemStack(0, 100, 3),
			new KLiteItemStack(3, 100, 5)), snapshot.getItems());
	}

	@Test
	public void arbitraryContainerSupportsItemQueries() throws Exception
	{
		ItemContainer container = mock(ItemContainer.class);
		when(client.getItemContainer(OTHER_TRADE_CONTAINER)).thenReturn(container);
		when(container.getItems()).thenReturn(new Item[]{
			new Item(100, 3), null, new Item(-1, 0), new Item(100, 5)});

		assertEquals(new KLiteItemStack(0, 100, 3),
			api.itemContainerItem(OTHER_TRADE_CONTAINER, 0).get().get());
		assertEquals(8L,
			api.itemContainerCount(OTHER_TRADE_CONTAINER, 100).get().longValue());
		assertTrue(api.itemContainerContains(OTHER_TRADE_CONTAINER, 100).get());
		assertEquals(Integer.valueOf(0),
			api.firstItemContainerSlot(OTHER_TRADE_CONTAINER, 100).get().get());
		assertFalse(api.itemContainerItem(OTHER_TRADE_CONTAINER, 1).get().isPresent());
	}

	@Test
	public void invalidOrUnavailableContainerQueriesReturnEmptyDefaults() throws Exception
	{
		assertFalse(api.itemContainer(-1).get().isPresent());
		assertFalse(api.itemContainer(1234).get().isPresent());
		assertFalse(api.itemContainerItem(-1, 0).get().isPresent());
		assertFalse(api.itemContainerItem(1234, -1).get().isPresent());
		assertEquals(0L, api.itemContainerCount(-1, 100).get().longValue());
		assertEquals(0L, api.itemContainerCount(1234, -1).get().longValue());
		assertFalse(api.itemContainerContains(-1, 100).get());
		assertFalse(api.itemContainerContains(1234, -1).get());
		assertFalse(api.firstItemContainerSlot(-1, 100).get().isPresent());
		assertFalse(api.firstItemContainerSlot(1234, -1).get().isPresent());
	}

}
