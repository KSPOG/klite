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
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.util.ImageUtil;

/**
 * Standalone browser and runtime controller for the KLite plugin catalog.
 *
 * <p>Runnable artifacts are verified and held in memory only.</p>
 */
@Singleton
public class KLiteMarketplaceWindow
{
	private static final int WINDOW_WIDTH = 760;
	private static final int WINDOW_HEIGHT = 560;
	private static final BufferedImage BRAND_IMAGE = ImageUtil.loadImageResource(
		KLiteMarketplaceWindow.class, "klite_marketplace.png");

	private final KLiteMarketplaceClient marketplaceClient;
	private final KLiteAccountService accountService;
	private final KLiteStreamedPluginService streamedPluginService;
	private List<KLiteMarketplacePlugin> plugins = Collections.emptyList();

	@Nullable
	private JFrame frame;
	private JPanel catalogList;
	private JTextField search;
	private JComboBox<String> categoryFilter;
	private JComboBox<String> typeFilter;
	private JComboBox<String> orderFilter;
	private JButton refreshButton;
	private JLabel footer;
	private boolean loading;
	private boolean updatingFilters;

	@Inject
	KLiteMarketplaceWindow(KLiteMarketplaceClient marketplaceClient,
		KLiteAccountService accountService,
		KLiteStreamedPluginService streamedPluginService)
	{
		this.marketplaceClient = marketplaceClient;
		this.accountService = accountService;
		this.streamedPluginService = streamedPluginService;
	}

