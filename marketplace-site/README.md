# KLite marketplace and account service

This directory contains the Cloudflare Worker, D1 schema, Discord integration,
and static marketplace site. Only `public/` is served as static content;
account code, migrations, and deployment configuration are not web-accessible.

## Features

- Website registration and sign-in with server-side, revocable sessions.
- Discord OAuth sign-in, account linking, one-time `/link` bot codes, and
  Discord-verified password recovery for legacy password accounts.
- Client sign-in with memory-only tokens and server-authoritative paid-plugin
  entitlements.
- A dual-role Plugin Dev capability, submission dashboard, and reviewer queue.
- Site-owner account and role administration for registered marketplace users.
- An authenticated, generated client/automation/web-walker API reference that
  deliberately excludes marketplace internals.
- A Discord Dev and site-owner bot dashboard with live application, server,
  command, role, channel, account, session, and announcement information.
- Configurable bot role mappings, account-link automation, audit/welcome
  channels, scheduled plugin announcements, and Dev-posted client updates.
- An opt-in client-update notification role managed by the bot through
  `/client-updates action:subscribe` and `/client-updates action:unsubscribe`.
- Capability-gated client hot reload for jars built into the local
  `sideloaded-plugins` directory.
- A shared catalog in `public/plugins.json` for the website and client.
- Click-to-run plugins streamed from private object storage into bounded client
  memory, with no manual download or persistent JAR installation.

The Worker enforces paid entitlements before returning a private artifact. The
client verifies its exact byte length and SHA-256 before loading only declared
entrypoints, then releases the artifact on Stop or client restart.

## Local setup

Install dependencies and create a local secrets file:

```powershell
npm install
Copy-Item .dev.vars.example .dev.vars
```

Create the D1 database once, copy its ID into `wrangler.jsonc`, then apply the
schema locally:

```powershell
npx wrangler d1 create klite-marketplace
npm run db:migrate:local
npm run dev
```

Never commit `.dev.vars` or any real Discord/password secrets.

## Discord configuration

Create a Discord application and configure these endpoints using the value of
`PUBLIC_ORIGIN` in `wrangler.jsonc`:

- Website and client OAuth redirect: `<PUBLIC_ORIGIN>/api/discord/callback`
- Password recovery OAuth redirect: `<PUBLIC_ORIGIN>/api/auth/reset/callback`
- Interactions endpoint: `<PUBLIC_ORIGIN>/api/discord/interactions`

Set `DISCORD_CLIENT_ID`, `DISCORD_GUILD_ID`, and `DISCORD_PLUGIN_DEV_ROLE_ID` in
`wrangler.jsonc`. OAuth requests `guilds.members.read` so the backend can verify
the server role without trusting browser or client claims. Store
`DISCORD_CLIENT_SECRET`, `DISCORD_PUBLIC_KEY`, and `DISCORD_BOT_TOKEN` as Worker
secrets. Create a Discord role named exactly `Dev`; linked members who currently
hold that role can load or change the bot dashboard. The site owner may also load
the installation dashboard before the Dev role has been created so the bootstrap
controls remain usable.

The bot needs View Channels, Send Messages, Embed Links, and Read Message
History. It also needs Manage Roles when automatic account-link assignment,
client-update subscriptions, or the dashboard's **Create Dev role** control are
enabled. The bot's highest role must be above the configured member and
client-update notification roles. To notify the client-update role, either make
that role mentionable or grant the bot permission to mention roles in the
configured update channel.

The dashboard's **Register slash commands** control registers and verifies the
commands directly in the designated Discord server. Guild registration is used
so updates are available immediately and the dashboard can verify the same
command collection it displays.

You can perform the same guild registration from a trusted terminal with
`DISCORD_APPLICATION_ID` (or `DISCORD_CLIENT_ID`), `DISCORD_BOT_TOKEN`, and
`DISCORD_GUILD_ID` set:

```powershell
npm run discord:commands
```

The Worker uses the bot token only server-side to validate configured channels,
register commands, verify posted client-update messages, publish Discord
messages, and verify dashboard installation state. The token is never returned
to the browser or stored in D1.

## Production deployment

Use independent random secrets for password hashing and owner recovery:

```powershell
npx wrangler secret put PASSWORD_PEPPER
npx wrangler secret put SITE_OWNER_RECOVERY_KEY
npx wrangler secret put DISCORD_CLIENT_SECRET
npx wrangler secret put DISCORD_PUBLIC_KEY
npx wrangler secret put DISCORD_BOT_TOKEN
npm run db:migrate:remote
npm run deploy
```

The recovery key is accepted only for the `site_owner` account. Other legacy
password accounts must verify the Discord identity already linked to the same
marketplace account before receiving a short-lived, one-time password reset
token.

Grant or revoke entitlements only from a trusted administrative path. For
example, after resolving a user's ID in D1:

```sql
INSERT INTO plugin_entitlements
  (user_id, plugin_id, access_level, granted_at, expires_at, revoked_at)
VALUES
  ('USER_ID', 'PLUGIN_ID', 'paid', unixepoch(), NULL, NULL)
ON CONFLICT(user_id, plugin_id) DO UPDATE SET
  access_level = excluded.access_level,
  granted_at = excluded.granted_at,
  expires_at = NULL,
  revoked_at = NULL;
```

The site-owner dashboard can assign or revoke the `plugin_dev` and
`marketplace_reviewer` website roles. Plugin developers still need both the
website role and the configured Discord Plugin Dev role. Equivalent trusted SQL
is:

```sql
INSERT INTO user_roles (user_id, role, granted_by, granted_at)
VALUES ('USER_ID', 'plugin_dev', 'ADMIN_USER_ID', unixepoch())
ON CONFLICT(user_id, role) DO NOTHING;
```

Reviewers use the separate `marketplace_reviewer` role. Approval updates the
review record but never publishes code automatically; a reviewed artifact still
needs the signed catalog publishing process.

Discord Plugin Dev verification is refreshed when the user relinks Discord or
runs `/account` in the configured server, and expires after 24 hours.

Payment-provider webhooks and an administrative entitlement-grant UI are
intentionally not included because no payment provider or entitlement trust
policy has been selected.

## Tests

```powershell
npm test
```
