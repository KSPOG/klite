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


replace_once(
    'marketplace-site/public/index.html',
    '        <article class="account-card"><span class="account-label">Announcements</span><strong id="discord-announcement-count">0</strong><p class="account-note">Marketplace announcements sent</p></article>\n',
    '        <article class="account-card"><span class="account-label">Announcements</span><strong id="discord-announcement-count">0</strong><p class="account-note">Marketplace announcements sent</p></article>\n'
    '        <article class="account-card"><span class="account-label">Client updates</span><strong id="discord-client-update-count">0</strong><p class="account-note">Client update posts sent</p></article>\n'
)
replace_once(
    'marketplace-site/public/index.html',
    '          <label class="form-field"><span>Default member role</span><select id="discord-member-role"></select></label>\n',
    '          <label class="form-field"><span>Default member role</span><select id="discord-member-role"></select></label>\n'
    '          <label class="form-field"><span>Client update notification role</span><select id="discord-client-update-role"></select></label>\n'
)
replace_once(
    'marketplace-site/public/index.html',
    '          <label class="form-field"><span>Member welcome channel</span><select id="discord-welcome-channel"></select></label>\n',
    '          <label class="form-field"><span>Member welcome channel</span><select id="discord-welcome-channel"></select></label>\n'
    '          <label class="form-field"><span>Client update channel</span><select id="discord-client-update-channel"></select></label>\n'
)
replace_once(
    'marketplace-site/public/index.html',
    '        <div class="bot-settings-group">\n'
    '          <div><h3>Marketplace announcements</h3><p class="account-note">Choose the channel used for approved plugin release and update announcements.</p></div>\n',
    '        <div class="bot-settings-group">\n'
    '          <div><h3>Client updates</h3><p class="account-note">Post a client release into the configured channel and mention only members who opted into the notification role with <code>/client-updates</code>.</p></div>\n'
    '          <label class="toggle-field"><input id="discord-client-updates-enabled" type="checkbox"><span>Client update posts and role subscriptions enabled</span></label>\n'
    '          <label class="form-field"><span>Client version</span><input id="discord-client-update-version" type="text" maxlength="64" placeholder="1.0.95"></label>\n'
    '          <label class="form-field submission-wide"><span>Updates</span><textarea id="discord-client-update-notes" rows="6" maxlength="3000" placeholder="- Added AutoLogin to KLite Core&#10;- Improved update notifications"></textarea></label>\n'
    '          <div class="review-actions bot-settings-actions"><button id="discord-client-update-post" class="button button-secondary" type="button">Post client update</button></div>\n'
    '          <p id="discord-client-update-status" class="account-note" aria-live="polite"></p>\n'
    '          <div><h4>Recent client updates</h4><div id="discord-client-update-history" class="submission-list bot-scroll-list"></div></div>\n'
    '        </div>\n'
    '        <div class="bot-settings-group">\n'
    '          <div><h3>Marketplace announcements</h3><p class="account-note">Choose the channel used for approved plugin release and update announcements.</p></div>\n'
)
replace_once(
    'marketplace-site/public/index.html',
    '  <script src="app.js?v=release-20260718-2" defer></script>\n',
    '  <script src="app.js?v=release-20260719-client-updates" defer></script>\n'
)

