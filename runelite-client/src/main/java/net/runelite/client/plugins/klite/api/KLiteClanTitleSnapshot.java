/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import javax.annotation.Nullable;
import lombok.Value;

/** Immutable copy of a configurable clan title. */
@Value
public class KLiteClanTitleSnapshot
{
	int id;
	@Nullable
	String name;
}
