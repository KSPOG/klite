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
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.plugins.klite.automation.AutomationManager;
import net.runelite.client.plugins.klite.walker.WebWalkResult;
import net.runelite.client.plugins.klite.walker.WebWalker;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

final class KLiteOverlay extends OverlayPanel
{
	private final Client client;
	private final KLiteConfig config;
	private final AutomationManager automationManager;
	private final WebWalker webWalker;

	@Inject
	private KLiteOverlay(Client client, KLiteConfig config, AutomationManager automationManager,
		WebWalker webWalker)
	{
		this.client = client;
		this.config = config;
		this.automationManager = automationManager;
		this.webWalker = webWalker;
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

		WebWalkResult walk = webWalker.status();
		panelComponent.getChildren().add(LineComponent.builder()
			.left("Web walker")
			.right(walk.getState().toString())
			.build());
		if (walk.getPathLength() > 0)
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Shortest Path")
				.right(walk.getPathLength() + " tiles")
				.build());
		}
		WorldPoint next = walk.getClickTarget();
		if (next != null)
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Next route tile")
				.right(next.getX() + ", " + next.getY() + ", " + next.getPlane())
				.build());
		}

		return super.render(graphics);
	}
}
