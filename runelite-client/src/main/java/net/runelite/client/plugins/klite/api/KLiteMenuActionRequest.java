/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.util.Objects;
import lombok.Value;
import net.runelite.api.MenuAction;

/**
 * Immutable low-level game-menu action.
 *
 * <p>Callers should prefer higher-level KLite interaction methods when one is
 * available. This request exists for actions whose RuneLite menu parameters
 * have already been resolved on the client thread.</p>
 */
@Value
public class KLiteMenuActionRequest
{
	int param0;
	int param1;
	MenuAction action;
	int identifier;
	int itemId;
	String option;
	String target;

	public KLiteMenuActionRequest(
		int param0,
		int param1,
		MenuAction action,
		int identifier,
		int itemId,
		String option,
		String target)
	{
		this.param0 = param0;
		this.param1 = param1;
		this.action = Objects.requireNonNull(action, "action");
		this.identifier = identifier;
		this.itemId = itemId;
		this.option = Objects.requireNonNull(option, "option");
		this.target = Objects.requireNonNull(target, "target");
	}
}
