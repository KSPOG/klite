/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import javax.annotation.Nullable;
import lombok.Value;
import net.runelite.api.coords.WorldPoint;

/** Immutable view of the active client hint arrow. */
@Value
public class KLiteHintArrowSnapshot
{
	KLiteHintArrowType type;
	int typeId;
	@Nullable
	WorldPoint point;
	@Nullable
	KLitePlayerSnapshot player;
	@Nullable
	KLiteNpcSnapshot npc;
}
