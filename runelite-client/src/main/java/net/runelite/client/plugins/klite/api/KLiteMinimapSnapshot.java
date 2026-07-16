/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import lombok.Value;

/** Immutable view of minimap zoom state and pixels-per-tile scale. */
@Value
public class KLiteMinimapSnapshot
{
	boolean zoomEnabled;
	double pixelsPerTile;
}
