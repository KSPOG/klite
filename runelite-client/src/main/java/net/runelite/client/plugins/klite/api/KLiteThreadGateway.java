/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;

/** Executes RuneLite API work on the client thread. */
@Singleton
public class KLiteThreadGateway
{
	private final Client client;
	private final ClientThread clientThread;

	@Inject
	KLiteThreadGateway(Client client, ClientThread clientThread)
	{
		this.client = client;
		this.clientThread = clientThread;
	}

	public <T> CompletableFuture<T> submit(Supplier<T> supplier)
	{
		CompletableFuture<T> future = new CompletableFuture<>();
		Runnable operation = () ->
		{
			try
			{
				future.complete(supplier.get());
			}
			catch (Exception exception)
			{
				future.completeExceptionally(exception);
			}
		};

		if (client.isClientThread())
		{
			operation.run();
		}
		else
		{
			clientThread.invokeLater(operation);
		}

		return future;
	}

	public CompletableFuture<Void> execute(Runnable runnable)
	{
		return submit(() ->
		{
			runnable.run();
			return null;
		});
	}
}
