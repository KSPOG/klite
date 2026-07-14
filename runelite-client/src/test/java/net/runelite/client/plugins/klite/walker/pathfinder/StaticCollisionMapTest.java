/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.walker.pathfinder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import net.runelite.api.coords.WorldPoint;
import org.junit.Test;

public class StaticCollisionMapTest
{
	@Test(timeout = 15_000L)
	public void findsPublishedCollisionMapRoute()
	{
		WorldPoint lumbridge = new WorldPoint(3222, 3218, 0);
		WorldPoint grandExchange = new WorldPoint(3165, 3484, 0);
		GroundPathfinder pathfinder = new GroundPathfinder(new StaticCollisionMap());

		PathSearchResult result = pathfinder.find(lumbridge, grandExchange);

		assertTrue(result.isReached());
		assertEquals(lumbridge, result.getPath().get(0));
		assertEquals(grandExchange, result.getPath().get(result.getPath().size() - 1));
	}
}
