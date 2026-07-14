/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import javax.annotation.Nullable;
import lombok.Value;
import net.runelite.api.coords.WorldPoint;

/** Immutable copy of an active projectile. */
@Value
public class KLiteProjectileSnapshot
{
	int id;
	int sourceLevel;
	@Nullable
	WorldPoint sourcePoint;
	@Nullable
	String sourceActor;
	int targetLevel;
	@Nullable
	WorldPoint targetPoint;
	@Nullable
	String targetActor;
	int endHeight;
	int startCycle;
	int endCycle;
	int remainingCycles;
	int slope;
	int startPosition;
	int startHeight;
	double x;
	double y;
	double z;
	int orientation;
	int animationFrame;
}
