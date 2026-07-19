/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.api;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.IllegalComponentStateException;
import java.awt.Rectangle;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.Timer;
import net.runelite.api.Client;
import net.runelite.api.Point;

/**
 * Thread-safe, virtual-only canvas input owned by KLite core.
 *
 * <p>RuneLite canvas coordinates are already final in fixed and ordinary
 * resizable modes. They are scaled only when stretched mode is active, using
 * RuneLite's real and stretched dimensions, and are always validated against
 * the current live AWT {@link Canvas} before dispatch.</p>
 *
 * <p>The Windows cursor is never moved and {@code java.awt.Robot} is not used.</p>
 */
@Singleton
public final class KLiteCanvasInput
{
	private static final int MOVE_TO_PRESS_MIN_MILLIS = 30;
	private static final int MOVE_TO_PRESS_MAX_MILLIS = 75;
	private static final int PRESS_HOLD_MIN_MILLIS = 55;
	private static final int PRESS_HOLD_MAX_MILLIS = 125;
	private static final int RELEASE_TO_CLICK_MIN_MILLIS = 8;
	private static final int RELEASE_TO_CLICK_MAX_MILLIS = 24;

	private final Client client;
	private final KLiteThreadGateway threadGateway;

	@Inject
	public KLiteCanvasInput(Client client, KLiteThreadGateway threadGateway)
	{
		this.client = client;
		this.threadGateway = threadGateway;
	}

	/** Returns the current logical, stretched, and live canvas geometry. */
	public CompletableFuture<KLiteCanvasGeometrySnapshot> snapshot()
	{
		return threadGateway.submit(this::snapshotNow);
	}

	/**
	 * Maps a RuneLite logical canvas point to the current live AWT canvas.
	 * An empty result means the point cannot safely be dispatched now.
	 */
	public CompletableFuture<Optional<Point>> mapPoint(Point point)
	{
		return threadGateway.submit(() -> Optional.ofNullable(mapPointNow(point)));
	}

	/**
	 * Maps and clips RuneLite logical canvas bounds to the current live AWT
	 * canvas. An empty result means none of the bounds are currently clickable.
	 */
	public CompletableFuture<Optional<Rectangle>> mapBounds(Rectangle bounds)
	{
		return threadGateway.submit(() -> Optional.ofNullable(mapBoundsNow(bounds)));
	}

	/** Queues a virtual click at a RuneLite logical canvas point. */
	public CompletableFuture<KLiteInteractionResult> clickPoint(Point point)
	{
		return threadGateway.submit(() ->
		{
			if (point == null)
			{
				return KLiteInteractionResult.invalidRequest(
					"Canvas click point must not be null");
			}

			DispatchTarget target = resolvePointTarget(point);
			if (target == null)
			{
				return KLiteInteractionResult.targetNotFound(
					"Canvas click point is outside the live canvas");
			}

			EventQueue.invokeLater(() -> dispatchClickSequence(target));
			return KLiteInteractionResult.dispatched();
		});
	}

	/**
	 * Queues a virtual click at a randomized safe point inside RuneLite logical
	 * canvas bounds.
	 */
	public CompletableFuture<KLiteInteractionResult> clickBounds(Rectangle bounds)
	{
		return threadGateway.submit(() ->
		{
			if (!validBounds(bounds))
			{
				return KLiteInteractionResult.invalidRequest(
					"Canvas click bounds must have positive dimensions");
			}

			DispatchTarget target = resolveBoundsTarget(bounds);
			if (target == null)
			{
				return KLiteInteractionResult.targetNotFound(
					"Canvas click bounds are outside the live canvas");
			}

			EventQueue.invokeLater(() -> dispatchClickSequence(target));
			return KLiteInteractionResult.dispatched();
		});
	}

