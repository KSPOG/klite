/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.Rectangle;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import org.junit.Before;
import org.junit.Test;

public class DefaultKLiteClientApiRootInterfaceTest
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
	public void interfaceSnapshotDetachesNonNullRoots() throws Exception
	{
		Widget root = mock(Widget.class);
		when(root.getId()).thenReturn(0x12340000);
		when(root.getName()).thenReturn("Root");
		when(root.getBounds()).thenReturn(new Rectangle(1, 2, 3, 4));
		when(client.getTopLevelInterfaceId()).thenReturn(0x1234);
		when(client.getWidgetRoots()).thenReturn(new Widget[]{root, null});

		KLiteInterfaceSnapshot snapshot = api.interfaceSnapshot().get();

		assertEquals(0x1234, snapshot.getTopLevelInterfaceId());
		assertEquals(1, snapshot.getRoots().size());
		assertEquals(0x12340000, snapshot.getRoots().get(0).getComponentId());
		assertEquals("Root", snapshot.getRoots().get(0).getName());
	}

	@Test
	public void interfaceSnapshotHandlesUnavailableRoots() throws Exception
	{
		assertTrue(api.interfaceSnapshot().get().getRoots().isEmpty());
	}
}
