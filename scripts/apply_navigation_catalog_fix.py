from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
PUBLIC = ROOT / "marketplace-site" / "public"


def replace_once(text: str, old: str, new: str, label: str) -> str:
    if new in text:
        return text
    if old not in text:
        raise RuntimeError(f"Unable to locate {label}")
    return text.replace(old, new, 1)


def add_before(text: str, marker: str, value: str, label: str) -> str:
    if value.strip() in text:
        return text
    if marker not in text:
        raise RuntimeError(f"Unable to locate {label}")
    return text.replace(marker, value + marker, 1)


# Main page navigation and the missing Discord-dashboard nodes that previously
# caused app.js to throw before loadCatalog() could run.
index_path = PUBLIC / "index.html"
index = index_path.read_text("utf-8")
index = index.replace('      <a href="/docs/">Developers</a>\n', "", 1)
index = index.replace('app.js?v=release-20260718-1', 'app.js?v=release-20260718-2')
index = index.replace('site-shell.js?v=release-20260718-1', 'site-shell.js?v=release-20260718-2')

status_cards = '''        <article class="account-card"><span class="account-label">Commands</span><strong id="discord-command-count">0</strong><p class="account-note">Registered server commands</p></article>
        <article class="account-card"><span class="account-label">Announcements</span><strong id="discord-announcement-count">0</strong><p class="account-note">Marketplace announcements sent</p></article>
'''
status_anchor = '        <article class="account-card"><span class="account-label">Linked accounts</span><strong id="discord-linked-count">0</strong><p id="discord-session-count" class="account-note"></p></article>\n'
if 'id="discord-command-count"' not in index:
    index = replace_once(index, status_anchor, status_anchor + status_cards, "Discord status cards")

announcement_group = '''        <div class="bot-settings-group">
          <div><h3>Marketplace announcements</h3><p class="account-note">Choose the channel used for approved plugin release and update announcements.</p></div>
          <label class="form-field"><span>Announcement channel</span><select id="announcement-channel-id"></select></label>
          <label class="toggle-field"><input id="announcement-enabled" type="checkbox"><span>Marketplace announcements enabled</span></label>
          <div class="review-actions bot-settings-actions"><button id="announcement-sync" class="button button-secondary" type="button">Sync published catalog</button></div>
          <p id="announcement-status" class="account-note" aria-live="polite"></p>
          <div><h4>Recent announcements</h4><div id="announcement-history" class="submission-list bot-scroll-list"></div></div>
        </div>
'''
announcement_anchor = '        <div class="review-actions bot-settings-actions">\n          <button class="button button-primary" type="submit">Save bot settings</button>\n        </div>\n'
if 'id="announcement-sync"' not in index:
    index = replace_once(index, announcement_anchor, announcement_group + announcement_anchor, "announcement controls")
index_path.write_text(index, "utf-8")

# Resources are public. The login button still disappears after /api/account
# succeeds because app.js sets hidden=true; explicit CSS below makes hidden win.
enhancements_path = PUBLIC / "enhancements.js"
enhancements = enhancements_path.read_text("utf-8")
enhancements = replace_once(
    enhancements,
    '  apiButton.hidden = true;\n  accountMenuWrapper.hidden = true;',
    '  apiButton.hidden = false;\n  accountMenuWrapper.hidden = true;',
    "signed-out Resources visibility",
)
enhancements_path.write_text(enhancements, "utf-8")

# Make catalog loading absolute and guard the optional announcement control so
# missing owner-only markup can never block public marketplace initialization.
app_path = PUBLIC / "app.js"
app = app_path.read_text("utf-8")
app = app.replace(
    'const response = await fetch("plugins.json", { cache: "no-store" });',
    'const response = await fetch("/plugins.json?v=20260718-2", { cache: "no-store" });',
    1,
)
start = 'announcementSync.addEventListener("click", async () => {'
next_marker = '\n\nsignInButton.addEventListener("click", () => openAuth("login"));'
if start in app and 'if (announcementSync) {\n  announcementSync.addEventListener' not in app:
    start_index = app.index(start)
    end_index = app.index(next_marker, start_index)
    block = app[start_index:end_index]
    indented = '\n'.join('  ' + line for line in block.splitlines())
    app = app[:start_index] + 'if (announcementSync) {\n' + indented + '\n}' + app[end_index:]
app_path.write_text(app, "utf-8")

