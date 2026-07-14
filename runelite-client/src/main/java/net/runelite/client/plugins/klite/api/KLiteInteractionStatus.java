/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

/** Outcome of a high-level KLite interaction request. */
public enum KLiteInteractionStatus
{
	DISPATCHED,
	NO_ACTION_REQUIRED,
	TARGET_NOT_FOUND,
	OPTION_NOT_FOUND,
	NO_WIDGET_SELECTED,
	INVALID_REQUEST
}
