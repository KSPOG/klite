# Recent GitHub Actions failures

Generated: 2026-07-18T02:23:46.628150+00:00
Repository: `KSPOG/klite`
Failed runs inspected: **15**

## CI: Add marketplace credits checkout and purchase API

- Run: [29626923841](https://github.com/KSPOG/klite/actions/runs/29626923841)
- Conclusion: `failure`
- Event: `push`
- Commit: `5dc2d35f4cec04aea4c67f3581f133d08336ed30`
- Created: `2026-07-18T02:22:13Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T02:22:39.4883956Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-18T02:22:39.4913918Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-18T02:22:39.4943833Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T02:22:39.4973608Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T02:22:39.7656483Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T02:22:39.8624492Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T02:22:39.8655072Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T02:22:39.8670127Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T02:22:39.8684282Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T02:22:39.9623602Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T02:22:39.9624516Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T02:22:39.9625246Z > Task :runelite-api:build
build	Build and Test	2026-07-18T02:22:43.2630047Z
build	Build and Test	2026-07-18T02:22:43.2642150Z > Task :client:javadoc
build	Build and Test	2026-07-18T02:22:43.2644409Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T02:22:43.2674039Z 	 * @param duration
build	Build and Test	2026-07-18T02:22:43.2684078Z 	   ^
build	Build and Test	2026-07-18T02:22:43.2714898Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T02:22:43.2727861Z 	 * @param duration
build	Build and Test	2026-07-18T02:22:43.2753952Z 	   ^
build	Build and Test	2026-07-18T02:22:43.5685261Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:22:43.5744544Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:22:43.5753369Z 	            ^
build	Build and Test	2026-07-18T02:22:43.5755170Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:22:43.5756608Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:22:43.5757297Z 	            ^
build	Build and Test	2026-07-18T02:22:43.5758180Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:22:43.5759575Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:22:43.5760248Z 	            ^
build	Build and Test	2026-07-18T02:22:43.5760975Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:22:43.5762209Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:22:43.5762876Z 	            ^
build	Build and Test	2026-07-18T02:22:43.5763937Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:22:43.5765781Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:22:43.5766506Z 	            ^
build	Build and Test	2026-07-18T02:22:43.5767481Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:22:43.5769555Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:22:43.5770488Z 	            ^
build	Build and Test	2026-07-18T02:22:43.5771340Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:22:43.5772624Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:22:43.5773527Z 	            ^
build	Build and Test	2026-07-18T02:22:43.5774544Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:22:43.5775918Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:22:43.5776691Z 	            ^
build	Build and Test	2026-07-18T02:22:43.5777663Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:22:43.5779067Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:22:43.5779828Z 	            ^
build	Build and Test	2026-07-18T02:22:43.5780729Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T02:22:43.5781666Z 	 * @param itemId
build	Build and Test	2026-07-18T02:22:43.5782027Z 	   ^
build	Build and Test	2026-07-18T02:22:43.5782934Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T02:22:43.5784075Z 	 * @return
build	Build and Test	2026-07-18T02:22:43.5784418Z 	   ^
build	Build and Test	2026-07-18T02:22:43.8777634Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T02:22:43.8778224Z 	               ^
build	Build and Test	2026-07-18T02:22:43.8779054Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T02:22:43.8779996Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T02:22:43.8780510Z 	             ^
build	Build and Test	2026-07-18T02:22:43.8781486Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T02:22:43.8782551Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T02:22:43.8783388Z 	            ^
build	Build and Test	2026-07-18T02:22:43.8784390Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T02:22:43.8785522Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T02:22:43.8786070Z 	            ^
build	Build and Test	2026-07-18T02:22:43.8786967Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T02:22:43.8788139Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T02:22:43.8788757Z 	            ^
build	Build and Test	2026-07-18T02:22:43.8789812Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T02:22:43.8791014Z 	public void select(Color color) {
build	Build and Test	2026-07-18T02:22:43.8791610Z 	            ^
build	Build and Test	2026-07-18T02:22:43.9624142Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T02:22:43.9629082Z 	 * @param dimmed
build	Build and Test	2026-07-18T02:22:43.9629607Z 	   ^
build	Build and Test	2026-07-18T02:22:43.9630733Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T02:22:43.9632008Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:22:43.9632584Z 	            ^
build	Build and Test	2026-07-18T02:22:43.9633747Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T02:22:43.9634991Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:22:43.9635535Z 	            ^
build	Build and Test	2026-07-18T02:22:43.9636461Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T02:22:43.9637640Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T02:22:43.9638236Z 		                                          ^
build	Build and Test	2026-07-18T02:22:46.5622376Z 100 warnings
build	Build and Test	2026-07-18T02:22:48.3634029Z
build	Build and Test	2026-07-18T02:22:48.3635318Z > Task :client:javadocJar
build	Build and Test	2026-07-18T02:22:51.6624077Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T02:22:51.6624690Z > Task :client:shadowJar
build	Build and Test	2026-07-18T02:22:51.6625204Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T02:22:51.6625516Z > Task :client:assemble
build	Build and Test	2026-07-18T02:22:51.8678016Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T02:22:51.8765118Z > Task :client:testClasses
build	Build and Test	2026-07-18T02:22:52.0624866Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T02:23:04.1684757Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T02:23:06.4625371Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T02:23:13.9655064Z /tmp/junit17205517056393971001/junit9934100791877384688/vert.glsl.vert
build	Build and Test	2026-07-18T02:23:13.9740793Z /tmp/junit17205517056393971001/junit9934100791877384688/frag.glsl.frag
build	Build and Test	2026-07-18T02:23:13.9825391Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T02:23:13.9884658Z /tmp/junit17205517056393971001/junit5827335254097525263/vertui.glsl.vert
build	Build and Test	2026-07-18T02:23:13.9954468Z /tmp/junit17205517056393971001/junit5827335254097525263/fragui.glsl.frag
build	Build and Test	2026-07-18T02:23:14.1651415Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T02:23:14.2657923Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T02:23:14.2685725Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T02:23:19.0625052Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T02:23:21.2645273Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T02:23:22.0623401Z > Task :client:test
build	Build and Test	2026-07-18T02:23:23.2630176Z
build	Build and Test	2026-07-18T02:23:23.2631868Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784341350855.json
build	Build and Test	2026-07-18T02:23:23.2632914Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T02:23:23.2634264Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T02:23:23.2634873Z
build	Build and Test	2026-07-18T02:23:23.2635062Z * What went wrong:
build	Build and Test	2026-07-18T02:23:23.2635457Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T02:23:23.2636018Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T02:23:23.2646257Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T02:23:23.2647796Z
build	Build and Test	2026-07-18T02:23:23.2647982Z * Try:
build	Build and Test	2026-07-18T02:23:23.2648455Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T02:23:23.2648755Z
build	Build and Test	2026-07-18T02:23:23.2648931Z BUILD FAILED in 55s
build	Build and Test	2026-07-18T02:23:23.7464578Z ##[error]Process completed with exit code 1.
```

## CI: Add marketplace credits ledger and pricing schema

- Run: [29626887718](https://github.com/KSPOG/klite/actions/runs/29626887718)
- Conclusion: `failure`
- Event: `push`
- Commit: `a164cbbb3743428bfbed582c74a9277bc93311ad`
- Created: `2026-07-18T02:21:02Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T02:21:36.0154458Z > Task :copper-tin-miner:jar
build	Build and Test	2026-07-18T02:21:36.0184373Z > Task :copper-tin-miner:assemble
build	Build and Test	2026-07-18T02:21:36.2155277Z > Task :copper-tin-miner:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-18T02:21:36.2157975Z > Task :copper-tin-miner:compileTestJava NO-SOURCE
build	Build and Test	2026-07-18T02:21:36.2158967Z > Task :copper-tin-miner:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T02:21:36.2160805Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-18T02:21:36.2161623Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-18T02:21:36.2162792Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T02:21:36.2163548Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T02:21:36.5105388Z > Task :client:jar
build	Build and Test	2026-07-18T02:21:36.5105956Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T02:21:36.7106706Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T02:21:42.4114816Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T02:21:42.4116203Z
build	Build and Test	2026-07-18T02:21:42.4125950Z 	 * @param duration
build	Build and Test	2026-07-18T02:21:42.4126373Z 	   ^
build	Build and Test	2026-07-18T02:21:42.4127632Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T02:21:42.4128984Z 	 * @param duration
build	Build and Test	2026-07-18T02:21:42.4129384Z 	   ^
build	Build and Test	2026-07-18T02:21:42.4146038Z > Task :client:javadoc
build	Build and Test	2026-07-18T02:21:42.9106437Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:21:42.9115343Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:21:42.9116510Z 	            ^
build	Build and Test	2026-07-18T02:21:42.9118132Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:21:42.9120447Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:21:42.9121634Z 	            ^
build	Build and Test	2026-07-18T02:21:42.9123215Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:21:42.9125710Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:21:42.9126865Z 	            ^
build	Build and Test	2026-07-18T02:21:42.9128304Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:21:42.9130537Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:21:42.9131836Z 	            ^
build	Build and Test	2026-07-18T02:21:42.9133532Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:21:42.9165063Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:21:42.9205672Z 	            ^
build	Build and Test	2026-07-18T02:21:42.9208767Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:21:42.9236160Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:21:42.9274895Z 	            ^
build	Build and Test	2026-07-18T02:21:42.9305644Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:21:42.9335098Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:21:42.9336684Z 	            ^
build	Build and Test	2026-07-18T02:21:42.9365699Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:21:42.9395200Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:21:42.9424672Z 	            ^
build	Build and Test	2026-07-18T02:21:42.9426524Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:21:42.9440029Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:21:42.9441381Z 	            ^
build	Build and Test	2026-07-18T02:21:42.9442871Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T02:21:42.9444692Z 	 * @param itemId
build	Build and Test	2026-07-18T02:21:42.9445286Z 	   ^
build	Build and Test	2026-07-18T02:21:42.9446768Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T02:21:42.9448388Z 	 * @return
build	Build and Test	2026-07-18T02:21:42.9448943Z 	   ^
build	Build and Test	2026-07-18T02:21:43.4199691Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T02:21:43.4200332Z 	               ^
build	Build and Test	2026-07-18T02:21:43.4201576Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T02:21:43.4202912Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T02:21:43.4203544Z 	             ^
build	Build and Test	2026-07-18T02:21:43.4205030Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T02:21:43.4206613Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T02:21:43.4207328Z 	            ^
build	Build and Test	2026-07-18T02:21:43.4208642Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T02:21:43.4210160Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T02:21:43.4210883Z 	            ^
build	Build and Test	2026-07-18T02:21:43.4212215Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T02:21:43.4214002Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T02:21:43.4214815Z 	            ^
build	Build and Test	2026-07-18T02:21:43.5112154Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T02:21:43.5135520Z 	public void select(Color color) {
build	Build and Test	2026-07-18T02:21:43.5136275Z 	            ^
build	Build and Test	2026-07-18T02:21:43.5137729Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T02:21:43.5139647Z 	 * @param dimmed
build	Build and Test	2026-07-18T02:21:43.5140232Z 	   ^
build	Build and Test	2026-07-18T02:21:43.6106034Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T02:21:43.6108079Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:21:43.6108869Z 	            ^
build	Build and Test	2026-07-18T02:21:43.6110236Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T02:21:43.6112231Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:21:43.6113002Z 	            ^
build	Build and Test	2026-07-18T02:21:43.6114615Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T02:21:43.6116331Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T02:21:43.6117213Z 		                                          ^
build	Build and Test	2026-07-18T02:21:47.8104531Z 100 warnings
build	Build and Test	2026-07-18T02:21:50.0105342Z
build	Build and Test	2026-07-18T02:21:50.0106320Z > Task :client:javadocJar
build	Build and Test	2026-07-18T02:21:50.0106905Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T02:21:54.6122644Z > Task :client:shadowJar
build	Build and Test	2026-07-18T02:21:54.6135268Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T02:21:54.6178234Z > Task :client:assemble
build	Build and Test	2026-07-18T02:21:55.0125112Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T02:21:55.0126141Z > Task :client:testClasses
build	Build and Test	2026-07-18T02:21:55.2137239Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T02:22:14.7154916Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T02:22:17.6135780Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T02:22:24.6104892Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T02:22:25.1124902Z > Task :client:pmdMain
build	Build and Test	2026-07-18T02:22:25.2134261Z > Task :client:test
build	Build and Test	2026-07-18T02:22:27.5104009Z
build	Build and Test	2026-07-18T02:22:27.5155249Z /tmp/junit1641700580882652875/junit15488490226405175681/vert.glsl.vert
build	Build and Test	2026-07-18T02:22:27.5214644Z /tmp/junit1641700580882652875/junit15488490226405175681/frag.glsl.frag
build	Build and Test	2026-07-18T02:22:27.7115200Z /tmp/junit1641700580882652875/junit14208496111849829546/vertui.glsl.vert
build	Build and Test	2026-07-18T02:22:27.7196590Z /tmp/junit1641700580882652875/junit14208496111849829546/fragui.glsl.frag
build	Build and Test	2026-07-18T02:22:27.9105344Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T02:22:28.1115957Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T02:22:28.3166623Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T02:22:28.3196044Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T02:22:34.2134482Z
build	Build and Test	2026-07-18T02:22:34.2196268Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T02:22:39.4125684Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784341282463.json
build	Build and Test	2026-07-18T02:22:39.4129399Z
build	Build and Test	2026-07-18T02:22:39.4132446Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T02:22:39.4133199Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T02:22:39.4141710Z
build	Build and Test	2026-07-18T02:22:39.4143335Z * What went wrong:
build	Build and Test	2026-07-18T02:22:39.4144201Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T02:22:39.4145456Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T02:22:39.4148022Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T02:22:39.4152424Z
build	Build and Test	2026-07-18T02:22:39.4153356Z * Try:
build	Build and Test	2026-07-18T02:22:39.4179960Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T02:22:39.4180578Z
build	Build and Test	2026-07-18T02:22:39.4180928Z BUILD FAILED in 1m 24s
build	Build and Test	2026-07-18T02:22:39.9600952Z ##[error]Process completed with exit code 1.
```

## CI: Install obsidian assets and catalog-driven homepage

- Run: [29626430327](https://github.com/KSPOG/klite/actions/runs/29626430327)
- Conclusion: `failure`
- Event: `push`
- Commit: `6ae7159706e7c16f52aae3279b1021a5456be206`
- Created: `2026-07-18T02:05:43Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T02:06:29.0722072Z > Task :copper-tin-miner:jar
build	Build and Test	2026-07-18T02:06:29.0751883Z > Task :copper-tin-miner:assemble
build	Build and Test	2026-07-18T02:06:29.2612064Z > Task :copper-tin-miner:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-18T02:06:29.2652126Z > Task :copper-tin-miner:compileTestJava NO-SOURCE
build	Build and Test	2026-07-18T02:06:29.2654534Z > Task :copper-tin-miner:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T02:06:29.2655941Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-18T02:06:29.2658439Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-18T02:06:29.2661790Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T02:06:29.2664479Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T02:06:29.5615154Z > Task :client:jar
build	Build and Test	2026-07-18T02:06:29.5616178Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T02:06:29.7612155Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T02:06:38.4643436Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T02:06:38.4644970Z
build	Build and Test	2026-07-18T02:06:38.4645306Z > Task :client:javadoc
build	Build and Test	2026-07-18T02:06:38.4701892Z 	 * @param duration
build	Build and Test	2026-07-18T02:06:38.4702417Z 	   ^
build	Build and Test	2026-07-18T02:06:38.4732868Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T02:06:38.4761800Z 	 * @param duration
build	Build and Test	2026-07-18T02:06:38.4762294Z 	   ^
build	Build and Test	2026-07-18T02:06:39.0673712Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:06:39.0762878Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:06:39.0792152Z 	            ^
build	Build and Test	2026-07-18T02:06:39.0853475Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:06:39.0904027Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:06:39.0941434Z 	            ^
build	Build and Test	2026-07-18T02:06:39.0943433Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:06:39.0946059Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:06:39.0947376Z 	            ^
build	Build and Test	2026-07-18T02:06:39.0948970Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:06:39.0951746Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:06:39.0953131Z 	            ^
build	Build and Test	2026-07-18T02:06:39.0954917Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:06:39.0957915Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:06:39.0959244Z 	            ^
build	Build and Test	2026-07-18T02:06:39.0960992Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:06:39.0964104Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:06:39.0965393Z 	            ^
build	Build and Test	2026-07-18T02:06:39.0967049Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:06:39.0970473Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:06:39.0972112Z 	            ^
build	Build and Test	2026-07-18T02:06:39.0973905Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:06:39.0976442Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:06:39.0977781Z 	            ^
build	Build and Test	2026-07-18T02:06:39.0979450Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:06:39.0982086Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:06:39.0983400Z 	            ^
build	Build and Test	2026-07-18T02:06:39.0984949Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T02:06:39.0986701Z 	 * @param itemId
build	Build and Test	2026-07-18T02:06:39.0987276Z 	   ^
build	Build and Test	2026-07-18T02:06:39.0988788Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T02:06:39.0990432Z 	 * @return
build	Build and Test	2026-07-18T02:06:39.0990967Z 	   ^
build	Build and Test	2026-07-18T02:06:39.6622026Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T02:06:39.6622838Z 	               ^
build	Build and Test	2026-07-18T02:06:39.6624411Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T02:06:39.6626200Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T02:06:39.6626995Z 	             ^
build	Build and Test	2026-07-18T02:06:39.6628588Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T02:06:39.6630502Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T02:06:39.6631652Z 	            ^
build	Build and Test	2026-07-18T02:06:39.6633236Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T02:06:39.6635037Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T02:06:39.6635875Z 	            ^
build	Build and Test	2026-07-18T02:06:39.6637504Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T02:06:39.6639502Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T02:06:39.6640396Z 	            ^
build	Build and Test	2026-07-18T02:06:39.7615073Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T02:06:39.7617664Z 	public void select(Color color) {
build	Build and Test	2026-07-18T02:06:39.7618644Z 	            ^
build	Build and Test	2026-07-18T02:06:39.7620351Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T02:06:39.7623009Z 	 * @param dimmed
build	Build and Test	2026-07-18T02:06:39.7629615Z 	   ^
build	Build and Test	2026-07-18T02:06:39.8610956Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T02:06:39.8613917Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:06:39.8615002Z 	            ^
build	Build and Test	2026-07-18T02:06:39.8616835Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T02:06:39.8633534Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:06:39.8634474Z 	            ^
build	Build and Test	2026-07-18T02:06:39.9618170Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T02:06:39.9621682Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T02:06:39.9630209Z 		                                          ^
build	Build and Test	2026-07-18T02:06:44.8609344Z 100 warnings
build	Build and Test	2026-07-18T02:06:47.0632098Z
build	Build and Test	2026-07-18T02:06:47.0662269Z > Task :client:javadocJar
build	Build and Test	2026-07-18T02:06:47.0682315Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T02:06:51.5609362Z > Task :client:shadowJar
build	Build and Test	2026-07-18T02:06:51.5610915Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T02:06:51.5614262Z > Task :client:assemble
build	Build and Test	2026-07-18T02:06:51.9632438Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T02:06:51.9633738Z > Task :client:testClasses
build	Build and Test	2026-07-18T02:06:52.1628460Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T02:07:12.9704229Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T02:07:14.8643377Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T02:07:21.5622373Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T02:07:21.9612260Z > Task :client:pmdMain
build	Build and Test	2026-07-18T02:07:22.1642352Z > Task :client:test
build	Build and Test	2026-07-18T02:07:25.3621720Z
build	Build and Test	2026-07-18T02:07:25.3683799Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T02:07:25.6610790Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T02:07:25.7662606Z /tmp/junit15161593462294368962/junit9610208445481315728/vert.glsl.vert
build	Build and Test	2026-07-18T02:07:25.7704518Z /tmp/junit15161593462294368962/junit9610208445481315728/frag.glsl.frag
build	Build and Test	2026-07-18T02:07:25.8610086Z /tmp/junit15161593462294368962/junit1782887925317729529/vertui.glsl.vert
build	Build and Test	2026-07-18T02:07:25.8652225Z /tmp/junit15161593462294368962/junit1782887925317729529/fragui.glsl.frag
build	Build and Test	2026-07-18T02:07:25.8683348Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T02:07:25.8743299Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T02:07:32.2609314Z
build	Build and Test	2026-07-18T02:07:32.2610095Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T02:07:38.9608593Z
build	Build and Test	2026-07-18T02:07:38.9609817Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784340375136.json
build	Build and Test	2026-07-18T02:07:38.9612184Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T02:07:38.9612751Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T02:07:38.9613461Z
build	Build and Test	2026-07-18T02:07:38.9613801Z * What went wrong:
build	Build and Test	2026-07-18T02:07:38.9614314Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T02:07:38.9615220Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T02:07:38.9616152Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T02:07:38.9616732Z
build	Build and Test	2026-07-18T02:07:38.9616837Z * Try:
build	Build and Test	2026-07-18T02:07:38.9617110Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T02:07:38.9617342Z
build	Build and Test	2026-07-18T02:07:38.9617457Z BUILD FAILED in 1m 35s
build	Build and Test	2026-07-18T02:07:39.4647495Z ##[error]Process completed with exit code 1.
```

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29626303029](https://github.com/KSPOG/klite/actions/runs/29626303029)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `94e9d19a9a03aa0441be2c7a13febeb3dc8f080c`
- Created: `2026-07-18T02:01:41Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 3: **Collect recent failure details** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29626290824](https://github.com/KSPOG/klite/actions/runs/29626290824)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `94e9d19a9a03aa0441be2c7a13febeb3dc8f080c`
- Created: `2026-07-18T02:01:17Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 3: **Collect recent failure details** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## CI: Replace placeholder featured plugins with catalog data

- Run: [29626244358](https://github.com/KSPOG/klite/actions/runs/29626244358)
- Conclusion: `failure`
- Event: `push`
- Commit: `a182ae7651b304c7b4344377036b7010bdc23f2f`
- Created: `2026-07-18T02:00:01Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T02:00:41.9934039Z > Task :copper-tin-miner:jar
build	Build and Test	2026-07-18T02:00:41.9963954Z > Task :copper-tin-miner:assemble
build	Build and Test	2026-07-18T02:00:42.0934119Z > Task :copper-tin-miner:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-18T02:00:42.0963874Z > Task :copper-tin-miner:compileTestJava NO-SOURCE
build	Build and Test	2026-07-18T02:00:42.0964919Z > Task :copper-tin-miner:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T02:00:42.0965804Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-18T02:00:42.0966584Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-18T02:00:42.0967273Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T02:00:42.0967946Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T02:00:42.3928610Z > Task :client:jar
build	Build and Test	2026-07-18T02:00:42.3929558Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T02:00:42.5934619Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T02:00:49.2945275Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T02:00:49.2946725Z
build	Build and Test	2026-07-18T02:00:49.2954455Z 	 * @param duration
build	Build and Test	2026-07-18T02:00:49.2955220Z 	   ^
build	Build and Test	2026-07-18T02:00:49.2956881Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T02:00:49.2958692Z 	 * @param duration
build	Build and Test	2026-07-18T02:00:49.2959288Z 	   ^
build	Build and Test	2026-07-18T02:00:49.2970621Z > Task :client:javadoc
build	Build and Test	2026-07-18T02:00:49.7985798Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:00:49.8032037Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:00:49.8093992Z 	            ^
build	Build and Test	2026-07-18T02:00:49.8133567Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:00:49.8168254Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:00:49.8169521Z 	            ^
build	Build and Test	2026-07-18T02:00:49.8194786Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:00:49.8230908Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:00:49.8237950Z 	            ^
build	Build and Test	2026-07-18T02:00:49.8239523Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:00:49.8241871Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:00:49.8243396Z 	            ^
build	Build and Test	2026-07-18T02:00:49.8245132Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:00:49.8266978Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:00:49.8268383Z 	            ^
build	Build and Test	2026-07-18T02:00:49.8269957Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:00:49.8272274Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:00:49.8273700Z 	            ^
build	Build and Test	2026-07-18T02:00:49.8275099Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:00:49.8277220Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:00:49.8278393Z 	            ^
build	Build and Test	2026-07-18T02:00:49.8280007Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:00:49.8282356Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:00:49.8283691Z 	            ^
build	Build and Test	2026-07-18T02:00:49.8285251Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:00:49.8287543Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:00:49.8288685Z 	            ^
build	Build and Test	2026-07-18T02:00:49.8290063Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T02:00:49.8291588Z 	 * @param itemId
build	Build and Test	2026-07-18T02:00:49.8292015Z 	   ^
build	Build and Test	2026-07-18T02:00:49.8297187Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T02:00:49.8298753Z 	 * @return
build	Build and Test	2026-07-18T02:00:49.8299143Z 	   ^
build	Build and Test	2026-07-18T02:00:50.3327608Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T02:00:50.3328270Z 	               ^
build	Build and Test	2026-07-18T02:00:50.3329694Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T02:00:50.3331421Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T02:00:50.3332190Z 	             ^
build	Build and Test	2026-07-18T02:00:50.3334050Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T02:00:50.3336032Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T02:00:50.3336893Z 	            ^
build	Build and Test	2026-07-18T02:00:50.3338445Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T02:00:50.3340262Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T02:00:50.3341055Z 	            ^
build	Build and Test	2026-07-18T02:00:50.3342627Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T02:00:50.3344915Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T02:00:50.3345836Z 	            ^
build	Build and Test	2026-07-18T02:00:50.3947580Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T02:00:50.3995319Z 	public void select(Color color) {
build	Build and Test	2026-07-18T02:00:50.4023597Z 	            ^
build	Build and Test	2026-07-18T02:00:50.4928047Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T02:00:50.4940239Z 	 * @param dimmed
build	Build and Test	2026-07-18T02:00:50.4940937Z 	   ^
build	Build and Test	2026-07-18T02:00:50.5928055Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T02:00:50.5930110Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:00:50.5930959Z 	            ^
build	Build and Test	2026-07-18T02:00:50.5932561Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T02:00:50.5934638Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:00:50.5935806Z 	            ^
build	Build and Test	2026-07-18T02:00:50.6927541Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T02:00:50.6963984Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T02:00:50.6974019Z 		                                          ^
build	Build and Test	2026-07-18T02:00:54.5926854Z 100 warnings
build	Build and Test	2026-07-18T02:00:56.7927815Z
build	Build and Test	2026-07-18T02:00:56.7928669Z > Task :client:javadocJar
build	Build and Test	2026-07-18T02:00:56.7929275Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T02:01:01.4925684Z > Task :client:shadowJar
build	Build and Test	2026-07-18T02:01:01.4926680Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T02:01:01.4927637Z > Task :client:assemble
build	Build and Test	2026-07-18T02:01:01.8944300Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T02:01:01.9015986Z > Task :client:testClasses
build	Build and Test	2026-07-18T02:01:02.1954053Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T02:01:24.2954100Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T02:01:28.1942495Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T02:01:31.5004982Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T02:01:31.8926890Z > Task :client:pmdMain
build	Build and Test	2026-07-18T02:01:32.1934186Z > Task :client:test
build	Build and Test	2026-07-18T02:01:32.3993666Z
build	Build and Test	2026-07-18T02:01:32.4034345Z /tmp/junit16565322211798936890/junit5786845258641129172/vert.glsl.vert
build	Build and Test	2026-07-18T02:01:32.4114356Z /tmp/junit16565322211798936890/junit5786845258641129172/frag.glsl.frag
build	Build and Test	2026-07-18T02:01:32.5927163Z /tmp/junit16565322211798936890/junit6717190829998637894/vertui.glsl.vert
build	Build and Test	2026-07-18T02:01:32.5953813Z /tmp/junit16565322211798936890/junit6717190829998637894/fragui.glsl.frag
build	Build and Test	2026-07-18T02:01:38.6927980Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T02:01:38.8938763Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T02:01:39.0928452Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T02:01:39.0945382Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T02:01:44.7926229Z
build	Build and Test	2026-07-18T02:01:44.7927369Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T02:01:48.8925689Z
build	Build and Test	2026-07-18T02:01:48.8926875Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784340027726.json
build	Build and Test	2026-07-18T02:01:48.8927978Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T02:01:48.8928230Z
build	Build and Test	2026-07-18T02:01:48.8928601Z * What went wrong:
build	Build and Test	2026-07-18T02:01:48.8928936Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T02:01:48.8929500Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T02:01:48.8930421Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T02:01:48.8931031Z
build	Build and Test	2026-07-18T02:01:48.8931140Z * Try:
build	Build and Test	2026-07-18T02:01:48.8931413Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T02:01:48.8931650Z
build	Build and Test	2026-07-18T02:01:48.8931772Z BUILD FAILED in 1m 28s
build	Build and Test	2026-07-18T02:01:48.8932379Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T02:01:49.3762078Z ##[error]Process completed with exit code 1.
```

## Install release preview homepage: Install the approved KLite release preview

- Run: [29626244343](https://github.com/KSPOG/klite/actions/runs/29626244343)
- Conclusion: `failure`
- Event: `push`
- Commit: `a182ae7651b304c7b4344377036b7010bdc23f2f`
- Created: `2026-07-18T02:00:01Z`

### Failed jobs and steps

- **install** — `failure`
  - Step 4: **Verify generated homepage** — `failure`

### Relevant log context

```text
install	Verify generated homepage	﻿2026-07-18T02:00:12.7442379Z ##[group]Run grep -Fq '/release-preview.css?v=3' marketplace-site/public/index.html
install	Verify generated homepage	2026-07-18T02:00:12.7443115Z ^[[36;1mgrep -Fq '/release-preview.css?v=3' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T02:00:12.7443740Z ^[[36;1mgrep -Fq '/obsidian-release.css?v=1' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T02:00:12.7444403Z ^[[36;1mgrep -Fq '/homepage-featured.js?v=1' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T02:00:12.7445080Z ^[[36;1mgrep -Fq 'class="release-wordmark">KLite</h1>' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T02:00:12.7445715Z ^[[36;1mgrep -Fq 'class="client-window"' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T02:00:12.7446346Z ^[[36;1mgrep -Fq 'id="featured-plugin-list"' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T02:00:12.7446928Z ^[[36;1m! grep -Fq 'GPU Plugin' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T02:00:12.7447488Z ^[[36;1m! grep -Fq 'class="landing-hero"' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T02:00:12.7484401Z shell: /usr/bin/bash -e {0}
install	Verify generated homepage	2026-07-18T02:00:12.7484970Z ##[endgroup]
install	Verify generated homepage	2026-07-18T02:00:12.7571260Z ##[error]Process completed with exit code 1.
```

## Install release preview homepage: Install the approved KLite release preview

- Run: [29626236108](https://github.com/KSPOG/klite/actions/runs/29626236108)
- Conclusion: `failure`
- Event: `push`
- Commit: `5485e23182cc08207584496ec0c866720dca20b2`
- Created: `2026-07-18T01:59:44Z`

### Failed jobs and steps

- **install** — `failure`
  - Step 4: **Verify generated homepage** — `failure`

### Relevant log context

```text
install	Verify generated homepage	﻿2026-07-18T01:59:55.2023248Z ##[group]Run grep -Fq '/release-preview.css?v=3' marketplace-site/public/index.html
install	Verify generated homepage	2026-07-18T01:59:55.2025316Z ^[[36;1mgrep -Fq '/release-preview.css?v=3' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T01:59:55.2027347Z ^[[36;1mgrep -Fq '/obsidian-release.css?v=1' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T01:59:55.2029364Z ^[[36;1mgrep -Fq '/homepage-featured.js?v=1' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T01:59:55.2031612Z ^[[36;1mgrep -Fq 'class="release-wordmark">KLite</h1>' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T01:59:55.2033742Z ^[[36;1mgrep -Fq 'class="client-window"' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T01:59:55.2035716Z ^[[36;1mgrep -Fq 'id="featured-plugin-list"' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T01:59:55.2037599Z ^[[36;1m! grep -Fq 'GPU Plugin' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T01:59:55.2039323Z ^[[36;1m! grep -Fq 'class="landing-hero"' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T01:59:55.2072092Z shell: /usr/bin/bash -e {0}
install	Verify generated homepage	2026-07-18T01:59:55.2073225Z ##[endgroup]
install	Verify generated homepage	2026-07-18T01:59:55.2159313Z ##[error]Process completed with exit code 1.
```

## CI: Simplify release-preview navigation

- Run: [29626236092](https://github.com/KSPOG/klite/actions/runs/29626236092)
- Conclusion: `failure`
- Event: `push`
- Commit: `5485e23182cc08207584496ec0c866720dca20b2`
- Created: `2026-07-18T01:59:44Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T02:00:22.1956863Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T02:00:22.2006416Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T02:00:22.3720055Z > Task :client:jar
build	Build and Test	2026-07-18T02:00:22.3756297Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T02:00:22.7736698Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T02:00:22.7756631Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T02:00:22.7766494Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T02:00:22.7849492Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T02:00:22.8719414Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T02:00:22.8720505Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T02:00:22.8721227Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T02:00:22.8721905Z > Task :runelite-api:build
build	Build and Test	2026-07-18T02:00:30.4723984Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T02:00:30.4746739Z 	 * @param duration
build	Build and Test	2026-07-18T02:00:30.4747106Z
build	Build and Test	2026-07-18T02:00:30.4747480Z > Task :client:javadoc
build	Build and Test	2026-07-18T02:00:30.4782935Z 	   ^
build	Build and Test	2026-07-18T02:00:30.4807764Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T02:00:30.4836896Z 	 * @param duration
build	Build and Test	2026-07-18T02:00:30.4846684Z 	   ^
build	Build and Test	2026-07-18T02:00:30.9718341Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:00:30.9720807Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:00:30.9722210Z 	            ^
build	Build and Test	2026-07-18T02:00:30.9724078Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:00:30.9730672Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:00:30.9732083Z 	            ^
build	Build and Test	2026-07-18T02:00:30.9785448Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:00:30.9817050Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:00:30.9846196Z 	            ^
build	Build and Test	2026-07-18T02:00:30.9848003Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:00:30.9877156Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:00:30.9906207Z 	            ^
build	Build and Test	2026-07-18T02:00:30.9937656Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:00:30.9940835Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:00:30.9966174Z 	            ^
build	Build and Test	2026-07-18T02:00:30.9997564Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:00:31.0026897Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:00:31.0056191Z 	            ^
build	Build and Test	2026-07-18T02:00:31.0067064Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:00:31.0085030Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:00:31.0102270Z 	            ^
build	Build and Test	2026-07-18T02:00:31.0137325Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:00:31.0157342Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:00:31.0159047Z 	            ^
build	Build and Test	2026-07-18T02:00:31.0160891Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:00:31.0163496Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:00:31.0164943Z 	            ^
build	Build and Test	2026-07-18T02:00:31.0719181Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T02:00:31.0746938Z 	 * @param itemId
build	Build and Test	2026-07-18T02:00:31.0776317Z 	   ^
build	Build and Test	2026-07-18T02:00:31.0778093Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T02:00:31.0806537Z 	 * @return
build	Build and Test	2026-07-18T02:00:31.0826517Z 	   ^
build	Build and Test	2026-07-18T02:00:31.4751019Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T02:00:31.4751766Z 	               ^
build	Build and Test	2026-07-18T02:00:31.4753252Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T02:00:31.4761528Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T02:00:31.4762362Z 	             ^
build	Build and Test	2026-07-18T02:00:31.4763956Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T02:00:31.4766110Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T02:00:31.4767018Z 	            ^
build	Build and Test	2026-07-18T02:00:31.4768600Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T02:00:31.4770444Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T02:00:31.4771284Z 	            ^
build	Build and Test	2026-07-18T02:00:31.4772846Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T02:00:31.4774727Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T02:00:31.4775822Z 	            ^
build	Build and Test	2026-07-18T02:00:31.5717639Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T02:00:31.5719633Z 	public void select(Color color) {
build	Build and Test	2026-07-18T02:00:31.5720359Z 	            ^
build	Build and Test	2026-07-18T02:00:31.5721962Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T02:00:31.5724191Z 	 * @param dimmed
build	Build and Test	2026-07-18T02:00:31.5724799Z 	   ^
build	Build and Test	2026-07-18T02:00:31.6717861Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T02:00:31.6720471Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:00:31.6721334Z 	            ^
build	Build and Test	2026-07-18T02:00:31.6722946Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T02:00:31.6724806Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:00:31.6725824Z 	            ^
build	Build and Test	2026-07-18T02:00:31.7719508Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T02:00:31.7723195Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T02:00:31.7724283Z 		                                          ^
build	Build and Test	2026-07-18T02:00:36.4716642Z 100 warnings
build	Build and Test	2026-07-18T02:00:38.8716468Z
build	Build and Test	2026-07-18T02:00:38.8717676Z > Task :client:javadocJar
build	Build and Test	2026-07-18T02:00:38.8718240Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T02:00:43.5717868Z > Task :client:shadowJar
build	Build and Test	2026-07-18T02:00:43.5726859Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T02:00:43.5727846Z > Task :client:assemble
build	Build and Test	2026-07-18T02:00:43.9734726Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T02:00:43.9796927Z > Task :client:testClasses
build	Build and Test	2026-07-18T02:00:44.0738957Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T02:01:04.6716903Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T02:01:07.7731929Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T02:01:13.5746744Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T02:01:13.9746581Z > Task :client:pmdMain
build	Build and Test	2026-07-18T02:01:14.0719028Z > Task :client:test
build	Build and Test	2026-07-18T02:01:16.9716337Z
build	Build and Test	2026-07-18T02:01:16.9747270Z /tmp/junit830391306425169707/junit7904874645748889028/vert.glsl.vert
build	Build and Test	2026-07-18T02:01:16.9947015Z /tmp/junit830391306425169707/junit7904874645748889028/frag.glsl.frag
build	Build and Test	2026-07-18T02:01:17.2747576Z /tmp/junit830391306425169707/junit4062187121322490259/vertui.glsl.vert
build	Build and Test	2026-07-18T02:01:17.2786723Z /tmp/junit830391306425169707/junit4062187121322490259/fragui.glsl.frag
build	Build and Test	2026-07-18T02:01:18.9737912Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T02:01:19.2717784Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T02:01:19.4718177Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T02:01:19.4797896Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T02:01:25.3716365Z
build	Build and Test	2026-07-18T02:01:25.3776738Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T02:01:32.7716602Z
build	Build and Test	2026-07-18T02:01:32.7717999Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784340008002.json
build	Build and Test	2026-07-18T02:01:32.7719183Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T02:01:32.7719463Z
build	Build and Test	2026-07-18T02:01:32.7719588Z * What went wrong:
build	Build and Test	2026-07-18T02:01:32.7719930Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T02:01:32.7720560Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T02:01:32.7721580Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T02:01:32.7724508Z
build	Build and Test	2026-07-18T02:01:32.7724739Z * Try:
build	Build and Test	2026-07-18T02:01:32.7725173Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T02:01:32.7725802Z
build	Build and Test	2026-07-18T02:01:32.7726011Z BUILD FAILED in 1m 35s
build	Build and Test	2026-07-18T02:01:32.7726506Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T02:01:33.2473020Z ##[error]Process completed with exit code 1.
```

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29626228894](https://github.com/KSPOG/klite/actions/runs/29626228894)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `2c020dbb3d71aa8acc3ab26230ce5978ab0e89a9`
- Created: `2026-07-18T01:59:29Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 3: **Collect recent failure details** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## CI: Render homepage plugins from the published catalog

- Run: [29626227769](https://github.com/KSPOG/klite/actions/runs/29626227769)
- Conclusion: `failure`
- Event: `push`
- Commit: `2c020dbb3d71aa8acc3ab26230ce5978ab0e89a9`
- Created: `2026-07-18T01:59:26Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T01:59:59.3351620Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T01:59:59.3374505Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T01:59:59.7172223Z > Task :client:jar
build	Build and Test	2026-07-18T01:59:59.7187800Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T02:00:00.0182972Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T02:00:00.0184081Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T02:00:00.0185029Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T02:00:00.0185950Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T02:00:00.1168515Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T02:00:00.1171382Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T02:00:00.1172170Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T02:00:00.1172884Z > Task :runelite-api:build
build	Build and Test	2026-07-18T02:00:08.3175934Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T02:00:08.3177454Z
build	Build and Test	2026-07-18T02:00:08.3178036Z 	 * @param duration
build	Build and Test	2026-07-18T02:00:08.3178780Z 	   ^
build	Build and Test	2026-07-18T02:00:08.3180347Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T02:00:08.3189901Z 	 * @param duration
build	Build and Test	2026-07-18T02:00:08.3190574Z 	   ^
build	Build and Test	2026-07-18T02:00:08.3202113Z > Task :client:javadoc
build	Build and Test	2026-07-18T02:00:08.8167088Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:00:08.8202285Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:00:08.8203834Z 	            ^
build	Build and Test	2026-07-18T02:00:08.8233040Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:00:08.8275605Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:00:08.8301674Z 	            ^
build	Build and Test	2026-07-18T02:00:08.8332865Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:00:08.8335396Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:00:08.8361775Z 	            ^
build	Build and Test	2026-07-18T02:00:08.8363436Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:00:08.8365808Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:00:08.8367216Z 	            ^
build	Build and Test	2026-07-18T02:00:08.8369063Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:00:08.8372174Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:00:08.8373504Z 	            ^
build	Build and Test	2026-07-18T02:00:08.8375228Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:00:08.8377677Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:00:08.8379347Z 	            ^
build	Build and Test	2026-07-18T02:00:08.8381215Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:00:08.8383520Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:00:08.8384836Z 	            ^
build	Build and Test	2026-07-18T02:00:08.8386582Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:00:08.8389105Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:00:08.8390446Z 	            ^
build	Build and Test	2026-07-18T02:00:08.8392451Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:00:08.8394975Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:00:08.8396365Z 	            ^
build	Build and Test	2026-07-18T02:00:08.8397945Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T02:00:08.8399696Z 	 * @param itemId
build	Build and Test	2026-07-18T02:00:08.8400354Z 	   ^
build	Build and Test	2026-07-18T02:00:08.8402126Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T02:00:08.8403937Z 	 * @return
build	Build and Test	2026-07-18T02:00:08.8404541Z 	   ^
build	Build and Test	2026-07-18T02:00:09.3215368Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T02:00:09.3216086Z 	               ^
build	Build and Test	2026-07-18T02:00:09.3217538Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T02:00:09.3219205Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T02:00:09.3219936Z 	             ^
build	Build and Test	2026-07-18T02:00:09.3221733Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T02:00:09.3223603Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T02:00:09.3224433Z 	            ^
build	Build and Test	2026-07-18T02:00:09.3225963Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T02:00:09.3227739Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T02:00:09.3228537Z 	            ^
build	Build and Test	2026-07-18T02:00:09.3230081Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T02:00:09.3232141Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T02:00:09.3232981Z 	            ^
build	Build and Test	2026-07-18T02:00:09.4175325Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T02:00:09.4192080Z 	public void select(Color color) {
build	Build and Test	2026-07-18T02:00:09.4192921Z 	            ^
build	Build and Test	2026-07-18T02:00:09.5173487Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T02:00:09.5176708Z 	 * @param dimmed
build	Build and Test	2026-07-18T02:00:09.5184274Z 	   ^
build	Build and Test	2026-07-18T02:00:09.5185901Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T02:00:09.5187752Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:00:09.5188950Z 	            ^
build	Build and Test	2026-07-18T02:00:09.5190593Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T02:00:09.5193072Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:00:09.5194018Z 	            ^
build	Build and Test	2026-07-18T02:00:09.6192833Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T02:00:09.6204494Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T02:00:09.6212080Z 		                                          ^
build	Build and Test	2026-07-18T02:00:14.5165066Z 100 warnings
build	Build and Test	2026-07-18T02:00:16.9165082Z
build	Build and Test	2026-07-18T02:00:16.9166173Z > Task :client:javadocJar
build	Build and Test	2026-07-18T02:00:16.9166976Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T02:00:21.6166181Z > Task :client:shadowJar
build	Build and Test	2026-07-18T02:00:21.6167317Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T02:00:21.6168205Z > Task :client:assemble
build	Build and Test	2026-07-18T02:00:21.9170179Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T02:00:21.9202211Z > Task :client:testClasses
build	Build and Test	2026-07-18T02:00:22.1167950Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T02:00:41.7182749Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T02:00:44.8212983Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T02:00:51.6192177Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T02:00:52.0181948Z > Task :client:pmdMain
build	Build and Test	2026-07-18T02:00:52.1201482Z > Task :client:test
build	Build and Test	2026-07-18T02:00:54.3164512Z
build	Build and Test	2026-07-18T02:00:54.3192145Z /tmp/junit9493692974890834929/junit13932164986236316275/vert.glsl.vert
build	Build and Test	2026-07-18T02:00:54.3193445Z /tmp/junit9493692974890834929/junit13932164986236316275/frag.glsl.frag
build	Build and Test	2026-07-18T02:00:54.4165232Z /tmp/junit9493692974890834929/junit12314623569809593487/vertui.glsl.vert
build	Build and Test	2026-07-18T02:00:54.4198009Z /tmp/junit9493692974890834929/junit12314623569809593487/fragui.glsl.frag
build	Build and Test	2026-07-18T02:00:55.2203053Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T02:00:55.4183203Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T02:00:55.6173619Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T02:00:55.6202940Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T02:01:02.1167421Z
build	Build and Test	2026-07-18T02:01:02.1192081Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T02:01:08.9169975Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784339986388.json
build	Build and Test	2026-07-18T02:01:08.9173967Z
build	Build and Test	2026-07-18T02:01:08.9174323Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T02:01:08.9175295Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T02:01:08.9175729Z
build	Build and Test	2026-07-18T02:01:08.9175912Z * What went wrong:
build	Build and Test	2026-07-18T02:01:08.9176404Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T02:01:08.9177308Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T02:01:08.9178770Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T02:01:08.9180059Z
build	Build and Test	2026-07-18T02:01:08.9180244Z * Try:
build	Build and Test	2026-07-18T02:01:08.9180683Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T02:01:08.9181354Z
build	Build and Test	2026-07-18T02:01:08.9181558Z BUILD FAILED in 1m 29s
build	Build and Test	2026-07-18T02:01:09.4172386Z ##[error]Process completed with exit code 1.
```

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29626216102](https://github.com/KSPOG/klite/actions/runs/29626216102)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `2eec27e7fc673e16baaa0f77302ae663f885e7e3`
- Created: `2026-07-18T01:59:04Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 3: **Collect recent failure details** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## CI: Apply authentic obsidian release styling

- Run: [29626190445](https://github.com/KSPOG/klite/actions/runs/29626190445)
- Conclusion: `failure`
- Event: `push`
- Commit: `2eec27e7fc673e16baaa0f77302ae663f885e7e3`
- Created: `2026-07-18T01:58:09Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T01:58:51.6385540Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T01:58:51.6428434Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T01:58:52.1393488Z > Task :client:jar
build	Build and Test	2026-07-18T01:58:52.1398535Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T01:58:52.3391516Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:58:52.3392930Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T01:58:52.3393814Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T01:58:52.3394640Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T01:58:52.3395478Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T01:58:52.3396215Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T01:58:52.3396949Z > Task :runelite-api:build
build	Build and Test	2026-07-18T01:58:52.4380965Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T01:58:59.0386168Z
build	Build and Test	2026-07-18T01:58:59.0387099Z > Task :client:javadoc
build	Build and Test	2026-07-18T01:58:59.0389293Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T01:58:59.0390880Z 	 * @param duration
build	Build and Test	2026-07-18T01:58:59.0391335Z 	   ^
build	Build and Test	2026-07-18T01:58:59.0392767Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T01:58:59.0394417Z 	 * @param duration
build	Build and Test	2026-07-18T01:58:59.0394867Z 	   ^
build	Build and Test	2026-07-18T01:58:59.4410055Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:58:59.4459245Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:59.4460622Z 	            ^
build	Build and Test	2026-07-18T01:58:59.4493362Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:58:59.4518927Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:59.4520097Z 	            ^
build	Build and Test	2026-07-18T01:58:59.4521815Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:58:59.4524189Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:59.4525342Z 	            ^
build	Build and Test	2026-07-18T01:58:59.4526822Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:58:59.4529347Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:59.4530475Z 	            ^
build	Build and Test	2026-07-18T01:58:59.4532346Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:58:59.4535594Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:59.4558525Z 	            ^
build	Build and Test	2026-07-18T01:58:59.4570743Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:58:59.4573339Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:59.4574787Z 	            ^
build	Build and Test	2026-07-18T01:58:59.4576373Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:58:59.4578959Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:59.4580352Z 	            ^
build	Build and Test	2026-07-18T01:58:59.4582160Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:58:59.4584788Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:59.4586186Z 	            ^
build	Build and Test	2026-07-18T01:58:59.4588277Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:58:59.4590984Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:59.4618463Z 	            ^
build	Build and Test	2026-07-18T01:58:59.5433964Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T01:58:59.5488355Z 	 * @param itemId
build	Build and Test	2026-07-18T01:58:59.5488939Z 	   ^
build	Build and Test	2026-07-18T01:58:59.5529559Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T01:58:59.5558419Z 	 * @return
build	Build and Test	2026-07-18T01:58:59.5558946Z 	   ^
build	Build and Test	2026-07-18T01:59:00.0455046Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T01:59:00.0455756Z 	               ^
build	Build and Test	2026-07-18T01:59:00.0457303Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T01:59:00.0459272Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T01:59:00.0460044Z 	             ^
build	Build and Test	2026-07-18T01:59:00.0461708Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T01:59:00.0463694Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T01:59:00.0464623Z 	            ^
build	Build and Test	2026-07-18T01:59:00.0466267Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T01:59:00.0473738Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T01:59:00.0474704Z 	            ^
build	Build and Test	2026-07-18T01:59:00.0476394Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T01:59:00.0478742Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T01:59:00.0480398Z 	            ^
build	Build and Test	2026-07-18T01:59:00.0482097Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T01:59:00.0483965Z 	public void select(Color color) {
build	Build and Test	2026-07-18T01:59:00.0484718Z 	            ^
build	Build and Test	2026-07-18T01:59:00.1383138Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T01:59:00.1399195Z 	 * @param dimmed
build	Build and Test	2026-07-18T01:59:00.1399956Z 	   ^
build	Build and Test	2026-07-18T01:59:00.1401612Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T01:59:00.1403619Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:59:00.1404519Z 	            ^
build	Build and Test	2026-07-18T01:59:00.1406197Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T01:59:00.1408365Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:59:00.1409115Z 	            ^
build	Build and Test	2026-07-18T01:59:00.2382042Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T01:59:00.2386007Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T01:59:00.2387157Z 		                                          ^
build	Build and Test	2026-07-18T01:59:04.5380040Z 100 warnings
build	Build and Test	2026-07-18T01:59:06.9380459Z
build	Build and Test	2026-07-18T01:59:06.9381331Z > Task :client:javadocJar
build	Build and Test	2026-07-18T01:59:06.9382257Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T01:59:11.5381420Z > Task :client:shadowJar
build	Build and Test	2026-07-18T01:59:11.5382662Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T01:59:11.5383585Z > Task :client:assemble
build	Build and Test	2026-07-18T01:59:11.9388928Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:59:11.9419045Z > Task :client:testClasses
build	Build and Test	2026-07-18T01:59:12.2432085Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T01:59:31.6399921Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T01:59:36.9390066Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T01:59:41.5380353Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T01:59:42.0398540Z > Task :client:pmdMain
build	Build and Test	2026-07-18T01:59:42.2380926Z > Task :client:test
build	Build and Test	2026-07-18T01:59:43.7388115Z
build	Build and Test	2026-07-18T01:59:43.7435784Z /tmp/junit11437552094463446864/junit3358380902139930863/vert.glsl.vert
build	Build and Test	2026-07-18T01:59:43.7569006Z /tmp/junit11437552094463446864/junit3358380902139930863/frag.glsl.frag
build	Build and Test	2026-07-18T01:59:43.9418930Z /tmp/junit11437552094463446864/junit7786974085606018280/vertui.glsl.vert
build	Build and Test	2026-07-18T01:59:43.9538964Z /tmp/junit11437552094463446864/junit7786974085606018280/fragui.glsl.frag
build	Build and Test	2026-07-18T01:59:47.1411758Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T01:59:47.3440017Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T01:59:47.5390275Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T01:59:47.5450180Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T01:59:53.7388081Z
build	Build and Test	2026-07-18T01:59:53.7442312Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T01:59:59.1381839Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784339918046.json
build	Build and Test	2026-07-18T01:59:59.1385464Z
build	Build and Test	2026-07-18T01:59:59.1387001Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T01:59:59.1398750Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T01:59:59.1399367Z
build	Build and Test	2026-07-18T01:59:59.1399724Z * What went wrong:
build	Build and Test	2026-07-18T01:59:59.1400430Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T01:59:59.1401601Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T01:59:59.1403308Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T01:59:59.1404476Z
build	Build and Test	2026-07-18T01:59:59.1404796Z * Try:
build	Build and Test	2026-07-18T01:59:59.1405490Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T01:59:59.1405925Z
build	Build and Test	2026-07-18T01:59:59.1406137Z BUILD FAILED in 1m 28s
build	Build and Test	2026-07-18T01:59:59.6790752Z ##[error]Process completed with exit code 1.
```

## CI: Add obsidian fracture background artwork

- Run: [29626172779](https://github.com/KSPOG/klite/actions/runs/29626172779)
- Conclusion: `failure`
- Event: `push`
- Commit: `6101960a049537e27a923f7dbaa15b532c2636a9`
- Created: `2026-07-18T01:57:33Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T01:58:13.4472684Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T01:58:13.4505525Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T01:58:13.8366263Z > Task :client:jar
build	Build and Test	2026-07-18T01:58:13.8366893Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T01:58:14.1366188Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:58:14.1395718Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T01:58:14.1396725Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T01:58:14.2370637Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T01:58:14.2395868Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T01:58:14.2425563Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T01:58:14.2445396Z > Task :runelite-api:build
build	Build and Test	2026-07-18T01:58:14.3346077Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T01:58:20.3375256Z
build	Build and Test	2026-07-18T01:58:20.3384104Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T01:58:20.3395717Z 	 * @param duration
build	Build and Test	2026-07-18T01:58:20.3396241Z > Task :client:javadoc
build	Build and Test	2026-07-18T01:58:20.3425804Z 	   ^
build	Build and Test	2026-07-18T01:58:20.3427448Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T01:58:20.3429227Z 	 * @param duration
build	Build and Test	2026-07-18T01:58:20.3429824Z 	   ^
build	Build and Test	2026-07-18T01:58:20.8346445Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:58:20.8391207Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:20.8414497Z 	            ^
build	Build and Test	2026-07-18T01:58:20.8446754Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:58:20.8476042Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:20.8477406Z 	            ^
build	Build and Test	2026-07-18T01:58:20.8506846Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:58:20.8536228Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:20.8565590Z 	            ^
build	Build and Test	2026-07-18T01:58:20.8596422Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:58:20.8598935Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:20.8650871Z 	            ^
build	Build and Test	2026-07-18T01:58:20.8727086Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:58:20.8758194Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:20.8788897Z 	            ^
build	Build and Test	2026-07-18T01:58:20.8816773Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:58:20.8819993Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:20.8821403Z 	            ^
build	Build and Test	2026-07-18T01:58:20.8823039Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:58:20.8825734Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:20.8827259Z 	            ^
build	Build and Test	2026-07-18T01:58:20.8829098Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:58:20.8831761Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:20.8833537Z 	            ^
build	Build and Test	2026-07-18T01:58:20.8835512Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:58:20.8838153Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:20.8839511Z 	            ^
build	Build and Test	2026-07-18T01:58:20.8841074Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T01:58:20.8842874Z 	 * @param itemId
build	Build and Test	2026-07-18T01:58:20.8843512Z 	   ^
build	Build and Test	2026-07-18T01:58:20.8845318Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T01:58:20.8847158Z 	 * @return
build	Build and Test	2026-07-18T01:58:20.8847765Z 	   ^
build	Build and Test	2026-07-18T01:58:21.3428596Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T01:58:21.3429347Z 	               ^
build	Build and Test	2026-07-18T01:58:21.3430911Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T01:58:21.3432564Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T01:58:21.3433278Z 	             ^
build	Build and Test	2026-07-18T01:58:21.3435109Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T01:58:21.3437084Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T01:58:21.3438069Z 	            ^
build	Build and Test	2026-07-18T01:58:21.3439724Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T01:58:21.3444297Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T01:58:21.3475702Z 	            ^
build	Build and Test	2026-07-18T01:58:21.3494213Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T01:58:21.3496503Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T01:58:21.3497429Z 	            ^
build	Build and Test	2026-07-18T01:58:21.3499029Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T01:58:21.3500943Z 	public void select(Color color) {
build	Build and Test	2026-07-18T01:58:21.3501745Z 	            ^
build	Build and Test	2026-07-18T01:58:21.4350875Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T01:58:21.4360227Z 	 * @param dimmed
build	Build and Test	2026-07-18T01:58:21.4361090Z 	   ^
build	Build and Test	2026-07-18T01:58:21.4362781Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T01:58:21.4364769Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:58:21.4366009Z 	            ^
build	Build and Test	2026-07-18T01:58:21.4369978Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T01:58:21.4372099Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:58:21.4373029Z 	            ^
build	Build and Test	2026-07-18T01:58:21.5367185Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T01:58:21.5369364Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T01:58:21.5378032Z 		                                          ^
build	Build and Test	2026-07-18T01:58:25.6344304Z 100 warnings
build	Build and Test	2026-07-18T01:58:28.0344353Z
build	Build and Test	2026-07-18T01:58:28.0345503Z > Task :client:javadocJar
build	Build and Test	2026-07-18T01:58:28.0346327Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T01:58:32.7370292Z > Task :client:shadowJar
build	Build and Test	2026-07-18T01:58:32.7389313Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T01:58:32.7395770Z > Task :client:assemble
build	Build and Test	2026-07-18T01:58:33.0379606Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:58:33.0395695Z > Task :client:testClasses
build	Build and Test	2026-07-18T01:58:33.2366108Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T01:58:52.0366017Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T01:58:56.4447027Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T01:59:02.1372891Z /tmp/junit6600105109584189800/junit6987792290711066786/vert.glsl.vert
build	Build and Test	2026-07-18T01:59:02.1420106Z /tmp/junit6600105109584189800/junit6987792290711066786/frag.glsl.frag
build	Build and Test	2026-07-18T01:59:02.3345719Z /tmp/junit6600105109584189800/junit3960614600824316411/vertui.glsl.vert
build	Build and Test	2026-07-18T01:59:02.3375661Z /tmp/junit6600105109584189800/junit3960614600824316411/fragui.glsl.frag
build	Build and Test	2026-07-18T01:59:02.7385973Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T01:59:03.1349777Z > Task :client:pmdMain
build	Build and Test	2026-07-18T01:59:03.2365945Z > Task :client:test
build	Build and Test	2026-07-18T01:59:06.5385479Z
build	Build and Test	2026-07-18T01:59:06.5436135Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T01:59:06.8366957Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T01:59:07.0348089Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T01:59:07.0417617Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T01:59:12.8368258Z
build	Build and Test	2026-07-18T01:59:12.8425816Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T01:59:17.9348069Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784339881265.json
build	Build and Test	2026-07-18T01:59:17.9349320Z
build	Build and Test	2026-07-18T01:59:17.9367235Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T01:59:17.9395761Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T01:59:17.9396710Z
build	Build and Test	2026-07-18T01:59:17.9404662Z * What went wrong:
build	Build and Test	2026-07-18T01:59:17.9405669Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T01:59:17.9406627Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T01:59:17.9408124Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T01:59:17.9408931Z
build	Build and Test	2026-07-18T01:59:17.9409076Z * Try:
build	Build and Test	2026-07-18T01:59:17.9409450Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T01:59:17.9409801Z
build	Build and Test	2026-07-18T01:59:17.9409986Z BUILD FAILED in 1m 24s
build	Build and Test	2026-07-18T01:59:18.4906600Z ##[error]Process completed with exit code 1.
```

## CI: Serialize release-preview homepage generation

- Run: [29626159892](https://github.com/KSPOG/klite/actions/runs/29626159892)
- Conclusion: `failure`
- Event: `push`
- Commit: `2e7b9bc9e22dbf755cc23ab24493ccd92fc822e1`
- Created: `2026-07-18T01:57:06Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T01:57:50.2912520Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T01:57:50.2913501Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T01:57:50.3785756Z > Task :client:jar
build	Build and Test	2026-07-18T01:57:50.3834007Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T01:57:50.6765861Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T01:57:50.7785938Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:57:50.7805251Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T01:57:50.7825184Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T01:57:50.8759299Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T01:57:50.8768411Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T01:57:50.8769242Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T01:57:50.8770146Z > Task :runelite-api:build
build	Build and Test	2026-07-18T01:57:57.8756310Z
build	Build and Test	2026-07-18T01:57:57.8760844Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T01:57:57.8762771Z > Task :client:javadoc
build	Build and Test	2026-07-18T01:57:57.8785828Z 	 * @param duration
build	Build and Test	2026-07-18T01:57:57.8790832Z 	   ^
build	Build and Test	2026-07-18T01:57:57.8792327Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T01:57:57.8794074Z 	 * @param duration
build	Build and Test	2026-07-18T01:57:57.8794895Z 	   ^
build	Build and Test	2026-07-18T01:57:58.3772207Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:57:58.3775960Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:57:58.3793338Z 	            ^
build	Build and Test	2026-07-18T01:57:58.3795292Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:57:58.3797645Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:57:58.3798929Z 	            ^
build	Build and Test	2026-07-18T01:57:58.3800584Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:57:58.3802901Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:57:58.3804160Z 	            ^
build	Build and Test	2026-07-18T01:57:58.3805953Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:57:58.3808265Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:57:58.3809574Z 	            ^
build	Build and Test	2026-07-18T01:57:58.3811235Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:57:58.3814834Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:57:58.3816138Z 	            ^
build	Build and Test	2026-07-18T01:57:58.3817777Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:57:58.3820171Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:57:58.3821435Z 	            ^
build	Build and Test	2026-07-18T01:57:58.3822925Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:57:58.3825361Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:57:58.3826680Z 	            ^
build	Build and Test	2026-07-18T01:57:58.3828440Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:57:58.3830917Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:57:58.3832179Z 	            ^
build	Build and Test	2026-07-18T01:57:58.3833898Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:57:58.3836515Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:57:58.3837799Z 	            ^
build	Build and Test	2026-07-18T01:57:58.4756807Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T01:57:58.4785505Z 	 * @param itemId
build	Build and Test	2026-07-18T01:57:58.4815267Z 	   ^
build	Build and Test	2026-07-18T01:57:58.4816946Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T01:57:58.4848854Z 	 * @return
build	Build and Test	2026-07-18T01:57:58.4863047Z 	   ^
build	Build and Test	2026-07-18T01:57:58.8160372Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T01:57:58.8161002Z 	               ^
build	Build and Test	2026-07-18T01:57:58.8162310Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T01:57:58.8163771Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T01:57:58.8164377Z 	             ^
build	Build and Test	2026-07-18T01:57:58.8165986Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T01:57:58.8167653Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T01:57:58.8168394Z 	            ^
build	Build and Test	2026-07-18T01:57:58.8169790Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T01:57:58.8171389Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T01:57:58.8172108Z 	            ^
build	Build and Test	2026-07-18T01:57:58.8173540Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T01:57:58.8175359Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T01:57:58.8176128Z 	            ^
build	Build and Test	2026-07-18T01:57:58.8751577Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T01:57:58.8753449Z 	public void select(Color color) {
build	Build and Test	2026-07-18T01:57:58.8754242Z 	            ^
build	Build and Test	2026-07-18T01:57:58.8797368Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T01:57:58.8799449Z 	 * @param dimmed
build	Build and Test	2026-07-18T01:57:58.8800022Z 	   ^
build	Build and Test	2026-07-18T01:57:58.9750418Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T01:57:58.9752377Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:57:58.9753237Z 	            ^
build	Build and Test	2026-07-18T01:57:58.9755074Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T01:57:58.9758645Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:57:58.9759552Z 	            ^
build	Build and Test	2026-07-18T01:57:58.9761107Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T01:57:58.9768655Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T01:57:58.9769607Z 		                                          ^
build	Build and Test	2026-07-18T01:58:03.2749641Z 100 warnings
build	Build and Test	2026-07-18T01:58:05.5750756Z
build	Build and Test	2026-07-18T01:58:05.5751714Z > Task :client:javadocJar
build	Build and Test	2026-07-18T01:58:05.5752591Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T01:58:10.1749592Z > Task :client:shadowJar
build	Build and Test	2026-07-18T01:58:10.1751271Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T01:58:10.1752065Z > Task :client:assemble
build	Build and Test	2026-07-18T01:58:10.5749600Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:58:10.5778708Z > Task :client:testClasses
build	Build and Test	2026-07-18T01:58:10.7787797Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T01:58:30.7765573Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T01:58:31.4756006Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T01:58:40.1768333Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T01:58:40.5785559Z > Task :client:pmdMain
build	Build and Test	2026-07-18T01:58:40.7797961Z > Task :client:test
build	Build and Test	2026-07-18T01:58:41.5764955Z
build	Build and Test	2026-07-18T01:58:41.5865641Z /tmp/junit8044041276315886904/junit11678023863944073386/vert.glsl.vert
build	Build and Test	2026-07-18T01:58:41.5985603Z /tmp/junit8044041276315886904/junit11678023863944073386/frag.glsl.frag
build	Build and Test	2026-07-18T01:58:41.7776934Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T01:58:41.7835578Z /tmp/junit8044041276315886904/junit13457538239066738775/vertui.glsl.vert
build	Build and Test	2026-07-18T01:58:41.7892713Z /tmp/junit8044041276315886904/junit13457538239066738775/fragui.glsl.frag
build	Build and Test	2026-07-18T01:58:42.0776809Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T01:58:42.2777131Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T01:58:42.2856802Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T01:58:48.2777088Z
build	Build and Test	2026-07-18T01:58:48.2865679Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T01:58:54.2750041Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784339857228.json
build	Build and Test	2026-07-18T01:58:54.2753243Z
build	Build and Test	2026-07-18T01:58:54.2753516Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T01:58:54.2756210Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T01:58:54.2756871Z
build	Build and Test	2026-07-18T01:58:54.2757260Z * What went wrong:
build	Build and Test	2026-07-18T01:58:54.2757948Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T01:58:54.2759133Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T01:58:54.2760816Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T01:58:54.2761938Z
build	Build and Test	2026-07-18T01:58:54.2762259Z * Try:
build	Build and Test	2026-07-18T01:58:54.2762909Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T01:58:54.2763474Z
build	Build and Test	2026-07-18T01:58:54.2763802Z BUILD FAILED in 1m 28s
build	Build and Test	2026-07-18T01:58:54.7958703Z ##[error]Process completed with exit code 1.
```

