/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.walker;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.PluginMessage;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginManager;

/**
 * Optional adapter for the RuneLite Plugin Hub Shortest Path plugin.
 *
 * <p>The adapter deliberately has no compile-time dependency on Shortest Path.
 * This allows KLite to start and use its internal pathfinder when the external
 * plugin is not installed, is disabled, or changes independently.</p>
 */
@Singleton
@Slf4j
final class ShortestPathBridge
{
	private static final String PLUGIN_CLASS = "shortestpath.ShortestPathPlugin";
	private static final String NAMESPACE = "shortestpath";
	private static final String PATH_MESSAGE = "path";
	private static final String CLEAR_MESSAGE = "clear";

	private final PluginManager pluginManager;
	private final EventBus eventBus;

	private Plugin requestedPlugin;
	private Set<Integer> requestedTargets = Set.of();

	@Inject
	ShortestPathBridge(PluginManager pluginManager, EventBus eventBus)
	{
		this.pluginManager = pluginManager;
		this.eventBus = eventBus;
	}

	/**
	 * Requests a route from Shortest Path. Returns false when the plugin is not
	 * installed and active, allowing the caller to immediately use its fallback.
	 */
	synchronized boolean request(WorldPoint start, WorldPoint destination, int arrivalDistance)
	{
		Plugin plugin = activePlugin();
		if (plugin == null)
		{
			resetRequest();
			return false;
		}

		Set<WorldPoint> targets = destinationArea(destination, arrivalDistance);
		Set<Integer> packedTargets = new HashSet<>(targets.size());
		for (WorldPoint target : targets)
		{
			packedTargets.add(pack(target));
		}

		Map<String, Object> data = new HashMap<>();
		data.put("start", start);
		data.put("target", targets);
		eventBus.post(new PluginMessage(NAMESPACE, PATH_MESSAGE, data));

		requestedPlugin = plugin;
		requestedTargets = packedTargets;
		return true;
	}

	/** Polls the route requested with {@link #request(WorldPoint, WorldPoint, int)}. */
	synchronized RouteSnapshot poll()
	{
		Plugin plugin = activePlugin();
		if (plugin == null || plugin != requestedPlugin)
		{
			return RouteSnapshot.unavailable("Shortest Path is not installed and enabled");
		}

		try
		{
			Object pathfinder = invoke(plugin, "getPathfinder");
			if (pathfinder == null)
			{
				return RouteSnapshot.calculating();
			}

			Object rawTargets = invoke(pathfinder, "getTargets");
			if (!(rawTargets instanceof Set<?>) || !matchesRequestedTargets((Set<?>) rawTargets))
			{
				// restartPathfinding is scheduled onto the client thread by Shortest Path,
				// so its previous Pathfinder can be visible briefly after our request.
				return RouteSnapshot.calculating();
			}

			Object rawDone = invoke(pathfinder, "isDone");
			if (!(rawDone instanceof Boolean) || !((Boolean) rawDone))
			{
				return RouteSnapshot.calculating();
			}

			Object rawPath = invoke(pathfinder, "getPath");
			if (!(rawPath instanceof Collection<?>))
			{
				return RouteSnapshot.failed("Shortest Path returned an unsupported path value");
			}

			List<WorldPoint> route = new ArrayList<>();
			for (Object step : (Collection<?>) rawPath)
			{
				Object rawPacked = invoke(step, "getPackedPosition");
				if (!(rawPacked instanceof Integer))
				{
					return RouteSnapshot.failed("Shortest Path returned an invalid path step");
				}
				route.add(unpack((Integer) rawPacked));
			}

			if (route.isEmpty())
			{
				return RouteSnapshot.failed("Shortest Path did not find a route");
			}

			// KLite currently performs ground walking only. A non-adjacent edge is a
			// teleport, transport, ladder, door transition, or another action which
			// must not be treated as a normal walk click.
			for (int index = 1; index < route.size(); index++)
			{
				WorldPoint previous = route.get(index - 1);
				WorldPoint current = route.get(index);
				if (previous.getPlane() != current.getPlane() || previous.distanceTo(current) > 1)
				{
					return RouteSnapshot.failed(
						"Shortest Path route requires a transport; using the KLite ground fallback");
				}
			}

			return RouteSnapshot.ready(route);
		}
		catch (ReflectiveOperationException | RuntimeException exception)
		{
			log.debug("Unable to read the Shortest Path route", exception);
			return RouteSnapshot.failed("Shortest Path integration failed: "
				+ exception.getClass().getSimpleName());
		}
	}

	synchronized void clear()
	{
		if (requestedPlugin != null && activePlugin() == requestedPlugin)
		{
			eventBus.post(new PluginMessage(NAMESPACE, CLEAR_MESSAGE));
		}
		resetRequest();
	}

	private Plugin activePlugin()
	{
		for (Plugin plugin : pluginManager.getPlugins())
		{
			if (PLUGIN_CLASS.equals(plugin.getClass().getName()) && pluginManager.isPluginActive(plugin))
			{
				return plugin;
			}
		}
		return null;
	}

	private boolean matchesRequestedTargets(Set<?> actualTargets)
	{
		if (requestedTargets.isEmpty() || actualTargets.isEmpty())
		{
			return false;
		}
		for (Object target : actualTargets)
		{
			if (target instanceof Integer && requestedTargets.contains(target))
			{
				return true;
			}
		}
		return false;
	}

	private void resetRequest()
	{
		requestedPlugin = null;
		requestedTargets = Set.of();
	}

	private static Set<WorldPoint> destinationArea(WorldPoint destination, int arrivalDistance)
	{
		Set<WorldPoint> targets = new HashSet<>();
		for (int dx = -arrivalDistance; dx <= arrivalDistance; dx++)
		{
			for (int dy = -arrivalDistance; dy <= arrivalDistance; dy++)
			{
				targets.add(new WorldPoint(destination.getX() + dx,
					destination.getY() + dy, destination.getPlane()));
			}
		}
		return targets;
	}

	private static Object invoke(Object target, String methodName) throws ReflectiveOperationException
	{
		Method method = target.getClass().getMethod(methodName);
		return method.invoke(target);
	}

	private static int pack(WorldPoint point)
	{
		return point.getX() & 0x7FFF
			| (point.getY() & 0x7FFF) << 15
			| (point.getPlane() & 0x3) << 30;
	}

	private static WorldPoint unpack(int packed)
	{
		return new WorldPoint(packed & 0x7FFF, packed >> 15 & 0x7FFF, packed >> 30 & 0x3);
	}

	enum RouteState
	{
		CALCULATING,
		READY,
		UNAVAILABLE,
		FAILED
	}

	@Value
	static class RouteSnapshot
	{
		RouteState state;
		List<WorldPoint> path;
		String message;

		static RouteSnapshot calculating()
		{
			return new RouteSnapshot(RouteState.CALCULATING, List.of(), null);
		}

		static RouteSnapshot ready(List<WorldPoint> path)
		{
			return new RouteSnapshot(RouteState.READY, List.copyOf(path), null);
		}

		static RouteSnapshot unavailable(String message)
		{
			return new RouteSnapshot(RouteState.UNAVAILABLE, List.of(), message);
		}

		static RouteSnapshot failed(String message)
		{
			return new RouteSnapshot(RouteState.FAILED, List.of(), message);
		}
	}
}
