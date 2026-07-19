/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.walker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.awt.Rectangle;
import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;
import org.junit.Test;

public class KLiteWorldMapWebWalkerControllerTest
{
	private static final Rectangle MAP_BOUNDS = new Rectangle(100, 50, 400, 300);
	private static final Point MAP_POSITION = new Point(3200, 3200);

	@Test
	public void mapCenterSelectsCurrentWorldMapPosition()
	{
		WorldPoint target = KLiteWorldMapWebWalkerController.worldPointForMapClick(
			MAP_BOUNDS, MAP_POSITION, 4.0f, new Point(302, 200));

		assertEquals(new WorldPoint(3200, 3200, 0), target);
	}

	@Test
	public void mapOffsetUsesShortestPathZoomConversion()
	{
		WorldPoint target = KLiteWorldMapWebWalkerController.worldPointForMapClick(
			MAP_BOUNDS, MAP_POSITION, 4.0f, new Point(342, 180));

		assertEquals(new WorldPoint(3210, 3205, 0), target);
	}

	@Test
	public void selectionRejectsInvalidGeometryAndOutsideClicks()
	{
		assertNull(KLiteWorldMapWebWalkerController.worldPointForMapClick(
			MAP_BOUNDS, MAP_POSITION, 0.0f, new Point(302, 200)));
		assertNull(KLiteWorldMapWebWalkerController.worldPointForMapClick(
			new Rectangle(), MAP_POSITION, 4.0f, new Point(302, 200)));
		assertNull(KLiteWorldMapWebWalkerController.worldPointForMapClick(
			MAP_BOUNDS, MAP_POSITION, 4.0f, new Point(99, 200)));
	}

	@Test
	public void webWalkerTaskUsesStableAutomationName()
	{
		assertEquals("web-walk", WebWalkerTask.TASK_NAME);
	}
}
