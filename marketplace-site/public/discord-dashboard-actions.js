(() => {
  const ACTIONS = new Set([
    "Register slash commands",
    "Post client update"
  ]);

  document.addEventListener("click", async (event) => {
    const button = event.target.closest("button");
    if (!button || !ACTIONS.has(button.textContent.trim())) return;

    if (button.id === "discord-client-update-post") {
      event.preventDefault();
      event.stopImmediatePropagation();
      await postClientUpdate(button);
      return;
    }

    if (button.textContent.trim() === "Register slash commands") {
      event.preventDefault();
      event.stopImmediatePropagation();
      await registerSlashCommands(button);
    }
  }, true);

  async function registerSlashCommands(button) {
    button.disabled = true;
    setAnnouncementStatus("Registering and verifying slash commands in the designated server...");
    try {
      const result = await dashboardApi("/api/discord-bot/commands/register", { method: "POST" });
      renderDashboard(result.dashboard);
      const names = (result.commandNames || []).map((name) => `/${name}`).join(", ");
      setAnnouncementStatus(
        `${result.registered} slash command${result.registered === 1 ? "" : "s"} registered and verified${names ? `: ${names}` : "."}`
      );
    } catch (error) {
      setAnnouncementStatus(error.message);
    } finally {
      button.disabled = false;
    }
  }

  async function postClientUpdate(button) {
    button.disabled = true;
    setClientUpdateStatus("Posting and verifying the client update in Discord...");
    try {
      const result = await dashboardApi("/api/discord-bot/client-updates/post", {
        method: "POST",
        body: JSON.stringify(collectDiscordSettings())
      });
      renderDashboard(result.dashboard);
      document.querySelector("#discord-client-update-notes").value = "";
      renderPostResult(result.post);
    } catch (error) {
      setClientUpdateStatus(error.message);
    } finally {
      button.disabled = false;
    }
  }

  function collectDiscordSettings() {
    const value = (id) => document.querySelector(`#${id}`)?.value || null;
    const checked = (id) => Boolean(document.querySelector(`#${id}`)?.checked);
    return {
      devRoleId: value("discord-dev-role"),
      pluginDevRoleId: value("discord-plugin-dev-role"),
      marketplaceReviewerRoleId: value("discord-reviewer-role"),
      memberRoleId: value("discord-member-role"),
      clientUpdateRoleId: value("discord-client-update-role"),
      announcementChannelId: value("announcement-channel-id"),
      clientUpdateChannelId: value("discord-client-update-channel"),
      auditChannelId: value("discord-audit-channel"),
      welcomeChannelId: value("discord-welcome-channel"),
      botEnabled: checked("discord-bot-enabled"),
      announcementsEnabled: checked("announcement-enabled"),
      clientUpdatesEnabled: checked("discord-client-updates-enabled"),
      autoAssignMemberRole: checked("discord-auto-member-role"),
      clientUpdateVersion: value("discord-client-update-version") || "",
      clientUpdateNotes: value("discord-client-update-notes") || ""
    };
  }

  async function dashboardApi(path, options = {}) {
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
      throw new Error(payload.error?.message || "The Discord dashboard action could not be completed.");
    }
    return payload;
  }

  function renderDashboard(payload) {
    if (typeof renderDiscordBotDashboard === "function" && payload) {
      renderDiscordBotDashboard(payload);
    }
  }

  function renderPostResult(post) {
    const status = document.querySelector("#discord-client-update-status");
    if (!status) return;
    status.replaceChildren();

    const channel = post.channelName ? `#${post.channelName}` : `channel ${post.channelId}`;
    const message = document.createTextNode(
      post.warning
        ? `Client update posted to ${channel}, but notifications were not verified. ${post.warning} `
        : `Client update posted and verified in ${channel}. `
    );
    const link = document.createElement("a");
    link.href = post.jumpUrl;
    link.target = "_blank";
    link.rel = "noopener noreferrer";
    link.textContent = "Open Discord message";
    status.append(message, link);
  }

  function setAnnouncementStatus(message) {
    const status = document.querySelector("#announcement-status");
    if (status) status.textContent = message;
  }

  function setClientUpdateStatus(message) {
    const status = document.querySelector("#discord-client-update-status");
    if (status) status.textContent = message;
  }
})();