	private KLiteCanvasGeometrySnapshot snapshotNow()
	{
		Canvas canvas = client.getCanvas();
		Dimension real = client.getRealDimensions();
		Dimension stretched = client.getStretchedDimensions();
		boolean stretchEnabled = client.isStretchedEnabled();
		return new KLiteCanvasGeometrySnapshot(
			client.getCanvasWidth(),
			client.getCanvasHeight(),
			canvas == null ? -1 : canvas.getWidth(),
			canvas == null ? -1 : canvas.getHeight(),
			real == null ? -1 : real.width,
			real == null ? -1 : real.height,
			stretched == null ? -1 : stretched.width,
			stretched == null ? -1 : stretched.height,
			client.isResized(),
			stretchEnabled,
			mappingMode(client.isResized(), stretchEnabled));
	}

	@Nullable
	private Point mapPointNow(@Nullable Point point)
	{
		Canvas canvas = client.getCanvas();
		if (canvas == null)
		{
			return null;
		}

		Point mapped = mapPoint(
			point,
			client.isStretchedEnabled(),
			client.getRealDimensions(),
			client.getStretchedDimensions());
		return isInsideCanvas(mapped, canvas.getWidth(), canvas.getHeight())
			? mapped : null;
	}

	@Nullable
	private Rectangle mapBoundsNow(@Nullable Rectangle bounds)
	{
		Canvas canvas = client.getCanvas();
		if (canvas == null)
		{
			return null;
		}

		Rectangle mapped = mapBounds(
			bounds,
			client.isStretchedEnabled(),
			client.getRealDimensions(),
			client.getStretchedDimensions());
		return clipToCanvas(mapped, canvas.getWidth(), canvas.getHeight());
	}

	@Nullable
	private DispatchTarget resolvePointTarget(Point source)
	{
		Canvas canvas = client.getCanvas();
		if (canvas == null)
		{
			return null;
		}

		boolean stretched = client.isStretchedEnabled();
		Dimension real = copy(client.getRealDimensions());
		Dimension stretchedDimensions = copy(client.getStretchedDimensions());
		Point mapped = mapPoint(source, stretched, real, stretchedDimensions);
		if (!isInsideCanvas(mapped, canvas.getWidth(), canvas.getHeight()))
		{
			return null;
		}

		return new DispatchTarget(
			canvas,
			mapped,
			canvas.getWidth(),
			canvas.getHeight(),
			client.isResized(),
			stretched,
			real,
			stretchedDimensions);
	}

	@Nullable
	private DispatchTarget resolveBoundsTarget(Rectangle source)
	{
		Canvas canvas = client.getCanvas();
		if (canvas == null)
		{
			return null;
		}

		boolean stretched = client.isStretchedEnabled();
		Dimension real = copy(client.getRealDimensions());
		Dimension stretchedDimensions = copy(client.getStretchedDimensions());
		Rectangle mapped = mapBounds(source, stretched, real, stretchedDimensions);
		Rectangle clipped = clipToCanvas(mapped, canvas.getWidth(), canvas.getHeight());
		if (clipped == null)
		{
			return null;
		}

		Point point = randomSafePoint(clipped);
		if (!isInsideCanvas(point, canvas.getWidth(), canvas.getHeight()))
		{
			return null;
		}

		return new DispatchTarget(
			canvas,
			point,
			canvas.getWidth(),
			canvas.getHeight(),
			client.isResized(),
			stretched,
			real,
			stretchedDimensions);
	}

