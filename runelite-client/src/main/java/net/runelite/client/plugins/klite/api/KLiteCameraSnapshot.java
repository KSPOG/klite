/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import lombok.Value;

/** Immutable view of the current and input-target camera state. */
@Value
public class KLiteCameraSnapshot
{
	int x;
	int y;
	int z;
	int pitch;
	int yaw;
	int targetPitch;
	int targetYaw;
}
