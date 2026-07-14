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
import net.runelite.api.ItemComposition;
import net.runelite.api.MenuAction;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.ObjectComposition;
import net.runelite.api.Player;
import net.runelite.api.Scene;
import net.runelite.api.Skill;
import net.runelite.api.Tile;
import net.runelite.api.TileItem;
import net.runelite.api.TileObject;
import net.runelite.api.WorldView;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.InventoryID;

/** Default thread-safe implementation of the public KLite client API. */
@Singleton
public class DefaultKLiteClientApi implements KLiteClientApi
{

	private static final MenuAction[] NPC_ACTIONS =
	{
		MenuAction.NPC_FIRST_OPTION,
		MenuAction.NPC_SECOND_OPTION,
		MenuAction.NPC_THIRD_OPTION,
		MenuAction.NPC_FOURTH_OPTION,
		MenuAction.NPC_FIFTH_OPTION
	};
	private static final MenuAction[] OBJECT_ACTIONS =
	{
		MenuAction.GAME_OBJECT_FIRST_OPTION,
		MenuAction.GAME_OBJECT_SECOND_OPTION,
		MenuAction.GAME_OBJECT_THIRD_OPTION,
		MenuAction.GAME_OBJECT_FOURTH_OPTION,
		MenuAction.GAME_OBJECT_FIFTH_OPTION
	};
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
	public CompletableFuture<KLiteInteractionResult> interactInventoryItem(int slot, String option)
	{
		return threadGateway.submit(() ->
		{
			if (slot < 0 || isBlank(option))
			{
				return KLiteInteractionResult.invalidRequest("Slot must be non-negative and option must not be blank");
			}

			ItemContainer inventory = client.getItemContainer(InventoryID.INV);
			if (inventory == null || slot >= inventory.getItems().length)
			{
				return KLiteInteractionResult.targetNotFound("No inventory item exists in slot " + slot);
			}

			Item item = inventory.getItems()[slot];
			if (item.getId() < 0 || item.getQuantity() <= 0)
			{
				return KLiteInteractionResult.targetNotFound("No inventory item exists in slot " + slot);
			}

			ItemComposition composition = client.getItemDefinition(item.getId());
			int actionIndex = findAction(composition.getInventoryActions(), option);
			if (actionIndex < 0)
			{
				return KLiteInteractionResult.optionNotFound(
					"Inventory item does not expose option: " + option);
			}

			String action = composition.getInventoryActions()[actionIndex];
			client.menuAction(slot, InterfaceID.Inventory.ITEMS, itemMenuAction(actionIndex),
				actionIndex + 1, item.getId(), action, composition.getName());
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> interactNpc(int index, String option)
	{
		return threadGateway.submit(() ->
		{
			if (index < 0 || isBlank(option))
			{
				return KLiteInteractionResult.invalidRequest("NPC index must be non-negative and option must not be blank");
			}

			WorldView worldView = client.getTopLevelWorldView();
			NPC npc = findNpc(worldView, index);
			if (npc == null)
			{
				return KLiteInteractionResult.targetNotFound("NPC index is not present: " + index);
			}

			NPCComposition composition = npc.getTransformedComposition();
			if (composition == null)
			{
				composition = npc.getComposition();
			}
			int actionIndex = findAction(composition.getActions(), option);
			if (actionIndex < 0)
			{
				return KLiteInteractionResult.optionNotFound("NPC does not expose option: " + option);
			}

			String action = composition.getActions()[actionIndex];
			client.menuAction(0, 0, NPC_ACTIONS[actionIndex], index, -1, action, composition.getName());
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> interactPlayer(int id, String option)
	{
		return threadGateway.submit(() ->
		{
			if (id < 0 || isBlank(option))
			{
				return KLiteInteractionResult.invalidRequest("Player id must be non-negative and option must not be blank");
			}

			WorldView worldView = client.getTopLevelWorldView();
			Player player = findPlayer(worldView, id);
			if (player == null)
			{
				return KLiteInteractionResult.targetNotFound("Player id is not present: " + id);
			}

			String[] options = client.getPlayerOptions();
			int actionIndex = findAction(options, option);
			int[] menuTypes = client.getPlayerMenuTypes();
			if (actionIndex < 0 || menuTypes == null || actionIndex >= menuTypes.length)
			{
				return KLiteInteractionResult.optionNotFound("Player does not expose option: " + option);
			}

			MenuAction action = MenuAction.of(menuTypes[actionIndex]);
			if (action == MenuAction.UNKNOWN)
			{
				return KLiteInteractionResult.optionNotFound("Player option has an unknown menu action: " + option);
			}

			client.menuAction(0, 0, action, id, -1, options[actionIndex], player.getName());
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> interactSceneObject(
		int objectId, WorldPoint location, String option)
	{
		return threadGateway.submit(() ->
		{
			if (objectId < 0 || location == null || isBlank(option))
			{
				return KLiteInteractionResult.invalidRequest(
					"Object id and location must be valid and option must not be blank");
			}

			TileObject object = findSceneObject(client.getTopLevelWorldView(), objectId, location);
			if (object == null)
			{
				return KLiteInteractionResult.targetNotFound("Scene object is no longer present");
			}

			ObjectComposition composition = objectComposition(object);
			String[] actions = resolveObjectActions(object, composition);
			int actionIndex = findAction(actions, option);
			if (actionIndex < 0)
			{
				return KLiteInteractionResult.optionNotFound("Scene object does not expose option: " + option);
			}

			LocalPoint local = object.getLocalLocation();
			client.menuAction(local.getSceneX(), local.getSceneY(), OBJECT_ACTIONS[actionIndex],
				object.getId(), -1, actions[actionIndex], composition.getName());
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> interactGroundItem(
		int itemId, WorldPoint location, String option)
	{
		return threadGateway.submit(() ->
		{
			if (itemId < 0 || location == null || isBlank(option))
			{
				return KLiteInteractionResult.invalidRequest(
					"Item id and location must be valid and option must not be blank");
			}
			if (!"Take".equalsIgnoreCase(option.trim()))
			{
				return KLiteInteractionResult.optionNotFound(
					"Only RuneLite's verified ground-item Take action is supported");
			}

			Tile tile = findTile(client.getTopLevelWorldView(), location);
			if (tile == null || !containsGroundItem(tile, itemId))
			{
				return KLiteInteractionResult.targetNotFound("Ground item is no longer present");
			}

			ItemComposition composition = client.getItemDefinition(itemId);
			LocalPoint local = tile.getLocalLocation();
			client.menuAction(local.getSceneX(), local.getSceneY(), MenuAction.GROUND_ITEM_THIRD_OPTION,
				itemId, itemId, "Take", composition.getName());
			return KLiteInteractionResult.dispatched();
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

	private static MenuAction itemMenuAction(int actionIndex)
	{
		return actionIndex < 3 ? MenuAction.CC_OP : MenuAction.CC_OP_LOW_PRIORITY;
	}
	private static int findAction(@Nullable String[] actions, String requested)
	{
		if (actions == null)
		{
			return -1;
		}
		String normalized = requested.trim();
		for (int index = 0; index < actions.length; index++)
		{
			if (actions[index] != null && actions[index].equalsIgnoreCase(normalized))
			{
				return index;
			}
		}
		return -1;
	}

	private static boolean isBlank(@Nullable String value)
	{
		return value == null || value.isBlank();
	}

	@Nullable
	private static NPC findNpc(@Nullable WorldView worldView, int index)
	{
		return worldView == null ? null : worldView.npcs().byIndex(index);
	}

	@Nullable
	private static Player findPlayer(@Nullable WorldView worldView, int id)
	{
		return worldView == null ? null : worldView.players().byIndex(id);
	}

	@Nullable
	private static TileObject findSceneObject(
		@Nullable WorldView worldView, int objectId, WorldPoint location)
	{
		Tile tile = findTile(worldView, location);
		if (tile == null)
		{
			return null;
		}
		for (TileObject object : tile.getGameObjects())
		{
			if (matchesObject(object, objectId, location))
			{
				return object;
			}
		}
		if (matchesObject(tile.getWallObject(), objectId, location))
		{
			return tile.getWallObject();
		}
		if (matchesObject(tile.getGroundObject(), objectId, location))
		{
			return tile.getGroundObject();
		}
		return matchesObject(tile.getDecorativeObject(), objectId, location)
			? tile.getDecorativeObject() : null;
	}

	private static boolean matchesObject(
		@Nullable TileObject object, int objectId, WorldPoint location)
	{
		return object != null && object.getId() == objectId && location.equals(object.getWorldLocation());
	}

	@Nullable
	private static Tile findTile(@Nullable WorldView worldView, WorldPoint location)
	{
		if (worldView == null || worldView.getScene() == null)
		{
			return null;
		}
		for (Tile[][] plane : worldView.getScene().getTiles())
		{
			for (Tile[] row : plane)
			{
				for (Tile tile : row)
				{
					if (tile != null && location.equals(tile.getWorldLocation()))
					{
						return tile;
					}
				}
			}
		}
		return null;
	}

	private static boolean containsGroundItem(Tile tile, int itemId)
	{
		for (TileItem item : tile.getGroundItems())
		{
			if (item.getId() == itemId)
			{
				return true;
			}
		}
		return false;
	}

	private ObjectComposition objectComposition(TileObject object)
	{
		ObjectComposition composition = client.getObjectDefinition(object.getId());
		if (composition.getImpostorIds() != null)
		{
			ObjectComposition transformed = composition.getImpostor();
			if (transformed != null)
			{
				return transformed;
			}
		}
		return composition;
	}

	private static String[] resolveObjectActions(
		TileObject object, ObjectComposition composition)
	{
		String[] compositionActions = composition.getActions();
		String[] actions = new String[compositionActions.length];
		for (int index = 0; index < compositionActions.length; index++)
		{
			String override = object.getOpOverride(index);
			actions[index] = override == null ? compositionActions[index] : override;
		}
		return actions;
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
