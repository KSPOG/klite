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

import java.awt.Rectangle;
import java.util.Optional;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Tile;
import net.runelite.api.WorldView;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import org.junit.Before;
import org.junit.Test;

public class DefaultKLiteClientApiContextStateTest
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
	public void followerReturnsDetachedNpcSnapshot() throws Exception
	{
		NPC follower = mock(NPC.class);
		when(follower.getId()).thenReturn(7617);
		when(follower.getIndex()).thenReturn(42);
		when(follower.getName()).thenReturn("Rock Golem");
		when(follower.getWorldLocation()).thenReturn(new WorldPoint(3200, 3201, 0));
		when(client.getFollower()).thenReturn(follower);

		KLiteNpcSnapshot snapshot = api.follower().get().get();

		assertEquals(7617, snapshot.getId());
		assertEquals(42, snapshot.getIndex());
		assertEquals("Rock Golem", snapshot.getName());
		assertEquals(new WorldPoint(3200, 3201, 0), snapshot.getLocation());
	}

	@Test
	public void followerIsEmptyWhenAbsent() throws Exception
	{
		assertFalse(api.follower().get().isPresent());
	}

	@Test
	public void focusedInputWidgetReturnsDetachedWidgetSnapshot() throws Exception
	{
		Widget widget = mock(Widget.class);
		when(widget.getId()).thenReturn(1234);
		when(widget.getIndex()).thenReturn(7);
		when(widget.getText()).thenReturn("Search");
		when(widget.getBounds()).thenReturn(new Rectangle(10, 20, 300, 30));
		when(client.getFocusedInputFieldWidget()).thenReturn(widget);

		KLiteWidgetSnapshot snapshot = api.focusedInputWidget().get().get();

		assertEquals(1234, snapshot.getComponentId());
		assertEquals(7, snapshot.getIndex());
		assertEquals("Search", snapshot.getText());
		assertEquals(10, snapshot.getX());
		assertEquals(20, snapshot.getY());
		assertEquals(300, snapshot.getWidth());
		assertEquals(30, snapshot.getHeight());
	}

	@Test
	public void focusedInputWidgetIsEmptyWhenAbsent() throws Exception
	{
		Optional<KLiteWidgetSnapshot> snapshot = api.focusedInputWidget().get();

		assertFalse(snapshot.isPresent());
	}

	@Test
	public void widgetTargetStateReadsAndClearsSelection() throws Exception
	{
		when(client.isWidgetSelected()).thenReturn(true);

		assertEquals(Boolean.TRUE, api.widgetTargetSelected().get());
		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.clearWidgetTarget().get().getStatus());
		verify(client).setWidgetSelected(false);
	}

	@Test
	public void clearWidgetTargetSkipsAbsentSelection() throws Exception
	{
		assertEquals(KLiteInteractionStatus.NO_ACTION_REQUIRED,
			api.clearWidgetTarget().get().getStatus());
		verify(client, never()).setWidgetSelected(false);
	}

	@Test
	public void selectedSceneTileReturnsDetachedLocation() throws Exception
	{
		WorldView worldView = mock(WorldView.class);
		Tile tile = mock(Tile.class);
		WorldPoint location = new WorldPoint(3210, 3220, 1);
		when(client.getTopLevelWorldView()).thenReturn(worldView);
		when(worldView.getSelectedSceneTile()).thenReturn(tile);
		when(tile.getWorldLocation()).thenReturn(location);

		assertEquals(location, api.selectedSceneTile().get().get());
	}

	@Test
	public void selectedSceneTileIsEmptyWithoutWorldOrTile() throws Exception
	{
		assertFalse(api.selectedSceneTile().get().isPresent());

		WorldView worldView = mock(WorldView.class);
		when(client.getTopLevelWorldView()).thenReturn(worldView);
		assertFalse(api.selectedSceneTile().get().isPresent());
	}
}
