/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import lombok.Value;

/** Immutable widget operation, using RuneLite's one-based operation number. */
@Value
public class KLiteWidgetAction
{
	int operation;
	String option;
}
