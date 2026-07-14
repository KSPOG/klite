/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;
import org.junit.Before;
import org.junit.Test;

public class DefaultKLiteClientApiWorldCameraTest
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
	public void cameraYawNormalizesJau14Angles() throws Exception
	{
		when(client.getCameraYawTarget()).thenReturn(0);

		assertEquals(KLiteInteractionStatus.DISPATCHED, api.setCameraYawTarget(16_385).get().getStatus());
		verify(client).setCameraYawTarget(1);
	}

	@Test
	public void cameraPitchRejectsInvalidAngle() throws Exception
	{
		assertEquals(KLiteInteractionStatus.INVALID_REQUEST, api.setCameraPitchTarget(-1).get().getStatus());
		assertEquals(KLiteInteractionStatus.INVALID_REQUEST, api.setCameraPitchTarget(16_384).get().getStatus());
	}

	@Test
	public void destinationIsEmptyWhenNoPathIsSet() throws Exception
	{
		assertFalse(api.destination().get().isPresent());
	}

	@Test
	public void opensWorldHopperOnClientThread() throws Exception
	{
		assertEquals(KLiteInteractionStatus.DISPATCHED, api.openWorldHopper().get().getStatus());
		verify(client).openWorldHopper();
	}
}
