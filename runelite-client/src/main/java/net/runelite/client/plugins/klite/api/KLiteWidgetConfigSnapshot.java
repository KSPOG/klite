/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import lombok.Value;

/** Immutable server-provided operation flags for a widget. */
@Value
public class KLiteWidgetConfigSnapshot
{
	int clickMask;
	int operationMask;
}
