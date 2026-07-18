from pathlib import Path

path = Path(__file__).resolve().parents[1] / "marketplace-site" / "worker" / "credits.js"
text = path.read_text("utf-8")
block = (
    '  if (request.method === "GET" && url.pathname === "/api/credits/prices") {\n'
    '    return json({ prices: await activePluginPrices(env) });\n'
    '  }\n'
)
text = text.replace(block, "")
anchor = (
    '  if (request.method === "POST" && url.pathname === "/api/webhooks/lemonsqueezy") {\n'
    '    return handleLemonSqueezyWebhook(request, env);\n'
    '  }\n'
)
if anchor not in text:
    raise RuntimeError("Unable to locate Lemon Squeezy webhook route")
text = text.replace(anchor, anchor + block, 1)
path.write_text(text, "utf-8")
