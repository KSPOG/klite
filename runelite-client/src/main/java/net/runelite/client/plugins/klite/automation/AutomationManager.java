/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.automation;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.plugins.klite.api.KLiteClientApi;

/** Controls one cooperative automation task at a time. */
@Singleton
@Slf4j
public class AutomationManager
{
	public static final long MINIMUM_INTERVAL_MILLIS = 100L;
	private static final int MAX_CONSECUTIVE_TIMEOUTS = 5;

	private final Object lock = new Object();
	private final KLiteClientApi clientApi;
	private final AutomationWindowLock windowLock;
	private final ScheduledExecutorService executor;

	private AutomationState state = AutomationState.DISABLED;
	@Nullable
	private AutomationTask activeTask;
	@Nullable
	private AutomationContext activeContext;
	@Nullable
	private ScheduledFuture<?> activeFuture;
	@Nullable
	private String failureMessage;
	private long startedAtMillis;
	private int consecutiveTimeouts;

	@Inject
	AutomationManager(KLiteClientApi clientApi, AutomationWindowLock windowLock)
	{
		this(clientApi, windowLock, Executors.newSingleThreadScheduledExecutor(
			new ThreadFactoryBuilder().setDaemon(true).setNameFormat("klite-automation-%d").build()));
	}

	AutomationManager(KLiteClientApi clientApi, AutomationWindowLock windowLock,
		ScheduledExecutorService executor)
	{
		this.clientApi = clientApi;
		this.windowLock = windowLock;
		this.executor = executor;
	}

	public void setEnabled(boolean enabled)
	{
		if (!enabled)
		{
			stopInternal(AutomationState.DISABLED);
			return;
		}

		synchronized (lock)
		{
			if (state == AutomationState.DISABLED)
			{
				state = AutomationState.IDLE;
				failureMessage = null;
			}
		}
	}

	public boolean start(AutomationTask task)
	{
		Objects.requireNonNull(task, "task");
		String taskName = Objects.requireNonNull(task.name(), "task.name()").trim();
		Duration interval = Objects.requireNonNull(task.interval(), "task.interval()");
		if (taskName.isEmpty())
		{
			throw new IllegalArgumentException("Automation task name cannot be blank");
		}
		if (interval.toMillis() < MINIMUM_INTERVAL_MILLIS)
		{
			throw new IllegalArgumentException("Automation interval must be at least "
				+ MINIMUM_INTERVAL_MILLIS + "ms");
		}

		AutomationContext context;
		synchronized (lock)
		{
			if (state != AutomationState.IDLE || activeTask != null)
			{
				return false;
			}

			context = new AutomationContext(clientApi);
			activeTask = task;
			activeContext = context;
			failureMessage = null;
			startedAtMillis = System.currentTimeMillis();
			consecutiveTimeouts = 0;
			state = AutomationState.RUNNING;
		}

		windowLock.acquire();
		executor.execute(() -> initialize(task, context, interval));
		return true;
	}

	public void stop()
	{
		synchronized (lock)
		{
			if (state == AutomationState.DISABLED)
			{
				return;
			}
		}
		stopInternal(AutomationState.IDLE);
	}

	public AutomationStatus status()
	{
		synchronized (lock)
		{
			return new AutomationStatus(
				state,
				activeTask == null ? null : activeTask.name(),
				failureMessage,
				startedAtMillis);
		}
	}

	public void shutdown()
	{
		stopInternal(AutomationState.DISABLED);
		executor.shutdownNow();
	}

	private void initialize(AutomationTask task, AutomationContext context, Duration interval)
	{
		try
		{
			task.onStart(context);
			synchronized (lock)
			{
				if (activeTask != task || context.isCancellationRequested())
				{
					return;
				}
				activeFuture = executor.scheduleWithFixedDelay(
					() -> tick(task, context), 0L, interval.toMillis(), TimeUnit.MILLISECONDS);
			}
		}
		catch (CancellationException exception)
		{
			if (!context.isCancellationRequested())
			{
				fail(task, context, exception);
			}
		}
		catch (Exception exception)
		{
			fail(task, context, exception);
		}
	}

	private void tick(AutomationTask task, AutomationContext context)
	{
		if (context.isCancellationRequested())
		{
			return;
		}

		try
		{
			AutomationResult result = task.tick(context);
			consecutiveTimeouts = 0;
			if (result == AutomationResult.STOP)
			{
				finish(task, context, AutomationState.IDLE, null);
			}
		}
		catch (CancellationException exception)
		{
			if (!context.isCancellationRequested())
			{
				fail(task, context, exception);
			}
		}
		catch (TimeoutException exception)
		{
			if (context.isCancellationRequested())
			{
				return;
			}
			consecutiveTimeouts++;
			log.warn("KLite automation task {} timed out waiting for the client thread ({}/{}); "
				+ "the task will retry on its next tick", task.name(), consecutiveTimeouts,
				MAX_CONSECUTIVE_TIMEOUTS);
			if (consecutiveTimeouts >= MAX_CONSECUTIVE_TIMEOUTS)
			{
				fail(task, context, new TimeoutException(
					"Client thread remained unresponsive for " + consecutiveTimeouts
						+ " consecutive automation requests"));
			}
		}
		catch (Exception exception)
		{
			fail(task, context, exception);
		}
	}

	private void fail(AutomationTask task, AutomationContext context, Exception exception)
	{
		log.error("KLite automation task {} failed", task.name(), exception);
		finish(task, context, AutomationState.FAILED,
			exception.getMessage() == null ? exception.getClass().getSimpleName() : exception.getMessage());
	}

	private void stopInternal(AutomationState targetState)
	{
		AutomationTask task;
		AutomationContext context;
		synchronized (lock)
		{
			task = activeTask;
			context = activeContext;
			if (task == null || context == null)
			{
				state = targetState;
				if (targetState != AutomationState.FAILED)
				{
					failureMessage = null;
				}
				return;
			}
			state = AutomationState.STOPPING;
		}
		finish(task, context, targetState, null);
	}

	private void finish(AutomationTask task, AutomationContext context,
		AutomationState targetState, @Nullable String error)
	{
		ScheduledFuture<?> future;
		synchronized (lock)
		{
			if (activeTask != task || activeContext != context)
			{
				return;
			}

			context.cancel();
			future = activeFuture;
			activeFuture = null;
			activeTask = null;
			activeContext = null;
			failureMessage = error;
			state = targetState;
			consecutiveTimeouts = 0;
			if (targetState != AutomationState.FAILED)
			{
				startedAtMillis = 0L;
			}
		}

		if (future != null)
		{
			future.cancel(false);
		}
		try
		{
			task.onStop(context);
		}
		catch (Exception exception)
		{
			log.warn("KLite automation task {} failed during shutdown", task.name(), exception);
		}
		finally
		{
			windowLock.release();
		}
	}
}
