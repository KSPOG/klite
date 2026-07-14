/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.walker.pathfinder;

import static net.runelite.api.Constants.REGION_SIZE;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.inject.Inject;
import javax.inject.Singleton;

/** Immutable collision map derived from Shortest Path 1.20.6. */
@Singleton
final class StaticCollisionMap implements TraversalMap
{
	private static final int FLAG_COUNT = 2;
	private static final int BITS_PER_PLANE = REGION_SIZE * REGION_SIZE * FLAG_COUNT;
	private static final int WORDS_PER_PLANE = BITS_PER_PLANE / Long.SIZE;
	private static final int REGION_MASK = REGION_SIZE - 1;
	private static final int[] DX = {-1, 1, 0, 0, -1, 1, -1, 1};
	private static final int[] DY = {0, 0, -1, 1, -1, -1, 1, 1};

	private final int minRegionX;
	private final int minRegionY;
	private final int width;
	private final byte[] planeCounts;
	private final int[] wordOffsets;
	private final long[] flags;

	@Inject
	StaticCollisionMap()
	{
		LoadedRegions loaded = loadRegions();
		minRegionX = loaded.minX;
		minRegionY = loaded.minY;
		width = loaded.maxX - loaded.minX + 1;
		int height = loaded.maxY - loaded.minY + 1;
		planeCounts = new byte[width * height];
		wordOffsets = new int[width * height];
		Arrays.fill(wordOffsets, -1);

		Map<Integer, long[]> wordsByIndex = new HashMap<>(loaded.regions.size());
		int totalWords = 0;
		for (Map.Entry<Integer, byte[]> entry : loaded.regions.entrySet())
		{
			int regionX = entry.getKey() & 0xFFFF;
			int regionY = entry.getKey() >>> 16 & 0xFFFF;
			int index = regionIndex(regionX, regionY);
			BitSet bits = BitSet.valueOf(entry.getValue());
			int planes = (bits.size() + BITS_PER_PLANE - 1) / BITS_PER_PLANE;
			planeCounts[index] = (byte) planes;
			wordOffsets[index] = totalWords;
			wordsByIndex.put(index, bits.toLongArray());
			totalWords += planes * WORDS_PER_PLANE;
		}

		flags = new long[totalWords];
		for (Map.Entry<Integer, long[]> entry : wordsByIndex.entrySet())
		{
			long[] words = entry.getValue();
			System.arraycopy(words, 0, flags, wordOffsets[entry.getKey()], words.length);
		}
	}

	@Override
	public boolean contains(int packedPoint)
	{
		int x = WorldPointCodec.x(packedPoint);
		int y = WorldPointCodec.y(packedPoint);
		int plane = WorldPointCodec.plane(packedPoint);
		int index = regionIndex(x / REGION_SIZE, y / REGION_SIZE);
		return index >= 0 && index < wordOffsets.length && wordOffsets[index] >= 0
			&& plane >= 0 && plane < planeCounts[index];
	}

	@Override
	public boolean canMove(int packedPoint, int direction)
	{
		if (direction < 0 || direction >= DX.length)
		{
			throw new IllegalArgumentException("Invalid direction: " + direction);
		}

		int x = WorldPointCodec.x(packedPoint);
		int y = WorldPointCodec.y(packedPoint);
		int plane = WorldPointCodec.plane(packedPoint);
		if (isBlocked(x, y, plane))
		{
			int targetX = x + DX[direction];
			int targetY = y + DY[direction];
			if (isBlocked(targetX, targetY, plane))
			{
				return false;
			}
			if (direction >= 4)
			{
				return !isBlocked(x + DX[direction], y, plane)
					&& !isBlocked(x, y + DY[direction], plane);
			}
			return true;
		}

		switch (direction)
		{
			case 0:
				return west(x, y, plane);
			case 1:
				return east(x, y, plane);
			case 2:
				return south(x, y, plane);
			case 3:
				return north(x, y, plane);
			case 4:
				return south(x, y, plane) && west(x, y - 1, plane)
					&& west(x, y, plane) && south(x - 1, y, plane);
			case 5:
				return south(x, y, plane) && east(x, y - 1, plane)
					&& east(x, y, plane) && south(x + 1, y, plane);
			case 6:
				return north(x, y, plane) && west(x, y + 1, plane)
					&& west(x, y, plane) && north(x - 1, y, plane);
			case 7:
				return north(x, y, plane) && east(x, y + 1, plane)
					&& east(x, y, plane) && north(x + 1, y, plane);
			default:
				return false;
		}
	}

