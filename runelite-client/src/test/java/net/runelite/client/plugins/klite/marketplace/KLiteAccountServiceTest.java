/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import com.google.gson.Gson;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class KLiteAccountServiceTest
{
	private MockWebServer server;
	private KLiteAccountService service;

	@Before
	public void setUp() throws Exception
	{
		server = new MockWebServer();
		server.start();
		service = new KLiteAccountService(
			new OkHttpClient(), new Gson(), server.url("/api/"));
	}

	@After
	public void tearDown() throws Exception
	{
		server.shutdown();
	}

	@Test
	public void loginKeepsTokenInMemoryAndLoadsEntitlements() throws Exception
	{
		server.enqueue(json(200, "{"
			+ "\"account\":{\"username\":\"member\",\"email\":\"member@example.com\","
			+ "\"capabilities\":[\"plugin_dev\"],"
			+ "\"discord\":{\"username\":\"discord-user\",\"globalName\":\"Discord User\"}},"
			+ "\"entitlements\":[{\"pluginId\":\"premium-walker\"}],"
			+ "\"token\":\"client-secret-token\",\"expiresAt\":12345}"));

		char[] password = "correct horse battery staple".toCharArray();
		KLiteAccountState account = service.login("member@example.com", password).get();

		assertEquals("member", account.getUsername());
		assertEquals("Discord User", account.getDiscordName());
		assertTrue(account.hasCapability("plugin_dev"));
		assertTrue(service.hasEntitlement("premium-walker"));
		assertFalse(service.hasEntitlement("another-plugin"));
		RecordedRequest login = server.takeRequest(1, TimeUnit.SECONDS);
		assertEquals("/api/auth/login", login.getPath());
		assertTrue(login.getBody().readUtf8().contains("\"client\":true"));

		server.enqueue(json(200, "{\"account\":{\"username\":\"member\","
			+ "\"email\":\"member@example.com\",\"capabilities\":[\"plugin_dev\"],"
			+ "\"discord\":null},"
			+ "\"entitlements\":[{\"pluginId\":\"premium-walker\"}]}"));
		service.refreshEntitlements().get();
		RecordedRequest refresh = server.takeRequest(1, TimeUnit.SECONDS);
		assertEquals("Bearer client-secret-token", refresh.getHeader("Authorization"));
		assertTrue(service.currentAccount().orElseThrow().hasCapability("plugin_dev"));
	}

	@Test
	public void authenticationFailureDoesNotCreateAccountState() throws Exception
	{
		server.enqueue(json(401,
			"{\"error\":{\"code\":\"invalid_credentials\",\"message\":\"Email or password is incorrect.\"}}"));

		try
		{
			service.login("member@example.com", "wrong-password".toCharArray()).get();
		}
		catch (ExecutionException expected)
		{
			assertTrue(expected.getCause().getMessage().contains("incorrect"));
		}

		assertTrue(service.currentAccount().isEmpty());
	}

	private static MockResponse json(int status, String body)
	{
		return new MockResponse()
			.setResponseCode(status)
			.setHeader("Content-Type", "application/json")
			.setBody(body);
	}
}
