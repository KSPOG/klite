/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.MenuAction;
import net.runelite.api.ObjectComposition;
import net.runelite.api.Scene;
import net.runelite.api.Tile;
import net.runelite.api.WorldView;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.callback.ClientThread;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DefaultKLiteClientApiInteractionTest
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
	public void sceneObjectsExposeDetachedDefinitionData() throws Exception
	{
		WorldView worldView = mock(WorldView.class);
		Scene scene = mock(Scene.class);
		Tile tile = mock(Tile.class);
		GameObject object = mock(GameObject.class);
		ObjectComposition composition = mock(ObjectComposition.class);
		WorldPoint location = new WorldPoint(3200, 3200, 0);

		when(client.getTopLevelWorldView()).thenReturn(worldView);
		when(worldView.getScene()).thenReturn(scene);
		when(scene.getTiles()).thenReturn(new Tile[][][]{{{tile}}});
		when(tile.getGameObjects()).thenReturn(new GameObject[]{object});
		when(object.getHash()).thenReturn(1234L);
		when(object.getId()).thenReturn(100);
		when(object.getWorldLocation()).thenReturn(location);
		when(client.getObjectDefinition(100)).thenReturn(composition);
		when(composition.getName()).thenReturn("Example object");
		when(composition.getActions()).thenReturn(new String[]{"Open", null, "Search", null, null});

		List<KLiteSceneObjectSnapshot> snapshots = api.sceneObjects().get();

		assertEquals(Collections.singletonList(new KLiteSceneObjectSnapshot(
			100,
			"Example object",
			KLiteSceneObjectType.GAME,
			location,
			Arrays.asList("Open", "Search"))), snapshots);
	}

	@Test
	public void menuActionDispatchesExactValidatedParameters() throws Exception
	{
		KLiteMenuActionRequest request = new KLiteMenuActionRequest(
			10, 20, MenuAction.GAME_OBJECT_FIRST_OPTION, 100, -1, "Open", "Example object");

		api.menuAction(request).get();

		verify(client).menuAction(
			10, 20, MenuAction.GAME_OBJECT_FIRST_OPTION, 100, -1, "Open", "Example object");
	}
}
