# Website control audit

This audit covers the public marketplace homepage, account and developer dashboards,
Discord bot dashboard, owner administration, credit wallet and credit administration,
API reference, plugin development guide, and changelog.

## Control contract

Every interactive control must have all of the following:

1. A browser event handler or native link/form action.
2. A matching Worker route when it calls `/api/*`.
3. A visible loading state while asynchronous work is running.
4. A visible success or failure result.
5. A regression test covering the control ID or API route.

## Fixed during this audit

- Added the missing owner account and role-management routes.
- Added the missing Discord Dev-role creation route.
- Kept Discord-only authentication for the website and blocked legacy password login,
  registration, and reset endpoints at the Worker entry point.
- Removed the legacy password and recovery dialogs from the rendered website.
- Added the missing dashboard installation payload expected by the browser renderer.
- Restored `site_owner` capability decoration on the normal account endpoint.
- Added visible progress and failure feedback for Discord linking, one-time link codes,
  sign-out, and installation verification.
- Kept credit-administration authorization failures visible instead of silently
  removing the complete panel.
- Added browser-to-Worker route and static-control contract tests.

## Areas verified without functional changes

- Marketplace search, category, access-type, and ordering filters.
- Primary and secondary route navigation.
- API-reference search, tabs, filters, expand/collapse, reset, and copy controls.
- Documentation table of contents and code-copy controls.
- Changelog category filters.
- Credit checkout, premium purchase, price selection, and price-save handlers.
