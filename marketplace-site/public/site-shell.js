const siteRouteDefinitions = {
  home: {
    eyebrow: "KLite desktop client",
    title: "KLite for Windows",
    description: "Download the released Windows client, preview its core features, and explore the reviewed KLite plugin marketplace.",
    subcategories: [
      { label: "Overview", target: "hero-title" },
      { label: "Client previews", target: "client-showcase" },
      { label: "Download", target: "download-card" }
    ]
  },
  marketplace: {
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
    eyebrow: "Plugin development",
    title: "Developer workspace",
    description: "Submit plugins, review your submission history, and open the KLite developer resources.",
    subcategories: [
      { label: "Submit a plugin", target: "submission-form" },
      { label: "Submission history", target: "submission-list" },
      { label: "API reference", href: "/api/" },
      { label: "Plugin documentation", href: "/docs/" }
    ]
  },
  community: {
    eyebrow: "Discord integration",
    title: "Discord bot control center",
    description: "Inspect live bot status, configure roles and channels, manage client updates and marketplace announcements, and review registered Discord resources.",
    subcategories: [
      { label: "Installation", target: "discord-bootstrap-slot" },
      { label: "Overview", target: "discord-bot-status-grid" },
      { label: "Roles and channels", target: "discord-bot-settings-form" },
      { label: "Client updates", target: "discord-client-update-history" },
      { label: "Marketplace announcements", target: "announcement-history" },
      { label: "Commands", target: "discord-command-list" },
      { label: "Server roles", target: "discord-role-list" },
      { label: "Server channels", target: "discord-channel-list" }
    ]
  },
  account: {
    eyebrow: "KLite membership",
    title: "Account and access",
    description: "Sign in with Discord to manage marketplace membership, paid-plugin entitlements, and account access.",
    subcategories: [
      { label: "Membership", target: "account-title" },
      { label: "Discord identity", target: "discord-status" },
      { label: "Entitlements", target: "entitlement-count" }
    ]
  },
  admin: {
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
let discordChannelInventorySignature = "";

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
  ensureDiscordChannelInventory();
}

function ensureDiscordChannelInventory() {
  const dashboard = document.querySelector("#discord-bot-dashboard");
  const detailGrid = dashboard?.querySelector(".bot-detail-grid");
  const statusGrid = dashboard?.querySelector("#discord-bot-status-grid");
  if (!dashboard || !detailGrid || !statusGrid) return;

  let channelCount = document.querySelector("#discord-channel-count");
  if (!channelCount) {
    const card = document.createElement("article");
    card.className = "account-card";
    card.innerHTML = '<span class="account-label">Server channels</span>'
      + '<strong id="discord-channel-count">0</strong>'
      + '<p class="account-note">Available Discord text and announcement channels</p>';
    statusGrid.append(card);
    channelCount = card.querySelector("#discord-channel-count");
  }

  let channelList = document.querySelector("#discord-channel-list");
  if (!channelList) {
    const section = document.createElement("section");
    section.className = "bot-detail-wide";
    section.style.gridColumn = "1 / -1";
    const heading = document.createElement("h3");
    heading.textContent = "Server channels";
    channelList = document.createElement("div");
    channelList.id = "discord-channel-list";
    channelList.className = "submission-list bot-scroll-list";
    section.append(heading, channelList);
    detailGrid.append(section);
  }

  syncDiscordChannelInventory(channelList, channelCount);
}

function syncDiscordChannelInventory(channelList, channelCount) {
  const selectDefinitions = [
    ["announcement-channel-id", "Marketplace announcements"],
    ["discord-audit-channel", "Audit log"],
    ["discord-welcome-channel", "Member welcome"],
    ["discord-client-update-channel", "Client updates"]
  ];
  const channels = new Map();
  for (const [selectId, usageLabel] of selectDefinitions) {
    const select = document.getElementById(selectId);
    if (!select) continue;
    for (const option of select.options) {
      if (!option.value) continue;
      const channel = channels.get(option.value) || { id: option.value, name: option.textContent, usages: [] };
      if (option.value === select.value) channel.usages.push(usageLabel);
      channels.set(option.value, channel);
    }
  }

  const entries = [...channels.values()].sort((left, right) => left.name.localeCompare(right.name));
  const signature = JSON.stringify(entries);
  if (signature === discordChannelInventorySignature) return;
  discordChannelInventorySignature = signature;
  channelCount.textContent = String(entries.length);
  channelList.replaceChildren();

  for (const channel of entries) {
    const card = document.createElement("article");
    card.className = "submission-card";
    const title = document.createElement("strong");
    title.textContent = `#${channel.name}`;
    const metadata = document.createElement("p");
    metadata.className = "submission-meta";
    metadata.textContent = `ID ${channel.id}`;
    card.append(title, metadata);
    if (channel.usages.length) {
      const usage = document.createElement("p");
      usage.className = "account-note";
      usage.textContent = `Configured for: ${channel.usages.join(", ")}`;
      card.append(usage);
    }
    channelList.append(card);
  }
  if (!entries.length) channelList.textContent = "No Discord channels are available.";
}

function applyRouteVisibility(panel, selectedRoute) {
  const inactive = panel.dataset.siteSection !== selectedRoute;
  panel.classList.toggle("route-inactive", inactive);
  panel.inert = inactive;
  if (inactive) {
    panel.style.setProperty("display", "none", "important");
    panel.setAttribute("aria-hidden", "true");
  } else {
    panel.style.removeProperty("display");
    panel.removeAttribute("aria-hidden");
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
    } else {
      const button = document.createElement("button");
      button.type = "button";
      button.textContent = item.label;
      button.addEventListener("click", () => scrollToSiteTarget(item.target));
      secondarySiteNav.append(button);
    }
  }
}

