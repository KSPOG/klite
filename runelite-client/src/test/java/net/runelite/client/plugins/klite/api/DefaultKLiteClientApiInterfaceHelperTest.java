/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.util.Arrays;
import java.util.Collections;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.MenuAction;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.InventoryID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DefaultKLiteClientApiInterfaceHelperTest
{
	private Client client;
	private DefaultKLiteClientApi api;

	@Before
	public void setUp()
	{
		client = mock(Client.class);
		when(client.isClientThread()).thenReturn(true);
		api = new DefaultKLiteClientApi(
			client, new KLiteThreadGateway(client, mock(ClientThread.class)));
	}

	@Test
	public void bankItemsAndOpenStateUseLiveBankContainers() throws Exception
	{
		ItemContainer bank = mock(ItemContainer.class);
		Widget bankItems = mock(Widget.class);
		when(client.getItemContainer(InventoryID.BANK)).thenReturn(bank);
		when(bank.getItems()).thenReturn(new Item[]{new Item(100, 3), new Item(-1, 0)});
		when(client.getWidget(InterfaceID.Bankmain.ITEMS)).thenReturn(bankItems);

		assertEquals(Collections.singletonList(new KLiteItemStack(0, 100, 3)), api.bankItems().get());
		assertTrue(api.isBankOpen().get());

		when(bankItems.isHidden()).thenReturn(true);
		assertFalse(api.isBankOpen().get());
	}

	@Test
	public void selectInventoryItemUsesWidgetTargetAction() throws Exception
	{
		ItemContainer inventory = mock(ItemContainer.class);
		ItemComposition composition = mock(ItemComposition.class);
		when(client.getItemContainer(InventoryID.INV)).thenReturn(inventory);
		when(inventory.getItems()).thenReturn(new Item[]{new Item(100, 1)});
		when(client.getItemDefinition(100)).thenReturn(composition);
		when(composition.getName()).thenReturn("Example item");

		KLiteInteractionResult result = api.selectInventoryItem(0).get();

		assertEquals(KLiteInteractionStatus.DISPATCHED, result.getStatus());
		verify(client).menuAction(0, InterfaceID.Inventory.ITEMS,
			MenuAction.WIDGET_TARGET, 0, 100, "Use", "Example item");
	}

	@Test
	public void selectedTargetRequiresAnActiveSelection() throws Exception
	{
		ItemContainer inventory = mock(ItemContainer.class);
		when(client.getItemContainer(InventoryID.INV)).thenReturn(inventory);
		when(inventory.getItems()).thenReturn(new Item[]{new Item(100, 1)});

		KLiteInteractionResult result = api.useSelectedWidgetOnInventoryItem(0).get();

		assertEquals(KLiteInteractionStatus.NO_WIDGET_SELECTED, result.getStatus());
		verify(client, never()).menuAction(
			org.mockito.ArgumentMatchers.anyInt(),
			org.mockito.ArgumentMatchers.anyInt(),
			org.mockito.ArgumentMatchers.any(MenuAction.class),
			org.mockito.ArgumentMatchers.anyInt(),
			org.mockito.ArgumentMatchers.anyInt(),
			org.mockito.ArgumentMatchers.anyString(),
			org.mockito.ArgumentMatchers.anyString());
	}

	@Test
	public void selectedInventoryTargetUsesActiveTargetVerb() throws Exception
	{
		ItemContainer inventory = mock(ItemContainer.class);
		ItemComposition composition = mock(ItemComposition.class);
		Widget selected = mock(Widget.class);
		when(client.getItemContainer(InventoryID.INV)).thenReturn(inventory);
		when(inventory.getItems()).thenReturn(new Item[]{new Item(100, 1)});
		when(client.getItemDefinition(100)).thenReturn(composition);
		when(composition.getName()).thenReturn("Target item");
		when(client.isWidgetSelected()).thenReturn(true);
		when(client.getSelectedWidget()).thenReturn(selected);
		when(selected.getTargetVerb()).thenReturn("Cast");

		KLiteInteractionResult result = api.useSelectedWidgetOnInventoryItem(0).get();

		assertEquals(KLiteInteractionStatus.DISPATCHED, result.getStatus());
		verify(client).menuAction(0, InterfaceID.Inventory.ITEMS,
			MenuAction.WIDGET_TARGET_ON_WIDGET, 0, 100, "Cast", "Target item");
	}
	@Test
	public void dialogOptionsExposeAndDispatchWidgetIndices() throws Exception
	{
		Widget parent = mock(Widget.class);
		Widget header = dialogWidget(0, "Select an Option");
		Widget first = dialogWidget(1, "Yes");
		Widget second = dialogWidget(2, "No");
		when(parent.getChildren()).thenReturn(new Widget[]{header, first, second});
		when(parent.getChild(2)).thenReturn(second);
		when(client.getWidget(InterfaceID.Chatmenu.OPTIONS)).thenReturn(parent);

		assertEquals(Arrays.asList(
			new KLiteDialogOption(1, "Yes"),
			new KLiteDialogOption(2, "No")), api.dialogOptions().get());
		assertEquals(KLiteInteractionStatus.DISPATCHED, api.chooseDialogOption(2).get().getStatus());
		verify(client).menuAction(2, InterfaceID.Chatmenu.OPTIONS,
			MenuAction.WIDGET_CONTINUE, 0, -1, "No", "");
	}

	@Test
	public void continueDialogUsesFirstVisibleSupportedWidget() throws Exception
	{
		Widget continueWidget = mock(Widget.class);
		when(continueWidget.getId()).thenReturn(InterfaceID.ChatLeft.CONTINUE);
		when(continueWidget.getIndex()).thenReturn(-1);
		when(continueWidget.getItemId()).thenReturn(-1);
		when(client.getWidget(InterfaceID.ChatLeft.CONTINUE)).thenReturn(continueWidget);

		assertEquals(KLiteInteractionStatus.DISPATCHED, api.continueDialog().get().getStatus());
		verify(client).menuAction(-1, InterfaceID.ChatLeft.CONTINUE,
			MenuAction.WIDGET_CONTINUE, 0, -1, "Continue", "");
	}

	private static Widget dialogWidget(int index, String text)
	{
		Widget widget = mock(Widget.class);
		when(widget.getId()).thenReturn(InterfaceID.Chatmenu.OPTIONS);
		when(widget.getIndex()).thenReturn(index);
		when(widget.getItemId()).thenReturn(-1);
		when(widget.getText()).thenReturn(text);
		return widget;
	}
}
