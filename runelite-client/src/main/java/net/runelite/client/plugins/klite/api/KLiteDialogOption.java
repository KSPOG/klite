/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import lombok.Value;

/** Immutable dialogue option exposed by the current chat menu. */
@Value
public class KLiteDialogOption
{
	int index;
	String text;
}
