const apiButton = document.querySelector("#api-button");
const accountMenuWrapper = document.querySelector("#account-menu-wrapper");
const accountMenu = document.querySelector("#account-menu");
const accountMenuAccount = document.querySelector("#account-menu-account");
const accountMenuLogout = document.querySelector("#account-menu-logout");
const bootstrapSlot = document.querySelector("#discord-bootstrap-slot");
const forgotPasswordButton = document.querySelector("#forgot-password-button");
const passwordResetDialog = document.querySelector("#password-reset-dialog");
const passwordResetForm = document.querySelector("#password-reset-form");
const passwordResetClose = document.querySelector("#password-reset-close");
const passwordResetEmailField = document.querySelector("#password-reset-email-field");
const passwordResetEmail = document.querySelector("#password-reset-email");
const passwordResetNewField = document.querySelector("#password-reset-new-field");
const passwordResetNewPassword = document.querySelector("#password-reset-new-password");
const passwordResetToken = document.querySelector("#password-reset-token");
const passwordResetStatus = document.querySelector("#password-reset-status");
const passwordResetSubmit = document.querySelector("#password-reset-submit");
const passwordResetTitle = document.querySelector("#password-reset-title");
const passwordResetDescription = document.querySelector("#password-reset-description");
const passwordResetOwnerKeyField = document.createElement("label");
passwordResetOwnerKeyField.className = "form-field";
passwordResetOwnerKeyField.innerHTML = '<span>Owner recovery key <small>(KLite owner only)</small></span><input id="password-reset-owner-key" type="password" autocomplete="off">';
passwordResetEmailField.after(passwordResetOwnerKeyField);
const passwordResetOwnerKey = passwordResetOwnerKeyField.querySelector("input");

let latestDiscordDashboard = null;
let ownerDashboard = null;

const originalRenderSignedOut = renderSignedOut;
renderSignedOut = function renderSignedOutEnhanced() {
  originalRenderSignedOut();
  apiButton.hidden = true;
  accountMenuWrapper.hidden = true;
  accountMenu.hidden = true;
  if (ownerDashboard) ownerDashboard.hidden = true;
};

const originalRenderAccount = renderAccount;
renderAccount = function renderAccountEnhanced(payload) {
  originalRenderAccount(payload);
  apiReference.hidden = true;
  apiButton.hidden = false;
  accountMenuWrapper.hidden = false;
  accountMenu.hidden = true;

  const capabilities = new Set(payload.account?.capabilities || []);
  if (capabilities.has("site_owner")) {
    ensureOwnerDashboard();
    ownerDashboard.hidden = false;
    loadManagedUsers();
    discordBotDashboard.hidden = false;
    loadDiscordBotDashboard();
  } else if (ownerDashboard) {
    ownerDashboard.hidden = true;
  }
};

const originalRenderDiscordBotDashboard = renderDiscordBotDashboard;
renderDiscordBotDashboard = function renderDiscordBotDashboardEnhanced(payload) {
  latestDiscordDashboard = payload;
  originalRenderDiscordBotDashboard(payload);
  discordBotAccess.textContent = payload.access.method === "site_owner"
    ? "Permanent KLite owner access"
    : `Verified through Discord role ${payload.access.devRoleName}`;
  renderBotBootstrap(payload);
};

accountButton.addEventListener("click", (event) => {
  event.preventDefault();
  event.stopImmediatePropagation();
  accountMenu.hidden = !accountMenu.hidden;
}, true);

accountMenuAccount.addEventListener("click", () => {
  accountMenu.hidden = true;
  accountPanel.scrollIntoView({ behavior: "smooth", block: "start" });
});

accountMenuLogout.addEventListener("click", () => {
  accountMenu.hidden = true;
  signOutButton.click();
});

document.addEventListener("click", (event) => {
  if (!accountMenuWrapper.contains(event.target)) accountMenu.hidden = true;
});

authForm.addEventListener("submit", () => {
  window.setTimeout(() => loadAccount(), 700);
});

