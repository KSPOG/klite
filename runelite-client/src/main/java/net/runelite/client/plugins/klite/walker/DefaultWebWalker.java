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
import net.runelite.client.plugins.klite.walker.pathfinder.GroundPathfinder;
import net.runelite.client.plugins.klite.walker.pathfinder.PathSearchResult;

/**
 * Cached-plan walker which advances one action per call. The control flow mirrors
 * TwiLite's public Navigation.step contract while using KLite-owned code.
 */
@Singleton
@Slf4j
public class DefaultWebWalker implements WebWalker
{
	private static final int MAX_CLICK_DISTANCE = 15;
	private static final int REPLAN_DISTANCE = 4;
	private static final int MOVEMENT_RECLICK_DISTANCE = 4;
	private static final long STALL_TIMEOUT_MILLIS = 8_000L;

	private final Client client;
	private final KLiteThreadGateway threadGateway;
	private final GroundPathfinder pathfinder;
	private final WebWalkBankCache bankCache;
	private final ExecutorService pathExecutor;
	@Nullable
	private final ShortestPathBridge shortestPathBridge;

	private volatile WebWalkResult status = new WebWalkResult(
		WebWalkState.IDLE, null, null, 0, null);
	@Nullable
	private WorldPoint destination;
	private int arrivalDistance;
	private List<WorldPoint> path = ImmutableList.of();
	private int pathIndex;
	@Nullable
	private CompletableFuture<PathSearchResult> pendingPath;
	private boolean shortestPathPending;
	@Nullable
	private WorldPoint clickTarget;
	@Nullable
	private WorldPoint lastLocation;
	private long lastProgressAt;

	@Inject
	DefaultWebWalker(Client client, KLiteThreadGateway threadGateway, GroundPathfinder pathfinder,
		WebWalkBankCache bankCache, ShortestPathBridge shortestPathBridge)
	{
		this(client, threadGateway, pathfinder, bankCache, Executors.newSingleThreadExecutor(
			new ThreadFactoryBuilder().setDaemon(true).setNameFormat("klite-pathfinder-%d").build()),
			shortestPathBridge);
	}

	DefaultWebWalker(Client client, KLiteThreadGateway threadGateway,
		GroundPathfinder pathfinder, WebWalkBankCache bankCache, ExecutorService pathExecutor)
	{
		this(client, threadGateway, pathfinder, bankCache, pathExecutor, null);
	}

	DefaultWebWalker(Client client, KLiteThreadGateway threadGateway,
		GroundPathfinder pathfinder, WebWalkBankCache bankCache, ExecutorService pathExecutor,
		@Nullable ShortestPathBridge shortestPathBridge)
	{
		this.client = client;
		this.threadGateway = threadGateway;
		this.pathfinder = pathfinder;
		this.bankCache = bankCache;
		this.pathExecutor = pathExecutor;
		this.shortestPathBridge = shortestPathBridge;
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
			return update(WebWalkState.MOVING, destination, clickTarget, path.size(), null);
		}

		if (now - lastProgressAt >= STALL_TIMEOUT_MILLIS)
		{
			log.debug("KLite web walker replanning after a movement stall at {}", current);
			clearPlan();
			destination = requestedDestination;
			arrivalDistance = requestedArrivalDistance;
			lastProgressAt = now;
		}

		// Exact destinations can be clicked directly. Radius-based destinations are
		// routed through Shortest Path or the internal pathfinder so a blocked center
		// tile is never selected.
		if (requestedArrivalDistance == 0 && path.isEmpty() && pendingPath == null
			&& !shortestPathPending && directWalk(current, requestedDestination))
		{
			return update(WebWalkState.MOVING, destination, clickTarget, 0, null);
		}

		if (pendingPath == null && !shortestPathPending && path.isEmpty())
		{
			requestPath(current, requestedDestination, requestedArrivalDistance);
			return update(WebWalkState.PATHFINDING, destination, null, 0,
				shortestPathPending ? "Waiting for the Shortest Path route" : "Calculating KLite ground route");
		}

		if (shortestPathPending)
		{
			ShortestPathBridge.RouteSnapshot route = shortestPathBridge.poll();
			switch (route.getState())
			{
				case CALCULATING:
					return update(WebWalkState.PATHFINDING, destination, null, 0,
						"Waiting for the Shortest Path route");
				case READY:
					path = route.getPath();
					pathIndex = 0;
					shortestPathPending = false;
					log.debug("Using Shortest Path route with {} tiles", path.size());
					break;
				case UNAVAILABLE:
				case FAILED:
					shortestPathPending = false;
					log.debug("Shortest Path route unavailable: {}", route.getMessage());
					requestInternalPath(current, requestedDestination, requestedArrivalDistance);
					return update(WebWalkState.PATHFINDING, destination, null, 0,
						route.getMessage() + "; calculating KLite ground route");
				default:
					throw new IllegalStateException("Unhandled Shortest Path state " + route.getState());
			}
		}

