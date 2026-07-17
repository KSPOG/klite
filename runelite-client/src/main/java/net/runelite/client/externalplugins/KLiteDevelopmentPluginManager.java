/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.externalplugins;

import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.RuneLite;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginInstantiationException;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.util.ReflectUtil;

/**
 * Loads developer-built plugin JARs from a local directory without requiring
 * access to the KLite client source tree or executable client JAR.
 */
@Singleton
@Slf4j
public class KLiteDevelopmentPluginManager
{
	public static final File DEVELOPMENT_PLUGINS_DIR =
		new File(RuneLite.RUNELITE_DIR, "klite-dev-plugins");
	private static final long SCAN_INTERVAL_SECONDS = 2L;

	private final PluginManager pluginManager;
	private final ScheduledExecutorService executor;
	private final Gson gson;
	private final boolean safeMode;
	private final Map<String, LoadedDevelopmentPlugin> loadedPlugins = new HashMap<>();

	private ScheduledFuture<?> scanFuture;
	private volatile boolean running;

	@Inject
	KLiteDevelopmentPluginManager(
		PluginManager pluginManager,
		ScheduledExecutorService executor,
		Gson gson,
		@Named("safeMode") boolean safeMode)
	{
		this.pluginManager = pluginManager;
		this.executor = executor;
		this.gson = gson;
		this.safeMode = safeMode;
	}

	public synchronized void start()
	{
		if (running)
		{
			return;
		}
		if (safeMode)
		{
			log.info("KLite development plugins are disabled in safe mode");
			return;
		}
		if (!DEVELOPMENT_PLUGINS_DIR.exists() && !DEVELOPMENT_PLUGINS_DIR.mkdirs())
		{
			log.warn("Unable to create KLite development plugin directory: {}",
				DEVELOPMENT_PLUGINS_DIR.getAbsolutePath());
			return;
		}

		running = true;
		scanFuture = executor.scheduleWithFixedDelay(
			this::refreshSafely, 0L, SCAN_INTERVAL_SECONDS, TimeUnit.SECONDS);
		log.info("Watching KLite development plugins in {}",
			DEVELOPMENT_PLUGINS_DIR.getAbsolutePath());
	}

	public synchronized void stop()
	{
		running = false;
		if (scanFuture != null)
		{
			scanFuture.cancel(false);
			scanFuture = null;
		}
		executor.execute(this::unloadAll);
	}

	public void reloadNow()
	{
		if (running)
		{
			executor.execute(this::refreshSafely);
		}
	}

	private void refreshSafely()
	{
		if (!running)
		{
			return;
		}
		try
		{
			refresh();
		}
		catch (Exception exception)
		{
			log.warn("Unable to refresh KLite development plugins", exception);
		}
	}

	private void refresh() throws IOException
	{
		Map<String, DevelopmentPluginCandidate> candidates = discoverCandidates();

		for (String internalName : new HashSet<>(loadedPlugins.keySet()))
		{
			LoadedDevelopmentPlugin loaded = loadedPlugins.get(internalName);
			DevelopmentPluginCandidate candidate = candidates.get(internalName);
			if (candidate == null || !candidate.fingerprint.equals(loaded.fingerprint))
			{
				unload(internalName, loaded);
			}
		}

		for (Map.Entry<String, DevelopmentPluginCandidate> entry : candidates.entrySet())
		{
			if (!loadedPlugins.containsKey(entry.getKey()))
			{
				load(entry.getValue());
			}
		}

		deleteSupersededJars(candidates);
	}

	private Map<String, DevelopmentPluginCandidate> discoverCandidates() throws IOException
	{
		File[] jars = DEVELOPMENT_PLUGINS_DIR.listFiles(
			file -> file.isFile() && file.getName().toLowerCase().endsWith(".jar"));
		if (jars == null || jars.length == 0)
		{
			return new HashMap<>();
		}

		Arrays.sort(jars, Comparator.comparingLong(File::lastModified).reversed());
		Map<String, DevelopmentPluginCandidate> result = new HashMap<>();
		for (File jar : jars)
		{
			try
			{
				PluginHubManifest.Stub stub = readStub(jar);
				String internalName = requireInternalName(stub, jar);
				if (!result.containsKey(internalName))
				{
					result.put(internalName, new DevelopmentPluginCandidate(
						internalName, jar, stub, sha256(jar)));
				}
			}
			catch (Exception exception)
			{
				log.warn("Ignoring invalid KLite development plugin JAR {}: {}",
					jar.getName(), exception.getMessage());
			}
		}
		return result;
	}

