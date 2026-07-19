# Recent GitHub Actions failures

Generated: 2026-07-19T15:45:58.730077+00:00
Repository: `KSPOG/klite`
Failed runs inspected: **2**

## CI: Add world map target controller for WebWalker

- Run: [29693454362](https://github.com/KSPOG/klite/actions/runs/29693454362)
- Conclusion: `failure`
- Event: `push`
- Commit: `e943a8df886a5898faa38f04532243199520ebba`
- Created: `2026-07-19T15:44:39Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-19T15:45:17.5154421Z > Task :runelite-api:build
build	Build and Test	2026-07-19T15:45:26.5156762Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/ChatboxInput.java:32: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T15:45:26.5159178Z
build	Build and Test	2026-07-19T15:45:26.5184104Z @Value
build	Build and Test	2026-07-19T15:45:26.5184598Z > Task :client:compileJava
build	Build and Test	2026-07-19T15:45:26.5214134Z ^
build	Build and Test	2026-07-19T15:45:26.5249323Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/party/messages/PartyChatMessage.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T15:45:26.5274899Z @Value
build	Build and Test	2026-07-19T15:45:26.5304008Z ^
build	Build and Test	2026-07-19T15:45:26.5336010Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/PrivateMessageInput.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T15:45:26.5363936Z @Value
build	Build and Test	2026-07-19T15:45:26.5393941Z ^
build	Build and Test	2026-07-19T15:45:26.5426086Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/devtools/ScriptInspector.java:100: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T15:45:26.5453997Z 	@Data
build	Build and Test	2026-07-19T15:45:26.5483978Z 	^
build	Build and Test	2026-07-19T15:45:33.2112703Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/agility/Courses.java:88: warning: non-varargs call of varargs method with inexact argument type for last parameter;
build	Build and Test	2026-07-19T15:45:33.2124638Z 		this(totalXp, -1, null);
build	Build and Test	2026-07-19T15:45:33.2134614Z 		                  ^
build	Build and Test	2026-07-19T15:45:33.2154597Z   cast to WorldPoint for a varargs call
build	Build and Test	2026-07-19T15:45:33.2155766Z   cast to WorldPoint[] for a non-varargs call and to suppress this warning
build	Build and Test	2026-07-19T15:45:37.6125643Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/walker/KLiteWorldMapWebWalkerController.java:81: error: cannot find symbol
build	Build and Test	2026-07-19T15:45:37.6154439Z 			|| WebWalkerTask.TASK_NAME.equals(automation.getTaskName()))
build	Build and Test	2026-07-19T15:45:37.6169711Z 			                ^
build	Build and Test	2026-07-19T15:45:37.6184009Z   symbol:   variable TASK_NAME
build	Build and Test	2026-07-19T15:45:37.6214085Z   location: class WebWalkerTask
build	Build and Test	2026-07-19T15:45:37.6244880Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/walker/KLiteWorldMapWebWalkerController.java:109: error: cannot find symbol
build	Build and Test	2026-07-19T15:45:37.6270445Z 			if (!WebWalkerTask.TASK_NAME.equals(status.getTaskName()))
build	Build and Test	2026-07-19T15:45:37.6271504Z 			                  ^
build	Build and Test	2026-07-19T15:45:37.6293988Z   symbol:   variable TASK_NAME
build	Build and Test	2026-07-19T15:45:37.6317073Z   location: class WebWalkerTask
build	Build and Test	2026-07-19T15:45:37.6326333Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/walker/KLiteWorldMapWebWalkerController.java:134: error: cannot find symbol
build	Build and Test	2026-07-19T15:45:37.6331867Z 		if (WebWalkerTask.TASK_NAME.equals(status.getTaskName()))
build	Build and Test	2026-07-19T15:45:37.6336406Z 		                 ^
build	Build and Test	2026-07-19T15:45:37.6340589Z   symbol:   variable TASK_NAME
build	Build and Test	2026-07-19T15:45:37.6349740Z   location: class WebWalkerTask
build	Build and Test	2026-07-19T15:45:38.4194874Z Note: Some input files use or override a deprecated API.
build	Build and Test	2026-07-19T15:45:38.4224311Z Note: Recompile with -Xlint:deprecation for details.
build	Build and Test	2026-07-19T15:45:38.4254989Z Note: Some input files use unchecked or unsafe operations.
build	Build and Test	2026-07-19T15:45:38.4256485Z Note: Recompile with -Xlint:unchecked for details.
build	Build and Test	2026-07-19T15:45:38.4257080Z 3 errors
build	Build and Test	2026-07-19T15:45:38.4257444Z 5 warnings
build	Build and Test	2026-07-19T15:45:38.8110843Z
build	Build and Test	2026-07-19T15:45:38.8117844Z
build	Build and Test	2026-07-19T15:45:38.8118518Z > Task :client:compileJava FAILED
build	Build and Test	2026-07-19T15:45:38.8126268Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784475903361.json
build	Build and Test	2026-07-19T15:45:38.8128351Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-19T15:45:38.8129448Z 55 actionable tasks: 22 executed, 33 from cache
build	Build and Test	2026-07-19T15:45:38.8129927Z
build	Build and Test	2026-07-19T15:45:38.8141570Z * What went wrong:
build	Build and Test	2026-07-19T15:45:38.8159542Z Execution failed for task ':client:compileJava'.
build	Build and Test	2026-07-19T15:45:38.8162279Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-19T15:45:38.8162835Z
build	Build and Test	2026-07-19T15:45:38.8163028Z * Try:
build	Build and Test	2026-07-19T15:45:38.8163887Z > Run with --info option to get more log output.
build	Build and Test	2026-07-19T15:45:38.8164629Z > Run with --scan to get full insights.
build	Build and Test	2026-07-19T15:45:38.8165018Z
build	Build and Test	2026-07-19T15:45:38.8165205Z BUILD FAILED in 44s
build	Build and Test	2026-07-19T15:45:39.2883295Z ##[error]Process completed with exit code 1.
```

## KLite marketplace D1 migrations: Merge pull request #60 from KSPOG/agent/fix-discord-dashboard-actions

- Run: [29691506140](https://github.com/KSPOG/klite/actions/runs/29691506140)
- Conclusion: `failure`
- Event: `push`
- Commit: `e0cd9f7bf1196d6e40effe7bc28de8d3a0e233f9`
- Created: `2026-07-19T14:46:43Z`

### Failed jobs and steps

- **Apply production migrations** — `failure`
  - Step 7: **Apply D1 migrations** — `failure`

### Relevant log context

```text
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:53.8654715Z   CLOUDFLARE_API_TOKEN: ***
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:53.8655060Z   CLOUDFLARE_ACCOUNT_ID: ***
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:53.8655311Z ##[endgroup]
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:55.2932042Z
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:55.2933481Z  ⛅️ wrangler 4.111.0
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:55.2934535Z ────────────────────
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:55.2940358Z Resource location: remote
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:55.2940809Z
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:55.8905865Z Migrations to be applied:
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:55.8970363Z ┌─────────────────────────┐
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:55.8971149Z │ name                    │
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:55.8971929Z ├─────────────────────────┤
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:55.8972590Z │ 0009_password_reset.sql │
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:55.8973372Z └─────────────────────────┘
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:55.8974142Z ? About to apply 1 migration(s)
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:55.8975145Z Your database may not be available to serve requests during the migration, continue?
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:55.8976223Z 🤖 Using fallback value in non-interactive context: yes
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:55.8980035Z 🌀 Executing on remote database klite-marketplace (***):
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:55.8981524Z 🌀 To execute on your local development database, remove the --remote flag from your wrangler command.
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:56.0548382Z
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:56.1069589Z ^[[31m✘ ^[[41;31m[^[[41;97mERROR^[[41;31m]^[[0m ^[[1mA request to the Cloudflare API (/accounts/***/d1/database/***/query) failed.^[[0m
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:56.1070553Z
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:56.1071073Z   table password_reset_states already exists at offset 13: SQLITE_ERROR [code: 7500]
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:56.1071768Z
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:56.1072640Z   If you think this is a bug, please open an issue at: ^[[4mhttps://github.com/cloudflare/workers-sdk/issues/new/choose^[[0m
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:56.1073268Z
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:56.1073276Z
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:56.1184781Z 🪵  Logs were written to "/home/runner/.config/.wrangler/logs/wrangler-2026-07-19_14-46-54_898.log"
Apply production migrations	Apply D1 migrations	2026-07-19T14:46:56.1517784Z ##[error]Process completed with exit code 1.
```

