from __future__ import annotations

from pathlib import Path

ROOT = Path(__file__).resolve().parents[2] if '.github' in Path(__file__).parts else Path.cwd()


def read(path: str) -> str:
    return (ROOT / path).read_text(encoding='utf-8')


def write(path: str, content: str) -> None:
    target = ROOT / path
    target.parent.mkdir(parents=True, exist_ok=True)
    target.write_text(content, encoding='utf-8', newline='\n')


def replace_once(path: str, old: str, new: str) -> None:
    content = read(path)
    count = content.count(old)
    if count != 1:
        raise RuntimeError(f'{path}: expected one replacement anchor, found {count}: {old[:120]!r}')
    write(path, content.replace(old, new, 1))


def ensure_absent(path: str) -> None:
    if (ROOT / path).exists():
        raise RuntimeError(f'{path}: file already exists')


# ---------------------------------------------------------------------------
# Client version below Check Updates / KLite Logs.
# ---------------------------------------------------------------------------
replace_once(
    'runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLitePluginPanel.java',
    'import net.runelite.client.plugins.Plugin;\n',
    'import net.runelite.client.RuneLiteProperties;\nimport net.runelite.client.plugins.Plugin;\n'
)
replace_once(
    'runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLitePluginPanel.java',
    '\t\tactions.add(utilities);\n\t\twrapper.add(actions, BorderLayout.CENTER);\n\t\treturn wrapper;\n\t}\n\n\tprivate void openLogWindow()',
    '\t\tactions.add(utilities);\n\t\twrapper.add(actions, BorderLayout.CENTER);\n\n'
    '\t\tJLabel clientVersion = new JLabel(clientVersionText());\n'
    '\t\tclientVersion.setHorizontalAlignment(SwingConstants.CENTER);\n'
    '\t\tclientVersion.setForeground(ColorScheme.LIGHT_GRAY_COLOR);\n'
    '\t\tclientVersion.setFont(clientVersion.getFont().deriveFont(10f));\n'
    '\t\tclientVersion.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));\n'
    '\t\twrapper.add(clientVersion, BorderLayout.SOUTH);\n'
    '\t\treturn wrapper;\n\t}\n\n'
    '\tstatic String clientVersionText()\n'
    '\t{\n'
    '\t\tString version = System.getProperty("klite.client.version");\n'
    '\t\tif (version == null || version.trim().isEmpty())\n'
    '\t\t{\n'
    '\t\t\tversion = System.getenv("KLITE_CLIENT_VERSION");\n'
    '\t\t}\n'
    '\t\treturn formatClientVersion(version, RuneLiteProperties.getCommit());\n'
    '\t}\n\n'
    '\tstatic String formatClientVersion(String version, String commit)\n'
    '\t{\n'
    '\t\tif (version != null && !version.trim().isEmpty())\n'
    '\t\t{\n'
    '\t\t\treturn "Client version: v" + version.trim();\n'
    '\t\t}\n'
    '\t\tif (commit == null || commit.trim().isEmpty())\n'
    '\t\t{\n'
    '\t\t\treturn "Client version: development";\n'
    '\t\t}\n'
    '\t\tString build = commit.trim();\n'
    '\t\treturn "Client version: build " + build.substring(0, Math.min(7, build.length()));\n'
    '\t}\n\n'
    '\tprivate void openLogWindow()'
)

# Pass the packaged launcher version to every managed KLiteClient process.
replace_once(
    'runelite-client/src/main/java/net/runelite/client/launcher/KLiteProcessLauncher.java',
    '\t\tenvironment.putAll(credentials);\n',
    '\t\tenvironment.putAll(credentials);\n'
    '\t\tString clientVersion = System.getProperty("klite.launcher.version");\n'
    '\t\tif (clientVersion != null && !clientVersion.isBlank())\n'
    '\t\t{\n'
    '\t\t\tenvironment.put("KLITE_CLIENT_VERSION", clientVersion);\n'
    '\t\t}\n'
)

# ---------------------------------------------------------------------------
# KLite Core AutoLogin.
# ---------------------------------------------------------------------------
replace_once(
    'runelite-client/src/main/java/net/runelite/client/plugins/klite/KLiteConfig.java',
    '\t@ConfigSection(\n\t\tname = "Automation",\n\t\tdescription = "Global controls for KLite automation modules.",\n\t\tposition = 1\n\t)\n\tString automationSection = "automation";\n\n'
    '\t@ConfigSection(\n\t\tname = "Plugin development",\n\t\tdescription = "Load locally built development plugins without the KLite client source code.",\n\t\tposition = 2\n\t)\n',
    '\t@ConfigSection(\n\t\tname = "Login",\n\t\tdescription = "KLite login and reconnect behaviour.",\n\t\tposition = 1\n\t)\n\tString loginSection = "login";\n\n'
    '\t@ConfigSection(\n\t\tname = "Automation",\n\t\tdescription = "Global controls for KLite automation modules.",\n\t\tposition = 2\n\t)\n\tString automationSection = "automation";\n\n'
    '\t@ConfigSection(\n\t\tname = "Plugin development",\n\t\tdescription = "Load locally built development plugins without the KLite client source code.",\n\t\tposition = 3\n\t)\n'
)
replace_once(
    'runelite-client/src/main/java/net/runelite/client/plugins/klite/KLiteConfig.java',
    '\t@ConfigItem(\n\t\tkeyName = "enableAutomation",\n',
    '\t@ConfigItem(\n'
    '\t\tkeyName = "autoLogin",\n'
    '\t\tname = "AutoLogin",\n'
    '\t\tdescription = "Automatically enter the game when KLite has a saved Jagex Launcher session or complete login credentials",\n'
    '\t\tsection = loginSection,\n'
    '\t\tposition = 0\n'
    '\t)\n'
    '\tdefault boolean autoLogin()\n'
    '\t{\n'
    '\t\treturn true;\n'
    '\t}\n\n'
    '\t@ConfigItem(\n\t\tkeyName = "enableAutomation",\n'
)

