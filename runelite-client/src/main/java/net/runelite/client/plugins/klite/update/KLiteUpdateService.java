/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.update;

import com.google.gson.Gson;
import java.awt.Component;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import net.runelite.api.Client;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.ClientShutdown;
import net.runelite.client.plugins.klite.debug.KLiteClientLogBuffer;
import net.runelite.client.util.OSType;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/** Checks, downloads, verifies, and installs KLite Windows client updates. */
@Singleton
public final class KLiteUpdateService
{
	private static final String LOG_SOURCE = "KLiteUpdater";
	private static final String MANIFEST_URL =
		"https://klite-marketplace.pages.dev/client/windows/latest.json";
	private static final String DOWNLOAD_URL =
		"https://klite-marketplace.pages.dev/download/windows";
	private static final long MAX_MANIFEST_BYTES = 32L * 1024L;
	private static final long MAX_INSTALLER_BYTES = 300L * 1024L * 1024L;
	private static final Gson GSON = new Gson();

	private final OkHttpClient httpClient;
	private final KLiteClientLogBuffer diagnostics;
	private final EventBus eventBus;
	private final Client client;
	private final AtomicReference<Call> activeCall = new AtomicReference<>();
	private final AtomicBoolean installing = new AtomicBoolean();

	@Inject
	KLiteUpdateService(OkHttpClient httpClient, KLiteClientLogBuffer diagnostics,
		EventBus eventBus, Client client)
	{
		this.httpClient = httpClient;
		this.diagnostics = diagnostics;
		this.eventBus = eventBus;
		this.client = client;
	}

