/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import com.google.common.collect.ImmutableList;
import java.awt.Rectangle;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Deque;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.GraphicsObject;
import net.runelite.api.GrandExchangeOffer;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemComposition;
import net.runelite.api.MenuAction;
import net.runelite.api.MessageNode;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.ObjectComposition;
import net.runelite.api.Player;
import net.runelite.api.Prayer;
import net.runelite.api.Projectile;
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
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.gameval.VarPlayerID;
import net.runelite.api.widgets.Widget;

/** Default thread-safe implementation of the public KLite client API. */
@Singleton
public class DefaultKLiteClientApi implements KLiteClientApi
{

	private static final int VENOM_THRESHOLD = 1_000_000;
	private static final int[] DIALOG_CONTINUE_COMPONENTS =
	{
		InterfaceID.ChatBoth.CONTINUE,
		InterfaceID.ChatLeft.CONTINUE,
		InterfaceID.ChatRight.CONTINUE,
		InterfaceID.Messagebox.CONTINUE,
		InterfaceID.LevelupDisplay.CONTINUE
	};
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
	public CompletableFuture<KLiteRuntimeSnapshot> runtimeSnapshot()
	{
		return threadGateway.submit(() ->
		{
			WorldView worldView = client.getTopLevelWorldView();
			ImmutableList.Builder<Integer> mapRegions = ImmutableList.builder();
			if (worldView != null && worldView.getMapRegions() != null)
			{
				for (int mapRegion : worldView.getMapRegions())
				{
					mapRegions.add(mapRegion);
				}
			}
			return new KLiteRuntimeSnapshot(
				client.getGameState(),
				client.getWorld(),
				client.getWorldHost(),
				ImmutableList.copyOf(client.getWorldType()),
				client.getTickCount(),
				client.getGameCycle(),
				client.getFPS(),
				worldView == null ? -1 : worldView.getPlane(),
				client.isInInstancedRegion(),
				mapRegions.build(),
				System.currentTimeMillis());
		});
	}

	@Override
	public CompletableFuture<KLiteCameraSnapshot> cameraSnapshot()
	{
		return threadGateway.submit(() -> new KLiteCameraSnapshot(
			client.getCameraX(),
			client.getCameraY(),
			client.getCameraZ(),
			client.getCameraPitch(),
			client.getCameraYaw(),
			client.getCameraPitchTarget(),
			client.getCameraYawTarget()));
	}

	@Override
	public CompletableFuture<List<KLiteChatMessageSnapshot>> chatMessages()
	{
		return threadGateway.submit(() -> chatMessageSnapshots(null));
	}

	@Override
	public CompletableFuture<List<KLiteChatMessageSnapshot>> chatMessages(ChatMessageType type)
	{
		return threadGateway.submit(() -> chatMessageSnapshots(type));
	}

	@Override
	public CompletableFuture<Optional<KLiteChatMessageSnapshot>> chatMessage(int id)
	{
		return threadGateway.submit(() ->
		{
			if (id < 0 || client.getMessages() == null)
			{
				return Optional.empty();
			}
			MessageNode message = client.getMessages().get(id);
			return message == null ? Optional.empty() : Optional.of(chatMessageSnapshot(message));
		});
	}

	@Override
	public CompletableFuture<KLiteCombatSnapshot> combatSnapshot()
	{
		return threadGateway.submit(() ->
		{
			Player player = client.getLocalPlayer();
			int poison = client.getVarpValue(VarPlayerID.POISON);
			return new KLiteCombatSnapshot(
				client.getBoostedSkillLevel(Skill.HITPOINTS),
				client.getRealSkillLevel(Skill.HITPOINTS),
				client.getBoostedSkillLevel(Skill.PRAYER),
				client.getRealSkillLevel(Skill.PRAYER),
				client.getEnergy(),
				client.getWeight(),
				client.getVarpValue(VarPlayerID.OPTION_RUN) != 0,
				client.getVarpValue(VarPlayerID.SA_ENERGY),
				client.getVarpValue(VarPlayerID.SA_ATTACK) != 0,
				poison,
				poison > 0 && poison < VENOM_THRESHOLD,
				poison >= VENOM_THRESHOLD,
				client.getVarbitValue(VarbitID.INSIDE_WILDERNESS) != 0,
				player == null ? -1 : player.getAnimation(),
				player == null ? -1 : player.getPoseAnimation(),
				player == null ? null : actorName(player.getInteracting()),
				activePrayerSnapshot());
		});
	}

	@Override
	public CompletableFuture<List<Prayer>> activePrayers()
	{
		return threadGateway.submit(this::activePrayerSnapshot);
	}

	@Override
	public CompletableFuture<Boolean> prayerActive(Prayer prayer)
	{
		return threadGateway.submit(() -> prayer != null && client.getVarbitValue(prayer.getVarbit()) != 0);
	}

