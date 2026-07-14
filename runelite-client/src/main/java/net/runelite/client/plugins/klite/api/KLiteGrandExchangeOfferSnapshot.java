/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import lombok.Value;
import net.runelite.api.GrandExchangeOfferState;

/** Immutable copy of one Grand Exchange offer slot. */
@Value
public class KLiteGrandExchangeOfferSnapshot
{
	int slot;
	int itemId;
	int quantitySold;
	int totalQuantity;
	int price;
	int spent;
	GrandExchangeOfferState state;
}
