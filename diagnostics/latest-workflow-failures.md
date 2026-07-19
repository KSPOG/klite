# Recent GitHub Actions failures

Generated: 2026-07-19T11:44:42.831026+00:00
Repository: `KSPOG/klite`
Failed runs inspected: **13**

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

## Apply client version, AutoLogin, and Discord updates: Add client AutoLogin and Discord update notifications

- Run: [29685581937](https://github.com/KSPOG/klite/actions/runs/29685581937)
- Conclusion: `failure`
- Event: `pull_request`
- Commit: `3e6178ec65f39c0340c5903ff7c770a5197afaff`
- Created: `2026-07-19T11:41:06Z`

### Failed jobs and steps

- **apply-and-verify** — `failure`
  - Step 7: **Run marketplace tests** — `failure`

### Relevant log context

```text
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4743270Z ok 6 - API browser exposes working expand, collapse, and reset controls
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4744249Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4744619Z   duration_ms: 1.538749
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4745025Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4745390Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4745869Z # Subtest: API page links the downloadable public API source bundle
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4746558Z ok 7 - API page links the downloadable public API source bundle
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4747095Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4747449Z   duration_ms: 0.241811
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4747863Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4748239Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4748735Z # Subtest: Cloudflare serves API page files before dynamic API routes
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4749466Z ok 8 - Cloudflare serves API page files before dynamic API routes
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4750032Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4750528Z   duration_ms: 0.306558
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4750928Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4751291Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4751887Z # file:///home/runner/work/klite/klite/marketplace-site/test/api-source-bundle.test.js:1
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4760578Z # const fs = require("node:fs");
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4761385Z #            ^
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4802826Z # ReferenceError: require is not defined in ES module scope, you can use import instead
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4805002Z # This file is being treated as an ES module because it has a '.js' file extension and '/home/runner/work/klite/klite/marketplace-site/package.json' contains "type": "module". To treat it as a CommonJS script, rename it to use the '.cjs' file extension.
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4807476Z #     at file:///home/runner/work/klite/klite/marketplace-site/test/api-source-bundle.test.js:1:12
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4808490Z #     at ModuleJob.run (node:internal/modules/esm/module_job:343:25)
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4809516Z #     at async onImport.tracePromise.__proto__ (node:internal/modules/esm/loader:681:26)
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4810795Z #     at async asyncRunEntryPointWithESMLoader (node:internal/modules/run_main:117:5)
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4811323Z # Node.js v22.23.1
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4811576Z # Subtest: test/api-source-bundle.test.js
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4811942Z not ok 3 - test/api-source-bundle.test.js
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4812243Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4812447Z   duration_ms: 35.947661
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4812842Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4813311Z   location: '/home/runner/work/klite/klite/marketplace-site/test/api-source-bundle.test.js:1:1'
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4813846Z   failureType: 'testCodeFailure'
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4814126Z   exitCode: 1
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4814333Z   signal: ~
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4814614Z   error: 'test failed'
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4814881Z   code: 'ERR_TEST_FAILURE'
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4815151Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4815460Z # Subtest: publishes only client-valid marketplace tags
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4815937Z ok 10 - publishes only client-valid marketplace tags
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4816317Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4816550Z   duration_ms: 5.033492
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4816816Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.4817064Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5355846Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5356235Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5565128Z # Subtest: normalizes Discord bot role and channel settings
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5566562Z ok 18 - normalizes Discord bot role and channel settings
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5567318Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5567765Z   duration_ms: 1.708614
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5568237Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5568653Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5571122Z # Subtest: shows the dashboard only when the linked member currently has Dev
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5574870Z ok 19 - shows the dashboard only when the linked member currently has Dev
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5575594Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5576026Z   duration_ms: 27.801307
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5576464Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5576853Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5795282Z # Subtest: public pages serve the generated design system and scoped credit styles
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5820799Z not ok 20 - public pages serve the generated design system and scoped credit styles
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5850540Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5850926Z   duration_ms: 51.314946
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5851304Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5851948Z   location: '/home/runner/work/klite/klite/marketplace-site/test/home-styles.test.js:13:1'
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5852613Z   failureType: 'testCodeFailure'
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5853037Z   error: |-
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5853375Z     Expected values to be strictly equal:
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5853810Z
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5854067Z     2 !== 1
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5854372Z
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5854635Z   code: 'ERR_ASSERTION'
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5854988Z   name: 'AssertionError'
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5855300Z   expected: 1
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5855621Z   actual: 2
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5855931Z   operator: 'strictEqual'
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5856282Z   stack: |-
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5857053Z     TestContext.<anonymous> (file:///home/runner/work/klite/klite/marketplace-site/test/home-styles.test.js:39:12)
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5858035Z     async Test.run (node:internal/test_runner/test:1054:7)
apply-and-verify	Run marketplace tests	2026-07-19T11:41:26.5859094Z     async startSubtestAfterBootstrap (node:internal/test_runner/harness:296:3)
apply-and-verify	Run marketplace tests	2026-07-19T11:41:27.0652667Z ok 33 - streams free plugin artifacts from private object storage
apply-and-verify	Run marketplace tests	2026-07-19T11:41:27.0653158Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:41:27.0653397Z   duration_ms: 3.436215
apply-and-verify	Run marketplace tests	2026-07-19T11:41:27.0653681Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:41:27.0654273Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:41:27.0654684Z # Subtest: requires a client login before serving paid plugin artifacts
apply-and-verify	Run marketplace tests	2026-07-19T11:41:27.0655299Z ok 34 - requires a client login before serving paid plugin artifacts
apply-and-verify	Run marketplace tests	2026-07-19T11:41:27.0655747Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:41:27.0655981Z   duration_ms: 0.672495
apply-and-verify	Run marketplace tests	2026-07-19T11:41:27.0656268Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:41:27.0656507Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:41:27.0716855Z 1..34
apply-and-verify	Run marketplace tests	2026-07-19T11:41:27.0717241Z # tests 34
apply-and-verify	Run marketplace tests	2026-07-19T11:41:27.0717550Z # suites 0
apply-and-verify	Run marketplace tests	2026-07-19T11:41:27.0717881Z # pass 32
apply-and-verify	Run marketplace tests	2026-07-19T11:41:27.0718129Z # fail 2
apply-and-verify	Run marketplace tests	2026-07-19T11:41:27.0718576Z # cancelled 0
apply-and-verify	Run marketplace tests	2026-07-19T11:41:27.0718907Z # skipped 0
apply-and-verify	Run marketplace tests	2026-07-19T11:41:27.0719199Z # todo 0
apply-and-verify	Run marketplace tests	2026-07-19T11:41:27.0719524Z # duration_ms 698.205385
apply-and-verify	Run marketplace tests	2026-07-19T11:41:27.0891123Z ##[error]Process completed with exit code 1.
```

## Apply client version, AutoLogin, and Discord updates: Add client AutoLogin and Discord update notifications

- Run: [29685505598](https://github.com/KSPOG/klite/actions/runs/29685505598)
- Conclusion: `failure`
- Event: `pull_request`
- Commit: `a4eeeb5fe0d6f42ff10407dcd0b502b50c0c778d`
- Created: `2026-07-19T11:38:39Z`

### Failed jobs and steps

- **apply-and-verify** — `failure`
  - Step 5: **Commit generated feature changes** — `failure`

### Relevant log context

```text
apply-and-verify	Commit generated feature changes	﻿2026-07-19T11:39:01.4749537Z ##[group]Run git config user.name "github-actions[bot]"
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:01.4749984Z ^[[36;1mgit config user.name "github-actions[bot]"^[[0m
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:01.4750458Z ^[[36;1mgit config user.email "41898282+github-actions[bot]@users.noreply.github.com"^[[0m
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:01.4750896Z ^[[36;1mgit add -A^[[0m
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:01.4751245Z ^[[36;1mgit commit -m "Add client AutoLogin and Discord update notifications"^[[0m
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:01.4751869Z ^[[36;1mif ! git push origin HEAD:feature/client-version-autologin-discord-updates 2>push-error.log; then^[[0m
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:01.4752372Z ^[[36;1m  {^[[0m
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:01.4752606Z ^[[36;1m    echo '### Generated source push failed'^[[0m
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:01.4752901Z ^[[36;1m    echo '```text'^[[0m
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:01.4753147Z ^[[36;1m    cat push-error.log^[[0m
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:01.4753391Z ^[[36;1m    echo '```'^[[0m
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:01.4753617Z ^[[36;1m  } > push-comment.md^[[0m
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:01.4753926Z ^[[36;1m  gh pr comment 57 --body-file push-comment.md^[[0m
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:01.4754263Z ^[[36;1m  exit 1^[[0m
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:01.4754457Z ^[[36;1mfi^[[0m
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:01.4819115Z shell: /usr/bin/bash --noprofile --norc -e -o pipefail {0}
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:01.4819470Z env:
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:01.4819784Z   JAVA_HOME: /opt/hostedtoolcache/Java_Temurin-Hotspot_jdk/11.0.31-11/x64
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:01.4820316Z   JAVA_HOME_11_X64: /opt/hostedtoolcache/Java_Temurin-Hotspot_jdk/11.0.31-11/x64
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:01.4823137Z   GH_TOKEN: ***
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:01.4823348Z ##[endgroup]
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:01.6301031Z [feature/client-version-autologin-discord-updates 062919db3] Add client AutoLogin and Discord update notifications
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:01.6302254Z  17 files changed, 758 insertions(+), 30 deletions(-)
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:01.6302991Z  create mode 100644 marketplace-site/migrations/0008_client_updates.sql
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:01.6303794Z  create mode 100644 marketplace-site/test/client-updates.test.js
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:01.6304591Z  create mode 100644 marketplace-site/worker/client-updates.js
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:01.6305390Z  create mode 100644 runelite-client/src/main/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginService.java
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:01.6306308Z  create mode 100644 runelite-client/src/test/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginServiceTest.java
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:01.6307549Z  create mode 100644 runelite-client/src/test/java/net/runelite/client/plugins/klite/marketplace/KLitePluginPanelVersionTest.java
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:03.7267314Z https://github.com/KSPOG/klite/pull/57#issuecomment-5015566043
apply-and-verify	Commit generated feature changes	2026-07-19T11:39:03.7282816Z ##[error]Process completed with exit code 1.
```

## Apply client version, AutoLogin, and Discord updates: Add client AutoLogin and Discord update notifications

- Run: [29685470699](https://github.com/KSPOG/klite/actions/runs/29685470699)
- Conclusion: `failure`
- Event: `pull_request`
- Commit: `cc4ae973e9717c6eaea0ced3038d38c9436f1a47`
- Created: `2026-07-19T11:37:33Z`

### Failed jobs and steps

- **apply-and-verify** — `failure`
  - Step 5: **Commit generated feature changes** — `failure`

### Relevant log context

```text
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:48.9692020Z ^[[36;1mgit config user.name "github-actions[bot]"^[[0m
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:48.9692491Z ^[[36;1mgit config user.email "41898282+github-actions[bot]@users.noreply.github.com"^[[0m
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:48.9692940Z ^[[36;1mgit add -A^[[0m
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:48.9693296Z ^[[36;1mgit commit -m "Add client AutoLogin and Discord update notifications"^[[0m
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:48.9693832Z ^[[36;1mgit push origin HEAD:feature/client-version-autologin-discord-updates^[[0m
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:48.9755050Z shell: /usr/bin/bash --noprofile --norc -e -o pipefail {0}
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:48.9755438Z env:
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:48.9755760Z   JAVA_HOME: /opt/hostedtoolcache/Java_Temurin-Hotspot_jdk/11.0.31-11/x64
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:48.9756295Z   JAVA_HOME_11_X64: /opt/hostedtoolcache/Java_Temurin-Hotspot_jdk/11.0.31-11/x64
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:48.9756882Z ##[endgroup]
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:49.1959291Z [feature/client-version-autologin-discord-updates f0a9da445] Add client AutoLogin and Discord update notifications
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:49.1960482Z  17 files changed, 758 insertions(+), 30 deletions(-)
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:49.1961239Z  create mode 100644 marketplace-site/migrations/0008_client_updates.sql
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:49.1962032Z  create mode 100644 marketplace-site/test/client-updates.test.js
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:49.1962619Z  create mode 100644 marketplace-site/worker/client-updates.js
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:49.1963710Z  create mode 100644 runelite-client/src/main/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginService.java
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:49.1965672Z  create mode 100644 runelite-client/src/test/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginServiceTest.java
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:49.1966650Z  create mode 100644 runelite-client/src/test/java/net/runelite/client/plugins/klite/marketplace/KLitePluginPanelVersionTest.java
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:49.8650312Z To https://github.com/KSPOG/klite
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:49.8652613Z  ! [remote rejected]     HEAD -> feature/client-version-autologin-discord-updates (refusing to allow a GitHub App to create or update workflow `.github/workflows/build-windows-client.yml` without `workflows` permission)
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:49.8654944Z error: failed to push some refs to 'https://github.com/KSPOG/klite'
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:49.8677239Z ##[error]Process completed with exit code 1.
```

## Apply client version, AutoLogin, and Discord updates: Persist generated changes before verification

- Run: [29685469542](https://github.com/KSPOG/klite/actions/runs/29685469542)
- Conclusion: `failure`
- Event: `push`
- Commit: `cc4ae973e9717c6eaea0ced3038d38c9436f1a47`
- Created: `2026-07-19T11:37:30Z`

### Failed jobs and steps

- **apply-and-verify** — `failure`
  - Step 5: **Commit generated feature changes** — `failure`

### Relevant log context

```text
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:51.7481170Z ^[[36;1mgit config user.name "github-actions[bot]"^[[0m
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:51.7481668Z ^[[36;1mgit config user.email "41898282+github-actions[bot]@users.noreply.github.com"^[[0m
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:51.7482114Z ^[[36;1mgit add -A^[[0m
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:51.7482452Z ^[[36;1mgit commit -m "Add client AutoLogin and Discord update notifications"^[[0m
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:51.7482971Z ^[[36;1mgit push origin HEAD:feature/client-version-autologin-discord-updates^[[0m
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:51.7543233Z shell: /usr/bin/bash --noprofile --norc -e -o pipefail {0}
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:51.7543594Z env:
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:51.7543912Z   JAVA_HOME: /opt/hostedtoolcache/Java_Temurin-Hotspot_jdk/11.0.31-11/x64
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:51.7544426Z   JAVA_HOME_11_X64: /opt/hostedtoolcache/Java_Temurin-Hotspot_jdk/11.0.31-11/x64
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:51.7544808Z ##[endgroup]
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:51.9322251Z [feature/client-version-autologin-discord-updates 6473f5262] Add client AutoLogin and Discord update notifications
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:51.9323519Z  17 files changed, 758 insertions(+), 30 deletions(-)
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:51.9324255Z  create mode 100644 marketplace-site/migrations/0008_client_updates.sql
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:51.9325102Z  create mode 100644 marketplace-site/test/client-updates.test.js
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:51.9325575Z  create mode 100644 marketplace-site/worker/client-updates.js
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:51.9326213Z  create mode 100644 runelite-client/src/main/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginService.java
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:51.9327050Z  create mode 100644 runelite-client/src/test/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginServiceTest.java
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:51.9327912Z  create mode 100644 runelite-client/src/test/java/net/runelite/client/plugins/klite/marketplace/KLitePluginPanelVersionTest.java
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:52.7135434Z To https://github.com/KSPOG/klite
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:52.7136577Z  ! [remote rejected]     HEAD -> feature/client-version-autologin-discord-updates (refusing to allow a GitHub App to create or update workflow `.github/workflows/build-windows-client.yml` without `workflows` permission)
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:52.7137982Z error: failed to push some refs to 'https://github.com/KSPOG/klite'
apply-and-verify	Commit generated feature changes	2026-07-19T11:37:52.7153332Z ##[error]Process completed with exit code 1.
```

## Apply client version, AutoLogin, and Discord updates: Add client AutoLogin and Discord update notifications

- Run: [29685423370](https://github.com/KSPOG/klite/actions/runs/29685423370)
- Conclusion: `failure`
- Event: `pull_request`
- Commit: `4bdf0a61264c8e09cad253f034b94bc4b321d1df`
- Created: `2026-07-19T11:35:58Z`

### Failed jobs and steps

- **apply-and-verify** — `failure`
  - Step 6: **Run marketplace tests** — `failure`

### Relevant log context

```text
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7210477Z ok 6 - API browser exposes working expand, collapse, and reset controls
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7211705Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7213188Z   duration_ms: 1.595695
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7213859Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7214475Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7215218Z # Subtest: API page links the downloadable public API source bundle
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7216335Z ok 7 - API page links the downloadable public API source bundle
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7217237Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7292715Z   duration_ms: 0.342561
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7321732Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7334674Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7359142Z # Subtest: Cloudflare serves API page files before dynamic API routes
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7401948Z ok 8 - Cloudflare serves API page files before dynamic API routes
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7403261Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7434186Z   duration_ms: 0.430035
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7465979Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7481504Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7502109Z # file:///home/runner/work/klite/klite/marketplace-site/test/api-source-bundle.test.js:1
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7517134Z # const fs = require("node:fs");
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7532567Z #            ^
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7533555Z # ReferenceError: require is not defined in ES module scope, you can use import instead
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7535838Z # This file is being treated as an ES module because it has a '.js' file extension and '/home/runner/work/klite/klite/marketplace-site/package.json' contains "type": "module". To treat it as a CommonJS script, rename it to use the '.cjs' file extension.
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7538654Z #     at file:///home/runner/work/klite/klite/marketplace-site/test/api-source-bundle.test.js:1:12
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7539807Z #     at ModuleJob.run (node:internal/modules/esm/module_job:343:25)
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7540855Z #     at async onImport.tracePromise.__proto__ (node:internal/modules/esm/loader:681:26)
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7544667Z #     at async asyncRunEntryPointWithESMLoader (node:internal/modules/run_main:117:5)
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7545624Z # Node.js v22.23.1
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7546190Z # Subtest: test/api-source-bundle.test.js
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7546877Z not ok 3 - test/api-source-bundle.test.js
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7547464Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7547937Z   duration_ms: 47.05357
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7548477Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7549326Z   location: '/home/runner/work/klite/klite/marketplace-site/test/api-source-bundle.test.js:1:1'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7550382Z   failureType: 'testCodeFailure'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7551346Z   exitCode: 1
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7551959Z   signal: ~
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7552442Z   error: 'test failed'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7552971Z   code: 'ERR_TEST_FAILURE'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7553491Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7554061Z # Subtest: publishes only client-valid marketplace tags
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7555277Z ok 10 - publishes only client-valid marketplace tags
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7556052Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7556538Z   duration_ms: 5.819738
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7557054Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7557512Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7692120Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7692561Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7841629Z # Subtest: normalizes Discord bot role and channel settings
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7843309Z ok 18 - normalizes Discord bot role and channel settings
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7844158Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7844762Z   duration_ms: 2.102583
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7845426Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7846010Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7846866Z # Subtest: shows the dashboard only when the linked member currently has Dev
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7849737Z ok 19 - shows the dashboard only when the linked member currently has Dev
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7855971Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7856674Z   duration_ms: 50.950231
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7857414Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.7857941Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.8658430Z # Subtest: public pages serve the generated design system and scoped credit styles
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.8698016Z not ok 20 - public pages serve the generated design system and scoped credit styles
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.8699027Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.8699528Z   duration_ms: 61.550662
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.8700182Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.8701372Z   location: '/home/runner/work/klite/klite/marketplace-site/test/home-styles.test.js:13:1'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.8702398Z   failureType: 'testCodeFailure'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.8703024Z   error: |-
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.8703557Z     Expected values to be strictly equal:
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.8704569Z
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.8705078Z     2 !== 1
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.8705599Z
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.8706126Z   code: 'ERR_ASSERTION'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.8706703Z   name: 'AssertionError'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.8707296Z   expected: 1
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.8707840Z   actual: 2
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.8708391Z   operator: 'strictEqual'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.8708960Z   stack: |-
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.8710231Z     TestContext.<anonymous> (file:///home/runner/work/klite/klite/marketplace-site/test/home-styles.test.js:39:12)
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.8711826Z     async Test.run (node:internal/test_runner/test:1054:7)
apply-and-verify	Run marketplace tests	2026-07-19T11:36:14.8712847Z     async startSubtestAfterBootstrap (node:internal/test_runner/harness:296:3)
apply-and-verify	Run marketplace tests	2026-07-19T11:36:15.3989320Z ok 33 - streams free plugin artifacts from private object storage
apply-and-verify	Run marketplace tests	2026-07-19T11:36:15.3989963Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:36:15.3990333Z   duration_ms: 3.488967
apply-and-verify	Run marketplace tests	2026-07-19T11:36:15.3990757Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:15.3991298Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:36:15.3991866Z # Subtest: requires a client login before serving paid plugin artifacts
apply-and-verify	Run marketplace tests	2026-07-19T11:36:15.3992717Z ok 34 - requires a client login before serving paid plugin artifacts
apply-and-verify	Run marketplace tests	2026-07-19T11:36:15.3993325Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:36:15.3993688Z   duration_ms: 0.854298
apply-and-verify	Run marketplace tests	2026-07-19T11:36:15.4005941Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:15.4006289Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:36:15.4106013Z 1..34
apply-and-verify	Run marketplace tests	2026-07-19T11:36:15.4106434Z # tests 34
apply-and-verify	Run marketplace tests	2026-07-19T11:36:15.4106728Z # suites 0
apply-and-verify	Run marketplace tests	2026-07-19T11:36:15.4107057Z # pass 32
apply-and-verify	Run marketplace tests	2026-07-19T11:36:15.4107679Z # fail 2
apply-and-verify	Run marketplace tests	2026-07-19T11:36:15.4108349Z # cancelled 0
apply-and-verify	Run marketplace tests	2026-07-19T11:36:15.4109046Z # skipped 0
apply-and-verify	Run marketplace tests	2026-07-19T11:36:15.4109697Z # todo 0
apply-and-verify	Run marketplace tests	2026-07-19T11:36:15.4110389Z # duration_ms 872.514676
apply-and-verify	Run marketplace tests	2026-07-19T11:36:15.4362077Z ##[error]Process completed with exit code 1.
```

## Apply client version, AutoLogin, and Discord updates: Run feature patch workflow for same-repository PRs

- Run: [29685418101](https://github.com/KSPOG/klite/actions/runs/29685418101)
- Conclusion: `failure`
- Event: `push`
- Commit: `4bdf0a61264c8e09cad253f034b94bc4b321d1df`
- Created: `2026-07-19T11:35:46Z`

### Failed jobs and steps

- **apply-and-verify** — `failure`
  - Step 6: **Run marketplace tests** — `failure`

### Relevant log context

```text
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.8999303Z ok 6 - API browser exposes working expand, collapse, and reset controls
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9029022Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9059142Z   duration_ms: 1.671036
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9072829Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9098899Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9099486Z # Subtest: API page links the downloadable public API source bundle
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9100314Z ok 7 - API page links the downloadable public API source bundle
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9100974Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9129129Z   duration_ms: 0.218729
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9129604Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9129961Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9130571Z # Subtest: Cloudflare serves API page files before dynamic API routes
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9131460Z ok 8 - Cloudflare serves API page files before dynamic API routes
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9132096Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9132429Z   duration_ms: 0.316492
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9132819Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9133156Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9133780Z # file:///home/runner/work/klite/klite/marketplace-site/test/api-source-bundle.test.js:1
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9134601Z # const fs = require("node:fs");
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9135030Z #            ^
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9135658Z # ReferenceError: require is not defined in ES module scope, you can use import instead
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9137686Z # This file is being treated as an ES module because it has a '.js' file extension and '/home/runner/work/klite/klite/marketplace-site/package.json' contains "type": "module". To treat it as a CommonJS script, rename it to use the '.cjs' file extension.
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9140653Z #     at file:///home/runner/work/klite/klite/marketplace-site/test/api-source-bundle.test.js:1:12
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9141718Z #     at ModuleJob.run (node:internal/modules/esm/module_job:343:25)
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9142633Z #     at async onImport.tracePromise.__proto__ (node:internal/modules/esm/loader:681:26)
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9143688Z #     at async asyncRunEntryPointWithESMLoader (node:internal/modules/run_main:117:5)
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9144458Z # Node.js v22.23.1
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9144867Z # Subtest: test/api-source-bundle.test.js
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9145419Z not ok 3 - test/api-source-bundle.test.js
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9145922Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9146260Z   duration_ms: 46.984492
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9146657Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9147375Z   location: '/home/runner/work/klite/klite/marketplace-site/test/api-source-bundle.test.js:1:1'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9148251Z   failureType: 'testCodeFailure'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9149020Z   exitCode: 1
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9149430Z   signal: ~
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9149762Z   error: 'test failed'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9150152Z   code: 'ERR_TEST_FAILURE'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9150884Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9151317Z # Subtest: publishes only client-valid marketplace tags
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9151996Z ok 10 - publishes only client-valid marketplace tags
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9152551Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9152875Z   duration_ms: 4.902359
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9153257Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9153593Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9204120Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9204451Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9229096Z # Subtest: normalizes Discord bot role and channel settings
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9259047Z ok 18 - normalizes Discord bot role and channel settings
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9277715Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9318930Z   duration_ms: 1.595103
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9366796Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9367155Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9367649Z # Subtest: shows the dashboard only when the linked member currently has Dev
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9368723Z ok 19 - shows the dashboard only when the linked member currently has Dev
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9408695Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9409497Z   duration_ms: 54.885024
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9410061Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:04.9410543Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.0019626Z # Subtest: public pages serve the generated design system and scoped credit styles
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.0021081Z not ok 20 - public pages serve the generated design system and scoped credit styles
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.0022008Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.0022500Z   duration_ms: 58.066931
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.0023039Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.0023886Z   location: '/home/runner/work/klite/klite/marketplace-site/test/home-styles.test.js:13:1'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.0024849Z   failureType: 'testCodeFailure'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.0025813Z   error: |-
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.0026352Z     Expected values to be strictly equal:
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.0027080Z
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.0027527Z     2 !== 1
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.0027975Z
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.0028768Z   code: 'ERR_ASSERTION'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.0029357Z   name: 'AssertionError'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.0029886Z   expected: 1
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.0030366Z   actual: 2
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.0030848Z   operator: 'strictEqual'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.0031381Z   stack: |-
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.0032483Z     TestContext.<anonymous> (file:///home/runner/work/klite/klite/marketplace-site/test/home-styles.test.js:39:12)
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.0033886Z     async Test.run (node:internal/test_runner/test:1054:7)
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.0034950Z     async startSubtestAfterBootstrap (node:internal/test_runner/harness:296:3)
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.5392999Z ok 33 - streams free plugin artifacts from private object storage
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.5393809Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.5394342Z   duration_ms: 3.345307
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.5394919Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.5395447Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.5396189Z # Subtest: requires a client login before serving paid plugin artifacts
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.5397232Z ok 34 - requires a client login before serving paid plugin artifacts
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.5398026Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.5398785Z   duration_ms: 0.861581
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.5399363Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.5399878Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.5480194Z 1..34
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.5480813Z # tests 34
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.5489458Z # suites 0
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.5489785Z # pass 32
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.5490072Z # fail 2
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.5490365Z # cancelled 0
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.5490681Z # skipped 0
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.5490995Z # todo 0
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.5491291Z # duration_ms 876.825551
apply-and-verify	Run marketplace tests	2026-07-19T11:36:05.5700207Z ##[error]Process completed with exit code 1.
```

## Apply client version, AutoLogin, and Discord updates: Add feature application and verification workflow

- Run: [29685371866](https://github.com/KSPOG/klite/actions/runs/29685371866)
- Conclusion: `failure`
- Event: `push`
- Commit: `3d2dff000d38b71a183eb603c02b73bf469a4ed5`
- Created: `2026-07-19T11:34:15Z`

### Failed jobs and steps

- **apply-and-verify** — `failure`
  - Step 6: **Run marketplace tests** — `failure`

### Relevant log context

```text
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4270389Z ok 6 - API browser exposes working expand, collapse, and reset controls
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4271033Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4271505Z   duration_ms: 1.877557
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4271977Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4272480Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4273026Z # Subtest: API page links the downloadable public API source bundle
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4273733Z ok 7 - API page links the downloadable public API source bundle
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4274377Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4274813Z   duration_ms: 0.22002
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4275400Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4275834Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4276380Z # Subtest: Cloudflare serves API page files before dynamic API routes
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4277191Z ok 8 - Cloudflare serves API page files before dynamic API routes
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4277794Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4278317Z   duration_ms: 0.300006
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4278790Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4279347Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4320143Z # file:///home/runner/work/klite/klite/marketplace-site/test/api-source-bundle.test.js:1
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4329801Z # const fs = require("node:fs");
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4330496Z #            ^
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4331199Z # ReferenceError: require is not defined in ES module scope, you can use import instead
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4332982Z # This file is being treated as an ES module because it has a '.js' file extension and '/home/runner/work/klite/klite/marketplace-site/package.json' contains "type": "module". To treat it as a CommonJS script, rename it to use the '.cjs' file extension.
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4335324Z #     at file:///home/runner/work/klite/klite/marketplace-site/test/api-source-bundle.test.js:1:12
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4338381Z #     at ModuleJob.run (node:internal/modules/esm/module_job:343:25)
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4339661Z #     at async onImport.tracePromise.__proto__ (node:internal/modules/esm/loader:681:26)
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4342740Z #     at async asyncRunEntryPointWithESMLoader (node:internal/modules/run_main:117:5)
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4343961Z # Node.js v22.23.1
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4344667Z # Subtest: test/api-source-bundle.test.js
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4345301Z not ok 3 - test/api-source-bundle.test.js
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4345919Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4346362Z   duration_ms: 40.365716
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4346849Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4347671Z   location: '/home/runner/work/klite/klite/marketplace-site/test/api-source-bundle.test.js:1:1'
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4348534Z   failureType: 'testCodeFailure'
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4349354Z   exitCode: 1
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4349833Z   signal: ~
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4350239Z   error: 'test failed'
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4351243Z   code: 'ERR_TEST_FAILURE'
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4351966Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4381271Z # Subtest: publishes only client-valid marketplace tags
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4400038Z ok 10 - publishes only client-valid marketplace tags
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4419654Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4449647Z   duration_ms: 4.821119
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4459758Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4482230Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4958749Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.4958992Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5361261Z # Subtest: normalizes Discord bot role and channel settings
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5362364Z ok 18 - normalizes Discord bot role and channel settings
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5362996Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5363365Z   duration_ms: 1.871607
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5363764Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5364208Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5364768Z # Subtest: shows the dashboard only when the linked member currently has Dev
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5365554Z ok 19 - shows the dashboard only when the linked member currently has Dev
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5366134Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5366472Z   duration_ms: 31.343925
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5366953Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5367314Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5720528Z # Subtest: public pages serve the generated design system and scoped credit styles
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5745593Z not ok 20 - public pages serve the generated design system and scoped credit styles
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5769869Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5799887Z   duration_ms: 48.604466
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5800438Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5801273Z   location: '/home/runner/work/klite/klite/marketplace-site/test/home-styles.test.js:13:1'
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5802026Z   failureType: 'testCodeFailure'
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5802838Z   error: |-
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5803310Z     Expected values to be strictly equal:
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5803770Z
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5804156Z     2 !== 1
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5804558Z
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5804931Z   code: 'ERR_ASSERTION'
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5805412Z   name: 'AssertionError'
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5805811Z   expected: 1
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5806178Z   actual: 2
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5806548Z   operator: 'strictEqual'
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5806951Z   stack: |-
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5807587Z     TestContext.<anonymous> (file:///home/runner/work/klite/klite/marketplace-site/test/home-styles.test.js:39:12)
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5808389Z     async Test.run (node:internal/test_runner/test:1054:7)
apply-and-verify	Run marketplace tests	2026-07-19T11:34:34.5809254Z     async startSubtestAfterBootstrap (node:internal/test_runner/harness:296:3)
apply-and-verify	Run marketplace tests	2026-07-19T11:34:35.0739463Z ok 33 - streams free plugin artifacts from private object storage
apply-and-verify	Run marketplace tests	2026-07-19T11:34:35.0740103Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:34:35.0740462Z   duration_ms: 2.813096
apply-and-verify	Run marketplace tests	2026-07-19T11:34:35.0740743Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:34:35.0740970Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:34:35.0741274Z # Subtest: requires a client login before serving paid plugin artifacts
apply-and-verify	Run marketplace tests	2026-07-19T11:34:35.0741649Z ok 34 - requires a client login before serving paid plugin artifacts
apply-and-verify	Run marketplace tests	2026-07-19T11:34:35.0741929Z   ---
apply-and-verify	Run marketplace tests	2026-07-19T11:34:35.0742135Z   duration_ms: 0.782713
apply-and-verify	Run marketplace tests	2026-07-19T11:34:35.0742388Z   type: 'test'
apply-and-verify	Run marketplace tests	2026-07-19T11:34:35.0742643Z   ...
apply-and-verify	Run marketplace tests	2026-07-19T11:34:35.0787540Z 1..34
apply-and-verify	Run marketplace tests	2026-07-19T11:34:35.0787876Z # tests 34
apply-and-verify	Run marketplace tests	2026-07-19T11:34:35.0788301Z # suites 0
apply-and-verify	Run marketplace tests	2026-07-19T11:34:35.0789172Z # pass 32
apply-and-verify	Run marketplace tests	2026-07-19T11:34:35.0789595Z # fail 2
apply-and-verify	Run marketplace tests	2026-07-19T11:34:35.0820555Z # cancelled 0
apply-and-verify	Run marketplace tests	2026-07-19T11:34:35.0833004Z # skipped 0
apply-and-verify	Run marketplace tests	2026-07-19T11:34:35.0833313Z # todo 0
apply-and-verify	Run marketplace tests	2026-07-19T11:34:35.0833569Z # duration_ms 756.024348
apply-and-verify	Run marketplace tests	2026-07-19T11:34:35.0949980Z ##[error]Process completed with exit code 1.
```

