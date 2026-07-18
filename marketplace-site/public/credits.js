(() => {
  const balanceNode = document.querySelector("#credit-balance");
  const packGrid = document.querySelector("#credit-pack-grid");
  const transactionList = document.querySelector("#credit-transaction-list");
  const statusNode = document.querySelector("#credit-status");
  const pluginGrid = document.querySelector("#plugin-grid");
  const accountPanel = document.querySelector("#account");
  let accountData = null;
  let catalogPlugins = [];
  let prices = new Map();

  async function creditApi(path, options = {}) {
    const response = await fetch(path, {
      credentials: "same-origin",
      ...options,
      headers: { ...(options.body ? { "content-type": "application/json" } : {}), ...options.headers }
    });
    const payload = await response.json().catch(() => ({}));
    if (!response.ok) {
      const error = new Error(payload.error?.message || "The request could not be completed.");
      error.status = response.status;
      throw error;
    }
    return payload;
  }

  const creditsText = (value) => `${Number(value || 0).toLocaleString("en-US")} credits`;
  const usdText = (cents) => new Intl.NumberFormat("en-US", {
    style: "currency", currency: "USD", minimumFractionDigits: 2
  }).format(Number(cents || 0) / 100);

  function setCreditStatus(message, error = false) {
    if (!statusNode) return;
    statusNode.textContent = message || "";
    statusNode.classList.toggle("is-error", error);
  }

  function renderCreditPacks(packs) {
    if (!packGrid) return;
    packGrid.replaceChildren();
    for (const pack of packs || []) {
      const card = document.createElement("article");
      card.className = `credit-pack-card${pack.bonusPercent >= 15 ? " credit-pack-featured" : ""}`;
      const heading = document.createElement("div");
      heading.className = "credit-pack-heading";
      const amount = document.createElement("strong");
      amount.textContent = Number(pack.credits).toLocaleString("en-US");
      const label = document.createElement("span");
      label.textContent = "KLite credits";
      heading.append(amount, label);
      const price = document.createElement("b");
      price.textContent = usdText(pack.usdCents);
      const bonus = document.createElement("small");
      bonus.textContent = pack.bonusPercent ? `${pack.bonusPercent}% bonus included` : "Standard credit pack";
      const button = document.createElement("button");
      button.type = "button";
      button.className = "button button-primary credit-topup-button";
      button.textContent = `Top up ${usdText(pack.usdCents)}`;
      button.addEventListener("click", async () => {
        button.disabled = true;
        setCreditStatus("Creating secure checkout…");
        try {
          const result = await creditApi("/api/credits/checkout", {
            method: "POST", body: JSON.stringify({ packId: pack.id })
          });
          window.location.assign(result.checkoutUrl);
        } catch (error) {
          setCreditStatus(error.message, true);
          button.disabled = false;
        }
      });
      card.append(heading, price, bonus, button);
      packGrid.append(card);
    }
  }

  function renderCreditTransactions(transactions) {
    if (!transactionList) return;
    transactionList.replaceChildren();
    for (const transaction of transactions || []) {
      const row = document.createElement("li");
      row.className = "credit-transaction";
      const copy = document.createElement("div");
      const title = document.createElement("strong");
      title.textContent = transaction.description;
      const date = document.createElement("small");
      date.textContent = new Date(Number(transaction.createdAt) * 1000).toLocaleString();
      copy.append(title, date);
      const amount = document.createElement("b");
      amount.className = transaction.delta > 0 ? "credit-positive" : "credit-negative";
      amount.textContent = `${transaction.delta > 0 ? "+" : ""}${Number(transaction.delta).toLocaleString("en-US")}`;
      row.append(copy, amount);
      transactionList.append(row);
    }
    if (!transactionList.childElementCount) {
      const empty = document.createElement("li");
      empty.className = "credit-empty";
      empty.textContent = "No credit transactions yet.";
      transactionList.append(empty);
    }
  }

  function applyCreditPayload(payload) {
    prices = new Map((payload.prices || []).map((item) => [item.pluginId, item.priceCredits]));
    if (balanceNode) balanceNode.textContent = creditsText(payload.balance);
    renderCreditPacks(payload.packs);
    renderCreditTransactions(payload.transactions);
    renderPluginCreditActions();
  }

  async function loadCredits() {
    if (!balanceNode || accountPanel?.hidden) return;
    setCreditStatus("Loading credit wallet…");
    try {
      applyCreditPayload(await creditApi("/api/credits"));
      setCreditStatus("Credits are added only after verified payment confirmation.");
    } catch (error) {
      if (error.status !== 401) setCreditStatus(error.message, true);
    }
  }

  async function loadCreditCatalog() {
    try {
      const [catalogResponse, priceResponse] = await Promise.all([
        fetch("/plugins.json", { cache: "no-store" }),
        fetch("/api/credits/prices", { cache: "no-store", credentials: "same-origin" })
      ]);
      const catalog = catalogResponse.ok ? await catalogResponse.json() : {};
      const pricePayload = priceResponse.ok ? await priceResponse.json() : {};
      catalogPlugins = Array.isArray(catalog.plugins) ? catalog.plugins : [];
      if (Array.isArray(pricePayload.prices)) {
        prices = new Map(pricePayload.prices.map((item) => [item.pluginId, item.priceCredits]));
      }
      renderPluginCreditActions();
    } catch (error) {
      console.error("Unable to load credit prices", error);
    }
  }

  function configurePurchaseButton(button, plugin, priceCredits, owned) {
    button.type = "button";
    button.className = "button button-primary";
    button.disabled = owned;
    button.textContent = owned ? "Owned" : accountData ? "Buy with credits" : "Sign in to buy";
    button.onclick = async () => {
      if (!accountData) {
        document.querySelector("#sign-in-button")?.click();
        return;
      }
      if (!window.confirm(`Purchase ${plugin.descriptor.name} for ${creditsText(priceCredits)}?`)) return;
      button.disabled = true;
      button.textContent = "Purchasing…";
      try {
        await creditApi("/api/credits/purchase", {
          method: "POST", body: JSON.stringify({ pluginId: plugin.id })
        });
        setCreditStatus(`${plugin.descriptor.name} was added to your account.`);
        await loadCredits();
        if (typeof loadAccount === "function") await loadAccount();
      } catch (error) {
        setCreditStatus(error.message, true);
        button.disabled = false;
        button.textContent = "Buy with credits";
      }
    };
  }

  function renderPluginCreditActions() {
    if (!pluginGrid) return;
    for (const card of pluginGrid.querySelectorAll(".plugin-card")) {
      const title = card.querySelector("h3")?.textContent?.trim();
      const plugin = catalogPlugins.find((item) => item.descriptor?.name === title);
      const accessType = plugin?.type || plugin?.access;
      const priceCredits = plugin ? prices.get(plugin.id) : null;
      let actions = card.querySelector(".plugin-credit-actions");

      if (!plugin || !["Premium", "Supporter"].includes(accessType)
          || !Number.isInteger(priceCredits) || priceCredits < 1) {
        actions?.remove();
        continue;
      }

      if (!actions) {
        actions = document.createElement("div");
        actions.className = "plugin-credit-actions";
        actions.append(document.createElement("strong"), document.createElement("button"));
        card.append(actions);
      }

      const price = actions.querySelector("strong");
      const button = actions.querySelector("button");
      price.textContent = creditsText(priceCredits);
      configurePurchaseButton(button, plugin, priceCredits, Boolean(card.querySelector(".access-owned")));
    }
  }

  if (typeof renderPlugins === "function") {
    const originalRenderPlugins = renderPlugins;
    renderPlugins = function renderPluginsWithCredits() {
      originalRenderPlugins();
      renderPluginCreditActions();
    };
  }

  if (typeof renderAccount === "function") {
    const original = renderAccount;
    renderAccount = function renderAccountWithCredits(payload) {
      original(payload);
      accountData = payload;
      setTimeout(loadCredits, 0);
      setTimeout(renderPluginCreditActions, 0);
    };
  }
  if (typeof renderSignedOut === "function") {
    const original = renderSignedOut;
    renderSignedOut = function renderSignedOutWithCredits() {
      original();
      accountData = null;
      if (balanceNode) balanceNode.textContent = "0 credits";
      renderPluginCreditActions();
    };
  }

  const paymentState = new URLSearchParams(window.location.search).get("credits");
  if (paymentState) {
    history.replaceState({}, "", `${window.location.pathname}#account`);
    setCreditStatus("Payment completed. Your balance updates after secure verification.");
  }
  loadCreditCatalog();
  if (accountPanel && !accountPanel.hidden) loadCredits();
})();
