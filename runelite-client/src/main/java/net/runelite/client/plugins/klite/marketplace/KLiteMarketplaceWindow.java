/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import javax.annotation.Nullable;
import javax.inject.Singleton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.util.ImageUtil;

/**
 * Standalone KLite plugin marketplace shell.
 *
 * <p>The window intentionally does not download or execute plugins until a
 * signed KLite catalog and verification policy are available.</p>
 */
@Singleton
public class KLiteMarketplaceWindow
{
	private static final int WINDOW_WIDTH = 760;
	private static final int WINDOW_HEIGHT = 560;
	private static final BufferedImage BRAND_IMAGE = ImageUtil.loadImageResource(
		KLiteMarketplaceWindow.class, "klite_marketplace.png");

	@Nullable
	private JFrame frame;

	public void open()
	{
		SwingUtilities.invokeLater(this::showWindow);
	}

	public void close()
	{
		SwingUtilities.invokeLater(() ->
		{
			if (frame != null)
			{
				frame.dispose();
				frame = null;
			}
		});
	}

	private void showWindow()
	{
		assert SwingUtilities.isEventDispatchThread() : "must be on EDT";
		if (frame == null)
		{
			frame = createFrame();
		}

		frame.setState(Frame.NORMAL);
		frame.setVisible(true);
		frame.toFront();
		frame.requestFocus();
	}

	private static JFrame createFrame()
	{
		JFrame marketplaceFrame = new JFrame("KLite Plugin Marketplace");
		marketplaceFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		marketplaceFrame.setIconImages(Arrays.asList(ClientUI.ICON_128, ClientUI.ICON_16));
		marketplaceFrame.setMinimumSize(new Dimension(640, 480));
		marketplaceFrame.setContentPane(createContent());
		marketplaceFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		marketplaceFrame.setLocationRelativeTo(null);
		return marketplaceFrame;
	}

	private static JPanel createContent()
	{
		JPanel content = new JPanel(new BorderLayout());
		content.setBackground(ColorScheme.DARK_GRAY_COLOR);
		content.add(createHeader(), BorderLayout.NORTH);
		content.add(createCatalogArea(), BorderLayout.CENTER);

		JLabel footer = new JLabel("Catalog source: not configured");
		footer.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
		footer.setBorder(BorderFactory.createEmptyBorder(10, 20, 14, 20));
		content.add(footer, BorderLayout.SOUTH);
		return content;
	}

	private static JPanel createHeader()
	{
		JPanel header = new JPanel(new BorderLayout(18, 0));
		header.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		header.setBorder(BorderFactory.createEmptyBorder(18, 22, 18, 22));

		BufferedImage logo = ImageUtil.resizeImage(BRAND_IMAGE, 72, 86, true);
		header.add(new JLabel(new ImageIcon(logo)), BorderLayout.WEST);

		JPanel copy = new JPanel();
		copy.setOpaque(false);
		copy.setLayout(new BoxLayout(copy, BoxLayout.Y_AXIS));
		JLabel title = new JLabel("KLite Plugin Marketplace");
		title.setForeground(ColorScheme.TEXT_COLOR);
		title.setFont(title.getFont().deriveFont(Font.BOLD, 25f));
		JLabel subtitle = new JLabel("Discover and manage extensions built for KLite.");
		subtitle.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
		copy.add(Box.createVerticalGlue());
		copy.add(title);
		copy.add(Box.createVerticalStrut(7));
		copy.add(subtitle);
		copy.add(Box.createVerticalGlue());
		header.add(copy, BorderLayout.CENTER);
		return header;
	}

	private static JPanel createCatalogArea()
	{
		JPanel catalogArea = new JPanel(new BorderLayout(0, 18));
		catalogArea.setBackground(ColorScheme.DARK_GRAY_COLOR);
		catalogArea.setBorder(BorderFactory.createEmptyBorder(20, 24, 20, 24));

		JTextField search = new JTextField("Search KLite plugins");
		search.setEnabled(false);
		search.setToolTipText("Search becomes available when a catalog source is configured");
		search.setPreferredSize(new Dimension(0, 34));
		catalogArea.add(search, BorderLayout.NORTH);

		JPanel emptyState = new JPanel(new GridBagLayout());
		emptyState.setBackground(ColorScheme.DARK_GRAY_COLOR);
		JPanel message = new JPanel();
		message.setOpaque(false);
		message.setLayout(new BoxLayout(message, BoxLayout.Y_AXIS));

		BufferedImage emptyLogo = ImageUtil.resizeImage(BRAND_IMAGE, 126, 156, true);
		JLabel icon = new JLabel(new ImageIcon(emptyLogo));
		icon.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		JLabel heading = new JLabel("The marketplace is ready for future plugins");
		heading.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setForeground(ColorScheme.TEXT_COLOR);
		heading.setFont(heading.getFont().deriveFont(Font.BOLD, 17f));
		JLabel explanation = new JLabel(
			"A verified KLite catalog will appear here when its distribution service is configured.");
		explanation.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		explanation.setHorizontalAlignment(SwingConstants.CENTER);
		explanation.setForeground(ColorScheme.LIGHT_GRAY_COLOR);

		message.add(icon);
		message.add(Box.createVerticalStrut(12));
		message.add(heading);
		message.add(Box.createVerticalStrut(7));
		message.add(explanation);
		emptyState.add(message);
		catalogArea.add(emptyState, BorderLayout.CENTER);
		return catalogArea;
	}
}
