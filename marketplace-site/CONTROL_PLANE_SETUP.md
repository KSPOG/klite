# KLite marketplace control plane

The Cloudflare Pages deployment hosts the marketplace, account service, Discord HTTP interactions, bot installation dashboard, reviewer management, and password recovery. A continuously running Discord Gateway process is not required; the bot can appear offline while slash commands and REST-driven automation continue to work.

## Cloudflare Pages production variables

Configure these under **Workers & Pages → klite-marketplace → Settings → Variables and secrets → Production**:

- `PASSWORD_PEPPER` — secret
- `DISCORD_BOT_TOKEN` — secret
- `DISCORD_CLIENT_SECRET` — secret
- `DISCORD_PUBLIC_KEY` — secret
- `DISCORD_CLIENT_ID` — application ID
- `DISCORD_APPLICATION_ID` — application ID; may match `DISCORD_CLIENT_ID`
- `DISCORD_GUILD_ID` — the only server the dashboard invitation may target
- `PUBLIC_ORIGIN` — `https://klite-marketplace.pages.dev`
- `SITE_OWNER_USERNAME` — defaults to `KSP`
- `SITE_OWNER_RECOVERY_KEY` — separate random secret used only for owner password recovery
- `SITE_OWNER_USER_ID` — optional stronger owner pinning after the account ID is known

Redeploy after changing Pages variables.

## Discord Developer Portal

Enable **Guild Install** and add both `bot` and `applications.commands` scopes. Set these URLs:

- Interactions endpoint: `https://klite-marketplace.pages.dev/api/discord/interactions`
- OAuth redirect: `https://klite-marketplace.pages.dev/api/discord/callback`
- Password reset redirect: `https://klite-marketplace.pages.dev/api/auth/reset/callback`

The owner dashboard generates an installation URL locked to `DISCORD_GUILD_ID`. After authorization, press **Verify installation**, create or choose a dashboard administrator role, register slash commands, and save the role/channel settings.

## Owner and reviewer access

The account whose username matches `SITE_OWNER_USERNAME` receives permanent site-owner access. For stronger pinning, query D1 for its user ID and set `SITE_OWNER_USER_ID`.

The owner dashboard can assign:

- `plugin_dev`
- `marketplace_reviewer`

Accounts with `marketplace_reviewer` see the plugin approval queue and can approve, reject, or request changes.

## Password reset

Normal password reset is verified through the Discord identity previously linked to the marketplace account. The KLite owner can instead enter `SITE_OWNER_RECOVERY_KEY` in the reset dialog when Discord was never linked. The recovery key must be different from `PASSWORD_PEPPER` and should be at least 16 random characters.

Password recovery never reveals the old password. Completing a reset invalidates all existing website/client sessions for that account.
