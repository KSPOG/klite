/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 *
 * The forward-waypoint/minimap walking strategy is adapted from Microbot's
 * Rs2Walker and Skretzo's Shortest Path project, distributed under BSD-2-Clause.
 */
package net.runelite.client.plugins.klite.walker;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
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
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.klite.api.KLiteThreadGateway;
import net.runelite.client.plugins.klite.debug.KLiteClientLogBuffer;
import net.runelite.client.plugins.klite.walker.pathfinder.PathSearchResult;
import net.runelite.client.plugins.klite.walker.pathfinder.ShortestPathRoutePlanner;

/**
 * KLite's integrated Shortest Path web walker.
 *
 * <p>It follows the planner's ordered route exclusively through sticky forward
 * minimap waypoints. A tile which cannot currently be projected onto the
 * minimap leaves the accepted route intact and is retried after a short delay.
 * It does not depend on the separately installed RuneLite Shortest Path
 * plugin.</p>
 */
@Singleton
public final class IntegratedShortestPathWebWalker implements WebWalker
{
	private static final String LOG_SOURCE = "WebWalker";
	private static final int WAYPOINT_ROUTE_STEPS = 10;
	private static final int MAX_WAYPOINT_DISTANCE = 12;
	private static final int ROUTE_PROGRESS_WINDOW = 24;
	private static final int MAX_ROUTE_DISTANCE = 4;
	private static final int WAYPOINT_CLOSE_DISTANCE = 2;
	private static final long CLICK_HOLD_MILLIS = 1_400L;
	private static final long PROGRESS_GRACE_MILLIS = 2_200L;
	private static final long RETARGET_MILLIS = 3_000L;
	private static final long STALL_TIMEOUT_MILLIS = 8_000L;
	private static final long WAYPOINT_PROJECTION_RETRY_MILLIS = 750L;

	private final Client client;
	private final KLiteThreadGateway threadGateway;
	private final ShortestPathRoutePlanner routePlanner;
	private final WebWalkBankCache bankCache;
	private final KLiteClientLogBuffer diagnostics;
	private final ExecutorService pathExecutor;

	private volatile WebWalkResult status = new WebWalkResult(
		WebWalkState.IDLE, null, null, 0, null);
	private volatile boolean clearRequested;
	@Nullable
	private WorldPoint destination;
	private int arrivalDistance;
	private List<WorldPoint> route = ImmutableList.of();
	private int routeIndex;
	@Nullable
	private CompletableFuture<PathSearchResult> pendingPath;
	@Nullable
	private WorldPoint waypoint;
	private int waypointIndex = -1;
	@Nullable
	private WorldPoint lastLocation;
	private long lastProgressAt;
	private long lastClickAt;
	private long nextProjectionAttemptAt;

	@Inject
	IntegratedShortestPathWebWalker(Client client, KLiteThreadGateway threadGateway,
		ShortestPathRoutePlanner routePlanner, WebWalkBankCache bankCache,
		KLiteClientLogBuffer diagnostics)
	{
		this.client = client;
		this.threadGateway = threadGateway;
		this.routePlanner = routePlanner;
		this.bankCache = bankCache;
		this.diagnostics = diagnostics;
		this.pathExecutor = Executors.newSingleThreadExecutor(new ThreadFactoryBuilder()
			.setDaemon(true)
			.setNameFormat("klite-integrated-shortest-path-%d")
			.build());
	}

	@Override
	public CompletableFuture<WebWalkResult> step(WorldPoint requestedDestination)
	{
		return step(requestedDestination, DEFAULT_ARRIVAL_DISTANCE);
	}

	@Override
	public CompletableFuture<WebWalkResult> step(WorldPoint requestedDestination,
		int requestedArrivalDistance)
	{
		Objects.requireNonNull(requestedDestination, "requestedDestination");
		if (requestedArrivalDistance < 0)
		{
			throw new IllegalArgumentException("Arrival distance cannot be negative");
		}
		clearRequested = false;
		return threadGateway.submit(() -> advance(requestedDestination, requestedArrivalDistance));
	}

	@Override
	public CompletableFuture<Void> clear()
	{
		clearRequested = true;
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
		clearRequested = true;
		clearOnClientThread();
		pathExecutor.shutdownNow();
	}

