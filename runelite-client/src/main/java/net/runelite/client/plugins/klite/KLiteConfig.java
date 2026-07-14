/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup(KLitePlugin.CONFIG_GROUP)
public interface KLiteConfig extends Config
{
	@ConfigSection(
		name = "Automation",
		description = "Global controls for KLite automation modules.",
		position = 1
	)
	String automationSection = "automation";

	@ConfigItem(
		keyName = "showStatusOverlay",
		name = "Show status overlay",
		description = "Display the KLite and RuneLite build status in an overlay",
		position = 0
	)
	default boolean showStatusOverlay()
	{
		return false;
	}

	@ConfigItem(
		keyName = "enableAutomation",
		name = "Enable automation",
		description = "Allow KLite automation tasks to run. Turning this off immediately stops the active task.",
		warning = "Automation can violate game rules. You are responsible for how you use this client.",
		section = automationSection,
		position = 0
	)
	default boolean enableAutomation()
	{
		return false;
	}
}
