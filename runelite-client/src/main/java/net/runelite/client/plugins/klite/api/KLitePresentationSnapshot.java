/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import lombok.Value;

/** Immutable primitive rendering and projection state. */
@Value
public class KLitePresentationSnapshot
{
	int skyboxColor;
	int draw2DMask;
	int zoom3d;
	int centerX;
	int centerY;
}
