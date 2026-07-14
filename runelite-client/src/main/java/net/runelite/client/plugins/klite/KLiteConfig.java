/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(KLitePlugin.CONFIG_GROUP)
public interface KLiteConfig extends Config
{
	@ConfigItem(
		keyName = "showStatusOverlay",
		name = "Show status overlay",
		description = "Display the KLite and RuneLite build status in an overlay"
	)
	default boolean showStatusOverlay()
	{
		return false;
	}
}
