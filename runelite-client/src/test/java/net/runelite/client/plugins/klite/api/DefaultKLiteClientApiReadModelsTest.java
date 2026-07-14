/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.util.Collections;
import java.util.List;
import net.runelite.api.Client;
import net.runelite.api.IndexedObjectSet;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Scene;
import net.runelite.api.Skill;
import net.runelite.api.Tile;
import net.runelite.api.TileItem;
import net.runelite.api.WorldView;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.InventoryID;
import net.runelite.client.callback.ClientThread;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DefaultKLiteClientApiReadModelsTest
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
	public void equipmentReturnsOccupiedWornSlots() throws Exception
	{
		ItemContainer equipment = mock(ItemContainer.class);
		when(equipment.getItems()).thenReturn(new Item[]{new Item(4151, 1), new Item(-1, 0)});
		when(client.getItemContainer(InventoryID.WORN)).thenReturn(equipment);

		assertEquals(
			Collections.singletonList(new KLiteItemStack(0, 4151, 1)),
			api.equipment().get());
	}

	@Test
	public void skillsCaptureRealBoostedAndExperience() throws Exception
	{
		when(client.getRealSkillLevel(Skill.ATTACK)).thenReturn(70);
		when(client.getBoostedSkillLevel(Skill.ATTACK)).thenReturn(75);
		when(client.getSkillExperience(Skill.ATTACK)).thenReturn(800_000);

		List<KLiteSkillSnapshot> skills = api.skills().get();

		assertEquals(Skill.values().length, skills.size());
		assertEquals(new KLiteSkillSnapshot(Skill.ATTACK, 70, 75, 800_000), skills.get(0));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void playersAndNpcsAreDetachedSnapshots() throws Exception
	{
		WorldView worldView = mock(WorldView.class);
		IndexedObjectSet<Player> players = mock(IndexedObjectSet.class);
		IndexedObjectSet<NPC> npcs = mock(IndexedObjectSet.class);
		Player player = mock(Player.class);
		NPC npc = mock(NPC.class);
		WorldPoint playerLocation = new WorldPoint(3200, 3201, 0);
		WorldPoint npcLocation = new WorldPoint(3202, 3203, 0);

		when(client.getTopLevelWorldView()).thenReturn(worldView);
		when(client.getLocalPlayer()).thenReturn(player);
		doReturn(players).when(worldView).players();
		doReturn(npcs).when(worldView).npcs();
		when(players.iterator()).thenReturn(Collections.singletonList(player).iterator());
		when(npcs.iterator()).thenReturn(Collections.singletonList(npc).iterator());
		when(player.getName()).thenReturn("Local player");
		when(player.getWorldLocation()).thenReturn(playerLocation);
		when(player.getCombatLevel()).thenReturn(100);
		when(npc.getId()).thenReturn(123);
		when(npc.getIndex()).thenReturn(7);
		when(npc.getName()).thenReturn("Example NPC");
		when(npc.getWorldLocation()).thenReturn(npcLocation);

		List<KLitePlayerSnapshot> playerSnapshots = api.players().get();
		List<KLiteNpcSnapshot> npcSnapshots = api.npcs().get();

		assertEquals(1, playerSnapshots.size());
		assertEquals(playerLocation, playerSnapshots.get(0).getLocation());
		assertTrue(playerSnapshots.get(0).isLocalPlayer());
		assertEquals(1, npcSnapshots.size());
		assertEquals(123, npcSnapshots.get(0).getId());
		assertEquals(npcLocation, npcSnapshots.get(0).getLocation());
	}

	@Test
	public void groundItemsIncludeLocationAndLifecycle() throws Exception
	{
		WorldView worldView = mock(WorldView.class);
		Scene scene = mock(Scene.class);
		Tile tile = mock(Tile.class);
		TileItem item = mock(TileItem.class);
		WorldPoint location = new WorldPoint(3210, 3211, 0);

		when(client.getTopLevelWorldView()).thenReturn(worldView);
		when(worldView.getScene()).thenReturn(scene);
		when(scene.getTiles()).thenReturn(new Tile[][][]{{{tile}}});
		when(tile.getWorldLocation()).thenReturn(location);
		when(tile.getGroundItems()).thenReturn(Collections.singletonList(item));
		when(item.getId()).thenReturn(995);
		when(item.getQuantity()).thenReturn(1_000);
		when(item.getVisibleTime()).thenReturn(50);
		when(item.getDespawnTime()).thenReturn(150);
		when(item.getOwnership()).thenReturn(TileItem.OWNERSHIP_SELF);
		when(item.isPrivate()).thenReturn(true);

		assertEquals(
			Collections.singletonList(new KLiteGroundItemSnapshot(
				995, 1_000, location, 50, 150, TileItem.OWNERSHIP_SELF, true)),
			api.groundItems().get());
	}
}
