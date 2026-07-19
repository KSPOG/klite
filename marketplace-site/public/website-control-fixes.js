(() => {
  let lastControlLabel = "";
  let lastControlAt = 0;

  function api(path, options = {}) {
    return fetch(path, {
      credentials: "same-origin",
      ...options,
      headers: {
        ...(options.body ? { "content-type": "application/json" } : {}),
        ...options.headers
      }
    }).then(async (response) => {
      const payload = await response.json().catch(() => ({}));
      if (!response.ok) {
        const error = new Error(payload.error?.message || `Request failed (${response.status}).`);
        error.status = response.status;
        throw error;
      }
      return payload;
    });
  }

  function showNotice(message, error = false) {
    if (!message) return;
    let notice = document.querySelector("#website-control-notice");
    if (!notice) {
      notice = document.createElement("div");
      notice.id = "website-control-notice";
      notice.setAttribute("aria-live", "polite");
      notice.style.position = "fixed";
      notice.style.right = "18px";
      notice.style.bottom = "18px";
      notice.style.zIndex = "2000";
      notice.style.maxWidth = "min(440px, calc(100vw - 36px))";
      notice.style.padding = "14px 16px";
      notice.style.border = "1px solid rgba(255,255,255,.16)";
      notice.style.borderRadius = "12px";
      notice.style.background = "rgba(4,10,16,.96)";
      notice.style.boxShadow = "0 18px 55px rgba(0,0,0,.42)";
      notice.style.color = "#f4f8fa";
      notice.style.font = "500 14px/1.45 system-ui, sans-serif";
      document.body.append(notice);
    }
    notice.setAttribute("role", error ? "alert" : "status");
    notice.style.borderColor = error ? "rgba(255,108,108,.55)" : "rgba(101,218,255,.42)";
    notice.textContent = message;
    notice.hidden = false;
    clearTimeout(notice._hideTimer);
    notice._hideTimer = setTimeout(() => { notice.hidden = true; }, error ? 9000 : 5000);
  }

  function statusNode(selector, message, error = false) {
    const node = document.querySelector(selector);
    if (!node) {
      showNotice(message, error);
      return;
    }
    node.textContent = message;
    node.classList.toggle("is-error", error);
  }

  function captureButton(selector, callback) {
    document.addEventListener("click", async (event) => {
      const button = event.target.closest(selector);
      if (!button || button.disabled) return;
      event.preventDefault();
      event.stopImmediatePropagation();
      button.disabled = true;
      button.setAttribute("aria-busy", "true");
      try {
        await callback(button);
      } catch (error) {
        showNotice(error.message || "The action could not be completed.", true);
      } finally {
        button.disabled = false;
        button.removeAttribute("aria-busy");
      }
    }, true);
  }

  function resetPasswordFormAction() {
    const submit = document.querySelector("#password-reset-submit");
    if (!submit) return;
    submit.type = "submit";
    submit.onclick = null;
    submit.disabled = false;
  }

  function installPasswordRecoveryEntry() {
    const signIn = document.querySelector("#sign-in-button");
    const forgot = document.querySelector("#forgot-password-button");
    if (!signIn || !forgot || document.querySelector("#recover-account-button")) return;

    const recover = document.createElement("button");
    recover.id = "recover-account-button";
    recover.type = "button";
    recover.className = "button button-secondary";
    recover.textContent = "Recover account";
    recover.hidden = signIn.hidden;
    recover.addEventListener("click", () => {
      resetPasswordFormAction();
      forgot.click();
    });
    signIn.after(recover);

    new MutationObserver(() => {
      recover.hidden = signIn.hidden;
    }).observe(signIn, { attributes: true, attributeFilter: ["hidden"] });
  }

  captureButton("#discord-oauth-button", async () => {
    statusNode("#discord-code-output", "Opening Discord account linking...");
    try {
      const payload = await api("/api/discord/link/start", {
        method: "POST",
        body: "{}"
      });
      if (!payload.authorizeUrl) throw new Error("Discord did not return an authorization URL.");
      window.location.assign(payload.authorizeUrl);
    } catch (error) {
      statusNode("#discord-code-output", error.message, true);
    }
  });

  captureButton("#discord-code-button", async () => {
    statusNode("#discord-code-output", "Creating a one-time Discord link code...");
    try {
      const payload = await api("/api/discord/link-code", {
        method: "POST",
        body: "{}"
      });
      statusNode(
        "#discord-code-output",
        `Run /link code:${payload.code} in Discord. This code expires in 10 minutes.`
      );
    } catch (error) {
      statusNode("#discord-code-output", error.message, true);
    }
  });

  captureButton("#sign-out-button", async () => {
    try {
      await api("/api/auth/logout", { method: "POST", body: "{}" });
      if (typeof renderSignedOut === "function") renderSignedOut();
      if (typeof setSiteRoute === "function") setSiteRoute("home");
      showNotice("Signed out of KLite.");
    } catch (error) {
      statusNode("#account-summary", error.message, true);
    }
  });

  document.addEventListener("click", (event) => {
    const button = event.target.closest("button, [role='button']");
    if (button) {
      lastControlLabel = button.textContent?.trim().replace(/\s+/g, " ").slice(0, 80) || "Website action";
      lastControlAt = Date.now();
    }

    if (event.target.closest("#forgot-password-button")) resetPasswordFormAction();

    const verify = event.target.closest("button");
    if (!verify || verify.textContent.trim() !== "Verify installation" || verify.disabled) return;
    event.preventDefault();
    event.stopImmediatePropagation();
    verify.disabled = true;
    verify.setAttribute("aria-busy", "true");
    statusNode("#announcement-status", "Checking the Discord bot installation...");
    api("/api/discord-bot/dashboard")
      .then((payload) => {
        if (typeof renderDiscordBotDashboard === "function") renderDiscordBotDashboard(payload);
        statusNode(
          "#announcement-status",
          payload.install?.installed
            ? "Discord bot installation verified."
            : "The Discord bot is not installed in the designated server yet."
        );
      })
      .catch((error) => statusNode("#announcement-status", error.message, true))
      .finally(() => {
        verify.disabled = false;
        verify.removeAttribute("aria-busy");
      });
  }, true);

  window.addEventListener("unhandledrejection", (event) => {
    const reason = event.reason;
    const message = reason?.message || (typeof reason === "string" ? reason : "The action failed unexpectedly.");
    const recentControl = Date.now() - lastControlAt < 5000 ? `${lastControlLabel}: ` : "";
    showNotice(`${recentControl}${message}`, true);
  });

  const authDialog = document.querySelector("#auth-dialog");
  const discordSignIn = document.querySelector("#sign-in-button");
  if (authDialog?.open && discordSignIn?.textContent.includes("Discord")) {
    authDialog.close();
    if (typeof setSiteRoute === "function") setSiteRoute("account", { preserveHash: true });
    showNotice("KLite website sign-in now uses Discord. Choose Continue with Discord.");
  }

  installPasswordRecoveryEntry();
})();
