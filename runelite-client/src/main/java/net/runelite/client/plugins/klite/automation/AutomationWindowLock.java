/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.automation;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.plugins.klite.KLiteConfig;

/**
 * Temporarily prevents window resizing while KLite automation is active.
 *
 * <p>The previous RuneLite preference is restored when automation stops. If
 * the preference is changed by another owner while the lock is held, that
 * newer value is left untouched.</p>
 */
@Singleton
final class AutomationWindowLock
{
	static final String LOCK_WINDOW_SIZE_KEY = "lockWindowSize";

	private final ConfigManager configManager;
	private final KLiteConfig config;

	private boolean held;
	@Nullable
	private String previousValue;

	@Inject
	AutomationWindowLock(ConfigManager configManager, KLiteConfig config)
	{
		this.configManager = configManager;
		this.config = config;
	}

	synchronized void acquire()
	{
		if (held || !config.lockWindowDuringAutomation())
		{
			return;
		}

		previousValue = configManager.getConfiguration(
			RuneLiteConfig.GROUP_NAME, LOCK_WINDOW_SIZE_KEY);
		held = true;

		if (!Boolean.TRUE.toString().equalsIgnoreCase(previousValue))
		{
			configManager.setConfiguration(
				RuneLiteConfig.GROUP_NAME, LOCK_WINDOW_SIZE_KEY, true);
		}
	}

	synchronized void release()
	{
		if (!held)
		{
			return;
		}

		String valueToRestore = previousValue;
		previousValue = null;
		held = false;

		String currentValue = configManager.getConfiguration(
			RuneLiteConfig.GROUP_NAME, LOCK_WINDOW_SIZE_KEY);
		if (!Boolean.TRUE.toString().equalsIgnoreCase(currentValue))
		{
			return;
		}

		if (valueToRestore == null)
		{
			configManager.unsetConfiguration(
				RuneLiteConfig.GROUP_NAME, LOCK_WINDOW_SIZE_KEY);
		}
		else if (!valueToRestore.equals(currentValue))
		{
			configManager.setConfiguration(
				RuneLiteConfig.GROUP_NAME, LOCK_WINDOW_SIZE_KEY, valueToRestore);
		}
	}
}
