#!/usr/bin/env python3
"""Verify that the generated plugin starter ZIP preserves the safe README example."""

from __future__ import annotations

import hashlib
import tempfile
from pathlib import Path
from zipfile import ZipFile

import build_sdk

EXPECTED_API_EXAMPLE = """/**: # (
java)
*: # (clientApi.inventoryFreeSlots&#40;&#41;)
*: # (    .thenAccept&#40;freeSlots -> log.info&#40;\"Free slots: {}\", freeSlots&#41;&#41;;)
*/: # (
)"""

UNESCAPED_API_EXAMPLE = """clientApi.inventoryFreeSlots()
    .thenAccept(freeSlots -> log.info(\"Free slots: {}\", freeSlots));"""


def sha256(path: Path) -> str:
    digest = hashlib.sha256()
    with path.open("rb") as stream:
        for chunk in iter(lambda: stream.read(1024 * 1024), b""):
            digest.update(chunk)
    return digest.hexdigest()


def main() -> int:
    with tempfile.TemporaryDirectory(prefix="klite-starter-readme-") as temporary_directory:
        output_root = Path(temporary_directory)
        dummy_sdk = output_root / build_sdk.SDK_NAME
        dummy_sdk.write_bytes(b"KLite starter README verification SDK placeholder\n")

        original_output_root = build_sdk.OUTPUT_ROOT
        build_sdk.OUTPUT_ROOT = output_root
        try:
            starter = build_sdk.build_starter(dummy_sdk, "readme-verification")
        finally:
            build_sdk.OUTPUT_ROOT = original_output_root

        with ZipFile(starter) as archive:
            readme = archive.read("README.md").decode("utf-8")
            corrupt_entry = archive.testzip()

        if corrupt_entry:
            raise SystemExit(f"Generated starter ZIP contains a corrupt entry: {corrupt_entry}")
        if EXPECTED_API_EXAMPLE not in readme:
            raise SystemExit("Generated starter README is missing the required escaped API example")
        if UNESCAPED_API_EXAMPLE in readme:
            raise SystemExit("Generated starter README still contains the error-prone unescaped API example")
        if "SDK version: `readme-verification`" not in readme:
            raise SystemExit("Generated starter README did not receive the SDK version replacement")

        print(f"Verified escaped README example in {starter}")
        print(f"Starter ZIP SHA-256: {sha256(starter)}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
