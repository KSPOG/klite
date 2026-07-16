/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import lombok.Value;

/** Immutable description of an active music track or jingle request. */
@Value
public class KLiteMidiRequestSnapshot
{
	int archiveId;
	boolean jingle;
}