	private PluginHubManifest.Stub readStub(File jar) throws IOException
	{
		try (URLClassLoader reader = new URLClassLoader(
			new URL[]{jar.toURI().toURL()}, KLiteDevelopmentPluginManager.class.getClassLoader());
			InputStream stream = reader.getResourceAsStream("runelite_plugin.json"))
		{
			if (stream == null)
			{
				throw new IOException("runelite_plugin.json is missing");
			}
			PluginHubManifest.Stub stub = gson.fromJson(
				new InputStreamReader(stream, StandardCharsets.UTF_8), PluginHubManifest.Stub.class);
			if (stub == null || stub.getPlugins() == null || stub.getPlugins().length == 0)
			{
				throw new IOException("no plugin entry classes are declared");
			}
			return stub;
		}
	}

	private static String requireInternalName(PluginHubManifest.Stub stub, File jar) throws IOException
	{
		String internalName = stub.getInternalName();
		if (internalName == null || !internalName.matches("[a-z0-9][a-z0-9-]{2,63}"))
		{
			throw new IOException("invalid internalName in " + jar.getName());
		}
		return internalName;
	}

	private void load(DevelopmentPluginCandidate candidate)
	{
		DevelopmentPluginClassLoader classLoader = null;
		List<Plugin> plugins = null;
		try
		{
			classLoader = new DevelopmentPluginClassLoader(candidate.jar, candidate.stub, gson);
			List<Class<?>> pluginClasses = new ArrayList<>();
			for (String className : candidate.stub.getPlugins())
			{
				Class<?> pluginClass = classLoader.loadClass(className);
				if (!Plugin.class.isAssignableFrom(pluginClass))
				{
					throw new IllegalArgumentException(className + " does not extend Plugin");
				}
				pluginClasses.add(pluginClass);
			}

			plugins = pluginManager.loadPlugins(pluginClasses, null);
			pluginManager.loadDefaultPluginConfiguration(plugins);
			startPlugins(plugins);
			loadedPlugins.put(candidate.internalName,
				new LoadedDevelopmentPlugin(candidate.jar, candidate.fingerprint, classLoader, plugins));
			log.info("Loaded KLite development plugin \"{}\" from {}",
				candidate.internalName, candidate.jar.getName());
		}
		catch (Throwable throwable)
		{
			log.warn("Unable to load KLite development plugin \"{}\" from {}",
				candidate.internalName, candidate.jar.getName(), throwable);
			if (plugins != null)
			{
				stopAndRemovePlugins(plugins);
			}
			closeQuietly(classLoader);
		}
	}

	private void unload(String internalName, LoadedDevelopmentPlugin loaded)
	{
		loadedPlugins.remove(internalName);
		stopAndRemovePlugins(loaded.plugins);
		closeQuietly(loaded.classLoader);
		log.info("Unloaded KLite development plugin \"{}\"", internalName);
	}

	private void unloadAll()
	{
		for (Map.Entry<String, LoadedDevelopmentPlugin> entry :
			new ArrayList<>(loadedPlugins.entrySet()))
		{
			unload(entry.getKey(), entry.getValue());
		}
	}

	private void startPlugins(List<Plugin> plugins)
		throws InterruptedException, InvocationTargetException
	{
		runOnEventDispatchThread(() ->
		{
			for (Plugin plugin : plugins)
			{
				try
				{
					pluginManager.startPlugin(plugin);
				}
				catch (PluginInstantiationException exception)
				{
					throw new RuntimeException(exception);
				}
			}
		});
	}

	private void stopAndRemovePlugins(List<Plugin> plugins)
	{
		try
		{
			runOnEventDispatchThread(() ->
			{
				for (Plugin plugin : plugins)
				{
					try
					{
						pluginManager.stopPlugin(plugin);
					}
					catch (Exception exception)
					{
						log.warn("Unable to stop development plugin {}", plugin.getClass().getName(), exception);
					}
				}
			});
		}
		catch (InterruptedException exception)
		{
			Thread.currentThread().interrupt();
		}
		catch (InvocationTargetException exception)
		{
			log.warn("Unable to stop one or more development plugins", exception.getCause());
		}

		for (Plugin plugin : plugins)
		{
			pluginManager.remove(plugin);
		}
	}

