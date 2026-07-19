/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.walker;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import net.runelite.api.Point;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class IntegratedShortestPathWebWalkerTest
{
	@Test
	public void activeWalkerContainsOnlyMinimapProjection() throws Exception
	{
		String resource = "/" + IntegratedShortestPathWebWalker.class.getName()
			.replace('.', '/') + ".class";
		try (InputStream input =
			IntegratedShortestPathWebWalker.class.getResourceAsStream(resource))
		{
			assertNotNull(input);
			String bytecode = new String(input.readAllBytes(), StandardCharsets.ISO_8859_1);
			assertTrue(bytecode.contains("localToMinimap"));
			assertFalse(bytecode.contains("localToCanvas"));
			assertFalse(bytecode.contains("GroundWalkDispatcher"));
			assertFalse(bytecode.contains("surface=scene"));
		}
	}

	@Test
	public void liveCanvasBoundsAcceptResizableMinimapCoordinates()
	{
		assertTrue(IntegratedShortestPathWebWalker.isInsideCanvas(
			new Point(1_320, 160), 1_440, 900));
		assertFalse(IntegratedShortestPathWebWalker.isInsideCanvas(
			new Point(1_440, 160), 1_440, 900));
		assertFalse(IntegratedShortestPathWebWalker.isInsideCanvas(
			new Point(1_320, 900), 1_440, 900));
	}

	@Test
	public void invalidCanvasDimensionsRejectCoordinates()
	{
		assertFalse(IntegratedShortestPathWebWalker.isInsideCanvas(
			new Point(10, 10), 0, 900));
		assertFalse(IntegratedShortestPathWebWalker.isInsideCanvas(
			new Point(10, 10), 1_440, 0));
		assertFalse(IntegratedShortestPathWebWalker.isInsideCanvas(
			null, 1_440, 900));
	}
}
