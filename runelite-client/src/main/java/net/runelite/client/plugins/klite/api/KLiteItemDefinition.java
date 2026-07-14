/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.util.List;
import lombok.Value;

/** Immutable item definition safe to use outside the client thread. */
@Value
public class KLiteItemDefinition
{
	int id;
	String name;
	String membersName;
	int storePrice;
	int highAlchemyPrice;
	boolean members;
	boolean stackable;
	boolean tradeable;
	boolean grandExchangeTradeable;
	int linkedNoteId;
	int placeholderId;
	List<String> inventoryActions;
}
