/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import com.google.gson.Gson;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Base64;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okio.Buffer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KLiteMarketplaceClientTest
{
	private MockWebServer server;
	private KLiteMarketplaceClient client;

	@Before
	public void setUp() throws IOException
	{
		server = new MockWebServer();
		server.start();
		client = new KLiteMarketplaceClient(new OkHttpClient(), new Gson(), server.url("/plugins.json"));
	}

	@After
	public void tearDown() throws IOException
	{
		server.shutdown();
	}

	@Test
	public void fetchesAndValidatesCatalog() throws Exception
	{
		server.enqueue(jsonResponse(validCatalogJson()));

		KLiteMarketplaceCatalog catalog = client.fetchCatalog().get(5, TimeUnit.SECONDS);

		assertEquals(1, catalog.getSchemaVersion());
		assertEquals(1, catalog.getPlugins().size());
		assertEquals("klite-example", catalog.getPlugins().get(0).getId());
		assertEquals("bundled", catalog.getPlugins().get(0).getStatus());
	}

	@Test
	public void rejectsUnsupportedSchema() throws Exception
	{
		server.enqueue(jsonResponse(validCatalogJson().replace("\"schemaVersion\": 1", "\"schemaVersion\": 2")));

		ExecutionException exception = expectFailure();

		assertTrue(exception.getCause() instanceof IllegalArgumentException);
	}

	@Test
	public void rejectsNonHttpsHomepage() throws Exception
	{
		server.enqueue(jsonResponse(validCatalogJson().replace("https://github.com/KSPOG/klite", "http://example.com")));

		ExecutionException exception = expectFailure();

		assertTrue(exception.getCause() instanceof IllegalArgumentException);
	}

	@Test
	public void rejectsUnsafeIconPath() throws Exception
	{
		server.enqueue(jsonResponse(validCatalogJson().replace(
			"assets/plugins/klite-example.png", "../private/icon.png")));

		ExecutionException exception = expectFailure();

		assertTrue(exception.getCause() instanceof IllegalArgumentException);
	}

	@Test
	public void fetchesSameOriginPluginIcon() throws Exception
	{
		server.enqueue(jsonResponse(validCatalogJson()));
		KLiteMarketplacePlugin plugin = client.fetchCatalog().get(5, TimeUnit.SECONDS)
			.getPlugins().get(0);
		server.enqueue(new MockResponse()
			.setHeader("Content-Type", "image/png")
			.setBody(new Buffer().write(Base64.getDecoder().decode(
				"iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNk+A8AAQUBAScY42YAAAAASUVORK5CYII="))));

		BufferedImage image = client.fetchIcon(plugin).get(5, TimeUnit.SECONDS);

		assertEquals(1, image.getWidth());
		assertEquals(1, image.getHeight());
		server.takeRequest();
		assertEquals("/assets/plugins/klite-example.png", server.takeRequest().getPath());
	}

	@Test
	public void reportsHttpFailure() throws Exception
	{
		server.enqueue(new MockResponse().setResponseCode(503));

		ExecutionException exception = expectFailure();

		assertTrue(exception.getCause() instanceof IOException);
	}

	private ExecutionException expectFailure() throws Exception
	{
		try
		{
			client.fetchCatalog().get(5, TimeUnit.SECONDS);
			throw new AssertionError("Expected catalog request to fail");
		}
		catch (ExecutionException ex)
		{
			return ex;
		}
	}

	private static MockResponse jsonResponse(String body)
	{
		return new MockResponse()
			.setHeader("Content-Type", "application/json")
			.setBody(body);
	}

	private static String validCatalogJson()
	{
		return "{\n"
			+ "  \"schemaVersion\": 1,\n"
			+ "  \"updatedAt\": \"2026-07-14T00:00:00Z\",\n"
			+ "  \"plugins\": [{\n"
			+ "    \"id\": \"klite-example\",\n"
			+ "    \"name\": \"KLite Example\",\n"
			+ "    \"version\": \"1.0.0\",\n"
			+ "    \"author\": \"KSPOG\",\n"
			+ "    \"description\": \"A safe example plugin.\",\n"
			+ "    \"status\": \"bundled\",\n"
			+ "    \"minimumClientVersion\": \"1.0.0\",\n"
			+ "    \"homepageUrl\": \"https://github.com/KSPOG/klite\",\n"
			+ "    \"iconPath\": \"assets/plugins/klite-example.png\"\n"
			+ "  }]\n"
			+ "}";
	}
}
