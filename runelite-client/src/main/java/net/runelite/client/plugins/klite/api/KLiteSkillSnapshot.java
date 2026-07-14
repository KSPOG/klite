/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import lombok.Value;
import net.runelite.api.Skill;

/** Immutable skill-level snapshot safe to use off the client thread. */
@Value
public class KLiteSkillSnapshot
{
	Skill skill;
	int realLevel;
	int boostedLevel;
	int experience;
}
