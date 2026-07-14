/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.util.Collections;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.IndexedObjectSet;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.MenuAction;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.ObjectComposition;
import net.runelite.api.Player;
import net.runelite.api.Scene;
import net.runelite.api.Tile;
import net.runelite.api.TileItem;
import net.runelite.api.WorldView;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.InventoryID;
import net.runelite.client.callback.ClientThread;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DefaultKLiteClientApiHighLevelInteractionTest
{
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
	public void inventoryInteractionResolvesCurrentSlotAndAction() throws Exception
	{
		ItemContainer inventory = mock(ItemContainer.class);
		ItemComposition composition = mock(ItemComposition.class);
		when(client.getItemContainer(InventoryID.INV)).thenReturn(inventory);
		when(inventory.getItems()).thenReturn(new Item[]{new Item(100, 1)});
		when(client.getItemDefinition(100)).thenReturn(composition);
		when(composition.getInventoryActions()).thenReturn(
			new String[]{"Eat", null, null, null, "Drop"});
		when(composition.getName()).thenReturn("Example food");

		KLiteInteractionResult result = api.interactInventoryItem(0, "eat").get();

		assertEquals(KLiteInteractionStatus.DISPATCHED, result.getStatus());
		verify(client).menuAction(0, InterfaceID.Inventory.ITEMS,
			MenuAction.CC_OP, 1, 100, "Eat", "Example food");
	}

	@Test
	@SuppressWarnings({"rawtypes", "unchecked"})
	public void npcInteractionUsesTransformedComposition() throws Exception
	{
		WorldView worldView = mock(WorldView.class);
		IndexedObjectSet npcs = mock(IndexedObjectSet.class);
		NPC npc = mock(NPC.class);
		NPCComposition composition = mock(NPCComposition.class);
		when(client.getTopLevelWorldView()).thenReturn(worldView);
		when(worldView.npcs()).thenReturn(npcs);
		when(npcs.byIndex(7)).thenReturn(npc);
		when(npc.getTransformedComposition()).thenReturn(composition);
		when(composition.getActions()).thenReturn(
			new String[]{"Talk-to", null, "Trade", null, null});
		when(composition.getName()).thenReturn("Shop keeper");

		KLiteInteractionResult result = api.interactNpc(7, "Trade").get();

		assertEquals(KLiteInteractionStatus.DISPATCHED, result.getStatus());
		verify(client).menuAction(0, 0, MenuAction.NPC_THIRD_OPTION,
			7, -1, "Trade", "Shop keeper");
	}

	@Test
	@SuppressWarnings({"rawtypes", "unchecked"})
	public void playerInteractionUsesCurrentMenuType() throws Exception
	{
		WorldView worldView = mock(WorldView.class);
		IndexedObjectSet players = mock(IndexedObjectSet.class);
		Player player = mock(Player.class);
		when(client.getTopLevelWorldView()).thenReturn(worldView);
		when(worldView.players()).thenReturn(players);
		when(players.byIndex(11)).thenReturn(player);
		when(player.getName()).thenReturn("Example player");
		when(client.getPlayerOptions()).thenReturn(new String[]{"Follow", "Trade with"});
		when(client.getPlayerMenuTypes()).thenReturn(new int[]{
			MenuAction.PLAYER_FIRST_OPTION.getId(), MenuAction.PLAYER_SECOND_OPTION.getId()});

		KLiteInteractionResult result = api.interactPlayer(11, "trade with").get();

		assertEquals(KLiteInteractionStatus.DISPATCHED, result.getStatus());
		verify(client).menuAction(0, 0, MenuAction.PLAYER_SECOND_OPTION,
			11, -1, "Trade with", "Example player");
	}
	@Test
	public void objectInteractionRevalidatesLocationAndOverride() throws Exception
	{
		WorldView worldView = mock(WorldView.class);
		Scene scene = mock(Scene.class);
		Tile tile = mock(Tile.class);
		GameObject object = mock(GameObject.class);
		ObjectComposition composition = mock(ObjectComposition.class);
		WorldPoint location = new WorldPoint(3200, 3200, 0);
		LocalPoint local = new LocalPoint(10 << 7, 20 << 7, WorldView.TOPLEVEL);
		when(client.getTopLevelWorldView()).thenReturn(worldView);
		when(worldView.getScene()).thenReturn(scene);
		when(scene.getTiles()).thenReturn(new Tile[][][]{{{tile}}});
		when(tile.getWorldLocation()).thenReturn(location);
		when(tile.getGameObjects()).thenReturn(new GameObject[]{object});
		when(object.getId()).thenReturn(200);
		when(object.getWorldLocation()).thenReturn(location);
		when(object.getLocalLocation()).thenReturn(local);
		when(object.getOpOverride(0)).thenReturn("Quick-open");
		when(client.getObjectDefinition(200)).thenReturn(composition);
		when(composition.getActions()).thenReturn(new String[]{"Open", null, null, null, null});
		when(composition.getName()).thenReturn("Door");

		KLiteInteractionResult result = api.interactSceneObject(200, location, "Quick-open").get();

		assertEquals(KLiteInteractionStatus.DISPATCHED, result.getStatus());
		verify(client).menuAction(10, 20, MenuAction.GAME_OBJECT_FIRST_OPTION,
			200, -1, "Quick-open", "Door");
	}

	@Test
	public void groundItemOnlyDispatchesVerifiedTakeAction() throws Exception
	{
		WorldView worldView = mock(WorldView.class);
		Scene scene = mock(Scene.class);
		Tile tile = mock(Tile.class);
		TileItem item = mock(TileItem.class);
		ItemComposition composition = mock(ItemComposition.class);
		WorldPoint location = new WorldPoint(3200, 3200, 0);
		when(client.getTopLevelWorldView()).thenReturn(worldView);
		when(worldView.getScene()).thenReturn(scene);
		when(scene.getTiles()).thenReturn(new Tile[][][]{{{tile}}});
		when(tile.getWorldLocation()).thenReturn(location);
		when(tile.getLocalLocation()).thenReturn(new LocalPoint(30 << 7, 40 << 7, WorldView.TOPLEVEL));
		when(tile.getGroundItems()).thenReturn(Collections.singletonList(item));
		when(item.getId()).thenReturn(300);
		when(client.getItemDefinition(300)).thenReturn(composition);
		when(composition.getName()).thenReturn("Coins");

		KLiteInteractionResult result = api.interactGroundItem(300, location, "Take").get();

		assertEquals(KLiteInteractionStatus.DISPATCHED, result.getStatus());
		verify(client).menuAction(30, 40, MenuAction.GROUND_ITEM_THIRD_OPTION,
			300, 300, "Take", "Coins");
	}

	@Test
	public void missingOptionDoesNotDispatch() throws Exception
	{
		ItemContainer inventory = mock(ItemContainer.class);
		ItemComposition composition = mock(ItemComposition.class);
		when(client.getItemContainer(InventoryID.INV)).thenReturn(inventory);
		when(inventory.getItems()).thenReturn(new Item[]{new Item(100, 1)});
		when(client.getItemDefinition(100)).thenReturn(composition);
		when(composition.getInventoryActions()).thenReturn(new String[]{"Eat", null, null, null, null});

		KLiteInteractionResult result = api.interactInventoryItem(0, "Drink").get();

		assertEquals(KLiteInteractionStatus.OPTION_NOT_FOUND, result.getStatus());
		verify(client, never()).menuAction(
			org.mockito.ArgumentMatchers.anyInt(),
			org.mockito.ArgumentMatchers.anyInt(),
			org.mockito.ArgumentMatchers.any(MenuAction.class),
			org.mockito.ArgumentMatchers.anyInt(),
			org.mockito.ArgumentMatchers.anyInt(),
			org.mockito.ArgumentMatchers.anyString(),
			org.mockito.ArgumentMatchers.anyString());
	}
}
