/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import com.google.common.collect.ImmutableList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.NPC;
import net.runelite.api.ObjectComposition;
import net.runelite.api.Player;
import net.runelite.api.Scene;
import net.runelite.api.Skill;
import net.runelite.api.Tile;
import net.runelite.api.TileItem;
import net.runelite.api.TileObject;
import net.runelite.api.WorldView;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.InventoryID;

/** Default thread-safe implementation of the public KLite read API. */
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
		return itemContainer(InventoryID.INV);
	}

	@Override
	public CompletableFuture<List<KLiteItemStack>> equipment()
	{
		return itemContainer(InventoryID.WORN);
	}

	@Override
	public CompletableFuture<List<KLiteSkillSnapshot>> skills()
	{
		return threadGateway.submit(() ->
		{
			ImmutableList.Builder<KLiteSkillSnapshot> snapshots = ImmutableList.builder();
			for (Skill skill : Skill.values())
			{
				snapshots.add(new KLiteSkillSnapshot(
					skill,
					client.getRealSkillLevel(skill),
					client.getBoostedSkillLevel(skill),
					client.getSkillExperience(skill)));
			}
			return snapshots.build();
		});
	}

	@Override
	public CompletableFuture<List<KLitePlayerSnapshot>> players()
	{
		return threadGateway.submit(() ->
		{
			WorldView worldView = client.getTopLevelWorldView();
			if (worldView == null)
			{
				return ImmutableList.of();
			}

			Player localPlayer = client.getLocalPlayer();
			ImmutableList.Builder<KLitePlayerSnapshot> snapshots = ImmutableList.builder();
			for (Player player : worldView.players())
			{
				snapshots.add(new KLitePlayerSnapshot(
					player.getId(),
					player.getName(),
					player.getCombatLevel(),
					player.getWorldLocation(),
					player.getAnimation(),
					player.getPoseAnimation(),
					player == localPlayer,
					player.isFriend(),
					player.isFriendsChatMember(),
					player.isClanMember(),
					actorName(player.getInteracting())));
			}
			return snapshots.build();
		});
	}

	@Override
	public CompletableFuture<List<KLiteNpcSnapshot>> npcs()
	{
		return threadGateway.submit(() ->
		{
			WorldView worldView = client.getTopLevelWorldView();
			if (worldView == null)
			{
				return ImmutableList.of();
			}

			ImmutableList.Builder<KLiteNpcSnapshot> snapshots = ImmutableList.builder();
			for (NPC npc : worldView.npcs())
			{
				snapshots.add(new KLiteNpcSnapshot(
					npc.getId(),
					npc.getIndex(),
					npc.getName(),
					npc.getCombatLevel(),
					npc.getWorldLocation(),
					npc.getAnimation(),
					npc.getPoseAnimation(),
					npc.getHealthRatio(),
					npc.getHealthScale(),
					actorName(npc.getInteracting())));
			}
			return snapshots.build();
		});
	}

	@Override
	public CompletableFuture<List<KLiteGroundItemSnapshot>> groundItems()
	{
		return threadGateway.submit(() ->
		{
			WorldView worldView = client.getTopLevelWorldView();
			if (worldView == null || worldView.getScene() == null)
			{
				return ImmutableList.of();
			}

			ImmutableList.Builder<KLiteGroundItemSnapshot> snapshots = ImmutableList.builder();
			addGroundItems(worldView.getScene(), snapshots);
			return snapshots.build();
		});
	}

	@Override
	public CompletableFuture<List<KLiteSceneObjectSnapshot>> sceneObjects()
	{
		return threadGateway.submit(() ->
		{
			WorldView worldView = client.getTopLevelWorldView();
			if (worldView == null || worldView.getScene() == null)
			{
				return ImmutableList.of();
			}

			Set<String> seenObjects = new HashSet<>();
			ImmutableList.Builder<KLiteSceneObjectSnapshot> snapshots = ImmutableList.builder();
			for (Tile[][] plane : worldView.getScene().getTiles())
			{
				for (Tile[] row : plane)
				{
					for (Tile tile : row)
					{
						if (tile == null)
						{
							continue;
						}
						for (TileObject gameObject : tile.getGameObjects())
						{
							addSceneObject(gameObject, KLiteSceneObjectType.GAME, seenObjects, snapshots);
						}
						addSceneObject(tile.getWallObject(), KLiteSceneObjectType.WALL, seenObjects, snapshots);
						addSceneObject(tile.getGroundObject(), KLiteSceneObjectType.GROUND, seenObjects, snapshots);
						addSceneObject(tile.getDecorativeObject(), KLiteSceneObjectType.DECORATIVE,
							seenObjects, snapshots);
					}
				}
			}
			return snapshots.build();
		});
	}

	@Override
	public CompletableFuture<Void> menuAction(KLiteMenuActionRequest request)
	{
		return threadGateway.execute(() -> client.menuAction(
			request.getParam0(),
			request.getParam1(),
			request.getAction(),
			request.getIdentifier(),
			request.getItemId(),
			request.getOption(),
			request.getTarget()));
	}
	@Override
	public CompletableFuture<Void> onClientThread(Runnable action)
	{
		return threadGateway.execute(action);
	}

	private void addSceneObject(
		@Nullable TileObject object,
		KLiteSceneObjectType type,
		Set<String> seenObjects,
		ImmutableList.Builder<KLiteSceneObjectSnapshot> snapshots)
	{
		if (object == null || !seenObjects.add(type + ":" + object.getHash()))
		{
			return;
		}

		ObjectComposition composition = client.getObjectDefinition(object.getId());
		if (composition.getImpostorIds() != null)
		{
			ObjectComposition transformed = composition.getImpostor();
			if (transformed != null)
			{
				composition = transformed;
			}
		}

		ImmutableList.Builder<String> actions = ImmutableList.builder();
		String[] compositionActions = composition.getActions();
		for (int index = 0; index < compositionActions.length; index++)
		{
			String override = object.getOpOverride(index);
			String action = override == null ? compositionActions[index] : override;
			if (action != null && !action.isBlank())
			{
				actions.add(action);
			}
		}
		snapshots.add(new KLiteSceneObjectSnapshot(
			object.getId(), composition.getName(), type, object.getWorldLocation(), actions.build()));
	}
	private CompletableFuture<List<KLiteItemStack>> itemContainer(int inventoryId)
	{
		return threadGateway.submit(() ->
		{
			ItemContainer container = client.getItemContainer(inventoryId);
			if (container == null)
			{
				return ImmutableList.of();
			}

			ImmutableList.Builder<KLiteItemStack> items = ImmutableList.builder();
			Item[] itemArray = container.getItems();
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

	private static void addGroundItems(
		Scene scene, ImmutableList.Builder<KLiteGroundItemSnapshot> snapshots)
	{
		for (Tile[][] plane : scene.getTiles())
		{
			for (Tile[] row : plane)
			{
				for (Tile tile : row)
				{
					if (tile == null)
					{
						continue;
					}
					for (TileItem item : tile.getGroundItems())
					{
						snapshots.add(new KLiteGroundItemSnapshot(
							item.getId(),
							item.getQuantity(),
							tile.getWorldLocation(),
							item.getVisibleTime(),
							item.getDespawnTime(),
							item.getOwnership(),
							item.isPrivate()));
					}
				}
			}
		}
	}

	@Nullable
	private static String actorName(@Nullable Actor actor)
	{
		return actor == null ? null : actor.getName();
	}
}
