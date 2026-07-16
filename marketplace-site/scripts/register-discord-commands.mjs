const applicationId = process.env.DISCORD_APPLICATION_ID;
const botToken = process.env.DISCORD_BOT_TOKEN;

if (!applicationId || !botToken) {
  throw new Error("DISCORD_APPLICATION_ID and DISCORD_BOT_TOKEN are required");
}

const commands = [
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
  }
];

const response = await fetch(
  `https://discord.com/api/v10/applications/${applicationId}/commands`,
  {
    method: "PUT",
    headers: {
      authorization: `Bot ${botToken}`,
      "content-type": "application/json"
    },
    body: JSON.stringify(commands)
  }
);

if (!response.ok) {
  throw new Error(`Discord command registration failed (${response.status}): ${await response.text()}`);
}

console.log(`Registered ${commands.length} global Discord commands.`);
