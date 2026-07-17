/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CompletableFuture;
import javax.inject.Inject;
import javax.inject.Singleton;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/** Fetches entitled plugin artifacts into bounded, verified memory only. */
@Singleton
class KLiteMarketplaceArtifactClient
{
	private final OkHttpClient httpClient;
	private final KLiteAccountService accountService;

	@Inject
	KLiteMarketplaceArtifactClient(OkHttpClient httpClient, KLiteAccountService accountService)
	{
		this.httpClient = httpClient;
		this.accountService = accountService;
	}

	CompletableFuture<byte[]> fetch(KLiteMarketplacePlugin plugin)
	{
		KLiteMarketplaceArtifact artifact = plugin.getArtifact();
		if (artifact == null || !"available".equals(plugin.getStatus()))
		{
			return failedFuture(new IllegalArgumentException("Plugin is not available to run"));
		}

		Request request;
		try
		{
			Request baseRequest = accountService.marketplaceGet(
				"client/plugins/" + plugin.getId() + "/artifact");
			request = baseRequest
				.newBuilder()
				.url(baseRequest.url().newBuilder()
					.addQueryParameter("version", artifact.getVersion())
					.build())
				.header("Accept", "application/java-archive")
				.header("Cache-Control", "no-store")
				.build();
		}
		catch (RuntimeException ex)
		{
			return failedFuture(ex);
		}

		CompletableFuture<byte[]> result = new CompletableFuture<>();
		execute(request, plugin, artifact, true, result);
		return result;
	}

	private void execute(Request request, KLiteMarketplacePlugin plugin,
		KLiteMarketplaceArtifact artifact, boolean allowPublicFallback,
		CompletableFuture<byte[]> result)
	{
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
				if (response.code() == 404 && allowPublicFallback && isPublicArtifact(plugin))
				{
					response.close();
					HttpUrl fallbackUrl = request.url().resolve(
						"/artifacts/" + plugin.getId() + "-" + artifact.getVersion() + ".jar");
					if (fallbackUrl == null)
					{
						result.completeExceptionally(
							new IOException("Marketplace artifact URL is invalid"));
						return;
					}
					Request fallbackRequest = new Request.Builder()
						.url(fallbackUrl)
						.get()
						.header("Accept", "application/java-archive")
						.header("Cache-Control", "no-store")
						.build();
					execute(fallbackRequest, plugin, artifact, false, result);
					return;
				}

				try (Response closeable = response)
				{
					result.complete(readArtifact(closeable, artifact));
				}
				catch (IOException | RuntimeException ex)
				{
					result.completeExceptionally(ex);
				}
			}
		});
	}

	private static boolean isPublicArtifact(KLiteMarketplacePlugin plugin)
	{
		return KLiteMarketplacePlugin.TYPE_FREE.equals(plugin.getType())
			|| KLiteMarketplacePlugin.TYPE_PUBLIC.equals(plugin.getType());
	}

	private static byte[] readArtifact(Response response, KLiteMarketplaceArtifact artifact)
		throws IOException
	{
		if (!response.isSuccessful())
		{
			throw new IOException("Marketplace artifact request failed with HTTP " + response.code());
		}
		ResponseBody body = response.body();
		if (body == null)
		{
			throw new IOException("Marketplace artifact response was empty");
		}
		MediaType type = body.contentType();
		if (type == null || !"application".equals(type.type())
			|| !"java-archive".equals(type.subtype()))
		{
			throw new IOException("Marketplace artifact has an invalid content type");
		}
		if (body.contentLength() != artifact.getSize())
		{
			throw new IOException("Marketplace artifact size does not match the catalog");
		}
		byte[] bytes = body.byteStream().readNBytes((int) artifact.getSize() + 1);
		if (bytes.length != artifact.getSize())
		{
			throw new IOException("Marketplace artifact size does not match the catalog");
		}
		if (!MessageDigest.isEqual(hexSha256(bytes), artifact.getSha256().getBytes(java.nio.charset.StandardCharsets.US_ASCII)))
		{
			throw new IOException("Marketplace artifact hash does not match the catalog");
		}
		return bytes;
	}

	private static byte[] hexSha256(byte[] bytes) throws IOException
	{
		try
		{
			byte[] digest = MessageDigest.getInstance("SHA-256").digest(bytes);
			char[] hex = new char[digest.length * 2];
			final char[] alphabet = "0123456789abcdef".toCharArray();
			for (int i = 0; i < digest.length; i++)
			{
				hex[i * 2] = alphabet[(digest[i] >>> 4) & 0xf];
				hex[i * 2 + 1] = alphabet[digest[i] & 0xf];
			}
			return new String(hex).getBytes(java.nio.charset.StandardCharsets.US_ASCII);
		}
		catch (NoSuchAlgorithmException ex)
		{
			throw new IOException("SHA-256 is unavailable", ex);
		}
	}

	private static <T> CompletableFuture<T> failedFuture(Throwable error)
	{
		CompletableFuture<T> future = new CompletableFuture<>();
		future.completeExceptionally(error);
		return future;
	}
}
