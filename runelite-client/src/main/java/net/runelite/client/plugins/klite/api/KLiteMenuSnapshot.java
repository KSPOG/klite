/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.util.List;
import lombok.Value;

/** Immutable view of the current client menu and its entries. */
@Value
public class KLiteMenuSnapshot
{
	boolean open;
	boolean scrollable;
	int scroll;
	int x;
	int y;
	int width;
	int height;
	List<KLiteMenuEntrySnapshot> entries;
}
