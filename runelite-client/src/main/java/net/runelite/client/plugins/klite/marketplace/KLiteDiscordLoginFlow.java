/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.client.util.LinkBrowser;

/**
 * Completes Discord OAuth through the system browser and a temporary loopback
 * callback. The authorization code is protected with PKCE before it is
 * exchanged for a persistent KLite client session.
 */
@Singleton
class KLiteDiscordLoginFlow
{
	private static final String CALLBACK_PATH = "/klite/discord/callback";
	private static final long LOGIN_TIMEOUT_MINUTES = 10L;
	private static final SecureRandom RANDOM = new SecureRandom();

	private final KLiteDiscordAccountClient accountClient;

	@Inject
	KLiteDiscordLoginFlow(KLiteDiscordAccountClient accountClient)
	{
		this.accountClient = accountClient;
	}

	CompletableFuture<KLiteAccountState> login()
	{
		CompletableFuture<KLiteAccountState> result = new CompletableFuture<>();
		ExecutorService callbackExecutor = Executors.newSingleThreadExecutor(runnable ->
		{
			Thread thread = new Thread(runnable, "KLite Discord login callback");
			thread.setDaemon(true);
			return thread;
		});

		final HttpServer server;
		try
		{
			server = HttpServer.create(new InetSocketAddress(
				InetAddress.getByName("127.0.0.1"), 0), 0);
		}
		catch (IOException ex)
		{
			callbackExecutor.shutdownNow();
			result.completeExceptionally(ex);
			return result;
		}

		server.setExecutor(callbackExecutor);
		AtomicBoolean finished = new AtomicBoolean();
		String verifier = randomVerifier();
		String challenge;
		try
		{
			challenge = sha256Base64Url(verifier);
		}
		catch (NoSuchAlgorithmException ex)
		{
			stop(server, callbackExecutor, finished);
			result.completeExceptionally(ex);
			return result;
		}

		String redirectUri = "http://127.0.0.1:" + server.getAddress().getPort()
			+ CALLBACK_PATH;
		AtomicReference<String> expectedState = new AtomicReference<>();

		server.createContext(CALLBACK_PATH, exchange ->
			handleCallback(exchange, expectedState, verifier, result,
				server, callbackExecutor, finished));
		server.start();

		accountClient.start(redirectUri, challenge)
			.whenComplete((login, error) ->
			{
				if (error != null)
				{
					stop(server, callbackExecutor, finished);
					result.completeExceptionally(error);
					return;
				}
				expectedState.set(login.getState());
				try
				{
					LinkBrowser.browse(login.getAuthorizeUrl());
				}
				catch (RuntimeException ex)
				{
					stop(server, callbackExecutor, finished);
					result.completeExceptionally(ex);
				}
			});

		CompletableFuture.runAsync(() ->
		{
			if (finished.compareAndSet(false, true))
			{
				server.stop(0);
				callbackExecutor.shutdownNow();
				result.completeExceptionally(
					new IOException("Discord login timed out"));
			}
		}, CompletableFuture.delayedExecutor(LOGIN_TIMEOUT_MINUTES,
			TimeUnit.MINUTES));

		return result;
	}

	private void handleCallback(HttpExchange exchange,
		AtomicReference<String> expectedState,
		String verifier, CompletableFuture<KLiteAccountState> result,
		HttpServer server, ExecutorService callbackExecutor,
		AtomicBoolean finished) throws IOException
	{
		Map<String, String> query = queryParameters(exchange.getRequestURI());
		String state = query.get("state");
		String code = query.get("code");
		String error = query.get("error");

		String expected = expectedState.get();
		if (!"GET".equalsIgnoreCase(exchange.getRequestMethod())
			|| expected == null
			|| !constantTimeEquals(expected, state))
		{
			sendBrowserResponse(exchange, 400,
				"Invalid KLite Discord login callback.");
			return;
		}

		if (error != null || code == null || code.isBlank())
		{
			sendBrowserResponse(exchange, 400,
				"Discord login was cancelled or could not be completed.");
			stop(server, callbackExecutor, finished);
			result.completeExceptionally(new IOException(
				"Discord login was cancelled or rejected"));
			return;
		}

		accountClient.exchange(code, state, verifier)
			.whenComplete((account, exchangeError) ->
			{
				try
				{
					if (exchangeError != null)
					{
						sendBrowserResponse(exchange, 500,
							"Discord login could not be completed. Return to KLite and try again.");
						result.completeExceptionally(exchangeError);
					}
					else
					{
						sendBrowserResponse(exchange, 200,
							"Discord login succeeded. You can close this window and return to KLite.");
						result.complete(account);
					}
				}
				catch (IOException responseError)
				{
					result.completeExceptionally(responseError);
				}
				finally
				{
					stop(server, callbackExecutor, finished);
				}
			});
	}

	private static void sendBrowserResponse(HttpExchange exchange, int status,
		String message) throws IOException
	{
		String html = "<!doctype html><html><head><meta charset=\"utf-8\">"
			+ "<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">"
			+ "<title>KLite Discord login</title></head>"
			+ "<body style=\"margin:0;background:#05090f;color:#f2f7fb;"
			+ "font:16px system-ui;display:grid;min-height:100vh;place-items:center\">"
			+ "<main style=\"max-width:560px;padding:32px;border:1px solid #263746;"
			+ "background:#0d151f;text-align:center\"><h1 style=\"color:#13d9ff\">"
			+ "KLite</h1><p>" + message + "</p></main></body></html>";
		byte[] bytes = html.getBytes(StandardCharsets.UTF_8);
		exchange.getResponseHeaders().set("Content-Type",
			"text/html; charset=utf-8");
		exchange.getResponseHeaders().set("Cache-Control", "no-store");
		exchange.sendResponseHeaders(status, bytes.length);
		exchange.getResponseBody().write(bytes);
		exchange.close();
	}

	private static Map<String, String> queryParameters(URI uri)
	{
		Map<String, String> parameters = new HashMap<>();
		String rawQuery = uri.getRawQuery();
		if (rawQuery == null || rawQuery.length() > 4096)
		{
			return parameters;
		}
		for (String pair : rawQuery.split("&"))
		{
			int separator = pair.indexOf('=');
			String name = separator < 0 ? pair : pair.substring(0, separator);
			String value = separator < 0 ? "" : pair.substring(separator + 1);
			parameters.put(
				URLDecoder.decode(name, StandardCharsets.UTF_8),
				URLDecoder.decode(value, StandardCharsets.UTF_8));
		}
		return parameters;
	}

	private static String randomVerifier()
	{
		byte[] bytes = new byte[32];
		RANDOM.nextBytes(bytes);
		return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
	}

	private static String sha256Base64Url(String value)
		throws NoSuchAlgorithmException
	{
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hashed = digest.digest(value.getBytes(StandardCharsets.US_ASCII));
		return Base64.getUrlEncoder().withoutPadding().encodeToString(hashed);
	}

	private static boolean constantTimeEquals(String expected, String actual)
	{
		if (actual == null)
		{
			return false;
		}
		return MessageDigest.isEqual(
			expected.getBytes(StandardCharsets.US_ASCII),
			actual.getBytes(StandardCharsets.US_ASCII));
	}

	private static void stop(HttpServer server,
		ExecutorService callbackExecutor, AtomicBoolean finished)
	{
		if (finished.compareAndSet(false, true))
		{
			server.stop(0);
			callbackExecutor.shutdownNow();
		}
	}
}
