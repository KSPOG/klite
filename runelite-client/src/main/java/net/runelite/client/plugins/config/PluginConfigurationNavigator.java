/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.config;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.SwingUtilities;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;

/** Opens the active RuneLite configuration UI for dynamically loaded plugins. */
@Singleton
public class PluginConfigurationNavigator
{
	private final ClientToolbar clientToolbar;
	@Nullable
	private NavigationButton navigationButton;
	@Nullable
	private TopLevelConfigPanel topLevelConfigPanel;

	@Inject
	PluginConfigurationNavigator(ClientToolbar clientToolbar)
	{
		this.clientToolbar = clientToolbar;
	}

	synchronized void register(NavigationButton navigationButton,
		TopLevelConfigPanel topLevelConfigPanel)
	{
		this.navigationButton = navigationButton;
		this.topLevelConfigPanel = topLevelConfigPanel;
	}

	synchronized void clear(NavigationButton navigationButton)
	{
		if (this.navigationButton == navigationButton)
		{
			this.navigationButton = null;
			this.topLevelConfigPanel = null;
		}
	}

	public void open(Plugin plugin)
	{
		if (plugin == null)
		{
			return;
		}
		SwingUtilities.invokeLater(() ->
		{
			NavigationButton button;
			TopLevelConfigPanel panel;
			synchronized (this)
			{
				button = navigationButton;
				panel = topLevelConfigPanel;
			}
			if (button == null || panel == null)
			{
				return;
			}
			clientToolbar.openPanel(button);
			panel.openConfigurationPanel(plugin.getName());
		});
	}
}