	private void dispatchClickSequence(DispatchTarget target)
	{
		if (!isCurrent(target))
		{
			return;
		}

		dispatchMouse(target.canvas, MouseEvent.MOUSE_ENTERED, 0,
			target.point, MouseEvent.NOBUTTON, 0);
		dispatchMouse(target.canvas, MouseEvent.MOUSE_MOVED, 0,
			target.point, MouseEvent.NOBUTTON, 0);

		int moveToPress = randomInclusive(
			MOVE_TO_PRESS_MIN_MILLIS, MOVE_TO_PRESS_MAX_MILLIS);
		int pressHold = randomInclusive(
			PRESS_HOLD_MIN_MILLIS, PRESS_HOLD_MAX_MILLIS);
		int releaseToClick = randomInclusive(
			RELEASE_TO_CLICK_MIN_MILLIS, RELEASE_TO_CLICK_MAX_MILLIS);

		schedule(moveToPress, () ->
		{
			if (!isCurrent(target))
			{
				return;
			}
			dispatchMouse(target.canvas, MouseEvent.MOUSE_PRESSED,
				InputEvent.BUTTON1_DOWN_MASK, target.point, MouseEvent.BUTTON1, 1);

			schedule(pressHold, () ->
			{
				if (!isCurrent(target))
				{
					return;
				}
				dispatchMouse(target.canvas, MouseEvent.MOUSE_RELEASED, 0,
					target.point, MouseEvent.BUTTON1, 1);

				schedule(releaseToClick, () ->
				{
					if (isCurrent(target))
					{
						dispatchMouse(target.canvas, MouseEvent.MOUSE_CLICKED, 0,
							target.point, MouseEvent.BUTTON1, 1);
					}
				});
			});
		});
	}

	private boolean isCurrent(DispatchTarget target)
	{
		Canvas current = client.getCanvas();
		if (current == null
			|| current != target.canvas
			|| current.getWidth() != target.liveWidth
			|| current.getHeight() != target.liveHeight
			|| client.isResized() != target.resized
			|| client.isStretchedEnabled() != target.stretched
			|| !isInsideCanvas(target.point, current.getWidth(), current.getHeight()))
		{
			return false;
		}

		return !target.stretched
			|| (sameDimensions(target.realDimensions, client.getRealDimensions())
				&& sameDimensions(target.stretchedDimensions,
					client.getStretchedDimensions()));
	}

	private static void dispatchMouse(Canvas canvas, int id, int modifiers,
		Point point, int button, int clickCount)
	{
		canvas.dispatchEvent(createMouseEvent(canvas, id,
			System.currentTimeMillis(), modifiers, point, button, clickCount));
	}

	static MouseEvent createMouseEvent(Canvas canvas, int id, long when,
		int modifiers, Point point, int button, int clickCount)
	{
		java.awt.Point screenLocation = canvasScreenLocation(canvas);
		return new MouseEvent(
			canvas,
			id,
			when,
			modifiers,
			point.getX(),
			point.getY(),
			screenLocation.x + point.getX(),
			screenLocation.y + point.getY(),
			clickCount,
			false,
			button);
	}

	private static java.awt.Point canvasScreenLocation(Canvas canvas)
	{
		try
		{
			return canvas.getLocationOnScreen();
		}
		catch (IllegalComponentStateException ignored)
		{
			return new java.awt.Point(0, 0);
		}
	}

	private static void schedule(int delayMillis, Runnable action)
	{
		Timer timer = new Timer(delayMillis, event ->
		{
			((Timer) event.getSource()).stop();
			action.run();
		});
		timer.setRepeats(false);
		timer.start();
	}

	private static Point randomSafePoint(Rectangle bounds)
	{
		int xInset = Math.max(1, bounds.width / 5);
		int yInset = Math.max(1, bounds.height / 5);
		int minimumX = bounds.x + xInset;
		int maximumX = bounds.x + bounds.width - xInset - 1;
		int minimumY = bounds.y + yInset;
		int maximumY = bounds.y + bounds.height - yInset - 1;

		if (maximumX < minimumX)
		{
			minimumX = bounds.x;
			maximumX = bounds.x + bounds.width - 1;
		}
		if (maximumY < minimumY)
		{
			minimumY = bounds.y;
			maximumY = bounds.y + bounds.height - 1;
		}

		return new Point(
			randomInclusive(minimumX, maximumX),
			randomInclusive(minimumY, maximumY));
	}

	private static int randomInclusive(int minimum, int maximum)
	{
		if (maximum <= minimum)
		{
			return minimum;
		}
		return ThreadLocalRandom.current().nextInt(minimum, maximum + 1);
	}

