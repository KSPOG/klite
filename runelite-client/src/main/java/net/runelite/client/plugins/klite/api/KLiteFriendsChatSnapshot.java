/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.util.List;
import javax.annotation.Nullable;
import lombok.Value;
import net.runelite.api.FriendsChatRank;

/** Immutable view of the currently joined friends chat. */
@Value
public class KLiteFriendsChatSnapshot
{
	@Nullable
	String owner;
	@Nullable
	String name;
	@Nullable
	FriendsChatRank myRank;
	@Nullable
	FriendsChatRank kickRank;
	List<KLiteFriendsChatMemberSnapshot> members;
}
