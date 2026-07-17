/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 *
 * This implementation and its bundled collision-map format are adapted from
 * Skretzo's Shortest Path plugin and Microbot's maintained Shortest Path fork,
 * both distributed under the BSD 2-Clause License.
 */
package net.runelite.client.plugins.klite.walker.pathfinder;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.klite.debug.KLiteClientLogBuffer;

/**
 * KLite-owned Shortest Path planner.
 *
 * <p>The planner uses the collision map bundled with the web walker and an
 * octile A* search. It is the primary and unconditional route source for
 * {@code DefaultWebWalker}; no separately installed RuneLite plugin is needed.
 * Routes contain every adjacent ground tile in traversal order so movement can
 * follow and render the calculated route.</p>
 */
@Singleton
public final class ShortestPathRoutePlanner
{
	private static final String LOG_SOURCE = "WebWalker";
	private static final int[] DX = {-1, 1, 0, 0, -1, 1, -1, 1};
	private static final int[] DY = {0, 0, -1, 1, -1, -1, 1, 1};
	private static final int STRAIGHT_COST = 10;
	private static final int DIAGONAL_COST = 14;
	private static final long SEARCH_TIMEOUT_MILLIS = 10_000L;
	private static final int MAX_VISITED_TILES = 3_000_000;

	private final TraversalMap map;
	@Nullable
	private final KLiteClientLogBuffer diagnostics;
	private volatile List<WorldPoint> latestPath = ImmutableList.of();

	@Inject
	ShortestPathRoutePlanner(StaticCollisionMap map, KLiteClientLogBuffer diagnostics)
	{
		this.map = map;
		this.diagnostics = diagnostics;
	}

	ShortestPathRoutePlanner(TraversalMap map)
	{
		this.map = Objects.requireNonNull(map, "map");
		this.diagnostics = null;
	}

	/** Returns an immutable snapshot used by the integrated Shortest Path overlays. */
	public List<WorldPoint> pathSnapshot()
	{
		return latestPath;
	}

	public PathSearchResult find(WorldPoint start, WorldPoint destination)
	{
		return find(start, destination, 0);
	}

	/** Finds the shortest reachable route into the requested destination radius. */
	public PathSearchResult find(WorldPoint start, WorldPoint destination, int arrivalDistance)
	{
		Objects.requireNonNull(start, "start");
		Objects.requireNonNull(destination, "destination");
		if (arrivalDistance < 0)
		{
			throw new IllegalArgumentException("Arrival distance cannot be negative");
		}

		latestPath = ImmutableList.of();
		long startedAt = System.currentTimeMillis();
		debug("Route search started: start=" + formatPoint(start)
			+ ", destination=" + formatPoint(destination)
			+ ", arrivalDistance=" + arrivalDistance + '.');
		int startPacked = WorldPointCodec.pack(start);
		int destinationPacked = WorldPointCodec.pack(destination);
		if (start.getPlane() != destination.getPlane())
		{
			warn("Route rejected because the start and destination planes differ.");
			return result(false, ImmutableList.of(), 0, startedAt);
		}
		if (!map.contains(startPacked))
		{
			warn("Route rejected because the collision map does not contain the starting tile "
				+ formatPoint(start) + '.');
			return result(false, ImmutableList.of(), 0, startedAt);
		}
		if (withinArrivalDistance(startPacked, destinationPacked, arrivalDistance))
		{
			debug("The player is already inside the destination radius.");
			latestPath = ImmutableList.of(start);
			return result(true, latestPath, 1, startedAt);
		}

		PriorityQueue<SearchNode> boundary = new PriorityQueue<>();
		Map<Integer, Integer> costs = new HashMap<>();
		Map<Integer, Integer> parents = new HashMap<>();
		int initialHeuristic = heuristic(startPacked, destinationPacked, arrivalDistance);
		boundary.add(new SearchNode(startPacked, 0, initialHeuristic));
		costs.put(startPacked, 0);
		parents.put(startPacked, startPacked);

		int reached = -1;
		int visited = 0;
		long deadline = startedAt + SEARCH_TIMEOUT_MILLIS;
		while (!boundary.isEmpty() && visited < MAX_VISITED_TILES
			&& System.currentTimeMillis() <= deadline)
		{
			SearchNode current = boundary.poll();
			Integer currentBest = costs.get(current.point);
			if (currentBest == null || current.cost != currentBest)
			{
				continue;
			}
			visited++;
			if (withinArrivalDistance(current.point, destinationPacked, arrivalDistance))
			{
				reached = current.point;
				break;
			}

			int x = WorldPointCodec.x(current.point);
			int y = WorldPointCodec.y(current.point);
			int plane = WorldPointCodec.plane(current.point);
			for (int direction = 0; direction < DX.length; direction++)
			{
				if (!map.canMove(current.point, direction))
				{
					continue;
				}
				int neighbor = WorldPointCodec.pack(x + DX[direction], y + DY[direction], plane);
				if (!map.contains(neighbor))
				{
					continue;
				}

				int nextCost = current.cost + (direction < 4 ? STRAIGHT_COST : DIAGONAL_COST);
				Integer previousCost = costs.get(neighbor);
				if (previousCost != null && previousCost <= nextCost)
				{
					continue;
				}
				costs.put(neighbor, nextCost);
				parents.put(neighbor, current.point);
				int estimated = nextCost + heuristic(neighbor, destinationPacked, arrivalDistance);
				boundary.add(new SearchNode(neighbor, nextCost, estimated));
			}
		}

		long elapsed = Math.max(0L, System.currentTimeMillis() - startedAt);
		if (reached == -1)
		{
			String reason = System.currentTimeMillis() > deadline ? "search timed out"
				: visited >= MAX_VISITED_TILES ? "visited-tile limit reached"
				: "search boundary was exhausted";
			warn("No route found: " + reason + ", visited=" + visited
				+ ", elapsed=" + elapsed + "ms.");
			return result(false, ImmutableList.of(), visited, startedAt);
		}
		List<WorldPoint> route = reconstruct(parents, startPacked, reached);
		latestPath = ImmutableList.copyOf(route);
		debug("Route found: length=" + route.size() + ", visited=" + visited
			+ ", elapsed=" + elapsed + "ms, reached="
			+ formatPoint(route.get(route.size() - 1)) + '.');
		return result(true, latestPath, visited, startedAt);
	}

