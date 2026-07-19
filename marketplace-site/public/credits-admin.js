(() => {
  let panel = null;
  let installing = false;

  async function api(path, options = {}) {
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

  async function load() {
    if (!panel) return;
    const status = panel.querySelector("#credit-admin-status");
    const refresh = panel.querySelector("#credit-admin-refresh");
    status.textContent = "Loading credit administration…";
    if (refresh) refresh.disabled = true;
    try {
      const payload = await api("/api/credits/admin");
      renderPrices(payload.prices || []);
      renderTransactions(payload.transactions || []);
      status.textContent = `${payload.transactions?.length || 0} recent transaction${payload.transactions?.length === 1 ? "" : "s"}.`;
    } catch (error) {
      status.textContent = error.status === 403
        ? "KLite owner access was not accepted by the credit administration endpoint."
        : error.message;
      status.classList.add("is-error");
    } finally {
      if (refresh) refresh.disabled = false;
    }
  }

  function renderPrices(prices) {
    const node = panel.querySelector("#credit-admin-prices");
    node.replaceChildren();
    for (const price of prices) {
      const row = document.createElement("button");
      row.type = "button";
      row.className = "credit-admin-row";
      const title = document.createElement("strong");
      title.textContent = price.pluginId;
      const detail = document.createElement("span");
      detail.textContent = `${creditsText(price.priceCredits)} · ${price.active ? "Active" : "Disabled"}`;
      row.append(title, detail);
      row.addEventListener("click", () => {
        panel.querySelector("#credit-price-plugin").value = price.pluginId;
        panel.querySelector("#credit-price-amount").value = price.priceCredits;
        panel.querySelector("#credit-price-active").checked = price.active;
      });
      node.append(row);
    }
    if (!node.childElementCount) node.textContent = "No premium plugin prices configured.";
  }

  function renderTransactions(transactions) {
    const node = panel.querySelector("#credit-admin-transactions");
    node.replaceChildren();
    for (const transaction of transactions) {
      const row = document.createElement("div");
      row.className = "credit-admin-row";
      const title = document.createElement("strong");
      title.textContent = transaction.username || transaction.userId;
      const detail = document.createElement("span");
      detail.textContent = `${transaction.delta > 0 ? "+" : ""}${Number(transaction.delta).toLocaleString("en-US")} · ${transaction.description}`;
      row.append(title, detail);
      node.append(row);
    }
    if (!node.childElementCount) node.textContent = "No credit transactions yet.";
  }

  async function install() {
    if (panel || installing) return;
    const owner = document.querySelector("#owner-admin-dashboard");
    if (!owner) return;
    installing = true;
    panel = document.createElement("section");
    panel.id = "credit-admin-panel";
    panel.className = "credit-admin-panel";

    const heading = document.createElement("div");
    heading.className = "credit-admin-heading";
    const copy = document.createElement("div");
    const eyebrow = document.createElement("p");
    eyebrow.className = "eyebrow";
    eyebrow.textContent = "Marketplace currency";
    const title = document.createElement("h3");
    title.textContent = "Credit prices and ledger";
    copy.append(eyebrow, title);
    const refresh = document.createElement("button");
    refresh.id = "credit-admin-refresh";
    refresh.type = "button";
    refresh.className = "button button-secondary";
    refresh.textContent = "Refresh";
    refresh.addEventListener("click", load);
    heading.append(copy, refresh);

    const form = document.createElement("form");
    form.id = "credit-price-form";
    form.className = "credit-price-form";
    form.innerHTML = "<label><span>Plugin ID</span><input id=\"credit-price-plugin\" pattern=\"[a-z0-9][a-z0-9-]{2,63}\" required></label><label><span>Price in credits</span><input id=\"credit-price-amount\" type=\"number\" min=\"1\" step=\"1\" required></label><label class=\"credit-active-field\"><input id=\"credit-price-active\" type=\"checkbox\" checked><span>Available for purchase</span></label><button class=\"button button-primary\" type=\"submit\">Save price</button>";

    const status = document.createElement("p");
    status.id = "credit-admin-status";
    status.className = "account-note";
    const columns = document.createElement("div");
    columns.className = "credit-admin-columns";
    const pricesColumn = document.createElement("div");
    const pricesTitle = document.createElement("h4");
    pricesTitle.textContent = "Plugin prices";
    const pricesNode = document.createElement("div");
    pricesNode.id = "credit-admin-prices";
    pricesColumn.append(pricesTitle, pricesNode);
    const transactionsColumn = document.createElement("div");
    const transactionsTitle = document.createElement("h4");
    transactionsTitle.textContent = "Recent transactions";
    const transactionsNode = document.createElement("div");
    transactionsNode.id = "credit-admin-transactions";
    transactionsColumn.append(transactionsTitle, transactionsNode);
    columns.append(pricesColumn, transactionsColumn);
    panel.append(heading, form, status, columns);
    owner.append(panel);

    form.addEventListener("submit", async (event) => {
      event.preventDefault();
      const submit = form.querySelector("button[type='submit']");
      const pluginId = panel.querySelector("#credit-price-plugin").value.trim().toLowerCase();
      const priceCredits = Number(panel.querySelector("#credit-price-amount").value);
      const active = panel.querySelector("#credit-price-active").checked;
      status.textContent = "Saving credit price…";
      submit.disabled = true;
      try {
        await api(`/api/credits/admin/prices/${encodeURIComponent(pluginId)}`, {
          method: "PUT",
          body: JSON.stringify({ priceCredits, active })
        });
        status.classList.remove("is-error");
        status.textContent = "Plugin credit price saved.";
        await load();
      } catch (error) {
        status.classList.add("is-error");
        status.textContent = error.message;
      } finally {
        submit.disabled = false;
      }
    });

    installing = false;
    await load();
  }

  new MutationObserver(install).observe(document.body, { subtree: true, childList: true });
  install();
})();
