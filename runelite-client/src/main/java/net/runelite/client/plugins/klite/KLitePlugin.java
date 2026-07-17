/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite;

import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import net.runelite.api.events.AccountHashChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.gameval.InventoryID;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.RuneScapeProfileChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.klite.api.DefaultKLiteClientApi;
import net.runelite.client.plugins.klite.api.KLiteClientApi;
import net.runelite.client.plugins.klite.automation.AutomationManager;
import net.runelite.client.plugins.klite.marketplace.KLiteMarketplaceWindow;
import net.runelite.client.plugins.klite.marketplace.KLitePluginPanel;
import net.runelite.client.plugins.klite.update.KLiteUpdateService;
import net.runelite.client.plugins.klite.walker.DefaultWebWalker;
import net.runelite.client.plugins.klite.walker.WebWalkBankCache;
import net.runelite.client.plugins.klite.walker.WebWalker;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "KLite Core",
	description = "KLite client information and distribution settings",
	tags = {"klite", "client", "status"}
)
public class KLitePlugin extends Plugin
{
	static final String CONFIG_GROUP = "klite";

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private KLiteOverlay overlay;

	@Inject
	private KLiteConfig config;

	@Inject
	private AutomationManager automationManager;

	@Inject
	private DefaultWebWalker webWalker;

	@Inject
	private WebWalkBankCache bankCache;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private KLiteMarketplaceWindow marketplaceWindow;

	@Inject
	private KLitePluginPanel pluginPanel;

	@Inject
	private KLiteUpdateService updateService;

	private NavigationButton marketplaceButton;

	@Provides
	KLiteConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(KLiteConfig.class);
	}

	@Provides
	KLiteClientApi provideClientApi(DefaultKLiteClientApi clientApi)
	{
		return clientApi;
	}

	@Provides
	WebWalker provideWebWalker(DefaultWebWalker defaultWebWalker)
	{
		return defaultWebWalker;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (CONFIG_GROUP.equals(event.getGroup()) && "enableAutomation".equals(event.getKey()))
		{
			automationManager.setEnabled(config.enableAutomation());
		}
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getContainerId() == InventoryID.BANK)
		{
			bankCache.update(event.getItemContainer());
		}
	}

	@Subscribe
	public void onAccountHashChanged(AccountHashChanged event)
	{
		bankCache.onAccountChanged();
	}

	@Subscribe
	public void onRuneScapeProfileChanged(RuneScapeProfileChanged event)
	{
		bankCache.onAccountChanged();
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
		automationManager.setEnabled(config.enableAutomation());
		bankCache.onAccountChanged();

		BufferedImage sourceIcon = ImageUtil.loadImageResource(
			KLitePlugin.class, "marketplace/klite_marketplace.png");
		BufferedImage scaledIcon = ImageUtil.resizeImage(sourceIcon, 32, 32, true);
		BufferedImage icon = ImageUtil.resizeCanvas(scaledIcon, 32, 32);
		marketplaceButton = NavigationButton.builder()
			.tooltip("KLite Plugins")
			.icon(icon)
			.priority(1)
			.panel(pluginPanel)
			.build();
		clientToolbar.addNavigation(marketplaceButton);

		if (config.checkForClientUpdates())
		{
			updateService.checkForUpdates(pluginPanel, false);
		}
	}

	@Override
	protected void shutDown()
	{
		updateService.cancel();
		clientToolbar.removeNavigation(marketplaceButton);
		marketplaceWindow.close();
		automationManager.setEnabled(false);
		webWalker.shutdown();
		bankCache.clearMemory();
		overlayManager.remove(overlay);
	}
}
