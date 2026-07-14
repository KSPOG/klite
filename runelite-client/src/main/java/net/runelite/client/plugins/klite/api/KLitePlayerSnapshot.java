/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import javax.annotation.Nullable;
import lombok.Value;
import net.runelite.api.coords.WorldPoint;

/** Immutable player snapshot safe to use off the client thread. */
@Value
public class KLitePlayerSnapshot
{
	int id;
	@Nullable
	String name;
	int combatLevel;
	WorldPoint location;
	int animation;
	int poseAnimation;
	boolean localPlayer;
	boolean friend;
	boolean friendsChatMember;
	boolean clanMember;
	@Nullable
	String interactingName;
}
