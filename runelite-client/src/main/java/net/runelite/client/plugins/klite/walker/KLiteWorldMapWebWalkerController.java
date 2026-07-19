/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 *
 * World-map target selection follows the coordinate conversion and RuneLite
 * menu-entry flow used by Skretzo's Shortest Path plugin (BSD-2-Clause).
 */
package net.runelite.client.plugins.klite.walker;

import java.awt.Canvas;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.api.worldmap.WorldMap;
import net.runelite.client.plugins.klite.automation.AutomationManager;
import net.runelite.client.plugins.klite.automation.AutomationState;
import net.runelite.client.plugins.klite.automation.AutomationStatus;
import net.runelite.client.ui.JagexColors;
import net.runelite.client.util.ColorUtil;

/** Adds Shortest Path-style Set Target controls to the world map. */
@Singleton
public final class KLiteWorldMapWebWalkerController
{
	private static final String SET = "Set";
	private static final String CLEAR = "Clear";
	private static final String TARGET = ColorUtil.wrapWithColorTag(
		"Target", JagexColors.MENU_TARGET);
	private static final String PATH = ColorUtil.wrapWithColorTag(
		"Path", JagexColors.MENU_TARGET);

	private final Client client;
	private final AutomationManager automationManager;
	private final WebWalker webWalker;

	@Nullable
	private Point lastMenuOpenedPoint;

	@Inject
	KLiteWorldMapWebWalkerController(Client client,
		AutomationManager automationManager, WebWalker webWalker)
	{
		this.client = client;
		this.automationManager = automationManager;
		this.webWalker = webWalker;
	}

	public void onMenuOpened(MenuOpened event)
	{
		lastMenuOpenedPoint = client.getMouseCanvasPosition();
	}

	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		Widget map = client.getWidget(InterfaceID.Worldmap.MAP_CONTAINER);
		Point mouse = client.getMouseCanvasPosition();
		if (map == null || map.isHidden() || mouse == null
			|| !map.getBounds().contains(mouse.getX(), mouse.getY()))
		{
			return;
		}