	private void deleteSupersededJars(Map<String, DevelopmentPluginCandidate> candidates)
	{
		File[] jars = DEVELOPMENT_PLUGINS_DIR.listFiles(
			file -> file.isFile() && file.getName().toLowerCase().endsWith(".jar"));
		if (jars == null)
		{
			return;
		}

		Set<File> keep = new HashSet<>();
		for (DevelopmentPluginCandidate candidate : candidates.values())
		{
			keep.add(candidate.jar.getAbsoluteFile());
		}

		for (File jar : jars)
		{
			File absolute = jar.getAbsoluteFile();
			if (keep.contains(absolute))
			{
				continue;
			}
			try
			{
				PluginHubManifest.Stub stub = readStub(jar);
				String internalName = requireInternalName(stub, jar);
				if (candidates.containsKey(internalName) && !jar.delete())
				{
					log.debug("Unable to delete superseded development plugin JAR {}", jar.getName());
				}
			}
			catch (Exception ignored)
			{
				// Invalid JARs are left in place so the developer can inspect them.
			}
		}
	}

	private static void runOnEventDispatchThread(Runnable action)
		throws InterruptedException, InvocationTargetException
	{
		if (SwingUtilities.isEventDispatchThread())
		{
			action.run();
		}
		else
		{
			SwingUtilities.invokeAndWait(action);
		}
	}

	private static String sha256(File file) throws IOException
	{
		try
		{
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			try (InputStream input = java.nio.file.Files.newInputStream(file.toPath()))
			{
				byte[] buffer = new byte[8192];
				int read;
				while ((read = input.read(buffer)) >= 0)
				{
					if (read > 0)
					{
						digest.update(buffer, 0, read);
					}
				}
			}
			StringBuilder result = new StringBuilder(64);
			for (byte value : digest.digest())
			{
				result.append(String.format("%02x", value & 0xff));
			}
			return result.toString();
		}
		catch (NoSuchAlgorithmException exception)
		{
			throw new IllegalStateException("SHA-256 is unavailable", exception);
		}
	}

	private static void closeQuietly(URLClassLoader classLoader)
	{
		if (classLoader == null)
		{
			return;
		}
		try
		{
			classLoader.close();
		}
		catch (IOException exception)
		{
			log.debug("Unable to close development plugin class loader", exception);
		}
	}

	private static final class DevelopmentPluginCandidate
	{
		private final String internalName;
		private final File jar;
		private final PluginHubManifest.Stub stub;
		private final String fingerprint;

		private DevelopmentPluginCandidate(String internalName, File jar,
			PluginHubManifest.Stub stub, String fingerprint)
		{
			this.internalName = internalName;
			this.jar = jar;
			this.stub = stub;
			this.fingerprint = fingerprint;
		}
	}

	private static final class LoadedDevelopmentPlugin
	{
		private final File jar;
		private final String fingerprint;
		private final DevelopmentPluginClassLoader classLoader;
		private final List<Plugin> plugins;

		private LoadedDevelopmentPlugin(File jar, String fingerprint,
			DevelopmentPluginClassLoader classLoader, List<Plugin> plugins)
		{
			this.jar = jar;
			this.fingerprint = fingerprint;
			this.classLoader = classLoader;
			this.plugins = plugins;
		}
	}

	private static final class DevelopmentPluginClassLoader extends URLClassLoader
		implements ReflectUtil.PrivateLookupableClassLoader
	{
		private final PluginHubManifest.Stub stub;
		private MethodHandles.Lookup lookup;

		private DevelopmentPluginClassLoader(File jar, PluginHubManifest.Stub stub, Gson gson)
			throws IOException
		{
			super(new URL[]{jar.toURI().toURL()},
				KLiteDevelopmentPluginManager.class.getClassLoader());
			this.stub = stub;
			ReflectUtil.installLookupHelper(this);
		}

		public PluginHubManifest.Stub getStub()
		{
			return stub;
		}

		@Override
		public MethodHandles.Lookup getLookup()
		{
			return lookup;
		}

		@Override
		public void setLookup(MethodHandles.Lookup lookup)
		{
			this.lookup = lookup;
		}

		@Override
		public Class<?> defineClass0(String name, byte[] bytes, int offset, int length)
			throws ClassFormatError
		{
			return super.defineClass(name, bytes, offset, length);
		}
	}
}
