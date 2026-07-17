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
import javax.annotation.Nullable;
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
import net.runelite.client.plugins.klite.debug.KLiteClientLogBuffer;
import net.runelite.client.plugins.klite.walker.WebWalkResult;
import net.runelite.client.plugins.klite.walker.WebWalkState;
import net.runelite.client.plugins.klite.walker.WebWalker;

/** Cooperative mining and banking loop used by {@link CopperTinMinerPlugin}. */
final class CopperTinMinerTask implements AutomationTask
{
	private static final String LOG_SOURCE = "CopperTinMiner";
	private static final Duration INTERVAL = Duration.ofMillis(600L);
	private static final Duration API_TIMEOUT = Duration.ofSeconds(3L);
	private static final long INTERACTION_COOLDOWN_MILLIS = 1_800L;
	private static final int INVENTORY_CAPACITY = 28;
	private static final WorldPoint MINE = new WorldPoint(3285, 3362, 0);
	private static final WorldPoint VARROCK_EAST_BANK = new WorldPoint(3253, 3420, 0);
	private static final Set<Integer> COPPER_ROCK_IDS = Set.of(10943, 11161);
	private static final Set<Integer> TIN_ROCK_IDS = Set.of(11360, 11361);

	private final WebWalker webWalker;
	private final KLiteClientLogBuffer diagnostics;
	private volatile boolean banking;
	private volatile boolean preferCopper = true;
	private volatile String activity = "Starting";
	@Nullable
	private volatile WorldPoint target;
	private long nextInteractionAt;
	private String lastWalkSummary = "";

	CopperTinMinerTask(WebWalker webWalker, KLiteClientLogBuffer diagnostics)
	{
		this.webWalker = webWalker;
		this.diagnostics = diagnostics;
		diagnostics.info(LOG_SOURCE, "Automation task created. Mine=" + formatPoint(MINE)
			+ ", bank=" + formatPoint(VARROCK_EAST_BANK) + '.');
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
	public void onStart(AutomationContext context)
	{
		diagnostics.info(LOG_SOURCE,
			"Automation started. Banking is permitted only when 28 occupied inventory slots are present.");
	}

	@Override
	public AutomationResult tick(AutomationContext context) throws Exception
	{
		try
		{
			KLiteClientApi client = context.client();
			KLiteClientSnapshot snapshot = context.await(client.snapshot(), API_TIMEOUT);
			WorldPoint playerLocation = snapshot.getPlayerLocation();
			if (playerLocation == null)
			{
				setActivity("Waiting for player location");
				return AutomationResult.CONTINUE;
			}

			List<KLiteItemStack> inventory = context.await(client.inventory(), API_TIMEOUT);
			boolean inventoryFull = inventory.size() >= INVENTORY_CAPACITY;
			Optional<KLiteItemStack> depositable = firstNonPickaxe(context, client, inventory);

			if (!banking && inventoryFull && depositable.isPresent())
			{
				banking = true;
				setActivity("Inventory full; switching to banking");
				diagnostics.info(LOG_SOURCE,
					"Inventory contains 28 occupied slots and at least one non-pickaxe item. Starting a banking trip.");
				context.await(webWalker.clear(), API_TIMEOUT);
			}

			if (banking)
			{
				boolean bankOpen = context.await(client.isBankOpen(), API_TIMEOUT);

				// A bank trip may only continue while travelling with the same full inventory,
				// or while the bank interface is open and the triggered deposit cycle is finishing.
				if (!bankOpen && (!inventoryFull || depositable.isEmpty()))
				{
					banking = false;
					target = MINE;
					setActivity("Banking cancelled; returning to mine");
					diagnostics.info(LOG_SOURCE,
						"Banking cancelled before opening the bank because the inventory is no longer full "
							+ "or contains no non-pickaxe item.");
					context.await(webWalker.clear(), API_TIMEOUT);
					mine(context, client, playerLocation);
				}
				else
				{
					bank(context, client, playerLocation, bankOpen, depositable);
				}
			}
			else
			{
				mine(context, client, playerLocation);
			}
			return AutomationResult.CONTINUE;
		}
		catch (Exception exception)
		{
			if (context.isCancellationRequested())
			{
				diagnostics.debug(LOG_SOURCE, "Automation tick cancelled during plugin shutdown.");
				return AutomationResult.STOP;
			}
			setActivity("Failed: " + exception.getClass().getSimpleName());
			diagnostics.error(LOG_SOURCE, "Automation tick failed", exception);
			throw exception;
		}
	}

	private void bank(AutomationContext context, KLiteClientApi client,
		WorldPoint playerLocation, boolean bankOpen,
		Optional<KLiteItemStack> depositable) throws Exception
	{
		if (bankOpen)
		{
			target = null;
			if (depositable.isEmpty())
			{
				banking = false;
				setActivity("Banking complete; returning to mine");
				diagnostics.info(LOG_SOURCE,
					"No non-pickaxe items remain. Banking is complete and the miner is returning to the mine.");
				context.await(webWalker.clear(), API_TIMEOUT);
				return;
			}

			setActivity("Depositing ores");
			if (cooldownElapsed())
			{
				KLiteItemStack item = depositable.get();
				diagnostics.debug(LOG_SOURCE, "Depositing inventory slot " + item.getSlot()
					+ " (itemId=" + item.getItemId() + ") with quantity ALL.");
				KLiteInteractionResult result = context.await(client.depositBankInventoryItem(
					item.getSlot(), KLiteBankQuantity.ALL), API_TIMEOUT);
				diagnostics.info(LOG_SOURCE, "Deposit result: status=" + result.getStatus()
					+ ", message=" + result.getMessage() + '.');
				startCooldown();
			}
			return;
		}

		if (playerLocation.distanceTo(VARROCK_EAST_BANK) > 5)
		{
			target = VARROCK_EAST_BANK;
			setActivity("Walking to Varrock East bank");
			walk(context, VARROCK_EAST_BANK, 4);
			return;
		}

		target = VARROCK_EAST_BANK;
		if (!cooldownElapsed())
		{
			setActivity("Waiting to open bank");
			return;
		}

		setActivity("Finding bank object");
		Optional<KLiteSceneObjectSnapshot> bankObject = context.await(
			client.sceneObjects(), API_TIMEOUT).stream()
			.filter(object -> object.getActions().stream().anyMatch(
				action -> "Bank".equalsIgnoreCase(action)))
			.min(Comparator.comparingInt(object -> object.getLocation().distanceTo(playerLocation)));
		if (bankObject.isPresent())
		{
			KLiteSceneObjectSnapshot object = bankObject.get();
			setActivity("Opening bank");
			diagnostics.info(LOG_SOURCE, "Interacting with bank object " + object.getObjectId()
				+ " at " + formatPoint(object.getLocation()) + '.');
			KLiteInteractionResult result = context.await(client.interactSceneObject(
				object.getObjectId(), object.getLocation(), "Bank"), API_TIMEOUT);
			diagnostics.info(LOG_SOURCE, "Bank interaction result: status=" + result.getStatus()
				+ ", message=" + result.getMessage() + '.');
			startCooldown();
		}
		else
		{
			setActivity("Bank object not visible");
		}
	}

	private Optional<KLiteItemStack> firstNonPickaxe(
		AutomationContext context, KLiteClientApi client,
		List<KLiteItemStack> inventory) throws Exception
	{
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
			target = MINE;
			setActivity("Walking to Varrock East mine");
			walk(context, MINE, 5);
			return;
		}

		target = MINE;
		Optional<KLitePlayerSnapshot> localPlayer = context.await(
			client.players(), API_TIMEOUT).stream()
			.filter(KLitePlayerSnapshot::isLocalPlayer)
			.findFirst();
		if (localPlayer.map(KLitePlayerSnapshot::getAnimation).orElse(-1) != -1)
		{
			setActivity("Mining");
			return;
		}
		if (!cooldownElapsed())
		{
			setActivity("Waiting for mining interaction");
			return;
		}

		setActivity("Finding " + getPreferredOre().toLowerCase(Locale.ROOT) + " rock");
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
			setActivity("Waiting for a copper or tin rock");
			return;
		}

