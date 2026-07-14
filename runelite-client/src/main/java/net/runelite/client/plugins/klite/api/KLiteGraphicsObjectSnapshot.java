/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import javax.annotation.Nullable;
import lombok.Value;
import net.runelite.api.coords.LocalPoint;

/** Immutable copy of an active graphics object. */
@Value
public class KLiteGraphicsObjectSnapshot
{
	int id;
	@Nullable
	LocalPoint location;
	int startCycle;
	int level;
	int z;
	boolean finished;
	int animationFrame;
}
