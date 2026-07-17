# Recent GitHub Actions failures

Generated: 2026-07-17T23:55:35.701059+00:00
Repository: `KSPOG/klite`
Failed runs inspected: **15**

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

## Verify live KLite Windows update: Redirect website downloads to latest verified installer

- Run: [29620547420](https://github.com/KSPOG/klite/actions/runs/29620547420)
- Conclusion: `cancelled`
- Event: `push`
- Commit: `bf0b94d7646542d0f01f100b7b428c662575088f`
- Created: `2026-07-17T23:23:15Z`

### Failed jobs and steps

- **verify-live-update** — `cancelled`
  - Step 3: **Wait for the Pages deployment** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## CI: Open Windows client downloads for release

- Run: [29620184674](https://github.com/KSPOG/klite/actions/runs/29620184674)
- Conclusion: `failure`
- Event: `push`
- Commit: `cd88efc642c1833360e8988e4fd3672c1f2a503f`
- Created: `2026-07-17T23:15:11Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-17T23:15:47.8962042Z 	   ^
build	Build and Test	2026-07-17T23:15:47.8971091Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-17T23:15:47.8974956Z 	 * @param duration
build	Build and Test	2026-07-17T23:15:47.8978905Z 	   ^
build	Build and Test	2026-07-17T23:15:48.2962678Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:15:48.3052624Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:15:48.3081958Z 	            ^
build	Build and Test	2026-07-17T23:15:48.3106690Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:15:48.3122385Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:15:48.3130314Z 	            ^
build	Build and Test	2026-07-17T23:15:48.3182682Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:15:48.3184556Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:15:48.3186998Z 	            ^
build	Build and Test	2026-07-17T23:15:48.3211766Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:15:48.3220742Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:15:48.3241976Z 	            ^
build	Build and Test	2026-07-17T23:15:48.3272750Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:15:48.3275001Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:15:48.3301923Z 	            ^
build	Build and Test	2026-07-17T23:15:48.3303064Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:15:48.3304924Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:15:48.3305668Z 	            ^
build	Build and Test	2026-07-17T23:15:48.3306630Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:15:48.3308073Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:15:48.3308877Z 	            ^
build	Build and Test	2026-07-17T23:15:48.3309977Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:15:48.3311738Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:15:48.3312556Z 	            ^
build	Build and Test	2026-07-17T23:15:48.3313643Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:15:48.3315194Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:15:48.3315961Z 	            ^
build	Build and Test	2026-07-17T23:15:48.3316898Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-17T23:15:48.3317962Z 	 * @param itemId
build	Build and Test	2026-07-17T23:15:48.3318294Z 	   ^
build	Build and Test	2026-07-17T23:15:48.3319258Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-17T23:15:48.3320352Z 	 * @return
build	Build and Test	2026-07-17T23:15:48.6924622Z 	            ^
build	Build and Test	2026-07-17T23:15:48.6925832Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-17T23:15:48.6927681Z 	 * @param dimmed
build	Build and Test	2026-07-17T23:15:48.6928478Z 	   ^
build	Build and Test	2026-07-17T23:15:48.6929686Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T23:15:48.6931148Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T23:15:48.6932065Z 	            ^
build	Build and Test	2026-07-17T23:15:48.6933296Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T23:15:48.6934729Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T23:15:48.6935393Z 	            ^
build	Build and Test	2026-07-17T23:15:48.7937208Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-17T23:15:48.7947021Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-17T23:15:48.7947864Z 		                                          ^
build	Build and Test	2026-07-17T23:15:52.3902787Z 100 warnings
build	Build and Test	2026-07-17T23:16:20.4942660Z /tmp/junit11776143677196071331/junit11897031664808477246/vertui.glsl.vert
build	Build and Test	2026-07-17T23:16:20.4982300Z /tmp/junit11776143677196071331/junit11897031664808477246/fragui.glsl.frag
build	Build and Test	2026-07-17T23:16:23.7923376Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-17T23:16:23.9903146Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-17T23:16:24.1903567Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-17T23:16:24.1932928Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-17T23:16:28.3900026Z > Task :client:checkstyleMain
build	Build and Test	2026-07-17T23:16:28.5899732Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-17T23:16:28.7899591Z > Task :client:test
build	Build and Test	2026-07-17T23:16:31.3905721Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784330134350.json
build	Build and Test	2026-07-17T23:16:31.3908172Z
build	Build and Test	2026-07-17T23:16:31.3908682Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T23:16:31.3909287Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-17T23:16:31.3910181Z
build	Build and Test	2026-07-17T23:16:31.3910507Z * What went wrong:
build	Build and Test	2026-07-17T23:16:31.3911109Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-17T23:16:31.3912182Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-17T23:16:31.3913691Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-17T23:16:31.3914580Z
build	Build and Test	2026-07-17T23:16:31.3914885Z * Try:
build	Build and Test	2026-07-17T23:16:31.3915416Z > Run with --scan to get full insights.
build	Build and Test	2026-07-17T23:16:31.3915898Z
build	Build and Test	2026-07-17T23:16:31.3916214Z BUILD FAILED in 1m
build	Build and Test	2026-07-17T23:16:31.8924840Z ##[error]Process completed with exit code 1.
```

