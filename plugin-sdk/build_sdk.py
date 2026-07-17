#!/usr/bin/env python3
"""Build a compile-only KLite plugin SDK and standalone Gradle starter ZIP.

The output deliberately contains only RuneLite API classes and an allowlisted
subset of KLite/RuneLite client-side plugin contracts. It never packages the
full client JAR or private client implementation packages.
"""

from __future__ import annotations

import hashlib
import json
import os
import shutil
import sys
import zipfile
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
CLIENT_CLASSES = ROOT / "runelite-client" / "build" / "classes" / "java" / "main"
API_LIBS = ROOT / "runelite-api" / "build" / "libs"
TEMPLATE_ROOT = ROOT / "plugin-sdk" / "template"
OUTPUT_ROOT = ROOT / "dist" / "plugin-sdk"
SDK_NAME = "KLite-Plugin-SDK.jar"
STARTER_NAME = "KLite-Plugin-Starter.zip"
MANIFEST_NAME = "sdk-manifest.json"

EXACT_CLIENT_CLASSES = {
    "net/runelite/client/plugins/Plugin.class",
    "net/runelite/client/plugins/PluginDescriptor.class",
    "net/runelite/client/eventbus/Subscribe.class",
}

CLIENT_CLASS_PREFIXES = (
    "net/runelite/client/plugins/Plugin$",
    "net/runelite/client/plugins/PluginDescriptor$",
    "net/runelite/client/config/Config.class",
    "net/runelite/client/config/ConfigGroup.class",
    "net/runelite/client/config/ConfigItem.class",
    "net/runelite/client/config/ConfigSection.class",
    "net/runelite/client/config/ConfigTitle.class",
    "net/runelite/client/config/Range.class",
    "net/runelite/client/config/Alpha.class",
    "net/runelite/client/config/Units.class",
    "net/runelite/client/config/Icon.class",
    "net/runelite/client/config/Secret.class",
    "net/runelite/client/config/Button.class",
    "net/runelite/client/config/Keybind.class",
    "net/runelite/client/config/ModifierlessKeybind.class",
    "net/runelite/client/plugins/klite/api/",
    "net/runelite/client/plugins/klite/automation/AutomationContext",
    "net/runelite/client/plugins/klite/automation/AutomationManager",
    "net/runelite/client/plugins/klite/automation/AutomationResult",
    "net/runelite/client/plugins/klite/automation/AutomationState",
    "net/runelite/client/plugins/klite/automation/AutomationStatus",
    "net/runelite/client/plugins/klite/automation/AutomationTask",
    "net/runelite/client/plugins/klite/walker/WebWalkBankSnapshot",
    "net/runelite/client/plugins/klite/walker/WebWalkResult",
    "net/runelite/client/plugins/klite/walker/WebWalkState",
    "net/runelite/client/plugins/klite/walker/WebWalkTransport",
    "net/runelite/client/plugins/klite/walker/WebWalkTransportAction",
    "net/runelite/client/plugins/klite/walker/WebWalkTransportProvider",
    "net/runelite/client/plugins/klite/walker/WebWalker.class",
    "net/runelite/client/plugins/klite/walker/WebWalker$",
)

EXCLUDED_CLIENT_PREFIXES = (
    "net/runelite/client/plugins/klite/api/DefaultKLiteClientApi",
)


def sha256(path: Path) -> str:
    digest = hashlib.sha256()
    with path.open("rb") as stream:
        for chunk in iter(lambda: stream.read(1024 * 1024), b""):
            digest.update(chunk)
    return digest.hexdigest()


def api_jar() -> Path:
    candidates = sorted(
        (path for path in API_LIBS.glob("*.jar") if "sources" not in path.name and "javadoc" not in path.name),
        key=lambda path: path.stat().st_mtime,
        reverse=True,
    )
    if not candidates:
        raise FileNotFoundError(f"No RuneLite API JAR found in {API_LIBS}")
    return candidates[0]


def client_class_allowed(relative: str) -> bool:
    if relative in EXACT_CLIENT_CLASSES:
        return True
    if any(relative.startswith(prefix) for prefix in EXCLUDED_CLIENT_PREFIXES):
        return False
    return any(relative.startswith(prefix) for prefix in CLIENT_CLASS_PREFIXES)


def add_bytes(archive: zipfile.ZipFile, name: str, data: bytes) -> None:
    info = zipfile.ZipInfo(name)
    info.date_time = (2026, 1, 1, 0, 0, 0)
    info.compress_type = zipfile.ZIP_DEFLATED
    info.external_attr = 0o644 << 16
    archive.writestr(info, data)


