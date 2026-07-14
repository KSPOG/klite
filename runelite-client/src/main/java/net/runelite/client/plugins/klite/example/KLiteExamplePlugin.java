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
 * Minimal bundled plugin used to demonstrate the KLite marketplace catalog.
 */
@PluginDescriptor(
	name = "KLite Example",
	description = "A harmless example plugin published in the KLite marketplace catalog",
	tags = {"klite", "example", "marketplace"},
	enabledByDefault = false
)
public class KLiteExamplePlugin extends Plugin
{
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
