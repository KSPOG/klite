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
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuAction;
import net.runelite.api.Player;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.klite.api.KLiteThreadGateway;
import net.runelite.client.plugins.klite.debug.KLiteClientLogBuffer;
import net.runelite.client.plugins.klite.walker.pathfinder.PathSearchResult;
import net.runelite.client.plugins.klite.walker.pathfinder.ShortestPathRoutePlanner;

/**
 * KLite web walker backed by the bundled Shortest Path route planner.
 *
 * <p>The planner supplies a complete ordered route. Movement advances through
 * that route monotonically and dispatches one adjacent route tile at a time.
 * This deliberately avoids skipping across walls, corners, doors, or a later
 * section of a route which happens to pass nearby.</p>
 */
@Singleton
public class DefaultWebWalker implements WebWalker
{
	private static final String LOG_SOURCE = "WebWalker";
	private static final int MAX_CLICK_DISTANCE = 2;
	private static final int ROUTE_CLICK_STEPS = 1;
	private static final int ROUTE_PROGRESS_WINDOW = 8;
	private static final int REPLAN_DISTANCE = 4;
	private static final long MOVEMENT_RETRY_MILLIS = 1_200L;
	private static final long STALL_TIMEOUT_MILLIS = 8_000L;

	private final Client client;
	private final KLiteThreadGateway threadGateway;
	private final ShortestPathRoutePlanner pathfinder;
	private final WebWalkBankCache bankCache;
	private final KLiteClientLogBuffer diagnostics;
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
	private long lastClickAt;

	@Inject
	DefaultWebWalker(Client client, KLiteThreadGateway threadGateway,
		ShortestPathRoutePlanner pathfinder, WebWalkBankCache bankCache,
		KLiteClientLogBuffer diagnostics)
	{
		this(client, threadGateway, pathfinder, bankCache, diagnostics,
			Executors.newSingleThreadExecutor(new ThreadFactoryBuilder()
				.setDaemon(true)
				.setNameFormat("klite-shortest-path-%d")
				.build()));
	}

	DefaultWebWalker(Client client, KLiteThreadGateway threadGateway,
		ShortestPathRoutePlanner pathfinder, WebWalkBankCache bankCache,
		KLiteClientLogBuffer diagnostics, ExecutorService pathExecutor)
	{
		this.client = client;
		this.threadGateway = threadGateway;
		this.pathfinder = pathfinder;
		this.bankCache = bankCache;
		this.diagnostics = diagnostics;
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
			if (destination != null)
			{
				diagnostics.info(LOG_SOURCE, "Arrived within " + requestedArrivalDistance
					+ " tile(s) of " + formatPoint(requestedDestination)
					+ " at " + formatPoint(current) + '.');
			}
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
			diagnostics.info(LOG_SOURCE, "New destination " + formatPoint(destination)
				+ " with arrivalDistance=" + arrivalDistance
				+ " from " + formatPoint(current) + '.');
		}

		if (clickTarget != null && now - lastProgressAt >= STALL_TIMEOUT_MILLIS)
		{
			diagnostics.warn(LOG_SOURCE, "Movement stalled at " + formatPoint(current)
				+ " while targeting " + formatPoint(clickTarget)
				+ ", localDestination=" + formatLocalPoint(client.getLocalDestinationLocation())
				+ ", routeIndex=" + pathIndex + '/' + path.size()
				+ ". Recalculating from the current tile.");
			clearPlan();
			destination = requestedDestination;
			arrivalDistance = requestedArrivalDistance;
			lastProgressAt = now;
		}

