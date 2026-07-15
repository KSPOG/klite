/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import net.runelite.api.Client;
import net.runelite.api.Menu;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.client.callback.ClientThread;
import org.junit.Before;
import org.junit.Test;

public class DefaultKLiteClientApiMenuStateTest
{
	private Client client;
	private Menu menu;
	private DefaultKLiteClientApi api;

	@Before
	public void setUp()
	{
		client = mock(Client.class);
		menu = mock(Menu.class);
		when(client.isClientThread()).thenReturn(true);
		when(client.getMenu()).thenReturn(menu);
		api = new DefaultKLiteClientApi(
			client, new KLiteThreadGateway(client, mock(ClientThread.class)));
	}

	@Test
	public void menuSnapshotDetachesMenuAndEntryState() throws Exception
	{
		MenuEntry entry = mock(MenuEntry.class);
		MenuEntry[] entries = {entry, null};
		when(client.isMenuOpen()).thenReturn(true);
		when(client.isMenuScrollable()).thenReturn(true);
		when(client.getMenuScroll()).thenReturn(2);
		when(menu.getMenuX()).thenReturn(10);
		when(menu.getMenuY()).thenReturn(20);
		when(menu.getMenuWidth()).thenReturn(200);
		when(menu.getMenuHeight()).thenReturn(150);
		when(menu.getMenuEntries()).thenReturn(entries);
		when(entry.getOption()).thenReturn("Take");
		when(entry.getTarget()).thenReturn("Coins");
		when(entry.getType()).thenReturn(MenuAction.GROUND_ITEM_FIRST_OPTION);
		when(entry.getIdentifier()).thenReturn(995);
		when(entry.getParam0()).thenReturn(5);
		when(entry.getParam1()).thenReturn(6);
		when(entry.getItemId()).thenReturn(995);
		when(entry.getItemOp()).thenReturn(1);
		when(entry.getWorldViewId()).thenReturn(0);
		when(entry.isForceLeftClick()).thenReturn(true);
		when(entry.isDeprioritized()).thenReturn(false);

		KLiteMenuSnapshot snapshot = api.menuSnapshot().get();
		entries[0] = null;

		KLiteMenuEntrySnapshot expectedEntry = new KLiteMenuEntrySnapshot(
			0, "Take", "Coins", MenuAction.GROUND_ITEM_FIRST_OPTION,
			995, 5, 6, 995, 1, 0, true, false);
		assertEquals(new KLiteMenuSnapshot(
			true, true, 2, 10, 20, 200, 150, Collections.singletonList(expectedEntry)),
			snapshot);
	}

	@Test
	public void interactMenuEntryDispatchesCurrentResolvedParameters() throws Exception
	{
		MenuEntry entry = mock(MenuEntry.class);
		when(menu.getMenuEntries()).thenReturn(new MenuEntry[]{entry});
		when(entry.getOption()).thenReturn("Talk-to");
		when(entry.getTarget()).thenReturn("Guide");
		when(entry.getType()).thenReturn(MenuAction.NPC_FIRST_OPTION);
		when(entry.getIdentifier()).thenReturn(7);
		when(entry.getParam0()).thenReturn(1);
		when(entry.getParam1()).thenReturn(2);
		when(entry.getItemId()).thenReturn(-1);

		KLiteInteractionResult result = api.interactMenuEntry(0).get();

		assertEquals(KLiteInteractionStatus.DISPATCHED, result.getStatus());
		verify(client).menuAction(
			1, 2, MenuAction.NPC_FIRST_OPTION, 7, -1, "Talk-to", "Guide");
	}

	@Test
	public void interactMenuEntryValidatesIndexPresenceAndAction() throws Exception
	{
		MenuEntry entry = mock(MenuEntry.class);
		when(menu.getMenuEntries()).thenReturn(new MenuEntry[]{entry});

		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.interactMenuEntry(-1).get().getStatus());
		assertEquals(KLiteInteractionStatus.TARGET_NOT_FOUND,
			api.interactMenuEntry(1).get().getStatus());
		assertEquals(KLiteInteractionStatus.OPTION_NOT_FOUND,
			api.interactMenuEntry(0).get().getStatus());
	}

	@Test
	public void missingMenuReturnsEmptySnapshotAndNoTarget() throws Exception
	{
		when(client.getMenu()).thenReturn(null);

		assertEquals(Collections.emptyList(), api.menuSnapshot().get().getEntries());
		assertEquals(KLiteInteractionStatus.TARGET_NOT_FOUND,
			api.interactMenuEntry(0).get().getStatus());
	}
}
