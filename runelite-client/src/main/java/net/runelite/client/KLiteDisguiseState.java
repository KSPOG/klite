/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import lombok.extern.slf4j.Slf4j;

/**
 * Stores the last selected disguise-mode state outside the profile bootstrap.
 *
 * <p>The marker is needed before configuration profiles are loaded so the
 * startup splash and operating-system taskbar icon can use the correct brand
 * from the first visible window.</p>
 */
@Slf4j
public final class KLiteDisguiseState
{
	private static final File STATE_FILE = new File(RuneLite.RUNELITE_DIR, "klite-disguise-mode");

	private KLiteDisguiseState()
	{
	}

	public static boolean isEnabled()
	{
		return STATE_FILE.isFile();
	}

	public static void setEnabled(boolean enabled)
	{
		try
		{
			if (enabled)
			{
				Files.createDirectories(RuneLite.RUNELITE_DIR.toPath());
				Files.writeString(
					STATE_FILE.toPath(),
					"enabled\n",
					StandardCharsets.US_ASCII,
					StandardOpenOption.CREATE,
					StandardOpenOption.TRUNCATE_EXISTING,
					StandardOpenOption.WRITE);
			}
			else
			{
				Files.deleteIfExists(STATE_FILE.toPath());
			}
		}
		catch (IOException ex)
		{
			log.warn("Unable to persist KLite disguise-mode state", ex);
		}
	}
}
