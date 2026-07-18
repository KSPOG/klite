(() => {
  const resourcesTrigger = document.querySelector("#shared-resources-button");
  const resourcesMenu = document.querySelector("#shared-resources-menu");
  const signInButton = document.querySelector("#shared-discord-login");
  const accountWrapper = document.querySelector("#shared-account-wrapper");
  const accountButton = document.querySelector("#shared-account-button");
  const accountMenu = document.querySelector("#shared-account-menu");
  const logoutButton = document.querySelector("#shared-account-logout");

  function closeMenus() {
    if (resourcesMenu) resourcesMenu.hidden = true;
    if (resourcesTrigger) resourcesTrigger.setAttribute("aria-expanded", "false");
    if (accountMenu) accountMenu.hidden = true;
    if (accountButton) accountButton.setAttribute("aria-expanded", "false");
  }

  function toggleMenu(trigger, menu) {
    if (!trigger || !menu) return;
    const opening = menu.hidden;
    closeMenus();
    menu.hidden = !opening;
    trigger.setAttribute("aria-expanded", String(opening));
  }

  resourcesTrigger?.addEventListener("click", (event) => {
    event.preventDefault();
    event.stopPropagation();
    toggleMenu(resourcesTrigger, resourcesMenu);
  });

  accountButton?.addEventListener("click", (event) => {
    event.preventDefault();
    event.stopPropagation();
    toggleMenu(accountButton, accountMenu);
  });

  document.addEventListener("click", (event) => {
    if (!event.target.closest(".shared-header-menu")) closeMenus();
  });

  document.addEventListener("keydown", (event) => {
    if (event.key === "Escape") closeMenus();
  });

  async function startDiscordLogin() {
    if (!signInButton || signInButton.disabled) return;
    const originalText = signInButton.textContent;
    signInButton.disabled = true;
    signInButton.textContent = "Opening Discord…";
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
      window.alert(error.message || "Discord login could not be started.");
    }
  }

  signInButton?.addEventListener("click", startDiscordLogin);

  logoutButton?.addEventListener("click", async () => {
    logoutButton.disabled = true;
    try {
      await fetch("/api/auth/logout", {
        method: "POST",
        credentials: "same-origin",
        headers: { "content-type": "application/json" },
        body: "{}"
      });
    } finally {
      window.location.assign("/");
    }
  });

  async function loadHeaderAccount() {
    try {
      const response = await fetch("/api/account", {
        credentials: "same-origin",
        cache: "no-store"
      });
      if (!response.ok) throw new Error("signed_out");
      const payload = await response.json();
      const username = payload.account?.username || "My Account";
      signInButton.hidden = true;
      accountWrapper.hidden = false;
      accountButton.textContent = username;
    } catch {
      signInButton.hidden = false;
      accountWrapper.hidden = true;
      closeMenus();
    }
  }

  loadHeaderAccount();
})();
