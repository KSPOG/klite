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
import net.runelite.api.GrandExchangeOffer;
import net.runelite.api.GrandExchangeOfferState;
import net.runelite.client.callback.ClientThread;
import org.junit.Test;

public class DefaultKLiteClientApiGrandExchangeTest
{
	@Test
	public void grandExchangeOffersCaptureOccupiedSlots() throws Exception
	{
		Client client = mock(Client.class);
		when(client.isClientThread()).thenReturn(true);
		GrandExchangeOffer offer = mock(GrandExchangeOffer.class);
		when(offer.getItemId()).thenReturn(4151);
		when(offer.getQuantitySold()).thenReturn(2);
		when(offer.getTotalQuantity()).thenReturn(5);
		when(offer.getPrice()).thenReturn(1_000_000);
		when(offer.getSpent()).thenReturn(2_000_000);
		when(offer.getState()).thenReturn(GrandExchangeOfferState.BUYING);
		when(client.getGrandExchangeOffers()).thenReturn(new GrandExchangeOffer[]{null, offer});
		DefaultKLiteClientApi api = new DefaultKLiteClientApi(
			client, new KLiteThreadGateway(client, mock(ClientThread.class)));

		assertEquals(new KLiteGrandExchangeOfferSnapshot(
			1, 4151, 2, 5, 1_000_000, 2_000_000, GrandExchangeOfferState.BUYING),
			api.grandExchangeOffers().get().get(0));
		assertEquals(4151, api.grandExchangeOffer(1).get().get().getItemId());
		assertFalse(api.grandExchangeOffer(2).get().isPresent());
	}
}
