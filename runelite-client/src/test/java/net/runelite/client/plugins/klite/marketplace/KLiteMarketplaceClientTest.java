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

		assertEquals(2, catalog.getSchemaVersion());
		assertEquals(1, catalog.getPlugins().size());
		KLiteMarketplacePlugin plugin = catalog.getPlugins().get(0);
		assertEquals("klite-example", plugin.getId());
		assertEquals("KLite Example", plugin.getDescriptor().getName());
		assertEquals("KSPOG", plugin.getDescriptor().getAuthors().get(0));
		assertEquals("1.0.0", plugin.getDescriptor().getVersion());
		assertTrue(plugin.getDescriptor().isExternal());
		assertEquals("Skilling", plugin.getCategories().get(0));
		assertEquals("Free", plugin.getAccess());
		assertEquals("coming-soon", plugin.getStatus());
	}

	@Test
	public void rejectsUnsupportedSchema() throws Exception
	{
		server.enqueue(jsonResponse(validCatalogJson().replace("\"schemaVersion\": 2", "\"schemaVersion\": 99")));

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
	public void rejectsMalformedCategory() throws Exception
	{
		server.enqueue(jsonResponse(validCatalogJson().replace("\"Skilling\"", "\"<script>\"")));

		ExecutionException exception = expectFailure();

		assertTrue(exception.getCause() instanceof IllegalArgumentException);
	}

	@Test
	public void rejectsNonExternalPlugin() throws Exception
	{
		server.enqueue(jsonResponse(validCatalogJson().replace("\"isExternal\": true", "\"isExternal\": false")));

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
			+ "  \"schemaVersion\": 2,\n"
			+ "  \"updatedAt\": \"2026-07-14T00:00:00Z\",\n"
			+ "  \"plugins\": [{\n"
			+ "    \"id\": \"klite-example\",\n"
			+ "    \"descriptor\": {\n"
			+ "      \"name\": \"KLite Example\",\n"
			+ "      \"description\": \"A safe example plugin.\",\n"
			+ "      \"tags\": [\"klite\", \"example\"],\n"
			+ "      \"authors\": [\"KSPOG\"],\n"
			+ "      \"version\": \"1.0.0\",\n"
			+ "      \"minClientVersion\": \"1.0.0\",\n"
			+ "      \"enabledByDefault\": false,\n"
			+ "      \"isExternal\": true\n"
			+ "    },\n"
			+ "    \"categories\": [\"Skilling\"],\n"
			+ "    \"access\": \"Free\",\n"
			+ "    \"status\": \"coming-soon\",\n"
			+ "    \"homepageUrl\": \"https://github.com/KSPOG/klite\",\n"
			+ "    \"iconPath\": \"assets/plugins/klite-example.png\"\n"
			+ "  }]\n"
			+ "}";
	}
}
