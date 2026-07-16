/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/** Supported camera modes, with an unknown value for forward compatibility. */
@Getter
@RequiredArgsConstructor
public enum KLiteCameraMode
{
	NORMAL(0),
	FREE(1),
	UNKNOWN(-1);

	private final int id;

	public static KLiteCameraMode fromId(int id)
	{
		if (id == NORMAL.id)
		{
			return NORMAL;
		}
		if (id == FREE.id)
		{
			return FREE;
		}
		return UNKNOWN;
	}
}
