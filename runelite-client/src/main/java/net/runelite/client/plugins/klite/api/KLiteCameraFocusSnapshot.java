/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import lombok.Value;

/** Immutable camera-focus location within a world view. */
@Value
public class KLiteCameraFocusSnapshot
{
	int worldViewId;
	int localX;
	int localY;
}