# Hidden must override the explicit !important flex declarations in the header.
obsidian_path = PUBLIC / "final-obsidian.css"
obsidian = obsidian_path.read_text("utf-8")
hidden_rule = '''

/* Authentication visibility must override header flex alignment. */
.account-actions > [hidden],
.account-actions [hidden],
#sign-in-button[hidden],
#register-button[hidden],
#api-button[hidden],
#account-menu-wrapper[hidden] {
  display: none !important;
}
'''
if 'Authentication visibility must override header flex alignment' not in obsidian:
    obsidian += hidden_rule
obsidian_path.write_text(obsidian, "utf-8")

shared_header_docs = '''  <header class="site-header secondary-site-header">
    <a class="brand" href="/" aria-label="KLite home">
      <img src="../assets/klite-marketplace.png" alt="" width="54" height="54">
      <span><strong>KLite</strong><small>Plugin Documentation</small></span>
    </a>
    <nav class="primary-site-nav" aria-label="Primary navigation">
      <a href="/">Home</a>
      <a href="/#marketplace">Marketplace</a>
    </nav>
    <div class="account-actions" aria-label="Account actions">
      <div class="shared-header-menu">
        <button id="shared-resources-button" class="button button-secondary" type="button" aria-haspopup="menu" aria-expanded="false">Resources</button>
        <div id="shared-resources-menu" class="shared-header-dropdown" role="menu" hidden>
          <a role="menuitem" href="/api/">API reference</a>
          <a role="menuitem" href="/docs/">Plugin development guide</a>
        </div>
      </div>
      <button id="shared-discord-login" class="button button-secondary discord-login-button" type="button">Continue with Discord</button>
      <div id="shared-account-wrapper" class="shared-header-menu" hidden>
        <button id="shared-account-button" class="button button-secondary" type="button" aria-haspopup="menu" aria-expanded="false">My Account</button>
        <div id="shared-account-menu" class="shared-header-dropdown" role="menu" hidden>
          <a role="menuitem" href="/#account">Account dashboard</a>
          <a role="menuitem" href="/api/">API reference</a>
          <a role="menuitem" href="/docs/">Plugin documentation</a>
          <button id="shared-account-logout" class="danger-link" type="button" role="menuitem">Log out</button>
        </div>
      </div>
    </div>
  </header>'''

shared_header_api = shared_header_docs.replace(
    '<span><strong>KLite</strong><small>Plugin Documentation</small></span>',
    '<span><strong>KLite</strong><small>Developer Documentation</small></span>',
)

# Documentation page.
docs_path = PUBLIC / "docs" / "index.html"
docs = docs_path.read_text("utf-8")
docs_start = docs.index('  <header class="site-header docs-site-header">')
docs_end = docs.index('  </header>', docs_start) + len('  </header>')
docs = docs[:docs_start] + shared_header_docs + docs[docs_end:]
docs = add_before(
    docs,
    '</head>',
    '  <link rel="stylesheet" href="/secondary-page-header.css?v=1">\n'
    '  <script src="/secondary-page-header.js?v=1" defer></script>\n',
    "Docs head",
)
docs_path.write_text(docs, "utf-8")

# API page and its old page-specific logout references.
api_index_path = PUBLIC / "api" / "index.html"
api_index = api_index_path.read_text("utf-8")
api_start = api_index.index('  <header class="site-header api-site-header">')
api_end = api_index.index('  </header>', api_start) + len('  </header>')
api_index = api_index[:api_start] + shared_header_api + api_index[api_end:]
api_index = add_before(
    api_index,
    '</head>',
    '  <link rel="stylesheet" href="/secondary-page-header.css?v=1">\n'
    '  <script src="/secondary-page-header.js?v=1" defer></script>\n',
    "API head",
)
api_index_path.write_text(api_index, "utf-8")

api_app_path = PUBLIC / "api" / "app.js"
api_app = api_app_path.read_text("utf-8")
api_app = api_app.replace('    logout.hidden = false;', '    if (logout) logout.hidden = false;', 1)
api_app = api_app.replace('logout.addEventListener("click", async () => {', 'logout?.addEventListener("click", async () => {', 1)
api_app_path.write_text(api_app, "utf-8")

# Cache-bust the public catalog and all new shared header assets.
headers_path = PUBLIC / "_headers"
headers = headers_path.read_text("utf-8")
for route in ["/plugins.json", "/secondary-page-header.js", "/secondary-page-header.css"]:
    if f"\n{route}\n" not in "\n" + headers:
        headers += f"\n{route}\n  Cache-Control: no-store, no-cache, must-revalidate, max-age=0\n"
headers_path.write_text(headers.rstrip() + "\n", "utf-8")
