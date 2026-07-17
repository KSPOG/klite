/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client;

import java.awt.Taskbar;
import net.runelite.client.ui.ClientUI;

/**
 * Stable entry point for the KLite distribution.
 *
 * <p>This small adapter keeps upstream updates straightforward while giving
 * launchers a KLite-owned main class.</p>
 */
public final class KLite
{
	private KLite()
	{
	}

	public static void main(String[] args) throws Exception
	{
		applyWindowsTaskbarIcon();
		RuneLite.main(args);
	}

	/**
	 * Applies the KLite splash crest before RuneLite creates its first window.
	 * The packaged KLite.exe also contains this icon, but setting it through the
	 * Java Taskbar API prevents Windows from temporarily showing the generic Java
	 * icon while the client starts or when Alt-Tab/taskbar metadata refreshes.
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
			if (taskbar.isSupported(Taskbar.Feature.ICON_IMAGE))
			{
				taskbar.setIconImage(ClientUI.ICON_128);
			}
		}
		catch (RuntimeException ignored)
		{
			// Window creation still applies the same icon through JFrame#setIconImages.
		}
	}
}
