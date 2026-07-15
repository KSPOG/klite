/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import lombok.Value;

/** Immutable authoritative total-level and overall-experience snapshot. */
@Value
public class KLiteSkillTotalsSnapshot
{
	int totalLevel;
	long overallExperience;
}
