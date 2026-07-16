/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;
import org.junit.Before;
import org.junit.Test;

public class DefaultKLiteClientApiLoginTest
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
	public void loginSnapshotContainsOnlyNonSecretState() throws Exception
	{
		when(client.getLoginIndex()).thenReturn(4);
		when(client.getCurrentLoginField()).thenReturn(1);
		when(client.getLauncherDisplayName()).thenReturn("Display Name");

		assertEquals(new KLiteLoginSnapshot(4, 1, "Display Name"),
			api.loginSnapshot().get());
	}

	@Test
	public void loginControlsDispatchExactValuesIncludingClear() throws Exception
	{
		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setLoginUsername("account").get().getStatus());
		verify(client).setUsername("account");

		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setLoginPassword("").get().getStatus());
		verify(client).setPassword("");

		assertEquals(KLiteInteractionStatus.DISPATCHED,
			api.setLoginOtp("123456").get().getStatus());
		verify(client).setOtp("123456");
	}

	@Test
	public void loginControlsRejectNullWithoutDispatch() throws Exception
	{
		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.setLoginUsername(null).get().getStatus());
		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.setLoginPassword(null).get().getStatus());
		assertEquals(KLiteInteractionStatus.INVALID_REQUEST,
			api.setLoginOtp(null).get().getStatus());
		verify(client, never()).setUsername(null);
		verify(client, never()).setPassword(null);
		verify(client, never()).setOtp(null);
	}
}
