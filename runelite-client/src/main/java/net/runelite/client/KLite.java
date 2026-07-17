/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client;

import java.awt.Taskbar;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.imageio.ImageIO;

/**
 * Stable entry point for the KLite distribution.
 *
 * <p>This small adapter keeps upstream updates straightforward while giving
 * launchers a KLite-owned main class.</p>
 */
public final class KLite
{
	private static final String SPLASH_ICON_RESOURCE = "klite_splash_icon.b64";

	private KLite()
	{
	}

	public static void main(String[] args) throws Exception
	{
		applyWindowsTaskbarIcon();
		RuneLite.main(args);
	}

	/**
	 * Applies the supplied KLite splash crest before RuneLite creates its first
	 * window. The packaged KLite.exe contains the same image as a multi-size ICO.
	 */
	private static void applyWindowsTaskbarIcon()
	{
		try
		{
			if (!Taskbar.isTaskbarSupported())
			{
				return;
			}
			Taskbar taskbar = Taskbar.getTaskbar();
			if (!taskbar.isSupported(Taskbar.Feature.ICON_IMAGE))
			{
				return;
			}
			BufferedImage icon = loadSplashIcon();
			if (icon != null)
			{
				taskbar.setIconImage(icon);
			}
		}
		catch (IOException | RuntimeException ignored)
		{
			// Failure to apply branding must never prevent the client from starting.
		}
	}

	private static BufferedImage loadSplashIcon() throws IOException
	{
		try (InputStream input = KLite.class.getResourceAsStream(SPLASH_ICON_RESOURCE))
		{
			if (input == null)
			{
				return null;
			}
			String encoded = new String(input.readAllBytes(), StandardCharsets.US_ASCII);
			byte[] png = Base64.getMimeDecoder().decode(encoded);
			return ImageIO.read(new ByteArrayInputStream(png));
		}
	}
}
