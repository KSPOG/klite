/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.config.PluginConfigurationNavigator;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.ImageUtil;

/** Sidebar home for KLite-managed marketplace plugins. */
@Singleton
public class KLitePluginPanel extends PluginPanel
{
	private static final BufferedImage BRAND_IMAGE = ImageUtil.loadImageResource(
		KLitePluginPanel.class, "klite_marketplace.png");

	private final KLiteStreamedPluginService streamedPluginService;
	private final PluginConfigurationNavigator configurationNavigator;
	private final JPanel pluginList = new JPanel();
	private final JLabel operationStatus = new JLabel(" ");

	@Inject
	KLitePluginPanel(KLiteMarketplaceWindow marketplaceWindow,
		KLiteAccountPanel accountPanel,
		KLiteStreamedPluginService streamedPluginService,
		PluginConfigurationNavigator configurationNavigator)
	{
		this.streamedPluginService = streamedPluginService;
		this.configurationNavigator = configurationNavigator;

		setLayout(new BorderLayout(0, 12));
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		add(createHeader(), BorderLayout.NORTH);

		JPanel content = new JPanel(new BorderLayout(0, 12));
		content.setBackground(ColorScheme.DARK_GRAY_COLOR);
		content.add(accountPanel, BorderLayout.NORTH);
		content.add(createPluginList(), BorderLayout.CENTER);
		add(content, BorderLayout.CENTER);
		add(createActions(marketplaceWindow), BorderLayout.SOUTH);

		streamedPluginService.addChangeListener(this::refreshPlugins);
		SwingUtilities.invokeLater(this::refreshPlugins);
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

	private JScrollPane createPluginList()
	{
		pluginList.setBackground(ColorScheme.DARK_GRAY_COLOR);
		pluginList.setLayout(new BoxLayout(pluginList, BoxLayout.Y_AXIS));

		JScrollPane scrollPane = new JScrollPane(pluginList);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.getViewport().setBackground(ColorScheme.DARK_GRAY_COLOR);
		return scrollPane;
	}

	private JPanel createActions(KLiteMarketplaceWindow marketplaceWindow)
	{
		JPanel wrapper = new JPanel(new BorderLayout(0, 7));
		wrapper.setOpaque(false);
		wrapper.setBorder(BorderFactory.createEmptyBorder(8, 0, 0, 0));

		operationStatus.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
		operationStatus.setHorizontalAlignment(SwingConstants.CENTER);
		wrapper.add(operationStatus, BorderLayout.NORTH);

		JPanel actions = new JPanel(new GridLayout(1, 2, 6, 0));
		actions.setOpaque(false);
		JButton marketplaceButton = new JButton("Open Marketplace");
		marketplaceButton.addActionListener(event -> marketplaceWindow.open());
		actions.add(marketplaceButton);

		JButton logsButton = new JButton("KLite Logs");
		logsButton.setToolTipText("Open detailed marketplace loading and plugin lifecycle diagnostics");
		logsButton.addActionListener(event -> openLogWindow());
		actions.add(logsButton);
		wrapper.add(actions, BorderLayout.CENTER);
		return wrapper;
	}

	private void openLogWindow()
	{
		JFrame logFrame = new JFrame("KLite Marketplace Logs");
		logFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		logFrame.setIconImages(java.util.Arrays.asList(
			new ImageIcon(BRAND_IMAGE).getImage()));

		JTextArea logArea = new JTextArea(streamedPluginService.diagnosticsText());
		logArea.setEditable(false);
		logArea.setLineWrap(false);
		logArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		logArea.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		logArea.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
		logArea.setCaretPosition(logArea.getDocument().getLength());

		JScrollPane scrollPane = new JScrollPane(logArea);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);

		JPanel buttons = new JPanel(new GridLayout(1, 3, 8, 0));
		buttons.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		buttons.setBackground(ColorScheme.DARK_GRAY_COLOR);

		JButton refresh = new JButton("Refresh");
		refresh.addActionListener(event ->
		{
			logArea.setText(streamedPluginService.diagnosticsText());
			logArea.setCaretPosition(logArea.getDocument().getLength());
		});
		buttons.add(refresh);

		JButton copy = new JButton("Copy All");
		copy.addActionListener(event -> Toolkit.getDefaultToolkit().getSystemClipboard()
			.setContents(new StringSelection(logArea.getText()), null));
		buttons.add(copy);

		JButton clear = new JButton("Clear");
		clear.addActionListener(event ->
		{
			streamedPluginService.clearDiagnostics();
			logArea.setText(streamedPluginService.diagnosticsText());
		});
		buttons.add(clear);

		JPanel content = new JPanel(new BorderLayout());
		content.setBackground(ColorScheme.DARK_GRAY_COLOR);
		content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		content.add(scrollPane, BorderLayout.CENTER);
		content.add(buttons, BorderLayout.SOUTH);

		logFrame.setContentPane(content);
		logFrame.setMinimumSize(new Dimension(760, 480));
		logFrame.setSize(900, 620);
		logFrame.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
		logFrame.setVisible(true);
	}

