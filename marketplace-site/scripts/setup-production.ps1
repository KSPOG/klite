[CmdletBinding()]
param(
    [string]$DatabaseId,
    [string]$PublicOrigin,
    [switch]$SkipInstall,
    [switch]$SkipUiFix,
    [switch]$SkipMigrations,
    [switch]$SkipDeploy
)

Set-StrictMode -Version Latest
$ErrorActionPreference = "Stop"

$marketplaceRoot = Split-Path -Parent $PSScriptRoot
$wranglerPath = Join-Path $marketplaceRoot "wrangler.jsonc"
$uiFixPath = Join-Path $PSScriptRoot "apply-login-ui-fix.ps1"

function Assert-LastExitCode {
    param([string]$Operation)
    if ($LASTEXITCODE -ne 0) {
        throw "$Operation failed with exit code $LASTEXITCODE."
    }
}

function Invoke-NpxCapture {
    param([Parameter(Mandatory = $true)][string[]]$Arguments)
    $output = & npx.cmd @Arguments 2>&1 | Out-String
    $exitCode = $LASTEXITCODE
    if ($exitCode -ne 0) {
        throw "npx $($Arguments -join ' ') failed with exit code $exitCode.`n$output"
    }
    return $output
}

function Find-Uuid {
    param([string]$Text)
    $match = [regex]::Match(
        $Text,
        '(?i)\b[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}\b'
    )
    if ($match.Success) { return $match.Value }
    return $null
}

function Set-WranglerStringValue {
    param(
        [Parameter(Mandatory = $true)][string]$Content,
        [Parameter(Mandatory = $true)][string]$PropertyName,
        [Parameter(Mandatory = $true)][string]$Value
    )
    $escapedName = [regex]::Escape($PropertyName)
    $pattern = '("' + $escapedName + '"\s*:\s*")[^"]*(")'
    $replacement = '${1}' + $Value + '${2}'
    $updated = [regex]::Replace($Content, $pattern, $replacement, 1)
    if ($updated -eq $Content) {
        throw "Could not update '$PropertyName' in wrangler.jsonc."
    }
    return $updated
}

function Get-WranglerStringValue {
    param(
        [Parameter(Mandatory = $true)][string]$Content,
        [Parameter(Mandatory = $true)][string]$PropertyName
    )
    $escapedName = [regex]::Escape($PropertyName)
    $match = [regex]::Match($Content, '("' + $escapedName + '"\s*:\s*")([^"]*)(")')
    if (-not $match.Success) { return $null }
    return $match.Groups[2].Value
}

function New-RandomSecret {
    $bytes = New-Object byte[] 48
    $rng = [System.Security.Cryptography.RandomNumberGenerator]::Create()
    try {
        $rng.GetBytes($bytes)
    } finally {
        $rng.Dispose()
    }
    return [Convert]::ToBase64String($bytes)
}

if (-not (Test-Path -LiteralPath $wranglerPath)) {
    throw "Could not find marketplace-site/wrangler.jsonc at: $wranglerPath"
}
if (-not (Get-Command node -ErrorAction SilentlyContinue)) {
    throw "Node.js is not installed or is not available in PATH."
}
if (-not (Get-Command npm.cmd -ErrorAction SilentlyContinue)) {
    throw "npm.cmd is not available in PATH. Reinstall Node.js with npm enabled."
}
if (-not (Get-Command npx.cmd -ErrorAction SilentlyContinue)) {
    throw "npx.cmd is not available in PATH. Reinstall Node.js with npm enabled."
}

