/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.Optional;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import net.runelite.client.ui.ColorScheme;

/** KLite marketplace account login, restored session, and developer controls. */
@Singleton
class KLiteAccountPanel extends JPanel
{
	private final KLiteAccountService accountService;
	private final KLiteDeveloperHotReloadService hotReloadService;
	private final JTextField email = new JTextField();
	private final JPasswordField password = new JPasswordField();
	private final JLabel status = new JLabel("Restoring marketplace account...");
	private final JButton action = new JButton("Sign in");
	private final JButton hotReload = new JButton("Enable hot reload");

	@Inject
	KLiteAccountPanel(KLiteAccountService accountService,
		KLiteDeveloperHotReloadService hotReloadService)
	{
		this.accountService = accountService;
		this.hotReloadService = hotReloadService;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setOpaque(false);
		setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createLineBorder(ColorScheme.MEDIUM_GRAY_COLOR),
			BorderFactory.createEmptyBorder(12, 12, 12, 12)));

		JLabel heading = new JLabel("Marketplace account");
		heading.setForeground(ColorScheme.TEXT_COLOR);
		status.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
		email.setToolTipText("KLite account email");
		password.setToolTipText("KLite account password");
		hotReload.setToolTipText("Watch " + KLiteDeveloperHotReloadService.pluginDirectory()
			+ " for rebuilt plugin jars");
		hotReload.setVisible(false);
		hotReload.addActionListener(event -> toggleHotReload());

		JPanel fields = new JPanel(new GridLayout(2, 1, 0, 7));
		fields.setOpaque(false);
		fields.add(email);
		fields.add(password);
		action.addActionListener(event -> authenticate());

		add(heading);
		add(Box.createVerticalStrut(7));
		add(status);
		add(Box.createVerticalStrut(9));
		add(fields);
		add(Box.createVerticalStrut(9));
		JPanel actionRow = new JPanel(new BorderLayout());
		actionRow.setOpaque(false);
		actionRow.add(action, BorderLayout.CENTER);
		add(actionRow);
		add(Box.createVerticalStrut(7));
		add(hotReload);

		accountService.addChangeListener(account ->
			SwingUtilities.invokeLater(() -> renderAccount(account)));
		SwingUtilities.invokeLater(() -> renderAccount(accountService.currentAccount()));
	}

	private void authenticate()
	{
		if (accountService.currentAccount().isPresent())
		{
			hotReloadService.disable();
			action.setEnabled(false);
			accountService.logout().whenComplete((ignored, error) -> SwingUtilities.invokeLater(() ->
			{
				action.setEnabled(true);
				if (error != null)
				{
					status.setText("Sign out failed: " + rootMessage(error));
				}
			}));
			return;
		}

		char[] secret = password.getPassword();
		String accountEmail = email.getText();
		if (accountEmail == null || accountEmail.isBlank() || secret.length == 0)
		{
			Arrays.fill(secret, '\0');
			status.setText("Enter your email and password");
			return;
		}
		action.setEnabled(false);
		status.setText("Signing in...");
		accountService.login(accountEmail, secret).whenComplete((account, error) ->
		{
			Arrays.fill(secret, '\0');
			SwingUtilities.invokeLater(() ->
			{
				password.setText("");
				action.setEnabled(true);
				if (error != null)
				{
					status.setText("Sign in failed: " + rootMessage(error));
				}
			});
		});
	}

	private void renderAccount(Optional<KLiteAccountState> account)
	{
		if (account.isEmpty())
		{
			email.setText("");
			email.setEnabled(true);
			password.setText("");
			password.setEnabled(true);
			action.setText("Sign in");
			action.setEnabled(true);
			hotReloadService.disable();
			hotReload.setVisible(false);
			status.setText("Sign in to access paid plugins");
			return;
		}

		KLiteAccountState current = account.get();
		email.setText(current.getEmail());
		email.setEnabled(false);
		password.setText("");
		password.setEnabled(false);
		action.setText("Sign out");
		action.setEnabled(true);
		hotReload.setVisible(current.hasCapability("plugin_dev"));
		hotReload.setText(hotReloadService.isEnabled()
			? "Disable hot reload" : "Enable hot reload");
		status.setText("Signed in as " + current.getUsername()
			+ " - " + current.getEntitlementPluginIds().size() + " paid plugin(s)");
	}

	private void toggleHotReload()
	{
		boolean enabled = hotReloadService.setEnabled(!hotReloadService.isEnabled());
		hotReload.setText(enabled ? "Disable hot reload" : "Enable hot reload");
		status.setText(enabled
			? "Watching " + KLiteDeveloperHotReloadService.pluginDirectory()
			: accountService.currentAccount()
				.map(account -> account.hasCapability("plugin_dev")
					? "Developer hot reload disabled" : "Plugin Dev access is required")
				.orElse("Sign in to enable hot reload"));
	}

	private static String rootMessage(Throwable error)
	{
		Throwable current = error;
		while (current.getCause() != null)
		{
			current = current.getCause();
		}
		return current.getMessage() == null ? "Unknown error" : current.getMessage();
	}
}
