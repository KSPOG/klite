/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.never;
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

	@Test
	public void freeCameraSnapshotPreservesUnknownMode() throws Exception
	{
		when(client.getCameraMode()).thenReturn(9);
		when(client.getCameraFocalPointX()).thenReturn(1.5f);
		when(client.getCameraFocalPointY()).thenReturn(-2.25f);
		when(client.getCameraFocalPointZ()).thenReturn(3.75f);

		assertEquals(new KLiteFreeCameraSnapshot(
			KLiteCameraMode.UNKNOWN, 9, 1.5f, -2.25f, 3.75f),
			api.freeCameraSnapshot().get());
	}

	@Test
	public void freeCameraEnableDispatchesTypedMode() throws Exception
	{
		when(client.getCameraMode()).thenReturn(KLiteCameraMode.NORMAL.getId());

		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setFreeCameraEnabled(true).get().getStatus());
		verify(client).setCameraMode(KLiteCameraMode.FREE.getId());
	}

	@Test
	public void freeCameraEnableSkipsMatchingMode() throws Exception
	{
		when(client.getCameraMode()).thenReturn(KLiteCameraMode.FREE.getId());

		assertEquals(KLiteInteractionStatus.NO_ACTION_REQUIRED,
			api.setFreeCameraEnabled(true).get().getStatus());
		verify(client, never()).setCameraMode(KLiteCameraMode.FREE.getId());
	}

	@Test
	public void focalPointRequiresFreeCameraMode() throws Exception
	{
		when(client.getCameraMode()).thenReturn(KLiteCameraMode.NORMAL.getId());

		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.setFreeCameraFocalPoint(1f, 2f, 3f).get().getStatus());
		verify(client, never()).setCameraFocalPointX(1f);
		verify(client, never()).setCameraFocalPointY(2f);
		verify(client, never()).setCameraFocalPointZ(3f);
	}

	@Test
	public void focalPointRejectsNonFiniteCoordinates() throws Exception
	{
		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.setFreeCameraFocalPoint(Float.NaN, 2f, 3f).get().getStatus());
		verify(client, never()).setCameraFocalPointX(Float.NaN);
	}

	@Test
	public void focalPointDispatchesAllCoordinates() throws Exception
	{
		when(client.getCameraMode()).thenReturn(KLiteCameraMode.FREE.getId());

		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setFreeCameraFocalPoint(1f, 2f, 3f).get().getStatus());
		verify(client).setCameraFocalPointX(1f);
		verify(client).setCameraFocalPointY(2f);
		verify(client).setCameraFocalPointZ(3f);
	}

	@Test
	public void freeCameraSpeedRejectsNegativeValues() throws Exception
	{
		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.setFreeCameraSpeed(-1).get().getStatus());
		verify(client, never()).setFreeCameraSpeed(-1);
	}

	@Test
	public void freeCameraSpeedDispatchesNonNegativeValues() throws Exception
	{
		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setFreeCameraSpeed(12).get().getStatus());
		verify(client).setFreeCameraSpeed(12);
	}

	@Test
	public void cameraSpeedRejectsNonFiniteAndDispatchesFiniteValues() throws Exception
	{
		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.setCameraSpeed(Float.NaN).get().getStatus());
		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.setCameraSpeed(Float.NEGATIVE_INFINITY).get().getStatus());
		verify(client, never()).setCameraSpeed(Float.NaN);
		verify(client, never()).setCameraSpeed(Float.NEGATIVE_INFINITY);

		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setCameraSpeed(-1.5f).get().getStatus());
		verify(client).setCameraSpeed(-1.5f);
	}

	@Test
	public void cameraInputControlsDispatchExactValues() throws Exception
	{
		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setCameraMouseButtonMask(-7).get().getStatus());
		verify(client).setCameraMouseButtonMask(-7);

		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setCameraPitchRelaxerEnabled(true).get().getStatus());
		verify(client).setCameraPitchRelaxerEnabled(true);

		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setInvertYaw(true).get().getStatus());
		verify(client).setInvertYaw(true);

		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setInvertPitch(false).get().getStatus());
		verify(client).setInvertPitch(false);
	}
}
