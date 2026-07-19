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
		assertTrue(KLiteAutoLoginService.hasLauncherSession("session", null));
	}

	@Test
	public void acceptsLauncherDisplayName()
	{
		assertTrue(KLiteAutoLoginService.hasLauncherSession(null, "Character"));
	}

	@Test
	public void rejectsMissingLauncherSession()
	{
		assertFalse(KLiteAutoLoginService.hasLauncherSession(null, null));
		assertFalse(KLiteAutoLoginService.hasLauncherSession(" ", " "));
	}
}
