/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.walker;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuAction;
import net.runelite.api.Player;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.klite.api.KLiteThreadGateway;
import net.runelite.client.plugins.klite.walker.pathfinder.PathSearchResult;
import net.runelite.client.plugins.klite.walker.pathfinder.ShortestPathRoutePlanner;

/**
 * KLite web walker backed by the bundled Shortest Path route planner.
 *
 * <p>The planner supplies a complete ordered route. Movement advances through
 * that route monotonically and clicks only a small number of route steps ahead,
 * preventing turns and route crossings from being skipped.</p>
 */
@Singleton
@Slf4j
public class DefaultWebWalker implements WebWalker
{
	private static final int MAX_CLICK_DISTANCE = 8;
	private static final int ROUTE_CLICK_STEPS = 6;
	private static final int ROUTE_PROGRESS_WINDOW = 8;
	private static final int REPLAN_DISTANCE = 4;
	private static final int MOVEMENT_RECLICK_DISTANCE = 2;
	private static final long STALL_TIMEOUT_MILLIS = 8_000L;

	private final Client client;
	private final KLiteThreadGateway threadGateway;
	private final ShortestPathRoutePlanner pathfinder;
	private final WebWalkBankCache bankCache;
	private final ExecutorService pathExecutor;

	private volatile WebWalkResult status = new WebWalkResult(
		WebWalkState.IDLE, null, null, 0, null);
	@Nullable
	private WorldPoint destination;
	private int arrivalDistance;
	private List<WorldPoint> path = ImmutableList.of();
	private int pathIndex;
	@Nullable
	private CompletableFuture<PathSearchResult> pendingPath;
	@Nullable
	private WorldPoint clickTarget;
	@Nullable
	private WorldPoint lastLocation;
	private long lastProgressAt;

	@Inject
	DefaultWebWalker(Client client, KLiteThreadGateway threadGateway,
		ShortestPathRoutePlanner pathfinder, WebWalkBankCache bankCache)
	{
		this(client, threadGateway, pathfinder, bankCache, Executors.newSingleThreadExecutor(
			new ThreadFactoryBuilder().setDaemon(true).setNameFormat("klite-shortest-path-%d").build()));
	}

	DefaultWebWalker(Client client, KLiteThreadGateway threadGateway,
		ShortestPathRoutePlanner pathfinder, WebWalkBankCache bankCache, ExecutorService pathExecutor)
	{
		this.client = client;
		this.threadGateway = threadGateway;
		this.pathfinder = pathfinder;
		this.bankCache = bankCache;
		this.pathExecutor = pathExecutor;
	}

	@Override
	public CompletableFuture<WebWalkResult> step(WorldPoint destination)
	{
		return step(destination, DEFAULT_ARRIVAL_DISTANCE);
	}

	@Override
	public CompletableFuture<WebWalkResult> step(WorldPoint destination, int arrivalDistance)
	{
		Objects.requireNonNull(destination, "destination");
		if (arrivalDistance < 0)
		{
			throw new IllegalArgumentException("Arrival distance cannot be negative");
		}
		return threadGateway.submit(() -> advance(destination, arrivalDistance));
	}

	@Override
	public CompletableFuture<Void> clear()
	{
		return threadGateway.execute(this::clearOnClientThread);
	}

	@Override
	public WebWalkResult status()
	{
		return status;
	}

	@Override
	public WebWalkBankSnapshot bankSnapshot()
	{
		return bankCache.snapshot();
	}

	public void shutdown()
	{
		clearOnClientThread();
		pathExecutor.shutdownNow();
	}

