from pathlib import Path
import json
import re


def replace_once(text: str, old: str, new: str, label: str) -> str:
    if new in text:
        return text
    if old not in text:
        raise RuntimeError(f"Unable to locate {label}")
    return text.replace(old, new, 1)


root = Path(__file__).resolve().parents[1]
public = root / "marketplace-site" / "public"
worker = root / "marketplace-site" / "worker"

# Main site: load final styles, add the credit wallet, and activate scripts.
index_path = public / "index.html"
index = index_path.read_text("utf-8")
index = replace_once(
    index,
    '  <link rel="stylesheet" href="/obsidian-release.css?v=1">',
    '  <link rel="stylesheet" href="/obsidian-release.css?v=1">\n'
    '  <link rel="stylesheet" href="/final-obsidian.css?v=1">\n'
    '  <link rel="stylesheet" href="/credits.css?v=1">',
    "main style links",
)
wallet = '''        <article class="credit-wallet-card">
          <div class="credit-wallet-heading">
            <div><p class="eyebrow">Marketplace currency</p><h3>KLite credits</h3><p>Top up securely, then use credits to purchase Premium and Supporter plugins.</p></div>
            <div class="credit-balance-block"><span>Available balance</span><strong id="credit-balance">0 credits</strong></div>
          </div>
          <div id="credit-pack-grid" class="credit-pack-grid" aria-live="polite"></div>
          <p id="credit-status" role="status" aria-live="polite"></p>
          <div class="credit-transaction-wrap"><h4>Recent credit activity</h4><ul id="credit-transaction-list" class="credit-transaction-list"></ul></div>
        </article>
'''
index = replace_once(
    index,
    '      <div class="account-details">\n',
    '      <div class="account-details">\n' + wallet,
    "account credit wallet",
)
index = replace_once(
    index,
    '  <script src="/homepage-featured.js?v=1" defer></script>',
    '  <script src="/homepage-featured.js?v=1" defer></script>\n'
    '  <script src="/account-routes.js?v=1" defer></script>\n'
    '  <script src="/credits.js?v=1" defer></script>\n'
    '  <script src="/credits-admin.js?v=1" defer></script>',
    "credit scripts",
)
index_path.write_text(index, "utf-8")

# Documentation: never expose the repository/source button publicly.
docs_path = public / "docs" / "index.html"
docs = docs_path.read_text("utf-8")
docs = re.sub(
    r'\n\s*<div class="account-actions">\s*<a[^>]+href="https://github\.com/KSPOG/klite/tree/main/examples/klite-copper-tin-miner"[^>]*>Example Source</a>\s*</div>',
    "",
    docs,
    count=1,
)
if "/final-obsidian.css?v=1" not in docs:
    docs = docs.replace(
        '  <link rel="stylesheet" href="docs.css">',
        '  <link rel="stylesheet" href="docs.css">\n  <link rel="stylesheet" href="/final-obsidian.css?v=1">',
        1,
    )
docs_path.write_text(docs, "utf-8")

# Remove the public source/homepage URL from catalog metadata.
catalog_path = public / "plugins.json"
catalog = json.loads(catalog_path.read_text("utf-8"))
for plugin in catalog.get("plugins", []):
    homepage = plugin.get("homepageUrl")
    if isinstance(homepage, str) and "github.com/KSPOG/klite" in homepage:
        plugin.pop("homepageUrl", None)
catalog_path.write_text(json.dumps(catalog, indent=2) + "\n", "utf-8")

# Public API page inherits the same obsidian surface.
api_page_path = public / "api" / "index.html"
api_page = api_page_path.read_text("utf-8")
if "/final-obsidian.css?v=1" not in api_page:
    api_page = api_page.replace(
        '  <link rel="stylesheet" href="/api-obsidian-theme.css?v=2">',
        '  <link rel="stylesheet" href="/api-obsidian-theme.css?v=2">\n  <link rel="stylesheet" href="/final-obsidian.css?v=1">',
        1,
    )
