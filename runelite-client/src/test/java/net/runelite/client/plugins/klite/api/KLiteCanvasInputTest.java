/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.awt.Dimension;
import java.awt.Rectangle;
import net.runelite.api.Point;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class KLiteCanvasInputTest
{
	@Test
	public void fixedAndResizableCoordinatesRemainDirect()
	{
		Point source = new Point(980, 210);
		Point mapped = KLiteCanvasInput.mapPoint(source, false,
			new Dimension(765, 503), new Dimension(1_440, 900));

		assertEquals(source, mapped);
		assertEquals(new Rectangle(415, 260, 420, 260),
			KLiteCanvasInput.mapBounds(new Rectangle(415, 260, 420, 260),
				false, new Dimension(765, 503), new Dimension(1_440, 900)));
	}

	@Test
	public void stretchedCoordinatesUseRuneLiteOutputDimensions()
	{
		Dimension real = new Dimension(765, 503);
		Dimension stretched = new Dimension(1_200, 700);

		assertEquals(new Point(337, 294), KLiteCanvasInput.mapPoint(
			new Point(215, 211), true, real, stretched));
		assertEquals(new Rectangle(337, 294, 71, 61),
			KLiteCanvasInput.mapBounds(new Rectangle(215, 211, 45, 44),
				true, real, stretched));
	}

	@Test
	public void mappedBoundsAreClippedToLiveCanvas()
	{
		assertEquals(new Rectangle(1_400, 850, 40, 50),
			KLiteCanvasInput.clipToCanvas(
				new Rectangle(1_400, 850, 100, 100), 1_440, 900));
		assertNull(KLiteCanvasInput.clipToCanvas(
			new Rectangle(1_500, 950, 20, 20), 1_440, 900));
	}

	@Test
	public void invalidGeometryIsRejected()
	{
		assertNull(KLiteCanvasInput.mapPoint(new Point(10, 10), true,
			new Dimension(0, 503), new Dimension(1_200, 700)));
		assertNull(KLiteCanvasInput.mapBounds(new Rectangle(10, 10, 0, 20),
			false, new Dimension(765, 503), new Dimension(1_200, 700)));
		assertFalse(KLiteCanvasInput.isInsideCanvas(new Point(10, 10), 0, 900));
		assertFalse(KLiteCanvasInput.isInsideCanvas(new Point(1_440, 10),
			1_440, 900));
		assertTrue(KLiteCanvasInput.isInsideCanvas(new Point(1_439, 899),
			1_440, 900));
	}
}
