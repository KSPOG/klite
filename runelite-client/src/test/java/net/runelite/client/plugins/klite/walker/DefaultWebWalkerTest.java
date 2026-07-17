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
	public void selectsShortOrderedLookAheadOnRoute()
	{
		List<WorldPoint> path = new ArrayList<>();
		for (int x = 3200; x <= 3220; x++)
		{
			path.add(new WorldPoint(x, 3200, 0));
		}

		int selected = DefaultWebWalker.selectRouteTargetIndex(
			path, 0, new WorldPoint(3200, 3200, 0));

		assertEquals(6, selected);
		assertEquals(new WorldPoint(3206, 3200, 0), path.get(selected));
	}

	@Test
	public void advancesRouteCursorInsideForwardWindow()
	{
		List<WorldPoint> path = new ArrayList<>();
		for (int x = 0; x < 20; x++)
		{
			path.add(new WorldPoint(x, 0, 0));
		}

		int index = DefaultWebWalker.advancePathIndex(path, new WorldPoint(14, 0, 0), 10);

		assertEquals(14, index);
	}

	@Test
	public void doesNotJumpAcrossDistantRouteCrossing()
	{
		List<WorldPoint> path = new ArrayList<>();
		for (int x = 0; x <= 10; x++)
		{
			path.add(new WorldPoint(x, 0, 0));
		}
		for (int x = 10; x >= 0; x--)
		{
			path.add(new WorldPoint(x, 1, 0));
		}

		int index = DefaultWebWalker.advancePathIndex(path, new WorldPoint(2, 1, 0), 0);

		// The physically adjacent return leg is much later in the route and must not
		// be selected until the cursor has progressed through the outgoing leg.
		assertEquals(2, index);
	}
}
