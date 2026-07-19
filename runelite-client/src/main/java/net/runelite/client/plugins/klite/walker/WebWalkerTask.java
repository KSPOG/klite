/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.walker;

import java.time.Duration;
import java.util.Objects;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.klite.automation.AutomationContext;
import net.runelite.client.plugins.klite.automation.AutomationResult;
import net.runelite.client.plugins.klite.automation.AutomationTask;

/** Automation task which advances the web walker once per game tick. */
public final class WebWalkerTask implements AutomationTask
{
	public static final String TASK_NAME = "web-walk";
	private static final Duration STEP_TIMEOUT = Duration.ofSeconds(2);

	private final WebWalker walker;
	private final WorldPoint destination;
	private final int arrivalDistance;

	public WebWalkerTask(WebWalker walker, WorldPoint destination)
	{
		this(walker, destination, WebWalker.DEFAULT_ARRIVAL_DISTANCE);
	}

	public WebWalkerTask(WebWalker walker, WorldPoint destination, int arrivalDistance)
	{
		this.walker = Objects.requireNonNull(walker, "walker");
		this.destination = Objects.requireNonNull(destination, "destination");
		if (arrivalDistance < 0)
		{
			throw new IllegalArgumentException("Arrival distance cannot be negative");
		}
		this.arrivalDistance = arrivalDistance;
	}

	@Override
	public String name()
	{
		return TASK_NAME;
	}

	@Override
	public Duration interval()
	{
		return Duration.ofMillis(600L);
	}

	@Override
	public AutomationResult tick(AutomationContext context) throws Exception
	{
		WebWalkResult result = context.await(walker.step(destination, arrivalDistance), STEP_TIMEOUT);
		switch (result.getState())
		{
			case ARRIVED:
			case NOT_LOGGED_IN:
				return AutomationResult.STOP;
			case NO_PATH:
				throw new IllegalStateException(result.getMessage());
			default:
				return AutomationResult.CONTINUE;
		}
	}

	@Override
	public void onStop(AutomationContext context)
	{
		walker.clear();
	}
}
