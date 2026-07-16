/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import lombok.Value;
import net.runelite.api.Point;

/** Immutable view of the current world-map position and zoom. */
@Value
public class KLiteWorldMapSnapshot
{
	Point position;
	float zoom;
}