replace_once(
    'marketplace-site/public/app.js',
    'const discordAnnouncementCount = document.querySelector("#discord-announcement-count");\n',
    'const discordAnnouncementCount = document.querySelector("#discord-announcement-count");\n'
    'const discordClientUpdateCount = document.querySelector("#discord-client-update-count");\n'
)
replace_once(
    'marketplace-site/public/app.js',
    'const discordMemberRole = document.querySelector("#discord-member-role");\n',
    'const discordMemberRole = document.querySelector("#discord-member-role");\n'
    'const discordClientUpdateRole = document.querySelector("#discord-client-update-role");\n'
)
replace_once(
    'marketplace-site/public/app.js',
    'const discordWelcomeChannel = document.querySelector("#discord-welcome-channel");\n',
    'const discordWelcomeChannel = document.querySelector("#discord-welcome-channel");\n'
    'const discordClientUpdateChannel = document.querySelector("#discord-client-update-channel");\n'
)
replace_once(
    'marketplace-site/public/app.js',
    'const announcementHistory = document.querySelector("#announcement-history");\n',
    'const announcementHistory = document.querySelector("#announcement-history");\n'
    'const discordClientUpdatesEnabled = document.querySelector("#discord-client-updates-enabled");\n'
    'const discordClientUpdateVersion = document.querySelector("#discord-client-update-version");\n'
    'const discordClientUpdateNotes = document.querySelector("#discord-client-update-notes");\n'
    'const discordClientUpdatePost = document.querySelector("#discord-client-update-post");\n'
    'const discordClientUpdateStatus = document.querySelector("#discord-client-update-status");\n'
    'const discordClientUpdateHistory = document.querySelector("#discord-client-update-history");\n'
)
replace_once(
    'marketplace-site/public/app.js',
    '  discordAnnouncementCount.textContent =\n    `${payload.stats.announcementsSent} marketplace announcements sent`;\n',
    '  discordAnnouncementCount.textContent =\n'
    '    `${payload.stats.announcementsSent} marketplace announcements sent`;\n'
    '  discordClientUpdateCount.textContent = String(payload.clientUpdates?.history?.length || 0);\n'
)
replace_once(
    'marketplace-site/public/app.js',
    '  populateDiscordSelect(discordMemberRole, roles.filter((role) => !role.managed),\n    settings.memberRoleId, "Not configured");\n',
    '  populateDiscordSelect(discordMemberRole, roles.filter((role) => !role.managed),\n'
    '    settings.memberRoleId, "Not configured");\n'
    '  populateDiscordSelect(discordClientUpdateRole, roles.filter((role) => !role.managed),\n'
    '    settings.clientUpdateRoleId, "Not configured");\n'
)
replace_once(
    'marketplace-site/public/app.js',
    '  populateDiscordSelect(discordWelcomeChannel, payload.channels,\n    settings.welcomeChannelId, "Not configured");\n',
    '  populateDiscordSelect(discordWelcomeChannel, payload.channels,\n'
    '    settings.welcomeChannelId, "Not configured");\n'
    '  populateDiscordSelect(discordClientUpdateChannel, payload.channels,\n'
    '    settings.clientUpdateChannelId, "Not configured");\n'
)
replace_once(
    'marketplace-site/public/app.js',
    '  discordAutoMemberRole.checked = settings.autoAssignMemberRole;\n\n  discordCommandList.replaceChildren();\n',
    '  discordAutoMemberRole.checked = settings.autoAssignMemberRole;\n'
    '  discordClientUpdatesEnabled.checked = settings.clientUpdatesEnabled;\n'
    '  if (!discordClientUpdateVersion.value && payload.clientUpdates?.currentRelease?.version) {\n'
    '    discordClientUpdateVersion.value = payload.clientUpdates.currentRelease.version;\n'
    '  }\n\n'
    '  discordClientUpdateHistory.replaceChildren();\n'
    '  for (const entry of payload.clientUpdates?.history || []) {\n'
    '    const card = document.createElement("article");\n'
    '    card.className = "submission-card";\n'
    '    const title = document.createElement("strong");\n'
    '    title.textContent = `Client ${entry.version}`;\n'
    '    const updates = document.createElement("p");\n'
    '    updates.textContent = entry.updates;\n'
    '    const metadata = document.createElement("p");\n'
    '    metadata.className = "submission-meta";\n'
    '    metadata.textContent = `Channel ${entry.channelId} - `\n'
    '      + new Date(entry.postedAt * 1000).toLocaleString();\n'
    '    card.append(title, updates, metadata);\n'
    '    discordClientUpdateHistory.append(card);\n'
    '  }\n'
    '  if (!discordClientUpdateHistory.childElementCount) {\n'
    '    discordClientUpdateHistory.textContent = "No client updates have been posted yet.";\n'
    '  }\n\n'
    '  discordCommandList.replaceChildren();\n'
)

