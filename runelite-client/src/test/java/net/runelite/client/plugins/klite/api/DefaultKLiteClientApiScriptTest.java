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

public class DefaultKLiteClientApiScriptTest
{
	@Test
	public void emptyScriptRequestIsRejected() throws Exception
	{
		Client client = mock(Client.class);
		when(client.isClientThread()).thenReturn(true);
		DefaultKLiteClientApi api = new DefaultKLiteClientApi(
			client, new KLiteThreadGateway(client, mock(ClientThread.class)));

		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.runScript().get().getStatus());
		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.runScript((Object[]) null).get().getStatus());
	}

	@Test
	public void scriptArgumentsAreCopiedBeforeDeferredExecution() throws Exception
	{
		Client client = mock(Client.class);
		ClientThread clientThread = mock(ClientThread.class);
		when(client.isClientThread()).thenReturn(false);
		DefaultKLiteClientApi api = new DefaultKLiteClientApi(
			client, new KLiteThreadGateway(client, clientThread));
		Object[] arguments = {1234, "before", 7};

		CompletableFuture<KLiteInteractionResult> future = api.runScript(arguments);
		assertFalse(future.isDone());
		arguments[1] = "after";

		ArgumentCaptor<Runnable> runnableCaptor = ArgumentCaptor.forClass(Runnable.class);
		verify(clientThread).invokeLater(runnableCaptor.capture());
		runnableCaptor.getValue().run();

		assertEquals(KLiteInteractionStatus.DISPATCHED, future.get().getStatus());
		verify(client).runScript(1234, "before", 7);
	}
}
