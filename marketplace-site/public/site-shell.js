const siteRouteDefinitions = {
  home: {
    label: "Home",
    eyebrow: "KLite desktop client",
    title: "KLite for Windows",
    description: "Preview the client and explore its core features while the Windows release is under construction.",
    subcategories: [
      { label: "Overview", target: "hero-title" },
      { label: "Client previews", target: "client-showcase" },
      { label: "Download", target: "download-card" }
    ]
  },
  marketplace: {
    label: "Marketplace",
    eyebrow: "Reviewed extensions",
    title: "Plugin marketplace",
    description: "Browse available plugins without mixing account, developer, Discord, or review controls into the catalog.",
    subcategories: [
      { label: "Browse plugins", target: "catalog-title" },
      { label: "Search and filters", target: "plugin-search" },
      { label: "Plugin categories", target: "category-filter" },
      { label: "Access types", target: "type-filter" }
    ]
  },
  developer: {
    label: "Developers",
    eyebrow: "Plugin development",
    title: "Developer workspace",
    description: "Submit plugins, review your submission history, and open the dedicated KLite API reference.",
    subcategories: [
      { label: "Submit a plugin", target: "submission-form" },
      { label: "Submission history", target: "submission-list" },
      { label: "API reference", href: "/api/" }
    ]
  },
  community: {
    label: "Community",
    eyebrow: "Discord integration",
    title: "Discord bot control center",
    description: "Install the bot, configure roles and channels, register commands, and manage marketplace announcements.",
    subcategories: [
      { label: "Installation", target: "discord-bootstrap-slot" },
      { label: "Roles and channels", target: "discord-bot-settings-form" },
      { label: "Commands", target: "discord-command-list" },
      { label: "Announcements", target: "announcement-history" }
    ]
  },
  account: {
    label: "Account",
    eyebrow: "KLite membership",
    title: "Account and access",
    description: "Manage marketplace membership, Discord linking, paid-plugin entitlements, and account recovery.",
    subcategories: [
      { label: "Membership", target: "account-title" },
      { label: "Discord linking", target: "discord-status" },
      { label: "Entitlements", target: "entitlement-count" }
    ]
  },
  admin: {
    label: "Administration",
    eyebrow: "Owner and reviewer tools",
    title: "Marketplace administration",
    description: "Appoint plugin developers and reviewers, then process the plugin approval queue from a focused administration area.",
    subcategories: [
      { label: "Staff access", target: "owner-admin-dashboard" },
      { label: "Plugin reviews", target: "review-dashboard" }
    ]
  }
};

const routePanels = [...document.querySelectorAll("[data-site-section]")];
const primaryRouteButtons = [...document.querySelectorAll("[data-site-route]")];
const workspaceHeading = document.querySelector("#workspace-heading");
const workspaceEyebrow = document.querySelector("#workspace-eyebrow");
const workspaceTitle = document.querySelector("#workspace-title");
const workspaceDescription = document.querySelector("#workspace-description");
const secondarySiteNav = document.querySelector("#secondary-site-nav");
const routeEmpty = document.querySelector("#route-empty");
const routeEmptyTitle = document.querySelector("#route-empty-title");
const routeEmptyDescription = document.querySelector("#route-empty-description");
const routeEmptyAction = document.querySelector("#route-empty-action");
let currentSiteRoute = "home";
let shellUpdatePending = false;

