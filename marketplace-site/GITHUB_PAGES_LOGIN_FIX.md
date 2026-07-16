# KLite marketplace login fix for Git-connected Cloudflare Pages

The public URL `https://klite-marketplace.pages.dev` is a Cloudflare Pages
project connected to GitHub. Pushing to GitHub deploys the site automatically.
The previous Worker-only deployment instructions do not match that hosting
model.

## What this package changes

### `functions/api/[[path]].js`

Cloudflare Pages uses the `functions/` directory for server-side routes. This
adapter sends every `/api/*` request to the existing
`marketplace-site/worker/index.js` implementation.

It also returns useful configuration errors when the `DB` binding or
`PASSWORD_PEPPER` secret is missing, instead of the generic:

```text
The request could not be completed.
```

### `public/_routes.json`

Only `/api/*` invokes Pages Functions. Static assets remain normal Pages files.

### GitHub migration workflow

`.github/workflows/marketplace-d1-migrations.yml` applies D1 migrations whenever
files under `marketplace-site/migrations/` change. It does not deploy the Pages
site; the existing Cloudflare Git integration continues to do that.

## Cloudflare Pages build settings

Open Cloudflare Dashboard -> Workers & Pages -> `klite-marketplace` -> Settings.

Use these build settings:

```text
Production branch: main
Root directory: marketplace-site
Build command: leave blank
Build output directory: public
```

The `functions` directory must be inside the configured root directory. After a
push, the deployment details should show a Pages Functions bundle.

## Required Cloudflare Pages bindings

Configure these in both Production and Preview when preview login should work.

### D1 database

Go to Settings -> Bindings -> Add -> D1 database.

```text
Variable name: DB
D1 database: klite-marketplace
```

Create the database in Cloudflare first if it does not already exist.

### Authentication secret

Go to Settings -> Variables and Secrets -> Add -> Secret.

```text
Name: PASSWORD_PEPPER
Value: a long random secret
```

Do not change an existing `PASSWORD_PEPPER`. Existing password hashes depend on
that exact value.

### Public origin

Add a normal environment variable:

```text
Name: PUBLIC_ORIGIN
Value: https://klite-marketplace.pages.dev
```

The Pages Function derives this from the request when omitted, but explicitly
setting it is recommended, especially before configuring Discord OAuth or a
custom domain.

### Optional feature bindings

The following are not required for basic email/password login, but are needed by
other marketplace features:

```text
R2 binding: PLUGIN_ARTIFACTS
DISCORD_CLIENT_ID
DISCORD_GUILD_ID
DISCORD_PLUGIN_DEV_ROLE_ID
DISCORD_CLIENT_SECRET (secret)
DISCORD_PUBLIC_KEY (secret)
DISCORD_BOT_TOKEN (secret)
```

## GitHub Actions secrets for automatic migrations

In GitHub, open Repository Settings -> Secrets and variables -> Actions. Add:

```text
CLOUDFLARE_API_TOKEN
CLOUDFLARE_ACCOUNT_ID
CLOUDFLARE_D1_DATABASE_ID
```

The API token needs permission to edit D1 for the relevant Cloudflare account.
The D1 ID is available on the database overview page in Cloudflare.

After adding the secrets, open GitHub -> Actions ->
`KLite marketplace D1 migrations` -> Run workflow. Future migration changes run
it automatically.

## Verification

After GitHub and Cloudflare finish deploying, open:

```text
https://klite-marketplace.pages.dev/api/account
```

The correct signed-out response is HTTP 401 with JSON similar to:

```json
{
  "error": {
    "code": "authentication_required",
    "message": "Sign in to continue."
  }
}
```

Other results indicate:

- `database_binding_missing`: add the Pages D1 binding named `DB`.
- `password_pepper_missing`: add the Pages secret `PASSWORD_PEPPER`.
- `marketplace_backend_error`: run the D1 migration workflow and inspect the
  Cloudflare Pages Function logs.
- HTML or a static 404: verify the Pages root is `marketplace-site` and that the
  deployment includes the `functions` directory.
