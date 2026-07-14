/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import lombok.Value;

/** Immutable result returned after resolving a high-level interaction. */
@Value
public class KLiteInteractionResult
{
	KLiteInteractionStatus status;
	String message;

	public boolean isDispatched()
	{
		return status == KLiteInteractionStatus.DISPATCHED;
	}

	static KLiteInteractionResult dispatched()
	{
		return new KLiteInteractionResult(KLiteInteractionStatus.DISPATCHED, "Action dispatched");
	}

	static KLiteInteractionResult targetNotFound(String message)
	{
		return new KLiteInteractionResult(KLiteInteractionStatus.TARGET_NOT_FOUND, message);
	}

	static KLiteInteractionResult optionNotFound(String message)
	{
		return new KLiteInteractionResult(KLiteInteractionStatus.OPTION_NOT_FOUND, message);
	}

	static KLiteInteractionResult noWidgetSelected()
	{
		return new KLiteInteractionResult(
			KLiteInteractionStatus.NO_WIDGET_SELECTED, "No item or spell is selected");
	}

	static KLiteInteractionResult invalidRequest(String message)
	{
		return new KLiteInteractionResult(KLiteInteractionStatus.INVALID_REQUEST, message);
	}
}