replace_once(
    'marketplace-site/public/app.js',
    'discordBotSettingsForm.addEventListener("submit", async (event) => {\n',
    'function discordSettingsPayload(postClientUpdate = false) {\n'
    '  return {\n'
    '    devRoleId: discordDevRole.value,\n'
    '    pluginDevRoleId: discordPluginDevRole.value || null,\n'
    '    marketplaceReviewerRoleId: discordReviewerRole.value || null,\n'
    '    memberRoleId: discordMemberRole.value || null,\n'
    '    clientUpdateRoleId: discordClientUpdateRole.value || null,\n'
    '    announcementChannelId: announcementChannelId.value || null,\n'
    '    clientUpdateChannelId: discordClientUpdateChannel.value || null,\n'
    '    auditChannelId: discordAuditChannel.value || null,\n'
    '    welcomeChannelId: discordWelcomeChannel.value || null,\n'
    '    botEnabled: discordBotEnabled.checked,\n'
    '    announcementsEnabled: announcementEnabled.checked,\n'
    '    clientUpdatesEnabled: discordClientUpdatesEnabled.checked,\n'
    '    autoAssignMemberRole: discordAutoMemberRole.checked,\n'
    '    postClientUpdate,\n'
    '    clientUpdateVersion: discordClientUpdateVersion.value,\n'
    '    clientUpdateNotes: discordClientUpdateNotes.value\n'
    '  };\n'
    '}\n\n'
    'discordBotSettingsForm.addEventListener("submit", async (event) => {\n'
)
replace_once(
    'marketplace-site/public/app.js',
    '      body: JSON.stringify({\n'
    '        devRoleId: discordDevRole.value,\n'
    '        pluginDevRoleId: discordPluginDevRole.value || null,\n'
    '        marketplaceReviewerRoleId: discordReviewerRole.value || null,\n'
    '        memberRoleId: discordMemberRole.value || null,\n'
    '        announcementChannelId: announcementChannelId.value || null,\n'
    '        auditChannelId: discordAuditChannel.value || null,\n'
    '        welcomeChannelId: discordWelcomeChannel.value || null,\n'
    '        botEnabled: discordBotEnabled.checked,\n'
    '        announcementsEnabled: announcementEnabled.checked,\n'
    '        autoAssignMemberRole: discordAutoMemberRole.checked\n'
    '      })\n',
    '      body: JSON.stringify(discordSettingsPayload(false))\n'
)
replace_once(
    'marketplace-site/public/app.js',
    'if (announcementSync) {\n',
    'if (discordClientUpdatePost) {\n'
    '  discordClientUpdatePost.addEventListener("click", async () => {\n'
    '    discordClientUpdatePost.disabled = true;\n'
    '    discordClientUpdateStatus.textContent = "Posting the client update...";\n'
    '    try {\n'
    '      const payload = await api("/api/discord-bot/settings", {\n'
    '        method: "PUT",\n'
    '        body: JSON.stringify(discordSettingsPayload(true))\n'
    '      });\n'
    '      renderDiscordBotDashboard(payload);\n'
    '      discordClientUpdateNotes.value = "";\n'
    '      discordClientUpdateStatus.textContent = "Client update posted.";\n'
    '    } catch (error) {\n'
    '      discordClientUpdateStatus.textContent = error.message;\n'
    '    } finally {\n'
    '      discordClientUpdatePost.disabled = false;\n'
    '    }\n'
    '  });\n'
    '}\n\n'
    'if (announcementSync) {\n'
)

