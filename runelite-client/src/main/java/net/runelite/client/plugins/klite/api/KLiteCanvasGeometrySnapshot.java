/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import lombok.Value;

/**
 * Immutable view of the logical game canvas and the live AWT canvas used for
 * virtual input dispatch.
 */
@Value
public class KLiteCanvasGeometrySnapshot
{
	int logicalWidth;
	int logicalHeight;
	int liveWidth;
	int liveHeight;
	int realWidth;
	int realHeight;
	int stretchedWidth;
	int stretchedHeight;
	boolean resized;
	boolean stretched;
	String mappingMode;
}
