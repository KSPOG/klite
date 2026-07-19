# Recent GitHub Actions failures

Generated: 2026-07-19T11:50:11.930399+00:00
Repository: `KSPOG/klite`
Failed runs inspected: **15**

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29685850632](https://github.com/KSPOG/klite/actions/runs/29685850632)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `411f7dc934109808d3cd01793391d032c268d889`
- Created: `2026-07-19T11:49:52Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 1: **Set up job** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## CI: Add client AutoLogin and Discord update notifications

- Run: [29685821123](https://github.com/KSPOG/klite/actions/runs/29685821123)
- Conclusion: `failure`
- Event: `pull_request`
- Commit: `b0da12baea03ebc10c51e277fb9a2661939571c2`
- Created: `2026-07-19T11:48:52Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-19T11:49:27.4254646Z > Task :runelite-api:build
build	Build and Test	2026-07-19T11:49:36.3174456Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/PrivateMessageInput.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:49:36.3176684Z
build	Build and Test	2026-07-19T11:49:36.3190790Z > Task :client:compileJava
build	Build and Test	2026-07-19T11:49:36.3194120Z @Value
build	Build and Test	2026-07-19T11:49:36.3194486Z ^
build	Build and Test	2026-07-19T11:49:36.3196567Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/ChatboxInput.java:32: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:49:36.3198666Z @Value
build	Build and Test	2026-07-19T11:49:36.3198994Z ^
build	Build and Test	2026-07-19T11:49:36.3206486Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/party/messages/PartyChatMessage.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:49:36.3234612Z @Value
build	Build and Test	2026-07-19T11:49:36.3237327Z ^
build	Build and Test	2026-07-19T11:49:36.3239733Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/devtools/ScriptInspector.java:100: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:49:36.3242002Z 	@Data
build	Build and Test	2026-07-19T11:49:36.3242528Z 	^
build	Build and Test	2026-07-19T11:49:43.0156768Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/agility/Courses.java:88: warning: non-varargs call of varargs method with inexact argument type for last parameter;
build	Build and Test	2026-07-19T11:49:43.0164611Z 		this(totalXp, -1, null);
build	Build and Test	2026-07-19T11:49:43.0165208Z 		                  ^
build	Build and Test	2026-07-19T11:49:43.0165693Z   cast to WorldPoint for a varargs call
build	Build and Test	2026-07-19T11:49:43.0166462Z   cast to WorldPoint[] for a non-varargs call and to suppress this warning
build	Build and Test	2026-07-19T11:49:46.2148583Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginService.java:154: error: cannot find symbol
build	Build and Test	2026-07-19T11:49:46.2184254Z 			client.getUsername(), client.getPassword());
build	Build and Test	2026-07-19T11:49:46.2208011Z 			                            ^
build	Build and Test	2026-07-19T11:49:46.2254559Z   symbol:   method getPassword()
build	Build and Test	2026-07-19T11:49:46.2284487Z   location: variable client of type Client
build	Build and Test	2026-07-19T11:49:47.1177452Z Note: Some input files use or override a deprecated API.
build	Build and Test	2026-07-19T11:49:47.1184512Z Note: Recompile with -Xlint:deprecation for details.
build	Build and Test	2026-07-19T11:49:47.1208596Z Note: Some input files use unchecked or unsafe operations.
build	Build and Test	2026-07-19T11:49:47.1234488Z Note: Recompile with -Xlint:unchecked for details.
build	Build and Test	2026-07-19T11:49:47.1264188Z 1 error
build	Build and Test	2026-07-19T11:49:47.1294292Z 5 warnings
build	Build and Test	2026-07-19T11:49:47.4174207Z
build	Build and Test	2026-07-19T11:49:47.4204868Z > Task :client:compileJava FAILED
build	Build and Test	2026-07-19T11:49:47.5156432Z
build	Build and Test	2026-07-19T11:49:47.5157802Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784461754259.json
build	Build and Test	2026-07-19T11:49:47.5159468Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-19T11:49:47.5160291Z
build	Build and Test	2026-07-19T11:49:47.5160625Z * What went wrong:
build	Build and Test	2026-07-19T11:49:47.5161266Z Execution failed for task ':client:compileJava'.
build	Build and Test	2026-07-19T11:49:47.5162678Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-19T11:49:47.5163305Z
build	Build and Test	2026-07-19T11:49:47.5163605Z * Try:
build	Build and Test	2026-07-19T11:49:47.5164557Z > Run with --info option to get more log output.
build	Build and Test	2026-07-19T11:49:47.5165272Z > Run with --scan to get full insights.
build	Build and Test	2026-07-19T11:49:47.5165761Z
build	Build and Test	2026-07-19T11:49:47.5166070Z BUILD FAILED in 41s
build	Build and Test	2026-07-19T11:49:47.5174273Z 55 actionable tasks: 23 executed, 32 from cache
build	Build and Test	2026-07-19T11:49:47.9454714Z ##[error]Process completed with exit code 1.
```

## CI: Align API bundle test with current parity implementation

- Run: [29685819432](https://github.com/KSPOG/klite/actions/runs/29685819432)
- Conclusion: `failure`
- Event: `push`
- Commit: `b0da12baea03ebc10c51e277fb9a2661939571c2`
- Created: `2026-07-19T11:48:48Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-19T11:49:28.4266680Z > Task :runelite-api:build
build	Build and Test	2026-07-19T11:49:37.1293455Z
build	Build and Test	2026-07-19T11:49:37.1323125Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/ChatboxInput.java:32: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:49:37.1325514Z > Task :client:compileJava
build	Build and Test	2026-07-19T11:49:37.1370873Z @Value
build	Build and Test	2026-07-19T11:49:37.1400592Z ^
build	Build and Test	2026-07-19T11:49:37.1432814Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/party/messages/PartyChatMessage.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:49:37.1460669Z @Value
build	Build and Test	2026-07-19T11:49:37.1490583Z ^
build	Build and Test	2026-07-19T11:49:37.1522643Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/PrivateMessageInput.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:49:37.1550691Z @Value
build	Build and Test	2026-07-19T11:49:37.1580960Z ^
build	Build and Test	2026-07-19T11:49:37.1612680Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/devtools/ScriptInspector.java:100: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:49:37.1640670Z 	@Data
build	Build and Test	2026-07-19T11:49:37.1670668Z 	^
build	Build and Test	2026-07-19T11:49:44.1264821Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/agility/Courses.java:88: warning: non-varargs call of varargs method with inexact argument type for last parameter;
build	Build and Test	2026-07-19T11:49:44.1290930Z 		this(totalXp, -1, null);
build	Build and Test	2026-07-19T11:49:44.1320685Z 		                  ^
build	Build and Test	2026-07-19T11:49:44.1321487Z   cast to WorldPoint for a varargs call
build	Build and Test	2026-07-19T11:49:44.1351117Z   cast to WorldPoint[] for a non-varargs call and to suppress this warning
build	Build and Test	2026-07-19T11:49:48.3284741Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginService.java:154: error: cannot find symbol
build	Build and Test	2026-07-19T11:49:48.3324300Z 			client.getUsername(), client.getPassword());
build	Build and Test	2026-07-19T11:49:48.3350764Z 			                            ^
build	Build and Test	2026-07-19T11:49:48.3380757Z   symbol:   method getPassword()
build	Build and Test	2026-07-19T11:49:48.3412566Z   location: variable client of type Client
build	Build and Test	2026-07-19T11:49:49.3331391Z Note: Some input files use or override a deprecated API.
build	Build and Test	2026-07-19T11:49:49.3372106Z Note: Recompile with -Xlint:deprecation for details.
build	Build and Test	2026-07-19T11:49:49.3401273Z Note: Some input files use unchecked or unsafe operations.
build	Build and Test	2026-07-19T11:49:49.3402336Z Note: Recompile with -Xlint:unchecked for details.
build	Build and Test	2026-07-19T11:49:49.3410892Z 1 error
build	Build and Test	2026-07-19T11:49:49.3411580Z 5 warnings
build	Build and Test	2026-07-19T11:49:49.6262610Z
build	Build and Test	2026-07-19T11:49:49.6269001Z
build	Build and Test	2026-07-19T11:49:49.6269650Z > Task :client:compileJava FAILED
build	Build and Test	2026-07-19T11:49:49.6270926Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-19T11:49:49.6280918Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784461754744.json
build	Build and Test	2026-07-19T11:49:49.6281810Z
build	Build and Test	2026-07-19T11:49:49.6282017Z * What went wrong:
build	Build and Test	2026-07-19T11:49:49.6282545Z Execution failed for task ':client:compileJava'.
build	Build and Test	2026-07-19T11:49:49.6284188Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-19T11:49:49.6284739Z
build	Build and Test	2026-07-19T11:49:49.6284917Z * Try:
build	Build and Test	2026-07-19T11:49:49.6285405Z > Run with --info option to get more log output.
build	Build and Test	2026-07-19T11:49:49.6286065Z > Run with --scan to get full insights.
build	Build and Test	2026-07-19T11:49:49.6286463Z
build	Build and Test	2026-07-19T11:49:49.6286649Z BUILD FAILED in 44s
build	Build and Test	2026-07-19T11:49:49.6287170Z 55 actionable tasks: 23 executed, 32 from cache
build	Build and Test	2026-07-19T11:49:50.0681163Z ##[error]Process completed with exit code 1.
```

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29685815395](https://github.com/KSPOG/klite/actions/runs/29685815395)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `2a8586bbf01df833d63ecfb7d80bb6a497058b08`
- Created: `2026-07-19T11:48:40Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 3: **Collect recent failure details** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## CI: Add client AutoLogin and Discord update notifications

