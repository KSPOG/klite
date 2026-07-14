/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.walker.pathfinder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;
import net.runelite.api.coords.WorldPoint;
import org.junit.Test;

public class GroundPathfinderTest
{
	@Test
	public void findsShortestChebyshevPath()
	{
		GroundPathfinder pathfinder = new GroundPathfinder(new TestMap(0, 0, 10, 10));

		PathSearchResult result = pathfinder.find(point(1, 1), point(6, 4));

		assertTrue(result.isReached());
		assertEquals(6, result.getPath().size());
		assertEquals(point(1, 1), result.getPath().get(0));
		assertEquals(point(6, 4), result.getPath().get(result.getPath().size() - 1));
	}

	@Test
	public void routesAroundBlockedTiles()
	{
		TestMap map = new TestMap(0, 0, 8, 8);
		map.block(3, 1);
		map.block(3, 2);
		map.block(3, 3);
		GroundPathfinder pathfinder = new GroundPathfinder(map);

		PathSearchResult result = pathfinder.find(point(1, 2), point(5, 2));

		assertTrue(result.isReached());
		assertFalse(result.getPath().stream().anyMatch(map::isBlocked));
		assertTrue(result.getPath().size() > 5);
	}

	@Test
	public void rejectsDifferentPlanes()
	{
		GroundPathfinder pathfinder = new GroundPathfinder(new TestMap(0, 0, 10, 10));

		PathSearchResult result = pathfinder.find(point(1, 1), new WorldPoint(2, 2, 1));

		assertFalse(result.isReached());
		assertTrue(result.getPath().isEmpty());
	}

	private static WorldPoint point(int x, int y)
	{
		return new WorldPoint(x, y, 0);
	}

	private static final class TestMap implements TraversalMap
	{
		private static final int[] DX = {-1, 1, 0, 0, -1, 1, -1, 1};
		private static final int[] DY = {0, 0, -1, 1, -1, -1, 1, 1};

		private final int minX;
		private final int minY;
		private final int maxX;
		private final int maxY;
		private final Set<WorldPoint> blocked = new HashSet<>();

		private TestMap(int minX, int minY, int maxX, int maxY)
		{
			this.minX = minX;
			this.minY = minY;
			this.maxX = maxX;
			this.maxY = maxY;
		}

		private void block(int x, int y)
		{
			blocked.add(point(x, y));
		}

		private boolean isBlocked(WorldPoint point)
		{
			return blocked.contains(point);
		}

		@Override
		public boolean contains(int packedPoint)
		{
			int x = WorldPointCodec.x(packedPoint);
			int y = WorldPointCodec.y(packedPoint);
			return WorldPointCodec.plane(packedPoint) == 0
				&& x >= minX && x <= maxX && y >= minY && y <= maxY;
		}

		@Override
		public boolean canMove(int packedPoint, int direction)
		{
			int x = WorldPointCodec.x(packedPoint);
			int y = WorldPointCodec.y(packedPoint);
			WorldPoint target = point(x + DX[direction], y + DY[direction]);
			if (blocked.contains(target))
			{
				return false;
			}
			return direction < 4
				|| !blocked.contains(point(x + DX[direction], y))
				&& !blocked.contains(point(x, y + DY[direction]));
		}
	}
}
