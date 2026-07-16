/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.walker;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import lombok.Value;

/** Immutable, account-scoped view of the last bank contents observed by KLite. */
@Value
public class WebWalkBankSnapshot
{
	boolean known;
	long accountHash;
	long updatedAtEpochMillis;
	Map<Integer, Long> itemQuantities;

	public WebWalkBankSnapshot(boolean known, long accountHash, long updatedAtEpochMillis,
		Map<Integer, Long> itemQuantities)
	{
		this.known = known;
		this.accountHash = accountHash;
		this.updatedAtEpochMillis = updatedAtEpochMillis;
		this.itemQuantities = Collections.unmodifiableMap(new HashMap<>(itemQuantities));
	}

	public long quantity(int itemId)
	{
		return itemQuantities.getOrDefault(itemId, 0L);
	}

	public boolean contains(int itemId)
	{
		return quantity(itemId) > 0;
	}

	static WebWalkBankSnapshot unknown(long accountHash)
	{
		return new WebWalkBankSnapshot(false, accountHash, 0L, Collections.emptyMap());
	}
}
