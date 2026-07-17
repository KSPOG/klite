/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import java.awt.BorderLayout;
import java.util.Optional;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import net.runelite.client.ui.ColorScheme;

/** KLite marketplace Discord login, restored session, and developer controls. */
@Singleton
class KLiteAccountPanel extends JPanel
{
	private final KLiteAccountService accountService;
	private final KLiteDiscordLoginFlow discordLoginFlow;
	private final KLiteDeveloperHotReloadService hotReloadService;
	private final JLabel status = new JLabel("Restoring marketplace account...");
	private final JButton action = new JButton("Sign in with Discord");
	private final JButton hotReload = new JButton("Enable hot reload");

	@Inject
	KLiteAccountPanel(KLiteAccountService accountService,
		KLiteDiscordLoginFlow discordLoginFlow,
		KLiteDeveloperHotReloadService hotReloadService)
	{
		this.accountService = accountService;
		this.discordLoginFlow = discordLoginFlow;
		this.hotReloadService = hotReloadService;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setOpaque(false);
		setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createLineBorder(ColorScheme.MEDIUM_GRAY_COLOR),
			BorderFactory.createEmptyBorder(12, 12, 12, 12)));

		JLabel heading = new JLabel("Marketplace account");
		heading.setForeground(ColorScheme.TEXT_COLOR);
		status.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
		action.setToolTipText(
			"Open Discord in your browser and authorize KLite");
		hotReload.setToolTipText("Watch "
			+ KLiteDeveloperHotReloadService.pluginDirectory()
			+ " for rebuilt plugin jars");
		hotReload.setVisible(false);
		hotReload.addActionListener(event -> toggleHotReload());
		action.addActionListener(event -> authenticate());

		add(heading);
		add(Box.createVerticalStrut(7));
		add(status);
		add(Box.createVerticalStrut(9));
		JPanel actionRow = new JPanel(new BorderLayout());
		actionRow.setOpaque(false);
		actionRow.add(action, BorderLayout.CENTER);
		add(actionRow);
		add(Box.createVerticalStrut(7));
		add(hotReload);

		accountService.addChangeListener(account ->
			SwingUtilities.invokeLater(() -> renderAccount(account)));
		SwingUtilities.invokeLater(() ->
			renderAccount(accountService.currentAccount()));
	}

	private void authenticate()
	{
		if (accountService.currentAccount().isPresent())
		{
			hotReloadService.disable();
			action.setEnabled(false);
			accountService.logout().whenComplete((ignored, error) ->
				SwingUtilities.invokeLater(() ->
				{
					action.setEnabled(true);
					if (error != null)
					{
						status.setText("Sign out failed: "
							+ rootMessage(error));
					}
				}));
			return;
		}

		action.setEnabled(false);
		status.setText("Opening Discord in your browser...");
		discordLoginFlow.login().whenComplete((account, error) ->
			SwingUtilities.invokeLater(() ->
			{
				action.setEnabled(true);
				if (error != null)
				{
					status.setText("Discord sign in failed: "
						+ rootMessage(error));
				}
			}));
	}

	private void renderAccount(Optional<KLiteAccountState> account)
	{
		if (account.isEmpty())
		{
			action.setText("Sign in with Discord");
			action.setEnabled(true);
			hotReloadService.disable();
			hotReload.setVisible(false);
			status.setText(
				"Sign in with Discord to access marketplace plugins");
			return;
		}

		KLiteAccountState current = account.get();
		action.setText("Sign out");
		action.setEnabled(true);
		hotReload.setVisible(current.hasCapability("plugin_dev"));
		hotReload.setText(hotReloadService.isEnabled()
			? "Disable hot reload" : "Enable hot reload");
		String identity = current.getDiscordName() == null
			? current.getUsername() : current.getDiscordName();
		status.setText("Signed in as " + identity + " - "
			+ current.getEntitlementPluginIds().size()
			+ " paid plugin(s)");
	}

	private void toggleHotReload()
	{
		boolean enabled =
			hotReloadService.setEnabled(!hotReloadService.isEnabled());
		hotReload.setText(enabled
			? "Disable hot reload" : "Enable hot reload");
		status.setText(enabled
			? "Watching " + KLiteDeveloperHotReloadService.pluginDirectory()
			: accountService.currentAccount()
				.map(account -> account.hasCapability("plugin_dev")
					? "Developer hot reload disabled"
					: "Plugin Dev access is required")
				.orElse("Sign in to enable hot reload"));
	}

	private static String rootMessage(Throwable error)
	{
		Throwable current = error;
		while (current.getCause() != null)
		{
			current = current.getCause();
		}
		return current.getMessage() == null
			? "Unknown error" : current.getMessage();
	}
}
