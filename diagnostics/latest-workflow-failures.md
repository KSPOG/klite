# Recent GitHub Actions failures

Generated: 2026-07-19T11:56:09.838474+00:00
Repository: `KSPOG/klite`
Failed runs inspected: **15**

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29686036675](https://github.com/KSPOG/klite/actions/runs/29686036675)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `0eb4e6914d72969e41d5554b817dfca0cda38553`
- Created: `2026-07-19T11:55:49Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 2: **Check out repository** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## Apply client version, AutoLogin, and Discord updates: Add client AutoLogin and Discord update notifications

- Run: [29685978405](https://github.com/KSPOG/klite/actions/runs/29685978405)
- Conclusion: `failure`
- Event: `pull_request`
- Commit: `b3248b934b29bf1da7ec2f03d6474e4d9e9c4da6`
- Created: `2026-07-19T11:53:58Z`

### Failed jobs and steps

- **verify-feature** — `failure`
  - Step 8: **Report focused client test failure** — `failure`

### Relevant log context

```text
verify-feature	Report focused client test failure	﻿2026-07-19T11:55:35.5401291Z ##[group]Run {
verify-feature	Report focused client test failure	2026-07-19T11:55:35.5401588Z ^[[36;1m{^[[0m
verify-feature	Report focused client test failure	2026-07-19T11:55:35.5401850Z ^[[36;1m  echo '### Focused client test failure summary'^[[0m
verify-feature	Report focused client test failure	2026-07-19T11:55:35.5402195Z ^[[36;1m  echo '```text'^[[0m
verify-feature	Report focused client test failure	2026-07-19T11:55:35.5402801Z ^[[36;1m  grep -E -A 18 -B 5 'error:|FAILURE:|FAILED|cannot find symbol|Compilation failed|AssertionError|Caused by:' client-test.log | tail -n 220^[[0m
verify-feature	Report focused client test failure	2026-07-19T11:55:35.5403419Z ^[[36;1m  echo '```'^[[0m
verify-feature	Report focused client test failure	2026-07-19T11:55:35.5403658Z ^[[36;1m} > client-test-comment.md^[[0m
verify-feature	Report focused client test failure	2026-07-19T11:55:35.5404019Z ^[[36;1mgh pr comment 57 --body-file client-test-comment.md^[[0m
verify-feature	Report focused client test failure	2026-07-19T11:55:35.5404687Z ^[[36;1mexit 1^[[0m
verify-feature	Report focused client test failure	2026-07-19T11:55:35.5464703Z shell: /usr/bin/bash --noprofile --norc -e -o pipefail {0}
verify-feature	Report focused client test failure	2026-07-19T11:55:35.5465098Z env:
verify-feature	Report focused client test failure	2026-07-19T11:55:35.5465429Z   JAVA_HOME: /opt/hostedtoolcache/Java_Temurin-Hotspot_jdk/11.0.31-11/x64
verify-feature	Report focused client test failure	2026-07-19T11:55:35.5465956Z   JAVA_HOME_11_X64: /opt/hostedtoolcache/Java_Temurin-Hotspot_jdk/11.0.31-11/x64
verify-feature	Report focused client test failure	2026-07-19T11:55:35.5468860Z   GH_TOKEN: ***
verify-feature	Report focused client test failure	2026-07-19T11:55:35.5469157Z ##[endgroup]
verify-feature	Report focused client test failure	2026-07-19T11:55:36.3217548Z https://github.com/KSPOG/klite/pull/57#issuecomment-5015613981
verify-feature	Report focused client test failure	2026-07-19T11:55:36.3242657Z ##[error]Process completed with exit code 1.
```

## CI: Add client AutoLogin and Discord update notifications

- Run: [29685978401](https://github.com/KSPOG/klite/actions/runs/29685978401)
- Conclusion: `failure`
- Event: `pull_request`
- Commit: `b3248b934b29bf1da7ec2f03d6474e4d9e9c4da6`
- Created: `2026-07-19T11:53:58Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-19T11:55:20.1357064Z 	public CompletableFuture<Optional<Point>> mapPoint(Point point)
build	Build and Test	2026-07-19T11:55:20.1358004Z 	                                          ^
build	Build and Test	2026-07-19T11:55:20.1359794Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:73: warning: no @param for bounds
build	Build and Test	2026-07-19T11:55:20.1376259Z 	public CompletableFuture<Optional<Rectangle>> mapBounds(Rectangle bounds)
build	Build and Test	2026-07-19T11:55:20.1377054Z 	                                              ^
build	Build and Test	2026-07-19T11:55:20.1378410Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:73: warning: no @return
build	Build and Test	2026-07-19T11:55:20.1380135Z 	public CompletableFuture<Optional<Rectangle>> mapBounds(Rectangle bounds)
build	Build and Test	2026-07-19T11:55:20.1380916Z 	                                              ^
build	Build and Test	2026-07-19T11:55:20.1382711Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:79: warning: no @param for point
build	Build and Test	2026-07-19T11:55:20.1384297Z 	public CompletableFuture<KLiteInteractionResult> clickPoint(Point point)
build	Build and Test	2026-07-19T11:55:20.1385052Z 	                                                 ^
build	Build and Test	2026-07-19T11:55:20.1386356Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:79: warning: no @return
build	Build and Test	2026-07-19T11:55:20.1387815Z 	public CompletableFuture<KLiteInteractionResult> clickPoint(Point point)
build	Build and Test	2026-07-19T11:55:20.1388521Z 	                                                 ^
build	Build and Test	2026-07-19T11:55:20.1390093Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:104: warning: no @param for bounds
build	Build and Test	2026-07-19T11:55:20.1391743Z 	public CompletableFuture<KLiteInteractionResult> clickBounds(Rectangle bounds)
build	Build and Test	2026-07-19T11:55:20.1392529Z 	                                                 ^
build	Build and Test	2026-07-19T11:55:20.1393891Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:104: warning: no @return
build	Build and Test	2026-07-19T11:55:20.1395462Z 	public CompletableFuture<KLiteInteractionResult> clickBounds(Rectangle bounds)
build	Build and Test	2026-07-19T11:55:20.1396262Z 	                                                 ^
build	Build and Test	2026-07-19T11:55:20.4241185Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-19T11:55:20.4270136Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T11:55:20.4302177Z 	            ^
build	Build and Test	2026-07-19T11:55:20.4311165Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-19T11:55:20.4313559Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T11:55:20.4314764Z 	            ^
build	Build and Test	2026-07-19T11:55:20.4316407Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-19T11:55:20.4318721Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T11:55:20.4320873Z 	            ^
build	Build and Test	2026-07-19T11:55:20.4330368Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-19T11:55:20.4332603Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T11:55:20.4333849Z 	            ^
build	Build and Test	2026-07-19T11:55:20.4336247Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-19T11:55:20.4338564Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T11:55:20.4339939Z 	            ^
build	Build and Test	2026-07-19T11:55:20.4341583Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-19T11:55:20.4343852Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T11:55:20.4345036Z 	            ^
build	Build and Test	2026-07-19T11:55:20.4346455Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-19T11:55:20.4348535Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T11:55:20.4349887Z 	            ^
build	Build and Test	2026-07-19T11:55:20.4351486Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-19T11:55:20.4353723Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T11:55:20.4355255Z 	            ^
build	Build and Test	2026-07-19T11:55:20.4356849Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-19T11:55:20.4359259Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T11:55:20.4360535Z 	            ^
build	Build and Test	2026-07-19T11:55:20.4361995Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-19T11:55:20.4363611Z 	 * @param itemId
build	Build and Test	2026-07-19T11:55:20.4364159Z 	   ^
build	Build and Test	2026-07-19T11:55:20.4365518Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-19T11:55:20.4367087Z 	 * @return
build	Build and Test	2026-07-19T11:55:20.4367605Z 	   ^
build	Build and Test	2026-07-19T11:55:20.8419360Z 	public boolean isClearChildren() {
build	Build and Test	2026-07-19T11:55:20.8419982Z 	               ^
build	Build and Test	2026-07-19T11:55:20.8421248Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:104: warning: no @return
build	Build and Test	2026-07-19T11:55:20.8422700Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-19T11:55:20.8423316Z 	               ^
build	Build and Test	2026-07-19T11:55:25.6227477Z 100 warnings
build	Build and Test	2026-07-19T11:55:27.8227205Z
build	Build and Test	2026-07-19T11:55:27.8228125Z > Task :client:javadocJar
build	Build and Test	2026-07-19T11:55:27.8229300Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-19T11:55:32.4284008Z > Task :client:shadowJar
build	Build and Test	2026-07-19T11:55:32.4324800Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-19T11:55:32.4369835Z > Task :client:assemble
build	Build and Test	2026-07-19T11:55:36.0244758Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/menus/TestMenuEntry.java:53: warning: Not generating setItemId(): A method with that name already exists
build	Build and Test	2026-07-19T11:55:36.0246131Z
build	Build and Test	2026-07-19T11:55:36.0269751Z 	private int itemId = -1;
build	Build and Test	2026-07-19T11:55:36.0270316Z > Task :client:compileTestJava
build	Build and Test	2026-07-19T11:55:36.0299381Z 	            ^
build	Build and Test	2026-07-19T11:55:36.0300701Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/menus/TestMenuEntry.java:60: warning: Not generating setWorldViewId(): A method with that name already exists
build	Build and Test	2026-07-19T11:55:36.0329330Z 	private int worldViewId;
build	Build and Test	2026-07-19T11:55:36.0359449Z 	            ^
build	Build and Test	2026-07-19T11:55:41.7260897Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginServiceTest.java:18: error: cannot find symbol
build	Build and Test	2026-07-19T11:55:41.7289807Z 		assertTrue(KLiteAutoLoginService.hasCredentials("session", null, null, null));
build	Build and Test	2026-07-19T11:55:41.7333221Z 		                                ^
build	Build and Test	2026-07-19T11:55:41.7359839Z   symbol:   method hasCredentials(String,<null>,<null>,<null>)
build	Build and Test	2026-07-19T11:55:41.7419494Z   location: class KLiteAutoLoginService
build	Build and Test	2026-07-19T11:55:41.7450317Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginServiceTest.java:24: error: cannot find symbol
build	Build and Test	2026-07-19T11:55:41.7509824Z 		assertTrue(KLiteAutoLoginService.hasCredentials(null, "Character", null, null));
build	Build and Test	2026-07-19T11:55:41.7539434Z 		                                ^
build	Build and Test	2026-07-19T11:55:41.7569622Z   symbol:   method hasCredentials(<null>,String,<null>,<null>)
build	Build and Test	2026-07-19T11:55:41.7570392Z   location: class KLiteAutoLoginService
build	Build and Test	2026-07-19T11:55:41.7571708Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginServiceTest.java:30: error: cannot find symbol
build	Build and Test	2026-07-19T11:55:41.7573297Z 		assertTrue(KLiteAutoLoginService.hasCredentials(null, null, "user", "password"));
build	Build and Test	2026-07-19T11:55:41.7574122Z 		                                ^
build	Build and Test	2026-07-19T11:55:41.7574759Z   symbol:   method hasCredentials(<null>,<null>,String,String)
build	Build and Test	2026-07-19T11:55:41.7575425Z   location: class KLiteAutoLoginService
build	Build and Test	2026-07-19T11:55:41.7576788Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginServiceTest.java:36: error: cannot find symbol
build	Build and Test	2026-07-19T11:55:41.7578289Z 		assertFalse(KLiteAutoLoginService.hasCredentials(null, null, "user", null));
build	Build and Test	2026-07-19T11:55:41.7639419Z 		                                 ^
build	Build and Test	2026-07-19T11:55:41.7709648Z   symbol:   method hasCredentials(<null>,<null>,String,<null>)
build	Build and Test	2026-07-19T11:55:41.7738150Z   location: class KLiteAutoLoginService
build	Build and Test	2026-07-19T11:55:41.7770193Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginServiceTest.java:37: error: cannot find symbol
build	Build and Test	2026-07-19T11:55:41.7810841Z 		assertFalse(KLiteAutoLoginService.hasCredentials(null, null, null, "password"));
build	Build and Test	2026-07-19T11:55:41.7859421Z 		                                 ^
build	Build and Test	2026-07-19T11:55:41.7889585Z   symbol:   method hasCredentials(<null>,<null>,<null>,String)
build	Build and Test	2026-07-19T11:55:41.7949544Z   location: class KLiteAutoLoginService
build	Build and Test	2026-07-19T11:55:41.7980283Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginServiceTest.java:38: error: cannot find symbol
build	Build and Test	2026-07-19T11:55:41.8039629Z 		assertFalse(KLiteAutoLoginService.hasCredentials(" ", " ", " ", " "));
build	Build and Test	2026-07-19T11:55:41.8069400Z 		                                 ^
build	Build and Test	2026-07-19T11:55:41.8129675Z   symbol:   method hasCredentials(String,String,String,String)
build	Build and Test	2026-07-19T11:55:41.8149449Z   location: class KLiteAutoLoginService
build	Build and Test	2026-07-19T11:55:42.1230144Z Note: Some input files use or override a deprecated API.
build	Build and Test	2026-07-19T11:55:42.1230709Z
build	Build and Test	2026-07-19T11:55:42.1249538Z Note: Recompile with -Xlint:deprecation for details.
build	Build and Test	2026-07-19T11:55:42.1312689Z Note: Some input files use unchecked or unsafe operations.
build	Build and Test	2026-07-19T11:55:42.1313418Z > Task :client:compileTestJava FAILED
build	Build and Test	2026-07-19T11:55:42.1314072Z Note: Recompile with -Xlint:unchecked for details.
build	Build and Test	2026-07-19T11:55:42.1339306Z 6 errors
build	Build and Test	2026-07-19T11:55:42.1359487Z 2 warnings
build	Build and Test	2026-07-19T11:55:50.0230690Z > Task :client:checkstyleMain
build	Build and Test	2026-07-19T11:55:50.0250416Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784462060622.json
build	Build and Test	2026-07-19T11:55:50.1226717Z
build	Build and Test	2026-07-19T11:55:50.1228109Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-19T11:55:50.1228838Z
build	Build and Test	2026-07-19T11:55:50.1249678Z * What went wrong:
build	Build and Test	2026-07-19T11:55:50.1250206Z 65 actionable tasks: 33 executed, 32 from cache
build	Build and Test	2026-07-19T11:55:50.1251048Z Execution failed for task ':client:compileTestJava'.
build	Build and Test	2026-07-19T11:55:50.1251777Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-19T11:55:50.1252190Z
build	Build and Test	2026-07-19T11:55:50.1252302Z * Try:
build	Build and Test	2026-07-19T11:55:50.1252611Z > Run with --info option to get more log output.
build	Build and Test	2026-07-19T11:55:50.1253240Z > Run with --scan to get full insights.
build	Build and Test	2026-07-19T11:55:50.1253473Z
build	Build and Test	2026-07-19T11:55:50.1253598Z BUILD FAILED in 1m 37s
build	Build and Test	2026-07-19T11:55:50.5482795Z ##[error]Process completed with exit code 1.
```

## CI: Restrict AutoLogin to available launcher sessions

- Run: [29685977010](https://github.com/KSPOG/klite/actions/runs/29685977010)
- Conclusion: `failure`
- Event: `push`
- Commit: `b3248b934b29bf1da7ec2f03d6474e4d9e9c4da6`
- Created: `2026-07-19T11:53:56Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-19T11:55:18.0880366Z 	public CompletableFuture<Optional<Point>> mapPoint(Point point)
build	Build and Test	2026-07-19T11:55:18.0909999Z 	                                          ^
build	Build and Test	2026-07-19T11:55:18.0913961Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:73: warning: no @param for bounds
build	Build and Test	2026-07-19T11:55:18.0915759Z 	public CompletableFuture<Optional<Rectangle>> mapBounds(Rectangle bounds)
build	Build and Test	2026-07-19T11:55:18.0917336Z 	                                              ^
build	Build and Test	2026-07-19T11:55:18.0919019Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:73: warning: no @return
build	Build and Test	2026-07-19T11:55:18.0920787Z 	public CompletableFuture<Optional<Rectangle>> mapBounds(Rectangle bounds)
build	Build and Test	2026-07-19T11:55:18.0921623Z 	                                              ^
build	Build and Test	2026-07-19T11:55:18.0923096Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:79: warning: no @param for point
build	Build and Test	2026-07-19T11:55:18.0924991Z 	public CompletableFuture<KLiteInteractionResult> clickPoint(Point point)
build	Build and Test	2026-07-19T11:55:18.0925909Z 	                                                 ^
build	Build and Test	2026-07-19T11:55:18.0927324Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:79: warning: no @return
build	Build and Test	2026-07-19T11:55:18.0929106Z 	public CompletableFuture<KLiteInteractionResult> clickPoint(Point point)
build	Build and Test	2026-07-19T11:55:18.0930093Z 	                                                 ^
build	Build and Test	2026-07-19T11:55:18.0931642Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:104: warning: no @param for bounds
build	Build and Test	2026-07-19T11:55:18.0933443Z 	public CompletableFuture<KLiteInteractionResult> clickBounds(Rectangle bounds)
build	Build and Test	2026-07-19T11:55:18.0934394Z 	                                                 ^
build	Build and Test	2026-07-19T11:55:18.0935910Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:104: warning: no @return
build	Build and Test	2026-07-19T11:55:18.0937543Z 	public CompletableFuture<KLiteInteractionResult> clickBounds(Rectangle bounds)
build	Build and Test	2026-07-19T11:55:18.0938532Z 	                                                 ^
build	Build and Test	2026-07-19T11:55:18.3731433Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-19T11:55:18.3791635Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T11:55:18.3793696Z 	            ^
build	Build and Test	2026-07-19T11:55:18.3795704Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-19T11:55:18.3805503Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T11:55:18.3811970Z 	            ^
build	Build and Test	2026-07-19T11:55:18.3813880Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-19T11:55:18.3816118Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T11:55:18.3817327Z 	            ^
build	Build and Test	2026-07-19T11:55:18.3818759Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-19T11:55:18.3821082Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T11:55:18.3822299Z 	            ^
build	Build and Test	2026-07-19T11:55:18.3824281Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-19T11:55:18.3826529Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T11:55:18.3827986Z 	            ^
build	Build and Test	2026-07-19T11:55:18.3829785Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-19T11:55:18.3832415Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T11:55:18.3833672Z 	            ^
build	Build and Test	2026-07-19T11:55:18.3835156Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-19T11:55:18.3837232Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T11:55:18.3838484Z 	            ^
build	Build and Test	2026-07-19T11:55:18.3840663Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-19T11:55:18.3842860Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T11:55:18.3845485Z 	            ^
build	Build and Test	2026-07-19T11:55:18.3849092Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-19T11:55:18.3851719Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T11:55:18.3853112Z 	            ^
build	Build and Test	2026-07-19T11:55:18.4726407Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-19T11:55:18.4770940Z 	 * @param itemId
build	Build and Test	2026-07-19T11:55:18.4800212Z 	   ^
build	Build and Test	2026-07-19T11:55:18.4830764Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-19T11:55:18.4832736Z 	 * @return
build	Build and Test	2026-07-19T11:55:18.4843665Z 	   ^
build	Build and Test	2026-07-19T11:55:18.7735600Z 	public boolean isClearChildren() {
build	Build and Test	2026-07-19T11:55:18.7736723Z 	               ^
build	Build and Test	2026-07-19T11:55:18.7738257Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:104: warning: no @return
build	Build and Test	2026-07-19T11:55:18.7740232Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-19T11:55:18.7741058Z 	               ^
build	Build and Test	2026-07-19T11:55:23.4722983Z 100 warnings
build	Build and Test	2026-07-19T11:55:25.3723737Z
build	Build and Test	2026-07-19T11:55:25.3725156Z > Task :client:javadocJar
build	Build and Test	2026-07-19T11:55:25.3726289Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-19T11:55:29.6723418Z > Task :client:shadowJar
build	Build and Test	2026-07-19T11:55:29.6725542Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-19T11:55:29.6726687Z > Task :client:assemble
build	Build and Test	2026-07-19T11:55:33.5801482Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/menus/TestMenuEntry.java:53: warning: Not generating setItemId(): A method with that name already exists
build	Build and Test	2026-07-19T11:55:33.5802803Z
build	Build and Test	2026-07-19T11:55:33.5830168Z > Task :client:compileTestJava
build	Build and Test	2026-07-19T11:55:33.5860022Z 	private int itemId = -1;
build	Build and Test	2026-07-19T11:55:33.5919916Z 	            ^
build	Build and Test	2026-07-19T11:55:33.5960690Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/menus/TestMenuEntry.java:60: warning: Not generating setWorldViewId(): A method with that name already exists
build	Build and Test	2026-07-19T11:55:33.5962486Z 	private int worldViewId;
build	Build and Test	2026-07-19T11:55:33.5963121Z 	            ^
build	Build and Test	2026-07-19T11:55:37.8781090Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginServiceTest.java:18: error: cannot find symbol
build	Build and Test	2026-07-19T11:55:37.8803308Z 		assertTrue(KLiteAutoLoginService.hasCredentials("session", null, null, null));
build	Build and Test	2026-07-19T11:55:37.8860344Z 		                                ^
build	Build and Test	2026-07-19T11:55:37.8890128Z   symbol:   method hasCredentials(String,<null>,<null>,<null>)
build	Build and Test	2026-07-19T11:55:37.8929912Z   location: class KLiteAutoLoginService
build	Build and Test	2026-07-19T11:55:37.8980743Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginServiceTest.java:24: error: cannot find symbol
build	Build and Test	2026-07-19T11:55:37.9040232Z 		assertTrue(KLiteAutoLoginService.hasCredentials(null, "Character", null, null));
build	Build and Test	2026-07-19T11:55:37.9069729Z 		                                ^
build	Build and Test	2026-07-19T11:55:37.9070716Z   symbol:   method hasCredentials(<null>,String,<null>,<null>)
build	Build and Test	2026-07-19T11:55:37.9071543Z   location: class KLiteAutoLoginService
build	Build and Test	2026-07-19T11:55:37.9072921Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginServiceTest.java:30: error: cannot find symbol
build	Build and Test	2026-07-19T11:55:37.9074452Z 		assertTrue(KLiteAutoLoginService.hasCredentials(null, null, "user", "password"));
build	Build and Test	2026-07-19T11:55:37.9075435Z 		                                ^
build	Build and Test	2026-07-19T11:55:37.9076140Z   symbol:   method hasCredentials(<null>,<null>,String,String)
build	Build and Test	2026-07-19T11:55:37.9076959Z   location: class KLiteAutoLoginService
build	Build and Test	2026-07-19T11:55:37.9078183Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginServiceTest.java:36: error: cannot find symbol
build	Build and Test	2026-07-19T11:55:37.9079920Z 		assertFalse(KLiteAutoLoginService.hasCredentials(null, null, "user", null));
build	Build and Test	2026-07-19T11:55:37.9080746Z 		                                 ^
build	Build and Test	2026-07-19T11:55:37.9109832Z   symbol:   method hasCredentials(<null>,<null>,String,<null>)
build	Build and Test	2026-07-19T11:55:37.9160017Z   location: class KLiteAutoLoginService
build	Build and Test	2026-07-19T11:55:37.9190497Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginServiceTest.java:37: error: cannot find symbol
build	Build and Test	2026-07-19T11:55:37.9250389Z 		assertFalse(KLiteAutoLoginService.hasCredentials(null, null, null, "password"));
build	Build and Test	2026-07-19T11:55:37.9279904Z 		                                 ^
build	Build and Test	2026-07-19T11:55:37.9340125Z   symbol:   method hasCredentials(<null>,<null>,<null>,String)
build	Build and Test	2026-07-19T11:55:37.9369841Z   location: class KLiteAutoLoginService
build	Build and Test	2026-07-19T11:55:37.9371465Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/login/KLiteAutoLoginServiceTest.java:38: error: cannot find symbol
build	Build and Test	2026-07-19T11:55:37.9373086Z 		assertFalse(KLiteAutoLoginService.hasCredentials(" ", " ", " ", " "));
build	Build and Test	2026-07-19T11:55:37.9374063Z 		                                 ^
build	Build and Test	2026-07-19T11:55:37.9374876Z   symbol:   method hasCredentials(String,String,String,String)
build	Build and Test	2026-07-19T11:55:37.9375842Z   location: class KLiteAutoLoginService
build	Build and Test	2026-07-19T11:55:38.3723731Z Note: Some input files use or override a deprecated API.
build	Build and Test	2026-07-19T11:55:38.3775556Z Note: Recompile with -Xlint:deprecation for details.
build	Build and Test	2026-07-19T11:55:38.3776451Z Note: Some input files use unchecked or unsafe operations.
build	Build and Test	2026-07-19T11:55:38.3777294Z Note: Recompile with -Xlint:unchecked for details.
build	Build and Test	2026-07-19T11:55:38.3777857Z 6 errors
build	Build and Test	2026-07-19T11:55:38.3778368Z 2 warnings
build	Build and Test	2026-07-19T11:55:38.4729719Z
build	Build and Test	2026-07-19T11:55:38.4731277Z > Task :client:compileTestJava FAILED
build	Build and Test	2026-07-19T11:55:43.6727407Z > Task :client:checkstyleMain
build	Build and Test	2026-07-19T11:55:43.6761364Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784462062519.json
build	Build and Test	2026-07-19T11:55:43.7722016Z
build	Build and Test	2026-07-19T11:55:43.7723287Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-19T11:55:43.7723854Z
build	Build and Test	2026-07-19T11:55:43.7724290Z 65 actionable tasks: 33 executed, 32 from cache
build	Build and Test	2026-07-19T11:55:43.7724988Z * What went wrong:
build	Build and Test	2026-07-19T11:55:43.7725602Z Execution failed for task ':client:compileTestJava'.
build	Build and Test	2026-07-19T11:55:43.7726389Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-19T11:55:43.7726923Z
build	Build and Test	2026-07-19T11:55:43.7727136Z * Try:
build	Build and Test	2026-07-19T11:55:43.7727641Z > Run with --info option to get more log output.
build	Build and Test	2026-07-19T11:55:43.7728711Z > Run with --scan to get full insights.
build	Build and Test	2026-07-19T11:55:43.7729242Z
build	Build and Test	2026-07-19T11:55:43.7729547Z BUILD FAILED in 1m 30s
build	Build and Test	2026-07-19T11:55:44.1889091Z ##[error]Process completed with exit code 1.
```

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

## Apply client version, AutoLogin, and Discord updates: Add client AutoLogin and Discord update notifications

- Run: [29685887978](https://github.com/KSPOG/klite/actions/runs/29685887978)
- Conclusion: `failure`
- Event: `pull_request`
- Commit: `f3c5cfd9b779db64f306d4824cea5db65c5ecd74`
- Created: `2026-07-19T11:51:02Z`

### Failed jobs and steps

- **verify-feature** — `failure`
  - Step 8: **Report focused client test failure** — `failure`

### Relevant log context

```text
verify-feature	Report focused client test failure	﻿2026-07-19T11:52:29.0058019Z ##[group]Run {
verify-feature	Report focused client test failure	2026-07-19T11:52:29.0058298Z ^[[36;1m{^[[0m
verify-feature	Report focused client test failure	2026-07-19T11:52:29.0058569Z ^[[36;1m  echo '### Focused client test failure summary'^[[0m
verify-feature	Report focused client test failure	2026-07-19T11:52:29.0058906Z ^[[36;1m  echo '```text'^[[0m
verify-feature	Report focused client test failure	2026-07-19T11:52:29.0059509Z ^[[36;1m  grep -E -A 18 -B 5 'error:|FAILURE:|FAILED|cannot find symbol|Compilation failed|AssertionError|Caused by:' client-test.log | tail -n 220^[[0m
verify-feature	Report focused client test failure	2026-07-19T11:52:29.0060149Z ^[[36;1m  echo '```'^[[0m
verify-feature	Report focused client test failure	2026-07-19T11:52:29.0060399Z ^[[36;1m} > client-test-comment.md^[[0m
verify-feature	Report focused client test failure	2026-07-19T11:52:29.0060760Z ^[[36;1mgh pr comment 57 --body-file client-test-comment.md^[[0m
verify-feature	Report focused client test failure	2026-07-19T11:52:29.0061106Z ^[[36;1mexit 1^[[0m
verify-feature	Report focused client test failure	2026-07-19T11:52:29.0118204Z shell: /usr/bin/bash --noprofile --norc -e -o pipefail {0}
verify-feature	Report focused client test failure	2026-07-19T11:52:29.0118569Z env:
verify-feature	Report focused client test failure	2026-07-19T11:52:29.0118894Z   JAVA_HOME: /opt/hostedtoolcache/Java_Temurin-Hotspot_jdk/11.0.31-11/x64
verify-feature	Report focused client test failure	2026-07-19T11:52:29.0119430Z   JAVA_HOME_11_X64: /opt/hostedtoolcache/Java_Temurin-Hotspot_jdk/11.0.31-11/x64
verify-feature	Report focused client test failure	2026-07-19T11:52:29.0122021Z   GH_TOKEN: ***
verify-feature	Report focused client test failure	2026-07-19T11:52:29.0122275Z ##[endgroup]
verify-feature	Report focused client test failure	2026-07-19T11:52:31.9309270Z https://github.com/KSPOG/klite/pull/57#issuecomment-5015604690
verify-feature	Report focused client test failure	2026-07-19T11:52:31.9335774Z ##[error]Process completed with exit code 1.
```

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