		addMenuEntry(event, SET, TARGET, 0, this::setSelectedTarget);
		WebWalkResult status = webWalker.status();
		AutomationStatus automation = automationManager.status();
		if (status.getDestination() != null
			|| WebWalkerTask.TASK_NAME.equals(automation.getTaskName()))
		{
			addMenuEntry(event, CLEAR, PATH, 0, this::clearPath);
		}
	}

	private void setSelectedTarget(MenuEntry ignored)
	{
		WorldPoint target = selectedWorldPoint();
		if (target == null)
		{
			message("Could not determine a valid world-map target.");
			return;
		}

		AutomationStatus status = automationManager.status();
		if (status.getState() == AutomationState.DISABLED)
		{
			message("Enable KLite Core > Enable automation before using Set Target.");
			return;
		}
		if (status.getState() == AutomationState.STOPPING)
		{
			message("The current automation task is still stopping. Try Set Target again.");
			return;
		}
		if (status.getState() == AutomationState.RUNNING)
		{
			if (!WebWalkerTask.TASK_NAME.equals(status.getTaskName()))
			{
				message("Another automation task is running: " + status.getTaskName() + '.');
				return;
			}
			automationManager.stop();
		}
		else if (status.getState() == AutomationState.FAILED)
		{
			automationManager.stop();
		}

		if (automationManager.start(new WebWalkerTask(webWalker, target)))
		{
			closeWorldMap();
			message("Walking to " + formatPoint(target) + '.');
		}
		else
		{
			message("The WebWalker could not start because automation is busy.");
		}
	}

	private void closeWorldMap()
	{
		Widget map = client.getWidget(InterfaceID.Worldmap.MAP_CONTAINER);
		Canvas canvas = client.getCanvas();
		if (map == null || map.isHidden() || canvas == null)
		{
			return;
		}

		EventQueue.invokeLater(() -> dispatchEscape(canvas));
	}

	static void dispatchEscape(Canvas canvas)
	{
		long when = System.currentTimeMillis();
		canvas.dispatchEvent(createEscapeEvent(canvas, KeyEvent.KEY_PRESSED, when));
		canvas.dispatchEvent(createEscapeEvent(canvas, KeyEvent.KEY_RELEASED, when));
	}

	static KeyEvent createEscapeEvent(Canvas canvas, int id, long when)
	{
		return new KeyEvent(canvas, id, when, 0,
			KeyEvent.VK_ESCAPE, KeyEvent.CHAR_UNDEFINED);
	}

	private void clearPath(MenuEntry ignored)
	{
		AutomationStatus status = automationManager.status();
		if (WebWalkerTask.TASK_NAME.equals(status.getTaskName()))
		{
			automationManager.stop();
		}
		else
		{
			webWalker.clear();
		}
		message("WebWalker path cleared.");
	}

	@Nullable
	private WorldPoint selectedWorldPoint()
	{
		Widget map = client.getWidget(InterfaceID.Worldmap.MAP_CONTAINER);
		WorldMap worldMap = client.getWorldMap();
		Point mapPosition = worldMap == null ? null : worldMap.getWorldMapPosition();
		Point selected = client.isMenuOpen() ? lastMenuOpenedPoint : client.getMouseCanvasPosition();
		if (map == null || worldMap == null || mapPosition == null || selected == null)
		{
			return null;
		}
		return worldPointForMapClick(map.getBounds(), mapPosition,
			worldMap.getWorldMapZoom(), selected);
	}

	@Nullable
	static WorldPoint worldPointForMapClick(Rectangle mapBounds, Point mapPosition,
		float zoom, Point selected)
	{
		if (mapBounds == null || mapPosition == null || selected == null
			|| mapBounds.width <= 0 || mapBounds.height <= 0
			|| !Float.isFinite(zoom) || zoom <= 0.0f
			|| !mapBounds.contains(selected.getX(), selected.getY()))
		{
			return null;
		}

		int middleX = mapWorldPointToGraphicsPointX(
			mapBounds, mapPosition, zoom, mapPosition.getX());
		int middleY = mapWorldPointToGraphicsPointY(
			mapBounds, mapPosition, zoom, mapPosition.getY());
		int dx = (int) ((selected.getX() - middleX) / zoom);
		int dy = (int) (-(selected.getY() - middleY) / zoom);
		int worldX = mapPosition.getX() + dx;
		int worldY = mapPosition.getY() + dy;
		if (worldX < 0 || worldX > 0x7FFF || worldY < 0 || worldY > 0x7FFF)
		{
			return null;
		}
		return new WorldPoint(worldX, worldY, 0);
	}

	private static int mapWorldPointToGraphicsPointX(Rectangle mapBounds,
		Point mapPosition, float zoom, int worldX)
	{
		int widthInTiles = (int) Math.ceil(mapBounds.getWidth() / zoom);
		int xTileOffset = worldX + widthInTiles / 2 - mapPosition.getX();
		int xGraphDiff = (int) (xTileOffset * zoom);
		xGraphDiff += (int) (zoom - Math.ceil(zoom / 2.0f));
		xGraphDiff += mapBounds.x;
		return xGraphDiff;
	}

	private static int mapWorldPointToGraphicsPointY(Rectangle mapBounds,
		Point mapPosition, float zoom, int worldY)
	{
		int heightInTiles = (int) Math.ceil(mapBounds.getHeight() / zoom);
		int yTileMax = mapPosition.getY() - heightInTiles / 2;
		int yTileOffset = (yTileMax - worldY - 1) * -1;
		int yGraphDiff = (int) (yTileOffset * zoom);
		yGraphDiff -= (int) (zoom - Math.ceil(zoom / 2.0f));
		yGraphDiff = mapBounds.height - yGraphDiff;
		yGraphDiff += mapBounds.y;
		return yGraphDiff;
	}

	private void addMenuEntry(MenuEntryAdded event, String option, String target,
		int position, java.util.function.Consumer<MenuEntry> callback)
	{
		List<MenuEntry> entries = new LinkedList<>(
			Arrays.asList(client.getMenu().getMenuEntries()));
		if (entries.stream().anyMatch(entry -> option.equals(entry.getOption())
			&& target.equals(entry.getTarget())))
		{
			return;
		}

		client.getMenu().createMenuEntry(position)
			.setOption(option)
			.setTarget(target)
			.setParam0(event.getActionParam0())
			.setParam1(event.getActionParam1())
			.setIdentifier(event.getIdentifier())
			.setType(MenuAction.RUNELITE)
			.onClick(callback);
	}

	private void message(String text)
	{
		client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "KLite: " + text, null);
	}

	private static String formatPoint(WorldPoint point)
	{
		return point.getX() + "," + point.getY() + "," + point.getPlane();
	}
}
