# Recent GitHub Actions failures

Generated: 2026-07-19T11:46:57.904642+00:00
Repository: `KSPOG/klite`
Failed runs inspected: **15**

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29685750633](https://github.com/KSPOG/klite/actions/runs/29685750633)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `cb389a60726ad53dd5b96d24276eb1eb0c59a6bb`
- Created: `2026-07-19T11:46:29Z`

### Failed jobs and steps

No failed job metadata was returned.

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29685736876](https://github.com/KSPOG/klite/actions/runs/29685736876)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `cb389a60726ad53dd5b96d24276eb1eb0c59a6bb`
- Created: `2026-07-19T11:46:03Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 3: **Collect recent failure details** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29685731439](https://github.com/KSPOG/klite/actions/runs/29685731439)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `cb389a60726ad53dd5b96d24276eb1eb0c59a6bb`
- Created: `2026-07-19T11:45:53Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 3: **Collect recent failure details** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## Apply client version, AutoLogin, and Discord updates: Add client AutoLogin and Discord update notifications

- Run: [29685714976](https://github.com/KSPOG/klite/actions/runs/29685714976)
- Conclusion: `failure`
- Event: `pull_request`
- Commit: `4ee5565f8ccf86050b0d098751556a45a16bf34b`
- Created: `2026-07-19T11:45:20Z`

### Failed jobs and steps

- **verify-feature** — `failure`
  - Step 5: **Run marketplace tests with diagnostics** — `failure`

### Relevant log context

```text
verify-feature	Run marketplace tests with diagnostics	﻿2026-07-19T11:45:39.1976384Z ##[group]Run set +e
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:39.1976687Z ^[[36;1mset +e^[[0m
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:39.1977051Z ^[[36;1mnpm --prefix marketplace-site test 2>&1 | tee marketplace-test.log^[[0m
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:39.1977872Z ^[[36;1mstatus=${PIPESTATUS[0]}^[[0m
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:39.1978263Z ^[[36;1mif [ "$status" -ne 0 ]; then^[[0m
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:39.1978519Z ^[[36;1m  {^[[0m
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:39.1978751Z ^[[36;1m    echo '### Marketplace test failure'^[[0m
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:39.1979042Z ^[[36;1m    echo '```text'^[[0m
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:39.1979297Z ^[[36;1m    tail -n 240 marketplace-test.log^[[0m
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:39.1979569Z ^[[36;1m    echo '```'^[[0m
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:39.1979810Z ^[[36;1m  } > marketplace-test-comment.md^[[0m
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:39.1980177Z ^[[36;1m  gh pr comment 57 --body-file marketplace-test-comment.md^[[0m
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:39.1980531Z ^[[36;1m  exit "$status"^[[0m
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:39.1980757Z ^[[36;1mfi^[[0m
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6778230Z   type: 'test'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6798032Z   ...
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6828198Z # Subtest: API page links the downloadable public API source bundle
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6829246Z ok 7 - API page links the downloadable public API source bundle
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6858162Z   ---
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6888189Z   duration_ms: 0.327343
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6896634Z   type: 'test'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6903616Z   ...
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6904466Z # Subtest: Cloudflare serves API page files before dynamic API routes
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6906238Z ok 8 - Cloudflare serves API page files before dynamic API routes
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6907233Z   ---
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6908076Z   duration_ms: 0.445994
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6908883Z   type: 'test'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6916608Z   ...
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6917359Z # Subtest: public API source bundle follows the documented API surface
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6918573Z not ok 9 - public API source bundle follows the documented API surface
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6919395Z   ---
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6919849Z   duration_ms: 5.54599
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6920342Z   type: 'test'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6921169Z   location: '/home/runner/work/klite/klite/marketplace-site/test/api-source-bundle.test.js:14:1'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6922201Z   failureType: 'testCodeFailure'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6922780Z   error: |-
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6923478Z     The input did not match the regular expression /verify_reference_parity/. Input:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6924292Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6924757Z     '#!/usr/bin/env python3\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6925575Z       '"""Build the Java source bundle represented by the public KLite API website.\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6926432Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6927186Z       'The website API reference is generated from the direct Java source files in the\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6928589Z       'KLite client API, automation runtime, and web-walker packages. This script\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6969062Z       'def sha256(path: Path) -> str:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6969623Z       '    digest = hashlib.sha256()\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6970188Z       '    with path.open("rb") as stream:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6970895Z       '        for chunk in iter(lambda: stream.read(1024 * 1024), b""):\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6971582Z       '            digest.update(chunk)\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6972137Z       '    return digest.hexdigest()\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6972691Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6973073Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6973701Z       'def add_bytes(archive: zipfile.ZipFile, name: str, data: bytes) -> None:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6974486Z       '    info = zipfile.ZipInfo(name)\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6975067Z       '    info.date_time = (2026, 1, 1, 0, 0, 0)\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6975702Z       '    info.compress_type = zipfile.ZIP_DEFLATED\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6976328Z       '    info.external_attr = 0o644 << 16\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6976902Z       '    archive.writestr(info, data)\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6977736Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6978214Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6978774Z       'def documented_reference() -> dict:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6980157Z       '    source = REFERENCE_FILE.read_text("utf-8")\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6981197Z       '    prefix = "export const API_REFERENCE = "\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6982342Z       '    if not source.startswith("// Generated by") or prefix not in source:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6983792Z       '        raise RuntimeError(f"Unsupported API reference format: {REFERENCE_FILE}")\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6985203Z       '    payload = source.split(prefix, 1)[1].strip()\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6985942Z       '    if not payload.endswith(";"):\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6986962Z       '        raise RuntimeError(f"Generated API reference is missing its terminator: {REFERENCE_FILE}")\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6988422Z       '    return json.loads(payload[:-1])\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6989052Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6989487Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6990066Z       'def discover_public_types() -> list[PublicType]:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6990868Z       '    public_types: list[PublicType] = []\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6991522Z       '    for area, directory_name in AREAS:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6992212Z       '        directory = KLITE_ROOT / directory_name\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6992913Z       '        if not directory.is_dir():\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6993846Z       '            raise FileNotFoundError(f"Public API source directory does not exist: {directory}")\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6994968Z       '        for source_path in sorted(directory.glob("*.java")):\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6995803Z       '            source = source_path.read_text("utf-8")\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6996598Z       '            package_match = PACKAGE_PATTERN.search(source)\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6997619Z       '            type_match = TYPE_PATTERN.search(source)\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6998427Z       '            if not package_match or not type_match:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.6999436Z       '                continue\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7000022Z       '            public_types.append(\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7000633Z       '                PublicType(\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7001234Z       '                    area=area,\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7001893Z       '                    name=type_match.group(2),\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7002598Z       '                    kind=type_match.group(1),\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7003358Z       '                    package_name=package_match.group(1),\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7004057Z       '                    source_path=source_path,\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7004706Z       '                )\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7005213Z       '            )\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7005717Z       '    return public_types\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7006274Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7006919Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7015453Z       'def select_documented_types(discovered: list[PublicType], reference: dict) -> list[PublicType]:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7016777Z       '    source_by_key = {item.reference_key: item for item in discovered}\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7017876Z       '    documented_keys = [\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7018895Z       '        (section["name"], item["packageName"], item["name"], item["kind"])\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7019754Z       '        for section in reference.get("sections", [])\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7020453Z       '        for item in section.get("types", [])\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7021022Z       '    ]\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7021636Z       '    missing = [key for key in documented_keys if key not in source_by_key]\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7022390Z       '    if missing:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7022872Z       '        raise RuntimeError(\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7023550Z       '            "Documented API types have no matching Java source: "\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7024538Z       '            f"{missing}. Run `npm run api:generate` in marketplace-site when the API changes."\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7025400Z       '        )\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7026048Z       '    selected = [source_by_key[key] for key in documented_keys]\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7027123Z       '    expected_count = int(reference.get("typeCount", -1))\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7028319Z       '    if expected_count != len(selected):\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7029021Z       '        raise RuntimeError(\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7030055Z       '            f"API reference declares {expected_count} types but {len(selected)} source files were selected"\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7031060Z       '        )\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7031673Z       '    return selected\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7032247Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7032677Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7033325Z       'def bundle_readme(version: str, commit: str, count: int) -> bytes:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7034176Z       '    return (\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7071483Z       '    with zipfile.ZipFile(output, "w") as archive:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7072118Z       '        add_bytes(\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7072609Z       '            archive,\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7073208Z       '            f"{BUNDLE_ROOT}/README.md",\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7074001Z       '            bundle_readme(version, commit, len(public_types)),\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7074762Z       '        )\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7075289Z       '        add_bytes(\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7075830Z       '            archive,\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7076531Z       '            f"{BUNDLE_ROOT}/api-sources-manifest.json",\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7077682Z       '            (json.dumps(manifest, indent=2) + "\\n").encode("utf-8"),\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7078552Z       '        )\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7079122Z       '        for item in public_types:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7079773Z       '            destination = (\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7080627Z       '                Path(BUNDLE_ROOT) / "src" / "main" / "java" / item.relative_java_path\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7081521Z       '            ).as_posix()\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7082315Z       '            add_bytes(archive, destination, item.source_path.read_bytes())\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7083160Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7083732Z       '    with zipfile.ZipFile(output) as archive:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7084759Z       '        corrupt_entry = archive.testzip()\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7085395Z       '        if corrupt_entry:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7086358Z       '            raise RuntimeError(f"Generated API source ZIP contains a corrupt entry: {corrupt_entry}")\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7087619Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7088162Z       '    print(\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7088921Z       '        f"Built {output} with {len(public_types)} documented Java types; "\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7121352Z       '        f"SHA-256 {sha256(output)}"\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7122225Z       '    )\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7122640Z       '    return output\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7123041Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7123360Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7123690Z       'def main() -> int:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7124303Z       '    version = os.environ.get("KLITE_SDK_VERSION", "0.0.0-local").strip()\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7124970Z       '    try:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7125383Z       '        build_source_bundle(version)\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7126244Z       '    except Exception as exception:  # noqa: BLE001 - command-line build reports complete failures\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7127302Z       '        print(f"API source bundle build failed: {exception}", file=sys.stderr)\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7128247Z       '        return 1\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7128651Z       '    return 0\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7129011Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7129309Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7129637Z       'if __name__ == "__main__":\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7130094Z       '    raise SystemExit(main())\n'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7130529Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7130829Z   code: 'ERR_ASSERTION'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7131227Z   name: 'AssertionError'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7131603Z   expected:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7131910Z   actual: |-
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7132241Z     #!/usr/bin/env python3
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7132847Z     """Build the Java source bundle represented by the public KLite API website.
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7133515Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7134318Z     The website API reference is generated from the direct Java source files in the
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7135229Z     KLite client API, automation runtime, and web-walker packages. This script
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7160962Z     def sha256(path: Path) -> str:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7161455Z         digest = hashlib.sha256()
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7161931Z         with path.open("rb") as stream:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7162533Z             for chunk in iter(lambda: stream.read(1024 * 1024), b""):
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7163162Z                 digest.update(chunk)
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7163612Z         return digest.hexdigest()
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7164030Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7164303Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7164805Z     def add_bytes(archive: zipfile.ZipFile, name: str, data: bytes) -> None:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7165482Z         info = zipfile.ZipInfo(name)
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7165965Z         info.date_time = (2026, 1, 1, 0, 0, 0)
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7166682Z         info.compress_type = zipfile.ZIP_DEFLATED
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7167185Z         info.external_attr = 0o644 << 16
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7167844Z         archive.writestr(info, data)
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7168276Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7168547Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7168878Z     def documented_reference() -> dict:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7169440Z         source = REFERENCE_FILE.read_text("utf-8")
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7169974Z         prefix = "export const API_REFERENCE = "
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7170616Z         if not source.startswith("// Generated by") or prefix not in source:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7171446Z             raise RuntimeError(f"Unsupported API reference format: {REFERENCE_FILE}")
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7172181Z         payload = source.split(prefix, 1)[1].strip()
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7172700Z         if not payload.endswith(";"):
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7173476Z             raise RuntimeError(f"Generated API reference is missing its terminator: {REFERENCE_FILE}")
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7174284Z         return json.loads(payload[:-1])
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7174690Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7174958Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7175322Z     def discover_public_types() -> list[PublicType]:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7175854Z         public_types: list[PublicType] = []
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7176333Z         for area, directory_name in AREAS:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7176822Z             directory = KLITE_ROOT / directory_name
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7177342Z             if not directory.is_dir():
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7178281Z                 raise FileNotFoundError(f"Public API source directory does not exist: {directory}")
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7179137Z             for source_path in sorted(directory.glob("*.java")):
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7179705Z                 source = source_path.read_text("utf-8")
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7180331Z                 package_match = PACKAGE_PATTERN.search(source)
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7181215Z                 type_match = TYPE_PATTERN.search(source)
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7181828Z                 if not package_match or not type_match:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7182299Z                     continue
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7182660Z                 public_types.append(
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7183053Z                     PublicType(
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7183425Z                         area=area,
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7183860Z                         name=type_match.group(2),
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7184347Z                         kind=type_match.group(1),
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7184886Z                         package_name=package_match.group(1),
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7185414Z                         source_path=source_path,
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7185865Z                     )
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7186193Z                 )
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7186546Z         return public_types
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7186941Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7187234Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7188124Z     def select_documented_types(discovered: list[PublicType], reference: dict) -> list[PublicType]:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7189484Z         source_by_key = {item.reference_key: item for item in discovered}
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7190140Z         documented_keys = [
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7190700Z             (section["name"], item["packageName"], item["name"], item["kind"])
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7191408Z             for section in reference.get("sections", [])
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7191977Z             for item in section.get("types", [])
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7192459Z         ]
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7192963Z         missing = [key for key in documented_keys if key not in source_by_key]
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7193599Z         if missing:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7193932Z             raise RuntimeError(
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7194452Z                 "Documented API types have no matching Java source: "
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7195278Z                 f"{missing}. Run `npm run api:generate` in marketplace-site when the API changes."
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7195982Z             )
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7196444Z         selected = [source_by_key[key] for key in documented_keys]
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7197688Z         expected_count = int(reference.get("typeCount", -1))
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7198287Z         if expected_count != len(selected):
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7198779Z             raise RuntimeError(
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7199533Z                 f"API reference declares {expected_count} types but {len(selected)} source files were selected"
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7200346Z             )
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7200692Z         return selected
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7201071Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7201360Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7201845Z     def bundle_readme(version: str, commit: str, count: int) -> bytes:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7202469Z         return (
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7230492Z         with zipfile.ZipFile(output, "w") as archive:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7231035Z             add_bytes(
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7231403Z                 archive,
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7231792Z                 f"{BUNDLE_ROOT}/README.md",
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7232380Z                 bundle_readme(version, commit, len(public_types)),
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7232925Z             )
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7233252Z             add_bytes(
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7233632Z                 archive,
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7234113Z                 f"{BUNDLE_ROOT}/api-sources-manifest.json",
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7234789Z                 (json.dumps(manifest, indent=2) + "\n").encode("utf-8"),
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7235378Z             )
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7235743Z             for item in public_types:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7236214Z                 destination = (
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7236862Z                     Path(BUNDLE_ROOT) / "src" / "main" / "java" / item.relative_java_path
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7237827Z                 ).as_posix()
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7238426Z                 add_bytes(archive, destination, item.source_path.read_bytes())
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7239064Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7239458Z         with zipfile.ZipFile(output) as archive:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7240021Z             corrupt_entry = archive.testzip()
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7240517Z             if corrupt_entry:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7241287Z                 raise RuntimeError(f"Generated API source ZIP contains a corrupt entry: {corrupt_entry}")
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7242089Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7242414Z         print(
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7242950Z             f"Built {output} with {len(public_types)} documented Java types; "
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7243635Z             f"SHA-256 {sha256(output)}"
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7244084Z         )
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7244395Z         return output
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7245012Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7245321Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7245652Z     def main() -> int:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7246252Z         version = os.environ.get("KLITE_SDK_VERSION", "0.0.0-local").strip()
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7246895Z         try:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7247230Z             build_source_bundle(version)
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7248308Z         except Exception as exception:  # noqa: BLE001 - command-line build reports complete failures
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7249331Z             print(f"API source bundle build failed: {exception}", file=sys.stderr)
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7249964Z             return 1
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7250296Z         return 0
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7250602Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7250869Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7251169Z     if __name__ == "__main__":
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7251576Z         raise SystemExit(main())
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:40.7251958Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:41.3078592Z   ---
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:41.3079157Z   duration_ms: 3.555292
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:41.3080685Z   type: 'test'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:41.3081273Z   ...
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:41.3082106Z # Subtest: requires a client login before serving paid plugin artifacts
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:41.3083217Z ok 35 - requires a client login before serving paid plugin artifacts
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:41.3084385Z   ---
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:41.3084966Z   duration_ms: 0.917047
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:41.3085736Z   type: 'test'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:41.3086215Z   ...
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:41.3146441Z 1..35
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:41.3147217Z # tests 35
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:41.3147798Z # suites 0
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:41.3148106Z # pass 34
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:41.3148756Z # fail 1
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:41.3149062Z # cancelled 0
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:41.3149668Z # skipped 0
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:41.3150221Z # todo 0
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:41.3150712Z # duration_ms 902.776282
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:42.1232813Z https://github.com/KSPOG/klite/pull/57#issuecomment-5015585050
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:42.1266800Z ##[error]Process completed with exit code 1.
```

## CI: Add client AutoLogin and Discord update notifications

- Run: [29685714971](https://github.com/KSPOG/klite/actions/runs/29685714971)
- Conclusion: `failure`
- Event: `pull_request`
- Commit: `4ee5565f8ccf86050b0d098751556a45a16bf34b`
- Created: `2026-07-19T11:45:20Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-19T11:46:04.5887822Z > Task :runelite-api:build
build	Build and Test	2026-07-19T11:46:12.9918890Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/party/messages/PartyChatMessage.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:46:12.9920820Z
build	Build and Test	2026-07-19T11:46:12.9946062Z @Value
build	Build and Test	2026-07-19T11:46:12.9946532Z > Task :client:compileJava
build	Build and Test	2026-07-19T11:46:12.9975852Z ^
build	Build and Test	2026-07-19T11:46:12.9978188Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/PrivateMessageInput.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:46:12.9980624Z @Value
build	Build and Test	2026-07-19T11:46:12.9981046Z ^
build	Build and Test	2026-07-19T11:46:12.9983308Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/ChatboxInput.java:32: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:46:12.9985956Z @Value
build	Build and Test	2026-07-19T11:46:12.9986351Z ^
build	Build and Test	2026-07-19T11:46:12.9988666Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/devtools/ScriptInspector.java:100: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:46:12.9991147Z 	@Data
build	Build and Test	2026-07-19T11:46:12.9991535Z 	^
build	Build and Test	2026-07-19T11:46:20.2889023Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/agility/Courses.java:88: warning: non-varargs call of varargs method with inexact argument type for last parameter;
build	Build and Test	2026-07-19T11:46:20.2908107Z 		this(totalXp, -1, null);
build	Build and Test	2026-07-19T11:46:20.2926337Z 		                  ^
build	Build and Test	2026-07-19T11:46:20.2946537Z   cast to WorldPoint for a varargs call
build	Build and Test	2026-07-19T11:46:20.2976606Z   cast to WorldPoint[] for a non-varargs call and to suppress this warning
build	Build and Test	2026-07-19T11:46:23.9977130Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginService.java:154: error: cannot find symbol
build	Build and Test	2026-07-19T11:46:24.0008872Z 			client.getUsername(), client.getPassword());
build	Build and Test	2026-07-19T11:46:24.0035707Z 			                            ^
build	Build and Test	2026-07-19T11:46:24.0065704Z   symbol:   method getPassword()
build	Build and Test	2026-07-19T11:46:24.0095709Z   location: variable client of type Client
build	Build and Test	2026-07-19T11:46:25.0913807Z Note: Some input files use or override a deprecated API.
build	Build and Test	2026-07-19T11:46:25.0936128Z Note: Recompile with -Xlint:deprecation for details.
build	Build and Test	2026-07-19T11:46:25.0939067Z Note: Some input files use unchecked or unsafe operations.
build	Build and Test	2026-07-19T11:46:25.0940004Z Note: Recompile with -Xlint:unchecked for details.
build	Build and Test	2026-07-19T11:46:25.0940732Z 1 error
build	Build and Test	2026-07-19T11:46:25.0941224Z 5 warnings
build	Build and Test	2026-07-19T11:46:25.3885855Z
build	Build and Test	2026-07-19T11:46:25.3890241Z
build	Build and Test	2026-07-19T11:46:25.3890891Z > Task :client:compileJava FAILED
build	Build and Test	2026-07-19T11:46:25.3891835Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-19T11:46:25.3892898Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784461551470.json
build	Build and Test	2026-07-19T11:46:25.3894116Z
build	Build and Test	2026-07-19T11:46:25.3894656Z 55 actionable tasks: 23 executed, 32 from cache
build	Build and Test	2026-07-19T11:46:25.3896828Z * What went wrong:
build	Build and Test	2026-07-19T11:46:25.3897562Z Execution failed for task ':client:compileJava'.
build	Build and Test	2026-07-19T11:46:25.3898591Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-19T11:46:25.3899747Z
build	Build and Test	2026-07-19T11:46:25.3900086Z * Try:
build	Build and Test	2026-07-19T11:46:25.3900718Z > Run with --info option to get more log output.
build	Build and Test	2026-07-19T11:46:25.3901501Z > Run with --scan to get full insights.
build	Build and Test	2026-07-19T11:46:25.3902032Z
build	Build and Test	2026-07-19T11:46:25.3902362Z BUILD FAILED in 42s
build	Build and Test	2026-07-19T11:46:25.8593022Z ##[error]Process completed with exit code 1.
```

## CI: Allow the API reference scoped stylesheet

- Run: [29685713911](https://github.com/KSPOG/klite/actions/runs/29685713911)
- Conclusion: `failure`
- Event: `push`
- Commit: `4ee5565f8ccf86050b0d098751556a45a16bf34b`
- Created: `2026-07-19T11:45:18Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-19T11:46:00.4429224Z > Task :runelite-api:build
build	Build and Test	2026-07-19T11:46:10.3442450Z
build	Build and Test	2026-07-19T11:46:10.3443454Z > Task :client:compileJava
build	Build and Test	2026-07-19T11:46:10.3487947Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/PrivateMessageInput.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:46:10.3515433Z @Value
build	Build and Test	2026-07-19T11:46:10.3522620Z ^
build	Build and Test	2026-07-19T11:46:10.3524828Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/ChatboxInput.java:32: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:46:10.3527384Z @Value
build	Build and Test	2026-07-19T11:46:10.3527774Z ^
build	Build and Test	2026-07-19T11:46:10.3529917Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/party/messages/PartyChatMessage.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:46:10.3532177Z @Value
build	Build and Test	2026-07-19T11:46:10.3532588Z ^
build	Build and Test	2026-07-19T11:46:10.3534730Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/devtools/ScriptInspector.java:100: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:46:10.3539597Z 	@Data
build	Build and Test	2026-07-19T11:46:10.3539998Z 	^
build	Build and Test	2026-07-19T11:46:17.0429224Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/agility/Courses.java:88: warning: non-varargs call of varargs method with inexact argument type for last parameter;
build	Build and Test	2026-07-19T11:46:17.0431611Z 		this(totalXp, -1, null);
build	Build and Test	2026-07-19T11:46:17.0432645Z 		                  ^
build	Build and Test	2026-07-19T11:46:17.0433436Z   cast to WorldPoint for a varargs call
build	Build and Test	2026-07-19T11:46:17.0434418Z   cast to WorldPoint[] for a non-varargs call and to suppress this warning
build	Build and Test	2026-07-19T11:46:21.2490083Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginService.java:154: error: cannot find symbol
build	Build and Test	2026-07-19T11:46:21.2515987Z 			client.getUsername(), client.getPassword());
build	Build and Test	2026-07-19T11:46:21.2545535Z 			                            ^
build	Build and Test	2026-07-19T11:46:21.2575602Z   symbol:   method getPassword()
build	Build and Test	2026-07-19T11:46:21.2576517Z   location: variable client of type Client
build	Build and Test	2026-07-19T11:46:22.2426703Z Note: Some input files use or override a deprecated API.
build	Build and Test	2026-07-19T11:46:22.2458824Z Note: Recompile with -Xlint:deprecation for details.
build	Build and Test	2026-07-19T11:46:22.2466258Z Note: Some input files use unchecked or unsafe operations.
build	Build and Test	2026-07-19T11:46:22.2495823Z Note: Recompile with -Xlint:unchecked for details.
build	Build and Test	2026-07-19T11:46:22.2545722Z 1 error
build	Build and Test	2026-07-19T11:46:22.2565833Z 5 warnings
build	Build and Test	2026-07-19T11:46:22.5417284Z
build	Build and Test	2026-07-19T11:46:22.5418036Z > Task :client:compileJava FAILED
build	Build and Test	2026-07-19T11:46:22.6427744Z
build	Build and Test	2026-07-19T11:46:22.6428696Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784461548197.json
build	Build and Test	2026-07-19T11:46:22.6445870Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-19T11:46:22.6455882Z 55 actionable tasks: 23 executed, 32 from cache
build	Build and Test	2026-07-19T11:46:22.6475778Z
build	Build and Test	2026-07-19T11:46:22.6506235Z * What went wrong:
build	Build and Test	2026-07-19T11:46:22.6536162Z Execution failed for task ':client:compileJava'.
build	Build and Test	2026-07-19T11:46:22.6565566Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-19T11:46:22.6571367Z
build	Build and Test	2026-07-19T11:46:22.6571766Z * Try:
build	Build and Test	2026-07-19T11:46:22.6572475Z > Run with --info option to get more log output.
build	Build and Test	2026-07-19T11:46:22.6573776Z > Run with --scan to get full insights.
build	Build and Test	2026-07-19T11:46:22.6574375Z
build	Build and Test	2026-07-19T11:46:22.6574763Z BUILD FAILED in 42s
build	Build and Test	2026-07-19T11:46:23.0881974Z ##[error]Process completed with exit code 1.
```

## Apply client version, AutoLogin, and Discord updates: Add client AutoLogin and Discord update notifications

- Run: [29685704265](https://github.com/KSPOG/klite/actions/runs/29685704265)
- Conclusion: `failure`
- Event: `pull_request`
- Commit: `0365c281d15705e1355d098f320d6b8f904f4144`
- Created: `2026-07-19T11:45:02Z`

### Failed jobs and steps

- **verify-feature** — `failure`
  - Step 5: **Run marketplace tests with diagnostics** — `failure`

### Relevant log context

```text
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5609424Z # Subtest: Cloudflare serves API page files before dynamic API routes
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5610890Z ok 8 - Cloudflare serves API page files before dynamic API routes
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5611670Z   ---
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5612230Z   duration_ms: 0.383172
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5612662Z   type: 'test'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5613187Z   ...
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5613831Z # Subtest: public API source bundle follows the documented API surface
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5615049Z not ok 9 - public API source bundle follows the documented API surface
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5615677Z   ---
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5616068Z   duration_ms: 3.893283
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5616488Z   type: 'test'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5617135Z   location: '/home/runner/work/klite/klite/marketplace-site/test/api-source-bundle.test.js:14:1'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5618115Z   failureType: 'testCodeFailure'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5618627Z   error: |-
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5619258Z     The input did not match the regular expression /verify_reference_parity/. Input:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5619918Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5620317Z     '#!/usr/bin/env python3\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5620995Z       '"""Build the Java source bundle represented by the public KLite API website.\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5621686Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5622287Z       'The website API reference is generated from the direct Java source files in the\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5623376Z       'KLite client API, automation runtime, and web-walker packages. This script\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5650149Z       'def sha256(path: Path) -> str:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5650471Z       '    digest = hashlib.sha256()\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5650716Z       '    with path.open("rb") as stream:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5651008Z       '        for chunk in iter(lambda: stream.read(1024 * 1024), b""):\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5651378Z       '            digest.update(chunk)\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5651612Z       '    return digest.hexdigest()\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5651854Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5652060Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5652330Z       'def add_bytes(archive: zipfile.ZipFile, name: str, data: bytes) -> None:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5652724Z       '    info = zipfile.ZipInfo(name)\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5652977Z       '    info.date_time = (2026, 1, 1, 0, 0, 0)\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5653244Z       '    info.compress_type = zipfile.ZIP_DEFLATED\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5653566Z       '    info.external_attr = 0o644 << 16\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5653807Z       '    archive.writestr(info, data)\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5654175Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5654680Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5654997Z       'def documented_reference() -> dict:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5655398Z       '    source = REFERENCE_FILE.read_text("utf-8")\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5655767Z       '    prefix = "export const API_REFERENCE = "\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5656234Z       '    if not source.startswith("// Generated by") or prefix not in source:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5656877Z       '        raise RuntimeError(f"Unsupported API reference format: {REFERENCE_FILE}")\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5657509Z       '    payload = source.split(prefix, 1)[1].strip()\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5657945Z       '    if not payload.endswith(";"):\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5658460Z       '        raise RuntimeError(f"Generated API reference is missing its terminator: {REFERENCE_FILE}")\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5659033Z       '    return json.loads(payload[:-1])\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5659365Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5659584Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5659860Z       'def discover_public_types() -> list[PublicType]:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5660253Z       '    public_types: list[PublicType] = []\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5660604Z       '    for area, directory_name in AREAS:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5661005Z       '        directory = KLITE_ROOT / directory_name\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5661512Z       '        if not directory.is_dir():\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5662155Z       '            raise FileNotFoundError(f"Public API source directory does not exist: {directory}")\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5662803Z       '        for source_path in sorted(directory.glob("*.java")):\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5663320Z       '            source = source_path.read_text("utf-8")\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5663758Z       '            package_match = PACKAGE_PATTERN.search(source)\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5664329Z       '            type_match = TYPE_PATTERN.search(source)\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5664797Z       '            if not package_match or not type_match:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5665444Z       '                continue\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5665816Z       '            public_types.append(\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5666200Z       '                PublicType(\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5666561Z       '                    area=area,\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5666935Z       '                    name=type_match.group(2),\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5667348Z       '                    kind=type_match.group(1),\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5667774Z       '                    package_name=package_match.group(1),\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5668217Z       '                    source_path=source_path,\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5668581Z       '                )\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5668879Z       '            )\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5669168Z       '    return public_types\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5669472Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5669713Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5670241Z       'def select_documented_types(discovered: list[PublicType], reference: dict) -> list[PublicType]:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5671020Z       '    source_by_key = {item.reference_key: item for item in discovered}\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5671517Z       '    documented_keys = [\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5671978Z       '        (section["name"], item["packageName"], item["name"], item["kind"])\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5672479Z       '        for section in reference.get("sections", [])\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5672895Z       '        for item in section.get("types", [])\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5673218Z       '    ]\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5673593Z       '    missing = [key for key in documented_keys if key not in source_by_key]\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5674203Z       '    if missing:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5674523Z       '        raise RuntimeError(\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5674971Z       '            "Documented API types have no matching Java source: "\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5675638Z       '            f"{missing}. Run `npm run api:generate` in marketplace-site when the API changes."\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5676201Z       '        )\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5676724Z       '    selected = [source_by_key[key] for key in documented_keys]\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5677332Z       '    expected_count = int(reference.get("typeCount", -1))\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5677792Z       '    if expected_count != len(selected):\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5678154Z       '        raise RuntimeError(\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5678719Z       '            f"API reference declares {expected_count} types but {len(selected)} source files were selected"\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5679121Z       '        )\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5679301Z       '    return selected\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5679494Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5679645Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5679885Z       'def bundle_readme(version: str, commit: str, count: int) -> bytes:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5680220Z       '    return (\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5693673Z       '    with zipfile.ZipFile(output, "w") as archive:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5693927Z       '        add_bytes(\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5694969Z       '            archive,\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5695308Z       '            f"{BUNDLE_ROOT}/README.md",\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5695787Z       '            bundle_readme(version, commit, len(public_types)),\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5696220Z       '        )\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5696490Z       '        add_bytes(\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5696783Z       '            archive,\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5697168Z       '            f"{BUNDLE_ROOT}/api-sources-manifest.json",\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5697677Z       '            (json.dumps(manifest, indent=2) + "\\n").encode("utf-8"),\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5698105Z       '        )\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5698387Z       '        for item in public_types:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5698737Z       '            destination = (\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5699202Z       '                Path(BUNDLE_ROOT) / "src" / "main" / "java" / item.relative_java_path\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5699688Z       '            ).as_posix()\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5700135Z       '            add_bytes(archive, destination, item.source_path.read_bytes())\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5700584Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5700887Z       '    with zipfile.ZipFile(output) as archive:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5701475Z       '        corrupt_entry = archive.testzip()\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5701824Z       '        if corrupt_entry:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5702402Z       '            raise RuntimeError(f"Generated API source ZIP contains a corrupt entry: {corrupt_entry}")\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5702997Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5728727Z       '    print(\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5729214Z       '        f"Built {output} with {len(public_types)} documented Java types; "\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5729740Z       '        f"SHA-256 {sha256(output)}"\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5730084Z       '    )\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5730348Z       '    return output\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5730621Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5730868Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5731119Z       'def main() -> int:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5731575Z       '    version = os.environ.get("KLITE_SDK_VERSION", "0.0.0-local").strip()\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5732062Z       '    try:\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5732346Z       '        build_source_bundle(version)\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5732988Z       '    except Exception as exception:  # noqa: BLE001 - command-line build reports complete failures\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5733724Z       '        print(f"API source bundle build failed: {exception}", file=sys.stderr)\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5735535Z       '        return 1\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5735827Z       '    return 0\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5736086Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5736310Z       '\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5736552Z       'if __name__ == "__main__":\n' +
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5736883Z       '    raise SystemExit(main())\n'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5737203Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5737415Z   code: 'ERR_ASSERTION'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5737689Z   name: 'AssertionError'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5737947Z   expected:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5738166Z   actual: |-
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5738412Z     #!/usr/bin/env python3
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5738861Z     """Build the Java source bundle represented by the public KLite API website.
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5739553Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5739944Z     The website API reference is generated from the direct Java source files in the
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5740588Z     KLite client API, automation runtime, and web-walker packages. This script
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5758314Z     def sha256(path: Path) -> str:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5758672Z         digest = hashlib.sha256()
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5759191Z         with path.open("rb") as stream:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5759768Z             for chunk in iter(lambda: stream.read(1024 * 1024), b""):
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5760339Z                 digest.update(chunk)
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5760700Z         return digest.hexdigest()
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5761013Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5761241Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5761552Z     def add_bytes(archive: zipfile.ZipFile, name: str, data: bytes) -> None:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5762058Z         info = zipfile.ZipInfo(name)
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5762819Z         info.date_time = (2026, 1, 1, 0, 0, 0)
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5763147Z         info.compress_type = zipfile.ZIP_DEFLATED
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5763453Z         info.external_attr = 0o644 << 16
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5763839Z         archive.writestr(info, data)
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5764260Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5764491Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5764658Z     def documented_reference() -> dict:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5764956Z         source = REFERENCE_FILE.read_text("utf-8")
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5765251Z         prefix = "export const API_REFERENCE = "
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5765566Z         if not source.startswith("// Generated by") or prefix not in source:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5766060Z             raise RuntimeError(f"Unsupported API reference format: {REFERENCE_FILE}")
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5766416Z         payload = source.split(prefix, 1)[1].strip()
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5766754Z         if not payload.endswith(";"):
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5767105Z             raise RuntimeError(f"Generated API reference is missing its terminator: {REFERENCE_FILE}")
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5767559Z         return json.loads(payload[:-1])
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5767770Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5767915Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5768145Z     def discover_public_types() -> list[PublicType]:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5768441Z         public_types: list[PublicType] = []
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5768678Z         for area, directory_name in AREAS:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5768955Z             directory = KLITE_ROOT / directory_name
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5769235Z             if not directory.is_dir():
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5769577Z                 raise FileNotFoundError(f"Public API source directory does not exist: {directory}")
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5770175Z             for source_path in sorted(directory.glob("*.java")):
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5770600Z                 source = source_path.read_text("utf-8")
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5771002Z                 package_match = PACKAGE_PATTERN.search(source)
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5771625Z                 type_match = TYPE_PATTERN.search(source)
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5772097Z                 if not package_match or not type_match:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5772486Z                     continue
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5772775Z                 public_types.append(
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5773124Z                     PublicType(
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5773423Z                         area=area,
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5773749Z                         name=type_match.group(2),
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5774353Z                         kind=type_match.group(1),
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5774720Z                         package_name=package_match.group(1),
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5775076Z                         source_path=source_path,
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5775383Z                     )
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5775613Z                 )
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5775855Z         return public_types
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5776120Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5776325Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5776803Z     def select_documented_types(discovered: list[PublicType], reference: dict) -> list[PublicType]:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5777495Z         source_by_key = {item.reference_key: item for item in discovered}
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5777931Z         documented_keys = [
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5778319Z             (section["name"], item["packageName"], item["name"], item["kind"])
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5778775Z             for section in reference.get("sections", [])
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5779158Z             for item in section.get("types", [])
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5779489Z         ]
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5779842Z         missing = [key for key in documented_keys if key not in source_by_key]
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5780269Z         if missing:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5780530Z             raise RuntimeError(
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5780898Z                 "Documented API types have no matching Java source: "
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5781481Z                 f"{missing}. Run `npm run api:generate` in marketplace-site when the API changes."
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5781983Z             )
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5782335Z         selected = [source_by_key[key] for key in documented_keys]
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5783027Z         expected_count = int(reference.get("typeCount", -1))
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5783450Z         if expected_count != len(selected):
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5783795Z             raise RuntimeError(
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5784549Z                 f"API reference declares {expected_count} types but {len(selected)} source files were selected"
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5785129Z             )
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5785368Z         return selected
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5785649Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5785871Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5786222Z     def bundle_readme(version: str, commit: str, count: int) -> bytes:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5786661Z         return (
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5805707Z         with zipfile.ZipFile(output, "w") as archive:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5806084Z             add_bytes(
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5806349Z                 archive,
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5806651Z                 f"{BUNDLE_ROOT}/README.md",
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5807065Z                 bundle_readme(version, commit, len(public_types)),
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5807466Z             )
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5807704Z             add_bytes(
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5807959Z                 archive,
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5808299Z                 f"{BUNDLE_ROOT}/api-sources-manifest.json",
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5808772Z                 (json.dumps(manifest, indent=2) + "\n").encode("utf-8"),
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5809193Z             )
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5809456Z             for item in public_types:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5809791Z                 destination = (
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5810230Z                     Path(BUNDLE_ROOT) / "src" / "main" / "java" / item.relative_java_path
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5810715Z                 ).as_posix()
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5811126Z                 add_bytes(archive, destination, item.source_path.read_bytes())
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5811577Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5811847Z         with zipfile.ZipFile(output) as archive:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5812241Z             corrupt_entry = archive.testzip()
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5812598Z             if corrupt_entry:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5813145Z                 raise RuntimeError(f"Generated API source ZIP contains a corrupt entry: {corrupt_entry}")
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5813705Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5813926Z         print(
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5814405Z             f"Built {output} with {len(public_types)} documented Java types; "
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5814883Z             f"SHA-256 {sha256(output)}"
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5815197Z         )
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5815422Z         return output
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5815819Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5816026Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5816247Z     def main() -> int:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5816663Z         version = os.environ.get("KLITE_SDK_VERSION", "0.0.0-local").strip()
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5817108Z         try:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5817370Z             build_source_bundle(version)
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5817935Z         except Exception as exception:  # noqa: BLE001 - command-line build reports complete failures
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5818640Z             print(f"API source bundle build failed: {exception}", file=sys.stderr)
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5819113Z             return 1
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5819375Z         return 0
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5819605Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5819812Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5820039Z     if __name__ == "__main__":
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5820351Z         raise SystemExit(main())
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.5820641Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6207297Z   type: 'test'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6207597Z   ...
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6385159Z # Subtest: normalizes Discord bot role and channel settings
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6395721Z ok 19 - normalizes Discord bot role and channel settings
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6434598Z   ---
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6474696Z   duration_ms: 1.157528
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6495872Z   type: 'test'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6524796Z   ...
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6554852Z # Subtest: shows the dashboard only when the linked member currently has Dev
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6575706Z ok 20 - shows the dashboard only when the linked member currently has Dev
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6579271Z   ---
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6580301Z   duration_ms: 24.903135
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6600819Z   type: 'test'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6602260Z   ...
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6742411Z # Subtest: public pages serve the generated design system and scoped credit styles
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6775500Z not ok 21 - public pages serve the generated design system and scoped credit styles
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6781451Z   ---
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6781871Z   duration_ms: 49.05629
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6782303Z   type: 'test'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6782927Z   location: '/home/runner/work/klite/klite/marketplace-site/test/home-styles.test.js:13:1'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6783652Z   failureType: 'testCodeFailure'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6784244Z   error: |-
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6784627Z     Expected values to be strictly equal:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6785062Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6785393Z     2 !== 1
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6785743Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6786503Z   code: 'ERR_ASSERTION'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6786917Z   name: 'AssertionError'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6787331Z   expected: 1
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6787698Z   actual: 2
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6788075Z   operator: 'strictEqual'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6788471Z   stack: |-
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6789095Z     TestContext.<anonymous> (file:///home/runner/work/klite/klite/marketplace-site/test/home-styles.test.js:39:12)
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6789913Z     async Test.run (node:internal/test_runner/test:1054:7)
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:22.6790583Z     async startSubtestAfterBootstrap (node:internal/test_runner/harness:296:3)
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:23.1407627Z   ---
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:23.1407797Z   duration_ms: 2.420922
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:23.1407977Z   type: 'test'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:23.1408158Z   ...
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:23.1408505Z # Subtest: requires a client login before serving paid plugin artifacts
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:23.1408915Z ok 35 - requires a client login before serving paid plugin artifacts
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:23.1409283Z   ---
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:23.1409461Z   duration_ms: 0.696294
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:23.1409639Z   type: 'test'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:23.1409814Z   ...
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:23.1472338Z 1..35
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:23.1472748Z # tests 35
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:23.1473140Z # suites 0
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:23.1473525Z # pass 33
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:23.1474157Z # fail 2
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:23.1474603Z # cancelled 0
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:23.1475047Z # skipped 0
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:23.1475286Z # todo 0
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:23.1475512Z # duration_ms 724.727697
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:23.9907831Z https://github.com/KSPOG/klite/pull/57#issuecomment-5015584193
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:45:23.9939683Z ##[error]Process completed with exit code 1.
```

## CI: Add client AutoLogin and Discord update notifications

- Run: [29685704187](https://github.com/KSPOG/klite/actions/runs/29685704187)
- Conclusion: `failure`
- Event: `pull_request`
- Commit: `0365c281d15705e1355d098f320d6b8f904f4144`
- Created: `2026-07-19T11:45:02Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-19T11:45:37.0015232Z > Task :runelite-api:build
build	Build and Test	2026-07-19T11:45:47.4014469Z
build	Build and Test	2026-07-19T11:45:47.4026217Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/party/messages/PartyChatMessage.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:45:47.4029231Z > Task :client:compileJava
build	Build and Test	2026-07-19T11:45:47.4029955Z @Value
build	Build and Test	2026-07-19T11:45:47.4030372Z ^
build	Build and Test	2026-07-19T11:45:47.4032651Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/PrivateMessageInput.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:45:47.4035381Z @Value
build	Build and Test	2026-07-19T11:45:47.4035765Z ^
build	Build and Test	2026-07-19T11:45:47.4037970Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/ChatboxInput.java:32: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:45:47.4040369Z @Value
build	Build and Test	2026-07-19T11:45:47.4040759Z ^
build	Build and Test	2026-07-19T11:45:47.4043157Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/devtools/ScriptInspector.java:100: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:45:47.4045901Z 	@Data
build	Build and Test	2026-07-19T11:45:47.4046266Z 	^
build	Build and Test	2026-07-19T11:45:54.3046323Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/agility/Courses.java:88: warning: non-varargs call of varargs method with inexact argument type for last parameter;
build	Build and Test	2026-07-19T11:45:54.3067364Z 		this(totalXp, -1, null);
build	Build and Test	2026-07-19T11:45:54.3068785Z 		                  ^
build	Build and Test	2026-07-19T11:45:54.3069307Z   cast to WorldPoint for a varargs call
build	Build and Test	2026-07-19T11:45:54.3070103Z   cast to WorldPoint[] for a non-varargs call and to suppress this warning
build	Build and Test	2026-07-19T11:45:57.7004525Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginService.java:154: error: cannot find symbol
build	Build and Test	2026-07-19T11:45:57.7006800Z 			client.getUsername(), client.getPassword());
build	Build and Test	2026-07-19T11:45:57.7007872Z 			                            ^
build	Build and Test	2026-07-19T11:45:57.7008775Z   symbol:   method getPassword()
build	Build and Test	2026-07-19T11:45:57.7009632Z   location: variable client of type Client
build	Build and Test	2026-07-19T11:45:58.7015465Z Note: Some input files use or override a deprecated API.
build	Build and Test	2026-07-19T11:45:58.7055398Z Note: Recompile with -Xlint:deprecation for details.
build	Build and Test	2026-07-19T11:45:58.7114981Z Note: Some input files use unchecked or unsafe operations.
build	Build and Test	2026-07-19T11:45:58.7144814Z Note: Recompile with -Xlint:unchecked for details.
build	Build and Test	2026-07-19T11:45:58.7146259Z 1 error
build	Build and Test	2026-07-19T11:45:58.7174589Z 5 warnings
build	Build and Test	2026-07-19T11:45:59.0000050Z
build	Build and Test	2026-07-19T11:45:59.0002185Z > Task :client:compileJava FAILED
build	Build and Test	2026-07-19T11:45:59.1002099Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784461524731.json
build	Build and Test	2026-07-19T11:45:59.1007625Z
build	Build and Test	2026-07-19T11:45:59.1011803Z 55 actionable tasks: 23 executed, 32 from cache
build	Build and Test	2026-07-19T11:45:59.1018583Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-19T11:45:59.1035040Z
build	Build and Test	2026-07-19T11:45:59.1036054Z * What went wrong:
build	Build and Test	2026-07-19T11:45:59.1036935Z Execution failed for task ':client:compileJava'.
build	Build and Test	2026-07-19T11:45:59.1038058Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-19T11:45:59.1038832Z
build	Build and Test	2026-07-19T11:45:59.1039213Z * Try:
build	Build and Test	2026-07-19T11:45:59.1039912Z > Run with --info option to get more log output.
build	Build and Test	2026-07-19T11:45:59.1040832Z > Run with --scan to get full insights.
build	Build and Test	2026-07-19T11:45:59.1041457Z
build	Build and Test	2026-07-19T11:45:59.1041830Z BUILD FAILED in 42s
build	Build and Test	2026-07-19T11:45:59.5445278Z ##[error]Process completed with exit code 1.
```

## CI: Run public API bundle tests as ES modules

- Run: [29685702263](https://github.com/KSPOG/klite/actions/runs/29685702263)
- Conclusion: `failure`
- Event: `push`
- Commit: `0365c281d15705e1355d098f320d6b8f904f4144`
- Created: `2026-07-19T11:44:59Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-19T11:45:30.5255345Z > Task :runelite-api:build
build	Build and Test	2026-07-19T11:45:37.6147652Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/party/messages/PartyChatMessage.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:45:37.6149886Z
build	Build and Test	2026-07-19T11:45:37.6175398Z @Value
build	Build and Test	2026-07-19T11:45:37.6176041Z ^
build	Build and Test	2026-07-19T11:45:37.6176728Z > Task :client:compileJava
build	Build and Test	2026-07-19T11:45:37.6236878Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/PrivateMessageInput.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:45:37.6265181Z @Value
build	Build and Test	2026-07-19T11:45:37.6266576Z ^
build	Build and Test	2026-07-19T11:45:37.6268744Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/ChatboxInput.java:32: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:45:37.6270870Z @Value
build	Build and Test	2026-07-19T11:45:37.6271398Z ^
build	Build and Test	2026-07-19T11:45:37.6305039Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/devtools/ScriptInspector.java:100: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:45:37.6306924Z 	@Data
build	Build and Test	2026-07-19T11:45:37.6307339Z 	^
build	Build and Test	2026-07-19T11:45:44.0117761Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/agility/Courses.java:88: warning: non-varargs call of varargs method with inexact argument type for last parameter;
build	Build and Test	2026-07-19T11:45:44.0133175Z 		this(totalXp, -1, null);
build	Build and Test	2026-07-19T11:45:44.0134985Z 		                  ^
build	Build and Test	2026-07-19T11:45:44.0135709Z   cast to WorldPoint for a varargs call
build	Build and Test	2026-07-19T11:45:44.0136551Z   cast to WorldPoint[] for a non-varargs call and to suppress this warning
build	Build and Test	2026-07-19T11:45:46.9111171Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginService.java:154: error: cannot find symbol
build	Build and Test	2026-07-19T11:45:46.9113388Z 			client.getUsername(), client.getPassword());
build	Build and Test	2026-07-19T11:45:46.9114309Z 			                            ^
build	Build and Test	2026-07-19T11:45:46.9115621Z   symbol:   method getPassword()
build	Build and Test	2026-07-19T11:45:46.9116518Z   location: variable client of type Client
build	Build and Test	2026-07-19T11:45:47.4110678Z Note: Some input files use or override a deprecated API.
build	Build and Test	2026-07-19T11:45:47.4132970Z Note: Recompile with -Xlint:deprecation for details.
build	Build and Test	2026-07-19T11:45:47.4134312Z Note: Some input files use unchecked or unsafe operations.
build	Build and Test	2026-07-19T11:45:47.4135598Z Note: Recompile with -Xlint:unchecked for details.
build	Build and Test	2026-07-19T11:45:47.4136401Z 1 error
build	Build and Test	2026-07-19T11:45:47.4136956Z 5 warnings
build	Build and Test	2026-07-19T11:45:47.8115165Z
build	Build and Test	2026-07-19T11:45:47.8115252Z
build	Build and Test	2026-07-19T11:45:47.8116151Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-19T11:45:47.8116864Z
build	Build and Test	2026-07-19T11:45:47.8117111Z * What went wrong:
build	Build and Test	2026-07-19T11:45:47.8117695Z Execution failed for task ':client:compileJava'.
build	Build and Test	2026-07-19T11:45:47.8118491Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-19T11:45:47.8118935Z
build	Build and Test	2026-07-19T11:45:47.8119100Z * Try:
build	Build and Test	2026-07-19T11:45:47.8119846Z > Run with --info option to get more log output.
build	Build and Test	2026-07-19T11:45:47.8120277Z > Run with --scan to get full insights.
build	Build and Test	2026-07-19T11:45:47.8120596Z
build	Build and Test	2026-07-19T11:45:47.8120762Z BUILD FAILED in 31s
build	Build and Test	2026-07-19T11:45:47.8145775Z > Task :client:compileJava FAILED
build	Build and Test	2026-07-19T11:45:47.8156412Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784461519754.json
build	Build and Test	2026-07-19T11:45:47.8185807Z 55 actionable tasks: 23 executed, 32 from cache
build	Build and Test	2026-07-19T11:45:48.2138420Z ##[error]Process completed with exit code 1.
```

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29685679077](https://github.com/KSPOG/klite/actions/runs/29685679077)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `626ef515cfe1c55d7b42cc6ad199919281b95356`
- Created: `2026-07-19T11:44:16Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 2: **Check out repository** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## Apply client version, AutoLogin, and Discord updates: Add client AutoLogin and Discord update notifications

- Run: [29685646388](https://github.com/KSPOG/klite/actions/runs/29685646388)
- Conclusion: `failure`
- Event: `pull_request`
- Commit: `6758c7ef858bb946c45360215b3d4d46da647f79`
- Created: `2026-07-19T11:43:14Z`

### Failed jobs and steps

- **verify-feature** — `failure`
  - Step 5: **Run marketplace tests with diagnostics** — `failure`

### Relevant log context

```text
verify-feature	Run marketplace tests with diagnostics	﻿2026-07-19T11:43:32.4426635Z ##[group]Run set +e
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.4426967Z ^[[36;1mset +e^[[0m
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.4427311Z ^[[36;1mnpm --prefix marketplace-site test 2>&1 | tee marketplace-test.log^[[0m
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.4427727Z ^[[36;1mstatus=${PIPESTATUS[0]}^[[0m
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.4428006Z ^[[36;1mif [ "$status" -ne 0 ]; then^[[0m
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.4428269Z ^[[36;1m  {^[[0m
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.4428510Z ^[[36;1m    echo '### Marketplace test failure'^[[0m
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.4428807Z ^[[36;1m    echo '```text'^[[0m
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.4429067Z ^[[36;1m    tail -n 240 marketplace-test.log^[[0m
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.4429345Z ^[[36;1m    echo '```'^[[0m
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.4429591Z ^[[36;1m  } > marketplace-test-comment.md^[[0m
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.4429951Z ^[[36;1m  gh pr comment 57 --body-file marketplace-test-comment.md^[[0m
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.4430291Z ^[[36;1m  exit "$status"^[[0m
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.4430518Z ^[[36;1mfi^[[0m
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7718043Z ok 6 - API browser exposes working expand, collapse, and reset controls
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7718706Z   ---
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7719130Z   duration_ms: 2.321668
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7719598Z   type: 'test'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7720015Z   ...
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7720603Z # Subtest: API page links the downloadable public API source bundle
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7721629Z ok 7 - API page links the downloadable public API source bundle
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7722256Z   ---
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7722651Z   duration_ms: 0.298635
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7723107Z   type: 'test'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7723513Z   ...
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7724051Z # Subtest: Cloudflare serves API page files before dynamic API routes
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7725261Z ok 8 - Cloudflare serves API page files before dynamic API routes
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7725929Z   ---
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7726349Z   duration_ms: 0.478161
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7726808Z   type: 'test'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7727225Z   ...
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7727922Z # file:///home/runner/work/klite/klite/marketplace-site/test/api-source-bundle.test.js:1
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7728750Z # const fs = require("node:fs");
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7729246Z #            ^
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7729938Z # ReferenceError: require is not defined in ES module scope, you can use import instead
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7731867Z # This file is being treated as an ES module because it has a '.js' file extension and '/home/runner/work/klite/klite/marketplace-site/package.json' contains "type": "module". To treat it as a CommonJS script, rename it to use the '.cjs' file extension.
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7733811Z #     at file:///home/runner/work/klite/klite/marketplace-site/test/api-source-bundle.test.js:1:12
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7734839Z #     at ModuleJob.run (node:internal/modules/esm/module_job:343:25)
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7735777Z #     at async onImport.tracePromise.__proto__ (node:internal/modules/esm/loader:681:26)
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7736754Z #     at async asyncRunEntryPointWithESMLoader (node:internal/modules/run_main:117:5)
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7737492Z # Node.js v22.23.1
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7737982Z # Subtest: test/api-source-bundle.test.js
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7738584Z not ok 3 - test/api-source-bundle.test.js
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7739730Z   ---
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7740188Z   duration_ms: 47.563748
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7740641Z   type: 'test'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7741769Z   location: '/home/runner/work/klite/klite/marketplace-site/test/api-source-bundle.test.js:1:1'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7742645Z   failureType: 'testCodeFailure'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7743302Z   exitCode: 1
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7743710Z   signal: ~
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7744134Z   error: 'test failed'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7744597Z   code: 'ERR_TEST_FAILURE'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7745083Z   ...
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7826546Z # Subtest: publishes only client-valid marketplace tags
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7832782Z ok 10 - publishes only client-valid marketplace tags
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7834694Z   ---
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7835204Z   duration_ms: 6.477586
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7835683Z   type: 'test'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.7836113Z   ...
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.8420759Z   type: 'test'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.8421348Z   ...
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.8880730Z # Subtest: normalizes Discord bot role and channel settings
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.8913854Z ok 18 - normalizes Discord bot role and channel settings
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.8914652Z   ---
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.8936408Z   duration_ms: 1.969683
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.8938316Z   type: 'test'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.8938890Z   ...
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.8939621Z # Subtest: shows the dashboard only when the linked member currently has Dev
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.8965715Z ok 19 - shows the dashboard only when the linked member currently has Dev
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.8966319Z   ---
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.8966621Z   duration_ms: 36.117671
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.8966966Z   type: 'test'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.8967259Z   ...
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.9042375Z # Subtest: public pages serve the generated design system and scoped credit styles
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.9059140Z not ok 20 - public pages serve the generated design system and scoped credit styles
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.9072712Z   ---
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.9098482Z   duration_ms: 46.830499
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.9125980Z   type: 'test'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.9152262Z   location: '/home/runner/work/klite/klite/marketplace-site/test/home-styles.test.js:13:1'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.9162993Z   failureType: 'testCodeFailure'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.9172864Z   error: |-
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.9183746Z     Expected values to be strictly equal:
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.9184678Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.9185042Z     2 !== 1
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.9185394Z
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.9185879Z   code: 'ERR_ASSERTION'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.9186332Z   name: 'AssertionError'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.9186757Z   expected: 1
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.9187248Z   actual: 2
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.9187664Z   operator: 'strictEqual'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.9188411Z   stack: |-
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.9189534Z     TestContext.<anonymous> (file:///home/runner/work/klite/klite/marketplace-site/test/home-styles.test.js:39:12)
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.9190808Z     async Test.run (node:internal/test_runner/test:1054:7)
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:32.9192169Z     async startSubtestAfterBootstrap (node:internal/test_runner/harness:296:3)
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:33.5078414Z   ---
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:33.5078811Z   duration_ms: 2.957692
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:33.5079246Z   type: 'test'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:33.5079654Z   ...
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:33.5080211Z # Subtest: requires a client login before serving paid plugin artifacts
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:33.5081117Z ok 34 - requires a client login before serving paid plugin artifacts
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:33.5081777Z   ---
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:33.5082158Z   duration_ms: 0.803433
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:33.5082600Z   type: 'test'
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:33.5083009Z   ...
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:33.5112028Z 1..34
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:33.5118279Z # tests 34
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:33.5118790Z # suites 0
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:33.5119195Z # pass 32
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:33.5119563Z # fail 2
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:33.5119858Z # cancelled 0
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:33.5120169Z # skipped 0
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:33.5121076Z # todo 0
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:33.5121496Z # duration_ms 870.295572
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:34.2458869Z https://github.com/KSPOG/klite/pull/57#issuecomment-5015578954
verify-feature	Run marketplace tests with diagnostics	2026-07-19T11:43:34.2485769Z ##[error]Process completed with exit code 1.
```

## CI: Add client AutoLogin and Discord update notifications

- Run: [29685646376](https://github.com/KSPOG/klite/actions/runs/29685646376)
- Conclusion: `failure`
- Event: `pull_request`
- Commit: `6758c7ef858bb946c45360215b3d4d46da647f79`
- Created: `2026-07-19T11:43:14Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-19T11:43:56.1303387Z > Task :runelite-api:build
build	Build and Test	2026-07-19T11:44:05.3295197Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/party/messages/PartyChatMessage.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:44:05.3297644Z
build	Build and Test	2026-07-19T11:44:05.3322856Z > Task :client:compileJava
build	Build and Test	2026-07-19T11:44:05.3362533Z @Value
build	Build and Test	2026-07-19T11:44:05.3392530Z ^
build	Build and Test	2026-07-19T11:44:05.3454544Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/PrivateMessageInput.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:44:05.3482531Z @Value
build	Build and Test	2026-07-19T11:44:05.3546058Z ^
build	Build and Test	2026-07-19T11:44:05.3548342Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/ChatboxInput.java:32: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:44:05.3593204Z @Value
build	Build and Test	2026-07-19T11:44:05.3598363Z ^
build	Build and Test	2026-07-19T11:44:05.3600786Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/devtools/ScriptInspector.java:100: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:44:05.3602770Z 	@Data
build	Build and Test	2026-07-19T11:44:05.3603141Z 	^
build	Build and Test	2026-07-19T11:44:12.5261036Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/agility/Courses.java:88: warning: non-varargs call of varargs method with inexact argument type for last parameter;
build	Build and Test	2026-07-19T11:44:12.5302699Z 		this(totalXp, -1, null);
build	Build and Test	2026-07-19T11:44:12.5303482Z 		                  ^
build	Build and Test	2026-07-19T11:44:12.5332741Z   cast to WorldPoint for a varargs call
build	Build and Test	2026-07-19T11:44:12.5362990Z   cast to WorldPoint[] for a non-varargs call and to suppress this warning
build	Build and Test	2026-07-19T11:44:16.2314263Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginService.java:154: error: cannot find symbol
build	Build and Test	2026-07-19T11:44:16.2372838Z 			client.getUsername(), client.getPassword());
build	Build and Test	2026-07-19T11:44:16.2442651Z 			                            ^
build	Build and Test	2026-07-19T11:44:16.2502780Z   symbol:   method getPassword()
build	Build and Test	2026-07-19T11:44:16.2503411Z   location: variable client of type Client
build	Build and Test	2026-07-19T11:44:17.1262662Z Note: Some input files use or override a deprecated API.
build	Build and Test	2026-07-19T11:44:17.1292920Z Note: Recompile with -Xlint:deprecation for details.
build	Build and Test	2026-07-19T11:44:17.1303161Z Note: Some input files use unchecked or unsafe operations.
build	Build and Test	2026-07-19T11:44:17.1303942Z Note: Recompile with -Xlint:unchecked for details.
build	Build and Test	2026-07-19T11:44:17.1304515Z 1 error
build	Build and Test	2026-07-19T11:44:17.1304861Z 5 warnings
build	Build and Test	2026-07-19T11:44:17.5258993Z
build	Build and Test	2026-07-19T11:44:17.5273420Z > Task :client:compileJava FAILED
build	Build and Test	2026-07-19T11:44:17.5274835Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784461423027.json
build	Build and Test	2026-07-19T11:44:17.6258549Z
build	Build and Test	2026-07-19T11:44:17.6260248Z 55 actionable tasks: 23 executed, 32 from cache
build	Build and Test	2026-07-19T11:44:17.6268163Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-19T11:44:17.6297406Z
build	Build and Test	2026-07-19T11:44:17.6330442Z * What went wrong:
build	Build and Test	2026-07-19T11:44:17.6338196Z Execution failed for task ':client:compileJava'.
build	Build and Test	2026-07-19T11:44:17.6362893Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-19T11:44:17.6364749Z
build	Build and Test	2026-07-19T11:44:17.6365111Z * Try:
build	Build and Test	2026-07-19T11:44:17.6365763Z > Run with --info option to get more log output.
build	Build and Test	2026-07-19T11:44:17.6366561Z > Run with --scan to get full insights.
build	Build and Test	2026-07-19T11:44:17.6367112Z
build	Build and Test	2026-07-19T11:44:17.6367449Z BUILD FAILED in 41s
build	Build and Test	2026-07-19T11:44:18.0404680Z ##[error]Process completed with exit code 1.
```

## CI: Report marketplace test diagnostics for feature verification

- Run: [29685645270](https://github.com/KSPOG/klite/actions/runs/29685645270)
- Conclusion: `failure`
- Event: `push`
- Commit: `6758c7ef858bb946c45360215b3d4d46da647f79`
- Created: `2026-07-19T11:43:12Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-19T11:43:49.3097633Z > Task :runelite-api:build
build	Build and Test	2026-07-19T11:43:58.6985696Z
build	Build and Test	2026-07-19T11:43:58.7002167Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/ChatboxInput.java:32: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:43:58.7004767Z > Task :client:compileJava
build	Build and Test	2026-07-19T11:43:58.7029830Z @Value
build	Build and Test	2026-07-19T11:43:58.7039715Z ^
build	Build and Test	2026-07-19T11:43:58.7042128Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/party/messages/PartyChatMessage.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:43:58.7044656Z @Value
build	Build and Test	2026-07-19T11:43:58.7060298Z ^
build	Build and Test	2026-07-19T11:43:58.7062842Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/PrivateMessageInput.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:43:58.7065696Z @Value
build	Build and Test	2026-07-19T11:43:58.7066350Z ^
build	Build and Test	2026-07-19T11:43:58.7068900Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/devtools/ScriptInspector.java:100: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:43:58.7071915Z 	@Data
build	Build and Test	2026-07-19T11:43:58.7072548Z 	^
build	Build and Test	2026-07-19T11:44:05.6008078Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/agility/Courses.java:88: warning: non-varargs call of varargs method with inexact argument type for last parameter;
build	Build and Test	2026-07-19T11:44:05.6039920Z 		this(totalXp, -1, null);
build	Build and Test	2026-07-19T11:44:05.6040822Z 		                  ^
build	Build and Test	2026-07-19T11:44:05.6069928Z   cast to WorldPoint for a varargs call
build	Build and Test	2026-07-19T11:44:05.6100033Z   cast to WorldPoint[] for a non-varargs call and to suppress this warning
build	Build and Test	2026-07-19T11:44:09.5983448Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginService.java:154: error: cannot find symbol
build	Build and Test	2026-07-19T11:44:09.6000303Z 			client.getUsername(), client.getPassword());
build	Build and Test	2026-07-19T11:44:09.6020320Z 			                            ^
build	Build and Test	2026-07-19T11:44:09.6021117Z   symbol:   method getPassword()
build	Build and Test	2026-07-19T11:44:09.6021949Z   location: variable client of type Client
build	Build and Test	2026-07-19T11:44:10.4981837Z Note: Some input files use or override a deprecated API.
build	Build and Test	2026-07-19T11:44:10.4983324Z Note: Recompile with -Xlint:deprecation for details.
build	Build and Test	2026-07-19T11:44:10.4991130Z Note: Some input files use unchecked or unsafe operations.
build	Build and Test	2026-07-19T11:44:10.5008281Z Note: Recompile with -Xlint:unchecked for details.
build	Build and Test	2026-07-19T11:44:10.5030911Z 1 error
build	Build and Test	2026-07-19T11:44:10.5039896Z 5 warnings
build	Build and Test	2026-07-19T11:44:10.8980238Z
build	Build and Test	2026-07-19T11:44:10.9010255Z > Task :client:compileJava FAILED
build	Build and Test	2026-07-19T11:44:10.9030310Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784461417120.json
build	Build and Test	2026-07-19T11:44:10.9978971Z
build	Build and Test	2026-07-19T11:44:10.9982687Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-19T11:44:10.9983168Z 55 actionable tasks: 23 executed, 32 from cache
build	Build and Test	2026-07-19T11:44:10.9983692Z
build	Build and Test	2026-07-19T11:44:10.9984437Z * What went wrong:
build	Build and Test	2026-07-19T11:44:10.9987348Z Execution failed for task ':client:compileJava'.
build	Build and Test	2026-07-19T11:44:10.9988005Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-19T11:44:10.9988923Z
build	Build and Test	2026-07-19T11:44:10.9989428Z * Try:
build	Build and Test	2026-07-19T11:44:10.9990058Z > Run with --info option to get more log output.
build	Build and Test	2026-07-19T11:44:10.9990674Z > Run with --scan to get full insights.
build	Build and Test	2026-07-19T11:44:10.9991042Z
build	Build and Test	2026-07-19T11:44:10.9991239Z BUILD FAILED in 41s
build	Build and Test	2026-07-19T11:44:11.3921715Z ##[error]Process completed with exit code 1.
```

## CI: Add client AutoLogin and Discord update notifications

- Run: [29685593640](https://github.com/KSPOG/klite/actions/runs/29685593640)
- Conclusion: `action_required`
- Event: `pull_request`
- Commit: `26e184affeccd8dbeb90dfd79b916710281f1749`
- Created: `2026-07-19T11:41:30Z`

### Failed jobs and steps

No failed job metadata was returned.

### Relevant log context

```text

failed to get run log: log not found
```

## Apply client version, AutoLogin, and Discord updates: Add client AutoLogin and Discord update notifications

- Run: [29685593614](https://github.com/KSPOG/klite/actions/runs/29685593614)
- Conclusion: `action_required`
- Event: `pull_request`
- Commit: `26e184affeccd8dbeb90dfd79b916710281f1749`
- Created: `2026-07-19T11:41:30Z`

### Failed jobs and steps

No failed job metadata was returned.

### Relevant log context

```text

failed to get run log: log not found
```

