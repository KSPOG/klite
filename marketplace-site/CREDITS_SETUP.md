# KLite marketplace credits deployment

The website and API support USD credit packs, a D1-backed immutable ledger, premium-plugin purchases, and owner-managed plugin prices.

## Credit packs

| USD price | Credits | Bonus |
|---:|---:|---:|
| $5.72 | 500 | 0% |
| $11.44 | 1,050 | 5% |
| $22.88 | 2,200 | 10% |
| $40.04 | 4,000 | 14% |
| $57.20 | 5,750 | 15% |
| $114.40 | 12,000 | 20% |

These are the fixed USD conversions selected on 2026-07-18. Changing them requires updating `CREDIT_PACKS` in `worker/credits.js` and redeploying.

## Required Cloudflare Pages secrets and variables

Configure these on the production Pages project:

- `LEMON_SQUEEZY_API_KEY` — private API key.
- `LEMON_SQUEEZY_STORE_ID` — numeric store ID.
- `LEMON_SQUEEZY_CREDIT_VARIANT_ID` — one-time purchase variant used to create custom-price credit checkouts.
- `LEMON_SQUEEZY_WEBHOOK_SECRET` — random webhook signing secret.
- `PUBLIC_ORIGIN` — `https://klite-marketplace.pages.dev`.

Do not expose any of these values in `public/`, client code, screenshots, or support logs.

## Lemon Squeezy configuration

1. Create one non-subscription product and variant for KLite credit top-ups.
2. Copy its store and variant IDs into the Pages variables.
3. Create a webhook pointing to:

   `https://klite-marketplace.pages.dev/api/webhooks/lemonsqueezy`

4. Subscribe the webhook to `order_created`.
5. Use the same signing secret for the webhook and `LEMON_SQUEEZY_WEBHOOK_SECRET`.
6. Redeploy the Pages project after adding variables or secrets.

The checkout click does not credit the account. Credits are inserted only after a correctly signed `order_created` webhook matches the local order, user, pack, currency, and expected USD subtotal.

## Database

Migration `0007_marketplace_credits.sql` must be applied to the production D1 database before using the credit endpoints. The repository migration workflow applies it when the required Cloudflare repository secrets are present.

## Premium plugin pricing

The site owner can open **Account → Marketplace administration** and use **Credit prices and ledger** to set a whole-number credit price for a published Premium or Supporter plugin ID. A purchase creates a negative ledger transaction and grants the existing plugin entitlement atomically.