ensure_absent('runelite-client/src/main/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginService.java')
write('runelite-client/src/main/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginService.java', r'''/*
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
''')

replace_once(
    'runelite-client/src/main/java/net/runelite/client/plugins/klite/KLitePlugin.java',
    'import net.runelite.api.events.ItemContainerChanged;\n',
    'import net.runelite.api.events.GameStateChanged;\nimport net.runelite.api.events.ItemContainerChanged;\n'
)
replace_once(
    'runelite-client/src/main/java/net/runelite/client/plugins/klite/KLitePlugin.java',
    'import net.runelite.client.plugins.klite.marketplace.KLiteMarketplacePersistenceService;\n',
    'import net.runelite.client.plugins.klite.login.KLiteAutoLoginService;\n'
    'import net.runelite.client.plugins.klite.marketplace.KLiteMarketplacePersistenceService;\n'
)
replace_once(
    'runelite-client/src/main/java/net/runelite/client/plugins/klite/KLitePlugin.java',
    '\t@Inject\n\tprivate AutomationManager automationManager;\n',
    '\t@Inject\n\tprivate AutomationManager automationManager;\n\n'
    '\t@Inject\n\tprivate KLiteAutoLoginService autoLoginService;\n'
)
replace_once(
    'runelite-client/src/main/java/net/runelite/client/plugins/klite/KLitePlugin.java',
    '\t\tif ("enableAutomation".equals(event.getKey()))\n',
    '\t\tif ("autoLogin".equals(event.getKey()))\n'
    '\t\t{\n'
    '\t\t\tautoLoginService.setEnabled(config.autoLogin());\n'
    '\t\t}\n'
    '\t\telse if ("enableAutomation".equals(event.getKey()))\n'
)
replace_once(
    'runelite-client/src/main/java/net/runelite/client/plugins/klite/KLitePlugin.java',
    '\t@Subscribe\n\tpublic void onItemContainerChanged(ItemContainerChanged event)\n',
    '\t@Subscribe\n'
    '\tpublic void onGameStateChanged(GameStateChanged event)\n'
    '\t{\n'
    '\t\tautoLoginService.onGameStateChanged(event.getGameState());\n'
    '\t}\n\n'
    '\t@Subscribe\n\tpublic void onItemContainerChanged(ItemContainerChanged event)\n'
)
replace_once(
    'runelite-client/src/main/java/net/runelite/client/plugins/klite/KLitePlugin.java',
    '\t\toverlayManager.add(shortestPathOverlay);\n\t\tautomationManager.setEnabled(config.enableAutomation());\n',
    '\t\toverlayManager.add(shortestPathOverlay);\n'
    '\t\tautoLoginService.start(config.autoLogin());\n'
    '\t\tautomationManager.setEnabled(config.enableAutomation());\n'
)
replace_once(
    'runelite-client/src/main/java/net/runelite/client/plugins/klite/KLitePlugin.java',
    '\t\tmarketplaceWindow.close();\n\t\tautomationManager.setEnabled(false);\n',
    '\t\tmarketplaceWindow.close();\n'
    '\t\tautoLoginService.stop();\n'
    '\t\tautomationManager.setEnabled(false);\n'
)

ensure_absent('runelite-client/src/test/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginServiceTest.java')
write('runelite-client/src/test/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginServiceTest.java', r'''/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.login;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class KLiteAutoLoginServiceTest
{
	@Test
	public void acceptsLauncherSession()
	{
		assertTrue(KLiteAutoLoginService.hasCredentials("session", null, null, null));
	}

	@Test
	public void acceptsLauncherDisplayName()
	{
		assertTrue(KLiteAutoLoginService.hasCredentials(null, "Character", null, null));
	}

	@Test
	public void acceptsCompleteClassicCredentials()
	{
		assertTrue(KLiteAutoLoginService.hasCredentials(null, null, "user", "password"));
	}

	@Test
	public void rejectsIncompleteCredentials()
	{
		assertFalse(KLiteAutoLoginService.hasCredentials(null, null, "user", null));
		assertFalse(KLiteAutoLoginService.hasCredentials(null, null, null, "password"));
		assertFalse(KLiteAutoLoginService.hasCredentials(" ", " ", " ", " "));
	}
}
''')

ensure_absent('runelite-client/src/test/java/net/runelite/client/plugins/klite/marketplace/KLitePluginPanelVersionTest.java')
write('runelite-client/src/test/java/net/runelite/client/plugins/klite/marketplace/KLitePluginPanelVersionTest.java', r'''/*
 * Copyright (c) 2026, KLite contributors
 * All rights reserved.
 * BSD 2-Clause License; see LICENSE in the project root.
 */
package net.runelite.client.plugins.klite.marketplace;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KLitePluginPanelVersionTest
{
	@Test
	public void prefersPackagedSemanticVersion()
	{
		assertEquals("Client version: v1.2.3",
			KLitePluginPanel.formatClientVersion("1.2.3", "abcdef123456"));
	}

	@Test
	public void fallsBackToShortBuild()
	{
		assertEquals("Client version: build abcdef1",
			KLitePluginPanel.formatClientVersion(null, "abcdef123456"));
	}
}
''')


print('Applied client version and KLite AutoLogin features.')