		KLiteSceneObjectSnapshot selected = rock.get();
		String ore = COPPER_ROCK_IDS.contains(selected.getObjectId()) ? "Copper" : "Tin";
		setActivity("Mining " + ore.toLowerCase(Locale.ROOT));
		diagnostics.info(LOG_SOURCE, "Interacting with " + ore + " rock "
			+ selected.getObjectId() + " at " + formatPoint(selected.getLocation()) + '.');
		KLiteInteractionResult result = context.await(client.interactSceneObject(
			selected.getObjectId(), selected.getLocation(), "Mine"), API_TIMEOUT);
		if (result.isDispatched())
		{
			preferCopper = !preferCopper;
			startCooldown();
		}
		else
		{
			diagnostics.warn(LOG_SOURCE, "The Mine interaction was not dispatched for object "
				+ selected.getObjectId() + ": " + result.getStatus() + " - " + result.getMessage());
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
		String summary = result.getState() + "|" + result.getPathLength() + '|'
			+ formatPoint(result.getClickTarget()) + '|' + String.valueOf(result.getMessage());
		if (!summary.equals(lastWalkSummary))
		{
			lastWalkSummary = summary;
			diagnostics.info(LOG_SOURCE, "Web walker returned state=" + result.getState()
				+ ", destination=" + formatPoint(destination)
				+ ", arrivalDistance=" + arrivalDistance
				+ ", pathLength=" + result.getPathLength()
				+ ", nextTile=" + formatPoint(result.getClickTarget())
				+ (result.getMessage() == null ? "" : ", message=" + result.getMessage()));
		}
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

	private void setActivity(String nextActivity)
	{
		if (!nextActivity.equals(activity))
		{
			activity = nextActivity;
			diagnostics.debug(LOG_SOURCE, "Activity: " + nextActivity);
		}
	}

	String getActivity()
	{
		return activity;
	}

	boolean isBanking()
	{
		return banking;
	}

	String getPreferredOre()
	{
		return preferCopper ? "Copper" : "Tin";
	}

	@Nullable
	WorldPoint getTarget()
	{
		return target;
	}

	@Override
	public void onStop(AutomationContext context)
	{
		setActivity("Stopped");
		diagnostics.info(LOG_SOURCE, "Automation task stopped and the web-walker route was cleared.");
		webWalker.clear();
	}

	private static String formatPoint(@Nullable WorldPoint point)
	{
		return point == null ? "none"
			: point.getX() + "," + point.getY() + "," + point.getPlane();
	}
}