		if (shouldWaitForCurrentMovement(current, now))
		{
			return update(WebWalkState.MOVING, destination, clickTarget, path.size(),
				followingMessage());
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
			diagnostics.warn(LOG_SOURCE, "Player at " + formatPoint(current)
				+ " is no longer near route index " + pathIndex + '/' + path.size()
				+ ". Recalculating.");
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
			diagnostics.warn(LOG_SOURCE, "No adjacent route tile could be dispatched from "
				+ formatPoint(current) + " at route index " + pathIndex + '/' + path.size()
				+ ". Recalculating.");
			clearPlan();
			destination = requestedDestination;
			arrivalDistance = requestedArrivalDistance;
			requestPath(current, requestedDestination, requestedArrivalDistance);
			return update(WebWalkState.PATHFINDING, destination, null, 0,
				"No adjacent Shortest Path route tile is currently clickable; replanning");
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
			diagnostics.debug(LOG_SOURCE, "Accepted route length=" + path.size()
				+ ", visited=" + result.getVisitedTiles()
				+ ", elapsed=" + result.getElapsedMillis() + "ms, tiles="
				+ summarizeRoute(path) + '.');
			return true;
		}
		catch (CompletionException exception)
		{
			Throwable cause = exception.getCause() == null ? exception : exception.getCause();
			diagnostics.error(LOG_SOURCE, "Shortest Path calculation failed", cause);
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
			if (!candidate.equals(current) && walk(candidate, current, targetIndex, route.size()))
			{
				return candidate;
			}
			targetIndex--;
		}
		return null;
	}

	private boolean walk(WorldPoint target, WorldPoint current, int targetIndex, int routeSize)
	{
		if (client.getTopLevelWorldView() == null)
		{
			diagnostics.warn(LOG_SOURCE, "Cannot dispatch " + formatPoint(target)
				+ " because no top-level world view is available.");
			return false;
		}
		if (target.getPlane() != client.getTopLevelWorldView().getPlane()
			|| !WorldPoint.isInScene(client.getTopLevelWorldView(), target.getX(), target.getY()))
		{
			diagnostics.warn(LOG_SOURCE, "Route tile " + formatPoint(target)
				+ " is outside the currently loaded scene or on another plane.");
			return false;
		}
		LocalPoint local = LocalPoint.fromWorld(client.getTopLevelWorldView(), target.getX(), target.getY());
		if (local == null)
		{
			diagnostics.warn(LOG_SOURCE, "Unable to convert route tile " + formatPoint(target)
				+ " to a local scene point.");
			return false;
		}

		diagnostics.debug(LOG_SOURCE, "Dispatching adjacent route tile " + targetIndex + '/'
			+ routeSize + ": current=" + formatPoint(current)
			+ ", target=" + formatPoint(target)
			+ ", scene=" + local.getSceneX() + ',' + local.getSceneY()
			+ ", previousLocalDestination=" + formatLocalPoint(client.getLocalDestinationLocation()) + '.');
		client.menuAction(local.getSceneX(), local.getSceneY(), MenuAction.WALK,
			0, -1, "Walk here", "");
		clickTarget = target;
		lastClickAt = System.currentTimeMillis();
		return true;
	}

	private boolean shouldWaitForCurrentMovement(WorldPoint current, long now)
	{
		return client.getLocalDestinationLocation() != null && clickTarget != null
			&& !current.equals(clickTarget)
			&& now - lastClickAt < MOVEMENT_RETRY_MILLIS;
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

	/** Selects only the next adjacent route point. */
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
			: "Following Shortest Path route " + Math.min(pathIndex + 1, path.size()) + '/' + path.size();
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
		lastClickAt = 0L;
	}

	private static String formatPoint(@Nullable WorldPoint point)
	{
		return point == null ? "none"
			: point.getX() + "," + point.getY() + "," + point.getPlane();
	}

	private static String formatLocalPoint(@Nullable LocalPoint point)
	{
		return point == null ? "none" : point.getSceneX() + "," + point.getSceneY();
	}

	private static String summarizeRoute(List<WorldPoint> route)
	{
		StringBuilder summary = new StringBuilder();
		int head = Math.min(route.size(), 12);
		for (int index = 0; index < head; index++)
		{
			if (summary.length() > 0)
			{
				summary.append(" -> ");
			}
			summary.append(formatPoint(route.get(index)));
		}
		if (route.size() > head)
		{
			summary.append(" -> ... -> ");
			int tailStart = Math.max(head, route.size() - 4);
			for (int index = tailStart; index < route.size(); index++)
			{
				if (index > tailStart)
				{
					summary.append(" -> ");
				}
				summary.append(formatPoint(route.get(index)));
			}
		}
		return summary.toString();
	}
}
