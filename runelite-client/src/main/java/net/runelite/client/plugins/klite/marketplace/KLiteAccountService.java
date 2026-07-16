/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import com.google.common.collect.ImmutableSet;
import com.google.gson.Gson;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
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

/** Authenticates a KLite marketplace account and keeps its revocable token in memory only. */
@Singleton
public class KLiteAccountService
{
	static final HttpUrl DEFAULT_API_URL = HttpUrl.get("https://klite-marketplace.pages.dev/api/");
	private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
	private static final int MAX_RESPONSE_BYTES = 128 * 1024;

	private final OkHttpClient httpClient;
	private final Gson gson;
	private final HttpUrl apiUrl;

	@Nullable
	private volatile String token;
	@Nullable
	private volatile KLiteAccountState state;

	@Inject
	KLiteAccountService(OkHttpClient httpClient, Gson gson)
	{
		this(httpClient, gson, DEFAULT_API_URL);
	}

	KLiteAccountService(OkHttpClient httpClient, Gson gson, HttpUrl apiUrl)
	{
		this.httpClient = httpClient;
		this.gson = gson;
		this.apiUrl = apiUrl;
	}

	public Optional<KLiteAccountState> currentAccount()
	{
		return Optional.ofNullable(state);
	}

	public boolean hasEntitlement(String pluginId)
	{
		KLiteAccountState current = state;
		return current != null && current.hasEntitlement(pluginId);
	}

	public CompletableFuture<KLiteAccountState> login(String email, char[] password)
	{
		if (email == null || email.isBlank() || password == null || password.length == 0)
		{
			return failedFuture(new IllegalArgumentException("Email and password are required"));
		}
		LoginRequest login = new LoginRequest(email.trim(), new String(password), true);
		Request request = new Request.Builder()
			.url(apiUrl.resolve("auth/login"))
			.post(RequestBody.create(JSON, gson.toJson(login)))
			.header("Accept", "application/json")
			.build();
		return execute(request, true);
	}

	public CompletableFuture<KLiteAccountState> refreshEntitlements()
	{
		String currentToken = token;
		if (currentToken == null)
		{
			return failedFuture(new IllegalStateException("Sign in to refresh entitlements"));
		}
		Request request = new Request.Builder()
			.url(apiUrl.resolve("client/entitlements"))
			.get()
			.header("Accept", "application/json")
			.header("Authorization", "Bearer " + currentToken)
			.build();
		return execute(request, false);
	}

	public CompletableFuture<Void> logout()
	{
		String currentToken = token;
		token = null;
		state = null;
		if (currentToken == null)
		{
			return CompletableFuture.completedFuture(null);
		}
		Request request = new Request.Builder()
			.url(apiUrl.resolve("auth/logout"))
			.post(RequestBody.create(JSON, "{}"))
			.header("Authorization", "Bearer " + currentToken)
			.build();
		CompletableFuture<Void> result = new CompletableFuture<>();
		httpClient.newCall(request).enqueue(new Callback()
		{
			@Override
			public void onFailure(Call call, IOException ex)
			{
				result.complete(null);
			}

			@Override
			public void onResponse(Call call, Response response)
			{
				response.close();
				result.complete(null);
			}
		});
		return result;
	}

	private CompletableFuture<KLiteAccountState> execute(Request request, boolean login)
	{
		CompletableFuture<KLiteAccountState> result = new CompletableFuture<>();
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
					AccountResponse payload = parseResponse(closeable);
					if (login && (payload.token == null || payload.token.isBlank()))
					{
						throw new IOException("Marketplace login did not return a client token");
					}
					if (payload.account == null)
					{
						throw new IOException("Marketplace response did not include an account");
					}
					Set<String> pluginIds = ImmutableSet.copyOf(payload.entitlements == null
						? new Entitlement[0] : payload.entitlements).stream()
						.map(entitlement -> entitlement.pluginId)
						.filter(pluginId -> pluginId != null && !pluginId.isBlank())
						.collect(ImmutableSet.toImmutableSet());
					Set<String> capabilities = ImmutableSet.copyOf(
						payload.account.capabilities == null ? new String[0] : payload.account.capabilities)
						.stream()
						.filter(capability -> capability != null && !capability.isBlank())
						.collect(ImmutableSet.toImmutableSet());
					String discordName = payload.account.discord == null ? null
						: firstNonBlank(payload.account.discord.globalName,
							payload.account.discord.username);
					KLiteAccountState updated = new KLiteAccountState(
						payload.account.username, payload.account.email, discordName,
						capabilities, pluginIds, login ? payload.expiresAt : currentExpiry());
					if (login)
					{
						token = payload.token;
					}
					state = updated;
					result.complete(updated);
				}
				catch (IOException | RuntimeException ex)
				{
					if (response.code() == 401)
					{
						token = null;
						state = null;
					}
					result.completeExceptionally(ex);
				}
			}
		});
		return result;
	}

	private AccountResponse parseResponse(Response response) throws IOException
	{
		ResponseBody body = response.body();
		if (body == null)
		{
			throw new IOException("Marketplace returned an empty response");
		}
		if (body.contentLength() > MAX_RESPONSE_BYTES)
		{
			throw new IOException("Marketplace account response exceeds the size limit");
		}
		byte[] bytes = body.byteStream().readNBytes(MAX_RESPONSE_BYTES + 1);
		if (bytes.length > MAX_RESPONSE_BYTES)
		{
			throw new IOException("Marketplace account response exceeds the size limit");
		}
		String json = new String(bytes, StandardCharsets.UTF_8);
		if (!response.isSuccessful())
		{
			ErrorResponse error = gson.fromJson(json, ErrorResponse.class);
			String message = error == null || error.error == null ? null : error.error.message;
			throw new IOException(message == null || message.isBlank()
				? "Marketplace account request failed with HTTP " + response.code() : message);
		}
		AccountResponse payload = gson.fromJson(json, AccountResponse.class);
		if (payload == null)
		{
			throw new IOException("Marketplace returned invalid account data");
		}
		return payload;
	}

	private long currentExpiry()
	{
		KLiteAccountState current = state;
		return current == null ? 0L : current.getExpiresAtEpochSeconds();
	}

	@Nullable
	private static String firstNonBlank(@Nullable String first, @Nullable String second)
	{
		return first != null && !first.isBlank() ? first
			: second != null && !second.isBlank() ? second : null;
	}

	private static <T> CompletableFuture<T> failedFuture(Throwable error)
	{
		CompletableFuture<T> future = new CompletableFuture<>();
		future.completeExceptionally(error);
		return future;
	}

	@SuppressWarnings("unused") // Gson serializes these fields reflectively.
	private static final class LoginRequest
	{
		private final String email;
		private final String password;
		private final boolean client;

		private LoginRequest(String email, String password, boolean client)
		{
			this.email = email;
			this.password = password;
			this.client = client;
		}
	}

	private static final class AccountResponse
	{
		private Account account;
		private Entitlement[] entitlements;
		private String token;
		private long expiresAt;
	}

	private static final class Account
	{
		private String email;
		private String username;
		private String[] capabilities;
		private DiscordAccount discord;
	}

	private static final class DiscordAccount
	{
		private String username;
		private String globalName;
	}

	private static final class Entitlement
	{
		private String pluginId;
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
