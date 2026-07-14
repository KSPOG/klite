const pluginGrid = document.querySelector("#plugin-grid");
const catalogStatus = document.querySelector("#catalog-status");
const searchInput = document.querySelector("#plugin-search");
const categoryFilter = document.querySelector("#category-filter");
const typeFilter = document.querySelector("#type-filter");
const orderFilter = document.querySelector("#order-filter");

const statusLabels = {
  bundled: "Bundled with KLite",
  available: "Available",
  "coming-soon": "Coming soon"
};

const orderComparators = {
  "trending-day": (left, right) => right.trendingDay - left.trendingDay,
  "trending-week": (left, right) => right.trendingWeek - left.trendingWeek,
  "trending-month": (left, right) => right.trendingMonth - left.trendingMonth,
  "recently-updated": (left, right) => right.updatedAt.localeCompare(left.updatedAt),
  "recently-released": (left, right) => right.releasedAt.localeCompare(left.releasedAt),
  name: (left, right) => left.descriptor.name.localeCompare(right.descriptor.name)
};

let plugins = [];

function comparePlugins(left, right) {
  const comparator = orderComparators[orderFilter.value] || orderComparators["trending-day"];
  return comparator(left, right)
    || left.descriptor.name.localeCompare(right.descriptor.name);
}

function renderPlugins() {
  const query = searchInput.value.trim().toLowerCase();
  const selectedCategory = categoryFilter.value;
  const selectedType = typeFilter.value;
  const visiblePlugins = plugins.filter((plugin) => {
    const descriptor = plugin.descriptor;
    const searchable = [
      descriptor.name,
      descriptor.description,
      ...descriptor.tags,
      ...descriptor.authors,
      ...plugin.categories,
      plugin.type || plugin.access
    ].join(" ").toLowerCase();

    return searchable.includes(query)
      && (!selectedCategory || plugin.categories.includes(selectedCategory))
      && (!selectedType || (plugin.type || plugin.access) === selectedType);
  }).sort(comparePlugins);

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
      "By " + descriptor.authors.join(", "),
      "v" + descriptor.version,
      plugin.type || plugin.access,
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

function populateFilter(select, values) {
  select.replaceChildren();
  const all = document.createElement("option");
  all.value = "";
  all.textContent = "All";
  select.append(all);

  for (const value of values) {
    const option = document.createElement("option");
    option.value = value;
    option.textContent = value;
    select.append(option);
  }
}

async function loadCatalog() {
  try {
    const response = await fetch("plugins.json", { cache: "no-store" });
    if (!response.ok) {
      throw new Error("Catalog request failed with status " + response.status);
    }

    const catalog = await response.json();
    if (![2, 3].includes(catalog.schemaVersion) || !Array.isArray(catalog.plugins)
      || !Array.isArray(catalog.categories) || !Array.isArray(catalog.types)) {
      throw new Error("Unsupported marketplace catalog schema");
    }

    plugins = catalog.plugins;
    populateFilter(categoryFilter, catalog.categories);
    populateFilter(typeFilter, catalog.types);
    renderPlugins();
  } catch (error) {
    console.error("Unable to load the plugin catalog", error);
    catalogStatus.textContent = "The plugin catalog is temporarily unavailable.";
  }
}

searchInput.addEventListener("input", renderPlugins);
categoryFilter.addEventListener("change", renderPlugins);
typeFilter.addEventListener("change", renderPlugins);
orderFilter.addEventListener("change", renderPlugins);
loadCatalog();
