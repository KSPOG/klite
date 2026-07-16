/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import javax.annotation.Nullable;
import lombok.Value;
import net.runelite.api.Point;

/** Immutable view of client input timing and pointer state. */
@Value
public class KLiteInputSnapshot
{
	@Nullable
	Point mousePosition;
	int mouseIdleTicks;
	long mouseLastPressedMillis;
	int keyboardIdleTicks;
}