	private WebWalkResult advance(WorldPoint requestedDestination,
		int requestedArrivalDistance)
	{
		if (clearRequested)
		{
			return update(WebWalkState.IDLE, null, null, 0, null);
		}

		Player player = client.getLocalPlayer();
		if (client.getGameState() != GameState.LOGGED_IN || player == null)
		{
			return update(WebWalkState.NOT_LOGGED_IN, requestedDestination, null, 0,
				"The local player is not logged in");
		}

		WorldPoint current = player.getWorldLocation();
		long now = System.currentTimeMillis();
		if (current.distanceTo(requestedDestination) <= requestedArrivalDistance)
		{
			diagnostics.info(LOG_SOURCE, "Arrived within " + requestedArrivalDistance
				+ " tile(s) of " + formatPoint(requestedDestination)
				+ " at " + formatPoint(current) + '.');
			clearPlan();
			return update(WebWalkState.ARRIVED, requestedDestination, null, 0, null);
		}

		if (!requestedDestination.equals(destination)
			|| requestedArrivalDistance != arrivalDistance)
		{
			clearPlan();
			destination = requestedDestination;
			arrivalDistance = requestedArrivalDistance;
			lastLocation = current;
			lastProgressAt = now;
			diagnostics.info(LOG_SOURCE, "New integrated Shortest Path destination "
				+ formatPoint(destination) + " with arrivalDistance=" + arrivalDistance
				+ " from " + formatPoint(current) + '.');
		}

		updateProgress(current, now);
		if (pendingPath == null && route.isEmpty())
		{
			requestPath(current);
			return update(WebWalkState.PATHFINDING, destination, null, 0,
				"Calculating integrated Shortest Path route");
		}
		if (pendingPath != null)
		{
			if (!pendingPath.isDone())
			{
				return update(WebWalkState.PATHFINDING, destination, null, 0,
					"Calculating integrated Shortest Path route");
			}
			if (!acceptPendingPath())
			{
				return status;
			}
		}

		int nearestIndex = nearestRouteIndex(route, current, routeIndex);
		if (nearestIndex < 0)
		{
			diagnostics.warn(LOG_SOURCE, "Player at " + formatPoint(current)
				+ " moved away from the integrated Shortest Path route; replanning.");
			replan(current);
			return status;
		}
		if (nearestIndex != routeIndex)
		{
			diagnostics.debug(LOG_SOURCE, "Route progress " + routeIndex + " -> "
				+ nearestIndex + " at " + formatPoint(current) + '.');
			routeIndex = nearestIndex;
			nextProjectionAttemptAt = 0L;
		}

		if (waypoint != null)
		{
			boolean reachedWaypoint = routeIndex >= waypointIndex
				|| current.distanceTo(waypoint) <= WAYPOINT_CLOSE_DISTANCE;
			if (reachedWaypoint)
			{
				diagnostics.debug(LOG_SOURCE, "Reached forward waypoint "
					+ formatPoint(waypoint) + " at route index " + routeIndex + '.');
				waypoint = null;
				waypointIndex = -1;
				nextProjectionAttemptAt = 0L;
			}
			else if (now - lastProgressAt >= STALL_TIMEOUT_MILLIS)
			{
				diagnostics.warn(LOG_SOURCE, "Movement stalled at " + formatPoint(current)
					+ " while targeting forward waypoint " + formatPoint(waypoint)
					+ "; replanning.");
				replan(current);
				return status;
			}
			else if (now - lastClickAt < CLICK_HOLD_MILLIS
				|| now - lastProgressAt < PROGRESS_GRACE_MILLIS
				|| client.getLocalDestinationLocation() != null)
			{
				return update(WebWalkState.MOVING, destination, waypoint, route.size(),
					followingMessage());
			}
			else if (now - lastClickAt < RETARGET_MILLIS)
			{
				return update(WebWalkState.MOVING, destination, waypoint, route.size(),
					"Waiting for forward Shortest Path waypoint progress");
			}
			else
			{
				diagnostics.debug(LOG_SOURCE,
					"Forward waypoint produced no progress; selecting a fresh waypoint.");
				waypoint = null;
				waypointIndex = -1;
				nextProjectionAttemptAt = 0L;
			}
		}

		if (now < nextProjectionAttemptAt)
		{
			return update(WebWalkState.MOVING, destination, null, route.size(),
				"Waiting for a visible minimap waypoint");
		}

		WaypointSelection selection = selectForwardWaypoint(route, routeIndex, current);
		if (selection.projected != null)
		{
			dispatchWaypoint(selection.projected, current);
			return update(WebWalkState.MOVING, destination,
				selection.projected.target, route.size(), followingMessage());
		}

		nextProjectionAttemptAt = now + WAYPOINT_PROJECTION_RETRY_MILLIS;
		diagnostics.warn(LOG_SOURCE,
			"No forward Shortest Path waypoint is currently visible from "
				+ formatPoint(current) + "; keeping route length=" + route.size()
				+ " and retrying projection in " + WAYPOINT_PROJECTION_RETRY_MILLIS
				+ "ms. " + selection.failureSummary() + ' '
				+ canvasSummary());
		return update(WebWalkState.MOVING, destination, null, route.size(),
			"Waiting for a visible minimap waypoint");
	}

