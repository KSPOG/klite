/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import lombok.Value;

/** Immutable view of free-camera mode and its focal point. */
@Value
public class KLiteFreeCameraSnapshot
{
	KLiteCameraMode mode;
	int modeId;
	float focalPointX;
	float focalPointY;
	float focalPointZ;
}
