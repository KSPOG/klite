/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.automation;

import java.time.Duration;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import net.runelite.client.plugins.klite.api.KLiteClientApi;

public final class AutomationContext
{
	private final KLiteClientApi clientApi;
	private final AtomicBoolean cancellationRequested = new AtomicBoolean();

	AutomationContext(KLiteClientApi clientApi)
	{
		this.clientApi = clientApi;
	}

	public KLiteClientApi client()
	{
		return clientApi;
	}

	public boolean isCancellationRequested()
	{
		return cancellationRequested.get();
	}

	public <T> T await(CompletableFuture<T> future, Duration timeout) throws Exception
	{
		if (isCancellationRequested())
		{
			throw new CancellationException("Automation was cancelled");
		}

		try
		{
			T value = future.get(timeout.toMillis(), TimeUnit.MILLISECONDS);
			if (isCancellationRequested())
			{
				throw new CancellationException("Automation was cancelled");
			}
			return value;
		}
		catch (TimeoutException ex)
		{
			throw new TimeoutException("Client operation exceeded " + timeout.toMillis() + "ms");
		}
	}

	void cancel()
	{
		cancellationRequested.set(true);
	}
}
