import { pluginDeveloperRoleId } from "./discord-dashboard.js";

const DISCORD_API = "https://discord.com/api/v10";

/**
 * Refreshes the Discord half of the Plugin Dev capability from the guild's
 * current membership. Website roles remain independently managed in D1.
 *
 * A failed Discord request deliberately leaves the last known value intact so
 * a temporary Discord outage cannot revoke access. Callers can continue using
 * the existing, time-bounded verification result.
 */
export async function refreshPluginDeveloperRole(
  env,
  userId,
  { fetchImpl = fetch } = {}
) {
  if (!env.DISCORD_BOT_TOKEN || !env.DISCORD_GUILD_ID || !userId) {
    return { refreshed: false, reason: "discord_not_configured" };
  }

  const account = await env.DB.prepare(
    "SELECT discord_id FROM discord_accounts WHERE user_id = ?"
  ).bind(userId).first();
  if (!account?.discord_id) {
    return { refreshed: false, reason: "discord_not_linked" };
  }

  const roleId = await pluginDeveloperRoleId(env);
  if (!roleId) {
    return { refreshed: false, reason: "plugin_dev_role_not_configured" };
  }

  const response = await fetchImpl(
    `${DISCORD_API}/guilds/${env.DISCORD_GUILD_ID}/members/${account.discord_id}`,
    {
      headers: {
        authorization: `Bot ${env.DISCORD_BOT_TOKEN}`
      }
    }
  );

  let hasRole = false;
  if (response.status !== 404) {
    if (!response.ok) {
      throw new Error(`Discord member verification returned HTTP ${response.status}`);
    }
    const member = await response.json();
    if (!Array.isArray(member?.roles)) {
      throw new Error("Discord member verification returned an invalid response");
    }
    hasRole = member.roles.includes(roleId);
  }

  const verifiedAt = Math.floor(Date.now() / 1000);
  await env.DB.prepare(
    `UPDATE discord_accounts
     SET plugin_dev_role = ?, role_verified_at = ?
     WHERE user_id = ?`
  ).bind(hasRole ? 1 : 0, verifiedAt, userId).run();

  return { refreshed: true, hasRole, verifiedAt };
}

export async function refreshPluginDeveloperRoleSafely(env, userId, options) {
  try {
    return await refreshPluginDeveloperRole(env, userId, options);
  } catch (error) {
    console.warn("Unable to refresh Discord Plugin Dev membership", error);
    return { refreshed: false, reason: "discord_unavailable" };
  }
}
