/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collections;
import net.runelite.api.Client;
import net.runelite.api.Deque;
import net.runelite.api.GraphicsObject;
import net.runelite.api.Projectile;
import net.runelite.api.WorldView;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.callback.ClientThread;
import org.junit.Before;
import org.junit.Test;

public class DefaultKLiteClientApiSceneEffectsTest
{
	private Client client;
	private DefaultKLiteClientApi api;

	@Before
	public void setUp()
	{
		client = mock(Client.class);
		when(client.isClientThread()).thenReturn(true);
		api = new DefaultKLiteClientApi(client, new KLiteThreadGateway(client, mock(ClientThread.class)));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void projectilesReturnDetachedSnapshots() throws Exception
	{
		Deque<Projectile> projectiles = mock(Deque.class);
		Projectile projectile = mock(Projectile.class);
		when(projectiles.iterator()).thenReturn(Collections.singletonList(projectile).iterator());
		when(client.getProjectiles()).thenReturn(projectiles);
		when(projectile.getId()).thenReturn(123);
		when(projectile.getSourcePoint()).thenReturn(new WorldPoint(3200, 3200, 0));
		when(projectile.getTargetPoint()).thenReturn(new WorldPoint(3201, 3201, 0));
		when(projectile.getRemainingCycles()).thenReturn(8);

		KLiteProjectileSnapshot snapshot = api.projectiles().get().get(0);

		assertEquals(123, snapshot.getId());
		assertEquals(new WorldPoint(3200, 3200, 0), snapshot.getSourcePoint());
		assertEquals(8, snapshot.getRemainingCycles());
	}

	@Test
	@SuppressWarnings("unchecked")
	public void graphicsObjectsReturnDetachedSnapshots() throws Exception
	{
		WorldView worldView = mock(WorldView.class);
		Deque<GraphicsObject> graphicsObjects = mock(Deque.class);
		GraphicsObject graphicsObject = mock(GraphicsObject.class);
		when(client.getTopLevelWorldView()).thenReturn(worldView);
		when(worldView.getGraphicsObjects()).thenReturn(graphicsObjects);
		when(graphicsObjects.iterator()).thenReturn(Collections.singletonList(graphicsObject).iterator());
		when(graphicsObject.getId()).thenReturn(456);
		when(graphicsObject.getLocation()).thenReturn(new LocalPoint(128, 256));
		when(graphicsObject.getLevel()).thenReturn(1);

		KLiteGraphicsObjectSnapshot snapshot = api.graphicsObjects().get().get(0);

		assertEquals(456, snapshot.getId());
		assertEquals(new LocalPoint(128, 256), snapshot.getLocation());
		assertEquals(1, snapshot.getLevel());
	}
}
