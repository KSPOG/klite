/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import com.google.gson.Gson;
import com.sun.jna.Platform;
import com.sun.jna.platform.win32.Crypt32Util;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.Optional;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.RuneLite;

/** Persists the revocable marketplace client token with Windows DPAPI protection. */
@Singleton
@Slf4j
final class KLiteAccountSessionStore
{
	private static final File DIRECTORY = new File(RuneLite.RUNELITE_DIR, "klite");
	private static final File SESSION_FILE = new File(DIRECTORY, "account-session.dat");
	private final Gson gson;

	@Inject
	KLiteAccountSessionStore(Gson gson)
	{
		this.gson = gson;
	}

	Optional<StoredSession> load()
	{
		if (!Platform.isWindows() || !SESSION_FILE.isFile())
		{
			return Optional.empty();
		}
		try
		{
			String encoded = Files.readString(SESSION_FILE.toPath(), StandardCharsets.UTF_8).trim();
			byte[] protectedBytes = Base64.getDecoder().decode(encoded);
			byte[] plainBytes = Crypt32Util.cryptUnprotectData(protectedBytes);
			StoredSession session = gson.fromJson(
				new String(plainBytes, StandardCharsets.UTF_8), StoredSession.class);
			if (session == null || session.token == null || session.token.isBlank()
				|| session.expiresAtEpochSeconds <= System.currentTimeMillis() / 1_000L)
			{
				clear();
				return Optional.empty();
			}
			return Optional.of(session);
		}
		catch (IOException | RuntimeException exception)
		{
			log.warn("Unable to restore the protected KLite account session", exception);
			clear();
			return Optional.empty();
		}
	}

	void save(String token, String email, long expiresAtEpochSeconds)
	{
		if (!Platform.isWindows())
		{
			return;
		}
		try
		{
			Files.createDirectories(DIRECTORY.toPath());
			StoredSession session = new StoredSession(token, email, expiresAtEpochSeconds);
			byte[] plainBytes = gson.toJson(session).getBytes(StandardCharsets.UTF_8);
			byte[] protectedBytes = Crypt32Util.cryptProtectData(plainBytes);
			String encoded = Base64.getEncoder().encodeToString(protectedBytes);
			File temporary = new File(DIRECTORY, SESSION_FILE.getName() + ".tmp");
			Files.writeString(temporary.toPath(), encoded, StandardCharsets.UTF_8);
			Files.move(temporary.toPath(), SESSION_FILE.toPath(),
				StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
		}
		catch (IOException | RuntimeException exception)
		{
			log.warn("Unable to persist the protected KLite account session", exception);
		}
	}

	void clear()
	{
		try
		{
			Files.deleteIfExists(SESSION_FILE.toPath());
		}
		catch (IOException exception)
		{
			log.warn("Unable to delete the saved KLite account session", exception);
		}
	}

	@Value
	static class StoredSession
	{
		String token;
		String email;
		long expiresAtEpochSeconds;
	}
}
