/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import javax.annotation.Nullable;
import lombok.Value;

/** Immutable view of mouse-button and widget-drag context. */
@Value
public class KLiteInputDragSnapshot
{
	int mouseButton;
	boolean draggingWidget;
	int dragTime;
	@Nullable
	KLiteWidgetSnapshot draggedWidget;
	@Nullable
	KLiteWidgetSnapshot draggedOnWidget;
}
