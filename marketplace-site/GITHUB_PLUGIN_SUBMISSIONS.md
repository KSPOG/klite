# Private GitHub plugin submissions

KLite accepts raw Java plugin classes from authenticated Plugin Dev members.
Unreviewed source is committed to the private
`KSPOG/klite-plugin-submissions` repository. Approval creates a source branch
and pull request in `KSPOG/klite`; it never pushes directly to public `main`.

## Cloudflare Pages configuration

Add these plaintext variables to the Production environment:

```text
GITHUB_SUBMISSIONS_REPOSITORY=KSPOG/klite-plugin-submissions
GITHUB_SUBMISSIONS_BRANCH=main
GITHUB_MAIN_REPOSITORY=KSPOG/klite
GITHUB_MAIN_BRANCH=main
```

Add these encrypted secrets:

```text
GITHUB_SUBMISSIONS_TOKEN
GITHUB_PROMOTION_TOKEN
```

Use separate fine-grained GitHub personal access tokens:

- `GITHUB_SUBMISSIONS_TOKEN`: repository access only to
  `KSPOG/klite-plugin-submissions`, with repository Contents read/write.
- `GITHUB_PROMOTION_TOKEN`: repository access only to `KSPOG/klite`, with
  repository Contents read/write and Pull requests read/write.

Never expose either token to browser JavaScript, commit it to the repository,
or configure it as a plaintext variable.

## Submission validation

- One to 100 `.java` files.
- Maximum 1 MiB per file and 20 MiB for the complete submission.
- UTF-8 source with an explicit Java package.
- Exactly one `@PluginDescriptor` class that extends `Plugin`.
- Repository paths are derived from package declarations; client-supplied
  directory paths are not trusted.
- A deterministic SHA-256 covers every sorted source path, size, and byte
  sequence.

## Approval

The backend reads every source file from the immutable private commit and
recomputes the complete SHA-256 before promotion. It then creates:

- `plugins/<plugin-id>/src/main/java/...`
- `plugins/<plugin-id>/build.gradle.kts`
- `plugins/<plugin-id>/KLITE_SUBMISSION.json`
- the required `settings.gradle.kts` project registration

The result is opened as a pull request. Repository CI and normal merge review
remain mandatory before the source reaches `main`.
