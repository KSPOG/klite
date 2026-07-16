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

import java.time.LocalDate;
import java.util.Collections;
import net.runelite.api.Client;
import net.runelite.api.clan.ClanChannel;
import net.runelite.api.clan.ClanChannelMember;
import net.runelite.api.clan.ClanID;
import net.runelite.api.clan.ClanMember;
import net.runelite.api.clan.ClanRank;
import net.runelite.api.clan.ClanSettings;
import net.runelite.api.clan.ClanTitle;
import net.runelite.client.callback.ClientThread;
import org.junit.Test;

public class DefaultKLiteClientApiClanTest
{
	@Test
	public void primaryClanReturnsDetachedChannelAndSettingsSnapshots() throws Exception
	{
		Client client = mock(Client.class);
		ClanChannel channel = mock(ClanChannel.class);
		ClanChannelMember channelMember = mock(ClanChannelMember.class);
		ClanSettings settings = mock(ClanSettings.class);
		ClanMember member = mock(ClanMember.class);
		ClanRank rank = new ClanRank(100);
		ClanTitle title = new ClanTitle(7, "Administrator");
		LocalDate joinDate = LocalDate.of(2026, 1, 2);
		when(client.isClientThread()).thenReturn(true);
		when(client.getClanChannel()).thenReturn(channel);
		when(client.getClanSettings()).thenReturn(settings);
		when(channel.getName()).thenReturn("KLite");
		when(channel.getMembers()).thenReturn(Collections.singletonList(channelMember));
		when(channel.findMember("Online")).thenReturn(channelMember);
		when(channelMember.getName()).thenReturn("Online");
		when(channelMember.getPrevName()).thenReturn("Formerly Online");
		when(channelMember.getWorld()).thenReturn(301);
		when(channelMember.getRank()).thenReturn(rank);
		when(settings.getName()).thenReturn("KLite");
		when(settings.getMembers()).thenReturn(Collections.singletonList(member));
		when(settings.findMember("Member")).thenReturn(member);
		when(settings.titleForRank(rank)).thenReturn(title);
		when(member.getName()).thenReturn("Member");
		when(member.getRank()).thenReturn(rank);
		when(member.getJoinDate()).thenReturn(joinDate);
		DefaultKLiteClientApi api = new DefaultKLiteClientApi(
			client, new KLiteThreadGateway(client, mock(ClientThread.class)));
		KLiteClanTitleSnapshot titleSnapshot =
			new KLiteClanTitleSnapshot(7, "Administrator");
		KLiteClanChannelMemberSnapshot channelMemberSnapshot =
			new KLiteClanChannelMemberSnapshot(
				"Online", "Formerly Online", 301, rank, titleSnapshot);
		KLiteClanMemberSnapshot memberSnapshot =
			new KLiteClanMemberSnapshot("Member", rank, joinDate, titleSnapshot);

		assertEquals(new KLiteClanChannelSnapshot(
			KLiteClanType.PRIMARY, "KLite", Collections.singletonList(channelMemberSnapshot)),
			api.clanChannel(KLiteClanType.PRIMARY).get().get());
		assertEquals(new KLiteClanSettingsSnapshot(
			KLiteClanType.PRIMARY, "KLite", Collections.singletonList(memberSnapshot)),
			api.clanSettings(KLiteClanType.PRIMARY).get().get());
		assertEquals(channelMemberSnapshot,
			api.clanChannelMember(KLiteClanType.PRIMARY, "Online").get().get());
		assertEquals(memberSnapshot,
			api.clanMember(KLiteClanType.PRIMARY, "Member").get().get());
	}

	@Test
	public void guestAndGroupIronmanUseTheirDedicatedSources() throws Exception
	{
		Client client = mock(Client.class);
		ClanChannel guestChannel = mock(ClanChannel.class);
		ClanSettings groupSettings = mock(ClanSettings.class);
		when(client.isClientThread()).thenReturn(true);
		when(client.getGuestClanChannel()).thenReturn(guestChannel);
		when(guestChannel.getName()).thenReturn("Guest Clan");
		when(guestChannel.getMembers()).thenReturn(Collections.emptyList());
		when(client.getClanSettings(ClanID.GROUP_IRONMAN)).thenReturn(groupSettings);
		when(groupSettings.getName()).thenReturn("Iron Team");
		when(groupSettings.getMembers()).thenReturn(Collections.emptyList());
		DefaultKLiteClientApi api = new DefaultKLiteClientApi(
			client, new KLiteThreadGateway(client, mock(ClientThread.class)));

		assertEquals(new KLiteClanChannelSnapshot(
			KLiteClanType.GUEST, "Guest Clan", Collections.emptyList()),
			api.clanChannel(KLiteClanType.GUEST).get().get());
		assertEquals(new KLiteClanSettingsSnapshot(
			KLiteClanType.GROUP_IRONMAN, "Iron Team", Collections.emptyList()),
			api.clanSettings(KLiteClanType.GROUP_IRONMAN).get().get());
	}

	@Test
	public void unavailableOrInvalidClanQueriesReturnEmptyResults() throws Exception
	{
		Client client = mock(Client.class);
		when(client.isClientThread()).thenReturn(true);
		DefaultKLiteClientApi api = new DefaultKLiteClientApi(
			client, new KLiteThreadGateway(client, mock(ClientThread.class)));

		assertFalse(api.clanChannel(null).get().isPresent());
		assertFalse(api.clanSettings(null).get().isPresent());
		assertFalse(api.clanChannel(KLiteClanType.PRIMARY).get().isPresent());
		assertFalse(api.clanSettings(KLiteClanType.PRIMARY).get().isPresent());
		assertFalse(api.clanChannelMember(KLiteClanType.PRIMARY, null).get().isPresent());
		assertFalse(api.clanMember(KLiteClanType.PRIMARY, null).get().isPresent());
	}
}