function requestedSiteRoute() {
  const raw = window.location.hash.replace(/^#/, "").trim().toLowerCase();
  if (raw.startsWith("reset-")) return "home";
  return Object.hasOwn(siteRouteDefinitions, raw) ? raw : "home";
}

function routeAvailable(route) {
  if (["home", "marketplace", "account"].includes(route)) return true;
  if (route === "developer") return !document.querySelector("#developer-dashboard")?.hidden;
  if (route === "community") return !document.querySelector("#discord-bot-dashboard")?.hidden;
  if (route === "admin") {
    const owner = document.querySelector("#owner-admin-dashboard");
    const review = document.querySelector("#review-dashboard");
    return Boolean((owner && !owner.hidden) || (review && !review.hidden));
  }
  return false;
}

function updatePrivilegedNavigation() {
  for (const button of primaryRouteButtons) {
    const route = button.dataset.siteRoute;
    if (["developer", "community", "admin"].includes(route)) {
      button.hidden = !routeAvailable(route);
    }
  }
}

function assignDynamicPanels() {
  const ownerDashboard = document.querySelector("#owner-admin-dashboard");
  if (ownerDashboard && !ownerDashboard.dataset.siteSection) {
    ownerDashboard.dataset.siteSection = "admin";
    ownerDashboard.classList.add("site-route-panel");
    routePanels.push(ownerDashboard);
  }
}

function renderSecondaryNavigation(route) {
  secondarySiteNav.replaceChildren();
  for (const item of siteRouteDefinitions[route].subcategories) {
    if (item.href) {
      const link = document.createElement("a");
      link.href = item.href;
      link.textContent = item.label;
      secondarySiteNav.append(link);
      continue;
    }
    const button = document.createElement("button");
    button.type = "button";
    button.textContent = item.label;
    button.addEventListener("click", () => scrollToSiteTarget(item.target));
    secondarySiteNav.append(button);
  }
}

function scrollToSiteTarget(id) {
  const target = document.getElementById(id);
  if (!target || target.hidden || target.closest(".route-inactive")) return;
  target.scrollIntoView({ behavior: "smooth", block: "start" });
}

function activeVisiblePanels(route) {
  return routePanels.filter((panel) => panel.dataset.siteSection === route
    && !panel.hidden
    && !panel.classList.contains("route-inactive"));
}

function renderRouteEmpty(route) {
  if (route === "home" || route === "marketplace" || activeVisiblePanels(route).length > 0) {
    routeEmpty.hidden = true;
    return;
  }

  routeEmpty.hidden = false;
  if (route === "account") {
    routeEmptyTitle.textContent = "Sign in to open your account";
    routeEmptyDescription.textContent = "Your membership, Discord link, and plugin entitlements appear here after signing in.";
    routeEmptyAction.hidden = false;
    routeEmptyAction.textContent = "Sign in";
    routeEmptyAction.onclick = () => document.querySelector("#sign-in-button")?.click();
  } else {
    routeEmptyTitle.textContent = "This category requires additional access";
    routeEmptyDescription.textContent = "Sign in with an account that has the required developer, Discord administrator, owner, or reviewer capability.";
    routeEmptyAction.hidden = false;
    routeEmptyAction.textContent = "Open account";
    routeEmptyAction.onclick = () => setSiteRoute("account");
  }
}

function setSiteRoute(route, options = {}) {
  assignDynamicPanels();
  updatePrivilegedNavigation();
  const selected = Object.hasOwn(siteRouteDefinitions, route) ? route : "home";
  currentSiteRoute = selected;

  for (const panel of routePanels) {
    panel.classList.toggle("route-inactive", panel.dataset.siteSection !== selected);
  }
  for (const button of primaryRouteButtons) {
    button.classList.toggle("is-active", button.dataset.siteRoute === selected);
    button.setAttribute("aria-current", button.dataset.siteRoute === selected ? "page" : "false");
  }

  const definition = siteRouteDefinitions[selected];
  const home = selected === "home";
  workspaceHeading.hidden = home;
  if (!home) {
    workspaceEyebrow.textContent = definition.eyebrow;
    workspaceTitle.textContent = definition.title;
    workspaceDescription.textContent = definition.description;
    renderSecondaryNavigation(selected);
  }
  renderRouteEmpty(selected);

  if (!options.preserveHash && window.location.hash !== `#${selected}`) {
    history.pushState({}, "", `${window.location.pathname}${window.location.search}#${selected}`);
  }
  if (!options.preserveScroll) window.scrollTo({ top: 0, behavior: "smooth" });
}

function createDownloadNoticeDialog() {
  const dialog = document.createElement("dialog");
  dialog.id = "download-notice-dialog";
  dialog.className = "auth-dialog";
  dialog.setAttribute("aria-labelledby", "download-notice-title");
  dialog.setAttribute("aria-describedby", "download-notice-description");
  dialog.innerHTML = `
    <div class="auth-form">
      <div class="dialog-heading">
        <div>
          <p class="eyebrow">Development notice</p>
          <h2 id="download-notice-title">KLite is under construction</h2>
        </div>
        <button class="dialog-close" type="button" aria-label="Close">&times;</button>
      </div>
      <p id="download-notice-description">The KLite client is currently under construction. Downloads will become available after the current development and testing work is complete.</p>
      <button class="button button-primary button-wide" type="button" data-download-notice-close>Got it</button>
    </div>`;

  const close = () => dialog.close();
  dialog.querySelector(".dialog-close")?.addEventListener("click", close);
  dialog.querySelector("[data-download-notice-close]")?.addEventListener("click", close);
  dialog.addEventListener("click", (event) => {
    if (event.target === dialog) close();
  });
  document.body.append(dialog);
  return dialog;
}

const downloadNoticeDialog = createDownloadNoticeDialog();
for (const link of document.querySelectorAll('a[href="/download/windows"], .download-button')) {
  link.addEventListener("click", (event) => {
    event.preventDefault();
    if (!downloadNoticeDialog.open) downloadNoticeDialog.showModal();
  });
}

for (const button of primaryRouteButtons) {
  button.addEventListener("click", () => setSiteRoute(button.dataset.siteRoute));
}

document.querySelector("#explore-marketplace-button")?.addEventListener("click", () => setSiteRoute("marketplace"));
document.querySelector("#footer-marketplace-link")?.addEventListener("click", (event) => {
  event.preventDefault();
  setSiteRoute("marketplace");
});
document.querySelector("#account-menu-account")?.addEventListener("click", () => setSiteRoute("account"), true);

window.addEventListener("hashchange", () => setSiteRoute(requestedSiteRoute(), {
  preserveHash: true,
  preserveScroll: false
}));

function scheduleShellUpdate() {
  if (shellUpdatePending) return;
  shellUpdatePending = true;
  window.requestAnimationFrame(() => {
    shellUpdatePending = false;
    assignDynamicPanels();
    updatePrivilegedNavigation();
    for (const panel of routePanels) {
      panel.classList.toggle("route-inactive", panel.dataset.siteSection !== currentSiteRoute);
    }
    renderRouteEmpty(currentSiteRoute);
  });
}

new MutationObserver(scheduleShellUpdate).observe(document.body, {
  subtree: true,
  childList: true,
  attributes: true,
  attributeFilter: ["hidden"]
});

setSiteRoute(requestedSiteRoute(), { preserveHash: true, preserveScroll: true });
