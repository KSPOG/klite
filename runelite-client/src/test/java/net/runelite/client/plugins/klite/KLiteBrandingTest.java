/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite;

import java.awt.image.BufferedImage;
import net.runelite.client.plugins.klite.marketplace.KLiteMarketplaceWindow;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.util.ImageUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class KLiteBrandingTest
{
	@Test
	public void applicationIconsUseKLiteDimensions()
	{
		assertEquals(128, ClientUI.ICON_128.getWidth());
		assertEquals(128, ClientUI.ICON_128.getHeight());
		assertEquals(16, ClientUI.ICON_16.getWidth());
		assertEquals(16, ClientUI.ICON_16.getHeight());
	}

	@Test
	public void marketplaceBrandResourceIsAvailable()
	{
		BufferedImage image = ImageUtil.loadImageResource(
			KLiteMarketplaceWindow.class, "klite_marketplace.png");
		assertNotNull(image);
		assertEquals(898, image.getWidth());
		assertEquals(1172, image.getHeight());
	}
}
