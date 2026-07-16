/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.examples.miner;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.klite.api.KLiteBankQuantity;
import net.runelite.client.plugins.klite.api.KLiteClientApi;
import net.runelite.client.plugins.klite.api.KLiteClientSnapshot;
import net.runelite.client.plugins.klite.api.KLiteInteractionResult;
import net.runelite.client.plugins.klite.api.KLiteItemDefinition;
import net.runelite.client.plugins.klite.api.KLiteItemStack;
import net.runelite.client.plugins.klite.api.KLitePlayerSnapshot;
import net.runelite.client.plugins.klite.api.KLiteSceneObjectSnapshot;
import net.runelite.client.plugins.klite.automation.AutomationContext;
import net.runelite.client.plugins.klite.automation.AutomationResult;
import net.runelite.client.plugins.klite.automation.AutomationTask;
import net.runelite.client.plugins.klite.walker.WebWalkResult;
import net.runelite.client.plugins.klite.walker.WebWalkState;
import net.runelite.client.plugins.klite.walker.WebWalker;

/** Cooperative mining and banking loop used by {@link CopperTinMinerPlugin}. */
final class CopperTinMinerTask implements AutomationTask
{
	private static final Duration INTERVAL = Duration.ofMillis(600L);
	private static final Duration API_TIMEOUT = Duration.ofSeconds(3L);
	private static final long INTERACTION_COOLDOWN_MILLIS = 1_800L;
	private static final WorldPoint MINE = new WorldPoint(3285, 3362, 0);
	private static final WorldPoint VARROCK_EAST_BANK = new WorldPoint(3253, 3420, 0);
	private static final Set<Integer> COPPER_ROCK_IDS = Set.of(10943, 11161);
	private static final Set<Integer> TIN_ROCK_IDS = Set.of(11360, 11361);

	private final WebWalker webWalker;
	private boolean banking;
	private boolean preferCopper = true;
	private long nextInteractionAt;

	CopperTinMinerTask(WebWalker webWalker)
	{
		this.webWalker = webWalker;
	}

	@Override
	public String name()
	{
		return "copper-tin-miner";
	}

	@Override
	public Duration interval()
	{
		return INTERVAL;
	}

	@Override
	public AutomationResult tick(AutomationContext context) throws Exception
	{
		KLiteClientApi client = context.client();
		KLiteClientSnapshot snapshot = context.await(client.snapshot(), API_TIMEOUT);
		WorldPoint playerLocation = snapshot.getPlayerLocation();
		if (playerLocation == null)
		{
			return AutomationResult.CONTINUE;
		}

		if (!banking && context.await(client.inventoryFreeSlots(), API_TIMEOUT) == 0)
		{
			banking = true;
			context.await(webWalker.clear(), API_TIMEOUT);
		}

		if (banking)
		{
			bank(context, client, playerLocation);
		}
		else
		{
			mine(context, client, playerLocation);
		}
		return AutomationResult.CONTINUE;
	}

	private void bank(AutomationContext context, KLiteClientApi client,
		WorldPoint playerLocation) throws Exception
	{
		if (context.await(client.isBankOpen(), API_TIMEOUT))
		{
			Optional<KLiteItemStack> deposit = firstNonPickaxe(context, client);
			if (deposit.isEmpty())
			{
				banking = false;
				context.await(webWalker.clear(), API_TIMEOUT);
				return;
			}

			if (cooldownElapsed())
			{
				context.await(client.depositBankInventoryItem(
					deposit.get().getSlot(), KLiteBankQuantity.ALL), API_TIMEOUT);
				startCooldown();
			}
			return;
		}

		if (playerLocation.distanceTo(VARROCK_EAST_BANK) > 5)
		{
			walk(context, VARROCK_EAST_BANK, 4);
			return;
		}

		if (!cooldownElapsed())
		{
			return;
		}

		Optional<KLiteSceneObjectSnapshot> bankObject = context.await(
			client.sceneObjects(), API_TIMEOUT).stream()
			.filter(object -> object.getActions().stream().anyMatch(
				action -> "Bank".equalsIgnoreCase(action)))
			.min(Comparator.comparingInt(object -> object.getLocation().distanceTo(playerLocation)));
		if (bankObject.isPresent())
		{
			KLiteSceneObjectSnapshot object = bankObject.get();
			context.await(client.interactSceneObject(
				object.getObjectId(), object.getLocation(), "Bank"), API_TIMEOUT);
			startCooldown();
		}
	}

