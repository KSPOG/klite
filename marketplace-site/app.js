const pluginGrid = document.querySelector("#plugin-grid");
const catalogStatus = document.querySelector("#catalog-status");
const searchInput = document.querySelector("#plugin-search");
const categoryFilter = document.querySelector("#category-filter");
const accessFilter = document.querySelector("#access-filter");

const statusLabels = {
  bundled: "Bundled with KLite",
  available: "Available",
  "coming-soon": "Coming soon"
};

let plugins = [];

function renderPlugins() {
  const query = searchInput.value.trim().toLowerCase();
  const selectedCategory = categoryFilter.value;
  const selectedAccess = accessFilter.value;
  const visiblePlugins = plugins.filter((plugin) => {
    const descriptor = plugin.descriptor;
    const searchable = [
      descriptor.name,
      descriptor.description,
      ...descriptor.tags,
      ...descriptor.authors,
      ...plugin.categories,
      plugin.access
    ].join(" ").toLowerCase();

    return searchable.includes(query)
      && (!selectedCategory || plugin.categories.includes(selectedCategory))
      && (!selectedAccess || plugin.access === selectedAccess);
  });

  pluginGrid.replaceChildren();

  if (visiblePlugins.length === 0) {
    catalogStatus.hidden = false;
    catalogStatus.textContent = plugins.length === 0
      ? "The catalog is ready. Reviewed plugins will appear here when published."
      : "No plugins match the selected filters.";
    return;
  }

  catalogStatus.hidden = true;

  for (const plugin of visiblePlugins) {
    const descriptor = plugin.descriptor;
    const card = document.createElement("article");
    card.className = "plugin-card";

    const header = document.createElement("div");
    header.className = "plugin-header";

    const icon = document.createElement("img");
    icon.className = "plugin-icon";
    icon.src = plugin.iconPath || "assets/klite-marketplace.png";
    icon.alt = descriptor.name + " icon";
    icon.width = 64;
    icon.height = 64;
    icon.loading = "lazy";

    const copy = document.createElement("div");
    copy.className = "plugin-copy";

    const title = document.createElement("h3");
    title.textContent = descriptor.name;

    const description = document.createElement("p");
    description.textContent = descriptor.description;

    copy.append(title, description);
    header.append(icon, copy);

    const meta = document.createElement("div");
    meta.className = "plugin-meta";
    const metadata = [
      `By ${descriptor.authors.join(", ")}`,
      `v${descriptor.version}`,
      plugin.access,
      ...plugin.categories,
      statusLabels[plugin.status] || "Unavailable"
    ];

    for (const value of metadata) {
      const item = document.createElement("span");
      item.textContent = value;
      meta.append(item);
    }

    card.append(header, meta);
    pluginGrid.append(card);
  }
}

function populateCategoryFilter() {
  const categories = [...new Set(plugins.flatMap((plugin) => plugin.categories))]
    .sort((left, right) => left.localeCompare(right));

  categoryFilter.replaceChildren();
  const allCategories = document.createElement("option");
  allCategories.value = "";
  allCategories.textContent = "All categories";
  categoryFilter.append(allCategories);

  for (const category of categories) {
    const option = document.createElement("option");
    option.value = category;
    option.textContent = category;
    categoryFilter.append(option);
  }
}

async function loadCatalog() {
  try {
    const response = await fetch("plugins.json", { cache: "no-store" });
    if (!response.ok) {
      throw new Error(`Catalog request failed with status ${response.status}`);
    }

    const catalog = await response.json();
    if (catalog.schemaVersion !== 2 || !Array.isArray(catalog.plugins)) {
      throw new Error("Unsupported marketplace catalog schema");
    }

    plugins = catalog.plugins;
    populateCategoryFilter();
    renderPlugins();
  } catch (error) {
    console.error("Unable to load the plugin catalog", error);
    catalogStatus.textContent = "The plugin catalog is temporarily unavailable.";
  }
}

searchInput.addEventListener("input", renderPlugins);
categoryFilter.addEventListener("change", renderPlugins);
accessFilter.addEventListener("change", renderPlugins);
loadCatalog();
