/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.awt.Rectangle;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DefaultKLiteClientApiWidgetVariableTest
{
	private static final int COMPONENT_ID = 0x12340001;

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
	public void widgetReturnsDetachedSparseActions() throws Exception
	{
		Widget widget = widget("Example", new String[]{"Open", null, null, null, null, "Configure"});
		when(client.getWidget(COMPONENT_ID)).thenReturn(widget);

		Optional<KLiteWidgetSnapshot> result = api.widget(COMPONENT_ID).get();

		assertEquals(Optional.of(new KLiteWidgetSnapshot(
			COMPONENT_ID,
			3,
			0x12340000,
			4,
			5,
			"Widget text",
			"Example",
			100,
			2,
			false,
			10,
			20,
			30,
			40,
			Arrays.asList(
				new KLiteWidgetAction(1, "Open"),
				new KLiteWidgetAction(6, "Configure")))), result);
	}

	@Test
	public void widgetChildAndChildrenHandleSparseArrays() throws Exception
	{
		Widget parent = mock(Widget.class);
		Widget child = widget("Child", new String[]{"Select"});
		when(client.getWidget(COMPONENT_ID)).thenReturn(parent);
		when(parent.getChild(2)).thenReturn(child);
		when(parent.getChildren()).thenReturn(new Widget[]{null, null, child});

		assertEquals(Optional.of(snapshot(child)), api.widgetChild(COMPONENT_ID, 2).get());
		assertEquals(Collections.singletonList(snapshot(child)), api.widgetChildren(COMPONENT_ID).get());
		assertFalse(api.widgetChild(COMPONENT_ID, 1).get().isPresent());
	}

	@Test
	public void widgetInteractionUsesResolvedLowPriorityOperation() throws Exception
	{
		Widget widget = widget("Example", new String[]{null, null, null, null, null, "Configure"});
		when(client.getWidget(COMPONENT_ID)).thenReturn(widget);

		KLiteInteractionResult result = api.interactWidget(COMPONENT_ID, "configure").get();

		assertEquals(KLiteInteractionStatus.DISPATCHED, result.getStatus());
		verify(client).menuAction(3, COMPONENT_ID, MenuAction.CC_OP_LOW_PRIORITY,
			6, 100, "Configure", "Example");
	}

	@Test
	public void hiddenWidgetDoesNotDispatch() throws Exception
	{
		Widget widget = widget("Hidden", new String[]{"Open"});
		when(widget.isHidden()).thenReturn(true);
		when(client.getWidget(COMPONENT_ID)).thenReturn(widget);

		KLiteInteractionResult result = api.interactWidget(COMPONENT_ID, "Open").get();

		assertEquals(KLiteInteractionStatus.TARGET_NOT_FOUND, result.getStatus());
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
	public void variableReadsUseMatchingClientAndServerSources() throws Exception
	{
		when(client.getVarbitValue(10)).thenReturn(11);
		when(client.getServerVarbitValue(10)).thenReturn(12);
		when(client.getVarpValue(20)).thenReturn(21);
		when(client.getServerVarpValue(20)).thenReturn(22);
		when(client.getVarcIntValue(30)).thenReturn(31);
		when(client.getVarcStrValue(40)).thenReturn("value");

		assertEquals(Integer.valueOf(11), api.varbit(10).get());
		assertEquals(Integer.valueOf(12), api.serverVarbit(10).get());
		assertEquals(Integer.valueOf(21), api.varp(20).get());
		assertEquals(Integer.valueOf(22), api.serverVarp(20).get());
		assertEquals(Integer.valueOf(31), api.varcInt(30).get());
		assertEquals("value", api.varcString(40).get());
	}

	private Widget widget(String name, String[] actions)
	{
		Widget widget = mock(Widget.class);
		when(widget.getId()).thenReturn(COMPONENT_ID);
		when(widget.getIndex()).thenReturn(3);
		when(widget.getParentId()).thenReturn(0x12340000);
		when(widget.getType()).thenReturn(4);
		when(widget.getContentType()).thenReturn(5);
		when(widget.getText()).thenReturn("Widget text");
		when(widget.getName()).thenReturn(name);
		when(widget.getItemId()).thenReturn(100);
		when(widget.getItemQuantity()).thenReturn(2);
		when(widget.getBounds()).thenReturn(new Rectangle(10, 20, 30, 40));
		when(widget.getActions()).thenReturn(actions);
		return widget;
	}

	private static KLiteWidgetSnapshot snapshot(Widget widget)
	{
		return new KLiteWidgetSnapshot(
			widget.getId(),
			widget.getIndex(),
			widget.getParentId(),
			widget.getType(),
			widget.getContentType(),
			widget.getText(),
			widget.getName(),
			widget.getItemId(),
			widget.getItemQuantity(),
			widget.isHidden(),
			widget.getBounds().x,
			widget.getBounds().y,
			widget.getBounds().width,
			widget.getBounds().height,
			Collections.singletonList(new KLiteWidgetAction(1, "Select")));
	}
}
