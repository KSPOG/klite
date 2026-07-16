/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import lombok.Value;

/** Immutable client build and runtime compatibility metadata. */
@Value
public class KLiteClientMetadataSnapshot
{
	String buildId;
	int environment;
	int revision;
	int itemDefinitionCount;
	boolean gpu;
}
