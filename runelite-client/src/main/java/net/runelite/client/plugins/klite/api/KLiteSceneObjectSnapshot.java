/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.util.List;
import javax.annotation.Nullable;
import lombok.Value;
import net.runelite.api.coords.WorldPoint;

/** Immutable scene-object snapshot safe to use off the client thread. */
@Value
public class KLiteSceneObjectSnapshot
{
	int objectId;
	@Nullable
	String name;
	KLiteSceneObjectType type;
	WorldPoint location;
	List<String> actions;
}
