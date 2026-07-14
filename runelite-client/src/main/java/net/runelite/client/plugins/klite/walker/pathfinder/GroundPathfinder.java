/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.walker.pathfinder;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.coords.WorldPoint;

/** Walking-only BFS adapted to the movement rules in Shortest Path 1.20.6. */
@Singleton
public final class GroundPathfinder
{
	private static final int[] DX = {-1, 1, 0, 0, -1, 1, -1, 1};
	private static final int[] DY = {0, 0, -1, 1, -1, -1, 1, 1};
	private static final long NO_PROGRESS_CUTOFF_MILLIS = 3_000L;
	private static final int MAX_VISITED_TILES = 3_000_000;

	private final TraversalMap map;

	@Inject
	GroundPathfinder(StaticCollisionMap map)
	{
		this.map = map;
	}

	GroundPathfinder(TraversalMap map)
	{
		this.map = Objects.requireNonNull(map, "map");
	}

	public PathSearchResult find(WorldPoint start, WorldPoint destination)
	{
		Objects.requireNonNull(start, "start");
		Objects.requireNonNull(destination, "destination");
		long startedAt = System.currentTimeMillis();
		int startPacked = WorldPointCodec.pack(start);
		int destinationPacked = WorldPointCodec.pack(destination);
		if (start.getPlane() != destination.getPlane() || !map.contains(startPacked))
		{
			return result(false, ImmutableList.of(), 0, startedAt);
		}

		IntParents parents = new IntParents(1 << 16);
		IntQueue boundary = new IntQueue(1 << 15);
		parents.putIfAbsent(startPacked, startPacked);
		boundary.add(startPacked);
		int best = startPacked;
		long bestDistance = WorldPointCodec.distanceSquared(startPacked, destinationPacked);
		long cutoffAt = startedAt + NO_PROGRESS_CUTOFF_MILLIS;
		boolean reached = startPacked == destinationPacked;

		while (!reached && !boundary.isEmpty() && parents.size() < MAX_VISITED_TILES)
		{
			if (System.currentTimeMillis() > cutoffAt)
			{
				break;
			}

			int current = boundary.remove();
			int x = WorldPointCodec.x(current);
			int y = WorldPointCodec.y(current);
			int plane = WorldPointCodec.plane(current);
			for (int direction = 0; direction < DX.length; direction++)
			{
				if (!map.canMove(current, direction))
				{
					continue;
				}

				int neighbor = WorldPointCodec.pack(x + DX[direction], y + DY[direction], plane);
				if (!map.contains(neighbor) || !parents.putIfAbsent(neighbor, current))
				{
					continue;
				}

				boundary.add(neighbor);
				long distance = WorldPointCodec.distanceSquared(neighbor, destinationPacked);
				if (distance < bestDistance)
				{
					bestDistance = distance;
					best = neighbor;
					cutoffAt = System.currentTimeMillis() + NO_PROGRESS_CUTOFF_MILLIS;
				}
				if (neighbor == destinationPacked)
				{
					best = neighbor;
					reached = true;
					break;
				}
			}
		}

		List<WorldPoint> path = reconstruct(parents, startPacked, best);
		return result(reached, path, parents.size(), startedAt);
	}

	private static List<WorldPoint> reconstruct(IntParents parents, int start, int end)
	{
		List<WorldPoint> reverse = new ArrayList<>();
		int current = end;
		while (true)
		{
			reverse.add(WorldPointCodec.unpack(current));
			if (current == start)
			{
				break;
			}
			current = parents.get(current);
		}
		Collections.reverse(reverse);
		return ImmutableList.copyOf(reverse);
	}

	private static PathSearchResult result(boolean reached, List<WorldPoint> path,
		int visited, long startedAt)
	{
		return new PathSearchResult(reached, path, visited,
			Math.max(0L, System.currentTimeMillis() - startedAt));
	}

	private static final class IntQueue
	{
		private int[] values;
		private int head;
		private int tail;

		private IntQueue(int capacity)
		{
			values = new int[capacity];
		}

		private void add(int value)
		{
			if (tail == values.length)
			{
				int remaining = tail - head;
				int[] replacement = new int[Math.max(values.length << 1, remaining + 1)];
				System.arraycopy(values, head, replacement, 0, remaining);
				values = replacement;
				head = 0;
				tail = remaining;
			}
			values[tail++] = value;
		}

		private int remove()
		{
			return values[head++];
		}

		private boolean isEmpty()
		{
			return head == tail;
		}
	}

	private static final class IntParents
	{
		private int[] keys;
		private int[] values;
		private boolean[] used;
		private int size;

		private IntParents(int capacity)
		{
			int tableSize = 1;
			while (tableSize < capacity)
			{
				tableSize <<= 1;
			}
			keys = new int[tableSize];
			values = new int[tableSize];
			used = new boolean[tableSize];
		}

		private boolean putIfAbsent(int key, int value)
		{
			if ((size + 1) * 10 >= keys.length * 6)
			{
				resize();
			}
			int index = findIndex(key);
			if (used[index])
			{
				return false;
			}
			used[index] = true;
			keys[index] = key;
			values[index] = value;
			size++;
			return true;
		}

		private int get(int key)
		{
			int index = findIndex(key);
			if (!used[index])
			{
				throw new IllegalStateException("Missing path parent");
			}
			return values[index];
		}

		private int size()
		{
			return size;
		}

		private int findIndex(int key)
		{
			int mask = keys.length - 1;
			int index = mix(key) & mask;
			while (used[index] && keys[index] != key)
			{
				index = index + 1 & mask;
			}
			return index;
		}

		private void resize()
		{
			int[] oldKeys = keys;
			int[] oldValues = values;
			boolean[] oldUsed = used;
			keys = new int[oldKeys.length << 1];
			values = new int[keys.length];
			used = new boolean[keys.length];
			size = 0;
			for (int i = 0; i < oldKeys.length; i++)
			{
				if (oldUsed[i])
				{
					putIfAbsent(oldKeys[i], oldValues[i]);
				}
			}
		}

		private static int mix(int value)
		{
			value ^= value >>> 16;
			value *= 0x7FEB352D;
			value ^= value >>> 15;
			value *= 0x846CA68B;
			return value ^ value >>> 16;
		}
	}
}
