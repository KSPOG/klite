(() => {
  const list = document.querySelector("#featured-plugin-list");
  if (!list) return;

  function message(value) {
    list.replaceChildren();
    const item = document.createElement("p");
    item.className = "featured-plugin-message";
    item.textContent = value;
    list.append(item);
  }

  function cardFor(plugin) {
    const descriptor = plugin.descriptor || {};
    const card = document.createElement("button");
    card.type = "button";
    card.className = "plugin-sample";
    card.addEventListener("click", () => { window.location.hash = "marketplace"; });

    const icon = document.createElement("img");
    icon.className = "plugin-sample-icon";
    icon.src = plugin.iconPath || "assets/klite-marketplace.png";
    icon.alt = "";
    icon.width = 44;
    icon.height = 44;

    const title = document.createElement("strong");
    title.textContent = descriptor.name || plugin.id || "Published plugin";

    const category = document.createElement("small");
    category.textContent = Array.isArray(plugin.categories) && plugin.categories.length
      ? plugin.categories.join(" · ") : "Marketplace plugin";

    const description = document.createElement("p");
    description.className = "plugin-sample-description";
    description.textContent = descriptor.description || "Published through the KLite marketplace.";

    const footer = document.createElement("footer");
    const version = document.createElement("span");
    version.textContent = descriptor.version ? "v" + descriptor.version : "Published";
    const access = document.createElement("b");
    access.textContent = plugin.type || plugin.access || "Available";
    footer.append(version, access);

    card.append(icon, title, category, description, footer);
    return card;
  }

  async function load() {
    message("Loading published marketplace plugins…");
    try {
      const response = await fetch("/plugins.json", { cache: "no-store" });
      if (!response.ok) throw new Error("Catalog request failed");
      const catalog = await response.json();
      const plugins = Array.isArray(catalog.plugins) ? catalog.plugins : [];
      const published = plugins
        .filter((plugin) => plugin.status === "available" || plugin.status === "bundled")
        .sort((left, right) => String(right.updatedAt || "").localeCompare(String(left.updatedAt || "")))
        .slice(0, 4);

      list.replaceChildren();
      if (!published.length) {
        message("No published plugins are available yet.");
        return;
      }
      published.forEach((plugin) => list.append(cardFor(plugin)));
    } catch (error) {
      console.error("Unable to load homepage plugins", error);
      message("Published plugins could not be loaded.");
    }
  }

  load();
})();
