/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.walker;

import net.runelite.client.plugins.klite.api.KLiteInteractionResult;

/** Executes a transport after the walker has reached its verified source tile. */
@FunctionalInterface
public interface WebWalkTransportAction
{
	KLiteInteractionResult execute();
}
