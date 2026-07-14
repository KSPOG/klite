/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client;

/**
 * Stable entry point for the KLite distribution.
 *
 * <p>This small adapter keeps upstream updates straightforward while giving
 * launchers a KLite-owned main class.</p>
 */
public final class KLite
{
	private KLite()
	{
	}

	public static void main(String[] args) throws Exception
	{
		RuneLite.main(args);
	}
}
