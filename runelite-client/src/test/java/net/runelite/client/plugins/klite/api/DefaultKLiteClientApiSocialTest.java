/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collections;
import net.runelite.api.Client;
import net.runelite.api.Friend;
import net.runelite.api.FriendContainer;
import net.runelite.client.callback.ClientThread;
import org.junit.Test;

public class DefaultKLiteClientApiSocialTest
{
	@Test
	public void friendsReturnDetachedSnapshots() throws Exception
	{
		Client client = mock(Client.class);
		FriendContainer friends = mock(FriendContainer.class);
		Friend friend = mock(Friend.class);
		when(client.isClientThread()).thenReturn(true);
		when(client.getFriendContainer()).thenReturn(friends);
		when(friends.getMembers()).thenReturn(new Friend[]{friend});
		when(friend.getName()).thenReturn("KSP");
		when(friend.getPrevName()).thenReturn("KSP Old");
		when(friend.getWorld()).thenReturn(301);
		when(client.isFriended("KSP", true)).thenReturn(true);
		DefaultKLiteClientApi api = new DefaultKLiteClientApi(
			client, new KLiteThreadGateway(client, mock(ClientThread.class)));

		assertEquals(Collections.singletonList(new KLiteFriendSnapshot("KSP", "KSP Old", 301)), api.friends().get());
		assertTrue(api.isFriend("KSP", true).get());
	}
}
