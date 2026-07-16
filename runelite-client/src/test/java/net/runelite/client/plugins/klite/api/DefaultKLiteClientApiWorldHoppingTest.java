/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.World;
import net.runelite.api.WorldType;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import org.junit.Test;

public class DefaultKLiteClientApiWorldHoppingTest
{
	@Test
	public void worldsReturnDetachedSnapshotsAndSupportLookup() throws Exception
	{
		Client client = mock(Client.class);
		World world = world(302);
		EnumSet<WorldType> types = EnumSet.of(WorldType.MEMBERS, WorldType.PVP);
		when(client.isClientThread()).thenReturn(true);
		when(client.getWorldList()).thenReturn(new World[]{world, null});
		when(world.getIndex()).thenReturn(1);
		when(world.getPlayerCount()).thenReturn(1_234);
		when(world.getLocation()).thenReturn(3);
		when(world.getActivity()).thenReturn("PvP");
		when(world.getAddress()).thenReturn("oldschool302.runescape.com");
		when(world.getTypes()).thenReturn(types);
		DefaultKLiteClientApi api = api(client);

		List<KLiteWorldSnapshot> snapshots = api.worlds().get();
		KLiteWorldSnapshot lookup = api.world(302).get().get();
		KLiteWorldSnapshot expected = new KLiteWorldSnapshot(
			302, 1, 1_234, 3, "PvP", "oldschool302.runescape.com",
			Arrays.asList(WorldType.MEMBERS, WorldType.PVP));
		types.clear();

		assertEquals(Collections.singletonList(expected), snapshots);
		assertEquals(expected, lookup);
		assertFalse(api.world(999).get().isPresent());
	}

	@Test
	public void loginScreenHopChangesWorldDirectly() throws Exception
	{
		Client client = mock(Client.class);
		World target = world(302);
		when(client.isClientThread()).thenReturn(true);
		when(client.getWorld()).thenReturn(301);
		when(client.getWorldList()).thenReturn(new World[]{target});
		when(client.getGameState()).thenReturn(GameState.LOGIN_SCREEN);

		KLiteInteractionResult result = api(client).hopToWorld(302).get();

		assertEquals(KLiteInteractionStatus.DISPATCHED, result.getStatus());
		verify(client).changeWorld(target);
		verify(client, never()).hopToWorld(target);
	}

	@Test
	public void openWorldHopperDispatchesHop() throws Exception
	{
		Client client = mock(Client.class);
		World target = world(302);
		Widget switcher = mock(Widget.class);
		when(client.isClientThread()).thenReturn(true);
		when(client.getWorld()).thenReturn(301);
		when(client.getWorldList()).thenReturn(new World[]{target});
		when(client.getGameState()).thenReturn(GameState.LOGGED_IN);
		when(client.getWidget(InterfaceID.Worldswitcher.BUTTONS)).thenReturn(switcher);
		when(switcher.isHidden()).thenReturn(false);

		KLiteInteractionResult result = api(client).hopToWorld(302).get();

		assertEquals(KLiteInteractionStatus.DISPATCHED, result.getStatus());
		verify(client).hopToWorld(target);
	}

	@Test
	public void hopValidatesWorldAndHopperState() throws Exception
	{
		Client client = mock(Client.class);
		World target = world(302);
		when(client.isClientThread()).thenReturn(true);
		when(client.getWorld()).thenReturn(301);
		when(client.getWorldList()).thenReturn(new World[]{target});
		when(client.getGameState()).thenReturn(GameState.LOGGED_IN);
		DefaultKLiteClientApi api = api(client);

		assertEquals(KLiteInteractionStatus.INVALID_REQUEST, api.hopToWorld(0).get().getStatus());
		assertEquals(KLiteInteractionStatus.TARGET_NOT_FOUND, api.hopToWorld(999).get().getStatus());
		assertEquals(KLiteInteractionStatus.TARGET_NOT_FOUND, api.hopToWorld(302).get().getStatus());
		when(client.getWorld()).thenReturn(302);
		assertEquals(KLiteInteractionStatus.NO_ACTION_REQUIRED, api.hopToWorld(302).get().getStatus());
		verify(client, never()).hopToWorld(target);
		verify(client, never()).changeWorld(target);
	}

	private static DefaultKLiteClientApi api(Client client)
	{
		return new DefaultKLiteClientApi(
			client, new KLiteThreadGateway(client, mock(ClientThread.class)));
	}

	private static World world(int id)
	{
		World world = mock(World.class);
		when(world.getId()).thenReturn(id);
		return world;
	}
}
