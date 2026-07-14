/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.plugins.klite.automation.AutomationManager;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

final class KLiteOverlay extends OverlayPanel
{
	private final Client client;
	private final KLiteConfig config;
	private final AutomationManager automationManager;

	@Inject
	private KLiteOverlay(Client client, KLiteConfig config, AutomationManager automationManager)
	{
		this.client = client;
		this.config = config;
		this.automationManager = automationManager;
		setPosition(OverlayPosition.TOP_LEFT);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.showStatusOverlay())
		{
			return null;
		}

		panelComponent.getChildren().add(TitleComponent.builder()
			.text("KLite")
			.build());
		panelComponent.getChildren().add(LineComponent.builder()
			.left("RuneLite")
			.right(RuneLiteProperties.getVersion())
			.build());
		panelComponent.getChildren().add(LineComponent.builder()
			.left("Game state")
			.right(client.getGameState().toString())
			.build());
		panelComponent.getChildren().add(LineComponent.builder()
			.left("Automation")
			.right(automationManager.status().getState().toString())
			.build());

		return super.render(graphics);
	}
}
