/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.util.List;
import lombok.Value;

/** Immutable structural state for one client world view. */
@Value
public class KLiteWorldViewSnapshot
{
	int id;
	boolean topLevel;
	int plane;
	int baseX;
	int baseY;
	int sizeX;
	int sizeY;
	boolean instance;
	List<Integer> mapRegions;
}
