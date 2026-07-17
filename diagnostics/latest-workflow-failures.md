# Recent GitHub Actions failures

Generated: 2026-07-17T23:56:34.553886+00:00
Repository: `KSPOG/klite`
Failed runs inspected: **15**

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

## Apply verified KLite PMD fixes: Apply verified KLite PMD fixes

- Run: [29621631508](https://github.com/KSPOG/klite/actions/runs/29621631508)
- Conclusion: `failure`
- Event: `push`
- Commit: `91780c61f328ae8d03c161026879e10ba75763c9`
- Created: `2026-07-17T23:48:50Z`

### Failed jobs and steps

- **apply** — `failure`
  - Step 5: **Verify PMD** — `failure`

### Relevant log context

```text
apply	Verify PMD	2026-07-17T23:50:50.5672844Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/party/messages/PartyChatMessage.java:29: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
apply	Verify PMD	2026-07-17T23:50:50.5700972Z @Value
apply	Verify PMD	2026-07-17T23:50:50.5721025Z ^
apply	Verify PMD	2026-07-17T23:50:50.5733022Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/devtools/ScriptInspector.java:100: warning: Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object. If this is intentional, add '@EqualsAndHashCode(callSuper=false)' to your type.
apply	Verify PMD	2026-07-17T23:50:50.5761033Z 	@Data
apply	Verify PMD	2026-07-17T23:50:50.5791098Z 	^
apply	Verify PMD	2026-07-17T23:50:58.2522371Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/agility/Courses.java:88: warning: non-varargs call of varargs method with inexact argument type for last parameter;
apply	Verify PMD	2026-07-17T23:50:58.2551315Z 		this(totalXp, -1, null);
apply	Verify PMD	2026-07-17T23:50:58.2561087Z 		                  ^
apply	Verify PMD	2026-07-17T23:50:58.2611178Z   cast to WorldPoint for a varargs call
apply	Verify PMD	2026-07-17T23:50:58.2641254Z   cast to WorldPoint[] for a non-varargs call and to suppress this warning
apply	Verify PMD	2026-07-17T23:51:02.9544723Z Note: Some input files use or override a deprecated API.
apply	Verify PMD	2026-07-17T23:51:02.9545891Z Note: Recompile with -Xlint:deprecation for details.
apply	Verify PMD	2026-07-17T23:51:02.9571313Z Note: Some input files use unchecked or unsafe operations.
apply	Verify PMD	2026-07-17T23:51:02.9598392Z Note: Recompile with -Xlint:unchecked for details.
apply	Verify PMD	2026-07-17T23:51:02.9621092Z 5 warnings
apply	Verify PMD	2026-07-17T23:51:04.2519537Z
apply	Verify PMD	2026-07-17T23:51:04.2520378Z > Task :client:classes
apply	Verify PMD	2026-07-17T23:51:12.2562951Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
apply	Verify PMD	2026-07-17T23:51:17.5522818Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	FinalFieldCouldBeStatic:	This final field could be made static
apply	Verify PMD	2026-07-17T23:51:20.7532296Z > Task :client:pmdMain FAILED
apply	Verify PMD	2026-07-17T23:51:20.8519540Z
apply	Verify PMD	2026-07-17T23:51:20.8525902Z FAILURE: Build failed with an exception.
apply	Verify PMD	2026-07-17T23:51:20.8526554Z 23 actionable tasks: 23 executed
apply	Verify PMD	2026-07-17T23:51:20.8527190Z
apply	Verify PMD	2026-07-17T23:51:20.8527539Z * What went wrong:
apply	Verify PMD	2026-07-17T23:51:20.8528178Z Execution failed for task ':client:pmdMain'.
apply	Verify PMD	2026-07-17T23:51:20.8529191Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
apply	Verify PMD	2026-07-17T23:51:20.8530998Z    > 2 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
apply	Verify PMD	2026-07-17T23:51:20.8532089Z
apply	Verify PMD	2026-07-17T23:51:20.8532387Z * Try:
apply	Verify PMD	2026-07-17T23:51:20.8532944Z > Run with --scan to get full insights.
apply	Verify PMD	2026-07-17T23:51:20.8533517Z
apply	Verify PMD	2026-07-17T23:51:20.8533845Z BUILD FAILED in 2m 16s
apply	Verify PMD	2026-07-17T23:51:21.2657672Z ##[error]Process completed with exit code 1.
```

## CI: Refresh and automate workflow failure diagnostics

- Run: [29621414634](https://github.com/KSPOG/klite/actions/runs/29621414634)
- Conclusion: `failure`
- Event: `push`
- Commit: `45890e950054e50e5edda92e469547f998839ae6`
- Created: `2026-07-17T23:43:30Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-17T23:43:58.2907935Z > Task :copper-tin-miner:jar
build	Build and Test	2026-07-17T23:43:58.2932683Z > Task :copper-tin-miner:assemble
build	Build and Test	2026-07-17T23:43:58.4860277Z > Task :copper-tin-miner:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-17T23:43:58.4872336Z > Task :copper-tin-miner:compileTestJava NO-SOURCE
build	Build and Test	2026-07-17T23:43:58.4873543Z > Task :copper-tin-miner:testClasses UP-TO-DATE
build	Build and Test	2026-07-17T23:43:58.4874365Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-17T23:43:58.4875974Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-17T23:43:58.4876648Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-17T23:43:58.4877377Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-17T23:43:58.7860242Z > Task :client:jar
build	Build and Test	2026-07-17T23:43:58.7872556Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-17T23:43:58.8859827Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-17T23:44:03.0883574Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-17T23:44:03.0884654Z
build	Build and Test	2026-07-17T23:44:03.0886405Z > Task :client:javadoc
build	Build and Test	2026-07-17T23:44:03.0912279Z 	 * @param duration
build	Build and Test	2026-07-17T23:44:03.0925060Z 	   ^
build	Build and Test	2026-07-17T23:44:03.0927004Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-17T23:44:03.0952321Z 	 * @param duration
build	Build and Test	2026-07-17T23:44:03.0952832Z 	   ^
build	Build and Test	2026-07-17T23:44:03.4859341Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:44:03.4893222Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:44:03.4922560Z 	            ^
build	Build and Test	2026-07-17T23:44:03.4924269Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:44:03.4952717Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:44:03.4982227Z 	            ^
build	Build and Test	2026-07-17T23:44:03.5012946Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:44:03.5014869Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:44:03.5042219Z 	            ^
build	Build and Test	2026-07-17T23:44:03.5063162Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:44:03.5065346Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:44:03.5066629Z 	            ^
build	Build and Test	2026-07-17T23:44:03.5068129Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:44:03.5070581Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:44:03.5071802Z 	            ^
build	Build and Test	2026-07-17T23:44:03.5073210Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:44:03.5075176Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:44:03.5076393Z 	            ^
build	Build and Test	2026-07-17T23:44:03.5077810Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:44:03.5079629Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:44:03.5080676Z 	            ^
build	Build and Test	2026-07-17T23:44:03.5082110Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:44:03.5091246Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:44:03.5122319Z 	            ^
build	Build and Test	2026-07-17T23:44:03.5153277Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:44:03.5155275Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:44:03.5181485Z 	            ^
build	Build and Test	2026-07-17T23:44:03.5214773Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-17T23:44:03.5244382Z 	 * @param itemId
build	Build and Test	2026-07-17T23:44:03.5272243Z 	   ^
build	Build and Test	2026-07-17T23:44:03.5303324Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-17T23:44:03.5354328Z 	 * @return
build	Build and Test	2026-07-17T23:44:03.5392294Z 	   ^
build	Build and Test	2026-07-17T23:44:03.8880227Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-17T23:44:03.8880877Z 	               ^
build	Build and Test	2026-07-17T23:44:03.8882154Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-17T23:44:03.8883561Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-17T23:44:03.8884208Z 	             ^
build	Build and Test	2026-07-17T23:44:03.8885457Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-17T23:44:03.8886935Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-17T23:44:03.8887710Z 	            ^
build	Build and Test	2026-07-17T23:44:03.8888935Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-17T23:44:03.8912438Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-17T23:44:03.8930996Z 	            ^
build	Build and Test	2026-07-17T23:44:03.8932572Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-17T23:44:03.8934092Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-17T23:44:03.8934822Z 	            ^
build	Build and Test	2026-07-17T23:44:03.8936064Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-17T23:44:03.8937381Z 	public void select(Color color) {
build	Build and Test	2026-07-17T23:44:03.8938029Z 	            ^
build	Build and Test	2026-07-17T23:44:03.9871468Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-17T23:44:03.9879417Z 	 * @param dimmed
build	Build and Test	2026-07-17T23:44:03.9881861Z 	   ^
build	Build and Test	2026-07-17T23:44:03.9883157Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T23:44:03.9884387Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T23:44:03.9884967Z 	            ^
build	Build and Test	2026-07-17T23:44:03.9885951Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T23:44:03.9887472Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T23:44:03.9888213Z 	            ^
build	Build and Test	2026-07-17T23:44:04.0859416Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-17T23:44:04.0876035Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-17T23:44:04.0892130Z 		                                          ^
build	Build and Test	2026-07-17T23:44:07.4859130Z 100 warnings
build	Build and Test	2026-07-17T23:44:09.1859359Z
build	Build and Test	2026-07-17T23:44:09.1860726Z > Task :client:javadocJar
build	Build and Test	2026-07-17T23:44:09.1867800Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-17T23:44:13.0864983Z > Task :client:shadowJar
build	Build and Test	2026-07-17T23:44:13.0866015Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-17T23:44:13.0866987Z > Task :client:assemble
build	Build and Test	2026-07-17T23:44:13.2873050Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-17T23:44:13.2912573Z > Task :client:testClasses
build	Build and Test	2026-07-17T23:44:13.4912894Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-17T23:44:28.4865364Z > Task :client:checkstyleTest
build	Build and Test	2026-07-17T23:44:30.0903597Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-17T23:44:36.1872723Z /tmp/junit6827454308465687702/junit1553032436801397126/vert.glsl.vert
build	Build and Test	2026-07-17T23:44:36.1913072Z /tmp/junit6827454308465687702/junit1553032436801397126/frag.glsl.frag
build	Build and Test	2026-07-17T23:44:36.2872736Z /tmp/junit6827454308465687702/junit17784938513262589626/vertui.glsl.vert
build	Build and Test	2026-07-17T23:44:36.2975017Z /tmp/junit6827454308465687702/junit17784938513262589626/fragui.glsl.frag
build	Build and Test	2026-07-17T23:44:37.9933894Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-17T23:44:38.2885012Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-17T23:44:38.3859614Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-17T23:44:38.3893703Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-17T23:44:43.0882711Z > Task :client:checkstyleMain
build	Build and Test	2026-07-17T23:44:43.3892692Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-17T23:44:43.4859426Z > Task :client:test
build	Build and Test	2026-07-17T23:44:47.2857297Z
build	Build and Test	2026-07-17T23:44:47.2858523Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784331827795.json
build	Build and Test	2026-07-17T23:44:47.2859559Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-17T23:44:47.2860458Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T23:44:47.2861084Z
build	Build and Test	2026-07-17T23:44:47.2861551Z * What went wrong:
build	Build and Test	2026-07-17T23:44:47.2862057Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-17T23:44:47.2862655Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-17T23:44:47.6856509Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-17T23:44:47.6857087Z
build	Build and Test	2026-07-17T23:44:47.6857237Z * Try:
build	Build and Test	2026-07-17T23:44:47.6857598Z > Run with --scan to get full insights.
build	Build and Test	2026-07-17T23:44:47.6857837Z
build	Build and Test	2026-07-17T23:44:47.6858189Z BUILD FAILED in 1m 2s
build	Build and Test	2026-07-17T23:44:47.6872061Z ##[error]Process completed with exit code 1.
```

## CI: Prevent stale obsidian website theme assets

- Run: [29621097478](https://github.com/KSPOG/klite/actions/runs/29621097478)
- Conclusion: `failure`
- Event: `push`
- Commit: `deb1d2e90ca3c0334bc0e417f5796ed820dbebdf`
- Created: `2026-07-17T23:35:49Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-17T23:36:36.3025294Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-17T23:36:36.3026491Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-17T23:36:36.3055316Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-17T23:36:36.3085199Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-17T23:36:36.3896122Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-17T23:36:36.3918017Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-17T23:36:36.3920216Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-17T23:36:36.4896663Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-17T23:36:36.4907843Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-17T23:36:36.4908778Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-17T23:36:36.4909555Z > Task :runelite-api:build
build	Build and Test	2026-07-17T23:36:36.5893498Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-17T23:36:43.8902116Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-17T23:36:43.8903646Z
build	Build and Test	2026-07-17T23:36:43.8904096Z > Task :client:javadoc
build	Build and Test	2026-07-17T23:36:43.8907956Z 	 * @param duration
build	Build and Test	2026-07-17T23:36:43.8908611Z 	   ^
build	Build and Test	2026-07-17T23:36:43.8910055Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-17T23:36:43.8911653Z 	 * @param duration
build	Build and Test	2026-07-17T23:36:43.8912118Z 	   ^
build	Build and Test	2026-07-17T23:36:44.4932042Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:36:44.4937895Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:36:44.4939479Z 	            ^
build	Build and Test	2026-07-17T23:36:44.4941420Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:36:44.4943987Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:36:44.4945558Z 	            ^
build	Build and Test	2026-07-17T23:36:44.4947292Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:36:44.4949717Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:36:44.4950965Z 	            ^
build	Build and Test	2026-07-17T23:36:44.4952544Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:36:44.4955135Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:36:44.4962837Z 	            ^
build	Build and Test	2026-07-17T23:36:44.4964985Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:36:44.4968218Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:36:44.4969510Z 	            ^
build	Build and Test	2026-07-17T23:36:44.4971163Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:36:44.4973504Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:36:44.4975031Z 	            ^
build	Build and Test	2026-07-17T23:36:44.4976522Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:36:44.4978616Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:36:44.4979994Z 	            ^
build	Build and Test	2026-07-17T23:36:44.4981803Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:36:44.4984383Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:36:44.4985960Z 	            ^
build	Build and Test	2026-07-17T23:36:44.4987816Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:36:44.4990428Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:36:44.4991794Z 	            ^
build	Build and Test	2026-07-17T23:36:44.4993354Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-17T23:36:44.4995320Z 	 * @param itemId
build	Build and Test	2026-07-17T23:36:44.4995776Z 	   ^
build	Build and Test	2026-07-17T23:36:44.4997060Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-17T23:36:44.4998499Z 	 * @return
build	Build and Test	2026-07-17T23:36:44.4998883Z 	   ^
build	Build and Test	2026-07-17T23:36:45.0036059Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-17T23:36:45.0065929Z 	               ^
build	Build and Test	2026-07-17T23:36:45.0097599Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-17T23:36:45.0105948Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-17T23:36:45.0106828Z 	             ^
build	Build and Test	2026-07-17T23:36:45.0108553Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-17T23:36:45.0110602Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-17T23:36:45.0111542Z 	            ^
build	Build and Test	2026-07-17T23:36:45.0113221Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-17T23:36:45.0123377Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-17T23:36:45.0124318Z 	            ^
build	Build and Test	2026-07-17T23:36:45.0135167Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-17T23:36:45.0137088Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-17T23:36:45.0137916Z 	            ^
build	Build and Test	2026-07-17T23:36:45.0139444Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-17T23:36:45.0141564Z 	public void select(Color color) {
build	Build and Test	2026-07-17T23:36:45.0142333Z 	            ^
build	Build and Test	2026-07-17T23:36:45.0906634Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-17T23:36:45.0908083Z 	 * @param dimmed
build	Build and Test	2026-07-17T23:36:45.0908360Z 	   ^
build	Build and Test	2026-07-17T23:36:45.0909130Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T23:36:45.0910043Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T23:36:45.0910413Z 	            ^
build	Build and Test	2026-07-17T23:36:45.0911194Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T23:36:45.0912141Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T23:36:45.0912509Z 	            ^
build	Build and Test	2026-07-17T23:36:45.1897272Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-17T23:36:45.1899580Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-17T23:36:45.1900961Z 		                                          ^
build	Build and Test	2026-07-17T23:36:49.8891547Z 100 warnings
build	Build and Test	2026-07-17T23:36:52.2893182Z
build	Build and Test	2026-07-17T23:36:52.2893838Z > Task :client:javadocJar
build	Build and Test	2026-07-17T23:36:52.2894408Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-17T23:36:57.0935110Z > Task :client:shadowJar
build	Build and Test	2026-07-17T23:36:57.0936511Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-17T23:36:57.0966590Z > Task :client:assemble
build	Build and Test	2026-07-17T23:36:57.3892091Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-17T23:36:57.3918018Z > Task :client:testClasses
build	Build and Test	2026-07-17T23:36:57.6892355Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-17T23:37:19.2891722Z > Task :client:checkstyleTest
build	Build and Test	2026-07-17T23:37:22.1906917Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-17T23:37:27.0905776Z > Task :client:checkstyleMain
build	Build and Test	2026-07-17T23:37:27.4892063Z > Task :client:pmdMain
build	Build and Test	2026-07-17T23:37:27.6891958Z > Task :client:test
build	Build and Test	2026-07-17T23:37:28.4895263Z
build	Build and Test	2026-07-17T23:37:28.4975883Z /tmp/junit11957349288787597235/junit1147063913985684260/vert.glsl.vert
build	Build and Test	2026-07-17T23:37:28.5095840Z /tmp/junit11957349288787597235/junit1147063913985684260/frag.glsl.frag
build	Build and Test	2026-07-17T23:37:28.6969544Z /tmp/junit11957349288787597235/junit2604365923299209676/vertui.glsl.vert
build	Build and Test	2026-07-17T23:37:28.6992764Z /tmp/junit11957349288787597235/junit2604365923299209676/fragui.glsl.frag
build	Build and Test	2026-07-17T23:37:33.8906786Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-17T23:37:34.0946942Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-17T23:37:34.2937318Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-17T23:37:34.2966934Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-17T23:37:40.9905306Z
build	Build and Test	2026-07-17T23:37:40.9977100Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-17T23:37:45.8893404Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784331382325.json
build	Build and Test	2026-07-17T23:37:45.8895482Z
build	Build and Test	2026-07-17T23:37:45.8895800Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-17T23:37:45.8897160Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T23:37:45.8899371Z
build	Build and Test	2026-07-17T23:37:45.8899870Z * What went wrong:
build	Build and Test	2026-07-17T23:37:45.8900628Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-17T23:37:45.8901796Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-17T23:37:45.8903992Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-17T23:37:45.8905517Z
build	Build and Test	2026-07-17T23:37:45.8905886Z * Try:
build	Build and Test	2026-07-17T23:37:45.8906539Z > Run with --scan to get full insights.
build	Build and Test	2026-07-17T23:37:45.8907152Z
build	Build and Test	2026-07-17T23:37:45.8907525Z BUILD FAILED in 1m 31s
build	Build and Test	2026-07-17T23:37:46.3965454Z ##[error]Process completed with exit code 1.
```

## CI: Load obsidian release website theme

- Run: [29621084961](https://github.com/KSPOG/klite/actions/runs/29621084961)
- Conclusion: `failure`
- Event: `push`
- Commit: `4171f1e1f4aff850c077374b188a9028a880ca2b`
- Created: `2026-07-17T23:35:29Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-17T23:36:05.7044568Z > Task :copper-tin-miner:jar
build	Build and Test	2026-07-17T23:36:05.7045328Z > Task :copper-tin-miner:assemble
build	Build and Test	2026-07-17T23:36:05.8919748Z > Task :copper-tin-miner:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-17T23:36:05.8926372Z > Task :copper-tin-miner:compileTestJava NO-SOURCE
build	Build and Test	2026-07-17T23:36:05.8927378Z > Task :copper-tin-miner:testClasses UP-TO-DATE
build	Build and Test	2026-07-17T23:36:05.8928364Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-17T23:36:05.8929213Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-17T23:36:05.8930120Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-17T23:36:05.8930891Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-17T23:36:06.1921804Z > Task :client:jar
build	Build and Test	2026-07-17T23:36:06.1922463Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-17T23:36:06.2927529Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-17T23:36:12.8947759Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-17T23:36:12.8949080Z
build	Build and Test	2026-07-17T23:36:12.8966648Z 	 * @param duration
build	Build and Test	2026-07-17T23:36:12.8967183Z > Task :client:javadoc
build	Build and Test	2026-07-17T23:36:12.8973874Z 	   ^
build	Build and Test	2026-07-17T23:36:12.8975934Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-17T23:36:12.8981731Z 	 * @param duration
build	Build and Test	2026-07-17T23:36:12.8982583Z 	   ^
build	Build and Test	2026-07-17T23:36:13.3936302Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:36:13.3972751Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:36:13.3977396Z 	            ^
build	Build and Test	2026-07-17T23:36:13.4012526Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:36:13.4045195Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:36:13.4054537Z 	            ^
build	Build and Test	2026-07-17T23:36:13.4075928Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:36:13.4085565Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:36:13.4087101Z 	            ^
build	Build and Test	2026-07-17T23:36:13.4088773Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:36:13.4115392Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:36:13.4144583Z 	            ^
build	Build and Test	2026-07-17T23:36:13.4175940Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:36:13.4205199Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:36:13.4206496Z 	            ^
build	Build and Test	2026-07-17T23:36:13.4235852Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:36:13.4265154Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:36:13.4289618Z 	            ^
build	Build and Test	2026-07-17T23:36:13.4321205Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:36:13.4345144Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:36:13.4356298Z 	            ^
build	Build and Test	2026-07-17T23:36:13.4363551Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:36:13.4366462Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:36:13.4367884Z 	            ^
build	Build and Test	2026-07-17T23:36:13.4369813Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:36:13.4372552Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:36:13.4374294Z 	            ^
build	Build and Test	2026-07-17T23:36:13.4376058Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-17T23:36:13.4378352Z 	 * @param itemId
build	Build and Test	2026-07-17T23:36:13.4379051Z 	   ^
build	Build and Test	2026-07-17T23:36:13.4380730Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-17T23:36:13.4382736Z 	 * @return
build	Build and Test	2026-07-17T23:36:13.4383379Z 	   ^
build	Build and Test	2026-07-17T23:36:13.8057180Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-17T23:36:13.8057710Z 	               ^
build	Build and Test	2026-07-17T23:36:13.8059019Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-17T23:36:13.8060486Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-17T23:36:13.8061036Z 	             ^
build	Build and Test	2026-07-17T23:36:13.8062441Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-17T23:36:13.8064325Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-17T23:36:13.8065005Z 	            ^
build	Build and Test	2026-07-17T23:36:13.8066391Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-17T23:36:13.8068033Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-17T23:36:13.8068682Z 	            ^
build	Build and Test	2026-07-17T23:36:13.8070080Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-17T23:36:13.8071791Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-17T23:36:13.8072467Z 	            ^
build	Build and Test	2026-07-17T23:36:13.8921665Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-17T23:36:13.8930973Z 	public void select(Color color) {
build	Build and Test	2026-07-17T23:36:13.8931743Z 	            ^
build	Build and Test	2026-07-17T23:36:13.8933383Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-17T23:36:13.8935758Z 	 * @param dimmed
build	Build and Test	2026-07-17T23:36:13.8936371Z 	   ^
build	Build and Test	2026-07-17T23:36:13.9929631Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T23:36:13.9940732Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T23:36:13.9954850Z 	            ^
build	Build and Test	2026-07-17T23:36:13.9976038Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T23:36:13.9995093Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T23:36:13.9996007Z 	            ^
build	Build and Test	2026-07-17T23:36:14.0922771Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-17T23:36:14.0925373Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-17T23:36:14.0926412Z 		                                          ^
build	Build and Test	2026-07-17T23:36:18.8919457Z 100 warnings
build	Build and Test	2026-07-17T23:36:21.1920015Z
build	Build and Test	2026-07-17T23:36:21.1936127Z > Task :client:javadocJar
build	Build and Test	2026-07-17T23:36:21.1937415Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-17T23:36:25.7919132Z > Task :client:shadowJar
build	Build and Test	2026-07-17T23:36:25.7920876Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-17T23:36:25.7921687Z > Task :client:assemble
build	Build and Test	2026-07-17T23:36:26.1975205Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-17T23:36:26.2027817Z > Task :client:testClasses
build	Build and Test	2026-07-17T23:36:26.3945295Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-17T23:36:44.2018669Z > Task :client:checkstyleTest
build	Build and Test	2026-07-17T23:36:49.1973103Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-17T23:36:54.9919115Z /tmp/junit4713973717617150567/junit6063909104959664275/vert.glsl.vert
build	Build and Test	2026-07-17T23:36:54.9962461Z /tmp/junit4713973717617150567/junit6063909104959664275/frag.glsl.frag
build	Build and Test	2026-07-17T23:36:55.0945411Z /tmp/junit4713973717617150567/junit9465171279534958785/vertui.glsl.vert
build	Build and Test	2026-07-17T23:36:55.1065079Z /tmp/junit4713973717617150567/junit9465171279534958785/fragui.glsl.frag
build	Build and Test	2026-07-17T23:36:55.7935127Z > Task :client:checkstyleMain
build	Build and Test	2026-07-17T23:36:56.1994880Z > Task :client:pmdMain
build	Build and Test	2026-07-17T23:36:56.3977937Z > Task :client:test
build	Build and Test	2026-07-17T23:36:58.0947705Z
build	Build and Test	2026-07-17T23:36:58.1051029Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-17T23:36:58.3952090Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-17T23:36:58.4042839Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-17T23:36:58.4086109Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-17T23:37:04.1924313Z
build	Build and Test	2026-07-17T23:37:04.1974837Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-17T23:37:08.8920016Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784331352244.json
build	Build and Test	2026-07-17T23:37:08.8921591Z
build	Build and Test	2026-07-17T23:37:08.8923288Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T23:37:08.8923840Z
build	Build and Test	2026-07-17T23:37:08.8924065Z * What went wrong:
build	Build and Test	2026-07-17T23:37:08.8924693Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-17T23:37:08.8925568Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-17T23:37:08.8927034Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-17T23:37:08.8928291Z
build	Build and Test	2026-07-17T23:37:08.8928465Z * Try:
build	Build and Test	2026-07-17T23:37:08.8928906Z > Run with --scan to get full insights.
build	Build and Test	2026-07-17T23:37:08.8929300Z
build	Build and Test	2026-07-17T23:37:08.8929498Z BUILD FAILED in 1m 24s
build	Build and Test	2026-07-17T23:37:08.8935122Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-17T23:37:09.4077127Z ##[error]Process completed with exit code 1.
```

## CI: Apply obsidian KLite release theme

- Run: [29621065439](https://github.com/KSPOG/klite/actions/runs/29621065439)
- Conclusion: `failure`
- Event: `push`
- Commit: `9b7986060ed794d792a3f6b431e36eb97edf5fa3`
- Created: `2026-07-17T23:35:04Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-17T23:35:45.6486958Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-17T23:35:45.6505868Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-17T23:35:46.1434646Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-17T23:35:46.1473960Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-17T23:35:46.1474735Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-17T23:35:46.1489983Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-17T23:35:46.2416163Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-17T23:35:46.2444323Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-17T23:35:46.2464382Z > Task :runelite-api:build
build	Build and Test	2026-07-17T23:35:46.2467040Z > Task :client:jar
build	Build and Test	2026-07-17T23:35:46.2467690Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-17T23:35:46.5414353Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-17T23:35:53.4419169Z
build	Build and Test	2026-07-17T23:35:53.4426214Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-17T23:35:53.4427878Z > Task :client:javadoc
build	Build and Test	2026-07-17T23:35:53.4454178Z 	 * @param duration
build	Build and Test	2026-07-17T23:35:53.4472102Z 	   ^
build	Build and Test	2026-07-17T23:35:53.4504803Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-17T23:35:53.4506446Z 	 * @param duration
build	Build and Test	2026-07-17T23:35:53.4520061Z 	   ^
build	Build and Test	2026-07-17T23:35:53.9435376Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:35:53.9448407Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:35:53.9463865Z 	            ^
build	Build and Test	2026-07-17T23:35:53.9495187Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:35:53.9544349Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:35:53.9570214Z 	            ^
build	Build and Test	2026-07-17T23:35:53.9622146Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:35:53.9654351Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:35:53.9683736Z 	            ^
build	Build and Test	2026-07-17T23:35:53.9714740Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:35:53.9744301Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:35:53.9767277Z 	            ^
build	Build and Test	2026-07-17T23:35:53.9795083Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:35:53.9798250Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:35:53.9799640Z 	            ^
build	Build and Test	2026-07-17T23:35:53.9801690Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:35:53.9804440Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:35:53.9805749Z 	            ^
build	Build and Test	2026-07-17T23:35:53.9807215Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:35:53.9809459Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:35:53.9810748Z 	            ^
build	Build and Test	2026-07-17T23:35:53.9812487Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:35:53.9815163Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:35:53.9816353Z 	            ^
build	Build and Test	2026-07-17T23:35:53.9817966Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:35:53.9820330Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:35:53.9821503Z 	            ^
build	Build and Test	2026-07-17T23:35:53.9822892Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-17T23:35:53.9844923Z 	 * @param itemId
build	Build and Test	2026-07-17T23:35:53.9845546Z 	   ^
build	Build and Test	2026-07-17T23:35:53.9846968Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-17T23:35:53.9848550Z 	 * @return
build	Build and Test	2026-07-17T23:35:53.9848956Z 	   ^
build	Build and Test	2026-07-17T23:35:54.3598757Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-17T23:35:54.3599441Z 	               ^
build	Build and Test	2026-07-17T23:35:54.3600926Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-17T23:35:54.3613792Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-17T23:35:54.3642116Z 	             ^
build	Build and Test	2026-07-17T23:35:54.3664626Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-17T23:35:54.3666260Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-17T23:35:54.3666932Z 	            ^
build	Build and Test	2026-07-17T23:35:54.3668298Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-17T23:35:54.3669868Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-17T23:35:54.3670502Z 	            ^
build	Build and Test	2026-07-17T23:35:54.3671861Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-17T23:35:54.3673693Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-17T23:35:54.3674359Z 	            ^
build	Build and Test	2026-07-17T23:35:54.4445130Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-17T23:35:54.4466157Z 	public void select(Color color) {
build	Build and Test	2026-07-17T23:35:54.4466994Z 	            ^
build	Build and Test	2026-07-17T23:35:54.4468667Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-17T23:35:54.4471486Z 	 * @param dimmed
build	Build and Test	2026-07-17T23:35:54.4472409Z 	   ^
build	Build and Test	2026-07-17T23:35:54.5417321Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T23:35:54.5432887Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T23:35:54.5438078Z 	            ^
build	Build and Test	2026-07-17T23:35:54.5439828Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T23:35:54.5441898Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T23:35:54.5442834Z 	            ^
build	Build and Test	2026-07-17T23:35:54.6427478Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-17T23:35:54.6454031Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-17T23:35:54.6470285Z 		                                          ^
build	Build and Test	2026-07-17T23:35:59.2413423Z 100 warnings
build	Build and Test	2026-07-17T23:36:01.6414693Z
build	Build and Test	2026-07-17T23:36:01.6415284Z > Task :client:javadocJar
build	Build and Test	2026-07-17T23:36:01.6415927Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-17T23:36:06.2436014Z > Task :client:shadowJar
build	Build and Test	2026-07-17T23:36:06.2439003Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-17T23:36:06.2441249Z > Task :client:assemble
build	Build and Test	2026-07-17T23:36:06.5463691Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-17T23:36:06.5464766Z > Task :client:testClasses
build	Build and Test	2026-07-17T23:36:06.7418691Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-17T23:36:27.2454263Z > Task :client:checkstyleTest
build	Build and Test	2026-07-17T23:36:30.2436740Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-17T23:36:36.2457900Z > Task :client:checkstyleMain
build	Build and Test	2026-07-17T23:36:36.6424182Z > Task :client:pmdMain
build	Build and Test	2026-07-17T23:36:36.7474432Z > Task :client:test
build	Build and Test	2026-07-17T23:36:37.3423370Z
build	Build and Test	2026-07-17T23:36:37.3434081Z /tmp/junit17528780650898575163/junit7633907577125845748/vert.glsl.vert
build	Build and Test	2026-07-17T23:36:37.3444721Z /tmp/junit17528780650898575163/junit7633907577125845748/frag.glsl.frag
build	Build and Test	2026-07-17T23:36:37.5484439Z /tmp/junit17528780650898575163/junit4289456836753475292/vertui.glsl.vert
build	Build and Test	2026-07-17T23:36:37.5539817Z /tmp/junit17528780650898575163/junit4289456836753475292/fragui.glsl.frag
build	Build and Test	2026-07-17T23:36:40.8414313Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-17T23:36:41.2414169Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-17T23:36:41.3414662Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-17T23:36:41.3515457Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-17T23:36:47.8412384Z
build	Build and Test	2026-07-17T23:36:47.8412994Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-17T23:36:52.3414193Z
build	Build and Test	2026-07-17T23:36:52.3414783Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T23:36:52.3415686Z
build	Build and Test	2026-07-17T23:36:52.3415845Z * What went wrong:
build	Build and Test	2026-07-17T23:36:52.3416866Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-17T23:36:52.3417924Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-17T23:36:52.3419649Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784331333261.json
build	Build and Test	2026-07-17T23:36:52.3420864Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-17T23:36:52.3422208Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-17T23:36:52.3423529Z
build	Build and Test	2026-07-17T23:36:52.3423713Z * Try:
build	Build and Test	2026-07-17T23:36:52.3424140Z > Run with --scan to get full insights.
build	Build and Test	2026-07-17T23:36:52.3424583Z
build	Build and Test	2026-07-17T23:36:52.3424806Z BUILD FAILED in 1m 27s
build	Build and Test	2026-07-17T23:36:52.7932402Z ##[error]Process completed with exit code 1.
```

## CI: Redirect Windows downloads directly to latest setup

- Run: [29620864634](https://github.com/KSPOG/klite/actions/runs/29620864634)
- Conclusion: `failure`
- Event: `push`
- Commit: `1a30e3199e68e159f05653ac18ffa9b8c0484435`
- Created: `2026-07-17T23:30:32Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-17T23:31:02.5376928Z > Task :copper-tin-miner:jar
build	Build and Test	2026-07-17T23:31:02.5406929Z > Task :copper-tin-miner:assemble
build	Build and Test	2026-07-17T23:31:02.7341325Z > Task :copper-tin-miner:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-17T23:31:02.7346037Z > Task :copper-tin-miner:compileTestJava NO-SOURCE
build	Build and Test	2026-07-17T23:31:02.7347216Z > Task :copper-tin-miner:testClasses UP-TO-DATE
build	Build and Test	2026-07-17T23:31:02.7348366Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-17T23:31:02.7349139Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-17T23:31:02.7349869Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-17T23:31:02.7350593Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-17T23:31:02.9339987Z > Task :client:jar
build	Build and Test	2026-07-17T23:31:02.9342364Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-17T23:31:03.1348436Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-17T23:31:08.6378974Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-17T23:31:08.6380382Z
build	Build and Test	2026-07-17T23:31:08.6397031Z 	 * @param duration
build	Build and Test	2026-07-17T23:31:08.6397505Z > Task :client:javadoc
build	Build and Test	2026-07-17T23:31:08.6406651Z 	   ^
build	Build and Test	2026-07-17T23:31:08.6407914Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-17T23:31:08.6409329Z 	 * @param duration
build	Build and Test	2026-07-17T23:31:08.6409713Z 	   ^
build	Build and Test	2026-07-17T23:31:09.1378540Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:31:09.1409532Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:31:09.1410305Z 	            ^
build	Build and Test	2026-07-17T23:31:09.1411542Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:31:09.1413367Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:31:09.1414301Z 	            ^
build	Build and Test	2026-07-17T23:31:09.1415669Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:31:09.1417737Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:31:09.1418693Z 	            ^
build	Build and Test	2026-07-17T23:31:09.1419962Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:31:09.1421973Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:31:09.1423029Z 	            ^
build	Build and Test	2026-07-17T23:31:09.1424516Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:31:09.1427224Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:31:09.1428271Z 	            ^
build	Build and Test	2026-07-17T23:31:09.1429692Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:31:09.1431732Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:31:09.1433005Z 	            ^
build	Build and Test	2026-07-17T23:31:09.1434264Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:31:09.1440256Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:31:09.1441415Z 	            ^
build	Build and Test	2026-07-17T23:31:09.1442871Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:31:09.1444975Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:31:09.1445976Z 	            ^
build	Build and Test	2026-07-17T23:31:09.1447546Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:31:09.1449566Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:31:09.1450617Z 	            ^
build	Build and Test	2026-07-17T23:31:09.2341069Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-17T23:31:09.2364142Z 	 * @param itemId
build	Build and Test	2026-07-17T23:31:09.2387316Z 	   ^
build	Build and Test	2026-07-17T23:31:09.2431432Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-17T23:31:09.2448365Z 	 * @return
build	Build and Test	2026-07-17T23:31:09.2477222Z 	   ^
build	Build and Test	2026-07-17T23:31:09.6351837Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-17T23:31:09.6352535Z 	               ^
build	Build and Test	2026-07-17T23:31:09.6353962Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-17T23:31:09.6355486Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-17T23:31:09.6356341Z 	             ^
build	Build and Test	2026-07-17T23:31:09.6357756Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-17T23:31:09.6359466Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-17T23:31:09.6360259Z 	            ^
build	Build and Test	2026-07-17T23:31:09.6361690Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-17T23:31:09.6363352Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-17T23:31:09.6364156Z 	            ^
build	Build and Test	2026-07-17T23:31:09.6365595Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-17T23:31:09.6367282Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-17T23:31:09.6368018Z 	            ^
build	Build and Test	2026-07-17T23:31:09.6369324Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-17T23:31:09.6370806Z 	public void select(Color color) {
build	Build and Test	2026-07-17T23:31:09.6371398Z 	            ^
build	Build and Test	2026-07-17T23:31:09.7340868Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-17T23:31:09.7344712Z 	 * @param dimmed
build	Build and Test	2026-07-17T23:31:09.7345305Z 	   ^
build	Build and Test	2026-07-17T23:31:09.7346899Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T23:31:09.7349237Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T23:31:09.7350372Z 	            ^
build	Build and Test	2026-07-17T23:31:09.7351872Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T23:31:09.7353575Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T23:31:09.7354363Z 	            ^
build	Build and Test	2026-07-17T23:31:09.8348289Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-17T23:31:09.8357328Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-17T23:31:09.8367435Z 		                                          ^
build	Build and Test	2026-07-17T23:31:13.8338226Z 100 warnings
build	Build and Test	2026-07-17T23:31:16.2338768Z
build	Build and Test	2026-07-17T23:31:16.2339848Z > Task :client:javadocJar
build	Build and Test	2026-07-17T23:31:16.2340691Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-17T23:31:20.9338773Z > Task :client:shadowJar
build	Build and Test	2026-07-17T23:31:20.9339825Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-17T23:31:20.9340797Z > Task :client:assemble
build	Build and Test	2026-07-17T23:31:21.3385295Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-17T23:31:21.3417120Z > Task :client:testClasses
build	Build and Test	2026-07-17T23:31:21.5404375Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-17T23:31:40.7357368Z > Task :client:checkstyleTest
build	Build and Test	2026-07-17T23:31:43.4378437Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-17T23:31:49.0338736Z /tmp/junit1836991514538373031/junit3897881562399879383/vert.glsl.vert
build	Build and Test	2026-07-17T23:31:49.0341695Z /tmp/junit1836991514538373031/junit3897881562399879383/frag.glsl.frag
build	Build and Test	2026-07-17T23:31:49.1366892Z /tmp/junit1836991514538373031/junit13994293601161489195/vertui.glsl.vert
build	Build and Test	2026-07-17T23:31:49.1382984Z /tmp/junit1836991514538373031/junit13994293601161489195/fragui.glsl.frag
build	Build and Test	2026-07-17T23:31:50.9357266Z > Task :client:checkstyleMain
build	Build and Test	2026-07-17T23:31:51.3397348Z > Task :client:pmdMain
build	Build and Test	2026-07-17T23:31:51.5364574Z > Task :client:test
build	Build and Test	2026-07-17T23:31:53.2337973Z
build	Build and Test	2026-07-17T23:31:53.2341090Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-17T23:31:53.3458609Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-17T23:31:53.5369316Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-17T23:31:53.5418454Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-17T23:31:59.1376729Z
build	Build and Test	2026-07-17T23:31:59.1447062Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-17T23:32:03.0339537Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784331050147.json
build	Build and Test	2026-07-17T23:32:03.0340925Z
build	Build and Test	2026-07-17T23:32:03.0344301Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-17T23:32:03.0346845Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T23:32:03.0347209Z
build	Build and Test	2026-07-17T23:32:03.0347374Z * What went wrong:
build	Build and Test	2026-07-17T23:32:03.0347831Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-17T23:32:03.0348823Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-17T23:32:03.0350347Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-17T23:32:03.0368769Z
build	Build and Test	2026-07-17T23:32:03.0369171Z * Try:
build	Build and Test	2026-07-17T23:32:03.0369697Z > Run with --scan to get full insights.
build	Build and Test	2026-07-17T23:32:03.0370251Z
build	Build and Test	2026-07-17T23:32:03.0370600Z BUILD FAILED in 1m 19s
build	Build and Test	2026-07-17T23:32:03.5531923Z ##[error]Process completed with exit code 1.
```

## Verify live KLite Windows update: Make browser setup downloads independent of manifest proxy

- Run: [29620725772](https://github.com/KSPOG/klite/actions/runs/29620725772)
- Conclusion: `failure`
- Event: `push`
- Commit: `cd437247feda164b5b2230ecd72f1bca20098f76`
- Created: `2026-07-17T23:27:16Z`

### Failed jobs and steps

- **verify-live-update** — `failure`
  - Step 3: **Wait for the Pages deployment** — `failure`

### Relevant log context

```text
verify-live-update	Wait for the Pages deployment	﻿2026-07-17T23:27:44.0038604Z ##[group]Run set -euo pipefail
verify-live-update	Wait for the Pages deployment	2026-07-17T23:27:44.0040022Z ^[[36;1mset -euo pipefail^[[0m
verify-live-update	Wait for the Pages deployment	2026-07-17T23:27:44.0042075Z ^[[36;1mexpected_asset="$(jq -r '.assetName' marketplace-site/public/client/windows/latest.json)"^[[0m
verify-live-update	Wait for the Pages deployment	2026-07-17T23:27:44.0044609Z ^[[36;1m^[[0m
verify-live-update	Wait for the Pages deployment	2026-07-17T23:27:44.0045555Z ^[[36;1mfor attempt in $(seq 1 20); do^[[0m
verify-live-update	Wait for the Pages deployment	2026-07-17T23:27:44.0046824Z ^[[36;1m  headers="$(mktemp)"^[[0m
verify-live-update	Wait for the Pages deployment	2026-07-17T23:27:44.0048153Z ^[[36;1m  if curl --silent --show-error --fail --head \^[[0m
verify-live-update	Wait for the Pages deployment	2026-07-17T23:27:44.0049731Z ^[[36;1m    --header 'Cache-Control: no-store' \^[[0m
verify-live-update	Wait for the Pages deployment	2026-07-17T23:27:44.0051141Z ^[[36;1m    --output /dev/null \^[[0m
verify-live-update	Wait for the Pages deployment	2026-07-17T23:27:44.0052349Z ^[[36;1m    --dump-header "$headers" \^[[0m
verify-live-update	Wait for the Pages deployment	2026-07-17T23:27:44.0055174Z ^[[36;1m    "https://klite-marketplace.pages.dev/download/windows?deployment_probe=${GITHUB_RUN_ID}-${attempt}"; then^[[0m
verify-live-update	Wait for the Pages deployment	2026-07-17T23:27:44.0058949Z ^[[36;1m    live_asset="$(awk -F': ' 'tolower($1) == "x-klite-installer-asset" {gsub("\\r", "", $2); print $2}' "$headers" | tail -n 1)"^[[0m
verify-live-update	Wait for the Pages deployment	2026-07-17T23:27:44.0061674Z ^[[36;1m    if [ "$live_asset" = "$expected_asset" ]; then^[[0m
verify-live-update	Wait for the Pages deployment	2026-07-17T23:27:44.0063667Z ^[[36;1m      echo "The live Pages Function is serving the expected asset: $live_asset"^[[0m
verify-live-update	Wait for the Pages deployment	2026-07-17T23:27:59.2451089Z Attempt 2: live asset '' does not yet match 'KLite-Setup-1.0.89-18d506cad791da2f.exe'.
verify-live-update	Wait for the Pages deployment	2026-07-17T23:28:14.3119054Z Attempt 3: live asset '' does not yet match 'KLite-Setup-1.0.89-18d506cad791da2f.exe'.
verify-live-update	Wait for the Pages deployment	2026-07-17T23:28:29.3753538Z Attempt 4: live asset '' does not yet match 'KLite-Setup-1.0.89-18d506cad791da2f.exe'.
verify-live-update	Wait for the Pages deployment	2026-07-17T23:28:44.4422762Z Attempt 5: live asset '' does not yet match 'KLite-Setup-1.0.89-18d506cad791da2f.exe'.
verify-live-update	Wait for the Pages deployment	2026-07-17T23:28:59.5077765Z Attempt 6: live asset '' does not yet match 'KLite-Setup-1.0.89-18d506cad791da2f.exe'.
verify-live-update	Wait for the Pages deployment	2026-07-17T23:29:14.5766336Z Attempt 7: live asset '' does not yet match 'KLite-Setup-1.0.89-18d506cad791da2f.exe'.
verify-live-update	Wait for the Pages deployment	2026-07-17T23:29:29.6410545Z Attempt 8: live asset '' does not yet match 'KLite-Setup-1.0.89-18d506cad791da2f.exe'.
verify-live-update	Wait for the Pages deployment	2026-07-17T23:29:44.7180624Z Attempt 9: live asset '' does not yet match 'KLite-Setup-1.0.89-18d506cad791da2f.exe'.
verify-live-update	Wait for the Pages deployment	2026-07-17T23:29:59.7795804Z Attempt 10: live asset '' does not yet match 'KLite-Setup-1.0.89-18d506cad791da2f.exe'.
verify-live-update	Wait for the Pages deployment	2026-07-17T23:30:14.8420747Z Attempt 11: live asset '' does not yet match 'KLite-Setup-1.0.89-18d506cad791da2f.exe'.
verify-live-update	Wait for the Pages deployment	2026-07-17T23:30:29.9010929Z Attempt 12: live asset '' does not yet match 'KLite-Setup-1.0.89-18d506cad791da2f.exe'.
verify-live-update	Wait for the Pages deployment	2026-07-17T23:30:44.9644898Z Attempt 13: live asset '' does not yet match 'KLite-Setup-1.0.89-18d506cad791da2f.exe'.
verify-live-update	Wait for the Pages deployment	2026-07-17T23:31:00.0278823Z Attempt 14: live asset '' does not yet match 'KLite-Setup-1.0.89-18d506cad791da2f.exe'.
verify-live-update	Wait for the Pages deployment	2026-07-17T23:31:15.1111274Z Attempt 15: live asset '' does not yet match 'KLite-Setup-1.0.89-18d506cad791da2f.exe'.
verify-live-update	Wait for the Pages deployment	2026-07-17T23:31:30.1594484Z Attempt 16: live asset '' does not yet match 'KLite-Setup-1.0.89-18d506cad791da2f.exe'.
verify-live-update	Wait for the Pages deployment	2026-07-17T23:31:45.2089732Z Attempt 17: live asset '' does not yet match 'KLite-Setup-1.0.89-18d506cad791da2f.exe'.
verify-live-update	Wait for the Pages deployment	2026-07-17T23:32:00.2629853Z Attempt 18: live asset '' does not yet match 'KLite-Setup-1.0.89-18d506cad791da2f.exe'.
verify-live-update	Wait for the Pages deployment	2026-07-17T23:32:15.3182917Z Attempt 19: live asset '' does not yet match 'KLite-Setup-1.0.89-18d506cad791da2f.exe'.
verify-live-update	Wait for the Pages deployment	2026-07-17T23:32:30.3655942Z Attempt 20: live asset '' does not yet match 'KLite-Setup-1.0.89-18d506cad791da2f.exe'.
verify-live-update	Wait for the Pages deployment	2026-07-17T23:32:45.3685069Z Cloudflare Pages did not publish the expected download function in time.
verify-live-update	Wait for the Pages deployment	2026-07-17T23:32:45.3702770Z ##[error]Process completed with exit code 1.
```

## CI: Make browser setup downloads independent of manifest proxy

- Run: [29620725730](https://github.com/KSPOG/klite/actions/runs/29620725730)
- Conclusion: `failure`
- Event: `push`
- Commit: `cd437247feda164b5b2230ecd72f1bca20098f76`
- Created: `2026-07-17T23:27:16Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-17T23:27:48.1294829Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-17T23:27:48.1324534Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-17T23:27:48.2005055Z > Task :client:jar
build	Build and Test	2026-07-17T23:27:48.2035040Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-17T23:27:48.5005825Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-17T23:27:48.5993390Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-17T23:27:48.5994737Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-17T23:27:48.5995606Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-17T23:27:48.5996469Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-17T23:27:48.5997006Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-17T23:27:48.5997473Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-17T23:27:48.5997918Z > Task :runelite-api:build
build	Build and Test	2026-07-17T23:27:52.3997294Z
build	Build and Test	2026-07-17T23:27:52.4000590Z > Task :client:javadoc
build	Build and Test	2026-07-17T23:27:52.4002512Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-17T23:27:52.4004378Z 	 * @param duration
build	Build and Test	2026-07-17T23:27:52.4005066Z 	   ^
build	Build and Test	2026-07-17T23:27:52.4006429Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-17T23:27:52.4007863Z 	 * @param duration
build	Build and Test	2026-07-17T23:27:52.4008501Z 	   ^
build	Build and Test	2026-07-17T23:27:52.7994382Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:27:52.8010246Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:27:52.8054990Z 	            ^
build	Build and Test	2026-07-17T23:27:52.8085788Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:27:52.8088414Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:27:52.8114702Z 	            ^
build	Build and Test	2026-07-17T23:27:52.8116558Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:27:52.8145405Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:27:52.8146785Z 	            ^
build	Build and Test	2026-07-17T23:27:52.8175737Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:27:52.8190763Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:27:52.8197168Z 	            ^
build	Build and Test	2026-07-17T23:27:52.8201139Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:27:52.8204364Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:27:52.8205774Z 	            ^
build	Build and Test	2026-07-17T23:27:52.8207483Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:27:52.8209902Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:27:52.8211321Z 	            ^
build	Build and Test	2026-07-17T23:27:52.8212927Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:27:52.8215504Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:27:52.8216852Z 	            ^
build	Build and Test	2026-07-17T23:27:52.8218752Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:27:52.8221030Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:27:52.8222455Z 	            ^
build	Build and Test	2026-07-17T23:27:52.8224306Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:27:52.8226721Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:27:52.8228154Z 	            ^
build	Build and Test	2026-07-17T23:27:52.8229667Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-17T23:27:52.8231392Z 	 * @param itemId
build	Build and Test	2026-07-17T23:27:52.8232075Z 	   ^
build	Build and Test	2026-07-17T23:27:52.8233626Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-17T23:27:52.8235330Z 	 * @return
build	Build and Test	2026-07-17T23:27:52.8236122Z 	   ^
build	Build and Test	2026-07-17T23:27:53.2006824Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-17T23:27:53.2007218Z 	               ^
build	Build and Test	2026-07-17T23:27:53.2007914Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-17T23:27:53.2008691Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-17T23:27:53.2009090Z 	             ^
build	Build and Test	2026-07-17T23:27:53.2009844Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-17T23:27:53.2010767Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-17T23:27:53.2011185Z 	            ^
build	Build and Test	2026-07-17T23:27:53.2011958Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-17T23:27:53.2012817Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-17T23:27:53.2013242Z 	            ^
build	Build and Test	2026-07-17T23:27:53.2014138Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-17T23:27:53.2015307Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-17T23:27:53.2015983Z 	            ^
build	Build and Test	2026-07-17T23:27:53.2998209Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-17T23:27:53.3002211Z 	public void select(Color color) {
build	Build and Test	2026-07-17T23:27:53.3035178Z 	            ^
build	Build and Test	2026-07-17T23:27:53.3065752Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-17T23:27:53.3094842Z 	 * @param dimmed
build	Build and Test	2026-07-17T23:27:53.3124771Z 	   ^
build	Build and Test	2026-07-17T23:27:53.4016338Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T23:27:53.4018025Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T23:27:53.4018786Z 	            ^
build	Build and Test	2026-07-17T23:27:53.4019978Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T23:27:53.4021498Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T23:27:53.4022289Z 	            ^
build	Build and Test	2026-07-17T23:27:53.4023466Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-17T23:27:53.4025247Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-17T23:27:53.4026051Z 		                                          ^
build	Build and Test	2026-07-17T23:27:56.1993663Z 100 warnings
build	Build and Test	2026-07-17T23:27:57.9993252Z
build	Build and Test	2026-07-17T23:27:57.9994898Z > Task :client:javadocJar
build	Build and Test	2026-07-17T23:27:57.9995997Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-17T23:28:02.1993832Z > Task :client:shadowJar
build	Build and Test	2026-07-17T23:28:02.2024890Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-17T23:28:02.2025641Z > Task :client:assemble
build	Build and Test	2026-07-17T23:28:02.4027784Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-17T23:28:02.4035204Z > Task :client:testClasses
build	Build and Test	2026-07-17T23:28:02.5015167Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-17T23:28:18.4995469Z > Task :client:checkstyleTest
build	Build and Test	2026-07-17T23:28:20.5996179Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-17T23:28:27.2992639Z /tmp/junit15456624655072236011/junit18154856276901266192/vert.glsl.vert
build	Build and Test	2026-07-17T23:28:27.3064267Z /tmp/junit15456624655072236011/junit18154856276901266192/frag.glsl.frag
build	Build and Test	2026-07-17T23:28:27.4017054Z /tmp/junit15456624655072236011/junit5605984061296167198/vertui.glsl.vert
build	Build and Test	2026-07-17T23:28:27.4105294Z /tmp/junit15456624655072236011/junit5605984061296167198/fragui.glsl.frag
build	Build and Test	2026-07-17T23:28:28.7007867Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-17T23:28:29.1008972Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-17T23:28:29.2026853Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-17T23:28:29.2056227Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-17T23:28:32.2005366Z > Task :client:checkstyleMain
build	Build and Test	2026-07-17T23:28:32.3992716Z > Task :client:pmdMain
build	Build and Test	2026-07-17T23:28:32.4992666Z > Task :client:test
build	Build and Test	2026-07-17T23:28:34.4035926Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-17T23:28:38.3992718Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784330858180.json
build	Build and Test	2026-07-17T23:28:38.4991596Z
build	Build and Test	2026-07-17T23:28:38.4992905Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T23:28:38.4993979Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-17T23:28:38.4994838Z
build	Build and Test	2026-07-17T23:28:38.4995206Z * What went wrong:
build	Build and Test	2026-07-17T23:28:38.4995853Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-17T23:28:38.4996729Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-17T23:28:38.4998102Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-17T23:28:38.4998894Z
build	Build and Test	2026-07-17T23:28:38.4999084Z * Try:
build	Build and Test	2026-07-17T23:28:38.4999617Z > Run with --scan to get full insights.
build	Build and Test	2026-07-17T23:28:38.4999868Z
build	Build and Test	2026-07-17T23:28:38.5000019Z BUILD FAILED in 1m 3s
build	Build and Test	2026-07-17T23:28:38.9399554Z ##[error]Process completed with exit code 1.
```

## CI: Prevent stale release download controls

- Run: [29620587497](https://github.com/KSPOG/klite/actions/runs/29620587497)
- Conclusion: `failure`
- Event: `push`
- Commit: `ebf1711c9ded2721cb170ce8a8e66d8429696dab`
- Created: `2026-07-17T23:24:08Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-17T23:24:39.8828340Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-17T23:24:39.8828921Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-17T23:24:40.0833498Z > Task :client:jar
build	Build and Test	2026-07-17T23:24:40.0865094Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-17T23:24:40.3816848Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-17T23:24:40.7800904Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-17T23:24:40.7803589Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-17T23:24:40.7804442Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-17T23:24:40.7805227Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-17T23:24:40.7805881Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-17T23:24:40.7806473Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-17T23:24:40.7807040Z > Task :runelite-api:build
build	Build and Test	2026-07-17T23:24:46.9826471Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-17T23:24:46.9827859Z
build	Build and Test	2026-07-17T23:24:46.9865126Z 	 * @param duration
build	Build and Test	2026-07-17T23:24:46.9865636Z > Task :client:javadoc
build	Build and Test	2026-07-17T23:24:46.9885188Z 	   ^
build	Build and Test	2026-07-17T23:24:46.9895743Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-17T23:24:46.9915428Z 	 * @param duration
build	Build and Test	2026-07-17T23:24:46.9936589Z 	   ^
build	Build and Test	2026-07-17T23:24:47.3809611Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:24:47.3811931Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:24:47.3813294Z 	            ^
build	Build and Test	2026-07-17T23:24:47.3815312Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:24:47.3817826Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:24:47.3819025Z 	            ^
build	Build and Test	2026-07-17T23:24:47.3820743Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:24:47.3823005Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:24:47.3824166Z 	            ^
build	Build and Test	2026-07-17T23:24:47.3825829Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:24:47.3828021Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:24:47.3829274Z 	            ^
build	Build and Test	2026-07-17T23:24:47.3830936Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:24:47.3833652Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:24:47.3835078Z 	            ^
build	Build and Test	2026-07-17T23:24:47.3836693Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:24:47.3839040Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:24:47.3840269Z 	            ^
build	Build and Test	2026-07-17T23:24:47.3841988Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:24:47.3844114Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:24:47.3848675Z 	            ^
build	Build and Test	2026-07-17T23:24:47.3876078Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:24:47.3905498Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:24:47.3915790Z 	            ^
build	Build and Test	2026-07-17T23:24:47.3932050Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:24:47.3975553Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:24:47.3976859Z 	            ^
build	Build and Test	2026-07-17T23:24:47.4810788Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-17T23:24:47.4865278Z 	 * @param itemId
build	Build and Test	2026-07-17T23:24:47.4881328Z 	   ^
build	Build and Test	2026-07-17T23:24:47.4905905Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-17T23:24:47.4924899Z 	 * @return
build	Build and Test	2026-07-17T23:24:47.4929005Z 	   ^
build	Build and Test	2026-07-17T23:24:47.8858187Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-17T23:24:47.8858759Z 	               ^
build	Build and Test	2026-07-17T23:24:47.8862906Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-17T23:24:47.8864945Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-17T23:24:47.8865628Z 	             ^
build	Build and Test	2026-07-17T23:24:47.8866983Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-17T23:24:47.8868551Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-17T23:24:47.8869282Z 	            ^
build	Build and Test	2026-07-17T23:24:47.8870589Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-17T23:24:47.8872139Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-17T23:24:47.8872910Z 	            ^
build	Build and Test	2026-07-17T23:24:47.8874535Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-17T23:24:47.8876227Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-17T23:24:47.8877098Z 	            ^
build	Build and Test	2026-07-17T23:24:47.8878437Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-17T23:24:47.8879995Z 	public void select(Color color) {
build	Build and Test	2026-07-17T23:24:47.8880659Z 	            ^
build	Build and Test	2026-07-17T23:24:47.9796250Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-17T23:24:47.9816648Z 	 * @param dimmed
build	Build and Test	2026-07-17T23:24:47.9817528Z 	   ^
build	Build and Test	2026-07-17T23:24:47.9818877Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T23:24:47.9820379Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T23:24:47.9821170Z 	            ^
build	Build and Test	2026-07-17T23:24:47.9822686Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T23:24:47.9825006Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T23:24:47.9825805Z 	            ^
build	Build and Test	2026-07-17T23:24:48.0796096Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-17T23:24:48.0798345Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-17T23:24:48.0799479Z 		                                          ^
build	Build and Test	2026-07-17T23:24:52.8794966Z 100 warnings
build	Build and Test	2026-07-17T23:24:55.1825357Z
build	Build and Test	2026-07-17T23:24:55.1826069Z > Task :client:javadocJar
build	Build and Test	2026-07-17T23:24:55.1826655Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-17T23:24:59.7815621Z > Task :client:shadowJar
build	Build and Test	2026-07-17T23:24:59.7822444Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-17T23:24:59.7823146Z > Task :client:assemble
build	Build and Test	2026-07-17T23:25:00.1794769Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-17T23:25:00.1813432Z > Task :client:testClasses
build	Build and Test	2026-07-17T23:25:00.3836718Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-17T23:25:17.1794764Z > Task :client:checkstyleTest
build	Build and Test	2026-07-17T23:25:20.8796395Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-17T23:25:29.7856085Z > Task :client:checkstyleMain
build	Build and Test	2026-07-17T23:25:30.2855343Z > Task :client:pmdMain
build	Build and Test	2026-07-17T23:25:30.3815690Z > Task :client:test
build	Build and Test	2026-07-17T23:25:30.9802883Z
build	Build and Test	2026-07-17T23:25:30.9905588Z /tmp/junit13523374070000421359/junit5477742436411721152/vert.glsl.vert
build	Build and Test	2026-07-17T23:25:30.9995485Z /tmp/junit13523374070000421359/junit5477742436411721152/frag.glsl.frag
build	Build and Test	2026-07-17T23:25:31.1825577Z /tmp/junit13523374070000421359/junit1878996905948527789/vertui.glsl.vert
build	Build and Test	2026-07-17T23:25:31.1915605Z /tmp/junit13523374070000421359/junit1878996905948527789/fragui.glsl.frag
build	Build and Test	2026-07-17T23:25:32.2815282Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-17T23:25:32.6817034Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-17T23:25:32.7796805Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-17T23:25:32.7886633Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-17T23:25:39.1804725Z
build	Build and Test	2026-07-17T23:25:39.1865177Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-17T23:25:43.9795047Z
build	Build and Test	2026-07-17T23:25:43.9795707Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T23:25:43.9796135Z
build	Build and Test	2026-07-17T23:25:43.9796316Z * What went wrong:
build	Build and Test	2026-07-17T23:25:43.9797202Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-17T23:25:43.9798048Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-17T23:25:43.9799377Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-17T23:25:43.9800163Z
build	Build and Test	2026-07-17T23:25:43.9800312Z * Try:
build	Build and Test	2026-07-17T23:25:43.9800669Z > Run with --scan to get full insights.
build	Build and Test	2026-07-17T23:25:43.9801011Z
build	Build and Test	2026-07-17T23:25:43.9801180Z BUILD FAILED in 1m 24s
build	Build and Test	2026-07-17T23:25:43.9802052Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784330667682.json
build	Build and Test	2026-07-17T23:25:43.9803293Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-17T23:25:44.4627264Z ##[error]Process completed with exit code 1.
```

## CI: Point website downloads at latest release redirect

- Run: [29620577718](https://github.com/KSPOG/klite/actions/runs/29620577718)
- Conclusion: `failure`
- Event: `push`
- Commit: `a1bbabf41ee34b75c933b60d345cc21c917105c9`
- Created: `2026-07-17T23:23:56Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-17T23:24:36.3167146Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-17T23:24:36.3167580Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-17T23:24:36.4216167Z > Task :client:jar
build	Build and Test	2026-07-17T23:24:36.4242132Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-17T23:24:36.7162786Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-17T23:24:36.7172205Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-17T23:24:36.7202121Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-17T23:24:36.7232035Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-17T23:24:36.7232717Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-17T23:24:36.7233393Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-17T23:24:36.7234004Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-17T23:24:36.7234614Z > Task :runelite-api:build
build	Build and Test	2026-07-17T23:24:43.8156459Z
build	Build and Test	2026-07-17T23:24:43.8157334Z > Task :client:javadoc
build	Build and Test	2026-07-17T23:24:43.8158998Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-17T23:24:43.8193321Z 	 * @param duration
build	Build and Test	2026-07-17T23:24:43.8202600Z 	   ^
build	Build and Test	2026-07-17T23:24:43.8230854Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-17T23:24:43.8233104Z 	 * @param duration
build	Build and Test	2026-07-17T23:24:43.8233894Z 	   ^
build	Build and Test	2026-07-17T23:24:44.2173853Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:24:44.2222769Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:24:44.2252129Z 	            ^
build	Build and Test	2026-07-17T23:24:44.2283644Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:24:44.2302749Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:24:44.2332049Z 	            ^
build	Build and Test	2026-07-17T23:24:44.2373550Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:24:44.2392652Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:24:44.2422101Z 	            ^
build	Build and Test	2026-07-17T23:24:44.2425785Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:24:44.2428287Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:24:44.2429644Z 	            ^
build	Build and Test	2026-07-17T23:24:44.2431761Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:24:44.2464809Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:24:44.2466475Z 	            ^
build	Build and Test	2026-07-17T23:24:44.2468291Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:24:44.2470958Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:24:44.2472527Z 	            ^
build	Build and Test	2026-07-17T23:24:44.2474048Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:24:44.2476380Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:24:44.2477711Z 	            ^
build	Build and Test	2026-07-17T23:24:44.2479541Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:24:44.2482561Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:24:44.2483882Z 	            ^
build	Build and Test	2026-07-17T23:24:44.2485639Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:24:44.2488203Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:24:44.2489478Z 	            ^
build	Build and Test	2026-07-17T23:24:44.2491000Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-17T23:24:44.2492963Z 	 * @param itemId
build	Build and Test	2026-07-17T23:24:44.2493425Z 	   ^
build	Build and Test	2026-07-17T23:24:44.2494945Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-17T23:24:44.2496649Z 	 * @return
build	Build and Test	2026-07-17T23:24:44.2497055Z 	   ^
build	Build and Test	2026-07-17T23:24:44.7196997Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-17T23:24:44.7197730Z 	               ^
build	Build and Test	2026-07-17T23:24:44.7199271Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-17T23:24:44.7201004Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-17T23:24:44.7202189Z 	             ^
build	Build and Test	2026-07-17T23:24:44.7208012Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-17T23:24:44.7210107Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-17T23:24:44.7211022Z 	            ^
build	Build and Test	2026-07-17T23:24:44.7213063Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-17T23:24:44.7215121Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-17T23:24:44.7215979Z 	            ^
build	Build and Test	2026-07-17T23:24:44.7217736Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-17T23:24:44.7219760Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-17T23:24:44.7220647Z 	            ^
build	Build and Test	2026-07-17T23:24:44.8152599Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-17T23:24:44.8154777Z 	public void select(Color color) {
build	Build and Test	2026-07-17T23:24:44.8155688Z 	            ^
build	Build and Test	2026-07-17T23:24:44.8157351Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-17T23:24:44.8159908Z 	 * @param dimmed
build	Build and Test	2026-07-17T23:24:44.8166190Z 	   ^
build	Build and Test	2026-07-17T23:24:44.9152420Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T23:24:44.9154896Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T23:24:44.9155927Z 	            ^
build	Build and Test	2026-07-17T23:24:44.9157746Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T23:24:44.9159994Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T23:24:44.9160963Z 	            ^
build	Build and Test	2026-07-17T23:24:45.0152051Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-17T23:24:45.0168699Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-17T23:24:45.0169950Z 		                                          ^
build	Build and Test	2026-07-17T23:24:49.2150123Z 100 warnings
build	Build and Test	2026-07-17T23:24:51.6149981Z
build	Build and Test	2026-07-17T23:24:51.6150778Z > Task :client:javadocJar
build	Build and Test	2026-07-17T23:24:51.6151783Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-17T23:24:56.2160536Z > Task :client:shadowJar
build	Build and Test	2026-07-17T23:24:56.2162862Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-17T23:24:56.2163721Z > Task :client:assemble
build	Build and Test	2026-07-17T23:24:56.6201712Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-17T23:24:56.6212073Z > Task :client:testClasses
build	Build and Test	2026-07-17T23:24:56.8172654Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-17T23:25:16.8162655Z > Task :client:checkstyleTest
build	Build and Test	2026-07-17T23:25:17.1175315Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-17T23:25:26.1152456Z > Task :client:checkstyleMain
build	Build and Test	2026-07-17T23:25:26.6212587Z > Task :client:pmdMain
build	Build and Test	2026-07-17T23:25:26.8182408Z > Task :client:test
build	Build and Test	2026-07-17T23:25:27.1169530Z
build	Build and Test	2026-07-17T23:25:27.1217925Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-17T23:25:27.4230449Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-17T23:25:27.6164329Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-17T23:25:27.6223768Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-17T23:25:28.3162654Z /tmp/junit638107920554419852/junit15382433736263400374/vert.glsl.vert
build	Build and Test	2026-07-17T23:25:28.3252606Z /tmp/junit638107920554419852/junit15382433736263400374/frag.glsl.frag
build	Build and Test	2026-07-17T23:25:28.5222548Z /tmp/junit638107920554419852/junit2881570392942465291/vertui.glsl.vert
build	Build and Test	2026-07-17T23:25:28.5252411Z /tmp/junit638107920554419852/junit2881570392942465291/fragui.glsl.frag
build	Build and Test	2026-07-17T23:25:34.4149837Z
build	Build and Test	2026-07-17T23:25:34.4202272Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-17T23:25:40.6149642Z
build	Build and Test	2026-07-17T23:25:40.6150776Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784330663923.json
build	Build and Test	2026-07-17T23:25:40.6152187Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T23:25:40.6152630Z
build	Build and Test	2026-07-17T23:25:40.6152749Z * What went wrong:
build	Build and Test	2026-07-17T23:25:40.6153051Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-17T23:25:40.6153604Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-17T23:25:40.6154585Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-17T23:25:40.6155248Z
build	Build and Test	2026-07-17T23:25:40.6155351Z * Try:
build	Build and Test	2026-07-17T23:25:40.6155610Z > Run with --scan to get full insights.
build	Build and Test	2026-07-17T23:25:40.6155839Z
build	Build and Test	2026-07-17T23:25:40.6155955Z BUILD FAILED in 1m 24s
build	Build and Test	2026-07-17T23:25:40.6156490Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-17T23:25:41.0855203Z ##[error]Process completed with exit code 1.
```

## CI: Redirect website downloads to latest verified installer

- Run: [29620547471](https://github.com/KSPOG/klite/actions/runs/29620547471)
- Conclusion: `failure`
- Event: `push`
- Commit: `bf0b94d7646542d0f01f100b7b428c662575088f`
- Created: `2026-07-17T23:23:16Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-17T23:23:50.1527347Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-17T23:23:50.1541268Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-17T23:23:50.5386943Z > Task :client:jar
build	Build and Test	2026-07-17T23:23:50.5391347Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-17T23:23:50.8379589Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-17T23:23:50.8404683Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-17T23:23:50.8420117Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-17T23:23:50.8421102Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-17T23:23:50.8422014Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-17T23:23:50.9387830Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-17T23:23:50.9417482Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-17T23:23:50.9447370Z > Task :runelite-api:build
build	Build and Test	2026-07-17T23:23:57.2405948Z
build	Build and Test	2026-07-17T23:23:57.2407167Z > Task :client:javadoc
build	Build and Test	2026-07-17T23:23:57.2428425Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-17T23:23:57.2430117Z 	 * @param duration
build	Build and Test	2026-07-17T23:23:57.2430580Z 	   ^
build	Build and Test	2026-07-17T23:23:57.2431974Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-17T23:23:57.2433546Z 	 * @param duration
build	Build and Test	2026-07-17T23:23:57.2434002Z 	   ^
build	Build and Test	2026-07-17T23:23:57.7388981Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:23:57.7412507Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:23:57.7437487Z 	            ^
build	Build and Test	2026-07-17T23:23:57.7448633Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:23:57.7467884Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:23:57.7497642Z 	            ^
build	Build and Test	2026-07-17T23:23:57.7512308Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:23:57.7514287Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:23:57.7515394Z 	            ^
build	Build and Test	2026-07-17T23:23:57.7517149Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:23:57.7519381Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:23:57.7520531Z 	            ^
build	Build and Test	2026-07-17T23:23:57.7522123Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:23:57.7524753Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:23:57.7525856Z 	            ^
build	Build and Test	2026-07-17T23:23:57.7527071Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:23:57.7528399Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:23:57.7529662Z 	            ^
build	Build and Test	2026-07-17T23:23:57.7530477Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:23:57.7531717Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:23:57.7532390Z 	            ^
build	Build and Test	2026-07-17T23:23:57.7533290Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:23:57.8421878Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:23:57.8424252Z 	            ^
build	Build and Test	2026-07-17T23:23:57.8452033Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:23:57.8454741Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:23:57.8456279Z 	            ^
build	Build and Test	2026-07-17T23:23:57.8458256Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-17T23:23:57.8460110Z 	 * @param itemId
build	Build and Test	2026-07-17T23:23:57.8460585Z 	   ^
build	Build and Test	2026-07-17T23:23:57.8461934Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-17T23:23:57.8463467Z 	 * @return
build	Build and Test	2026-07-17T23:23:57.8463889Z 	   ^
build	Build and Test	2026-07-17T23:23:58.3383767Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-17T23:23:58.3384567Z 	               ^
build	Build and Test	2026-07-17T23:23:58.3386123Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-17T23:23:58.3388090Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-17T23:23:58.3388857Z 	             ^
build	Build and Test	2026-07-17T23:23:58.3390450Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-17T23:23:58.3392305Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-17T23:23:58.3393176Z 	            ^
build	Build and Test	2026-07-17T23:23:58.3394789Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-17T23:23:58.3402774Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-17T23:23:58.3403454Z 	            ^
build	Build and Test	2026-07-17T23:23:58.3404850Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-17T23:23:58.3406516Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-17T23:23:58.3407470Z 	            ^
build	Build and Test	2026-07-17T23:23:58.4391198Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-17T23:23:58.4418015Z 	public void select(Color color) {
build	Build and Test	2026-07-17T23:23:58.4418943Z 	            ^
build	Build and Test	2026-07-17T23:23:58.4420629Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-17T23:23:58.4422921Z 	 * @param dimmed
build	Build and Test	2026-07-17T23:23:58.4423631Z 	   ^
build	Build and Test	2026-07-17T23:23:58.5373865Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T23:23:58.5375979Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T23:23:58.5377747Z 	            ^
build	Build and Test	2026-07-17T23:23:58.5379453Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T23:23:58.5381426Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T23:23:58.5382292Z 	            ^
build	Build and Test	2026-07-17T23:23:58.6373426Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-17T23:23:58.6393769Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-17T23:23:58.6394871Z 		                                          ^
build	Build and Test	2026-07-17T23:24:03.2372209Z 100 warnings
build	Build and Test	2026-07-17T23:24:05.7372676Z
build	Build and Test	2026-07-17T23:24:05.7373545Z > Task :client:javadocJar
build	Build and Test	2026-07-17T23:24:05.7374218Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-17T23:24:10.4381246Z > Task :client:shadowJar
build	Build and Test	2026-07-17T23:24:10.4382096Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-17T23:24:10.4382723Z > Task :client:assemble
build	Build and Test	2026-07-17T23:24:10.8376052Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-17T23:24:10.8453994Z > Task :client:testClasses
build	Build and Test	2026-07-17T23:24:11.0391691Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-17T23:24:34.8387744Z > Task :client:checkstyleTest
build	Build and Test	2026-07-17T23:24:36.3398774Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-17T23:24:40.4378786Z > Task :client:checkstyleMain
build	Build and Test	2026-07-17T23:24:40.8447638Z > Task :client:pmdMain
build	Build and Test	2026-07-17T23:24:41.0417667Z > Task :client:test
build	Build and Test	2026-07-17T23:24:43.4427168Z
build	Build and Test	2026-07-17T23:24:43.4457759Z /tmp/junit2554356395640122403/junit7752461396152957075/vert.glsl.vert
build	Build and Test	2026-07-17T23:24:43.4487682Z /tmp/junit2554356395640122403/junit7752461396152957075/frag.glsl.frag
build	Build and Test	2026-07-17T23:24:43.5395788Z /tmp/junit2554356395640122403/junit6915366472599580560/vertui.glsl.vert
build	Build and Test	2026-07-17T23:24:43.5427845Z /tmp/junit2554356395640122403/junit6915366472599580560/fragui.glsl.frag
build	Build and Test	2026-07-17T23:24:46.8399221Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-17T23:24:47.1409045Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-17T23:24:47.4379167Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-17T23:24:47.4409010Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-17T23:24:53.4443547Z
build	Build and Test	2026-07-17T23:24:53.4485190Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-17T23:24:58.8372698Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784330617177.json
build	Build and Test	2026-07-17T23:24:58.9371572Z
build	Build and Test	2026-07-17T23:24:58.9372382Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-17T23:24:58.9373545Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T23:24:58.9374172Z
build	Build and Test	2026-07-17T23:24:58.9374596Z * What went wrong:
build	Build and Test	2026-07-17T23:24:58.9375332Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-17T23:24:58.9375999Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-17T23:24:58.9377288Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-17T23:24:58.9378380Z
build	Build and Test	2026-07-17T23:24:58.9378515Z * Try:
build	Build and Test	2026-07-17T23:24:58.9378808Z > Run with --scan to get full insights.
build	Build and Test	2026-07-17T23:24:58.9379070Z
build	Build and Test	2026-07-17T23:24:58.9379198Z BUILD FAILED in 1m 28s
build	Build and Test	2026-07-17T23:24:59.4049605Z ##[error]Process completed with exit code 1.
```