	@Override
	public CompletableFuture<List<KLiteGrandExchangeOfferSnapshot>> grandExchangeOffers()
	{
		return threadGateway.submit(() ->
		{
			GrandExchangeOffer[] offers = client.getGrandExchangeOffers();
			if (offers == null)
			{
				return ImmutableList.of();
			}
			ImmutableList.Builder<KLiteGrandExchangeOfferSnapshot> snapshots = ImmutableList.builder();
			for (int slot = 0; slot < offers.length; slot++)
			{
				GrandExchangeOffer offer = offers[slot];
				if (offer != null)
				{
					snapshots.add(grandExchangeOfferSnapshot(slot, offer));
				}
			}
			return snapshots.build();
		});
	}

	@Override
	public CompletableFuture<Optional<KLiteGrandExchangeOfferSnapshot>> grandExchangeOffer(int slot)
	{
		return threadGateway.submit(() ->
		{
			GrandExchangeOffer[] offers = client.getGrandExchangeOffers();
			if (offers == null || slot < 0 || slot >= offers.length || offers[slot] == null)
			{
				return Optional.empty();
			}
			return Optional.of(grandExchangeOfferSnapshot(slot, offers[slot]));
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
	public CompletableFuture<Long> equipmentCount(int itemId)
	{
		return threadGateway.submit(() -> itemCount(InventoryID.WORN, itemId));
	}

	@Override
	public CompletableFuture<Boolean> equipmentContains(int itemId)
	{
		return threadGateway.submit(() -> findItemSlot(InventoryID.WORN, itemId).isPresent());
	}

	@Override
	public CompletableFuture<Optional<KLiteItemStack>> equipmentItem(EquipmentInventorySlot slot)
	{
		return threadGateway.submit(() ->
		{
			if (slot == null)
			{
				return Optional.empty();
			}
			Item item = itemAt(InventoryID.WORN, slot.getSlotIdx());
			if (item == null || item.getId() < 0 || item.getQuantity() <= 0)
			{
				return Optional.empty();
			}
			return Optional.of(new KLiteItemStack(
				slot.getSlotIdx(), item.getId(), item.getQuantity()));
		});
	}

	@Override
	public CompletableFuture<List<KLiteItemStack>> bankItems()
	{
		return itemContainer(InventoryID.BANK);
	}

	@Override
	public CompletableFuture<Long> bankCount(int itemId)
	{
		return threadGateway.submit(() -> itemCount(InventoryID.BANK, itemId));
	}

	@Override
	public CompletableFuture<Boolean> bankContains(int itemId)
	{
		return threadGateway.submit(() -> findItemSlot(InventoryID.BANK, itemId).isPresent());
	}

	@Override
	public CompletableFuture<Optional<Integer>> firstBankSlot(int itemId)
	{
		return threadGateway.submit(() -> findItemSlot(InventoryID.BANK, itemId));
	}

	@Override
	public CompletableFuture<Long> inventoryCount(int itemId)
	{
		return threadGateway.submit(() -> itemCount(InventoryID.INV, itemId));
	}

	@Override
	public CompletableFuture<Boolean> inventoryContains(int itemId)
	{
		return threadGateway.submit(() -> findItemSlot(InventoryID.INV, itemId).isPresent());
	}

	@Override
	public CompletableFuture<Optional<Integer>> firstInventorySlot(int itemId)
	{
		return threadGateway.submit(() -> findItemSlot(InventoryID.INV, itemId));
	}

	@Override
	public CompletableFuture<Integer> inventoryFreeSlots()
	{
		return threadGateway.submit(() ->
		{
			ItemContainer inventory = client.getItemContainer(InventoryID.INV);
			if (inventory == null)
			{
				return 0;
			}
			int freeSlots = 0;
			for (Item item : inventory.getItems())
			{
				if (item.getId() < 0 || item.getQuantity() <= 0)
				{
					freeSlots++;
				}
			}
			return freeSlots;
		});
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
				snapshots.add(playerSnapshot(player, player == localPlayer));
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
				snapshots.add(npcSnapshot(npc));
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
	public CompletableFuture<List<KLiteProjectileSnapshot>> projectiles()
	{
		return threadGateway.submit(() ->
		{
			Deque<Projectile> projectiles = client.getProjectiles();
			if (projectiles == null)
			{
				return ImmutableList.of();
			}
			ImmutableList.Builder<KLiteProjectileSnapshot> snapshots = ImmutableList.builder();
			for (Projectile projectile : projectiles)
			{
				if (projectile != null)
				{
					snapshots.add(new KLiteProjectileSnapshot(
						projectile.getId(), projectile.getSourceLevel(), projectile.getSourcePoint(),
						actorName(projectile.getSourceActor()), projectile.getTargetLevel(), projectile.getTargetPoint(),
						actorName(projectile.getTargetActor()), projectile.getEndHeight(), projectile.getStartCycle(),
						projectile.getEndCycle(), projectile.getRemainingCycles(), projectile.getSlope(),
						projectile.getStartPos(), projectile.getStartHeight(), projectile.getX(), projectile.getY(),
						projectile.getZ(), projectile.getOrientation(), projectile.getAnimationFrame()));
				}
			}
			return snapshots.build();
		});
	}

	@Override
	public CompletableFuture<List<KLiteGraphicsObjectSnapshot>> graphicsObjects()
	{
		return threadGateway.submit(() ->
		{
			WorldView worldView = client.getTopLevelWorldView();
			if (worldView == null || worldView.getGraphicsObjects() == null)
			{
				return ImmutableList.of();
			}
			ImmutableList.Builder<KLiteGraphicsObjectSnapshot> snapshots = ImmutableList.builder();
			for (GraphicsObject graphicsObject : worldView.getGraphicsObjects())
			{
				if (graphicsObject != null)
				{
					snapshots.add(new KLiteGraphicsObjectSnapshot(
						graphicsObject.getId(), graphicsObject.getLocation(), graphicsObject.getStartCycle(),
						graphicsObject.getLevel(), graphicsObject.getZ(), graphicsObject.finished(),
						graphicsObject.getAnimationFrame()));
				}
			}
			return snapshots.build();
		});
	}

	@Override
	public CompletableFuture<List<KLiteSceneObjectSnapshot>> sceneObjects()
	{
		return threadGateway.submit(this::currentSceneObjectSnapshots);
	}

	@Override
	public CompletableFuture<Optional<KLitePlayerSnapshot>> nearestPlayer(String name)
	{
		return threadGateway.submit(() -> nearestPlayerSnapshot(name));
	}

	@Override
	public CompletableFuture<Optional<KLiteNpcSnapshot>> nearestNpc(int npcId)
	{
		return threadGateway.submit(() -> nearestNpcSnapshot(npcId, null));
	}

	@Override
	public CompletableFuture<Optional<KLiteNpcSnapshot>> nearestNpc(String name)
	{
		return threadGateway.submit(() -> nearestNpcSnapshot(-1, name));
	}

	@Override
	public CompletableFuture<Optional<KLiteGroundItemSnapshot>> nearestGroundItem(int itemId)
	{
		return threadGateway.submit(() -> nearestGroundItemSnapshot(itemId, null));
	}

	@Override
	public CompletableFuture<Optional<KLiteGroundItemSnapshot>> nearestGroundItem(String name)
	{
		return threadGateway.submit(() -> nearestGroundItemSnapshot(-1, name));
	}

	@Override
	public CompletableFuture<Optional<KLiteSceneObjectSnapshot>> nearestSceneObject(int objectId)
	{
		return threadGateway.submit(() -> nearestSceneObjectSnapshot(objectId, null));
	}

	@Override
	public CompletableFuture<Optional<KLiteSceneObjectSnapshot>> nearestSceneObject(String name)
	{
		return threadGateway.submit(() -> nearestSceneObjectSnapshot(-1, name));
	}

	@Override
	public CompletableFuture<Optional<KLiteItemDefinition>> itemDefinition(int itemId)
	{
		return threadGateway.submit(() -> itemId < 0
			? Optional.empty()
			: Optional.of(itemDefinitionSnapshot(client.getItemDefinition(itemId))));
	}

	@Override
	public CompletableFuture<Optional<KLiteNpcDefinition>> npcDefinition(int npcId)
	{
		return threadGateway.submit(() ->
		{
			if (npcId < 0)
			{
				return Optional.empty();
			}
			NPCComposition composition = client.getNpcDefinition(npcId);
			if (composition.getConfigs() != null)
			{
				NPCComposition transformed = composition.transform();
				if (transformed != null)
				{
					composition = transformed;
				}
			}
			return Optional.of(npcDefinitionSnapshot(composition));
		});
	}

	@Override
	public CompletableFuture<Optional<KLiteObjectDefinition>> objectDefinition(int objectId)
	{
		return threadGateway.submit(() ->
		{
			if (objectId < 0)
			{
				return Optional.empty();
			}
			ObjectComposition composition = client.getObjectDefinition(objectId);
			if (composition.getImpostorIds() != null)
			{
				ObjectComposition transformed = composition.getImpostor();
				if (transformed != null)
				{
					composition = transformed;
				}
			}
			return Optional.of(objectDefinitionSnapshot(composition));
		});
	}

	@Override
	public CompletableFuture<Optional<Integer>> distanceTo(WorldPoint location)
	{
		return threadGateway.submit(() ->
		{
			Player player = client.getLocalPlayer();
			return player == null || location == null
				? Optional.empty()
				: Optional.of(player.getWorldLocation().distanceTo(location));
		});
	}

	@Override
	public CompletableFuture<Boolean> hasLineOfSightTo(WorldPoint location)
	{
		return threadGateway.submit(() ->
		{
			Player player = client.getLocalPlayer();
			WorldView worldView = client.getTopLevelWorldView();
			return player != null && worldView != null && location != null
				&& player.getWorldArea().hasLineOfSightTo(worldView, location);
		});
	}

	@Override
	public CompletableFuture<Optional<KLiteWidgetSnapshot>> widget(int componentId)
	{
		return threadGateway.submit(() -> componentId < 0
			? Optional.empty()
			: Optional.ofNullable(client.getWidget(componentId))
				.map(DefaultKLiteClientApi::widgetSnapshot));
	}

	@Override
	public CompletableFuture<Optional<KLiteWidgetSnapshot>> widgetChild(
		int componentId, int childIndex)
	{
		return threadGateway.submit(() ->
		{
			if (componentId < 0 || childIndex < 0)
			{
				return Optional.empty();
			}
			Widget parent = client.getWidget(componentId);
			return Optional.ofNullable(parent == null ? null : parent.getChild(childIndex))
				.map(DefaultKLiteClientApi::widgetSnapshot);
		});
	}

	@Override
	public CompletableFuture<List<KLiteWidgetSnapshot>> widgetChildren(int componentId)
	{
		return threadGateway.submit(() ->
		{
			if (componentId < 0)
			{
				return ImmutableList.of();
			}
			Widget parent = client.getWidget(componentId);
			Widget[] children = parent == null ? null : parent.getChildren();
			if (children == null)
			{
				return ImmutableList.of();
			}

			ImmutableList.Builder<KLiteWidgetSnapshot> snapshots = ImmutableList.builder();
			for (Widget child : children)
			{
				if (child != null)
				{
					snapshots.add(widgetSnapshot(child));
				}
			}
			return snapshots.build();
		});
	}

	@Override
	public CompletableFuture<Optional<KLiteWidgetSnapshot>> selectedWidget()
	{
		return threadGateway.submit(() -> Optional.ofNullable(client.getSelectedWidget())
			.map(DefaultKLiteClientApi::widgetSnapshot));
	}

	@Override
	public CompletableFuture<Boolean> isBankOpen()
	{
		return threadGateway.submit(() -> isVisible(client.getWidget(InterfaceID.Bankmain.ITEMS)));
	}

	@Override
	public CompletableFuture<List<KLiteDialogOption>> dialogOptions()
	{
		return threadGateway.submit(() ->
		{
			Widget options = client.getWidget(InterfaceID.Chatmenu.OPTIONS);
			Widget[] children = options == null ? null : options.getChildren();
			if (children == null)
			{
				return ImmutableList.of();
			}

			ImmutableList.Builder<KLiteDialogOption> result = ImmutableList.builder();
			for (Widget child : children)
			{
				if (child != null && child.getIndex() > 0 && !child.isHidden()
					&& !isBlank(child.getText()))
				{
					result.add(new KLiteDialogOption(child.getIndex(), child.getText()));
				}
			}
			return result.build();
		});
	}

	@Override
	public CompletableFuture<Integer> varbit(int varbitId)
	{
		return threadGateway.submit(() -> client.getVarbitValue(varbitId));
	}

	@Override
	public CompletableFuture<Integer> serverVarbit(int varbitId)
	{
		return threadGateway.submit(() -> client.getServerVarbitValue(varbitId));
	}

	@Override
	public CompletableFuture<Integer> varp(int varpId)
	{
		return threadGateway.submit(() -> client.getVarpValue(varpId));
	}

	@Override
	public CompletableFuture<Integer> serverVarp(int varpId)
	{
		return threadGateway.submit(() -> client.getServerVarpValue(varpId));
	}

	@Override
	public CompletableFuture<Integer> varcInt(int varcId)
	{
		return threadGateway.submit(() -> client.getVarcIntValue(varcId));
	}

	@Override
	public CompletableFuture<String> varcString(int varcId)
	{
		return threadGateway.submit(() -> client.getVarcStrValue(varcId));
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
	public CompletableFuture<KLiteInteractionResult> selectInventoryItem(int slot)
	{
		return threadGateway.submit(() ->
		{
			Item item = itemAt(InventoryID.INV, slot);
			if (slot < 0)
			{
				return KLiteInteractionResult.invalidRequest("Slot must be non-negative");
			}
			if (item == null)
			{
				return KLiteInteractionResult.targetNotFound(
					"No inventory item exists in slot " + slot);
			}

			ItemComposition composition = client.getItemDefinition(item.getId());
			client.menuAction(slot, InterfaceID.Inventory.ITEMS, MenuAction.WIDGET_TARGET,
				0, item.getId(), "Use", composition.getName());
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> useSelectedWidgetOnInventoryItem(int slot)
	{
		return threadGateway.submit(() ->
		{
			if (slot < 0)
			{
				return KLiteInteractionResult.invalidRequest("Slot must be non-negative");
			}
			Item item = itemAt(InventoryID.INV, slot);
			if (item == null)
			{
				return KLiteInteractionResult.targetNotFound(
					"No inventory item exists in slot " + slot);
			}
			if (!client.isWidgetSelected() || client.getSelectedWidget() == null)
			{
				return KLiteInteractionResult.noWidgetSelected();
			}
			return dispatchSelectedTarget(slot, InterfaceID.Inventory.ITEMS,
				MenuAction.WIDGET_TARGET_ON_WIDGET, 0, item.getId(),
				client.getItemDefinition(item.getId()).getName());
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> interactBankItem(int slot, String option)
	{
		return interactWidgetChild(InterfaceID.Bankmain.ITEMS, slot, option);
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> interactBankInventoryItem(int slot, String option)
	{
		return interactWidgetChild(InterfaceID.Bankside.ITEMS, slot, option);
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> withdrawBankItem(
		int slot, KLiteBankQuantity quantity)
	{
		return bankItemInteraction(
			InterfaceID.Bankmain.ITEMS, slot,
			quantity == null ? null : quantity.getWithdrawOption());
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> depositBankInventoryItem(
		int slot, KLiteBankQuantity quantity)
	{
		return bankItemInteraction(
			InterfaceID.Bankside.ITEMS, slot,
			quantity == null ? null : quantity.getDepositOption());
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> depositInventory()
	{
		return interactWidget(InterfaceID.Bankmain.DEPOSITINV, "Deposit inventory");
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> depositEquipment()
	{
		return interactWidget(InterfaceID.Bankmain.DEPOSITWORN, "Deposit worn items");
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setRunEnabled(boolean enabled)
	{
		return threadGateway.submit(() ->
		{
			boolean current = client.getVarpValue(VarPlayerID.OPTION_RUN) != 0;
			return current == enabled
				? KLiteInteractionResult.noActionRequired("Run is already " + stateName(enabled))
				: interactFirstWidgetAction(client.getWidget(InterfaceID.Orbs.ORB_RUNENERGY));
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> setSpecialAttackEnabled(boolean enabled)
	{
		return threadGateway.submit(() ->
		{
			boolean current = client.getVarpValue(VarPlayerID.SA_ATTACK) != 0;
			return current == enabled
				? KLiteInteractionResult.noActionRequired(
					"Special attack is already " + stateName(enabled))
				: interactFirstWidgetAction(client.getWidget(InterfaceID.CombatInterface.SPECIAL_ATTACK));
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> selectWidgetTarget(int componentId)
	{
		return threadGateway.submit(() -> componentId < 0
			? KLiteInteractionResult.invalidRequest("Widget component id must be non-negative")
			: selectWidgetTarget(client.getWidget(componentId)));
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> selectWidgetTargetChild(
		int componentId, int childIndex)
	{
		return threadGateway.submit(() ->
		{
			if (componentId < 0 || childIndex < 0)
			{
				return KLiteInteractionResult.invalidRequest(
					"Widget component id and child index must be non-negative");
			}
			Widget parent = client.getWidget(componentId);
			return selectWidgetTarget(parent == null ? null : parent.getChild(childIndex));
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> interactWidget(int componentId, String option)
	{
		return threadGateway.submit(() ->
		{
			if (componentId < 0)
			{
				return KLiteInteractionResult.invalidRequest("Widget component id must be non-negative");
			}
			return interactWidget(client.getWidget(componentId), option);
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> interactWidgetChild(
		int componentId, int childIndex, String option)
	{
		return threadGateway.submit(() ->
		{
			if (componentId < 0 || childIndex < 0)
			{
				return KLiteInteractionResult.invalidRequest(
					"Widget component id and child index must be non-negative");
			}
			Widget parent = client.getWidget(componentId);
			return interactWidget(parent == null ? null : parent.getChild(childIndex), option);
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
	public CompletableFuture<KLiteInteractionResult> useSelectedWidgetOnNpc(int index)
	{
		return threadGateway.submit(() ->
		{
			if (index < 0)
			{
				return KLiteInteractionResult.invalidRequest("NPC index must be non-negative");
			}
			NPC npc = findNpc(client.getTopLevelWorldView(), index);
			if (npc == null)
			{
				return KLiteInteractionResult.targetNotFound("NPC index is not present: " + index);
			}
			return dispatchSelectedTarget(0, 0, MenuAction.WIDGET_TARGET_ON_NPC,
				index, -1, npc.getName());
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> useSelectedWidgetOnPlayer(int id)
	{
		return threadGateway.submit(() ->
		{
			if (id < 0)
			{
				return KLiteInteractionResult.invalidRequest("Player id must be non-negative");
			}
			Player player = findPlayer(client.getTopLevelWorldView(), id);
			if (player == null)
			{
				return KLiteInteractionResult.targetNotFound("Player id is not present: " + id);
			}
			return dispatchSelectedTarget(0, 0, MenuAction.WIDGET_TARGET_ON_PLAYER,
				id, -1, player.getName());
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> useSelectedWidgetOnSceneObject(
		int objectId, WorldPoint location)
	{
		return threadGateway.submit(() ->
		{
			if (objectId < 0 || location == null)
			{
				return KLiteInteractionResult.invalidRequest("Object id and location must be valid");
			}
			TileObject object = findSceneObject(client.getTopLevelWorldView(), objectId, location);
			if (object == null)
			{
				return KLiteInteractionResult.targetNotFound("Scene object is no longer present");
			}
			LocalPoint local = object.getLocalLocation();
			return dispatchSelectedTarget(local.getSceneX(), local.getSceneY(),
				MenuAction.WIDGET_TARGET_ON_GAME_OBJECT, object.getId(), -1,
				objectComposition(object).getName());
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> useSelectedWidgetOnGroundItem(
		int itemId, WorldPoint location)
	{
		return threadGateway.submit(() ->
		{
			if (itemId < 0 || location == null)
			{
				return KLiteInteractionResult.invalidRequest("Item id and location must be valid");
			}
			Tile tile = findTile(client.getTopLevelWorldView(), location);
			if (tile == null || !containsGroundItem(tile, itemId))
			{
				return KLiteInteractionResult.targetNotFound("Ground item is no longer present");
			}
			LocalPoint local = tile.getLocalLocation();
			return dispatchSelectedTarget(local.getSceneX(), local.getSceneY(),
				MenuAction.WIDGET_TARGET_ON_GROUND_ITEM, itemId, itemId,
				client.getItemDefinition(itemId).getName());
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> chooseDialogOption(int index)
	{
		return threadGateway.submit(() ->
		{
			if (index < 1)
			{
				return KLiteInteractionResult.invalidRequest(
					"Dialogue option index must be at least 1");
			}
			Widget parent = client.getWidget(InterfaceID.Chatmenu.OPTIONS);
			Widget option = parent == null ? null : parent.getChild(index);
			if (!isVisible(option) || isBlank(option.getText()))
			{
				return KLiteInteractionResult.targetNotFound(
					"Dialogue option is not present: " + index);
			}
			client.menuAction(option.getIndex(), option.getId(), MenuAction.WIDGET_CONTINUE,
				0, option.getItemId(), option.getText(), "");
			return KLiteInteractionResult.dispatched();
		});
	}

	@Override
	public CompletableFuture<KLiteInteractionResult> continueDialog()
	{
		return threadGateway.submit(() ->
		{
			for (int componentId : DIALOG_CONTINUE_COMPONENTS)
			{
				Widget widget = client.getWidget(componentId);
				if (isVisible(widget))
				{
					client.menuAction(widget.getIndex(), widget.getId(), MenuAction.WIDGET_CONTINUE,
						0, widget.getItemId(), "Continue", "");
					return KLiteInteractionResult.dispatched();
				}
			}
			return KLiteInteractionResult.targetNotFound("No supported continue dialogue is open");
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

	private List<Prayer> activePrayerSnapshot()
	{
		ImmutableList.Builder<Prayer> prayers = ImmutableList.builder();
		for (Prayer prayer : Prayer.values())
		{
			if (client.getVarbitValue(prayer.getVarbit()) != 0)
			{
				prayers.add(prayer);
			}
		}
		return prayers.build();
	}

	private KLiteInteractionResult interactFirstWidgetAction(@Nullable Widget widget)
	{
		if (!isVisible(widget))
		{
			return KLiteInteractionResult.targetNotFound("Widget is absent or hidden");
		}
		String[] actions = widget.getActions();
		if (actions != null)
		{
			for (String action : actions)
			{
				if (!isBlank(action))
				{
					return interactWidget(widget, action);
				}
			}
		}
		return KLiteInteractionResult.optionNotFound("Widget does not expose an action");
	}

	private KLiteInteractionResult selectWidgetTarget(@Nullable Widget widget)
	{
		if (!isVisible(widget))
		{
			return KLiteInteractionResult.targetNotFound("Widget is absent or hidden");
		}
		String verb = widget.getTargetVerb();
		if (isBlank(verb))
		{
			return KLiteInteractionResult.optionNotFound("Widget is not a selectable target");
		}
		String target = isBlank(widget.getName()) ? widget.getText() : widget.getName();
		client.menuAction(widget.getIndex(), widget.getId(), MenuAction.WIDGET_TARGET,
			0, widget.getItemId(), verb, target == null ? "" : target);
		return KLiteInteractionResult.dispatched();
	}

	private static String stateName(boolean enabled)
	{
		return enabled ? "enabled" : "disabled";
	}
	private CompletableFuture<KLiteInteractionResult> bankItemInteraction(
		int componentId, int slot, @Nullable String option)
	{
		return threadGateway.submit(() ->
		{
			if (slot < 0 || isBlank(option))
			{
				return KLiteInteractionResult.invalidRequest(
					"Bank slot must be non-negative and quantity must be provided");
			}
			Widget parent = client.getWidget(componentId);
			return interactWidget(parent == null ? null : parent.getChild(slot), option);
		});
	}

	private static KLiteGrandExchangeOfferSnapshot grandExchangeOfferSnapshot(
		int slot, GrandExchangeOffer offer)
	{
		return new KLiteGrandExchangeOfferSnapshot(slot, offer.getItemId(), offer.getQuantitySold(),
			offer.getTotalQuantity(), offer.getPrice(), offer.getSpent(), offer.getState());
	}

	private List<KLiteChatMessageSnapshot> chatMessageSnapshots(@Nullable ChatMessageType type)
	{
		if (client.getMessages() == null)
		{
			return ImmutableList.of();
		}
		ImmutableList.Builder<KLiteChatMessageSnapshot> messages = ImmutableList.builder();
		for (MessageNode message : client.getMessages())
		{
			if (message != null && (type == null || type == message.getType()))
			{
				messages.add(chatMessageSnapshot(message));
			}
		}
		return messages.build();
	}

	private static KLiteChatMessageSnapshot chatMessageSnapshot(MessageNode message)
	{
		return new KLiteChatMessageSnapshot(
			message.getId(),
			message.getType(),
			message.getName(),
			message.getSender(),
			message.getValue(),
			message.getRuneLiteFormatMessage(),
			message.getTimestamp());
	}

	private long itemCount(int inventoryId, int itemId)
	{
		if (itemId < 0)
		{
			return 0L;
		}
		long count = 0L;
		ItemContainer container = client.getItemContainer(inventoryId);
		if (container != null)
		{
			for (Item item : container.getItems())
			{
				if (item.getId() == itemId && item.getQuantity() > 0)
				{
					count += item.getQuantity();
				}
			}
		}
		return count;
	}
	private Optional<Integer> findItemSlot(int inventoryId, int itemId)
	{
		if (itemId < 0)
		{
			return Optional.empty();
		}
		ItemContainer container = client.getItemContainer(inventoryId);
		if (container == null)
		{
			return Optional.empty();
		}
		Item[] items = container.getItems();
		for (int slot = 0; slot < items.length; slot++)
		{
			if (items[slot].getId() == itemId && items[slot].getQuantity() > 0)
			{
				return Optional.of(slot);
			}
		}
		return Optional.empty();
	}

	private Optional<KLitePlayerSnapshot> nearestPlayerSnapshot(@Nullable String name)
	{
		WorldView worldView = client.getTopLevelWorldView();
		Player localPlayer = client.getLocalPlayer();
		if (worldView == null || localPlayer == null || isBlank(name))
		{
			return Optional.empty();
		}
		Player nearest = null;
		int nearestDistance = Integer.MAX_VALUE;
		for (Player player : worldView.players())
		{
			if (name.equalsIgnoreCase(player.getName()))
			{
				int distance = localPlayer.getWorldLocation().distanceTo(player.getWorldLocation());
				if (nearest == null || distance < nearestDistance)
				{
					nearest = player;
					nearestDistance = distance;
				}
			}
		}
		return nearest == null ? Optional.empty()
			: Optional.of(playerSnapshot(nearest, nearest == localPlayer));
	}

	private Optional<KLiteNpcSnapshot> nearestNpcSnapshot(int npcId, @Nullable String name)
	{
		WorldView worldView = client.getTopLevelWorldView();
		Player localPlayer = client.getLocalPlayer();
		if (worldView == null || localPlayer == null || npcId < 0 && isBlank(name))
		{
			return Optional.empty();
		}
		NPC nearest = null;
		int nearestDistance = Integer.MAX_VALUE;
		for (NPC npc : worldView.npcs())
		{
			boolean matches = npcId >= 0 ? npc.getId() == npcId : name.equalsIgnoreCase(npc.getName());
			if (matches)
			{
				int distance = localPlayer.getWorldLocation().distanceTo(npc.getWorldLocation());
				if (nearest == null || distance < nearestDistance)
				{
					nearest = npc;
					nearestDistance = distance;
				}
			}
		}
		return nearest == null ? Optional.empty() : Optional.of(npcSnapshot(nearest));
	}

	private Optional<KLiteGroundItemSnapshot> nearestGroundItemSnapshot(
		int itemId, @Nullable String name)
	{
		WorldView worldView = client.getTopLevelWorldView();
		Player localPlayer = client.getLocalPlayer();
		if (worldView == null || worldView.getScene() == null || localPlayer == null
			|| itemId < 0 && isBlank(name))
		{
			return Optional.empty();
		}
		KLiteGroundItemSnapshot nearest = null;
		int nearestDistance = Integer.MAX_VALUE;
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
					for (TileItem item : tile.getGroundItems())
					{
						boolean matches = itemId >= 0 ? item.getId() == itemId
							: name.equalsIgnoreCase(client.getItemDefinition(item.getId()).getName());
						int distance = localPlayer.getWorldLocation().distanceTo(tile.getWorldLocation());
						if (matches && (nearest == null || distance < nearestDistance))
						{
							nearest = groundItemSnapshot(item, tile.getWorldLocation());
							nearestDistance = distance;
						}
					}
				}
			}
		}
		return Optional.ofNullable(nearest);
	}

	private Optional<KLiteSceneObjectSnapshot> nearestSceneObjectSnapshot(
		int objectId, @Nullable String name)
	{
		Player localPlayer = client.getLocalPlayer();
		if (localPlayer == null || objectId < 0 && isBlank(name))
		{
			return Optional.empty();
		}
		KLiteSceneObjectSnapshot nearest = null;
		int nearestDistance = Integer.MAX_VALUE;
		for (KLiteSceneObjectSnapshot object : currentSceneObjectSnapshots())
		{
			boolean matches = objectId >= 0 ? object.getObjectId() == objectId
				: name.equalsIgnoreCase(object.getName());
			int distance = localPlayer.getWorldLocation().distanceTo(object.getLocation());
			if (matches && (nearest == null || distance < nearestDistance))
			{
				nearest = object;
				nearestDistance = distance;
			}
		}
		return Optional.ofNullable(nearest);
	}

	private List<KLiteSceneObjectSnapshot> currentSceneObjectSnapshots()
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
	}

	private static KLitePlayerSnapshot playerSnapshot(Player player, boolean localPlayer)
	{
		return new KLitePlayerSnapshot(
			player.getId(), player.getName(), player.getCombatLevel(), player.getWorldLocation(),
			player.getAnimation(), player.getPoseAnimation(), localPlayer, player.isFriend(),
			player.isFriendsChatMember(), player.isClanMember(), actorName(player.getInteracting()));
	}

	private static KLiteNpcSnapshot npcSnapshot(NPC npc)
	{
		return new KLiteNpcSnapshot(
			npc.getId(), npc.getIndex(), npc.getName(), npc.getCombatLevel(), npc.getWorldLocation(),
			npc.getAnimation(), npc.getPoseAnimation(), npc.getHealthRatio(), npc.getHealthScale(),
			actorName(npc.getInteracting()));
	}

	private static KLiteGroundItemSnapshot groundItemSnapshot(TileItem item, WorldPoint location)
	{
		return new KLiteGroundItemSnapshot(
			item.getId(), item.getQuantity(), location, item.getVisibleTime(), item.getDespawnTime(),
			item.getOwnership(), item.isPrivate());
	}

	private static KLiteItemDefinition itemDefinitionSnapshot(ItemComposition composition)
	{
		return new KLiteItemDefinition(
			composition.getId(), composition.getName(), composition.getMembersName(),
			composition.getPrice(), composition.getHaPrice(), composition.isMembers(),
			composition.isStackable(), composition.isTradeable(), composition.isGeTradeable(),
			composition.getLinkedNoteId(), composition.getPlaceholderId(),
			immutableActions(composition.getInventoryActions()));
	}

	private static KLiteNpcDefinition npcDefinitionSnapshot(NPCComposition composition)
	{
		return new KLiteNpcDefinition(
			composition.getId(), composition.getName(), composition.getCombatLevel(),
			composition.getSize(), composition.isInteractible(), composition.isMinimapVisible(),
			composition.isFollower(), immutableActions(composition.getActions()));
	}

	private static KLiteObjectDefinition objectDefinitionSnapshot(ObjectComposition composition)
	{
		return new KLiteObjectDefinition(
			composition.getId(), composition.getName(), composition.getSizeX(), composition.getSizeY(),
			composition.getMapSceneId(), composition.getMapIconId(), composition.getVarbitId(),
			composition.getVarPlayerId(), immutableActions(composition.getActions()));
	}

	private static List<String> immutableActions(@Nullable String[] actions)
	{
		ImmutableList.Builder<String> result = ImmutableList.builder();
		if (actions != null)
		{
			for (String action : actions)
			{
				if (!isBlank(action))
				{
					result.add(action);
				}
			}
		}
		return result.build();
	}
	@Nullable
	private Item itemAt(int inventoryId, int slot)
	{
		if (slot < 0)
		{
			return null;
		}
		ItemContainer container = client.getItemContainer(inventoryId);
		if (container == null || slot >= container.getItems().length)
		{
			return null;
		}
		Item item = container.getItems()[slot];
		return item.getId() >= 0 && item.getQuantity() > 0 ? item : null;
	}

	private KLiteInteractionResult dispatchSelectedTarget(
		int param0, int param1, MenuAction action, int identifier, int itemId, @Nullable String target)
	{
		Widget selected = client.getSelectedWidget();
		if (!client.isWidgetSelected() || selected == null)
		{
			return KLiteInteractionResult.noWidgetSelected();
		}
		String option = isBlank(selected.getTargetVerb()) ? "Use" : selected.getTargetVerb();
		client.menuAction(param0, param1, action, identifier, itemId,
			option, target == null ? "" : target);
		return KLiteInteractionResult.dispatched();
	}

	private static boolean isVisible(@Nullable Widget widget)
	{
		return widget != null && !widget.isHidden();
	}
	private KLiteInteractionResult interactWidget(@Nullable Widget widget, @Nullable String option)
	{
		if (isBlank(option))
		{
			return KLiteInteractionResult.invalidRequest("Widget option must not be blank");
		}
		if (widget == null || widget.isHidden())
		{
			return KLiteInteractionResult.targetNotFound("Widget is absent or hidden");
		}

		String[] actions = widget.getActions();
		int actionIndex = findAction(actions, option);
		if (actionIndex < 0)
		{
			return KLiteInteractionResult.optionNotFound("Widget does not expose option: " + option);
		}

		int operation = actionIndex + 1;
		MenuAction action = operation >= 6 ? MenuAction.CC_OP_LOW_PRIORITY : MenuAction.CC_OP;
		String target = widget.getName() == null ? "" : widget.getName();
		client.menuAction(widget.getIndex(), widget.getId(), action, operation,
			widget.getItemId(), actions[actionIndex], target);
		return KLiteInteractionResult.dispatched();
	}

	private static KLiteWidgetSnapshot widgetSnapshot(Widget widget)
	{
		Rectangle bounds = widget.getBounds();
		ImmutableList.Builder<KLiteWidgetAction> actions = ImmutableList.builder();
		String[] widgetActions = widget.getActions();
		if (widgetActions != null)
		{
			for (int index = 0; index < widgetActions.length; index++)
			{
				String option = widgetActions[index];
				if (!isBlank(option))
				{
					actions.add(new KLiteWidgetAction(index + 1, option));
				}
			}
		}
		return new KLiteWidgetSnapshot(
			widget.getId(),
			widget.getIndex(),
			widget.getParentId(),
			widget.getType(),
			widget.getContentType(),
			widget.getText(),
			widget.getName(),
			widget.getItemId(),
			widget.getItemQuantity(),
			widget.isHidden(),
			bounds.x,
			bounds.y,
			bounds.width,
			bounds.height,
			actions.build());
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
