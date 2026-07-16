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

import java.util.Collections;
import net.runelite.api.Client;
import net.runelite.api.Friend;
import net.runelite.api.FriendContainer;
import net.runelite.api.FriendsChatManager;
import net.runelite.api.FriendsChatMember;
import net.runelite.api.FriendsChatRank;
import net.runelite.api.Ignore;
import net.runelite.api.NameableContainer;
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

	@Test
	public void ignoresReturnDetachedSnapshotsAndSupportLookup() throws Exception
	{
		Client client = mock(Client.class);
		@SuppressWarnings("unchecked")
		NameableContainer<Ignore> ignores = mock(NameableContainer.class);
		Ignore ignored = mock(Ignore.class);
		when(client.isClientThread()).thenReturn(true);
		when(client.getIgnoreContainer()).thenReturn(ignores);
		when(ignores.getMembers()).thenReturn(new Ignore[]{ignored});
		when(ignores.findByName("Muted")).thenReturn(ignored);
		when(ignored.getName()).thenReturn("Muted");
		when(ignored.getPrevName()).thenReturn("Previously Muted");
		DefaultKLiteClientApi api = new DefaultKLiteClientApi(
			client, new KLiteThreadGateway(client, mock(ClientThread.class)));

		assertEquals(Collections.singletonList(
			new KLiteIgnoreSnapshot("Muted", "Previously Muted")), api.ignores().get());
		assertTrue(api.isIgnored("Muted").get());
		assertFalse(api.isIgnored(null).get());
	}

	@Test
	public void friendsChatReturnsDetachedSnapshotAndSupportsMemberLookup() throws Exception
	{
		Client client = mock(Client.class);
		FriendsChatManager friendsChat = mock(FriendsChatManager.class);
		FriendsChatMember member = mock(FriendsChatMember.class);
		when(client.isClientThread()).thenReturn(true);
		when(client.getFriendsChatManager()).thenReturn(friendsChat);
		when(friendsChat.getOwner()).thenReturn("Owner");
		when(friendsChat.getName()).thenReturn("KLite Chat");
		when(friendsChat.getMyRank()).thenReturn(FriendsChatRank.GENERAL);
		when(friendsChat.getKickRank()).thenReturn(FriendsChatRank.CAPTAIN);
		when(friendsChat.getMembers()).thenReturn(new FriendsChatMember[]{member});
		when(friendsChat.findByName("KSP")).thenReturn(member);
		when(member.getName()).thenReturn("KSP");
		when(member.getPrevName()).thenReturn("KSP Old");
		when(member.getWorld()).thenReturn(301);
		when(member.getRank()).thenReturn(FriendsChatRank.OWNER);
		DefaultKLiteClientApi api = new DefaultKLiteClientApi(
			client, new KLiteThreadGateway(client, mock(ClientThread.class)));
		KLiteFriendsChatMemberSnapshot memberSnapshot = new KLiteFriendsChatMemberSnapshot(
			"KSP", "KSP Old", 301, FriendsChatRank.OWNER);

		assertEquals(new KLiteFriendsChatSnapshot(
			"Owner", "KLite Chat", FriendsChatRank.GENERAL, FriendsChatRank.CAPTAIN,
			Collections.singletonList(memberSnapshot)), api.friendsChat().get().get());
		assertEquals(memberSnapshot, api.friendsChatMember("KSP").get().get());
		assertFalse(api.friendsChatMember(null).get().isPresent());
	}

	@Test
	public void unavailableSocialContainersReturnEmptyResults() throws Exception
	{
		Client client = mock(Client.class);
		when(client.isClientThread()).thenReturn(true);
		DefaultKLiteClientApi api = new DefaultKLiteClientApi(
			client, new KLiteThreadGateway(client, mock(ClientThread.class)));

		assertTrue(api.ignores().get().isEmpty());
		assertFalse(api.isIgnored("Anyone").get());
		assertFalse(api.friendsChat().get().isPresent());
		assertFalse(api.friendsChatMember("Anyone").get().isPresent());
	}

}
