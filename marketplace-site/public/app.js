const pluginGrid = document.querySelector("#plugin-grid");
const catalogStatus = document.querySelector("#catalog-status");
const searchInput = document.querySelector("#plugin-search");
const categoryFilter = document.querySelector("#category-filter");
const typeFilter = document.querySelector("#type-filter");
const signInButton = document.querySelector("#sign-in-button");
const registerButton = document.querySelector("#register-button");
const accountButton = document.querySelector("#account-button");
const accountPanel = document.querySelector("#account");
const accountSummary = document.querySelector("#account-summary");
const discordStatus = document.querySelector("#discord-status");
const discordOauthButton = document.querySelector("#discord-oauth-button");
const discordCodeButton = document.querySelector("#discord-code-button");
const discordCodeOutput = document.querySelector("#discord-code-output");
const developerRoleStatus = document.querySelector("#developer-role-status");
const entitlementCount = document.querySelector("#entitlement-count");
const entitlementList = document.querySelector("#entitlement-list");
const signOutButton = document.querySelector("#sign-out-button");
const authDialog = document.querySelector("#auth-dialog");
const authForm = document.querySelector("#auth-form");
const authTitle = document.querySelector("#auth-title");
const authEyebrow = document.querySelector("#auth-eyebrow");
const authSubmit = document.querySelector("#auth-submit");
const authClose = document.querySelector("#auth-close");
const authError = document.querySelector("#auth-error");
const usernameField = document.querySelector("#username-field");
const authUsername = document.querySelector("#auth-username");
const authEmail = document.querySelector("#auth-email");
const authPassword = document.querySelector("#auth-password");
const orderFilter = document.querySelector("#order-filter");
const developerDashboard = document.querySelector("#developer-dashboard");
const submissionForm = document.querySelector("#submission-form");
const submissionPluginId = document.querySelector("#submission-plugin-id");
const submissionName = document.querySelector("#submission-name");
const submissionVersion = document.querySelector("#submission-version");
const submissionSourceUrl = document.querySelector("#submission-source-url");
const submissionDescription = document.querySelector("#submission-description");
const submissionError = document.querySelector("#submission-error");
const submissionList = document.querySelector("#submission-list");
const reviewDashboard = document.querySelector("#review-dashboard");
const reviewList = document.querySelector("#review-list");
const apiReference = document.querySelector("#api-reference");
const apiReferenceSearch = document.querySelector("#api-reference-search");
const apiReferenceSummary = document.querySelector("#api-reference-summary");
const apiReferenceContent = document.querySelector("#api-reference-content");
const announcementForm = document.querySelector("#announcement-form");
const announcementChannelId = document.querySelector("#announcement-channel-id");
const announcementEnabled = document.querySelector("#announcement-enabled");
const announcementSync = document.querySelector("#announcement-sync");
const announcementStatus = document.querySelector("#announcement-status");
const announcementHistory = document.querySelector("#announcement-history");

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

