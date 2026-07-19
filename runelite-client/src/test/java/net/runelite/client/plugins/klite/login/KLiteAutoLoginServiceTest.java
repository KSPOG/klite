/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.login;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class KLiteAutoLoginServiceTest
{
	@Test
	public void acceptsLauncherSession()
	{
		assertTrue(KLiteAutoLoginService.hasCredentials("session", null, null, null));
	}

	@Test
	public void acceptsLauncherDisplayName()
	{
		assertTrue(KLiteAutoLoginService.hasCredentials(null, "Character", null, null));
	}

	@Test
	public void acceptsCompleteClassicCredentials()
	{
		assertTrue(KLiteAutoLoginService.hasCredentials(null, null, "user", "password"));
	}

	@Test
	public void rejectsIncompleteCredentials()
	{
		assertFalse(KLiteAutoLoginService.hasCredentials(null, null, "user", null));
		assertFalse(KLiteAutoLoginService.hasCredentials(null, null, null, "password"));
		assertFalse(KLiteAutoLoginService.hasCredentials(" ", " ", " ", " "));
	}
}
