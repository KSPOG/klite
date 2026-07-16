/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.Rectangle;
import java.util.Collections;
import net.runelite.api.CameraFocusableEntity;
import net.runelite.api.Client;
import net.runelite.api.HashTable;
import net.runelite.api.MenuAction;
import net.runelite.api.WidgetNode;
import net.runelite.api.WorldView;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetConfigNode;
import net.runelite.api.widgets.WidgetModalMode;
import net.runelite.client.callback.ClientThread;
import org.junit.Before;
import org.junit.Test;

public class DefaultKLiteClientApiRemainingSurfaceTest
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
	public void playerMenuSnapshotHandlesUnevenClientArrays() throws Exception
	{
		when(client.getPlayerOptions()).thenReturn(new String[]{"Trade", null});
		when(client.getPlayerMenuTypes()).thenReturn(
			new int[]{MenuAction.PLAYER_FIRST_OPTION.getId()});
		when(client.getPlayerOptionsPriorities()).thenReturn(new boolean[]{true});

		assertEquals(new KLitePlayerMenuOption(
			0, "Trade", MenuAction.PLAYER_FIRST_OPTION,
			MenuAction.PLAYER_FIRST_OPTION.getId(), true),
			api.playerMenuOptions().get().get(0));
		assertEquals(new KLitePlayerMenuOption(
			1, null, MenuAction.UNKNOWN, -1, false),
			api.playerMenuOptions().get().get(1));
	}

	@Test
	public void advancedCameraSnapshotDetachesFocus() throws Exception
	{
		CameraFocusableEntity entity = mock(CameraFocusableEntity.class);
		WorldView worldView = mock(WorldView.class);
		when(worldView.getId()).thenReturn(7);
		when(entity.getWorldView()).thenReturn(worldView);
		when(entity.getCameraFocus()).thenReturn(new LocalPoint(128, 256, 7));
		when(client.getCameraFocusEntity()).thenReturn(entity);
		when(client.getCameraFpX()).thenReturn(1.25f);
		when(client.getCameraFpY()).thenReturn(2.5f);
		when(client.getCameraFpZ()).thenReturn(-3.75f);
		when(client.getCameraFpPitch()).thenReturn(4.5f);
		when(client.getCameraFpYaw()).thenReturn(5.75f);
		when(client.isCameraShakeDisabled()).thenReturn(true);

		assertEquals(new KLiteAdvancedCameraSnapshot(
			1.25f, 2.5f, -3.75f, 4.5f, 5.75f, true,
			java.util.Optional.of(new KLiteCameraFocusSnapshot(7, 128, 256))),
			api.advancedCameraSnapshot().get());
	}

	@Test
	public void cameraShakeControlIsIdempotent() throws Exception
	{
		when(client.isCameraShakeDisabled()).thenReturn(true);
		assertEquals(KLiteInteractionStatus.NO_ACTION_REQUIRED,
			api.setCameraShakeDisabled(true).get().getStatus());
		verify(client, never()).setCameraShakeDisabled(true);

		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setCameraShakeDisabled(false).get().getStatus());
		verify(client).setCameraShakeDisabled(false);
	}

	@Test
	public void worldViewQueriesReturnDetachedStructure() throws Exception
	{
		WorldView worldView = mock(WorldView.class);
		WorldPoint point = new WorldPoint(3200, 3201, 0);
		when(client.getWorldView(4)).thenReturn(worldView);
		when(client.findWorldViewFromWorldPoint(point)).thenReturn(worldView);
		when(worldView.getId()).thenReturn(4);
		when(worldView.getPlane()).thenReturn(2);
		when(worldView.getBaseX()).thenReturn(3100);
		when(worldView.getBaseY()).thenReturn(3150);
		when(worldView.getSizeX()).thenReturn(104);
		when(worldView.getSizeY()).thenReturn(104);
		when(worldView.isInstance()).thenReturn(true);
		when(worldView.getMapRegions()).thenReturn(new int[]{123, 456});

		KLiteWorldViewSnapshot expected = new KLiteWorldViewSnapshot(
			4, false, 2, 3100, 3150, 104, 104, true,
			java.util.Arrays.asList(123, 456));
		assertEquals(expected, api.worldView(4).get().get());
		assertEquals(expected, api.worldViewAt(point).get().get());
		assertFalse(api.worldView(-2).get().isPresent());
		assertFalse(api.worldViewAt(null).get().isPresent());
	}

	@Test
	public void directAndScriptWidgetQueriesDetachState() throws Exception
	{
		Widget widget = mock(Widget.class);
		when(widget.getBounds()).thenReturn(new Rectangle(1, 2, 3, 4));
		when(widget.getId()).thenReturn(0x12340005);
		when(client.getWidget(0x1234, 5)).thenReturn(widget);
		when(client.getScriptActiveWidget()).thenReturn(widget);
		when(client.getScriptDotWidget()).thenReturn(widget);

		assertEquals(0x12340005,
			api.widget(0x1234, 5).get().get().getComponentId());
		assertTrue(api.scriptActiveWidget().get().isPresent());
		assertTrue(api.scriptDotWidget().get().isPresent());
	}

	@Test
	public void widgetConfigCopiesPrimitiveMasks() throws Exception
	{
		Widget widget = mock(Widget.class);
		WidgetConfigNode config = mock(WidgetConfigNode.class);
		when(client.getWidget(77)).thenReturn(widget);
		when(client.getWidgetConfig(widget)).thenReturn(config);
		when(config.getClickMask()).thenReturn(12);
		when(config.getOpMask()).thenReturn(34);

		assertEquals(new KLiteWidgetConfigSnapshot(12, 34),
			api.widgetConfig(77).get().get());
	}

	@Test
	public void interfaceNodeCommandsResolveByComponent() throws Exception
	{
		@SuppressWarnings("unchecked")
		HashTable<WidgetNode> table = mock(HashTable.class);
		WidgetNode node = mock(WidgetNode.class);
		when(client.getComponentTable()).thenReturn(table);
		when(table.iterator()).thenReturn(Collections.singleton(node).iterator());
		when(table.get(100)).thenReturn(node);
		when(node.getHash()).thenReturn(100L);
		when(node.getId()).thenReturn(200);
		when(node.getModalMode()).thenReturn(WidgetModalMode.NON_MODAL);

		assertEquals(Collections.singletonList(new KLiteInterfaceNodeSnapshot(
			100, 200, WidgetModalMode.NON_MODAL)), api.interfaceNodes().get());
		assertEquals(KLiteInteractionStatus.NO_ACTION_REQUIRED,
			api.openInterface(100, 200, WidgetModalMode.NON_MODAL).get().getStatus());
		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.closeInterface(100, true).get().getStatus());
		verify(client).closeInterface(node, true);
	}

	@Test
	public void interfaceCommandsValidateAndDispatch() throws Exception
	{
		@SuppressWarnings("unchecked")
		HashTable<WidgetNode> table = mock(HashTable.class);
		when(client.getComponentTable()).thenReturn(table);

		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.openInterface(1, 2, 99).get().getStatus());
		verify(client, never()).openInterface(1, 2, 99);

		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.openInterface(1, 2, WidgetModalMode.MODAL_CLICKTHROUGH)
				.get().getStatus());
		verify(client).openInterface(1, 2, WidgetModalMode.MODAL_CLICKTHROUGH);
		assertEquals(KLiteInteractionStatus.TARGET_NOT_FOUND,
			api.closeInterface(3, false).get().getStatus());
	}

	@Test
	public void menuScrollValidatesAndSkipsMatchingState() throws Exception
	{
		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.setMenuScroll(-1).get().getStatus());
		verify(client, never()).setMenuScroll(-1);

		when(client.getMenuScroll()).thenReturn(4);
		assertEquals(KLiteInteractionStatus.NO_ACTION_REQUIRED,
			api.setMenuScroll(4).get().getStatus());
		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setMenuScroll(5).get().getStatus());
		verify(client).setMenuScroll(5);
	}

	@Test
	public void crossWorldMessageSnapshotCopiesRing() throws Exception
	{
		long[] ids = {10L, 20L};
		when(client.getCrossWorldMessageIds()).thenReturn(ids);
		when(client.getCrossWorldMessageIdsIndex()).thenReturn(1);

		KLiteCrossWorldMessageSnapshot snapshot =
			api.crossWorldMessageSnapshot().get();
		ids[0] = 99L;

		assertEquals(java.util.Arrays.asList(10L, 20L), snapshot.getMessageIds());
		assertEquals(1, snapshot.getNextIndex());
	}

	@Test
	public void runtimeControlsValidateAndDispatch() throws Exception
	{
		when(client.getExpandedMapLoading()).thenReturn(3);
		assertEquals(Integer.valueOf(3), api.expandedMapLoading().get());
		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.setExpandedMapLoading(-1).get().getStatus());
		assertEquals(KLiteInteractionStatus.NO_ACTION_REQUIRED,
			api.setExpandedMapLoading(3).get().getStatus());
		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setExpandedMapLoading(4).get().getStatus());
		verify(client).setExpandedMapLoading(4);

		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.setUnlockedFpsTarget(0).get().getStatus());
		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setUnlockedFpsTarget(120).get().getStatus());
		verify(client).setUnlockedFpsTarget(120);

		api.setUnlockedFps(true).get();
		api.setLowMemoryMode(true).get();
		api.setAllWidgetsTargetable(true).get();
		verify(client).setUnlockedFps(true);
		verify(client).changeMemoryMode(true);
		verify(client).setAllWidgetsAreOpTargetable(true);
	}
}
