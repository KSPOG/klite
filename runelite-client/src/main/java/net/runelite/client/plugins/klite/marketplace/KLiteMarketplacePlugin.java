/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * A reviewed plugin entry published by the KLite marketplace catalog.
 */
public final class KLiteMarketplacePlugin
{
	private static final Pattern ID_PATTERN = Pattern.compile("[a-z0-9](?:[a-z0-9-]{0,62}[a-z0-9])?");
	private static final Pattern DISPLAY_PATTERN = Pattern.compile("[A-Za-z0-9][A-Za-z0-9 ._'()-]{0,63}");
	private static final Pattern VERSION_PATTERN = Pattern.compile("[0-9]+(?:\\.[0-9]+){1,3}(?:[-+][A-Za-z0-9.-]+)?");
	private static final Pattern ICON_PATH_PATTERN = Pattern.compile(
		"assets/plugins/[a-z0-9][a-z0-9._-]{0,100}\\.(?:png|jpg|jpeg)");
	private static final Set<String> STATUSES = Set.of("bundled", "available", "coming-soon");

	private String id;
	private String name;
	private String version;
	private String author;
	private String description;
	private String status;
	private String minimumClientVersion;
	private String homepageUrl;
	private String iconPath;

	public String getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public String getVersion()
	{
		return version;
	}

	public String getAuthor()
	{
		return author;
	}

	public String getDescription()
	{
		return description;
	}

	public String getStatus()
	{
		return status;
	}

	public String getMinimumClientVersion()
	{
		return minimumClientVersion;
	}

	public String getHomepageUrl()
	{
		return homepageUrl;
	}

	public String getIconPath()
	{
		return iconPath;
	}

	void validate()
	{
		if (id == null || !ID_PATTERN.matcher(id).matches())
		{
			throw new IllegalArgumentException("Invalid marketplace plugin id");
		}
		if (name == null || !DISPLAY_PATTERN.matcher(name).matches())
		{
			throw new IllegalArgumentException("Invalid marketplace plugin name: " + id);
		}
		if (author == null || !DISPLAY_PATTERN.matcher(author).matches())
		{
			throw new IllegalArgumentException("Invalid marketplace plugin author: " + id);
		}
		if (version == null || !VERSION_PATTERN.matcher(version).matches())
		{
			throw new IllegalArgumentException("Invalid marketplace plugin version: " + id);
		}
		if (minimumClientVersion == null || !VERSION_PATTERN.matcher(minimumClientVersion).matches())
		{
			throw new IllegalArgumentException("Invalid minimum client version: " + id);
		}
		if (description == null || description.isBlank() || description.length() > 300)
		{
			throw new IllegalArgumentException("Invalid marketplace plugin description: " + id);
		}
		if (status == null || !STATUSES.contains(status.toLowerCase(Locale.ROOT)))
		{
			throw new IllegalArgumentException("Invalid marketplace plugin status: " + id);
		}
		status = status.toLowerCase(Locale.ROOT);
		validateHttpsUrl(homepageUrl);
		if (iconPath != null && !ICON_PATH_PATTERN.matcher(iconPath).matches())
		{
			throw new IllegalArgumentException("Invalid marketplace plugin icon path: " + id);
		}
	}

	private static void validateHttpsUrl(String value)
	{
		if (value == null)
		{
			return;
		}

		try
		{
			URI uri = new URI(value);
			if (!"https".equalsIgnoreCase(uri.getScheme()) || uri.getHost() == null)
			{
				throw new IllegalArgumentException("Marketplace URLs must use HTTPS");
			}
		}
		catch (URISyntaxException ex)
		{
			throw new IllegalArgumentException("Invalid marketplace URL", ex);
		}
	}
}
