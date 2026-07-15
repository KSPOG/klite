/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import net.runelite.api.Client;
import net.runelite.api.HintArrowType;
import net.runelite.api.IndexedObjectSet;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.WorldView;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.callback.ClientThread;
import org.junit.Before;
import org.junit.Test;

public class DefaultKLiteClientApiHintArrowTest
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
	public void coordinateHintArrowReturnsDetachedState() throws Exception
	{
		WorldPoint point = new WorldPoint(3200, 3201, 0);
		when(client.hasHintArrow()).thenReturn(true);
		when(client.getHintArrowType()).thenReturn(HintArrowType.COORDINATE);
		when(client.getHintArrowPoint()).thenReturn(point);

		KLiteHintArrowSnapshot snapshot = api.hintArrow().get().get();

		assertEquals(KLiteHintArrowType.COORDINATE, snapshot.getType());
		assertEquals(HintArrowType.COORDINATE, snapshot.getTypeId());
		assertEquals(point, snapshot.getPoint());
		assertNull(snapshot.getPlayer());
		assertNull(snapshot.getNpc());
	}

	@Test
	public void entityHintArrowsReturnDetachedActorSnapshots() throws Exception
	{
		NPC npc = mock(NPC.class);
		Player player = mock(Player.class);
		when(client.hasHintArrow()).thenReturn(true);
		when(client.getHintArrowType()).thenReturn(HintArrowType.NPC, HintArrowType.PLAYER);
		when(client.getHintArrowNpc()).thenReturn(npc);
		when(client.getHintArrowPlayer()).thenReturn(player);
		when(client.getLocalPlayer()).thenReturn(player);
		when(npc.getId()).thenReturn(100);
		when(npc.getIndex()).thenReturn(7);
		when(npc.getName()).thenReturn("Guide");
		when(player.getId()).thenReturn(11);
		when(player.getName()).thenReturn("KSP");

		KLiteHintArrowSnapshot npcSnapshot = api.hintArrow().get().get();
		KLiteHintArrowSnapshot playerSnapshot = api.hintArrow().get().get();

		assertEquals(KLiteHintArrowType.NPC, npcSnapshot.getType());
		assertNotNull(npcSnapshot.getNpc());
		assertEquals(7, npcSnapshot.getNpc().getIndex());
		assertEquals(KLiteHintArrowType.PLAYER, playerSnapshot.getType());
		assertNotNull(playerSnapshot.getPlayer());
		assertEquals(11, playerSnapshot.getPlayer().getId());
		assertTrue(playerSnapshot.getPlayer().isLocalPlayer());
	}

	@Test
	public void absentAndUnknownHintArrowsAreRepresentedSafely() throws Exception
	{
		assertFalse(api.hintArrow().get().isPresent());
		when(client.hasHintArrow()).thenReturn(true);
		when(client.getHintArrowType()).thenReturn(99);

		KLiteHintArrowSnapshot snapshot = api.hintArrow().get().get();

		assertEquals(KLiteHintArrowType.UNKNOWN, snapshot.getType());
		assertEquals(99, snapshot.getTypeId());
	}

	@Test
	public void pointAndClearControlsAreStateAware() throws Exception
	{
		WorldPoint current = new WorldPoint(3200, 3200, 0);
		WorldPoint replacement = new WorldPoint(3201, 3201, 0);
		when(client.getHintArrowType()).thenReturn(HintArrowType.COORDINATE);
		when(client.getHintArrowPoint()).thenReturn(current);

		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.setHintArrow(null).get().getStatus());
		assertEquals(KLiteInteractionStatus.NO_ACTION_REQUIRED,
			api.setHintArrow(current).get().getStatus());
		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setHintArrow(replacement).get().getStatus());
		verify(client).setHintArrow(replacement);

		when(client.hasHintArrow()).thenReturn(false, true);
		assertEquals(KLiteInteractionStatus.NO_ACTION_REQUIRED,
			api.clearHintArrow().get().getStatus());
		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.clearHintArrow().get().getStatus());
		verify(client).clearHintArrow();
	}

	@Test
	@SuppressWarnings({"rawtypes", "unchecked"})
	public void entityControlsResolveCurrentWorldView() throws Exception
	{
		WorldView worldView = mock(WorldView.class);
		IndexedObjectSet npcs = mock(IndexedObjectSet.class);
		IndexedObjectSet players = mock(IndexedObjectSet.class);
		NPC npc = mock(NPC.class);
		Player player = mock(Player.class);
		when(client.getTopLevelWorldView()).thenReturn(worldView);
		when(worldView.npcs()).thenReturn(npcs);
		when(worldView.players()).thenReturn(players);
		when(npcs.byIndex(7)).thenReturn(npc);
		when(players.byIndex(11)).thenReturn(player);

		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setHintArrowNpc(7).get().getStatus());
		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setHintArrowPlayer(11).get().getStatus());
		verify(client).setHintArrow(npc);
		verify(client).setHintArrow(player);
	}

	@Test
	@SuppressWarnings({"rawtypes", "unchecked"})
	public void entityControlsRejectInvalidOrMissingTargets() throws Exception
	{
		WorldView worldView = mock(WorldView.class);
		IndexedObjectSet npcs = mock(IndexedObjectSet.class);
		IndexedObjectSet players = mock(IndexedObjectSet.class);
		when(client.getTopLevelWorldView()).thenReturn(worldView);
		when(worldView.npcs()).thenReturn(npcs);
		when(worldView.players()).thenReturn(players);

		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.setHintArrowNpc(-1).get().getStatus());
		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.setHintArrowPlayer(-1).get().getStatus());
		assertEquals(KLiteInteractionStatus.TARGET_NOT_FOUND,
			api.setHintArrowNpc(7).get().getStatus());
		assertEquals(KLiteInteractionStatus.TARGET_NOT_FOUND,
			api.setHintArrowPlayer(11).get().getStatus());
		verify(client, never()).setHintArrow(any(NPC.class));
		verify(client, never()).setHintArrow(any(Player.class));
	}
}
