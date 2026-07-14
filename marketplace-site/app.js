const pluginGrid = document.querySelector("#plugin-grid");
const catalogStatus = document.querySelector("#catalog-status");
const searchInput = document.querySelector("#plugin-search");

let plugins = [];

function renderPlugins(query = "") {
  const normalizedQuery = query.trim().toLowerCase();
  const visiblePlugins = plugins.filter((plugin) => {
    const searchable = `${plugin.name} ${plugin.author} ${plugin.description}`.toLowerCase();
    return searchable.includes(normalizedQuery);
  });

  pluginGrid.replaceChildren();

  if (visiblePlugins.length === 0) {
    catalogStatus.hidden = false;
    catalogStatus.textContent = plugins.length === 0
      ? "The catalog is ready. Reviewed plugins will appear here when published."
      : "No plugins match your search.";
    return;
  }

  catalogStatus.hidden = true;

  for (const plugin of visiblePlugins) {
    const card = document.createElement("article");
    card.className = "plugin-card";

    const header = document.createElement("div");
    header.className = "plugin-header";

    const icon = document.createElement("img");
    icon.className = "plugin-icon";
    icon.src = plugin.iconPath || "assets/klite-marketplace.png";
    icon.alt = plugin.name + " icon";
    icon.width = 64;
    icon.height = 64;
    icon.loading = "lazy";

    const copy = document.createElement("div");
    copy.className = "plugin-copy";

    const title = document.createElement("h3");
    title.textContent = plugin.name;

    const description = document.createElement("p");
    description.textContent = plugin.description;

    copy.append(title, description);
    header.append(icon, copy);

    const meta = document.createElement("div");
    meta.className = "plugin-meta";

    const author = document.createElement("span");
    author.textContent = `By ${plugin.author}`;

    const version = document.createElement("span");
    version.textContent = `v${plugin.version}`;

    const status = document.createElement("span");
    status.textContent = plugin.status === "bundled" ? "Bundled with KLite" : plugin.status;

    meta.append(author, version, status);
    card.append(header, meta);
    pluginGrid.append(card);
  }
}

async function loadCatalog() {
  try {
    const response = await fetch("plugins.json", { cache: "no-store" });
    if (!response.ok) {
      throw new Error(`Catalog request failed with status ${response.status}`);
    }

    const catalog = await response.json();
    plugins = Array.isArray(catalog.plugins) ? catalog.plugins : [];
    renderPlugins();
  } catch (error) {
    console.error("Unable to load the plugin catalog", error);
    catalogStatus.textContent = "The plugin catalog is temporarily unavailable.";
  }
}

searchInput.addEventListener("input", (event) => renderPlugins(event.target.value));
loadCatalog();
