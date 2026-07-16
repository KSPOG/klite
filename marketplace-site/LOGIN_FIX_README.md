# KLite marketplace login deployment fix

This package fixes the deployment/configuration issue behind the generic
`The request could not be completed.` login error.

## Included changes

- `wrangler.jsonc`
  - Explicitly enables the `workers.dev` deployment.
  - Keeps `/api/*` routed through the Worker before static assets.
  - Enables Worker observability so backend exceptions are visible in Cloudflare logs.
  - Retains safe placeholders for account-specific IDs. The setup script replaces the D1 ID.
- `package.json`
  - Adds `npm run setup:production` and `npm run fix:login-ui`.
- `scripts/apply-login-ui-fix.ps1`
  - Updates `public/app.js` in place.
  - Replaces the generic error with useful HTTP 404/500, deployment, D1, migration, and secret diagnostics.
  - Creates a timestamped backup before editing.
- `scripts/setup-production.ps1`
  - Installs dependencies.
  - verifies Cloudflare authentication.
  - Finds or creates the `klite-marketplace` D1 database.
  - writes the real D1 UUID into `wrangler.jsonc`.
  - preserves an existing `PASSWORD_PEPPER`; creates one only when missing.
  - applies remote migrations.
  - deploys the Worker.
  - detects the resulting `workers.dev` URL, updates `PUBLIC_ORIGIN`, and redeploys.

## Install

Extract this ZIP over the root of the `KSPOG/klite` repository so the included
`marketplace-site` directory merges with the existing one.

Then run from PowerShell:

```powershell
cd .\marketplace-site
npm run setup:production
```

For a custom domain, provide the exact HTTPS origin:

```powershell
powershell -NoProfile -ExecutionPolicy Bypass `
  -File .\scripts\setup-production.ps1 `
  -PublicOrigin "https://marketplace.your-domain.example"
```

If D1 auto-detection cannot determine the ID:

```powershell
npx wrangler d1 list
powershell -NoProfile -ExecutionPolicy Bypass `
  -File .\scripts\setup-production.ps1 `
  -DatabaseId "YOUR-D1-UUID"
```

## Important deployment note

`https://klite-marketplace.pages.dev` is a Pages hostname. The repository is
configured as a Cloudflare Worker with static assets. `wrangler deploy` normally
publishes it to a `workers.dev` URL or a Worker custom domain.

After setup, open the exact origin printed by the script. Do not continue using
the old Pages URL unless you separately route that hostname to the Worker.

## Verification

Open:

```text
https://YOUR-WORKER-OR-CUSTOM-DOMAIN/api/account
```

While signed out, the correct result is:

- HTTP status `401`
- JSON response with error code `authentication_required`

Incorrect results are:

- a Pages HTML document
- HTTP `404`
- HTTP `500`
- the generic frontend message without an HTTP diagnostic

Then register or sign in through the marketplace UI.

## Secrets

The package contains no secret values. The setup script does not replace an
existing `PASSWORD_PEPPER`, because doing so would invalidate password hashes for
existing accounts.

Discord secrets remain optional for basic email/password login. Configure them
before using Discord linking or the bot dashboard:

```powershell
npx wrangler secret put DISCORD_CLIENT_SECRET
npx wrangler secret put DISCORD_PUBLIC_KEY
npx wrangler secret put DISCORD_BOT_TOKEN
```
