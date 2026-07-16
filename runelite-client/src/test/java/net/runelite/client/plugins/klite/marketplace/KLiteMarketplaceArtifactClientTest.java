/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import com.google.gson.Gson;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class KLiteMarketplaceArtifactClientTest
{
	private MockWebServer server;
	private KLiteMarketplaceArtifactClient client;

	@Before
	public void setUp() throws IOException
	{
		server = new MockWebServer();
		server.start();
		OkHttpClient httpClient = new OkHttpClient();
		Gson gson = new Gson();
		KLiteAccountService accountService = new KLiteAccountService(
			httpClient, gson, server.url("/api/"));
		client = new KLiteMarketplaceArtifactClient(httpClient, accountService);
	}

	@After
	public void tearDown() throws IOException
	{
		server.shutdown();
	}

	@Test
	public void streamsVerifiedFreeArtifactWithoutPersistingIt() throws Exception
	{
		byte[] artifactBytes = {0x50, 0x4b, 3, 4, 5};
		KLiteMarketplacePlugin plugin = plugin(artifactBytes);
		server.enqueue(new MockResponse()
			.setHeader("Content-Type", "application/java-archive")
			.setHeader("Content-Length", artifactBytes.length)
			.setBody(new okio.Buffer().write(artifactBytes)));

		byte[] result = client.fetch(plugin).get(5, TimeUnit.SECONDS);

		assertArrayEquals(artifactBytes, result);
		RecordedRequest request = server.takeRequest();
		assertEquals("/api/client/plugins/test-plugin/artifact?version=1.0.0", request.getPath());
		assertNull(request.getHeader("Authorization"));
		assertEquals("no-store", request.getHeader("Cache-Control"));
	}

	@Test
	public void rejectsArtifactWhoseHashDoesNotMatchCatalog() throws Exception
	{
		byte[] artifactBytes = {1, 2, 3};
		KLiteMarketplacePlugin plugin = plugin(artifactBytes);
		server.enqueue(new MockResponse()
			.setHeader("Content-Type", "application/java-archive")
			.setHeader("Content-Length", artifactBytes.length)
			.setBody(new okio.Buffer().write(new byte[]{3, 2, 1})));

		try
		{
			client.fetch(plugin).get(5, TimeUnit.SECONDS);
			throw new AssertionError("Expected the artifact request to fail");
		}
		catch (ExecutionException ex)
		{
			assertTrue(ex.getCause() instanceof IOException);
			assertTrue(ex.getCause().getMessage().contains("hash"));
		}
	}

	private static KLiteMarketplacePlugin plugin(byte[] artifactBytes) throws Exception
	{
		String json = "{"
			+ "\"id\":\"test-plugin\","
			+ "\"descriptor\":{"
			+ "\"name\":\"Test Plugin\","
			+ "\"description\":\"A test marketplace plugin.\","
			+ "\"tags\":[\"test\"],"
			+ "\"authors\":[\"KLite\"],"
			+ "\"version\":\"1.0.0\","
			+ "\"minClientVersion\":\"1.0.0\","
			+ "\"enabledByDefault\":false,"
			+ "\"isExternal\":true},"
			+ "\"categories\":[\"Other\"],"
			+ "\"type\":\"Free\","
			+ "\"access\":\"Free\","
			+ "\"status\":\"available\","
			+ "\"artifact\":{"
			+ "\"version\":\"1.0.0\","
			+ "\"sha256\":\"" + sha256(artifactBytes) + "\","
			+ "\"size\":" + artifactBytes.length + ","
			+ "\"entrypoints\":[\"com.example.TestPlugin\"]},"
			+ "\"releasedAt\":\"2026-07-16T00:00:00Z\","
			+ "\"updatedAt\":\"2026-07-16T00:00:00Z\","
			+ "\"trendingDay\":0,"
			+ "\"trendingWeek\":0,"
			+ "\"trendingMonth\":0}";
		KLiteMarketplacePlugin plugin = new Gson().fromJson(json, KLiteMarketplacePlugin.class);
		plugin.validate(Arrays.asList("Other"), Arrays.asList("Free"));
		return plugin;
	}

	private static String sha256(byte[] bytes) throws Exception
	{
		byte[] digest = MessageDigest.getInstance("SHA-256").digest(bytes);
		StringBuilder hex = new StringBuilder(digest.length * 2);
		for (byte value : digest)
		{
			hex.append(String.format("%02x", value & 0xff));
		}
		return hex.toString();
	}
}