def build_sdk(version: str) -> Path:
    if not CLIENT_CLASSES.is_dir():
        raise FileNotFoundError(f"Client classes were not built: {CLIENT_CLASSES}")

    OUTPUT_ROOT.mkdir(parents=True, exist_ok=True)
    output = OUTPUT_ROOT / SDK_NAME
    entries: set[str] = set()

    with zipfile.ZipFile(output, "w") as archive:
        with zipfile.ZipFile(api_jar(), "r") as source:
            for entry in sorted(source.namelist()):
                if not entry.endswith(".class") or not entry.startswith("net/runelite/api/"):
                    continue
                if entry in entries:
                    continue
                add_bytes(archive, entry, source.read(entry))
                entries.add(entry)

        for class_file in sorted(CLIENT_CLASSES.rglob("*.class")):
            relative = class_file.relative_to(CLIENT_CLASSES).as_posix()
            if not client_class_allowed(relative):
                continue
            if relative in entries:
                continue
            add_bytes(archive, relative, class_file.read_bytes())
            entries.add(relative)

        properties = (
            f"sdk.version={version}\n"
            f"sdk.client.commit={os.environ.get('GITHUB_SHA', 'local')}\n"
            "sdk.scope=compile-only-public-api\n"
        ).encode("utf-8")
        add_bytes(archive, "META-INF/klite-plugin-sdk.properties", properties)
        add_bytes(
            archive,
            "META-INF/NOTICE.txt",
            (
                "KLite Plugin SDK - compile-only public API.\n"
                "This archive intentionally excludes the KLite client implementation.\n"
                "Do not package this SDK inside a plugin JAR.\n"
            ).encode("utf-8"),
        )

    if "net/runelite/client/plugins/klite/api/KLiteClientApi.class" not in entries:
        raise RuntimeError("KLiteClientApi was not included in the SDK")
    if "net/runelite/client/plugins/Plugin.class" not in entries:
        raise RuntimeError("Plugin base class was not included in the SDK")

    forbidden = [
        entry
        for entry in entries
        if entry.startswith("net/runelite/client/") and not client_class_allowed(entry)
    ]
    if forbidden:
        raise RuntimeError(f"Unapproved client classes entered the SDK: {forbidden[:10]}")

    print(f"Built {output} with {len(entries)} public class files")
    return output


def copy_template_tree(stage: Path, sdk: Path, version: str) -> None:
    if stage.exists():
        shutil.rmtree(stage)
    shutil.copytree(TEMPLATE_ROOT, stage)

    for wrapper_file in (ROOT / "gradlew", ROOT / "gradlew.bat"):
        shutil.copy2(wrapper_file, stage / wrapper_file.name)
    shutil.copytree(ROOT / "gradle" / "wrapper", stage / "gradle" / "wrapper", dirs_exist_ok=True)

    libs = stage / "libs"
    libs.mkdir(parents=True, exist_ok=True)
    shutil.copy2(sdk, libs / SDK_NAME)

    for path in stage.rglob("*"):
        if not path.is_file() or path.suffix.lower() not in {".md", ".kts", ".java", ".json", ".properties"}:
            continue
        text = path.read_text("utf-8")
        path.write_text(text.replace("@SDK_VERSION@", version), "utf-8")


def build_starter(sdk: Path, version: str) -> Path:
    stage = OUTPUT_ROOT / "starter"
    copy_template_tree(stage, sdk, version)
    output = OUTPUT_ROOT / STARTER_NAME
    with zipfile.ZipFile(output, "w", zipfile.ZIP_DEFLATED) as archive:
        for path in sorted(stage.rglob("*")):
            if path.is_file():
                archive.write(path, path.relative_to(stage).as_posix())
    shutil.rmtree(stage)
    print(f"Built {output}")
    return output


def write_manifest(sdk: Path, starter: Path, version: str) -> Path:
    manifest = {
        "schemaVersion": 1,
        "version": version,
        "clientBuild": os.environ.get("GITHUB_SHA", "local"),
        "sdk": {"name": sdk.name, "size": sdk.stat().st_size, "sha256": sha256(sdk)},
        "starter": {
            "name": starter.name,
            "size": starter.stat().st_size,
            "sha256": sha256(starter),
        },
    }
    output = OUTPUT_ROOT / MANIFEST_NAME
    output.write_text(json.dumps(manifest, indent=2) + "\n", "utf-8")
    return output


def main() -> int:
    version = os.environ.get("KLITE_SDK_VERSION", "0.0.0-local").strip()
    try:
        sdk = build_sdk(version)
        starter = build_starter(sdk, version)
        manifest = write_manifest(sdk, starter, version)
    except Exception as exception:  # noqa: BLE001 - command-line build should report all failures
        print(f"SDK build failed: {exception}", file=sys.stderr)
        return 1

    print(f"Manifest: {manifest}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
