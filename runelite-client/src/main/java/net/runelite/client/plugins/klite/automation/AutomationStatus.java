/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.automation;

import javax.annotation.Nullable;
import lombok.Value;

@Value
public class AutomationStatus
{
	AutomationState state;
	@Nullable
	String taskName;
	@Nullable
	String failureMessage;
	long startedAtMillis;
}
