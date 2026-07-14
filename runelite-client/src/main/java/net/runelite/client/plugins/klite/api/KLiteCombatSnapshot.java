/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.util.List;
import javax.annotation.Nullable;
import lombok.Value;
import net.runelite.api.Prayer;

/** Immutable combat and movement state safe to use outside the client thread. */
@Value
public class KLiteCombatSnapshot
{
	int hitpoints;
	int maximumHitpoints;
	int prayerPoints;
	int maximumPrayerPoints;
	int runEnergy;
	int weight;
	boolean runEnabled;
	int specialAttackEnergy;
	boolean specialAttackEnabled;
	int poisonValue;
	boolean poisoned;
	boolean venomed;
	boolean inWilderness;
	int animation;
	int poseAnimation;
	@Nullable
	String interactingName;
	List<Prayer> activePrayers;
}
