/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.ImageUtil;

/**
 * Sidebar home for KLite-managed plugins.
 */
@Singleton
public class KLitePluginPanel extends PluginPanel
{
	private static final BufferedImage BRAND_IMAGE = ImageUtil.loadImageResource(
		KLitePluginPanel.class, "klite_marketplace.png");

	@Inject
	KLitePluginPanel(KLiteMarketplaceWindow marketplaceWindow)
	{
		setLayout(new BorderLayout(0, 16));
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		add(createHeader(), BorderLayout.NORTH);
		add(createEmptyPluginList(), BorderLayout.CENTER);
		add(createActions(marketplaceWindow), BorderLayout.SOUTH);
	}

	private static JPanel createHeader()
	{
		JPanel header = new JPanel();
		header.setOpaque(false);
		header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));

		BufferedImage logo = ImageUtil.resizeImage(BRAND_IMAGE, 82, 104, true);
		JLabel icon = new JLabel(new ImageIcon(logo));
		icon.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		JLabel title = new JLabel("KLite Plugins");
		title.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		title.setForeground(ColorScheme.TEXT_COLOR);
		title.setFont(title.getFont().deriveFont(Font.BOLD, 20f));

		header.add(icon);
		header.add(Box.createVerticalStrut(8));
		header.add(title);
		return header;
	}

	private static JPanel createEmptyPluginList()
	{
		JPanel container = new JPanel(new GridBagLayout());
		container.setBackground(ColorScheme.DARK_GRAY_COLOR);

		JPanel message = new JPanel();
		message.setOpaque(false);
		message.setLayout(new BoxLayout(message, BoxLayout.Y_AXIS));
		JLabel heading = new JLabel("No KLite plugins installed");
		heading.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setForeground(ColorScheme.TEXT_COLOR);
		heading.setFont(heading.getFont().deriveFont(Font.BOLD, 14f));
		JLabel explanation = new JLabel(
			"<html><div style='text-align:center'>Installed marketplace plugins<br>will be listed here.</div></html>");
		explanation.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		explanation.setHorizontalAlignment(SwingConstants.CENTER);
		explanation.setForeground(ColorScheme.LIGHT_GRAY_COLOR);

		message.add(heading);
		message.add(Box.createVerticalStrut(7));
		message.add(explanation);
		container.add(message);
		return container;
	}

	private static JPanel createActions(KLiteMarketplaceWindow marketplaceWindow)
	{
		JPanel actions = new JPanel(new BorderLayout());
		actions.setOpaque(false);
		actions.setBorder(BorderFactory.createEmptyBorder(8, 0, 0, 0));
		JButton marketplaceButton = new JButton("Open Marketplace");
		marketplaceButton.addActionListener(event -> marketplaceWindow.open());
		actions.add(marketplaceButton, BorderLayout.CENTER);
		return actions;
	}
}
