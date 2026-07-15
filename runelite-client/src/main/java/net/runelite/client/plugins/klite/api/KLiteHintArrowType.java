/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import net.runelite.api.HintArrowType;

/** Stable KLite representation of RuneLite hint-arrow target types. */
public enum KLiteHintArrowType
{
	NONE,
	NPC,
	COORDINATE,
	PLAYER,
	WORLD_ENTITY,
	UNKNOWN;

	static KLiteHintArrowType fromId(int typeId)
	{
		switch (typeId)
		{
			case HintArrowType.NONE:
				return NONE;
			case HintArrowType.NPC:
				return NPC;
			case HintArrowType.COORDINATE:
				return COORDINATE;
			case HintArrowType.PLAYER:
				return PLAYER;
			case HintArrowType.WORLDENTITY:
				return WORLD_ENTITY;
			default:
				return UNKNOWN;
		}
	}
}
