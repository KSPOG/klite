/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite;

import java.awt.Frame;
import java.awt.Taskbar;
import java.awt.TrayIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.swing.SwingUtilities;
import net.runelite.client.KLiteDisguiseState;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.ContainableFrame;
import net.runelite.client.util.ImageUtil;

/**
 * Applies the selected KLite/RuneLite branding to the live desktop client.
 */
@Singleton
public class KLiteDisguiseService
{
	static final String RUNELITE_TITLE = "RuneLite";

	private static final BufferedImage RUNELITE_ICON_128 =
		ImageUtil.loadImageResource(ClientUI.class, "runelite_128.png");
	private static final BufferedImage RUNELITE_ICON_16 =
		ImageUtil.loadImageResource(ClientUI.class, "runelite_16.png");

	private final ClientUI clientUI;
	private final String kliteTitle;
	private final boolean safeMode;
	private final PropertyChangeListener titleListener = this::onTitleChanged;
	private final WindowAdapter windowListener = new WindowAdapter()
	{
		@Override
		public void windowOpened(WindowEvent event)
		{
			refresh();
		}
	};

	private volatile boolean enabled;
	private ContainableFrame frame;
	private boolean applyingTitle;

	@Inject
	KLiteDisguiseService(
		ClientUI clientUI,
		@Named("runelite.title") String kliteTitle,
		@Named("safeMode") boolean safeMode)
	{
		this.clientUI = clientUI;
		this.kliteTitle = kliteTitle;
		this.safeMode = safeMode;
	}

	public void start(boolean enabled)
	{
		setEnabled(enabled);
	}

	public void stop()
	{
		runOnEdt(() ->
		{
			if (frame != null)
			{
				frame.removePropertyChangeListener("title", titleListener);
				frame.removeWindowListener(windowListener);
				frame = null;
			}
		});
	}

	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
		KLiteDisguiseState.setEnabled(enabled);
		refresh();
	}

	public void refresh()
	{
		runOnEdt(this::applyBranding);
	}

	private void applyBranding()
	{
		ContainableFrame clientFrame = findClientFrame();
		if (clientFrame == null)
		{
			return;
		}

		attachFrame(clientFrame);

		BufferedImage icon128 = enabled ? RUNELITE_ICON_128 : ClientUI.ICON_128;
		BufferedImage icon16 = enabled ? RUNELITE_ICON_16 : ClientUI.ICON_16;
		String baseTitle = enabled ? RUNELITE_TITLE : kliteTitle;
		String windowTitle = buildWindowTitle(clientFrame.getTitle(), baseTitle, safeMode);

		clientFrame.setIconImages(Arrays.asList(icon128, icon16));
		if (!windowTitle.equals(clientFrame.getTitle()))
		{
			applyingTitle = true;
			try
			{
				clientFrame.setTitle(windowTitle);
			}
			finally
			{
				applyingTitle = false;
			}
		}

		updateTrayIcon(icon16, baseTitle);
		updateTaskbarIcon(icon128);
	}

	private ContainableFrame findClientFrame()
	{
		if (frame != null)
		{
			return frame;
		}

		for (Frame candidate : Frame.getFrames())
		{
			if (candidate instanceof ContainableFrame)
			{
				return (ContainableFrame) candidate;
			}
		}

		return null;
	}

	private void attachFrame(ContainableFrame clientFrame)
	{
		if (frame == clientFrame)
		{
			return;
		}

		if (frame != null)
		{
			frame.removePropertyChangeListener("title", titleListener);
			frame.removeWindowListener(windowListener);
		}

		frame = clientFrame;
		frame.addPropertyChangeListener("title", titleListener);
		frame.addWindowListener(windowListener);
	}

	private void onTitleChanged(PropertyChangeEvent event)
	{
		if (!applyingTitle)
		{
			refresh();
		}
	}

	private void updateTrayIcon(BufferedImage icon, String baseTitle)
	{
		TrayIcon trayIcon = clientUI.getTrayIcon();
		if (trayIcon == null)
		{
			return;
		}

		trayIcon.setImage(icon);
		trayIcon.setToolTip(baseTitle + (safeMode ? " (safe mode)" : ""));
	}

	private static void updateTaskbarIcon(BufferedImage icon)
	{
		try
		{
			if (!Taskbar.isTaskbarSupported())
			{
				return;
			}

			Taskbar taskbar = Taskbar.getTaskbar();
			if (taskbar.isSupported(Taskbar.Feature.ICON_IMAGE))
			{
				taskbar.setIconImage(icon);
			}
		}
		catch (RuntimeException ignored)
		{
			// Branding failures must never interrupt the client.
		}
	}

	static String buildWindowTitle(String currentTitle, String baseTitle, boolean safeMode)
	{
		String suffix = "";
		if (currentTitle != null)
		{
			int separator = currentTitle.indexOf(" - ");
			if (separator >= 0)
			{
				suffix = currentTitle.substring(separator);
			}
		}

		return baseTitle + (safeMode ? " (safe mode)" : "") + suffix;
	}

	private static void runOnEdt(Runnable runnable)
	{
		if (SwingUtilities.isEventDispatchThread())
		{
			runnable.run();
		}
		else
		{
			SwingUtilities.invokeLater(runnable);
		}
	}
}
