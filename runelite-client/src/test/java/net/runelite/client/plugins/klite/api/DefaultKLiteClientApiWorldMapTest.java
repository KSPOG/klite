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

import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.worldmap.WorldMap;
import net.runelite.api.worldmap.WorldMapData;
import net.runelite.client.callback.ClientThread;
import org.junit.Before;
import org.junit.Test;

public class DefaultKLiteClientApiWorldMapTest
{
	private Client client;
	private WorldMap worldMap;
	private DefaultKLiteClientApi api;

	@Before
	public void setUp()
	{
		client = mock(Client.class);
		worldMap = mock(WorldMap.class);
		when(client.isClientThread()).thenReturn(true);
		when(client.getWorldMap()).thenReturn(worldMap);
		api = new DefaultKLiteClientApi(
			client, new KLiteThreadGateway(client, mock(ClientThread.class)));
	}

	@Test
	public void snapshotCopiesPositionAndZoom() throws Exception
	{
		Point position = new Point(3200, 3201);
		when(worldMap.getWorldMapPosition()).thenReturn(position);
		when(worldMap.getWorldMapZoom()).thenReturn(4.5f);

		assertEquals(new KLiteWorldMapSnapshot(position, 4.5f),
			api.worldMapSnapshot().get().get());
	}

	@Test
	public void snapshotIsEmptyWhenPositionIsUnavailable() throws Exception
	{
		assertFalse(api.worldMapSnapshot().get().isPresent());
	}

	@Test
	public void snapshotIsEmptyWhenMapIsUnavailable() throws Exception
	{
		when(client.getWorldMap()).thenReturn(null);

		assertFalse(api.worldMapSnapshot().get().isPresent());
	}

	@Test
	public void containmentDelegatesSurfaceCoordinates() throws Exception
	{
		WorldMapData data = mock(WorldMapData.class);
		when(worldMap.getWorldMapData()).thenReturn(data);
		when(data.surfaceContainsPosition(3210, 3220)).thenReturn(true);

		assertEquals(Boolean.TRUE,
			api.worldMapContains(new WorldPoint(3210, 3220, 2)).get());
		verify(data).surfaceContainsPosition(3210, 3220);
	}

	@Test
	public void containmentIsFalseWithoutInputOrData() throws Exception
	{
		assertEquals(Boolean.FALSE, api.worldMapContains(null).get());
		assertEquals(Boolean.FALSE,
			api.worldMapContains(new WorldPoint(3210, 3220, 0)).get());
	}

	@Test
	public void targetRejectsNullAndUnavailableMap() throws Exception
	{
		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.setWorldMapPositionTarget(null).get().getStatus());
		when(client.getWorldMap()).thenReturn(null);
		assertEquals(KLiteInteractionStatus.TARGET_NOT_FOUND,
			api.setWorldMapPositionTarget(new WorldPoint(3200, 3200, 0)).get().getStatus());
	}

	@Test
	public void targetSkipsCurrentPosition() throws Exception
	{
		when(worldMap.getWorldMapPosition()).thenReturn(new Point(3200, 3201));
		WorldPoint target = new WorldPoint(3200, 3201, 3);

		assertEquals(KLiteInteractionStatus.NO_ACTION_REQUIRED,
			api.setWorldMapPositionTarget(target).get().getStatus());
		verify(worldMap, never()).setWorldMapPositionTarget(target);
	}

	@Test
	public void targetDispatchesDifferentPosition() throws Exception
	{
		when(worldMap.getWorldMapPosition()).thenReturn(new Point(3200, 3201));
		WorldPoint target = new WorldPoint(3300, 3301, 0);

		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setWorldMapPositionTarget(target).get().getStatus());
		verify(worldMap).setWorldMapPositionTarget(target);
	}
}