	private void refreshPlugins()
	{
		pluginList.removeAll();
		List<KLiteStreamedPluginService.LoadedMarketplacePlugin> loaded =
			streamedPluginService.loadedMarketplacePlugins();
		if (loaded.isEmpty())
		{
			pluginList.add(createEmptyPluginList());
		}
		else
		{
			for (int index = 0; index < loaded.size(); index++)
			{
				if (index > 0)
				{
					pluginList.add(Box.createVerticalStrut(8));
				}
				pluginList.add(createPluginCard(loaded.get(index)));
			}
			pluginList.add(Box.createVerticalGlue());
		}
		pluginList.revalidate();
		pluginList.repaint();
	}

	private JPanel createPluginCard(KLiteStreamedPluginService.LoadedMarketplacePlugin loaded)
	{
		KLiteMarketplacePlugin marketplacePlugin = loaded.getMarketplacePlugin();
		JPanel card = new JPanel(new BorderLayout(0, 8));
		card.setAlignmentX(JPanel.LEFT_ALIGNMENT);
		card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 112));
		card.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		card.setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createLineBorder(ColorScheme.MEDIUM_GRAY_COLOR),
			BorderFactory.createEmptyBorder(10, 10, 10, 10)));

		JPanel heading = new JPanel(new BorderLayout(6, 0));
		heading.setOpaque(false);
		JLabel name = new JLabel(marketplacePlugin.getName());
		name.setForeground(ColorScheme.TEXT_COLOR);
		name.setFont(name.getFont().deriveFont(Font.BOLD, 13f));
		heading.add(name, BorderLayout.CENTER);
		JLabel state = new JLabel(loaded.isRunning() ? "Enabled" : "Loaded");
		state.setForeground(loaded.isRunning()
			? ColorScheme.PROGRESS_COMPLETE_COLOR : ColorScheme.LIGHT_GRAY_COLOR);
		heading.add(state, BorderLayout.EAST);
		card.add(heading, BorderLayout.NORTH);

		JLabel metadata = new JLabel("v" + marketplacePlugin.getVersion()
			+ " • " + marketplacePlugin.getType());
		metadata.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
		card.add(metadata, BorderLayout.CENTER);

		int columns = loaded.isConfigurable() ? 3 : 2;
		JPanel controls = new JPanel(new GridLayout(1, columns, 5, 0));
		controls.setOpaque(false);
		JButton toggle = new JButton(loaded.isRunning() ? "Disable" : "Enable");
		toggle.addActionListener(event -> runOperation(
			loaded.isRunning() ? "Disabling " : "Enabling ", marketplacePlugin.getName(),
			loaded.isRunning()
				? streamedPluginService.stop(marketplacePlugin.getId())
				: streamedPluginService.start(marketplacePlugin.getId())));
		controls.add(toggle);

		if (loaded.isConfigurable())
		{
			JButton configure = new JButton("Configure");
			configure.addActionListener(event ->
			{
				Plugin primary = loaded.getPrimaryPlugin();
				configurationNavigator.open(primary);
			});
			controls.add(configure);
		}

		JButton unload = new JButton("Unload");
		unload.addActionListener(event -> runOperation("Unloading ", marketplacePlugin.getName(),
			streamedPluginService.unload(marketplacePlugin.getId())));
		controls.add(unload);
		card.add(controls, BorderLayout.SOUTH);
		return card;
	}

	private void runOperation(String action, String pluginName, CompletableFuture<Void> operation)
	{
		operationStatus.setText(action + pluginName + "…");
		operation.whenComplete((ignored, error) -> SwingUtilities.invokeLater(() ->
		{
			if (error == null)
			{
				operationStatus.setText(pluginName + " updated.");
				operationStatus.setToolTipText(null);
			}
			else
			{
				String detail = KLiteStreamedPluginService.describe(error);
				operationStatus.setText("Unable to update " + pluginName + ". Open KLite Logs.");
				operationStatus.setToolTipText(detail);
			}
			refreshPlugins();
		}));
	}

	private static JPanel createEmptyPluginList()
	{
		JPanel container = new JPanel(new GridBagLayout());
		container.setAlignmentX(JPanel.LEFT_ALIGNMENT);
		container.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
		container.setBackground(ColorScheme.DARK_GRAY_COLOR);

		JPanel message = new JPanel();
		message.setOpaque(false);
		message.setLayout(new BoxLayout(message, BoxLayout.Y_AXIS));
		JLabel heading = new JLabel("No marketplace plugins loaded");
		heading.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setForeground(ColorScheme.TEXT_COLOR);
		heading.setFont(heading.getFont().deriveFont(Font.BOLD, 14f));
		JLabel explanation = new JLabel(
			"<html><div style='text-align:center'>Load a plugin from the marketplace.<br>It will appear here before it is enabled.</div></html>");
		explanation.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		explanation.setHorizontalAlignment(SwingConstants.CENTER);
		explanation.setForeground(ColorScheme.LIGHT_GRAY_COLOR);

		message.add(heading);
		message.add(Box.createVerticalStrut(7));
		message.add(explanation);
		container.add(message);
		return container;
	}
}
