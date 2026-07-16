/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import javax.annotation.Nullable;
import lombok.Value;
import net.runelite.api.MenuAction;

/** Immutable player-menu option state for one client option slot. */
@Value
public class KLitePlayerMenuOption
{
	int index;
	@Nullable
	String option;
	MenuAction action;
	int rawActionId;
	boolean priority;
}
