/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.walker;

import java.util.List;

/** Supplies verified transport metadata to an advanced walker implementation. */
public interface WebWalkTransportProvider
{
	List<WebWalkTransport> transports();
}
