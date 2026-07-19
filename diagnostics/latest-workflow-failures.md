# Recent GitHub Actions failures

Generated: 2026-07-19T11:52:23.373554+00:00
Repository: `KSPOG/klite`
Failed runs inspected: **15**

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29685918635](https://github.com/KSPOG/klite/actions/runs/29685918635)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `704c4aa7d43a4529053494545bec16474f30951d`
- Created: `2026-07-19T11:52:01Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 2: **Check out repository** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## CI: Add client AutoLogin and Discord update notifications

- Run: [29685887973](https://github.com/KSPOG/klite/actions/runs/29685887973)
- Conclusion: `failure`
- Event: `pull_request`
- Commit: `f3c5cfd9b779db64f306d4824cea5db65c5ecd74`
- Created: `2026-07-19T11:51:02Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-19T11:51:40.5248788Z > Task :runelite-api:build
build	Build and Test	2026-07-19T11:51:49.5183851Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/party/messages/PartyChatMessage.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:51:49.5186745Z
build	Build and Test	2026-07-19T11:51:49.5216181Z @Value
build	Build and Test	2026-07-19T11:51:49.5216860Z > Task :client:compileJava
build	Build and Test	2026-07-19T11:51:49.5226025Z ^
build	Build and Test	2026-07-19T11:51:49.5248131Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/PrivateMessageInput.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:51:49.5265813Z @Value
build	Build and Test	2026-07-19T11:51:49.5286653Z ^
build	Build and Test	2026-07-19T11:51:49.5295001Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/ChatboxInput.java:32: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:51:49.5325888Z @Value
build	Build and Test	2026-07-19T11:51:49.5355871Z ^
build	Build and Test	2026-07-19T11:51:49.5407529Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/devtools/ScriptInspector.java:100: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:51:49.5415833Z 	@Data
build	Build and Test	2026-07-19T11:51:49.5445762Z 	^
build	Build and Test	2026-07-19T11:51:56.0177065Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/agility/Courses.java:88: warning: non-varargs call of varargs method with inexact argument type for last parameter;
build	Build and Test	2026-07-19T11:51:56.0199786Z 		this(totalXp, -1, null);
build	Build and Test	2026-07-19T11:51:56.0224026Z 		                  ^
build	Build and Test	2026-07-19T11:51:56.0256184Z   cast to WorldPoint for a varargs call
build	Build and Test	2026-07-19T11:51:56.0257340Z   cast to WorldPoint[] for a non-varargs call and to suppress this warning
build	Build and Test	2026-07-19T11:51:59.6197982Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginService.java:154: error: cannot find symbol
build	Build and Test	2026-07-19T11:51:59.6216017Z 			client.getUsername(), client.getPassword());
build	Build and Test	2026-07-19T11:51:59.6217075Z 			                            ^
build	Build and Test	2026-07-19T11:51:59.6217849Z   symbol:   method getPassword()
build	Build and Test	2026-07-19T11:51:59.6219278Z   location: variable client of type Client
build	Build and Test	2026-07-19T11:52:00.5158311Z Note: Some input files use or override a deprecated API.
build	Build and Test	2026-07-19T11:52:00.5166650Z Note: Recompile with -Xlint:deprecation for details.
build	Build and Test	2026-07-19T11:52:00.5167938Z Note: Some input files use unchecked or unsafe operations.
build	Build and Test	2026-07-19T11:52:00.5169054Z Note: Recompile with -Xlint:unchecked for details.
build	Build and Test	2026-07-19T11:52:00.5170088Z 1 error
build	Build and Test	2026-07-19T11:52:00.5170851Z 5 warnings
build	Build and Test	2026-07-19T11:52:00.8177053Z
build	Build and Test	2026-07-19T11:52:00.8179747Z > Task :client:compileJava FAILED
build	Build and Test	2026-07-19T11:52:00.8181885Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784461888399.json
build	Build and Test	2026-07-19T11:52:00.9157356Z
build	Build and Test	2026-07-19T11:52:00.9164157Z 55 actionable tasks: 23 executed, 32 from cache
build	Build and Test	2026-07-19T11:52:00.9177803Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-19T11:52:00.9188304Z
build	Build and Test	2026-07-19T11:52:00.9197570Z * What went wrong:
build	Build and Test	2026-07-19T11:52:00.9198243Z Execution failed for task ':client:compileJava'.
build	Build and Test	2026-07-19T11:52:00.9199080Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-19T11:52:00.9199505Z
build	Build and Test	2026-07-19T11:52:00.9199779Z * Try:
build	Build and Test	2026-07-19T11:52:00.9200282Z > Run with --info option to get more log output.
build	Build and Test	2026-07-19T11:52:00.9200885Z > Run with --scan to get full insights.
build	Build and Test	2026-07-19T11:52:00.9201234Z
build	Build and Test	2026-07-19T11:52:00.9201474Z BUILD FAILED in 39s
build	Build and Test	2026-07-19T11:52:01.3113914Z ##[error]Process completed with exit code 1.
```

## CI: Upload focused client test diagnostics

- Run: [29685886504](https://github.com/KSPOG/klite/actions/runs/29685886504)
- Conclusion: `failure`
- Event: `push`
- Commit: `f3c5cfd9b779db64f306d4824cea5db65c5ecd74`
- Created: `2026-07-19T11:50:59Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-19T11:51:34.9109492Z > Task :runelite-api:build
build	Build and Test	2026-07-19T11:51:44.5110956Z
build	Build and Test	2026-07-19T11:51:44.5136319Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/party/messages/PartyChatMessage.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:51:44.5138846Z @Value
build	Build and Test	2026-07-19T11:51:44.5139223Z ^
build	Build and Test	2026-07-19T11:51:44.5141463Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/PrivateMessageInput.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:51:44.5144107Z @Value
build	Build and Test	2026-07-19T11:51:44.5144480Z ^
build	Build and Test	2026-07-19T11:51:44.5146644Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/ChatboxInput.java:32: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:51:44.5148939Z @Value
build	Build and Test	2026-07-19T11:51:44.5149293Z ^
build	Build and Test	2026-07-19T11:51:44.5151506Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/devtools/ScriptInspector.java:100: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
build	Build and Test	2026-07-19T11:51:44.5154027Z 	@Data
build	Build and Test	2026-07-19T11:51:44.5154379Z 	^
build	Build and Test	2026-07-19T11:51:44.5154752Z > Task :client:compileJava
build	Build and Test	2026-07-19T11:51:51.5116877Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/agility/Courses.java:88: warning: non-varargs call of varargs method with inexact argument type for last parameter;
build	Build and Test	2026-07-19T11:51:51.5119172Z 		this(totalXp, -1, null);
build	Build and Test	2026-07-19T11:51:51.5120050Z 		                  ^
build	Build and Test	2026-07-19T11:51:51.5120799Z   cast to WorldPoint for a varargs call
build	Build and Test	2026-07-19T11:51:51.5121876Z   cast to WorldPoint[] for a non-varargs call and to suppress this warning
build	Build and Test	2026-07-19T11:51:55.4135248Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginService.java:154: error: cannot find symbol
build	Build and Test	2026-07-19T11:51:55.4164108Z 			client.getUsername(), client.getPassword());
build	Build and Test	2026-07-19T11:51:55.4193982Z 			                            ^
build	Build and Test	2026-07-19T11:51:55.4224161Z   symbol:   method getPassword()
build	Build and Test	2026-07-19T11:51:55.4254034Z   location: variable client of type Client
build	Build and Test	2026-07-19T11:51:56.2154713Z Note: Some input files use or override a deprecated API.
build	Build and Test	2026-07-19T11:51:56.2179123Z Note: Recompile with -Xlint:deprecation for details.
build	Build and Test	2026-07-19T11:51:56.2180459Z Note: Some input files use unchecked or unsafe operations.
build	Build and Test	2026-07-19T11:51:56.2189731Z Note: Recompile with -Xlint:unchecked for details.
build	Build and Test	2026-07-19T11:51:56.2190610Z 1 error
build	Build and Test	2026-07-19T11:51:56.2191185Z 5 warnings
build	Build and Test	2026-07-19T11:51:56.5105315Z
build	Build and Test	2026-07-19T11:51:56.5106021Z > Task :client:compileJava FAILED
build	Build and Test	2026-07-19T11:51:56.6133882Z
build	Build and Test	2026-07-19T11:51:56.6134862Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784461882765.json
build	Build and Test	2026-07-19T11:51:56.6150503Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-19T11:51:56.6151046Z
build	Build and Test	2026-07-19T11:51:56.6151330Z 55 actionable tasks: 23 executed, 32 from cache
build	Build and Test	2026-07-19T11:51:56.6152371Z * What went wrong:
build	Build and Test	2026-07-19T11:51:56.6153053Z Execution failed for task ':client:compileJava'.
build	Build and Test	2026-07-19T11:51:56.6154561Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-19T11:51:56.6155352Z
build	Build and Test	2026-07-19T11:51:56.6157578Z * Try:
build	Build and Test	2026-07-19T11:51:56.6158286Z > Run with --info option to get more log output.
build	Build and Test	2026-07-19T11:51:56.6159153Z > Run with --scan to get full insights.
build	Build and Test	2026-07-19T11:51:56.6159733Z
build	Build and Test	2026-07-19T11:51:56.6160092Z BUILD FAILED in 40s
build	Build and Test	2026-07-19T11:51:57.0452278Z ##[error]Process completed with exit code 1.
```

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

## Apply client version, AutoLogin, and Discord updates: Add client AutoLogin and Discord update notifications

- Run: [29685821101](https://github.com/KSPOG/klite/actions/runs/29685821101)
- Conclusion: `failure`
- Event: `pull_request`
- Commit: `b0da12baea03ebc10c51e277fb9a2661939571c2`
- Created: `2026-07-19T11:48:52Z`

### Failed jobs and steps

- **verify-feature** — `failure`
  - Step 8: **Run focused client tests** — `failure`

### Relevant log context

```text
verify-feature	Run focused client tests	2026-07-19T11:49:58.9027106Z > Task :runelite-api:jar
verify-feature	Run focused client tests	2026-07-19T11:50:10.2025249Z
verify-feature	Run focused client tests	2026-07-19T11:50:10.2056133Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/PrivateMessageInput.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
verify-feature	Run focused client tests	2026-07-19T11:50:10.2083837Z @Value
verify-feature	Run focused client tests	2026-07-19T11:50:10.2084288Z > Task :client:compileJava
verify-feature	Run focused client tests	2026-07-19T11:50:10.2093717Z ^
verify-feature	Run focused client tests	2026-07-19T11:50:10.2095954Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/ChatboxInput.java:32: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
verify-feature	Run focused client tests	2026-07-19T11:50:10.2098268Z @Value
verify-feature	Run focused client tests	2026-07-19T11:50:10.2098573Z ^
verify-feature	Run focused client tests	2026-07-19T11:50:10.2100820Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/party/messages/PartyChatMessage.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
verify-feature	Run focused client tests	2026-07-19T11:50:10.2111076Z @Value
verify-feature	Run focused client tests	2026-07-19T11:50:10.2111413Z ^
verify-feature	Run focused client tests	2026-07-19T11:50:10.2113827Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/devtools/ScriptInspector.java:100: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
verify-feature	Run focused client tests	2026-07-19T11:50:10.2116194Z 	@Data
verify-feature	Run focused client tests	2026-07-19T11:50:10.2116487Z 	^
verify-feature	Run focused client tests	2026-07-19T11:50:17.4027964Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/agility/Courses.java:88: warning: non-varargs call of varargs method with inexact argument type for last parameter;
verify-feature	Run focused client tests	2026-07-19T11:50:17.4032738Z 		this(totalXp, -1, null);
verify-feature	Run focused client tests	2026-07-19T11:50:17.4033697Z 		                  ^
verify-feature	Run focused client tests	2026-07-19T11:50:17.4034384Z   cast to WorldPoint for a varargs call
verify-feature	Run focused client tests	2026-07-19T11:50:17.4035322Z   cast to WorldPoint[] for a non-varargs call and to suppress this warning
verify-feature	Run focused client tests	2026-07-19T11:50:21.8030586Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginService.java:154: error: cannot find symbol
verify-feature	Run focused client tests	2026-07-19T11:50:21.8074597Z 			client.getUsername(), client.getPassword());
verify-feature	Run focused client tests	2026-07-19T11:50:21.8093878Z 			                            ^
verify-feature	Run focused client tests	2026-07-19T11:50:21.8104054Z   symbol:   method getPassword()
verify-feature	Run focused client tests	2026-07-19T11:50:21.8133780Z   location: variable client of type Client
verify-feature	Run focused client tests	2026-07-19T11:50:22.7028754Z Note: Some input files use or override a deprecated API.
verify-feature	Run focused client tests	2026-07-19T11:50:22.7041580Z Note: Recompile with -Xlint:deprecation for details.
verify-feature	Run focused client tests	2026-07-19T11:50:22.7081521Z Note: Some input files use unchecked or unsafe operations.
verify-feature	Run focused client tests	2026-07-19T11:50:22.7095974Z Note: Recompile with -Xlint:unchecked for details.
verify-feature	Run focused client tests	2026-07-19T11:50:22.7108148Z 1 error
verify-feature	Run focused client tests	2026-07-19T11:50:22.7116145Z 5 warnings
verify-feature	Run focused client tests	2026-07-19T11:50:23.0025152Z
verify-feature	Run focused client tests	2026-07-19T11:50:23.0059917Z
verify-feature	Run focused client tests	2026-07-19T11:50:23.0060557Z > Task :client:compileJava FAILED
verify-feature	Run focused client tests	2026-07-19T11:50:23.0064537Z FAILURE: Build failed with an exception.
verify-feature	Run focused client tests	2026-07-19T11:50:23.0065464Z 24 actionable tasks: 24 executed
verify-feature	Run focused client tests	2026-07-19T11:50:23.0093643Z
verify-feature	Run focused client tests	2026-07-19T11:50:23.0094153Z * What went wrong:
verify-feature	Run focused client tests	2026-07-19T11:50:23.0095071Z Execution failed for task ':client:compileJava'.
verify-feature	Run focused client tests	2026-07-19T11:50:23.0095899Z > Compilation failed; see the compiler error output for details.
verify-feature	Run focused client tests	2026-07-19T11:50:23.0096786Z
verify-feature	Run focused client tests	2026-07-19T11:50:23.0097079Z * Try:
verify-feature	Run focused client tests	2026-07-19T11:50:23.0098874Z > Run with --info option to get more log output.
verify-feature	Run focused client tests	2026-07-19T11:50:23.0099574Z > Run with --scan to get full insights.
verify-feature	Run focused client tests	2026-07-19T11:50:23.0100117Z
verify-feature	Run focused client tests	2026-07-19T11:50:23.0100459Z BUILD FAILED in 1m 11s
verify-feature	Run focused client tests	2026-07-19T11:50:23.4767446Z ##[error]Process completed with exit code 1.
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

