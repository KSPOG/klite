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

public class DefaultKLiteClientApiAudioTest
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
	public void musicVolumeReadsCurrentValue() throws Exception
	{
		when(client.getMusicVolume()).thenReturn(127);

		assertEquals(Integer.valueOf(127), api.musicVolume().get());
	}

	@Test
	public void musicVolumeRejectsValuesOutsideDocumentedRange() throws Exception
	{
		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.setMusicVolume(-1).get().getStatus());
		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.setMusicVolume(256).get().getStatus());
		verify(client, never()).setMusicVolume(-1);
		verify(client, never()).setMusicVolume(256);
	}

	@Test
	public void musicVolumeSkipsMatchingValue() throws Exception
	{
		when(client.getMusicVolume()).thenReturn(64);

		assertEquals(KLiteInteractionStatus.NO_ACTION_REQUIRED,
			api.setMusicVolume(64).get().getStatus());
		verify(client, never()).setMusicVolume(64);
	}

	@Test
	public void musicVolumeDispatchesBoundaryValues() throws Exception
	{
		when(client.getMusicVolume()).thenReturn(1);

		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setMusicVolume(0).get().getStatus());
		verify(client).setMusicVolume(0);

		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setMusicVolume(255).get().getStatus());
		verify(client).setMusicVolume(255);
	}

	@Test
	public void soundPlaybackDispatchesEveryClientForm() throws Exception
	{
		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.playSoundEffect(-10).get().getStatus());
		verify(client).playSoundEffect(-10);

		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.playSoundEffectAtVolume(20, 127).get().getStatus());
		verify(client).playSoundEffect(20, 127);

		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.playAreaSoundEffect(30, 3200, 3201, 8).get().getStatus());
		verify(client).playSoundEffect(30, 3200, 3201, 8);

		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.playAreaSoundEffect(40, 3202, 3203, 10, 2).get().getStatus());
		verify(client).playSoundEffect(40, 3202, 3203, 10, 2);
	}
}