	private WebWalkResult advance(WorldPoint requestedDestination, int requestedArrivalDistance)
	{
		Player player = client.getLocalPlayer();
		if (client.getGameState() != GameState.LOGGED_IN || player == null)
		{
			return update(WebWalkState.NOT_LOGGED_IN, requestedDestination, null, 0,
				"The local player is not logged in");
		}

		WorldPoint current = player.getWorldLocation();
		long now = System.currentTimeMillis();
		updateProgress(current, now);
		if (current.distanceTo(requestedDestination) <= requestedArrivalDistance)
		{
			clearPlan();
			return update(WebWalkState.ARRIVED, requestedDestination, null, 0, null);
		}

		if (!requestedDestination.equals(destination) || requestedArrivalDistance != arrivalDistance)
		{
			clearPlan();
			destination = requestedDestination;
			arrivalDistance = requestedArrivalDistance;
			lastLocation = current;
			lastProgressAt = now;
		}

		if (shouldWaitForCurrentMovement(current))
		{
			return update(WebWalkState.MOVING, destination, clickTarget, path.size(),
				followingMessage());
		}

		if (now - lastProgressAt >= STALL_TIMEOUT_MILLIS)
		{
			log.debug("KLite Shortest Path walker replanning after a movement stall at {}", current);
			clearPlan();
			destination = requestedDestination;
			arrivalDistance = requestedArrivalDistance;
			lastProgressAt = now;
		}

		if (pendingPath == null && path.isEmpty())
		{
			requestPath(current, requestedDestination, requestedArrivalDistance);
			return update(WebWalkState.PATHFINDING, destination, null, 0,
				"Calculating Shortest Path route");
		}

		if (pendingPath != null)
		{
			if (!pendingPath.isDone())
			{
				return update(WebWalkState.PATHFINDING, destination, null, 0,
					"Calculating Shortest Path route");
			}
			if (!acceptPendingPath())
			{
				return status;
			}
		}

		int advancedIndex = advancePathIndex(path, current, pathIndex);
		if (advancedIndex < 0)
		{
			clearPlan();
			destination = requestedDestination;
			arrivalDistance = requestedArrivalDistance;
			requestPath(current, requestedDestination, requestedArrivalDistance);
			return update(WebWalkState.PATHFINDING, destination, null, 0,
				"Player moved away from the Shortest Path route");
		}
		pathIndex = advancedIndex;

		WorldPoint next = walkNextRouteTile(path, pathIndex, current);
		if (next == null)
		{
			clearPlan();
			destination = requestedDestination;
			arrivalDistance = requestedArrivalDistance;
			requestPath(current, requestedDestination, requestedArrivalDistance);
			return update(WebWalkState.PATHFINDING, destination, null, 0,
				"No loaded Shortest Path route tile is currently clickable; replanning");
		}
		return update(WebWalkState.MOVING, destination, next, path.size(), followingMessage());
	}

	private boolean acceptPendingPath()
	{
		CompletableFuture<PathSearchResult> completed = pendingPath;
		pendingPath = null;
		try
		{
			PathSearchResult result = completed.join();
			if (!result.isReached() || result.getPath().isEmpty())
			{
				update(WebWalkState.NO_PATH, destination, null, result.getPath().size(),
					"Shortest Path did not find a route after visiting "
						+ result.getVisitedTiles() + " tiles");
				return false;
			}
			path = result.getPath();
			pathIndex = 0;
			log.debug("Shortest Path route found: {} tiles, {} visited, {}ms",
				path.size(), result.getVisitedTiles(), result.getElapsedMillis());
			return true;
		}
		catch (CompletionException exception)
		{
			Throwable cause = exception.getCause() == null ? exception : exception.getCause();
			log.warn("Shortest Path calculation failed", cause);
			update(WebWalkState.NO_PATH, destination, null, 0,
				"Shortest Path calculation failed: " + cause.getClass().getSimpleName());
			return false;
		}
	}

	private void requestPath(WorldPoint start, WorldPoint target, int requestedArrivalDistance)
	{
		pendingPath = CompletableFuture.supplyAsync(
			() -> pathfinder.find(start, target, requestedArrivalDistance), pathExecutor);
	}

