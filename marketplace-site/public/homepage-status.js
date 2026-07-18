(() => {
  const rows = [...document.querySelectorAll("[data-status-endpoint]")];
  const overall = document.querySelector("#status-overall");
  const refresh = document.querySelector("#refresh-status-button");
  const statusNavigation = document.querySelector("#status-navigation-button");
  const version = document.querySelector("#release-version");
  const published = document.querySelector("#release-published");

  async function checkEndpoint(row) {
    const label = row.querySelector("b");
    label.textContent = "Checking";
    label.className = "is-checking";
    try {
      const response = await fetch(row.dataset.statusEndpoint, { cache: "no-store" });
      if (!response.ok) throw new Error(`HTTP ${response.status}`);
      label.textContent = "Operational";
      label.className = "is-operational";
      return true;
    } catch (error) {
      console.warn(`KLite status check failed for ${row.dataset.statusEndpoint}`, error);
      label.textContent = "Unavailable";
      label.className = "is-unavailable";
      return false;
    }
  }

  async function refreshStatus() {
    if (!overall || !refresh) return;
    refresh.disabled = true;
    overall.textContent = "Checking KLite services...";
    const results = await Promise.all(rows.map(checkEndpoint));
    const healthy = results.filter(Boolean).length;
    overall.textContent = healthy === rows.length
      ? "All checked systems operational"
      : `${healthy} of ${rows.length} checked systems operational`;
    overall.classList.toggle("has-errors", healthy !== rows.length);
    refresh.disabled = false;
  }

  async function loadRelease() {
    try {
      const response = await fetch("/client/windows/latest.json", { cache: "no-store" });
      if (!response.ok) return;
      const manifest = await response.json();
      if (manifest.version && version) version.textContent = `v${manifest.version}`;
      if (manifest.publishedAt && published) {
        const date = new Date(manifest.publishedAt);
        published.textContent = `Published ${new Intl.DateTimeFormat(undefined, { dateStyle: "medium" }).format(date)}`;
      }
    } catch (error) {
      console.warn("Unable to load the Windows release manifest", error);
    }
  }

  refresh?.addEventListener("click", refreshStatus);
  statusNavigation?.addEventListener("click", () => {
    window.location.hash = "home";
    window.setTimeout(() => document.querySelector("#release-status")?.scrollIntoView({ behavior: "smooth", block: "center" }), 0);
  });

  refreshStatus();
  loadRelease();
})();
