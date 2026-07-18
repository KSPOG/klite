/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.launcher;

import net.runelite.client.KLite;

/** Native KLiteClient.exe entry point created as a secondary jpackage launcher. */
public final class KLiteClient
{
	private KLiteClient()
	{
	}

	public static void main(String[] args) throws Exception
	{
		KLite.main(clientArguments(args));
	}

	static String[] clientArguments(String[] args)
	{
		String[] forwarded = new String[args.length + 1];
		forwarded[0] = KLiteLauncher.CLIENT_ARGUMENT;
		System.arraycopy(args, 0, forwarded, 1, args.length);
		return forwarded;
	}
}
