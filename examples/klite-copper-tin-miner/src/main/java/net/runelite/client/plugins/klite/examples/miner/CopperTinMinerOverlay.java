/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.examples.miner;

import java.awt.Dimension;
import java.awt.Graphics2D;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.klite.automation.AutomationManager;
import net.runelite.client.plugins.klite.automation.AutomationStatus;
import net.runelite.client.plugins.klite.walker.WebWalkResult;
import net.runelite.client.plugins.klite.walker.WebWalker;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

/** Dedicated runtime overlay for Copper and Tin Miner. */
final class CopperTinMinerOverlay extends OverlayPanel
{
	private final CopperTinMinerConfig config;
	private final CopperTinMinerTask task;
	private final AutomationManager automationManager;
	private final WebWalker webWalker;

	CopperTinMinerOverlay(CopperTinMinerConfig config, CopperTinMinerTask task,
		AutomationManager automationManager, WebWalker webWalker)
	{
		this.config = config;
		this.task = task;
		this.automationManager = automationManager;
		this.webWalker = webWalker;
		setPosition(OverlayPosition.TOP_LEFT);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.showOverlay())
		{
			return null;
		}

		AutomationStatus automation = automationManager.status();
		WebWalkResult walk = webWalker.status();
		panelComponent.getChildren().add(TitleComponent.builder()
			.text("Copper & Tin Miner v" + CopperTinMinerPlugin.VERSION)
			.build());
		addLine("Status", task.getActivity());
		addLine("Mode", task.isBanking() ? "Banking" : "Mining");
		addLine("Bank trigger", "Full inventory");
		addLine("Next ore", task.getPreferredOre());

		WorldPoint target = task.getTarget();
		if (target != null)
		{
			addLine("Target", formatPoint(target));
		}

		addLine("Web walker", walk.getState().toString());
		if (walk.getPathLength() > 0)
		{
			addLine("Route", walk.getPathLength() + " tiles");
		}
		if (walk.getClickTarget() != null)
		{
			addLine("Next tile", formatPoint(walk.getClickTarget()));
		}
		if (walk.getMessage() != null && !walk.getMessage().isBlank())
		{
			addLine("Walker status", walk.getMessage());
		}
		if (automation.getStartedAtMillis() > 0L)
		{
			addLine("Runtime", formatRuntime(System.currentTimeMillis()
				- automation.getStartedAtMillis()));
		}
		if (automation.getFailureMessage() != null)
		{
			addLine("Failure", automation.getFailureMessage());
		}

		return super.render(graphics);
	}

	private void addLine(String left, String right)
	{
		panelComponent.getChildren().add(LineComponent.builder()
			.left(left)
			.right(right)
			.build());
	}

	private static String formatPoint(WorldPoint point)
	{
		return point.getX() + ", " + point.getY() + ", " + point.getPlane();
	}

	private static String formatRuntime(long elapsedMillis)
	{
		long seconds = Math.max(0L, elapsedMillis / 1_000L);
		long hours = seconds / 3_600L;
		long minutes = seconds % 3_600L / 60L;
		long remainingSeconds = seconds % 60L;
		return String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds);
	}
}
