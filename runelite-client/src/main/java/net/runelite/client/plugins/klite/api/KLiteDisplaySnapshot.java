/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import lombok.Value;

/** Immutable view of canvas, viewport, and stretching geometry. */
@Value
public class KLiteDisplaySnapshot
{
	int canvasWidth;
	int canvasHeight;
	int viewportX;
	int viewportY;
	int viewportWidth;
	int viewportHeight;
	int scale;
	boolean resized;
	boolean stretched;
	boolean stretchedFast;
	int stretchedWidth;
	int stretchedHeight;
	int realWidth;
	int realHeight;
}