	private void requestPath(WorldPoint current)
	{
		pendingPath = CompletableFuture.supplyAsync(
			() -> routePlanner.find(current, destination, arrivalDistance), pathExecutor);
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
					"Integrated Shortest Path found no route after visiting "
						+ result.getVisitedTiles() + " tiles");
				return false;
			}
			route = ImmutableList.copyOf(result.getPath());
			routeIndex = 0;
			lastProgressAt = System.currentTimeMillis();
			nextProjectionAttemptAt = 0L;
			diagnostics.info(LOG_SOURCE, "Integrated Shortest Path accepted route length="
				+ route.size() + ", visited=" + result.getVisitedTiles()
				+ ", elapsed=" + result.getElapsedMillis() + "ms.");
			return true;
		}
		catch (CompletionException exception)
		{
			Throwable cause = exception.getCause() == null ? exception : exception.getCause();
			diagnostics.error(LOG_SOURCE, "Integrated Shortest Path calculation failed", cause);
			update(WebWalkState.NO_PATH, destination, null, 0,
				"Integrated Shortest Path failed: " + cause.getClass().getSimpleName());
			return false;
		}
	}

	private void replan(WorldPoint current)
	{
		clearPlan();
		lastLocation = current;
		lastProgressAt = System.currentTimeMillis();
		requestPath(current);
		update(WebWalkState.PATHFINDING, destination, null, 0,
			"Recalculating integrated Shortest Path route");
	}

	private void updateProgress(WorldPoint current, long now)
	{
		if (!current.equals(lastLocation))
		{
			lastLocation = current;
			lastProgressAt = now;
		}
	}

	private WaypointSelection selectForwardWaypoint(List<WorldPoint> path,
		int fromIndex, WorldPoint current)
	{
		WaypointSelection selection = new WaypointSelection();
		if (client.getTopLevelWorldView() == null)
		{
			selection.worldViewUnavailable = true;
			return selection;
		}

		int end = Math.min(path.size() - 1, fromIndex + WAYPOINT_ROUTE_STEPS);
		for (int index = end; index > fromIndex; index--)
		{
			WorldPoint candidate = path.get(index);
			if (candidate.getPlane() != current.getPlane()
				|| current.distanceTo(candidate) > MAX_WAYPOINT_DISTANCE)
			{
				continue;
			}

			selection.candidates++;
			LocalPoint local = LocalPoint.fromWorld(client.getTopLevelWorldView(),
				candidate.getX(), candidate.getY());
			if (local == null)
			{
				selection.localProjectionFailures++;
				continue;
			}

			Point minimap = Perspective.localToMinimap(client, local);
			if (minimap == null)
			{
				selection.minimapProjectionFailures++;
				continue;
			}

			Point dispatchPoint = scaleForDispatch(minimap);
			if (!insideCanvas(dispatchPoint))
			{
				selection.outsideCanvasFailures++;
				selection.lastRejectedPoint = dispatchPoint;
				continue;
			}

			selection.projected = new ProjectedWaypoint(
				candidate, index, minimap, dispatchPoint);
			return selection;
		}
		return selection;
	}

	private void dispatchWaypoint(ProjectedWaypoint projected, WorldPoint current)
	{
		diagnostics.debug(LOG_SOURCE, "Dispatching integrated Shortest Path waypoint "
			+ projected.index + '/' + route.size() + ": current=" + formatPoint(current)
			+ ", target=" + formatPoint(projected.target)
			+ ", surface=minimap, projected="
			+ projected.minimapPoint.getX() + ',' + projected.minimapPoint.getY()
			+ ", dispatch=" + projected.dispatchPoint.getX() + ','
			+ projected.dispatchPoint.getY() + ", " + canvasSummary());
		EventQueue.invokeLater(() ->
		{
			if (!clearRequested)
			{
				dispatchMinimapClick(projected.dispatchPoint);
			}
		});
		waypoint = projected.target;
		waypointIndex = projected.index;
		lastClickAt = System.currentTimeMillis();
		nextProjectionAttemptAt = 0L;
	}

	private Point scaleForDispatch(Point point)
	{
		if (!client.isStretchedEnabled())
		{
			return point;
		}
		Dimension stretched = client.getStretchedDimensions();
		Dimension real = client.getRealDimensions();
		if (stretched == null || real == null || real.width <= 0 || real.height <= 0)
		{
			return point;
		}
		return new Point(
			(int) ((long) point.getX() * stretched.width / real.width),
			(int) ((long) point.getY() * stretched.height / real.height));
	}

	private boolean insideCanvas(Point point)
	{
		Canvas canvas = client.getCanvas();
		return canvas != null
			&& isInsideCanvas(point, canvas.getWidth(), canvas.getHeight());
	}

	static boolean isInsideCanvas(Point point, int canvasWidth, int canvasHeight)
	{
		return point != null
			&& canvasWidth > 0
			&& canvasHeight > 0
			&& point.getX() >= 0
			&& point.getY() >= 0
			&& point.getX() < canvasWidth
			&& point.getY() < canvasHeight;
	}

	private String canvasSummary()
	{
		Canvas canvas = client.getCanvas();
		int width = canvas == null ? 0 : canvas.getWidth();
		int height = canvas == null ? 0 : canvas.getHeight();
		return "canvas=" + width + 'x' + height
			+ ", clientCanvas=" + client.getCanvasWidth() + 'x' + client.getCanvasHeight()
			+ ", resized=" + client.isResized()
			+ ", stretched=" + client.isStretchedEnabled();
	}

	private void dispatchMinimapClick(Point point)
	{
		Canvas canvas = client.getCanvas();
		if (canvas == null || !isInsideCanvas(point, canvas.getWidth(), canvas.getHeight()))
		{
			diagnostics.warn(LOG_SOURCE,
				"Skipped minimap click because the live canvas changed before dispatch: point="
					+ point.getX() + ',' + point.getY() + ", " + canvasSummary());
			return;
		}
		dispatchMouse(canvas, MouseEvent.MOUSE_ENTERED, point, MouseEvent.NOBUTTON, 0);
		dispatchMouse(canvas, MouseEvent.MOUSE_MOVED, point, MouseEvent.NOBUTTON, 0);
		dispatchMouse(canvas, MouseEvent.MOUSE_PRESSED, point, MouseEvent.BUTTON1, 1);
		dispatchMouse(canvas, MouseEvent.MOUSE_RELEASED, point, MouseEvent.BUTTON1, 1);
		dispatchMouse(canvas, MouseEvent.MOUSE_CLICKED, point, MouseEvent.BUTTON1, 1);
	}

	private static void dispatchMouse(Canvas canvas, int id, Point point,
		int button, int clickCount)
	{
		canvas.dispatchEvent(new MouseEvent(canvas, id, System.currentTimeMillis(), 0,
			point.getX(), point.getY(), clickCount, false, button));
	}

	private static int nearestRouteIndex(List<WorldPoint> path, WorldPoint current,
		int previousIndex)
	{
		if (path.isEmpty())
		{
			return -1;
		}
		int from = Math.max(0, previousIndex - 3);
		int to = Math.min(path.size(), previousIndex + ROUTE_PROGRESS_WINDOW + 1);
		int best = -1;
		int bestDistance = Integer.MAX_VALUE;
		for (int index = from; index < to; index++)
		{
			int distance = current.distanceTo(path.get(index));
			if (distance < bestDistance || distance == bestDistance && index > best)
			{
				best = index;
				bestDistance = distance;
			}
		}
		return bestDistance <= MAX_ROUTE_DISTANCE ? best : -1;
	}

	private String followingMessage()
	{
		return "Following integrated Shortest Path route "
			+ Math.min(routeIndex + 1, route.size()) + '/' + route.size();
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
		route = ImmutableList.of();
		routeIndex = 0;
		waypoint = null;
		waypointIndex = -1;
		lastClickAt = 0L;
		nextProjectionAttemptAt = 0L;
	}

	private static String formatPoint(@Nullable WorldPoint point)
	{
		return point == null ? "none"
			: point.getX() + "," + point.getY() + "," + point.getPlane();
	}

	private static final class ProjectedWaypoint
	{
		private final WorldPoint target;
		private final int index;
		private final Point minimapPoint;
		private final Point dispatchPoint;

		private ProjectedWaypoint(WorldPoint target, int index,
			Point minimapPoint, Point dispatchPoint)
		{
			this.target = target;
			this.index = index;
			this.minimapPoint = minimapPoint;
			this.dispatchPoint = dispatchPoint;
		}
	}

	private static final class WaypointSelection
	{
		@Nullable
		private ProjectedWaypoint projected;
		private boolean worldViewUnavailable;
		private int candidates;
		private int localProjectionFailures;
		private int minimapProjectionFailures;
		private int outsideCanvasFailures;
		@Nullable
		private Point lastRejectedPoint;

		private String failureSummary()
		{
			return "projectionFailures={worldViewUnavailable=" + worldViewUnavailable
				+ ", candidates=" + candidates
				+ ", local=" + localProjectionFailures
				+ ", minimap=" + minimapProjectionFailures
				+ ", outsideCanvas=" + outsideCanvasFailures
				+ ", lastRejected="
				+ (lastRejectedPoint == null ? "none"
					: lastRejectedPoint.getX() + "," + lastRejectedPoint.getY())
				+ '}';
		}
	}
}
