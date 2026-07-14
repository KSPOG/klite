/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import javax.annotation.Nullable;
import lombok.Value;
import net.runelite.api.FriendsChatRank;

/** Immutable copy of one friends-chat member. */
@Value
public class KLiteFriendsChatMemberSnapshot
{
	@Nullable
	String name;
	@Nullable
	String previousName;
	int world;
	@Nullable
	FriendsChatRank rank;
}
