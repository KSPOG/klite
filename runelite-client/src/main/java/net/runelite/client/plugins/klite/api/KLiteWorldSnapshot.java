/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.util.List;
import javax.annotation.Nullable;
import lombok.Value;
import net.runelite.api.WorldType;

/** Immutable copy of one entry in the loaded game world list. */
@Value
public class KLiteWorldSnapshot
{
	int id;
	int index;
	int playerCount;
	int location;
	@Nullable
	String activity;
	@Nullable
	String address;
	List<WorldType> types;
}
