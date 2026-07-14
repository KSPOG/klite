/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Versioned root document served by the KLite marketplace.
 */
public final class KLiteMarketplaceCatalog
{
	static final int SUPPORTED_SCHEMA_VERSION = 3;
	private static final int MAX_PLUGIN_COUNT = 250;
	private static final int MAX_CATEGORY_COUNT = 50;
	private static final int MAX_TYPE_COUNT = 10;

	private int schemaVersion;
	private String updatedAt;
	private List<String> categories;
	private List<String> types;
	private List<KLiteMarketplacePlugin> plugins;

	public int getSchemaVersion()
	{
		return schemaVersion;
	}

	public String getUpdatedAt()
	{
		return updatedAt;
	}

	public List<String> getCategories()
	{
		return categories;
	}

	public List<String> getTypes()
	{
		return types;
	}

	public List<KLiteMarketplacePlugin> getPlugins()
	{
		return plugins;
	}

	void validate()
	{
		if (schemaVersion != SUPPORTED_SCHEMA_VERSION)
		{
			throw new IllegalArgumentException("Unsupported marketplace schema version: " + schemaVersion);
		}
		if (updatedAt != null)
		{
			try
			{
				Instant.parse(updatedAt);
			}
			catch (DateTimeParseException ex)
			{
				throw new IllegalArgumentException("Invalid marketplace update timestamp", ex);
			}
		}

		validateFilters();
		if (plugins == null || plugins.size() > MAX_PLUGIN_COUNT)
		{
			throw new IllegalArgumentException("Invalid marketplace plugin list");
		}

		Set<String> pluginIds = new HashSet<>();
		for (KLiteMarketplacePlugin plugin : plugins)
		{
			if (plugin == null)
			{
				throw new IllegalArgumentException("Marketplace plugin entry cannot be null");
			}
			plugin.validate(categories, types);
			if (!pluginIds.add(plugin.getId()))
			{
				throw new IllegalArgumentException("Duplicate marketplace plugin id: " + plugin.getId());
			}
		}

		plugins = Collections.unmodifiableList(plugins);
	}

	private void validateFilters()
	{
		if (categories == null || categories.isEmpty() || categories.size() > MAX_CATEGORY_COUNT
			|| types == null || types.isEmpty() || types.size() > MAX_TYPE_COUNT)
		{
			throw new IllegalArgumentException("Invalid marketplace filters");
		}

		Set<String> uniqueCategories = new HashSet<>(categories);
		Set<String> uniqueTypes = new HashSet<>(types);
		if (uniqueCategories.size() != categories.size() || uniqueTypes.size() != types.size())
		{
			throw new IllegalArgumentException("Marketplace filters must be unique");
		}
		categories = Collections.unmodifiableList(categories);
		types = Collections.unmodifiableList(types);
	}
}
