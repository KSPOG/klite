/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.runelite.api.Client;
import net.runelite.api.EnumComposition;
import net.runelite.api.MidiRequest;
import net.runelite.api.Skill;
import net.runelite.api.StructComposition;
import net.runelite.api.dbtable.DBRowConfig;
import net.runelite.api.worldmap.MapElementConfig;
import net.runelite.client.callback.ClientThread;
import org.junit.Before;
import org.junit.Test;

public class DefaultKLiteClientApiExtendedCoverageTest
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
	public void metadataAndPresentationSnapshotsCopyPrimitiveState() throws Exception
	{
		when(client.getBuildID()).thenReturn("build-123");
		when(client.getEnvironment()).thenReturn(2);
		when(client.getRevision()).thenReturn(235);
		when(client.getItemCount()).thenReturn(30_000);
		when(client.isGpu()).thenReturn(true);
		when(client.getSkyboxColor()).thenReturn(0x112233);
		when(client.getDraw2DMask()).thenReturn(3);
		when(client.get3dZoom()).thenReturn(512);
		when(client.getCenterX()).thenReturn(400);
		when(client.getCenterY()).thenReturn(250);

		assertEquals(new KLiteClientMetadataSnapshot("build-123", 2, 235, 30_000, true),
			api.clientMetadataSnapshot().get());
		assertEquals(new KLitePresentationSnapshot(
			0x112233, 3, 512, 400, 250), api.presentationSnapshot().get());
	}

	@Test
	public void presentationControlsValidateAndSkipMatchingState() throws Exception
	{
		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.setSkyboxColor(-1).get().getStatus());
		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.setSkyboxColor(0x1000000).get().getStatus());
		verify(client, never()).setSkyboxColor(-1);

		when(client.getSkyboxColor()).thenReturn(0x123456);
		assertEquals(KLiteInteractionStatus.NO_ACTION_REQUIRED,
			api.setSkyboxColor(0x123456).get().getStatus());
		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setSkyboxColor(0x654321).get().getStatus());
		verify(client).setSkyboxColor(0x654321);

		when(client.getDraw2DMask()).thenReturn(3);
		assertEquals(KLiteInteractionStatus.NO_ACTION_REQUIRED,
			api.setDraw2DMask(3).get().getStatus());
		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setDraw2DMask(1).get().getStatus());
		verify(client).setDraw2DMask(1);
	}

	@Test
	public void midiAndDragControlsDetachAndValidate() throws Exception
	{
		MidiRequest track = mock(MidiRequest.class);
		when(track.getArchiveId()).thenReturn(42);
		when(track.isJingle()).thenReturn(true);
		when(client.getActiveMidiRequests()).thenReturn(Arrays.asList(track, null));

		assertEquals(Collections.singletonList(
			new KLiteMidiRequestSnapshot(42, true)), api.activeMidiRequests().get());
		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.setInventoryDragDelay(-1).get().getStatus());
		verify(client, never()).setInventoryDragDelay(-1);
		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setInventoryDragDelay(5).get().getStatus());
		verify(client).setInventoryDragDelay(5);
	}

	@Test
	public void variableWritesAndNotificationsValidateAndDispatch() throws Exception
	{
		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.setVarbit(-1, 2).get().getStatus());
		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.queueChangedVarp(-1).get().getStatus());
		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.queueChangedSkill(null).get().getStatus());

		when(client.getVarbitValue(10)).thenReturn(2);
		assertEquals(KLiteInteractionStatus.NO_ACTION_REQUIRED,
			api.setVarbit(10, 2).get().getStatus());
		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setVarbit(10, 3).get().getStatus());
		verify(client).setVarbit(10, 3);

		api.queueChangedVarp(20).get();
		api.queueChangedSkill(Skill.ATTACK).get();
		verify(client).queueChangedVarp(20);
		verify(client).queueChangedSkill(Skill.ATTACK);
	}

	@Test
	public void enumDefinitionCopiesAllValueArrays() throws Exception
	{
		EnumComposition definition = mock(EnumComposition.class);
		int[] keys = {1, 2};
		int[] integers = {10, 20};
		long[] longs = {100L, 200L};
		String[] strings = {"one", "two"};
		when(client.getEnum(7)).thenReturn(definition);
		when(definition.size()).thenReturn(2);
		when(definition.getKeys()).thenReturn(keys);
		when(definition.getIntVals()).thenReturn(integers);
		when(definition.getLongVals()).thenReturn(longs);
		when(definition.getStringVals()).thenReturn(strings);

		KLiteEnumSnapshot snapshot = api.enumDefinition(7).get().get();
		keys[0] = 99;
		integers[0] = 99;
		longs[0] = 99L;
		strings[0] = "changed";

		assertEquals(new KLiteEnumSnapshot(
			7, 2, Arrays.asList(1, 2), Arrays.asList(10, 20),
			Arrays.asList(100L, 200L), Arrays.asList("one", "two")), snapshot);
		assertFalse(api.enumDefinition(-1).get().isPresent());
	}

	@Test
	public void structMapAndDatabaseQueriesDetachResults() throws Exception
	{
		StructComposition struct = mock(StructComposition.class);
		MapElementConfig mapElement = mock(MapElementConfig.class);
		DBRowConfig row = mock(DBRowConfig.class);
		Object[] field = {"name", 123};
		when(client.getStructComposition(5)).thenReturn(struct);
		when(struct.getIntValue(6)).thenReturn(12);
		when(struct.getLongValue(6)).thenReturn(34L);
		when(struct.getStringValue(6)).thenReturn("value");
		when(client.getMapElementConfig(8)).thenReturn(mapElement);
		when(mapElement.getCategory()).thenReturn(9);
		when(client.getDBRowConfig(10)).thenReturn(row);
		when(row.getTableID()).thenReturn(11);
		when(client.getDBTableField(10, 12, 0)).thenReturn(field);
		when(client.getDBTableRows(11)).thenReturn(Arrays.asList(10, 20));
		when(client.getDBRowsByValue(11, 12, 0, "name"))
			.thenReturn(Collections.singletonList(10));

		assertEquals(Integer.valueOf(12), api.structIntParam(5, 6).get().get());
		assertEquals(Long.valueOf(34L), api.structLongParam(5, 6).get().get());
		assertEquals("value", api.structStringParam(5, 6).get().get());
		assertEquals(Integer.valueOf(9), api.mapElementCategory(8).get().get());
		assertEquals(Integer.valueOf(11), api.databaseRowTable(10).get().get());
		List<Object> fieldSnapshot = api.databaseField(10, 12, 0).get();
		field[0] = "changed";
		assertEquals(Arrays.asList("name", 123), fieldSnapshot);
		assertEquals(Arrays.asList(10, 20), api.databaseRows(11).get());
		assertEquals(Collections.singletonList(10),
			api.databaseRowsByValue(11, 12, 0, "name").get());
	}
}
