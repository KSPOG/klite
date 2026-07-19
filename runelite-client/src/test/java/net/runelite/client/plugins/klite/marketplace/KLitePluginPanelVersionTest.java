/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KLitePluginPanelVersionTest
{
	@Test
	public void prefersPackagedSemanticVersion()
	{
		assertEquals("Client version: v1.2.3",
			KLitePluginPanel.formatClientVersion("1.2.3", "abcdef123456"));
	}

	@Test
	public void fallsBackToShortBuild()
	{
		assertEquals("Client version: build abcdef1",
			KLitePluginPanel.formatClientVersion(null, "abcdef123456"));
	}
}
