/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;
import org.junit.Test;

public class DefaultKLiteClientApiSkillTotalsTest
{
	@Test
	public void skillTotalsCopyAuthoritativeClientValues() throws Exception
	{
		Client client = mock(Client.class);
		when(client.isClientThread()).thenReturn(true);
		when(client.getTotalLevel()).thenReturn(2_277);
		when(client.getOverallExperience()).thenReturn(4_600_000_000L);
		DefaultKLiteClientApi api = new DefaultKLiteClientApi(
			client, new KLiteThreadGateway(client, mock(ClientThread.class)));

		assertEquals(new KLiteSkillTotalsSnapshot(2_277, 4_600_000_000L),
			api.skillTotals().get());
	}
}
