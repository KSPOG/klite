/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.login;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.Timer;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.plugins.klite.debug.KLiteClientLogBuffer;

/**
 * KLite-owned automatic login and connection-loss recovery.
 *
 * <p>The service never stores credentials. It only starts a login when the
 * client already holds a launcher session or complete credentials. An explicit
 * logout is respected and does not immediately trigger another login.</p>
 */
@Singleton
public final class KLiteAutoLoginService
{
	private static final String LOG_SOURCE = "AutoLogin";
	private static final int LOGIN_DELAY_MILLIS = 1_200;
	private static final int RETRY_COOLDOWN_MILLIS = 12_000;
	private static final int MAX_ATTEMPTS_PER_CYCLE = 3;

	private final Client client;
	private final ClientThread clientThread;
	private final KLiteClientLogBuffer diagnostics;

	private boolean enabled;
	private boolean running;
	private boolean startupArmed;
	private boolean loginCycleActive;
	private boolean reconnectArmed;
	private int attempts;
	private long lastAttemptAt;
	private Timer pendingTimer;

	@Inject
	KLiteAutoLoginService(Client client, ClientThread clientThread,
		KLiteClientLogBuffer diagnostics)
	{
		this.client = client;
		this.clientThread = clientThread;
		this.diagnostics = diagnostics;
	}

	public void start(boolean autoLoginEnabled)
	{
		running = true;
		startupArmed = true;
		setEnabled(autoLoginEnabled);
	}

	public void stop()
	{
		running = false;
		cancelPending();
		resetCycle();
	}

	public void setEnabled(boolean autoLoginEnabled)
	{
		enabled = autoLoginEnabled;
		if (!enabled)
		{
			cancelPending();
			resetCycle();
			return;
		}
		if (running)
		{
			clientThread.invokeLater(() -> onGameStateChanged(client.getGameState()));
		}
	}

	public void onGameStateChanged(GameState gameState)
	{
		if (!running || !enabled)
		{
			return;
		}

		if (gameState == GameState.LOGGED_IN)
		{
			startupArmed = false;
			cancelPending();
			resetCycle();
			return;
		}
		if (gameState == GameState.CONNECTION_LOST)
		{
			reconnectArmed = true;
			cancelPending();
			return;
		}
		if (gameState == GameState.LOGIN_SCREEN
			&& (startupArmed || loginCycleActive || reconnectArmed))
		{
			scheduleAttempt();
		}
	}

	private void scheduleAttempt()
	{
		if (pendingTimer != null || attempts >= MAX_ATTEMPTS_PER_CYCLE
			|| !credentialsAvailable())
		{
			return;
		}
		long elapsed = System.currentTimeMillis() - lastAttemptAt;
		int delay = (int) Math.max(LOGIN_DELAY_MILLIS,
			lastAttemptAt == 0L ? LOGIN_DELAY_MILLIS : RETRY_COOLDOWN_MILLIS - elapsed);
		pendingTimer = new Timer(delay, event ->
		{
			pendingTimer = null;
			clientThread.invokeLater(this::attemptOnClientThread);
		});
		pendingTimer.setRepeats(false);
		pendingTimer.start();
	}

	private void attemptOnClientThread()
	{
		if (!running || !enabled || client.getGameState() != GameState.LOGIN_SCREEN
			|| attempts >= MAX_ATTEMPTS_PER_CYCLE || !credentialsAvailable())
		{
			return;
		}
		long now = System.currentTimeMillis();
		if (lastAttemptAt != 0L && now - lastAttemptAt < RETRY_COOLDOWN_MILLIS)
		{
			scheduleAttempt();
			return;
		}

		attempts++;
		lastAttemptAt = now;
		loginCycleActive = true;
		reconnectArmed = false;
		diagnostics.info(LOG_SOURCE, "Starting automatic login attempt " + attempts
			+ '/' + MAX_ATTEMPTS_PER_CYCLE + '.');
		client.setGameState(GameState.LOGGING_IN);
	}

	private boolean credentialsAvailable()
	{
		return hasCredentials(System.getenv("JX_SESSION_ID"), client.getLauncherDisplayName(),
			client.getUsername(), client.getPassword());
	}

	static boolean hasCredentials(String launcherSession, String launcherDisplayName,
		String username, String password)
	{
		return hasText(launcherSession) || hasText(launcherDisplayName)
			|| hasText(username) && hasText(password);
	}

	private static boolean hasText(String value)
	{
		return value != null && !value.trim().isEmpty();
	}

	private void cancelPending()
	{
		if (pendingTimer != null)
		{
			pendingTimer.stop();
			pendingTimer = null;
		}
	}

	private void resetCycle()
	{
		loginCycleActive = false;
		reconnectArmed = false;
		attempts = 0;
		lastAttemptAt = 0L;
	}
}