function renderBotBootstrap(payload) {
  bootstrapSlot.replaceChildren();
  const panel = document.createElement("section");
  panel.className = "bootstrap-panel";

  const heading = document.createElement("div");
  heading.className = "bootstrap-heading";
  const copy = document.createElement("div");
  const title = document.createElement("h3");
  title.textContent = payload.install.installed ? "Bot installation verified" : "Install the Discord bot";
  const description = document.createElement("p");
  description.className = "account-note";
  description.textContent = payload.install.installed
    ? "The bot is present in the designated server. Roles, channels, commands, and automation can now be configured below."
    : "Install the bot in the designated server first. The invite is locked to that server and includes slash-command support.";
  copy.append(title, description);

  const actions = document.createElement("div");
  actions.className = "bootstrap-actions";
  if (payload.install.inviteUrl) {
    const install = document.createElement("a");
    install.className = "button button-primary";
    install.href = payload.install.inviteUrl;
    install.target = "_blank";
    install.rel = "noopener noreferrer";
    install.textContent = payload.install.installed ? "Reauthorize bot" : "Add bot to server";
    actions.append(install);
  }
  const refresh = document.createElement("button");
  refresh.type = "button";
  refresh.className = "button button-secondary";
  refresh.textContent = "Verify installation";
  refresh.addEventListener("click", async () => {
    refresh.disabled = true;
    try { await loadDiscordBotDashboard(); } finally { refresh.disabled = false; }
  });
  actions.append(refresh);

  const createRole = document.createElement("button");
  createRole.type = "button";
  createRole.className = "button button-secondary";
  createRole.textContent = "Create Dev role";
  createRole.disabled = !payload.install.installed;
  createRole.addEventListener("click", async () => {
    createRole.disabled = true;
    announcementStatus.textContent = "Creating the Discord Dev role...";
    try {
      const updated = await api("/api/discord-bot/roles/dev", { method: "POST" });
      renderDiscordBotDashboard(updated);
      announcementStatus.textContent = "Dev role is available.";
    } catch (error) {
      announcementStatus.textContent = error.message;
    } finally {
      createRole.disabled = false;
    }
  });
  actions.append(createRole);

  const register = document.createElement("button");
  register.type = "button";
  register.className = "button button-secondary";
  register.textContent = "Register slash commands";
  register.disabled = !payload.install.installed;
  register.addEventListener("click", async () => {
    register.disabled = true;
    announcementStatus.textContent = "Registering slash commands in the designated server...";
    try {
      const result = await api("/api/discord-bot/commands/register", { method: "POST" });
      renderDiscordBotDashboard(result.dashboard);
      announcementStatus.textContent = `${result.registered} slash command${result.registered === 1 ? "" : "s"} registered.`;
    } catch (error) {
      announcementStatus.textContent = error.message;
    } finally {
      register.disabled = false;
    }
  });
  actions.append(register);

  heading.append(copy, actions);
  panel.append(heading);

  const meta = document.createElement("div");
  meta.className = "bootstrap-meta";
  const configured = document.createElement("span");
  configured.textContent = payload.install.configured
    ? "Cloudflare Discord variables: configured"
    : `Missing Cloudflare variables: ${payload.install.missing.join(", ")}`;
  const server = document.createElement("span");
  server.textContent = `Designated server ID: ${payload.install.guildId || "not configured"}`;
  const interactions = document.createElement("span");
  interactions.textContent = `Discord Interactions Endpoint URL: ${payload.install.interactionEndpoint}`;
  const resetRedirect = document.createElement("span");
  resetRedirect.textContent = `Discord password-reset redirect URL: ${payload.install.passwordResetRedirect}`;
  meta.append(configured, server, interactions, resetRedirect);
  panel.append(meta);
  bootstrapSlot.append(panel);

  for (const control of discordBotSettingsForm.querySelectorAll("input, select, button")) {
    control.disabled = !payload.install.installed;
  }
}

function ensureOwnerDashboard() {
  if (ownerDashboard) return;
  ownerDashboard = document.createElement("section");
  ownerDashboard.id = "owner-admin-dashboard";
  ownerDashboard.className = "account-panel owner-admin-panel";
  ownerDashboard.innerHTML = `
    <div class="owner-admin-heading">
      <div>
        <p class="eyebrow">KLite owner administration</p>
        <h2>Marketplace staff and reviewer access</h2>
        <p>Select the registered accounts allowed to submit plugins or approve plugin submissions.</p>
      </div>
      <div class="owner-admin-actions">
        <input id="owner-user-search" type="search" placeholder="Search username or email" autocomplete="off">
        <button id="owner-user-refresh" class="button button-secondary" type="button">Refresh</button>
      </div>
    </div>
    <p id="owner-user-status" class="account-note"></p>
    <div id="owner-user-list" class="owner-user-list"></div>`;
  reviewDashboard.parentNode.insertBefore(ownerDashboard, reviewDashboard);
  ownerDashboard.querySelector("#owner-user-refresh").addEventListener("click", loadManagedUsers);
  let timer = null;
  ownerDashboard.querySelector("#owner-user-search").addEventListener("input", () => {
    clearTimeout(timer);
    timer = setTimeout(loadManagedUsers, 250);
  });
}

async function loadManagedUsers() {
  if (!ownerDashboard || ownerDashboard.hidden) return;
  const search = ownerDashboard.querySelector("#owner-user-search").value.trim();
  const list = ownerDashboard.querySelector("#owner-user-list");
  const status = ownerDashboard.querySelector("#owner-user-status");
  status.textContent = "Loading registered marketplace accounts...";
  try {
    const payload = await api(`/api/admin/users?query=${encodeURIComponent(search)}`);
    list.replaceChildren();
    for (const user of payload.users || []) list.append(renderManagedUser(user));
    status.textContent = `${payload.users?.length || 0} account${payload.users?.length === 1 ? "" : "s"} shown.`;
  } catch (error) {
    status.textContent = error.message;
  }
}

