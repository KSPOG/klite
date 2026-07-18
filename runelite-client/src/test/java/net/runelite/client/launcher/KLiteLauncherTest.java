/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.launcher;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class KLiteLauncherTest
{
	@Test
	public void recognizesAndRemovesInternalClientArgument()
	{
		String[] arguments = {"--profile", "main", "--klite-client", "--debug"};

		assertTrue(KLiteLauncher.isClientInvocation(arguments));
		assertArrayEquals(new String[]{"--profile", "main", "--debug"},
			KLiteLauncher.clientArguments(arguments));
	}

	@Test
	public void normalInvocationOpensLauncher()
	{
		assertFalse(KLiteLauncher.isClientInvocation(new String[]{"--debug"}));
	}
}
