# Recent GitHub Actions failures

Generated: 2026-07-18T02:40:48.185313+00:00
Repository: `KSPOG/klite`
Failed runs inspected: **15**

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29627456022](https://github.com/KSPOG/klite/actions/runs/29627456022)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `65e7e93df59d231e1e61df2e73a3e3a9785eb00c`
- Created: `2026-07-18T02:40:26Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 2: **Check out repository** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## CI: Guard account route observer against self-triggering

- Run: [29627403467](https://github.com/KSPOG/klite/actions/runs/29627403467)
- Conclusion: `failure`
- Event: `push`
- Commit: `65e7e93df59d231e1e61df2e73a3e3a9785eb00c`
- Created: `2026-07-18T02:38:42Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T02:39:16.8160955Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T02:39:16.8191090Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T02:39:16.9112281Z > Task :client:jar
build	Build and Test	2026-07-18T02:39:16.9120935Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T02:39:17.3118498Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T02:39:17.3121481Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T02:39:17.3122324Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T02:39:17.3123107Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T02:39:17.3123866Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T02:39:17.3124600Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T02:39:17.3125274Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T02:39:17.3125973Z > Task :runelite-api:build
build	Build and Test	2026-07-18T02:39:24.1112937Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T02:39:24.1114477Z 	 * @param duration
build	Build and Test	2026-07-18T02:39:24.1114753Z
build	Build and Test	2026-07-18T02:39:24.1115138Z 	   ^
build	Build and Test	2026-07-18T02:39:24.1116637Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T02:39:24.1118231Z 	 * @param duration
build	Build and Test	2026-07-18T02:39:24.1118713Z 	   ^
build	Build and Test	2026-07-18T02:39:24.1131421Z > Task :client:javadoc
build	Build and Test	2026-07-18T02:39:24.6104519Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:39:24.6118595Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:39:24.6143297Z 	            ^
build	Build and Test	2026-07-18T02:39:24.6152138Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:39:24.6181562Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:39:24.6182573Z 	            ^
build	Build and Test	2026-07-18T02:39:24.6184011Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:39:24.6186048Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:39:24.6187053Z 	            ^
build	Build and Test	2026-07-18T02:39:24.6188322Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:39:24.6190314Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:39:24.6191564Z 	            ^
build	Build and Test	2026-07-18T02:39:24.6193034Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:39:24.6195611Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:39:24.6196631Z 	            ^
build	Build and Test	2026-07-18T02:39:24.6198035Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:39:24.6200078Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:39:24.6201476Z 	            ^
build	Build and Test	2026-07-18T02:39:24.6202703Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:39:24.6204585Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:39:24.6205612Z 	            ^
build	Build and Test	2026-07-18T02:39:24.6207141Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:39:24.6225371Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:39:24.6238964Z 	            ^
build	Build and Test	2026-07-18T02:39:24.6272041Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:39:24.6331650Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:39:24.6391100Z 	            ^
build	Build and Test	2026-07-18T02:39:24.6422016Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T02:39:24.6423447Z 	 * @param itemId
build	Build and Test	2026-07-18T02:39:24.6423866Z 	   ^
build	Build and Test	2026-07-18T02:39:24.6425184Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T02:39:24.6426564Z 	 * @return
build	Build and Test	2026-07-18T02:39:24.6426967Z 	   ^
build	Build and Test	2026-07-18T02:39:25.1528607Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T02:39:25.1529290Z 	               ^
build	Build and Test	2026-07-18T02:39:25.1530862Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T02:39:25.1532412Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T02:39:25.1533116Z 	             ^
build	Build and Test	2026-07-18T02:39:25.1534725Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T02:39:25.1536505Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T02:39:25.1537310Z 	            ^
build	Build and Test	2026-07-18T02:39:25.1538794Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T02:39:25.1540650Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T02:39:25.1541424Z 	            ^
build	Build and Test	2026-07-18T02:39:25.1542893Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T02:39:25.1544678Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T02:39:25.1545502Z 	            ^
build	Build and Test	2026-07-18T02:39:25.2096229Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T02:39:25.2105944Z 	public void select(Color color) {
build	Build and Test	2026-07-18T02:39:25.2106775Z 	            ^
build	Build and Test	2026-07-18T02:39:25.3083296Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T02:39:25.3095346Z 	 * @param dimmed
build	Build and Test	2026-07-18T02:39:25.3096079Z 	   ^
build	Build and Test	2026-07-18T02:39:25.3097528Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T02:39:25.3099785Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:39:25.3100976Z 	            ^
build	Build and Test	2026-07-18T02:39:25.3102576Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T02:39:25.3104653Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:39:25.3105492Z 	            ^
build	Build and Test	2026-07-18T02:39:25.4084186Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T02:39:25.4088561Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T02:39:25.4089515Z 		                                          ^
build	Build and Test	2026-07-18T02:39:30.1082133Z 100 warnings
build	Build and Test	2026-07-18T02:39:32.6101202Z
build	Build and Test	2026-07-18T02:39:32.6121908Z > Task :client:javadocJar
build	Build and Test	2026-07-18T02:39:32.6142688Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T02:39:37.4083036Z > Task :client:shadowJar
build	Build and Test	2026-07-18T02:39:37.4084073Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T02:39:37.4084907Z > Task :client:assemble
build	Build and Test	2026-07-18T02:39:37.8091770Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T02:39:37.8141859Z > Task :client:testClasses
build	Build and Test	2026-07-18T02:39:37.9114735Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T02:39:56.6099455Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T02:40:00.3123150Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T02:40:07.4081932Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T02:40:07.8081693Z > Task :client:pmdMain
build	Build and Test	2026-07-18T02:40:07.9111697Z > Task :client:test
build	Build and Test	2026-07-18T02:40:09.1100975Z
build	Build and Test	2026-07-18T02:40:09.1122362Z /tmp/junit10327584977549075708/junit6733095243045609883/vert.glsl.vert
build	Build and Test	2026-07-18T02:40:09.1153319Z /tmp/junit10327584977549075708/junit6733095243045609883/frag.glsl.frag
build	Build and Test	2026-07-18T02:40:09.3091775Z /tmp/junit10327584977549075708/junit12678063395479957610/vertui.glsl.vert
build	Build and Test	2026-07-18T02:40:09.3212381Z /tmp/junit10327584977549075708/junit12678063395479957610/fragui.glsl.frag
build	Build and Test	2026-07-18T02:40:10.3112820Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T02:40:10.6104634Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T02:40:10.7113152Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T02:40:10.7173409Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T02:40:17.1101032Z
build	Build and Test	2026-07-18T02:40:17.1114566Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T02:40:23.0082837Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784342344129.json
build	Build and Test	2026-07-18T02:40:23.0086655Z
build	Build and Test	2026-07-18T02:40:23.0086923Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T02:40:23.0088754Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T02:40:23.0089344Z
build	Build and Test	2026-07-18T02:40:23.0089688Z * What went wrong:
build	Build and Test	2026-07-18T02:40:23.0090350Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T02:40:23.0091650Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T02:40:23.0093236Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T02:40:23.0094646Z
build	Build and Test	2026-07-18T02:40:23.0094966Z * Try:
build	Build and Test	2026-07-18T02:40:23.0095521Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T02:40:23.0096051Z
build	Build and Test	2026-07-18T02:40:23.0096394Z BUILD FAILED in 1m 26s
build	Build and Test	2026-07-18T02:40:23.5062338Z ##[error]Process completed with exit code 1.
```

## CI: Stop marketplace credit render feedback loop

- Run: [29627396258](https://github.com/KSPOG/klite/actions/runs/29627396258)
- Conclusion: `failure`
- Event: `push`
- Commit: `1e1f720f225b6f049cb46338f4ff301b31d938de`
- Created: `2026-07-18T02:38:24Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T02:39:09.2837326Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T02:39:09.2877252Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T02:39:09.6677571Z > Task :client:jar
build	Build and Test	2026-07-18T02:39:09.6678496Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T02:39:09.9727966Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T02:39:09.9757492Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T02:39:09.9777522Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T02:39:09.9778550Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T02:39:10.0677985Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T02:39:10.0707297Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T02:39:10.0737182Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T02:39:10.0763674Z > Task :runelite-api:build
build	Build and Test	2026-07-18T02:39:16.5686438Z
build	Build and Test	2026-07-18T02:39:16.5693360Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T02:39:16.5695015Z > Task :client:javadoc
build	Build and Test	2026-07-18T02:39:16.5727461Z 	 * @param duration
build	Build and Test	2026-07-18T02:39:16.5737506Z 	   ^
build	Build and Test	2026-07-18T02:39:16.5738968Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T02:39:16.5740615Z 	 * @param duration
build	Build and Test	2026-07-18T02:39:16.5741087Z 	   ^
build	Build and Test	2026-07-18T02:39:17.0709667Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:39:17.0730918Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:39:17.0757197Z 	            ^
build	Build and Test	2026-07-18T02:39:17.0800412Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:39:17.0827829Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:39:17.0857257Z 	            ^
build	Build and Test	2026-07-18T02:39:17.0881815Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:39:17.0908893Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:39:17.0919050Z 	            ^
build	Build and Test	2026-07-18T02:39:17.0920065Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:39:17.0921349Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:39:17.0922025Z 	            ^
build	Build and Test	2026-07-18T02:39:17.0922931Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:39:17.0925754Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:39:17.0927168Z 	            ^
build	Build and Test	2026-07-18T02:39:17.0929346Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:39:17.0931795Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:39:17.0933066Z 	            ^
build	Build and Test	2026-07-18T02:39:17.0934557Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:39:17.0937077Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:39:17.0938378Z 	            ^
build	Build and Test	2026-07-18T02:39:17.0940098Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:39:17.0942573Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:39:17.0943821Z 	            ^
build	Build and Test	2026-07-18T02:39:17.0945465Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:39:17.0948159Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:39:17.0949399Z 	            ^
build	Build and Test	2026-07-18T02:39:17.0950854Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T02:39:17.0952468Z 	 * @param itemId
build	Build and Test	2026-07-18T02:39:17.0952938Z 	   ^
build	Build and Test	2026-07-18T02:39:17.0954361Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T02:39:17.0955951Z 	 * @return
build	Build and Test	2026-07-18T02:39:17.0956382Z 	   ^
build	Build and Test	2026-07-18T02:39:17.5731282Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T02:39:17.5732022Z 	               ^
build	Build and Test	2026-07-18T02:39:17.5733522Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T02:39:17.5735155Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T02:39:17.5735879Z 	             ^
build	Build and Test	2026-07-18T02:39:17.5737667Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T02:39:17.5739585Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T02:39:17.5740477Z 	            ^
build	Build and Test	2026-07-18T02:39:17.5742025Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T02:39:17.5743844Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T02:39:17.5744667Z 	            ^
build	Build and Test	2026-07-18T02:39:17.5746245Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T02:39:17.5748364Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T02:39:17.5749213Z 	            ^
build	Build and Test	2026-07-18T02:39:17.5750759Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T02:39:17.5752576Z 	public void select(Color color) {
build	Build and Test	2026-07-18T02:39:17.5753336Z 	            ^
build	Build and Test	2026-07-18T02:39:17.6678814Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T02:39:17.6680907Z 	 * @param dimmed
build	Build and Test	2026-07-18T02:39:17.6681382Z 	   ^
build	Build and Test	2026-07-18T02:39:17.7668622Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T02:39:17.7670658Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:39:17.7671585Z 	            ^
build	Build and Test	2026-07-18T02:39:17.7673204Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T02:39:17.7675090Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:39:17.7675908Z 	            ^
build	Build and Test	2026-07-18T02:39:17.7677693Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T02:39:17.7679704Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T02:39:17.7680668Z 		                                          ^
build	Build and Test	2026-07-18T02:39:22.0665833Z 100 warnings
build	Build and Test	2026-07-18T02:39:24.4667290Z
build	Build and Test	2026-07-18T02:39:24.4668551Z > Task :client:javadocJar
build	Build and Test	2026-07-18T02:39:24.4669362Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T02:39:28.9670373Z > Task :client:shadowJar
build	Build and Test	2026-07-18T02:39:28.9671371Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T02:39:28.9672201Z > Task :client:assemble
build	Build and Test	2026-07-18T02:39:29.2717911Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T02:39:29.2745585Z > Task :client:testClasses
build	Build and Test	2026-07-18T02:39:29.5673970Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T02:39:50.2707834Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T02:39:52.8679091Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T02:39:57.2666184Z /tmp/junit5230050592239675776/junit13980875346885491487/vert.glsl.vert
build	Build and Test	2026-07-18T02:39:57.2757672Z /tmp/junit5230050592239675776/junit13980875346885491487/frag.glsl.frag
build	Build and Test	2026-07-18T02:39:57.3672033Z /tmp/junit5230050592239675776/junit18246237196306006261/vertui.glsl.vert
build	Build and Test	2026-07-18T02:39:57.3727499Z /tmp/junit5230050592239675776/junit18246237196306006261/fragui.glsl.frag
build	Build and Test	2026-07-18T02:39:58.9687793Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T02:39:59.3677789Z > Task :client:pmdMain
build	Build and Test	2026-07-18T02:39:59.5687797Z > Task :client:test
build	Build and Test	2026-07-18T02:40:02.9687189Z
build	Build and Test	2026-07-18T02:40:02.9748873Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T02:40:03.3695302Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T02:40:03.4729318Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T02:40:03.5667780Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T02:40:09.2707320Z
build	Build and Test	2026-07-18T02:40:09.2737747Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T02:40:14.0667897Z
build	Build and Test	2026-07-18T02:40:14.0669021Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784342337029.json
build	Build and Test	2026-07-18T02:40:14.0673509Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T02:40:14.0674165Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T02:40:14.0675080Z
build	Build and Test	2026-07-18T02:40:14.0675439Z * What went wrong:
build	Build and Test	2026-07-18T02:40:14.0676084Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T02:40:14.0677352Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T02:40:14.0678911Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T02:40:14.0679956Z
build	Build and Test	2026-07-18T02:40:14.0680266Z * Try:
build	Build and Test	2026-07-18T02:40:14.0680831Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T02:40:14.0681341Z
build	Build and Test	2026-07-18T02:40:14.0681665Z BUILD FAILED in 1m 25s
build	Build and Test	2026-07-18T02:40:14.5931719Z ##[error]Process completed with exit code 1.
```

## CI: Document private marketplace credits deployment

- Run: [29627177373](https://github.com/KSPOG/klite/actions/runs/29627177373)
- Conclusion: `failure`
- Event: `push`
- Commit: `f1642a54d3b32204d7f29c6b812b81e8ae4483e0`
- Created: `2026-07-18T02:30:51Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T02:31:25.7289484Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T02:31:25.7290263Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T02:31:26.0307776Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T02:31:26.0325556Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T02:31:26.0349818Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T02:31:26.0364768Z > Task :client:jar
build	Build and Test	2026-07-18T02:31:26.0365704Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T02:31:26.0366698Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T02:31:26.1265577Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T02:31:26.1267247Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T02:31:26.1268151Z > Task :runelite-api:build
build	Build and Test	2026-07-18T02:31:26.2264898Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T02:31:31.2269926Z
build	Build and Test	2026-07-18T02:31:31.2285381Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T02:31:31.2299510Z > Task :client:javadoc
build	Build and Test	2026-07-18T02:31:31.2300346Z 	 * @param duration
build	Build and Test	2026-07-18T02:31:31.2323635Z 	   ^
build	Build and Test	2026-07-18T02:31:31.2340208Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T02:31:31.2374908Z 	 * @param duration
build	Build and Test	2026-07-18T02:31:31.2395047Z 	   ^
build	Build and Test	2026-07-18T02:31:31.6268435Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:31:31.6298076Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:31:31.6325264Z 	            ^
build	Build and Test	2026-07-18T02:31:31.6356184Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:31:31.6358522Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:31:31.6370736Z 	            ^
build	Build and Test	2026-07-18T02:31:31.6375369Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:31:31.6377811Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:31:31.6378964Z 	            ^
build	Build and Test	2026-07-18T02:31:31.6380939Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:31:31.6383012Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:31:31.6415126Z 	            ^
build	Build and Test	2026-07-18T02:31:31.6445905Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:31:31.6475428Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:31:31.6476993Z 	            ^
build	Build and Test	2026-07-18T02:31:31.6505710Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:31:31.6535489Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:31:31.6564724Z 	            ^
build	Build and Test	2026-07-18T02:31:31.6566402Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:31:31.6595402Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:31:31.6605075Z 	            ^
build	Build and Test	2026-07-18T02:31:31.6606774Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:31:31.6609131Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:31:31.6610390Z 	            ^
build	Build and Test	2026-07-18T02:31:31.6611948Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:31:31.6614175Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:31:31.6615400Z 	            ^
build	Build and Test	2026-07-18T02:31:31.7264783Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T02:31:31.7345688Z 	 * @param itemId
build	Build and Test	2026-07-18T02:31:31.7382025Z 	   ^
build	Build and Test	2026-07-18T02:31:31.7383617Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T02:31:31.7385541Z 	 * @return
build	Build and Test	2026-07-18T02:31:31.7386394Z 	   ^
build	Build and Test	2026-07-18T02:31:32.1388078Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T02:31:32.1388528Z 	               ^
build	Build and Test	2026-07-18T02:31:32.1389267Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T02:31:32.1390037Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T02:31:32.1390523Z 	             ^
build	Build and Test	2026-07-18T02:31:32.1391295Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T02:31:32.1392238Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T02:31:32.1392703Z 	            ^
build	Build and Test	2026-07-18T02:31:32.1393479Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T02:31:32.1394567Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T02:31:32.1395040Z 	            ^
build	Build and Test	2026-07-18T02:31:32.1395820Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T02:31:32.1396750Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T02:31:32.1397184Z 	            ^
build	Build and Test	2026-07-18T02:31:32.2265285Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T02:31:32.2289180Z 	public void select(Color color) {
build	Build and Test	2026-07-18T02:31:32.2305294Z 	            ^
build	Build and Test	2026-07-18T02:31:32.2306959Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T02:31:32.2308816Z 	 * @param dimmed
build	Build and Test	2026-07-18T02:31:32.2309501Z 	   ^
build	Build and Test	2026-07-18T02:31:32.3268378Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T02:31:32.3295641Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:31:32.3298762Z 	            ^
build	Build and Test	2026-07-18T02:31:32.3300271Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T02:31:32.3301973Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:31:32.3302767Z 	            ^
build	Build and Test	2026-07-18T02:31:32.3304494Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T02:31:32.3306254Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T02:31:32.3307371Z 		                                          ^
build	Build and Test	2026-07-18T02:31:36.4263285Z 100 warnings
build	Build and Test	2026-07-18T02:31:38.4276442Z
build	Build and Test	2026-07-18T02:31:38.4286189Z > Task :client:javadocJar
build	Build and Test	2026-07-18T02:31:38.4287135Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T02:31:42.8279143Z > Task :client:shadowJar
build	Build and Test	2026-07-18T02:31:42.8305996Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T02:31:42.8335710Z > Task :client:assemble
build	Build and Test	2026-07-18T02:31:43.1264497Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T02:31:43.1295332Z > Task :client:testClasses
build	Build and Test	2026-07-18T02:31:43.2266106Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T02:32:01.9285948Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T02:32:02.4269228Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T02:32:10.3263483Z /tmp/junit2130965153587762132/junit2964281152531211582/vert.glsl.vert
build	Build and Test	2026-07-18T02:32:10.3295660Z /tmp/junit2130965153587762132/junit2964281152531211582/frag.glsl.frag
build	Build and Test	2026-07-18T02:32:10.5275850Z /tmp/junit2130965153587762132/junit8183762680418585085/vertui.glsl.vert
build	Build and Test	2026-07-18T02:32:10.5326353Z /tmp/junit2130965153587762132/junit8183762680418585085/fragui.glsl.frag
build	Build and Test	2026-07-18T02:32:11.4287577Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T02:32:11.6326908Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T02:32:11.8264616Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T02:32:11.8346687Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T02:32:12.8305460Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T02:32:13.1325593Z > Task :client:pmdMain
build	Build and Test	2026-07-18T02:32:13.2275438Z > Task :client:test
build	Build and Test	2026-07-18T02:32:17.0275768Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T02:32:21.6263860Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784341874332.json
build	Build and Test	2026-07-18T02:32:21.6266398Z
build	Build and Test	2026-07-18T02:32:21.6266804Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T02:32:21.6276320Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T02:32:21.6276988Z
build	Build and Test	2026-07-18T02:32:21.6277352Z * What went wrong:
build	Build and Test	2026-07-18T02:32:21.6278214Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T02:32:21.6280046Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T02:32:21.6281775Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T02:32:21.6282763Z
build	Build and Test	2026-07-18T02:32:21.6283164Z * Try:
build	Build and Test	2026-07-18T02:32:21.6283816Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T02:32:21.6284839Z
build	Build and Test	2026-07-18T02:32:21.6285244Z BUILD FAILED in 1m 11s
build	Build and Test	2026-07-18T02:32:22.0642537Z ##[error]Process completed with exit code 1.
```

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29627164433](https://github.com/KSPOG/klite/actions/runs/29627164433)
- Conclusion: `failure`
- Event: `workflow_run`
- Commit: `df96795e3cc7dc9b2efaaf841210f1b79cef5c2b`
- Created: `2026-07-18T02:30:26Z`

### Failed jobs and steps

- **diagnose** — `failure`
  - Step 4: **Publish diagnostic report** — `failure`

### Relevant log context

```text
diagnose	Publish diagnostic report	﻿2026-07-18T02:31:01.5214826Z ##[group]Run set -euo pipefail
diagnose	Publish diagnostic report	2026-07-18T02:31:01.5215196Z ^[[36;1mset -euo pipefail^[[0m
diagnose	Publish diagnostic report	2026-07-18T02:31:01.5215487Z ^[[36;1mgit config user.name "github-actions[bot]"^[[0m
diagnose	Publish diagnostic report	2026-07-18T02:31:01.5215937Z ^[[36;1mgit config user.email "41898282+github-actions[bot]@users.noreply.github.com"^[[0m
diagnose	Publish diagnostic report	2026-07-18T02:31:01.5216439Z ^[[36;1mgit add diagnostics/latest-workflow-failures.md^[[0m
diagnose	Publish diagnostic report	2026-07-18T02:31:01.5216780Z ^[[36;1mif git diff --cached --quiet; then^[[0m
diagnose	Publish diagnostic report	2026-07-18T02:31:01.5281408Z ^[[36;1m  echo "The failure report did not change."^[[0m
diagnose	Publish diagnostic report	2026-07-18T02:31:01.5281969Z ^[[36;1m  exit 0^[[0m
diagnose	Publish diagnostic report	2026-07-18T02:31:01.5282355Z ^[[36;1mfi^[[0m
diagnose	Publish diagnostic report	2026-07-18T02:31:01.5282935Z ^[[36;1mgit commit -m "Update workflow failure diagnostics [skip ci]"^[[0m
diagnose	Publish diagnostic report	2026-07-18T02:31:01.5283660Z ^[[36;1mgit push^[[0m
diagnose	Publish diagnostic report	2026-07-18T02:31:01.5349826Z shell: /usr/bin/bash --noprofile --norc -e -o pipefail {0}
diagnose	Publish diagnostic report	2026-07-18T02:31:01.5350190Z ##[endgroup]
diagnose	Publish diagnostic report	2026-07-18T02:31:01.6336046Z [main 877817f9a] Update workflow failure diagnostics [skip ci]
diagnose	Publish diagnostic report	2026-07-18T02:31:01.6336720Z  1 file changed, 1094 insertions(+), 1217 deletions(-)
diagnose	Publish diagnostic report	2026-07-18T02:31:01.8267949Z To https://github.com/KSPOG/klite
diagnose	Publish diagnostic report	2026-07-18T02:31:01.8268629Z  ! [rejected]            main -> main (fetch first)
diagnose	Publish diagnostic report	2026-07-18T02:31:01.8269235Z error: failed to push some refs to 'https://github.com/KSPOG/klite'
diagnose	Publish diagnostic report	2026-07-18T02:31:01.8279152Z hint: Updates were rejected because the remote contains work that you do not
diagnose	Publish diagnostic report	2026-07-18T02:31:01.8280083Z hint: have locally. This is usually caused by another repository pushing to
diagnose	Publish diagnostic report	2026-07-18T02:31:01.8281073Z hint: the same ref. If you want to integrate the remote changes, use
diagnose	Publish diagnostic report	2026-07-18T02:31:01.8281714Z hint: 'git pull' before pushing again.
diagnose	Publish diagnostic report	2026-07-18T02:31:01.8282348Z hint: See the 'Note about fast-forwards' in 'git push --help' for details.
diagnose	Publish diagnostic report	2026-07-18T02:31:01.8294147Z ##[error]Process completed with exit code 1.
```

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29627158553](https://github.com/KSPOG/klite/actions/runs/29627158553)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `df96795e3cc7dc9b2efaaf841210f1b79cef5c2b`
- Created: `2026-07-18T02:30:17Z`

### Failed jobs and steps

No failed job metadata was returned.

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29627138331](https://github.com/KSPOG/klite/actions/runs/29627138331)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `df96795e3cc7dc9b2efaaf841210f1b79cef5c2b`
- Created: `2026-07-18T02:29:37Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 3: **Collect recent failure details** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29627127773](https://github.com/KSPOG/klite/actions/runs/29627127773)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `df96795e3cc7dc9b2efaaf841210f1b79cef5c2b`
- Created: `2026-07-18T02:29:14Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 3: **Collect recent failure details** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## CI: Install marketplace credits and final website styling

- Run: [29627110958](https://github.com/KSPOG/klite/actions/runs/29627110958)
- Conclusion: `failure`
- Event: `push`
- Commit: `453bd22b0a457b5b4fe0ebf3e3f6f932816b0512`
- Created: `2026-07-18T02:28:37Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T02:29:12.1069355Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T02:29:12.1128546Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T02:29:12.3911097Z > Task :client:jar
build	Build and Test	2026-07-18T02:29:12.3912035Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T02:29:12.6919486Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T02:29:12.6928959Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T02:29:12.6984077Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T02:29:12.7031616Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T02:29:12.7884215Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T02:29:12.7887417Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T02:29:12.7888638Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T02:29:12.7889469Z > Task :runelite-api:build
build	Build and Test	2026-07-18T02:29:19.6885642Z
build	Build and Test	2026-07-18T02:29:19.6932340Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T02:29:19.6933973Z > Task :client:javadoc
build	Build and Test	2026-07-18T02:29:19.6958744Z 	 * @param duration
build	Build and Test	2026-07-18T02:29:19.6967766Z 	   ^
build	Build and Test	2026-07-18T02:29:19.6969790Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T02:29:19.6971618Z 	 * @param duration
build	Build and Test	2026-07-18T02:29:19.6972276Z 	   ^
build	Build and Test	2026-07-18T02:29:20.2889237Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:29:20.2969705Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:29:20.2971004Z 	            ^
build	Build and Test	2026-07-18T02:29:20.2972724Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:29:20.2975139Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:29:20.2976318Z 	            ^
build	Build and Test	2026-07-18T02:29:20.2977990Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:29:20.2980624Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:29:20.2981745Z 	            ^
build	Build and Test	2026-07-18T02:29:20.2983215Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:29:20.2985477Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:29:20.2986664Z 	            ^
build	Build and Test	2026-07-18T02:29:20.2988567Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:29:20.2991316Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:29:20.2992502Z 	            ^
build	Build and Test	2026-07-18T02:29:20.2994104Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:29:20.2996465Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:29:20.2997934Z 	            ^
build	Build and Test	2026-07-18T02:29:20.3029780Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:29:20.3031992Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:29:20.3033199Z 	            ^
build	Build and Test	2026-07-18T02:29:20.3034843Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:29:20.3037238Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:29:20.3038645Z 	            ^
build	Build and Test	2026-07-18T02:29:20.3040260Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:29:20.3042598Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:29:20.3043762Z 	            ^
build	Build and Test	2026-07-18T02:29:20.3045155Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T02:29:20.3046681Z 	 * @param itemId
build	Build and Test	2026-07-18T02:29:20.3047114Z 	   ^
build	Build and Test	2026-07-18T02:29:20.3048671Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T02:29:20.3050215Z 	 * @return
build	Build and Test	2026-07-18T02:29:20.3050593Z 	   ^
build	Build and Test	2026-07-18T02:29:20.7058769Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T02:29:20.7059491Z 	               ^
build	Build and Test	2026-07-18T02:29:20.7060861Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T02:29:20.7062498Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T02:29:20.7063245Z 	             ^
build	Build and Test	2026-07-18T02:29:20.7064811Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T02:29:20.7066604Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T02:29:20.7067426Z 	            ^
build	Build and Test	2026-07-18T02:29:20.7069181Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T02:29:20.7070960Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T02:29:20.7071776Z 	            ^
build	Build and Test	2026-07-18T02:29:20.7073291Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T02:29:20.7075179Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T02:29:20.7076113Z 	            ^
build	Build and Test	2026-07-18T02:29:20.7882230Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T02:29:20.7892411Z 	public void select(Color color) {
build	Build and Test	2026-07-18T02:29:20.7893250Z 	            ^
build	Build and Test	2026-07-18T02:29:20.7894867Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T02:29:20.7897062Z 	 * @param dimmed
build	Build and Test	2026-07-18T02:29:20.7897720Z 	   ^
build	Build and Test	2026-07-18T02:29:20.8881825Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T02:29:20.8885462Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:29:20.8886363Z 	            ^
build	Build and Test	2026-07-18T02:29:20.8888306Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T02:29:20.8890221Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:29:20.8891045Z 	            ^
build	Build and Test	2026-07-18T02:29:20.9881908Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T02:29:20.9899191Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T02:29:20.9902883Z 		                                          ^
build	Build and Test	2026-07-18T02:29:25.3879559Z 100 warnings
build	Build and Test	2026-07-18T02:29:27.5900029Z
build	Build and Test	2026-07-18T02:29:27.5907275Z > Task :client:javadocJar
build	Build and Test	2026-07-18T02:29:27.5916117Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T02:29:32.1890649Z > Task :client:shadowJar
build	Build and Test	2026-07-18T02:29:32.1898676Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T02:29:32.1903592Z > Task :client:assemble
build	Build and Test	2026-07-18T02:29:32.5887713Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T02:29:32.5903543Z > Task :client:testClasses
build	Build and Test	2026-07-18T02:29:32.7897336Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T02:29:53.6889142Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T02:29:55.5900291Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T02:30:02.1909258Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T02:30:02.6919020Z > Task :client:pmdMain
build	Build and Test	2026-07-18T02:30:02.7909277Z > Task :client:test
build	Build and Test	2026-07-18T02:30:03.1880533Z
build	Build and Test	2026-07-18T02:30:03.1909267Z /tmp/junit10616686811661844569/junit7933540487757775698/vert.glsl.vert
build	Build and Test	2026-07-18T02:30:03.1938858Z /tmp/junit10616686811661844569/junit7933540487757775698/frag.glsl.frag
build	Build and Test	2026-07-18T02:30:03.3925958Z /tmp/junit10616686811661844569/junit14802529382451747124/vertui.glsl.vert
build	Build and Test	2026-07-18T02:30:03.3967459Z /tmp/junit10616686811661844569/junit14802529382451747124/fragui.glsl.frag
build	Build and Test	2026-07-18T02:30:05.0930738Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T02:30:05.3900356Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T02:30:05.5900781Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T02:30:05.5950543Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T02:30:11.5898417Z
build	Build and Test	2026-07-18T02:30:11.5928908Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T02:30:17.5884665Z
build	Build and Test	2026-07-18T02:30:17.5885802Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784341739568.json
build	Build and Test	2026-07-18T02:30:17.5888591Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T02:30:17.5889361Z
build	Build and Test	2026-07-18T02:30:17.5889883Z * What went wrong:
build	Build and Test	2026-07-18T02:30:17.5890530Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T02:30:17.5891569Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T02:30:17.5893136Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T02:30:17.5894515Z
build	Build and Test	2026-07-18T02:30:17.5894866Z * Try:
build	Build and Test	2026-07-18T02:30:17.5895493Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T02:30:17.5896036Z
build	Build and Test	2026-07-18T02:30:17.5896389Z BUILD FAILED in 1m 26s
build	Build and Test	2026-07-18T02:30:17.5908845Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T02:30:18.1102723Z ##[error]Process completed with exit code 1.
```

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29627110666](https://github.com/KSPOG/klite/actions/runs/29627110666)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `453bd22b0a457b5b4fe0ebf3e3f6f932816b0512`
- Created: `2026-07-18T02:28:37Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 3: **Collect recent failure details** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29627103401](https://github.com/KSPOG/klite/actions/runs/29627103401)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `afb4b4fa813e7073c8befd86abf389adfb852b97`
- Created: `2026-07-18T02:28:21Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 3: **Collect recent failure details** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## CI: Ensure credit prices remain publicly readable

- Run: [29627103322](https://github.com/KSPOG/klite/actions/runs/29627103322)
- Conclusion: `failure`
- Event: `push`
- Commit: `afb4b4fa813e7073c8befd86abf389adfb852b97`
- Created: `2026-07-18T02:28:21Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T02:28:59.1115460Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T02:28:59.1116681Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T02:28:59.5081066Z > Task :client:jar
build	Build and Test	2026-07-18T02:28:59.5112078Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T02:28:59.8098370Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T02:29:00.1081076Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T02:29:00.1082590Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T02:29:00.1083445Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T02:29:00.1084118Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T02:29:00.1084687Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T02:29:00.1085081Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T02:29:00.1085446Z > Task :runelite-api:build
build	Build and Test	2026-07-18T02:29:08.3086327Z
build	Build and Test	2026-07-18T02:29:08.3113368Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T02:29:08.3114994Z > Task :client:javadoc
build	Build and Test	2026-07-18T02:29:08.3141916Z 	 * @param duration
build	Build and Test	2026-07-18T02:29:08.3164947Z 	   ^
build	Build and Test	2026-07-18T02:29:08.3192924Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T02:29:08.3218161Z 	 * @param duration
build	Build and Test	2026-07-18T02:29:08.3218889Z 	   ^
build	Build and Test	2026-07-18T02:29:08.8093775Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:29:08.8152712Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:29:08.8163293Z 	            ^
build	Build and Test	2026-07-18T02:29:08.8242810Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:29:08.8276591Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:29:08.8343258Z 	            ^
build	Build and Test	2026-07-18T02:29:08.8374935Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:29:08.8433129Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:29:08.8461957Z 	            ^
build	Build and Test	2026-07-18T02:29:08.8523208Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:29:08.8572875Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:29:08.8612180Z 	            ^
build	Build and Test	2026-07-18T02:29:08.8635438Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:29:08.8662639Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:29:08.8722031Z 	            ^
build	Build and Test	2026-07-18T02:29:08.8783420Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:29:08.8832772Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:29:08.8861995Z 	            ^
build	Build and Test	2026-07-18T02:29:08.8863652Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:29:08.8866066Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:29:08.8867417Z 	            ^
build	Build and Test	2026-07-18T02:29:08.8869240Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:29:08.8872175Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:29:08.8873412Z 	            ^
build	Build and Test	2026-07-18T02:29:08.8875046Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:29:08.8877491Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:29:08.8878704Z 	            ^
build	Build and Test	2026-07-18T02:29:08.9104282Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T02:29:08.9119305Z 	 * @param itemId
build	Build and Test	2026-07-18T02:29:08.9120134Z 	   ^
build	Build and Test	2026-07-18T02:29:08.9121801Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T02:29:08.9123250Z 	 * @return
build	Build and Test	2026-07-18T02:29:08.9123505Z 	   ^
build	Build and Test	2026-07-18T02:29:09.4101604Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T02:29:09.4102390Z 	               ^
build	Build and Test	2026-07-18T02:29:09.4103840Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T02:29:09.4105453Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T02:29:09.4106132Z 	             ^
build	Build and Test	2026-07-18T02:29:09.4107672Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T02:29:09.4109552Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T02:29:09.4110376Z 	            ^
build	Build and Test	2026-07-18T02:29:09.4112179Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T02:29:09.4114034Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T02:29:09.4114794Z 	            ^
build	Build and Test	2026-07-18T02:29:09.4116150Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T02:29:09.4117739Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T02:29:09.4118475Z 	            ^
build	Build and Test	2026-07-18T02:29:09.5082400Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T02:29:09.5084358Z 	public void select(Color color) {
build	Build and Test	2026-07-18T02:29:09.5085074Z 	            ^
build	Build and Test	2026-07-18T02:29:09.5086655Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T02:29:09.5088794Z 	 * @param dimmed
build	Build and Test	2026-07-18T02:29:09.5089364Z 	   ^
build	Build and Test	2026-07-18T02:29:09.6085440Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T02:29:09.6088373Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:29:09.6089334Z 	            ^
build	Build and Test	2026-07-18T02:29:09.6091025Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T02:29:09.6093490Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:29:09.6094450Z 	            ^
build	Build and Test	2026-07-18T02:29:09.7082837Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T02:29:09.7090676Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T02:29:09.7092098Z 		                                          ^
build	Build and Test	2026-07-18T02:29:14.6080081Z 100 warnings
build	Build and Test	2026-07-18T02:29:17.1081136Z
build	Build and Test	2026-07-18T02:29:17.1083286Z > Task :client:javadocJar
build	Build and Test	2026-07-18T02:29:17.1084238Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T02:29:21.8080842Z > Task :client:shadowJar
build	Build and Test	2026-07-18T02:29:21.8083489Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T02:29:21.8084443Z > Task :client:assemble
build	Build and Test	2026-07-18T02:29:22.1081493Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T02:29:22.1092445Z > Task :client:testClasses
build	Build and Test	2026-07-18T02:29:22.3162310Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T02:29:41.4102294Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T02:29:45.1133612Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T02:29:51.8080060Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T02:29:52.2085283Z > Task :client:pmdMain
build	Build and Test	2026-07-18T02:29:52.3132259Z > Task :client:test
build	Build and Test	2026-07-18T02:29:55.1103425Z
build	Build and Test	2026-07-18T02:29:55.1121104Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T02:29:55.3081019Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T02:29:55.3152226Z /tmp/junit11890823785410090307/junit16218185394753949292/vert.glsl.vert
build	Build and Test	2026-07-18T02:29:55.3232363Z /tmp/junit11890823785410090307/junit16218185394753949292/frag.glsl.frag
build	Build and Test	2026-07-18T02:29:55.5124104Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T02:29:55.5213692Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T02:29:55.5234678Z /tmp/junit11890823785410090307/junit10555845958051597400/vertui.glsl.vert
build	Build and Test	2026-07-18T02:29:55.5302450Z /tmp/junit11890823785410090307/junit10555845958051597400/fragui.glsl.frag
build	Build and Test	2026-07-18T02:30:01.4091721Z
build	Build and Test	2026-07-18T02:30:01.4152396Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T02:30:07.2080692Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784341726006.json
build	Build and Test	2026-07-18T02:30:07.3079589Z
build	Build and Test	2026-07-18T02:30:07.3081482Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T02:30:07.3082232Z
build	Build and Test	2026-07-18T02:30:07.3082409Z * What went wrong:
build	Build and Test	2026-07-18T02:30:07.3082760Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T02:30:07.3083370Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T02:30:07.3084350Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T02:30:07.3085294Z
build	Build and Test	2026-07-18T02:30:07.3085409Z * Try:
build	Build and Test	2026-07-18T02:30:07.3085688Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T02:30:07.3085932Z
build	Build and Test	2026-07-18T02:30:07.3086055Z BUILD FAILED in 1m 31s
build	Build and Test	2026-07-18T02:30:07.3086398Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T02:30:07.7510401Z ##[error]Process completed with exit code 1.
```

## CI: Add installer for credits and final website fixes

- Run: [29627089207](https://github.com/KSPOG/klite/actions/runs/29627089207)
- Conclusion: `failure`
- Event: `push`
- Commit: `08ff43a5481fcc236c9531637ae16a989b42f68e`
- Created: `2026-07-18T02:27:53Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T02:28:25.6551670Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T02:28:25.6579748Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T02:28:25.7450249Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T02:28:25.7479496Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T02:28:25.7509323Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T02:28:25.7510256Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T02:28:25.8432060Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T02:28:25.8469711Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T02:28:25.8499436Z > Task :runelite-api:build
build	Build and Test	2026-07-18T02:28:25.8500316Z > Task :client:jar
build	Build and Test	2026-07-18T02:28:25.8500812Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T02:28:26.0439833Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T02:28:31.8440754Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T02:28:31.8442297Z
build	Build and Test	2026-07-18T02:28:31.8487933Z 	 * @param duration
build	Build and Test	2026-07-18T02:28:31.8488450Z > Task :client:javadoc
build	Build and Test	2026-07-18T02:28:31.8508042Z 	   ^
build	Build and Test	2026-07-18T02:28:31.8509743Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T02:28:31.8511417Z 	 * @param duration
build	Build and Test	2026-07-18T02:28:31.8511891Z 	   ^
build	Build and Test	2026-07-18T02:28:32.3435230Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:28:32.3439314Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:28:32.3440803Z 	            ^
build	Build and Test	2026-07-18T02:28:32.3442705Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:28:32.3445060Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:28:32.3446427Z 	            ^
build	Build and Test	2026-07-18T02:28:32.3448383Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:28:32.3483166Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:28:32.3509245Z 	            ^
build	Build and Test	2026-07-18T02:28:32.3540293Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:28:32.3542995Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:28:32.3569290Z 	            ^
build	Build and Test	2026-07-18T02:28:32.3600661Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:28:32.3629901Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:28:32.3719281Z 	            ^
build	Build and Test	2026-07-18T02:28:32.3760591Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:28:32.3809893Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:28:32.3869217Z 	            ^
build	Build and Test	2026-07-18T02:28:32.3889192Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:28:32.3942319Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:28:32.3969143Z 	            ^
build	Build and Test	2026-07-18T02:28:32.3978452Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:28:32.3981352Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:28:32.3982770Z 	            ^
build	Build and Test	2026-07-18T02:28:32.3984556Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:28:32.3987200Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:28:32.3989055Z 	            ^
build	Build and Test	2026-07-18T02:28:32.4469395Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T02:28:32.4529294Z 	 * @param itemId
build	Build and Test	2026-07-18T02:28:32.4559318Z 	   ^
build	Build and Test	2026-07-18T02:28:32.4570412Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T02:28:32.4572307Z 	 * @return
build	Build and Test	2026-07-18T02:28:32.4572971Z 	   ^
build	Build and Test	2026-07-18T02:28:32.8539079Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T02:28:32.8539789Z 	               ^
build	Build and Test	2026-07-18T02:28:32.8569939Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T02:28:32.8571485Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T02:28:32.8572018Z 	             ^
build	Build and Test	2026-07-18T02:28:32.8573454Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T02:28:32.8575184Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T02:28:32.8575860Z 	            ^
build	Build and Test	2026-07-18T02:28:32.8577325Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T02:28:32.8579231Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T02:28:32.8579889Z 	            ^
build	Build and Test	2026-07-18T02:28:32.8581339Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T02:28:32.8583053Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T02:28:32.8583746Z 	            ^
build	Build and Test	2026-07-18T02:28:33.0460494Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T02:28:33.0489107Z 	public void select(Color color) {
build	Build and Test	2026-07-18T02:28:33.0500228Z 	            ^
build	Build and Test	2026-07-18T02:28:33.0520261Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T02:28:33.0539566Z 	 * @param dimmed
build	Build and Test	2026-07-18T02:28:33.0569694Z 	   ^
build	Build and Test	2026-07-18T02:28:33.1430292Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T02:28:33.1432412Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:28:33.1437070Z 	            ^
build	Build and Test	2026-07-18T02:28:33.1438996Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T02:28:33.1440972Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:28:33.1441820Z 	            ^
build	Build and Test	2026-07-18T02:28:33.2431452Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T02:28:33.2433869Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T02:28:33.2435002Z 		                                          ^
build	Build and Test	2026-07-18T02:28:37.4429900Z 100 warnings
build	Build and Test	2026-07-18T02:28:39.8428927Z
build	Build and Test	2026-07-18T02:28:39.8429728Z > Task :client:javadocJar
build	Build and Test	2026-07-18T02:28:39.8430343Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T02:28:44.4438845Z > Task :client:shadowJar
build	Build and Test	2026-07-18T02:28:44.4466502Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T02:28:44.4467288Z > Task :client:assemble
build	Build and Test	2026-07-18T02:28:44.8430280Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T02:28:44.8457530Z > Task :client:testClasses
build	Build and Test	2026-07-18T02:28:44.9438317Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T02:29:05.0429480Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T02:29:08.3477530Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T02:29:14.4439579Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T02:29:14.8439646Z > Task :client:pmdMain
build	Build and Test	2026-07-18T02:29:14.9444249Z > Task :client:test
build	Build and Test	2026-07-18T02:29:15.0450460Z
build	Build and Test	2026-07-18T02:29:15.0510250Z /tmp/junit12536990159157172340/junit17517696090335205866/vert.glsl.vert
build	Build and Test	2026-07-18T02:29:15.0569388Z /tmp/junit12536990159157172340/junit17517696090335205866/frag.glsl.frag
build	Build and Test	2026-07-18T02:29:15.2442898Z /tmp/junit12536990159157172340/junit2287467102092372876/vertui.glsl.vert
build	Build and Test	2026-07-18T02:29:15.2469379Z /tmp/junit12536990159157172340/junit2287467102092372876/fragui.glsl.frag
build	Build and Test	2026-07-18T02:29:18.0480883Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T02:29:18.2430858Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T02:29:18.4441496Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T02:29:18.4500898Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T02:29:23.7459171Z
build	Build and Test	2026-07-18T02:29:23.7482947Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T02:29:28.7428892Z
build	Build and Test	2026-07-18T02:29:28.7429912Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784341693132.json
build	Build and Test	2026-07-18T02:29:28.7431723Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T02:29:28.7432392Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T02:29:28.7433040Z
build	Build and Test	2026-07-18T02:29:28.7433225Z * What went wrong:
build	Build and Test	2026-07-18T02:29:28.7433567Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T02:29:28.7434124Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T02:29:28.7434977Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T02:29:28.7435759Z
build	Build and Test	2026-07-18T02:29:28.7435858Z * Try:
build	Build and Test	2026-07-18T02:29:28.7436117Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T02:29:28.7436341Z
build	Build and Test	2026-07-18T02:29:28.7436450Z BUILD FAILED in 1m 22s
build	Build and Test	2026-07-18T02:29:29.2357934Z ##[error]Process completed with exit code 1.
```

## CI: Move privileged routes into the account menu

- Run: [29627068009](https://github.com/KSPOG/klite/actions/runs/29627068009)
- Conclusion: `failure`
- Event: `push`
- Commit: `0e4558dbc9f1474352a4963089a4c4e2c61eae65`
- Created: `2026-07-18T02:27:06Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T02:27:53.7252085Z > Task :copper-tin-miner:jar
build	Build and Test	2026-07-18T02:27:53.7252778Z > Task :copper-tin-miner:assemble
build	Build and Test	2026-07-18T02:27:53.8199729Z > Task :copper-tin-miner:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-18T02:27:53.8200888Z > Task :copper-tin-miner:compileTestJava NO-SOURCE
build	Build and Test	2026-07-18T02:27:53.8202296Z > Task :copper-tin-miner:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T02:27:53.8203328Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-18T02:27:53.8205522Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-18T02:27:53.8206985Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T02:27:53.8208331Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T02:27:54.1199587Z > Task :client:jar
build	Build and Test	2026-07-18T02:27:54.2200461Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T02:27:54.3200489Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T02:28:01.4224749Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T02:28:01.4226269Z
build	Build and Test	2026-07-18T02:28:01.4252520Z 	 * @param duration
build	Build and Test	2026-07-18T02:28:01.4253052Z > Task :client:javadoc
build	Build and Test	2026-07-18T02:28:01.4282125Z 	   ^
build	Build and Test	2026-07-18T02:28:01.4283854Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T02:28:01.4309040Z 	 * @param duration
build	Build and Test	2026-07-18T02:28:01.4332077Z 	   ^
build	Build and Test	2026-07-18T02:28:02.0276911Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:28:02.0293243Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:28:02.0314069Z 	            ^
build	Build and Test	2026-07-18T02:28:02.0323697Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:28:02.0353005Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:28:02.0382414Z 	            ^
build	Build and Test	2026-07-18T02:28:02.0413729Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:28:02.0416585Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:28:02.0442327Z 	            ^
build	Build and Test	2026-07-18T02:28:02.0473373Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:28:02.0503112Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:28:02.0504751Z 	            ^
build	Build and Test	2026-07-18T02:28:02.0533778Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:28:02.0563121Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:28:02.0592449Z 	            ^
build	Build and Test	2026-07-18T02:28:02.0623835Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:28:02.0626576Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:28:02.0652399Z 	            ^
build	Build and Test	2026-07-18T02:28:02.0673539Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:28:02.0703116Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:28:02.0730477Z 	            ^
build	Build and Test	2026-07-18T02:28:02.0733274Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:28:02.0768922Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:28:02.0787836Z 	            ^
build	Build and Test	2026-07-18T02:28:02.0813904Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:28:02.0816596Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:28:02.0817964Z 	            ^
build	Build and Test	2026-07-18T02:28:02.0819559Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T02:28:02.0821627Z 	 * @param itemId
build	Build and Test	2026-07-18T02:28:02.0822399Z 	   ^
build	Build and Test	2026-07-18T02:28:02.0823872Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T02:28:02.0825637Z 	 * @return
build	Build and Test	2026-07-18T02:28:02.0826164Z 	   ^
build	Build and Test	2026-07-18T02:28:02.5312134Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T02:28:02.5352120Z 	               ^
build	Build and Test	2026-07-18T02:28:02.5373194Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T02:28:02.5374758Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T02:28:02.5402096Z 	             ^
build	Build and Test	2026-07-18T02:28:02.5413355Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T02:28:02.5415437Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T02:28:02.5416425Z 	            ^
build	Build and Test	2026-07-18T02:28:02.5418083Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T02:28:02.5419995Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T02:28:02.5420850Z 	            ^
build	Build and Test	2026-07-18T02:28:02.5422662Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T02:28:02.5424597Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T02:28:02.5425475Z 	            ^
build	Build and Test	2026-07-18T02:28:02.6230160Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T02:28:02.6237811Z 	public void select(Color color) {
build	Build and Test	2026-07-18T02:28:02.6238750Z 	            ^
build	Build and Test	2026-07-18T02:28:02.6240932Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T02:28:02.6243440Z 	 * @param dimmed
build	Build and Test	2026-07-18T02:28:02.6244084Z 	   ^
build	Build and Test	2026-07-18T02:28:02.7202296Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T02:28:02.7214059Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:28:02.7215211Z 	            ^
build	Build and Test	2026-07-18T02:28:02.7216978Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T02:28:02.7219139Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:28:02.7220152Z 	            ^
build	Build and Test	2026-07-18T02:28:02.7222208Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T02:28:02.7224499Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T02:28:02.7225737Z 		                                          ^
build	Build and Test	2026-07-18T02:28:07.4198440Z 100 warnings
build	Build and Test	2026-07-18T02:28:09.8198501Z
build	Build and Test	2026-07-18T02:28:09.8199181Z > Task :client:javadocJar
build	Build and Test	2026-07-18T02:28:09.8199764Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T02:28:14.4199656Z > Task :client:shadowJar
build	Build and Test	2026-07-18T02:28:14.4200688Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T02:28:14.4201802Z > Task :client:assemble
build	Build and Test	2026-07-18T02:28:14.7211372Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T02:28:14.7214085Z > Task :client:testClasses
build	Build and Test	2026-07-18T02:28:15.0208698Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T02:28:35.0246355Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T02:28:39.4203650Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T02:28:44.4212429Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T02:28:44.8202835Z > Task :client:pmdMain
build	Build and Test	2026-07-18T02:28:45.0263026Z > Task :client:test
build	Build and Test	2026-07-18T02:28:48.7198713Z
build	Build and Test	2026-07-18T02:28:48.7302952Z /tmp/junit4331385799535107643/junit14830381406408224662/vert.glsl.vert
build	Build and Test	2026-07-18T02:28:48.7372657Z /tmp/junit4331385799535107643/junit14830381406408224662/frag.glsl.frag
build	Build and Test	2026-07-18T02:28:48.8198524Z /tmp/junit4331385799535107643/junit16754686328704665744/vertui.glsl.vert
build	Build and Test	2026-07-18T02:28:48.8221349Z /tmp/junit4331385799535107643/junit16754686328704665744/fragui.glsl.frag
build	Build and Test	2026-07-18T02:28:50.1224384Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T02:28:50.5203732Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T02:28:50.7204461Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T02:28:50.7314000Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T02:28:57.7215073Z
build	Build and Test	2026-07-18T02:28:57.7302604Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T02:29:03.4204857Z
build	Build and Test	2026-07-18T02:29:03.4206021Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784341659083.json
build	Build and Test	2026-07-18T02:29:03.4233315Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T02:29:03.4234065Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T02:29:03.4234551Z
build	Build and Test	2026-07-18T02:29:03.4236032Z * What went wrong:
build	Build and Test	2026-07-18T02:29:03.4236945Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T02:29:03.4238309Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T02:29:03.4239977Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T02:29:03.4241111Z
build	Build and Test	2026-07-18T02:29:03.4241808Z * Try:
build	Build and Test	2026-07-18T02:29:03.4242442Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T02:29:03.4242977Z
build	Build and Test	2026-07-18T02:29:03.4243307Z BUILD FAILED in 1m 35s
build	Build and Test	2026-07-18T02:29:03.9238288Z ##[error]Process completed with exit code 1.
```

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29627055361](https://github.com/KSPOG/klite/actions/runs/29627055361)
- Conclusion: `failure`
- Event: `workflow_run`
- Commit: `95a58ad04743be38b003f147bd783f6e06c44145`
- Created: `2026-07-18T02:26:42Z`

### Failed jobs and steps

- **diagnose** — `failure`
  - Step 4: **Publish diagnostic report** — `failure`

### Relevant log context

```text
diagnose	Publish diagnostic report	﻿2026-07-18T02:27:43.8909594Z ##[group]Run set -euo pipefail
diagnose	Publish diagnostic report	2026-07-18T02:27:43.8909975Z ^[[36;1mset -euo pipefail^[[0m
diagnose	Publish diagnostic report	2026-07-18T02:27:43.8910262Z ^[[36;1mgit config user.name "github-actions[bot]"^[[0m
diagnose	Publish diagnostic report	2026-07-18T02:27:43.8910713Z ^[[36;1mgit config user.email "41898282+github-actions[bot]@users.noreply.github.com"^[[0m
diagnose	Publish diagnostic report	2026-07-18T02:27:43.8911209Z ^[[36;1mgit add diagnostics/latest-workflow-failures.md^[[0m
diagnose	Publish diagnostic report	2026-07-18T02:27:43.8974567Z ^[[36;1mif git diff --cached --quiet; then^[[0m
diagnose	Publish diagnostic report	2026-07-18T02:27:43.8975241Z ^[[36;1m  echo "The failure report did not change."^[[0m
diagnose	Publish diagnostic report	2026-07-18T02:27:43.8975864Z ^[[36;1m  exit 0^[[0m
diagnose	Publish diagnostic report	2026-07-18T02:27:43.8976282Z ^[[36;1mfi^[[0m
diagnose	Publish diagnostic report	2026-07-18T02:27:43.8976774Z ^[[36;1mgit commit -m "Update workflow failure diagnostics [skip ci]"^[[0m
diagnose	Publish diagnostic report	2026-07-18T02:27:43.8977533Z ^[[36;1mgit push^[[0m
diagnose	Publish diagnostic report	2026-07-18T02:27:43.9044253Z shell: /usr/bin/bash --noprofile --norc -e -o pipefail {0}
diagnose	Publish diagnostic report	2026-07-18T02:27:43.9044615Z ##[endgroup]
diagnose	Publish diagnostic report	2026-07-18T02:27:44.0761546Z [main 5ffaa3032] Update workflow failure diagnostics [skip ci]
diagnose	Publish diagnostic report	2026-07-18T02:27:44.0762436Z  1 file changed, 300 insertions(+), 424 deletions(-)
diagnose	Publish diagnostic report	2026-07-18T02:27:44.3739065Z To https://github.com/KSPOG/klite
diagnose	Publish diagnostic report	2026-07-18T02:27:44.3739791Z  ! [rejected]            main -> main (fetch first)
diagnose	Publish diagnostic report	2026-07-18T02:27:44.3740253Z error: failed to push some refs to 'https://github.com/KSPOG/klite'
diagnose	Publish diagnostic report	2026-07-18T02:27:44.3752403Z hint: Updates were rejected because the remote contains work that you do not
diagnose	Publish diagnostic report	2026-07-18T02:27:44.3753652Z hint: have locally. This is usually caused by another repository pushing to
diagnose	Publish diagnostic report	2026-07-18T02:27:44.3754852Z hint: the same ref. If you want to integrate the remote changes, use
diagnose	Publish diagnostic report	2026-07-18T02:27:44.3755814Z hint: 'git pull' before pushing again.
diagnose	Publish diagnostic report	2026-07-18T02:27:44.3756708Z hint: See the 'Note about fast-forwards' in 'git push --help' for details.
diagnose	Publish diagnostic report	2026-07-18T02:27:44.3767855Z ##[error]Process completed with exit code 1.
```