replace_once(
    'marketplace-site/test/discord-dashboard.test.js',
    '''test("normalizes Discord bot role and channel settings", () => {
  assert.equal(normalizeSnowflake(` ${DEV_ROLE_ID} `), DEV_ROLE_ID);
  assert.equal(normalizeSnowflake("not-a-role"), null);
  assert.deepEqual(normalizeDiscordBotSettings({
    devRoleId: DEV_ROLE_ID,
    pluginDevRoleId: null,
    marketplaceReviewerRoleId: "",
    memberRoleId: null,
    announcementChannelId: null,
    auditChannelId: null,
    welcomeChannelId: null,
    botEnabled: true,
    autoAssignMemberRole: false,
    announcementsEnabled: false
  }), {
    devRoleId: DEV_ROLE_ID,
    pluginDevRoleId: null,
    marketplaceReviewerRoleId: null,
    memberRoleId: null,
    announcementChannelId: null,
    auditChannelId: null,
    welcomeChannelId: null,
    botEnabled: true,
    autoAssignMemberRole: false,
    announcementsEnabled: false
  });
});
''',
    '''test("normalizes Discord bot role and channel settings", () => {
  assert.equal(normalizeSnowflake(` ${DEV_ROLE_ID} `), DEV_ROLE_ID);
  assert.equal(normalizeSnowflake("not-a-role"), null);
  assert.deepEqual(normalizeDiscordBotSettings({
    devRoleId: DEV_ROLE_ID,
    pluginDevRoleId: null,
    marketplaceReviewerRoleId: "",
    memberRoleId: null,
    clientUpdateRoleId: null,
    announcementChannelId: null,
    clientUpdateChannelId: null,
    auditChannelId: null,
    welcomeChannelId: null,
    botEnabled: true,
    autoAssignMemberRole: false,
    announcementsEnabled: false,
    clientUpdatesEnabled: false
  }), {
    devRoleId: DEV_ROLE_ID,
    pluginDevRoleId: null,
    marketplaceReviewerRoleId: null,
    memberRoleId: null,
    clientUpdateRoleId: null,
    announcementChannelId: null,
    clientUpdateChannelId: null,
    auditChannelId: null,
    welcomeChannelId: null,
    botEnabled: true,
    autoAssignMemberRole: false,
    announcementsEnabled: false,
    clientUpdatesEnabled: false,
    postClientUpdate: false,
    clientUpdateVersion: "",
    clientUpdateNotes: ""
  });
});
'''
)

ensure_absent('marketplace-site/test/client-updates.test.js')
write('marketplace-site/test/client-updates.test.js', r'''import assert from "node:assert/strict";
import test from "node:test";

import {
  buildClientUpdateMessage,
  normalizeUpdates,
  normalizeVersion
} from "../worker/client-updates.js";

const ROLE_ID = "12345678901234567";

test("builds the requested client version and updates message", () => {
  assert.deepEqual(buildClientUpdateMessage("1.0.95", "- Added AutoLogin", ROLE_ID), {
    content: `<@&${ROLE_ID}>\n**Client version:** 1.0.95\n**Updates:**\n- Added AutoLogin`,
    allowed_mentions: { parse: [], roles: [ROLE_ID] }
  });
});

test("normalizes client update versions and notes", () => {
  assert.equal(normalizeVersion(" 1.0.95 "), "1.0.95");
  assert.equal(normalizeVersion("latest"), null);
  assert.equal(normalizeUpdates(" line one\r\nline two "), "line one\nline two");
  assert.equal(normalizeUpdates("  "), null);
});
''')

replace_once(
    'marketplace-site/README.md',
    '- Configurable bot role mappings, account-link automation, audit/welcome\n  channels, and scheduled plugin release/update announcements.\n',
    '- Configurable bot role mappings, account-link automation, audit/welcome\n'
    '  channels, scheduled plugin announcements, and Dev-posted client updates.\n'
    '- An opt-in client-update notification role managed by the bot through\n'
    '  `/client-updates action:subscribe` and `/client-updates action:unsubscribe`.\n'
)
replace_once(
    'marketplace-site/README.md',
    'The bot needs View Channels, Send Messages, Embed Links, and Read Message\nHistory. It also needs Manage Roles when automatic account-link role assignment\nis enabled. The bot\'s highest role must be above the configured member role.\n',
    'The bot needs View Channels, Send Messages, Embed Links, and Read Message\n'
    'History. It also needs Manage Roles when automatic account-link assignment or\n'
    'client-update subscriptions are enabled. The bot\'s highest role must be above\n'
    'the configured member and client-update notification roles.\n'
)

print('Applied Discord client-update frontend and tests.')
