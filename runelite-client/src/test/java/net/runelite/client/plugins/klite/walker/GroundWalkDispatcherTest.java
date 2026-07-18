/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.walker;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.coords.LocalPoint;
import org.junit.Test;

public class GroundWalkDispatcherTest
{
	@Test
	public void dispatchesWalkRatherThanHoveredEntityAction()
	{
		Client client = mock(Client.class);
		LocalPoint target = new LocalPoint(42 << 7, 57 << 7);

		GroundWalkDispatcher.walk(client, target);

		verify(client).menuAction(42, 57, MenuAction.WALK,
			0, -1, "Walk here", "");
		verifyNoMoreInteractions(client);
	}
}