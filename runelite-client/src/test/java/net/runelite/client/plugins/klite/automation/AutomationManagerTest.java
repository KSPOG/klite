/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.automation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import net.runelite.client.plugins.klite.api.KLiteClientApi;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.klite.KLiteConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AutomationManagerTest
{
	private ScheduledExecutorService executor;
	private AutomationManager manager;
	private AutomationWindowLock windowLock;

	@Before
	public void setUp()
	{
		executor = Executors.newSingleThreadScheduledExecutor();
		KLiteConfig config = mock(KLiteConfig.class);
		windowLock = new AutomationWindowLock(
			mock(ConfigManager.class), config);
		manager = new AutomationManager(
			mock(KLiteClientApi.class), windowLock, executor);
	}

	@After
	public void tearDown()
	{
		manager.shutdown();
	}

	@Test
	public void disabledManagerRejectsTasks()
	{
		manager.stop();
		assertFalse(manager.start(stoppingTask(new CountDownLatch(1))));
		assertEquals(AutomationState.DISABLED, manager.status().getState());
	}

	@Test
	public void taskCanStopCooperatively() throws Exception
	{
		CountDownLatch stopped = new CountDownLatch(1);
		manager.setEnabled(true);

		assertTrue(manager.start(stoppingTask(stopped)));
		assertTrue(stopped.await(2, TimeUnit.SECONDS));
		assertEquals(AutomationState.IDLE, manager.status().getState());
	}

	@Test
	public void failureIsReportedAndRequiresReset() throws Exception
	{
		CountDownLatch stopped = new CountDownLatch(1);
		manager.setEnabled(true);
		AutomationTask failingTask = new AutomationTask()
		{
			@Override
			public String name()
			{
				return "failure-test";
			}

			@Override
			public Duration interval()
			{
				return Duration.ofMillis(100);
			}

			@Override
			public AutomationResult tick(AutomationContext context)
			{
				throw new IllegalStateException("boom");
			}

			@Override
			public void onStop(AutomationContext context)
			{
				stopped.countDown();
			}
		};

		assertTrue(manager.start(failingTask));
		assertTrue(stopped.await(2, TimeUnit.SECONDS));
		assertEquals(AutomationState.FAILED, manager.status().getState());
		assertEquals("boom", manager.status().getFailureMessage());
		assertFalse(manager.start(stoppingTask(new CountDownLatch(1))));

		manager.stop();
		assertEquals(AutomationState.IDLE, manager.status().getState());
	}

	private static AutomationTask stoppingTask(CountDownLatch stopped)
	{
		return new AutomationTask()
		{
			@Override
			public String name()
			{
				return "stop-test";
			}

			@Override
			public Duration interval()
			{
				return Duration.ofMillis(100);
			}

			@Override
			public AutomationResult tick(AutomationContext context)
			{
				return AutomationResult.STOP;
			}

			@Override
			public void onStop(AutomationContext context)
			{
				stopped.countDown();
			}
		};
	}
}
