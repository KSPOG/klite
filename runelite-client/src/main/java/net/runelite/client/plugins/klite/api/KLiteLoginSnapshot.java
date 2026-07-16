/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import javax.annotation.Nullable;
import lombok.Value;

/** Immutable non-secret view of the current login interface state. */
@Value
public class KLiteLoginSnapshot
{
	int loginIndex;
	int selectedField;
	@Nullable
	String launcherDisplayName;
}
