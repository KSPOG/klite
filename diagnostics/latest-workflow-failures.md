# Recent GitHub Actions failures

Generated: 2026-07-18T02:54:05.260648+00:00
Repository: `KSPOG/klite`
Failed runs inspected: **15**

## CI: Keep persisted schema version instance-scoped

- Run: [29627796454](https://github.com/KSPOG/klite/actions/runs/29627796454)
- Conclusion: `failure`
- Event: `push`
- Commit: `38fe0e42a531dc34c7fb06102488f2ae6e05b1c6`
- Created: `2026-07-18T02:51:59Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T02:52:34.2376684Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-18T02:52:34.2406568Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-18T02:52:34.2412946Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T02:52:34.2413582Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T02:52:34.5243592Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T02:52:34.5266845Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T02:52:34.5296609Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T02:52:34.5316682Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T02:52:34.5326626Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T02:52:34.5347965Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T02:52:34.5349237Z > Task :runelite-api:build
build	Build and Test	2026-07-18T02:52:34.5349877Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T02:52:41.8244140Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T02:52:41.8245678Z
build	Build and Test	2026-07-18T02:52:41.8256730Z 	 * @param duration
build	Build and Test	2026-07-18T02:52:41.8257227Z 	   ^
build	Build and Test	2026-07-18T02:52:41.8258583Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T02:52:41.8260140Z 	 * @param duration
build	Build and Test	2026-07-18T02:52:41.8260584Z 	   ^
build	Build and Test	2026-07-18T02:52:41.8266871Z > Task :client:javadoc
build	Build and Test	2026-07-18T02:52:42.2220234Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:52:42.2279548Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:52:42.2316948Z 	            ^
build	Build and Test	2026-07-18T02:52:42.2368308Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:52:42.2397346Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:52:42.2429620Z 	            ^
build	Build and Test	2026-07-18T02:52:42.2482015Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:52:42.2507173Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:52:42.2526753Z 	            ^
build	Build and Test	2026-07-18T02:52:42.2562995Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:52:42.2564782Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:52:42.2606650Z 	            ^
build	Build and Test	2026-07-18T02:52:42.2657619Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:52:42.2660737Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:52:42.2686467Z 	            ^
build	Build and Test	2026-07-18T02:52:42.2706516Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:52:42.2747153Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:52:42.2776466Z 	            ^
build	Build and Test	2026-07-18T02:52:42.2797153Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:52:42.2807363Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:52:42.2808720Z 	            ^
build	Build and Test	2026-07-18T02:52:42.2810615Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:52:42.2813186Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:52:42.2814480Z 	            ^
build	Build and Test	2026-07-18T02:52:42.2816369Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:52:42.2818841Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:52:42.2820201Z 	            ^
build	Build and Test	2026-07-18T02:52:42.2821771Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T02:52:42.2823485Z 	 * @param itemId
build	Build and Test	2026-07-18T02:52:42.2824128Z 	   ^
build	Build and Test	2026-07-18T02:52:42.3220387Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T02:52:42.3271370Z 	 * @return
build	Build and Test	2026-07-18T02:52:42.3296727Z 	   ^
build	Build and Test	2026-07-18T02:52:42.7382458Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T02:52:42.7382997Z 	               ^
build	Build and Test	2026-07-18T02:52:42.7384259Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T02:52:42.7385671Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T02:52:42.7386416Z 	             ^
build	Build and Test	2026-07-18T02:52:42.7387786Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T02:52:42.7389441Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T02:52:42.7390115Z 	            ^
build	Build and Test	2026-07-18T02:52:42.7391464Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T02:52:42.7393039Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T02:52:42.7393674Z 	            ^
build	Build and Test	2026-07-18T02:52:42.7395035Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T02:52:42.7397065Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T02:52:42.7397733Z 	            ^
build	Build and Test	2026-07-18T02:52:42.8238193Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T02:52:42.8246299Z 	public void select(Color color) {
build	Build and Test	2026-07-18T02:52:42.8247088Z 	            ^
build	Build and Test	2026-07-18T02:52:42.9219687Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T02:52:42.9223798Z 	 * @param dimmed
build	Build and Test	2026-07-18T02:52:42.9224447Z 	   ^
build	Build and Test	2026-07-18T02:52:42.9225764Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T02:52:42.9227854Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:52:42.9228978Z 	            ^
build	Build and Test	2026-07-18T02:52:42.9230515Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T02:52:42.9232313Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:52:42.9233111Z 	            ^
build	Build and Test	2026-07-18T02:52:43.0219589Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T02:52:43.0223293Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T02:52:43.0224560Z 		                                          ^
build	Build and Test	2026-07-18T02:52:47.2218912Z 100 warnings
build	Build and Test	2026-07-18T02:52:49.6220034Z
build	Build and Test	2026-07-18T02:52:49.6220899Z > Task :client:javadocJar
build	Build and Test	2026-07-18T02:52:49.6221648Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T02:52:54.3225724Z > Task :client:shadowJar
build	Build and Test	2026-07-18T02:52:54.3256806Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T02:52:54.3257463Z > Task :client:assemble
build	Build and Test	2026-07-18T02:52:54.7237069Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T02:52:54.7256679Z > Task :client:testClasses
build	Build and Test	2026-07-18T02:52:54.9226921Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T02:53:14.4253449Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T02:53:19.1219379Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T02:53:24.3297430Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T02:53:24.7227011Z > Task :client:pmdMain
build	Build and Test	2026-07-18T02:53:24.9286791Z > Task :client:test
build	Build and Test	2026-07-18T02:53:27.2226431Z
build	Build and Test	2026-07-18T02:53:27.2277439Z /tmp/junit6721244069880153225/junit3062305474884553024/vert.glsl.vert
build	Build and Test	2026-07-18T02:53:27.2397228Z /tmp/junit6721244069880153225/junit3062305474884553024/frag.glsl.frag
build	Build and Test	2026-07-18T02:53:27.4285426Z /tmp/junit6721244069880153225/junit15349489677539116642/vertui.glsl.vert
build	Build and Test	2026-07-18T02:53:27.4425746Z /tmp/junit6721244069880153225/junit15349489677539116642/fragui.glsl.frag
build	Build and Test	2026-07-18T02:53:29.6228295Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T02:53:30.0258159Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T02:53:30.1231267Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T02:53:30.2259669Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T02:53:36.2218408Z
build	Build and Test	2026-07-18T02:53:36.2267152Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T02:53:42.2230042Z
build	Build and Test	2026-07-18T02:53:42.2231143Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784343140544.json
build	Build and Test	2026-07-18T02:53:42.2246713Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T02:53:42.2256788Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T02:53:42.2286481Z
build	Build and Test	2026-07-18T02:53:42.2307670Z * What went wrong:
build	Build and Test	2026-07-18T02:53:42.2316741Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T02:53:42.2343931Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T02:53:42.2357123Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T02:53:42.2387214Z
build	Build and Test	2026-07-18T02:53:42.2387709Z * Try:
build	Build and Test	2026-07-18T02:53:42.2392431Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T02:53:42.2393042Z
build	Build and Test	2026-07-18T02:53:42.2393400Z BUILD FAILED in 1m 30s
build	Build and Test	2026-07-18T02:53:42.8024209Z ##[error]Process completed with exit code 1.
```

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29627709625](https://github.com/KSPOG/klite/actions/runs/29627709625)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `63d852ce8609eaabfd600bb8716b5b339916b2db`
- Created: `2026-07-18T02:49:11Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 3: **Collect recent failure details** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## Fix credit-related CI failures: Apply and verify credit-related CI fixes

- Run: [29627666561](https://github.com/KSPOG/klite/actions/runs/29627666561)
- Conclusion: `failure`
- Event: `push`
- Commit: `7364bf0036ef9df118822245f2e5a21bf900bf01`
- Created: `2026-07-18T02:47:40Z`

### Failed jobs and steps

- **fix-and-verify** — `failure`
  - Step 6: **Verify client PMD** — `failure`

### Relevant log context

```text
fix-and-verify	Verify client PMD	2026-07-18T02:48:55.9966142Z ^
fix-and-verify	Verify client PMD	2026-07-18T02:48:55.9998158Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/events/ChatboxInput.java:32: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
fix-and-verify	Verify client PMD	2026-07-18T02:48:56.0026814Z @Value
fix-and-verify	Verify client PMD	2026-07-18T02:48:56.0027723Z ^
fix-and-verify	Verify client PMD	2026-07-18T02:48:56.0108729Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/devtools/ScriptInspector.java:100: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
fix-and-verify	Verify client PMD	2026-07-18T02:48:56.0136228Z 	@Data
fix-and-verify	Verify client PMD	2026-07-18T02:48:56.0166189Z 	^
fix-and-verify	Verify client PMD	2026-07-18T02:49:03.1813033Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/agility/Courses.java:88: warning: non-varargs call of varargs method with inexact argument type for last parameter;
fix-and-verify	Verify client PMD	2026-07-18T02:49:03.1819320Z 		this(totalXp, -1, null);
fix-and-verify	Verify client PMD	2026-07-18T02:49:03.1820066Z 		                  ^
fix-and-verify	Verify client PMD	2026-07-18T02:49:03.1820866Z   cast to WorldPoint for a varargs call
fix-and-verify	Verify client PMD	2026-07-18T02:49:03.1821872Z   cast to WorldPoint[] for a non-varargs call and to suppress this warning
fix-and-verify	Verify client PMD	2026-07-18T02:49:07.9854971Z Note: Some input files use or override a deprecated API.
fix-and-verify	Verify client PMD	2026-07-18T02:49:07.9886349Z Note: Recompile with -Xlint:deprecation for details.
fix-and-verify	Verify client PMD	2026-07-18T02:49:07.9898436Z Note: Some input files use unchecked or unsafe operations.
fix-and-verify	Verify client PMD	2026-07-18T02:49:07.9899515Z Note: Recompile with -Xlint:unchecked for details.
fix-and-verify	Verify client PMD	2026-07-18T02:49:07.9900337Z 5 warnings
fix-and-verify	Verify client PMD	2026-07-18T02:49:08.5809181Z
fix-and-verify	Verify client PMD	2026-07-18T02:49:08.5814196Z > Task :client:classes
fix-and-verify	Verify client PMD	2026-07-18T02:49:21.3808845Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	FinalFieldCouldBeStatic:	This final field could be made static
fix-and-verify	Verify client PMD	2026-07-18T02:49:24.9808397Z > Task :client:pmdMain FAILED
fix-and-verify	Verify client PMD	2026-07-18T02:49:24.9827272Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run_2-1784342890192.json
fix-and-verify	Verify client PMD	2026-07-18T02:49:25.0806761Z
fix-and-verify	Verify client PMD	2026-07-18T02:49:25.0851494Z FAILURE: Build failed with an exception.
fix-and-verify	Verify client PMD	2026-07-18T02:49:25.0852202Z
fix-and-verify	Verify client PMD	2026-07-18T02:49:25.0852637Z * What went wrong:
fix-and-verify	Verify client PMD	2026-07-18T02:49:25.0853152Z Execution failed for task ':client:pmdMain'.
fix-and-verify	Verify client PMD	2026-07-18T02:49:25.0854245Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
fix-and-verify	Verify client PMD	2026-07-18T02:49:25.0856068Z    > 1 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
fix-and-verify	Verify client PMD	2026-07-18T02:49:25.0857137Z
fix-and-verify	Verify client PMD	2026-07-18T02:49:25.0888747Z * Try:
fix-and-verify	Verify client PMD	2026-07-18T02:49:25.0889214Z 23 actionable tasks: 23 executed
fix-and-verify	Verify client PMD	2026-07-18T02:49:25.0890200Z > Run with --scan to get full insights.
fix-and-verify	Verify client PMD	2026-07-18T02:49:25.0890603Z
fix-and-verify	Verify client PMD	2026-07-18T02:49:25.0890784Z BUILD FAILED in 1m 24s
fix-and-verify	Verify client PMD	2026-07-18T02:49:25.5072210Z ##[error]Process completed with exit code 1.
```

## CI: Apply and verify credit-related CI fixes

- Run: [29627666504](https://github.com/KSPOG/klite/actions/runs/29627666504)
- Conclusion: `failure`
- Event: `push`
- Commit: `7364bf0036ef9df118822245f2e5a21bf900bf01`
- Created: `2026-07-18T02:47:40Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T02:48:17.5223569Z > Task :copper-tin-miner:jar
build	Build and Test	2026-07-18T02:48:17.5253403Z > Task :copper-tin-miner:assemble
build	Build and Test	2026-07-18T02:48:17.7183213Z > Task :copper-tin-miner:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-18T02:48:17.7190215Z > Task :copper-tin-miner:compileTestJava NO-SOURCE
build	Build and Test	2026-07-18T02:48:17.7203875Z > Task :copper-tin-miner:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T02:48:17.7204834Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-18T02:48:17.7206006Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-18T02:48:17.7206868Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T02:48:17.7207712Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T02:48:17.9178678Z > Task :client:jar
build	Build and Test	2026-07-18T02:48:17.9179309Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T02:48:18.1182717Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T02:48:24.5204416Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T02:48:24.5205260Z
build	Build and Test	2026-07-18T02:48:24.5205389Z 	 * @param duration
build	Build and Test	2026-07-18T02:48:24.5205643Z 	   ^
build	Build and Test	2026-07-18T02:48:24.5206384Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T02:48:24.5207237Z 	 * @param duration
build	Build and Test	2026-07-18T02:48:24.5207511Z 	   ^
build	Build and Test	2026-07-18T02:48:24.5233963Z > Task :client:javadoc
build	Build and Test	2026-07-18T02:48:24.9186246Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:48:24.9216822Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:48:24.9243672Z 	            ^
build	Build and Test	2026-07-18T02:48:24.9268911Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:48:24.9284380Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:48:24.9285879Z 	            ^
build	Build and Test	2026-07-18T02:48:24.9287778Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:48:24.9290405Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:48:24.9291741Z 	            ^
build	Build and Test	2026-07-18T02:48:24.9293589Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:48:24.9296128Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:48:24.9297596Z 	            ^
build	Build and Test	2026-07-18T02:48:24.9299503Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:48:24.9302694Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:48:24.9304577Z 	            ^
build	Build and Test	2026-07-18T02:48:24.9306449Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:48:24.9309126Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:48:24.9310818Z 	            ^
build	Build and Test	2026-07-18T02:48:24.9312417Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:48:24.9315066Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:48:24.9337644Z 	            ^
build	Build and Test	2026-07-18T02:48:24.9339527Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:48:24.9342253Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:48:24.9343954Z 	            ^
build	Build and Test	2026-07-18T02:48:24.9345774Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:48:24.9348437Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:48:24.9349882Z 	            ^
build	Build and Test	2026-07-18T02:48:25.0200837Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T02:48:25.0235988Z 	 * @param itemId
build	Build and Test	2026-07-18T02:48:25.0285310Z 	   ^
build	Build and Test	2026-07-18T02:48:25.0300101Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T02:48:25.0349474Z 	 * @return
build	Build and Test	2026-07-18T02:48:25.0374665Z 	   ^
build	Build and Test	2026-07-18T02:48:25.4497880Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T02:48:25.4498592Z 	               ^
build	Build and Test	2026-07-18T02:48:25.4500010Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T02:48:25.4501682Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T02:48:25.4502424Z 	             ^
build	Build and Test	2026-07-18T02:48:25.4504156Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T02:48:25.4505994Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T02:48:25.4506868Z 	            ^
build	Build and Test	2026-07-18T02:48:25.4508435Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T02:48:25.4510259Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T02:48:25.4511151Z 	            ^
build	Build and Test	2026-07-18T02:48:25.4512797Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T02:48:25.4514922Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T02:48:25.4515914Z 	            ^
build	Build and Test	2026-07-18T02:48:25.5187104Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T02:48:25.5189075Z 	public void select(Color color) {
build	Build and Test	2026-07-18T02:48:25.5189872Z 	            ^
build	Build and Test	2026-07-18T02:48:25.6179686Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T02:48:25.6183825Z 	 * @param dimmed
build	Build and Test	2026-07-18T02:48:25.6184631Z 	   ^
build	Build and Test	2026-07-18T02:48:25.7191183Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T02:48:25.7194011Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:48:25.7194994Z 	            ^
build	Build and Test	2026-07-18T02:48:25.7196601Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T02:48:25.7198560Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:48:25.7199426Z 	            ^
build	Build and Test	2026-07-18T02:48:25.7201047Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T02:48:25.7203416Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T02:48:25.7204495Z 		                                          ^
build	Build and Test	2026-07-18T02:48:30.8178417Z 100 warnings
build	Build and Test	2026-07-18T02:48:33.0179262Z
build	Build and Test	2026-07-18T02:48:33.0180452Z > Task :client:javadocJar
build	Build and Test	2026-07-18T02:48:33.0181062Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T02:48:37.6203985Z > Task :client:shadowJar
build	Build and Test	2026-07-18T02:48:37.6206504Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T02:48:37.6207826Z > Task :client:assemble
build	Build and Test	2026-07-18T02:48:38.0214118Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T02:48:38.0233790Z > Task :client:testClasses
build	Build and Test	2026-07-18T02:48:38.2184068Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T02:48:56.5178724Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T02:48:58.9255212Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T02:49:07.6213998Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T02:49:08.0213844Z > Task :client:pmdMain
build	Build and Test	2026-07-18T02:49:08.2193997Z > Task :client:test
build	Build and Test	2026-07-18T02:49:09.1203480Z
build	Build and Test	2026-07-18T02:49:09.1235287Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T02:49:09.4259705Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T02:49:09.6205405Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T02:49:09.6235178Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T02:49:10.6184244Z /tmp/junit16871883324217064244/junit3096796417214940782/vert.glsl.vert
build	Build and Test	2026-07-18T02:49:10.6243912Z /tmp/junit16871883324217064244/junit3096796417214940782/frag.glsl.frag
build	Build and Test	2026-07-18T02:49:10.8178778Z /tmp/junit16871883324217064244/junit9410703922642406012/vertui.glsl.vert
build	Build and Test	2026-07-18T02:49:10.8233942Z /tmp/junit16871883324217064244/junit9410703922642406012/fragui.glsl.frag
build	Build and Test	2026-07-18T02:49:15.8177718Z
build	Build and Test	2026-07-18T02:49:15.8203790Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T02:49:22.1184652Z
build	Build and Test	2026-07-18T02:49:22.1185776Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784342883897.json
build	Build and Test	2026-07-18T02:49:22.1187262Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T02:49:22.1187656Z
build	Build and Test	2026-07-18T02:49:22.1187840Z * What went wrong:
build	Build and Test	2026-07-18T02:49:22.1188327Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T02:49:22.1189240Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T02:49:22.1190711Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T02:49:22.1191857Z
build	Build and Test	2026-07-18T02:49:22.1192020Z * Try:
build	Build and Test	2026-07-18T02:49:22.1192435Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T02:49:22.1192808Z
build	Build and Test	2026-07-18T02:49:22.1193241Z BUILD FAILED in 1m 26s
build	Build and Test	2026-07-18T02:49:22.1203687Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T02:49:22.5921283Z ##[error]Process completed with exit code 1.
```

## CI: Add patch for credit-related CI failures

- Run: [29627658488](https://github.com/KSPOG/klite/actions/runs/29627658488)
- Conclusion: `failure`
- Event: `push`
- Commit: `d162238f026d5495078fbfeb60498a162be10515`
- Created: `2026-07-18T02:47:23Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T02:47:56.1163529Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T02:47:56.1193496Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T02:47:56.7996916Z > Task :client:jar
build	Build and Test	2026-07-18T02:47:56.8023672Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T02:47:57.0004407Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T02:47:57.0053980Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T02:47:57.0103906Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T02:47:57.0133887Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T02:47:57.0988228Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T02:47:57.0991256Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T02:47:57.0992099Z > Task :runelite-api:build
build	Build and Test	2026-07-18T02:47:57.0992815Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T02:48:03.8015269Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T02:48:03.8016679Z
build	Build and Test	2026-07-18T02:48:03.8025088Z 	 * @param duration
build	Build and Test	2026-07-18T02:48:03.8035131Z > Task :client:javadoc
build	Build and Test	2026-07-18T02:48:03.8061635Z 	   ^
build	Build and Test	2026-07-18T02:48:03.8064607Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T02:48:03.8066118Z 	 * @param duration
build	Build and Test	2026-07-18T02:48:03.8066542Z 	   ^
build	Build and Test	2026-07-18T02:48:04.2994074Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:48:04.3024385Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:48:04.3053764Z 	            ^
build	Build and Test	2026-07-18T02:48:04.3055796Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:48:04.3084325Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:48:04.3110957Z 	            ^
build	Build and Test	2026-07-18T02:48:04.3112600Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:48:04.3115481Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:48:04.3116543Z 	            ^
build	Build and Test	2026-07-18T02:48:04.3117937Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:48:04.3120083Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:48:04.3121242Z 	            ^
build	Build and Test	2026-07-18T02:48:04.3122848Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:48:04.3125843Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:48:04.3126980Z 	            ^
build	Build and Test	2026-07-18T02:48:04.3128544Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:48:04.3130801Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:48:04.3131929Z 	            ^
build	Build and Test	2026-07-18T02:48:04.3137186Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:48:04.3139346Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:48:04.3140489Z 	            ^
build	Build and Test	2026-07-18T02:48:04.3142089Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:48:04.3144666Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:48:04.3145792Z 	            ^
build	Build and Test	2026-07-18T02:48:04.3147313Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:48:04.3154240Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:48:04.3155402Z 	            ^
build	Build and Test	2026-07-18T02:48:04.3156790Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T02:48:04.3158293Z 	 * @param itemId
build	Build and Test	2026-07-18T02:48:04.3158715Z 	   ^
build	Build and Test	2026-07-18T02:48:04.3160050Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T02:48:04.3161516Z 	 * @return
build	Build and Test	2026-07-18T02:48:04.3161900Z 	   ^
build	Build and Test	2026-07-18T02:48:04.8043857Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T02:48:04.8044485Z 	               ^
build	Build and Test	2026-07-18T02:48:04.8049085Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T02:48:04.8050872Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T02:48:04.8051618Z 	             ^
build	Build and Test	2026-07-18T02:48:04.8053357Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T02:48:04.8055177Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T02:48:04.8055974Z 	            ^
build	Build and Test	2026-07-18T02:48:04.8057447Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T02:48:04.8059156Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T02:48:04.8059904Z 	            ^
build	Build and Test	2026-07-18T02:48:04.8061397Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T02:48:04.8063403Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T02:48:04.8064222Z 	            ^
build	Build and Test	2026-07-18T02:48:04.8996665Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T02:48:04.9004326Z 	public void select(Color color) {
build	Build and Test	2026-07-18T02:48:04.9005090Z 	            ^
build	Build and Test	2026-07-18T02:48:04.9988839Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T02:48:04.9991074Z 	 * @param dimmed
build	Build and Test	2026-07-18T02:48:04.9991685Z 	   ^
build	Build and Test	2026-07-18T02:48:05.0987562Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T02:48:05.0991583Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:48:05.0992466Z 	            ^
build	Build and Test	2026-07-18T02:48:05.0994282Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T02:48:05.0996447Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:48:05.0998664Z 	            ^
build	Build and Test	2026-07-18T02:48:05.1987424Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T02:48:05.2014197Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T02:48:05.2044075Z 		                                          ^
build	Build and Test	2026-07-18T02:48:09.3986408Z 100 warnings
build	Build and Test	2026-07-18T02:48:11.8005536Z
build	Build and Test	2026-07-18T02:48:11.8006521Z > Task :client:javadocJar
build	Build and Test	2026-07-18T02:48:11.8007799Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T02:48:16.4988841Z > Task :client:shadowJar
build	Build and Test	2026-07-18T02:48:16.4994280Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T02:48:16.4995075Z > Task :client:assemble
build	Build and Test	2026-07-18T02:48:16.8015928Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T02:48:16.8016751Z > Task :client:testClasses
build	Build and Test	2026-07-18T02:48:17.0034531Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T02:48:37.7014078Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T02:48:40.0995157Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T02:48:46.5016153Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T02:48:46.9043987Z > Task :client:pmdMain
build	Build and Test	2026-07-18T02:48:46.9993964Z > Task :client:test
build	Build and Test	2026-07-18T02:48:47.4993475Z
build	Build and Test	2026-07-18T02:48:47.5084317Z /tmp/junit12330517058881582715/junit14664136208803338294/vert.glsl.vert
build	Build and Test	2026-07-18T02:48:47.5164707Z /tmp/junit12330517058881582715/junit14664136208803338294/frag.glsl.frag
build	Build and Test	2026-07-18T02:48:47.7031608Z /tmp/junit12330517058881582715/junit16654327193224990595/vertui.glsl.vert
build	Build and Test	2026-07-18T02:48:47.7094250Z /tmp/junit12330517058881582715/junit16654327193224990595/fragui.glsl.frag
build	Build and Test	2026-07-18T02:48:50.9035202Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T02:48:51.4015220Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T02:48:51.6005541Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T02:48:51.6035077Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T02:48:57.7003555Z
build	Build and Test	2026-07-18T02:48:57.7034079Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T02:49:02.5986294Z
build	Build and Test	2026-07-18T02:49:02.5987171Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784342863870.json
build	Build and Test	2026-07-18T02:49:02.5988462Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T02:49:02.5988887Z
build	Build and Test	2026-07-18T02:49:02.5989270Z * What went wrong:
build	Build and Test	2026-07-18T02:49:02.5989630Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T02:49:02.5990496Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T02:49:02.5991667Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T02:49:02.5992567Z
build	Build and Test	2026-07-18T02:49:02.5992767Z * Try:
build	Build and Test	2026-07-18T02:49:02.5993442Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T02:49:02.5995654Z
build	Build and Test	2026-07-18T02:49:02.5995862Z BUILD FAILED in 1m 26s
build	Build and Test	2026-07-18T02:49:02.5996407Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T02:49:03.0611220Z ##[error]Process completed with exit code 1.
```

## CI: Align all website header controls

- Run: [29627626782](https://github.com/KSPOG/klite/actions/runs/29627626782)
- Conclusion: `failure`
- Event: `push`
- Commit: `89424a4cef054171c25ee44d3a1e3e0829fc2f35`
- Created: `2026-07-18T02:46:16Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T02:46:55.7207475Z > Task :copper-tin-miner:jar
build	Build and Test	2026-07-18T02:46:55.7208023Z > Task :copper-tin-miner:assemble
build	Build and Test	2026-07-18T02:46:56.0131011Z > Task :copper-tin-miner:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-18T02:46:56.0163717Z > Task :copper-tin-miner:compileTestJava NO-SOURCE
build	Build and Test	2026-07-18T02:46:56.0175908Z > Task :copper-tin-miner:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T02:46:56.0176887Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-18T02:46:56.0178350Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-18T02:46:56.0179159Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T02:46:56.0179931Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T02:46:56.2131267Z > Task :client:jar
build	Build and Test	2026-07-18T02:46:56.2145987Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T02:46:56.5130762Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T02:47:03.6155658Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T02:47:03.6157226Z
build	Build and Test	2026-07-18T02:47:03.6159664Z 	 * @param duration
build	Build and Test	2026-07-18T02:47:03.6160207Z > Task :client:javadoc
build	Build and Test	2026-07-18T02:47:03.6161172Z 	   ^
build	Build and Test	2026-07-18T02:47:03.6162866Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T02:47:03.6167066Z 	 * @param duration
build	Build and Test	2026-07-18T02:47:03.6167781Z 	   ^
build	Build and Test	2026-07-18T02:47:04.2131459Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:47:04.2173975Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:47:04.2198205Z 	            ^
build	Build and Test	2026-07-18T02:47:04.2226787Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:47:04.2276267Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:47:04.2301327Z 	            ^
build	Build and Test	2026-07-18T02:47:04.2307562Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:47:04.2366519Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:47:04.2386068Z 	            ^
build	Build and Test	2026-07-18T02:47:04.2388120Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:47:04.2390614Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:47:04.2391977Z 	            ^
build	Build and Test	2026-07-18T02:47:04.2393794Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:47:04.2397487Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:47:04.2401998Z 	            ^
build	Build and Test	2026-07-18T02:47:04.2403970Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:47:04.2407532Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:47:04.2408843Z 	            ^
build	Build and Test	2026-07-18T02:47:04.2410369Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T02:47:04.2412654Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:47:04.2413974Z 	            ^
build	Build and Test	2026-07-18T02:47:04.2415929Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T02:47:04.2418445Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:47:04.2419723Z 	            ^
build	Build and Test	2026-07-18T02:47:04.2421336Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T02:47:04.2423694Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T02:47:04.2425136Z 	            ^
build	Build and Test	2026-07-18T02:47:04.3131285Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T02:47:04.3156159Z 	 * @param itemId
build	Build and Test	2026-07-18T02:47:04.3176066Z 	   ^
build	Build and Test	2026-07-18T02:47:04.3177694Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T02:47:04.3179345Z 	 * @return
build	Build and Test	2026-07-18T02:47:04.3179836Z 	   ^
build	Build and Test	2026-07-18T02:47:04.7236006Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T02:47:04.7236725Z 	               ^
build	Build and Test	2026-07-18T02:47:04.7238168Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T02:47:04.7239780Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T02:47:04.7240514Z 	             ^
build	Build and Test	2026-07-18T02:47:04.7242175Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T02:47:04.7244040Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T02:47:04.7245085Z 	            ^
build	Build and Test	2026-07-18T02:47:04.7246663Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T02:47:04.7248484Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T02:47:04.7249323Z 	            ^
build	Build and Test	2026-07-18T02:47:04.7250895Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T02:47:04.7252731Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T02:47:04.7253597Z 	            ^
build	Build and Test	2026-07-18T02:47:04.8131864Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T02:47:04.8135564Z 	public void select(Color color) {
build	Build and Test	2026-07-18T02:47:04.8143077Z 	            ^
build	Build and Test	2026-07-18T02:47:04.9131345Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T02:47:04.9135248Z 	 * @param dimmed
build	Build and Test	2026-07-18T02:47:04.9136020Z 	   ^
build	Build and Test	2026-07-18T02:47:05.0130651Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T02:47:05.0134063Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:47:05.0165516Z 	            ^
build	Build and Test	2026-07-18T02:47:05.0167849Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T02:47:05.0195754Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T02:47:05.0199830Z 	            ^
build	Build and Test	2026-07-18T02:47:05.1130700Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T02:47:05.1133581Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T02:47:05.1134553Z 		                                          ^
build	Build and Test	2026-07-18T02:47:10.0129122Z 100 warnings
build	Build and Test	2026-07-18T02:47:12.4145372Z
build	Build and Test	2026-07-18T02:47:12.4176086Z > Task :client:javadocJar
build	Build and Test	2026-07-18T02:47:12.4206134Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T02:47:17.0129962Z > Task :client:shadowJar
build	Build and Test	2026-07-18T02:47:17.0130885Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T02:47:17.0132075Z > Task :client:assemble
build	Build and Test	2026-07-18T02:47:17.3129989Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T02:47:17.3130776Z > Task :client:testClasses
build	Build and Test	2026-07-18T02:47:17.5177861Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T02:47:38.5140129Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T02:47:41.6156973Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T02:47:47.0136005Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T02:47:47.4178677Z > Task :client:pmdMain
build	Build and Test	2026-07-18T02:47:47.5129296Z > Task :client:test
build	Build and Test	2026-07-18T02:47:48.2163984Z
build	Build and Test	2026-07-18T02:47:48.2226340Z /tmp/junit2912440302264886043/junit7618345967520411127/vert.glsl.vert
build	Build and Test	2026-07-18T02:47:48.2346116Z /tmp/junit2912440302264886043/junit7618345967520411127/frag.glsl.frag
build	Build and Test	2026-07-18T02:47:48.2369888Z /tmp/junit2912440302264886043/junit526065631382802519/vertui.glsl.vert
build	Build and Test	2026-07-18T02:47:48.2429512Z /tmp/junit2912440302264886043/junit526065631382802519/fragui.glsl.frag
build	Build and Test	2026-07-18T02:47:52.9157053Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T02:47:53.2207370Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T02:47:53.3157451Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T02:47:53.3227342Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T02:48:00.4136422Z
build	Build and Test	2026-07-18T02:48:00.4168191Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T02:48:06.3131931Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784342802139.json
build	Build and Test	2026-07-18T02:48:06.4128447Z
build	Build and Test	2026-07-18T02:48:06.4165627Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T02:48:06.4166391Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T02:48:06.4195597Z
build	Build and Test	2026-07-18T02:48:06.4206016Z * What went wrong:
build	Build and Test	2026-07-18T02:48:06.4206795Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T02:48:06.4208245Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T02:48:06.4209758Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T02:48:06.4210694Z
build	Build and Test	2026-07-18T02:48:06.4210813Z * Try:
build	Build and Test	2026-07-18T02:48:06.4211105Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T02:48:06.4211357Z
build	Build and Test	2026-07-18T02:48:06.4211490Z BUILD FAILED in 1m 32s
build	Build and Test	2026-07-18T02:48:06.8743365Z ##[error]Process completed with exit code 1.
```

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

