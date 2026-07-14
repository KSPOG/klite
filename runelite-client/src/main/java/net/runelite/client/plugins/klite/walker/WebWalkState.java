/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.walker;

public enum WebWalkState
{
	IDLE,
	PATHFINDING,
	MOVING,
	ARRIVED,
	NO_PATH,
	NOT_LOGGED_IN
}
