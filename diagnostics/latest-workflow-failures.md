# Recent GitHub Actions failures

Generated: 2026-07-18T00:43:24.392043+00:00
Repository: `KSPOG/klite`
Failed runs inspected: **15**

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

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29623115393](https://github.com/KSPOG/klite/actions/runs/29623115393)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `7a547344b62fd14b622f6b62b15592d0cb0a3669`
- Created: `2026-07-18T00:27:06Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 3: **Collect recent failure details** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## CI: Load obsidian release styling on API documentation

- Run: [29623068234](https://github.com/KSPOG/klite/actions/runs/29623068234)
- Conclusion: `failure`
- Event: `push`
- Commit: `7a547344b62fd14b622f6b62b15592d0cb0a3669`
- Created: `2026-07-18T00:25:47Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T00:26:19.1856670Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T00:26:19.1886451Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T00:26:19.1887175Z > Task :client:jar
build	Build and Test	2026-07-18T00:26:19.1916326Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T00:26:19.4697167Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T00:26:19.7712464Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T00:26:19.7735536Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T00:26:19.7766459Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T00:26:19.7796619Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T00:26:19.7826533Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T00:26:19.7856773Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T00:26:19.7869189Z > Task :runelite-api:build
build	Build and Test	2026-07-18T00:26:25.4706606Z
build	Build and Test	2026-07-18T00:26:25.4711140Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T00:26:25.4746615Z 	 * @param duration
build	Build and Test	2026-07-18T00:26:25.4747120Z > Task :client:javadoc
build	Build and Test	2026-07-18T00:26:25.4776403Z 	   ^
build	Build and Test	2026-07-18T00:26:25.4797567Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T00:26:25.4836475Z 	 * @param duration
build	Build and Test	2026-07-18T00:26:25.4866590Z 	   ^
build	Build and Test	2026-07-18T00:26:25.9687463Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:26:25.9757582Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:26:25.9806737Z 	            ^
build	Build and Test	2026-07-18T00:26:25.9827692Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:26:25.9857086Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:26:25.9876656Z 	            ^
build	Build and Test	2026-07-18T00:26:25.9887484Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:26:25.9916943Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:26:25.9936495Z 	            ^
build	Build and Test	2026-07-18T00:26:25.9967444Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:26:25.9997428Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:26:25.9998759Z 	            ^
build	Build and Test	2026-07-18T00:26:26.0027708Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:26:26.0057216Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:26:26.0086435Z 	            ^
build	Build and Test	2026-07-18T00:26:26.0088218Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:26:26.0090349Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:26:26.0092089Z 	            ^
build	Build and Test	2026-07-18T00:26:26.0093399Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:26:26.0095281Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:26:26.0096528Z 	            ^
build	Build and Test	2026-07-18T00:26:26.0097991Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:26:26.0100087Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:26:26.0101135Z 	            ^
build	Build and Test	2026-07-18T00:26:26.0102570Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:26:26.0104653Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:26:26.0105690Z 	            ^
build	Build and Test	2026-07-18T00:26:26.0702837Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T00:26:26.0733911Z 	 * @param itemId
build	Build and Test	2026-07-18T00:26:26.0734743Z 	   ^
build	Build and Test	2026-07-18T00:26:26.0736476Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T00:26:26.0738146Z 	 * @return
build	Build and Test	2026-07-18T00:26:26.0738745Z 	   ^
build	Build and Test	2026-07-18T00:26:26.4728233Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T00:26:26.4728926Z 	               ^
build	Build and Test	2026-07-18T00:26:26.4730339Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T00:26:26.4740466Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T00:26:26.4741481Z 	             ^
build	Build and Test	2026-07-18T00:26:26.4742909Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T00:26:26.4744720Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T00:26:26.4745480Z 	            ^
build	Build and Test	2026-07-18T00:26:26.4747114Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T00:26:26.4748784Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T00:26:26.4749539Z 	            ^
build	Build and Test	2026-07-18T00:26:26.4750982Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T00:26:26.4752738Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T00:26:26.4753573Z 	            ^
build	Build and Test	2026-07-18T00:26:26.5684222Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T00:26:26.5695572Z 	public void select(Color color) {
build	Build and Test	2026-07-18T00:26:26.5696764Z 	            ^
build	Build and Test	2026-07-18T00:26:26.5698291Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T00:26:26.5700281Z 	 * @param dimmed
build	Build and Test	2026-07-18T00:26:26.5700842Z 	   ^
build	Build and Test	2026-07-18T00:26:26.5702230Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T00:26:26.5703911Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T00:26:26.5704948Z 	            ^
build	Build and Test	2026-07-18T00:26:26.5706607Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T00:26:26.5708342Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T00:26:26.5709107Z 	            ^
build	Build and Test	2026-07-18T00:26:26.6687515Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T00:26:26.6689996Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T00:26:26.6690992Z 		                                          ^
build	Build and Test	2026-07-18T00:26:30.2683123Z 100 warnings
build	Build and Test	2026-07-18T00:26:32.5682966Z
build	Build and Test	2026-07-18T00:26:37.2682819Z > Task :client:shadowJar
build	Build and Test	2026-07-18T00:26:37.2683823Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T00:26:37.2684654Z > Task :client:assemble
build	Build and Test	2026-07-18T00:26:37.5717176Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T00:26:37.5738802Z > Task :client:testClasses
build	Build and Test	2026-07-18T00:26:37.7741966Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T00:26:55.3696803Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T00:27:00.7699504Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T00:27:07.2708981Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T00:27:07.4696395Z
build	Build and Test	2026-07-18T00:27:07.4724385Z /tmp/junit11963805858375699689/junit16935010230043229527/vert.glsl.vert
build	Build and Test	2026-07-18T00:27:07.4773676Z /tmp/junit11963805858375699689/junit16935010230043229527/frag.glsl.frag
build	Build and Test	2026-07-18T00:27:07.6737283Z /tmp/junit11963805858375699689/junit898254795108028237/vertui.glsl.vert
build	Build and Test	2026-07-18T00:27:07.6824258Z /tmp/junit11963805858375699689/junit898254795108028237/fragui.glsl.frag
build	Build and Test	2026-07-18T00:27:07.6916642Z
build	Build and Test	2026-07-18T00:27:07.7006955Z > Task :client:pmdMain
build	Build and Test	2026-07-18T00:27:07.7727870Z > Task :client:test
build	Build and Test	2026-07-18T00:27:10.5746310Z
build	Build and Test	2026-07-18T00:27:10.5817771Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T00:27:10.7683669Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T00:27:10.8690629Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T00:27:10.8729320Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T00:27:17.1706437Z
build	Build and Test	2026-07-18T00:27:17.1707452Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T00:27:21.3683038Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784334366474.json
build	Build and Test	2026-07-18T00:27:21.3686680Z
build	Build and Test	2026-07-18T00:27:21.3694927Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T00:27:21.3695668Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T00:27:21.3696769Z
build	Build and Test	2026-07-18T00:27:21.3697533Z * What went wrong:
build	Build and Test	2026-07-18T00:27:21.3698267Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T00:27:21.3699355Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T00:27:21.3700980Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T00:27:21.3702822Z
build	Build and Test	2026-07-18T00:27:21.3703239Z * Try:
build	Build and Test	2026-07-18T00:27:21.3703900Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T00:27:21.3704536Z
build	Build and Test	2026-07-18T00:27:21.3705003Z BUILD FAILED in 1m 22s
build	Build and Test	2026-07-18T00:27:21.8950470Z ##[error]Process completed with exit code 1.
```

## CI: Add obsidian release theme for API documentation

- Run: [29623050967](https://github.com/KSPOG/klite/actions/runs/29623050967)
- Conclusion: `failure`
- Event: `push`
- Commit: `b4f47c53913ac65d07560f8ae0b45d16942c3242`
- Created: `2026-07-18T00:25:19Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T00:25:53.4352175Z > Task :copper-tin-miner:jar
build	Build and Test	2026-07-18T00:25:53.4382159Z > Task :copper-tin-miner:assemble
build	Build and Test	2026-07-18T00:25:53.6288890Z > Task :copper-tin-miner:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-18T00:25:53.6290746Z > Task :copper-tin-miner:compileTestJava NO-SOURCE
build	Build and Test	2026-07-18T00:25:53.6291839Z > Task :copper-tin-miner:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T00:25:53.6293500Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-18T00:25:53.6294984Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-18T00:25:53.6295762Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T00:25:53.6296888Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T00:25:54.0284842Z > Task :client:jar
build	Build and Test	2026-07-18T00:25:54.0285424Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T00:25:54.2286647Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T00:26:01.1314488Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T00:26:01.1315898Z
build	Build and Test	2026-07-18T00:26:01.1329653Z > Task :client:javadoc
build	Build and Test	2026-07-18T00:26:01.1342312Z 	 * @param duration
build	Build and Test	2026-07-18T00:26:01.1352557Z 	   ^
build	Build and Test	2026-07-18T00:26:01.1354106Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T00:26:01.1355889Z 	 * @param duration
build	Build and Test	2026-07-18T00:26:01.1356531Z 	   ^
build	Build and Test	2026-07-18T00:26:01.6373950Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:26:01.6393132Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:26:01.6412636Z 	            ^
build	Build and Test	2026-07-18T00:26:01.6416095Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:26:01.6423024Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:26:01.6424289Z 	            ^
build	Build and Test	2026-07-18T00:26:01.6426156Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:26:01.6428592Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:26:01.6429820Z 	            ^
build	Build and Test	2026-07-18T00:26:01.6431335Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:26:01.6433839Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:26:01.6435181Z 	            ^
build	Build and Test	2026-07-18T00:26:01.6436926Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:26:01.6439775Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:26:01.6441088Z 	            ^
build	Build and Test	2026-07-18T00:26:01.6442859Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:26:01.6483111Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:26:01.6512344Z 	            ^
build	Build and Test	2026-07-18T00:26:01.6536067Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T00:26:01.6538408Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:26:01.6539746Z 	            ^
build	Build and Test	2026-07-18T00:26:01.6541474Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T00:26:01.6544135Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:26:01.6545463Z 	            ^
build	Build and Test	2026-07-18T00:26:01.6547133Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T00:26:01.6549512Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T00:26:01.6550819Z 	            ^
build	Build and Test	2026-07-18T00:26:01.6552534Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T00:26:01.6554181Z 	 * @param itemId
build	Build and Test	2026-07-18T00:26:01.6554792Z 	   ^
build	Build and Test	2026-07-18T00:26:01.6556664Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T00:26:01.6558290Z 	 * @return
build	Build and Test	2026-07-18T00:26:01.6558856Z 	   ^
build	Build and Test	2026-07-18T00:26:02.0517941Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T00:26:02.0518443Z 	               ^
build	Build and Test	2026-07-18T00:26:02.0519645Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T00:26:02.0520998Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T00:26:02.0521520Z 	             ^
build	Build and Test	2026-07-18T00:26:02.0522963Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T00:26:02.0524594Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T00:26:02.0525277Z 	            ^
build	Build and Test	2026-07-18T00:26:02.0526602Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T00:26:02.0528155Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T00:26:02.0528767Z 	            ^
build	Build and Test	2026-07-18T00:26:02.0530081Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T00:26:02.0531834Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T00:26:02.0532482Z 	            ^
build	Build and Test	2026-07-18T00:26:02.1308057Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T00:26:02.1322917Z 	public void select(Color color) {
build	Build and Test	2026-07-18T00:26:02.1327978Z 	            ^
build	Build and Test	2026-07-18T00:26:02.2285285Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T00:26:02.2292088Z 	 * @param dimmed
build	Build and Test	2026-07-18T00:26:02.2292839Z 	   ^
build	Build and Test	2026-07-18T00:26:02.2294553Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T00:26:02.2296466Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T00:26:02.2297325Z 	            ^
build	Build and Test	2026-07-18T00:26:02.2298898Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T00:26:02.2301061Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T00:26:02.2302314Z 	            ^
build	Build and Test	2026-07-18T00:26:02.3285551Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T00:26:02.3287617Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T00:26:02.3288615Z 		                                          ^
build	Build and Test	2026-07-18T00:26:07.0284157Z 100 warnings
build	Build and Test	2026-07-18T00:26:09.2283716Z
build	Build and Test	2026-07-18T00:26:09.2284833Z > Task :client:javadocJar
build	Build and Test	2026-07-18T00:26:09.2285432Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T00:26:13.8283736Z > Task :client:shadowJar
build	Build and Test	2026-07-18T00:26:13.8284358Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T00:26:13.8284930Z > Task :client:assemble
build	Build and Test	2026-07-18T00:26:14.1302916Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T00:26:14.1333737Z > Task :client:testClasses
build	Build and Test	2026-07-18T00:26:14.3402862Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T00:26:33.8284370Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T00:26:35.2287368Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T00:26:43.2302857Z /tmp/junit9643401916479398708/junit18025570335579962424/vert.glsl.vert
build	Build and Test	2026-07-18T00:26:43.2342531Z /tmp/junit9643401916479398708/junit18025570335579962424/frag.glsl.frag
build	Build and Test	2026-07-18T00:26:43.3342898Z /tmp/junit9643401916479398708/junit980625448068186275/vertui.glsl.vert
build	Build and Test	2026-07-18T00:26:43.3383564Z /tmp/junit9643401916479398708/junit980625448068186275/fragui.glsl.frag
build	Build and Test	2026-07-18T00:26:43.8312711Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T00:26:44.2302653Z > Task :client:pmdMain
build	Build and Test	2026-07-18T00:26:44.3292729Z > Task :client:test
build	Build and Test	2026-07-18T00:26:45.1302113Z
build	Build and Test	2026-07-18T00:26:45.1423927Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T00:26:45.4295577Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T00:26:45.5293995Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T00:26:45.5349871Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T00:26:51.7292255Z
build	Build and Test	2026-07-18T00:26:51.7312944Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T00:26:56.5284540Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784334339847.json
build	Build and Test	2026-07-18T00:26:56.6283120Z
build	Build and Test	2026-07-18T00:26:56.6284188Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T00:26:56.6284913Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T00:26:56.6285586Z
build	Build and Test	2026-07-18T00:26:56.6285860Z * What went wrong:
build	Build and Test	2026-07-18T00:26:56.6286368Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T00:26:56.6287055Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T00:26:56.6287948Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T00:26:56.6288484Z
build	Build and Test	2026-07-18T00:26:56.6288998Z * Try:
build	Build and Test	2026-07-18T00:26:56.6289280Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T00:26:56.6289517Z
build	Build and Test	2026-07-18T00:26:56.6289634Z BUILD FAILED in 1m 24s
build	Build and Test	2026-07-18T00:26:57.1022520Z ##[error]Process completed with exit code 1.
```

## Diagnose failed workflow runs: Include PMD helper failures in diagnostics

- Run: [29621923034](https://github.com/KSPOG/klite/actions/runs/29621923034)
- Conclusion: `cancelled`
- Event: `push`
- Commit: `271ad9738546d23ac4923cb06b67e6a7c4d5f080`
- Created: `2026-07-17T23:55:56Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 3: **Collect recent failure details** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## CI: Include PMD helper failures in diagnostics

- Run: [29621923007](https://github.com/KSPOG/klite/actions/runs/29621923007)
- Conclusion: `failure`
- Event: `push`
- Commit: `271ad9738546d23ac4923cb06b67e6a7c4d5f080`
- Created: `2026-07-17T23:55:56Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-17T23:56:34.4085891Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-17T23:56:34.4115778Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-17T23:56:34.7977163Z > Task :client:jar
build	Build and Test	2026-07-17T23:56:34.8005873Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-17T23:56:35.1961498Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-17T23:56:35.2966749Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-17T23:56:35.2996003Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-17T23:56:35.3025832Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-17T23:56:35.3026844Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-17T23:56:35.3055835Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-17T23:56:35.3086528Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-17T23:56:35.3115791Z > Task :runelite-api:build
build	Build and Test	2026-07-17T23:56:40.7961377Z
build	Build and Test	2026-07-17T23:56:40.7987125Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-17T23:56:40.7988639Z > Task :client:javadoc
build	Build and Test	2026-07-17T23:56:40.7989147Z 	 * @param duration
build	Build and Test	2026-07-17T23:56:40.7989586Z 	   ^
build	Build and Test	2026-07-17T23:56:40.7990934Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-17T23:56:40.7992475Z 	 * @param duration
build	Build and Test	2026-07-17T23:56:40.7992965Z 	   ^
build	Build and Test	2026-07-17T23:56:41.2957816Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:56:41.2986475Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:56:41.3004148Z 	            ^
build	Build and Test	2026-07-17T23:56:41.3017044Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:56:41.3031027Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:56:41.3047834Z 	            ^
build	Build and Test	2026-07-17T23:56:41.3061665Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:56:41.3086316Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:56:41.3115622Z 	            ^
build	Build and Test	2026-07-17T23:56:41.3146469Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:56:41.3148145Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:56:41.3149024Z 	            ^
build	Build and Test	2026-07-17T23:56:41.3150407Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:56:41.3152522Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:56:41.3153590Z 	            ^
build	Build and Test	2026-07-17T23:56:41.3154864Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:56:41.3156686Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:56:41.3157561Z 	            ^
build	Build and Test	2026-07-17T23:56:41.3158718Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:56:41.3160231Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:56:41.3161093Z 	            ^
build	Build and Test	2026-07-17T23:56:41.3162447Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:56:41.3164145Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:56:41.3164988Z 	            ^
build	Build and Test	2026-07-17T23:56:41.3166862Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:56:41.3169536Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:56:41.3170885Z 	            ^
build	Build and Test	2026-07-17T23:56:41.3175666Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-17T23:56:41.3177467Z 	 * @param itemId
build	Build and Test	2026-07-17T23:56:41.3178030Z 	   ^
build	Build and Test	2026-07-17T23:56:41.3179616Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-17T23:56:41.3181354Z 	 * @return
build	Build and Test	2026-07-17T23:56:41.3181940Z 	   ^
build	Build and Test	2026-07-17T23:56:41.8025049Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-17T23:56:41.8026031Z 	               ^
build	Build and Test	2026-07-17T23:56:41.8027525Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-17T23:56:41.8029135Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-17T23:56:41.8029954Z 	             ^
build	Build and Test	2026-07-17T23:56:41.8031465Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-17T23:56:41.8032487Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-17T23:56:41.8032884Z 	            ^
build	Build and Test	2026-07-17T23:56:41.8033667Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-17T23:56:41.8034570Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-17T23:56:41.8034939Z 	            ^
build	Build and Test	2026-07-17T23:56:41.8067468Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-17T23:56:41.8069297Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-17T23:56:41.8070035Z 	            ^
build	Build and Test	2026-07-17T23:56:41.8957054Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-17T23:56:41.8959129Z 	public void select(Color color) {
build	Build and Test	2026-07-17T23:56:41.8959976Z 	            ^
build	Build and Test	2026-07-17T23:56:41.8961632Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-17T23:56:41.8964277Z 	 * @param dimmed
build	Build and Test	2026-07-17T23:56:41.8971137Z 	   ^
build	Build and Test	2026-07-17T23:56:41.9983971Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T23:56:42.0006362Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T23:56:42.0007278Z 	            ^
build	Build and Test	2026-07-17T23:56:42.0008969Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T23:56:42.0011016Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T23:56:42.0012013Z 	            ^
build	Build and Test	2026-07-17T23:56:42.0013667Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-17T23:56:42.0016013Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-17T23:56:42.0017564Z 		                                          ^
build	Build and Test	2026-07-17T23:56:45.6954977Z 100 warnings
build	Build and Test	2026-07-17T23:56:48.0956884Z
build	Build and Test	2026-07-17T23:56:48.0957884Z > Task :client:javadocJar
build	Build and Test	2026-07-17T23:56:48.0958879Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-17T23:56:52.6955519Z > Task :client:shadowJar
build	Build and Test	2026-07-17T23:56:52.6957670Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-17T23:56:52.6958286Z > Task :client:assemble
build	Build and Test	2026-07-17T23:56:52.9966224Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-17T23:56:52.9995740Z > Task :client:testClasses
build	Build and Test	2026-07-17T23:56:53.1976147Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-17T23:57:12.1031999Z > Task :client:checkstyleTest
build	Build and Test	2026-07-17T23:57:15.2999405Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-17T23:57:21.1986480Z /tmp/junit15815595511745407223/junit5651712836868098289/vert.glsl.vert
build	Build and Test	2026-07-17T23:57:21.2016091Z /tmp/junit15815595511745407223/junit5651712836868098289/frag.glsl.frag
build	Build and Test	2026-07-17T23:57:21.2955671Z /tmp/junit15815595511745407223/junit7276061574576982138/vertui.glsl.vert
build	Build and Test	2026-07-17T23:57:21.2957123Z /tmp/junit15815595511745407223/junit7276061574576982138/fragui.glsl.frag
build	Build and Test	2026-07-17T23:57:22.6956059Z > Task :client:checkstyleMain
build	Build and Test	2026-07-17T23:57:23.0976239Z > Task :client:pmdMain
build	Build and Test	2026-07-17T23:57:23.1977558Z > Task :client:test
build	Build and Test	2026-07-17T23:57:25.6978130Z
build	Build and Test	2026-07-17T23:57:25.7047582Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-17T23:57:25.8957326Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-17T23:57:26.1007854Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-17T23:57:26.1067301Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-17T23:57:31.9965675Z
build	Build and Test	2026-07-17T23:57:32.0026237Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-17T23:57:36.1959463Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784332582470.json
build	Build and Test	2026-07-17T23:57:36.2955021Z
build	Build and Test	2026-07-17T23:57:36.2956997Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-17T23:57:36.2958173Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T23:57:36.2959214Z
build	Build and Test	2026-07-17T23:57:36.2959708Z * What went wrong:
build	Build and Test	2026-07-17T23:57:36.2960474Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-17T23:57:36.2961609Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-17T23:57:36.2963520Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-17T23:57:36.2964784Z
build	Build and Test	2026-07-17T23:57:36.2964984Z * Try:
build	Build and Test	2026-07-17T23:57:36.2965668Z > Run with --scan to get full insights.
build	Build and Test	2026-07-17T23:57:36.2966062Z
build	Build and Test	2026-07-17T23:57:36.2966254Z BUILD FAILED in 1m 20s
build	Build and Test	2026-07-17T23:57:36.7390171Z ##[error]Process completed with exit code 1.
```

## Apply verified KLite PMD fixes: Apply and verify KLite PMD fixes

- Run: [29621828094](https://github.com/KSPOG/klite/actions/runs/29621828094)
- Conclusion: `failure`
- Event: `push`
- Commit: `69f0efc45918933643651d34a2959eab4aaa3188`
- Created: `2026-07-17T23:53:35Z`

### Failed jobs and steps

- **apply** — `failure`
  - Step 5: **Verify PMD** — `failure`

### Relevant log context

```text
apply	Verify PMD	2026-07-17T23:55:32.1713709Z @Value
apply	Verify PMD	2026-07-17T23:55:32.1773637Z ^
apply	Verify PMD	2026-07-17T23:55:32.1805616Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/devtools/ScriptInspector.java:100: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
apply	Verify PMD	2026-07-17T23:55:32.1808599Z 	@Data
apply	Verify PMD	2026-07-17T23:55:32.1808902Z 	^
apply	Verify PMD	2026-07-17T23:55:39.3513891Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/agility/Courses.java:88: warning: non-varargs call of varargs method with inexact argument type for last parameter;
apply	Verify PMD	2026-07-17T23:55:39.3517976Z 		this(totalXp, -1, null);
apply	Verify PMD	2026-07-17T23:55:39.3522968Z 		                  ^
apply	Verify PMD	2026-07-17T23:55:39.3523870Z   cast to WorldPoint for a varargs call
apply	Verify PMD	2026-07-17T23:55:39.3524797Z   cast to WorldPoint[] for a non-varargs call and to suppress this warning
apply	Verify PMD	2026-07-17T23:55:44.6503173Z Note: Some input files use or override a deprecated API.
apply	Verify PMD	2026-07-17T23:55:44.6524206Z Note: Recompile with -Xlint:deprecation for details.
apply	Verify PMD	2026-07-17T23:55:44.6525056Z Note: Some input files use unchecked or unsafe operations.
apply	Verify PMD	2026-07-17T23:55:44.6525899Z Note: Recompile with -Xlint:unchecked for details.
apply	Verify PMD	2026-07-17T23:55:44.6526679Z 5 warnings
apply	Verify PMD	2026-07-17T23:55:45.7503362Z
apply	Verify PMD	2026-07-17T23:55:45.7504158Z > Task :client:classes
apply	Verify PMD	2026-07-17T23:55:53.8555171Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
apply	Verify PMD	2026-07-17T23:55:58.9545207Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	FinalFieldCouldBeStatic:	This final field could be made static
apply	Verify PMD	2026-07-17T23:56:02.2509645Z
apply	Verify PMD	2026-07-17T23:56:02.2510176Z > Task :client:pmdMain FAILED
apply	Verify PMD	2026-07-17T23:56:02.2589969Z FAILURE: Build failed with an exception.
apply	Verify PMD	2026-07-17T23:56:02.2590579Z 23 actionable tasks: 23 executed
apply	Verify PMD	2026-07-17T23:56:02.2604302Z
apply	Verify PMD	2026-07-17T23:56:02.2616120Z * What went wrong:
apply	Verify PMD	2026-07-17T23:56:02.2643761Z Execution failed for task ':client:pmdMain'.
apply	Verify PMD	2026-07-17T23:56:02.2704059Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
apply	Verify PMD	2026-07-17T23:56:02.2724062Z    > 2 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
apply	Verify PMD	2026-07-17T23:56:02.2734483Z
apply	Verify PMD	2026-07-17T23:56:02.2754707Z * Try:
apply	Verify PMD	2026-07-17T23:56:02.2774126Z > Run with --scan to get full insights.
apply	Verify PMD	2026-07-17T23:56:02.2830519Z
apply	Verify PMD	2026-07-17T23:56:02.2853964Z BUILD FAILED in 2m 14s
apply	Verify PMD	2026-07-17T23:56:02.8025722Z ##[error]Process completed with exit code 1.
```

## CI: Run verified KLite PMD fixes

- Run: [29621828069](https://github.com/KSPOG/klite/actions/runs/29621828069)
- Conclusion: `failure`
- Event: `push`
- Commit: `69f0efc45918933643651d34a2959eab4aaa3188`
- Created: `2026-07-17T23:53:35Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-17T23:54:06.6334719Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-17T23:54:06.6364744Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-17T23:54:06.9215190Z > Task :client:jar
build	Build and Test	2026-07-17T23:54:06.9274945Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-17T23:54:07.2225157Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-17T23:54:07.3215561Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-17T23:54:07.3254305Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-17T23:54:07.3257222Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-17T23:54:07.3258111Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-17T23:54:07.3258872Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-17T23:54:07.3259433Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-17T23:54:07.3259984Z > Task :runelite-api:build
build	Build and Test	2026-07-17T23:54:13.1215154Z
build	Build and Test	2026-07-17T23:54:13.1246200Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-17T23:54:13.1247791Z 	 * @param duration
build	Build and Test	2026-07-17T23:54:13.1248216Z 	   ^
build	Build and Test	2026-07-17T23:54:13.1249532Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-17T23:54:13.1250998Z 	 * @param duration
build	Build and Test	2026-07-17T23:54:13.1251446Z 	   ^
build	Build and Test	2026-07-17T23:54:13.1251899Z > Task :client:javadoc
build	Build and Test	2026-07-17T23:54:13.6216316Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:54:13.6235446Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:54:13.6244663Z 	            ^
build	Build and Test	2026-07-17T23:54:13.6285900Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:54:13.6295274Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:54:13.6324869Z 	            ^
build	Build and Test	2026-07-17T23:54:13.6326763Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:54:13.6329233Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:54:13.6330316Z 	            ^
build	Build and Test	2026-07-17T23:54:13.6331659Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:54:13.6333753Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:54:13.6335131Z 	            ^
build	Build and Test	2026-07-17T23:54:13.6336705Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:54:13.6339384Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:54:13.6340556Z 	            ^
build	Build and Test	2026-07-17T23:54:13.6342137Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:54:13.6344705Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:54:13.6345844Z 	            ^
build	Build and Test	2026-07-17T23:54:13.6347508Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:54:13.6349576Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:54:13.6350720Z 	            ^
build	Build and Test	2026-07-17T23:54:13.6352275Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:54:13.6375039Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:54:13.6376236Z 	            ^
build	Build and Test	2026-07-17T23:54:13.6377804Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:54:13.6380084Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:54:13.6381225Z 	            ^
build	Build and Test	2026-07-17T23:54:13.6382570Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-17T23:54:13.6384083Z 	 * @param itemId
build	Build and Test	2026-07-17T23:54:13.6384770Z 	   ^
build	Build and Test	2026-07-17T23:54:13.6386113Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-17T23:54:13.6387623Z 	 * @return
build	Build and Test	2026-07-17T23:54:13.6388016Z 	   ^
build	Build and Test	2026-07-17T23:54:14.0429192Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-17T23:54:14.0429897Z 	               ^
build	Build and Test	2026-07-17T23:54:14.0431246Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-17T23:54:14.0432750Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-17T23:54:14.0433392Z 	             ^
build	Build and Test	2026-07-17T23:54:14.0435055Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-17T23:54:14.0436816Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-17T23:54:14.0437600Z 	            ^
build	Build and Test	2026-07-17T23:54:14.0439039Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-17T23:54:14.0440728Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-17T23:54:14.0441469Z 	            ^
build	Build and Test	2026-07-17T23:54:14.0442944Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-17T23:54:14.0444914Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-17T23:54:14.0445761Z 	            ^
build	Build and Test	2026-07-17T23:54:14.1210790Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-17T23:54:14.1212743Z 	public void select(Color color) {
build	Build and Test	2026-07-17T23:54:14.1213534Z 	            ^
build	Build and Test	2026-07-17T23:54:14.2217708Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-17T23:54:14.2220492Z 	 * @param dimmed
build	Build and Test	2026-07-17T23:54:14.2221296Z 	   ^
build	Build and Test	2026-07-17T23:54:14.2222913Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T23:54:14.2225023Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T23:54:14.2225923Z 	            ^
build	Build and Test	2026-07-17T23:54:14.2227549Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T23:54:14.2229818Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T23:54:14.2230697Z 	            ^
build	Build and Test	2026-07-17T23:54:14.3210426Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-17T23:54:14.3212611Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-17T23:54:14.3213605Z 		                                          ^
build	Build and Test	2026-07-17T23:54:18.9209188Z 100 warnings
build	Build and Test	2026-07-17T23:54:21.3224803Z
build	Build and Test	2026-07-17T23:54:25.9212575Z > Task :client:shadowJar
build	Build and Test	2026-07-17T23:54:25.9213210Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-17T23:54:25.9213767Z > Task :client:assemble
build	Build and Test	2026-07-17T23:54:26.3237476Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-17T23:54:26.3245071Z > Task :client:testClasses
build	Build and Test	2026-07-17T23:54:26.4259648Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-17T23:54:46.4236241Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-17T23:54:51.4225278Z > Task :client:checkstyleTest
build	Build and Test	2026-07-17T23:54:55.9235400Z > Task :client:checkstyleMain
build	Build and Test	2026-07-17T23:54:56.3214632Z
build	Build and Test	2026-07-17T23:54:56.3335375Z /tmp/junit1139996545169073521/junit11986717680707458024/vert.glsl.vert
build	Build and Test	2026-07-17T23:54:56.3336399Z /tmp/junit1139996545169073521/junit11986717680707458024/frag.glsl.frag
build	Build and Test	2026-07-17T23:54:56.3454645Z
build	Build and Test	2026-07-17T23:54:56.3515563Z > Task :client:pmdMain
build	Build and Test	2026-07-17T23:54:56.4255278Z > Task :client:test
build	Build and Test	2026-07-17T23:54:56.5244609Z
build	Build and Test	2026-07-17T23:54:56.5261293Z /tmp/junit1139996545169073521/junit13680554166156575860/vertui.glsl.vert
build	Build and Test	2026-07-17T23:54:56.5285293Z /tmp/junit1139996545169073521/junit13680554166156575860/fragui.glsl.frag
build	Build and Test	2026-07-17T23:54:58.0236486Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-17T23:54:58.3234997Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-17T23:54:58.4210590Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-17T23:54:58.4272047Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-17T23:55:05.4234604Z
build	Build and Test	2026-07-17T23:55:05.4275211Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-17T23:55:13.5214885Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784332433844.json
build	Build and Test	2026-07-17T23:55:13.5218004Z
build	Build and Test	2026-07-17T23:55:13.5218286Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-17T23:55:13.5245399Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T23:55:13.5245743Z
build	Build and Test	2026-07-17T23:55:13.5246084Z * What went wrong:
build	Build and Test	2026-07-17T23:55:13.5246619Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-17T23:55:13.5247563Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-17T23:55:13.5249007Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-17T23:55:13.5251727Z
build	Build and Test	2026-07-17T23:55:13.5251921Z * Try:
build	Build and Test	2026-07-17T23:55:13.5252365Z > Run with --scan to get full insights.
build	Build and Test	2026-07-17T23:55:13.5252746Z
build	Build and Test	2026-07-17T23:55:13.5252935Z BUILD FAILED in 1m 26s
build	Build and Test	2026-07-17T23:55:14.0419884Z ##[error]Process completed with exit code 1.
```

## CI: Apply verified KLite PMD fixes

- Run: [29621631511](https://github.com/KSPOG/klite/actions/runs/29621631511)
- Conclusion: `failure`
- Event: `push`
- Commit: `91780c61f328ae8d03c161026879e10ba75763c9`
- Created: `2026-07-17T23:48:50Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-17T23:49:34.6732064Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-17T23:49:34.6761942Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-17T23:49:34.9562890Z > Task :client:jar
build	Build and Test	2026-07-17T23:49:34.9582499Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-17T23:49:35.2554723Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-17T23:49:35.2572717Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-17T23:49:35.2602583Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-17T23:49:35.2603721Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-17T23:49:35.2604474Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-17T23:49:35.2605155Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-17T23:49:35.2605937Z > Task :runelite-api:build
build	Build and Test	2026-07-17T23:49:35.3552191Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-17T23:49:43.0562285Z
build	Build and Test	2026-07-17T23:49:43.0603657Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-17T23:49:43.0605172Z > Task :client:javadoc
build	Build and Test	2026-07-17T23:49:43.0632337Z 	 * @param duration
build	Build and Test	2026-07-17T23:49:43.0642236Z 	   ^
build	Build and Test	2026-07-17T23:49:43.0646479Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-17T23:49:43.0648101Z 	 * @param duration
build	Build and Test	2026-07-17T23:49:43.0648804Z 	   ^
build	Build and Test	2026-07-17T23:49:43.5564004Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:49:43.5566576Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:49:43.5567846Z 	            ^
build	Build and Test	2026-07-17T23:49:43.5569705Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:49:43.5572214Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:49:43.5573505Z 	            ^
build	Build and Test	2026-07-17T23:49:43.5575180Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:49:43.5577406Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:49:43.5578574Z 	            ^
build	Build and Test	2026-07-17T23:49:43.5581980Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:49:43.5584385Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:49:43.5585524Z 	            ^
build	Build and Test	2026-07-17T23:49:43.5587176Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:49:43.5589412Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:49:43.5590335Z 	            ^
build	Build and Test	2026-07-17T23:49:43.5591740Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:49:43.5593964Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:49:43.5595384Z 	            ^
build	Build and Test	2026-07-17T23:49:43.5596735Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:49:43.5598923Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:49:43.5600093Z 	            ^
build	Build and Test	2026-07-17T23:49:43.5601818Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:49:43.5604022Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:49:43.5605307Z 	            ^
build	Build and Test	2026-07-17T23:49:43.5606844Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:49:43.5609083Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:49:43.5610320Z 	            ^
build	Build and Test	2026-07-17T23:49:43.5611716Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-17T23:49:43.5613264Z 	 * @param itemId
build	Build and Test	2026-07-17T23:49:43.5613819Z 	   ^
build	Build and Test	2026-07-17T23:49:43.5615224Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-17T23:49:43.5616728Z 	 * @return
build	Build and Test	2026-07-17T23:49:43.5617267Z 	   ^
build	Build and Test	2026-07-17T23:49:44.1575937Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-17T23:49:44.1576743Z 	               ^
build	Build and Test	2026-07-17T23:49:44.1578125Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-17T23:49:44.1579701Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-17T23:49:44.1580514Z 	             ^
build	Build and Test	2026-07-17T23:49:44.1582147Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-17T23:49:44.1583861Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-17T23:49:44.1584779Z 	            ^
build	Build and Test	2026-07-17T23:49:44.1586318Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-17T23:49:44.1588085Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-17T23:49:44.1589082Z 	            ^
build	Build and Test	2026-07-17T23:49:44.1590608Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-17T23:49:44.1592535Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-17T23:49:44.1593465Z 	            ^
build	Build and Test	2026-07-17T23:49:44.1594954Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-17T23:49:44.1596309Z 	public void select(Color color) {
build	Build and Test	2026-07-17T23:49:44.1597086Z 	            ^
build	Build and Test	2026-07-17T23:49:44.2552819Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-17T23:49:44.2556063Z 	 * @param dimmed
build	Build and Test	2026-07-17T23:49:44.2565090Z 	   ^
build	Build and Test	2026-07-17T23:49:44.3556195Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T23:49:44.3572791Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T23:49:44.3597410Z 	            ^
build	Build and Test	2026-07-17T23:49:44.3604176Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T23:49:44.3627951Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T23:49:44.3628951Z 	            ^
build	Build and Test	2026-07-17T23:49:44.3630698Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-17T23:49:44.3632756Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-17T23:49:44.3633734Z 		                                          ^
build	Build and Test	2026-07-17T23:49:48.8554542Z 100 warnings
build	Build and Test	2026-07-17T23:49:50.9550533Z
build	Build and Test	2026-07-17T23:49:55.4593103Z > Task :client:shadowJar
build	Build and Test	2026-07-17T23:49:55.4643549Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-17T23:49:55.4692380Z > Task :client:assemble
build	Build and Test	2026-07-17T23:49:55.7551746Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-17T23:49:55.7582842Z > Task :client:testClasses
build	Build and Test	2026-07-17T23:49:55.9569887Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-17T23:50:14.5573003Z > Task :client:checkstyleTest
build	Build and Test	2026-07-17T23:50:17.4594251Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-17T23:50:25.4572964Z > Task :client:checkstyleMain
build	Build and Test	2026-07-17T23:50:25.6611895Z
build	Build and Test	2026-07-17T23:50:25.6668978Z /tmp/junit14779094202885449548/junit5764516436889166144/vert.glsl.vert
build	Build and Test	2026-07-17T23:50:25.6733039Z /tmp/junit14779094202885449548/junit5764516436889166144/frag.glsl.frag
build	Build and Test	2026-07-17T23:50:25.7562764Z /tmp/junit14779094202885449548/junit3606670992083014839/vertui.glsl.vert
build	Build and Test	2026-07-17T23:50:25.7615711Z /tmp/junit14779094202885449548/junit3606670992083014839/fragui.glsl.frag
build	Build and Test	2026-07-17T23:50:25.8601894Z
build	Build and Test	2026-07-17T23:50:25.8692584Z > Task :client:pmdMain
build	Build and Test	2026-07-17T23:50:25.9562843Z > Task :client:test
build	Build and Test	2026-07-17T23:50:27.4556101Z
build	Build and Test	2026-07-17T23:50:27.4604031Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-17T23:50:27.6563577Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-17T23:50:27.8574140Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-17T23:50:27.8625767Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-17T23:50:34.1571604Z
build	Build and Test	2026-07-17T23:50:34.1632650Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-17T23:50:39.4564228Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784332161713.json
build	Build and Test	2026-07-17T23:50:39.5549288Z
build	Build and Test	2026-07-17T23:50:39.5550661Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T23:50:39.5552092Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-17T23:50:39.5552915Z
build	Build and Test	2026-07-17T23:50:39.5553639Z * What went wrong:
build	Build and Test	2026-07-17T23:50:39.5554272Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-17T23:50:39.5555328Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-17T23:50:39.5556728Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-17T23:50:39.5558028Z
build	Build and Test	2026-07-17T23:50:39.5558254Z * Try:
build	Build and Test	2026-07-17T23:50:39.5558757Z > Run with --scan to get full insights.
build	Build and Test	2026-07-17T23:50:39.5559213Z
build	Build and Test	2026-07-17T23:50:39.5559432Z BUILD FAILED in 1m 30s
build	Build and Test	2026-07-17T23:50:40.0252004Z ##[error]Process completed with exit code 1.
```

