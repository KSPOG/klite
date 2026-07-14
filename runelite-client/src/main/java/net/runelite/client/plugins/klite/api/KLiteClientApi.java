/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import net.runelite.api.coords.WorldPoint;

/** Public KLite API exposed to KLite automation modules. */
public interface KLiteClientApi
{
	CompletableFuture<KLiteClientSnapshot> snapshot();

	CompletableFuture<List<KLiteItemStack>> inventory();

	CompletableFuture<List<KLiteItemStack>> equipment();

	CompletableFuture<List<KLiteSkillSnapshot>> skills();

	CompletableFuture<List<KLitePlayerSnapshot>> players();

	CompletableFuture<List<KLiteNpcSnapshot>> npcs();

	CompletableFuture<List<KLiteGroundItemSnapshot>> groundItems();

	CompletableFuture<List<KLiteSceneObjectSnapshot>> sceneObjects();

	CompletableFuture<KLiteInteractionResult> interactInventoryItem(int slot, String option);

	CompletableFuture<KLiteInteractionResult> interactNpc(int index, String option);

	CompletableFuture<KLiteInteractionResult> interactPlayer(int id, String option);

	CompletableFuture<KLiteInteractionResult> interactSceneObject(
		int objectId, WorldPoint location, String option);

	CompletableFuture<KLiteInteractionResult> interactGroundItem(
		int itemId, WorldPoint location, String option);

	CompletableFuture<Void> menuAction(KLiteMenuActionRequest request);

	CompletableFuture<Void> onClientThread(Runnable action);
}
