/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.util.List;
import lombok.Value;

/** Immutable copy of the client's cross-world message deduplication ring. */
@Value
public class KLiteCrossWorldMessageSnapshot
{
	List<Long> messageIds;
	int nextIndex;
}
