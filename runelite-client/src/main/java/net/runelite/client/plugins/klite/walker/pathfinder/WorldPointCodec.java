/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.walker.pathfinder;

import net.runelite.api.coords.WorldPoint;

final class WorldPointCodec
{
	private WorldPointCodec()
	{
	}

	static int pack(WorldPoint point)
	{
		return pack(point.getX(), point.getY(), point.getPlane());
	}

	static int pack(int x, int y, int plane)
	{
		return (x & 0x7FFF) | ((y & 0x7FFF) << 15) | ((plane & 0x3) << 30);
	}

	static int x(int packed)
	{
		return packed & 0x7FFF;
	}

	static int y(int packed)
	{
		return (packed >> 15) & 0x7FFF;
	}

	static int plane(int packed)
	{
		return (packed >> 30) & 0x3;
	}

	static WorldPoint unpack(int packed)
	{
		return new WorldPoint(x(packed), y(packed), plane(packed));
	}

	static int distance(int first, int second)
	{
		if (plane(first) != plane(second))
		{
			return Integer.MAX_VALUE;
		}
		return Math.max(Math.abs(x(first) - x(second)), Math.abs(y(first) - y(second)));
	}

	static long distanceSquared(int first, int second)
	{
		if (plane(first) != plane(second))
		{
			return Long.MAX_VALUE;
		}
		long dx = x(first) - x(second);
		long dy = y(first) - y(second);
		return dx * dx + dy * dy;
	}
}
