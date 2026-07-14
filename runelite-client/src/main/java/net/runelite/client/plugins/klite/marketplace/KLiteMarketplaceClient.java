/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import javax.imageio.ImageIO;
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
	private static final int MAX_ICON_BYTES = 512 * 1024;
	private static final int MAX_ICON_DIMENSION = 1024;

	private final OkHttpClient httpClient;
	private final Gson gson;
	private final HttpUrl catalogUrl;
	private final Map<String, CompletableFuture<BufferedImage>> iconRequests = new ConcurrentHashMap<>();

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

	public CompletableFuture<BufferedImage> fetchIcon(KLiteMarketplacePlugin plugin)
	{
		String iconPath = plugin.getIconPath();
		if (iconPath == null)
		{
			CompletableFuture<BufferedImage> result = new CompletableFuture<>();
			result.completeExceptionally(new IllegalArgumentException("Plugin does not define an icon"));
			return result;
		}

		CompletableFuture<BufferedImage> request = iconRequests.computeIfAbsent(iconPath, this::requestIcon);
		request.whenComplete((image, error) ->
		{
			if (error != null)
			{
				iconRequests.remove(iconPath, request);
			}
		});
		return request;
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

	private CompletableFuture<BufferedImage> requestIcon(String iconPath)
	{
		CompletableFuture<BufferedImage> result = new CompletableFuture<>();
		HttpUrl iconUrl = catalogUrl.resolve(iconPath);
		if (iconUrl == null || !catalogUrl.scheme().equals(iconUrl.scheme())
			|| !catalogUrl.host().equals(iconUrl.host()) || catalogUrl.port() != iconUrl.port())
		{
			result.completeExceptionally(new IllegalArgumentException("Plugin icon must use the marketplace origin"));
			return result;
		}

		Request request = new Request.Builder()
			.url(iconUrl)
			.header("Accept", "image/png, image/jpeg")
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
					result.complete(parseIconResponse(closeableResponse));
				}
				catch (IOException | IllegalArgumentException ex)
				{
					result.completeExceptionally(ex);
				}
			}
		});
		return result;
	}

	private static BufferedImage parseIconResponse(Response response) throws IOException
	{
		if (!response.isSuccessful())
		{
			throw new IOException("Marketplace icon returned HTTP " + response.code());
		}

		ResponseBody body = response.body();
		if (body == null)
		{
			throw new IOException("Marketplace icon returned an empty response");
		}
		MediaType contentType = body.contentType();
		if (contentType == null || !"image".equals(contentType.type())
			|| (!"png".equals(contentType.subtype()) && !"jpeg".equals(contentType.subtype())))
		{
			throw new IOException("Marketplace icon has an unsupported content type");
		}
		if (body.contentLength() > MAX_ICON_BYTES)
		{
			throw new IOException("Marketplace icon exceeds the size limit");
		}

		byte[] bytes = body.byteStream().readNBytes(MAX_ICON_BYTES + 1);
		if (bytes.length > MAX_ICON_BYTES)
		{
			throw new IOException("Marketplace icon exceeds the size limit");
		}

		BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes));
		if (image == null)
		{
			throw new IOException("Marketplace icon is not a valid image");
		}
		if (image.getWidth() > MAX_ICON_DIMENSION || image.getHeight() > MAX_ICON_DIMENSION)
		{
			throw new IOException("Marketplace icon dimensions exceed the limit");
		}
		return image;
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
