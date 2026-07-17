/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import com.example.StreamedFixture;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class KLiteInMemoryPluginClassLoaderTest
{
	@Test
	public void definesClassesAndResourcesDirectlyFromMemory() throws Exception
	{
		String className = StreamedFixture.class.getName();
		String classPath = className.replace('.', '/') + ".class";
		byte[] classBytes;
		try (InputStream input = StreamedFixture.class.getClassLoader().getResourceAsStream(classPath))
		{
			classBytes = input.readAllBytes();
		}
		byte[] jar = jar(classPath, classBytes, "plugin.properties", "loaded=true".getBytes());

		try (KLiteInMemoryPluginClassLoader loader = new KLiteInMemoryPluginClassLoader(
			jar, getClass().getClassLoader()))
		{
			Class<?> loaded = loader.loadClass(className);
			assertNotSame(StreamedFixture.class, loaded);
			assertEquals("streamed", loaded.getMethod("value").invoke(
				loaded.getConstructor().newInstance()));
			try (InputStream resource = loader.getResourceAsStream("plugin.properties"))
			{
				assertEquals("loaded=true", new String(resource.readAllBytes()));
			}
		}
	}

	@Test
	public void allowsDeclaredPluginClassesInsideRuneLiteNamespace() throws Exception
	{
		String className = KLiteMarketplacePlugin.class.getName();
		String classPath = className.replace('.', '/') + ".class";
		byte[] classBytes;
		try (InputStream input = KLiteMarketplacePlugin.class.getClassLoader().getResourceAsStream(classPath))
		{
			classBytes = input.readAllBytes();
		}
		byte[] jar = jar(classPath, classBytes, "marker.txt", new byte[]{1});

		try (KLiteInMemoryPluginClassLoader loader = new KLiteInMemoryPluginClassLoader(
			jar, getClass().getClassLoader(), List.of(className)))
		{
			assertNotSame(KLiteMarketplacePlugin.class, loader.loadClass(className));
		}
	}

	@Test(expected = IOException.class)
	public void rejectsProtectedNamespaceClasses() throws Exception
	{
		byte[] jar = jar("net/runelite/Injected.class", new byte[]{1, 2, 3},
			"marker.txt", new byte[]{1});
		new KLiteInMemoryPluginClassLoader(jar, getClass().getClassLoader());
	}

	private static byte[] jar(String firstName, byte[] firstBytes,
		String secondName, byte[] secondBytes) throws IOException
	{
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try (JarOutputStream jar = new JarOutputStream(output))
		{
			jar.putNextEntry(new JarEntry(firstName));
			jar.write(firstBytes);
			jar.closeEntry();
			jar.putNextEntry(new JarEntry(secondName));
			jar.write(secondBytes);
			jar.closeEntry();
		}
		return output.toByteArray();
	}
}
