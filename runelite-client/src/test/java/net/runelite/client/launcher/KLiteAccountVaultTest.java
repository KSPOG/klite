/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.launcher;

import com.google.gson.Gson;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class KLiteAccountVaultTest
{
	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();

	@Test
	public void importsAndRestoresProtectedJagexEnvironment() throws Exception
	{
		Path file = temporaryFolder.newFile("accounts.dat").toPath();
		Files.delete(file);
		KLiteAccountVault vault = vault(file);
		Map<String, String> environment = credentials("character-one", "session-secret", "Copper Main");
		environment.put("UNRELATED_VALUE", "must-not-be-stored");

		KLiteAccountVault.AccountSummary imported =
			vault.importEnvironment(environment).orElseThrow(AssertionError::new);

		assertEquals("Copper Main", imported.getDisplayName());
		assertEquals(1, vault.list().size());
		assertEquals("session-secret", vault.credentials(imported.getId()).get("JX_SESSION_ID"));
		String stored = Files.readString(file, StandardCharsets.US_ASCII);
		assertFalse(stored.contains("session-secret"));
		assertFalse(vault.credentials(imported.getId()).containsKey("UNRELATED_VALUE"));
	}

	@Test
	public void updatesExistingCharacterWithoutCreatingDuplicate() throws Exception
	{
		KLiteAccountVault vault = vault(temporaryFolder.newFolder().toPath().resolve("accounts.dat"));
		vault.importEnvironment(credentials("same-character", "first-session", "First name"));
		KLiteAccountVault.AccountSummary updated = vault.importEnvironment(
			credentials("same-character", "renewed-session", "Renamed")).orElseThrow(AssertionError::new);

		assertEquals(1, vault.list().size());
		assertEquals("Renamed", vault.list().get(0).getDisplayName());
		assertEquals("renewed-session", vault.credentials(updated.getId()).get("JX_SESSION_ID"));
	}

	@Test
	public void ignoresEnvironmentWithoutCompleteJagexSession() throws Exception
	{
		KLiteAccountVault vault = vault(temporaryFolder.newFolder().toPath().resolve("accounts.dat"));
		Map<String, String> environment = new HashMap<>();
		environment.put("JX_CHARACTER_ID", "incomplete");

		Optional<KLiteAccountVault.AccountSummary> imported = vault.importEnvironment(environment);

		assertTrue(imported.isEmpty());
		assertTrue(vault.list().isEmpty());
	}

	@Test
	public void removesSavedCharacter() throws Exception
	{
		KLiteAccountVault vault = vault(temporaryFolder.newFolder().toPath().resolve("accounts.dat"));
		KLiteAccountVault.AccountSummary imported = vault.importEnvironment(
			credentials("character", "session", "Account")).orElseThrow(AssertionError::new);

		vault.remove(imported.getId());

		assertTrue(vault.list().isEmpty());
	}

	private static KLiteAccountVault vault(Path file)
	{
		return new KLiteAccountVault(file, new Gson(), new XorProtector());
	}

	private static Map<String, String> credentials(String characterId, String sessionId,
		String displayName)
	{
		Map<String, String> credentials = new HashMap<>();
		credentials.put("JX_CHARACTER_ID", characterId);
		credentials.put("JX_SESSION_ID", sessionId);
		credentials.put("JX_DISPLAY_NAME", displayName);
		return credentials;
	}

	private static final class XorProtector implements KLiteAccountVault.Protector
	{
		@Override
		public byte[] protect(byte[] plain)
		{
			return transform(plain);
		}

		@Override
		public byte[] unprotect(byte[] encrypted)
		{
			return transform(encrypted);
		}

		private static byte[] transform(byte[] input)
		{
			byte[] output = new byte[input.length];
			for (int index = 0; index < input.length; index++)
			{
				output[index] = (byte) (input[index] ^ 0x5a);
			}
			return output;
		}
	}
}