let authMode = "login";
let currentAccount = null;
let activeEntitlementIds = new Set();
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

    if (["Premium", "Supporter"].includes(plugin.type || plugin.access)) {
      const access = document.createElement("span");
      if (activeEntitlementIds.has(plugin.id)) {
        access.textContent = "Owned";
        access.className = "access-owned";
      } else {
        access.textContent = currentAccount ? "Purchase required" : "Sign in required";
        access.className = "access-locked";
      }
      meta.append(access);
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

async function api(path, options = {}) {
  const response = await fetch(path, {
    credentials: "same-origin",
    ...options,
    headers: {
      ...(options.body ? { "content-type": "application/json" } : {}),
      ...options.headers
    }
  });
  const payload = await response.json().catch(() => ({}));
  if (!response.ok) {
    const error = new Error(payload.error?.message || "The request could not be completed.");
    error.status = response.status;
    throw error;
  }
  return payload;
}

function openAuth(mode) {
  authMode = mode;
  const registering = mode === "register";
  authTitle.textContent = registering ? "Create account" : "Sign in";
  authEyebrow.textContent = registering ? "Join KLite" : "Welcome back";
  authSubmit.textContent = registering ? "Register" : "Sign in";
  usernameField.hidden = !registering;
  authUsername.required = registering;
  authPassword.autocomplete = registering ? "new-password" : "current-password";
  authError.textContent = "";
  authDialog.showModal();
  (registering ? authUsername : authEmail).focus();
}

function renderSignedOut() {
  currentAccount = null;
  activeEntitlementIds = new Set();
  signInButton.hidden = false;
  registerButton.hidden = false;
  accountButton.hidden = true;
  accountPanel.hidden = true;
  discordCodeOutput.textContent = "";
  renderPlugins();
  developerDashboard.hidden = true;
  reviewDashboard.hidden = true;
  apiReference.hidden = true;
}

function renderAccount(payload) {
  currentAccount = payload.account;
  const entitlements = payload.entitlements || [];
  activeEntitlementIds = new Set(entitlements.map((item) => item.pluginId));
  signInButton.hidden = true;
  registerButton.hidden = true;
  accountButton.hidden = false;
  accountButton.textContent = currentAccount.username;
  accountPanel.hidden = false;
  accountSummary.textContent = `${currentAccount.username} / ${currentAccount.email}`;
  discordStatus.textContent = currentAccount.discord
    ? (currentAccount.discord.globalName || currentAccount.discord.username)
    : "Not linked";
  discordOauthButton.textContent = currentAccount.discord ? "Relink Discord" : "Link Discord";
  entitlementCount.textContent = `${entitlements.length} active entitlement${entitlements.length === 1 ? "" : "s"}`;
  entitlementList.replaceChildren();
  for (const entitlement of entitlements) {
    const item = document.createElement("li");
    item.textContent = entitlement.pluginId;
    entitlementList.append(item);
  }
  if (entitlements.length === 0) {
    const item = document.createElement("li");
    item.textContent = "No paid plugins are assigned yet.";
    entitlementList.append(item);
  }
  const capabilities = new Set(currentAccount.capabilities || []);
  const websiteRoles = new Set(currentAccount.roles || []);
  developerRoleStatus.textContent = capabilities.has("plugin_dev")
    ? "Plugin Dev access verified on KLite and Discord."
    : websiteRoles.has("plugin_dev") ? "Relink Discord to verify the Plugin Dev server role." : "";
  developerDashboard.hidden = !capabilities.has("plugin_dev");
  reviewDashboard.hidden = !capabilities.has("marketplace_review");
  apiReference.hidden = false;
  loadApiReference();
  if (!developerDashboard.hidden) {
    loadDeveloperSubmissions();
    loadAnnouncementSettings();
  }
  if (!reviewDashboard.hidden) {
    loadReviewSubmissions();
  }
  renderPlugins();
}

let apiReferencePayload = null;

async function loadApiReference() {
  if (apiReferencePayload) {
    renderApiReference();
    return;
  }
  apiReferenceContent.textContent = "Loading API reference...";
  try {
    apiReferencePayload = await api("/api/docs");
    apiReferenceSummary.textContent = `${apiReferencePayload.typeCount} public types and `
      + `${apiReferencePayload.methodCount} callable signatures. Marketplace APIs are excluded.`;
    renderApiReference();
  } catch (error) {
    apiReferenceContent.textContent = error.message;
  }
}

function renderApiReference() {
  if (!apiReferencePayload) {
    return;
  }
  const query = apiReferenceSearch.value.trim().toLowerCase();
  apiReferenceContent.replaceChildren();
  let visibleTypes = 0;
  for (const section of apiReferencePayload.sections || []) {
    const matchingTypes = section.types.filter((type) => [
      type.name, type.packageName, type.description, ...type.signatures
    ].join(" ").toLowerCase().includes(query));
    if (!matchingTypes.length) {
      continue;
    }
    const heading = document.createElement("h3");
    heading.textContent = section.name;
    apiReferenceContent.append(heading);
    for (const type of matchingTypes) {
      visibleTypes += 1;
      const details = document.createElement("details");
      details.className = "api-type";
      const summary = document.createElement("summary");
      const name = document.createElement("strong");
      name.textContent = type.name;
      const kind = document.createElement("span");
      kind.textContent = type.kind;
      summary.append(name, kind);
      const packageName = document.createElement("code");
      packageName.textContent = type.packageName;
      details.append(summary, packageName);
      if (type.description) {
        const description = document.createElement("p");
        description.textContent = type.description;
        details.append(description);
      }
      const signatures = document.createElement("ul");
      signatures.className = "api-signatures";
      for (const signature of type.signatures) {
        const item = document.createElement("li");
        const code = document.createElement("code");
        code.textContent = signature;
        item.append(code);
        signatures.append(item);
      }
      if (type.signatures.length) {
        details.append(signatures);
      }
      apiReferenceContent.append(details);
    }
  }
  if (!visibleTypes) {
    apiReferenceContent.textContent = "No API types match your search.";
  }
}

function renderAnnouncementSettings(payload) {
  const setting = payload.setting;
  announcementChannelId.value = setting?.channelId || "";
  announcementEnabled.checked = setting?.enabled ?? false;
  announcementHistory.replaceChildren();
  for (const entry of payload.history || []) {
    const card = document.createElement("article");
    card.className = "submission-card";
    const title = document.createElement("strong");
    title.textContent = `${entry.eventType === "new" ? "New" : "Updated"}: `
      + `${entry.pluginId} ${entry.version}`;
    const metadata = document.createElement("p");
    metadata.className = "submission-meta";
    metadata.textContent = `Channel ${entry.channelId} - `
      + new Date(entry.announcedAt * 1000).toLocaleString();
    card.append(title, metadata);
    announcementHistory.append(card);
  }
  if (!announcementHistory.childElementCount) {
    announcementHistory.textContent = "No marketplace announcements have been posted yet.";
  }
}

async function loadAnnouncementSettings() {
  announcementStatus.textContent = "";
  try {
    renderAnnouncementSettings(await api("/api/developer/announcements"));
  } catch (error) {
    announcementStatus.textContent = error.message;
  }
}

async function loadAccount() {
  try {
    renderAccount(await api("/api/account"));
  } catch (error) {
    if (error.status !== 401) {
      console.error("Unable to load account", error);
    }
    renderSignedOut();
  }
}

authForm.addEventListener("submit", async (event) => {
  event.preventDefault();
  authError.textContent = "";
  authSubmit.disabled = true;
  try {
    const payload = await api(`/api/auth/${authMode === "register" ? "register" : "login"}`, {
      method: "POST",
      body: JSON.stringify({
        username: authMode === "register" ? authUsername.value : undefined,
        email: authEmail.value,
        password: authPassword.value
      })
    });
    authForm.reset();
    authDialog.close();
    renderAccount(payload);
    accountPanel.scrollIntoView({ behavior: "smooth", block: "start" });
  } catch (error) {
    authError.textContent = error.message;
  } finally {
    authPassword.value = "";
    authSubmit.disabled = false;
  }
});


function createSubmissionCard(submission, reviewMode = false) {
  const card = document.createElement("article");
  card.className = "submission-card";
  const title = document.createElement("h4");
  title.textContent = `${submission.name} ${submission.version}`;
  const metadata = document.createElement("p");
  metadata.className = "submission-meta";
  metadata.textContent = `${submission.pluginId} - ${submission.status}`
    + (submission.submitter ? ` - by ${submission.submitter}` : "");
  const source = document.createElement("a");
  source.href = submission.sourceUrl;
  source.target = "_blank";
  source.rel = "noopener noreferrer";
  source.textContent = "Review source";
  const description = document.createElement("p");
  description.textContent = submission.description;
  card.append(title, metadata, source, description);
  if (submission.reviewNotes) {
    const notes = document.createElement("p");
    notes.className = "review-notes";
    notes.textContent = `Review notes: ${submission.reviewNotes}`;
    card.append(notes);
  }
  if (reviewMode) {
    const notes = document.createElement("textarea");
    notes.rows = 3;
    notes.maxLength = 2000;
    notes.placeholder = "Review notes (required for rejection or requested changes)";
    notes.setAttribute("aria-label", `Review notes for ${submission.name}`);
    const actions = document.createElement("div");
    actions.className = "review-actions";
    for (const [label, decision, className] of [
      ["Approve", "approved", "button-primary"],
      ["Request changes", "changes_requested", "button-secondary"],
      ["Reject", "rejected", "button-danger"]
    ]) {
      const button = document.createElement("button");
      button.type = "button";
      button.className = `button ${className}`;
      button.textContent = label;
      button.addEventListener("click", async () => {
        actions.querySelectorAll("button").forEach((item) => { item.disabled = true; });
        try {
          await api(`/api/review/submissions/${submission.id}/decision`, {
            method: "POST",
            body: JSON.stringify({ decision, notes: notes.value })
          });
          await loadReviewSubmissions();
        } catch (error) {
          metadata.textContent = error.message;
          actions.querySelectorAll("button").forEach((item) => { item.disabled = false; });
        }
      });
      actions.append(button);
    }
    card.append(notes, actions);
  }
  return card;
}

async function loadDeveloperSubmissions() {
  submissionList.textContent = "Loading submissions...";
  try {
    const payload = await api("/api/developer/submissions");
    submissionList.replaceChildren();
    for (const submission of payload.submissions || []) {
      submissionList.append(createSubmissionCard(submission));
    }
    if (!submissionList.childElementCount) {
      submissionList.textContent = "No plugin submissions yet.";
    }
  } catch (error) {
    submissionList.textContent = error.message;
  }
}

async function loadReviewSubmissions() {
  reviewList.textContent = "Loading review queue...";
  try {
    const payload = await api("/api/review/submissions");
    reviewList.replaceChildren();
    for (const submission of payload.submissions || []) {
      reviewList.append(createSubmissionCard(submission, true));
    }
    if (!reviewList.childElementCount) {
      reviewList.textContent = "The review queue is empty.";
    }
  } catch (error) {
    reviewList.textContent = error.message;
  }
}

submissionForm.addEventListener("submit", async (event) => {
  event.preventDefault();
  submissionError.textContent = "";
  const submit = submissionForm.querySelector("button[type='submit']");
  submit.disabled = true;
  try {
    await api("/api/developer/submissions", {
      method: "POST",
      body: JSON.stringify({
        pluginId: submissionPluginId.value,
        name: submissionName.value,
        version: submissionVersion.value,
        sourceUrl: submissionSourceUrl.value,
        description: submissionDescription.value
      })
    });
    submissionForm.reset();
    await loadDeveloperSubmissions();
  } catch (error) {
    submissionError.textContent = error.message;
  } finally {
    submit.disabled = false;
  }
});

apiReferenceSearch.addEventListener("input", renderApiReference);

announcementForm.addEventListener("submit", async (event) => {
  event.preventDefault();
  const submit = announcementForm.querySelector("button[type='submit']");
  submit.disabled = true;
  announcementStatus.textContent = "Validating the bot's channel access...";
  try {
    const payload = await api("/api/developer/announcements", {
      method: "PUT",
      body: JSON.stringify({
        channelId: announcementChannelId.value,
        enabled: announcementEnabled.checked
      })
    });
    announcementStatus.textContent = `Saved #${payload.setting.channelName}.`;
    await loadAnnouncementSettings();
  } catch (error) {
    announcementStatus.textContent = error.message;
  } finally {
    submit.disabled = false;
  }
});

announcementSync.addEventListener("click", async () => {
  announcementSync.disabled = true;
  announcementStatus.textContent = "Checking the published catalog...";
  try {
    const result = await api("/api/developer/announcements/sync", { method: "POST" });
    announcementStatus.textContent = result.skipped === "disabled"
      ? "Automatic announcements are disabled."
      : `${result.announced} announcement${result.announced === 1 ? "" : "s"} posted.`;
    await loadAnnouncementSettings();
  } catch (error) {
    announcementStatus.textContent = error.message;
  } finally {
    announcementSync.disabled = false;
  }
});

signInButton.addEventListener("click", () => openAuth("login"));
registerButton.addEventListener("click", () => openAuth("register"));
authClose.addEventListener("click", () => authDialog.close());
accountButton.addEventListener("click", () => accountPanel.scrollIntoView({ behavior: "smooth" }));
signOutButton.addEventListener("click", async () => {
  await api("/api/auth/logout", { method: "POST" });
  renderSignedOut();
});
discordOauthButton.addEventListener("click", async () => {
  const payload = await api("/api/discord/link/start", { method: "POST" });
  window.location.assign(payload.authorizeUrl);
});
discordCodeButton.addEventListener("click", async () => {
  const payload = await api("/api/discord/link-code", { method: "POST" });
  discordCodeOutput.textContent = `Run /link code:${payload.code} in Discord. This code expires in 10 minutes.`;
});

const accountResult = new URLSearchParams(window.location.search).get("account");
if (accountResult) {
  history.replaceState({}, "", `${window.location.pathname}#account`);
  discordCodeOutput.textContent = accountResult === "discord_linked"
    ? "Discord linked successfully."
    : "Discord could not be linked. Generate a new link request and try again.";
}
typeFilter.addEventListener("change", renderPlugins);
orderFilter.addEventListener("change", renderPlugins);
loadCatalog();
document.querySelector(".catalog-controls").addEventListener("submit", (event) => event.preventDefault());
loadAccount();
