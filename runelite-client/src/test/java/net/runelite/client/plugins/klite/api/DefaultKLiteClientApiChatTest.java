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
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.IterableHashTable;
import net.runelite.api.MessageNode;
import net.runelite.client.callback.ClientThread;
import org.junit.Before;
import org.junit.Test;

public class DefaultKLiteClientApiChatTest
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
	@SuppressWarnings("unchecked")
	public void chatMessagesReturnDetachedSnapshotsAndFilterByType() throws Exception
	{
		IterableHashTable<MessageNode> messages = mock(IterableHashTable.class);
		MessageNode gameMessage = message(10, ChatMessageType.GAMEMESSAGE, "", "", "Welcome", 100);
		MessageNode publicMessage = message(11, ChatMessageType.PUBLICCHAT, "KSP", "", "Hello", 101);
		when(messages.iterator()).thenAnswer(invocation -> Arrays.asList(gameMessage, publicMessage).iterator());
		when(messages.get(10)).thenReturn(gameMessage);
		when(client.getMessages()).thenReturn(messages);

		List<KLiteChatMessageSnapshot> allMessages = api.chatMessages().get();
		List<KLiteChatMessageSnapshot> publicMessages = api.chatMessages(ChatMessageType.PUBLICCHAT).get();

		assertEquals(2, allMessages.size());
		assertEquals(
			new KLiteChatMessageSnapshot(10, ChatMessageType.GAMEMESSAGE, "", "", "Welcome", null, 100),
			allMessages.get(0));
		assertEquals(
			Collections.singletonList(new KLiteChatMessageSnapshot(
				11, ChatMessageType.PUBLICCHAT, "KSP", "", "Hello", null, 101)),
			publicMessages);
		assertEquals("Welcome", api.chatMessage(10).get().get().getValue());
		assertFalse(api.chatMessage(-1).get().isPresent());
	}

	@Test
	public void chatMessagesHandleUnavailableHistory() throws Exception
	{
		assertTrue(api.chatMessages().get().isEmpty());
		assertFalse(api.chatMessage(1).get().isPresent());
	}

	private static MessageNode message(
		int id, ChatMessageType type, String name, String sender, String value, int timestamp)
	{
		MessageNode message = mock(MessageNode.class);
		when(message.getId()).thenReturn(id);
		when(message.getType()).thenReturn(type);
		when(message.getName()).thenReturn(name);
		when(message.getSender()).thenReturn(sender);
		when(message.getValue()).thenReturn(value);
		when(message.getTimestamp()).thenReturn(timestamp);
		return message;
	}
}