		if (pendingPath != null)
		{
			if (!pendingPath.isDone())
			{
				return update(WebWalkState.PATHFINDING, destination, null, 0,
					"Calculating KLite ground route");
			}
			if (!acceptPendingPath())
			{
				return status;
			}
		}

		int closest = closestPathIndex(path, current, pathIndex);
		if (closest < 0 || current.distanceTo(path.get(closest)) > REPLAN_DISTANCE)
		{
			clearPlan();
			destination = requestedDestination;
			arrivalDistance = requestedArrivalDistance;
			requestPath(current, requestedDestination, requestedArrivalDistance);
			return update(WebWalkState.PATHFINDING, destination, null, 0,
				"Player moved away from the cached path");
		}
		pathIndex = closest;

		WorldPoint next = selectLookAhead(path, pathIndex, current);
		if (next == null || !walk(next))
		{
			clearPlan();
			destination = requestedDestination;
			arrivalDistance = requestedArrivalDistance;
			return update(WebWalkState.NO_PATH, destination, null, path.size(),
				"No loaded path tile could be selected");
		}
		return update(WebWalkState.MOVING, destination, clickTarget, path.size(), null);
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
					"No ground-only route was found after visiting " + result.getVisitedTiles() + " tiles");
				return false;
			}
			path = result.getPath();
			pathIndex = 0;
			log.debug("KLite path found: {} tiles, {} visited, {}ms",
				path.size(), result.getVisitedTiles(), result.getElapsedMillis());
			return true;
		}
		catch (CompletionException exception)
		{
			log.warn("KLite path calculation failed", exception.getCause());
			update(WebWalkState.NO_PATH, destination, null, 0,
				"Path calculation failed: " + exception.getCause().getClass().getSimpleName());
			return false;
		}
	}

	private void requestPath(WorldPoint start, WorldPoint target, int requestedArrivalDistance)
	{
		if (shortestPathBridge != null
			&& shortestPathBridge.request(start, target, requestedArrivalDistance))
		{
			shortestPathPending = true;
			return;
		}
		requestInternalPath(start, target, requestedArrivalDistance);
	}

	private void requestInternalPath(WorldPoint start, WorldPoint target, int requestedArrivalDistance)
	{
		pendingPath = CompletableFuture.supplyAsync(
			() -> pathfinder.find(start, target, requestedArrivalDistance), pathExecutor);
	}

	private boolean directWalk(WorldPoint current, WorldPoint target)
	{
		return current.getPlane() == target.getPlane()
			&& current.distanceTo(target) <= MAX_CLICK_DISTANCE
			&& WorldPoint.isInScene(client.getTopLevelWorldView(), target.getX(), target.getY())
			&& walk(target);
	}

	private boolean walk(WorldPoint target)
	{
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

	static int closestPathIndex(List<WorldPoint> path, WorldPoint current, int previousIndex)
	{
		if (path.isEmpty())
		{
			return -1;
		}
		int from = Math.max(0, previousIndex - 8);
		int to = Math.min(path.size(), previousIndex + 256);
		int closest = from;
		int distance = Integer.MAX_VALUE;
		for (int i = from; i < to; i++)
		{
			int candidateDistance = current.distanceTo(path.get(i));
			if (candidateDistance < distance)
			{
				distance = candidateDistance;
				closest = i;
			}
		}
		return closest;
	}

	@Nullable
	static WorldPoint selectLookAhead(List<WorldPoint> path, int fromIndex, WorldPoint current)
	{
		WorldPoint selected = null;
		for (int i = Math.max(0, fromIndex); i < path.size(); i++)
		{
			WorldPoint candidate = path.get(i);
			if (candidate.getPlane() != current.getPlane()
				|| current.distanceTo(candidate) > MAX_CLICK_DISTANCE)
			{
				break;
			}
			selected = candidate;
		}
		return selected;
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
		if (shortestPathBridge != null)
		{
			shortestPathBridge.clear();
		}
		shortestPathPending = false;
		path = ImmutableList.of();
		pathIndex = 0;
		clickTarget = null;
	}
}
