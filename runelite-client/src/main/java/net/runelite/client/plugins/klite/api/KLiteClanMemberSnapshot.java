/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.time.LocalDate;
import javax.annotation.Nullable;
import lombok.Value;
import net.runelite.api.clan.ClanRank;

/** Immutable copy of one clan-settings member. */
@Value
public class KLiteClanMemberSnapshot
{
	@Nullable
	String name;
	@Nullable
	ClanRank rank;
	@Nullable
	LocalDate joinDate;
	@Nullable
	KLiteClanTitleSnapshot title;
}
