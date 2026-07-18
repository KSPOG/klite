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
import java.security.MessageDigest;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class KLiteLauncherUpdateServiceTest
{
	private MockWebServer server;

	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();

	@Before
	public void setUp() throws Exception
	{
		server = new MockWebServer();
		server.start();
	}

	@After
	public void tearDown() throws Exception
	{
		server.shutdown();
	}

	@Test
	public void developmentBuildDoesNotContactUpdateServer() throws Exception
	{
		KLiteLauncherUpdateService.UpdateResult result = service(null).checkAndDownload();

		assertEquals(KLiteLauncherUpdateService.Status.DEVELOPMENT_BUILD, result.getStatus());
		assertEquals(0, server.getRequestCount());
	}

	@Test
	public void currentVersionDoesNotDownloadInstaller() throws Exception
	{
		byte[] installer = "installer".getBytes(StandardCharsets.UTF_8);
		server.enqueue(jsonManifest("1.0.90", installer, hash(installer)));

		KLiteLauncherUpdateService.UpdateResult result =
			service("1.0.90").checkAndDownload();

		assertEquals(KLiteLauncherUpdateService.Status.CURRENT, result.getStatus());
		assertEquals(1, server.getRequestCount());
	}

	@Test
	public void newerVersionIsDownloadedAndVerified() throws Exception
	{
		byte[] installer = "verified-native-installer".getBytes(StandardCharsets.UTF_8);
		server.enqueue(jsonManifest("1.0.91", installer, hash(installer)));
		server.enqueue(new MockResponse().setResponseCode(200).setBody(
			new okio.Buffer().write(installer)));

		KLiteLauncherUpdateService.UpdateResult result =
			service("1.0.90").checkAndDownload();

		assertEquals(KLiteLauncherUpdateService.Status.UPDATE_READY, result.getStatus());
		assertEquals("1.0.91", result.getVersion());
		assertTrue(Files.isRegularFile(result.getInstaller()));
		assertArrayEquals(installer, Files.readAllBytes(result.getInstaller()));
		assertEquals("/manifest", server.takeRequest().getPath());
		assertEquals("/download", server.takeRequest().getPath());
	}

	@Test(expected = java.io.IOException.class)
	public void invalidInstallerHashIsRejected() throws Exception
	{
		byte[] installer = "tampered".getBytes(StandardCharsets.UTF_8);
		server.enqueue(jsonManifest("1.0.91", installer,
			"0".repeat(64)));
		server.enqueue(new MockResponse().setResponseCode(200).setBody(
			new okio.Buffer().write(installer)));

		try
		{
			service("1.0.90").checkAndDownload();
		}
		finally
		{
			Path partial = temporaryFolder.getRoot().toPath()
				.resolve("KLiteLauncher-Setup-1.0.91.exe.part");
			assertFalse(Files.exists(partial));
		}
	}

	@Test
	public void comparesNumericVersionComponents()
	{
		assertTrue(KLiteLauncherUpdateService.compareVersions("1.0.100", "1.0.99") > 0);
		assertTrue(KLiteLauncherUpdateService.compareVersions("2.0.0", "1.99.999") > 0);
		assertEquals(0, KLiteLauncherUpdateService.compareVersions("1.2.3", "1.2.3"));
	}

	private KLiteLauncherUpdateService service(String currentVersion)
	{
		return new KLiteLauncherUpdateService(new okhttp3.OkHttpClient(), new Gson(),
			server.url("/manifest"), server.url("/download"),
			temporaryFolder.getRoot().toPath(), currentVersion);
	}

	private MockResponse jsonManifest(String version, byte[] installer, String hash)
	{
		String json = "{"
			+ "\"schemaVersion\":1,"
			+ "\"launcher\":\"KLiteLauncher.exe\","
			+ "\"platform\":\"windows-x64\","
			+ "\"version\":\"" + version + "\","
			+ "\"buildSha\":\"0123456789012345678901234567890123456789\","
			+ "\"downloadUrl\":\"" + server.url("/download") + "\","
			+ "\"sha256\":\"" + hash + "\","
			+ "\"size\":" + installer.length
			+ "}";
		return new MockResponse().setResponseCode(200)
			.setHeader("Content-Type", "application/json")
			.setBody(json);
	}

	private static String hash(byte[] bytes) throws Exception
	{
		byte[] digest = MessageDigest.getInstance("SHA-256").digest(bytes);
		StringBuilder result = new StringBuilder(digest.length * 2);
		for (byte value : digest)
		{
			result.append(String.format("%02x", value & 0xff));
		}
		return result.toString();
	}
}
