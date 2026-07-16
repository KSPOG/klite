/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import javax.annotation.Nullable;
import lombok.Value;
import net.runelite.api.clan.ClanRank;

/** Immutable copy of one online clan-channel member. */
@Value
public class KLiteClanChannelMemberSnapshot
{
	@Nullable
	String name;
	@Nullable
	String previousName;
	int world;
	@Nullable
	ClanRank rank;
	@Nullable
	KLiteClanTitleSnapshot title;
}
