/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.InventoryID;

@Singleton
public class DefaultKLiteClientApi implements KLiteClientApi
{
	private final Client client;
	private final KLiteThreadGateway threadGateway;

	@Inject
	DefaultKLiteClientApi(Client client, KLiteThreadGateway threadGateway)
	{
		this.client = client;
		this.threadGateway = threadGateway;
	}

	@Override
	public CompletableFuture<KLiteClientSnapshot> snapshot()
	{
		return threadGateway.submit(() ->
		{
			Player player = client.getLocalPlayer();
			WorldPoint location = player == null ? null : player.getWorldLocation();
			return new KLiteClientSnapshot(
				client.getGameState(),
				location,
				client.getWorld(),
				System.currentTimeMillis());
		});
	}

	@Override
	public CompletableFuture<List<KLiteItemStack>> inventory()
	{
		return threadGateway.submit(() ->
		{
			ItemContainer inventory = client.getItemContainer(InventoryID.INV);
			if (inventory == null)
			{
				return ImmutableList.of();
			}

			ImmutableList.Builder<KLiteItemStack> items = ImmutableList.builder();
			Item[] itemArray = inventory.getItems();
			for (int slot = 0; slot < itemArray.length; slot++)
			{
				Item item = itemArray[slot];
				if (item.getId() >= 0 && item.getQuantity() > 0)
				{
					items.add(new KLiteItemStack(slot, item.getId(), item.getQuantity()));
				}
			}
			return items.build();
		});
	}

	@Override
	public CompletableFuture<Void> onClientThread(Runnable action)
	{
		return threadGateway.execute(action);
	}
}
