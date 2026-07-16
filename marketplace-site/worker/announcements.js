const MAX_ANNOUNCEMENTS_PER_SYNC = 20;

export async function announcementSettings(env) {
  const setting = await env.DB.prepare(
    "SELECT channel_id, enabled, configured_at, updated_at FROM discord_announcement_settings WHERE id = 1"
  ).first();
  const history = await env.DB.prepare(
    "SELECT plugin_id, version, event_type, channel_id, message_id, announced_at "
      + "FROM plugin_announcement_log ORDER BY announced_at DESC LIMIT 20"
  ).all();
  return {
    setting: setting ? {
      channelId: setting.channel_id,
      enabled: setting.enabled === 1,
      configuredAt: setting.configured_at,
      updatedAt: setting.updated_at
    } : null,
    history: (history.results || []).map((row) => ({
      pluginId: row.plugin_id,
      version: row.version,
      eventType: row.event_type,
      channelId: row.channel_id,
      messageId: row.message_id,
      announcedAt: row.announced_at
    }))
  };
}

export async function saveAnnouncementSettings(env, userId, channelId, enabled) {
  const channel = await fetchDiscordChannel(env, channelId);
  if (!channel) {
    return null;
  }
  const now = nowSeconds();
  await env.DB.prepare(
    "INSERT INTO discord_announcement_settings "
      + "(id, channel_id, enabled, configured_by, configured_at, updated_at) "
      + "VALUES (1, ?, ?, ?, ?, ?) "
      + "ON CONFLICT(id) DO UPDATE SET channel_id = excluded.channel_id, "
      + "enabled = excluded.enabled, configured_by = excluded.configured_by, "
      + "updated_at = excluded.updated_at"
  ).bind(channelId, enabled ? 1 : 0, userId, now, now).run();
  return { channelId, enabled, channelName: channel.name };
}

export async function syncPluginAnnouncements(env, announcedBy) {
  const setting = await env.DB.prepare(
    "SELECT channel_id, enabled FROM discord_announcement_settings WHERE id = 1"
  ).first();
  if (!setting || setting.enabled !== 1) {
    return { announced: 0, skipped: "disabled" };
  }
  if (!env.DISCORD_BOT_TOKEN) {
    throw new Error("DISCORD_BOT_TOKEN is not configured");
  }
  const response = await env.ASSETS.fetch(
    new Request(new URL("/plugins.json", env.PUBLIC_ORIGIN))
  );
  if (!response.ok) {
    throw new Error(`Marketplace catalog returned HTTP ${response.status}`);
  }
  const catalog = await response.json();
  const plugins = Array.isArray(catalog?.plugins)
    ? catalog.plugins.filter((plugin) => plugin?.status === "available") : [];
  let announced = 0;
  for (const plugin of plugins) {
    if (announced >= MAX_ANNOUNCEMENTS_PER_SYNC) {
      break;
    }
    const pluginId = normalizePluginId(plugin.id);
    const version = normalizeVersion(plugin.descriptor?.version);
    const updatedAt = typeof plugin.updatedAt === "string" ? plugin.updatedAt : null;
    if (!pluginId || !version || !updatedAt) {
      continue;
    }
    const previous = await env.DB.prepare(
      "SELECT announced_version, announced_updated_at "
        + "FROM plugin_announcement_state WHERE plugin_id = ?"
    ).bind(pluginId).first();
    const eventType = !previous ? "new"
      : previous.announced_version !== version || previous.announced_updated_at !== updatedAt
        ? "update" : null;
    if (!eventType) {
      continue;
    }
    const message = await postDiscordAnnouncement(env, setting.channel_id, plugin, eventType);
    const now = nowSeconds();
    await env.DB.prepare(
      "INSERT INTO plugin_announcement_state "
        + "(plugin_id, announced_version, announced_updated_at, message_id, announced_at) "
        + "VALUES (?, ?, ?, ?, ?) "
        + "ON CONFLICT(plugin_id) DO UPDATE SET announced_version = excluded.announced_version, "
        + "announced_updated_at = excluded.announced_updated_at, "
        + "message_id = excluded.message_id, announced_at = excluded.announced_at"
    ).bind(pluginId, version, updatedAt, message.id, now).run();
    await env.DB.prepare(
      "INSERT INTO plugin_announcement_log "
        + "(id, plugin_id, version, event_type, channel_id, message_id, announced_by, announced_at) "
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
    ).bind(crypto.randomUUID(), pluginId, version, eventType, setting.channel_id,
      message.id, announcedBy, now).run();
    announced += 1;
  }
  return { announced, available: plugins.length };
}