	@Nullable
	static Point mapPoint(@Nullable Point point, boolean stretched,
		@Nullable Dimension real, @Nullable Dimension stretchedDimensions)
	{
		if (point == null)
		{
			return null;
		}
		if (!stretched)
		{
			return new Point(point.getX(), point.getY());
		}
		if (!validDimensions(real) || !validDimensions(stretchedDimensions))
		{
			return null;
		}

		return new Point(
			scale(point.getX(), real.width, stretchedDimensions.width),
			scale(point.getY(), real.height, stretchedDimensions.height));
	}

	@Nullable
	static Rectangle mapBounds(@Nullable Rectangle bounds, boolean stretched,
		@Nullable Dimension real, @Nullable Dimension stretchedDimensions)
	{
		if (!validBounds(bounds))
		{
			return null;
		}
		if (!stretched)
		{
			return new Rectangle(bounds);
		}
		if (!validDimensions(real) || !validDimensions(stretchedDimensions))
		{
			return null;
		}

		return new Rectangle(
			scale(bounds.x, real.width, stretchedDimensions.width),
			scale(bounds.y, real.height, stretchedDimensions.height),
			Math.max(1, scale(bounds.width, real.width, stretchedDimensions.width)),
			Math.max(1, scale(bounds.height, real.height, stretchedDimensions.height)));
	}

	@Nullable
	static Rectangle clipToCanvas(@Nullable Rectangle bounds,
		int canvasWidth, int canvasHeight)
	{
		if (!validBounds(bounds) || canvasWidth <= 0 || canvasHeight <= 0)
		{
			return null;
		}
		Rectangle clipped = bounds.intersection(
			new Rectangle(0, 0, canvasWidth, canvasHeight));
		return clipped.width > 0 && clipped.height > 0 ? clipped : null;
	}

	static boolean isInsideCanvas(@Nullable Point point,
		int canvasWidth, int canvasHeight)
	{
		return point != null
			&& canvasWidth > 0
			&& canvasHeight > 0
			&& point.getX() >= 0
			&& point.getY() >= 0
			&& point.getX() < canvasWidth
			&& point.getY() < canvasHeight;
	}

	private static int scale(int value, int sourceSize, int targetSize)
	{
		return (int) Math.round((double) value * targetSize / sourceSize);
	}

	private static boolean validBounds(@Nullable Rectangle bounds)
	{
		return bounds != null && bounds.width > 0 && bounds.height > 0;
	}

	private static boolean validDimensions(@Nullable Dimension dimensions)
	{
		return dimensions != null
			&& dimensions.width > 0
			&& dimensions.height > 0;
	}

	private static boolean sameDimensions(@Nullable Dimension first,
		@Nullable Dimension second)
	{
		if (first == null || second == null)
		{
			return first == second;
		}
		return first.width == second.width && first.height == second.height;
	}

	@Nullable
	private static Dimension copy(@Nullable Dimension dimensions)
	{
		return dimensions == null ? null : new Dimension(dimensions);
	}

	private static String mappingMode(boolean resized, boolean stretched)
	{
		if (stretched)
		{
			return "stretched-scale";
		}
		return resized ? "direct-resizable" : "direct-fixed";
	}

	private static final class DispatchTarget
	{
		private final Canvas canvas;
		private final Point point;
		private final int liveWidth;
		private final int liveHeight;
		private final boolean resized;
		private final boolean stretched;
		@Nullable
		private final Dimension realDimensions;
		@Nullable
		private final Dimension stretchedDimensions;

		private DispatchTarget(Canvas canvas, Point point, int liveWidth,
			int liveHeight, boolean resized, boolean stretched,
			@Nullable Dimension realDimensions,
			@Nullable Dimension stretchedDimensions)
		{
			this.canvas = canvas;
			this.point = point;
			this.liveWidth = liveWidth;
			this.liveHeight = liveHeight;
			this.resized = resized;
			this.stretched = stretched;
			this.realDimensions = realDimensions;
			this.stretchedDimensions = stretchedDimensions;
		}
	}
}