	public void open()
	{
		SwingUtilities.invokeLater(() ->
		{
			showWindow();
			refreshCatalog();
		});
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

	private JFrame createFrame()
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

	private JPanel createContent()
	{
		JPanel content = new JPanel(new BorderLayout());
		content.setBackground(ColorScheme.DARK_GRAY_COLOR);
		content.add(createHeader(), BorderLayout.NORTH);
		content.add(createCatalogArea(), BorderLayout.CENTER);

		footer = new JLabel("Catalog source: " + marketplaceClient.getCatalogUrl().host());
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
		JLabel subtitle = new JLabel("Discover reviewed extensions published for KLite.");
		subtitle.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
		copy.add(Box.createVerticalGlue());
		copy.add(title);
		copy.add(Box.createVerticalStrut(7));
		copy.add(subtitle);
		copy.add(Box.createVerticalGlue());
		header.add(copy, BorderLayout.CENTER);
		return header;
	}

	private JPanel createCatalogArea()
	{
		JPanel catalogArea = new JPanel(new BorderLayout(0, 14));
		catalogArea.setBackground(ColorScheme.DARK_GRAY_COLOR);
		catalogArea.setBorder(BorderFactory.createEmptyBorder(20, 24, 20, 24));

		JPanel controls = new JPanel(new BorderLayout(10, 10));
		controls.setOpaque(false);
		search = new JTextField();
		search.setEnabled(false);
		search.setToolTipText("Search the loaded KLite plugin catalog");
		search.setPreferredSize(new Dimension(0, 34));
		search.getDocument().addDocumentListener(new DocumentListener()
		{
			@Override
			public void insertUpdate(DocumentEvent event)
			{
				renderCatalog();
			}

			@Override
			public void removeUpdate(DocumentEvent event)
			{
				renderCatalog();
			}

			@Override
			public void changedUpdate(DocumentEvent event)
			{
				renderCatalog();
			}
		});
		controls.add(search, BorderLayout.CENTER);

		JPanel filters = new JPanel(new GridLayout(1, 3, 10, 0));
		filters.setOpaque(false);
		categoryFilter = new JComboBox<>(new String[]{"All categories"});
		categoryFilter.addActionListener(event -> renderCatalog());
		filters.add(categoryFilter);
		typeFilter = new JComboBox<>(new String[]{"All types"});
		typeFilter.addActionListener(event -> renderCatalog());
		filters.add(typeFilter);
		orderFilter = new JComboBox<>(new String[]{
			"Trending today",
			"Trending this week",
			"Trending this month",
			"Recently updated",
			"Recently released",
			"Name"
		});
		orderFilter.addActionListener(event -> renderCatalog());
		filters.add(orderFilter);
		controls.add(filters, BorderLayout.SOUTH);

		refreshButton = new JButton("Refresh");
		refreshButton.addActionListener(event -> refreshCatalog());
		controls.add(refreshButton, BorderLayout.EAST);
		catalogArea.add(controls, BorderLayout.NORTH);

		catalogList = new JPanel();
		catalogList.setBackground(ColorScheme.DARK_GRAY_COLOR);
		catalogList.setLayout(new BoxLayout(catalogList, BoxLayout.Y_AXIS));
		showCatalogStatus("Open the marketplace to load the catalog.");

		JScrollPane scrollPane = new JScrollPane(catalogList);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.getViewport().setBackground(ColorScheme.DARK_GRAY_COLOR);
		catalogArea.add(scrollPane, BorderLayout.CENTER);
		return catalogArea;
	}

	private void refreshCatalog()
	{
		assert SwingUtilities.isEventDispatchThread() : "must be on EDT";
		if (loading)
		{
			return;
		}

		loading = true;
		search.setEnabled(false);
		refreshButton.setEnabled(false);
		footer.setText("Loading catalog from " + marketplaceClient.getCatalogUrl().host() + "…");
		showCatalogStatus("Loading reviewed plugins…");

		marketplaceClient.fetchCatalog().whenComplete((catalog, error) -> SwingUtilities.invokeLater(() ->
		{
			loading = false;
			refreshButton.setEnabled(true);
			if (error != null)
			{
				plugins = Collections.emptyList();
				footer.setText("Catalog unavailable — no remote code was loaded");
				showCatalogStatus("Unable to load the marketplace catalog. Check your connection and try again.");
				return;
			}

			plugins = catalog.getPlugins();
			updateFilters(catalog);
			search.setEnabled(true);
			footer.setText("Catalog source: " + marketplaceClient.getCatalogUrl().host()
				+ " • " + plugins.size() + " reviewed plugin" + (plugins.size() == 1 ? "" : "s"));
			renderCatalog();
		}));
	}

	private void updateFilters(KLiteMarketplaceCatalog catalog)
	{
		updatingFilters = true;
		String selectedCategory = categoryFilter.getSelectedIndex() == 0
			? null : (String) categoryFilter.getSelectedItem();
		String selectedType = typeFilter.getSelectedIndex() == 0
			? null : (String) typeFilter.getSelectedItem();

		categoryFilter.removeAllItems();
		categoryFilter.addItem("All categories");
		for (String category : catalog.getCategories())
		{
			categoryFilter.addItem(category);
		}
		typeFilter.removeAllItems();
		typeFilter.addItem("All types");
		for (String type : catalog.getTypes())
		{
			typeFilter.addItem(type);
		}
		if (selectedCategory != null)
		{
			categoryFilter.setSelectedItem(selectedCategory);
		}
		if (selectedType != null)
		{
			typeFilter.setSelectedItem(selectedType);
		}
		updatingFilters = false;
	}

	private void renderCatalog()
	{
		if (updatingFilters || catalogList == null || search == null)
		{
			return;
		}

		String query = search.getText().trim().toLowerCase(Locale.ROOT);
		String selectedCategory = categoryFilter.getSelectedIndex() == 0
			? null : (String) categoryFilter.getSelectedItem();
		String selectedType = typeFilter.getSelectedIndex() == 0
			? null : (String) typeFilter.getSelectedItem();
		List<KLiteMarketplacePlugin> orderedPlugins = new ArrayList<>(plugins);
		orderedPlugins.sort(getOrderComparator());
		catalogList.removeAll();
		int visiblePluginCount = 0;
		for (KLiteMarketplacePlugin plugin : orderedPlugins)
		{
			String searchable = (plugin.getName() + " " + plugin.getAuthorsDisplay() + " "
				+ plugin.getDescription() + " "
				+ String.join(" ", plugin.getDescriptor().getTags()) + " "
				+ String.join(" ", plugin.getCategories()) + " " + plugin.getType())
				.toLowerCase(Locale.ROOT);
			if (!searchable.contains(query)
				|| (selectedCategory != null && !plugin.getCategories().contains(selectedCategory))
				|| (selectedType != null && !selectedType.equals(plugin.getType())))
			{
				continue;
			}

			if (visiblePluginCount++ > 0)
			{
				catalogList.add(Box.createVerticalStrut(10));
			}
			catalogList.add(createPluginCard(plugin));
		}

		if (visiblePluginCount == 0)
		{
			showCatalogStatus(plugins.isEmpty()
				? "No reviewed plugins have been published yet."
				: "No plugins match your search.");
			return;
		}

		catalogList.add(Box.createVerticalGlue());
		catalogList.revalidate();
		catalogList.repaint();
	}

	private Comparator<KLiteMarketplacePlugin> getOrderComparator()
	{
		Comparator<KLiteMarketplacePlugin> comparator;
		switch (orderFilter.getSelectedIndex())
		{
			case 1:
				comparator = Comparator.comparingInt(KLiteMarketplacePlugin::getTrendingWeek).reversed();
				break;
			case 2:
				comparator = Comparator.comparingInt(KLiteMarketplacePlugin::getTrendingMonth).reversed();
				break;
			case 3:
				comparator = Comparator.comparing(KLiteMarketplacePlugin::getUpdatedAt).reversed();
				break;
			case 4:
				comparator = Comparator.comparing(KLiteMarketplacePlugin::getReleasedAt).reversed();
				break;
			case 5:
				return Comparator.comparing(KLiteMarketplacePlugin::getName, String.CASE_INSENSITIVE_ORDER);
			default:
				comparator = Comparator.comparingInt(KLiteMarketplacePlugin::getTrendingDay).reversed();
				break;
		}
		return comparator.thenComparing(KLiteMarketplacePlugin::getName, String.CASE_INSENSITIVE_ORDER);
	}

	private JPanel createPluginCard(KLiteMarketplacePlugin plugin)
	{
		JPanel card = new JPanel(new BorderLayout(14, 10));
		card.setAlignmentX(JPanel.LEFT_ALIGNMENT);
		card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
		card.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		card.setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createLineBorder(ColorScheme.MEDIUM_GRAY_COLOR),
			BorderFactory.createEmptyBorder(14, 16, 14, 16)));

