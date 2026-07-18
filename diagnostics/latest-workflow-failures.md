# Recent GitHub Actions failures

Generated: 2026-07-18T01:46:17.597969+00:00
Repository: `KSPOG/klite`
Failed runs inspected: **15**

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29625825527](https://github.com/KSPOG/klite/actions/runs/29625825527)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `6d1ee78ce940da3d50c304f1a7036c950d0e8ba3`
- Created: `2026-07-18T01:45:55Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 2: **Check out repository** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## Install release preview homepage: Add release-preview dashboard partial

- Run: [29625812379](https://github.com/KSPOG/klite/actions/runs/29625812379)
- Conclusion: `failure`
- Event: `push`
- Commit: `8a001a7a3a0b654d3ed9f8456c9fad129d3c7bdf`
- Created: `2026-07-18T01:45:30Z`

### Failed jobs and steps

No failed job metadata was returned.

### Relevant log context

```text

failed to get run log: log not found
```

## Install release preview homepage: Add release-preview hero partial

- Run: [29625803313](https://github.com/KSPOG/klite/actions/runs/29625803313)
- Conclusion: `failure`
- Event: `push`
- Commit: `6dac2c4618576bbcbe0715a06d9d56418dcf1ae9`
- Created: `2026-07-18T01:45:14Z`

### Failed jobs and steps

No failed job metadata was returned.

### Relevant log context

```text

failed to get run log: log not found
```

## Install release preview homepage: Load release homepage from split partials

- Run: [29625793500](https://github.com/KSPOG/klite/actions/runs/29625793500)
- Conclusion: `failure`
- Event: `push`
- Commit: `4e3c0d1b7e9b74ec504ee75fa841a453bc028ed2`
- Created: `2026-07-18T01:44:57Z`

### Failed jobs and steps

No failed job metadata was returned.

### Relevant log context

```text

failed to get run log: log not found
```

## CI: Add release-preview header partial

- Run: [29625772017](https://github.com/KSPOG/klite/actions/runs/29625772017)
- Conclusion: `failure`
- Event: `push`
- Commit: `5331e512e8faaa922f758a4b7e41313d8245ef97`
- Created: `2026-07-18T01:44:16Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T01:44:49.9140258Z > Task :copper-tin-miner:jar
build	Build and Test	2026-07-18T01:44:49.9170343Z > Task :copper-tin-miner:assemble
build	Build and Test	2026-07-18T01:44:50.1062652Z > Task :copper-tin-miner:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-18T01:44:50.1065506Z > Task :copper-tin-miner:compileTestJava NO-SOURCE
build	Build and Test	2026-07-18T01:44:50.1066237Z > Task :copper-tin-miner:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T01:44:50.1066990Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-18T01:44:50.1067609Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-18T01:44:50.1068186Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T01:44:50.1068741Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T01:44:50.4062858Z > Task :client:jar
build	Build and Test	2026-07-18T01:44:50.4070216Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T01:44:50.6062851Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T01:44:56.7081325Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T01:44:56.7082639Z
build	Build and Test	2026-07-18T01:44:56.7110021Z 	 * @param duration
build	Build and Test	2026-07-18T01:44:56.7110531Z > Task :client:javadoc
build	Build and Test	2026-07-18T01:44:56.7122934Z 	   ^
build	Build and Test	2026-07-18T01:44:56.7150778Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T01:44:56.7159952Z 	 * @param duration
build	Build and Test	2026-07-18T01:44:56.7190059Z 	   ^
build	Build and Test	2026-07-18T01:44:57.2063375Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:44:57.2072954Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:44:57.2099731Z 	            ^
build	Build and Test	2026-07-18T01:44:57.2121026Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:44:57.2152092Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:44:57.2179670Z 	            ^
build	Build and Test	2026-07-18T01:44:57.2201001Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:44:57.2238441Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:44:57.2251128Z 	            ^
build	Build and Test	2026-07-18T01:44:57.2280625Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:44:57.2297774Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:44:57.2309655Z 	            ^
build	Build and Test	2026-07-18T01:44:57.2311307Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:44:57.2314002Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:44:57.2348650Z 	            ^
build	Build and Test	2026-07-18T01:44:57.2360970Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:44:57.2363800Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:44:57.2365634Z 	            ^
build	Build and Test	2026-07-18T01:44:57.2367365Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:44:57.2370076Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:44:57.2371531Z 	            ^
build	Build and Test	2026-07-18T01:44:57.2373344Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:44:57.2375902Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:44:57.2377234Z 	            ^
build	Build and Test	2026-07-18T01:44:57.2378951Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:44:57.2381715Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:44:57.2383045Z 	            ^
build	Build and Test	2026-07-18T01:44:57.3082111Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T01:44:57.3109810Z 	 * @param itemId
build	Build and Test	2026-07-18T01:44:57.3117769Z 	   ^
build	Build and Test	2026-07-18T01:44:57.3130926Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T01:44:57.3132673Z 	 * @return
build	Build and Test	2026-07-18T01:44:57.3133310Z 	   ^
build	Build and Test	2026-07-18T01:44:57.7086279Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T01:44:57.7087012Z 	               ^
build	Build and Test	2026-07-18T01:44:57.7088480Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T01:44:57.7090451Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T01:44:57.7091214Z 	             ^
build	Build and Test	2026-07-18T01:44:57.7092765Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T01:44:57.7094588Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T01:44:57.7095413Z 	            ^
build	Build and Test	2026-07-18T01:44:57.7096909Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T01:44:57.7098734Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T01:44:57.7099868Z 	            ^
build	Build and Test	2026-07-18T01:44:57.7101509Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T01:44:57.7103485Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T01:44:57.7104426Z 	            ^
build	Build and Test	2026-07-18T01:44:57.8073019Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T01:44:57.8079879Z 	public void select(Color color) {
build	Build and Test	2026-07-18T01:44:57.8080625Z 	            ^
build	Build and Test	2026-07-18T01:44:57.8082172Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T01:44:57.8084213Z 	 * @param dimmed
build	Build and Test	2026-07-18T01:44:57.8084780Z 	   ^
build	Build and Test	2026-07-18T01:44:57.9061816Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T01:44:57.9065187Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:44:57.9068579Z 	            ^
build	Build and Test	2026-07-18T01:44:57.9070447Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T01:44:57.9072404Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:44:57.9073241Z 	            ^
build	Build and Test	2026-07-18T01:44:58.0062032Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T01:44:58.0080466Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T01:44:58.0110026Z 		                                          ^
build	Build and Test	2026-07-18T01:45:03.1062956Z 100 warnings
build	Build and Test	2026-07-18T01:45:05.5060244Z
build	Build and Test	2026-07-18T01:45:05.5063535Z > Task :client:javadocJar
build	Build and Test	2026-07-18T01:45:05.5064147Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T01:45:10.2064927Z > Task :client:shadowJar
build	Build and Test	2026-07-18T01:45:10.2089636Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T01:45:10.2117735Z > Task :client:assemble
build	Build and Test	2026-07-18T01:45:10.5090342Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:45:10.5179532Z > Task :client:testClasses
build	Build and Test	2026-07-18T01:45:10.6110245Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T01:45:30.1109925Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T01:45:32.8071204Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T01:45:40.1083141Z /tmp/junit13130440773127703417/junit10238296996299911551/vert.glsl.vert
build	Build and Test	2026-07-18T01:45:40.1150298Z /tmp/junit13130440773127703417/junit10238296996299911551/frag.glsl.frag
build	Build and Test	2026-07-18T01:45:40.1189987Z /tmp/junit13130440773127703417/junit15624719782579115591/vertui.glsl.vert
build	Build and Test	2026-07-18T01:45:40.1240008Z /tmp/junit13130440773127703417/junit15624719782579115591/fragui.glsl.frag
build	Build and Test	2026-07-18T01:45:40.2090166Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T01:45:40.5072663Z > Task :client:pmdMain
build	Build and Test	2026-07-18T01:45:40.7090090Z > Task :client:test
build	Build and Test	2026-07-18T01:45:43.1060298Z
build	Build and Test	2026-07-18T01:45:43.1071237Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T01:45:43.4068711Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T01:45:43.5071723Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T01:45:43.5101004Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T01:45:49.2069805Z
build	Build and Test	2026-07-18T01:45:49.2091190Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T01:45:53.7061626Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784339076275.json
build	Build and Test	2026-07-18T01:45:53.7063204Z
build	Build and Test	2026-07-18T01:45:53.7065293Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T01:45:53.7065976Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T01:45:53.7066746Z
build	Build and Test	2026-07-18T01:45:53.7067123Z * What went wrong:
build	Build and Test	2026-07-18T01:45:53.7067836Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T01:45:53.7068979Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T01:45:53.7070929Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T01:45:53.7072422Z
build	Build and Test	2026-07-18T01:45:53.7072768Z * Try:
build	Build and Test	2026-07-18T01:45:53.7073431Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T01:45:53.7074023Z
build	Build and Test	2026-07-18T01:45:53.7074383Z BUILD FAILED in 1m 25s
build	Build and Test	2026-07-18T01:45:54.2187784Z ##[error]Process completed with exit code 1.
```

## Install release preview homepage: Add release-preview header partial

- Run: [29625771625](https://github.com/KSPOG/klite/actions/runs/29625771625)
- Conclusion: `failure`
- Event: `push`
- Commit: `5331e512e8faaa922f758a4b7e41313d8245ef97`
- Created: `2026-07-18T01:44:15Z`

### Failed jobs and steps

No failed job metadata was returned.

### Relevant log context

```text

failed to get run log: log not found
```

## CI: Add release-preview installer driver

- Run: [29625763747](https://github.com/KSPOG/klite/actions/runs/29625763747)
- Conclusion: `failure`
- Event: `push`
- Commit: `7141170b7fce59a176d189927aab969afbaa1f68`
- Created: `2026-07-18T01:44:00Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T01:44:40.2598800Z > Task :copper-tin-miner:jar
build	Build and Test	2026-07-18T01:44:40.2628903Z > Task :copper-tin-miner:assemble
build	Build and Test	2026-07-18T01:44:40.4534515Z > Task :copper-tin-miner:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-18T01:44:40.4542304Z > Task :copper-tin-miner:compileTestJava NO-SOURCE
build	Build and Test	2026-07-18T01:44:40.4546870Z > Task :copper-tin-miner:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T01:44:40.4547603Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-18T01:44:40.4548425Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-18T01:44:40.4549089Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T01:44:40.4549712Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T01:44:40.7544027Z > Task :client:jar
build	Build and Test	2026-07-18T01:44:40.7544813Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T01:44:40.9556345Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T01:44:47.7539141Z
build	Build and Test	2026-07-18T01:44:47.7570261Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T01:44:47.7571823Z 	 * @param duration
build	Build and Test	2026-07-18T01:44:47.7572253Z 	   ^
build	Build and Test	2026-07-18T01:44:47.7573529Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T01:44:47.7574977Z 	 * @param duration
build	Build and Test	2026-07-18T01:44:47.7575388Z 	   ^
build	Build and Test	2026-07-18T01:44:47.7575761Z > Task :client:javadoc
build	Build and Test	2026-07-18T01:44:48.3584098Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:44:48.3619627Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:44:48.3648882Z 	            ^
build	Build and Test	2026-07-18T01:44:48.3650598Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:44:48.3652900Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:44:48.3653991Z 	            ^
build	Build and Test	2026-07-18T01:44:48.3655558Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:44:48.3657818Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:44:48.3659122Z 	            ^
build	Build and Test	2026-07-18T01:44:48.3660524Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:44:48.3662699Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:44:48.3663856Z 	            ^
build	Build and Test	2026-07-18T01:44:48.3665483Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:44:48.3691694Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:44:48.3692867Z 	            ^
build	Build and Test	2026-07-18T01:44:48.3694451Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:44:48.3696967Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:44:48.3698095Z 	            ^
build	Build and Test	2026-07-18T01:44:48.3730037Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:44:48.3732258Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:44:48.3733457Z 	            ^
build	Build and Test	2026-07-18T01:44:48.3735073Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:44:48.3737468Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:44:48.3738933Z 	            ^
build	Build and Test	2026-07-18T01:44:48.3740523Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:44:48.3742837Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:44:48.3743995Z 	            ^
build	Build and Test	2026-07-18T01:44:48.3745407Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T01:44:48.3747019Z 	 * @param itemId
build	Build and Test	2026-07-18T01:44:48.3747477Z 	   ^
build	Build and Test	2026-07-18T01:44:48.3749193Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T01:44:48.3750832Z 	 * @return
build	Build and Test	2026-07-18T01:44:48.3751232Z 	   ^
build	Build and Test	2026-07-18T01:44:48.8551221Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T01:44:48.8551904Z 	               ^
build	Build and Test	2026-07-18T01:44:48.8553286Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T01:44:48.8554849Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T01:44:48.8555526Z 	             ^
build	Build and Test	2026-07-18T01:44:48.8557112Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T01:44:48.8559426Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T01:44:48.8560467Z 	            ^
build	Build and Test	2026-07-18T01:44:48.8562028Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T01:44:48.8563868Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T01:44:48.8564728Z 	            ^
build	Build and Test	2026-07-18T01:44:48.8566273Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T01:44:48.8568506Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T01:44:48.8569476Z 	            ^
build	Build and Test	2026-07-18T01:44:48.9534624Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T01:44:48.9546060Z 	public void select(Color color) {
build	Build and Test	2026-07-18T01:44:48.9547035Z 	            ^
build	Build and Test	2026-07-18T01:44:48.9548870Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T01:44:48.9551262Z 	 * @param dimmed
build	Build and Test	2026-07-18T01:44:48.9551945Z 	   ^
build	Build and Test	2026-07-18T01:44:49.0534353Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T01:44:49.0539169Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:44:49.0540244Z 	            ^
build	Build and Test	2026-07-18T01:44:49.0541939Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T01:44:49.0543902Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:44:49.0544798Z 	            ^
build	Build and Test	2026-07-18T01:44:49.0546476Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T01:44:49.0548831Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T01:44:49.0549975Z 		                                          ^
build	Build and Test	2026-07-18T01:44:52.9532558Z 100 warnings
build	Build and Test	2026-07-18T01:44:55.3532814Z
build	Build and Test	2026-07-18T01:44:55.3534044Z > Task :client:javadocJar
build	Build and Test	2026-07-18T01:44:55.3535312Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T01:45:00.1533325Z > Task :client:shadowJar
build	Build and Test	2026-07-18T01:45:00.1534436Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T01:45:00.1535741Z > Task :client:assemble
build	Build and Test	2026-07-18T01:45:00.5570245Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:45:00.5601469Z > Task :client:testClasses
build	Build and Test	2026-07-18T01:45:00.7532609Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T01:45:19.9594160Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T01:45:24.2580177Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T01:45:30.1539335Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T01:45:30.5553439Z > Task :client:pmdMain
build	Build and Test	2026-07-18T01:45:30.7589209Z > Task :client:test
build	Build and Test	2026-07-18T01:45:32.5588917Z
build	Build and Test	2026-07-18T01:45:32.5649579Z /tmp/junit14734798164399824988/junit5261311143588705812/vert.glsl.vert
build	Build and Test	2026-07-18T01:45:32.5749376Z /tmp/junit14734798164399824988/junit5261311143588705812/frag.glsl.frag
build	Build and Test	2026-07-18T01:45:32.7589379Z /tmp/junit14734798164399824988/junit4950514145884144541/vertui.glsl.vert
build	Build and Test	2026-07-18T01:45:32.7649327Z /tmp/junit14734798164399824988/junit4950514145884144541/fragui.glsl.frag
build	Build and Test	2026-07-18T01:45:34.4551115Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T01:45:34.8600755Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T01:45:35.0573022Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T01:45:35.0670670Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T01:45:40.7548788Z
build	Build and Test	2026-07-18T01:45:40.7569440Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T01:45:46.0533096Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784339065987.json
build	Build and Test	2026-07-18T01:45:46.1531716Z
build	Build and Test	2026-07-18T01:45:46.1532309Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T01:45:46.1532774Z
build	Build and Test	2026-07-18T01:45:46.1533036Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T01:45:46.1535934Z * What went wrong:
build	Build and Test	2026-07-18T01:45:46.1536495Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T01:45:46.1537287Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T01:45:46.1538838Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T01:45:46.1539416Z
build	Build and Test	2026-07-18T01:45:46.1539522Z * Try:
build	Build and Test	2026-07-18T01:45:46.1539787Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T01:45:46.1540021Z
build	Build and Test	2026-07-18T01:45:46.1540134Z BUILD FAILED in 1m 29s
build	Build and Test	2026-07-18T01:45:46.6336192Z ##[error]Process completed with exit code 1.
```

## Install release preview homepage: Add release-preview installer driver

- Run: [29625763460](https://github.com/KSPOG/klite/actions/runs/29625763460)
- Conclusion: `failure`
- Event: `push`
- Commit: `7141170b7fce59a176d189927aab969afbaa1f68`
- Created: `2026-07-18T01:44:00Z`

### Failed jobs and steps

No failed job metadata was returned.

### Relevant log context

```text

failed to get run log: log not found
```

## CI: Fix release-preview homepage installer workflow

- Run: [29625545917](https://github.com/KSPOG/klite/actions/runs/29625545917)
- Conclusion: `failure`
- Event: `push`
- Commit: `45f817511b0cc2ae8b5a655e027623481e08df95`
- Created: `2026-07-18T01:37:15Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T01:37:49.3171924Z > Task :copper-tin-miner:jar
build	Build and Test	2026-07-18T01:37:49.3201935Z > Task :copper-tin-miner:assemble
build	Build and Test	2026-07-18T01:37:49.6114857Z > Task :copper-tin-miner:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-18T01:37:49.6116330Z > Task :copper-tin-miner:compileTestJava NO-SOURCE
build	Build and Test	2026-07-18T01:37:49.6117067Z > Task :copper-tin-miner:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T01:37:49.6117806Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-18T01:37:49.6118473Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-18T01:37:49.6119093Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T01:37:49.6119686Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T01:37:49.8117812Z > Task :client:jar
build	Build and Test	2026-07-18T01:37:49.8118755Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T01:37:50.0115174Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T01:37:56.0124883Z
build	Build and Test	2026-07-18T01:37:56.0134895Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T01:37:56.0136686Z > Task :client:javadoc
build	Build and Test	2026-07-18T01:37:56.0163591Z 	 * @param duration
build	Build and Test	2026-07-18T01:37:56.0182359Z 	   ^
build	Build and Test	2026-07-18T01:37:56.0200548Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T01:37:56.0222137Z 	 * @param duration
build	Build and Test	2026-07-18T01:37:56.0252053Z 	   ^
build	Build and Test	2026-07-18T01:37:56.5160299Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:37:56.5163427Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:37:56.5192163Z 	            ^
build	Build and Test	2026-07-18T01:37:56.5223285Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:37:56.5261977Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:37:56.5263200Z 	            ^
build	Build and Test	2026-07-18T01:37:56.5278930Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:37:56.5316127Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:37:56.5331931Z 	            ^
build	Build and Test	2026-07-18T01:37:56.5373062Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:37:56.5392634Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:37:56.5402082Z 	            ^
build	Build and Test	2026-07-18T01:37:56.5433290Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:37:56.5439266Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:37:56.5440673Z 	            ^
build	Build and Test	2026-07-18T01:37:56.5473041Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:37:56.5502412Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:37:56.5529137Z 	            ^
build	Build and Test	2026-07-18T01:37:56.5533065Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:37:56.5552861Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:37:56.5591925Z 	            ^
build	Build and Test	2026-07-18T01:37:56.5593633Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:37:56.5596049Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:37:56.5597289Z 	            ^
build	Build and Test	2026-07-18T01:37:56.5598940Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:37:56.5601624Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:37:56.5602855Z 	            ^
build	Build and Test	2026-07-18T01:37:56.5604303Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T01:37:56.5605928Z 	 * @param itemId
build	Build and Test	2026-07-18T01:37:56.5606371Z 	   ^
build	Build and Test	2026-07-18T01:37:56.5607754Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T01:37:56.5609315Z 	 * @return
build	Build and Test	2026-07-18T01:37:56.5609713Z 	   ^
build	Build and Test	2026-07-18T01:37:57.0144111Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T01:37:57.0144886Z 	               ^
build	Build and Test	2026-07-18T01:37:57.0146509Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T01:37:57.0148235Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T01:37:57.0148990Z 	             ^
build	Build and Test	2026-07-18T01:37:57.0150631Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T01:37:57.0152935Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T01:37:57.0153834Z 	            ^
build	Build and Test	2026-07-18T01:37:57.0155442Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T01:37:57.0157326Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T01:37:57.0158172Z 	            ^
build	Build and Test	2026-07-18T01:37:57.0159771Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T01:37:57.0161951Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T01:37:57.0162868Z 	            ^
build	Build and Test	2026-07-18T01:37:57.0164497Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T01:37:57.0166354Z 	public void select(Color color) {
build	Build and Test	2026-07-18T01:37:57.0167070Z 	            ^
build	Build and Test	2026-07-18T01:37:57.1116105Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T01:37:57.1120117Z 	 * @param dimmed
build	Build and Test	2026-07-18T01:37:57.1120760Z 	   ^
build	Build and Test	2026-07-18T01:37:57.1122588Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T01:37:57.1124717Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:37:57.1126125Z 	            ^
build	Build and Test	2026-07-18T01:37:57.1127823Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T01:37:57.1129791Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:37:57.1131045Z 	            ^
build	Build and Test	2026-07-18T01:37:57.2115375Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T01:37:57.2118688Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T01:37:57.2119757Z 		                                          ^
build	Build and Test	2026-07-18T01:38:01.3113442Z 100 warnings
build	Build and Test	2026-07-18T01:38:03.5114794Z
build	Build and Test	2026-07-18T01:38:03.5115786Z > Task :client:javadocJar
build	Build and Test	2026-07-18T01:38:03.5116741Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T01:38:08.1118979Z > Task :client:shadowJar
build	Build and Test	2026-07-18T01:38:08.1120062Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T01:38:08.1122128Z > Task :client:assemble
build	Build and Test	2026-07-18T01:38:08.4122502Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:38:08.4178211Z > Task :client:testClasses
build	Build and Test	2026-07-18T01:38:08.6120838Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T01:38:29.4122333Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T01:38:31.5213581Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T01:38:37.9122577Z /tmp/junit16125367780129481369/junit3319244019752055548/vert.glsl.vert
build	Build and Test	2026-07-18T01:38:37.9192490Z /tmp/junit16125367780129481369/junit3319244019752055548/frag.glsl.frag
build	Build and Test	2026-07-18T01:38:38.1132531Z /tmp/junit16125367780129481369/junit13907967638594005852/vertui.glsl.vert
build	Build and Test	2026-07-18T01:38:38.1142420Z /tmp/junit16125367780129481369/junit13907967638594005852/fragui.glsl.frag
build	Build and Test	2026-07-18T01:38:38.1192869Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T01:38:38.5114385Z > Task :client:pmdMain
build	Build and Test	2026-07-18T01:38:38.6132419Z > Task :client:test
build	Build and Test	2026-07-18T01:38:41.9131905Z
build	Build and Test	2026-07-18T01:38:41.9146136Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T01:38:42.2163676Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T01:38:42.4154155Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T01:38:42.4243927Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T01:38:48.8120532Z
build	Build and Test	2026-07-18T01:38:48.8152106Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T01:38:53.5114830Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784338655841.json
build	Build and Test	2026-07-18T01:38:53.6112998Z
build	Build and Test	2026-07-18T01:38:53.6113681Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T01:38:53.6114164Z
build	Build and Test	2026-07-18T01:38:53.6114358Z * What went wrong:
build	Build and Test	2026-07-18T01:38:53.6114849Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T01:38:53.6115579Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T01:38:53.6116567Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T01:38:53.6117183Z
build	Build and Test	2026-07-18T01:38:53.6117603Z * Try:
build	Build and Test	2026-07-18T01:38:53.6117887Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T01:38:53.6118139Z
build	Build and Test	2026-07-18T01:38:53.6118261Z BUILD FAILED in 1m 25s
build	Build and Test	2026-07-18T01:38:53.6118601Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T01:38:54.0565866Z ##[error]Process completed with exit code 1.
```

## Install release preview homepage: Fix release-preview homepage installer workflow

- Run: [29625545550](https://github.com/KSPOG/klite/actions/runs/29625545550)
- Conclusion: `failure`
- Event: `push`
- Commit: `45f817511b0cc2ae8b5a655e027623481e08df95`
- Created: `2026-07-18T01:37:15Z`

### Failed jobs and steps

No failed job metadata was returned.

### Relevant log context

```text

failed to get run log: log not found
```

## CI: Deploy completed KLite release-preview homepage

- Run: [29625073765](https://github.com/KSPOG/klite/actions/runs/29625073765)
- Conclusion: `failure`
- Event: `push`
- Commit: `3de1828e1e2793c8febf3a09a881d9d95eca868e`
- Created: `2026-07-18T01:22:37Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T01:23:21.9124744Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T01:23:21.9125415Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T01:23:22.0048291Z > Task :client:jar
build	Build and Test	2026-07-18T01:23:22.0056027Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T01:23:22.3089888Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T01:23:22.5079945Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:23:22.5109517Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T01:23:22.5127453Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T01:23:22.6034214Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T01:23:22.6049568Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T01:23:22.6069485Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T01:23:22.6089461Z > Task :runelite-api:build
build	Build and Test	2026-07-18T01:23:28.6050954Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T01:23:28.6052624Z 	 * @param duration
build	Build and Test	2026-07-18T01:23:28.6053083Z 	   ^
build	Build and Test	2026-07-18T01:23:28.6054434Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T01:23:28.6056049Z 	 * @param duration
build	Build and Test	2026-07-18T01:23:28.6056518Z 	   ^
build	Build and Test	2026-07-18T01:23:28.6056742Z
build	Build and Test	2026-07-18T01:23:28.6057167Z > Task :client:javadoc
build	Build and Test	2026-07-18T01:23:29.2047339Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:23:29.2070201Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:23:29.2071670Z 	            ^
build	Build and Test	2026-07-18T01:23:29.2073528Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:23:29.2075979Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:23:29.2077239Z 	            ^
build	Build and Test	2026-07-18T01:23:29.2079091Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:23:29.2081404Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:23:29.2082633Z 	            ^
build	Build and Test	2026-07-18T01:23:29.2084193Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:23:29.2086458Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:23:29.2087825Z 	            ^
build	Build and Test	2026-07-18T01:23:29.2089978Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:23:29.2102852Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:23:29.2103863Z 	            ^
build	Build and Test	2026-07-18T01:23:29.2105205Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:23:29.2107180Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:23:29.2108165Z 	            ^
build	Build and Test	2026-07-18T01:23:29.2109587Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:23:29.2111414Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:23:29.2112426Z 	            ^
build	Build and Test	2026-07-18T01:23:29.2113853Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:23:29.2115876Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:23:29.2116856Z 	            ^
build	Build and Test	2026-07-18T01:23:29.2118181Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:23:29.2120317Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:23:29.2121303Z 	            ^
build	Build and Test	2026-07-18T01:23:29.2122486Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T01:23:29.2123792Z 	 * @param itemId
build	Build and Test	2026-07-18T01:23:29.2124156Z 	   ^
build	Build and Test	2026-07-18T01:23:29.2125305Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T01:23:29.2126660Z 	 * @return
build	Build and Test	2026-07-18T01:23:29.2127040Z 	   ^
build	Build and Test	2026-07-18T01:23:29.7072215Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T01:23:29.7072776Z 	               ^
build	Build and Test	2026-07-18T01:23:29.7074123Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T01:23:29.7075601Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T01:23:29.7076180Z 	             ^
build	Build and Test	2026-07-18T01:23:29.7077626Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T01:23:29.7079617Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T01:23:29.7080339Z 	            ^
build	Build and Test	2026-07-18T01:23:29.7081762Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T01:23:29.7083401Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T01:23:29.7084052Z 	            ^
build	Build and Test	2026-07-18T01:23:29.7085457Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T01:23:29.7087166Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T01:23:29.7087847Z 	            ^
build	Build and Test	2026-07-18T01:23:29.8034264Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T01:23:29.8036974Z 	public void select(Color color) {
build	Build and Test	2026-07-18T01:23:29.8043807Z 	            ^
build	Build and Test	2026-07-18T01:23:29.8045670Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T01:23:29.8047859Z 	 * @param dimmed
build	Build and Test	2026-07-18T01:23:29.8048553Z 	   ^
build	Build and Test	2026-07-18T01:23:29.9033157Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T01:23:29.9041490Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:23:29.9042394Z 	            ^
build	Build and Test	2026-07-18T01:23:29.9044047Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T01:23:29.9045979Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:23:29.9046830Z 	            ^
build	Build and Test	2026-07-18T01:23:30.0032940Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T01:23:30.0036217Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T01:23:30.0037284Z 		                                          ^
build	Build and Test	2026-07-18T01:23:34.5031746Z 100 warnings
build	Build and Test	2026-07-18T01:23:37.0042154Z
build	Build and Test	2026-07-18T01:23:37.0043121Z > Task :client:javadocJar
build	Build and Test	2026-07-18T01:23:37.0044031Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T01:23:41.8041436Z > Task :client:shadowJar
build	Build and Test	2026-07-18T01:23:41.8042330Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T01:23:41.8043154Z > Task :client:assemble
build	Build and Test	2026-07-18T01:23:42.1033811Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:23:42.1059615Z > Task :client:testClasses
build	Build and Test	2026-07-18T01:23:42.3091457Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T01:24:03.0052439Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T01:24:05.7041264Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T01:24:11.5031024Z /tmp/junit13784656828790185448/junit17550443512662811832/vert.glsl.vert
build	Build and Test	2026-07-18T01:24:11.5075283Z /tmp/junit13784656828790185448/junit17550443512662811832/frag.glsl.frag
build	Build and Test	2026-07-18T01:24:11.7100202Z /tmp/junit13784656828790185448/junit14158380588200768140/vertui.glsl.vert
build	Build and Test	2026-07-18T01:24:11.7169853Z /tmp/junit13784656828790185448/junit14158380588200768140/fragui.glsl.frag
build	Build and Test	2026-07-18T01:24:11.8031298Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T01:24:12.2089761Z > Task :client:pmdMain
build	Build and Test	2026-07-18T01:24:12.3069774Z > Task :client:test
build	Build and Test	2026-07-18T01:24:16.0049350Z
build	Build and Test	2026-07-18T01:24:16.0081134Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T01:24:16.3060908Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T01:24:16.5051343Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T01:24:16.5140975Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T01:24:23.6031271Z
build	Build and Test	2026-07-18T01:24:23.6039565Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T01:24:28.5060327Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784337789243.json
build	Build and Test	2026-07-18T01:24:28.6030649Z
build	Build and Test	2026-07-18T01:24:28.6031443Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T01:24:28.6031914Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T01:24:28.6032438Z
build	Build and Test	2026-07-18T01:24:28.6032927Z * What went wrong:
build	Build and Test	2026-07-18T01:24:28.6033749Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T01:24:28.6034943Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T01:24:28.6036656Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T01:24:28.6037519Z
build	Build and Test	2026-07-18T01:24:28.6037813Z * Try:
build	Build and Test	2026-07-18T01:24:28.6038478Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T01:24:28.6039159Z
build	Build and Test	2026-07-18T01:24:28.6039485Z BUILD FAILED in 1m 27s
build	Build and Test	2026-07-18T01:24:29.0910727Z ##[error]Process completed with exit code 1.
```

## Install release preview homepage: Deploy completed KLite release-preview homepage

- Run: [29625073341](https://github.com/KSPOG/klite/actions/runs/29625073341)
- Conclusion: `failure`
- Event: `push`
- Commit: `3de1828e1e2793c8febf3a09a881d9d95eca868e`
- Created: `2026-07-18T01:22:36Z`

### Failed jobs and steps

No failed job metadata was returned.

### Relevant log context

```text

failed to get run log: log not found
```

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29625061570](https://github.com/KSPOG/klite/actions/runs/29625061570)
- Conclusion: `failure`
- Event: `workflow_run`
- Commit: `95949644c17f627b58c7f87a8613a9e169ea8306`
- Created: `2026-07-18T01:22:14Z`

### Failed jobs and steps

- **diagnose** — `failure`
  - Step 4: **Publish diagnostic report** — `failure`

### Relevant log context

```text
diagnose	Publish diagnostic report	﻿2026-07-18T01:22:57.9736403Z ##[group]Run set -euo pipefail
diagnose	Publish diagnostic report	2026-07-18T01:22:57.9736789Z ^[[36;1mset -euo pipefail^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:22:57.9737087Z ^[[36;1mgit config user.name "github-actions[bot]"^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:22:57.9737559Z ^[[36;1mgit config user.email "41898282+github-actions[bot]@users.noreply.github.com"^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:22:57.9738088Z ^[[36;1mgit add diagnostics/latest-workflow-failures.md^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:22:57.9806297Z ^[[36;1mif git diff --cached --quiet; then^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:22:57.9806690Z ^[[36;1m  echo "The failure report did not change."^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:22:57.9806999Z ^[[36;1m  exit 0^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:22:57.9807200Z ^[[36;1mfi^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:22:57.9807518Z ^[[36;1mgit commit -m "Update workflow failure diagnostics [skip ci]"^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:22:57.9807930Z ^[[36;1mgit push^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:22:57.9870287Z shell: /usr/bin/bash --noprofile --norc -e -o pipefail {0}
diagnose	Publish diagnostic report	2026-07-18T01:22:57.9870669Z ##[endgroup]
diagnose	Publish diagnostic report	2026-07-18T01:22:58.1575097Z [main d03cd0bdf] Update workflow failure diagnostics [skip ci]
diagnose	Publish diagnostic report	2026-07-18T01:22:58.1576028Z  1 file changed, 316 insertions(+), 317 deletions(-)
diagnose	Publish diagnostic report	2026-07-18T01:22:58.5131446Z To https://github.com/KSPOG/klite
diagnose	Publish diagnostic report	2026-07-18T01:22:58.5132067Z  ! [rejected]            main -> main (fetch first)
diagnose	Publish diagnostic report	2026-07-18T01:22:58.5132648Z error: failed to push some refs to 'https://github.com/KSPOG/klite'
diagnose	Publish diagnostic report	2026-07-18T01:22:58.5143049Z hint: Updates were rejected because the remote contains work that you do not
diagnose	Publish diagnostic report	2026-07-18T01:22:58.5143890Z hint: have locally. This is usually caused by another repository pushing to
diagnose	Publish diagnostic report	2026-07-18T01:22:58.5144405Z hint: the same ref. If you want to integrate the remote changes, use
diagnose	Publish diagnostic report	2026-07-18T01:22:58.5145025Z hint: 'git pull' before pushing again.
diagnose	Publish diagnostic report	2026-07-18T01:22:58.5145889Z hint: See the 'Note about fast-forwards' in 'git push --help' for details.
diagnose	Publish diagnostic report	2026-07-18T01:22:58.5158644Z ##[error]Process completed with exit code 1.
```

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29625061217](https://github.com/KSPOG/klite/actions/runs/29625061217)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `95949644c17f627b58c7f87a8613a9e169ea8306`
- Created: `2026-07-18T01:22:13Z`

### Failed jobs and steps

- **diagnose** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## CI: Install the release-preview homepage structure

- Run: [29625015246](https://github.com/KSPOG/klite/actions/runs/29625015246)
- Conclusion: `failure`
- Event: `push`
- Commit: `95949644c17f627b58c7f87a8613a9e169ea8306`
- Created: `2026-07-18T01:20:46Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T01:21:12.7666113Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T01:21:12.7695722Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T01:21:12.9633805Z > Task :client:jar
build	Build and Test	2026-07-18T01:21:12.9666132Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T01:21:13.2611298Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:21:13.2643759Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T01:21:13.2666035Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T01:21:13.2725767Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T01:21:13.2726903Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T01:21:13.3616085Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T01:21:13.3616850Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T01:21:13.3617580Z > Task :runelite-api:build
build	Build and Test	2026-07-18T01:21:17.7635388Z
build	Build and Test	2026-07-18T01:21:17.7646791Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T01:21:17.7648060Z > Task :client:javadoc
build	Build and Test	2026-07-18T01:21:17.7675901Z 	 * @param duration
build	Build and Test	2026-07-18T01:21:17.7676571Z 	   ^
build	Build and Test	2026-07-18T01:21:17.7677863Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T01:21:17.7706119Z 	 * @param duration
build	Build and Test	2026-07-18T01:21:17.7745553Z 	   ^
build	Build and Test	2026-07-18T01:21:18.1677279Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:21:18.1716681Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:21:18.1755787Z 	            ^
build	Build and Test	2026-07-18T01:21:18.1816790Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:21:18.1831568Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:21:18.1885507Z 	            ^
build	Build and Test	2026-07-18T01:21:18.1946353Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:21:18.2005931Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:21:18.2007243Z 	            ^
build	Build and Test	2026-07-18T01:21:18.2036494Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:21:18.2049467Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:21:18.2065604Z 	            ^
build	Build and Test	2026-07-18T01:21:18.2096464Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:21:18.2126372Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:21:18.2155981Z 	            ^
build	Build and Test	2026-07-18T01:21:18.2176703Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:21:18.2178798Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:21:18.2200707Z 	            ^
build	Build and Test	2026-07-18T01:21:18.2203181Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:21:18.2205204Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:21:18.2207843Z 	            ^
build	Build and Test	2026-07-18T01:21:18.2209280Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:21:18.2211032Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:21:18.2212122Z 	            ^
build	Build and Test	2026-07-18T01:21:18.2213375Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:21:18.2215370Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:21:18.2216500Z 	            ^
build	Build and Test	2026-07-18T01:21:18.2217625Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T01:21:18.2233704Z 	 * @param itemId
build	Build and Test	2026-07-18T01:21:18.2234396Z 	   ^
build	Build and Test	2026-07-18T01:21:18.2235767Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T01:21:18.2237025Z 	 * @return
build	Build and Test	2026-07-18T01:21:18.2237562Z 	   ^
build	Build and Test	2026-07-18T01:21:18.5714594Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T01:21:18.5739987Z 	               ^
build	Build and Test	2026-07-18T01:21:18.5772170Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T01:21:18.5782381Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T01:21:18.5805805Z 	             ^
build	Build and Test	2026-07-18T01:21:18.5836244Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T01:21:18.5866058Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T01:21:18.5875743Z 	            ^
build	Build and Test	2026-07-18T01:21:18.5877211Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T01:21:18.5878625Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T01:21:18.5879370Z 	            ^
build	Build and Test	2026-07-18T01:21:18.5880661Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T01:21:18.5882102Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T01:21:18.5882828Z 	            ^
build	Build and Test	2026-07-18T01:21:18.6617157Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T01:21:18.6636137Z 	public void select(Color color) {
build	Build and Test	2026-07-18T01:21:18.6636867Z 	            ^
build	Build and Test	2026-07-18T01:21:18.6638256Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T01:21:18.6639900Z 	 * @param dimmed
build	Build and Test	2026-07-18T01:21:18.6640466Z 	   ^
build	Build and Test	2026-07-18T01:21:18.7606257Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T01:21:18.7608401Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:21:18.7609252Z 	            ^
build	Build and Test	2026-07-18T01:21:18.7610554Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T01:21:18.7611822Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:21:18.7612529Z 	            ^
build	Build and Test	2026-07-18T01:21:18.7613625Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T01:21:18.8608789Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T01:21:18.8628924Z 		                                          ^
build	Build and Test	2026-07-18T01:21:22.6605420Z 100 warnings
build	Build and Test	2026-07-18T01:21:24.6606554Z
build	Build and Test	2026-07-18T01:21:24.6608270Z > Task :client:javadocJar
build	Build and Test	2026-07-18T01:21:24.6609080Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T01:21:28.8608181Z > Task :client:shadowJar
build	Build and Test	2026-07-18T01:21:28.8626222Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T01:21:28.8628931Z > Task :client:assemble
build	Build and Test	2026-07-18T01:21:29.2646716Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:21:29.2665416Z > Task :client:testClasses
build	Build and Test	2026-07-18T01:21:29.4616230Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T01:21:45.4605574Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T01:21:48.6685201Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T01:21:50.1627752Z /tmp/junit487144925063875188/junit4113074715057593355/vert.glsl.vert
build	Build and Test	2026-07-18T01:21:50.1665117Z /tmp/junit487144925063875188/junit4113074715057593355/frag.glsl.frag
build	Build and Test	2026-07-18T01:21:50.2605229Z /tmp/junit487144925063875188/junit14448847149242787263/vertui.glsl.vert
build	Build and Test	2026-07-18T01:21:50.2668719Z /tmp/junit487144925063875188/junit14448847149242787263/fragui.glsl.frag
build	Build and Test	2026-07-18T01:21:56.1626983Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T01:21:56.2637244Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T01:21:56.4616344Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T01:21:56.4774964Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T01:21:58.8626111Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T01:21:59.2606208Z > Task :client:pmdMain
build	Build and Test	2026-07-18T01:21:59.4646714Z > Task :client:test
build	Build and Test	2026-07-18T01:22:00.8606012Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T01:22:03.9605906Z
build	Build and Test	2026-07-18T01:22:03.9606977Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T01:22:03.9607443Z
build	Build and Test	2026-07-18T01:22:03.9607647Z * What went wrong:
build	Build and Test	2026-07-18T01:22:03.9608151Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T01:22:03.9609310Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T01:22:03.9610429Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T01:22:03.9611054Z
build	Build and Test	2026-07-18T01:22:03.9611246Z * Try:
build	Build and Test	2026-07-18T01:22:03.9611782Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T01:22:03.9612130Z
build	Build and Test	2026-07-18T01:22:03.9612518Z BUILD FAILED in 1m 3s
build	Build and Test	2026-07-18T01:22:03.9613404Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784337663260.json
build	Build and Test	2026-07-18T01:22:03.9614373Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T01:22:04.4207026Z ##[error]Process completed with exit code 1.
```

