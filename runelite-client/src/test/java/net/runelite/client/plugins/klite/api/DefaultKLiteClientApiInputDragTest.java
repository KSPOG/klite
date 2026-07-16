/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.Rectangle;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import org.junit.Before;
import org.junit.Test;

public class DefaultKLiteClientApiInputDragTest
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
	public void dragSnapshotDetachesWidgetsAndInputState() throws Exception
	{
		Widget dragged = widget(100, "Dragged");
		when(client.getMouseCurrentButton()).thenReturn(2);
		when(client.isDraggingWidget()).thenReturn(true);
		when(client.getDragTime()).thenReturn(17);
		when(client.getDraggedWidget()).thenReturn(dragged);

		KLiteInputDragSnapshot snapshot = api.inputDragSnapshot().get();

		assertEquals(2, snapshot.getMouseButton());
		assertEquals(true, snapshot.isDraggingWidget());
		assertEquals(17, snapshot.getDragTime());
		assertEquals(100, snapshot.getDraggedWidget().getComponentId());
		assertNull(snapshot.getDraggedOnWidget());
	}

	@Test
	public void keyQueryAndDragTargetControlsDelegateExactly() throws Exception
	{
		int componentId = 0x12340001;
		Widget target = widget(componentId, "Target");
		when(client.isKeyPressed(81)).thenReturn(true);
		when(client.getWidget(componentId)).thenReturn(target);

		assertEquals(Boolean.TRUE, api.keyPressed(81).get());
		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setDraggedOnWidget(componentId).get().getStatus());
		verify(client).setDraggedOnWidget(target);

		when(client.getDraggedOnWidget()).thenReturn(target);
		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.clearDraggedOnWidget().get().getStatus());
		verify(client).setDraggedOnWidget(null);
	}

	@Test
	public void dragTargetControlsReportInvalidMissingAndNoActionStates() throws Exception
	{
		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.setDraggedOnWidget(-1).get().getStatus());
		assertEquals(KLiteInteractionStatus.TARGET_NOT_FOUND,
			api.setDraggedOnWidget(123).get().getStatus());
		assertEquals(KLiteInteractionStatus.NO_ACTION_REQUIRED,
			api.clearDraggedOnWidget().get().getStatus());
	}

	private static Widget widget(int componentId, String name)
	{
		Widget widget = mock(Widget.class);
		when(widget.getId()).thenReturn(componentId);
		when(widget.getName()).thenReturn(name);
		when(widget.getBounds()).thenReturn(new Rectangle());
		return widget;
	}
}
