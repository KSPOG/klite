/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * A reviewed plugin entry published by the KLite marketplace catalog.
 */
public final class KLiteMarketplacePlugin
{
	public static final String TYPE_PUBLIC = "Public";
	public static final String TYPE_SUPPORTER = "Supporter";
	public static final String TYPE_FREE = "Free";
	public static final String TYPE_PREMIUM = "Premium";

	private static final Pattern ID_PATTERN = Pattern.compile("[a-z0-9](?:[a-z0-9-]{0,62}[a-z0-9])?");
	private static final Pattern ICON_PATH_PATTERN = Pattern.compile(
		"assets/plugins/[a-z0-9][a-z0-9._-]{0,100}\\.(?:png|jpg|jpeg)");
	private static final Pattern CATEGORY_PATTERN = Pattern.compile(
		"[A-Za-z0-9][A-Za-z0-9 &'/-]{0,31}");
	private static final Set<String> STATUSES = Set.of("bundled", "available", "coming-soon");

	private String id;
	private KLiteMarketplaceDescriptor descriptor;
	private List<String> categories;
	private String type;
	private String access;
	private String status;
	private String homepageUrl;
	private String iconPath;
	private String releasedAt;
	private String updatedAt;
	private int trendingDay;
	private int trendingWeek;
	private int trendingMonth;

	public String getId()
	{
		return id;
	}

	public KLiteMarketplaceDescriptor getDescriptor()
	{
		return descriptor;
	}

	public List<String> getCategories()
	{
		return categories;
	}

	public String getType()
	{
		return type == null ? access : type;
	}

	public String getStatus()
	{
		return status;
	}

	public String getHomepageUrl()
	{
		return homepageUrl;
	}

	public String getIconPath()
	{
		return iconPath;
	}

	public String getReleasedAt()
	{
		return releasedAt;
	}

	public String getUpdatedAt()
	{
		return updatedAt;
	}

	public int getTrendingDay()
	{
		return trendingDay;
	}

	public int getTrendingWeek()
	{
		return trendingWeek;
	}

	public int getTrendingMonth()
	{
		return trendingMonth;
	}

	public String getName()
	{
		return descriptor.getName();
	}

	public String getDescription()
	{
		return descriptor.getDescription();
	}

	public String getAuthorsDisplay()
	{
		return String.join(", ", descriptor.getAuthors());
	}

	public String getVersion()
	{
		return descriptor.getVersion();
	}

	public String getMinimumClientVersion()
	{
		return descriptor.getMinClientVersion();
	}

	void validate(List<String> allowedCategories, List<String> allowedTypes)
	{
		if (id == null || !ID_PATTERN.matcher(id).matches())
		{
			throw new IllegalArgumentException("Invalid marketplace plugin id");
		}
		if (descriptor == null)
		{
			throw new IllegalArgumentException("Marketplace plugin descriptor is required: " + id);
		}
		descriptor.validate(id);

		validateCategories(allowedCategories);
		String effectiveType = getType();
		if (effectiveType == null || !allowedTypes.contains(effectiveType)
			|| (type != null && access != null && !type.equals(access)))
		{
			throw new IllegalArgumentException("Invalid marketplace plugin type: " + id);
		}
		if (status == null || !STATUSES.contains(status.toLowerCase(Locale.ROOT)))
		{
			throw new IllegalArgumentException("Invalid marketplace plugin status: " + id);
		}
		status = status.toLowerCase(Locale.ROOT);
		validateHttpsUrl(homepageUrl);
		validateTimestamp(releasedAt, "release");
		validateTimestamp(updatedAt, "update");
		if (trendingDay < 0 || trendingWeek < 0 || trendingMonth < 0)
		{
			throw new IllegalArgumentException("Invalid marketplace plugin trend score: " + id);
		}
		if (iconPath != null && !ICON_PATH_PATTERN.matcher(iconPath).matches())
		{
			throw new IllegalArgumentException("Invalid marketplace plugin icon path: " + id);
		}
	}

	private void validateCategories(List<String> allowedCategories)
	{
		if (categories == null || categories.isEmpty() || categories.size() > 5)
		{
			throw new IllegalArgumentException("Invalid marketplace plugin categories: " + id);
		}

		Set<String> uniqueCategories = new HashSet<>();
		for (String category : categories)
		{
			if (category == null || !CATEGORY_PATTERN.matcher(category).matches()
				|| !allowedCategories.contains(category) || !uniqueCategories.add(category))
			{
				throw new IllegalArgumentException("Invalid marketplace plugin category: " + id);
			}
		}
		categories = Collections.unmodifiableList(categories);
	}

	private void validateTimestamp(String value, String label)
	{
		try
		{
			Instant.parse(value);
		}
		catch (NullPointerException | DateTimeParseException ex)
		{
			throw new IllegalArgumentException(
				"Invalid marketplace plugin " + label + " timestamp: " + id, ex);
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
