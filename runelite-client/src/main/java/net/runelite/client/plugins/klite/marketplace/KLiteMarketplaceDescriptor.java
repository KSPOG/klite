/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Serializable marketplace representation of {@code PluginDescriptor}.
 */
public final class KLiteMarketplaceDescriptor
{
	private static final Pattern DISPLAY_PATTERN = Pattern.compile("[A-Za-z0-9][A-Za-z0-9 ._'()-]{0,63}");
	private static final Pattern TAG_PATTERN = Pattern.compile("[a-z0-9][a-z0-9-]{0,31}");
	private static final Pattern VERSION_PATTERN = Pattern.compile(
		"[0-9]+(?:\\.[0-9]+){1,3}(?:[-+][A-Za-z0-9.-]+)?");
	private static final int MAX_TAGS = 20;
	private static final int MAX_AUTHORS = 10;

	private String name;
	private String description;
	private List<String> tags;
	private List<String> authors;
	private String version;
	private String minClientVersion;
	private boolean enabledByDefault;
	private boolean isExternal;

	public String getName()
	{
		return name;
	}

	public String getDescription()
	{
		return description;
	}

	public List<String> getTags()
	{
		return tags;
	}

	public List<String> getAuthors()
	{
		return authors;
	}

	public String getVersion()
	{
		return version;
	}

	public String getMinClientVersion()
	{
		return minClientVersion;
	}

	public boolean isEnabledByDefault()
	{
		return enabledByDefault;
	}

	public boolean isExternal()
	{
		return isExternal;
	}

	void validate(String pluginId)
	{
		if (name == null || !DISPLAY_PATTERN.matcher(name).matches())
		{
			throw new IllegalArgumentException("Invalid marketplace plugin name: " + pluginId);
		}
		if (description == null || description.isBlank() || description.length() > 300)
		{
			throw new IllegalArgumentException("Invalid marketplace plugin description: " + pluginId);
		}
		if (version == null || !VERSION_PATTERN.matcher(version).matches())
		{
			throw new IllegalArgumentException("Invalid marketplace plugin version: " + pluginId);
		}
		if (minClientVersion == null || !VERSION_PATTERN.matcher(minClientVersion).matches())
		{
			throw new IllegalArgumentException("Invalid minimum client version: " + pluginId);
		}
		if (!isExternal)
		{
			throw new IllegalArgumentException("Marketplace plugins must be external: " + pluginId);
		}

		validateTags(pluginId);
		validateAuthors(pluginId);
		tags = Collections.unmodifiableList(tags);
		authors = Collections.unmodifiableList(authors);
	}

	private void validateTags(String pluginId)
	{
		if (tags == null || tags.size() > MAX_TAGS)
		{
			throw new IllegalArgumentException("Invalid marketplace plugin tags: " + pluginId);
		}

		Set<String> uniqueTags = new HashSet<>();
		for (String tag : tags)
		{
			if (tag == null || !TAG_PATTERN.matcher(tag).matches() || !uniqueTags.add(tag))
			{
				throw new IllegalArgumentException("Invalid marketplace plugin tag: " + pluginId);
			}
		}
	}

	private void validateAuthors(String pluginId)
	{
		if (authors == null || authors.isEmpty() || authors.size() > MAX_AUTHORS)
		{
			throw new IllegalArgumentException("Invalid marketplace plugin authors: " + pluginId);
		}

		Set<String> uniqueAuthors = new HashSet<>();
		for (String author : authors)
		{
			if (author == null || !DISPLAY_PATTERN.matcher(author).matches() || !uniqueAuthors.add(author))
			{
				throw new IllegalArgumentException("Invalid marketplace plugin author: " + pluginId);
			}
		}
	}
}
