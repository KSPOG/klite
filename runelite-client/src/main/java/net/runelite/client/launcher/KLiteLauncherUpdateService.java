/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.launcher;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.Objects;
import net.runelite.client.RuneLite;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/** Checks and downloads the verified installer which updates both native executables. */
final class KLiteLauncherUpdateService
{
	private static final String MANIFEST_URL =
		"https://klite-marketplace.pages.dev/client/windows/latest.json";
	private static final String DOWNLOAD_URL =
		"https://klite-marketplace.pages.dev/download/windows";
	private static final long MAX_MANIFEST_BYTES = 32L * 1024L;
	private static final long MAX_INSTALLER_BYTES = 300L * 1024L * 1024L;
	private static final String VERSION_PROPERTY = "klite.launcher.version";

	private final OkHttpClient httpClient;
	private final Gson gson;
	private final HttpUrl manifestUrl;
	private final HttpUrl downloadUrl;
	private final Path updateDirectory;
	private final String currentVersion;

	KLiteLauncherUpdateService()
	{
		this(new OkHttpClient(), new Gson(), requireUrl(MANIFEST_URL),
			requireUrl(DOWNLOAD_URL), RuneLite.RUNELITE_DIR.toPath()
				.resolve("klite").resolve("launcher-updates"),
			System.getProperty(VERSION_PROPERTY));
	}

	KLiteLauncherUpdateService(OkHttpClient httpClient, Gson gson, HttpUrl manifestUrl,
		HttpUrl downloadUrl, Path updateDirectory, String currentVersion)
	{
		this.httpClient = Objects.requireNonNull(httpClient);
		this.gson = Objects.requireNonNull(gson);
		this.manifestUrl = Objects.requireNonNull(manifestUrl);
		this.downloadUrl = Objects.requireNonNull(downloadUrl);
		this.updateDirectory = Objects.requireNonNull(updateDirectory);
		this.currentVersion = currentVersion;
	}

	UpdateResult checkAndDownload() throws IOException
	{
		if (!isVersion(currentVersion))
		{
			return UpdateResult.developmentBuild();
		}

		Manifest manifest = fetchManifest();
		if (compareVersions(manifest.version, currentVersion) <= 0)
		{
			return UpdateResult.current(currentVersion);
		}

		Path installer = downloadInstaller(manifest);
		return UpdateResult.ready(manifest.version, installer);
	}

	void installAfterExit(Path installer) throws IOException
	{
		if (!Files.isRegularFile(installer))
		{
			throw new IOException("The verified KLite launcher installer is missing.");
		}
		long pid = ProcessHandle.current().pid();
		String escaped = installer.toAbsolutePath().toString().replace("'", "''");
		String command = "Wait-Process -Id " + pid
			+ "; Start-Process -FilePath '" + escaped + "'";
		new ProcessBuilder("powershell.exe", "-NoProfile", "-WindowStyle", "Hidden",
			"-Command", command).start();
	}

