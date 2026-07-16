/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import javax.annotation.Nullable;
import net.runelite.client.util.ReflectUtil;

/** A bounded JAR class loader whose class and resource bytes never touch disk. */
final class KLiteInMemoryPluginClassLoader extends ClassLoader
	implements Closeable, ReflectUtil.PrivateLookupableClassLoader
{
	private static final int MAX_ENTRIES = 5_000;
	private static final int MAX_ENTRY_BYTES = 10 * 1024 * 1024;
	private static final int MAX_EXPANDED_BYTES = 40 * 1024 * 1024;
	private static final String[] PARENT_FIRST_PACKAGES =
	{
		"java.", "javax.", "jdk.", "sun.", "com.sun.",
		"net.runelite.", "com.google.", "org.slf4j.", "okhttp3.", "okio."
	};

	private final Map<String, byte[]> classes = new HashMap<>();
	private final Map<String, byte[]> resources = new HashMap<>();
	private volatile boolean closed;
	@Nullable
	private MethodHandles.Lookup lookup;

	KLiteInMemoryPluginClassLoader(byte[] jarBytes, ClassLoader parent) throws IOException
	{
		super(parent);
		readJar(jarBytes);
		ReflectUtil.installLookupHelper(this);
	}

	@Override
	protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException
	{
		synchronized (getClassLoadingLock(name))
		{
			Class<?> loaded = findLoadedClass(name);
			if (loaded == null)
			{
				if (isParentFirst(name))
				{
					loaded = getParent().loadClass(name);
				}
				else
				{
					try
					{
						loaded = findClass(name);
					}
					catch (ClassNotFoundException ex)
					{
						loaded = getParent().loadClass(name);
					}
				}
			}
			if (resolve)
			{
				resolveClass(loaded);
			}
			return loaded;
		}
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException
	{
		if (closed)
		{
			throw new ClassNotFoundException(name);
		}
		byte[] bytes = classes.get(name);
		if (bytes == null)
		{
			throw new ClassNotFoundException(name);
		}
		return defineClass(name, bytes, 0, bytes.length);
	}

	@Override
	public InputStream getResourceAsStream(String name)
	{
		byte[] bytes = resources.get(name);
		return bytes == null ? super.getResourceAsStream(name) : new ByteArrayInputStream(bytes);
	}

	@Override
	protected URL findResource(String name)
	{
		byte[] bytes = resources.get(name);
		if (bytes == null)
		{
			return null;
		}
		try
		{
			return new URL(null, "memory:" + name, new MemoryUrlHandler(bytes));
		}
		catch (java.net.MalformedURLException ex)
		{
			return null;
		}
	}

	@Override
	protected Enumeration<URL> findResources(String name)
	{
		URL resource = findResource(name);
		return resource == null ? Collections.emptyEnumeration()
			: Collections.enumeration(Collections.singleton(resource));
	}

	@Override
	public Class<?> defineClass0(String name, byte[] bytes, int offset, int length)
		throws ClassFormatError
	{
		return defineClass(name, bytes, offset, length);
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
	public void close()
	{
		closed = true;
		classes.clear();
		resources.clear();
		lookup = null;
	}

	private void readJar(byte[] jarBytes) throws IOException
	{
		int count = 0;
		int expandedBytes = 0;
		try (JarInputStream jar = new JarInputStream(new ByteArrayInputStream(jarBytes)))
		{
			JarEntry entry;
			while ((entry = jar.getNextJarEntry()) != null)
			{
				if (entry.isDirectory())
				{
					continue;
				}
				if (++count > MAX_ENTRIES)
				{
					throw new IOException("Plugin archive has too many entries");
				}
				String name = entry.getName();
				validateEntryName(name);
				byte[] bytes = readEntry(jar);
				expandedBytes += bytes.length;
				if (expandedBytes > MAX_EXPANDED_BYTES)
				{
					throw new IOException("Plugin archive expands beyond the size limit");
				}
				if (name.endsWith(".class"))
				{
					String className = name.substring(0, name.length() - 6).replace('/', '.');
					if (isParentFirst(className))
					{
						throw new IOException("Plugin archive contains a protected class: " + className);
					}
					if (classes.putIfAbsent(className, bytes) != null)
					{
						throw new IOException("Plugin archive contains a duplicate class: " + className);
					}
				}
				else if (resources.putIfAbsent(name, bytes) != null)
				{
					throw new IOException("Plugin archive contains a duplicate resource: " + name);
				}
			}
		}
		if (classes.isEmpty())
		{
			throw new IOException("Plugin archive does not contain classes");
		}
	}

	private static byte[] readEntry(InputStream input) throws IOException
	{
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		byte[] buffer = new byte[8192];
		int read;
		while ((read = input.read(buffer)) != -1)
		{
			if (output.size() + read > MAX_ENTRY_BYTES)
			{
				throw new IOException("Plugin archive entry exceeds the size limit");
			}
			output.write(buffer, 0, read);
		}
		return output.toByteArray();
	}

	private static void validateEntryName(String name) throws IOException
	{
		if (name.isEmpty() || name.startsWith("/") || name.startsWith("\\")
			|| name.contains("\\") || name.contains("../") || name.contains("/.."))
		{
			throw new IOException("Plugin archive contains an unsafe entry path");
		}
	}

	private static boolean isParentFirst(String className)
	{
		for (String prefix : PARENT_FIRST_PACKAGES)
		{
			if (className.startsWith(prefix))
			{
				return true;
			}
		}
		return false;
	}

	private static final class MemoryUrlHandler extends URLStreamHandler
	{
		private final byte[] bytes;

		private MemoryUrlHandler(byte[] bytes)
		{
			this.bytes = bytes;
		}

		@Override
		protected URLConnection openConnection(URL url)
		{
			return new URLConnection(url)
			{
				@Override
				public void connect()
				{
					connected = true;
				}

				@Override
				public InputStream getInputStream()
				{
					return new ByteArrayInputStream(bytes);
				}
			};
		}
	}
}
