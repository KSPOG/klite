package com.kspog.klite.geflipper;

import com.google.inject.Injector;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.klite.automation.AutomationManager;
import net.runelite.client.plugins.klite.walker.WebWalker;

/**
 * Resolves services owned by the already-running KLite Core plugin.
 *
 * <p>The standalone SDK does not currently expose KLite Core as a
 * {@code PluginDependency} type. Development plugins therefore use their own
 * injector to locate PluginManager, find the active KLite Core instance, and
 * obtain the public automation services from the Core injector.</p>
 */
final class KLiteCoreRuntime
{
    private static final String PLUGIN_MANAGER_CLASS =
        "net.runelite.client.plugins.PluginManager";
    private static final String KLITE_CORE_CLASS =
        "net.runelite.client.plugins.klite.KLitePlugin";

    private final AutomationManager automationManager;
    private final WebWalker webWalker;

    private KLiteCoreRuntime(AutomationManager automationManager, WebWalker webWalker)
    {
        this.automationManager = automationManager;
        this.webWalker = webWalker;
    }

    static KLiteCoreRuntime resolve(Plugin owner)
    {
        try
        {
            Injector ownerInjector = owner.getInjector();
            ClassLoader parentLoader = owner.getClass().getClassLoader().getParent();
            Class<?> pluginManagerType = Class.forName(
                PLUGIN_MANAGER_CLASS,
                true,
                parentLoader == null ? owner.getClass().getClassLoader() : parentLoader);

            Object pluginManager = getInstance(ownerInjector, pluginManagerType);
            Method getPlugins = pluginManagerType.getMethod("getPlugins");
            Object result = getPlugins.invoke(pluginManager);

            if (!(result instanceof Collection))
            {
                throw new IllegalStateException("PluginManager returned an invalid plugin collection");
            }

            for (Object plugin : (Collection<?>) result)
            {
                if (!KLITE_CORE_CLASS.equals(plugin.getClass().getName()))
                {
                    continue;
                }

                Method getInjector = plugin.getClass().getMethod("getInjector");
                Injector coreInjector = (Injector) getInjector.invoke(plugin);

                AutomationManager automationManager =
                    coreInjector.getInstance(AutomationManager.class);
                WebWalker webWalker = coreInjector.getInstance(WebWalker.class);

                return new KLiteCoreRuntime(automationManager, webWalker);
            }

            throw new IllegalStateException(
                "KLite Core is not loaded. Enable KLite Core before enabling KLite GE Flipper.");
        }
        catch (ClassNotFoundException
            | NoSuchMethodException
            | IllegalAccessException
            | InvocationTargetException exception)
        {
            throw new IllegalStateException(
                "Unable to resolve KLite Core runtime services", exception);
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static Object getInstance(Injector injector, Class<?> type)
    {
        return injector.getInstance((Class) type);
    }

    AutomationManager getAutomationManager()
    {
        return automationManager;
    }

    WebWalker getWebWalker()
    {
        return webWalker;
    }
}