api_page_path.write_text(api_page, "utf-8")

# Make prices public, but require authentication for balances and purchases.
credits_path = worker / "credits.js"
credits = credits_path.read_text("utf-8")
credits = replace_once(
    credits,
    '  if (request.method === "POST" && url.pathname === "/api/webhooks/lemonsqueezy") {\n    return handleLemonSqueezyWebhook(request, env);\n  }\n\n  const user = await authenticatedUser(request, env);',
    '  if (request.method === "POST" && url.pathname === "/api/webhooks/lemonsqueezy") {\n    return handleLemonSqueezyWebhook(request, env);\n  }\n  if (request.method === "GET" && url.pathname === "/api/credits/prices") {\n    return json({ prices: await activePluginPrices(env) });\n  }\n  if (!url.pathname.startsWith("/api/credits")) return null;\n\n  const user = await authenticatedUser(request, env);',
    "public credit price route",
)
credits = credits.replace(
    '  if (request.method === "GET" && url.pathname === "/api/credits/prices") {\n    return json({ prices: await activePluginPrices(env) });\n  }\n',
    "",
    1,
)
# The previous replace removes the first matching block when already moved; ensure one public block remains.
marker = '  if (request.method === "GET" && url.pathname === "/api/credits/prices") {'
if marker not in credits:
    webhook_end = '  if (request.method === "POST" && url.pathname === "/api/webhooks/lemonsqueezy") {\n    return handleLemonSqueezyWebhook(request, env);\n  }\n'
    credits = credits.replace(webhook_end, webhook_end + '  if (request.method === "GET" && url.pathname === "/api/credits/prices") {\n    return json({ prices: await activePluginPrices(env) });\n  }\n', 1)
credits_path.write_text(credits, "utf-8")

# Route credits through Cloudflare Pages before legacy password checks.
pages_path = root / "marketplace-site" / "functions" / "api" / "[[path]].js"
pages = pages_path.read_text("utf-8")
if 'from "../../worker/credits.js"' not in pages:
    pages = pages.replace(
        'import marketplaceWorker from "../../worker/index.js";',
        'import marketplaceWorker from "../../worker/index.js";\nimport { handleCredits } from "../../worker/credits.js";',
        1,
    )
pages = replace_once(
    pages,
    '    if (!env.PASSWORD_PEPPER) {',
    '    const creditResponse = await handleCredits(request, env, requestUrl);\n'
    '    if (creditResponse) return creditResponse;\n\n'
    '    if (!env.PASSWORD_PEPPER) {',
    "Pages credit routing",
)
pages_path.write_text(pages, "utf-8")

# Route credits through the standalone Worker entrypoint too.
entry_path = worker / "entry.js"
entry = entry_path.read_text("utf-8")
if 'from "./credits.js"' not in entry:
    entry = entry.replace(
        'import core from "./index.js";',
        'import core from "./index.js";\nimport { handleCredits } from "./credits.js";',
        1,
    )
entry = replace_once(
    entry,
    '    try {\n      if (request.method === "POST" && url.pathname === "/api/auth/discord/start") {',
    '    try {\n      const creditResponse = await handleCredits(request, env, url);\n'
    '      if (creditResponse) return creditResponse;\n\n'
    '      if (request.method === "POST" && url.pathname === "/api/auth/discord/start") {',
    "Worker credit routing",
)
entry_path.write_text(entry, "utf-8")

# Explicit cache controls for new production assets.
headers_path = public / "_headers"
headers = headers_path.read_text("utf-8")
for route in ["/final-obsidian.css", "/credits.css", "/credits.js", "/credits-admin.js", "/account-routes.js"]:
    if f"\n{route}\n" not in "\n" + headers:
        headers += f"\n{route}\n  Cache-Control: no-store, no-cache, must-revalidate, max-age=0\n"
headers_path.write_text(headers.rstrip() + "\n", "utf-8")
