/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.automation;

import java.time.Duration;

/** One cooperative automation routine managed by {@link AutomationManager}. */
public interface AutomationTask
{
	String name();

	Duration interval();

	default void onStart(AutomationContext context) throws Exception
	{
	}

	AutomationResult tick(AutomationContext context) throws Exception;

	default void onStop(AutomationContext context)
	{
	}
}
