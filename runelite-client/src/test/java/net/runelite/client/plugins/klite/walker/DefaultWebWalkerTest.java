/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.walker;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import net.runelite.api.coords.WorldPoint;
import org.junit.Test;

public class DefaultWebWalkerTest
{
	@Test
	public void selectsFarthestTileWithinClickRange()
	{
		List<WorldPoint> path = new ArrayList<>();
		for (int x = 3200; x <= 3220; x++)
		{
			path.add(new WorldPoint(x, 3200, 0));
		}

		WorldPoint selected = DefaultWebWalker.selectLookAhead(
			path, 0, new WorldPoint(3200, 3200, 0));

		assertEquals(new WorldPoint(3215, 3200, 0), selected);
	}

	@Test
	public void advancesClosestIndexWithoutRestartingPath()
	{
		List<WorldPoint> path = new ArrayList<>();
		for (int x = 0; x < 20; x++)
		{
			path.add(new WorldPoint(x, 0, 0));
		}

		int index = DefaultWebWalker.closestPathIndex(path, new WorldPoint(14, 0, 0), 10);

		assertEquals(14, index);
	}
}
