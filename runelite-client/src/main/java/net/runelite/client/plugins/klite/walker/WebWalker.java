/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.walker;

import java.util.concurrent.CompletableFuture;
import net.runelite.api.coords.WorldPoint;

/** Stateful, non-blocking global ground walker. */
public interface WebWalker
{
	int DEFAULT_ARRIVAL_DISTANCE = 1;

	CompletableFuture<WebWalkResult> step(WorldPoint destination);

	CompletableFuture<WebWalkResult> step(WorldPoint destination, int arrivalDistance);

	CompletableFuture<Void> clear();

	WebWalkResult status();
}