	private Manifest fetchManifest() throws IOException
	{
		Request request = new Request.Builder()
			.url(manifestUrl)
			.header("Accept", "application/json")
			.header("Cache-Control", "no-store")
			.get()
			.build();
		try (Response response = httpClient.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				throw new IOException("Update manifest request failed with HTTP " + response.code());
			}
			ResponseBody body = response.body();
			if (body == null || body.contentLength() > MAX_MANIFEST_BYTES)
			{
				throw new IOException("Update manifest response was empty or too large.");
			}
			String json = body.string();
			if (json.getBytes(StandardCharsets.UTF_8).length > MAX_MANIFEST_BYTES)
			{
				throw new IOException("Update manifest exceeded the maximum size.");
			}
			Manifest manifest = gson.fromJson(json, Manifest.class);
			validateManifest(manifest);
			return manifest;
		}
		catch (RuntimeException exception)
		{
			throw new IOException("Update manifest could not be parsed.", exception);
		}
	}

	private void validateManifest(Manifest manifest) throws IOException
	{
		if (manifest == null
			|| manifest.schemaVersion != 1
			|| !"windows-x64".equals(manifest.platform)
			|| !"KLiteLauncher.exe".equals(manifest.launcher)
			|| !isVersion(manifest.version)
			|| manifest.buildSha == null
			|| !manifest.buildSha.matches("[0-9a-fA-F]{40}")
			|| manifest.sha256 == null
			|| !manifest.sha256.matches("[0-9a-fA-F]{64}")
			|| manifest.size <= 0L
			|| manifest.size > MAX_INSTALLER_BYTES)
		{
			throw new IOException("Update manifest metadata is invalid.");
		}
		HttpUrl candidate = HttpUrl.parse(manifest.downloadUrl);
		if (!downloadUrl.equals(candidate))
		{
			throw new IOException("Update manifest download URL is not trusted.");
		}
	}

	private Path downloadInstaller(Manifest manifest) throws IOException
	{
		Files.createDirectories(updateDirectory);
		Path installer = updateDirectory.resolve(
			"KLiteLauncher-Setup-" + manifest.version + ".exe");
		if (Files.isRegularFile(installer)
			&& Files.size(installer) == manifest.size
			&& hash(installer).equals(manifest.sha256.toLowerCase(Locale.ROOT)))
		{
			return installer;
		}

		Path partial = installer.resolveSibling(installer.getFileName() + ".part");
		Files.deleteIfExists(partial);
		Request request = new Request.Builder()
			.url(downloadUrl)
			.header("Accept", "application/octet-stream")
			.header("Cache-Control", "no-store")
			.get()
			.build();
		try (Response response = httpClient.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				throw new IOException("Installer request failed with HTTP " + response.code());
			}
			ResponseBody body = response.body();
			if (body == null
				|| body.contentLength() >= 0L && body.contentLength() != manifest.size)
			{
				throw new IOException("Installer size does not match the update manifest.");
			}
			copyVerified(body, partial, manifest);
		}
		catch (IOException exception)
		{
			Files.deleteIfExists(partial);
			throw exception;
		}

		try
		{
			Files.move(partial, installer, StandardCopyOption.REPLACE_EXISTING,
				StandardCopyOption.ATOMIC_MOVE);
		}
		catch (AtomicMoveNotSupportedException exception)
		{
			Files.move(partial, installer, StandardCopyOption.REPLACE_EXISTING);
		}
		return installer;
	}

	private static void copyVerified(ResponseBody body, Path partial,
		Manifest manifest) throws IOException
	{
		MessageDigest digest = sha256();
		long total = 0L;
		try (InputStream input = body.byteStream();
			OutputStream output = Files.newOutputStream(partial))
		{
			byte[] buffer = new byte[64 * 1024];
			int read;
			while ((read = input.read(buffer)) >= 0)
			{
				if (read == 0)
				{
					continue;
				}
				total += read;
				if (total > manifest.size || total > MAX_INSTALLER_BYTES)
				{
					throw new IOException("Installer exceeded the expected size.");
				}
				digest.update(buffer, 0, read);
				output.write(buffer, 0, read);
			}
		}
		String actual = toHex(digest.digest());
		if (total != manifest.size
			|| !MessageDigest.isEqual(actual.getBytes(StandardCharsets.US_ASCII),
				manifest.sha256.toLowerCase(Locale.ROOT).getBytes(StandardCharsets.US_ASCII)))
		{
			throw new IOException("Installer verification failed.");
		}
	}

	private static String hash(Path file) throws IOException
	{
		MessageDigest digest = sha256();
		try (InputStream input = Files.newInputStream(file))
		{
			byte[] buffer = new byte[64 * 1024];
			int read;
			while ((read = input.read(buffer)) >= 0)
			{
				if (read > 0)
				{
					digest.update(buffer, 0, read);
				}
			}
		}
		return toHex(digest.digest());
	}

	static int compareVersions(String left, String right)
	{
		String[] leftParts = left.split("\\.");
		String[] rightParts = right.split("\\.");
		for (int index = 0; index < Math.max(leftParts.length, rightParts.length); index++)
		{
			int leftPart = index < leftParts.length ? Integer.parseInt(leftParts[index]) : 0;
			int rightPart = index < rightParts.length ? Integer.parseInt(rightParts[index]) : 0;
			if (leftPart != rightPart)
			{
				return Integer.compare(leftPart, rightPart);
			}
		}
		return 0;
	}

	private static boolean isVersion(String version)
	{
		return version != null && version.matches("\\d+\\.\\d+\\.\\d+");
	}

	private static MessageDigest sha256() throws IOException
	{
		try
		{
			return MessageDigest.getInstance("SHA-256");
		}
		catch (NoSuchAlgorithmException exception)
		{
			throw new IOException("SHA-256 is unavailable.", exception);
		}
	}

	private static String toHex(byte[] bytes)
	{
		char[] alphabet = "0123456789abcdef".toCharArray();
		char[] output = new char[bytes.length * 2];
		for (int index = 0; index < bytes.length; index++)
		{
			output[index * 2] = alphabet[(bytes[index] >>> 4) & 0xf];
			output[index * 2 + 1] = alphabet[bytes[index] & 0xf];
		}
		return new String(output);
	}

	private static HttpUrl requireUrl(String value)
	{
		HttpUrl url = HttpUrl.parse(value);
		if (url == null)
		{
			throw new IllegalStateException("Invalid KLite update URL.");
		}
		return url;
	}

	static final class UpdateResult
	{
		private final Status status;
		private final String version;
		private final Path installer;

		private UpdateResult(Status status, String version, Path installer)
		{
			this.status = status;
			this.version = version;
			this.installer = installer;
		}

		static UpdateResult developmentBuild()
		{
			return new UpdateResult(Status.DEVELOPMENT_BUILD, null, null);
		}

		static UpdateResult current(String version)
		{
			return new UpdateResult(Status.CURRENT, version, null);
		}

		static UpdateResult ready(String version, Path installer)
		{
			return new UpdateResult(Status.UPDATE_READY, version, installer);
		}

		Status getStatus()
		{
			return status;
		}

		String getVersion()
		{
			return version;
		}

		Path getInstaller()
		{
			return installer;
		}
	}

	enum Status
	{
		DEVELOPMENT_BUILD,
		CURRENT,
		UPDATE_READY
	}

	private static final class Manifest
	{
		private int schemaVersion;
		private String platform;
		private String launcher;
		private String version;
		private String buildSha;
		private String downloadUrl;
		private String sha256;
		private long size;
	}
}
