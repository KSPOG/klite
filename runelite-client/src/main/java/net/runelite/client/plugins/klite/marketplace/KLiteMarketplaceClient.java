/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
import javax.inject.Inject;
import javax.inject.Singleton;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Downloads and validates the public KLite marketplace catalog.
 *
 * <p>This client reads metadata only. It never downloads or loads plugin
 * artifacts.</p>
 */
@Singleton
public class KLiteMarketplaceClient
{
	static final HttpUrl DEFAULT_CATALOG_URL = HttpUrl.get(
		"https://klite-marketplace.pages.dev/plugins.json");
	private static final int MAX_CATALOG_BYTES = 256 * 1024;

	private final OkHttpClient httpClient;
	private final Gson gson;
	private final HttpUrl catalogUrl;

	@Inject
	KLiteMarketplaceClient(OkHttpClient httpClient, Gson gson)
	{
		this(httpClient, gson, DEFAULT_CATALOG_URL);
	}

	KLiteMarketplaceClient(OkHttpClient httpClient, Gson gson, HttpUrl catalogUrl)
	{
		this.httpClient = httpClient;
		this.gson = gson;
		this.catalogUrl = catalogUrl;
	}

	public HttpUrl getCatalogUrl()
	{
		return catalogUrl;
	}

	public CompletableFuture<KLiteMarketplaceCatalog> fetchCatalog()
	{
		CompletableFuture<KLiteMarketplaceCatalog> result = new CompletableFuture<>();
		Request request = new Request.Builder()
			.url(catalogUrl)
			.header("Accept", "application/json")
			.header("Cache-Control", "no-cache")
			.build();

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
				try (Response closeableResponse = response)
				{
					result.complete(parseResponse(closeableResponse));
				}
				catch (IOException | IllegalArgumentException | JsonParseException ex)
				{
					result.completeExceptionally(ex);
				}
			}
		});

		return result;
	}

	private KLiteMarketplaceCatalog parseResponse(Response response) throws IOException
	{
		if (!response.isSuccessful())
		{
			throw new IOException("Marketplace returned HTTP " + response.code());
		}

		ResponseBody body = response.body();
		if (body == null)
		{
			throw new IOException("Marketplace returned an empty response");
		}
		if (body.contentLength() > MAX_CATALOG_BYTES)
		{
			throw new IOException("Marketplace catalog exceeds the size limit");
		}

		byte[] bytes = body.byteStream().readNBytes(MAX_CATALOG_BYTES + 1);
		if (bytes.length > MAX_CATALOG_BYTES)
		{
			throw new IOException("Marketplace catalog exceeds the size limit");
		}

		KLiteMarketplaceCatalog catalog = gson.fromJson(
			new String(bytes, StandardCharsets.UTF_8), KLiteMarketplaceCatalog.class);
		if (catalog == null)
		{
			throw new IOException("Marketplace catalog is empty");
		}
		catalog.validate();
		return catalog;
	}
}
