const expandAll = document.querySelector("#api-expand-all");
const collapseAll = document.querySelector("#api-collapse-all");
const resetFilters = document.querySelector("#api-reset-filters");
const searchInput = document.querySelector("#api-search");
const sectionFilter = document.querySelector("#api-section-filter");
const kindFilter = document.querySelector("#api-kind-filter");
const methodsOnly = document.querySelector("#api-methods-only");
const content = document.querySelector("#api-content");

function visibleTypes() {
  return [...(content?.querySelectorAll("details.api-type") || [])];
}

expandAll?.addEventListener("click", () => {
  for (const details of visibleTypes()) details.open = true;
});

collapseAll?.addEventListener("click", () => {
  for (const details of visibleTypes()) details.open = false;
});

resetFilters?.addEventListener("click", () => {
  searchInput.value = "";
  sectionFilter.value = "Client API";
  kindFilter.value = "";
  methodsOnly.checked = true;

  searchInput.dispatchEvent(new Event("input", { bubbles: true }));
  sectionFilter.dispatchEvent(new Event("change", { bubbles: true }));
  kindFilter.dispatchEvent(new Event("change", { bubbles: true }));
  methodsOnly.dispatchEvent(new Event("change", { bubbles: true }));
  searchInput.focus();
});
