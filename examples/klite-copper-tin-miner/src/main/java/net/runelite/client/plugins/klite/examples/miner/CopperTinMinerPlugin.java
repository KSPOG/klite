/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.examples.miner;

import javax.inject.Inject;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.klite.KLitePlugin;
import net.runelite.client.plugins.klite.automation.AutomationManager;
import net.runelite.client.plugins.klite.walker.WebWalker;

/** Marketplace example which runs the copper and tin mining automation task. */
@PluginDependency(KLitePlugin.class)
@PluginDescriptor(
	name = "Copper and Tin Miner",
	description = "Mines copper and tin near Varrock and banks everything except pickaxes",
	tags = {"klite", "mining", "copper", "tin", "example", "Free"},
	authors = {"KSP"},
	version = CopperTinMinerPlugin.VERSION,
	minClientVersion = "1.0.0",
	enabledByDefault = false,
	isExternal = true
)
public class CopperTinMinerPlugin extends Plugin
{
	public static final String VERSION = "1.0.0";

	@Inject
	private AutomationManager automationManager;

	@Inject
	private WebWalker webWalker;

	private boolean taskStarted;

	@Override
	protected void startUp()
	{
		automationManager.setEnabled(true);
		taskStarted = automationManager.start(new CopperTinMinerTask(webWalker));
		if (!taskStarted)
		{
			throw new IllegalStateException("Another KLite automation task is already running");
		}
	}

	@Override
	protected void shutDown()
	{
		if (taskStarted)
		{
			automationManager.stop();
			taskStarted = false;
		}
	}
}
