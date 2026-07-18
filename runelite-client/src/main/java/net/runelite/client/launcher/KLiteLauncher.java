/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.launcher;

import com.formdev.flatlaf.FlatDarkLaf;
import java.util.Arrays;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/** Standalone KLite desktop launcher entry point. */
public final class KLiteLauncher
{
	static final String CLIENT_ARGUMENT = "--klite-client";

	private KLiteLauncher()
	{
	}

	public static void main(String[] args)
	{
		FlatDarkLaf.setup();
		UIManager.put("Component.arc", 10);
		UIManager.put("Button.arc", 10);
		UIManager.put("TextComponent.arc", 8);

		SwingUtilities.invokeLater(() ->
		{
			KLiteAccountVault vault = new KLiteAccountVault();
			KLiteLauncherFrame frame = new KLiteLauncherFrame(vault, new KLiteProcessLauncher());
			frame.captureOfficialLauncherAccount(System.getenv());
			frame.setVisible(true);
		});
	}

	public static boolean isClientInvocation(String[] args)
	{
		return Arrays.asList(args).contains(CLIENT_ARGUMENT);
	}

	public static String[] clientArguments(String[] args)
	{
		return Arrays.stream(args)
			.filter(argument -> !CLIENT_ARGUMENT.equals(argument))
			.toArray(String[]::new);
	}
}
