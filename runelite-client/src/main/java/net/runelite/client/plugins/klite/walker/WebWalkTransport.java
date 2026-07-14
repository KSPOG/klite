/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.walker;

import java.util.Objects;
import net.runelite.api.coords.WorldPoint;

/** A verified directed transition that may connect otherwise disconnected walk paths. */
public final class WebWalkTransport
{
	private final WorldPoint source;
	private final WorldPoint destination;
	private final String name;
	private final WebWalkTransportAction action;

	public WebWalkTransport(WorldPoint source, WorldPoint destination, String name,
		WebWalkTransportAction action)
	{
		this.source = Objects.requireNonNull(source, "source");
		this.destination = Objects.requireNonNull(destination, "destination");
		this.name = Objects.requireNonNull(name, "name");
		this.action = Objects.requireNonNull(action, "action");
	}

	public WorldPoint getSource()
	{
		return source;
	}

	public WorldPoint getDestination()
	{
		return destination;
	}

	public WebWalkTransportAction getAction()
	{
		return action;
	}

	public String getName()
	{
		return name;
	}
}