		JPanel heading = new JPanel(new BorderLayout());
		heading.setOpaque(false);
		JLabel name = new JLabel(plugin.getName());
		name.setForeground(ColorScheme.TEXT_COLOR);
		name.setFont(name.getFont().deriveFont(Font.BOLD, 16f));
		heading.add(name, BorderLayout.WEST);

		boolean paid = "Premium".equals(plugin.getType()) || "Supporter".equals(plugin.getType());
		boolean entitled = paid && accountService.hasEntitlement(plugin.getId());
		String statusText = paid
			? entitled ? "Owned"
				: accountService.currentAccount().isPresent() ? "Locked" : "Sign in required"
			: formatStatus(plugin.getStatus());
		boolean running = streamedPluginService.isRunning(plugin.getId());
		boolean pluginLoading = streamedPluginService.isLoading(plugin.getId());
		JLabel status = new JLabel(statusText);
		status.setForeground(running || entitled || "bundled".equals(plugin.getStatus())
			? ColorScheme.PROGRESS_COMPLETE_COLOR : ColorScheme.LIGHT_GRAY_COLOR);
		JPanel controls = new JPanel();
		controls.setOpaque(false);
		controls.add(status);
		if ("available".equals(plugin.getStatus()))
		{
			JButton action = new JButton(running ? "Stop" : pluginLoading ? "Loading..." : "Run");
			action.setEnabled(!pluginLoading && (!paid || entitled));
			action.setToolTipText(paid && !entitled
				? "Sign in with an entitled account to run this plugin"
				: "Runs from verified memory without installing a JAR");
			action.addActionListener(event ->
			{
				action.setEnabled(false);
				action.setText(running ? "Stopping..." : "Loading...");
				CompletableFuture<Void> operation = running
					? streamedPluginService.stop(plugin.getId())
					: streamedPluginService.run(plugin);
				operation.whenComplete((ignored, error) -> SwingUtilities.invokeLater(() ->
				{
					if (error == null)
					{
						footer.setText(running ? plugin.getName() + " stopped; memory released"
							: plugin.getName() + " is running from memory");
					}
					else
					{
						Throwable cause = error.getCause() == null ? error : error.getCause();
						footer.setText("Could not " + (running ? "stop " : "run ")
							+ plugin.getName() + ": " + cause.getMessage());
					}
					renderCatalog();
				}));
			});
			controls.add(action);
		}
		heading.add(controls, BorderLayout.EAST);
		card.add(heading, BorderLayout.NORTH);

		BufferedImage fallbackImage = ImageUtil.resizeImage(BRAND_IMAGE, 56, 56, true);
		JLabel pluginIcon = new JLabel(new ImageIcon(ImageUtil.resizeCanvas(fallbackImage, 56, 56)));
		pluginIcon.setPreferredSize(new Dimension(64, 64));
		pluginIcon.setHorizontalAlignment(SwingConstants.CENTER);
		card.add(pluginIcon, BorderLayout.WEST);
		if (plugin.getIconPath() != null)
		{
			marketplaceClient.fetchIcon(plugin).whenComplete((image, error) ->
			{
				if (image != null)
				{
					SwingUtilities.invokeLater(() ->
					{
						BufferedImage scaledImage = ImageUtil.resizeImage(image, 56, 56, true);
						pluginIcon.setIcon(new ImageIcon(ImageUtil.resizeCanvas(scaledImage, 56, 56)));
					});
				}
			});
		}

		JTextArea description = new JTextArea(plugin.getDescription());
		description.setEditable(false);
		description.setFocusable(false);
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		description.setOpaque(false);
		description.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
		description.setFont(name.getFont().deriveFont(Font.PLAIN, 13f));
		card.add(description, BorderLayout.CENTER);

		JLabel metadata = new JLabel("By " + plugin.getAuthorsDisplay() + " • v" + plugin.getVersion()
			+ " • " + plugin.getType() + " • " + String.join(", ", plugin.getCategories())
			+ " • KLite " + plugin.getMinimumClientVersion() + "+");
		metadata.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
		card.add(metadata, BorderLayout.SOUTH);
		return card;
	}

	private static String formatStatus(String status)
	{
		switch (status)
		{
			case "bundled":
				return "Bundled";
			case "available":
				return "Available";
			default:
				return "Coming soon";
		}
	}

	private void showCatalogStatus(String text)
	{
		catalogList.removeAll();
		JPanel emptyState = new JPanel(new GridBagLayout());
		emptyState.setAlignmentX(JPanel.LEFT_ALIGNMENT);
		emptyState.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
		emptyState.setBackground(ColorScheme.DARK_GRAY_COLOR);

		JLabel message = new JLabel(text, SwingConstants.CENTER);
		message.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
		emptyState.add(message);
		catalogList.add(emptyState);
		catalogList.revalidate();
		catalogList.repaint();
	}
}
