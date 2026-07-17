const apiAreaTabs = [...document.querySelectorAll("[data-api-tab]")];
const apiAreaCards = [...document.querySelectorAll("[data-api-area]")];
const apiSectionFilter = document.querySelector("#api-section-filter");
const apiMethodsOnly = document.querySelector("#api-methods-only");
const apiReferenceBrowser = document.querySelector("#reference-browser");

function setActiveApiArea(area, { scroll = false } = {}) {
  if (!apiSectionFilter) return;

  const hasOption = [...apiSectionFilter.options].some((option) => option.value === area);
  if (area && !hasOption) return;

  apiSectionFilter.value = area;
  apiSectionFilter.dispatchEvent(new Event("change", { bubbles: true }));
  updateApiTabs(area);

  if (scroll) {
    apiReferenceBrowser?.scrollIntoView({ behavior: "smooth", block: "start" });
  }
}

function updateApiTabs(area) {
  for (const tab of apiAreaTabs) {
    const active = tab.dataset.apiTab === area;
    tab.classList.toggle("is-active", active);
    tab.setAttribute("aria-pressed", String(active));
  }
}

function initializeFocusedReference() {
  if (!apiSectionFilter || apiSectionFilter.options.length < 2) return false;

  if (apiMethodsOnly) {
    apiMethodsOnly.checked = true;
  }
  setActiveApiArea("Client API");
  return true;
}

for (const tab of apiAreaTabs) {
  tab.addEventListener("click", () => {
    setActiveApiArea(tab.dataset.apiTab || "");
  });
}

for (const card of apiAreaCards) {
  card.addEventListener("click", () => {
    setActiveApiArea(card.dataset.apiArea || "", { scroll: true });
  });
}

apiSectionFilter?.addEventListener("change", () => {
  updateApiTabs(apiSectionFilter.value);
});

if (!initializeFocusedReference() && apiSectionFilter) {
  const observer = new MutationObserver(() => {
    if (initializeFocusedReference()) {
      observer.disconnect();
    }
  });
  observer.observe(apiSectionFilter, { childList: true });
}
