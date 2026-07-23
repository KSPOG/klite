import assert from "node:assert/strict";
import test from "node:test";

import { adjustUserCredits } from "../worker/credits.js";

const USER_ID = "11111111-1111-4111-8111-111111111111";
const OWNER = {
  id: "22222222-2222-4222-8222-222222222222",
  username: "KSP"
};

function request(delta, reason = "Manual support correction") {
  return new Request("https://klite-marketplace.pages.dev/api/credits/admin/users/x/adjustments", {
    method: "POST",
    headers: { "content-type": "application/json" },
    body: JSON.stringify({ delta, reason })
  });
}

function environment(initialBalance = 100) {
  let balance = initialBalance;
  const transactions = [];
  return {
    env: {
      DB: {
        prepare(sql) {
          return {
            bind(...values) {
              return {
                async first() {
                  if (sql.includes("FROM users WHERE id")) {
                    return values[0] === USER_ID
                      ? { id: USER_ID, username: "Tester", email: "tester@example.com" }
                      : null;
                  }
                  if (sql.includes("COALESCE(SUM(delta)")) return { balance };
                  throw new Error(`Unexpected first query: ${sql}`);
                },
                async run() {
                  if (!sql.includes("INSERT INTO credit_transactions")) {
                    throw new Error(`Unexpected run query: ${sql}`);
                  }
                  const delta = values[2];
                  if (balance + delta < 0) return { meta: { changes: 0 } };
                  balance += delta;
                  transactions.push({ id: values[0], delta, reason: values[3] });
                  return { meta: { changes: 1 } };
                }
              };
            }
          };
        }
      },
      SITE_OWNER_USERNAME: "KSP"
    },
    balance: () => balance,
    transactions
  };
}

test("owner credit adjustments append an audited ledger transaction", async () => {
  const state = environment();
  const response = await adjustUserCredits(
    request(500, "Granted after verified support review"),
    state.env,
    OWNER,
    USER_ID
  );
  const payload = await response.json();

  assert.equal(response.status, 200);
  assert.equal(payload.user.balance, 600);
  assert.equal(payload.transaction.delta, 500);
  assert.equal(payload.transaction.kind, "adjustment");
  assert.equal(state.transactions.length, 1);
  assert.equal(state.balance(), 600);
});

test("credit adjustments cannot make the balance negative", async () => {
  const state = environment(100);
  const response = await adjustUserCredits(
    request(-101, "Removing incorrectly granted credits"),
    state.env,
    OWNER,
    USER_ID
  );
  const payload = await response.json();

  assert.equal(response.status, 409);
  assert.equal(payload.error.code, "negative_credit_balance");
  assert.equal(state.balance(), 100);
  assert.equal(state.transactions.length, 0);
});

test("credit adjustments require a meaningful audit reason", async () => {
  const state = environment();
  const response = await adjustUserCredits(request(5, "short"), state.env, OWNER, USER_ID);
  const payload = await response.json();

  assert.equal(response.status, 400);
  assert.equal(payload.error.code, "invalid_adjustment_reason");
  assert.equal(state.transactions.length, 0);
});
