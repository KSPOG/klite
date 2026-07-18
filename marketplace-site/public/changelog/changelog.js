(() => {
  const buttons = [...document.querySelectorAll("[data-changelog-filter]")];
  const entries = [...document.querySelectorAll("[data-changelog-category]")];
  const empty = document.querySelector("#changelog-empty");

  function applyFilter(category, updateUrl = true) {
    const selected = buttons.some((button) => button.dataset.changelogFilter === category) ? category : "all";
    let visible = 0;
    for (const entry of entries) {
      const categories = entry.dataset.changelogCategory.split(/\s+/);
      entry.hidden = selected !== "all" && !categories.includes(selected);
      if (!entry.hidden) visible += 1;
    }
    for (const button of buttons) {
      const active = button.dataset.changelogFilter === selected;
      button.classList.toggle("is-active", active);
      button.setAttribute("aria-pressed", String(active));
    }
    if (empty) empty.hidden = visible !== 0;
    if (updateUrl) {
      const url = new URL(window.location.href);
      if (selected === "all") url.searchParams.delete("category");
      else url.searchParams.set("category", selected);
      history.replaceState({}, "", url);
    }
  }

  for (const button of buttons) {
    button.addEventListener("click", () => applyFilter(button.dataset.changelogFilter));
  }

  applyFilter(new URLSearchParams(window.location.search).get("category") || "all", false);
})();
