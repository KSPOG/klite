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
import net.runelite.client.launcher.KLiteLauncher;

/**
 * Stable entry point for the KLite distribution.
 *
 * <p>This small adapter keeps upstream updates straightforward while giving
 * launchers a KLite-owned main class.</p>
 */
public final class KLite
{
	private static final String SPLASH_ICON_RESOURCE = "klite_splash_icon.b64";
	private static final String RUNELITE_ICON_RESOURCE = "ui/runelite_128.png";

	private KLite()
	{
	}

	public static void main(String[] args) throws Exception
	{
		if (!KLiteLauncher.isClientInvocation(args))
		{
			KLiteLauncher.main(args);
			return;
		}

		applyWindowsTaskbarIcon();
		RuneLite.main(KLiteLauncher.clientArguments(args));
	}

	/**
	 * Applies the selected client icon before RuneLite creates its first window.
	 * The packaged KLite.exe contains the KLite image as a multi-size ICO, while
	 * disguise mode replaces Java's runtime taskbar image with RuneLite's icon.
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
			BufferedImage icon = KLiteDisguiseState.isEnabled()
				? loadRuneLiteIcon()
				: loadSplashIcon();
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

	private static BufferedImage loadRuneLiteIcon() throws IOException
	{
		try (InputStream input = KLite.class.getResourceAsStream(RUNELITE_ICON_RESOURCE))
		{
			return input == null ? null : ImageIO.read(input);
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