- Run: [29685785865](https://github.com/KSPOG/klite/actions/runs/29685785865)
- Conclusion: `failure`
- Event: `pull_request`
- Commit: `2f8ffaf38cf66eea1a9ede1d39fcde38923c77c7`
- Created: `2026-07-19T11:47:40Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-19T11:48:15.7104604Z > Task :runelite-api:build
build	Build and Test	2026-07-19T11:48:24.4054808Z
build	Build and Test	2026-07-19T11:48:24.4069532Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/ChatboxInput.java:32: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:48:24.4071912Z > Task :client:compileJava
build	Build and Test	2026-07-19T11:48:24.4094221Z @Value
build	Build and Test	2026-07-19T11:48:24.4125904Z ^
build	Build and Test	2026-07-19T11:48:24.4148071Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/party/messages/PartyChatMessage.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:48:24.4150581Z @Value
build	Build and Test	2026-07-19T11:48:24.4151013Z ^
build	Build and Test	2026-07-19T11:48:24.4153270Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/PrivateMessageInput.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:48:24.4156027Z @Value
build	Build and Test	2026-07-19T11:48:24.4156665Z ^
build	Build and Test	2026-07-19T11:48:24.4158561Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/devtools/ScriptInspector.java:100: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:48:24.4188238Z 	@Data
build	Build and Test	2026-07-19T11:48:24.4188578Z 	^
build	Build and Test	2026-07-19T11:48:31.4048079Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/agility/Courses.java:88: warning: non-varargs call of varargs method with inexact argument type for last parameter;
build	Build and Test	2026-07-19T11:48:31.4091024Z 		this(totalXp, -1, null);
build	Build and Test	2026-07-19T11:48:31.4125103Z 		                  ^
build	Build and Test	2026-07-19T11:48:31.4150900Z   cast to WorldPoint for a varargs call
build	Build and Test	2026-07-19T11:48:31.4168643Z   cast to WorldPoint[] for a non-varargs call and to suppress this warning
build	Build and Test	2026-07-19T11:48:34.6080673Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginService.java:154: error: cannot find symbol
build	Build and Test	2026-07-19T11:48:34.6106544Z 			client.getUsername(), client.getPassword());
build	Build and Test	2026-07-19T11:48:34.6129418Z 			                            ^
build	Build and Test	2026-07-19T11:48:34.6156103Z   symbol:   method getPassword()
build	Build and Test	2026-07-19T11:48:34.6201762Z   location: variable client of type Client
build	Build and Test	2026-07-19T11:48:35.5068461Z Note: Some input files use or override a deprecated API.
build	Build and Test	2026-07-19T11:48:35.5096134Z Note: Recompile with -Xlint:deprecation for details.
build	Build and Test	2026-07-19T11:48:35.5097480Z Note: Some input files use unchecked or unsafe operations.
build	Build and Test	2026-07-19T11:48:35.5122222Z Note: Recompile with -Xlint:unchecked for details.
build	Build and Test	2026-07-19T11:48:35.5146164Z 1 error
build	Build and Test	2026-07-19T11:48:35.5176005Z 5 warnings
build	Build and Test	2026-07-19T11:48:35.9045158Z
build	Build and Test	2026-07-19T11:48:35.9046496Z > Task :client:compileJava FAILED
build	Build and Test	2026-07-19T11:48:35.9048153Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784461681529.json
build	Build and Test	2026-07-19T11:48:35.9049146Z
build	Build and Test	2026-07-19T11:48:35.9049681Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-19T11:48:35.9051028Z 55 actionable tasks: 23 executed, 32 from cache
build	Build and Test	2026-07-19T11:48:35.9051655Z
build	Build and Test	2026-07-19T11:48:35.9054036Z * What went wrong:
build	Build and Test	2026-07-19T11:48:35.9054830Z Execution failed for task ':client:compileJava'.
build	Build and Test	2026-07-19T11:48:35.9056055Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-19T11:48:35.9056836Z
build	Build and Test	2026-07-19T11:48:35.9057240Z * Try:
build	Build and Test	2026-07-19T11:48:35.9057936Z > Run with --info option to get more log output.
build	Build and Test	2026-07-19T11:48:35.9058767Z > Run with --scan to get full insights.
build	Build and Test	2026-07-19T11:48:35.9059358Z
build	Build and Test	2026-07-19T11:48:35.9059757Z BUILD FAILED in 42s
build	Build and Test	2026-07-19T11:48:36.3588950Z ##[error]Process completed with exit code 1.
```

## Apply client version, AutoLogin, and Discord updates: Add client AutoLogin and Discord update notifications

- Run: [29685785861](https://github.com/KSPOG/klite/actions/runs/29685785861)
- Conclusion: `failure`
- Event: `pull_request`
- Commit: `2f8ffaf38cf66eea1a9ede1d39fcde38923c77c7`
- Created: `2026-07-19T11:47:40Z`

### Failed jobs and steps

- **verify-feature** — `failure`
  - Step 7: **Report marketplace test failure** — `failure`

### Relevant log context

```text
verify-feature	Report marketplace test failure	﻿2026-07-19T11:48:05.2562676Z ##[group]Run {
verify-feature	Report marketplace test failure	2026-07-19T11:48:05.2562966Z ^[[36;1m{^[[0m
verify-feature	Report marketplace test failure	2026-07-19T11:48:05.2563232Z ^[[36;1m  echo '### Marketplace test failure summary'^[[0m
verify-feature	Report marketplace test failure	2026-07-19T11:48:05.2563582Z ^[[36;1m  echo '```text'^[[0m
verify-feature	Report marketplace test failure	2026-07-19T11:48:05.2564103Z ^[[36;1m  grep -E -A 14 -B 3 'not ok|AssertionError|ReferenceError|SyntaxError|ERR_' marketplace-test.log | tail -n 180^[[0m
verify-feature	Report marketplace test failure	2026-07-19T11:48:05.2564657Z ^[[36;1m  echo '```'^[[0m
verify-feature	Report marketplace test failure	2026-07-19T11:48:05.2564922Z ^[[36;1m} > marketplace-test-comment.md^[[0m
verify-feature	Report marketplace test failure	2026-07-19T11:48:05.2565330Z ^[[36;1mgh pr comment 57 --body-file marketplace-test-comment.md^[[0m
verify-feature	Report marketplace test failure	2026-07-19T11:48:05.2565689Z ^[[36;1mexit 1^[[0m
verify-feature	Report marketplace test failure	2026-07-19T11:48:05.2629180Z shell: /usr/bin/bash --noprofile --norc -e -o pipefail {0}
verify-feature	Report marketplace test failure	2026-07-19T11:48:05.2629551Z env:
verify-feature	Report marketplace test failure	2026-07-19T11:48:05.2629878Z   JAVA_HOME: /opt/hostedtoolcache/Java_Temurin-Hotspot_jdk/11.0.31-11/x64
verify-feature	Report marketplace test failure	2026-07-19T11:48:05.2630392Z   JAVA_HOME_11_X64: /opt/hostedtoolcache/Java_Temurin-Hotspot_jdk/11.0.31-11/x64
verify-feature	Report marketplace test failure	2026-07-19T11:48:05.2632987Z   GH_TOKEN: ***
verify-feature	Report marketplace test failure	2026-07-19T11:48:05.2633267Z ##[endgroup]
verify-feature	Report marketplace test failure	2026-07-19T11:48:08.3545149Z https://github.com/KSPOG/klite/pull/57#issuecomment-5015592290
verify-feature	Report marketplace test failure	2026-07-19T11:48:08.3571548Z ##[error]Process completed with exit code 1.
```

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29685784680](https://github.com/KSPOG/klite/actions/runs/29685784680)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `2d73f477cb56653cee48afb066290a3a9ea9e7c3`
- Created: `2026-07-19T11:47:38Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 2: **Check out repository** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## CI: Correct marketplace test outcome condition

- Run: [29685784605](https://github.com/KSPOG/klite/actions/runs/29685784605)
- Conclusion: `failure`
- Event: `push`
- Commit: `2f8ffaf38cf66eea1a9ede1d39fcde38923c77c7`
- Created: `2026-07-19T11:47:37Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-19T11:48:25.0170221Z > Task :runelite-api:build
build	Build and Test	2026-07-19T11:48:35.3176041Z
build	Build and Test	2026-07-19T11:48:35.3190310Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/PrivateMessageInput.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:48:35.3193067Z @Value
build	Build and Test	2026-07-19T11:48:35.3193667Z > Task :client:compileJava
build	Build and Test	2026-07-19T11:48:35.3194291Z ^
build	Build and Test	2026-07-19T11:48:35.3196652Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/ChatboxInput.java:32: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:48:35.3198185Z @Value
build	Build and Test	2026-07-19T11:48:35.3198528Z ^
build	Build and Test	2026-07-19T11:48:35.3200524Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/party/messages/PartyChatMessage.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:48:35.3202486Z @Value
build	Build and Test	2026-07-19T11:48:35.3202729Z ^
build	Build and Test	2026-07-19T11:48:35.3204057Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/devtools/ScriptInspector.java:100: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:48:35.3205438Z 	@Data
build	Build and Test	2026-07-19T11:48:35.3205658Z 	^
build	Build and Test	2026-07-19T11:48:42.5191759Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/agility/Courses.java:88: warning: non-varargs call of varargs method with inexact argument type for last parameter;
build	Build and Test	2026-07-19T11:48:42.5230503Z 		this(totalXp, -1, null);
build	Build and Test	2026-07-19T11:48:42.5260287Z 		                  ^
build	Build and Test	2026-07-19T11:48:42.5290055Z   cast to WorldPoint for a varargs call
build	Build and Test	2026-07-19T11:48:42.5291080Z   cast to WorldPoint[] for a non-varargs call and to suppress this warning
build	Build and Test	2026-07-19T11:48:46.2193867Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginService.java:154: error: cannot find symbol
build	Build and Test	2026-07-19T11:48:46.2220621Z 			client.getUsername(), client.getPassword());
build	Build and Test	2026-07-19T11:48:46.2250213Z 			                            ^
build	Build and Test	2026-07-19T11:48:46.2280084Z   symbol:   method getPassword()
build	Build and Test	2026-07-19T11:48:46.2281009Z   location: variable client of type Client
build	Build and Test	2026-07-19T11:48:47.2166843Z Note: Some input files use or override a deprecated API.
build	Build and Test	2026-07-19T11:48:47.2190507Z Note: Recompile with -Xlint:deprecation for details.
build	Build and Test	2026-07-19T11:48:47.2200515Z Note: Some input files use unchecked or unsafe operations.
build	Build and Test	2026-07-19T11:48:47.2201511Z Note: Recompile with -Xlint:unchecked for details.
build	Build and Test	2026-07-19T11:48:47.2202426Z 1 error
build	Build and Test	2026-07-19T11:48:47.2202996Z 5 warnings
build	Build and Test	2026-07-19T11:48:47.6165766Z
build	Build and Test	2026-07-19T11:48:47.6166714Z > Task :client:compileJava FAILED
build	Build and Test	2026-07-19T11:48:47.6167257Z
build	Build and Test	2026-07-19T11:48:47.6168366Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784461691725.json
build	Build and Test	2026-07-19T11:48:47.6170792Z 55 actionable tasks: 23 executed, 32 from cache
build	Build and Test	2026-07-19T11:48:47.6173019Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-19T11:48:47.6173444Z
build	Build and Test	2026-07-19T11:48:47.6174128Z * What went wrong:
build	Build and Test	2026-07-19T11:48:47.6174680Z Execution failed for task ':client:compileJava'.
build	Build and Test	2026-07-19T11:48:47.6175495Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-19T11:48:47.6176037Z
build	Build and Test	2026-07-19T11:48:47.6176203Z * Try:
build	Build and Test	2026-07-19T11:48:47.6176666Z > Run with --info option to get more log output.
build	Build and Test	2026-07-19T11:48:47.6177316Z > Run with --scan to get full insights.
build	Build and Test	2026-07-19T11:48:47.6177710Z
build	Build and Test	2026-07-19T11:48:47.6177902Z BUILD FAILED in 46s
build	Build and Test	2026-07-19T11:48:48.0806779Z ##[error]Process completed with exit code 1.
```

## Apply client version, AutoLogin, and Discord updates: Add client AutoLogin and Discord update notifications

- Run: [29685754294](https://github.com/KSPOG/klite/actions/runs/29685754294)
- Conclusion: `failure`
- Event: `pull_request`
- Commit: `0a5f82d6933dae0cf014c04ca981f729028d55a5`
- Created: `2026-07-19T11:46:37Z`

### Failed jobs and steps

- **verify-feature** — `failure`
  - Step 7: **Report marketplace test failure** — `failure`

### Relevant log context

```text
verify-feature	Report marketplace test failure	﻿2026-07-19T11:47:07.6584059Z ##[group]Run {
verify-feature	Report marketplace test failure	2026-07-19T11:47:07.6584335Z ^[[36;1m{^[[0m
verify-feature	Report marketplace test failure	2026-07-19T11:47:07.6584590Z ^[[36;1m  echo '### Marketplace test failure summary'^[[0m
verify-feature	Report marketplace test failure	2026-07-19T11:47:07.6584912Z ^[[36;1m  echo '```text'^[[0m
verify-feature	Report marketplace test failure	2026-07-19T11:47:07.6585411Z ^[[36;1m  grep -E -A 14 -B 3 'not ok|AssertionError|ReferenceError|SyntaxError|ERR_' marketplace-test.log | tail -n 180^[[0m
verify-feature	Report marketplace test failure	2026-07-19T11:47:07.6585946Z ^[[36;1m  echo '```'^[[0m
verify-feature	Report marketplace test failure	2026-07-19T11:47:07.6586196Z ^[[36;1m} > marketplace-test-comment.md^[[0m
verify-feature	Report marketplace test failure	2026-07-19T11:47:07.6586572Z ^[[36;1mgh pr comment 57 --body-file marketplace-test-comment.md^[[0m
verify-feature	Report marketplace test failure	2026-07-19T11:47:07.6586924Z ^[[36;1mexit 1^[[0m
verify-feature	Report marketplace test failure	2026-07-19T11:47:07.6645045Z shell: /usr/bin/bash --noprofile --norc -e -o pipefail {0}
verify-feature	Report marketplace test failure	2026-07-19T11:47:07.6645391Z env:
verify-feature	Report marketplace test failure	2026-07-19T11:47:07.6645868Z   JAVA_HOME: /opt/hostedtoolcache/Java_Temurin-Hotspot_jdk/11.0.31-11/x64
verify-feature	Report marketplace test failure	2026-07-19T11:47:07.6646388Z   JAVA_HOME_11_X64: /opt/hostedtoolcache/Java_Temurin-Hotspot_jdk/11.0.31-11/x64
verify-feature	Report marketplace test failure	2026-07-19T11:47:07.6649622Z   GH_TOKEN: ***
verify-feature	Report marketplace test failure	2026-07-19T11:47:07.6649882Z ##[endgroup]
verify-feature	Report marketplace test failure	2026-07-19T11:47:08.6570042Z https://github.com/KSPOG/klite/pull/57#issuecomment-5015589278
verify-feature	Report marketplace test failure	2026-07-19T11:47:08.6607061Z ##[error]Process completed with exit code 1.
```

## CI: Add client AutoLogin and Discord update notifications

- Run: [29685754245](https://github.com/KSPOG/klite/actions/runs/29685754245)
- Conclusion: `failure`
- Event: `pull_request`
- Commit: `0a5f82d6933dae0cf014c04ca981f729028d55a5`
- Created: `2026-07-19T11:46:37Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-19T11:47:13.2404985Z > Task :runelite-api:build
build	Build and Test	2026-07-19T11:47:21.1384802Z
build	Build and Test	2026-07-19T11:47:21.1423468Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/PrivateMessageInput.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:47:21.1426098Z > Task :client:compileJava
build	Build and Test	2026-07-19T11:47:21.1450776Z @Value
build	Build and Test	2026-07-19T11:47:21.1475940Z ^
build	Build and Test	2026-07-19T11:47:21.1481499Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/ChatboxInput.java:32: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:47:21.1485304Z @Value
build	Build and Test	2026-07-19T11:47:21.1485942Z ^
build	Build and Test	2026-07-19T11:47:21.1488542Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/party/messages/PartyChatMessage.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:47:21.1491686Z @Value
build	Build and Test	2026-07-19T11:47:21.1492348Z ^
build	Build and Test	2026-07-19T11:47:21.1495001Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/devtools/ScriptInspector.java:100: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:47:21.1497814Z 	@Data
build	Build and Test	2026-07-19T11:47:21.1498468Z 	^
build	Build and Test	2026-07-19T11:47:28.2372972Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/agility/Courses.java:88: warning: non-varargs call of varargs method with inexact argument type for last parameter;
build	Build and Test	2026-07-19T11:47:28.2400909Z 		this(totalXp, -1, null);
build	Build and Test	2026-07-19T11:47:28.2430723Z 		                  ^
build	Build and Test	2026-07-19T11:47:28.2431530Z   cast to WorldPoint for a varargs call
build	Build and Test	2026-07-19T11:47:28.2457651Z   cast to WorldPoint[] for a non-varargs call and to suppress this warning
build	Build and Test	2026-07-19T11:47:31.9404703Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginService.java:154: error: cannot find symbol
build	Build and Test	2026-07-19T11:47:31.9430874Z 			client.getUsername(), client.getPassword());
build	Build and Test	2026-07-19T11:47:31.9432162Z 			                            ^
build	Build and Test	2026-07-19T11:47:31.9466243Z   symbol:   method getPassword()
build	Build and Test	2026-07-19T11:47:31.9490803Z   location: variable client of type Client
build	Build and Test	2026-07-19T11:47:32.8372297Z Note: Some input files use or override a deprecated API.
build	Build and Test	2026-07-19T11:47:32.8381291Z Note: Recompile with -Xlint:deprecation for details.
build	Build and Test	2026-07-19T11:47:32.8410955Z Note: Some input files use unchecked or unsafe operations.
build	Build and Test	2026-07-19T11:47:32.8450907Z Note: Recompile with -Xlint:unchecked for details.
build	Build and Test	2026-07-19T11:47:32.8470003Z 1 error
build	Build and Test	2026-07-19T11:47:32.8482866Z 5 warnings
build	Build and Test	2026-07-19T11:47:33.2383560Z
build	Build and Test	2026-07-19T11:47:33.2384431Z > Task :client:compileJava FAILED
build	Build and Test	2026-07-19T11:47:33.2385838Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784461620359.json
build	Build and Test	2026-07-19T11:47:33.3380774Z
build	Build and Test	2026-07-19T11:47:33.3381487Z 55 actionable tasks: 23 executed, 32 from cache
build	Build and Test	2026-07-19T11:47:33.3382397Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-19T11:47:33.3382819Z
build	Build and Test	2026-07-19T11:47:33.3384979Z * What went wrong:
build	Build and Test	2026-07-19T11:47:33.3386012Z Execution failed for task ':client:compileJava'.
build	Build and Test	2026-07-19T11:47:33.3387049Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-19T11:47:33.3387788Z
build	Build and Test	2026-07-19T11:47:33.3388145Z * Try:
build	Build and Test	2026-07-19T11:47:33.3388850Z > Run with --info option to get more log output.
build	Build and Test	2026-07-19T11:47:33.3389705Z > Run with --scan to get full insights.
build	Build and Test	2026-07-19T11:47:33.3390562Z
build	Build and Test	2026-07-19T11:47:33.3390952Z BUILD FAILED in 41s
build	Build and Test	2026-07-19T11:47:33.7208442Z ##[error]Process completed with exit code 1.
```

## CI: Upload marketplace test diagnostics

- Run: [29685752787](https://github.com/KSPOG/klite/actions/runs/29685752787)
- Conclusion: `failure`
- Event: `push`
- Commit: `0a5f82d6933dae0cf014c04ca981f729028d55a5`
- Created: `2026-07-19T11:46:34Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-19T11:47:15.7864493Z > Task :runelite-api:build
build	Build and Test	2026-07-19T11:47:25.7862273Z
build	Build and Test	2026-07-19T11:47:25.7889907Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/ChatboxInput.java:32: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:47:25.7892500Z > Task :client:compileJava
build	Build and Test	2026-07-19T11:47:25.7897966Z @Value
build	Build and Test	2026-07-19T11:47:25.7898654Z ^
build	Build and Test	2026-07-19T11:47:25.7901328Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/party/messages/PartyChatMessage.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:47:25.7904192Z @Value
build	Build and Test	2026-07-19T11:47:25.7904772Z ^
build	Build and Test	2026-07-19T11:47:25.7907553Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/PrivateMessageInput.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:47:25.7910356Z @Value
build	Build and Test	2026-07-19T11:47:25.7910990Z ^
build	Build and Test	2026-07-19T11:47:25.7913779Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/devtools/ScriptInspector.java:100: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:47:25.7916644Z 	@Data
build	Build and Test	2026-07-19T11:47:25.7917430Z 	^
build	Build and Test	2026-07-19T11:47:32.5879497Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/agility/Courses.java:88: warning: non-varargs call of varargs method with inexact argument type for last parameter;
build	Build and Test	2026-07-19T11:47:32.5926898Z 		this(totalXp, -1, null);
build	Build and Test	2026-07-19T11:47:32.5938186Z 		                  ^
build	Build and Test	2026-07-19T11:47:32.5938970Z   cast to WorldPoint for a varargs call
build	Build and Test	2026-07-19T11:47:32.5940076Z   cast to WorldPoint[] for a non-varargs call and to suppress this warning
build	Build and Test	2026-07-19T11:47:36.3920177Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginService.java:154: error: cannot find symbol
build	Build and Test	2026-07-19T11:47:36.3947946Z 			client.getUsername(), client.getPassword());
build	Build and Test	2026-07-19T11:47:36.3977691Z 			                            ^
build	Build and Test	2026-07-19T11:47:36.3978595Z   symbol:   method getPassword()
build	Build and Test	2026-07-19T11:47:36.4007931Z   location: variable client of type Client
build	Build and Test	2026-07-19T11:47:37.1865154Z Note: Some input files use or override a deprecated API.
build	Build and Test	2026-07-19T11:47:37.1868272Z Note: Recompile with -Xlint:deprecation for details.
build	Build and Test	2026-07-19T11:47:37.1869423Z Note: Some input files use unchecked or unsafe operations.
build	Build and Test	2026-07-19T11:47:37.1870386Z Note: Recompile with -Xlint:unchecked for details.
build	Build and Test	2026-07-19T11:47:37.1871217Z 1 error
build	Build and Test	2026-07-19T11:47:37.1871795Z 5 warnings
build	Build and Test	2026-07-19T11:47:37.4859825Z
build	Build and Test	2026-07-19T11:47:37.4878098Z > Task :client:compileJava FAILED
build	Build and Test	2026-07-19T11:47:37.5856463Z
build	Build and Test	2026-07-19T11:47:37.5858035Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784461623716.json
build	Build and Test	2026-07-19T11:47:37.5859446Z 55 actionable tasks: 23 executed, 32 from cache
build	Build and Test	2026-07-19T11:47:37.5880694Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-19T11:47:37.5897828Z
build	Build and Test	2026-07-19T11:47:37.5898957Z * What went wrong:
build	Build and Test	2026-07-19T11:47:37.5899724Z Execution failed for task ':client:compileJava'.
build	Build and Test	2026-07-19T11:47:37.5900640Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-19T11:47:37.5901370Z
build	Build and Test	2026-07-19T11:47:37.5901677Z * Try:
build	Build and Test	2026-07-19T11:47:37.5902265Z > Run with --info option to get more log output.
build	Build and Test	2026-07-19T11:47:37.5902998Z > Run with --scan to get full insights.
build	Build and Test	2026-07-19T11:47:37.5903484Z
build	Build and Test	2026-07-19T11:47:37.5903798Z BUILD FAILED in 41s
build	Build and Test	2026-07-19T11:47:38.0024404Z ##[error]Process completed with exit code 1.
```

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

