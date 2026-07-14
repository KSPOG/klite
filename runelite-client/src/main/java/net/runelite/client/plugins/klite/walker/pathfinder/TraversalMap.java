/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.walker.pathfinder;

interface TraversalMap
{
	boolean contains(int packedPoint);

	boolean canMove(int packedPoint, int direction);
}
