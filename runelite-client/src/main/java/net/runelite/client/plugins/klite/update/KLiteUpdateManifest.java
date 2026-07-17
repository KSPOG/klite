/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.update;

import lombok.Getter;

/** Immutable representation of the published Windows client update manifest. */
@Getter
final class KLiteUpdateManifest
{
	private int schemaVersion;
	private String platform;
	private String version;
	private String buildSha;
	private String downloadUrl;
	private String sha256;
	private long size;
	private String publishedAt;
}
