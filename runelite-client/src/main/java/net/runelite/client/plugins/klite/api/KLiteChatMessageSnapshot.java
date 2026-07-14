/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import javax.annotation.Nullable;
import lombok.Value;
import net.runelite.api.ChatMessageType;

/** Immutable copy of a chat message visible to the client. */
@Value
public class KLiteChatMessageSnapshot
{
	int id;
	ChatMessageType type;
	@Nullable
	String name;
	@Nullable
	String sender;
	@Nullable
	String value;
	@Nullable
	String runeLiteFormatMessage;
	int timestamp;
}
