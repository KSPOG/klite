/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import lombok.Value;

/** Immutable description of an interface attached to a component. */
@Value
public class KLiteInterfaceNodeSnapshot
{
	int componentId;
	int interfaceId;
	int modalMode;
}
