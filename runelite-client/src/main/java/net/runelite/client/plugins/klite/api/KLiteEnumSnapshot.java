/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.util.List;
import lombok.Value;

/** Immutable copy of a client enum definition. */
@Value
public class KLiteEnumSnapshot
{
	int id;
	int size;
	List<Integer> keys;
	List<Integer> integerValues;
	List<Long> longValues;
	List<String> stringValues;
}
