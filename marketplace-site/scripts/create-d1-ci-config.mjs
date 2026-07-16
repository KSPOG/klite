import { writeFile } from "node:fs/promises";

const databaseId = process.env.CLOUDFLARE_D1_DATABASE_ID?.trim();

if (!databaseId) {
  throw new Error(
    "CLOUDFLARE_D1_DATABASE_ID is required. Add it as a GitHub Actions repository secret."
  );
}

if (!/^[0-9a-f]{8}-[0-9a-f-]{27,}$/i.test(databaseId)) {
  throw new Error("CLOUDFLARE_D1_DATABASE_ID does not look like a valid D1 UUID.");
}

const config = {
  $schema: "./node_modules/wrangler/config-schema.json",
  name: "klite-marketplace-migrations",
  compatibility_date: "2026-07-16",
  d1_databases: [
    {
      binding: "DB",
      database_name: "klite-marketplace",
      database_id: databaseId,
      migrations_dir: "migrations"
    }
  ]
};

await writeFile(
  new URL("../wrangler.migrations-ci.json", import.meta.url),
  `${JSON.stringify(config, null, 2)}\n`,
  "utf8"
);

console.log("Created temporary Wrangler configuration for D1 migrations.");