	/** Checks the published manifest and optionally reports an up-to-date result. */
	public void checkForUpdates(Component parent, boolean interactive)
	{
		if (OSType.getOSType() != OSType.Windows)
		{
			if (interactive)
			{
				showMessage(parent, "KLite client updates are currently available for Windows only.",
					JOptionPane.INFORMATION_MESSAGE);
			}
			return;
		}
		if (installing.get())
		{
			if (interactive)
			{
				showMessage(parent, "A KLite update is already being installed.",
					JOptionPane.INFORMATION_MESSAGE);
			}
			return;
		}

		Request request = new Request.Builder()
			.url(MANIFEST_URL)
			.get()
			.header("Accept", "application/json")
			.header("Cache-Control", "no-store")
			.build();
		Call call = httpClient.newCall(request);
		if (!activeCall.compareAndSet(null, call))
		{
			if (interactive)
			{
				showMessage(parent, "KLite is already checking for an update.",
					JOptionPane.INFORMATION_MESSAGE);
			}
			return;
		}

		diagnostics.info(LOG_SOURCE, "Checking for a Windows client update. Current build="
			+ currentBuild() + '.');
		call.enqueue(new Callback()
		{
			@Override
			public void onFailure(Call failedCall, IOException exception)
			{
				activeCall.compareAndSet(failedCall, null);
				diagnostics.error(LOG_SOURCE, "Update manifest request failed", exception);
				if (interactive)
				{
					showMessage(parent, "KLite could not check for updates. See KLite Logs for details.",
						JOptionPane.ERROR_MESSAGE);
				}
			}

			@Override
			public void onResponse(Call completedCall, Response response)
			{
				activeCall.compareAndSet(completedCall, null);
				try (Response closeable = response)
				{
					KLiteUpdateManifest manifest = readManifest(closeable);
					handleManifest(parent, manifest, interactive);
				}
				catch (IOException | RuntimeException exception)
				{
					diagnostics.error(LOG_SOURCE, "Update manifest validation failed", exception);
					if (interactive)
					{
						showMessage(parent,
							"KLite received an invalid update response. See KLite Logs for details.",
							JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
	}

	public void cancel()
	{
		Call call = activeCall.getAndSet(null);
		if (call != null)
		{
			call.cancel();
		}
	}

	private void handleManifest(Component parent, KLiteUpdateManifest manifest, boolean interactive)
	{
		String current = currentBuild();
		if (!isUpdateAvailable(manifest))
		{
			diagnostics.info(LOG_SOURCE, "KLite is current at build " + current + '.');
			if (interactive)
			{
				showMessage(parent, "KLite is up to date.\n\nBuild: " + current,
					JOptionPane.INFORMATION_MESSAGE);
			}
			return;
		}

		diagnostics.info(LOG_SOURCE, "Update available: current=" + current
			+ ", latest=" + shortBuild(manifest.getBuildSha())
			+ ", version=" + manifest.getVersion() + '.');
		SwingUtilities.invokeLater(() ->
		{
			int choice = JOptionPane.showConfirmDialog(parent,
				"A KLite client update is available.\n\n"
					+ "Current build: " + current + "\n"
					+ "Latest build: " + shortBuild(manifest.getBuildSha()) + "\n"
					+ "Version: " + manifest.getVersion() + "\n\n"
					+ "Download, verify, and install it now?",
				"KLite Update",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
			if (choice == JOptionPane.YES_OPTION)
			{
				downloadAndInstall(parent, manifest);
			}
		});
	}

	private void downloadAndInstall(Component parent, KLiteUpdateManifest manifest)
	{
		if (!installing.compareAndSet(false, true))
		{
			return;
		}
		Request request = new Request.Builder()
			.url(manifest.getDownloadUrl())
			.get()
			.header("Accept", "application/octet-stream")
			.header("Cache-Control", "no-store")
			.build();
		Call call = httpClient.newCall(request);
		activeCall.set(call);
		diagnostics.info(LOG_SOURCE, "Downloading verified installer for build "
			+ shortBuild(manifest.getBuildSha()) + '.');
		call.enqueue(new Callback()
		{
			@Override
			public void onFailure(Call failedCall, IOException exception)
			{
				activeCall.compareAndSet(failedCall, null);
				installing.set(false);
				diagnostics.error(LOG_SOURCE, "Installer download failed", exception);
				showMessage(parent, "The KLite update download failed. See KLite Logs for details.",
					JOptionPane.ERROR_MESSAGE);
			}

			@Override
			public void onResponse(Call completedCall, Response response)
			{
				activeCall.compareAndSet(completedCall, null);
				try (Response closeable = response)
				{
					Path installer = downloadVerifiedInstaller(closeable, manifest);
					scheduleInstaller(installer);
					diagnostics.info(LOG_SOURCE, "Installer verified. KLite will shut down before installation.");
					shutdownClient();
				}
				catch (IOException | RuntimeException exception)
				{
					installing.set(false);
					diagnostics.error(LOG_SOURCE, "Installer validation or launch failed", exception);
					showMessage(parent,
						"The downloaded KLite installer could not be verified or launched. See KLite Logs for details.",
						JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	private void shutdownClient()
	{
		ClientShutdown shutdown = new ClientShutdown();
		eventBus.post(shutdown);
		new Thread(() ->
		{
			shutdown.waitForAllConsumers(Duration.ofSeconds(10));
			client.stopNow();
			try
			{
				Thread.sleep(1_000L);
			}
			catch (InterruptedException ignored)
			{
				Thread.currentThread().interrupt();
			}
			System.exit(0);
		}, "KLite Update Shutdown").start();
	}

	private static KLiteUpdateManifest readManifest(Response response) throws IOException
	{
		if (!response.isSuccessful())
		{
			throw new IOException("Update manifest request failed with HTTP " + response.code());
		}
		ResponseBody body = response.body();
		if (body == null)
		{
			throw new IOException("Update manifest response was empty");
		}
		long length = body.contentLength();
		if (length > MAX_MANIFEST_BYTES)
		{
			throw new IOException("Update manifest exceeded the maximum size");
		}
		String json = body.string();
		if (json.getBytes(java.nio.charset.StandardCharsets.UTF_8).length > MAX_MANIFEST_BYTES)
		{
			throw new IOException("Update manifest exceeded the maximum size");
		}
		KLiteUpdateManifest manifest = GSON.fromJson(json, KLiteUpdateManifest.class);
		validateManifest(manifest);
		return manifest;
	}

	private static void validateManifest(KLiteUpdateManifest manifest) throws IOException
	{
		if (manifest == null || manifest.getSchemaVersion() != 1)
		{
			throw new IOException("Unsupported update manifest schema");
		}
		if (!"windows-x64".equals(manifest.getPlatform()))
		{
			throw new IOException("Update manifest platform is invalid");
		}
		if (isBlank(manifest.getVersion())
			|| manifest.getBuildSha() == null
			|| !manifest.getBuildSha().matches("[0-9a-fA-F]{40}")
			|| manifest.getSha256() == null
			|| !manifest.getSha256().matches("[0-9a-fA-F]{64}")
			|| manifest.getSize() <= 0L
			|| manifest.getSize() > MAX_INSTALLER_BYTES)
		{
			throw new IOException("Update manifest metadata is invalid");
		}
		HttpUrl downloadUrl = HttpUrl.parse(manifest.getDownloadUrl());
		HttpUrl expectedUrl = HttpUrl.parse(DOWNLOAD_URL);
		if (downloadUrl == null || expectedUrl == null || !expectedUrl.equals(downloadUrl))
		{
			throw new IOException("Update manifest download URL is not trusted");
		}
	}

	private static Path downloadVerifiedInstaller(Response response,
		KLiteUpdateManifest manifest) throws IOException
	{
		if (!response.isSuccessful())
		{
			throw new IOException("Installer request failed with HTTP " + response.code());
		}
		ResponseBody body = response.body();
		if (body == null)
		{
			throw new IOException("Installer response was empty");
		}
		if (body.contentLength() >= 0L && body.contentLength() != manifest.getSize())
		{
			throw new IOException("Installer size does not match the update manifest");
		}

		Path directory = Path.of(System.getProperty("java.io.tmpdir"), "klite-updates");
		Files.createDirectories(directory);
		String build = shortBuild(manifest.getBuildSha());
		Path partial = directory.resolve("KLite-Setup-" + build + ".exe.part");
		Path installer = directory.resolve("KLite-Setup-" + build + ".exe");
		MessageDigest digest = sha256();
		long total = 0L;
		try (InputStream input = body.byteStream(); OutputStream output = Files.newOutputStream(partial))
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
				if (total > manifest.getSize() || total > MAX_INSTALLER_BYTES)
				{
					throw new IOException("Installer exceeded the expected size");
				}
				digest.update(buffer, 0, read);
				output.write(buffer, 0, read);
			}
		}
		catch (IOException exception)
		{
			Files.deleteIfExists(partial);
			throw exception;
		}

		String actualHash = toHex(digest.digest());
		if (total != manifest.getSize()
			|| !MessageDigest.isEqual(
				actualHash.getBytes(java.nio.charset.StandardCharsets.US_ASCII),
				manifest.getSha256().toLowerCase(Locale.ROOT)
					.getBytes(java.nio.charset.StandardCharsets.US_ASCII)))
		{
			Files.deleteIfExists(partial);
			throw new IOException("Installer verification failed");
		}
		try
		{
			Files.move(partial, installer, StandardCopyOption.REPLACE_EXISTING,
				StandardCopyOption.ATOMIC_MOVE);
		}
		catch (java.nio.file.AtomicMoveNotSupportedException ignored)
		{
			Files.move(partial, installer, StandardCopyOption.REPLACE_EXISTING);
		}
		return installer;
	}

	private static void scheduleInstaller(Path installer) throws IOException
	{
		long pid = ProcessHandle.current().pid();
		String escaped = installer.toAbsolutePath().toString().replace("'", "''");
		String command = "Wait-Process -Id " + pid
			+ "; Start-Process -FilePath '" + escaped + "'";
		new ProcessBuilder("powershell.exe", "-NoProfile", "-WindowStyle", "Hidden",
			"-Command", command).start();
	}

	private static boolean isUpdateAvailable(KLiteUpdateManifest manifest)
	{
		String current = RuneLiteProperties.getCommit();
		return isBlank(current) || !manifest.getBuildSha().startsWith(current.trim());
	}

	private static String currentBuild()
	{
		String commit = RuneLiteProperties.getCommit();
		String build = isBlank(commit) ? "unknown" : commit.trim();
		return build + (RuneLiteProperties.isDirty() ? "-dirty" : "");
	}

	private static String shortBuild(String build)
	{
		return build == null ? "unknown" : build.substring(0, Math.min(7, build.length()));
	}

	private static MessageDigest sha256() throws IOException
	{
		try
		{
			return MessageDigest.getInstance("SHA-256");
		}
		catch (NoSuchAlgorithmException exception)
		{
			throw new IOException("SHA-256 is unavailable", exception);
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

	private static boolean isBlank(String value)
	{
		return value == null || value.trim().isEmpty();
	}

	private static void showMessage(Component parent, String message, int type)
	{
		SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(parent, message,
			"KLite Update", type));
	}
}