	private Optional<KLiteItemStack> firstNonPickaxe(
		AutomationContext context, KLiteClientApi client) throws Exception
	{
		List<KLiteItemStack> inventory = context.await(client.inventory(), API_TIMEOUT);
		for (KLiteItemStack item : inventory)
		{
			Optional<KLiteItemDefinition> definition = context.await(
				client.itemDefinition(item.getItemId()), API_TIMEOUT);
			if (definition.isEmpty()
				|| !definition.get().getName().toLowerCase(Locale.ROOT).contains("pickaxe"))
			{
				return Optional.of(item);
			}
		}
		return Optional.empty();
	}

	private void mine(AutomationContext context, KLiteClientApi client,
		WorldPoint playerLocation) throws Exception
	{
		if (playerLocation.distanceTo(MINE) > 8)
		{
			walk(context, MINE, 5);
			return;
		}

		Optional<KLitePlayerSnapshot> localPlayer = context.await(
			client.players(), API_TIMEOUT).stream()
			.filter(KLitePlayerSnapshot::isLocalPlayer)
			.findFirst();
		if (localPlayer.map(KLitePlayerSnapshot::getAnimation).orElse(-1) != -1
			|| !cooldownElapsed())
		{
			return;
		}

		List<KLiteSceneObjectSnapshot> objects = context.await(
			client.sceneObjects(), API_TIMEOUT);
		Optional<KLiteSceneObjectSnapshot> rock = nearestRock(
			objects, playerLocation, preferCopper ? COPPER_ROCK_IDS : TIN_ROCK_IDS);
		if (rock.isEmpty())
		{
			rock = nearestRock(objects, playerLocation,
				preferCopper ? TIN_ROCK_IDS : COPPER_ROCK_IDS);
		}
		if (rock.isEmpty())
		{
			return;
		}

		KLiteSceneObjectSnapshot target = rock.get();
		KLiteInteractionResult result = context.await(client.interactSceneObject(
			target.getObjectId(), target.getLocation(), "Mine"), API_TIMEOUT);
		if (result.isDispatched())
		{
			preferCopper = !preferCopper;
			startCooldown();
		}
	}

	private Optional<KLiteSceneObjectSnapshot> nearestRock(
		List<KLiteSceneObjectSnapshot> objects, WorldPoint playerLocation, Set<Integer> ids)
	{
		return objects.stream()
			.filter(object -> ids.contains(object.getObjectId()))
			.filter(object -> object.getActions().stream().anyMatch(
				action -> "Mine".equalsIgnoreCase(action)))
			.min(Comparator.comparingInt(object -> object.getLocation().distanceTo(playerLocation)));
	}

	private void walk(AutomationContext context, WorldPoint destination,
		int arrivalDistance) throws Exception
	{
		WebWalkResult result = context.await(
			webWalker.step(destination, arrivalDistance), API_TIMEOUT);
		if (result.getState() == WebWalkState.NO_PATH)
		{
			throw new IllegalStateException(result.getMessage() == null
				? "No web-walking path is available" : result.getMessage());
		}
	}

	private boolean cooldownElapsed()
	{
		return System.currentTimeMillis() >= nextInteractionAt;
	}

	private void startCooldown()
	{
		nextInteractionAt = System.currentTimeMillis() + INTERACTION_COOLDOWN_MILLIS;
	}

	@Override
	public void onStop(AutomationContext context)
	{
		webWalker.clear();
	}
}
