/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.util.List;
import lombok.Value;

/** Immutable view of the current root interface and its root widgets. */
@Value
public class KLiteInterfaceSnapshot
{
	int topLevelInterfaceId;
	List<KLiteWidgetSnapshot> roots;
}
