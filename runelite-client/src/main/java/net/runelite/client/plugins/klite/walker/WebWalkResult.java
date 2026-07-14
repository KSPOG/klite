/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.walker;

import javax.annotation.Nullable;
import lombok.Value;
import net.runelite.api.coords.WorldPoint;

@Value
public class WebWalkResult
{
	WebWalkState state;
	@Nullable
	WorldPoint destination;
	@Nullable
	WorldPoint clickTarget;
	int pathLength;
	@Nullable
	String message;
}
