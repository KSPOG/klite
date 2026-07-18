/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.walker;

import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.coords.LocalPoint;

/** Dispatches an unambiguous ground walk action for a scene tile. */
final class GroundWalkDispatcher
{
	private GroundWalkDispatcher()
	{
	}

	static void walk(Client client, LocalPoint target)
	{
		client.menuAction(target.getSceneX(), target.getSceneY(), MenuAction.WALK,
			0, -1, "Walk here", "");
	}
}