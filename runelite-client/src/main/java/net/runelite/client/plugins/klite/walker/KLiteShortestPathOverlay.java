/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 *
 * Scene and minimap route rendering is adapted from the Shortest Path plugin
 * by Skretzo and Microbot's maintained fork, distributed under BSD-2-Clause.
 */
package net.runelite.client.plugins.klite.walker;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.klite.KLiteConfig;
import net.runelite.client.plugins.klite.walker.pathfinder.ShortestPathRoutePlanner;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

/** Renders the active KLite Shortest Path route in the scene and minimap. */
@Singleton
public final class KLiteShortestPathOverlay extends Overlay
{
	private static final Color ROUTE_START = new Color(0, 220, 255, 190);
	private static final Color ROUTE_END = new Color(255, 143, 45, 210);
	private static final Color TARGET_FILL = new Color(255, 143, 45, 110);
	private static final Stroke SCENE_STROKE = new BasicStroke(4.0f,
		BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
	private static final Stroke MINIMAP_STROKE = new BasicStroke(2.0f,
		BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

	private final Client client;
	private final KLiteConfig config;
	private final WebWalker webWalker;
	private final ShortestPathRoutePlanner routePlanner;

	@Inject
	private KLiteShortestPathOverlay(Client client, KLiteConfig config,
		WebWalker webWalker, ShortestPathRoutePlanner routePlanner)
	{
		this.client = client;
		this.config = config;
		this.webWalker = webWalker;
		this.routePlanner = routePlanner;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(Overlay.PRIORITY_LOW);
		setLayer(OverlayLayer.ALWAYS_ON_TOP);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		WebWalkResult status = webWalker.status();
		List<WorldPoint> route = routePlanner.pathSnapshot();
		if (!config.showWebWalkerPath() || status.getPathLength() <= 0 || route.size() < 2)
		{
			return null;
		}

		Player player = client.getLocalPlayer();
		int startIndex = player == null ? 0 : nearestRouteIndex(route, player.getWorldLocation());
		Stroke previousStroke = graphics.getStroke();
		try
		{
			renderSceneRoute(graphics, route, startIndex);
			renderMinimapRoute(graphics, route, startIndex);
		}
		finally
		{
			graphics.setStroke(previousStroke);
		}
		return null;
	}

	private void renderSceneRoute(Graphics2D graphics, List<WorldPoint> route, int startIndex)
	{
		graphics.setStroke(SCENE_STROKE);
		Point previous = null;
		for (int index = startIndex; index < route.size(); index++)
		{
			Point current = scenePoint(route.get(index));
			if (previous != null && current != null)
			{
				graphics.setColor(routeColor(index, route.size()));
				graphics.draw(new Line2D.Double(previous.getX(), previous.getY(),
					current.getX(), current.getY()));
			}
			previous = current;
		}

		Point target = scenePoint(route.get(route.size() - 1));
		if (target != null)
		{
			graphics.setColor(TARGET_FILL);
			graphics.fill(new Ellipse2D.Double(target.getX() - 8, target.getY() - 8, 16, 16));
			graphics.setColor(ROUTE_END);
			graphics.draw(new Ellipse2D.Double(target.getX() - 8, target.getY() - 8, 16, 16));
		}
	}

	private void renderMinimapRoute(Graphics2D graphics, List<WorldPoint> route, int startIndex)
	{
		graphics.setStroke(MINIMAP_STROKE);
		Point previous = null;
		for (int index = startIndex; index < route.size(); index++)
		{
			Point current = minimapPoint(route.get(index));
			if (previous != null && current != null)
			{
				graphics.setColor(routeColor(index, route.size()));
				graphics.drawLine(previous.getX(), previous.getY(), current.getX(), current.getY());
			}
			previous = current;
		}

		Point target = minimapPoint(route.get(route.size() - 1));
		if (target != null)
		{
			graphics.setColor(ROUTE_END);
			graphics.fillOval(target.getX() - 3, target.getY() - 3, 7, 7);
		}
	}

	@Nullable
	private Point scenePoint(WorldPoint point)
	{
		if (client.getTopLevelWorldView() == null
			|| point.getPlane() != client.getTopLevelWorldView().getPlane()
			|| !WorldPoint.isInScene(client.getTopLevelWorldView(), point.getX(), point.getY()))
		{
			return null;
		}
		LocalPoint local = LocalPoint.fromWorld(client.getTopLevelWorldView(), point.getX(), point.getY());
		return local == null ? null : Perspective.localToCanvas(client, local, point.getPlane());
	}

	@Nullable
	private Point minimapPoint(WorldPoint point)
	{
		if (client.getTopLevelWorldView() == null
			|| point.getPlane() != client.getTopLevelWorldView().getPlane())
		{
			return null;
		}
		LocalPoint local = LocalPoint.fromWorld(client.getTopLevelWorldView(), point.getX(), point.getY());
		return local == null ? null : Perspective.localToMinimap(client, local);
	}

	private static int nearestRouteIndex(List<WorldPoint> route, WorldPoint player)
	{
		int bestIndex = 0;
		int bestDistance = Integer.MAX_VALUE;
		for (int index = 0; index < route.size(); index++)
		{
			int distance = player.distanceTo(route.get(index));
			if (distance < bestDistance)
			{
				bestIndex = index;
				bestDistance = distance;
			}
		}
		return bestIndex;
	}

	private static Color routeColor(int index, int size)
	{
		float step = size <= 1 ? 1.0f : index / (float) (size - 1);
		int red = Math.round(ROUTE_START.getRed()
			+ step * (ROUTE_END.getRed() - ROUTE_START.getRed()));
		int green = Math.round(ROUTE_START.getGreen()
			+ step * (ROUTE_END.getGreen() - ROUTE_START.getGreen()));
		int blue = Math.round(ROUTE_START.getBlue()
			+ step * (ROUTE_END.getBlue() - ROUTE_START.getBlue()));
		return new Color(red, green, blue, 190);
	}
}
