/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.Dimension;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.client.callback.ClientThread;
import org.junit.Before;
import org.junit.Test;

public class DefaultKLiteClientApiInputDisplayTest
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
	public void inputSnapshotCopiesPointerAndIdleTiming() throws Exception
	{
		Point mouse = new Point(123, 456);
		when(client.getMouseCanvasPosition()).thenReturn(mouse);
		when(client.getMouseIdleTicks()).thenReturn(12);
		when(client.getMouseLastPressedMillis()).thenReturn(1_234_567L);
		when(client.getKeyboardIdleTicks()).thenReturn(34);

		assertEquals(new KLiteInputSnapshot(mouse, 12, 1_234_567L, 34),
			api.inputSnapshot().get());
	}

	@Test
	public void displaySnapshotCopiesCanvasViewportAndStretching() throws Exception
	{
		when(client.getCanvasWidth()).thenReturn(765);
		when(client.getCanvasHeight()).thenReturn(503);
		when(client.getViewportXOffset()).thenReturn(4);
		when(client.getViewportYOffset()).thenReturn(5);
		when(client.getViewportWidth()).thenReturn(700);
		when(client.getViewportHeight()).thenReturn(400);
		when(client.getScale()).thenReturn(512);
		when(client.isResized()).thenReturn(true);
		when(client.isStretchedEnabled()).thenReturn(true);
		when(client.isStretchedFast()).thenReturn(true);
		when(client.getStretchedDimensions()).thenReturn(new Dimension(1_530, 1_006));
		when(client.getRealDimensions()).thenReturn(new Dimension(765, 503));

		assertEquals(new KLiteDisplaySnapshot(
			765, 503, 4, 5, 700, 400, 512,
			true, true, true, 1_530, 1_006, 765, 503),
			api.displaySnapshot().get());
	}

	@Test
	public void unavailableDimensionsUseExplicitSentinels() throws Exception
	{
		KLiteDisplaySnapshot snapshot = api.displaySnapshot().get();

		assertEquals(-1, snapshot.getStretchedWidth());
		assertEquals(-1, snapshot.getStretchedHeight());
		assertEquals(-1, snapshot.getRealWidth());
		assertEquals(-1, snapshot.getRealHeight());
	}
}
