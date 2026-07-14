/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import net.runelite.api.ChatMessageType;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.Prayer;
import net.runelite.api.annotations.Component;
import net.runelite.api.annotations.Varbit;
import net.runelite.api.annotations.VarCInt;
import net.runelite.api.annotations.VarCStr;
import net.runelite.api.annotations.Varp;
import net.runelite.api.coords.WorldPoint;

/** Public KLite API exposed to KLite automation modules. */
public interface KLiteClientApi
{
	CompletableFuture<KLiteClientSnapshot> snapshot();

	CompletableFuture<KLiteRuntimeSnapshot> runtimeSnapshot();

	CompletableFuture<KLiteCameraSnapshot> cameraSnapshot();

	CompletableFuture<List<KLiteChatMessageSnapshot>> chatMessages();

	CompletableFuture<List<KLiteChatMessageSnapshot>> chatMessages(ChatMessageType type);

	CompletableFuture<Optional<KLiteChatMessageSnapshot>> chatMessage(int id);

	CompletableFuture<KLiteCombatSnapshot> combatSnapshot();

	CompletableFuture<List<Prayer>> activePrayers();

	CompletableFuture<Boolean> prayerActive(Prayer prayer);

	CompletableFuture<List<KLiteGrandExchangeOfferSnapshot>> grandExchangeOffers();

	CompletableFuture<Optional<KLiteGrandExchangeOfferSnapshot>> grandExchangeOffer(int slot);

	CompletableFuture<List<KLiteItemStack>> inventory();

	CompletableFuture<List<KLiteItemStack>> equipment();

	CompletableFuture<Long> equipmentCount(int itemId);

	CompletableFuture<Boolean> equipmentContains(int itemId);

	CompletableFuture<Optional<KLiteItemStack>> equipmentItem(EquipmentInventorySlot slot);

	CompletableFuture<List<KLiteItemStack>> bankItems();

	CompletableFuture<Long> bankCount(int itemId);

	CompletableFuture<Boolean> bankContains(int itemId);

	CompletableFuture<Optional<Integer>> firstBankSlot(int itemId);

	CompletableFuture<Long> inventoryCount(int itemId);

	CompletableFuture<Boolean> inventoryContains(int itemId);

	CompletableFuture<Optional<Integer>> firstInventorySlot(int itemId);

	CompletableFuture<Integer> inventoryFreeSlots();

	CompletableFuture<List<KLiteSkillSnapshot>> skills();

	CompletableFuture<List<KLitePlayerSnapshot>> players();

	CompletableFuture<List<KLiteNpcSnapshot>> npcs();

	CompletableFuture<List<KLiteGroundItemSnapshot>> groundItems();

	CompletableFuture<List<KLiteProjectileSnapshot>> projectiles();

	CompletableFuture<List<KLiteGraphicsObjectSnapshot>> graphicsObjects();

	CompletableFuture<List<KLiteSceneObjectSnapshot>> sceneObjects();

	CompletableFuture<Optional<KLitePlayerSnapshot>> nearestPlayer(String name);

	CompletableFuture<Optional<KLiteNpcSnapshot>> nearestNpc(int npcId);

	CompletableFuture<Optional<KLiteNpcSnapshot>> nearestNpc(String name);

	CompletableFuture<Optional<KLiteGroundItemSnapshot>> nearestGroundItem(int itemId);

	CompletableFuture<Optional<KLiteGroundItemSnapshot>> nearestGroundItem(String name);

	CompletableFuture<Optional<KLiteSceneObjectSnapshot>> nearestSceneObject(int objectId);

	CompletableFuture<Optional<KLiteSceneObjectSnapshot>> nearestSceneObject(String name);

	CompletableFuture<Optional<KLiteItemDefinition>> itemDefinition(int itemId);

	CompletableFuture<Optional<KLiteNpcDefinition>> npcDefinition(int npcId);

