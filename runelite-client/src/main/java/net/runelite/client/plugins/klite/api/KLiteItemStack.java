/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import lombok.Value;

/** Immutable inventory item snapshot. */
@Value
public class KLiteItemStack
{
	int slot;
	int itemId;
	int quantity;
}
