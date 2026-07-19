package com.kspog.klite.geflipper;

import com.google.inject.Injector;
import java.awt.Rectangle;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.SwingUtilities;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.klite.automation.AutomationManager;
import net.runelite.client.plugins.klite.walker.WebWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PluginDescriptor(
    name = "KLite GE Flipper",
    description = "KLite API port of the Flipping Copilot automation helper.",
    tags = {"klite", "flip", "ge", "grand exchange", "copilot", "automation"},
    authors = {"Choken", "afss0", "KSP Plugins"},
    version = "0.3.13",
    minClientVersion = "1.0.98",
    enabledByDefault = false,
    isExternal = true
)
public final class KLiteGeFlipperPlugin extends Plugin
{
    private static final Logger log = LoggerFactory.getLogger(KLiteGeFlipperPlugin.class);
    private static final AtomicBoolean PLUGIN_LIST_REFRESH_REQUESTED =
        new AtomicBoolean();

    private Object overlayManager;

    private AutomationManager automationManager;
    private KLiteGeFlipperTask task;
    private KLiteGeFlipperOverlay overlay;
    private volatile String pluginStatus = "Starting";

    public KLiteGeFlipperPlugin()
    {
        requestDevelopmentPluginListRefresh();
    }

    @Override
    protected void startUp()
    {
        pluginStatus = "Starting";
        overlay = new KLiteGeFlipperOverlay(this);
        registerOverlay();

        KLiteCoreRuntime runtime = KLiteCoreRuntime.resolve(this);
        automationManager = runtime.getAutomationManager();

        WebWalker webWalker = runtime.getWebWalker();
        task = new KLiteGeFlipperTask(this, webWalker);

        if (!automationManager.start(task))
        {
            pluginStatus = "Automation busy";
            log.warn(
                "KLite GE Flipper is visible but its task could not start. "
                    + "Enable automation in KLite Core and stop any other active automation task.");
            task = null;
            return;
        }

        pluginStatus = "Running";
        log.info("KLite GE Flipper started");
    }

    @Override
    protected void shutDown()
    {
        pluginStatus = "Stopping";

        if (automationManager != null)
        {
            automationManager.stop();
        }

        unregisterOverlay();

        overlay = null;
        task = null;
        automationManager = null;
        pluginStatus = "Stopped";
        log.info("KLite GE Flipper stopped");
    }

