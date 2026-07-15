/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.util.List;
import javax.annotation.Nullable;
import lombok.Value;

/** Immutable view of one currently available clan settings container. */
@Value
public class KLiteClanSettingsSnapshot
{
	KLiteClanType type;
	@Nullable
	String name;
	List<KLiteClanMemberSnapshot> members;
}
