/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import javax.annotation.Nullable;
import lombok.Value;
import net.runelite.api.coords.WorldPoint;

/** Immutable non-player-character snapshot safe to use off the client thread. */
@Value
public class KLiteNpcSnapshot
{
	int id;
	int index;
	@Nullable
	String name;
	int combatLevel;
	WorldPoint location;
	int animation;
	int poseAnimation;
	int healthRatio;
	int healthScale;
	@Nullable
	String interactingName;
}
