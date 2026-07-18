# Recent GitHub Actions failures

Generated: 2026-07-18T01:50:51.408257+00:00
Repository: `KSPOG/klite`
Failed runs inspected: **15**

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29625946594](https://github.com/KSPOG/klite/actions/runs/29625946594)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `3be79e7168ecbc256d8a144331c068c6e80329be`
- Created: `2026-07-18T01:50:01Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 3: **Collect recent failure details** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## CI: Collapse all duplicate header closing tags

- Run: [29625906944](https://github.com/KSPOG/klite/actions/runs/29625906944)
- Conclusion: `failure`
- Event: `push`
- Commit: `b1d028e3927fadc8e9ccee4a985e872f8e6fbab9`
- Created: `2026-07-18T01:48:39Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T01:49:17.3318464Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T01:49:17.3319034Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T01:49:17.8314922Z > Task :client:jar
build	Build and Test	2026-07-18T01:49:17.8315961Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T01:49:18.0302463Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:49:18.0314135Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T01:49:18.0315393Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T01:49:18.0324246Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T01:49:18.0324883Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T01:49:18.0345374Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T01:49:18.0345948Z > Task :runelite-api:build
build	Build and Test	2026-07-18T01:49:18.1315788Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T01:49:26.0328200Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T01:49:26.0329685Z
build	Build and Test	2026-07-18T01:49:26.0330082Z 	 * @param duration
build	Build and Test	2026-07-18T01:49:26.0330629Z 	   ^
build	Build and Test	2026-07-18T01:49:26.0332034Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T01:49:26.0334314Z 	 * @param duration
build	Build and Test	2026-07-18T01:49:26.0334745Z 	   ^
build	Build and Test	2026-07-18T01:49:26.0359353Z > Task :client:javadoc
build	Build and Test	2026-07-18T01:49:26.5305749Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:49:26.5345345Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:49:26.5404239Z 	            ^
build	Build and Test	2026-07-18T01:49:26.5435413Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:49:26.5437794Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:49:26.5464138Z 	            ^
build	Build and Test	2026-07-18T01:49:26.5465746Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:49:26.5468008Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:49:26.5469082Z 	            ^
build	Build and Test	2026-07-18T01:49:26.5470467Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:49:26.5472651Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:49:26.5474122Z 	            ^
build	Build and Test	2026-07-18T01:49:26.5475763Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:49:26.5478423Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:49:26.5479533Z 	            ^
build	Build and Test	2026-07-18T01:49:26.5481087Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:49:26.5483346Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:49:26.6316764Z 	            ^
build	Build and Test	2026-07-18T01:49:26.6345375Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:49:26.6364751Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:49:26.6398969Z 	            ^
build	Build and Test	2026-07-18T01:49:26.6405662Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:49:26.6445485Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:49:26.6446930Z 	            ^
build	Build and Test	2026-07-18T01:49:26.6448853Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:49:26.6451714Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:49:26.6453243Z 	            ^
build	Build and Test	2026-07-18T01:49:26.6455246Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T01:49:26.6457017Z 	 * @param itemId
build	Build and Test	2026-07-18T01:49:26.6457718Z 	   ^
build	Build and Test	2026-07-18T01:49:26.6459290Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T01:49:26.6460976Z 	 * @return
build	Build and Test	2026-07-18T01:49:26.6461578Z 	   ^
build	Build and Test	2026-07-18T01:49:27.2397187Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T01:49:27.2397881Z 	               ^
build	Build and Test	2026-07-18T01:49:27.2399307Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T01:49:27.2401000Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T01:49:27.2401728Z 	             ^
build	Build and Test	2026-07-18T01:49:27.2403250Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T01:49:27.2405340Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T01:49:27.2406224Z 	            ^
build	Build and Test	2026-07-18T01:49:27.2407788Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T01:49:27.2409597Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T01:49:27.2410421Z 	            ^
build	Build and Test	2026-07-18T01:49:27.2411962Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T01:49:27.2414084Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T01:49:27.2414944Z 	            ^
build	Build and Test	2026-07-18T01:49:27.2416434Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T01:49:27.2418048Z 	public void select(Color color) {
build	Build and Test	2026-07-18T01:49:27.2418720Z 	            ^
build	Build and Test	2026-07-18T01:49:27.3302284Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T01:49:27.3306267Z 	 * @param dimmed
build	Build and Test	2026-07-18T01:49:27.3306925Z 	   ^
build	Build and Test	2026-07-18T01:49:27.3308360Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T01:49:27.3310054Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:49:27.3311091Z 	            ^
build	Build and Test	2026-07-18T01:49:27.3312632Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T01:49:27.3314662Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:49:27.3315450Z 	            ^
build	Build and Test	2026-07-18T01:49:27.4302724Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T01:49:27.4306215Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T01:49:27.4307312Z 		                                          ^
build	Build and Test	2026-07-18T01:49:32.2304579Z 100 warnings
build	Build and Test	2026-07-18T01:49:34.7301029Z
build	Build and Test	2026-07-18T01:49:34.7302588Z > Task :client:javadocJar
build	Build and Test	2026-07-18T01:49:34.7303202Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T01:49:39.4344820Z > Task :client:shadowJar
build	Build and Test	2026-07-18T01:49:39.4345902Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T01:49:39.4364491Z > Task :client:assemble
build	Build and Test	2026-07-18T01:49:39.8302001Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:49:39.8334243Z > Task :client:testClasses
build	Build and Test	2026-07-18T01:49:39.9308233Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T01:49:59.8394765Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T01:50:02.9302083Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T01:50:09.4314553Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T01:50:09.9304513Z > Task :client:pmdMain
build	Build and Test	2026-07-18T01:50:09.9364268Z > Task :client:test
build	Build and Test	2026-07-18T01:50:11.9384697Z
build	Build and Test	2026-07-18T01:50:11.9414708Z /tmp/junit1136244390164458942/junit1537257946731587085/vert.glsl.vert
build	Build and Test	2026-07-18T01:50:11.9465614Z /tmp/junit1136244390164458942/junit1537257946731587085/frag.glsl.frag
build	Build and Test	2026-07-18T01:50:12.0324706Z /tmp/junit1136244390164458942/junit1094064462841315984/vertui.glsl.vert
build	Build and Test	2026-07-18T01:50:12.0354350Z /tmp/junit1136244390164458942/junit1094064462841315984/fragui.glsl.frag
build	Build and Test	2026-07-18T01:50:12.5325651Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T01:50:12.7325912Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T01:50:12.9302812Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T01:50:12.9376003Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T01:50:18.4300607Z
build	Build and Test	2026-07-18T01:50:18.4334589Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T01:50:24.0308642Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784339344309.json
build	Build and Test	2026-07-18T01:50:24.0312356Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T01:50:24.0312818Z
build	Build and Test	2026-07-18T01:50:24.0320608Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T01:50:24.0321138Z
build	Build and Test	2026-07-18T01:50:24.0324499Z * What went wrong:
build	Build and Test	2026-07-18T01:50:24.0325291Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T01:50:24.0326631Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T01:50:24.0328136Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T01:50:24.0331265Z
build	Build and Test	2026-07-18T01:50:24.0331448Z * Try:
build	Build and Test	2026-07-18T01:50:24.0331891Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T01:50:24.0332304Z
build	Build and Test	2026-07-18T01:50:24.0332494Z BUILD FAILED in 1m 32s
build	Build and Test	2026-07-18T01:50:24.5358198Z ##[error]Process completed with exit code 1.
```

## CI: Remove duplicate header closing tag during generation

- Run: [29625856273](https://github.com/KSPOG/klite/actions/runs/29625856273)
- Conclusion: `failure`
- Event: `push`
- Commit: `c9bdc9d376fadca11a6aafb5d89356522f4d18c8`
- Created: `2026-07-18T01:46:56Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T01:47:45.2940632Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T01:47:45.2944970Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T01:47:45.3907329Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:47:45.3942532Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T01:47:45.3974467Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T01:47:45.4922896Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T01:47:45.5898987Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T01:47:45.5911961Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T01:47:45.5913621Z > Task :runelite-api:build
build	Build and Test	2026-07-18T01:47:45.6919794Z > Task :client:jar
build	Build and Test	2026-07-18T01:47:45.6939159Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T01:47:46.1899591Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T01:47:56.3918325Z
build	Build and Test	2026-07-18T01:47:56.3923083Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T01:47:56.3928070Z > Task :client:javadoc
build	Build and Test	2026-07-18T01:47:56.3930184Z 	 * @param duration
build	Build and Test	2026-07-18T01:47:56.3932074Z 	   ^
build	Build and Test	2026-07-18T01:47:56.3936481Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T01:47:56.3950646Z 	 * @param duration
build	Build and Test	2026-07-18T01:47:56.3981719Z 	   ^
build	Build and Test	2026-07-18T01:47:57.3932890Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:47:57.3940081Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:47:57.3971868Z 	            ^
build	Build and Test	2026-07-18T01:47:57.4026380Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:47:57.4083735Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:47:57.4111708Z 	            ^
build	Build and Test	2026-07-18T01:47:57.4175631Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:47:57.4223396Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:47:57.4281878Z 	            ^
build	Build and Test	2026-07-18T01:47:57.4314632Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:47:57.4373597Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:47:57.4401595Z 	            ^
build	Build and Test	2026-07-18T01:47:57.4406557Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:47:57.4454834Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:47:57.4458690Z 	            ^
build	Build and Test	2026-07-18T01:47:57.4464358Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:47:57.4492368Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:47:57.4496378Z 	            ^
build	Build and Test	2026-07-18T01:47:57.4501138Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:47:57.4508150Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:47:57.4512105Z 	            ^
build	Build and Test	2026-07-18T01:47:57.4517060Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:47:57.4555664Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:47:57.4572128Z 	            ^
build	Build and Test	2026-07-18T01:47:57.4577337Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:47:57.4584906Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:47:57.4588583Z 	            ^
build	Build and Test	2026-07-18T01:47:57.4907683Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T01:47:57.4913222Z 	 * @param itemId
build	Build and Test	2026-07-18T01:47:57.4914981Z 	   ^
build	Build and Test	2026-07-18T01:47:57.4919801Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T01:47:57.4925394Z 	 * @return
build	Build and Test	2026-07-18T01:47:57.4927095Z 	   ^
build	Build and Test	2026-07-18T01:47:58.1983031Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T01:47:58.1984725Z 	               ^
build	Build and Test	2026-07-18T01:47:58.1988596Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T01:47:58.1993572Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T01:47:58.1995387Z 	             ^
build	Build and Test	2026-07-18T01:47:58.2017908Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T01:47:58.2023314Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T01:47:58.2025435Z 	            ^
build	Build and Test	2026-07-18T01:47:58.2029665Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T01:47:58.2034860Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T01:47:58.2036817Z 	            ^
build	Build and Test	2026-07-18T01:47:58.2041528Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T01:47:58.2046717Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T01:47:58.2048761Z 	            ^
build	Build and Test	2026-07-18T01:47:58.2901588Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T01:47:58.2929212Z 	public void select(Color color) {
build	Build and Test	2026-07-18T01:47:58.2931474Z 	            ^
build	Build and Test	2026-07-18T01:47:58.4901430Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T01:47:58.4908849Z 	 * @param dimmed
build	Build and Test	2026-07-18T01:47:58.4910521Z 	   ^
build	Build and Test	2026-07-18T01:47:58.5900542Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T01:47:58.5908126Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:47:58.5910489Z 	            ^
build	Build and Test	2026-07-18T01:47:58.5915518Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T01:47:58.5921277Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:47:58.5923503Z 	            ^
build	Build and Test	2026-07-18T01:47:58.7917554Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T01:47:58.7952577Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T01:47:58.7961772Z 		                                          ^
build	Build and Test	2026-07-18T01:48:05.4897130Z 100 warnings
build	Build and Test	2026-07-18T01:48:09.4897680Z
build	Build and Test	2026-07-18T01:48:09.4899194Z > Task :client:javadocJar
build	Build and Test	2026-07-18T01:48:09.4902090Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T01:48:17.5897937Z > Task :client:shadowJar
build	Build and Test	2026-07-18T01:48:17.5901509Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T01:48:17.5903733Z > Task :client:assemble
build	Build and Test	2026-07-18T01:48:18.1992623Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:48:18.1994665Z > Task :client:testClasses
build	Build and Test	2026-07-18T01:48:18.3960296Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T01:48:47.5902269Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T01:48:48.1912136Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T01:48:48.2932177Z > Task :client:pmdMain
build	Build and Test	2026-07-18T01:48:48.3942252Z > Task :client:test
build	Build and Test	2026-07-18T01:49:05.1921438Z
build	Build and Test	2026-07-18T01:49:05.1979708Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T01:49:11.4898934Z /tmp/junit1883002507561648448/junit10527254522151436126/vert.glsl.vert
build	Build and Test	2026-07-18T01:49:11.4932278Z /tmp/junit1883002507561648448/junit10527254522151436126/frag.glsl.frag
build	Build and Test	2026-07-18T01:49:11.7962923Z /tmp/junit1883002507561648448/junit8981146417300601597/vertui.glsl.vert
build	Build and Test	2026-07-18T01:49:11.8081965Z /tmp/junit1883002507561648448/junit8981146417300601597/fragui.glsl.frag
build	Build and Test	2026-07-18T01:49:23.7956535Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T01:49:24.1925371Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T01:49:24.4927162Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T01:49:24.4938227Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T01:49:36.4898954Z
build	Build and Test	2026-07-18T01:49:36.4911926Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T01:49:49.7906098Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784339242661.json
build	Build and Test	2026-07-18T01:49:49.8914449Z
build	Build and Test	2026-07-18T01:49:49.8915648Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T01:49:49.8949475Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T01:49:49.8971334Z
build	Build and Test	2026-07-18T01:49:49.8981853Z * What went wrong:
build	Build and Test	2026-07-18T01:49:49.9012034Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T01:49:49.9043464Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T01:49:49.9074859Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T01:49:49.9101491Z
build	Build and Test	2026-07-18T01:49:49.9111875Z * Try:
build	Build and Test	2026-07-18T01:49:49.9142174Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T01:49:49.9143571Z
build	Build and Test	2026-07-18T01:49:49.9144767Z BUILD FAILED in 2m 36s
build	Build and Test	2026-07-18T01:49:50.5553412Z ##[error]Process completed with exit code 1.
```

## Install release preview homepage: Install the approved KLite release preview

- Run: [29625856267](https://github.com/KSPOG/klite/actions/runs/29625856267)
- Conclusion: `failure`
- Event: `push`
- Commit: `c9bdc9d376fadca11a6aafb5d89356522f4d18c8`
- Created: `2026-07-18T01:46:56Z`

### Failed jobs and steps

- **install** — `failure`
  - Step 3: **Install release preview** — `failure`

### Relevant log context

```text
install	Install release preview	﻿2026-07-18T01:47:09.1521586Z ##[group]Run python3 scripts/install_release_preview.py
install	Install release preview	2026-07-18T01:47:09.1522272Z ^[[36;1mpython3 scripts/install_release_preview.py^[[0m
install	Install release preview	2026-07-18T01:47:09.1583462Z shell: /usr/bin/bash -e {0}
install	Install release preview	2026-07-18T01:47:09.1584080Z ##[endgroup]
install	Install release preview	2026-07-18T01:47:09.3071323Z Traceback (most recent call last):
install	Install release preview	2026-07-18T01:47:09.3072711Z   File "/home/runner/work/klite/klite/scripts/install_release_preview.py", line 93, in <module>
install	Install release preview	2026-07-18T01:47:09.3073560Z     main()
install	Install release preview	2026-07-18T01:47:09.3074104Z   File "/home/runner/work/klite/klite/scripts/install_release_preview.py", line 76, in main
install	Install release preview	2026-07-18T01:47:09.3074749Z     raise RuntimeError("Duplicate header closing tag remains")
install	Install release preview	2026-07-18T01:47:09.3075262Z RuntimeError: Duplicate header closing tag remains
install	Install release preview	2026-07-18T01:47:09.3240086Z ##[error]Process completed with exit code 1.
```

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29625854025](https://github.com/KSPOG/klite/actions/runs/29625854025)
- Conclusion: `failure`
- Event: `workflow_run`
- Commit: `9ce6f3ce32f40a4ff27a9f5bd988ef9593a39834`
- Created: `2026-07-18T01:46:52Z`

### Failed jobs and steps

- **diagnose** — `failure`
  - Step 4: **Publish diagnostic report** — `failure`

### Relevant log context

```text
diagnose	Publish diagnostic report	﻿2026-07-18T01:47:21.6046109Z ##[group]Run set -euo pipefail
diagnose	Publish diagnostic report	2026-07-18T01:47:21.6119520Z ^[[36;1mset -euo pipefail^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:47:21.6120002Z ^[[36;1mgit config user.name "github-actions[bot]"^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:47:21.6120796Z ^[[36;1mgit config user.email "41898282+github-actions[bot]@users.noreply.github.com"^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:47:21.6121690Z ^[[36;1mgit add diagnostics/latest-workflow-failures.md^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:47:21.6122298Z ^[[36;1mif git diff --cached --quiet; then^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:47:21.6122784Z ^[[36;1m  echo "The failure report did not change."^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:47:21.6123237Z ^[[36;1m  exit 0^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:47:21.6123542Z ^[[36;1mfi^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:47:21.6123981Z ^[[36;1mgit commit -m "Update workflow failure diagnostics [skip ci]"^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:47:21.6124531Z ^[[36;1mgit push^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:47:21.6194534Z shell: /usr/bin/bash --noprofile --norc -e -o pipefail {0}
diagnose	Publish diagnostic report	2026-07-18T01:47:21.6194942Z ##[endgroup]
diagnose	Publish diagnostic report	2026-07-18T01:47:21.7930734Z [main bfe9e61a4] Update workflow failure diagnostics [skip ci]
diagnose	Publish diagnostic report	2026-07-18T01:47:21.7931571Z  1 file changed, 452 insertions(+), 358 deletions(-)
diagnose	Publish diagnostic report	2026-07-18T01:47:21.9889411Z To https://github.com/KSPOG/klite
diagnose	Publish diagnostic report	2026-07-18T01:47:21.9889913Z  ! [rejected]            main -> main (non-fast-forward)
diagnose	Publish diagnostic report	2026-07-18T01:47:21.9890650Z error: failed to push some refs to 'https://github.com/KSPOG/klite'
diagnose	Publish diagnostic report	2026-07-18T01:47:21.9922650Z hint: Updates were rejected because the tip of your current branch is behind
diagnose	Publish diagnostic report	2026-07-18T01:47:21.9923495Z hint: its remote counterpart. If you want to integrate the remote changes,
diagnose	Publish diagnostic report	2026-07-18T01:47:21.9924170Z hint: use 'git pull' before pushing again.
diagnose	Publish diagnostic report	2026-07-18T01:47:21.9924851Z hint: See the 'Note about fast-forwards' in 'git push --help' for details.
diagnose	Publish diagnostic report	2026-07-18T01:47:21.9941615Z ##[error]Process completed with exit code 1.
```

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29625853059](https://github.com/KSPOG/klite/actions/runs/29625853059)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `9ce6f3ce32f40a4ff27a9f5bd988ef9593a39834`
- Created: `2026-07-18T01:46:50Z`

### Failed jobs and steps

No failed job metadata was returned.

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29625847992](https://github.com/KSPOG/klite/actions/runs/29625847992)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `9ce6f3ce32f40a4ff27a9f5bd988ef9593a39834`
- Created: `2026-07-18T01:46:39Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 2: **Check out repository** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

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

## CI: Simplify release-preview installer workflow

- Run: [29625820866](https://github.com/KSPOG/klite/actions/runs/29625820866)
- Conclusion: `failure`
- Event: `push`
- Commit: `6d1ee78ce940da3d50c304f1a7036c950d0e8ba3`
- Created: `2026-07-18T01:45:46Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T01:46:18.5443666Z > Task :copper-tin-miner:jar
build	Build and Test	2026-07-18T01:46:18.5483620Z > Task :copper-tin-miner:assemble
build	Build and Test	2026-07-18T01:46:18.7404105Z > Task :copper-tin-miner:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-18T01:46:18.7419995Z > Task :copper-tin-miner:compileTestJava NO-SOURCE
build	Build and Test	2026-07-18T01:46:18.7433281Z > Task :copper-tin-miner:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T01:46:18.7453541Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-18T01:46:18.7454951Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-18T01:46:18.7455689Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T01:46:18.7457106Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T01:46:19.1376407Z > Task :client:jar
build	Build and Test	2026-07-18T01:46:19.1378603Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T01:46:19.4376569Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T01:46:25.0381709Z
build	Build and Test	2026-07-18T01:46:25.0415071Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T01:46:25.0416582Z > Task :client:javadoc
build	Build and Test	2026-07-18T01:46:25.0417672Z 	 * @param duration
build	Build and Test	2026-07-18T01:46:25.0427725Z 	   ^
build	Build and Test	2026-07-18T01:46:25.0429124Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T01:46:25.0430567Z 	 * @param duration
build	Build and Test	2026-07-18T01:46:25.0430950Z 	   ^
build	Build and Test	2026-07-18T01:46:25.5389294Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:46:25.5444130Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:46:25.5444991Z 	            ^
build	Build and Test	2026-07-18T01:46:25.5446224Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:46:25.5447725Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:46:25.5448472Z 	            ^
build	Build and Test	2026-07-18T01:46:25.5449699Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:46:25.5451194Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:46:25.5451907Z 	            ^
build	Build and Test	2026-07-18T01:46:25.5453081Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:46:25.5454521Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:46:25.5455305Z 	            ^
build	Build and Test	2026-07-18T01:46:25.5456507Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:46:25.5458406Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:46:25.5459153Z 	            ^
build	Build and Test	2026-07-18T01:46:25.5460280Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:46:25.5471345Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:46:25.5472401Z 	            ^
build	Build and Test	2026-07-18T01:46:25.5473530Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:46:25.5475252Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:46:25.5476221Z 	            ^
build	Build and Test	2026-07-18T01:46:25.5477099Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:46:25.5478309Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:46:25.5478925Z 	            ^
build	Build and Test	2026-07-18T01:46:25.5479808Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:46:25.5481032Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:46:25.5513493Z 	            ^
build	Build and Test	2026-07-18T01:46:25.6396160Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T01:46:25.6443118Z 	 * @param itemId
build	Build and Test	2026-07-18T01:46:25.6460258Z 	   ^
build	Build and Test	2026-07-18T01:46:25.6504432Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T01:46:25.6533302Z 	 * @return
build	Build and Test	2026-07-18T01:46:25.6533710Z 	   ^
build	Build and Test	2026-07-18T01:46:26.0579786Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T01:46:26.0580229Z 	               ^
build	Build and Test	2026-07-18T01:46:26.0581269Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T01:46:26.0582504Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T01:46:26.0583179Z 	             ^
build	Build and Test	2026-07-18T01:46:26.0584410Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T01:46:26.0585934Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T01:46:26.0586568Z 	            ^
build	Build and Test	2026-07-18T01:46:26.0587645Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T01:46:26.0588908Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T01:46:26.0589412Z 	            ^
build	Build and Test	2026-07-18T01:46:26.0590584Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T01:46:26.0591978Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T01:46:26.0592567Z 	            ^
build	Build and Test	2026-07-18T01:46:26.1378599Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T01:46:26.1394215Z 	public void select(Color color) {
build	Build and Test	2026-07-18T01:46:26.1394987Z 	            ^
build	Build and Test	2026-07-18T01:46:26.1396542Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T01:46:26.1398819Z 	 * @param dimmed
build	Build and Test	2026-07-18T01:46:26.1399383Z 	   ^
build	Build and Test	2026-07-18T01:46:26.2401366Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T01:46:26.2433742Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:46:26.2453264Z 	            ^
build	Build and Test	2026-07-18T01:46:26.2469391Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T01:46:26.2503944Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:46:26.2513718Z 	            ^
build	Build and Test	2026-07-18T01:46:26.3394922Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T01:46:26.3416090Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T01:46:26.3433869Z 		                                          ^
build	Build and Test	2026-07-18T01:46:30.5375188Z 100 warnings
build	Build and Test	2026-07-18T01:46:32.7375915Z
build	Build and Test	2026-07-18T01:46:32.7377047Z > Task :client:javadocJar
build	Build and Test	2026-07-18T01:46:32.7379051Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T01:46:37.4375634Z > Task :client:shadowJar
build	Build and Test	2026-07-18T01:46:37.4376857Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T01:46:37.4377749Z > Task :client:assemble
build	Build and Test	2026-07-18T01:46:37.8375850Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:46:37.8413489Z > Task :client:testClasses
build	Build and Test	2026-07-18T01:46:37.9383865Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T01:46:55.9403784Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T01:46:59.6404833Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T01:47:07.4411536Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T01:47:07.8413807Z > Task :client:pmdMain
build	Build and Test	2026-07-18T01:47:07.9405597Z > Task :client:test
build	Build and Test	2026-07-18T01:47:08.3423253Z
build	Build and Test	2026-07-18T01:47:08.3483874Z /tmp/junit15785860839500056708/junit10462049655532190469/vert.glsl.vert
build	Build and Test	2026-07-18T01:47:08.3513680Z /tmp/junit15785860839500056708/junit10462049655532190469/frag.glsl.frag
build	Build and Test	2026-07-18T01:47:08.4393987Z /tmp/junit15785860839500056708/junit11719202794637379576/vertui.glsl.vert
build	Build and Test	2026-07-18T01:47:08.4484245Z /tmp/junit15785860839500056708/junit11719202794637379576/fragui.glsl.frag
build	Build and Test	2026-07-18T01:47:08.6414900Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T01:47:08.9404982Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T01:47:09.1415201Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T01:47:09.1505052Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T01:47:14.9374719Z
build	Build and Test	2026-07-18T01:47:14.9375941Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T01:47:20.7395575Z
build	Build and Test	2026-07-18T01:47:20.7401049Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T01:47:20.7402169Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784339165732.json
build	Build and Test	2026-07-18T01:47:20.7403993Z
build	Build and Test	2026-07-18T01:47:20.7404440Z * What went wrong:
build	Build and Test	2026-07-18T01:47:20.7405110Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T01:47:20.7406174Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T01:47:20.7407736Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T01:47:20.7410453Z
build	Build and Test	2026-07-18T01:47:20.7410875Z * Try:
build	Build and Test	2026-07-18T01:47:20.7411506Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T01:47:20.7412139Z
build	Build and Test	2026-07-18T01:47:20.7412513Z BUILD FAILED in 1m 20s
build	Build and Test	2026-07-18T01:47:20.7413389Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T01:47:21.2411205Z ##[error]Process completed with exit code 1.
```

## CI: Add release-preview dashboard partial

- Run: [29625812746](https://github.com/KSPOG/klite/actions/runs/29625812746)
- Conclusion: `failure`
- Event: `push`
- Commit: `8a001a7a3a0b654d3ed9f8456c9fad129d3c7bdf`
- Created: `2026-07-18T01:45:31Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T01:45:57.7645415Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-18T01:45:57.7654985Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-18T01:45:57.7675161Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T01:45:57.7705128Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T01:45:58.0554448Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T01:45:58.2595954Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:45:58.2625650Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T01:45:58.2655259Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T01:45:58.3565746Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T01:45:58.3595564Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T01:45:58.3625147Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T01:45:58.3654974Z > Task :runelite-api:build
build	Build and Test	2026-07-18T01:46:01.6559411Z
build	Build and Test	2026-07-18T01:46:01.6586293Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T01:46:01.6587835Z > Task :client:javadoc
build	Build and Test	2026-07-18T01:46:01.6615899Z 	 * @param duration
build	Build and Test	2026-07-18T01:46:01.6621989Z 	   ^
build	Build and Test	2026-07-18T01:46:01.6627273Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T01:46:01.6628646Z 	 * @param duration
build	Build and Test	2026-07-18T01:46:01.6629181Z 	   ^
build	Build and Test	2026-07-18T01:46:01.9580644Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:46:01.9619792Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:46:01.9645106Z 	            ^
build	Build and Test	2026-07-18T01:46:01.9676004Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:46:01.9719317Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:46:01.9765002Z 	            ^
build	Build and Test	2026-07-18T01:46:01.9845754Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:46:01.9867289Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:46:01.9894954Z 	            ^
build	Build and Test	2026-07-18T01:46:01.9905789Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:46:01.9940654Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:46:01.9953452Z 	            ^
build	Build and Test	2026-07-18T01:46:01.9955138Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:46:01.9958547Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:46:01.9970438Z 	            ^
build	Build and Test	2026-07-18T01:46:01.9981112Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:46:02.0005329Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:46:02.0006469Z 	            ^
build	Build and Test	2026-07-18T01:46:02.0007420Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:46:02.0008880Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:46:02.0009828Z 	            ^
build	Build and Test	2026-07-18T01:46:02.0011073Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:46:02.0012631Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:46:02.0013503Z 	            ^
build	Build and Test	2026-07-18T01:46:02.0014762Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:46:02.0016295Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:46:02.0017175Z 	            ^
build	Build and Test	2026-07-18T01:46:02.0555997Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T01:46:02.0625942Z 	 * @param itemId
build	Build and Test	2026-07-18T01:46:02.0664975Z 	   ^
build	Build and Test	2026-07-18T01:46:02.0666117Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T01:46:02.0667037Z 	 * @return
build	Build and Test	2026-07-18T01:46:02.0667409Z 	   ^
build	Build and Test	2026-07-18T01:46:02.3621665Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T01:46:02.3622066Z 	               ^
build	Build and Test	2026-07-18T01:46:02.3622928Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T01:46:02.3623827Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T01:46:02.3624377Z 	             ^
build	Build and Test	2026-07-18T01:46:02.3625333Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T01:46:02.3626427Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T01:46:02.3626941Z 	            ^
build	Build and Test	2026-07-18T01:46:02.4553993Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T01:46:02.4562789Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T01:46:02.4564415Z 	            ^
build	Build and Test	2026-07-18T01:46:02.4565589Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T01:46:02.4566906Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T01:46:02.4567435Z 	            ^
build	Build and Test	2026-07-18T01:46:02.4568455Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T01:46:02.4569551Z 	public void select(Color color) {
build	Build and Test	2026-07-18T01:46:02.4570006Z 	            ^
build	Build and Test	2026-07-18T01:46:02.4571093Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T01:46:02.4572575Z 	 * @param dimmed
build	Build and Test	2026-07-18T01:46:02.4572967Z 	   ^
build	Build and Test	2026-07-18T01:46:02.5556813Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T01:46:02.5558962Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:46:02.5567897Z 	            ^
build	Build and Test	2026-07-18T01:46:02.5569397Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T01:46:02.5570557Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:46:02.5571187Z 	            ^
build	Build and Test	2026-07-18T01:46:02.5572358Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T01:46:02.5573662Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T01:46:02.5574587Z 		                                          ^
build	Build and Test	2026-07-18T01:46:05.8553396Z 100 warnings
build	Build and Test	2026-07-18T01:46:07.4553945Z
build	Build and Test	2026-07-18T01:46:07.4555781Z > Task :client:javadocJar
build	Build and Test	2026-07-18T01:46:07.4556404Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T01:46:10.8578685Z > Task :client:shadowJar
build	Build and Test	2026-07-18T01:46:10.8580029Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T01:46:10.8600431Z > Task :client:assemble
build	Build and Test	2026-07-18T01:46:11.0583497Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:46:11.0592813Z > Task :client:testClasses
build	Build and Test	2026-07-18T01:46:11.2590585Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T01:46:23.8624345Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T01:46:26.5587423Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T01:46:31.4566166Z /tmp/junit14753855233385870108/junit17145691515724683561/vert.glsl.vert
build	Build and Test	2026-07-18T01:46:31.4626088Z /tmp/junit14753855233385870108/junit17145691515724683561/frag.glsl.frag
build	Build and Test	2026-07-18T01:46:31.4675384Z /tmp/junit14753855233385870108/junit4217802389498196062/vertui.glsl.vert
build	Build and Test	2026-07-18T01:46:31.4755595Z /tmp/junit14753855233385870108/junit4217802389498196062/fragui.glsl.frag
build	Build and Test	2026-07-18T01:46:33.9553062Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T01:46:34.1636718Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T01:46:34.2606253Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T01:46:34.2646396Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T01:46:38.6553479Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T01:46:40.8556264Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T01:46:41.2575915Z > Task :client:test
build	Build and Test	2026-07-18T01:46:41.7564935Z
build	Build and Test	2026-07-18T01:46:41.7566456Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784339148763.json
build	Build and Test	2026-07-18T01:46:41.7585904Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T01:46:41.7586576Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T01:46:41.7606010Z
build	Build and Test	2026-07-18T01:46:41.7614410Z * What went wrong:
build	Build and Test	2026-07-18T01:46:41.7615693Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T01:46:41.7625616Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T01:46:41.7626852Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T01:46:41.7627721Z
build	Build and Test	2026-07-18T01:46:41.7628051Z * Try:
build	Build and Test	2026-07-18T01:46:41.7628523Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T01:46:41.7628918Z
build	Build and Test	2026-07-18T01:46:41.7629210Z BUILD FAILED in 56s
build	Build and Test	2026-07-18T01:46:42.2592934Z ##[error]Process completed with exit code 1.
```

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

## CI: Add release-preview hero partial

- Run: [29625803721](https://github.com/KSPOG/klite/actions/runs/29625803721)
- Conclusion: `failure`
- Event: `push`
- Commit: `6dac2c4618576bbcbe0715a06d9d56418dcf1ae9`
- Created: `2026-07-18T01:45:15Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T01:45:42.8019186Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T01:45:42.8059123Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T01:45:42.8812276Z > Task :client:jar
build	Build and Test	2026-07-18T01:45:42.8869474Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T01:45:43.0805671Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T01:45:43.2807222Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:45:43.2808054Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T01:45:43.2808847Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T01:45:43.2821732Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T01:45:43.2823119Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T01:45:43.2823874Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T01:45:43.2824730Z > Task :runelite-api:build
build	Build and Test	2026-07-18T01:45:47.0811389Z
build	Build and Test	2026-07-18T01:45:47.0829910Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T01:45:47.0831490Z > Task :client:javadoc
build	Build and Test	2026-07-18T01:45:47.0832152Z 	 * @param duration
build	Build and Test	2026-07-18T01:45:47.0832721Z 	   ^
build	Build and Test	2026-07-18T01:45:47.0833986Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T01:45:47.0835382Z 	 * @param duration
build	Build and Test	2026-07-18T01:45:47.0835920Z 	   ^
build	Build and Test	2026-07-18T01:45:47.4820461Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:45:47.4856099Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:45:47.4875484Z 	            ^
build	Build and Test	2026-07-18T01:45:47.4890492Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:45:47.4892343Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:45:47.4893572Z 	            ^
build	Build and Test	2026-07-18T01:45:47.4895001Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:45:47.4896910Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:45:47.4897986Z 	            ^
build	Build and Test	2026-07-18T01:45:47.4900894Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:45:47.4906161Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:45:47.4907349Z 	            ^
build	Build and Test	2026-07-18T01:45:47.4908902Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:45:47.4911140Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:45:47.4912227Z 	            ^
build	Build and Test	2026-07-18T01:45:47.4913639Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:45:47.4915485Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:45:47.4916974Z 	            ^
build	Build and Test	2026-07-18T01:45:47.4918515Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:45:47.4920374Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:45:47.4921455Z 	            ^
build	Build and Test	2026-07-18T01:45:47.4922922Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:45:47.4924884Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:45:47.4925941Z 	            ^
build	Build and Test	2026-07-18T01:45:47.4927333Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:45:47.4929280Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:45:47.4930276Z 	            ^
build	Build and Test	2026-07-18T01:45:47.4931448Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T01:45:47.4932619Z 	 * @param itemId
build	Build and Test	2026-07-18T01:45:47.4933212Z 	   ^
build	Build and Test	2026-07-18T01:45:47.4934262Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T01:45:47.4935501Z 	 * @return
build	Build and Test	2026-07-18T01:45:47.4935971Z 	   ^
build	Build and Test	2026-07-18T01:45:47.8060123Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T01:45:47.8060681Z 	               ^
build	Build and Test	2026-07-18T01:45:47.8061820Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T01:45:47.8063025Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T01:45:47.8063722Z 	             ^
build	Build and Test	2026-07-18T01:45:47.8064849Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T01:45:47.8066281Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T01:45:47.8067042Z 	            ^
build	Build and Test	2026-07-18T01:45:47.8068548Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T01:45:47.8069940Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T01:45:47.8070650Z 	            ^
build	Build and Test	2026-07-18T01:45:47.8071807Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T01:45:47.8073251Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T01:45:47.8073995Z 	            ^
build	Build and Test	2026-07-18T01:45:47.8829367Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T01:45:47.8836880Z 	public void select(Color color) {
build	Build and Test	2026-07-18T01:45:47.8837668Z 	            ^
build	Build and Test	2026-07-18T01:45:47.8839350Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T01:45:47.8841133Z 	 * @param dimmed
build	Build and Test	2026-07-18T01:45:47.8841696Z 	   ^
build	Build and Test	2026-07-18T01:45:47.9805700Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T01:45:47.9810097Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:45:47.9822909Z 	            ^
build	Build and Test	2026-07-18T01:45:47.9824394Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T01:45:47.9827437Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:45:47.9828191Z 	            ^
build	Build and Test	2026-07-18T01:45:47.9829719Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T01:45:47.9831305Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T01:45:47.9832192Z 		                                          ^
build	Build and Test	2026-07-18T01:45:50.9805342Z 100 warnings
build	Build and Test	2026-07-18T01:45:52.6804294Z
build	Build and Test	2026-07-18T01:45:52.6805511Z > Task :client:javadocJar
build	Build and Test	2026-07-18T01:45:52.6816090Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T01:45:56.5804782Z > Task :client:shadowJar
build	Build and Test	2026-07-18T01:45:56.5806886Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T01:45:56.5807731Z > Task :client:assemble
build	Build and Test	2026-07-18T01:45:56.8804935Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:45:56.8859753Z > Task :client:testClasses
build	Build and Test	2026-07-18T01:45:56.9846839Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T01:46:11.8896053Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T01:46:14.2840728Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T01:46:17.7840267Z /tmp/junit3223512500982683403/junit4043216909887378272/vert.glsl.vert
build	Build and Test	2026-07-18T01:46:17.7909959Z /tmp/junit3223512500982683403/junit4043216909887378272/frag.glsl.frag
build	Build and Test	2026-07-18T01:46:17.8819970Z /tmp/junit3223512500982683403/junit18285034886412210780/vertui.glsl.vert
build	Build and Test	2026-07-18T01:46:17.8859605Z /tmp/junit3223512500982683403/junit18285034886412210780/fragui.glsl.frag
build	Build and Test	2026-07-18T01:46:22.0821375Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T01:46:22.2816364Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T01:46:22.3824263Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T01:46:22.3930433Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T01:46:26.5805045Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T01:46:26.8804932Z > Task :client:pmdMain
build	Build and Test	2026-07-18T01:46:26.9819778Z > Task :client:test
build	Build and Test	2026-07-18T01:46:27.3829627Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T01:46:30.8803791Z
build	Build and Test	2026-07-18T01:46:30.8804513Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T01:46:30.8804849Z
build	Build and Test	2026-07-18T01:46:30.8805090Z * What went wrong:
build	Build and Test	2026-07-18T01:46:30.8805509Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T01:46:30.8806375Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T01:46:30.8807142Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T01:46:30.8807625Z
build	Build and Test	2026-07-18T01:46:30.8807779Z * Try:
build	Build and Test	2026-07-18T01:46:30.8808111Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T01:46:30.8808531Z
build	Build and Test	2026-07-18T01:46:30.8808831Z BUILD FAILED in 1m
build	Build and Test	2026-07-18T01:46:30.8809400Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784339133329.json
build	Build and Test	2026-07-18T01:46:30.8810035Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T01:46:31.3222259Z ##[error]Process completed with exit code 1.
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

## CI: Load release homepage from split partials

- Run: [29625793851](https://github.com/KSPOG/klite/actions/runs/29625793851)
- Conclusion: `failure`
- Event: `push`
- Commit: `4e3c0d1b7e9b74ec504ee75fa841a453bc028ed2`
- Created: `2026-07-18T01:44:58Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T01:45:38.6357902Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T01:45:38.6389853Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T01:45:39.0220509Z > Task :client:jar
build	Build and Test	2026-07-18T01:45:39.0230024Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T01:45:39.4202280Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T01:45:39.4220257Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:45:39.4250079Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T01:45:39.4279975Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T01:45:39.4309895Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T01:45:39.5213149Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T01:45:39.5240047Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T01:45:39.5270362Z > Task :runelite-api:build
build	Build and Test	2026-07-18T01:45:45.7240096Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T01:45:45.7241794Z 	 * @param duration
build	Build and Test	2026-07-18T01:45:45.7242234Z 	   ^
build	Build and Test	2026-07-18T01:45:45.7243578Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T01:45:45.7245067Z 	 * @param duration
build	Build and Test	2026-07-18T01:45:45.7245527Z 	   ^
build	Build and Test	2026-07-18T01:45:45.7245843Z
build	Build and Test	2026-07-18T01:45:45.7269983Z > Task :client:javadoc
build	Build and Test	2026-07-18T01:45:46.2243876Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:45:46.2288336Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:45:46.2331491Z 	            ^
build	Build and Test	2026-07-18T01:45:46.2351172Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:45:46.2360448Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:45:46.2361507Z 	            ^
build	Build and Test	2026-07-18T01:45:46.2363138Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:45:46.2365465Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:45:46.2366565Z 	            ^
build	Build and Test	2026-07-18T01:45:46.2367984Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:45:46.2370515Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:45:46.2371744Z 	            ^
build	Build and Test	2026-07-18T01:45:46.2373378Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:45:46.2376302Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:45:46.2377521Z 	            ^
build	Build and Test	2026-07-18T01:45:46.2379143Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:45:46.2382128Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:45:46.2383391Z 	            ^
build	Build and Test	2026-07-18T01:45:46.2385128Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:45:46.2387397Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:45:46.2388643Z 	            ^
build	Build and Test	2026-07-18T01:45:46.2450766Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:45:46.2453214Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:45:46.2454455Z 	            ^
build	Build and Test	2026-07-18T01:45:46.2456123Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:45:46.2458589Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:45:46.2460072Z 	            ^
build	Build and Test	2026-07-18T01:45:46.3280223Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T01:45:46.3309982Z 	 * @param itemId
build	Build and Test	2026-07-18T01:45:46.3330437Z 	   ^
build	Build and Test	2026-07-18T01:45:46.3332066Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T01:45:46.3333908Z 	 * @return
build	Build and Test	2026-07-18T01:45:46.3334486Z 	   ^
build	Build and Test	2026-07-18T01:45:46.8224659Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T01:45:46.8225463Z 	               ^
build	Build and Test	2026-07-18T01:45:46.8227043Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T01:45:46.8228794Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T01:45:46.8229824Z 	             ^
build	Build and Test	2026-07-18T01:45:46.8231545Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T01:45:46.8233547Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T01:45:46.8234461Z 	            ^
build	Build and Test	2026-07-18T01:45:46.8236064Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T01:45:46.8237897Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T01:45:46.8238740Z 	            ^
build	Build and Test	2026-07-18T01:45:46.8240627Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T01:45:46.8242546Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T01:45:46.8243423Z 	            ^
build	Build and Test	2026-07-18T01:45:46.9197256Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T01:45:46.9205409Z 	public void select(Color color) {
build	Build and Test	2026-07-18T01:45:46.9206193Z 	            ^
build	Build and Test	2026-07-18T01:45:46.9207795Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T01:45:46.9215747Z 	 * @param dimmed
build	Build and Test	2026-07-18T01:45:46.9216425Z 	   ^
build	Build and Test	2026-07-18T01:45:47.0213855Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T01:45:47.0240378Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:45:47.0249924Z 	            ^
build	Build and Test	2026-07-18T01:45:47.0251427Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T01:45:47.0253186Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:45:47.0253885Z 	            ^
build	Build and Test	2026-07-18T01:45:47.1197002Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T01:45:47.1199267Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T01:45:47.1200663Z 		                                          ^
build	Build and Test	2026-07-18T01:45:51.2194724Z 100 warnings
build	Build and Test	2026-07-18T01:45:53.5197450Z
build	Build and Test	2026-07-18T01:45:53.5198348Z > Task :client:javadocJar
build	Build and Test	2026-07-18T01:45:53.5199275Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T01:45:58.2230540Z > Task :client:shadowJar
build	Build and Test	2026-07-18T01:45:58.2260070Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T01:45:58.2260992Z > Task :client:assemble
build	Build and Test	2026-07-18T01:45:58.5195002Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:45:58.5210327Z > Task :client:testClasses
build	Build and Test	2026-07-18T01:45:58.8212303Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T01:46:19.4211736Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T01:46:20.6196134Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T01:46:26.5220733Z /tmp/junit12354029031178676569/junit10742372702611123629/vert.glsl.vert
build	Build and Test	2026-07-18T01:46:26.5280281Z /tmp/junit12354029031178676569/junit10742372702611123629/frag.glsl.frag
build	Build and Test	2026-07-18T01:46:26.7210727Z /tmp/junit12354029031178676569/junit6310173311250645936/vertui.glsl.vert
build	Build and Test	2026-07-18T01:46:26.7259758Z /tmp/junit12354029031178676569/junit6310173311250645936/fragui.glsl.frag
build	Build and Test	2026-07-18T01:46:28.2220381Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T01:46:28.6200420Z > Task :client:pmdMain
build	Build and Test	2026-07-18T01:46:28.8240491Z > Task :client:test
build	Build and Test	2026-07-18T01:46:30.8212773Z
build	Build and Test	2026-07-18T01:46:30.8271790Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T01:46:31.2210606Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T01:46:31.3196796Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T01:46:31.3211583Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T01:46:36.9199664Z
build	Build and Test	2026-07-18T01:46:36.9290227Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T01:46:41.1211030Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784339126677.json
build	Build and Test	2026-07-18T01:46:41.2196058Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T01:46:41.2196900Z
build	Build and Test	2026-07-18T01:46:41.2199177Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T01:46:41.2210904Z
build	Build and Test	2026-07-18T01:46:41.2211376Z * What went wrong:
build	Build and Test	2026-07-18T01:46:41.2212116Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T01:46:41.2213699Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T01:46:41.2215407Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T01:46:41.2216569Z
build	Build and Test	2026-07-18T01:46:41.2216922Z * Try:
build	Build and Test	2026-07-18T01:46:41.2217561Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T01:46:41.2218135Z
build	Build and Test	2026-07-18T01:46:41.2218504Z BUILD FAILED in 1m 22s
build	Build and Test	2026-07-18T01:46:41.7284504Z ##[error]Process completed with exit code 1.
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

