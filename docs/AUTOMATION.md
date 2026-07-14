# KLite API and automation runtime

KLite automation is an opt-in runtime layered on RuneLite's plugin system. It
is disabled by default and allows one cooperative task at a time. Disabling the
global switch immediately cancels the active task.

## Threading rules

RuneLite client objects are not safe to read from arbitrary threads. Automation
tasks run on KLite's dedicated daemon executor and must access game state through
`KLiteClientApi`:

- `snapshot()` returns an immutable game-state, world, and player-location view.
- `combatSnapshot()` returns health, prayer, run, weight, special-attack, poison,
  wilderness, animation, target, and active-prayer state. Run energy uses hundredths
  of a percent; special-attack energy uses tenths of a percent.
- `activePrayers()` and `prayerActive(...)` read prayer varbits directly, avoiding
  RuneLite's deprecated prayer helper.
- `inventory()`, `equipment()`, and `bankItems()` return immutable item and slot snapshots;
  `isBankOpen()` reports whether the bank item container is visible.
- `inventoryCount(...)`, `inventoryContains(...)`, `firstInventorySlot(...)`, and
  `inventoryFreeSlots()` provide overflow-safe inventory queries.
- `skills()` returns real level, boosted level, and experience snapshots.
- `players()` and `npcs()` return detached nearby-actor snapshots.
- `groundItems()` returns detached scene-item and lifecycle snapshots.
- `sceneObjects()` returns game, wall, ground, and decorative object snapshots.
- The `nearest...` methods find exact ID or case-insensitive exact-name matches relative
  to the local player; `distanceTo(...)` and `hasLineOfSightTo(...)` expose spatial checks.
- `itemDefinition(...)`, `npcDefinition(...)`, and `objectDefinition(...)` return
  detached metadata and resolve the current NPC or object transformation when available.
- `widget(...)`, `widgetChild(...)`, and `widgetChildren(...)` return immutable UI
  snapshots while preserving RuneLite's one-based widget operation numbers.
- `selectedWidget()` reports the currently selected item or spell. `selectInventoryItem(...)`
  enters target mode, and the `useSelectedWidgetOn...` methods revalidate targets.
- `selectWidgetTarget(...)` and `selectWidgetTargetChild(...)` use the live target verb
  for spells and other targetable widgets. Run and special-attack setters avoid redundant
  actions and resolve the current generated widget action before dispatch.
- `dialogOptions()`, `chooseDialogOption(...)`, and `continueDialog()` expose standard
  dialogue interfaces while preserving their live widget child indices.
- Bank count, containment, and first-slot queries use the live bank container. Quantity
  helpers support `ONE`, `FIVE`, `TEN`, and `ALL`; deposit-inventory and deposit-equipment
  helpers resolve generated bank components and live widget actions.
- `varbit(...)`, `varp(...)`, and the server variants expose synchronized game
  variables; `varcInt(...)` and `varcString(...)` expose typed client variables.
- `interactInventoryItem(...)`, `interactWidget(...)`,
  `interactWidgetChild(...)`, `interactNpc(...)`, `interactPlayer(...)`, and
  `interactSceneObject(...)` re-resolve the target and option on the client thread.
- `interactGroundItem(...)` revalidates the item and supports the verified `Take`
  action; unsupported ground-item options return `OPTION_NOT_FOUND`.
- `menuAction(...)` dispatches an immutable, typed low-level menu request.
- `onClientThread(...)` queues an advanced operation on RuneLite's client thread.

Prefer the snapshot and high-level interaction methods. Every high-level
interaction returns a `KLiteInteractionResult` with `DISPATCHED`, `NO_ACTION_REQUIRED`,
`TARGET_NOT_FOUND`, `OPTION_NOT_FOUND`, `NO_WIDGET_SELECTED`, or
`INVALID_REQUEST`. `menuAction(...)`
is intentionally low-level; only use parameters resolved for the current client
revision. Keep `onClientThread` actions short; never sleep, wait for network
access, or execute an automation loop on the client thread.

## Writing a task

```java
public final class ExampleTask implements AutomationTask
{
	@Override
	public String name()
	{
		return "example";
	}

	@Override
	public Duration interval()
	{
		return Duration.ofMillis(600);
	}

	@Override
	public AutomationResult tick(AutomationContext context) throws Exception
	{
		KLiteClientSnapshot snapshot = context.await(
			context.client().snapshot(), Duration.ofSeconds(2));
		return snapshot.getGameState() == GameState.LOGGED_IN
			? AutomationResult.CONTINUE
			: AutomationResult.STOP;
	}
}
```

Inject `AutomationManager`, enable automation in the KLite Core configuration,
and call `manager.start(task)`. A task must use an interval of at least 100 ms.
`start` returns `false` when automation is disabled, another task is active, or
a failed task has not been acknowledged with `manager.stop()`.

## Lifecycle

1. `onStart` runs once on the automation executor.
2. `tick` runs with a fixed delay after the previous invocation completes.
3. Returning `STOP`, calling `AutomationManager.stop()`, disabling automation,
   or throwing an exception ends the task.
4. `onStop` runs once for cleanup.

Task exceptions move the manager to `FAILED` and expose a concise error through
`AutomationStatus`. Call `stop()` to acknowledge the failure and return to
`IDLE` before starting another task.

## Web walking

Inject `WebWalker` and pass it to `WebWalkerTask` to run a cached, non-blocking
ground walk through the automation manager. The task advances once per game
tick and stops on arrival.

See [WEB_WALKER.md](WEB_WALKER.md) for its API, traversal behavior, Shortest
Path revision, and current ground-only boundary.

## Safety boundary

The runtime provides scheduling, cancellation, snapshots, and thread marshalling.
Feature modules remain responsible for validating game state, nullability,
distance, UI availability, and action-specific cooldowns before every operation.
Do not store live RuneLite `Client`, `Player`, `NPC`, `Widget`, or `ItemContainer`
objects outside the client-thread callback that produced them.

Numeric/name dialogue submission and bank `X` quantities are not exposed because RuneLite
does not provide a verified public packet-resume API. Marketplace plugin download and
loading also remain outside this API layer.