	private boolean north(int x, int y, int plane)
	{
		return get(x, y, plane, 0);
	}

	private boolean south(int x, int y, int plane)
	{
		return north(x, y - 1, plane);
	}

	private boolean east(int x, int y, int plane)
	{
		return get(x, y, plane, 1);
	}

	private boolean west(int x, int y, int plane)
	{
		return east(x - 1, y, plane);
	}

	private boolean isBlocked(int x, int y, int plane)
	{
		return !north(x, y, plane) && !south(x, y, plane)
			&& !east(x, y, plane) && !west(x, y, plane);
	}

	private boolean get(int x, int y, int plane, int flag)
	{
		int index = regionIndex(x / REGION_SIZE, y / REGION_SIZE);
		if (index < 0 || index >= wordOffsets.length)
		{
			return false;
		}
		int offset = wordOffsets[index];
		if (offset < 0 || plane < 0 || plane >= planeCounts[index])
		{
			return false;
		}
		int bit = (plane * REGION_SIZE * REGION_SIZE
			+ (y & REGION_MASK) * REGION_SIZE + (x & REGION_MASK)) * FLAG_COUNT + flag;
		return (flags[offset + (bit >> 6)] >>> (bit & 63) & 1L) != 0L;
	}

	private int regionIndex(int regionX, int regionY)
	{
		return regionX - minRegionX + (regionY - minRegionY) * width;
	}

	private static LoadedRegions loadRegions()
	{
		Map<Integer, byte[]> regions = new HashMap<>();
		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int maxY = Integer.MIN_VALUE;
		InputStream resource = StaticCollisionMap.class.getResourceAsStream(
			"/net/runelite/client/plugins/klite/walker/collision-map.zip");
		try (ZipInputStream input = new ZipInputStream(Objects.requireNonNull(resource,
			"Missing KLite walker collision map")))
		{
			ZipEntry entry;
			while ((entry = input.getNextEntry()) != null)
			{
				String[] coordinates = entry.getName().split("_");
				int x = Integer.parseInt(coordinates[0]);
				int y = Integer.parseInt(coordinates[1]);
				minX = Math.min(minX, x);
				minY = Math.min(minY, y);
				maxX = Math.max(maxX, x);
				maxY = Math.max(maxY, y);
				regions.put(x & 0xFFFF | (y & 0xFFFF) << 16, readEntry(input));
			}
		}
		catch (IOException exception)
		{
			throw new UncheckedIOException(exception);
		}
		if (regions.isEmpty())
		{
			throw new IllegalStateException("KLite walker collision map is empty");
		}
		return new LoadedRegions(regions, minX, minY, maxX, maxY);
	}

	private static byte[] readEntry(InputStream input) throws IOException
	{
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		byte[] buffer = new byte[8192];
		int read;
		while ((read = input.read(buffer)) != -1)
		{
			output.write(buffer, 0, read);
		}
		return output.toByteArray();
	}

	private static final class LoadedRegions
	{
		private final Map<Integer, byte[]> regions;
		private final int minX;
		private final int minY;
		private final int maxX;
		private final int maxY;

		private LoadedRegions(Map<Integer, byte[]> regions, int minX, int minY, int maxX, int maxY)
		{
			this.regions = regions;
			this.minX = minX;
			this.minY = minY;
			this.maxX = maxX;
			this.maxY = maxY;
		}
	}
}
