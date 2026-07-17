package com.example.klite;

import javax.inject.Inject;
import net.runelite.api.events.GameTick;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.klite.api.KLiteClientApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PluginDescriptor(
    name = "Starter Plugin",
    description = "A standalone KLite plugin starter project.",
    tags = {"klite", "starter"},
    authors = {"Your name"},
    version = "0.1.0",
    minClientVersion = "1.0.85",
    isExternal = true,
    developerPlugin = true,
    enabledByDefault = true
)
public final class StarterPlugin extends Plugin
{
    private static final Logger log = LoggerFactory.getLogger(StarterPlugin.class);

    @Inject
    private KLiteClientApi clientApi;

    private int gameTicks;

    @Override
    protected void startUp()
    {
        gameTicks = 0;
        log.info("Starter Plugin enabled");
    }

    @Override
    protected void shutDown()
    {
        log.info("Starter Plugin disabled");
    }

    @Subscribe
    public void onGameTick(GameTick event)
    {
        gameTicks++;
        if (gameTicks % 10 != 0)
        {
            return;
        }

        clientApi.inventoryFreeSlots()
            .thenAccept(freeSlots -> log.debug("Inventory free slots: {}", freeSlots))
            .exceptionally(error ->
            {
                log.warn("Unable to read inventory state", error);
                return null;
            });
    }
}