Push-Location $marketplaceRoot
try {
    if (-not $SkipInstall) {
        Write-Host "Installing marketplace dependencies..." -ForegroundColor Cyan
        & npm.cmd install
        Assert-LastExitCode "npm install"
    }

    Write-Host "Checking Cloudflare authentication..." -ForegroundColor Cyan
    & npx.cmd wrangler whoami
    Assert-LastExitCode "wrangler whoami"

    if (-not $SkipUiFix) {
        & powershell.exe -NoProfile -ExecutionPolicy Bypass -File $uiFixPath
        Assert-LastExitCode "Applying the login UI fix"
    }

    $wranglerContent = Get-Content -LiteralPath $wranglerPath -Raw

    if ([string]::IsNullOrWhiteSpace($DatabaseId)) {
        Write-Host "Looking for the klite-marketplace D1 database..." -ForegroundColor Cyan
        $databaseList = Invoke-NpxCapture -Arguments @("wrangler", "d1", "list")

        $namedLine = ($databaseList -split '\r?\n' | Where-Object {
            $_ -match '\bklite-marketplace\b'
        } | Select-Object -First 1)

        if ($namedLine) {
            $DatabaseId = Find-Uuid $namedLine
        }

        if ([string]::IsNullOrWhiteSpace($DatabaseId)) {
            Write-Host "Creating the klite-marketplace D1 database..." -ForegroundColor Cyan
            $createOutput = Invoke-NpxCapture -Arguments @("wrangler", "d1", "create", "klite-marketplace")
            Write-Host $createOutput
            $DatabaseId = Find-Uuid $createOutput
        }
    }

    if ([string]::IsNullOrWhiteSpace($DatabaseId)) {
        throw @"
The D1 database ID could not be detected automatically.
Run: npx wrangler d1 list
Then rerun this script with: -DatabaseId <uuid>
"@
    }

    $wranglerContent = Set-WranglerStringValue $wranglerContent "database_id" $DatabaseId

    if (-not [string]::IsNullOrWhiteSpace($PublicOrigin)) {
        $normalizedOrigin = $PublicOrigin.TrimEnd('/')
        if ($normalizedOrigin -notmatch '^https://') {
            throw "PublicOrigin must be an HTTPS origin, for example https://example.workers.dev"
        }
        $wranglerContent = Set-WranglerStringValue $wranglerContent "PUBLIC_ORIGIN" $normalizedOrigin
    }

    $timestamp = Get-Date -Format "yyyyMMdd-HHmmss"
    $wranglerBackup = "$wranglerPath.$timestamp.bak"
    Copy-Item -LiteralPath $wranglerPath -Destination $wranglerBackup -Force
    Set-Content -LiteralPath $wranglerPath -Value $wranglerContent -Encoding UTF8
    Write-Host "Configured D1 database: $DatabaseId" -ForegroundColor Green
    Write-Host "Wrangler backup: $wranglerBackup" -ForegroundColor DarkGray

    Write-Host "Checking PASSWORD_PEPPER..." -ForegroundColor Cyan
    $secretList = Invoke-NpxCapture -Arguments @("wrangler", "secret", "list")
    if ($secretList -notmatch '(?m)^\s*PASSWORD_PEPPER\s*$' -and
        $secretList -notmatch '"name"\s*:\s*"PASSWORD_PEPPER"') {
        Write-Host "PASSWORD_PEPPER is missing; creating it without printing the value..." -ForegroundColor Yellow
        $pepper = New-RandomSecret
        $pepper | & npx.cmd wrangler secret put PASSWORD_PEPPER
        Assert-LastExitCode "Configuring PASSWORD_PEPPER"
    } else {
        Write-Host "Existing PASSWORD_PEPPER preserved." -ForegroundColor Green
    }

    if (-not $SkipMigrations) {
        Write-Host "Applying remote D1 migrations..." -ForegroundColor Cyan
        & npm.cmd run db:migrate:remote
        Assert-LastExitCode "Remote D1 migration"
    }

    if (-not $SkipDeploy) {
        Write-Host "Deploying the marketplace Worker..." -ForegroundColor Cyan
        $deployOutput = Invoke-NpxCapture -Arguments @("wrangler", "deploy")
        Write-Host $deployOutput

        if ([string]::IsNullOrWhiteSpace($PublicOrigin)) {
            $workerUrlMatch = [regex]::Match(
                $deployOutput,
                'https://[a-zA-Z0-9.-]+\.workers\.dev'
            )
            if ($workerUrlMatch.Success) {
                $detectedOrigin = $workerUrlMatch.Value.TrimEnd('/')
                $latestWranglerContent = Get-Content -LiteralPath $wranglerPath -Raw
                $currentOrigin = Get-WranglerStringValue $latestWranglerContent "PUBLIC_ORIGIN"
                if ($currentOrigin -ne $detectedOrigin) {
                    Write-Host "Updating PUBLIC_ORIGIN to $detectedOrigin and redeploying..." -ForegroundColor Cyan
                    $latestWranglerContent = Set-WranglerStringValue `
                        -Content $latestWranglerContent `
                        -PropertyName "PUBLIC_ORIGIN" `
                        -Value $detectedOrigin
                    Set-Content -LiteralPath $wranglerPath -Value $latestWranglerContent -Encoding UTF8
                    $secondDeploy = Invoke-NpxCapture -Arguments @("wrangler", "deploy")
                    Write-Host $secondDeploy
                }
                $PublicOrigin = $detectedOrigin
            } else {
                Write-Warning @"
The Worker URL could not be detected from Wrangler output.
Set PUBLIC_ORIGIN in wrangler.jsonc to the exact Worker or custom-domain origin,
then run: npm run deploy
"@
            }
        }
    }

    Write-Host "" 
    Write-Host "KLite marketplace login deployment setup completed." -ForegroundColor Green
    if (-not [string]::IsNullOrWhiteSpace($PublicOrigin)) {
        Write-Host "Marketplace origin: $PublicOrigin" -ForegroundColor Green
        Write-Host "Test endpoint: $PublicOrigin/api/account" -ForegroundColor DarkGray
    }
    Write-Host "An unauthenticated /api/account request should return HTTP 401 with JSON, not HTML or 404." -ForegroundColor DarkGray
} finally {
    Pop-Location
}
