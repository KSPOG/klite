# KLite marketplace and account service

This directory contains the Cloudflare Worker, D1 schema, Discord integration,
and static marketplace site. Only `public/` is served as static content;
account code, migrations, and deployment configuration are not web-accessible.

## Features

- Website registration and sign-in with server-side, revocable sessions.
- Discord OAuth account linking and one-time `/link` bot codes.
- Client sign-in with memory-only tokens and server-authoritative paid-plugin
  entitlements.
- A dual-role Plugin Dev capability, submission dashboard, and reviewer queue.
- An authenticated, generated client/automation/web-walker API reference that
  deliberately excludes marketplace internals.
- A Discord Dev-only bot dashboard with live application, server, command,
  role, channel, account, session, and announcement information.
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

- OAuth redirect: `<PUBLIC_ORIGIN>/api/discord/callback`
- Interactions endpoint: `<PUBLIC_ORIGIN>/api/discord/interactions`

Set `DISCORD_CLIENT_ID`, `DISCORD_GUILD_ID`, and `DISCORD_PLUGIN_DEV_ROLE_ID` in
`wrangler.jsonc`. OAuth requests `guilds.members.read` so the backend can verify
the server role without trusting browser or client claims. Store
`DISCORD_CLIENT_SECRET`, `DISCORD_PUBLIC_KEY`, and `DISCORD_BOT_TOKEN` as Worker
secrets. Create a Discord role named exactly `Dev`; only linked members who
currently hold that role can load or change the bot dashboard. The first
authorized request resolves that role by name, after which its stable role ID is
stored in D1.

The bot needs View Channels, Send Messages, Embed Links, and Read Message
History. It also needs Manage Roles when automatic account-link assignment or
client-update subscriptions are enabled. The bot's highest role must be above
the configured member and client-update notification roles.

Register the global slash commands from a trusted terminal with
`DISCORD_APPLICATION_ID` and `DISCORD_BOT_TOKEN` set:

```powershell
npm run discord:commands
```

The Worker uses the bot token only server-side to validate the configured text
channel and post marketplace announcement embeds. The token is never returned
to the browser or stored in D1.

## Production deployment

Use a random password pepper that is independent of the database:

```powershell
npx wrangler secret put PASSWORD_PEPPER
npx wrangler secret put DISCORD_CLIENT_SECRET
npx wrangler secret put DISCORD_PUBLIC_KEY
npx wrangler secret put DISCORD_BOT_TOKEN
npm run db:migrate:remote
npm run deploy
```

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
  expires_at = excluded.expires_at,
  revoked_at = NULL;
```

Website roles are assigned only from a trusted administrative path. Plugin
developers need both this website role and the configured Discord role:

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

Payment-provider webhooks and an administrative grant UI are intentionally not
included because no payment provider or trust policy has been selected.

## Tests

```powershell
npm test
```
