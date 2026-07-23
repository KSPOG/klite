import assert from "node:assert/strict";
import { createHmac, webcrypto } from "node:crypto";
import test from "node:test";

globalThis.crypto ??= webcrypto;

const { handleCredits, livePaymentsEnabled } = await import("../worker/credits.js");

test("live payments require an explicit production flag", () => {
  assert.equal(livePaymentsEnabled({}), false);
  assert.equal(livePaymentsEnabled({ LEMON_SQUEEZY_LIVE_MODE: "false" }), false);
  assert.equal(livePaymentsEnabled({ LEMON_SQUEEZY_LIVE_MODE: "true" }), true);
});

test("test-mode order webhooks cannot grant credits", async () => {
  const secret = "live-webhook-secret";
  const body = JSON.stringify({
    meta: {
      event_name: "order_created",
      custom_data: {
        klite_order_id: "order-id",
        klite_user_id: "user-id",
        klite_pack_id: "credits-500"
      }
    },
    data: {
      type: "orders",
      id: "provider-order-id",
      attributes: {
        test_mode: true,
        currency: "USD",
        subtotal: 572
      }
    }
  });
  const signature = createHmac("sha256", secret).update(body).digest("hex");
  const response = await handleCredits(
    new Request("https://klite.example/api/webhooks/lemonsqueezy", {
      method: "POST",
      headers: {
        "content-type": "application/json",
        "x-event-name": "order_created",
        "x-signature": signature
      },
      body
    }),
    {
      LEMON_SQUEEZY_LIVE_MODE: "true",
      LEMON_SQUEEZY_WEBHOOK_SECRET: secret
    }
  );

  assert.equal(response.status, 409);
  assert.equal((await response.json()).error.code, "test_mode_payment_rejected");
});

test("webhooks remain disabled until live mode is explicitly enabled", async () => {
  const response = await handleCredits(
    new Request("https://klite.example/api/webhooks/lemonsqueezy", {
      method: "POST",
      body: "{}"
    }),
    { LEMON_SQUEEZY_WEBHOOK_SECRET: "unused" }
  );

  assert.equal(response.status, 503);
  assert.equal((await response.json()).error.code, "credit_webhook_live_mode_required");
});