    /**
     * KLite's local development loader currently adds disabled plugins to
     * PluginManager without posting ExternalPluginsChanged. Since this plugin
     * intentionally has enabledByDefault=false, no PluginChanged event is
     * emitted either and an already-open plugin list remains stale.
     *
     * Queue one delayed runtime event after construction. Reflection keeps the
     * standalone plugin on the published KLite SDK boundary.
     */
    private static void requestDevelopmentPluginListRefresh()
    {
        if (!PLUGIN_LIST_REFRESH_REQUESTED.compareAndSet(false, true))
        {
            return;
        }

        Thread refresher = new Thread(() ->
        {
            try
            {
                Thread.sleep(500L);
                SwingUtilities.invokeLater(KLiteGeFlipperPlugin::postExternalPluginsChanged);
            }
            catch (InterruptedException exception)
            {
                Thread.currentThread().interrupt();
            }
        }, "klite-ge-flipper-plugin-list-refresh");
        refresher.setDaemon(true);
        refresher.start();
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static void postExternalPluginsChanged()
    {
        try
        {
            ClassLoader loader = Plugin.class.getClassLoader();

            Class<?> runeLiteType = Class.forName(
                "net.runelite.client.RuneLite",
                true,
                loader);
            Method getInjector = runeLiteType.getMethod("getInjector");
            Object injector = getInjector.invoke(null);

            Class<?> eventBusType = Class.forName(
                "net.runelite.client.eventbus.EventBus",
                true,
                loader);
            Method getInstance = injector.getClass().getMethod(
                "getInstance",
                Class.class);
            Object eventBus = getInstance.invoke(injector, eventBusType);

            Class<?> eventType = Class.forName(
                "net.runelite.client.events.ExternalPluginsChanged",
                true,
                loader);
            Object event = eventType.getDeclaredConstructor().newInstance();

            Method postMethod = null;
            for (Method method : eventBusType.getMethods())
            {
                if ("post".equals(method.getName())
                    && method.getParameterCount() == 1
                    && method.getParameterTypes()[0].isAssignableFrom(eventType))
                {
                    postMethod = method;
                    break;
                }
            }
            if (postMethod == null)
            {
                throw new NoSuchMethodException(
                    eventBusType.getName() + ".post(Object)");
            }

            postMethod.invoke(eventBus, event);
            log.debug("Requested KLite plugin-list refresh");
        }
        catch (ReflectiveOperationException | RuntimeException exception)
        {
            log.debug(
                "Unable to request a KLite plugin-list refresh: {}",
                exception.getMessage());
        }
    }

    private void registerOverlay()
    {
        try
        {
            overlayManager = resolveOverlayManager();
            invokeOverlayManager("add", overlay);
        }
        catch (ReflectiveOperationException | RuntimeException exception)
        {
            overlayManager = null;
            log.warn(
                "Unable to register the KLite GE Flipper overlay: {}",
                exception.getMessage());
        }
    }

    private void unregisterOverlay()
    {
        if (overlayManager == null || overlay == null)
        {
            return;
        }

        try
        {
            invokeOverlayManager("remove", overlay);
        }
        catch (ReflectiveOperationException | RuntimeException exception)
        {
            log.warn(
                "Unable to unregister the KLite GE Flipper overlay: {}",
                exception.getMessage());
        }
        finally
        {
            overlayManager = null;
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private Object resolveOverlayManager() throws ReflectiveOperationException
    {
        ClassLoader loader = getClass().getClassLoader().getParent();
        if (loader == null)
        {
            loader = getClass().getClassLoader();
        }

        Class<?> managerType = Class.forName(
            "net.runelite.client.ui.overlay.OverlayManager",
            true,
            loader);
        Injector injector = getInjector();
        return injector.getInstance((Class) managerType);
    }

    private void invokeOverlayManager(String methodName, Object value)
        throws ReflectiveOperationException
    {
        if (overlayManager == null || value == null)
        {
            return;
        }

        for (Method method : overlayManager.getClass().getMethods())
        {
            if (!methodName.equals(method.getName())
                || method.getParameterCount() != 1)
            {
                continue;
            }

            Class<?> parameterType = method.getParameterTypes()[0];
            if (!parameterType.isAssignableFrom(value.getClass()))
            {
                continue;
            }

            method.invoke(overlayManager, value);
            return;
        }

        throw new NoSuchMethodException(
            overlayManager.getClass().getName() + "." + methodName + "(Overlay)");
    }

    String overlayStatus()
    {
        KLiteGeFlipperTask current = task;
        return current == null ? pluginStatus : current.overlayStatus();
    }

    long overlayRuntimeMillis()
    {
        KLiteGeFlipperTask current = task;
        return current == null ? 0L : current.overlayRuntimeMillis();
    }

    long overlayProfitGp()
    {
        KLiteGeFlipperTask current = task;
        return current == null ? 0L : current.overlayProfitGp();
    }

    long overlayProfitPerHour()
    {
        KLiteGeFlipperTask current = task;
        return current == null ? 0L : current.overlayProfitPerHour();
    }

    String overlayMostProfitableFlip()
    {
        KLiteGeFlipperTask current = task;
        return current == null ? "-" : current.overlayMostProfitableFlip();
    }

    Rectangle overlayInventoryBounds()
    {
        KLiteGeFlipperTask current = task;
        return current == null ? null : current.overlayInventoryBounds();
    }

    boolean overlayRunning()
    {
        return task != null;
    }
}
