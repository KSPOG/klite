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
	static final int SUPPORTED_SCHEMA_VERSION = 1;
	private static final int MAX_PLUGIN_COUNT = 250;

	private int schemaVersion;
	private String updatedAt;
	private List<KLiteMarketplacePlugin> plugins;

	public int getSchemaVersion()
	{
		return schemaVersion;
	}

	public String getUpdatedAt()
	{
		return updatedAt;
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
			plugin.validate();
			if (!pluginIds.add(plugin.getId()))
			{
				throw new IllegalArgumentException("Duplicate marketplace plugin id: " + plugin.getId());
			}
		}

		plugins = Collections.unmodifiableList(plugins);
	}
}
