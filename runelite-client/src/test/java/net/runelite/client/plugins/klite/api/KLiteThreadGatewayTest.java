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

import java.util.concurrent.CompletableFuture;
import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class KLiteThreadGatewayTest
{
	@Test
	public void submitRunsImmediatelyOnClientThread() throws Exception
	{
		Client client = mock(Client.class);
		when(client.isClientThread()).thenReturn(true);
		KLiteThreadGateway gateway = new KLiteThreadGateway(client, mock(ClientThread.class));

		assertEquals("ready", gateway.submit(() -> "ready").get());
	}

	@Test
	public void submitQueuesWorkOffClientThread() throws Exception
	{
		Client client = mock(Client.class);
		ClientThread clientThread = mock(ClientThread.class);
		when(client.isClientThread()).thenReturn(false);
		KLiteThreadGateway gateway = new KLiteThreadGateway(client, clientThread);

		CompletableFuture<Integer> future = gateway.submit(() -> 42);
		assertFalse(future.isDone());

		ArgumentCaptor<Runnable> captor = ArgumentCaptor.forClass(Runnable.class);
		verify(clientThread).invokeLater(captor.capture());
		captor.getValue().run();
		assertEquals(Integer.valueOf(42), future.get());
	}
}
