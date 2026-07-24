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
	public void runeLiteBrandResourcesAreAvailable()
	{
		BufferedImage icon128 = ImageUtil.loadImageResource(ClientUI.class, "runelite_128.png");
		BufferedImage icon16 = ImageUtil.loadImageResource(ClientUI.class, "runelite_16.png");
		BufferedImage splash = ImageUtil.loadImageResource(ClientUI.class, "runelite_splash.png");

		assertNotNull(icon128);
		assertNotNull(icon16);
		assertNotNull(splash);
		assertEquals(128, icon128.getWidth());
		assertEquals(16, icon16.getWidth());
		assertEquals(200, splash.getWidth());
	}

	@Test
	public void disguiseTitlePreservesSafeModeAndDisplayName()
	{
		assertEquals(
			"RuneLite (safe mode) - Example Player",
			KLiteDisguiseService.buildWindowTitle(
				"KLite (safe mode) - Example Player",
				KLiteDisguiseService.RUNELITE_TITLE,
				true));
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
