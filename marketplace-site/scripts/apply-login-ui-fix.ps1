[CmdletBinding()]
param()

Set-StrictMode -Version Latest
$ErrorActionPreference = "Stop"

$marketplaceRoot = Split-Path -Parent $PSScriptRoot
$appPath = Join-Path $marketplaceRoot "public\app.js"

if (-not (Test-Path -LiteralPath $appPath)) {
    throw "Could not find marketplace-site/public/app.js at: $appPath"
}

$oldFunction = @'
async function api(path, options = {}) {
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
    const error = new Error(payload.error?.message || "The request could not be completed.");
    error.status = response.status;
    throw error;
  }
  return payload;
}
'@

$newFunction = @'
async function api(path, options = {}) {
  let response;
  try {
    response = await fetch(path, {
      credentials: "same-origin",
      ...options,
      headers: {
        ...(options.body ? { "content-type": "application/json" } : {}),
        ...options.headers
      }
    });
  } catch (cause) {
    const error = new Error(
      "Unable to reach the KLite API. Verify that the Cloudflare Worker is deployed and that this site is using the Worker or its custom domain."
    );
    error.status = 0;
    error.cause = cause;
    throw error;
  }

  const responseText = await response.text();
  let payload = {};
  if (responseText) {
    try {
      payload = JSON.parse(responseText);
    } catch {
      // Cloudflare may return HTML for a missing Worker route or deployment error.
    }
  }

  if (!response.ok) {
    let message = payload.error?.message;
    if (!message) {
      if (response.status === 404) {
        message = "The marketplace API route was not found. Deploy the Cloudflare Worker, not only the static Pages site.";
      } else if (response.status >= 500) {
        message = `The marketplace API failed with HTTP ${response.status}. Check the Worker logs, D1 binding, database migrations, and PASSWORD_PEPPER secret.`;
      } else {
        message = `The request failed with HTTP ${response.status}.`;
      }
    }

    const error = new Error(message);
    error.status = response.status;
    error.payload = payload;
    throw error;
  }

  return payload;
}
'@

$content = Get-Content -LiteralPath $appPath -Raw

if ($content.Contains($newFunction.Trim())) {
    Write-Host "Login API error handling is already updated." -ForegroundColor Green
    exit 0
}

if (-not $content.Contains($oldFunction.Trim())) {
    throw @"
The expected api() function was not found in public/app.js.
The repository may have changed since this fix was prepared. No file was modified.
Apply marketplace-site/patches/app-js-api-error-handling.patch manually or update this script for the current api() function.
"@
}

$timestamp = Get-Date -Format "yyyyMMdd-HHmmss"
$backupPath = "$appPath.$timestamp.bak"
Copy-Item -LiteralPath $appPath -Destination $backupPath -Force

$content = $content.Replace($oldFunction.Trim(), $newFunction.Trim())
Set-Content -LiteralPath $appPath -Value $content -Encoding UTF8

Write-Host "Updated: $appPath" -ForegroundColor Green
Write-Host "Backup:  $backupPath" -ForegroundColor DarkGray
