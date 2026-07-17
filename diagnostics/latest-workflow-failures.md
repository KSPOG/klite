# Recent GitHub Actions failures

Generated: 2026-07-17T23:04:44.224131+00:00
Repository: `KSPOG/klite`
Failed runs inspected: **15**

## CI: Add workflow failure diagnostics

- Run: [29619539243](https://github.com/KSPOG/klite/actions/runs/29619539243)
- Conclusion: `failure`
- Event: `push`
- Commit: `1af07fc5932a166cf0b4561d09928f84000c2463`
- Created: `2026-07-17T23:01:17Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-17T23:02:00.4056331Z 	   ^
build	Build and Test	2026-07-17T23:02:00.4058350Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-17T23:02:00.4064965Z 	 * @param duration
build	Build and Test	2026-07-17T23:02:00.4065797Z 	   ^
build	Build and Test	2026-07-17T23:02:00.8980253Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:02:00.8981918Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:02:00.8982770Z 	            ^
build	Build and Test	2026-07-17T23:02:00.8983929Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:02:00.8985373Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:02:00.8986112Z 	            ^
build	Build and Test	2026-07-17T23:02:00.8987920Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:02:00.8990640Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:02:00.8991701Z 	            ^
build	Build and Test	2026-07-17T23:02:00.9007947Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:02:00.9010278Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:02:00.9012319Z 	            ^
build	Build and Test	2026-07-17T23:02:00.9013978Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:02:00.9018577Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:02:00.9019277Z 	            ^
build	Build and Test	2026-07-17T23:02:00.9020167Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:02:00.9021454Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:02:00.9022350Z 	            ^
build	Build and Test	2026-07-17T23:02:00.9023136Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T23:02:00.9024309Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:02:00.9024957Z 	            ^
build	Build and Test	2026-07-17T23:02:00.9025831Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T23:02:00.9027728Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:02:00.9028779Z 	            ^
build	Build and Test	2026-07-17T23:02:00.9030135Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T23:02:00.9031419Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T23:02:00.9032054Z 	            ^
build	Build and Test	2026-07-17T23:02:00.9032829Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-17T23:02:00.9033659Z 	 * @param itemId
build	Build and Test	2026-07-17T23:02:00.9033911Z 	   ^
build	Build and Test	2026-07-17T23:02:00.9034659Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-17T23:02:00.9035483Z 	 * @return
build	Build and Test	2026-07-17T23:02:01.4992907Z 	            ^
build	Build and Test	2026-07-17T23:02:01.5981421Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-17T23:02:01.5989346Z 	 * @param dimmed
build	Build and Test	2026-07-17T23:02:01.5996869Z 	   ^
build	Build and Test	2026-07-17T23:02:01.5998663Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T23:02:01.6001119Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T23:02:01.6002440Z 	            ^
build	Build and Test	2026-07-17T23:02:01.6004246Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T23:02:01.6006336Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T23:02:01.6008154Z 	            ^
build	Build and Test	2026-07-17T23:02:01.6980828Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-17T23:02:01.6983808Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-17T23:02:01.6984904Z 		                                          ^
build	Build and Test	2026-07-17T23:02:06.1979626Z 100 warnings
build	Build and Test	2026-07-17T23:02:17.2067116Z 	            ^
build	Build and Test	2026-07-17T23:02:17.2086778Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/menus/TestMenuEntry.java:60: warning: Not generating setWorldViewId(): A method with that name already exists
build	Build and Test	2026-07-17T23:02:17.2097247Z 	private int worldViewId;
build	Build and Test	2026-07-17T23:02:17.2127062Z 	            ^
build	Build and Test	2026-07-17T23:02:22.6979681Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T23:02:22.6997568Z 		GroundPathfinder pathfinder = new GroundPathfinder(new StaticCollisionMap());
build	Build and Test	2026-07-17T23:02:22.7047805Z 		^
build	Build and Test	2026-07-17T23:02:22.7073946Z   symbol:   class GroundPathfinder
build	Build and Test	2026-07-17T23:02:22.7087293Z   location: class StaticCollisionMapTest
build	Build and Test	2026-07-17T23:02:22.7112091Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T23:02:22.7187400Z 		GroundPathfinder pathfinder = new GroundPathfinder(new StaticCollisionMap());
build	Build and Test	2026-07-17T23:02:22.7217037Z 		                                  ^
build	Build and Test	2026-07-17T23:02:22.7247054Z   symbol:   class GroundPathfinder
build	Build and Test	2026-07-17T23:02:22.7307110Z   location: class StaticCollisionMapTest
build	Build and Test	2026-07-17T23:02:23.1007705Z Note: Some input files use or override a deprecated API.
build	Build and Test	2026-07-17T23:02:23.1067364Z Note: Recompile with -Xlint:deprecation for details.
build	Build and Test	2026-07-17T23:02:23.1097217Z Note: Some input files use unchecked or unsafe operations.
build	Build and Test	2026-07-17T23:02:23.1157245Z Note: Recompile with -Xlint:unchecked for details.
build	Build and Test	2026-07-17T23:02:23.1187006Z 2 errors
build	Build and Test	2026-07-17T23:02:23.1247008Z 2 warnings
build	Build and Test	2026-07-17T23:02:23.2006973Z
build	Build and Test	2026-07-17T23:02:23.2037349Z > Task :client:compileTestJava FAILED
build	Build and Test	2026-07-17T23:02:33.1979092Z > Task :client:checkstyleMain
build	Build and Test	2026-07-17T23:02:33.2979567Z
build	Build and Test	2026-07-17T23:02:33.2980663Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784329300300.json
build	Build and Test	2026-07-17T23:02:33.2997173Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T23:02:33.2997827Z 65 actionable tasks: 27 executed, 38 from cache
build	Build and Test	2026-07-17T23:02:33.3031822Z
build	Build and Test	2026-07-17T23:02:33.3032089Z * What went wrong:
build	Build and Test	2026-07-17T23:02:33.3032674Z Execution failed for task ':client:compileTestJava'.
build	Build and Test	2026-07-17T23:02:33.3033494Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-17T23:02:33.3034031Z
build	Build and Test	2026-07-17T23:02:33.3034194Z * Try:
build	Build and Test	2026-07-17T23:02:33.3034657Z > Run with --info option to get more log output.
build	Build and Test	2026-07-17T23:02:33.3035601Z > Run with --scan to get full insights.
build	Build and Test	2026-07-17T23:02:33.3035969Z
build	Build and Test	2026-07-17T23:02:33.3036157Z BUILD FAILED in 1m 1s
build	Build and Test	2026-07-17T23:02:33.7787583Z ##[error]Process completed with exit code 1.
```

## CI: Clean obsolete workflow runs after SDK publication

- Run: [29619210710](https://github.com/KSPOG/klite/actions/runs/29619210710)
- Conclusion: `failure`
- Event: `push`
- Commit: `ffc8d1107ae54e8265f057b0d1275fb178c1b417`
- Created: `2026-07-17T22:53:59Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-17T22:54:43.5695241Z 	   ^
build	Build and Test	2026-07-17T22:54:43.5725973Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-17T22:54:43.5752995Z 	 * @param duration
build	Build and Test	2026-07-17T22:54:43.5765676Z 	   ^
build	Build and Test	2026-07-17T22:54:44.0618766Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:54:44.0620999Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:44.0622504Z 	            ^
build	Build and Test	2026-07-17T22:54:44.0624229Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:54:44.0626944Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:44.0628172Z 	            ^
build	Build and Test	2026-07-17T22:54:44.0629805Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:54:44.0632052Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:44.0633241Z 	            ^
build	Build and Test	2026-07-17T22:54:44.0634879Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:54:44.0637207Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:44.0638525Z 	            ^
build	Build and Test	2026-07-17T22:54:44.0640200Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:54:44.0646264Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:44.0651336Z 	            ^
build	Build and Test	2026-07-17T22:54:44.0653020Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:54:44.0655565Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:44.0657623Z 	            ^
build	Build and Test	2026-07-17T22:54:44.0659084Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:54:44.0661161Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:44.0662387Z 	            ^
build	Build and Test	2026-07-17T22:54:44.0663957Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:54:44.0666585Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:44.0667891Z 	            ^
build	Build and Test	2026-07-17T22:54:44.0669903Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:54:44.0672568Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:44.0673729Z 	            ^
build	Build and Test	2026-07-17T22:54:44.0675294Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-17T22:54:44.0676818Z 	 * @param itemId
build	Build and Test	2026-07-17T22:54:44.0677410Z 	   ^
build	Build and Test	2026-07-17T22:54:44.0678819Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-17T22:54:44.0680293Z 	 * @return
build	Build and Test	2026-07-17T22:54:44.5668864Z 	            ^
build	Build and Test	2026-07-17T22:54:44.6618858Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-17T22:54:44.6642094Z 	 * @param dimmed
build	Build and Test	2026-07-17T22:54:44.6642904Z 	   ^
build	Build and Test	2026-07-17T22:54:44.6644548Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T22:54:44.6646811Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T22:54:44.6647604Z 	            ^
build	Build and Test	2026-07-17T22:54:44.6649034Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T22:54:44.6650681Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T22:54:44.6651450Z 	            ^
build	Build and Test	2026-07-17T22:54:44.7626715Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-17T22:54:44.7635194Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-17T22:54:44.7636207Z 		                                          ^
build	Build and Test	2026-07-17T22:54:49.3617529Z 100 warnings
build	Build and Test	2026-07-17T22:55:00.1685474Z > Task :client:compileTestJava
build	Build and Test	2026-07-17T22:55:00.1686874Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/menus/TestMenuEntry.java:60: warning: Not generating setWorldViewId(): A method with that name already exists
build	Build and Test	2026-07-17T22:55:00.1725173Z 	private int worldViewId;
build	Build and Test	2026-07-17T22:55:00.1755001Z 	            ^
build	Build and Test	2026-07-17T22:55:06.2620854Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:55:06.2665741Z 		GroundPathfinder pathfinder = new GroundPathfinder(new StaticCollisionMap());
build	Build and Test	2026-07-17T22:55:06.2695803Z 		^
build	Build and Test	2026-07-17T22:55:06.2735253Z   symbol:   class GroundPathfinder
build	Build and Test	2026-07-17T22:55:06.2773253Z   location: class StaticCollisionMapTest
build	Build and Test	2026-07-17T22:55:06.2797750Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:55:06.2825205Z 		GroundPathfinder pathfinder = new GroundPathfinder(new StaticCollisionMap());
build	Build and Test	2026-07-17T22:55:06.2854963Z 		                                  ^
build	Build and Test	2026-07-17T22:55:06.2879202Z   symbol:   class GroundPathfinder
build	Build and Test	2026-07-17T22:55:06.2879825Z   location: class StaticCollisionMapTest
build	Build and Test	2026-07-17T22:55:06.9630614Z Note: Some input files use or override a deprecated API.
build	Build and Test	2026-07-17T22:55:06.9655430Z Note: Recompile with -Xlint:deprecation for details.
build	Build and Test	2026-07-17T22:55:06.9656290Z Note: Some input files use unchecked or unsafe operations.
build	Build and Test	2026-07-17T22:55:06.9656994Z Note: Recompile with -Xlint:unchecked for details.
build	Build and Test	2026-07-17T22:55:06.9657546Z 2 errors
build	Build and Test	2026-07-17T22:55:06.9657909Z 2 warnings
build	Build and Test	2026-07-17T22:55:07.0616883Z
build	Build and Test	2026-07-17T22:55:07.0695453Z > Task :client:compileTestJava FAILED
build	Build and Test	2026-07-17T22:55:15.6617127Z > Task :client:checkstyleMain
build	Build and Test	2026-07-17T22:55:15.6645676Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784328862471.json
build	Build and Test	2026-07-17T22:55:15.7616446Z
build	Build and Test	2026-07-17T22:55:15.7617679Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T22:55:15.7618344Z 65 actionable tasks: 27 executed, 38 from cache
build	Build and Test	2026-07-17T22:55:15.7619657Z
build	Build and Test	2026-07-17T22:55:15.7620129Z * What went wrong:
build	Build and Test	2026-07-17T22:55:15.7620816Z Execution failed for task ':client:compileTestJava'.
build	Build and Test	2026-07-17T22:55:15.7621722Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-17T22:55:15.7622285Z
build	Build and Test	2026-07-17T22:55:15.7622964Z * Try:
build	Build and Test	2026-07-17T22:55:15.7623430Z > Run with --info option to get more log output.
build	Build and Test	2026-07-17T22:55:15.7624025Z > Run with --scan to get full insights.
build	Build and Test	2026-07-17T22:55:15.7624550Z
build	Build and Test	2026-07-17T22:55:15.7624740Z BUILD FAILED in 1m
build	Build and Test	2026-07-17T22:55:16.2098372Z ##[error]Process completed with exit code 1.
```

## Publish KLite Plugin SDK: Fix plugin SDK ZIP verification and release validation

- Run: [29619197729](https://github.com/KSPOG/klite/actions/runs/29619197729)
- Conclusion: `failure`
- Event: `push`
- Commit: `9c88565e1ff4f39845c0a2b4f63f496dc347b62d`
- Created: `2026-07-17T22:53:38Z`

### Failed jobs and steps

- **build-sdk** — `failure`
  - Step 9: **Compile generated standalone starter** — `failure`

### Relevant log context

```text
build-sdk	Compile generated standalone starter	2026-07-17T22:56:32.0552726Z ^[[36;1m    corrupt = archive.testzip()^[[0m
build-sdk	Compile generated standalone starter	2026-07-17T22:56:32.0553154Z ^[[36;1mif corrupt:^[[0m
build-sdk	Compile generated standalone starter	2026-07-17T22:56:32.0554082Z ^[[36;1m    raise SystemExit(f"Generated starter plugin contains a corrupt entry: {corrupt}")^[[0m
build-sdk	Compile generated standalone starter	2026-07-17T22:56:32.0554860Z ^[[36;1mif "runelite_plugin.json" not in entries:^[[0m
build-sdk	Compile generated standalone starter	2026-07-17T22:56:32.0555593Z ^[[36;1m    raise SystemExit("Generated starter plugin is missing runelite_plugin.json")^[[0m
build-sdk	Compile generated standalone starter	2026-07-17T22:56:32.0556272Z ^[[36;1m^[[0m
build-sdk	Compile generated standalone starter	2026-07-17T22:56:32.0556573Z ^[[36;1mbundled_runtime = sorted(^[[0m
build-sdk	Compile generated standalone starter	2026-07-17T22:56:32.0556989Z ^[[36;1m    entry for entry in entries^[[0m
build-sdk	Compile generated standalone starter	2026-07-17T22:56:32.0557445Z ^[[36;1m    if entry.endswith(".class") and (^[[0m
build-sdk	Compile generated standalone starter	2026-07-17T22:56:32.0557951Z ^[[36;1m        entry.startswith("net/runelite/")^[[0m
build-sdk	Compile generated standalone starter	2026-07-17T22:56:32.0558498Z ^[[36;1m        or entry.startswith("com/google/inject/")^[[0m
build-sdk	Compile generated standalone starter	2026-07-17T22:56:32.1302208Z + ./gradlew clean jar --no-daemon --stacktrace
build-sdk	Compile generated standalone starter	2026-07-17T22:56:32.8304227Z To honour the JVM settings for this build a single-use Daemon process will be forked. For more on this, please refer to https://docs.gradle.org/8.8/userguide/gradle_daemon.html#sec:disabling_the_daemon in the Gradle documentation.
build-sdk	Compile generated standalone starter	2026-07-17T22:56:33.9324450Z Daemon will be stopped at the end of the build
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2288764Z
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2289775Z FAILURE: Build failed with an exception.
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2290157Z
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2290278Z * Where:
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2292903Z Build file '/home/runner/work/klite/klite/build/sdk-starter-verification/build.gradle.kts' line: 23
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2293571Z
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2293874Z * What went wrong:
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2296262Z Build was configured to prefer settings repositories over project repositories but repository 'MavenRepo' was added by build file 'build.gradle.kts'
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2298226Z > Run with --info or --debug option to get more log output.
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2299527Z > Run with --scan to get full insights.
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2301348Z > Get more help at https://help.gradle.org.
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2320128Z
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2326909Z * Exception is:
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2328438Z org.gradle.api.InvalidUserCodeException: Build was configured to prefer settings repositories over project repositories but repository 'MavenRepo' was added by build file 'build.gradle.kts'
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2331027Z 	at org.gradle.internal.management.DefaultDependencyResolutionManagement.repoMutationDisallowedOnProject(DefaultDependencyResolutionManagement.java:199)
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2332950Z 	at org.gradle.internal.ImmutableActionSet$SetWithFewActions.execute(ImmutableActionSet.java:285)
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2334580Z 	at org.gradle.api.internal.DefaultDomainObjectCollection.doAdd(DefaultDomainObjectCollection.java:262)
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2335758Z 	at org.gradle.api.internal.DefaultNamedDomainObjectCollection.doAdd(DefaultNamedDomainObjectCollection.java:125)
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2336742Z 	at org.gradle.api.internal.DefaultDomainObjectCollection.add(DefaultDomainObjectCollection.java:251)
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2337775Z 	at org.gradle.api.internal.artifacts.DefaultArtifactRepositoryContainer.access$101(DefaultArtifactRepositoryContainer.java:35)
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2571931Z 	at org.gradle.tooling.internal.provider.BuildSessionLifecycleBuildActionExecuter.execute(BuildSessionLifecycleBuildActionExecuter.java:62)
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2573374Z 	at org.gradle.tooling.internal.provider.BuildSessionLifecycleBuildActionExecuter.execute(BuildSessionLifecycleBuildActionExecuter.java:41)
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2575319Z 	at org.gradle.tooling.internal.provider.StartParamsValidatingActionExecuter.execute(StartParamsValidatingActionExecuter.java:64)
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2577084Z 	at org.gradle.tooling.internal.provider.StartParamsValidatingActionExecuter.execute(StartParamsValidatingActionExecuter.java:32)
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2578595Z 	at org.gradle.tooling.internal.provider.SessionFailureReportingActionExecuter.execute(SessionFailureReportingActionExecuter.java:51)
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2580130Z 	at org.gradle.tooling.internal.provider.SessionFailureReportingActionExecuter.execute(SessionFailureReportingActionExecuter.java:39)
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2581382Z 	at org.gradle.tooling.internal.provider.SetupLoggingActionExecuter.execute(SetupLoggingActionExecuter.java:47)
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2582790Z 	at org.gradle.tooling.internal.provider.SetupLoggingActionExecuter.execute(SetupLoggingActionExecuter.java:31)
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2584156Z 	at org.gradle.launcher.daemon.server.exec.ExecuteBuild.doBuild(ExecuteBuild.java:65)
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2585149Z 	at org.gradle.launcher.daemon.server.exec.BuildCommandOnly.execute(BuildCommandOnly.java:37)
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2586356Z 	at org.gradle.launcher.daemon.server.api.DaemonCommandExecution.proceed(DaemonCommandExecution.java:104)
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2587466Z 	at org.gradle.launcher.daemon.server.exec.WatchForDisconnection.execute(WatchForDisconnection.java:39)
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2608429Z 	at org.gradle.launcher.daemon.server.exec.BuildCommandOnly.execute(BuildCommandOnly.java:37)
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2609652Z 	at org.gradle.launcher.daemon.server.api.DaemonCommandExecution.proceed(DaemonCommandExecution.java:104)
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2610994Z 	at org.gradle.launcher.daemon.server.exec.StartBuildOrRespondWithBusy$1.run(StartBuildOrRespondWithBusy.java:52)
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2612329Z 	at org.gradle.launcher.daemon.server.DaemonStateCoordinator$1.run(DaemonStateCoordinator.java:297)
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2613509Z 	at org.gradle.internal.concurrent.ExecutorPolicy$CatchAndRecordFailures.onExecute(ExecutorPolicy.java:64)
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2614846Z 	at org.gradle.internal.concurrent.AbstractManagedExecutor$1.run(AbstractManagedExecutor.java:47)
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2615480Z
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2615492Z
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2615623Z BUILD FAILED in 11s
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.6114455Z ##[error]Process completed with exit code 1.
```

## CI: Fix plugin SDK ZIP verification and release validation

- Run: [29619197712](https://github.com/KSPOG/klite/actions/runs/29619197712)
- Conclusion: `failure`
- Event: `push`
- Commit: `9c88565e1ff4f39845c0a2b4f63f496dc347b62d`
- Created: `2026-07-17T22:53:38Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-17T22:54:26.4374864Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-17T22:54:26.4376554Z 	 * @param duration
build	Build and Test	2026-07-17T22:54:26.4377136Z 	   ^
build	Build and Test	2026-07-17T22:54:26.4399166Z > Task :client:javadoc
build	Build and Test	2026-07-17T22:54:26.8375864Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:54:26.8419554Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:26.8448980Z 	            ^
build	Build and Test	2026-07-17T22:54:26.8474634Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:54:26.8499273Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:26.8522148Z 	            ^
build	Build and Test	2026-07-17T22:54:26.8551878Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:54:26.8579250Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:26.8580316Z 	            ^
build	Build and Test	2026-07-17T22:54:26.8581635Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:54:26.8583654Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:26.8584739Z 	            ^
build	Build and Test	2026-07-17T22:54:26.8586235Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:54:26.8591860Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:26.8592931Z 	            ^
build	Build and Test	2026-07-17T22:54:26.8594330Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:54:26.8596719Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:26.8597776Z 	            ^
build	Build and Test	2026-07-17T22:54:26.8599849Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:54:26.8601765Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:26.8602829Z 	            ^
build	Build and Test	2026-07-17T22:54:26.8604309Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:54:26.8606425Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:26.8607453Z 	            ^
build	Build and Test	2026-07-17T22:54:26.8622966Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:54:26.8625276Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:26.8626385Z 	            ^
build	Build and Test	2026-07-17T22:54:26.9370450Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-17T22:54:26.9414206Z 	 * @param itemId
build	Build and Test	2026-07-17T22:54:26.9433552Z 	   ^
build	Build and Test	2026-07-17T22:54:26.9469691Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-17T22:54:26.9498970Z 	 * @return
build	Build and Test	2026-07-17T22:54:27.4384365Z 	            ^
build	Build and Test	2026-07-17T22:54:27.5370183Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-17T22:54:27.5388609Z 	 * @param dimmed
build	Build and Test	2026-07-17T22:54:27.5408833Z 	   ^
build	Build and Test	2026-07-17T22:54:27.5421916Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T22:54:27.5437831Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T22:54:27.5438691Z 	            ^
build	Build and Test	2026-07-17T22:54:27.5444855Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T22:54:27.5446441Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T22:54:27.5488805Z 	            ^
build	Build and Test	2026-07-17T22:54:27.6352363Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-17T22:54:27.6380585Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-17T22:54:27.6381664Z 		                                          ^
build	Build and Test	2026-07-17T22:54:32.0351650Z 100 warnings
build	Build and Test	2026-07-17T22:54:43.0458490Z 	            ^
build	Build and Test	2026-07-17T22:54:43.0511159Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/menus/TestMenuEntry.java:60: warning: Not generating setWorldViewId(): A method with that name already exists
build	Build and Test	2026-07-17T22:54:43.0538525Z 	private int worldViewId;
build	Build and Test	2026-07-17T22:54:43.0568517Z 	            ^
build	Build and Test	2026-07-17T22:54:48.6376596Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:54:48.6412363Z 		GroundPathfinder pathfinder = new GroundPathfinder(new StaticCollisionMap());
build	Build and Test	2026-07-17T22:54:48.6459539Z 		^
build	Build and Test	2026-07-17T22:54:48.6529028Z   symbol:   class GroundPathfinder
build	Build and Test	2026-07-17T22:54:48.6549054Z   location: class StaticCollisionMapTest
build	Build and Test	2026-07-17T22:54:48.6613252Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:54:48.6709523Z 		GroundPathfinder pathfinder = new GroundPathfinder(new StaticCollisionMap());
build	Build and Test	2026-07-17T22:54:48.6779050Z 		                                  ^
build	Build and Test	2026-07-17T22:54:48.6869085Z   symbol:   class GroundPathfinder
build	Build and Test	2026-07-17T22:54:48.6898934Z   location: class StaticCollisionMapTest
build	Build and Test	2026-07-17T22:54:49.2351799Z Note: Some input files use or override a deprecated API.
build	Build and Test	2026-07-17T22:54:49.2352389Z
build	Build and Test	2026-07-17T22:54:49.2358811Z > Task :client:compileTestJava FAILED
build	Build and Test	2026-07-17T22:54:49.2388888Z Note: Recompile with -Xlint:deprecation for details.
build	Build and Test	2026-07-17T22:54:49.2398887Z Note: Some input files use unchecked or unsafe operations.
build	Build and Test	2026-07-17T22:54:49.2449003Z Note: Recompile with -Xlint:unchecked for details.
build	Build and Test	2026-07-17T22:54:49.2478771Z 2 errors
build	Build and Test	2026-07-17T22:54:49.2517947Z 2 warnings
build	Build and Test	2026-07-17T22:55:00.0359065Z
build	Build and Test	2026-07-17T22:55:00.0359778Z > Task :client:checkstyleMain
build	Build and Test	2026-07-17T22:55:00.0360807Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784328844169.json
build	Build and Test	2026-07-17T22:55:00.0362434Z 65 actionable tasks: 27 executed, 38 from cache
build	Build and Test	2026-07-17T22:55:00.0363609Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T22:55:00.0364299Z
build	Build and Test	2026-07-17T22:55:00.0364583Z * What went wrong:
build	Build and Test	2026-07-17T22:55:00.0364971Z Execution failed for task ':client:compileTestJava'.
build	Build and Test	2026-07-17T22:55:00.0365464Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-17T22:55:00.0366027Z
build	Build and Test	2026-07-17T22:55:00.0366148Z * Try:
build	Build and Test	2026-07-17T22:55:00.0366452Z > Run with --info option to get more log output.
build	Build and Test	2026-07-17T22:55:00.0366832Z > Run with --scan to get full insights.
build	Build and Test	2026-07-17T22:55:00.0367057Z
build	Build and Test	2026-07-17T22:55:00.0367170Z BUILD FAILED in 1m 8s
build	Build and Test	2026-07-17T22:55:00.5311846Z ##[error]Process completed with exit code 1.
```

## CI: Add safe workflow run history cleanup

- Run: [29619103093](https://github.com/KSPOG/klite/actions/runs/29619103093)
- Conclusion: `failure`
- Event: `push`
- Commit: `44cc561037a696298c2de2969df6af0989b39d27`
- Created: `2026-07-17T22:51:40Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-17T22:52:19.2360375Z > Task :client:javadoc
build	Build and Test	2026-07-17T22:52:19.2388682Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-17T22:52:19.2406153Z 	 * @param duration
build	Build and Test	2026-07-17T22:52:19.2434170Z 	   ^
build	Build and Test	2026-07-17T22:52:19.7213711Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:52:19.7238109Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:52:19.7239154Z 	            ^
build	Build and Test	2026-07-17T22:52:19.7240690Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:52:19.7242855Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:52:19.7243862Z 	            ^
build	Build and Test	2026-07-17T22:52:19.7245295Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:52:19.7247617Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:52:19.7248633Z 	            ^
build	Build and Test	2026-07-17T22:52:19.7249999Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:52:19.7252218Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:52:19.7253392Z 	            ^
build	Build and Test	2026-07-17T22:52:19.7255008Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:52:19.7258044Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:52:19.7259190Z 	            ^
build	Build and Test	2026-07-17T22:52:19.7260732Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:52:19.7263007Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:52:19.7264294Z 	            ^
build	Build and Test	2026-07-17T22:52:19.7265587Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:52:19.7298049Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:52:19.7299269Z 	            ^
build	Build and Test	2026-07-17T22:52:19.7300833Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:52:19.7303155Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:52:19.7304295Z 	            ^
build	Build and Test	2026-07-17T22:52:19.7305878Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:52:19.7308409Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:52:19.7309584Z 	            ^
build	Build and Test	2026-07-17T22:52:19.7310974Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-17T22:52:19.7312505Z 	 * @param itemId
build	Build and Test	2026-07-17T22:52:19.7312938Z 	   ^
build	Build and Test	2026-07-17T22:52:19.7314356Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-17T22:52:19.7315895Z 	 * @return
build	Build and Test	2026-07-17T22:52:20.3197842Z 	            ^
build	Build and Test	2026-07-17T22:52:20.3199426Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-17T22:52:20.3201496Z 	 * @param dimmed
build	Build and Test	2026-07-17T22:52:20.3202070Z 	   ^
build	Build and Test	2026-07-17T22:52:20.4152516Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T22:52:20.4154663Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T22:52:20.4156049Z 	            ^
build	Build and Test	2026-07-17T22:52:20.4158005Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T22:52:20.4159963Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T22:52:20.4160818Z 	            ^
build	Build and Test	2026-07-17T22:52:20.5152603Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-17T22:52:20.5154762Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-17T22:52:20.5155789Z 		                                          ^
build	Build and Test	2026-07-17T22:52:25.0150893Z 100 warnings
build	Build and Test	2026-07-17T22:52:35.7254427Z 	            ^
build	Build and Test	2026-07-17T22:52:35.7278649Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/menus/TestMenuEntry.java:60: warning: Not generating setWorldViewId(): A method with that name already exists
build	Build and Test	2026-07-17T22:52:35.7307784Z 	private int worldViewId;
build	Build and Test	2026-07-17T22:52:35.7332493Z 	            ^
build	Build and Test	2026-07-17T22:52:41.5151255Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:52:41.5207868Z 		GroundPathfinder pathfinder = new GroundPathfinder(new StaticCollisionMap());
build	Build and Test	2026-07-17T22:52:41.5267576Z 		^
build	Build and Test	2026-07-17T22:52:41.5297756Z   symbol:   class GroundPathfinder
build	Build and Test	2026-07-17T22:52:41.5357511Z   location: class StaticCollisionMapTest
build	Build and Test	2026-07-17T22:52:41.5418819Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:52:41.5477776Z 		GroundPathfinder pathfinder = new GroundPathfinder(new StaticCollisionMap());
build	Build and Test	2026-07-17T22:52:41.5537589Z 		                                  ^
build	Build and Test	2026-07-17T22:52:41.5597676Z   symbol:   class GroundPathfinder
build	Build and Test	2026-07-17T22:52:41.5657575Z   location: class StaticCollisionMapTest
build	Build and Test	2026-07-17T22:52:42.3178032Z Note: Some input files use or override a deprecated API.
build	Build and Test	2026-07-17T22:52:42.3237909Z Note: Recompile with -Xlint:deprecation for details.
build	Build and Test	2026-07-17T22:52:42.3238764Z Note: Some input files use unchecked or unsafe operations.
build	Build and Test	2026-07-17T22:52:42.3267887Z Note: Recompile with -Xlint:unchecked for details.
build	Build and Test	2026-07-17T22:52:42.3297777Z 2 errors
build	Build and Test	2026-07-17T22:52:42.3327649Z 2 warnings
build	Build and Test	2026-07-17T22:52:42.4157514Z
build	Build and Test	2026-07-17T22:52:42.4188154Z > Task :client:compileTestJava FAILED
build	Build and Test	2026-07-17T22:52:52.0151125Z > Task :client:checkstyleMain
build	Build and Test	2026-07-17T22:52:52.1150129Z
build	Build and Test	2026-07-17T22:52:52.1151252Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784328719709.json
build	Build and Test	2026-07-17T22:52:52.1153189Z 65 actionable tasks: 27 executed, 38 from cache
build	Build and Test	2026-07-17T22:52:52.1156731Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T22:52:52.1167774Z
build	Build and Test	2026-07-17T22:52:52.1168212Z * What went wrong:
build	Build and Test	2026-07-17T22:52:52.1168840Z Execution failed for task ':client:compileTestJava'.
build	Build and Test	2026-07-17T22:52:52.1169686Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-17T22:52:52.1170225Z
build	Build and Test	2026-07-17T22:52:52.1170394Z * Try:
build	Build and Test	2026-07-17T22:52:52.1170871Z > Run with --info option to get more log output.
build	Build and Test	2026-07-17T22:52:52.1171831Z > Run with --scan to get full insights.
build	Build and Test	2026-07-17T22:52:52.1172218Z
build	Build and Test	2026-07-17T22:52:52.1172417Z BUILD FAILED in 59s
build	Build and Test	2026-07-17T22:52:52.6166940Z ##[error]Process completed with exit code 1.
```

## Publish KLite Plugin SDK: Retrigger plugin SDK publication with build diagnostics

- Run: [29618768539](https://github.com/KSPOG/klite/actions/runs/29618768539)
- Conclusion: `failure`
- Event: `push`
- Commit: `36b6cdcc1598135abd030ec495b4d1f913cdd42e`
- Created: `2026-07-17T22:44:31Z`

### Failed jobs and steps

- **build-sdk** — `failure`
  - Step 9: **Compile generated standalone starter** — `failure`

### Relevant log context

```text
build-sdk	Compile generated standalone starter	2026-07-17T22:47:27.4817125Z + ./gradlew clean jar --no-daemon --stacktrace
build-sdk	Compile generated standalone starter	2026-07-17T22:47:28.2125037Z To honour the JVM settings for this build a single-use Daemon process will be forked. For more on this, please refer to https://docs.gradle.org/8.8/userguide/gradle_daemon.html#sec:disabling_the_daemon in the Gradle documentation.
build-sdk	Compile generated standalone starter	2026-07-17T22:47:29.4051279Z Daemon will be stopped at the end of the build
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.4103186Z
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.4143569Z FAILURE: Build failed with an exception.
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.4175877Z
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.4186783Z * Where:
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.4187832Z Build file '/home/runner/work/klite/klite/build/sdk-starter-verification/build.gradle.kts' line: 23
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.4188780Z
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.4189079Z * What went wrong:
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.4190236Z Build was configured to prefer settings repositories over project repositories but repository 'MavenRepo' was added by build file 'build.gradle.kts'
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.4192252Z > Run with --info or --debug option to get more log output.
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.4194049Z > Run with --scan to get full insights.
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.4194551Z > Get more help at https://help.gradle.org.
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.4194876Z
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.4195001Z * Exception is:
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.4196023Z org.gradle.api.InvalidUserCodeException: Build was configured to prefer settings repositories over project repositories but repository 'MavenRepo' was added by build file 'build.gradle.kts'
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.4197960Z 	at org.gradle.internal.management.DefaultDependencyResolutionManagement.repoMutationDisallowedOnProject(DefaultDependencyResolutionManagement.java:199)
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.4199484Z 	at org.gradle.internal.ImmutableActionSet$SetWithFewActions.execute(ImmutableActionSet.java:285)
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.4200693Z 	at org.gradle.api.internal.DefaultDomainObjectCollection.doAdd(DefaultDomainObjectCollection.java:262)
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.4202035Z 	at org.gradle.api.internal.DefaultNamedDomainObjectCollection.doAdd(DefaultNamedDomainObjectCollection.java:125)
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.4203409Z 	at org.gradle.api.internal.DefaultDomainObjectCollection.add(DefaultDomainObjectCollection.java:251)
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.4204666Z 	at org.gradle.api.internal.artifacts.DefaultArtifactRepositoryContainer.access$101(DefaultArtifactRepositoryContainer.java:35)
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.5061451Z 	at org.gradle.tooling.internal.provider.BuildSessionLifecycleBuildActionExecuter.execute(BuildSessionLifecycleBuildActionExecuter.java:62)
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.5062718Z 	at org.gradle.tooling.internal.provider.BuildSessionLifecycleBuildActionExecuter.execute(BuildSessionLifecycleBuildActionExecuter.java:41)
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.5064068Z 	at org.gradle.tooling.internal.provider.StartParamsValidatingActionExecuter.execute(StartParamsValidatingActionExecuter.java:64)
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.5065062Z 	at org.gradle.tooling.internal.provider.StartParamsValidatingActionExecuter.execute(StartParamsValidatingActionExecuter.java:32)
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.5066079Z 	at org.gradle.tooling.internal.provider.SessionFailureReportingActionExecuter.execute(SessionFailureReportingActionExecuter.java:51)
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.5067089Z 	at org.gradle.tooling.internal.provider.SessionFailureReportingActionExecuter.execute(SessionFailureReportingActionExecuter.java:39)
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.5067994Z 	at org.gradle.tooling.internal.provider.SetupLoggingActionExecuter.execute(SetupLoggingActionExecuter.java:47)
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.5068801Z 	at org.gradle.tooling.internal.provider.SetupLoggingActionExecuter.execute(SetupLoggingActionExecuter.java:31)
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.5069489Z 	at org.gradle.launcher.daemon.server.exec.ExecuteBuild.doBuild(ExecuteBuild.java:65)
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.5070125Z 	at org.gradle.launcher.daemon.server.exec.BuildCommandOnly.execute(BuildCommandOnly.java:37)
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.5070866Z 	at org.gradle.launcher.daemon.server.api.DaemonCommandExecution.proceed(DaemonCommandExecution.java:104)
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.5071804Z 	at org.gradle.launcher.daemon.server.exec.WatchForDisconnection.execute(WatchForDisconnection.java:39)
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.5085592Z 	at org.gradle.launcher.daemon.server.exec.BuildCommandOnly.execute(BuildCommandOnly.java:37)
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.5086287Z 	at org.gradle.launcher.daemon.server.api.DaemonCommandExecution.proceed(DaemonCommandExecution.java:104)
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.5087078Z 	at org.gradle.launcher.daemon.server.exec.StartBuildOrRespondWithBusy$1.run(StartBuildOrRespondWithBusy.java:52)
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.5087826Z 	at org.gradle.launcher.daemon.server.DaemonStateCoordinator$1.run(DaemonStateCoordinator.java:297)
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.5088542Z 	at org.gradle.internal.concurrent.ExecutorPolicy$CatchAndRecordFailures.onExecute(ExecutorPolicy.java:64)
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.5089463Z 	at org.gradle.internal.concurrent.AbstractManagedExecutor$1.run(AbstractManagedExecutor.java:47)
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.5089846Z
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.5089854Z
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.5089947Z BUILD FAILED in 11s
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.8444951Z ##[error]Process completed with exit code 1.
```

## CI: Retrigger plugin SDK publication with build diagnostics

- Run: [29618768516](https://github.com/KSPOG/klite/actions/runs/29618768516)
- Conclusion: `failure`
- Event: `push`
- Commit: `36b6cdcc1598135abd030ec495b4d1f913cdd42e`
- Created: `2026-07-17T22:44:31Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-17T22:45:21.7271311Z 	   ^
build	Build and Test	2026-07-17T22:45:21.7272156Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-17T22:45:21.7273145Z 	 * @param duration
build	Build and Test	2026-07-17T22:45:21.7301555Z 	   ^
build	Build and Test	2026-07-17T22:45:22.2183101Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:45:22.2222142Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:45:22.2251504Z 	            ^
build	Build and Test	2026-07-17T22:45:22.2312660Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:45:22.2315074Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:45:22.2316214Z 	            ^
build	Build and Test	2026-07-17T22:45:22.2317924Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:45:22.2320353Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:45:22.2351530Z 	            ^
build	Build and Test	2026-07-17T22:45:22.2382411Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:45:22.2412121Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:45:22.2441317Z 	            ^
build	Build and Test	2026-07-17T22:45:22.2472590Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:45:22.2492280Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:45:22.2494413Z 	            ^
build	Build and Test	2026-07-17T22:45:22.2496012Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:45:22.2498303Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:45:22.2499566Z 	            ^
build	Build and Test	2026-07-17T22:45:22.2522701Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:45:22.2525029Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:45:22.2526233Z 	            ^
build	Build and Test	2026-07-17T22:45:22.2527819Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:45:22.2530124Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:45:22.2531475Z 	            ^
build	Build and Test	2026-07-17T22:45:22.2533038Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:45:22.2535331Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:45:22.2536467Z 	            ^
build	Build and Test	2026-07-17T22:45:22.2537867Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-17T22:45:22.2539480Z 	 * @param itemId
build	Build and Test	2026-07-17T22:45:22.2539904Z 	   ^
build	Build and Test	2026-07-17T22:45:22.2541421Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-17T22:45:22.2542921Z 	 * @return
build	Build and Test	2026-07-17T22:45:22.8269137Z 	            ^
build	Build and Test	2026-07-17T22:45:22.9180976Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-17T22:45:22.9184489Z 	 * @param dimmed
build	Build and Test	2026-07-17T22:45:22.9192735Z 	   ^
build	Build and Test	2026-07-17T22:45:23.0193221Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T22:45:23.0196147Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T22:45:23.0197020Z 	            ^
build	Build and Test	2026-07-17T22:45:23.0204464Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T22:45:23.0206410Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T22:45:23.0207272Z 	            ^
build	Build and Test	2026-07-17T22:45:23.0208872Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-17T22:45:23.0211216Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-17T22:45:23.0212249Z 		                                          ^
build	Build and Test	2026-07-17T22:45:28.3178507Z 100 warnings
build	Build and Test	2026-07-17T22:45:38.8271427Z 	            ^
build	Build and Test	2026-07-17T22:45:38.8332476Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/menus/TestMenuEntry.java:60: warning: Not generating setWorldViewId(): A method with that name already exists
build	Build and Test	2026-07-17T22:45:38.8380178Z 	private int worldViewId;
build	Build and Test	2026-07-17T22:45:38.8391729Z 	            ^
build	Build and Test	2026-07-17T22:45:44.0201518Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:45:44.0213210Z 		GroundPathfinder pathfinder = new GroundPathfinder(new StaticCollisionMap());
build	Build and Test	2026-07-17T22:45:44.0232010Z 		^
build	Build and Test	2026-07-17T22:45:44.0261575Z   symbol:   class GroundPathfinder
build	Build and Test	2026-07-17T22:45:44.0262598Z   location: class StaticCollisionMapTest
build	Build and Test	2026-07-17T22:45:44.0292552Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:45:44.0321798Z 		GroundPathfinder pathfinder = new GroundPathfinder(new StaticCollisionMap());
build	Build and Test	2026-07-17T22:45:44.0351556Z 		                                  ^
build	Build and Test	2026-07-17T22:45:44.0381493Z   symbol:   class GroundPathfinder
build	Build and Test	2026-07-17T22:45:44.0382394Z   location: class StaticCollisionMapTest
build	Build and Test	2026-07-17T22:45:44.8178733Z Note: Some input files use or override a deprecated API.
build	Build and Test	2026-07-17T22:45:44.8191258Z
build	Build and Test	2026-07-17T22:45:44.8221635Z Note: Recompile with -Xlint:deprecation for details.
build	Build and Test	2026-07-17T22:45:44.8222391Z > Task :client:compileTestJava FAILED
build	Build and Test	2026-07-17T22:45:44.8223272Z Note: Some input files use unchecked or unsafe operations.
build	Build and Test	2026-07-17T22:45:44.8251460Z Note: Recompile with -Xlint:unchecked for details.
build	Build and Test	2026-07-17T22:45:44.8252125Z 2 errors
build	Build and Test	2026-07-17T22:45:44.8281653Z 2 warnings
build	Build and Test	2026-07-17T22:45:55.1179259Z > Task :client:checkstyleMain
build	Build and Test	2026-07-17T22:45:55.1181486Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784328301967.json
build	Build and Test	2026-07-17T22:45:55.2178096Z
build	Build and Test	2026-07-17T22:45:55.2181347Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T22:45:55.2182379Z 65 actionable tasks: 27 executed, 38 from cache
build	Build and Test	2026-07-17T22:45:55.2183261Z
build	Build and Test	2026-07-17T22:45:55.2183678Z * What went wrong:
build	Build and Test	2026-07-17T22:45:55.2184456Z Execution failed for task ':client:compileTestJava'.
build	Build and Test	2026-07-17T22:45:55.2185521Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-17T22:45:55.2186327Z
build	Build and Test	2026-07-17T22:45:55.2186713Z * Try:
build	Build and Test	2026-07-17T22:45:55.2187487Z > Run with --info option to get more log output.
build	Build and Test	2026-07-17T22:45:55.2188390Z > Run with --scan to get full insights.
build	Build and Test	2026-07-17T22:45:55.2189040Z
build	Build and Test	2026-07-17T22:45:55.2189455Z BUILD FAILED in 1m
build	Build and Test	2026-07-17T22:45:55.6371576Z ##[error]Process completed with exit code 1.
```

## CI: Serve API documentation assets before backend routing

- Run: [29618513490](https://github.com/KSPOG/klite/actions/runs/29618513490)
- Conclusion: `failure`
- Event: `push`
- Commit: `30641aa5163d4fe43258756fd39d1becc050b398`
- Created: `2026-07-17T22:39:10Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-17T22:39:58.9051619Z 	   ^
build	Build and Test	2026-07-17T22:39:58.9067563Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-17T22:39:58.9080561Z 	 * @param duration
build	Build and Test	2026-07-17T22:39:58.9081230Z 	   ^
build	Build and Test	2026-07-17T22:39:59.2974326Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:39:59.3007777Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:39:59.3036554Z 	            ^
build	Build and Test	2026-07-17T22:39:59.3043164Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:39:59.3075750Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:39:59.3106765Z 	            ^
build	Build and Test	2026-07-17T22:39:59.3137942Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:39:59.3167147Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:39:59.3168560Z 	            ^
build	Build and Test	2026-07-17T22:39:59.3197607Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:39:59.3247223Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:39:59.3248560Z 	            ^
build	Build and Test	2026-07-17T22:39:59.3268343Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:39:59.3271468Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:39:59.3276608Z 	            ^
build	Build and Test	2026-07-17T22:39:59.3278377Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:39:59.3280766Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:39:59.3282720Z 	            ^
build	Build and Test	2026-07-17T22:39:59.3284165Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:39:59.3286711Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:39:59.3287995Z 	            ^
build	Build and Test	2026-07-17T22:39:59.3289827Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:39:59.3292319Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:39:59.3293595Z 	            ^
build	Build and Test	2026-07-17T22:39:59.3295241Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:39:59.3297766Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:39:59.3299007Z 	            ^
build	Build and Test	2026-07-17T22:39:59.3300491Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-17T22:39:59.3302075Z 	 * @param itemId
build	Build and Test	2026-07-17T22:39:59.3302634Z 	   ^
build	Build and Test	2026-07-17T22:39:59.3304045Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-17T22:39:59.3305603Z 	 * @return
build	Build and Test	2026-07-17T22:39:59.7984840Z 	            ^
build	Build and Test	2026-07-17T22:39:59.8970741Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-17T22:39:59.8974321Z 	 * @param dimmed
build	Build and Test	2026-07-17T22:39:59.8974976Z 	   ^
build	Build and Test	2026-07-17T22:39:59.9970342Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T22:39:59.9973774Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T22:39:59.9975022Z 	            ^
build	Build and Test	2026-07-17T22:39:59.9978076Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T22:39:59.9979908Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T22:39:59.9980779Z 	            ^
build	Build and Test	2026-07-17T22:39:59.9982424Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-17T22:39:59.9984261Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-17T22:39:59.9985277Z 		                                          ^
build	Build and Test	2026-07-17T22:40:03.9970681Z 100 warnings
build	Build and Test	2026-07-17T22:40:14.6026730Z 	            ^
build	Build and Test	2026-07-17T22:40:14.6049181Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/menus/TestMenuEntry.java:60: warning: Not generating setWorldViewId(): A method with that name already exists
build	Build and Test	2026-07-17T22:40:14.6076639Z 	private int worldViewId;
build	Build and Test	2026-07-17T22:40:14.6086391Z 	            ^
build	Build and Test	2026-07-17T22:40:19.9978181Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:40:20.0021920Z 		GroundPathfinder pathfinder = new GroundPathfinder(new StaticCollisionMap());
build	Build and Test	2026-07-17T22:40:20.0056525Z 		^
build	Build and Test	2026-07-17T22:40:20.0127458Z   symbol:   class GroundPathfinder
build	Build and Test	2026-07-17T22:40:20.0136482Z   location: class StaticCollisionMapTest
build	Build and Test	2026-07-17T22:40:20.0167323Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:40:20.0196718Z 		GroundPathfinder pathfinder = new GroundPathfinder(new StaticCollisionMap());
build	Build and Test	2026-07-17T22:40:20.0226511Z 		                                  ^
build	Build and Test	2026-07-17T22:40:20.0276530Z   symbol:   class GroundPathfinder
build	Build and Test	2026-07-17T22:40:20.0296565Z   location: class StaticCollisionMapTest
build	Build and Test	2026-07-17T22:40:20.5970180Z
build	Build and Test	2026-07-17T22:40:20.5976892Z > Task :client:compileTestJava FAILED
build	Build and Test	2026-07-17T22:40:20.5996955Z Note: Some input files use or override a deprecated API.
build	Build and Test	2026-07-17T22:40:20.6056667Z Note: Recompile with -Xlint:deprecation for details.
build	Build and Test	2026-07-17T22:40:20.6109855Z Note: Some input files use unchecked or unsafe operations.
build	Build and Test	2026-07-17T22:40:20.6176604Z Note: Recompile with -Xlint:unchecked for details.
build	Build and Test	2026-07-17T22:40:20.6232323Z 2 errors
build	Build and Test	2026-07-17T22:40:20.6286378Z 2 warnings
build	Build and Test	2026-07-17T22:40:31.1970858Z > Task :client:checkstyleMain
build	Build and Test	2026-07-17T22:40:31.1996583Z
build	Build and Test	2026-07-17T22:40:31.1997310Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784327978116.json
build	Build and Test	2026-07-17T22:40:31.1999032Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T22:40:31.1999602Z 65 actionable tasks: 27 executed, 38 from cache
build	Build and Test	2026-07-17T22:40:31.2000179Z
build	Build and Test	2026-07-17T22:40:31.2000496Z * What went wrong:
build	Build and Test	2026-07-17T22:40:31.2001114Z Execution failed for task ':client:compileTestJava'.
build	Build and Test	2026-07-17T22:40:31.2001955Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-17T22:40:31.2002570Z
build	Build and Test	2026-07-17T22:40:31.2002871Z * Try:
build	Build and Test	2026-07-17T22:40:31.2003430Z > Run with --info option to get more log output.
build	Build and Test	2026-07-17T22:40:31.2004372Z > Run with --scan to get full insights.
build	Build and Test	2026-07-17T22:40:31.2004834Z
build	Build and Test	2026-07-17T22:40:31.2005135Z BUILD FAILED in 1m 6s
build	Build and Test	2026-07-17T22:40:31.6833521Z ##[error]Process completed with exit code 1.
```

## CI: Prevent stale API documentation assets

- Run: [29618367432](https://github.com/KSPOG/klite/actions/runs/29618367432)
- Conclusion: `failure`
- Event: `push`
- Commit: `6c179f12151bd0b2eb262557bab36543bf618629`
- Created: `2026-07-17T22:36:02Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-17T22:36:53.4415777Z 	   ^
build	Build and Test	2026-07-17T22:36:53.4441436Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-17T22:36:53.4465856Z 	 * @param duration
build	Build and Test	2026-07-17T22:36:53.4466369Z 	   ^
build	Build and Test	2026-07-17T22:36:53.9347550Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:36:53.9376498Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:53.9405813Z 	            ^
build	Build and Test	2026-07-17T22:36:53.9437169Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:36:53.9456556Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:53.9505938Z 	            ^
build	Build and Test	2026-07-17T22:36:53.9547134Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:36:53.9576513Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:53.9605800Z 	            ^
build	Build and Test	2026-07-17T22:36:53.9636868Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:36:53.9666533Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:53.9695745Z 	            ^
build	Build and Test	2026-07-17T22:36:53.9717419Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:36:53.9740211Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:53.9741837Z 	            ^
build	Build and Test	2026-07-17T22:36:53.9743622Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:36:53.9746533Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:53.9747948Z 	            ^
build	Build and Test	2026-07-17T22:36:53.9749534Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:36:53.9751847Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:53.9762541Z 	            ^
build	Build and Test	2026-07-17T22:36:53.9764412Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:36:53.9767236Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:53.9768548Z 	            ^
build	Build and Test	2026-07-17T22:36:53.9770257Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:36:53.9772759Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:53.9774091Z 	            ^
build	Build and Test	2026-07-17T22:36:54.0316704Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-17T22:36:54.0318908Z 	 * @param itemId
build	Build and Test	2026-07-17T22:36:54.0342625Z 	   ^
build	Build and Test	2026-07-17T22:36:54.0344310Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-17T22:36:54.0346527Z 	 * @return
build	Build and Test	2026-07-17T22:36:54.5329774Z 	            ^
build	Build and Test	2026-07-17T22:36:54.6315932Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-17T22:36:54.6336579Z 	 * @param dimmed
build	Build and Test	2026-07-17T22:36:54.6337278Z 	   ^
build	Build and Test	2026-07-17T22:36:54.7326842Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T22:36:54.7327893Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T22:36:54.7328295Z 	            ^
build	Build and Test	2026-07-17T22:36:54.7329098Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T22:36:54.7330046Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T22:36:54.7330418Z 	            ^
build	Build and Test	2026-07-17T22:36:54.8316358Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-17T22:36:54.8318384Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-17T22:36:54.8319547Z 		                                          ^
build	Build and Test	2026-07-17T22:36:59.7314974Z 100 warnings
build	Build and Test	2026-07-17T22:37:10.5397500Z 	            ^
build	Build and Test	2026-07-17T22:37:10.5422845Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/menus/TestMenuEntry.java:60: warning: Not generating setWorldViewId(): A method with that name already exists
build	Build and Test	2026-07-17T22:37:10.5451027Z 	private int worldViewId;
build	Build and Test	2026-07-17T22:37:10.5501697Z 	            ^
build	Build and Test	2026-07-17T22:37:16.1317104Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:37:16.1346077Z 		GroundPathfinder pathfinder = new GroundPathfinder(new StaticCollisionMap());
build	Build and Test	2026-07-17T22:37:16.1405791Z 		^
build	Build and Test	2026-07-17T22:37:16.1406337Z   symbol:   class GroundPathfinder
build	Build and Test	2026-07-17T22:37:16.1465798Z   location: class StaticCollisionMapTest
build	Build and Test	2026-07-17T22:37:16.1467368Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:37:16.1496067Z 		GroundPathfinder pathfinder = new GroundPathfinder(new StaticCollisionMap());
build	Build and Test	2026-07-17T22:37:16.1543273Z 		                                  ^
build	Build and Test	2026-07-17T22:37:16.1586038Z   symbol:   class GroundPathfinder
build	Build and Test	2026-07-17T22:37:16.1615832Z   location: class StaticCollisionMapTest
build	Build and Test	2026-07-17T22:37:16.9346584Z Note: Some input files use or override a deprecated API.
build	Build and Test	2026-07-17T22:37:16.9347186Z
build	Build and Test	2026-07-17T22:37:16.9406081Z Note: Recompile with -Xlint:deprecation for details.
build	Build and Test	2026-07-17T22:37:16.9406853Z > Task :client:compileTestJava FAILED
build	Build and Test	2026-07-17T22:37:16.9407608Z Note: Some input files use unchecked or unsafe operations.
build	Build and Test	2026-07-17T22:37:16.9447290Z Note: Recompile with -Xlint:unchecked for details.
build	Build and Test	2026-07-17T22:37:16.9465756Z 2 errors
build	Build and Test	2026-07-17T22:37:16.9495679Z 2 warnings
build	Build and Test	2026-07-17T22:37:25.9336471Z > Task :client:checkstyleMain
build	Build and Test	2026-07-17T22:37:26.0316034Z
build	Build and Test	2026-07-17T22:37:26.0317134Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784327792105.json
build	Build and Test	2026-07-17T22:37:26.0318888Z 65 actionable tasks: 27 executed, 38 from cache
build	Build and Test	2026-07-17T22:37:26.0376129Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T22:37:26.0406272Z
build	Build and Test	2026-07-17T22:37:26.0416619Z * What went wrong:
build	Build and Test	2026-07-17T22:37:26.0417659Z Execution failed for task ':client:compileTestJava'.
build	Build and Test	2026-07-17T22:37:26.0418930Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-17T22:37:26.0419766Z
build	Build and Test	2026-07-17T22:37:26.0420140Z * Try:
build	Build and Test	2026-07-17T22:37:26.0420889Z > Run with --info option to get more log output.
build	Build and Test	2026-07-17T22:37:26.0421820Z > Run with --scan to get full insights.
build	Build and Test	2026-07-17T22:37:26.0422452Z
build	Build and Test	2026-07-17T22:37:26.0422836Z BUILD FAILED in 1m 2s
build	Build and Test	2026-07-17T22:37:26.5877994Z ##[error]Process completed with exit code 1.
```

## CI: Refresh API documentation asset versions

- Run: [29618361936](https://github.com/KSPOG/klite/actions/runs/29618361936)
- Conclusion: `failure`
- Event: `push`
- Commit: `dc424b22d4b3b3041166a54d881e55dbe2c805ef`
- Created: `2026-07-17T22:35:53Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-17T22:36:46.4718581Z 	   ^
build	Build and Test	2026-07-17T22:36:46.4729319Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-17T22:36:46.4731152Z 	 * @param duration
build	Build and Test	2026-07-17T22:36:46.4731758Z 	   ^
build	Build and Test	2026-07-17T22:36:46.9660009Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:36:46.9678210Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:46.9708332Z 	            ^
build	Build and Test	2026-07-17T22:36:46.9737193Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:36:46.9769111Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:46.9770839Z 	            ^
build	Build and Test	2026-07-17T22:36:46.9799719Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:36:46.9832964Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:46.9858411Z 	            ^
build	Build and Test	2026-07-17T22:36:46.9866677Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:36:46.9869693Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:46.9871266Z 	            ^
build	Build and Test	2026-07-17T22:36:46.9873156Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:36:46.9881239Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:46.9882811Z 	            ^
build	Build and Test	2026-07-17T22:36:46.9884399Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:36:46.9887026Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:46.9888715Z 	            ^
build	Build and Test	2026-07-17T22:36:46.9919013Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:36:46.9921394Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:46.9922650Z 	            ^
build	Build and Test	2026-07-17T22:36:46.9924365Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:36:46.9926770Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:46.9928427Z 	            ^
build	Build and Test	2026-07-17T22:36:46.9930092Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:36:46.9932540Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:46.9933783Z 	            ^
build	Build and Test	2026-07-17T22:36:47.0665109Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-17T22:36:47.0718835Z 	 * @param itemId
build	Build and Test	2026-07-17T22:36:47.0729176Z 	   ^
build	Build and Test	2026-07-17T22:36:47.0731075Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-17T22:36:47.0733005Z 	 * @return
build	Build and Test	2026-07-17T22:36:47.7644364Z 	            ^
build	Build and Test	2026-07-17T22:36:47.7646133Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-17T22:36:47.7649392Z 	 * @param dimmed
build	Build and Test	2026-07-17T22:36:47.7656193Z 	   ^
build	Build and Test	2026-07-17T22:36:47.8631720Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T22:36:47.8633978Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T22:36:47.8634903Z 	            ^
build	Build and Test	2026-07-17T22:36:47.8636581Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T22:36:47.8639014Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T22:36:47.8639943Z 	            ^
build	Build and Test	2026-07-17T22:36:47.9632018Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-17T22:36:47.9635521Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-17T22:36:47.9636498Z 		                                          ^
build	Build and Test	2026-07-17T22:36:53.3630703Z 100 warnings
build	Build and Test	2026-07-17T22:37:04.1708050Z 	            ^
build	Build and Test	2026-07-17T22:37:04.1769278Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/menus/TestMenuEntry.java:60: warning: Not generating setWorldViewId(): A method with that name already exists
build	Build and Test	2026-07-17T22:37:04.1808242Z 	private int worldViewId;
build	Build and Test	2026-07-17T22:37:04.1838235Z 	            ^
build	Build and Test	2026-07-17T22:37:10.9709829Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:37:10.9744285Z 		GroundPathfinder pathfinder = new GroundPathfinder(new StaticCollisionMap());
build	Build and Test	2026-07-17T22:37:10.9808328Z 		^
build	Build and Test	2026-07-17T22:37:10.9848456Z   symbol:   class GroundPathfinder
build	Build and Test	2026-07-17T22:37:10.9898416Z   location: class StaticCollisionMapTest
build	Build and Test	2026-07-17T22:37:10.9939139Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:37:10.9968510Z 		GroundPathfinder pathfinder = new GroundPathfinder(new StaticCollisionMap());
build	Build and Test	2026-07-17T22:37:11.0018333Z 		                                  ^
build	Build and Test	2026-07-17T22:37:11.0078443Z   symbol:   class GroundPathfinder
build	Build and Test	2026-07-17T22:37:11.0138453Z   location: class StaticCollisionMapTest
build	Build and Test	2026-07-17T22:37:11.6638827Z Note: Some input files use or override a deprecated API.
build	Build and Test	2026-07-17T22:37:11.6639387Z
build	Build and Test	2026-07-17T22:37:11.6668278Z Note: Recompile with -Xlint:deprecation for details.
build	Build and Test	2026-07-17T22:37:11.6688320Z Note: Some input files use unchecked or unsafe operations.
build	Build and Test	2026-07-17T22:37:11.6689114Z > Task :client:compileTestJava FAILED
build	Build and Test	2026-07-17T22:37:11.6718319Z Note: Recompile with -Xlint:unchecked for details.
build	Build and Test	2026-07-17T22:37:11.6719065Z 2 errors
build	Build and Test	2026-07-17T22:37:11.6719513Z 2 warnings
build	Build and Test	2026-07-17T22:37:22.1658756Z > Task :client:checkstyleMain
build	Build and Test	2026-07-17T22:37:22.2630428Z
build	Build and Test	2026-07-17T22:37:22.2631610Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784327784885.json
build	Build and Test	2026-07-17T22:37:22.2633334Z 65 actionable tasks: 27 executed, 38 from cache
build	Build and Test	2026-07-17T22:37:22.2638051Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T22:37:22.2638801Z
build	Build and Test	2026-07-17T22:37:22.2639226Z * What went wrong:
build	Build and Test	2026-07-17T22:37:22.2639988Z Execution failed for task ':client:compileTestJava'.
build	Build and Test	2026-07-17T22:37:22.2640795Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-17T22:37:22.2641171Z
build	Build and Test	2026-07-17T22:37:22.2641286Z * Try:
build	Build and Test	2026-07-17T22:37:22.2641614Z > Run with --info option to get more log output.
build	Build and Test	2026-07-17T22:37:22.2642041Z > Run with --scan to get full insights.
build	Build and Test	2026-07-17T22:37:22.2642294Z
build	Build and Test	2026-07-17T22:37:22.2642425Z BUILD FAILED in 1m 7s
build	Build and Test	2026-07-17T22:37:22.7190086Z ##[error]Process completed with exit code 1.
```

## CI: Compile generated plugin starter before publishing SDK

- Run: [29618192143](https://github.com/KSPOG/klite/actions/runs/29618192143)
- Conclusion: `failure`
- Event: `push`
- Commit: `249ff500a57fb8a4f18746c65b579e37f1a08e17`
- Created: `2026-07-17T22:32:29Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-17T22:33:12.1810049Z 	   ^
build	Build and Test	2026-07-17T22:33:12.1811400Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-17T22:33:12.1812950Z 	 * @param duration
build	Build and Test	2026-07-17T22:33:12.1813419Z 	   ^
build	Build and Test	2026-07-17T22:33:12.6788906Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:33:12.6807659Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:33:12.6836852Z 	            ^
build	Build and Test	2026-07-17T22:33:12.6868149Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:33:12.6870495Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:33:12.6871592Z 	            ^
build	Build and Test	2026-07-17T22:33:12.6873118Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:33:12.6875307Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:33:12.6876676Z 	            ^
build	Build and Test	2026-07-17T22:33:12.6878067Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:33:12.6880261Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:33:12.6881449Z 	            ^
build	Build and Test	2026-07-17T22:33:12.6883052Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:33:12.6886072Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:33:12.6887483Z 	            ^
build	Build and Test	2026-07-17T22:33:12.6889072Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:33:12.6910158Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:33:12.6911918Z 	            ^
build	Build and Test	2026-07-17T22:33:12.6913338Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:33:12.6915886Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:33:12.6917197Z 	            ^
build	Build and Test	2026-07-17T22:33:12.6918721Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:33:12.6921064Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:33:12.6922248Z 	            ^
build	Build and Test	2026-07-17T22:33:12.6923793Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:33:12.6926109Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:33:12.6927542Z 	            ^
build	Build and Test	2026-07-17T22:33:12.7798407Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-17T22:33:12.7826458Z 	 * @param itemId
build	Build and Test	2026-07-17T22:33:12.7856836Z 	   ^
build	Build and Test	2026-07-17T22:33:12.7887947Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-17T22:33:12.7890656Z 	 * @return
build	Build and Test	2026-07-17T22:33:13.2833860Z 	            ^
build	Build and Test	2026-07-17T22:33:13.3779930Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-17T22:33:13.3782490Z 	 * @param dimmed
build	Build and Test	2026-07-17T22:33:13.3783365Z 	   ^
build	Build and Test	2026-07-17T22:33:13.4780291Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T22:33:13.4782372Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T22:33:13.4783958Z 	            ^
build	Build and Test	2026-07-17T22:33:13.4785752Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T22:33:13.4787947Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T22:33:13.4788803Z 	            ^
build	Build and Test	2026-07-17T22:33:13.5780832Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-17T22:33:13.5783034Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-17T22:33:13.5784181Z 		                                          ^
build	Build and Test	2026-07-17T22:33:18.4778118Z 100 warnings
build	Build and Test	2026-07-17T22:33:29.9897186Z 	            ^
build	Build and Test	2026-07-17T22:33:29.9917857Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/menus/TestMenuEntry.java:60: warning: Not generating setWorldViewId(): A method with that name already exists
build	Build and Test	2026-07-17T22:33:29.9937124Z 	private int worldViewId;
build	Build and Test	2026-07-17T22:33:29.9966879Z 	            ^
build	Build and Test	2026-07-17T22:33:35.8789573Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:33:35.8807233Z 		GroundPathfinder pathfinder = new GroundPathfinder(new StaticCollisionMap());
build	Build and Test	2026-07-17T22:33:35.8831119Z 		^
build	Build and Test	2026-07-17T22:33:35.8855264Z   symbol:   class GroundPathfinder
build	Build and Test	2026-07-17T22:33:35.8885217Z   location: class StaticCollisionMapTest
build	Build and Test	2026-07-17T22:33:35.8897705Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:33:35.8927115Z 		GroundPathfinder pathfinder = new GroundPathfinder(new StaticCollisionMap());
build	Build and Test	2026-07-17T22:33:35.8956904Z 		                                  ^
build	Build and Test	2026-07-17T22:33:35.8981432Z   symbol:   class GroundPathfinder
build	Build and Test	2026-07-17T22:33:35.8996214Z   location: class StaticCollisionMapTest
build	Build and Test	2026-07-17T22:33:36.7787490Z Note: Some input files use or override a deprecated API.
build	Build and Test	2026-07-17T22:33:36.7806944Z Note: Recompile with -Xlint:deprecation for details.
build	Build and Test	2026-07-17T22:33:36.7847008Z Note: Some input files use unchecked or unsafe operations.
build	Build and Test	2026-07-17T22:33:36.7848034Z Note: Recompile with -Xlint:unchecked for details.
build	Build and Test	2026-07-17T22:33:36.7876952Z 2 errors
build	Build and Test	2026-07-17T22:33:36.7883806Z 2 warnings
build	Build and Test	2026-07-17T22:33:36.8786947Z
build	Build and Test	2026-07-17T22:33:36.8788051Z > Task :client:compileTestJava FAILED
build	Build and Test	2026-07-17T22:33:47.4800642Z > Task :client:checkstyleMain
build	Build and Test	2026-07-17T22:33:47.4827831Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784327571305.json
build	Build and Test	2026-07-17T22:33:47.5778616Z
build	Build and Test	2026-07-17T22:33:47.5779141Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T22:33:47.5779439Z
build	Build and Test	2026-07-17T22:33:47.5779553Z * What went wrong:
build	Build and Test	2026-07-17T22:33:47.5779875Z Execution failed for task ':client:compileTestJava'.
build	Build and Test	2026-07-17T22:33:47.5780335Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-17T22:33:47.5780633Z
build	Build and Test	2026-07-17T22:33:47.5780728Z * Try:
build	Build and Test	2026-07-17T22:33:47.5781011Z > Run with --info option to get more log output.
build	Build and Test	2026-07-17T22:33:47.5781363Z > Run with --scan to get full insights.
build	Build and Test	2026-07-17T22:33:47.5782051Z
build	Build and Test	2026-07-17T22:33:47.5782159Z BUILD FAILED in 1m 5s
build	Build and Test	2026-07-17T22:33:47.5782468Z 65 actionable tasks: 27 executed, 38 from cache
build	Build and Test	2026-07-17T22:33:48.0855689Z ##[error]Process completed with exit code 1.
```

## Publish KLite Plugin SDK: Compile generated plugin starter before publishing SDK

- Run: [29618192132](https://github.com/KSPOG/klite/actions/runs/29618192132)
- Conclusion: `failure`
- Event: `push`
- Commit: `249ff500a57fb8a4f18746c65b579e37f1a08e17`
- Created: `2026-07-17T22:32:29Z`

### Failed jobs and steps

- **build-sdk** — `failure`
  - Step 8: **Compile generated standalone starter** — `failure`

### Relevant log context

```text
build-sdk	Compile generated standalone starter	2026-07-17T22:35:27.3644880Z ##[endgroup]
build-sdk	Compile generated standalone starter	2026-07-17T22:35:28.0442183Z To honour the JVM settings for this build a single-use Daemon process will be forked. For more on this, please refer to https://docs.gradle.org/8.8/userguide/gradle_daemon.html#sec:disabling_the_daemon in the Gradle documentation.
build-sdk	Compile generated standalone starter	2026-07-17T22:35:29.0426569Z Daemon will be stopped at the end of the build
build-sdk	Compile generated standalone starter	2026-07-17T22:35:38.3424573Z
build-sdk	Compile generated standalone starter	2026-07-17T22:35:38.3425573Z FAILURE: Build failed with an exception.
build-sdk	Compile generated standalone starter	2026-07-17T22:35:38.3426093Z
build-sdk	Compile generated standalone starter	2026-07-17T22:35:38.3426282Z * Where:
build-sdk	Compile generated standalone starter	2026-07-17T22:35:38.3437055Z Build file '/home/runner/work/klite/klite/build/sdk-starter-verification/build.gradle.kts' line: 23
build-sdk	Compile generated standalone starter	2026-07-17T22:35:38.3441517Z
build-sdk	Compile generated standalone starter	2026-07-17T22:35:38.3441691Z * What went wrong:
build-sdk	Compile generated standalone starter	2026-07-17T22:35:38.3442408Z Build was configured to prefer settings repositories over project repositories but repository 'MavenRepo' was added by build file 'build.gradle.kts'
build-sdk	Compile generated standalone starter	2026-07-17T22:35:38.3444472Z > Run with --info or --debug option to get more log output.
build-sdk	Compile generated standalone starter	2026-07-17T22:35:38.3444868Z > Run with --scan to get full insights.
build-sdk	Compile generated standalone starter	2026-07-17T22:35:38.3445295Z > Get more help at https://help.gradle.org.
build-sdk	Compile generated standalone starter	2026-07-17T22:35:38.3445552Z
build-sdk	Compile generated standalone starter	2026-07-17T22:35:38.3445709Z BUILD FAILED in 10s
build-sdk	Compile generated standalone starter	2026-07-17T22:35:38.7222408Z ##[error]Process completed with exit code 1.
```

## CI: Add isolated plugin SDK and IDE setup guide

- Run: [29618171116](https://github.com/KSPOG/klite/actions/runs/29618171116)
- Conclusion: `failure`
- Event: `push`
- Commit: `51c9d5d2e407af29ee11d33212610a2097174220`
- Created: `2026-07-17T22:32:02Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-17T22:32:47.4856379Z 	   ^
build	Build and Test	2026-07-17T22:32:47.4867569Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-17T22:32:47.4869349Z 	 * @param duration
build	Build and Test	2026-07-17T22:32:47.4870057Z 	   ^
build	Build and Test	2026-07-17T22:32:48.0817666Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:32:48.0836792Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:48.0866141Z 	            ^
build	Build and Test	2026-07-17T22:32:48.0867830Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:32:48.0896682Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:48.0926124Z 	            ^
build	Build and Test	2026-07-17T22:32:48.0937508Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:32:48.0966879Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:48.0986115Z 	            ^
build	Build and Test	2026-07-17T22:32:48.1017005Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:32:48.1046782Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:48.1072104Z 	            ^
build	Build and Test	2026-07-17T22:32:48.1077331Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:32:48.1110022Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:48.1134387Z 	            ^
build	Build and Test	2026-07-17T22:32:48.1136408Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:32:48.1138904Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:48.1140224Z 	            ^
build	Build and Test	2026-07-17T22:32:48.1141826Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:32:48.1144059Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:48.1145359Z 	            ^
build	Build and Test	2026-07-17T22:32:48.1147129Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:32:48.1149604Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:48.1150971Z 	            ^
build	Build and Test	2026-07-17T22:32:48.1152747Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:32:48.1155262Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:48.1156961Z 	            ^
build	Build and Test	2026-07-17T22:32:48.1158567Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-17T22:32:48.1160363Z 	 * @param itemId
build	Build and Test	2026-07-17T22:32:48.1161065Z 	   ^
build	Build and Test	2026-07-17T22:32:48.1162709Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-17T22:32:48.1170562Z 	 * @return
build	Build and Test	2026-07-17T22:32:48.5806196Z 	            ^
build	Build and Test	2026-07-17T22:32:48.5807928Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-17T22:32:48.5810554Z 	 * @param dimmed
build	Build and Test	2026-07-17T22:32:48.5811265Z 	   ^
build	Build and Test	2026-07-17T22:32:48.6801696Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T22:32:48.6804112Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T22:32:48.6805247Z 	            ^
build	Build and Test	2026-07-17T22:32:48.6818276Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T22:32:48.6820520Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T22:32:48.6842918Z 	            ^
build	Build and Test	2026-07-17T22:32:48.7784236Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-17T22:32:48.7788016Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-17T22:32:48.7793354Z 		                                          ^
build	Build and Test	2026-07-17T22:32:52.7783154Z 100 warnings
build	Build and Test	2026-07-17T22:33:02.8956258Z 	            ^
build	Build and Test	2026-07-17T22:33:02.8997082Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/menus/TestMenuEntry.java:60: warning: Not generating setWorldViewId(): A method with that name already exists
build	Build and Test	2026-07-17T22:33:02.8998627Z 	private int worldViewId;
build	Build and Test	2026-07-17T22:33:02.8999090Z 	            ^
build	Build and Test	2026-07-17T22:33:08.5787428Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:33:08.5806657Z 		GroundPathfinder pathfinder = new GroundPathfinder(new StaticCollisionMap());
build	Build and Test	2026-07-17T22:33:08.5836815Z 		^
build	Build and Test	2026-07-17T22:33:08.5846496Z   symbol:   class GroundPathfinder
build	Build and Test	2026-07-17T22:33:08.5866256Z   location: class StaticCollisionMapTest
build	Build and Test	2026-07-17T22:33:08.5897064Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:33:08.5926466Z 		GroundPathfinder pathfinder = new GroundPathfinder(new StaticCollisionMap());
build	Build and Test	2026-07-17T22:33:08.5937909Z 		                                  ^
build	Build and Test	2026-07-17T22:33:08.5956149Z   symbol:   class GroundPathfinder
build	Build and Test	2026-07-17T22:33:08.5986190Z   location: class StaticCollisionMapTest
build	Build and Test	2026-07-17T22:33:09.1786619Z Note: Some input files use or override a deprecated API.
build	Build and Test	2026-07-17T22:33:09.1816248Z Note: Recompile with -Xlint:deprecation for details.
build	Build and Test	2026-07-17T22:33:09.1876181Z Note: Some input files use unchecked or unsafe operations.
build	Build and Test	2026-07-17T22:33:09.1926196Z Note: Recompile with -Xlint:unchecked for details.
build	Build and Test	2026-07-17T22:33:09.1966012Z 2 errors
build	Build and Test	2026-07-17T22:33:09.1985991Z 2 warnings
build	Build and Test	2026-07-17T22:33:09.2781782Z
build	Build and Test	2026-07-17T22:33:09.2796503Z > Task :client:compileTestJava FAILED
build	Build and Test	2026-07-17T22:33:19.4782814Z
build	Build and Test	2026-07-17T22:33:19.4783466Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T22:33:19.4784004Z
build	Build and Test	2026-07-17T22:33:19.4784244Z > Task :client:checkstyleMain
build	Build and Test	2026-07-17T22:33:19.4785229Z * What went wrong:
build	Build and Test	2026-07-17T22:33:19.4793476Z Execution failed for task ':client:compileTestJava'.
build	Build and Test	2026-07-17T22:33:19.4795378Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784327547602.json
build	Build and Test	2026-07-17T22:33:19.4796597Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-17T22:33:19.4796929Z
build	Build and Test	2026-07-17T22:33:19.4797044Z * Try:
build	Build and Test	2026-07-17T22:33:19.4797360Z > Run with --info option to get more log output.
build	Build and Test	2026-07-17T22:33:19.4797756Z > Run with --scan to get full insights.
build	Build and Test	2026-07-17T22:33:19.4797997Z
build	Build and Test	2026-07-17T22:33:19.4798117Z BUILD FAILED in 57s
build	Build and Test	2026-07-17T22:33:19.4798448Z 65 actionable tasks: 27 executed, 38 from cache
build	Build and Test	2026-07-17T22:33:19.9731387Z ##[error]Process completed with exit code 1.
```

## Publish KLite Plugin SDK: Publish isolated KLite plugin SDK and starter

- Run: [29618133339](https://github.com/KSPOG/klite/actions/runs/29618133339)
- Conclusion: `cancelled`
- Event: `push`
- Commit: `421dbb8e24ea095f5a74c539cd68cb9ea1a585ce`
- Created: `2026-07-17T22:31:18Z`

### Failed jobs and steps

- **build-sdk** — `cancelled`
  - Step 4: **Build RuneLite API classes** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## CI: Publish isolated KLite plugin SDK and starter

- Run: [29618133323](https://github.com/KSPOG/klite/actions/runs/29618133323)
- Conclusion: `failure`
- Event: `push`
- Commit: `421dbb8e24ea095f5a74c539cd68cb9ea1a585ce`
- Created: `2026-07-17T22:31:18Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-17T22:32:10.4128821Z 	   ^
build	Build and Test	2026-07-17T22:32:10.4130435Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-17T22:32:10.4132264Z 	 * @param duration
build	Build and Test	2026-07-17T22:32:10.4132901Z 	   ^
build	Build and Test	2026-07-17T22:32:11.0078445Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:32:11.0129587Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:11.0168900Z 	            ^
build	Build and Test	2026-07-17T22:32:11.0200416Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:32:11.0231079Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:11.0349150Z 	            ^
build	Build and Test	2026-07-17T22:32:11.0393489Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:32:11.0469712Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:11.0509038Z 	            ^
build	Build and Test	2026-07-17T22:32:11.0569897Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:32:11.0599576Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:11.0600986Z 	            ^
build	Build and Test	2026-07-17T22:32:11.0602817Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:32:11.0606195Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:11.0607546Z 	            ^
build	Build and Test	2026-07-17T22:32:11.0609458Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:32:11.0611617Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:11.0612725Z 	            ^
build	Build and Test	2026-07-17T22:32:11.0614034Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:32:11.0615907Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:11.0616956Z 	            ^
build	Build and Test	2026-07-17T22:32:11.0648711Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:32:11.0651149Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:11.0652286Z 	            ^
build	Build and Test	2026-07-17T22:32:11.0653821Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:32:11.0656105Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:11.0657294Z 	            ^
build	Build and Test	2026-07-17T22:32:11.0658984Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-17T22:32:11.0660533Z 	 * @param itemId
build	Build and Test	2026-07-17T22:32:11.0661004Z 	   ^
build	Build and Test	2026-07-17T22:32:11.0662361Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-17T22:32:11.0663874Z 	 * @return
build	Build and Test	2026-07-17T22:32:11.6128833Z 	            ^
build	Build and Test	2026-07-17T22:32:11.6130845Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-17T22:32:11.6132587Z 	 * @param dimmed
build	Build and Test	2026-07-17T22:32:11.6132995Z 	   ^
build	Build and Test	2026-07-17T22:32:11.7100308Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T22:32:11.7128973Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T22:32:11.7159079Z 	            ^
build	Build and Test	2026-07-17T22:32:11.7190639Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T22:32:11.7192737Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-17T22:32:11.7193675Z 	            ^
build	Build and Test	2026-07-17T22:32:11.8089129Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-17T22:32:11.8091682Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-17T22:32:11.8092787Z 		                                          ^
build	Build and Test	2026-07-17T22:32:16.6077303Z 100 warnings
build	Build and Test	2026-07-17T22:32:27.5218708Z 	            ^
build	Build and Test	2026-07-17T22:32:27.5249912Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/menus/TestMenuEntry.java:60: warning: Not generating setWorldViewId(): A method with that name already exists
build	Build and Test	2026-07-17T22:32:27.5278888Z 	private int worldViewId;
build	Build and Test	2026-07-17T22:32:27.5318835Z 	            ^
build	Build and Test	2026-07-17T22:32:34.3077894Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:32:34.3179376Z 		GroundPathfinder pathfinder = new GroundPathfinder(new StaticCollisionMap());
build	Build and Test	2026-07-17T22:32:34.3188937Z 		^
build	Build and Test	2026-07-17T22:32:34.3248951Z   symbol:   class GroundPathfinder
build	Build and Test	2026-07-17T22:32:34.3279211Z   location: class StaticCollisionMapTest
build	Build and Test	2026-07-17T22:32:34.3309714Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:32:34.3338999Z 		GroundPathfinder pathfinder = new GroundPathfinder(new StaticCollisionMap());
build	Build and Test	2026-07-17T22:32:34.3344338Z 		                                  ^
build	Build and Test	2026-07-17T22:32:34.3368733Z   symbol:   class GroundPathfinder
build	Build and Test	2026-07-17T22:32:34.3398738Z   location: class StaticCollisionMapTest
build	Build and Test	2026-07-17T22:32:34.8076819Z Note: Some input files use or override a deprecated API.
build	Build and Test	2026-07-17T22:32:34.8099601Z Note: Recompile with -Xlint:deprecation for details.
build	Build and Test	2026-07-17T22:32:34.8128921Z Note: Some input files use unchecked or unsafe operations.
build	Build and Test	2026-07-17T22:32:34.8156402Z Note: Recompile with -Xlint:unchecked for details.
build	Build and Test	2026-07-17T22:32:34.8157231Z 2 errors
build	Build and Test	2026-07-17T22:32:34.8218822Z 2 warnings
build	Build and Test	2026-07-17T22:32:34.9076278Z
build	Build and Test	2026-07-17T22:32:34.9099047Z > Task :client:compileTestJava FAILED
build	Build and Test	2026-07-17T22:32:44.4079030Z
build	Build and Test	2026-07-17T22:32:44.4079690Z > Task :client:checkstyleMain
build	Build and Test	2026-07-17T22:32:44.4099042Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T22:32:44.4100204Z
build	Build and Test	2026-07-17T22:32:44.4100394Z * What went wrong:
build	Build and Test	2026-07-17T22:32:44.4100932Z Execution failed for task ':client:compileTestJava'.
build	Build and Test	2026-07-17T22:32:44.4101733Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-17T22:32:44.4102278Z
build	Build and Test	2026-07-17T22:32:44.4102443Z * Try:
build	Build and Test	2026-07-17T22:32:44.4102904Z > Run with --info option to get more log output.
build	Build and Test	2026-07-17T22:32:44.4103526Z > Run with --scan to get full insights.
build	Build and Test	2026-07-17T22:32:44.4103911Z
build	Build and Test	2026-07-17T22:32:44.4104092Z BUILD FAILED in 1m 3s
build	Build and Test	2026-07-17T22:32:44.4105237Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784327509313.json
build	Build and Test	2026-07-17T22:32:44.4106410Z 65 actionable tasks: 27 executed, 38 from cache
build	Build and Test	2026-07-17T22:32:44.9263305Z ##[error]Process completed with exit code 1.
```

