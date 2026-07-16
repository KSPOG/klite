/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.util.Optional;
import lombok.Value;

/** Immutable floating-point camera, focus, and shake state. */
@Value
public class KLiteAdvancedCameraSnapshot
{
	float x;
	float y;
	float z;
	float pitch;
	float yaw;
	boolean shakeDisabled;
	Optional<KLiteCameraFocusSnapshot> focus;
}
