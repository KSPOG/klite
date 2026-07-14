/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.util.List;
import lombok.Value;

/** Immutable scene-object definition safe to use outside the client thread. */
@Value
public class KLiteObjectDefinition
{
	int id;
	String name;
	int sizeX;
	int sizeY;
	int mapSceneId;
	int mapIconId;
	int varbitId;
	int varPlayerId;
	List<String> actions;
}
