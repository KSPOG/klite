/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite;

import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "KLite Core",
	description = "KLite client information and distribution settings",
	tags = {"klite", "client", "status"}
)
public class KLitePlugin extends Plugin
{
	static final String CONFIG_GROUP = "klite";

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private KLiteOverlay overlay;

	@Provides
	KLiteConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(KLiteConfig.class);
	}

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
