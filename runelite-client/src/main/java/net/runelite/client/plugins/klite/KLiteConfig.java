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
		name = "Branding",
		description = "Controls how the desktop client identifies itself.",
		position = 0
	)
	String brandingSection = "branding";

	@ConfigSection(
		name = "Updates",
		description = "KLite desktop client update settings.",
		position = 1
	)
	String updatesSection = "updates";

	@ConfigSection(
		name = "Login",
		description = "KLite login and reconnect behaviour.",
		position = 2
	)
	String loginSection = "login";

	@ConfigSection(
		name = "Automation",
		description = "Global controls for KLite automation modules.",
		position = 3
	)
	String automationSection = "automation";

	@ConfigSection(
		name = "Plugin development",
		description = "Load locally built development plugins without the KLite client source code.",
		position = 4
	)
	String developmentSection = "development";

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
		keyName = "disguiseMode",
		name = "Disguise mode",
		description = "Show RuneLite as the client name and use the RuneLite application icons instead of KLite branding",
		section = brandingSection,
		position = 0
	)
	default boolean disguiseMode()
	{
		return false;
	}

	@ConfigItem(
		keyName = "checkForClientUpdates",
		name = "Check for client updates",
		description = "Check for a newer verified KLite Windows client when KLite starts",
		section = updatesSection,
		position = 0
	)
	default boolean checkForClientUpdates()
	{
		return true;
	}

	@ConfigItem(
		keyName = "autoLogin",
		name = "AutoLogin",
		description = "Automatically enter the game and reconnect when KLite was launched with a saved Jagex character session",
		section = loginSection,
		position = 0
	)
	default boolean autoLogin()
	{
		return true;
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

	@ConfigItem(
		keyName = "lockWindowDuringAutomation",
		name = "Lock window during automation",
		description = "Prevent client resizing while an automation task is running so live widget positions remain stable",
		section = automationSection,
		position = 1
	)
	default boolean lockWindowDuringAutomation()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showWebWalkerPath",
		name = "Show web-walker path",
		description = "Render the active integrated Shortest Path route in the game scene and minimap",
		section = automationSection,
		position = 2
	)
	default boolean showWebWalkerPath()
	{
		return true;
	}

	@ConfigItem(
		keyName = "enableDevelopmentPlugins",
		name = "Enable development plugins",
		description = "Watch ~/.runelite/klite-dev-plugins and automatically reload locally built plugin JARs",
		warning = "Development plugins are unreviewed local code and have the same permissions as the client. Only load JARs you trust.",
		section = developmentSection,
		position = 0
	)
	default boolean enableDevelopmentPlugins()
	{
		return false;
	}
}
