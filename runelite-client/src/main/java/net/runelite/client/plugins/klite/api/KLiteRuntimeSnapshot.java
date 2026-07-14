/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.util.List;
import javax.annotation.Nullable;
import lombok.Value;
import net.runelite.api.GameState;
import net.runelite.api.WorldType;

/** Immutable view of runtime and loaded-world state. */
@Value
public class KLiteRuntimeSnapshot
{
	GameState gameState;
	int world;
	@Nullable
	String worldHost;
	List<WorldType> worldTypes;
	int tickCount;
	int gameCycle;
	int fps;
	int plane;
	boolean instancedRegion;
	List<Integer> mapRegions;
	long capturedAtMillis;
}
