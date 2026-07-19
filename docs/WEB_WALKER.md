# KLite web walker

The KLite web walker is a stateful, non-blocking ground walker. It uses the
collision data and walking rules from Shortest Path 1.20.6, the revision
currently published by RuneLite Plugin Hub:

- Repository: <https://github.com/Skretzo/shortest-path>
- Published commit: `9953d52745f711a38c9cdd4a00bb1d0d57d1fdea`
- License: BSD 2-Clause

KLite owns the walker API, scheduler integration, path cache, traversal state,
and menu-action implementation. It does not bundle or call Microbot or TwiLite.

## World map target

With **KLite Core > Enable automation** enabled, right-click anywhere inside the
RuneScape world map and choose **Set Target**. KLite uses the same map-center,
widget-bounds, and zoom conversion as Shortest Path to resolve the selected
surface tile, then starts the integrated WebWalker toward that location.

Selecting another target while the WebWalker is active replaces the current
WebWalker destination. It does not cancel an unrelated KLite automation task.
Choose **Clear Path** on the world map to stop the active WebWalker route.

## Traversal model

The walker follows a step-based model:

1. `step(destination)` is called once per automation tick.
2. A locally loaded destination is attempted directly.
3. Otherwise, a path calculation is started on KLite's pathfinder executor.
4. Later calls reuse the pending or cached path and execute one walking action.
5. While the existing walk destination is more than four tiles away, another
   click is suppressed.
6. Moving away from the path or remaining stalled for eight seconds invalidates
   the cached path and causes recalculation.
7. Arrival, `clear()`, task cancellation, or client shutdown clears the plan.

All client reads and walk actions are marshalled through `KLiteThreadGateway`.
The global search never runs on RuneLite's client thread.

## API

Inject `WebWalker` into a KLite module:

```java
@Inject
private WebWalker webWalker;
```

Advance it manually:

```java
WebWalkResult result = context.await(
	webWalker.step(new WorldPoint(3165, 3484, 0), 1),
	Duration.ofSeconds(2));
```

Or start the supplied automation task:

```java
automationManager.start(new WebWalkerTask(
	webWalker,
	new WorldPoint(3165, 3484, 0),
	1));
```

`WebWalkState` reports `PATHFINDING`, `MOVING`, `ARRIVED`, `NO_PATH`,
`NOT_LOGGED_IN`, or `IDLE`.

## Current boundary

This version deliberately calculates ground-only paths. It does not claim to
execute Shortest Path transports such as teleports, boats, ladders, fairy
rings, doors represented as transports, or other cross-plane interactions.
When the destination cannot be reached through adjacent walkable tiles, the
walker returns `NO_PATH` instead of attempting an unsafe or unsupported action.

Instanced areas are also outside this first version because the bundled global
collision map uses template-world coordinates. Local destinations within the
loaded top-level scene can still use the direct-walk path.
