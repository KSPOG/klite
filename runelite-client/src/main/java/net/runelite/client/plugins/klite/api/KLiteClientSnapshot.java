/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import javax.annotation.Nullable;
import lombok.Value;
import net.runelite.api.GameState;
import net.runelite.api.coords.WorldPoint;

/** Immutable view of client state safe to use off the client thread. */
@Value
public class KLiteClientSnapshot
{
	GameState gameState;
	@Nullable
	WorldPoint playerLocation;
	int world;
	long capturedAtMillis;
}
