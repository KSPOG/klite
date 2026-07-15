/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import net.runelite.api.Client;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;
import net.runelite.client.callback.ClientThread;
import org.junit.Before;
import org.junit.Test;

public class DefaultKLiteClientApiQuestTest
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
	public void questStateMapsEveryClientScriptResult() throws Exception
	{
		when(client.getIntStack()).thenReturn(
			new int[]{2}, new int[]{1}, new int[]{0});

		assertEquals(QuestState.FINISHED,
			api.questState(Quest.COOKS_ASSISTANT).get().get());
		assertEquals(QuestState.NOT_STARTED,
			api.questState(Quest.COOKS_ASSISTANT).get().get());
		assertEquals(QuestState.IN_PROGRESS,
			api.questState(Quest.COOKS_ASSISTANT).get().get());
	}

	@Test
	public void questStateIsEmptyForNullRequest() throws Exception
	{
		assertFalse(api.questState(null).get().isPresent());
	}
}
