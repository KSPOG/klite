import {
  DISCORD_COMMANDS,
  listGuildDiscordCommands,
  registerGuildDiscordCommands,
  verifyRegisteredCommands
} from "./discord-commands.js";

const DISCORD_API = "https://discord.com/api/v10";

export async function handleDiscordDashboardActions(request, env, url, services) {
  if (request.method === "POST" && url.pathname === "/api/discord-bot/commands/register") {
    return registerCommands(env, services);
  }
  if (request.method === "POST" && url.pathname === "/api/discord-bot/client-updates/post") {
    return postAndVerifyClientUpdate(request, env, services);
  }
  return null;
}

async function registerCommands(env, services) {
  const accessResponse = await services.loadDashboard();
  if (!accessResponse.ok) return accessResponse;

  try {
    await registerGuildDiscordCommands(env);
    const verifiedCommands = verifyRegisteredCommands(await listGuildDiscordCommands(env));
    const dashboardResponse = await services.loadDashboard();
    if (!dashboardResponse.ok) return dashboardResponse;
    const dashboard = await dashboardResponse.json();
    const expectedNames = new Set(DISCORD_COMMANDS.map((command) => command.name));
    const dashboardNames = new Set((dashboard.commands || []).map((command) => command.name));
    const missing = [...expectedNames].filter((name) => !dashboardNames.has(name));
    if (missing.length) {
      return apiError(
        502,
        "discord_command_dashboard_stale",
        `Discord registered the commands, but the dashboard could not verify: ${missing.map((name) => `/${name}`).join(", ")}.`
      );
    }
    return json({
      registered: DISCORD_COMMANDS.length,
      commandNames: verifiedCommands
        .filter((command) => expectedNames.has(command.name))
        .map((command) => command.name),
      dashboard
    });
  } catch (error) {
    return apiError(
      502,
      error.code || "discord_command_registration_failed",
      error.message || "Slash commands could not be registered."
    );
  }
}

async function postAndVerifyClientUpdate(request, env, services) {
  let input;
  try {
    input = await request.json();
  } catch {
    return apiError(400, "invalid_json", "A JSON request body is required.");
  }
  if (!input || typeof input !== "object") {
    return apiError(400, "invalid_settings", "Enter valid client update settings.");
  }

  const updateResponse = await services.updateSettings({ ...input, postClientUpdate: true });
  if (!updateResponse.ok) return updateResponse;
  const dashboard = await updateResponse.json();
  const version = typeof input.clientUpdateVersion === "string"
    ? input.clientUpdateVersion.trim() : "";
  const updates = normalizeUpdates(input.clientUpdateNotes);
  const latest = (dashboard.clientUpdates?.history || []).find((entry) =>
    entry.version === version
      && (!updates || entry.updates === updates)
      && entry.channelId
      && entry.messageId
  );
  if (!latest) {
    return apiError(
      502,
      "client_update_not_recorded",
      "The settings request completed, but no matching Discord client-update message was recorded."
    );
  }

  let message;
  try {
    message = await discordApi(
      env,
      `/channels/${latest.channelId}/messages/${latest.messageId}`
    );
  } catch (error) {
    return apiError(
      502,
      error.code || "client_update_verification_failed",
      `${error.message} The dashboard will not report this update as verified.`
    );
  }

  const expectedVersionLine = `**Client version:** ${latest.version}`;
  const expectedRoleMention = latest.roleId ? `<@&${latest.roleId}>` : null;
  if (message.id !== latest.messageId
      || message.channel_id !== latest.channelId
      || typeof message.content !== "string"
      || !message.content.includes(expectedVersionLine)
      || !message.content.includes("**Updates:**")
      || (updates && !message.content.includes(updates))) {
    return apiError(
      502,
      "client_update_message_mismatch",
      "Discord returned a message, but its channel, ID, version, or update body did not match the requested post."
    );
  }

  const jumpUrl = `https://discord.com/channels/${env.DISCORD_GUILD_ID}/${latest.channelId}/${latest.messageId}`;
  const channel = (dashboard.channels || []).find((item) => item.id === latest.channelId);
  const role = (dashboard.roles || []).find((item) => item.id === latest.roleId);
  const mentionRoles = Array.isArray(message.mention_roles) ? message.mention_roles : [];
  const mentionVerified = !expectedRoleMention
    || (message.content.includes(expectedRoleMention) && mentionRoles.includes(latest.roleId));

  return json({
    dashboard,
    post: {
      verified: true,
      notificationVerified: mentionVerified,
      version: latest.version,
      channelId: latest.channelId,
      channelName: channel?.name || null,
      roleId: latest.roleId || null,
      roleName: role?.name || null,
      messageId: latest.messageId,
      jumpUrl,
      warning: mentionVerified ? null
        : "The Discord message exists, but Discord did not activate the notification-role mention. Make the role mentionable or grant the bot permission to mention roles."
    }
  });
}

async function discordApi(env, path) {
  if (!env.DISCORD_BOT_TOKEN) {
    const error = new Error("The Discord bot token is not configured.");
    error.code = "discord_bot_unavailable";
    throw error;
  }
  const response = await fetch(`${DISCORD_API}${path}`, {
    headers: { authorization: `Bot ${env.DISCORD_BOT_TOKEN}` }
  });
  if (!response.ok) {
    const details = await response.text();
    const error = new Error(
      `Discord could not verify the posted client update (${response.status}): ${details.slice(0, 240)}`
    );
    error.code = "client_update_verification_failed";
    throw error;
  }
  return response.json();
}

function normalizeUpdates(value) {
  if (typeof value !== "string") return null;
  const normalized = value
    .replace(/[\u0000-\u0008\u000b\u000c\u000e-\u001f\u007f]/g, " ")
    .replace(/\r\n?/g, "\n")
    .trim();
  return normalized ? normalized.slice(0, 3_000) : null;
}

function apiError(status, code, message) {
  return json({ error: { code, message } }, status);
}

function json(payload, status = 200) {
  return new Response(JSON.stringify(payload), {
    status,
    headers: {
      "content-type": "application/json; charset=utf-8",
      "cache-control": "no-store",
      "x-content-type-options": "nosniff"
    }
  });
}
