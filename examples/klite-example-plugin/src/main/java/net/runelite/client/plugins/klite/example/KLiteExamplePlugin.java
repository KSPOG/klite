/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.example;

import javax.inject.Inject;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

/**
 * Source-only plugin used to demonstrate the future KLite marketplace package format.
 */
@PluginDescriptor(
	name = "KLite Example",
	description = "A harmless example plugin published in the KLite marketplace catalog",
	tags = {"klite", "example", "marketplace"},
	authors = {"KSPOG"},
	version = KLiteExamplePlugin.VERSION,
	minClientVersion = "1.0.0",
	enabledByDefault = false,
	isExternal = true
)
public class KLiteExamplePlugin extends Plugin
{
	public static final String VERSION = "1.0.0";

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private KLiteExampleOverlay overlay;

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(overlay);
	}
}
