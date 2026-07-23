/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.automation;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.plugins.klite.KLiteConfig;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

public class AutomationWindowLockTest
{
	private ConfigManager configManager;
	private KLiteConfig config;
	private AutomationWindowLock windowLock;

	@Before
	public void setUp()
	{
		configManager = mock(ConfigManager.class);
		config = mock(KLiteConfig.class);
		when(config.lockWindowDuringAutomation()).thenReturn(true);
		windowLock = new AutomationWindowLock(configManager, config);
	}

	@Test
	public void absentPreferenceIsLockedAndThenRestoredToDefault()
	{
		when(configManager.getConfiguration(
			RuneLiteConfig.GROUP_NAME,
			AutomationWindowLock.LOCK_WINDOW_SIZE_KEY))
			.thenReturn(null, "true");

		windowLock.acquire();
		windowLock.release();

		InOrder order = inOrder(configManager);
		order.verify(configManager).setConfiguration(
			RuneLiteConfig.GROUP_NAME,
			AutomationWindowLock.LOCK_WINDOW_SIZE_KEY,
			true);
		order.verify(configManager).unsetConfiguration(
			RuneLiteConfig.GROUP_NAME,
			AutomationWindowLock.LOCK_WINDOW_SIZE_KEY);
	}

	@Test
	public void explicitFalsePreferenceIsRestored()
	{
		when(configManager.getConfiguration(
			RuneLiteConfig.GROUP_NAME,
			AutomationWindowLock.LOCK_WINDOW_SIZE_KEY))
			.thenReturn("false", "true");

		windowLock.acquire();
		windowLock.release();

		verify(configManager).setConfiguration(
			RuneLiteConfig.GROUP_NAME,
			AutomationWindowLock.LOCK_WINDOW_SIZE_KEY,
			"false");
	}

	@Test
	public void existingLockedPreferenceIsNotRewritten()
	{
		when(configManager.getConfiguration(
			RuneLiteConfig.GROUP_NAME,
			AutomationWindowLock.LOCK_WINDOW_SIZE_KEY))
			.thenReturn("true");

		windowLock.acquire();
		windowLock.release();

		verify(configManager, never()).setConfiguration(
			RuneLiteConfig.GROUP_NAME,
			AutomationWindowLock.LOCK_WINDOW_SIZE_KEY,
			true);
		verify(configManager, never()).unsetConfiguration(
			RuneLiteConfig.GROUP_NAME,
			AutomationWindowLock.LOCK_WINDOW_SIZE_KEY);
	}

	@Test
	public void externalPreferenceChangeIsNotOverwritten()
	{
		when(configManager.getConfiguration(
			RuneLiteConfig.GROUP_NAME,
			AutomationWindowLock.LOCK_WINDOW_SIZE_KEY))
			.thenReturn("false");

		windowLock.acquire();
		windowLock.release();

		verify(configManager, never()).unsetConfiguration(
			RuneLiteConfig.GROUP_NAME,
			AutomationWindowLock.LOCK_WINDOW_SIZE_KEY);
		verify(configManager, never()).setConfiguration(
			RuneLiteConfig.GROUP_NAME,
			AutomationWindowLock.LOCK_WINDOW_SIZE_KEY,
			false);
	}

	@Test
	public void disabledSafetySettingLeavesRuneLitePreferenceUntouched()
	{
		when(config.lockWindowDuringAutomation()).thenReturn(false);

		windowLock.acquire();
		windowLock.release();

		verify(configManager, never()).getConfiguration(
			RuneLiteConfig.GROUP_NAME,
			AutomationWindowLock.LOCK_WINDOW_SIZE_KEY);
	}
}