function scrollToSiteTarget(id) {
  const target = document.getElementById(id);
  if (!target || target.hidden || target.closest(".route-inactive")) return;
  target.scrollIntoView({ behavior: "smooth", block: "start" });
}

function activeVisiblePanels(route) {
  return routePanels.filter((panel) => panel.dataset.siteSection === route
    && !panel.hidden && !panel.classList.contains("route-inactive"));
}

function renderRouteEmpty(route) {
  if (route === "home" || route === "marketplace" || activeVisiblePanels(route).length > 0) {
    routeEmpty.hidden = true;
    return;
  }
  routeEmpty.hidden = false;
  if (route === "account") {
    routeEmptyTitle.textContent = "Sign in with Discord";
    routeEmptyDescription.textContent = "Your Discord identity, membership, and plugin entitlements appear here after signing in.";
    routeEmptyAction.textContent = "Continue with Discord";
    routeEmptyAction.onclick = () => document.querySelector("#sign-in-button")?.click();
  } else {
    routeEmptyTitle.textContent = "This category requires additional access";
    routeEmptyDescription.textContent = "Sign in with a Discord account that has the required capability.";
    routeEmptyAction.textContent = "Open account";
    routeEmptyAction.onclick = () => setSiteRoute("account");
  }
}

function setSiteRoute(route, options = {}) {
  assignDynamicPanels();
  updatePrivilegedNavigation();
  const selected = Object.hasOwn(siteRouteDefinitions, route) ? route : "home";
  currentSiteRoute = selected;
  for (const panel of routePanels) applyRouteVisibility(panel, selected);
  for (const button of primaryRouteButtons) {
    button.classList.toggle("is-active", button.dataset.siteRoute === selected);
    button.setAttribute("aria-current", button.dataset.siteRoute === selected ? "page" : "false");
  }
  const definition = siteRouteDefinitions[selected];
  workspaceHeading.hidden = selected === "home";
  if (selected !== "home") {
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

function ensureResourcesMenuStyles() {
  if (document.querySelector('link[data-klite-resources-menu]')) return;
  const stylesheet = document.createElement("link");
  stylesheet.rel = "stylesheet";
  stylesheet.href = "/resources-menu.css";
  stylesheet.dataset.kliteResourcesMenu = "";
  document.head.append(stylesheet);
}

function createResourcesMenu() {
  const trigger = document.querySelector("#api-button");
  if (!trigger || trigger.closest(".klite-resources-menu")) return;

  ensureResourcesMenuStyles();

  const wrapper = document.createElement("div");
  wrapper.className = "klite-resources-menu";
  wrapper.hidden = trigger.hidden;

  const menuId = "klite-developer-resources";
  trigger.textContent = "Resources";
  trigger.href = "#developer-resources";
  trigger.setAttribute("role", "button");
  trigger.setAttribute("aria-haspopup", "menu");
  trigger.setAttribute("aria-controls", menuId);
  trigger.setAttribute("aria-expanded", "false");

  const menu = document.createElement("div");
  menu.id = menuId;
  menu.className = "klite-resources-list";
  menu.setAttribute("role", "menu");
  menu.setAttribute("aria-label", "Developer resources");
  menu.hidden = true;
  menu.innerHTML = `
    <div class="klite-resources-heading">
      <strong>Developer resources</strong>
      <small>Reference material for KLite integrations and plugins.</small>
    </div>
    <a role="menuitem" href="/api/">
      <span class="klite-resource-icon" aria-hidden="true">{ }</span>
      <span><strong>API reference</strong><small>Client and automation interfaces</small></span>
      <span class="klite-resource-arrow" aria-hidden="true">›</span>
    </a>
    <a role="menuitem" href="/docs/">
      <span class="klite-resource-icon" aria-hidden="true">&lt;/&gt;</span>
      <span><strong>Plugin development guide</strong><small>Complete Copper &amp; Tin example</small></span>
      <span class="klite-resource-arrow" aria-hidden="true">›</span>
    </a>`;

  const positionMenu = () => {
    if (menu.hidden) return;
    const triggerRect = trigger.getBoundingClientRect();
    const padding = 16;
    const width = Math.min(360, Math.max(260, window.innerWidth - padding * 2));
    const left = Math.min(
      Math.max(padding, triggerRect.right - width),
      Math.max(padding, window.innerWidth - width - padding)
    );
    menu.style.width = `${width}px`;
    menu.style.left = `${Math.round(left)}px`;
    menu.style.top = `${Math.round(triggerRect.bottom + 10)}px`;
  };

  const closeMenu = ({ restoreFocus = false } = {}) => {
    menu.hidden = true;
    trigger.setAttribute("aria-expanded", "false");
    if (restoreFocus) trigger.focus();
  };

  const openMenu = ({ focusFirst = false } = {}) => {
    menu.hidden = false;
    trigger.setAttribute("aria-expanded", "true");
    positionMenu();
    if (focusFirst) menu.querySelector('[role="menuitem"]')?.focus();
  };

  const toggleMenu = () => {
    if (menu.hidden) openMenu();
    else closeMenu();
  };

  trigger.addEventListener("click", (event) => {
    event.preventDefault();
    event.stopPropagation();
    toggleMenu();
  });

  trigger.addEventListener("keydown", (event) => {
    if (["Enter", " "].includes(event.key)) {
      event.preventDefault();
      toggleMenu();
    } else if (event.key === "ArrowDown") {
      event.preventDefault();
      openMenu({ focusFirst: true });
    } else if (event.key === "Escape") {
      event.preventDefault();
      closeMenu();
    }
  });

  menu.addEventListener("keydown", (event) => {
    if (event.key === "Escape") {
      event.preventDefault();
      closeMenu({ restoreFocus: true });
    }
  });

  document.addEventListener("click", (event) => {
    if (!wrapper.contains(event.target) && !menu.contains(event.target)) closeMenu();
  });
  window.addEventListener("resize", positionMenu);
  window.addEventListener("scroll", positionMenu, true);

  new MutationObserver(() => {
    wrapper.hidden = trigger.hidden;
    if (wrapper.hidden) closeMenu();
  }).observe(trigger, { attributes: true, attributeFilter: ["hidden"] });

  trigger.before(wrapper);
  wrapper.append(trigger);
  document.body.append(menu);

  const accountMenu = document.querySelector("#account-menu");
  const logout = document.querySelector("#account-menu-logout");
  if (accountMenu && logout && !accountMenu.querySelector('a[href="/docs/"]')) {
    const docsLink = document.createElement("a");
    docsLink.href = "/docs/";
    docsLink.textContent = "Plugin documentation";
    accountMenu.insertBefore(docsLink, logout);
  }
}

function showDiscordLoginNotice(message, error = false) {
  const notice = document.createElement("div");
  notice.className = `discord-login-notice${error ? " is-error" : ""}`;
  notice.setAttribute("role", error ? "alert" : "status");
  notice.textContent = message;
  document.body.append(notice);
  window.setTimeout(() => notice.remove(), 6000);
}

function configureDiscordLogin() {
  const signInButton = document.querySelector("#sign-in-button");
  const registerButton = document.querySelector("#register-button");
  if (!signInButton) return;

  ensureResourcesMenuStyles();
  signInButton.textContent = "Continue with Discord";
  signInButton.classList.add("discord-login-button");

  const keepRegistrationHidden = () => {
    if (registerButton && !registerButton.hidden) registerButton.hidden = true;
  };
  keepRegistrationHidden();
  if (registerButton) {
    registerButton.setAttribute("aria-hidden", "true");
    new MutationObserver(keepRegistrationHidden)
      .observe(registerButton, { attributes: true, attributeFilter: ["hidden"] });
  }

  signInButton.addEventListener("click", async (event) => {
    event.preventDefault();
    event.stopImmediatePropagation();
    if (signInButton.disabled) return;

    const originalText = signInButton.textContent;
    signInButton.disabled = true;
    signInButton.textContent = "Opening Discord...";
    try {
      const response = await fetch("/api/auth/discord/start", {
        method: "POST",
        credentials: "same-origin",
        headers: { "content-type": "application/json" },
        body: "{}"
      });
      const payload = await response.json().catch(() => ({}));
      if (!response.ok || !payload.authorizeUrl) {
        throw new Error(payload.error?.message || "Discord login could not be started.");
      }
      window.location.assign(payload.authorizeUrl);
    } catch (error) {
      signInButton.disabled = false;
      signInButton.textContent = originalText;
      showDiscordLoginNotice(error.message || "Discord login could not be started.", true);
    }
  }, true);

  const loginResult = new URLSearchParams(window.location.search).get("login");
  if (loginResult) {
    history.replaceState({}, "", `${window.location.pathname}#account`);
    const messages = {
      discord_cancelled: "Discord login was cancelled.",
      discord_verified_email_required: "Discord must provide a verified email address for KLite login.",
      discord_authorization_failed: "Discord authorization could not be completed.",
      discord_login_failed: "Discord login failed. Please try again."
    };
    showDiscordLoginNotice(messages[loginResult] || "Discord login could not be completed.", true);
  }
}

createResourcesMenu();
configureDiscordLogin();
for (const button of primaryRouteButtons) button.addEventListener("click", () => setSiteRoute(button.dataset.siteRoute));
document.querySelector("#explore-marketplace-button")?.addEventListener("click", () => setSiteRoute("marketplace"));
document.querySelector("#footer-marketplace-link")?.addEventListener("click", (event) => { event.preventDefault(); setSiteRoute("marketplace"); });
document.querySelector("#account-menu-account")?.addEventListener("click", () => setSiteRoute("account"), true);
window.addEventListener("hashchange", () => setSiteRoute(requestedSiteRoute(), { preserveHash: true }));

function scheduleShellUpdate() {
  if (shellUpdatePending) return;
  shellUpdatePending = true;
  window.requestAnimationFrame(() => {
    shellUpdatePending = false;
    assignDynamicPanels();
    updatePrivilegedNavigation();
    for (const panel of routePanels) applyRouteVisibility(panel, currentSiteRoute);
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