function renderManagedUser(user) {
  const card = document.createElement("article");
  card.className = "user-role-card";
  const info = document.createElement("div");
  const title = document.createElement("strong");
  title.textContent = user.owner ? `${user.username} — Site owner` : user.username;
  const email = document.createElement("p");
  email.textContent = user.email;
  const options = document.createElement("div");
  options.className = "user-role-options";
  const current = new Set(user.roles || []);
  const controls = [];
  for (const [label, role] of [["Plugin developer", "plugin_dev"], ["Can approve plugins", "marketplace_reviewer"]]) {
    const wrapper = document.createElement("label");
    const checkbox = document.createElement("input");
    checkbox.type = "checkbox";
    checkbox.checked = current.has(role);
    checkbox.dataset.role = role;
    wrapper.append(checkbox, document.createTextNode(label));
    options.append(wrapper);
    controls.push(checkbox);
  }
  info.append(title, email, options);

  const actions = document.createElement("div");
  actions.className = "user-role-actions";
  const save = document.createElement("button");
  save.type = "button";
  save.className = "button button-primary";
  save.textContent = "Save access";
  const message = document.createElement("span");
  message.className = "account-note";
  save.addEventListener("click", async () => {
    save.disabled = true;
    message.textContent = "Saving...";
    try {
      const roles = controls.filter((control) => control.checked).map((control) => control.dataset.role);
      await api(`/api/admin/users/${user.id}/roles`, {
        method: "PUT",
        body: JSON.stringify({ roles })
      });
      message.textContent = "Saved.";
    } catch (error) {
      message.textContent = error.message;
    } finally {
      save.disabled = false;
    }
  });
  actions.append(save, message);
  card.append(info, actions);
  return card;
}

forgotPasswordButton.addEventListener("click", () => openPasswordResetStart());
passwordResetClose.addEventListener("click", () => passwordResetDialog.close());

function openPasswordResetStart() {
  authDialog.close();
  passwordResetForm.reset();
  passwordResetToken.value = "";
  passwordResetEmailField.hidden = false;
  passwordResetEmail.required = true;
  passwordResetNewField.hidden = true;
  passwordResetOwnerKeyField.hidden = false;
  passwordResetNewPassword.required = false;
  passwordResetTitle.textContent = "Reset password";
  passwordResetDescription.textContent = "Enter your marketplace email. Recovery is verified through the Discord account previously linked to it.";
  passwordResetSubmit.textContent = "Continue with Discord";
  passwordResetStatus.textContent = "";
  passwordResetDialog.showModal();
  passwordResetEmail.focus();
}

function openPasswordResetComplete(token) {
  passwordResetForm.reset();
  passwordResetToken.value = token;
  passwordResetEmailField.hidden = true;
  passwordResetEmail.required = false;
  passwordResetNewField.hidden = false;
  passwordResetOwnerKeyField.hidden = true;
  passwordResetNewPassword.required = true;
  passwordResetTitle.textContent = "Choose a new password";
  passwordResetDescription.textContent = "Identity verification succeeded. Enter a new password with at least 12 characters.";
  passwordResetSubmit.textContent = "Update password";
  passwordResetStatus.textContent = "";
  passwordResetDialog.showModal();
  passwordResetNewPassword.focus();
}

passwordResetForm.addEventListener("submit", async (event) => {
  event.preventDefault();
  passwordResetSubmit.disabled = true;
  passwordResetStatus.textContent = "";
  try {
    if (passwordResetToken.value) {
      const result = await api("/api/auth/reset/complete", {
        method: "POST",
        body: JSON.stringify({ token: passwordResetToken.value, password: passwordResetNewPassword.value })
      });
      passwordResetStatus.textContent = result.message;
      passwordResetSubmit.textContent = "Return to sign in";
      passwordResetSubmit.type = "button";
      passwordResetSubmit.onclick = () => {
        passwordResetDialog.close();
        passwordResetSubmit.type = "submit";
        passwordResetSubmit.onclick = null;
        openAuth("login");
      };
    } else {
      const result = await api("/api/auth/reset/start", {
        method: "POST",
        body: JSON.stringify({ email: passwordResetEmail.value, recoveryKey: passwordResetOwnerKey.value || undefined })
      });
      if (result.resetToken) {
        openPasswordResetComplete(result.resetToken);
        return;
      }
      if (result.authorizeUrl) {
        window.location.assign(result.authorizeUrl);
        return;
      }
      passwordResetStatus.textContent = result.message || "This account cannot be recovered through Discord.";
    }
  } catch (error) {
    passwordResetStatus.textContent = error.message;
  } finally {
    passwordResetSubmit.disabled = false;
  }
});

const resetHash = new URLSearchParams(window.location.hash.replace(/^#reset-/, ""));
if (window.location.hash.startsWith("#reset-token=")) {
  const token = resetHash.get("token");
  history.replaceState({}, "", window.location.pathname);
  if (token) openPasswordResetComplete(token);
} else if (window.location.hash.startsWith("#reset-error=")) {
  const errorCode = resetHash.get("error") || "unknown_error";
  history.replaceState({}, "", window.location.pathname);
  openPasswordResetStart();
  passwordResetStatus.textContent = `Password reset could not be verified (${errorCode.replaceAll("_", " ")}).`;
}

if (new URLSearchParams(window.location.search).get("signin") === "1") {
  history.replaceState({}, "", window.location.pathname);
  openAuth("login");
}

loadAccount();
