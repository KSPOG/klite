/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.launcher;

import com.google.gson.Gson;
import com.sun.jna.Platform;
import com.sun.jna.platform.win32.Crypt32Util;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;
import net.runelite.client.RuneLite;

/**
 * Stores Jagex Launcher character sessions encrypted for the current Windows user.
 * Plaintext credentials exist only while importing, decrypting, or starting a child process.
 */
final class KLiteAccountVault
{
	private static final Pattern JAGEX_VARIABLE = Pattern.compile("JX_[A-Z0-9_]+");
	private static final String CHARACTER_ID = "JX_CHARACTER_ID";
	private static final String SESSION_ID = "JX_SESSION_ID";
	private static final String DISPLAY_NAME = "JX_DISPLAY_NAME";
	private static final Path DEFAULT_FILE = RuneLite.RUNELITE_DIR.toPath()
		.resolve("klite").resolve("launcher-accounts.dat");

	private final Path file;
	private final Gson gson;
	private final Protector protector;

	KLiteAccountVault()
	{
		this(DEFAULT_FILE, new Gson(), new WindowsProtector());
	}

	KLiteAccountVault(Path file, Gson gson, Protector protector)
	{
		this.file = Objects.requireNonNull(file);
		this.gson = Objects.requireNonNull(gson);
		this.protector = Objects.requireNonNull(protector);
	}

	synchronized Optional<AccountSummary> importEnvironment(Map<String, String> environment) throws IOException
	{
		Map<String, String> credentials = filterCredentials(environment);
		if (!credentials.containsKey(CHARACTER_ID) || !credentials.containsKey(SESSION_ID))
		{
			return Optional.empty();
		}

		VaultData data = read();
		String id = accountId(credentials.get(CHARACTER_ID));
		String displayName = cleanDisplayName(credentials.get(DISPLAY_NAME));
		StoredAccount account = new StoredAccount(id, displayName, Instant.now().toEpochMilli(), credentials);
		data.accounts.put(id, account);
		write(data);
		return Optional.of(account.summary());
	}

	synchronized List<AccountSummary> list() throws IOException
	{
		List<AccountSummary> summaries = new ArrayList<>();
		for (StoredAccount account : read().accounts.values())
		{
			summaries.add(account.summary());
		}
		summaries.sort(Comparator.comparing(AccountSummary::getDisplayName, String.CASE_INSENSITIVE_ORDER));
		return summaries;
	}

	synchronized Map<String, String> credentials(String id) throws IOException
	{
		StoredAccount account = read().accounts.get(id);
		if (account == null)
		{
			throw new IOException("The selected account no longer exists in the KLite vault.");
		}
		return new HashMap<>(account.credentials);
	}

	synchronized void remove(String id) throws IOException
	{
		VaultData data = read();
		if (data.accounts.remove(id) != null)
		{
			write(data);
		}
	}

	private VaultData read() throws IOException
	{
		if (!Files.isRegularFile(file))
		{
			return new VaultData();
		}

		byte[] plain = null;
		try
		{
			byte[] encrypted = Base64.getDecoder().decode(
				Files.readString(file, StandardCharsets.US_ASCII).trim());
			plain = protector.unprotect(encrypted);
			VaultData data = gson.fromJson(new String(plain, StandardCharsets.UTF_8), VaultData.class);
			if (data == null || data.accounts == null)
			{
				throw new IOException("The KLite account vault is invalid.");
			}
			return data;
		}
		catch (IllegalArgumentException exception)
		{
			throw new IOException("The KLite account vault could not be decoded.", exception);
		}
		finally
		{
			if (plain != null)
			{
				Arrays.fill(plain, (byte) 0);
			}
		}
	}

	private void write(VaultData data) throws IOException
	{
		byte[] plain = gson.toJson(data).getBytes(StandardCharsets.UTF_8);
		try
		{
			byte[] encrypted = protector.protect(plain);
			Files.createDirectories(file.getParent());
			Path temporary = file.resolveSibling(file.getFileName() + ".tmp");
			Files.writeString(temporary, Base64.getEncoder().encodeToString(encrypted),
				StandardCharsets.US_ASCII);
			try
			{
				Files.move(temporary, file, StandardCopyOption.REPLACE_EXISTING,
					StandardCopyOption.ATOMIC_MOVE);
			}
			catch (AtomicMoveNotSupportedException exception)
			{
				Files.move(temporary, file, StandardCopyOption.REPLACE_EXISTING);
			}
		}
		finally
		{
			Arrays.fill(plain, (byte) 0);
		}
	}

	private static Map<String, String> filterCredentials(Map<String, String> environment)
	{
		Map<String, String> credentials = new LinkedHashMap<>();
		environment.forEach((key, value) ->
		{
			if (key != null && value != null && !value.isBlank()
				&& JAGEX_VARIABLE.matcher(key).matches())
			{
				credentials.put(key, value);
			}
		});
		return credentials;
	}

	private static String cleanDisplayName(String displayName)
	{
		return displayName == null || displayName.isBlank()
			? "Jagex character" : displayName.strip();
	}

	private static String accountId(String characterId) throws IOException
	{
		try
		{
			byte[] digest = MessageDigest.getInstance("SHA-256")
				.digest(characterId.getBytes(StandardCharsets.UTF_8));
			StringBuilder id = new StringBuilder(24);
			for (int index = 0; index < 12; index++)
			{
				id.append(String.format("%02x", digest[index] & 0xff));
			}
			return id.toString();
		}
		catch (NoSuchAlgorithmException exception)
		{
			throw new IOException("SHA-256 is unavailable.", exception);
		}
	}

	interface Protector
	{
		byte[] protect(byte[] plain) throws IOException;

		byte[] unprotect(byte[] encrypted) throws IOException;
	}

	private static final class WindowsProtector implements Protector
	{
		@Override
		public byte[] protect(byte[] plain) throws IOException
		{
			requireWindows();
			try
			{
				return Crypt32Util.cryptProtectData(plain);
			}
			catch (RuntimeException exception)
			{
				throw new IOException("Windows could not protect the KLite account vault.", exception);
			}
		}

		@Override
		public byte[] unprotect(byte[] encrypted) throws IOException
		{
			requireWindows();
			try
			{
				return Crypt32Util.cryptUnprotectData(encrypted);
			}
			catch (RuntimeException exception)
			{
				throw new IOException("Windows could not unlock the KLite account vault.", exception);
			}
		}

		private static void requireWindows() throws IOException
		{
			if (!Platform.isWindows())
			{
				throw new IOException("Saved Jagex accounts are currently supported only on Windows.");
			}
		}
	}

	static final class AccountSummary
	{
		private final String id;
		private final String displayName;
		private final long importedAt;

		AccountSummary(String id, String displayName, long importedAt)
		{
			this.id = id;
			this.displayName = displayName;
			this.importedAt = importedAt;
		}

		String getId()
		{
			return id;
		}

		String getDisplayName()
		{
			return displayName;
		}

		long getImportedAt()
		{
			return importedAt;
		}
	}

	private static final class VaultData
	{
		private final Map<String, StoredAccount> accounts = new LinkedHashMap<>();
	}

	private static final class StoredAccount
	{
		private final String id;
		private final String displayName;
		private final long importedAt;
		private final Map<String, String> credentials;

		private StoredAccount(String id, String displayName, long importedAt,
			Map<String, String> credentials)
		{
			this.id = id;
			this.displayName = displayName;
			this.importedAt = importedAt;
			this.credentials = new LinkedHashMap<>(credentials);
		}

		private AccountSummary summary()
		{
			return new AccountSummary(id, displayName, importedAt);
		}
	}
}
