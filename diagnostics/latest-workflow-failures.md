# Recent GitHub Actions failures

Generated: 2026-07-18T00:56:53.892165+00:00
Repository: `KSPOG/klite`
Failed runs inspected: **15**

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29624179610](https://github.com/KSPOG/klite/actions/runs/29624179610)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `f23599ad48a00a3347e38af7476540c56a7af5b9`
- Created: `2026-07-18T00:56:26Z`

### Failed jobs and steps

No failed job metadata was returned.

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29624167237](https://github.com/KSPOG/klite/actions/runs/29624167237)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `f23599ad48a00a3347e38af7476540c56a7af5b9`
- Created: `2026-07-18T00:56:06Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 3: **Collect recent failure details** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## CI: Apply announcement reference design

- Run: [29624119127](https://github.com/KSPOG/klite/actions/runs/29624119127)
- Conclusion: `failure`
- Event: `push`
- Commit: `f52532981af7ea37b0c571f257d768c008e408ae`
- Created: `2026-07-18T00:54:43Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T00:55:14.2286823Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-18T00:55:14.2316236Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-18T00:55:14.2316971Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T00:55:14.2317592Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T00:55:14.7296717Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T00:55:14.8284619Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T00:55:14.8309465Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T00:55:14.8336221Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T00:55:14.8366209Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T00:55:14.8366887Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T00:55:14.8371606Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T00:55:14.8372179Z > Task :runelite-api:build
build	Build and Test	2026-07-18T00:55:21.3300182Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T00:55:21.3301537Z
build	Build and Test	2026-07-18T00:55:21.3301940Z 	 * @param duration
build	Build and Test	2026-07-18T00:55:21.3302329Z > Task :client:javadoc
build	Build and Test	2026-07-18T00:55:21.3302780Z 	   ^
build	Build and Test	2026-07-18T00:55:21.3304023Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T00:55:21.3305462Z 	 * @param duration
build	Build and Test	2026-07-18T00:55:21.3306320Z 	   ^
build	Build and Test	2026-07-18T00:55:21.7297983Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:55:21.7346890Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:55:21.7389265Z 	            ^
build	Build and Test	2026-07-18T00:55:21.7449429Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:55:21.7476574Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:55:21.7506366Z 	            ^
build	Build and Test	2026-07-18T00:55:21.7537258Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:55:21.7541492Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:55:21.7542310Z 	            ^
build	Build and Test	2026-07-18T00:55:21.7543409Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:55:21.7544867Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:55:21.7545859Z 	            ^
build	Build and Test	2026-07-18T00:55:21.7547000Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:55:21.7551149Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:55:21.7552714Z 	            ^
build	Build and Test	2026-07-18T00:55:21.7602327Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:55:21.7616798Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:55:21.7625986Z 	            ^
build	Build and Test	2026-07-18T00:55:21.7650637Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:55:21.7676820Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:55:21.7678053Z 	            ^
build	Build and Test	2026-07-18T00:55:21.7708771Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:55:21.7747952Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:55:21.7766372Z 	            ^
build	Build and Test	2026-07-18T00:55:21.7768093Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:55:21.7770186Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:55:21.7771270Z 	            ^
build	Build and Test	2026-07-18T00:55:21.8337663Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T00:55:21.8346166Z 	 * @param itemId
build	Build and Test	2026-07-18T00:55:21.8376151Z 	   ^
build	Build and Test	2026-07-18T00:55:21.8407346Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T00:55:21.8409186Z 	 * @return
build	Build and Test	2026-07-18T00:55:21.8409796Z 	   ^
build	Build and Test	2026-07-18T00:55:22.2326091Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T00:55:22.2327478Z 	               ^
build	Build and Test	2026-07-18T00:55:22.2332001Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T00:55:22.2333185Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T00:55:22.2333673Z 	             ^
build	Build and Test	2026-07-18T00:55:22.2334811Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T00:55:22.2336471Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T00:55:22.2337059Z 	            ^
build	Build and Test	2026-07-18T00:55:22.2338242Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T00:55:22.2339615Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T00:55:22.2340176Z 	            ^
build	Build and Test	2026-07-18T00:55:22.2341066Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T00:55:22.2341967Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T00:55:22.2342363Z 	            ^
build	Build and Test	2026-07-18T00:55:22.2343111Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T00:55:22.2343964Z 	public void select(Color color) {
build	Build and Test	2026-07-18T00:55:22.2344283Z 	            ^
build	Build and Test	2026-07-18T00:55:22.3309417Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T00:55:22.3311799Z 	 * @param dimmed
build	Build and Test	2026-07-18T00:55:22.3313029Z 	   ^
build	Build and Test	2026-07-18T00:55:22.4281604Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T00:55:22.4283292Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T00:55:22.4284051Z 	            ^
build	Build and Test	2026-07-18T00:55:22.4285662Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T00:55:22.4287652Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T00:55:22.4288373Z 	            ^
build	Build and Test	2026-07-18T00:55:22.5282139Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T00:55:22.5284224Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T00:55:22.5285189Z 		                                          ^
build	Build and Test	2026-07-18T00:55:26.9281402Z 100 warnings
build	Build and Test	2026-07-18T00:55:29.3280291Z
build	Build and Test	2026-07-18T00:55:29.3281665Z > Task :client:javadocJar
build	Build and Test	2026-07-18T00:55:29.3282778Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T00:55:33.9296950Z > Task :client:shadowJar
build	Build and Test	2026-07-18T00:55:33.9297818Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T00:55:33.9298380Z > Task :client:assemble
build	Build and Test	2026-07-18T00:55:34.3335779Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T00:55:34.3399439Z > Task :client:testClasses
build	Build and Test	2026-07-18T00:55:34.4320997Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T00:55:53.2296764Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T00:55:56.6294494Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T00:56:03.1306838Z /tmp/junit3089053757507217064/junit12436421095863159180/vert.glsl.vert
build	Build and Test	2026-07-18T00:56:03.1396948Z /tmp/junit3089053757507217064/junit12436421095863159180/frag.glsl.frag
build	Build and Test	2026-07-18T00:56:03.2302891Z /tmp/junit3089053757507217064/junit1138759449107152987/vertui.glsl.vert
build	Build and Test	2026-07-18T00:56:03.2406766Z /tmp/junit3089053757507217064/junit1138759449107152987/fragui.glsl.frag
build	Build and Test	2026-07-18T00:56:03.9336826Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T00:56:04.3295159Z > Task :client:pmdMain
build	Build and Test	2026-07-18T00:56:04.4316625Z > Task :client:test
build	Build and Test	2026-07-18T00:56:06.6296012Z
build	Build and Test	2026-07-18T00:56:06.6357744Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T00:56:06.8336733Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T00:56:07.0298946Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T00:56:07.0377601Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T00:56:12.5286008Z
build	Build and Test	2026-07-18T00:56:12.5296648Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T00:56:16.9297708Z
build	Build and Test	2026-07-18T00:56:16.9298906Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784336102021.json
build	Build and Test	2026-07-18T00:56:16.9326149Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T00:56:16.9326822Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T00:56:16.9334373Z
build	Build and Test	2026-07-18T00:56:16.9362176Z * What went wrong:
build	Build and Test	2026-07-18T00:56:16.9369181Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T00:56:16.9370262Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T00:56:16.9371908Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T00:56:16.9372991Z
build	Build and Test	2026-07-18T00:56:16.9373644Z * Try:
build	Build and Test	2026-07-18T00:56:16.9374165Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T00:56:16.9374638Z
build	Build and Test	2026-07-18T00:56:16.9374920Z BUILD FAILED in 1m 22s
build	Build and Test	2026-07-18T00:56:17.4630172Z ##[error]Process completed with exit code 1.
```

## CI: Add announcement-derived API and docs layouts

- Run: [29624110153](https://github.com/KSPOG/klite/actions/runs/29624110153)
- Conclusion: `failure`
- Event: `push`
- Commit: `e1de9c8e57105256e8e381b6739488c6cc5105f6`
- Created: `2026-07-18T00:54:25Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T00:55:08.2836829Z > Task :copper-tin-miner:jar
build	Build and Test	2026-07-18T00:55:08.2837890Z > Task :copper-tin-miner:assemble
build	Build and Test	2026-07-18T00:55:08.4781841Z > Task :copper-tin-miner:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-18T00:55:08.4783458Z > Task :copper-tin-miner:compileTestJava NO-SOURCE
build	Build and Test	2026-07-18T00:55:08.4785670Z > Task :copper-tin-miner:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T00:55:08.4788298Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-18T00:55:08.4789603Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-18T00:55:08.4792274Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T00:55:08.4794467Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T00:55:08.7787825Z > Task :client:jar
build	Build and Test	2026-07-18T00:55:08.7816887Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T00:55:08.9772936Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T00:55:15.3788520Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T00:55:15.3790709Z 	 * @param duration
build	Build and Test	2026-07-18T00:55:15.3791390Z 	   ^
build	Build and Test	2026-07-18T00:55:15.3792929Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T00:55:15.3795068Z 	 * @param duration
build	Build and Test	2026-07-18T00:55:15.3795706Z 	   ^
build	Build and Test	2026-07-18T00:55:15.3796582Z
build	Build and Test	2026-07-18T00:55:15.3796801Z > Task :client:javadoc
build	Build and Test	2026-07-18T00:55:15.9778452Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:55:15.9807519Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:55:15.9809196Z 	            ^
build	Build and Test	2026-07-18T00:55:15.9838135Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:55:15.9871686Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:55:15.9889147Z 	            ^
build	Build and Test	2026-07-18T00:55:15.9914075Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:55:15.9927995Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:55:15.9956961Z 	            ^
build	Build and Test	2026-07-18T00:55:15.9982018Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:55:16.0015572Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:55:16.0046955Z 	            ^
build	Build and Test	2026-07-18T00:55:16.0058029Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:55:16.0077629Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:55:16.0110431Z 	            ^
build	Build and Test	2026-07-18T00:55:16.0138039Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:55:16.0140580Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:55:16.0167998Z 	            ^
build	Build and Test	2026-07-18T00:55:16.0212359Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:55:16.0214629Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:55:16.0215864Z 	            ^
build	Build and Test	2026-07-18T00:55:16.0217801Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:55:16.0220229Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:55:16.0221402Z 	            ^
build	Build and Test	2026-07-18T00:55:16.0222928Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:55:16.0225205Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:55:16.0226651Z 	            ^
build	Build and Test	2026-07-18T00:55:16.0228082Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T00:55:16.0229678Z 	 * @param itemId
build	Build and Test	2026-07-18T00:55:16.0230133Z 	   ^
build	Build and Test	2026-07-18T00:55:16.0231514Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T00:55:16.0233086Z 	 * @return
build	Build and Test	2026-07-18T00:55:16.0233510Z 	   ^
build	Build and Test	2026-07-18T00:55:16.4008285Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T00:55:16.4008992Z 	               ^
build	Build and Test	2026-07-18T00:55:16.4010428Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T00:55:16.4012065Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T00:55:16.4012718Z 	             ^
build	Build and Test	2026-07-18T00:55:16.4014283Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T00:55:16.4016480Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T00:55:16.4017505Z 	            ^
build	Build and Test	2026-07-18T00:55:16.4019184Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T00:55:16.4020912Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T00:55:16.4021582Z 	            ^
build	Build and Test	2026-07-18T00:55:16.4023023Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T00:55:16.4024751Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T00:55:16.4025443Z 	            ^
build	Build and Test	2026-07-18T00:55:16.4764593Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T00:55:16.4770244Z 	public void select(Color color) {
build	Build and Test	2026-07-18T00:55:16.4771103Z 	            ^
build	Build and Test	2026-07-18T00:55:16.5763773Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T00:55:16.5767845Z 	 * @param dimmed
build	Build and Test	2026-07-18T00:55:16.5768537Z 	   ^
build	Build and Test	2026-07-18T00:55:16.5770106Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T00:55:16.5775758Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T00:55:16.5776953Z 	            ^
build	Build and Test	2026-07-18T00:55:16.5778612Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T00:55:16.5780620Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T00:55:16.5781445Z 	            ^
build	Build and Test	2026-07-18T00:55:16.6763993Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T00:55:16.6767559Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T00:55:16.6768711Z 		                                          ^
build	Build and Test	2026-07-18T00:55:21.1762622Z 100 warnings
build	Build and Test	2026-07-18T00:55:23.5764881Z
build	Build and Test	2026-07-18T00:55:28.1763696Z > Task :client:assemble
build	Build and Test	2026-07-18T00:55:28.4790760Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T00:55:28.4857196Z > Task :client:testClasses
build	Build and Test	2026-07-18T00:55:28.6808857Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T00:55:48.6787242Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T00:55:51.8798460Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T00:55:58.1777316Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T00:55:58.5816609Z
build	Build and Test	2026-07-18T00:55:58.5827343Z /tmp/junit9900443260037277318/junit15919614876590709124/vert.glsl.vert
build	Build and Test	2026-07-18T00:55:58.5887220Z /tmp/junit9900443260037277318/junit15919614876590709124/frag.glsl.frag
build	Build and Test	2026-07-18T00:55:58.5946581Z
build	Build and Test	2026-07-18T00:55:58.5992367Z > Task :client:pmdMain
build	Build and Test	2026-07-18T00:55:58.6789223Z
build	Build and Test	2026-07-18T00:55:58.6817571Z /tmp/junit9900443260037277318/junit6822969479765167617/vertui.glsl.vert
build	Build and Test	2026-07-18T00:55:58.6877308Z /tmp/junit9900443260037277318/junit6822969479765167617/fragui.glsl.frag
build	Build and Test	2026-07-18T00:55:58.6906563Z
build	Build and Test	2026-07-18T00:55:58.6959123Z > Task :client:test
build	Build and Test	2026-07-18T00:56:02.5806605Z
build	Build and Test	2026-07-18T00:56:02.5868429Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T00:56:02.8808505Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T00:56:03.0768727Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T00:56:03.0828308Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T00:56:09.1786851Z
build	Build and Test	2026-07-18T00:56:09.1817251Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T00:56:13.7796833Z
build	Build and Test	2026-07-18T00:56:13.7798594Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784336094272.json
build	Build and Test	2026-07-18T00:56:13.7799691Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T00:56:13.7827054Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T00:56:13.7847182Z
build	Build and Test	2026-07-18T00:56:13.7847664Z * What went wrong:
build	Build and Test	2026-07-18T00:56:13.7848472Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T00:56:13.7849595Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T00:56:13.7851335Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T00:56:13.7852459Z
build	Build and Test	2026-07-18T00:56:13.7852781Z * Try:
build	Build and Test	2026-07-18T00:56:13.7853383Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T00:56:13.7853929Z
build	Build and Test	2026-07-18T00:56:13.7854270Z BUILD FAILED in 1m 27s
build	Build and Test	2026-07-18T00:56:14.3228885Z ##[error]Process completed with exit code 1.
```

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29624109450](https://github.com/KSPOG/klite/actions/runs/29624109450)
- Conclusion: `failure`
- Event: `workflow_run`
- Commit: `927b4a975f4adee47b115429bfabad3a47116d82`
- Created: `2026-07-18T00:54:24Z`

### Failed jobs and steps

- **diagnose** — `failure`
  - Step 4: **Publish diagnostic report** — `failure`

### Relevant log context

```text
diagnose	Publish diagnostic report	﻿2026-07-18T00:54:55.0416262Z ##[group]Run set -euo pipefail
diagnose	Publish diagnostic report	2026-07-18T00:54:55.0416592Z ^[[36;1mset -euo pipefail^[[0m
diagnose	Publish diagnostic report	2026-07-18T00:54:55.0416875Z ^[[36;1mgit config user.name "github-actions[bot]"^[[0m
diagnose	Publish diagnostic report	2026-07-18T00:54:55.0417326Z ^[[36;1mgit config user.email "41898282+github-actions[bot]@users.noreply.github.com"^[[0m
diagnose	Publish diagnostic report	2026-07-18T00:54:55.0488724Z ^[[36;1mgit add diagnostics/latest-workflow-failures.md^[[0m
diagnose	Publish diagnostic report	2026-07-18T00:54:55.0489376Z ^[[36;1mif git diff --cached --quiet; then^[[0m
diagnose	Publish diagnostic report	2026-07-18T00:54:55.0489845Z ^[[36;1m  echo "The failure report did not change."^[[0m
diagnose	Publish diagnostic report	2026-07-18T00:54:55.0490357Z ^[[36;1m  exit 0^[[0m
diagnose	Publish diagnostic report	2026-07-18T00:54:55.0490678Z ^[[36;1mfi^[[0m
diagnose	Publish diagnostic report	2026-07-18T00:54:55.0491198Z ^[[36;1mgit commit -m "Update workflow failure diagnostics [skip ci]"^[[0m
diagnose	Publish diagnostic report	2026-07-18T00:54:55.0491824Z ^[[36;1mgit push^[[0m
diagnose	Publish diagnostic report	2026-07-18T00:54:55.0560341Z shell: /usr/bin/bash --noprofile --norc -e -o pipefail {0}
diagnose	Publish diagnostic report	2026-07-18T00:54:55.0560714Z ##[endgroup]
diagnose	Publish diagnostic report	2026-07-18T00:54:55.2316903Z [main 64017c773] Update workflow failure diagnostics [skip ci]
diagnose	Publish diagnostic report	2026-07-18T00:54:55.2317772Z  1 file changed, 140 insertions(+), 142 deletions(-)
diagnose	Publish diagnostic report	2026-07-18T00:54:55.4369090Z To https://github.com/KSPOG/klite
diagnose	Publish diagnostic report	2026-07-18T00:54:55.4369708Z  ! [rejected]            main -> main (fetch first)
diagnose	Publish diagnostic report	2026-07-18T00:54:55.4370349Z error: failed to push some refs to 'https://github.com/KSPOG/klite'
diagnose	Publish diagnostic report	2026-07-18T00:54:55.4381977Z hint: Updates were rejected because the remote contains work that you do not
diagnose	Publish diagnostic report	2026-07-18T00:54:55.4382655Z hint: have locally. This is usually caused by another repository pushing to
diagnose	Publish diagnostic report	2026-07-18T00:54:55.4383149Z hint: the same ref. If you want to integrate the remote changes, use
diagnose	Publish diagnostic report	2026-07-18T00:54:55.4383525Z hint: 'git pull' before pushing again.
diagnose	Publish diagnostic report	2026-07-18T00:54:55.4384127Z hint: See the 'Note about fast-forwards' in 'git push --help' for details.
diagnose	Publish diagnostic report	2026-07-18T00:54:55.4399549Z ##[error]Process completed with exit code 1.
```

## CI: Add announcement-derived cards

- Run: [29624100742](https://github.com/KSPOG/klite/actions/runs/29624100742)
- Conclusion: `failure`
- Event: `push`
- Commit: `927b4a975f4adee47b115429bfabad3a47116d82`
- Created: `2026-07-18T00:54:09Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T00:54:50.7071034Z > Task :copper-tin-miner:jar
build	Build and Test	2026-07-18T00:54:50.7071827Z > Task :copper-tin-miner:assemble
build	Build and Test	2026-07-18T00:54:50.9007555Z > Task :copper-tin-miner:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-18T00:54:50.9011788Z > Task :copper-tin-miner:compileTestJava NO-SOURCE
build	Build and Test	2026-07-18T00:54:50.9012268Z > Task :copper-tin-miner:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T00:54:50.9012711Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-18T00:54:50.9013088Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-18T00:54:50.9013440Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T00:54:50.9013928Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T00:54:51.1021562Z > Task :client:jar
build	Build and Test	2026-07-18T00:54:51.1051486Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T00:54:51.3003708Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T00:54:59.2008786Z
build	Build and Test	2026-07-18T00:54:59.2032594Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T00:54:59.2034195Z 	 * @param duration
build	Build and Test	2026-07-18T00:54:59.2034632Z 	   ^
build	Build and Test	2026-07-18T00:54:59.2036036Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T00:54:59.2037583Z 	 * @param duration
build	Build and Test	2026-07-18T00:54:59.2038043Z 	   ^
build	Build and Test	2026-07-18T00:54:59.2038799Z > Task :client:javadoc
build	Build and Test	2026-07-18T00:54:59.7041176Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:54:59.7083674Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:54:59.7121258Z 	            ^
build	Build and Test	2026-07-18T00:54:59.7152454Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:54:59.7156513Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:54:59.7181090Z 	            ^
build	Build and Test	2026-07-18T00:54:59.7212269Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:54:59.7241493Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:54:59.7270987Z 	            ^
build	Build and Test	2026-07-18T00:54:59.7273507Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:54:59.7301797Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:54:59.7331051Z 	            ^
build	Build and Test	2026-07-18T00:54:59.7354477Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:54:59.7381774Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:54:59.7411085Z 	            ^
build	Build and Test	2026-07-18T00:54:59.7432199Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:54:59.7452683Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:54:59.7455129Z 	            ^
build	Build and Test	2026-07-18T00:54:59.7456854Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:54:59.7459481Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:54:59.7461267Z 	            ^
build	Build and Test	2026-07-18T00:54:59.7463268Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:54:59.7466032Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:54:59.7467463Z 	            ^
build	Build and Test	2026-07-18T00:54:59.7469319Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:54:59.7472267Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:54:59.7473672Z 	            ^
build	Build and Test	2026-07-18T00:54:59.8004740Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T00:54:59.8040051Z 	 * @param itemId
build	Build and Test	2026-07-18T00:54:59.8041160Z 	   ^
build	Build and Test	2026-07-18T00:54:59.8042729Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T00:54:59.8044443Z 	 * @return
build	Build and Test	2026-07-18T00:54:59.8045015Z 	   ^
build	Build and Test	2026-07-18T00:55:00.1227866Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T00:55:00.1228383Z 	               ^
build	Build and Test	2026-07-18T00:55:00.1229638Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T00:55:00.1231286Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T00:55:00.1231828Z 	             ^
build	Build and Test	2026-07-18T00:55:00.1233174Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T00:55:00.1234822Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T00:55:00.1235467Z 	            ^
build	Build and Test	2026-07-18T00:55:00.1236865Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T00:55:00.1238473Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T00:55:00.1239119Z 	            ^
build	Build and Test	2026-07-18T00:55:00.1256416Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T00:55:00.1258279Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T00:55:00.1259004Z 	            ^
build	Build and Test	2026-07-18T00:55:00.2085863Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T00:55:00.2087931Z 	public void select(Color color) {
build	Build and Test	2026-07-18T00:55:00.2088773Z 	            ^
build	Build and Test	2026-07-18T00:55:00.2090730Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T00:55:00.2092994Z 	 * @param dimmed
build	Build and Test	2026-07-18T00:55:00.2093651Z 	   ^
build	Build and Test	2026-07-18T00:55:00.3005757Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T00:55:00.3007712Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T00:55:00.3008914Z 	            ^
build	Build and Test	2026-07-18T00:55:00.3010997Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T00:55:00.3012994Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T00:55:00.3013787Z 	            ^
build	Build and Test	2026-07-18T00:55:00.3015431Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T00:55:00.3017477Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T00:55:00.3018475Z 		                                          ^
build	Build and Test	2026-07-18T00:55:04.9002732Z 100 warnings
build	Build and Test	2026-07-18T00:55:07.2003847Z
build	Build and Test	2026-07-18T00:55:07.2005507Z > Task :client:javadocJar
build	Build and Test	2026-07-18T00:55:07.2006951Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T00:55:11.8003204Z > Task :client:shadowJar
build	Build and Test	2026-07-18T00:55:11.8005265Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T00:55:11.8006103Z > Task :client:assemble
build	Build and Test	2026-07-18T00:55:12.1003878Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T00:55:12.1031009Z > Task :client:testClasses
build	Build and Test	2026-07-18T00:55:12.4031585Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T00:55:33.0061477Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T00:55:33.3032976Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T00:55:41.8021498Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T00:55:42.2051506Z > Task :client:pmdMain
build	Build and Test	2026-07-18T00:55:42.4011376Z > Task :client:test
build	Build and Test	2026-07-18T00:55:42.5031087Z
build	Build and Test	2026-07-18T00:55:42.5085798Z /tmp/junit2799199001928179402/junit4736738385154402605/vert.glsl.vert
build	Build and Test	2026-07-18T00:55:42.5171877Z /tmp/junit2799199001928179402/junit4736738385154402605/frag.glsl.frag
build	Build and Test	2026-07-18T00:55:42.7020705Z /tmp/junit2799199001928179402/junit15400278443449694918/vertui.glsl.vert
build	Build and Test	2026-07-18T00:55:42.7051257Z /tmp/junit2799199001928179402/junit15400278443449694918/fragui.glsl.frag
build	Build and Test	2026-07-18T00:55:43.2042993Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T00:55:43.4042887Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T00:55:43.5004595Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T00:55:43.5072910Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T00:55:49.2011004Z
build	Build and Test	2026-07-18T00:55:49.2061252Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T00:55:55.2002681Z
build	Build and Test	2026-07-18T00:55:55.2003820Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784336076437.json
build	Build and Test	2026-07-18T00:55:55.2015264Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T00:55:55.2026250Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T00:55:55.2026815Z
build	Build and Test	2026-07-18T00:55:55.2027149Z * What went wrong:
build	Build and Test	2026-07-18T00:55:55.2027657Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T00:55:55.2028708Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T00:55:55.2030205Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T00:55:55.2031862Z
build	Build and Test	2026-07-18T00:55:55.2032572Z * Try:
build	Build and Test	2026-07-18T00:55:55.2032879Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T00:55:55.2033173Z
build	Build and Test	2026-07-18T00:55:55.2033410Z BUILD FAILED in 1m 30s
build	Build and Test	2026-07-18T00:55:55.6988287Z ##[error]Process completed with exit code 1.
```

## CI: Add announcement-derived hero composition

- Run: [29624057860](https://github.com/KSPOG/klite/actions/runs/29624057860)
- Conclusion: `failure`
- Event: `push`
- Commit: `79cc5106c66a519587e174fe60c41496276f26e1`
- Created: `2026-07-18T00:52:53Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T00:53:24.0754363Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-18T00:53:24.0754858Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-18T00:53:24.0755297Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T00:53:24.0755743Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T00:53:24.3702519Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T00:53:24.3722605Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T00:53:24.3732602Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T00:53:24.3736660Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T00:53:24.3737332Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T00:53:24.3738097Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T00:53:24.3738708Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T00:53:24.3739260Z > Task :runelite-api:build
build	Build and Test	2026-07-18T00:53:28.2723590Z
build	Build and Test	2026-07-18T00:53:28.2746475Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T00:53:28.2747781Z > Task :client:javadoc
build	Build and Test	2026-07-18T00:53:28.2762517Z 	 * @param duration
build	Build and Test	2026-07-18T00:53:28.2796336Z 	   ^
build	Build and Test	2026-07-18T00:53:28.2798077Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T00:53:28.2799547Z 	 * @param duration
build	Build and Test	2026-07-18T00:53:28.2800017Z 	   ^
build	Build and Test	2026-07-18T00:53:28.6697402Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:53:28.6699541Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:53:28.6700694Z 	            ^
build	Build and Test	2026-07-18T00:53:28.6702527Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:53:28.6704600Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:53:28.6705636Z 	            ^
build	Build and Test	2026-07-18T00:53:28.6749346Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:53:28.6756867Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:53:28.6803424Z 	            ^
build	Build and Test	2026-07-18T00:53:28.6816466Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:53:28.6823279Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:53:28.6852211Z 	            ^
build	Build and Test	2026-07-18T00:53:28.6889157Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:53:28.6891503Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:53:28.6907717Z 	            ^
build	Build and Test	2026-07-18T00:53:28.6944115Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:53:28.6946554Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:53:28.6947435Z 	            ^
build	Build and Test	2026-07-18T00:53:28.6948538Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:53:28.6950225Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:53:28.6951124Z 	            ^
build	Build and Test	2026-07-18T00:53:28.6952565Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:53:28.6954395Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:53:28.6955265Z 	            ^
build	Build and Test	2026-07-18T00:53:28.6956488Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:53:28.6958282Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:53:28.6959167Z 	            ^
build	Build and Test	2026-07-18T00:53:28.6960246Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T00:53:28.6961417Z 	 * @param itemId
build	Build and Test	2026-07-18T00:53:28.6961736Z 	   ^
build	Build and Test	2026-07-18T00:53:28.6962924Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T00:53:28.6964109Z 	 * @return
build	Build and Test	2026-07-18T00:53:28.6964395Z 	   ^
build	Build and Test	2026-07-18T00:53:28.9848954Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T00:53:28.9849320Z 	               ^
build	Build and Test	2026-07-18T00:53:28.9850165Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T00:53:28.9851126Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T00:53:28.9851572Z 	             ^
build	Build and Test	2026-07-18T00:53:28.9852721Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T00:53:28.9853868Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T00:53:28.9854339Z 	            ^
build	Build and Test	2026-07-18T00:53:28.9855271Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T00:53:28.9856381Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T00:53:28.9856858Z 	            ^
build	Build and Test	2026-07-18T00:53:28.9857803Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T00:53:28.9858966Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T00:53:28.9859460Z 	            ^
build	Build and Test	2026-07-18T00:53:29.0698793Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T00:53:29.0705127Z 	public void select(Color color) {
build	Build and Test	2026-07-18T00:53:29.0705700Z 	            ^
build	Build and Test	2026-07-18T00:53:29.0706953Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T00:53:29.0708652Z 	 * @param dimmed
build	Build and Test	2026-07-18T00:53:29.0709220Z 	   ^
build	Build and Test	2026-07-18T00:53:29.1700745Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T00:53:29.1712970Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T00:53:29.1713658Z 	            ^
build	Build and Test	2026-07-18T00:53:29.1714910Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T00:53:29.1716415Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T00:53:29.1717043Z 	            ^
build	Build and Test	2026-07-18T00:53:29.2724006Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T00:53:29.2729834Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T00:53:29.2730668Z 		                                          ^
build	Build and Test	2026-07-18T00:53:32.4695511Z 100 warnings
build	Build and Test	2026-07-18T00:53:34.2695839Z
build	Build and Test	2026-07-18T00:53:34.2696756Z > Task :client:javadocJar
build	Build and Test	2026-07-18T00:53:34.2697216Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T00:53:37.9696136Z > Task :client:shadowJar
build	Build and Test	2026-07-18T00:53:37.9697850Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T00:53:37.9698624Z > Task :client:assemble
build	Build and Test	2026-07-18T00:53:38.2703590Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T00:53:38.2722533Z > Task :client:testClasses
build	Build and Test	2026-07-18T00:53:38.3713102Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T00:53:54.6696185Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T00:53:57.0741123Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T00:54:02.3720177Z /tmp/junit16491846199427218/junit15962683529185072570/vert.glsl.vert
build	Build and Test	2026-07-18T00:54:02.3722673Z /tmp/junit16491846199427218/junit15962683529185072570/frag.glsl.frag
build	Build and Test	2026-07-18T00:54:02.5702034Z /tmp/junit16491846199427218/junit15648573810731710986/vertui.glsl.vert
build	Build and Test	2026-07-18T00:54:02.5732782Z /tmp/junit16491846199427218/junit15648573810731710986/fragui.glsl.frag
build	Build and Test	2026-07-18T00:54:05.5743887Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T00:54:05.7696390Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T00:54:05.8724082Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T00:54:05.8763851Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T00:54:07.9722829Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T00:54:08.2752949Z > Task :client:pmdMain
build	Build and Test	2026-07-18T00:54:08.3711037Z > Task :client:test
build	Build and Test	2026-07-18T00:54:10.8733059Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T00:54:14.0696646Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784335993669.json
build	Build and Test	2026-07-18T00:54:14.1697491Z
build	Build and Test	2026-07-18T00:54:14.1698397Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T00:54:14.1699112Z
build	Build and Test	2026-07-18T00:54:14.1699246Z * What went wrong:
build	Build and Test	2026-07-18T00:54:14.1699637Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T00:54:14.1700318Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T00:54:14.1701616Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T00:54:14.1702511Z
build	Build and Test	2026-07-18T00:54:14.1702649Z * Try:
build	Build and Test	2026-07-18T00:54:14.1702958Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T00:54:14.1703246Z
build	Build and Test	2026-07-18T00:54:14.1703390Z BUILD FAILED in 1m 4s
build	Build and Test	2026-07-18T00:54:14.1703809Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T00:54:14.6103127Z ##[error]Process completed with exit code 1.
```

## CI: Add announcement-derived website shell

- Run: [29624008887](https://github.com/KSPOG/klite/actions/runs/29624008887)
- Conclusion: `failure`
- Event: `push`
- Commit: `5fea1df97929520df1bc3c931ec55e3e73b45a35`
- Created: `2026-07-18T00:51:29Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T00:52:00.4497098Z > Task :copper-tin-miner:jar
build	Build and Test	2026-07-18T00:52:00.4526886Z > Task :copper-tin-miner:assemble
build	Build and Test	2026-07-18T00:52:00.5457312Z > Task :copper-tin-miner:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-18T00:52:00.5459133Z > Task :copper-tin-miner:compileTestJava NO-SOURCE
build	Build and Test	2026-07-18T00:52:00.5460247Z > Task :copper-tin-miner:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T00:52:00.5461094Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-18T00:52:00.5461978Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-18T00:52:00.5462797Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T00:52:00.5463571Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T00:52:00.8439714Z > Task :client:jar
build	Build and Test	2026-07-18T00:52:00.8440456Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T00:52:00.9487533Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T00:52:04.6458626Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T00:52:04.6459892Z
build	Build and Test	2026-07-18T00:52:04.6477549Z 	 * @param duration
build	Build and Test	2026-07-18T00:52:04.6478465Z > Task :client:javadoc
build	Build and Test	2026-07-18T00:52:04.6507269Z 	   ^
build	Build and Test	2026-07-18T00:52:04.6509002Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T00:52:04.6510661Z 	 * @param duration
build	Build and Test	2026-07-18T00:52:04.6511243Z 	   ^
build	Build and Test	2026-07-18T00:52:05.0448800Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:52:05.0468442Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:52:05.0511923Z 	            ^
build	Build and Test	2026-07-18T00:52:05.0532709Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:52:05.0577544Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:52:05.0591138Z 	            ^
build	Build and Test	2026-07-18T00:52:05.0629005Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:52:05.0633850Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:52:05.0657409Z 	            ^
build	Build and Test	2026-07-18T00:52:05.0679045Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:52:05.0707800Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:52:05.0736890Z 	            ^
build	Build and Test	2026-07-18T00:52:05.0767930Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:52:05.0787549Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:52:05.0796810Z 	            ^
build	Build and Test	2026-07-18T00:52:05.0807987Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:52:05.0810528Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:52:05.0811579Z 	            ^
build	Build and Test	2026-07-18T00:52:05.0812825Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:52:05.0814658Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:52:05.0815875Z 	            ^
build	Build and Test	2026-07-18T00:52:05.0817762Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:52:05.0819773Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:52:05.0820865Z 	            ^
build	Build and Test	2026-07-18T00:52:05.0822333Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:52:05.0824258Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:52:05.0825443Z 	            ^
build	Build and Test	2026-07-18T00:52:05.0826813Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T00:52:05.0828197Z 	 * @param itemId
build	Build and Test	2026-07-18T00:52:05.0828818Z 	   ^
build	Build and Test	2026-07-18T00:52:05.0830018Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T00:52:05.0831325Z 	 * @return
build	Build and Test	2026-07-18T00:52:05.0831908Z 	   ^
build	Build and Test	2026-07-18T00:52:05.3794665Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T00:52:05.3795274Z 	               ^
build	Build and Test	2026-07-18T00:52:05.3796592Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T00:52:05.3797840Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T00:52:05.3798395Z 	             ^
build	Build and Test	2026-07-18T00:52:05.3799747Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T00:52:05.3801231Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T00:52:05.3801917Z 	            ^
build	Build and Test	2026-07-18T00:52:05.3803088Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T00:52:05.3810550Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T00:52:05.3811329Z 	            ^
build	Build and Test	2026-07-18T00:52:05.3812500Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T00:52:05.3813910Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T00:52:05.3814535Z 	            ^
build	Build and Test	2026-07-18T00:52:05.4439453Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T00:52:05.4447204Z 	public void select(Color color) {
build	Build and Test	2026-07-18T00:52:05.4447946Z 	            ^
build	Build and Test	2026-07-18T00:52:05.4449270Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T00:52:05.4450871Z 	 * @param dimmed
build	Build and Test	2026-07-18T00:52:05.4451445Z 	   ^
build	Build and Test	2026-07-18T00:52:05.5439064Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T00:52:05.5447190Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T00:52:05.5447988Z 	            ^
build	Build and Test	2026-07-18T00:52:05.5449327Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T00:52:05.5450755Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T00:52:05.5451450Z 	            ^
build	Build and Test	2026-07-18T00:52:05.6447866Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T00:52:05.6467244Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T00:52:05.6468503Z 		                                          ^
build	Build and Test	2026-07-18T00:52:08.8439654Z 100 warnings
build	Build and Test	2026-07-18T00:52:10.6448664Z
build	Build and Test	2026-07-18T00:52:10.6451167Z > Task :client:javadocJar
build	Build and Test	2026-07-18T00:52:10.6457524Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T00:52:14.3477234Z > Task :client:shadowJar
build	Build and Test	2026-07-18T00:52:14.3478825Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T00:52:14.3487404Z > Task :client:assemble
build	Build and Test	2026-07-18T00:52:14.6514565Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T00:52:14.6535249Z > Task :client:testClasses
build	Build and Test	2026-07-18T00:52:14.7460423Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T00:52:29.7440710Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T00:52:31.5466809Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T00:52:36.1467774Z /tmp/junit3693584345932624781/junit17395692588038489439/vert.glsl.vert
build	Build and Test	2026-07-18T00:52:36.1527583Z /tmp/junit3693584345932624781/junit17395692588038489439/frag.glsl.frag
build	Build and Test	2026-07-18T00:52:36.2477516Z /tmp/junit3693584345932624781/junit6492458549968509834/vertui.glsl.vert
build	Build and Test	2026-07-18T00:52:36.2517458Z /tmp/junit3693584345932624781/junit6492458549968509834/fragui.glsl.frag
build	Build and Test	2026-07-18T00:52:39.7468804Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T00:52:39.8448448Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T00:52:40.0488405Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T00:52:40.0578101Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T00:52:44.3469015Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T00:52:44.4447556Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T00:52:44.7439176Z > Task :client:test
build	Build and Test	2026-07-18T00:52:47.7449511Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784335909534.json
build	Build and Test	2026-07-18T00:52:47.8447060Z
build	Build and Test	2026-07-18T00:52:47.8448005Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T00:52:47.8451543Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T00:52:47.8452222Z
build	Build and Test	2026-07-18T00:52:47.8459865Z * What went wrong:
build	Build and Test	2026-07-18T00:52:47.8460879Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T00:52:47.8461902Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T00:52:47.8464152Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T00:52:47.8464960Z
build	Build and Test	2026-07-18T00:52:47.8465135Z * Try:
build	Build and Test	2026-07-18T00:52:47.8465787Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T00:52:47.8466337Z
build	Build and Test	2026-07-18T00:52:47.8466571Z BUILD FAILED in 1m 2s
build	Build and Test	2026-07-18T00:52:48.2475561Z ##[error]Process completed with exit code 1.
```

## CI: Run obsidian layout v2 activation

- Run: [29623641087](https://github.com/KSPOG/klite/actions/runs/29623641087)
- Conclusion: `failure`
- Event: `push`
- Commit: `76b8eb32895308d2bdc6ac559ee8d4945284daa1`
- Created: `2026-07-18T00:41:17Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T00:41:55.5832232Z > Task :copper-tin-miner:jar
build	Build and Test	2026-07-18T00:41:55.5862193Z > Task :copper-tin-miner:assemble
build	Build and Test	2026-07-18T00:41:55.7794107Z > Task :copper-tin-miner:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-18T00:41:55.7822762Z > Task :copper-tin-miner:compileTestJava NO-SOURCE
build	Build and Test	2026-07-18T00:41:55.7832748Z > Task :copper-tin-miner:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T00:41:55.7833689Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-18T00:41:55.7834536Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-18T00:41:55.7835305Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T00:41:55.7836041Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T00:41:55.9784781Z > Task :client:jar
build	Build and Test	2026-07-18T00:41:55.9786833Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T00:41:56.1793721Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T00:42:02.4790701Z
build	Build and Test	2026-07-18T00:42:02.4823893Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T00:42:02.4825430Z > Task :client:javadoc
build	Build and Test	2026-07-18T00:42:02.4832165Z 	 * @param duration
build	Build and Test	2026-07-18T00:42:02.4852292Z 	   ^
build	Build and Test	2026-07-18T00:42:02.4863475Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T00:42:02.4892559Z 	 * @param duration
build	Build and Test	2026-07-18T00:42:02.4902623Z 	   ^
build	Build and Test	2026-07-18T00:42:02.9798705Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:42:02.9801101Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:42:02.9804128Z 	            ^
build	Build and Test	2026-07-18T00:42:02.9862891Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:42:02.9923092Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:42:02.9977183Z 	            ^
build	Build and Test	2026-07-18T00:42:02.9992899Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:42:02.9998178Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:42:02.9999445Z 	            ^
build	Build and Test	2026-07-18T00:42:03.0000968Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:42:03.0016785Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:42:03.0018161Z 	            ^
build	Build and Test	2026-07-18T00:42:03.0019904Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:42:03.0023241Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:42:03.0028134Z 	            ^
build	Build and Test	2026-07-18T00:42:03.0029883Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:42:03.0033142Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:42:03.0034383Z 	            ^
build	Build and Test	2026-07-18T00:42:03.0035944Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:42:03.0038159Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:42:03.0039461Z 	            ^
build	Build and Test	2026-07-18T00:42:03.0041169Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:42:03.0043789Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:42:03.0045078Z 	            ^
build	Build and Test	2026-07-18T00:42:03.0046750Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:42:03.0049126Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:42:03.0050407Z 	            ^
build	Build and Test	2026-07-18T00:42:03.0794644Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T00:42:03.0842300Z 	 * @param itemId
build	Build and Test	2026-07-18T00:42:03.0862569Z 	   ^
build	Build and Test	2026-07-18T00:42:03.0864198Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T00:42:03.0865852Z 	 * @return
build	Build and Test	2026-07-18T00:42:03.0866398Z 	   ^
build	Build and Test	2026-07-18T00:42:03.4806503Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T00:42:03.4807177Z 	               ^
build	Build and Test	2026-07-18T00:42:03.4808541Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T00:42:03.4810027Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T00:42:03.4810682Z 	             ^
build	Build and Test	2026-07-18T00:42:03.4812274Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T00:42:03.4814031Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T00:42:03.4814830Z 	            ^
build	Build and Test	2026-07-18T00:42:03.4816265Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T00:42:03.4818040Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T00:42:03.4819078Z 	            ^
build	Build and Test	2026-07-18T00:42:03.4820518Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T00:42:03.4822380Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T00:42:03.4823175Z 	            ^
build	Build and Test	2026-07-18T00:42:03.5786083Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T00:42:03.5795815Z 	public void select(Color color) {
build	Build and Test	2026-07-18T00:42:03.5796611Z 	            ^
build	Build and Test	2026-07-18T00:42:03.5798162Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T00:42:03.5800181Z 	 * @param dimmed
build	Build and Test	2026-07-18T00:42:03.5800750Z 	   ^
build	Build and Test	2026-07-18T00:42:03.6785526Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T00:42:03.6802125Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T00:42:03.6832023Z 	            ^
build	Build and Test	2026-07-18T00:42:03.6863340Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T00:42:03.6892699Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T00:42:03.6922708Z 	            ^
build	Build and Test	2026-07-18T00:42:03.7785629Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T00:42:03.7805821Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T00:42:03.7806850Z 		                                          ^
build	Build and Test	2026-07-18T00:42:07.7784192Z 100 warnings
build	Build and Test	2026-07-18T00:42:09.9785705Z
build	Build and Test	2026-07-18T00:42:14.6786613Z > Task :client:assemble
build	Build and Test	2026-07-18T00:42:14.9784954Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T00:42:14.9793875Z > Task :client:testClasses
build	Build and Test	2026-07-18T00:42:15.2786788Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T00:42:35.0792868Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T00:42:39.1823636Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T00:42:44.6832614Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T00:42:45.0812018Z
build	Build and Test	2026-07-18T00:42:45.0879552Z /tmp/junit6493409438661038552/junit12763894807649971304/vert.glsl.vert
build	Build and Test	2026-07-18T00:42:45.1040705Z /tmp/junit6493409438661038552/junit12763894807649971304/frag.glsl.frag
build	Build and Test	2026-07-18T00:42:45.1131987Z
build	Build and Test	2026-07-18T00:42:45.1242343Z > Task :client:pmdMain
build	Build and Test	2026-07-18T00:42:45.1912124Z
build	Build and Test	2026-07-18T00:42:45.2022939Z /tmp/junit6493409438661038552/junit13749237359163374639/vertui.glsl.vert
build	Build and Test	2026-07-18T00:42:45.2063036Z /tmp/junit6493409438661038552/junit13749237359163374639/fragui.glsl.frag
build	Build and Test	2026-07-18T00:42:45.2142149Z
build	Build and Test	2026-07-18T00:42:45.2202577Z > Task :client:test
build	Build and Test	2026-07-18T00:42:49.4792073Z
build	Build and Test	2026-07-18T00:42:49.4823950Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T00:42:49.6785516Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T00:42:49.8785764Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T00:42:49.8854038Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T00:42:55.8812181Z
build	Build and Test	2026-07-18T00:42:55.8833024Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T00:42:59.5788170Z
build	Build and Test	2026-07-18T00:42:59.5789242Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T00:42:59.5789589Z
build	Build and Test	2026-07-18T00:42:59.5789724Z * What went wrong:
build	Build and Test	2026-07-18T00:42:59.5790074Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T00:42:59.5790667Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T00:42:59.5791787Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T00:42:59.5792632Z
build	Build and Test	2026-07-18T00:42:59.5792747Z * Try:
build	Build and Test	2026-07-18T00:42:59.5793039Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T00:42:59.5793288Z
build	Build and Test	2026-07-18T00:42:59.5793417Z BUILD FAILED in 1m 25s
build	Build and Test	2026-07-18T00:42:59.5795660Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784335302234.json
build	Build and Test	2026-07-18T00:42:59.5798173Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T00:43:00.0813199Z ##[error]Process completed with exit code 1.
```

## CI: Replace legacy website layout with obsidian release layout

- Run: [29623606687](https://github.com/KSPOG/klite/actions/runs/29623606687)
- Conclusion: `failure`
- Event: `push`
- Commit: `f48109f38363a67b4cd312eae4dda0b44e32b171`
- Created: `2026-07-18T00:40:18Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T00:40:53.7139293Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-18T00:40:53.7159478Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-18T00:40:53.7160168Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T00:40:53.7160786Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T00:40:53.9109138Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T00:40:53.9110513Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T00:40:53.9111277Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T00:40:53.9111953Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T00:40:54.0087024Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T00:40:54.0109302Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T00:40:54.0109903Z > Task :runelite-api:build
build	Build and Test	2026-07-18T00:40:54.1079113Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T00:41:01.3098721Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T00:41:01.3100592Z
build	Build and Test	2026-07-18T00:41:01.3106354Z > Task :client:javadoc
build	Build and Test	2026-07-18T00:41:01.3109464Z 	 * @param duration
build	Build and Test	2026-07-18T00:41:01.3119972Z 	   ^
build	Build and Test	2026-07-18T00:41:01.3121542Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T00:41:01.3123289Z 	 * @param duration
build	Build and Test	2026-07-18T00:41:01.3123939Z 	   ^
build	Build and Test	2026-07-18T00:41:01.8083015Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:41:01.8108546Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:41:01.8141518Z 	            ^
build	Build and Test	2026-07-18T00:41:01.8163242Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:41:01.8165995Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:41:01.8167335Z 	            ^
build	Build and Test	2026-07-18T00:41:01.8169449Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:41:01.8172093Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:41:01.8173446Z 	            ^
build	Build and Test	2026-07-18T00:41:01.8175090Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:41:01.8177521Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:41:01.8179097Z 	            ^
build	Build and Test	2026-07-18T00:41:01.8180917Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:41:01.8183802Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:41:01.8185162Z 	            ^
build	Build and Test	2026-07-18T00:41:01.8186975Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:41:01.8189672Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:41:01.8191314Z 	            ^
build	Build and Test	2026-07-18T00:41:01.8193024Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:41:01.8195403Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:41:01.8196807Z 	            ^
build	Build and Test	2026-07-18T00:41:01.8198636Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:41:01.8201447Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:41:01.8202818Z 	            ^
build	Build and Test	2026-07-18T00:41:01.8204561Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:41:01.8207141Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:41:01.8208872Z 	            ^
build	Build and Test	2026-07-18T00:41:01.8210632Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T00:41:01.8212687Z 	 * @param itemId
build	Build and Test	2026-07-18T00:41:01.8213307Z 	   ^
build	Build and Test	2026-07-18T00:41:01.8214828Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T00:41:01.8216470Z 	 * @return
build	Build and Test	2026-07-18T00:41:01.8216997Z 	   ^
build	Build and Test	2026-07-18T00:41:02.2120837Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T00:41:02.2121524Z 	               ^
build	Build and Test	2026-07-18T00:41:02.2122849Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T00:41:02.2124327Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T00:41:02.2124974Z 	             ^
build	Build and Test	2026-07-18T00:41:02.2126434Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T00:41:02.2133790Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T00:41:02.2134616Z 	            ^
build	Build and Test	2026-07-18T00:41:02.2136078Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T00:41:02.2137821Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T00:41:02.2138565Z 	            ^
build	Build and Test	2026-07-18T00:41:02.2140231Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T00:41:02.2141973Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T00:41:02.2142761Z 	            ^
build	Build and Test	2026-07-18T00:41:02.3100986Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T00:41:02.3110283Z 	public void select(Color color) {
build	Build and Test	2026-07-18T00:41:02.3111614Z 	            ^
build	Build and Test	2026-07-18T00:41:02.3113156Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T00:41:02.3135942Z 	 * @param dimmed
build	Build and Test	2026-07-18T00:41:02.3159653Z 	   ^
build	Build and Test	2026-07-18T00:41:02.4079368Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T00:41:02.4082707Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T00:41:02.4086184Z 	            ^
build	Build and Test	2026-07-18T00:41:02.4087931Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T00:41:02.4090098Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T00:41:02.4091030Z 	            ^
build	Build and Test	2026-07-18T00:41:02.5079926Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T00:41:02.5083347Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T00:41:02.5084872Z 		                                          ^
build	Build and Test	2026-07-18T00:41:06.8077685Z 100 warnings
build	Build and Test	2026-07-18T00:41:09.1079889Z
build	Build and Test	2026-07-18T00:41:09.1081260Z > Task :client:javadocJar
build	Build and Test	2026-07-18T00:41:09.1082488Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T00:41:13.8078489Z > Task :client:shadowJar
build	Build and Test	2026-07-18T00:41:13.8109533Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T00:41:13.8139603Z > Task :client:assemble
build	Build and Test	2026-07-18T00:41:14.1120680Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T00:41:14.1167578Z > Task :client:testClasses
build	Build and Test	2026-07-18T00:41:14.2130044Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T00:41:34.9079839Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T00:41:37.2100913Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T00:41:43.8085758Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T00:41:44.1131021Z > Task :client:pmdMain
build	Build and Test	2026-07-18T00:41:44.2090212Z > Task :client:test
build	Build and Test	2026-07-18T00:41:44.9099341Z
build	Build and Test	2026-07-18T00:41:44.9169933Z /tmp/junit1754212419700943208/junit1525908910448277575/vert.glsl.vert
build	Build and Test	2026-07-18T00:41:44.9239930Z /tmp/junit1754212419700943208/junit1525908910448277575/frag.glsl.frag
build	Build and Test	2026-07-18T00:41:45.0099932Z /tmp/junit1754212419700943208/junit13459472007231102023/vertui.glsl.vert
build	Build and Test	2026-07-18T00:41:45.0156397Z /tmp/junit1754212419700943208/junit13459472007231102023/fragui.glsl.frag
build	Build and Test	2026-07-18T00:41:47.0079528Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T00:41:47.1098016Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T00:41:47.4083056Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T00:41:47.4100872Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T00:41:53.4086690Z
build	Build and Test	2026-07-18T00:41:53.4139819Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T00:41:58.4079134Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784335240835.json
build	Build and Test	2026-07-18T00:41:58.4082243Z
build	Build and Test	2026-07-18T00:41:58.4086320Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T00:41:58.4086987Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T00:41:58.4088160Z
build	Build and Test	2026-07-18T00:41:58.4088575Z * What went wrong:
build	Build and Test	2026-07-18T00:41:58.4089570Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T00:41:58.4090715Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T00:41:58.4092549Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T00:41:58.4094118Z
build	Build and Test	2026-07-18T00:41:58.4094498Z * Try:
build	Build and Test	2026-07-18T00:41:58.4095140Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T00:41:58.4095743Z
build	Build and Test	2026-07-18T00:41:58.4096130Z BUILD FAILED in 1m 27s
build	Build and Test	2026-07-18T00:41:58.9237797Z ##[error]Process completed with exit code 1.
```

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29623266952](https://github.com/KSPOG/klite/actions/runs/29623266952)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `8ecde6fc456c1cf5cf545a1f769dbc368d1f610d`
- Created: `2026-07-18T00:31:10Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 3: **Collect recent failure details** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29623263095](https://github.com/KSPOG/klite/actions/runs/29623263095)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `8ecde6fc456c1cf5cf545a1f769dbc368d1f610d`
- Created: `2026-07-18T00:31:03Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 2: **Check out repository** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## CI: Run site-wide obsidian theme deployment

- Run: [29623210856](https://github.com/KSPOG/klite/actions/runs/29623210856)
- Conclusion: `failure`
- Event: `push`
- Commit: `de8123565ec7c70c0e7f57529ff1c3ee4eb37313`
- Created: `2026-07-18T00:29:47Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T00:30:22.0983244Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T00:30:22.0983855Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T00:30:22.1879028Z > Task :client:jar
build	Build and Test	2026-07-18T00:30:22.1886944Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T00:30:22.4933951Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T00:30:22.7882234Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T00:30:22.7913422Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T00:30:22.7943155Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T00:30:22.8879007Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T00:30:22.8879625Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T00:30:22.8879991Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T00:30:22.8880327Z > Task :runelite-api:build
build	Build and Test	2026-07-18T00:30:28.9894831Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T00:30:28.9896213Z
build	Build and Test	2026-07-18T00:30:28.9923202Z 	 * @param duration
build	Build and Test	2026-07-18T00:30:28.9923681Z > Task :client:javadoc
build	Build and Test	2026-07-18T00:30:28.9953191Z 	   ^
build	Build and Test	2026-07-18T00:30:28.9984090Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T00:30:29.0013101Z 	 * @param duration
build	Build and Test	2026-07-18T00:30:29.0022532Z 	   ^
build	Build and Test	2026-07-18T00:30:29.4879670Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:30:29.4913785Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:30:29.4943162Z 	            ^
build	Build and Test	2026-07-18T00:30:29.4952289Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:30:29.4955157Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:30:29.4956159Z 	            ^
build	Build and Test	2026-07-18T00:30:29.4957613Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:30:29.4959660Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:30:29.4960665Z 	            ^
build	Build and Test	2026-07-18T00:30:29.4961949Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:30:29.4964137Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:30:29.4965218Z 	            ^
build	Build and Test	2026-07-18T00:30:29.4966748Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:30:29.4969475Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:30:29.4970504Z 	            ^
build	Build and Test	2026-07-18T00:30:29.4971939Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:30:29.4974799Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:30:29.4975857Z 	            ^
build	Build and Test	2026-07-18T00:30:29.4977447Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:30:29.4979401Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:30:29.4980482Z 	            ^
build	Build and Test	2026-07-18T00:30:29.4981976Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:30:29.4984299Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:30:29.4985384Z 	            ^
build	Build and Test	2026-07-18T00:30:29.4986833Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:30:29.4988949Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:30:29.4990010Z 	            ^
build	Build and Test	2026-07-18T00:30:29.4991317Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T00:30:29.4992919Z 	 * @param itemId
build	Build and Test	2026-07-18T00:30:29.4993329Z 	   ^
build	Build and Test	2026-07-18T00:30:29.4994603Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T00:30:29.4996006Z 	 * @return
build	Build and Test	2026-07-18T00:30:29.4996374Z 	   ^
build	Build and Test	2026-07-18T00:30:30.0016652Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T00:30:30.0017339Z 	               ^
build	Build and Test	2026-07-18T00:30:30.0018627Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T00:30:30.0020061Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T00:30:30.0020730Z 	             ^
build	Build and Test	2026-07-18T00:30:30.0022169Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T00:30:30.0024080Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T00:30:30.0024980Z 	            ^
build	Build and Test	2026-07-18T00:30:30.0026448Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T00:30:30.0028161Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T00:30:30.0028961Z 	            ^
build	Build and Test	2026-07-18T00:30:30.0030452Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T00:30:30.0032221Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T00:30:30.0033195Z 	            ^
build	Build and Test	2026-07-18T00:30:30.0887300Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T00:30:30.0895801Z 	public void select(Color color) {
build	Build and Test	2026-07-18T00:30:30.0896643Z 	            ^
build	Build and Test	2026-07-18T00:30:30.0898267Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T00:30:30.0900459Z 	 * @param dimmed
build	Build and Test	2026-07-18T00:30:30.0905181Z 	   ^
build	Build and Test	2026-07-18T00:30:30.1878595Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T00:30:30.1904020Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T00:30:30.1933675Z 	            ^
build	Build and Test	2026-07-18T00:30:30.1964646Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T00:30:30.1973795Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T00:30:30.1974684Z 	            ^
build	Build and Test	2026-07-18T00:30:30.2878851Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T00:30:30.2886897Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T00:30:30.2888056Z 		                                          ^
build	Build and Test	2026-07-18T00:30:34.4877627Z 100 warnings
build	Build and Test	2026-07-18T00:30:36.7885950Z
build	Build and Test	2026-07-18T00:30:41.4903673Z > Task :client:shadowJar
build	Build and Test	2026-07-18T00:30:41.4933145Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T00:30:41.4963198Z > Task :client:assemble
build	Build and Test	2026-07-18T00:30:41.7904248Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T00:30:41.7923473Z > Task :client:testClasses
build	Build and Test	2026-07-18T00:30:41.9894013Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T00:31:01.0878026Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T00:31:04.4984779Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T00:31:11.3906053Z /tmp/junit16879032751016673861/junit1769140476354038821/vert.glsl.vert
build	Build and Test	2026-07-18T00:31:11.3933773Z /tmp/junit16879032751016673861/junit1769140476354038821/frag.glsl.frag
build	Build and Test	2026-07-18T00:31:11.4917096Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T00:31:11.5893190Z
build	Build and Test	2026-07-18T00:31:11.5968914Z /tmp/junit16879032751016673861/junit16363183263920805885/vertui.glsl.vert
build	Build and Test	2026-07-18T00:31:11.6054198Z /tmp/junit16879032751016673861/junit16363183263920805885/fragui.glsl.frag
build	Build and Test	2026-07-18T00:31:11.7905331Z
build	Build and Test	2026-07-18T00:31:11.7934204Z > Task :client:pmdMain
build	Build and Test	2026-07-18T00:31:11.9893718Z > Task :client:test
build	Build and Test	2026-07-18T00:31:14.4883140Z
build	Build and Test	2026-07-18T00:31:14.4914991Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T00:31:14.6934724Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T00:31:14.7935098Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T00:31:14.7941601Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T00:31:20.4877296Z
build	Build and Test	2026-07-18T00:31:20.4878328Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T00:31:24.6881141Z
build	Build and Test	2026-07-18T00:31:24.6882316Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784334609665.json
build	Build and Test	2026-07-18T00:31:24.6884793Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T00:31:24.6885427Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T00:31:24.6886118Z
build	Build and Test	2026-07-18T00:31:24.6886547Z * What went wrong:
build	Build and Test	2026-07-18T00:31:24.6887231Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T00:31:24.6888302Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T00:31:24.6889909Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T00:31:24.6891292Z
build	Build and Test	2026-07-18T00:31:24.6891642Z * Try:
build	Build and Test	2026-07-18T00:31:24.6892242Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T00:31:24.6892960Z
build	Build and Test	2026-07-18T00:31:24.6893335Z BUILD FAILED in 1m 23s
build	Build and Test	2026-07-18T00:31:25.2060483Z ##[error]Process completed with exit code 1.
```

## CI: Add site-wide obsidian theme deployment task

- Run: [29623197790](https://github.com/KSPOG/klite/actions/runs/29623197790)
- Conclusion: `failure`
- Event: `push`
- Commit: `62415b3fd270eb8d285320e694c673f11f115768`
- Created: `2026-07-18T00:29:24Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T00:29:56.5629631Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T00:29:56.5630190Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T00:29:57.0553312Z > Task :client:jar
build	Build and Test	2026-07-18T00:29:57.0575762Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T00:29:57.2554809Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T00:29:57.2599525Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T00:29:57.2615446Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T00:29:57.2635928Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T00:29:57.2695405Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T00:29:57.2695984Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T00:29:57.2725510Z > Task :runelite-api:build
build	Build and Test	2026-07-18T00:29:57.4558604Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T00:30:03.8560492Z
build	Build and Test	2026-07-18T00:30:03.8587029Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T00:30:03.8588584Z > Task :client:javadoc
build	Build and Test	2026-07-18T00:30:03.8635740Z 	 * @param duration
build	Build and Test	2026-07-18T00:30:03.8675858Z 	   ^
build	Build and Test	2026-07-18T00:30:03.8706478Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T00:30:03.8727446Z 	 * @param duration
build	Build and Test	2026-07-18T00:30:03.8779473Z 	   ^
build	Build and Test	2026-07-18T00:30:04.2624571Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:30:04.2656257Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:30:04.2676750Z 	            ^
build	Build and Test	2026-07-18T00:30:04.2706882Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:30:04.2756146Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:30:04.2780605Z 	            ^
build	Build and Test	2026-07-18T00:30:04.2796583Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:30:04.2798743Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:30:04.2799886Z 	            ^
build	Build and Test	2026-07-18T00:30:04.2801239Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:30:04.2803449Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:30:04.2865701Z 	            ^
build	Build and Test	2026-07-18T00:30:04.2901861Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:30:04.2958917Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:30:04.2960341Z 	            ^
build	Build and Test	2026-07-18T00:30:04.2962070Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:30:04.2964477Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:30:04.2965940Z 	            ^
build	Build and Test	2026-07-18T00:30:04.2967781Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:30:04.2969957Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:30:04.2971239Z 	            ^
build	Build and Test	2026-07-18T00:30:04.2972897Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:30:04.2975476Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:30:04.2976736Z 	            ^
build	Build and Test	2026-07-18T00:30:04.2978366Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:30:04.2980759Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:30:04.2982015Z 	            ^
build	Build and Test	2026-07-18T00:30:04.2983495Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T00:30:04.2985269Z 	 * @param itemId
build	Build and Test	2026-07-18T00:30:04.2985863Z 	   ^
build	Build and Test	2026-07-18T00:30:04.2987358Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T00:30:04.2988976Z 	 * @return
build	Build and Test	2026-07-18T00:30:04.2989531Z 	   ^
build	Build and Test	2026-07-18T00:30:04.7595885Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T00:30:04.7596567Z 	               ^
build	Build and Test	2026-07-18T00:30:04.7597985Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T00:30:04.7599474Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T00:30:04.7604281Z 	             ^
build	Build and Test	2026-07-18T00:30:04.7606092Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T00:30:04.7607832Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T00:30:04.7608591Z 	            ^
build	Build and Test	2026-07-18T00:30:04.7610048Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T00:30:04.7611729Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T00:30:04.7612457Z 	            ^
build	Build and Test	2026-07-18T00:30:04.7613865Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T00:30:04.7645648Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T00:30:04.7659580Z 	            ^
build	Build and Test	2026-07-18T00:30:04.7661112Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T00:30:04.7663692Z 	public void select(Color color) {
build	Build and Test	2026-07-18T00:30:04.7664319Z 	            ^
build	Build and Test	2026-07-18T00:30:04.8562553Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T00:30:04.8585916Z 	 * @param dimmed
build	Build and Test	2026-07-18T00:30:04.8620473Z 	   ^
build	Build and Test	2026-07-18T00:30:04.9551908Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T00:30:04.9554081Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T00:30:04.9555164Z 	            ^
build	Build and Test	2026-07-18T00:30:04.9562944Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T00:30:04.9565390Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T00:30:04.9566192Z 	            ^
build	Build and Test	2026-07-18T00:30:04.9567683Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T00:30:04.9569531Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T00:30:04.9570476Z 		                                          ^
build	Build and Test	2026-07-18T00:30:09.5551098Z 100 warnings
build	Build and Test	2026-07-18T00:30:11.9550706Z
build	Build and Test	2026-07-18T00:30:11.9551346Z > Task :client:javadocJar
build	Build and Test	2026-07-18T00:30:11.9551977Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T00:30:16.6557806Z > Task :client:shadowJar
build	Build and Test	2026-07-18T00:30:16.6558813Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T00:30:16.6559673Z > Task :client:assemble
build	Build and Test	2026-07-18T00:30:16.9577620Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T00:30:16.9605558Z > Task :client:testClasses
build	Build and Test	2026-07-18T00:30:17.1553198Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T00:30:36.6566364Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T00:30:38.5557010Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T00:30:45.9582974Z /tmp/junit11750750380986191398/junit7585137771730274972/vert.glsl.vert
build	Build and Test	2026-07-18T00:30:45.9605776Z /tmp/junit11750750380986191398/junit7585137771730274972/frag.glsl.frag
build	Build and Test	2026-07-18T00:30:46.1576094Z /tmp/junit11750750380986191398/junit4977348275863961152/vertui.glsl.vert
build	Build and Test	2026-07-18T00:30:46.1605883Z /tmp/junit11750750380986191398/junit4977348275863961152/fragui.glsl.frag
build	Build and Test	2026-07-18T00:30:46.6576193Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T00:30:47.0605923Z > Task :client:pmdMain
build	Build and Test	2026-07-18T00:30:47.1550942Z > Task :client:test
build	Build and Test	2026-07-18T00:30:48.5557998Z
build	Build and Test	2026-07-18T00:30:48.5573082Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T00:30:48.8567078Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T00:30:48.9579391Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T00:30:48.9626371Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T00:30:54.2565320Z
build	Build and Test	2026-07-18T00:30:54.2585815Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T00:30:59.7550607Z
build	Build and Test	2026-07-18T00:30:59.7552155Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784334584848.json
build	Build and Test	2026-07-18T00:30:59.7553630Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T00:30:59.7577113Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T00:30:59.7602298Z
build	Build and Test	2026-07-18T00:30:59.7615827Z * What went wrong:
build	Build and Test	2026-07-18T00:30:59.7616532Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T00:30:59.7617814Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T00:30:59.7619488Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T00:30:59.7620589Z
build	Build and Test	2026-07-18T00:30:59.7622856Z * Try:
build	Build and Test	2026-07-18T00:30:59.7623463Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T00:30:59.7624020Z
build	Build and Test	2026-07-18T00:30:59.7624374Z BUILD FAILED in 1m 22s
build	Build and Test	2026-07-18T00:31:00.3227725Z ##[error]Process completed with exit code 1.
```

## CI: Add site-wide obsidian route styling

- Run: [29623189556](https://github.com/KSPOG/klite/actions/runs/29623189556)
- Conclusion: `failure`
- Event: `push`
- Commit: `f3221be2d41c292d11d94068430b6c32f790e8d3`
- Created: `2026-07-18T00:29:09Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T00:29:45.8644699Z > Task :copper-tin-miner:jar
build	Build and Test	2026-07-18T00:29:45.8674583Z > Task :copper-tin-miner:assemble
build	Build and Test	2026-07-18T00:29:46.0570912Z > Task :copper-tin-miner:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-18T00:29:46.0624755Z > Task :copper-tin-miner:compileTestJava NO-SOURCE
build	Build and Test	2026-07-18T00:29:46.0625524Z > Task :copper-tin-miner:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T00:29:46.0626224Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-18T00:29:46.0626859Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-18T00:29:46.0627498Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T00:29:46.0628060Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T00:29:46.3570942Z > Task :client:jar
build	Build and Test	2026-07-18T00:29:46.3571901Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T00:29:46.5570743Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T00:29:53.2587983Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T00:29:53.2589463Z
build	Build and Test	2026-07-18T00:29:53.2595249Z > Task :client:javadoc
build	Build and Test	2026-07-18T00:29:53.2605087Z 	 * @param duration
build	Build and Test	2026-07-18T00:29:53.2644637Z 	   ^
build	Build and Test	2026-07-18T00:29:53.2667568Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T00:29:53.2684860Z 	 * @param duration
build	Build and Test	2026-07-18T00:29:53.2724626Z 	   ^
build	Build and Test	2026-07-18T00:29:53.7570385Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:29:53.7595632Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:29:53.7636076Z 	            ^
build	Build and Test	2026-07-18T00:29:53.7683840Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:29:53.7715088Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:29:53.7723293Z 	            ^
build	Build and Test	2026-07-18T00:29:53.7750853Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:29:53.7775230Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:29:53.7834821Z 	            ^
build	Build and Test	2026-07-18T00:29:53.7895740Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:29:53.7925380Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:29:53.7964616Z 	            ^
build	Build and Test	2026-07-18T00:29:53.7966345Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:29:53.7995340Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:29:53.7996510Z 	            ^
build	Build and Test	2026-07-18T00:29:53.7998070Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:29:53.8000395Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:29:53.8002137Z 	            ^
build	Build and Test	2026-07-18T00:29:53.8003549Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:29:53.8005919Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:29:53.8007067Z 	            ^
build	Build and Test	2026-07-18T00:29:53.8008641Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:29:53.8010977Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:29:53.8012106Z 	            ^
build	Build and Test	2026-07-18T00:29:53.8013658Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:29:53.8016143Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:29:53.8017294Z 	            ^
build	Build and Test	2026-07-18T00:29:53.8636067Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T00:29:53.8664874Z 	 * @param itemId
build	Build and Test	2026-07-18T00:29:53.8685085Z 	   ^
build	Build and Test	2026-07-18T00:29:53.8686565Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T00:29:53.8688189Z 	 * @return
build	Build and Test	2026-07-18T00:29:53.8688570Z 	   ^
build	Build and Test	2026-07-18T00:29:54.2688297Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T00:29:54.2688956Z 	               ^
build	Build and Test	2026-07-18T00:29:54.2690338Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T00:29:54.2691997Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T00:29:54.2692673Z 	             ^
build	Build and Test	2026-07-18T00:29:54.2694342Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T00:29:54.2696031Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T00:29:54.2696888Z 	            ^
build	Build and Test	2026-07-18T00:29:54.2698364Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T00:29:54.2700077Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T00:29:54.2700889Z 	            ^
build	Build and Test	2026-07-18T00:29:54.2702407Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T00:29:54.2704473Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T00:29:54.2705320Z 	            ^
build	Build and Test	2026-07-18T00:29:54.3571211Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T00:29:54.3573138Z 	public void select(Color color) {
build	Build and Test	2026-07-18T00:29:54.3573918Z 	            ^
build	Build and Test	2026-07-18T00:29:54.4574605Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T00:29:54.4577194Z 	 * @param dimmed
build	Build and Test	2026-07-18T00:29:54.4577865Z 	   ^
build	Build and Test	2026-07-18T00:29:54.4579516Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T00:29:54.4581449Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T00:29:54.4582598Z 	            ^
build	Build and Test	2026-07-18T00:29:54.4584497Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T00:29:54.4586395Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T00:29:54.4587262Z 	            ^
build	Build and Test	2026-07-18T00:29:54.5570811Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T00:29:54.5573102Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T00:29:54.5574477Z 		                                          ^
build	Build and Test	2026-07-18T00:29:59.3568851Z 100 warnings
build	Build and Test	2026-07-18T00:30:01.6569105Z
build	Build and Test	2026-07-18T00:30:01.6570011Z > Task :client:javadocJar
build	Build and Test	2026-07-18T00:30:01.7570609Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T00:30:06.2585072Z > Task :client:shadowJar
build	Build and Test	2026-07-18T00:30:06.2585751Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T00:30:06.2586293Z > Task :client:assemble
build	Build and Test	2026-07-18T00:30:06.7595345Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T00:30:06.7625224Z > Task :client:testClasses
build	Build and Test	2026-07-18T00:30:06.9658611Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T00:30:24.3656065Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T00:30:35.7584983Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T00:30:36.2599325Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T00:30:36.7595031Z > Task :client:pmdMain
build	Build and Test	2026-07-18T00:30:36.9575258Z > Task :client:test
build	Build and Test	2026-07-18T00:30:37.3574414Z
build	Build and Test	2026-07-18T00:30:37.3636561Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T00:30:37.7586076Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T00:30:37.9586671Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T00:30:37.9676247Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T00:30:38.0595298Z /tmp/junit544591347301907198/junit1688951878797788884/vert.glsl.vert
build	Build and Test	2026-07-18T00:30:38.0644896Z /tmp/junit544591347301907198/junit1688951878797788884/frag.glsl.frag
build	Build and Test	2026-07-18T00:30:38.2645457Z /tmp/junit544591347301907198/junit13853412591987554639/vertui.glsl.vert
build	Build and Test	2026-07-18T00:30:38.2715064Z /tmp/junit544591347301907198/junit13853412591987554639/fragui.glsl.frag
build	Build and Test	2026-07-18T00:30:45.0594452Z
build	Build and Test	2026-07-18T00:30:45.0625006Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T00:30:53.4576876Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784334572037.json
build	Build and Test	2026-07-18T00:30:53.5568370Z
build	Build and Test	2026-07-18T00:30:53.5568964Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T00:30:53.5569418Z
build	Build and Test	2026-07-18T00:30:53.5569556Z * What went wrong:
build	Build and Test	2026-07-18T00:30:53.5569929Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T00:30:53.5570588Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T00:30:53.5571625Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T00:30:53.5572280Z
build	Build and Test	2026-07-18T00:30:53.5572956Z * Try:
build	Build and Test	2026-07-18T00:30:53.5573308Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T00:30:53.5573823Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T00:30:53.5574392Z
build	Build and Test	2026-07-18T00:30:53.5574647Z BUILD FAILED in 1m 30s
build	Build and Test	2026-07-18T00:30:54.0142145Z ##[error]Process completed with exit code 1.
```

