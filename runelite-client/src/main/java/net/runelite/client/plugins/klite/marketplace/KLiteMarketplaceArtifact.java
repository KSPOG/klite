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

/** Immutable catalog metadata used to authenticate a streamed plugin artifact. */
public final class KLiteMarketplaceArtifact
{
	static final long MAX_SIZE = 20L * 1024L * 1024L;
	private static final Pattern SHA256_PATTERN = Pattern.compile("[a-f0-9]{64}");
	private static final Pattern CLASS_NAME_PATTERN = Pattern.compile(
		"[A-Za-z_$][A-Za-z0-9_$]*(?:\\.[A-Za-z_$][A-Za-z0-9_$]*)+");

	private String version;
	private String sha256;
	private long size;
	private List<String> entrypoints;

	public String getVersion()
	{
		return version;
	}

	public String getSha256()
	{
		return sha256;
	}

	public long getSize()
	{
		return size;
	}

	public List<String> getEntrypoints()
	{
		return entrypoints;
	}

	void validate(String pluginId, String descriptorVersion)
	{
		if (!descriptorVersion.equals(version))
		{
			throw new IllegalArgumentException("Marketplace artifact version does not match: " + pluginId);
		}
		if (sha256 == null || !SHA256_PATTERN.matcher(sha256).matches())
		{
			throw new IllegalArgumentException("Invalid marketplace artifact hash: " + pluginId);
		}
		if (size <= 0 || size > MAX_SIZE)
		{
			throw new IllegalArgumentException("Invalid marketplace artifact size: " + pluginId);
		}
		if (entrypoints == null || entrypoints.isEmpty() || entrypoints.size() > 25)
		{
			throw new IllegalArgumentException("Invalid marketplace artifact entrypoints: " + pluginId);
		}

		Set<String> unique = new HashSet<>();
		for (String entrypoint : entrypoints)
		{
			if (entrypoint == null || !CLASS_NAME_PATTERN.matcher(entrypoint).matches()
				|| !unique.add(entrypoint))
			{
				throw new IllegalArgumentException("Invalid marketplace artifact entrypoint: " + pluginId);
			}
		}
		entrypoints = Collections.unmodifiableList(entrypoints);
	}
}