	CompletableFuture<Optional<KLiteObjectDefinition>> objectDefinition(int objectId);

	CompletableFuture<Optional<Integer>> distanceTo(WorldPoint location);

	CompletableFuture<Boolean> hasLineOfSightTo(WorldPoint location);

	CompletableFuture<Optional<KLiteWidgetSnapshot>> widget(@Component int componentId);

	CompletableFuture<Optional<KLiteWidgetSnapshot>> widgetChild(
		@Component int componentId, int childIndex);

	CompletableFuture<List<KLiteWidgetSnapshot>> widgetChildren(@Component int componentId);

	CompletableFuture<Optional<KLiteWidgetSnapshot>> selectedWidget();

	CompletableFuture<Boolean> isBankOpen();

	CompletableFuture<List<KLiteDialogOption>> dialogOptions();

	CompletableFuture<Integer> varbit(@Varbit int varbitId);

	CompletableFuture<Integer> serverVarbit(@Varbit int varbitId);

	CompletableFuture<Integer> varp(@Varp int varpId);

	CompletableFuture<Integer> serverVarp(@Varp int varpId);

	CompletableFuture<Integer> varcInt(@VarCInt int varcId);

	CompletableFuture<String> varcString(@VarCStr int varcId);

	CompletableFuture<KLiteInteractionResult> interactInventoryItem(int slot, String option);

	CompletableFuture<KLiteInteractionResult> selectInventoryItem(int slot);

	CompletableFuture<KLiteInteractionResult> useSelectedWidgetOnInventoryItem(int slot);

	CompletableFuture<KLiteInteractionResult> interactBankItem(int slot, String option);

	CompletableFuture<KLiteInteractionResult> interactBankInventoryItem(int slot, String option);

	CompletableFuture<KLiteInteractionResult> withdrawBankItem(
		int slot, KLiteBankQuantity quantity);

	CompletableFuture<KLiteInteractionResult> depositBankInventoryItem(
		int slot, KLiteBankQuantity quantity);

	CompletableFuture<KLiteInteractionResult> depositInventory();

	CompletableFuture<KLiteInteractionResult> depositEquipment();

	CompletableFuture<KLiteInteractionResult> setRunEnabled(boolean enabled);

	CompletableFuture<KLiteInteractionResult> setSpecialAttackEnabled(boolean enabled);

	CompletableFuture<KLiteInteractionResult> selectWidgetTarget(@Component int componentId);

	CompletableFuture<KLiteInteractionResult> selectWidgetTargetChild(
		@Component int componentId, int childIndex);

	CompletableFuture<KLiteInteractionResult> interactWidget(
		@Component int componentId, String option);

	CompletableFuture<KLiteInteractionResult> interactWidgetChild(
		@Component int componentId, int childIndex, String option);

	CompletableFuture<KLiteInteractionResult> interactNpc(int index, String option);

	CompletableFuture<KLiteInteractionResult> interactPlayer(int id, String option);

	CompletableFuture<KLiteInteractionResult> interactSceneObject(
		int objectId, WorldPoint location, String option);

	CompletableFuture<KLiteInteractionResult> interactGroundItem(
		int itemId, WorldPoint location, String option);

	CompletableFuture<KLiteInteractionResult> useSelectedWidgetOnNpc(int index);

	CompletableFuture<KLiteInteractionResult> useSelectedWidgetOnPlayer(int id);

	CompletableFuture<KLiteInteractionResult> useSelectedWidgetOnSceneObject(
		int objectId, WorldPoint location);

	CompletableFuture<KLiteInteractionResult> useSelectedWidgetOnGroundItem(
		int itemId, WorldPoint location);

	CompletableFuture<KLiteInteractionResult> chooseDialogOption(int index);

	CompletableFuture<KLiteInteractionResult> continueDialog();

	CompletableFuture<Void> menuAction(KLiteMenuActionRequest request);

	CompletableFuture<Void> onClientThread(Runnable action);
}
