/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import lombok.Value;
import net.runelite.api.coords.WorldPoint;

/** Immutable ground-item snapshot safe to use off the client thread. */
@Value
public class KLiteGroundItemSnapshot
{
	int itemId;
	int quantity;
	WorldPoint location;
	int visibleAtTick;
	int despawnsAtTick;
	int ownership;
	boolean privateItem;
}
