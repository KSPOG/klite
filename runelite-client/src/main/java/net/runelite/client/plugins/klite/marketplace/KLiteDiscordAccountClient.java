/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import com.google.gson.Gson;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import javax.inject.Inject;
import javax.inject.Singleton;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/** Exchanges Discord OAuth data for the protected KLite client session. */
@Singleton
class KLiteDiscordAccountClient
{
	private static final MediaType JSON =
		MediaType.get("application/json; charset=utf-8");
	private static final int MAX_RESPONSE_BYTES = 128 * 1024;

	private final OkHttpClient httpClient;
	private final Gson gson;
	private final KLiteAccountSessionStore sessionStore;
	private final KLiteAccountService accountService;

	@Inject
	KLiteDiscordAccountClient(OkHttpClient httpClient, Gson gson,
		KLiteAccountSessionStore sessionStore,
		KLiteAccountService accountService)
	{
		this.httpClient = httpClient;
		this.gson = gson;
		this.sessionStore = sessionStore;
		this.accountService = accountService;
	}

	CompletableFuture<DiscordLoginStart> start(String redirectUri,
		String codeChallenge)
	{
		if (redirectUri == null || redirectUri.isBlank()
			|| codeChallenge == null || codeChallenge.isBlank())
		{
			return failedFuture(new IllegalArgumentException(
				"Discord client redirect and PKCE challenge are required"));
		}

		DiscordLoginStartRequest payload =
			new DiscordLoginStartRequest(true, redirectUri, codeChallenge);
		Request request = new Request.Builder()
			.url(resolve("auth/discord/start"))
			.post(RequestBody.create(JSON, gson.toJson(payload)))
			.header("Accept", "application/json")
			.build();
		return execute(request, DiscordLoginStart.class)
			.thenApply(start ->
			{
				if (start.authorizeUrl == null || start.authorizeUrl.isBlank()
					|| start.state == null || start.state.isBlank())
				{
					throw new IllegalStateException(
						"Marketplace returned invalid Discord login data");
				}
				return start;
			});
	}

	CompletableFuture<KLiteAccountState> exchange(String code,
		String state, String codeVerifier)
	{
		if (code == null || code.isBlank() || state == null || state.isBlank()
			|| codeVerifier == null || codeVerifier.isBlank())
		{
			return failedFuture(new IllegalArgumentException(
				"Discord login callback data is incomplete"));
		}

		DiscordLoginExchangeRequest payload =
			new DiscordLoginExchangeRequest(code, state, codeVerifier);
		Request request = new Request.Builder()
			.url(resolve("auth/discord/exchange"))
			.post(RequestBody.create(JSON, gson.toJson(payload)))
			.header("Accept", "application/json")
			.build();
		return execute(request, DiscordLoginExchangeResponse.class)
			.thenCompose(response ->
			{
				if (response.token == null || response.token.isBlank()
					|| response.expiresAt <= 0L || response.account == null
					|| response.account.email == null
					|| response.account.email.isBlank())
				{
					return failedFuture(new IOException(
						"Marketplace did not return a valid client session"));
				}
				sessionStore.save(response.token, response.account.email,
					response.expiresAt);
				return accountService.restoreSession()
					.thenCompose(KLiteDiscordAccountClient::requireAccount);
			});
	}

	private <T> CompletableFuture<T> execute(Request request, Class<T> type)
	{
		CompletableFuture<T> result = new CompletableFuture<>();
		httpClient.newCall(request).enqueue(new Callback()
		{
			@Override
			public void onFailure(Call call, IOException ex)
			{
				result.completeExceptionally(ex);
			}

			@Override
			public void onResponse(Call call, Response response)
			{
				try (Response closeable = response)
				{
					String json = responseJson(closeable);
					T payload = gson.fromJson(json, type);
					if (payload == null)
					{
						throw new IOException(
							"Marketplace returned invalid Discord login data");
					}
					result.complete(payload);
				}
				catch (IOException | RuntimeException ex)
				{
					result.completeExceptionally(ex);
				}
			}
		});
		return result;
	}

	private String responseJson(Response response) throws IOException
	{
		ResponseBody body = response.body();
		if (body == null)
		{
			throw new IOException("Marketplace returned an empty response");
		}
		if (body.contentLength() > MAX_RESPONSE_BYTES)
		{
			throw new IOException(
				"Marketplace Discord response exceeds the size limit");
		}
		byte[] bytes = body.byteStream().readNBytes(MAX_RESPONSE_BYTES + 1);
		if (bytes.length > MAX_RESPONSE_BYTES)
		{
			throw new IOException(
				"Marketplace Discord response exceeds the size limit");
		}
		String json = new String(bytes, StandardCharsets.UTF_8);
		if (!response.isSuccessful())
		{
			ErrorResponse error = gson.fromJson(json, ErrorResponse.class);
			String message = error == null || error.error == null
				? null : error.error.message;
			throw new IOException(message == null || message.isBlank()
				? "Marketplace Discord request failed with HTTP "
					+ response.code()
				: message);
		}
		return json;
	}

	private static CompletableFuture<KLiteAccountState> requireAccount(
		Optional<KLiteAccountState> account)
	{
		return account.map(CompletableFuture::completedFuture)
			.orElseGet(() -> failedFuture(new IOException(
				"The Discord client session could not be restored")));
	}

	private static HttpUrl resolve(String relativePath)
	{
		HttpUrl resolved = KLiteAccountService.DEFAULT_API_URL.resolve(relativePath);
		if (resolved == null)
		{
			throw new IllegalArgumentException("Invalid marketplace API path");
		}
		return resolved;
	}

	private static <T> CompletableFuture<T> failedFuture(Throwable error)
	{
		CompletableFuture<T> future = new CompletableFuture<>();
		future.completeExceptionally(error);
		return future;
	}

	@SuppressWarnings("unused")
	private static final class DiscordLoginStartRequest
	{
		private final boolean client;
		private final String redirectUri;
		private final String codeChallenge;

		private DiscordLoginStartRequest(boolean client, String redirectUri,
			String codeChallenge)
		{
			this.client = client;
			this.redirectUri = redirectUri;
			this.codeChallenge = codeChallenge;
		}
	}

	@SuppressWarnings("unused")
	private static final class DiscordLoginExchangeRequest
	{
		private final String code;
		private final String state;
		private final String codeVerifier;

		private DiscordLoginExchangeRequest(String code, String state,
			String codeVerifier)
		{
			this.code = code;
			this.state = state;
			this.codeVerifier = codeVerifier;
		}
	}

	static final class DiscordLoginStart
	{
		private String authorizeUrl;
		private String state;

		String getAuthorizeUrl()
		{
			return authorizeUrl;
		}

		String getState()
		{
			return state;
		}
	}

	private static final class DiscordLoginExchangeResponse
	{
		private String token;
		private long expiresAt;
		private Account account;
	}

	private static final class Account
	{
		private String email;
	}

	private static final class ErrorResponse
	{
		private ApiError error;
	}

	private static final class ApiError
	{
		private String message;
	}
}