	@Nullable
	private WorldPoint walkNextRouteTile(List<WorldPoint> route, int fromIndex, WorldPoint current)
	{
		int targetIndex = selectRouteTargetIndex(route, fromIndex, current);
		while (targetIndex >= fromIndex)
		{
			WorldPoint candidate = route.get(targetIndex);
			if (!candidate.equals(current) && walk(candidate))
			{
				return candidate;
			}
			targetIndex--;
		}
		return null;
	}

	private boolean walk(WorldPoint target)
	{
		if (target.getPlane() != client.getTopLevelWorldView().getPlane()
			|| !WorldPoint.isInScene(client.getTopLevelWorldView(), target.getX(), target.getY()))
		{
			return false;
		}
		LocalPoint local = LocalPoint.fromWorld(client.getTopLevelWorldView(), target.getX(), target.getY());
		if (local == null)
		{
			return false;
		}
		client.menuAction(local.getSceneX(), local.getSceneY(), MenuAction.WALK,
			0, -1, "Walk here", "");
		clickTarget = target;
		return true;
	}

	private boolean shouldWaitForCurrentMovement(WorldPoint current)
	{
		return client.getLocalDestinationLocation() != null && clickTarget != null
			&& current.distanceTo(clickTarget) > MOVEMENT_RECLICK_DISTANCE;
	}

	private void updateProgress(WorldPoint current, long now)
	{
		if (!current.equals(lastLocation))
		{
			lastLocation = current;
			lastProgressAt = now;
		}
	}

	/**
	 * Advances only inside a small forward window. This prevents a route which
	 * bends back near itself from jumping to a later crossing.
	 */
	static int advancePathIndex(List<WorldPoint> route, WorldPoint current, int previousIndex)
	{
		if (route.isEmpty())
		{
			return -1;
		}
		int base = Math.max(0, Math.min(previousIndex, route.size() - 1));
		int from = Math.max(0, base - 1);
		int to = Math.min(route.size(), base + ROUTE_PROGRESS_WINDOW + 1);
		int best = base;
		int bestDistance = current.distanceTo(route.get(base));
		for (int index = from; index < to; index++)
		{
			int distance = current.distanceTo(route.get(index));
			if (distance < bestDistance || distance == bestDistance && index > best)
			{
				best = index;
				bestDistance = distance;
			}
		}
		if (bestDistance > REPLAN_DISTANCE)
		{
			return -1;
		}
		return Math.max(base, best);
	}

	/** Selects a short, ordered look-ahead point which is always on the route. */
	static int selectRouteTargetIndex(List<WorldPoint> route, int fromIndex, WorldPoint current)
	{
		if (route.isEmpty())
		{
			return -1;
		}
		int start = Math.max(0, Math.min(fromIndex, route.size() - 1));
		int end = Math.min(route.size() - 1, start + ROUTE_CLICK_STEPS);
		for (int index = end; index >= start; index--)
		{
			WorldPoint candidate = route.get(index);
			if (candidate.getPlane() == current.getPlane()
				&& current.distanceTo(candidate) <= MAX_CLICK_DISTANCE)
			{
				return index;
			}
		}
		return -1;
	}

	private String followingMessage()
	{
		return path.isEmpty() ? "Following Shortest Path route"
			: "Following Shortest Path route " + Math.min(pathIndex + 1, path.size()) + "/" + path.size();
	}

	private WebWalkResult update(WebWalkState state, @Nullable WorldPoint target,
		@Nullable WorldPoint next, int length, @Nullable String message)
	{
		status = new WebWalkResult(state, target, next, length, message);
		return status;
	}

	private void clearOnClientThread()
	{
		clearPlan();
		destination = null;
		arrivalDistance = 0;
		lastLocation = null;
		lastProgressAt = 0L;
		update(WebWalkState.IDLE, null, null, 0, null);
	}

	private void clearPlan()
	{
		if (pendingPath != null)
		{
			pendingPath.cancel(false);
			pendingPath = null;
		}
		path = ImmutableList.of();
		pathIndex = 0;
		clickTarget = null;
	}
}
