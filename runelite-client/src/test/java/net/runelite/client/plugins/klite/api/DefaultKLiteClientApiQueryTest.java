/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import net.runelite.api.Client;
import net.runelite.api.IndexedObjectSet;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.ObjectComposition;
import net.runelite.api.Player;
import net.runelite.api.WorldView;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.InventoryID;
import net.runelite.client.callback.ClientThread;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DefaultKLiteClientApiQueryTest
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
	public void inventoryQueriesPreserveQuantitiesAndSlots() throws Exception
	{
		ItemContainer inventory = mock(ItemContainer.class);
		when(client.getItemContainer(InventoryID.INV)).thenReturn(inventory);
		when(inventory.getItems()).thenReturn(new Item[]{
			new Item(100, 5), new Item(-1, 0), new Item(200, 1), new Item(100, 7)
		});

		assertEquals(Long.valueOf(12), api.inventoryCount(100).get());
		assertTrue(api.inventoryContains(200).get());
		assertFalse(api.inventoryContains(300).get());
		assertEquals(Optional.of(2), api.firstInventorySlot(200).get());
		assertEquals(Integer.valueOf(1), api.inventoryFreeSlots().get());
	}

	@Test
	public void itemDefinitionReturnsDetachedMetadata() throws Exception
	{
		ItemComposition composition = mock(ItemComposition.class);
		when(client.getItemDefinition(100)).thenReturn(composition);
		when(composition.getId()).thenReturn(100);
		when(composition.getName()).thenReturn("Example item");
		when(composition.getMembersName()).thenReturn("Example item");
		when(composition.getPrice()).thenReturn(50);
		when(composition.getHaPrice()).thenReturn(30);
		when(composition.isMembers()).thenReturn(true);
		when(composition.isStackable()).thenReturn(true);
		when(composition.isTradeable()).thenReturn(true);
		when(composition.isGeTradeable()).thenReturn(true);
		when(composition.getLinkedNoteId()).thenReturn(101);
		when(composition.getPlaceholderId()).thenReturn(102);
		when(composition.getInventoryActions()).thenReturn(
			new String[]{"Eat", null, null, null, "Drop"});

		assertEquals(Optional.of(new KLiteItemDefinition(
			100, "Example item", "Example item", 50, 30, true, true, true, true,
			101, 102, Arrays.asList("Eat", "Drop"))), api.itemDefinition(100).get());
		assertFalse(api.itemDefinition(-1).get().isPresent());
	}

	@Test
	public void definitionsResolveCurrentNpcAndObjectTransforms() throws Exception
	{
		NPCComposition baseNpc = mock(NPCComposition.class);
		NPCComposition npc = mock(NPCComposition.class);
		when(client.getNpcDefinition(10)).thenReturn(baseNpc);
		when(baseNpc.getConfigs()).thenReturn(new int[]{11});
		when(baseNpc.transform()).thenReturn(npc);
		when(npc.getId()).thenReturn(11);
		when(npc.getName()).thenReturn("Transformed NPC");
		when(npc.getActions()).thenReturn(new String[]{"Talk-to"});

		ObjectComposition baseObject = mock(ObjectComposition.class);
		ObjectComposition object = mock(ObjectComposition.class);
		when(client.getObjectDefinition(20)).thenReturn(baseObject);
		when(baseObject.getImpostorIds()).thenReturn(new int[]{21});
		when(baseObject.getImpostor()).thenReturn(object);
		when(object.getId()).thenReturn(21);
		when(object.getName()).thenReturn("Open door");
		when(object.getActions()).thenReturn(new String[]{"Close"});

		assertEquals("Transformed NPC", api.npcDefinition(10).get().get().getName());
		assertEquals(Collections.singletonList("Talk-to"),
			api.npcDefinition(10).get().get().getActions());
		assertEquals("Open door", api.objectDefinition(20).get().get().getName());
		assertEquals(Collections.singletonList("Close"),
			api.objectDefinition(20).get().get().getActions());
	}

	@Test
	@SuppressWarnings({"rawtypes", "unchecked"})
	public void nearestNpcUsesCurrentPlayerDistanceAndExactName() throws Exception
	{
		WorldView worldView = mock(WorldView.class);
		Player localPlayer = mock(Player.class);
		NPC far = npc(1, 10, "Guard", new WorldPoint(3210, 3200, 0));
		NPC near = npc(1, 11, "Guard", new WorldPoint(3202, 3200, 0));
		IndexedObjectSet npcs = mock(IndexedObjectSet.class);
		when(client.getTopLevelWorldView()).thenReturn(worldView);
		when(client.getLocalPlayer()).thenReturn(localPlayer);
		when(localPlayer.getWorldLocation()).thenReturn(new WorldPoint(3200, 3200, 0));
		when(worldView.npcs()).thenReturn(npcs);
		when(npcs.iterator()).thenAnswer(invocation -> Arrays.asList(far, near).iterator());

		assertEquals(Integer.valueOf(11), api.nearestNpc(1).get().map(KLiteNpcSnapshot::getIndex).get());
		assertEquals(Integer.valueOf(11),
			api.nearestNpc("guard").get().map(KLiteNpcSnapshot::getIndex).get());
		assertFalse(api.nearestNpc("Guard captain").get().isPresent());
	}

	@Test
	public void distanceRequiresLocalPlayerAndPreservesPlaneRules() throws Exception
	{
		Player player = mock(Player.class);
		when(client.getLocalPlayer()).thenReturn(player);
		when(player.getWorldLocation()).thenReturn(new WorldPoint(3200, 3200, 0));

		assertEquals(Optional.of(5), api.distanceTo(new WorldPoint(3205, 3203, 0)).get());
		assertEquals(Optional.of(Integer.MAX_VALUE),
			api.distanceTo(new WorldPoint(3200, 3200, 1)).get());
		assertEquals(Optional.empty(), api.distanceTo(null).get());
	}

	private static NPC npc(int id, int index, String name, WorldPoint location)
	{
		NPC npc = mock(NPC.class);
		when(npc.getId()).thenReturn(id);
		when(npc.getIndex()).thenReturn(index);
		when(npc.getName()).thenReturn(name);
		when(npc.getWorldLocation()).thenReturn(location);
		return npc;
	}
}
