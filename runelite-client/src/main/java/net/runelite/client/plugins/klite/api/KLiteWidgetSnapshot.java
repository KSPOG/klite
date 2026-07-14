/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.util.List;
import javax.annotation.Nullable;
import lombok.Value;

/** Immutable widget data safe to retain outside RuneLite's client thread. */
@Value
public class KLiteWidgetSnapshot
{
	int componentId;
	int index;
	int parentId;
	int type;
	int contentType;
	@Nullable
	String text;
	@Nullable
	String name;
	int itemId;
	int itemQuantity;
	boolean hidden;
	int x;
	int y;
	int width;
	int height;
	List<KLiteWidgetAction> actions;
}
