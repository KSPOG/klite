/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.util.List;
import lombok.Value;

/** Immutable copy of an arbitrary game item container. */
@Value
public class KLiteItemContainerSnapshot
{
	int id;
	int size;
	int filledSlots;
	List<KLiteItemStack> items;
}
