/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;
import org.junit.Before;
import org.junit.Test;

public class DefaultKLiteClientApiMinimapRuntimeTest
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
	public void idleTimeoutReadsAndDispatchesRawTicks() throws Exception
	{
		when(client.getIdleTimeout()).thenReturn(100);
		assertEquals(Integer.valueOf(100), api.idleTimeout().get());

		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setIdleTimeout(-1).get().getStatus());
		verify(client).setIdleTimeout(-1);
	}

	@Test
	public void idleTimeoutSkipsMatchingValue() throws Exception
	{
		when(client.getIdleTimeout()).thenReturn(250);

		assertEquals(KLiteInteractionStatus.NO_ACTION_REQUIRED,
			api.setIdleTimeout(250).get().getStatus());
		verify(client, never()).setIdleTimeout(250);
	}

	@Test
	public void minimapSnapshotCopiesBothZoomValues() throws Exception
	{
		when(client.isMinimapZoom()).thenReturn(true);
		when(client.getMinimapZoom()).thenReturn(4.25);

		assertEquals(new KLiteMinimapSnapshot(true, 4.25),
			api.minimapSnapshot().get());
	}

	@Test
	public void minimapZoomEnabledIsIdempotent() throws Exception
	{
		when(client.isMinimapZoom()).thenReturn(true);

		assertEquals(KLiteInteractionStatus.NO_ACTION_REQUIRED,
			api.setMinimapZoomEnabled(true).get().getStatus());
		verify(client, never()).setMinimapZoom(true);

		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setMinimapZoomEnabled(false).get().getStatus());
		verify(client).setMinimapZoom(false);
	}

	@Test
	public void minimapZoomRejectsNonFiniteValues() throws Exception
	{
		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.setMinimapZoom(Double.NaN).get().getStatus());
		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.setMinimapZoom(Double.POSITIVE_INFINITY).get().getStatus());
		verify(client, never()).setMinimapZoom(Double.NaN);
		verify(client, never()).setMinimapZoom(Double.POSITIVE_INFINITY);
	}

	@Test
	public void minimapZoomIsIdempotentAndDispatchesRawFiniteValues() throws Exception
	{
		when(client.getMinimapZoom()).thenReturn(4.0);

		assertEquals(KLiteInteractionStatus.NO_ACTION_REQUIRED,
			api.setMinimapZoom(4.0).get().getStatus());
		verify(client, never()).setMinimapZoom(4.0);

		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setMinimapZoom(-2.5).get().getStatus());
		verify(client).setMinimapZoom(-2.5);
	}
}