	private static int heuristic(int point, int destination, int arrivalDistance)
	{
		int dx = Math.max(0,
			Math.abs(WorldPointCodec.x(point) - WorldPointCodec.x(destination)) - arrivalDistance);
		int dy = Math.max(0,
			Math.abs(WorldPointCodec.y(point) - WorldPointCodec.y(destination)) - arrivalDistance);
		int diagonal = Math.min(dx, dy);
		int straight = Math.max(dx, dy) - diagonal;
		return diagonal * DIAGONAL_COST + straight * STRAIGHT_COST;
	}

	private static boolean withinArrivalDistance(int point, int destination, int arrivalDistance)
	{
		return WorldPointCodec.plane(point) == WorldPointCodec.plane(destination)
			&& Math.max(
				Math.abs(WorldPointCodec.x(point) - WorldPointCodec.x(destination)),
				Math.abs(WorldPointCodec.y(point) - WorldPointCodec.y(destination))) <= arrivalDistance;
	}

	private static List<WorldPoint> reconstruct(Map<Integer, Integer> parents, int start, int end)
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
			Integer parent = parents.get(current);
			if (parent == null)
			{
				throw new IllegalStateException("Shortest Path route has a missing parent tile");
			}
			current = parent;
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

	private void debug(String message)
	{
		if (diagnostics != null)
		{
			diagnostics.debug(LOG_SOURCE, message);
		}
	}

	private void warn(String message)
	{
		if (diagnostics != null)
		{
			diagnostics.warn(LOG_SOURCE, message);
		}
	}

	private static String formatPoint(WorldPoint point)
	{
		return point.getX() + "," + point.getY() + "," + point.getPlane();
	}

	private static final class SearchNode implements Comparable<SearchNode>
	{
		private final int point;
		private final int cost;
		private final int estimatedTotal;

		private SearchNode(int point, int cost, int estimatedTotal)
		{
			this.point = point;
			this.cost = cost;
			this.estimatedTotal = estimatedTotal;
		}

		@Override
		public int compareTo(SearchNode other)
		{
			int estimateComparison = Integer.compare(estimatedTotal, other.estimatedTotal);
			return estimateComparison != 0 ? estimateComparison : Integer.compare(cost, other.cost);
		}
	}
}
