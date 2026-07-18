/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.launcher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

/** Account-oriented UI for the standalone KLite launcher. */
final class KLiteLauncherFrame extends JFrame
{
	private static final Color CYAN = new Color(0, 191, 255);
	private static final Color ORANGE = new Color(255, 145, 32);
	private static final Color PANEL = new Color(17, 24, 32);
	private static final DateTimeFormatter IMPORTED_FORMAT =
		DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm").withZone(ZoneId.systemDefault());

	private final KLiteAccountVault vault;
	private final KLiteProcessLauncher processLauncher;
	private final KLiteLauncherUpdateService updateService;
	private final DefaultListModel<KLiteAccountVault.AccountSummary> accountModel =
		new DefaultListModel<>();
	private final JList<KLiteAccountVault.AccountSummary> accountList = new JList<>(accountModel);
	private final JLabel status = new JLabel("Ready");
	private final JButton launchButton = new JButton("Launch KLite");
	private final Map<String, Process> runningClients = new HashMap<>();
	private boolean updateCheckComplete;

	KLiteLauncherFrame(KLiteAccountVault vault, KLiteProcessLauncher processLauncher,
		KLiteLauncherUpdateService updateService)
	{
		super("KLite Launcher");
		this.vault = vault;
		this.processLauncher = processLauncher;
		this.updateService = updateService;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(880, 560));
		setSize(980, 620);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		applyIcon();

