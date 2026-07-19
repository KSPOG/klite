import {
  DISCORD_COMMANDS,
  listGuildDiscordCommands,
  registerGuildDiscordCommands,
  verifyRegisteredCommands
} from "../worker/discord-commands.js";

const env = {
  DISCORD_APPLICATION_ID: process.env.DISCORD_APPLICATION_ID,
  DISCORD_CLIENT_ID: process.env.DISCORD_CLIENT_ID,
  DISCORD_BOT_TOKEN: process.env.DISCORD_BOT_TOKEN,
  DISCORD_GUILD_ID: process.env.DISCORD_GUILD_ID
};

if (!(env.DISCORD_APPLICATION_ID || env.DISCORD_CLIENT_ID)
    || !env.DISCORD_BOT_TOKEN || !env.DISCORD_GUILD_ID) {
  throw new Error(
    "DISCORD_APPLICATION_ID (or DISCORD_CLIENT_ID), DISCORD_BOT_TOKEN, and DISCORD_GUILD_ID are required"
  );
}

await registerGuildDiscordCommands(env);
const commands = verifyRegisteredCommands(await listGuildDiscordCommands(env));
const names = commands
  .filter((command) => DISCORD_COMMANDS.some((expected) => expected.name === command.name))
  .map((command) => `/${command.name}`)
  .join(", ");

console.log(`Registered and verified ${DISCORD_COMMANDS.length} guild Discord commands: ${names}`);
