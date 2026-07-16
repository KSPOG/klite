/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
import lombok.Value;

/** Immutable authenticated marketplace identity and paid-plugin entitlement set. */
@Value
public class KLiteAccountState
{
	String username;
	String email;
	@Nullable
	String discordName;
	Set<String> capabilities;
	Set<String> entitlementPluginIds;
	long expiresAtEpochSeconds;

	public KLiteAccountState(String username, String email, @Nullable String discordName,
		Set<String> capabilities, Set<String> entitlementPluginIds, long expiresAtEpochSeconds)
	{
		this.username = username;
		this.email = email;
		this.discordName = discordName;
		this.capabilities = Collections.unmodifiableSet(new HashSet<>(capabilities));
		this.entitlementPluginIds = Collections.unmodifiableSet(
			new HashSet<>(entitlementPluginIds));
		this.expiresAtEpochSeconds = expiresAtEpochSeconds;
	}

	public boolean hasEntitlement(String pluginId)
	{
		return entitlementPluginIds.contains(pluginId);
	}

	public boolean hasCapability(String capability)
	{
		return capabilities.contains(capability);
	}
}