		add(createSidebar(), BorderLayout.WEST);
		add(createAccountsPanel(), BorderLayout.CENTER);
		add(createStatusBar(), BorderLayout.SOUTH);
		refreshAccounts();
	}

	void captureOfficialLauncherAccount(Map<String, String> environment)
	{
		try
		{
			Optional<KLiteAccountVault.AccountSummary> imported = vault.importEnvironment(environment);
			if (imported.isPresent())
			{
				refreshAccounts();
				select(imported.get().getId());
				status.setText("Saved " + imported.get().getDisplayName()
					+ " securely for this Windows user");
			}
		}
		catch (IOException exception)
		{
			showError("KLite could not save the account supplied by the official Jagex Launcher.",
				exception);
		}
	}

	void startAutomaticUpdateCheck()
	{
		updateCheckComplete = false;
		updateActions();
		status.setText("Checking for KLite Launcher and client updates...");
		new SwingWorker<KLiteLauncherUpdateService.UpdateResult, Void>()
		{
			@Override
			protected KLiteLauncherUpdateService.UpdateResult doInBackground() throws Exception
			{
				return updateService.checkAndDownload();
			}

			@Override
			protected void done()
			{
				try
				{
					handleUpdateResult(get());
				}
				catch (Exception exception)
				{
					updateCheckComplete = true;
					status.setText("Update check failed; using the installed KLite version");
					JOptionPane.showMessageDialog(KLiteLauncherFrame.this,
						"KLite could not check or download updates. The installed version "
							+ "can still be used.\n" + rootMessage(exception),
						"KLite Update", JOptionPane.WARNING_MESSAGE);
				}
				updateActions();
			}
		}.execute();
	}

	private void handleUpdateResult(KLiteLauncherUpdateService.UpdateResult result)
		throws IOException
	{
		if (result.getStatus() == KLiteLauncherUpdateService.Status.UPDATE_READY)
		{
			status.setText("KLite " + result.getVersion() + " is downloaded and verified");
			int choice = JOptionPane.showConfirmDialog(this,
				"KLite " + result.getVersion() + " is ready.\n\n"
					+ "Install the update now? The launcher will close and restart through "
					+ "the verified installer.",
				"KLite Update", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (choice == JOptionPane.YES_OPTION)
			{
				updateService.installAfterExit(result.getInstaller());
				dispose();
				System.exit(0);
			}
		}
		else if (result.getStatus() == KLiteLauncherUpdateService.Status.CURRENT)
		{
			status.setText("KLite Launcher and client are current at " + result.getVersion());
		}
		else
		{
			status.setText("Development build; automatic packaged updates are disabled");
		}
		updateCheckComplete = true;
	}

	private JPanel createSidebar()
	{
		JPanel sidebar = new JPanel(new GridBagLayout());
		sidebar.setPreferredSize(new Dimension(230, 0));
		sidebar.setBackground(new Color(8, 14, 20));
		sidebar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(38, 52, 64)));
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.weightx = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;

		JLabel title = new JLabel("KLITE");
		title.setFont(title.getFont().deriveFont(Font.BOLD, 30f));
		title.setForeground(CYAN);
		constraints.gridy = 0;
		constraints.insets = new Insets(30, 24, 2, 24);
		sidebar.add(title, constraints);

		JLabel subtitle = new JLabel("ELITE OSRS CLIENT");
		subtitle.setForeground(new Color(160, 174, 186));
		constraints.gridy = 1;
		constraints.insets = new Insets(0, 24, 34, 24);
		sidebar.add(subtitle, constraints);

		constraints.gridy = 2;
		constraints.insets = new Insets(0, 12, 8, 12);
		sidebar.add(navigationLabel("Accounts", CYAN), constraints);
		constraints.gridy = 3;
		JLabel autoLogin = navigationLabel("AutoLogin", new Color(190, 198, 207));
		autoLogin.setToolTipText("Launch a saved character without selecting it in Jagex Launcher.");
		sidebar.add(autoLogin, constraints);

		constraints.gridy = 4;
		constraints.weighty = 1;
		sidebar.add(new JPanel(), constraints);
		JLabel security = new JLabel("Protected by Windows DPAPI");
		security.setForeground(new Color(104, 176, 126));
		security.setFont(security.getFont().deriveFont(11f));
		constraints.gridy = 5;
		constraints.weighty = 0;
		constraints.insets = new Insets(12, 24, 24, 24);
		sidebar.add(security, constraints);
		return sidebar;
	}

	private JPanel createAccountsPanel()
	{
		JPanel content = new JPanel(new BorderLayout(0, 18));
		content.setBorder(BorderFactory.createEmptyBorder(30, 34, 26, 34));

		JPanel heading = new JPanel(new BorderLayout());
		JPanel headingText = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.anchor = GridBagConstraints.WEST;
		JLabel title = new JLabel("Accounts");
		title.setFont(title.getFont().deriveFont(Font.BOLD, 28f));
		headingText.add(title, constraints);
		constraints.gridy = 1;
		JLabel description = new JLabel("Launch saved Jagex characters in isolated KLite profiles.");
		description.setForeground(new Color(157, 170, 181));
		headingText.add(description, constraints);
		heading.add(headingText, BorderLayout.WEST);

		JButton addAccount = new JButton("Add Jagex account");
		addAccount.addActionListener(event -> showEnrollmentInstructions());
		heading.add(addAccount, BorderLayout.EAST);
		content.add(heading, BorderLayout.NORTH);

		accountList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		accountList.setFixedCellHeight(72);
		accountList.setCellRenderer(new AccountRenderer());
		accountList.addListSelectionListener(event -> updateActions());
		accountList.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent event)
			{
				if (event.getClickCount() == 2)
				{
					launchSelected();
				}
			}
		});
		JScrollPane scrollPane = new JScrollPane(accountList);
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(42, 58, 70)));
		content.add(scrollPane, BorderLayout.CENTER);

		JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
		JButton removeButton = new JButton("Remove");
		removeButton.addActionListener(event -> removeSelected());
		actions.add(removeButton);
		launchButton.setBackground(new Color(0, 119, 168));
		launchButton.addActionListener(event -> launchSelected());
		actions.add(launchButton);
		content.add(actions, BorderLayout.SOUTH);
		return content;
	}

	private JPanel createStatusBar()
	{
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createCompoundBorder(
			new JSeparator(SwingConstants.HORIZONTAL).getBorder(),
			BorderFactory.createEmptyBorder(8, 18, 8, 18)));
		status.setForeground(new Color(150, 164, 176));
		panel.add(status, BorderLayout.WEST);
		JLabel version = new JLabel("Secure account launcher");
		version.setForeground(ORANGE);
		panel.add(version, BorderLayout.EAST);
		return panel;
	}

	private void refreshAccounts()
	{
		String selectedId = accountList.getSelectedValue() == null
			? null : accountList.getSelectedValue().getId();
		try
		{
			List<KLiteAccountVault.AccountSummary> accounts = vault.list();
			accountModel.clear();
			accounts.forEach(accountModel::addElement);
			if (selectedId != null)
			{
				select(selectedId);
			}
			if (accountModel.size() == 1 && accountList.getSelectedIndex() < 0)
			{
				accountList.setSelectedIndex(0);
			}
			status.setText(accounts.isEmpty()
				? "No saved accounts. Add one through the official Jagex Launcher."
				: accounts.size() + (accounts.size() == 1 ? " saved account" : " saved accounts"));
		}
		catch (IOException exception)
		{
			showError("KLite could not unlock the saved account list.", exception);
		}
		updateActions();
	}

	private void launchSelected()
	{
		KLiteAccountVault.AccountSummary account = accountList.getSelectedValue();
		if (account == null)
		{
			return;
		}
		Process existing = runningClients.get(account.getId());
		if (existing != null && existing.isAlive())
		{
			status.setText(account.getDisplayName() + " is already running");
			return;
		}

		launchButton.setEnabled(false);
		status.setText("Starting " + account.getDisplayName() + "...");
		new SwingWorker<Process, Void>()
		{
			@Override
			protected Process doInBackground() throws Exception
			{
				return processLauncher.launch(account, vault.credentials(account.getId()));
			}

			@Override
			protected void done()
			{
				try
				{
					Process process = get();
					runningClients.put(account.getId(), process);
					status.setText("KLite started for " + account.getDisplayName());
				}
				catch (Exception exception)
				{
					showError("KLite could not start the selected character.", exception);
				}
				updateActions();
			}
		}.execute();
	}

	private void removeSelected()
	{
		KLiteAccountVault.AccountSummary account = accountList.getSelectedValue();
		if (account == null)
		{
			return;
		}
		int choice = JOptionPane.showConfirmDialog(this,
			"Remove " + account.getDisplayName() + " from this computer?",
			"Remove saved account", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
		if (choice != JOptionPane.OK_OPTION)
		{
			return;
		}
		try
		{
			vault.remove(account.getId());
			runningClients.remove(account.getId());
			refreshAccounts();
		}
		catch (IOException exception)
		{
			showError("KLite could not remove the selected account.", exception);
		}
	}

	private void showEnrollmentInstructions()
	{
		JOptionPane.showMessageDialog(this,
			"1. In the official Jagex Launcher, set KLiteLauncher.exe as the RuneLite executable.\n"
				+ "2. Select the character you want to add and press Play.\n"
				+ "3. KLite saves that character for this Windows user automatically.\n\n"
				+ "KLite never asks for or stores your Jagex password.",
			"Add a Jagex account", JOptionPane.INFORMATION_MESSAGE);
	}

	private void select(String id)
	{
		for (int index = 0; index < accountModel.size(); index++)
		{
			if (accountModel.get(index).getId().equals(id))
			{
				accountList.setSelectedIndex(index);
				accountList.ensureIndexIsVisible(index);
				return;
			}
		}
	}

	private void updateActions()
	{
		launchButton.setEnabled(updateCheckComplete
			&& accountList.getSelectedValue() != null);
	}

	private void applyIcon()
	{
		try
		{
			BufferedImage icon = ImageIO.read(KLiteLauncherFrame.class.getResourceAsStream(
				"/net/runelite/client/ui/klite_icon.png"));
			if (icon != null)
			{
				setIconImage(icon);
			}
		}
		catch (IOException | IllegalArgumentException ignored)
		{
			// Branding failure must not prevent account access.
		}
	}

	private void showError(String message, Exception exception)
	{
		status.setText(message);
		JOptionPane.showMessageDialog(this, message + "\n" + rootMessage(exception),
			"KLite Launcher", JOptionPane.ERROR_MESSAGE);
	}

	private static String rootMessage(Throwable throwable)
	{
		Throwable current = throwable;
		while (current.getCause() != null)
		{
			current = current.getCause();
		}
		return current.getMessage() == null ? "Unexpected error" : current.getMessage();
	}

	private static JLabel navigationLabel(String text, Color foreground)
	{
		JLabel label = new JLabel(text);
		label.setOpaque(true);
		label.setBackground(PANEL);
		label.setForeground(foreground);
		label.setBorder(BorderFactory.createEmptyBorder(12, 16, 12, 16));
		return label;
	}

	private final class AccountRenderer extends DefaultListCellRenderer
	{
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index,
			boolean selected, boolean focused)
		{
			KLiteAccountVault.AccountSummary account = (KLiteAccountVault.AccountSummary) value;
			String running = Optional.ofNullable(runningClients.get(account.getId()))
				.filter(Process::isAlive).map(process -> "  ?  Running").orElse("");
			String imported = IMPORTED_FORMAT.format(Instant.ofEpochMilli(account.getImportedAt()));
			super.getListCellRendererComponent(list,
				"<html><b>" + html(account.getDisplayName()) + "</b>" + running
					+ "<br><font color='#93A4B2'>Saved " + imported + "</font></html>",
				index, selected, focused);
			setBorder(BorderFactory.createEmptyBorder(10, 16, 10, 16));
			return this;
		}

		private String html(String text)
		{
			return text.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
		}
	}
}