async function fetchDiscordChannel(env, channelId) {
  if (!env.DISCORD_BOT_TOKEN) {
    return null;
  }
  const response = await fetch(`https://discord.com/api/v10/channels/${channelId}`, {
    headers: { authorization: `Bot ${env.DISCORD_BOT_TOKEN}` }
  });
  if (!response.ok) {
    return null;
  }
  const channel = await response.json();
  return channel.guild_id === env.DISCORD_GUILD_ID && (channel.type === 0 || channel.type === 5)
    ? channel : null;
}

async function postDiscordAnnouncement(env, channelId, plugin, eventType) {
  const response = await fetch(
    `https://discord.com/api/v10/channels/${channelId}/messages`,
    {
      method: "POST",
      headers: {
        authorization: `Bot ${env.DISCORD_BOT_TOKEN}`,
        "content-type": "application/json"
      },
      body: JSON.stringify(buildDiscordAnnouncement(env, plugin, eventType))
    }
  );
  if (!response.ok) {
    const details = await response.text();
    throw new Error(
      `Discord announcement failed with HTTP ${response.status}: ${details.slice(0, 200)}`
    );
  }
  return response.json();
}

export function buildDiscordAnnouncement(env, plugin, eventType) {
  const descriptor = plugin.descriptor || {};
  const name = normalizeDiscordText(descriptor.name, 256) || plugin.id;
  const version = normalizeDiscordText(descriptor.version, 64) || "unknown";
  const authors = Array.isArray(descriptor.authors) ? descriptor.authors.join(", ") : "Unknown";
  const categories = Array.isArray(plugin.categories) ? plugin.categories.join(", ") : "Other";
  const tags = Array.isArray(descriptor.tags) ? descriptor.tags.join(", ") : "None";
  const embed = {
    title: eventType === "new" ? `New plugin: ${name}` : `Plugin updated: ${name}`,
    description: normalizeDiscordText(descriptor.description, 4_096)
      || "No description provided.",
    color: eventType === "new" ? 0x4fdcff : 0xff681f,
    fields: [
      { name: "Version", value: version, inline: true },
      {
        name: "Access",
        value: normalizeDiscordText(plugin.type || plugin.access, 128) || "Public",
        inline: true
      },
      {
        name: "Minimum KLite",
        value: normalizeDiscordText(descriptor.minClientVersion, 128) || "Not specified",
        inline: true
      },
      {
        name: "Authors",
        value: normalizeDiscordText(authors, 1_024) || "Unknown",
        inline: false
      },
      {
        name: "Categories",
        value: normalizeDiscordText(categories, 1_024) || "Other",
        inline: false
      },
      {
        name: "Tags",
        value: normalizeDiscordText(tags, 1_024) || "None",
        inline: false
      },
      {
        name: "Released",
        value: normalizeDiscordText(plugin.releasedAt, 128) || "Not specified",
        inline: true
      }
    ],
    footer: { text: `KLite Plugin Marketplace - ${plugin.id}` },
    timestamp: typeof plugin.updatedAt === "string"
      ? plugin.updatedAt : new Date().toISOString()
  };
  if (isSafeHttpsUrl(plugin.homepageUrl)) {
    embed.url = plugin.homepageUrl;
  }
  if (typeof plugin.iconPath === "string"
      && /^assets\/plugins\/[a-z0-9._-]+\.(png|jpe?g)$/.test(plugin.iconPath)) {
    embed.thumbnail = {
      url: new URL(`/${plugin.iconPath}`, env.PUBLIC_ORIGIN).toString()
    };
  }
  return { embeds: [embed], allowed_mentions: { parse: [] } };
}

export function normalizeDiscordChannelId(value) {
  if (typeof value !== "string") {
    return null;
  }
  const channelId = value.trim();
  return /^\d{17,20}$/.test(channelId) ? channelId : null;
}

function normalizePluginId(value) {
  if (typeof value !== "string") {
    return null;
  }
  const id = value.trim().toLowerCase();
  return /^[a-z0-9][a-z0-9-]{2,63}$/.test(id) ? id : null;
}

function normalizeVersion(value) {
  if (typeof value !== "string") {
    return null;
  }
  const version = value.trim();
  return /^(0|[1-9]\d*)\.(0|[1-9]\d*)\.(0|[1-9]\d*)(?:[-+][0-9A-Za-z.-]+)?$/.test(version)
    && version.length <= 64 ? version : null;
}

function normalizeDiscordText(value, maximum) {
  if (typeof value !== "string") {
    return null;
  }
  const text = value.trim()
    .replace(/[\u0000-\u001f\u007f]/g, " ")
    .replace(/\s+/g, " ");
  return text ? text.slice(0, maximum) : null;
}

function isSafeHttpsUrl(value) {
  if (typeof value !== "string") {
    return false;
  }
  try {
    const url = new URL(value);
    return url.protocol === "https:" && !url.username && !url.password;
  } catch {
    return false;
  }
}

function nowSeconds() {
  return Math.floor(Date.now() / 1000);
}
