/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite;

import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.klite.api.DefaultKLiteClientApi;
import net.runelite.client.plugins.klite.api.KLiteClientApi;
import net.runelite.client.plugins.klite.automation.AutomationManager;
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

	@Inject
	private KLiteConfig config;

	@Inject
	private AutomationManager automationManager;

	@Provides
	KLiteConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(KLiteConfig.class);
	}

	@Provides
	KLiteClientApi provideClientApi(DefaultKLiteClientApi clientApi)
	{
		return clientApi;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (CONFIG_GROUP.equals(event.getGroup()) && "enableAutomation".equals(event.getKey()))
		{
			automationManager.setEnabled(config.enableAutomation());
		}
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
		automationManager.setEnabled(config.enableAutomation());
	}

	@Override
	protected void shutDown()
	{
		automationManager.setEnabled(false);
		overlayManager.remove(overlay);
	}
}
