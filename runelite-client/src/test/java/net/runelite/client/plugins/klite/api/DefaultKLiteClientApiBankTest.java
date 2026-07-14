/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.util.Optional;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.MenuAction;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.InventoryID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DefaultKLiteClientApiBankTest
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
	public void bankQueriesPreserveLargeStackTotalsAndSlots() throws Exception
	{
		ItemContainer bank = mock(ItemContainer.class);
		when(client.getItemContainer(InventoryID.BANK)).thenReturn(bank);
		when(bank.getItems()).thenReturn(new Item[]{
			new Item(100, Integer.MAX_VALUE), new Item(-1, 0), new Item(100, 10)
		});

		assertEquals(Long.valueOf((long) Integer.MAX_VALUE + 10), api.bankCount(100).get());
		assertEquals(Boolean.TRUE, api.bankContains(100).get());
		assertEquals(Boolean.FALSE, api.bankContains(200).get());
		assertEquals(Optional.of(0), api.firstBankSlot(100).get());
	}

	@Test
	public void withdrawUsesCurrentQuantityAction() throws Exception
	{
		Widget parent = mock(Widget.class);
		Widget item = bankWidget(InterfaceID.Bankmain.ITEMS, "Bank item",
			new String[]{null, "Withdraw-1", "Withdraw-5", "Withdraw-10", "Withdraw-All"});
		when(client.getWidget(InterfaceID.Bankmain.ITEMS)).thenReturn(parent);
		when(parent.getChild(4)).thenReturn(item);

		KLiteInteractionResult result = api.withdrawBankItem(4, KLiteBankQuantity.ALL).get();

		assertEquals(KLiteInteractionStatus.DISPATCHED, result.getStatus());
		verify(client).menuAction(4, InterfaceID.Bankmain.ITEMS,
			MenuAction.CC_OP, 5, 100, "Withdraw-All", "Bank item");
	}

	@Test
	public void depositUsesCurrentBankInventoryAction() throws Exception
	{
		Widget parent = mock(Widget.class);
		Widget item = bankWidget(InterfaceID.Bankside.ITEMS, "Inventory item",
			new String[]{null, "Deposit-1", "Deposit-5", "Deposit-10", "Deposit-All"});
		when(item.getIndex()).thenReturn(2);
		when(client.getWidget(InterfaceID.Bankside.ITEMS)).thenReturn(parent);
		when(parent.getChild(2)).thenReturn(item);

		KLiteInteractionResult result =
			api.depositBankInventoryItem(2, KLiteBankQuantity.TEN).get();

		assertEquals(KLiteInteractionStatus.DISPATCHED, result.getStatus());
		verify(client).menuAction(2, InterfaceID.Bankside.ITEMS,
			MenuAction.CC_OP, 4, 100, "Deposit-10", "Inventory item");
	}

	@Test
	public void depositInventoryUsesGeneratedBankComponent() throws Exception
	{
		Widget button = bankWidget(InterfaceID.Bankmain.DEPOSITINV, "",
			new String[]{"Deposit inventory"});
		when(client.getWidget(InterfaceID.Bankmain.DEPOSITINV)).thenReturn(button);

		KLiteInteractionResult result = api.depositInventory().get();

		assertEquals(KLiteInteractionStatus.DISPATCHED, result.getStatus());
		verify(client).menuAction(-1, InterfaceID.Bankmain.DEPOSITINV,
			MenuAction.CC_OP, 1, 100, "Deposit inventory", "");
	}

	@Test
	public void missingQuantityDoesNotDispatch() throws Exception
	{
		KLiteInteractionResult result = api.withdrawBankItem(0, null).get();

		assertEquals(KLiteInteractionStatus.INVALID_REQUEST, result.getStatus());
		verify(client, never()).getWidget(InterfaceID.Bankmain.ITEMS);
	}

	private static Widget bankWidget(int componentId, String name, String[] actions)
	{
		Widget widget = mock(Widget.class);
		when(widget.getId()).thenReturn(componentId);
		when(widget.getIndex()).thenReturn(componentId == InterfaceID.Bankmain.DEPOSITINV ? -1 : 4);
		when(widget.getItemId()).thenReturn(100);
		when(widget.getName()).thenReturn(name);
		when(widget.getActions()).thenReturn(actions);
		return widget;
	}
}
