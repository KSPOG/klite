/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.examples.miner;

import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.klite.KLitePlugin;
import net.runelite.client.plugins.klite.automation.AutomationManager;
import net.runelite.client.plugins.klite.debug.KLiteClientLogBuffer;
import net.runelite.client.plugins.klite.walker.WebWalker;
import net.runelite.client.ui.overlay.OverlayManager;

/** Marketplace example which runs the copper and tin mining automation task. */
@PluginDependency(KLitePlugin.class)
@PluginDescriptor(
	name = "Copper and Tin Miner",
	description = "Mines copper and tin near Varrock and banks only when the inventory is full",
	tags = {"klite", "mining", "copper", "tin", "example", "Free"},
	authors = {"KSP"},
	version = CopperTinMinerPlugin.VERSION,
	minClientVersion = "1.0.0",
	enabledByDefault = false,
	isExternal = true
)
public class CopperTinMinerPlugin extends Plugin
{
	public static final String VERSION = "0.0.2";
	private static final String LOG_SOURCE = "CopperTinMiner";

	@Inject
	private AutomationManager automationManager;

	@Inject
	private WebWalker webWalker;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private CopperTinMinerConfig config;

	@Inject
	private KLiteClientLogBuffer diagnostics;

	private CopperTinMinerTask task;
	private CopperTinMinerOverlay overlay;
	private boolean taskStarted;

	@Provides
	CopperTinMinerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CopperTinMinerConfig.class);
	}

	@Override
	protected void startUp()
	{
		diagnostics.info(LOG_SOURCE, "Plugin v" + VERSION + " startup requested.");
		task = new CopperTinMinerTask(webWalker, diagnostics);
		overlay = new CopperTinMinerOverlay(config, task, automationManager, webWalker);
		overlayManager.add(overlay);
		automationManager.setEnabled(true);
		taskStarted = automationManager.start(task);
		if (!taskStarted)
		{
			overlayManager.remove(overlay);
			overlay = null;
			task = null;
			diagnostics.warn(LOG_SOURCE, "Startup was rejected because another KLite automation task is running.");
			throw new IllegalStateException("Another KLite automation task is already running");
		}
		diagnostics.info(LOG_SOURCE, "Plugin v" + VERSION
			+ " enabled. Overlay registered and automation task started.");
	}

	@Override
	protected void shutDown()
	{
		diagnostics.info(LOG_SOURCE, "Plugin v" + VERSION + " shutdown requested.");
		if (taskStarted)
		{
			automationManager.stop();
			taskStarted = false;
		}
		if (overlay != null)
		{
			overlayManager.remove(overlay);
			overlay = null;
		}
		task = null;
		diagnostics.info(LOG_SOURCE, "Plugin disabled. Overlay removed and automation task stopped.");
	}
}
