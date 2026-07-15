/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import javax.annotation.Nullable;
import lombok.Value;
import net.runelite.api.MenuAction;

/** Immutable copy of one current client menu entry. */
@Value
public class KLiteMenuEntrySnapshot
{
	int index;
	@Nullable
	String option;
	@Nullable
	String target;
	@Nullable
	MenuAction action;
	int identifier;
	int param0;
	int param1;
	int itemId;
	int itemOp;
	int worldViewId;
	boolean forceLeftClick;
	boolean deprioritized;
}
