# Recent GitHub Actions failures

Generated: 2026-07-18T01:39:17.364661+00:00
Repository: `KSPOG/klite`
Failed runs inspected: **15**

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

## .github/workflows/install-release-preview-homepage.yml: Fix release-preview homepage installer workflow

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

## .github/workflows/install-release-preview-homepage.yml: Deploy completed KLite release-preview homepage

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

## .github/workflows/install-release-preview-homepage.yml: Install the release-preview homepage structure

- Run: [29625014811](https://github.com/KSPOG/klite/actions/runs/29625014811)
- Conclusion: `failure`
- Event: `push`
- Commit: `95949644c17f627b58c7f87a8613a9e169ea8306`
- Created: `2026-07-18T01:20:45Z`

### Failed jobs and steps

No failed job metadata was returned.

### Relevant log context

```text

failed to get run log: log not found
```

## CI: Add exact release-preview website styling

- Run: [29624995301](https://github.com/KSPOG/klite/actions/runs/29624995301)
- Conclusion: `failure`
- Event: `push`
- Commit: `d8a333ca3d532da1f6f42e2ee20ad42613d297e2`
- Created: `2026-07-18T01:20:11Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T01:20:54.9513525Z > Task :copper-tin-miner:jar
build	Build and Test	2026-07-18T01:20:54.9518920Z > Task :copper-tin-miner:assemble
build	Build and Test	2026-07-18T01:20:55.1460309Z > Task :copper-tin-miner:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-18T01:20:55.1475438Z > Task :copper-tin-miner:compileTestJava NO-SOURCE
build	Build and Test	2026-07-18T01:20:55.1476828Z > Task :copper-tin-miner:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T01:20:55.1477788Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-18T01:20:55.1478920Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-18T01:20:55.1479698Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T01:20:55.1480964Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T01:20:55.4479963Z > Task :client:jar
build	Build and Test	2026-07-18T01:20:55.4480721Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T01:20:55.6469700Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T01:21:02.6510483Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T01:21:02.6511985Z
build	Build and Test	2026-07-18T01:21:02.6539262Z 	 * @param duration
build	Build and Test	2026-07-18T01:21:02.6539800Z > Task :client:javadoc
build	Build and Test	2026-07-18T01:21:02.6619398Z 	   ^
build	Build and Test	2026-07-18T01:21:02.6650345Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T01:21:02.6709056Z 	 * @param duration
build	Build and Test	2026-07-18T01:21:02.6709666Z 	   ^
build	Build and Test	2026-07-18T01:21:03.2483918Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:21:03.2542491Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:21:03.2600707Z 	            ^
build	Build and Test	2026-07-18T01:21:03.2622678Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:21:03.2689838Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:21:03.2691624Z 	            ^
build	Build and Test	2026-07-18T01:21:03.2720320Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:21:03.2739611Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:21:03.2770190Z 	            ^
build	Build and Test	2026-07-18T01:21:03.2779939Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:21:03.2809808Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:21:03.2823415Z 	            ^
build	Build and Test	2026-07-18T01:21:03.2825759Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:21:03.2843385Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:21:03.2845510Z 	            ^
build	Build and Test	2026-07-18T01:21:03.2847692Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:21:03.2850954Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:21:03.2853879Z 	            ^
build	Build and Test	2026-07-18T01:21:03.2855387Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:21:03.2860301Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:21:03.2861618Z 	            ^
build	Build and Test	2026-07-18T01:21:03.2864142Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:21:03.2869397Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:21:03.2871160Z 	            ^
build	Build and Test	2026-07-18T01:21:03.2873472Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:21:03.2879727Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:21:03.2881483Z 	            ^
build	Build and Test	2026-07-18T01:21:03.2883643Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T01:21:03.2889160Z 	 * @param itemId
build	Build and Test	2026-07-18T01:21:03.2889739Z 	   ^
build	Build and Test	2026-07-18T01:21:03.2891824Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T01:21:03.2893535Z 	 * @return
build	Build and Test	2026-07-18T01:21:03.2894061Z 	   ^
build	Build and Test	2026-07-18T01:21:03.6492597Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T01:21:03.6499015Z 	               ^
build	Build and Test	2026-07-18T01:21:03.6500697Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T01:21:03.6502356Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T01:21:03.6503158Z 	             ^
build	Build and Test	2026-07-18T01:21:03.6504732Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T01:21:03.6506552Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T01:21:03.6507396Z 	            ^
build	Build and Test	2026-07-18T01:21:03.6509102Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T01:21:03.6510955Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T01:21:03.6511710Z 	            ^
build	Build and Test	2026-07-18T01:21:03.6513317Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T01:21:03.6520332Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T01:21:03.6521269Z 	            ^
build	Build and Test	2026-07-18T01:21:03.7467987Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T01:21:03.7470284Z 	public void select(Color color) {
build	Build and Test	2026-07-18T01:21:03.7471106Z 	            ^
build	Build and Test	2026-07-18T01:21:03.7472852Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T01:21:03.7475411Z 	 * @param dimmed
build	Build and Test	2026-07-18T01:21:03.7476093Z 	   ^
build	Build and Test	2026-07-18T01:21:03.8463401Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T01:21:03.8465776Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:21:03.8466947Z 	            ^
build	Build and Test	2026-07-18T01:21:03.8468894Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T01:21:03.8470785Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:21:03.8471643Z 	            ^
build	Build and Test	2026-07-18T01:21:03.9480585Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T01:21:03.9482615Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T01:21:03.9483461Z 		                                          ^
build	Build and Test	2026-07-18T01:21:08.3458963Z 100 warnings
build	Build and Test	2026-07-18T01:21:10.7459982Z
build	Build and Test	2026-07-18T01:21:10.7460983Z > Task :client:javadocJar
build	Build and Test	2026-07-18T01:21:10.7461832Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T01:21:15.5470809Z > Task :client:shadowJar
build	Build and Test	2026-07-18T01:21:15.5471675Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T01:21:15.5472481Z > Task :client:assemble
build	Build and Test	2026-07-18T01:21:15.8480244Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:21:15.8539612Z > Task :client:testClasses
build	Build and Test	2026-07-18T01:21:16.0479241Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T01:21:35.0519569Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T01:21:38.5490427Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T01:21:45.4465667Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T01:21:45.8499476Z > Task :client:pmdMain
build	Build and Test	2026-07-18T01:21:46.0474165Z > Task :client:test
build	Build and Test	2026-07-18T01:21:46.1486601Z
build	Build and Test	2026-07-18T01:21:46.1509357Z /tmp/junit532126844024099884/junit12057223313659430555/vert.glsl.vert
build	Build and Test	2026-07-18T01:21:46.1588094Z /tmp/junit532126844024099884/junit12057223313659430555/frag.glsl.frag
build	Build and Test	2026-07-18T01:21:46.3463565Z /tmp/junit532126844024099884/junit6695304374389203323/vertui.glsl.vert
build	Build and Test	2026-07-18T01:21:46.3589416Z /tmp/junit532126844024099884/junit6695304374389203323/fragui.glsl.frag
build	Build and Test	2026-07-18T01:21:49.0460475Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T01:21:49.3484256Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T01:21:49.5460955Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T01:21:49.5540565Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T01:21:55.6499023Z
build	Build and Test	2026-07-18T01:21:55.6539369Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T01:22:01.4458190Z
build	Build and Test	2026-07-18T01:22:01.4459732Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784337640731.json
build	Build and Test	2026-07-18T01:22:01.4461426Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T01:22:01.4462049Z
build	Build and Test	2026-07-18T01:22:01.4462192Z * What went wrong:
build	Build and Test	2026-07-18T01:22:01.4462576Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T01:22:01.4463293Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T01:22:01.4464445Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T01:22:01.4465180Z
build	Build and Test	2026-07-18T01:22:01.4465308Z * Try:
build	Build and Test	2026-07-18T01:22:01.4465638Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T01:22:01.4465940Z
build	Build and Test	2026-07-18T01:22:01.4466083Z BUILD FAILED in 1m 29s
build	Build and Test	2026-07-18T01:22:01.4466481Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T01:22:01.9218753Z ##[error]Process completed with exit code 1.
```

## CI: Prepare final announcement artwork website deployment

- Run: [29624269782](https://github.com/KSPOG/klite/actions/runs/29624269782)
- Conclusion: `failure`
- Event: `push`
- Commit: `d5cc6e395d6b7c9d1d9f64c828d1410211b635a5`
- Created: `2026-07-18T00:59:04Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T00:59:38.9387751Z > Task :copper-tin-miner:jar
build	Build and Test	2026-07-18T00:59:38.9417687Z > Task :copper-tin-miner:assemble
build	Build and Test	2026-07-18T00:59:39.1316220Z > Task :copper-tin-miner:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-18T00:59:39.1327048Z > Task :copper-tin-miner:compileTestJava NO-SOURCE
build	Build and Test	2026-07-18T00:59:39.1329912Z > Task :copper-tin-miner:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T00:59:39.1331572Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-18T00:59:39.1332453Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-18T00:59:39.1334092Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T00:59:39.1334957Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T00:59:39.4315919Z > Task :client:jar
build	Build and Test	2026-07-18T00:59:39.4318525Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T00:59:39.7316433Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T00:59:46.2328598Z
build	Build and Test	2026-07-18T00:59:46.2339270Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T00:59:46.2350211Z > Task :client:javadoc
build	Build and Test	2026-07-18T00:59:46.2350998Z 	 * @param duration
build	Build and Test	2026-07-18T00:59:46.2351753Z 	   ^
build	Build and Test	2026-07-18T00:59:46.2353437Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T00:59:46.2361486Z 	 * @param duration
build	Build and Test	2026-07-18T00:59:46.2362238Z 	   ^
build	Build and Test	2026-07-18T00:59:46.7318673Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:59:46.7368571Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:59:46.7406615Z 	            ^
build	Build and Test	2026-07-18T00:59:46.7429192Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:59:46.7448518Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:59:46.7455766Z 	            ^
build	Build and Test	2026-07-18T00:59:46.7479024Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:59:46.7508290Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:59:46.7537792Z 	            ^
build	Build and Test	2026-07-18T00:59:46.7539247Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:59:46.7541432Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:59:46.7542569Z 	            ^
build	Build and Test	2026-07-18T00:59:46.7544153Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:59:46.7546767Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:59:46.7548116Z 	            ^
build	Build and Test	2026-07-18T00:59:46.7550197Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:59:46.7552404Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:59:46.7553791Z 	            ^
build	Build and Test	2026-07-18T00:59:46.7555125Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:59:46.7556973Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:59:46.7558277Z 	            ^
build	Build and Test	2026-07-18T00:59:46.7559671Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:59:46.7561833Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:59:46.7562972Z 	            ^
build	Build and Test	2026-07-18T00:59:46.7564398Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:59:46.7566619Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:59:46.7583608Z 	            ^
build	Build and Test	2026-07-18T00:59:46.7584968Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T00:59:46.7586435Z 	 * @param itemId
build	Build and Test	2026-07-18T00:59:46.7586839Z 	   ^
build	Build and Test	2026-07-18T00:59:46.7588376Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T00:59:46.7589788Z 	 * @return
build	Build and Test	2026-07-18T00:59:46.7590154Z 	   ^
build	Build and Test	2026-07-18T00:59:47.2481931Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T00:59:47.2482599Z 	               ^
build	Build and Test	2026-07-18T00:59:47.2483978Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T00:59:47.2485532Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T00:59:47.2486198Z 	             ^
build	Build and Test	2026-07-18T00:59:47.2487855Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T00:59:47.2489686Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T00:59:47.2490499Z 	            ^
build	Build and Test	2026-07-18T00:59:47.2491998Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T00:59:47.2493749Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T00:59:47.2494530Z 	            ^
build	Build and Test	2026-07-18T00:59:47.2496047Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T00:59:47.2498040Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T00:59:47.2498850Z 	            ^
build	Build and Test	2026-07-18T00:59:47.3317707Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T00:59:47.3328352Z 	public void select(Color color) {
build	Build and Test	2026-07-18T00:59:47.3338252Z 	            ^
build	Build and Test	2026-07-18T00:59:47.4316321Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T00:59:47.4320612Z 	 * @param dimmed
build	Build and Test	2026-07-18T00:59:47.4321230Z 	   ^
build	Build and Test	2026-07-18T00:59:47.4322733Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T00:59:47.4324528Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T00:59:47.4325738Z 	            ^
build	Build and Test	2026-07-18T00:59:47.4327518Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T00:59:47.4329415Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T00:59:47.4330229Z 	            ^
build	Build and Test	2026-07-18T00:59:47.5316618Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T00:59:47.5319041Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T00:59:47.5320060Z 		                                          ^
build	Build and Test	2026-07-18T00:59:51.7315493Z 100 warnings
build	Build and Test	2026-07-18T00:59:53.9316338Z
build	Build and Test	2026-07-18T00:59:53.9317715Z > Task :client:javadocJar
build	Build and Test	2026-07-18T00:59:53.9318794Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T00:59:58.6330790Z > Task :client:shadowJar
build	Build and Test	2026-07-18T00:59:58.6373947Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T00:59:58.6391722Z > Task :client:assemble
build	Build and Test	2026-07-18T00:59:59.0358559Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T00:59:59.0438311Z > Task :client:testClasses
build	Build and Test	2026-07-18T00:59:59.2318336Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T01:00:18.7348298Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T01:00:22.7339309Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T01:00:28.6339809Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T01:00:29.0328379Z > Task :client:pmdMain
build	Build and Test	2026-07-18T01:00:29.2368151Z > Task :client:test
build	Build and Test	2026-07-18T01:00:30.1314843Z
build	Build and Test	2026-07-18T01:00:30.1348639Z /tmp/junit5074098868047704511/junit4883500526179660298/vert.glsl.vert
build	Build and Test	2026-07-18T01:00:30.1399766Z /tmp/junit5074098868047704511/junit4883500526179660298/frag.glsl.frag
build	Build and Test	2026-07-18T01:00:30.3359105Z /tmp/junit5074098868047704511/junit2423082776649184877/vertui.glsl.vert
build	Build and Test	2026-07-18T01:00:30.3388529Z /tmp/junit5074098868047704511/junit2423082776649184877/fragui.glsl.frag
build	Build and Test	2026-07-18T01:00:33.9349427Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T01:00:34.2359573Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T01:00:34.4322652Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T01:00:34.4379458Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T01:00:41.2314642Z
build	Build and Test	2026-07-18T01:00:41.2328137Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T01:00:46.2327065Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784336365398.json
build	Build and Test	2026-07-18T01:00:46.3314767Z
build	Build and Test	2026-07-18T01:00:46.3315576Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T01:00:46.3316050Z
build	Build and Test	2026-07-18T01:00:46.3316240Z * What went wrong:
build	Build and Test	2026-07-18T01:00:46.3316745Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T01:00:46.3317973Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T01:00:46.3319416Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T01:00:46.3320074Z
build	Build and Test	2026-07-18T01:00:46.3320567Z * Try:
build	Build and Test	2026-07-18T01:00:46.3320843Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T01:00:46.3321086Z
build	Build and Test	2026-07-18T01:00:46.3321204Z BUILD FAILED in 1m 29s
build	Build and Test	2026-07-18T01:00:46.3321535Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T01:00:46.8088826Z ##[error]Process completed with exit code 1.
```

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

