const DISCORD_API = "https://discord.com/api/v10";

export const DISCORD_COMMANDS = Object.freeze([
  {
    name: "link",
    description: "Link your Discord user to a KLite marketplace account",
    options: [
      {
        type: 3,
        name: "code",
        description: "One-time code generated on the KLite account page",
        required: true,
        min_length: 8,
        max_length: 8
      }
    ]
  },
  {
    name: "account",
    description: "Show the KLite account linked to your Discord user"
  },
  {
    name: "client-updates",
    description: "Subscribe to or unsubscribe from KLite client update notifications",
    options: [
      {
        type: 3,
        name: "action",
        description: "Choose whether to receive client update notifications",
        required: true,
        choices: [
          { name: "Subscribe", value: "subscribe" },
          { name: "Unsubscribe", value: "unsubscribe" }
        ]
      }
    ]
  }
]);

export async function registerGuildDiscordCommands(env) {
  const applicationId = env.DISCORD_APPLICATION_ID || env.DISCORD_CLIENT_ID;
  if (!applicationId || !env.DISCORD_BOT_TOKEN || !env.DISCORD_GUILD_ID) {
    throw discordCommandError(
      "discord_command_configuration_missing",
      "Discord application ID, bot token, and designated server ID are required."
    );
  }

  const commands = await discordApi(
    env,
    `/applications/${applicationId}/guilds/${env.DISCORD_GUILD_ID}/commands`,
    { method: "PUT", body: DISCORD_COMMANDS }
  );
  verifyRegisteredCommands(commands);
  return commands;
}

export async function listGuildDiscordCommands(env) {
  const applicationId = env.DISCORD_APPLICATION_ID || env.DISCORD_CLIENT_ID;
  if (!applicationId || !env.DISCORD_BOT_TOKEN || !env.DISCORD_GUILD_ID) {
    throw discordCommandError(
      "discord_command_configuration_missing",
      "Discord application ID, bot token, and designated server ID are required."
    );
  }
  return discordApi(
    env,
    `/applications/${applicationId}/guilds/${env.DISCORD_GUILD_ID}/commands`
  );
}

export function verifyRegisteredCommands(commands) {
  if (!Array.isArray(commands)) {
    throw discordCommandError(
      "discord_command_registration_invalid",
      "Discord returned an invalid slash-command registration response."
    );
  }
  const names = new Set(commands.map((command) => command?.name));
  const missing = DISCORD_COMMANDS
    .map((command) => command.name)
    .filter((name) => !names.has(name));
  if (missing.length) {
    throw discordCommandError(
      "discord_command_registration_incomplete",
      `Discord did not register: ${missing.map((name) => `/${name}`).join(", ")}.`
    );
  }
  return commands;
}

async function discordApi(env, path, options = {}) {
  const response = await fetch(`${DISCORD_API}${path}`, {
    method: options.method || "GET",
    headers: {
      authorization: `Bot ${env.DISCORD_BOT_TOKEN}`,
      ...(options.body ? { "content-type": "application/json" } : {})
    },
    body: options.body ? JSON.stringify(options.body) : undefined
  });
  if (!response.ok) {
    const details = await response.text();
    throw discordCommandError(
      "discord_command_registration_failed",
      `Discord rejected slash-command registration (${response.status}): ${details.slice(0, 240)}`
    );
  }
  return response.status === 204 ? null : response.json();
}

function discordCommandError(code, message) {
  const error = new Error(message);
  error.code = code;
  return error;
}
