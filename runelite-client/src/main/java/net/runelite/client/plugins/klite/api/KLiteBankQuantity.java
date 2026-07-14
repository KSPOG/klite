/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/** Bank quantities that do not require a follow-up numeric input dialog. */
@Getter
@RequiredArgsConstructor
public enum KLiteBankQuantity
{
	ONE("Withdraw-1", "Deposit-1"),
	FIVE("Withdraw-5", "Deposit-5"),
	TEN("Withdraw-10", "Deposit-10"),
	ALL("Withdraw-All", "Deposit-All");

	private final String withdrawOption;
	private final String depositOption;
}
