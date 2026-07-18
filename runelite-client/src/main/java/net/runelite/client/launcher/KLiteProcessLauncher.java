/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.launcher;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** Starts an isolated KLite client process for a saved character. */
final class KLiteProcessLauncher
{
	Process launch(KLiteAccountVault.AccountSummary account,
		Map<String, String> credentials) throws IOException
	{
		ProcessBuilder processBuilder = new ProcessBuilder(command(account));
		Map<String, String> environment = processBuilder.environment();
		environment.keySet().removeIf(key -> key.startsWith("JX_"));
		environment.putAll(credentials);
		processBuilder.redirectErrorStream(true);
		processBuilder.redirectOutput(ProcessBuilder.Redirect.DISCARD);
		return processBuilder.start();
	}

	private static List<String> command(KLiteAccountVault.AccountSummary account)
		throws IOException
	{
		List<String> command = new ArrayList<>();
		String packagedExecutable = System.getProperty("jpackage.app-path");
		if (packagedExecutable != null && !packagedExecutable.isBlank())
		{
			Path launcher = Path.of(packagedExecutable).toAbsolutePath();
			Path client = launcher.resolveSibling("KLiteClient.exe");
			if (!Files.isRegularFile(client))
			{
				throw new IOException("KLiteClient.exe is missing. Reinstall the KLite Launcher.");
			}
			command.add(client.toString());
		}
		else
		{
			command.add(new File(System.getProperty("java.home"), "bin/java").getAbsolutePath());
			command.add("-cp");
			command.add(System.getProperty("java.class.path"));
			command.add("net.runelite.client.KLite");
			command.add(KLiteLauncher.CLIENT_ARGUMENT);
		}
		command.add("--profile");
		command.add("klite-account-" + account.getId());
		return command;
	}
}
