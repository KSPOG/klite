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
import java.util.EnumSet;
import net.runelite.api.Client;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.GameState;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.WorldType;
import net.runelite.api.WorldView;
import net.runelite.api.gameval.InventoryID;
import net.runelite.client.callback.ClientThread;
import org.junit.Before;
import org.junit.Test;

public class DefaultKLiteClientApiRuntimeTest
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
	public void runtimeSnapshotDetachesWorldState() throws Exception
	{
		WorldView worldView = mock(WorldView.class);
		EnumSet<WorldType> worldTypes = EnumSet.of(WorldType.MEMBERS);
		int[] mapRegions = {12_850, 12_851};
		when(client.getTopLevelWorldView()).thenReturn(worldView);
		when(client.getGameState()).thenReturn(GameState.LOGGED_IN);
		when(client.getWorld()).thenReturn(301);
		when(client.getWorldHost()).thenReturn("oldschool1.runescape.com");
		when(client.getWorldType()).thenReturn(worldTypes);
		when(client.getTickCount()).thenReturn(42);
		when(client.getGameCycle()).thenReturn(1_234);
		when(client.getFPS()).thenReturn(50);
		when(client.isInInstancedRegion()).thenReturn(true);
		when(worldView.getPlane()).thenReturn(2);
		when(worldView.getMapRegions()).thenReturn(mapRegions);

		KLiteRuntimeSnapshot snapshot = api.runtimeSnapshot().get();
		worldTypes.clear();
		mapRegions[0] = 0;

		assertEquals(GameState.LOGGED_IN, snapshot.getGameState());
		assertEquals(301, snapshot.getWorld());
		assertEquals("oldschool1.runescape.com", snapshot.getWorldHost());
		assertEquals(Arrays.asList(WorldType.MEMBERS), snapshot.getWorldTypes());
		assertEquals(42, snapshot.getTickCount());
		assertEquals(1_234, snapshot.getGameCycle());
		assertEquals(50, snapshot.getFps());
		assertEquals(2, snapshot.getPlane());
		assertTrue(snapshot.isInstancedRegion());
		assertEquals(Arrays.asList(12_850, 12_851), snapshot.getMapRegions());
	}

	@Test
	public void runtimeSnapshotHandlesMissingWorldView() throws Exception
	{
		when(client.getWorldType()).thenReturn(EnumSet.noneOf(WorldType.class));

		KLiteRuntimeSnapshot snapshot = api.runtimeSnapshot().get();

		assertEquals(-1, snapshot.getPlane());
		assertTrue(snapshot.getMapRegions().isEmpty());
	}

	@Test
	public void cameraSnapshotCapturesCurrentAndTargetAngles() throws Exception
	{
		when(client.getCameraX()).thenReturn(100);
		when(client.getCameraY()).thenReturn(200);
		when(client.getCameraZ()).thenReturn(-300);
		when(client.getCameraPitch()).thenReturn(400);
		when(client.getCameraYaw()).thenReturn(500);
		when(client.getCameraPitchTarget()).thenReturn(600);
		when(client.getCameraYawTarget()).thenReturn(700);

		assertEquals(
			new KLiteCameraSnapshot(100, 200, -300, 400, 500, 600, 700),
			api.cameraSnapshot().get());
	}

	@Test
	public void equipmentQueriesUseTypedWornSlots() throws Exception
	{
		ItemContainer equipment = mock(ItemContainer.class);
		Item[] items = new Item[14];
		Arrays.fill(items, new Item(-1, 0));
		items[EquipmentInventorySlot.WEAPON.getSlotIdx()] = new Item(4151, 1);
		items[EquipmentInventorySlot.AMMO.getSlotIdx()] = new Item(892, 250);
		when(equipment.getItems()).thenReturn(items);
		when(client.getItemContainer(InventoryID.WORN)).thenReturn(equipment);

		assertEquals(250L, (long) api.equipmentCount(892).get());
		assertTrue(api.equipmentContains(4151).get());
		assertFalse(api.equipmentContains(995).get());
		assertEquals(
			new KLiteItemStack(3, 4151, 1),
			api.equipmentItem(EquipmentInventorySlot.WEAPON).get().get());
		assertFalse(api.equipmentItem(EquipmentInventorySlot.HEAD).get().isPresent());
		assertFalse(api.equipmentItem(null).get().isPresent());
	}
}
