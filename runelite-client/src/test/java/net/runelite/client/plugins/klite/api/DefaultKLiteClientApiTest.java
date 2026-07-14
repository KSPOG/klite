/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.client.callback.ClientThread;
import net.runelite.api.gameval.InventoryID;
import org.junit.Test;

public class DefaultKLiteClientApiTest
{
	@Test
	public void inventoryReturnsOnlyOccupiedSlots() throws Exception
	{
		Client client = mock(Client.class);
		when(client.isClientThread()).thenReturn(true);
		ItemContainer inventory = mock(ItemContainer.class);
		when(inventory.getItems()).thenReturn(new Item[]{
			new Item(100, 2),
			new Item(-1, 0),
			new Item(200, 1)
		});
		when(client.getItemContainer(InventoryID.INV)).thenReturn(inventory);

		DefaultKLiteClientApi api = new DefaultKLiteClientApi(
			client, new KLiteThreadGateway(client, mock(ClientThread.class)));
		List<KLiteItemStack> items = api.inventory().get();

		assertEquals(2, items.size());
		assertEquals(new KLiteItemStack(0, 100, 2), items.get(0));
		assertEquals(new KLiteItemStack(2, 200, 1), items.get(1));
	}
}
