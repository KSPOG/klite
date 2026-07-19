# Recent GitHub Actions failures

Generated: 2026-07-19T18:49:43.674074+00:00
Repository: `KSPOG/klite`
Failed runs inspected: **6**

## CI: Add GE Flipper task source part 01

- Run: [29699346025](https://github.com/KSPOG/klite/actions/runs/29699346025)
- Conclusion: `failure`
- Event: `push`
- Commit: `8c521c991491095f507cea559d402844dc109b55`
- Created: `2026-07-19T18:48:30Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-19T18:49:12.1981382Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-19T18:49:12.2022401Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-19T18:49:12.2023009Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-19T18:49:12.2957354Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-19T18:49:12.2977011Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-19T18:49:12.3006945Z > Task :runelite-api:build
build	Build and Test	2026-07-19T18:49:12.6967476Z > Task :copper-tin-miner:compileJava FROM-CACHE
build	Build and Test	2026-07-19T18:49:12.6996814Z > Task :copper-tin-miner:classes UP-TO-DATE
build	Build and Test	2026-07-19T18:49:12.7026878Z > Task :copper-tin-miner:jar
build	Build and Test	2026-07-19T18:49:12.7049636Z > Task :copper-tin-miner:assemble
build	Build and Test	2026-07-19T18:49:12.8957415Z > Task :copper-tin-miner:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-19T18:49:12.8989718Z > Task :copper-tin-miner:compileTestJava NO-SOURCE
build	Build and Test	2026-07-19T18:49:12.8994655Z > Task :copper-tin-miner:testClasses UP-TO-DATE
build	Build and Test	2026-07-19T18:49:12.8995180Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-19T18:49:12.8995639Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-19T18:49:12.8996042Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-19T18:49:12.8996593Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-19T18:49:12.9977279Z > Task :client:jar
build	Build and Test	2026-07-19T18:49:12.9977774Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-19T18:49:13.1957651Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-19T18:49:13.2960472Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:34: error: cannot find symbol
build	Build and Test	2026-07-19T18:49:13.2961465Z
build	Build and Test	2026-07-19T18:49:13.2977026Z > Task :klite-ge-flipper:compileJava FAILED
build	Build and Test	2026-07-19T18:49:13.2977890Z     private KLiteGeFlipperTask task;
build	Build and Test	2026-07-19T18:49:13.2978561Z             ^
build	Build and Test	2026-07-19T18:49:13.2979047Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:49:13.2979638Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:49:13.2980789Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:54: error: cannot find symbol
build	Build and Test	2026-07-19T18:49:13.2981985Z         task = new KLiteGeFlipperTask(this, webWalker);
build	Build and Test	2026-07-19T18:49:13.2982613Z                    ^
build	Build and Test	2026-07-19T18:49:13.2983130Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:49:13.2983709Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:49:13.2984869Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:266: error: cannot find symbol
build	Build and Test	2026-07-19T18:49:13.2986086Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:49:13.2986899Z         ^
build	Build and Test	2026-07-19T18:49:13.2987360Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:49:13.2987942Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:49:13.2989100Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:272: error: cannot find symbol
build	Build and Test	2026-07-19T18:49:13.2990297Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:49:13.2990903Z         ^
build	Build and Test	2026-07-19T18:49:13.2991399Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:49:13.2992040Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:49:13.2993186Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:278: error: cannot find symbol
build	Build and Test	2026-07-19T18:49:13.2994339Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:49:13.2994913Z         ^
build	Build and Test	2026-07-19T18:49:13.2995402Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:49:13.2995990Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:49:13.2997298Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:284: error: cannot find symbol
build	Build and Test	2026-07-19T18:49:13.2999159Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:49:13.2999731Z         ^
build	Build and Test	2026-07-19T18:49:13.3000199Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:49:13.3000785Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:49:13.3001938Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:290: error: cannot find symbol
build	Build and Test	2026-07-19T18:49:13.3003097Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:49:13.3003680Z         ^
build	Build and Test	2026-07-19T18:49:13.3004155Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:49:13.3004737Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:49:13.3005837Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:296: error: cannot find symbol
build	Build and Test	2026-07-19T18:49:13.3007156Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:49:13.3007723Z         ^
build	Build and Test	2026-07-19T18:49:13.3008193Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:49:13.3008811Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:49:13.3009368Z 8 errors
build	Build and Test	2026-07-19T18:49:16.9958040Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-19T18:49:16.9959142Z
build	Build and Test	2026-07-19T18:49:16.9963029Z 	 * @param duration
build	Build and Test	2026-07-19T18:49:16.9986963Z 	   ^
build	Build and Test	2026-07-19T18:49:16.9987317Z > Task :client:javadoc
build	Build and Test	2026-07-19T18:49:16.9994536Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-19T18:49:16.9995643Z 	 * @param duration
build	Build and Test	2026-07-19T18:49:17.1974519Z 	public CompletableFuture<Optional<Point>> mapPoint(Point point)
build	Build and Test	2026-07-19T18:49:17.1975196Z 	                                          ^
build	Build and Test	2026-07-19T18:49:17.1976599Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:74: warning: no @param for bounds
build	Build and Test	2026-07-19T18:49:17.1978124Z 	public CompletableFuture<Optional<Rectangle>> mapBounds(Rectangle bounds)
build	Build and Test	2026-07-19T18:49:17.1978880Z 	                                              ^
build	Build and Test	2026-07-19T18:49:17.1980083Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:74: warning: no @return
build	Build and Test	2026-07-19T18:49:17.1988465Z 	public CompletableFuture<Optional<Rectangle>> mapBounds(Rectangle bounds)
build	Build and Test	2026-07-19T18:49:17.1989261Z 	                                              ^
build	Build and Test	2026-07-19T18:49:17.1990521Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:80: warning: no @param for point
build	Build and Test	2026-07-19T18:49:17.1992017Z 	public CompletableFuture<KLiteInteractionResult> clickPoint(Point point)
build	Build and Test	2026-07-19T18:49:17.1992804Z 	                                                 ^
build	Build and Test	2026-07-19T18:49:17.1995078Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:80: warning: no @return
build	Build and Test	2026-07-19T18:49:17.1996665Z 	public CompletableFuture<KLiteInteractionResult> clickPoint(Point point)
build	Build and Test	2026-07-19T18:49:17.1997405Z 	                                                 ^
build	Build and Test	2026-07-19T18:49:17.1998703Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:106: warning: no @param for bounds
build	Build and Test	2026-07-19T18:49:17.2000364Z 	public CompletableFuture<KLiteInteractionResult> clickBounds(Rectangle bounds)
build	Build and Test	2026-07-19T18:49:17.2001134Z 	                                                 ^
build	Build and Test	2026-07-19T18:49:17.2002373Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:106: warning: no @return
build	Build and Test	2026-07-19T18:49:17.2003816Z 	public CompletableFuture<KLiteInteractionResult> clickBounds(Rectangle bounds)
build	Build and Test	2026-07-19T18:49:17.2004572Z 	                                                 ^
build	Build and Test	2026-07-19T18:49:17.3958937Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-19T18:49:17.3987784Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:49:17.4016772Z 	            ^
build	Build and Test	2026-07-19T18:49:17.4047509Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-19T18:49:17.4049302Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:49:17.4057000Z 	            ^
build	Build and Test	2026-07-19T18:49:17.4058498Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-19T18:49:17.4060274Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:49:17.4061171Z 	            ^
build	Build and Test	2026-07-19T18:49:17.4089172Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-19T18:49:17.4091185Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:49:17.4092220Z 	            ^
build	Build and Test	2026-07-19T18:49:17.4093553Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-19T18:49:17.4095457Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:49:17.4096573Z 	            ^
build	Build and Test	2026-07-19T18:49:17.4097831Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-19T18:49:17.4099573Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:49:17.4100560Z 	            ^
build	Build and Test	2026-07-19T18:49:17.4101591Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-19T18:49:17.4103148Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:49:17.4104558Z 	            ^
build	Build and Test	2026-07-19T18:49:17.4105830Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-19T18:49:17.4107826Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:49:17.4108887Z 	            ^
build	Build and Test	2026-07-19T18:49:17.4110421Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-19T18:49:17.4112446Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:49:17.4113705Z 	            ^
build	Build and Test	2026-07-19T18:49:17.4115103Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-19T18:49:17.4116663Z 	 * @param itemId
build	Build and Test	2026-07-19T18:49:17.4117359Z 	   ^
build	Build and Test	2026-07-19T18:49:17.4118534Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-19T18:49:17.4119966Z 	 * @return
build	Build and Test	2026-07-19T18:49:17.4120608Z 	   ^
build	Build and Test	2026-07-19T18:49:17.7229805Z 		public CrypticClue.CrypticClueBuilder solution(final String solution) {
build	Build and Test	2026-07-19T18:49:17.7230369Z 		                                      ^
build	Build and Test	2026-07-19T18:49:17.7231481Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/cluescrolls/clues/CrypticClue.java:353: warning: no @param for questionText
build	Build and Test	2026-07-19T18:49:17.7232861Z 		public CrypticClue.CrypticClueBuilder questionText(@Nullable final String questionText) {
build	Build and Test	2026-07-19T18:49:17.7233738Z 		                                      ^
build	Build and Test	2026-07-19T18:49:17.7234932Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/cluescrolls/clues/CrypticClue.java:361: warning: no @param for answer
build	Build and Test	2026-07-19T18:49:17.7236223Z 		public CrypticClue.CrypticClueBuilder answer(@Nullable final String answer) {
build	Build and Test	2026-07-19T18:49:17.7236962Z 		                                      ^
build	Build and Test	2026-07-19T18:49:17.7238059Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/cluescrolls/clues/CrypticClue.java:369: warning: no @param for requiresLight
build	Build and Test	2026-07-19T18:49:17.7239388Z 		public CrypticClue.CrypticClueBuilder requiresLight(final boolean requiresLight) {
build	Build and Test	2026-07-19T18:49:17.7240004Z 		                                      ^
build	Build and Test	2026-07-19T18:49:17.7952458Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:97: warning: no @return
build	Build and Test	2026-07-19T18:49:17.7954963Z 	public boolean isClearChildren() {
build	Build and Test	2026-07-19T18:49:17.7955590Z 	               ^
build	Build and Test	2026-07-19T18:49:17.7956807Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:104: warning: no @return
build	Build and Test	2026-07-19T18:49:17.7958037Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-19T18:49:17.7958572Z 	               ^
build	Build and Test	2026-07-19T18:49:21.3950927Z 100 warnings
build	Build and Test	2026-07-19T18:49:22.4950586Z
build	Build and Test	2026-07-19T18:49:22.4951562Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784486934216.json
build	Build and Test	2026-07-19T18:49:22.4952427Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-19T18:49:22.4952770Z
build	Build and Test	2026-07-19T18:49:22.4952916Z 63 actionable tasks: 25 executed, 38 from cache
build	Build and Test	2026-07-19T18:49:22.4953452Z * What went wrong:
build	Build and Test	2026-07-19T18:49:22.4954038Z Execution failed for task ':klite-ge-flipper:compileJava'.
build	Build and Test	2026-07-19T18:49:22.4954663Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-19T18:49:22.4955086Z
build	Build and Test	2026-07-19T18:49:22.4955208Z * Try:
build	Build and Test	2026-07-19T18:49:22.4955543Z > Run with --info option to get more log output.
build	Build and Test	2026-07-19T18:49:22.4955983Z > Run with --scan to get full insights.
build	Build and Test	2026-07-19T18:49:22.4956432Z
build	Build and Test	2026-07-19T18:49:22.4956566Z BUILD FAILED in 31s
build	Build and Test	2026-07-19T18:49:23.1435458Z ##[error]Process completed with exit code 1.
```

## CI: Add GE Flipper task source part 02b

- Run: [29699173951](https://github.com/KSPOG/klite/actions/runs/29699173951)
- Conclusion: `failure`
- Event: `push`
- Commit: `7c4d5246d9baefa2d4dee184446cdc200cc66bc7`
- Created: `2026-07-19T18:42:30Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-19T18:43:26.8501809Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-19T18:43:26.8530125Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-19T18:43:26.8530722Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-19T18:43:26.8531242Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-19T18:43:26.8531750Z > Task :runelite-api:build
build	Build and Test	2026-07-19T18:43:28.1475150Z > Task :client:compileJava FROM-CACHE
build	Build and Test	2026-07-19T18:43:28.1512649Z > Task :client:classes
build	Build and Test	2026-07-19T18:43:28.8489510Z > Task :copper-tin-miner:compileJava FROM-CACHE
build	Build and Test	2026-07-19T18:43:28.8560443Z > Task :copper-tin-miner:classes UP-TO-DATE
build	Build and Test	2026-07-19T18:43:28.8590448Z > Task :copper-tin-miner:jar
build	Build and Test	2026-07-19T18:43:28.8611767Z > Task :copper-tin-miner:assemble
build	Build and Test	2026-07-19T18:43:29.1509422Z > Task :copper-tin-miner:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-19T18:43:29.1580287Z > Task :copper-tin-miner:compileTestJava NO-SOURCE
build	Build and Test	2026-07-19T18:43:29.1581164Z > Task :copper-tin-miner:testClasses UP-TO-DATE
build	Build and Test	2026-07-19T18:43:29.1636634Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-19T18:43:29.1643911Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-19T18:43:29.1693835Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-19T18:43:29.1720322Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-19T18:43:29.3520696Z > Task :client:jar
build	Build and Test	2026-07-19T18:43:29.3550124Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-19T18:43:29.7501798Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:34: error: cannot find symbol
build	Build and Test	2026-07-19T18:43:29.7503336Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-19T18:43:29.7503931Z
build	Build and Test	2026-07-19T18:43:29.7504728Z     private KLiteGeFlipperTask task;
build	Build and Test	2026-07-19T18:43:29.7505392Z > Task :klite-ge-flipper:compileJava FAILED
build	Build and Test	2026-07-19T18:43:29.7530259Z             ^
build	Build and Test	2026-07-19T18:43:29.7560256Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:43:29.7580324Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:43:29.7620864Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:54: error: cannot find symbol
build	Build and Test	2026-07-19T18:43:29.7622562Z         task = new KLiteGeFlipperTask(this, webWalker);
build	Build and Test	2026-07-19T18:43:29.7650211Z                    ^
build	Build and Test	2026-07-19T18:43:29.7670329Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:43:29.7693096Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:43:29.7710896Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:266: error: cannot find symbol
build	Build and Test	2026-07-19T18:43:29.7713264Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:43:29.7750104Z         ^
build	Build and Test	2026-07-19T18:43:29.7780383Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:43:29.7795946Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:43:29.7805465Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:272: error: cannot find symbol
build	Build and Test	2026-07-19T18:43:29.7860216Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:43:29.7861521Z         ^
build	Build and Test	2026-07-19T18:43:29.7862031Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:43:29.7862667Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:43:29.7864091Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:278: error: cannot find symbol
build	Build and Test	2026-07-19T18:43:29.7865469Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:43:29.7866054Z         ^
build	Build and Test	2026-07-19T18:43:29.7866498Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:43:29.7867090Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:43:29.7868440Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:284: error: cannot find symbol
build	Build and Test	2026-07-19T18:43:29.7870807Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:43:29.7871384Z         ^
build	Build and Test	2026-07-19T18:43:29.7871818Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:43:29.7872413Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:43:29.7873766Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:290: error: cannot find symbol
build	Build and Test	2026-07-19T18:43:29.7875128Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:43:29.7875691Z         ^
build	Build and Test	2026-07-19T18:43:29.7876122Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:43:29.7876713Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:43:29.7878035Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:296: error: cannot find symbol
build	Build and Test	2026-07-19T18:43:29.7879376Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:43:29.7880168Z         ^
build	Build and Test	2026-07-19T18:43:29.7880611Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:43:29.7881211Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:43:29.7881758Z 8 errors
build	Build and Test	2026-07-19T18:43:36.3482126Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-19T18:43:36.3483753Z
build	Build and Test	2026-07-19T18:43:36.3490448Z > Task :client:javadoc
build	Build and Test	2026-07-19T18:43:36.3497951Z 	 * @param duration
build	Build and Test	2026-07-19T18:43:36.3520735Z 	   ^
build	Build and Test	2026-07-19T18:43:36.3551455Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-19T18:43:36.3560619Z 	 * @param duration
build	Build and Test	2026-07-19T18:43:36.5671575Z 	public CompletableFuture<Optional<Point>> mapPoint(Point point)
build	Build and Test	2026-07-19T18:43:36.5672288Z 	                                          ^
build	Build and Test	2026-07-19T18:43:36.5674355Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:74: warning: no @param for bounds
build	Build and Test	2026-07-19T18:43:36.5676124Z 	public CompletableFuture<Optional<Rectangle>> mapBounds(Rectangle bounds)
build	Build and Test	2026-07-19T18:43:36.5676912Z 	                                              ^
build	Build and Test	2026-07-19T18:43:36.5678310Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:74: warning: no @return
build	Build and Test	2026-07-19T18:43:36.5680194Z 	public CompletableFuture<Optional<Rectangle>> mapBounds(Rectangle bounds)
build	Build and Test	2026-07-19T18:43:36.5680989Z 	                                              ^
build	Build and Test	2026-07-19T18:43:36.5682844Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:80: warning: no @param for point
build	Build and Test	2026-07-19T18:43:36.5684663Z 	public CompletableFuture<KLiteInteractionResult> clickPoint(Point point)
build	Build and Test	2026-07-19T18:43:36.5685546Z 	                                                 ^
build	Build and Test	2026-07-19T18:43:36.5687948Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:80: warning: no @return
build	Build and Test	2026-07-19T18:43:36.5690165Z 	public CompletableFuture<KLiteInteractionResult> clickPoint(Point point)
build	Build and Test	2026-07-19T18:43:36.5691094Z 	                                                 ^
build	Build and Test	2026-07-19T18:43:36.5692734Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:106: warning: no @param for bounds
build	Build and Test	2026-07-19T18:43:36.5694640Z 	public CompletableFuture<KLiteInteractionResult> clickBounds(Rectangle bounds)
build	Build and Test	2026-07-19T18:43:36.5695548Z 	                                                 ^
build	Build and Test	2026-07-19T18:43:36.5697083Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:106: warning: no @return
build	Build and Test	2026-07-19T18:43:36.5698957Z 	public CompletableFuture<KLiteInteractionResult> clickBounds(Rectangle bounds)
build	Build and Test	2026-07-19T18:43:36.5700145Z 	                                                 ^
build	Build and Test	2026-07-19T18:43:36.8478982Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-19T18:43:36.8481746Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:43:36.8510184Z 	            ^
build	Build and Test	2026-07-19T18:43:36.8541472Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-19T18:43:36.8571141Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:43:36.8600063Z 	            ^
build	Build and Test	2026-07-19T18:43:36.8602026Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-19T18:43:36.8630806Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:43:36.8660140Z 	            ^
build	Build and Test	2026-07-19T18:43:36.8691261Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-19T18:43:36.8693751Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:43:36.8720300Z 	            ^
build	Build and Test	2026-07-19T18:43:36.8751467Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-19T18:43:36.8780749Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:43:36.8782137Z 	            ^
build	Build and Test	2026-07-19T18:43:36.8811424Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-19T18:43:36.8840878Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:43:36.8848392Z 	            ^
build	Build and Test	2026-07-19T18:43:36.8850401Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-19T18:43:36.8852677Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:43:36.8854501Z 	            ^
build	Build and Test	2026-07-19T18:43:36.8856668Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-19T18:43:36.8859357Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:43:36.8861260Z 	            ^
build	Build and Test	2026-07-19T18:43:36.8863127Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-19T18:43:36.8865746Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:43:36.8867183Z 	            ^
build	Build and Test	2026-07-19T18:43:36.9543903Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-19T18:43:36.9590497Z 	 * @param itemId
build	Build and Test	2026-07-19T18:43:36.9620344Z 	   ^
build	Build and Test	2026-07-19T18:43:36.9659479Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-19T18:43:36.9661403Z 	 * @return
build	Build and Test	2026-07-19T18:43:36.9662461Z 	   ^
build	Build and Test	2026-07-19T18:43:37.2887359Z 		public CrypticClue.CrypticClueBuilder solution(final String solution) {
build	Build and Test	2026-07-19T18:43:37.2888195Z 		                                      ^
build	Build and Test	2026-07-19T18:43:37.2890091Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/cluescrolls/clues/CrypticClue.java:353: warning: no @param for questionText
build	Build and Test	2026-07-19T18:43:37.2892160Z 		public CrypticClue.CrypticClueBuilder questionText(@Nullable final String questionText) {
build	Build and Test	2026-07-19T18:43:37.2893366Z 		                                      ^
build	Build and Test	2026-07-19T18:43:37.2895239Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/cluescrolls/clues/CrypticClue.java:361: warning: no @param for answer
build	Build and Test	2026-07-19T18:43:37.2897197Z 		public CrypticClue.CrypticClueBuilder answer(@Nullable final String answer) {
build	Build and Test	2026-07-19T18:43:37.2898081Z 		                                      ^
build	Build and Test	2026-07-19T18:43:37.2899987Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/cluescrolls/clues/CrypticClue.java:369: warning: no @param for requiresLight
build	Build and Test	2026-07-19T18:43:37.2902041Z 		public CrypticClue.CrypticClueBuilder requiresLight(final boolean requiresLight) {
build	Build and Test	2026-07-19T18:43:37.2902958Z 		                                      ^
build	Build and Test	2026-07-19T18:43:37.3483247Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:97: warning: no @return
build	Build and Test	2026-07-19T18:43:37.3488833Z 	public boolean isClearChildren() {
build	Build and Test	2026-07-19T18:43:37.3489856Z 	               ^
build	Build and Test	2026-07-19T18:43:37.3491347Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:104: warning: no @return
build	Build and Test	2026-07-19T18:43:37.3492969Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-19T18:43:37.3493629Z 	               ^
build	Build and Test	2026-07-19T18:43:42.3473931Z 100 warnings
build	Build and Test	2026-07-19T18:43:43.6475745Z
build	Build and Test	2026-07-19T18:43:43.6476867Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784486581229.json
build	Build and Test	2026-07-19T18:43:43.6478565Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-19T18:43:43.6479251Z 63 actionable tasks: 25 executed, 38 from cache
build	Build and Test	2026-07-19T18:43:43.6480530Z
build	Build and Test	2026-07-19T18:43:43.6485639Z * What went wrong:
build	Build and Test	2026-07-19T18:43:43.6486500Z Execution failed for task ':klite-ge-flipper:compileJava'.
build	Build and Test	2026-07-19T18:43:43.6487600Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-19T18:43:43.6488393Z
build	Build and Test	2026-07-19T18:43:43.6488752Z * Try:
build	Build and Test	2026-07-19T18:43:43.6489432Z > Run with --info option to get more log output.
build	Build and Test	2026-07-19T18:43:43.6490751Z > Run with --scan to get full insights.
build	Build and Test	2026-07-19T18:43:43.6491338Z
build	Build and Test	2026-07-19T18:43:43.6491707Z BUILD FAILED in 51s
build	Build and Test	2026-07-19T18:43:44.1380510Z ##[error]Process completed with exit code 1.
```

## CI: Publish GE Flipper 0.3.13 with bounded Copilot recovery

- Run: [29698620263](https://github.com/KSPOG/klite/actions/runs/29698620263)
- Conclusion: `failure`
- Event: `pull_request`
- Commit: `f799cdf81190ac2d096b067c7311012b321fb406`
- Created: `2026-07-19T18:23:09Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-19T18:23:58.7372877Z > Task :client:compileJava FROM-CACHE
build	Build and Test	2026-07-19T18:23:58.7397208Z > Task :client:classes
build	Build and Test	2026-07-19T18:23:59.1358905Z > Task :runelite-api:sourcesJar
build	Build and Test	2026-07-19T18:23:59.1366966Z > Task :runelite-api:assemble
build	Build and Test	2026-07-19T18:23:59.1368634Z > Task :runelite-api:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-19T18:23:59.1369843Z > Task :runelite-api:generateTestEffectiveLombokConfig FROM-CACHE
build	Build and Test	2026-07-19T18:23:59.8365894Z > Task :client:jar
build	Build and Test	2026-07-19T18:23:59.8372368Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-19T18:23:59.9362782Z > Task :copper-tin-miner:compileJava FROM-CACHE
build	Build and Test	2026-07-19T18:23:59.9364331Z > Task :copper-tin-miner:classes UP-TO-DATE
build	Build and Test	2026-07-19T18:23:59.9365399Z > Task :copper-tin-miner:jar
build	Build and Test	2026-07-19T18:23:59.9366286Z > Task :copper-tin-miner:assemble
build	Build and Test	2026-07-19T18:24:00.2401056Z > Task :copper-tin-miner:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-19T18:24:00.2462185Z > Task :copper-tin-miner:compileTestJava NO-SOURCE
build	Build and Test	2026-07-19T18:24:00.2464436Z > Task :copper-tin-miner:testClasses UP-TO-DATE
build	Build and Test	2026-07-19T18:24:00.3362256Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-19T18:24:00.3422137Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-19T18:24:00.3442394Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-19T18:24:00.3471766Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-19T18:24:00.5385965Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-19T18:24:00.7432854Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:34: error: cannot find symbol
build	Build and Test	2026-07-19T18:24:00.7434290Z
build	Build and Test	2026-07-19T18:24:00.7492287Z     private KLiteGeFlipperTask task;
build	Build and Test	2026-07-19T18:24:00.7493277Z > Task :klite-ge-flipper:compileJava
build	Build and Test	2026-07-19T18:24:00.7552184Z             ^
build	Build and Test	2026-07-19T18:24:00.7612232Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:24:00.7622987Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:24:00.8373133Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:54: error: cannot find symbol
build	Build and Test	2026-07-19T18:24:00.8421098Z         task = new KLiteGeFlipperTask(this, webWalker);
build	Build and Test	2026-07-19T18:24:00.8474629Z                    ^
build	Build and Test	2026-07-19T18:24:00.8498763Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:24:00.8548251Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:24:00.8576544Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:266: error: cannot find symbol
build	Build and Test	2026-07-19T18:24:00.8624395Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:24:00.8673984Z         ^
build	Build and Test	2026-07-19T18:24:00.8726485Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:24:00.8751276Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:24:00.9366318Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:272: error: cannot find symbol
build	Build and Test	2026-07-19T18:24:00.9403881Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:24:00.9432202Z         ^
build	Build and Test	2026-07-19T18:24:00.9462081Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:24:00.9463364Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:24:00.9492605Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:278: error: cannot find symbol
build	Build and Test	2026-07-19T18:24:00.9494755Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:24:00.9495615Z         ^
build	Build and Test	2026-07-19T18:24:00.9496255Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:24:00.9497618Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:24:00.9499125Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:284: error: cannot find symbol
build	Build and Test	2026-07-19T18:24:00.9500985Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:24:00.9501941Z         ^
build	Build and Test	2026-07-19T18:24:00.9502689Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:24:00.9503619Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:24:00.9505286Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:290: error: cannot find symbol
build	Build and Test	2026-07-19T18:24:00.9506885Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:24:00.9508073Z         ^
build	Build and Test	2026-07-19T18:24:00.9508764Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:24:00.9509619Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:24:00.9511392Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:296: error: cannot find symbol
build	Build and Test	2026-07-19T18:24:00.9512837Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:24:00.9513592Z         ^
build	Build and Test	2026-07-19T18:24:00.9514226Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:24:00.9515038Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:24:01.0365888Z 8 errors
build	Build and Test	2026-07-19T18:24:01.0366310Z
build	Build and Test	2026-07-19T18:24:01.0367299Z > Task :klite-ge-flipper:compileJava FAILED
build	Build and Test	2026-07-19T18:24:01.3372732Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-19T18:24:01.3382078Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-19T18:24:01.3383251Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-19T18:24:01.3384613Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-19T18:24:01.3385603Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-19T18:24:01.3386547Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-19T18:24:01.3387516Z > Task :runelite-api:build
build	Build and Test	2026-07-19T18:24:07.0574681Z 	public CompletableFuture<Optional<Point>> mapPoint(Point point)
build	Build and Test	2026-07-19T18:24:07.0575353Z 	                                          ^
build	Build and Test	2026-07-19T18:24:07.0576737Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:74: warning: no @param for bounds
build	Build and Test	2026-07-19T18:24:07.0578407Z 	public CompletableFuture<Optional<Rectangle>> mapBounds(Rectangle bounds)
build	Build and Test	2026-07-19T18:24:07.0579849Z 	                                              ^
build	Build and Test	2026-07-19T18:24:07.0581455Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:74: warning: no @return
build	Build and Test	2026-07-19T18:24:07.0583025Z 	public CompletableFuture<Optional<Rectangle>> mapBounds(Rectangle bounds)
build	Build and Test	2026-07-19T18:24:07.0583754Z 	                                              ^
build	Build and Test	2026-07-19T18:24:07.0585076Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:80: warning: no @param for point
build	Build and Test	2026-07-19T18:24:07.0586738Z 	public CompletableFuture<KLiteInteractionResult> clickPoint(Point point)
build	Build and Test	2026-07-19T18:24:07.0587735Z 	                                                 ^
build	Build and Test	2026-07-19T18:24:07.0589093Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:80: warning: no @return
build	Build and Test	2026-07-19T18:24:07.0590489Z 	public CompletableFuture<KLiteInteractionResult> clickPoint(Point point)
build	Build and Test	2026-07-19T18:24:07.0591334Z 	                                                 ^
build	Build and Test	2026-07-19T18:24:07.0592765Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:106: warning: no @param for bounds
build	Build and Test	2026-07-19T18:24:07.0594462Z 	public CompletableFuture<KLiteInteractionResult> clickBounds(Rectangle bounds)
build	Build and Test	2026-07-19T18:24:07.0595216Z 	                                                 ^
build	Build and Test	2026-07-19T18:24:07.0596509Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:106: warning: no @return
build	Build and Test	2026-07-19T18:24:07.0598107Z 	public CompletableFuture<KLiteInteractionResult> clickBounds(Rectangle bounds)
build	Build and Test	2026-07-19T18:24:07.0598894Z 	                                                 ^
build	Build and Test	2026-07-19T18:24:07.3372030Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-19T18:24:07.3401093Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:24:07.3431500Z 	            ^
build	Build and Test	2026-07-19T18:24:07.3452796Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-19T18:24:07.3472102Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:24:07.3491560Z 	            ^
build	Build and Test	2026-07-19T18:24:07.3522559Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-19T18:24:07.3552049Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:24:07.3553185Z 	            ^
build	Build and Test	2026-07-19T18:24:07.3554657Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-19T18:24:07.3556694Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:24:07.3557757Z 	            ^
build	Build and Test	2026-07-19T18:24:07.3559133Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-19T18:24:07.3561502Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:24:07.3562908Z 	            ^
build	Build and Test	2026-07-19T18:24:07.3564254Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-19T18:24:07.3566448Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:24:07.3567563Z 	            ^
build	Build and Test	2026-07-19T18:24:07.3568776Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-19T18:24:07.3570749Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:24:07.3572308Z 	            ^
build	Build and Test	2026-07-19T18:24:07.3573735Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-19T18:24:07.3575892Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:24:07.3576990Z 	            ^
build	Build and Test	2026-07-19T18:24:07.3578450Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-19T18:24:07.3580386Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:24:07.3611907Z 	            ^
build	Build and Test	2026-07-19T18:24:07.4359064Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-19T18:24:07.4391772Z 	 * @param itemId
build	Build and Test	2026-07-19T18:24:07.4416736Z 	   ^
build	Build and Test	2026-07-19T18:24:07.4452313Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-19T18:24:07.4481362Z 	 * @return
build	Build and Test	2026-07-19T18:24:07.4482063Z 	   ^
build	Build and Test	2026-07-19T18:24:07.7885568Z 		public CrypticClue.CrypticClueBuilder solution(final String solution) {
build	Build and Test	2026-07-19T18:24:07.7886239Z 		                                      ^
build	Build and Test	2026-07-19T18:24:07.7887670Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/cluescrolls/clues/CrypticClue.java:353: warning: no @param for questionText
build	Build and Test	2026-07-19T18:24:07.7889494Z 		public CrypticClue.CrypticClueBuilder questionText(@Nullable final String questionText) {
build	Build and Test	2026-07-19T18:24:07.7890571Z 		                                      ^
build	Build and Test	2026-07-19T18:24:07.7892234Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/cluescrolls/clues/CrypticClue.java:361: warning: no @param for answer
build	Build and Test	2026-07-19T18:24:07.7893985Z 		public CrypticClue.CrypticClueBuilder answer(@Nullable final String answer) {
build	Build and Test	2026-07-19T18:24:07.7894843Z 		                                      ^
build	Build and Test	2026-07-19T18:24:07.7896356Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/cluescrolls/clues/CrypticClue.java:369: warning: no @param for requiresLight
build	Build and Test	2026-07-19T18:24:07.7898214Z 		public CrypticClue.CrypticClueBuilder requiresLight(final boolean requiresLight) {
build	Build and Test	2026-07-19T18:24:07.7899068Z 		                                      ^
build	Build and Test	2026-07-19T18:24:07.8372934Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:97: warning: no @return
build	Build and Test	2026-07-19T18:24:07.8374499Z 	public boolean isClearChildren() {
build	Build and Test	2026-07-19T18:24:07.8375053Z 	               ^
build	Build and Test	2026-07-19T18:24:07.8376325Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:104: warning: no @return
build	Build and Test	2026-07-19T18:24:07.8377783Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-19T18:24:07.8378325Z 	               ^
build	Build and Test	2026-07-19T18:24:11.7357955Z 100 warnings
build	Build and Test	2026-07-19T18:24:12.9357380Z
build	Build and Test	2026-07-19T18:24:12.9358431Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784485415398.json
build	Build and Test	2026-07-19T18:24:12.9359310Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-19T18:24:12.9359639Z
build	Build and Test	2026-07-19T18:24:12.9360054Z * What went wrong:
build	Build and Test	2026-07-19T18:24:12.9360413Z 63 actionable tasks: 25 executed, 38 from cache
build	Build and Test	2026-07-19T18:24:12.9361163Z Execution failed for task ':klite-ge-flipper:compileJava'.
build	Build and Test	2026-07-19T18:24:12.9361828Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-19T18:24:12.9362120Z
build	Build and Test	2026-07-19T18:24:12.9362235Z * Try:
build	Build and Test	2026-07-19T18:24:12.9362519Z > Run with --info option to get more log output.
build	Build and Test	2026-07-19T18:24:12.9362891Z > Run with --scan to get full insights.
build	Build and Test	2026-07-19T18:24:12.9363107Z
build	Build and Test	2026-07-19T18:24:12.9363220Z BUILD FAILED in 43s
build	Build and Test	2026-07-19T18:24:13.3560022Z ##[error]Process completed with exit code 1.
```

## CI: Reconstruct reviewed GE Flipper sources in CI

- Run: [29698611737](https://github.com/KSPOG/klite/actions/runs/29698611737)
- Conclusion: `failure`
- Event: `push`
- Commit: `f799cdf81190ac2d096b067c7311012b321fb406`
- Created: `2026-07-19T18:22:50Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-19T18:23:39.5554878Z > Task :runelite-api:runtimeJar
build	Build and Test	2026-07-19T18:23:40.1557185Z > Task :client:compileJava FROM-CACHE
build	Build and Test	2026-07-19T18:23:40.1571367Z > Task :client:classes
build	Build and Test	2026-07-19T18:23:40.3565354Z > Task :runelite-api:sourcesJar
build	Build and Test	2026-07-19T18:23:40.3592099Z > Task :runelite-api:assemble
build	Build and Test	2026-07-19T18:23:40.4582477Z > Task :runelite-api:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-19T18:23:40.4583678Z > Task :runelite-api:generateTestEffectiveLombokConfig FROM-CACHE
build	Build and Test	2026-07-19T18:23:41.1555631Z > Task :copper-tin-miner:compileJava FROM-CACHE
build	Build and Test	2026-07-19T18:23:41.1592036Z > Task :copper-tin-miner:classes UP-TO-DATE
build	Build and Test	2026-07-19T18:23:41.1616087Z > Task :copper-tin-miner:jar
build	Build and Test	2026-07-19T18:23:41.1641924Z > Task :copper-tin-miner:assemble
build	Build and Test	2026-07-19T18:23:41.4562860Z > Task :copper-tin-miner:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-19T18:23:41.5572574Z > Task :copper-tin-miner:compileTestJava NO-SOURCE
build	Build and Test	2026-07-19T18:23:41.5591966Z > Task :copper-tin-miner:testClasses UP-TO-DATE
build	Build and Test	2026-07-19T18:23:41.5615264Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-19T18:23:41.5671874Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-19T18:23:41.5691678Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-19T18:23:41.5721534Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-19T18:23:41.6602309Z > Task :client:jar
build	Build and Test	2026-07-19T18:23:41.6661954Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-19T18:23:42.1583808Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:34: error: cannot find symbol
build	Build and Test	2026-07-19T18:23:42.1585107Z
build	Build and Test	2026-07-19T18:23:42.1612012Z     private KLiteGeFlipperTask task;
build	Build and Test	2026-07-19T18:23:42.1612652Z > Task :klite-ge-flipper:compileJava
build	Build and Test	2026-07-19T18:23:42.1672166Z             ^
build	Build and Test	2026-07-19T18:23:42.1742104Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:23:42.1756110Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:23:42.1771495Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:54: error: cannot find symbol
build	Build and Test	2026-07-19T18:23:42.1777321Z         task = new KLiteGeFlipperTask(this, webWalker);
build	Build and Test	2026-07-19T18:23:42.1778074Z                    ^
build	Build and Test	2026-07-19T18:23:42.1778608Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:23:42.1779217Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:23:42.1781714Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:266: error: cannot find symbol
build	Build and Test	2026-07-19T18:23:42.1782536Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:23:42.1782875Z         ^
build	Build and Test	2026-07-19T18:23:42.1783218Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:23:42.1785228Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:23:42.1786411Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:272: error: cannot find symbol
build	Build and Test	2026-07-19T18:23:42.1787633Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:23:42.1788142Z         ^
build	Build and Test	2026-07-19T18:23:42.1788530Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:23:42.1789012Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:23:42.1790071Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:278: error: cannot find symbol
build	Build and Test	2026-07-19T18:23:42.1791312Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:23:42.1791751Z         ^
build	Build and Test	2026-07-19T18:23:42.1792089Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:23:42.1792566Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:23:42.1793616Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:284: error: cannot find symbol
build	Build and Test	2026-07-19T18:23:42.1794703Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:23:42.1795159Z         ^
build	Build and Test	2026-07-19T18:23:42.1795520Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:23:42.1795995Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:23:42.1797054Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:290: error: cannot find symbol
build	Build and Test	2026-07-19T18:23:42.1798239Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:23:42.1798760Z         ^
build	Build and Test	2026-07-19T18:23:42.1799525Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:23:42.1800064Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:23:42.1801613Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:296: error: cannot find symbol
build	Build and Test	2026-07-19T18:23:42.1803046Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:23:42.1803542Z         ^
build	Build and Test	2026-07-19T18:23:42.1803929Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:23:42.1804460Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:23:42.2560900Z 8 errors
build	Build and Test	2026-07-19T18:23:42.2568221Z
build	Build and Test	2026-07-19T18:23:42.2591604Z > Task :klite-ge-flipper:compileJava FAILED
build	Build and Test	2026-07-19T18:23:42.2621427Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-19T18:23:42.3585793Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-19T18:23:42.3611799Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-19T18:23:42.3641568Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-19T18:23:42.3642411Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-19T18:23:42.3671654Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-19T18:23:42.3691796Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-19T18:23:42.3701500Z > Task :runelite-api:build
build	Build and Test	2026-07-19T18:23:42.4555621Z
build	Build and Test	2026-07-19T18:23:42.4556884Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784485395862.json
build	Build and Test	2026-07-19T18:23:42.4557944Z 62 actionable tasks: 24 executed, 38 from cache
build	Build and Test	2026-07-19T18:23:42.4559018Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-19T18:23:42.4559382Z
build	Build and Test	2026-07-19T18:23:42.4559559Z * What went wrong:
build	Build and Test	2026-07-19T18:23:42.4560099Z Execution failed for task ':klite-ge-flipper:compileJava'.
build	Build and Test	2026-07-19T18:23:42.4560882Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-19T18:23:42.4561519Z
build	Build and Test	2026-07-19T18:23:42.4561636Z * Try:
build	Build and Test	2026-07-19T18:23:42.4562005Z > Run with --info option to get more log output.
build	Build and Test	2026-07-19T18:23:42.4562607Z > Run with --scan to get full insights.
build	Build and Test	2026-07-19T18:23:42.4562959Z
build	Build and Test	2026-07-19T18:23:42.4563166Z BUILD FAILED in 33s
build	Build and Test	2026-07-19T18:23:42.9702628Z ##[error]Process completed with exit code 1.
```

## CI: Add GE Flipper overlay

- Run: [29698364961](https://github.com/KSPOG/klite/actions/runs/29698364961)
- Conclusion: `failure`
- Event: `push`
- Commit: `34a88c8493b52d09bdfffb2ec79db196563a82c7`
- Created: `2026-07-19T18:14:24Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-19T18:15:25.8221443Z > Task :client:classes
build	Build and Test	2026-07-19T18:15:25.8222055Z > Task :runelite-api:sourcesJar
build	Build and Test	2026-07-19T18:15:25.8225755Z > Task :runelite-api:assemble
build	Build and Test	2026-07-19T18:15:25.9200740Z > Task :runelite-api:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-19T18:15:25.9229402Z > Task :runelite-api:generateTestEffectiveLombokConfig FROM-CACHE
build	Build and Test	2026-07-19T18:15:27.0235230Z > Task :copper-tin-miner:compileJava FROM-CACHE
build	Build and Test	2026-07-19T18:15:27.0294856Z > Task :copper-tin-miner:classes UP-TO-DATE
build	Build and Test	2026-07-19T18:15:27.0324601Z > Task :copper-tin-miner:jar
build	Build and Test	2026-07-19T18:15:27.1225337Z > Task :copper-tin-miner:assemble
build	Build and Test	2026-07-19T18:15:27.3225470Z > Task :client:jar
build	Build and Test	2026-07-19T18:15:27.3270890Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-19T18:15:27.4218529Z > Task :copper-tin-miner:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-19T18:15:27.4241841Z > Task :copper-tin-miner:compileTestJava NO-SOURCE
build	Build and Test	2026-07-19T18:15:27.4264704Z > Task :copper-tin-miner:testClasses UP-TO-DATE
build	Build and Test	2026-07-19T18:15:27.4290403Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-19T18:15:27.4315228Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-19T18:15:27.4338501Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-19T18:15:27.4362745Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-19T18:15:27.8214913Z
build	Build and Test	2026-07-19T18:15:27.8216322Z > Task :klite-ge-flipper:compileJava
build	Build and Test	2026-07-19T18:15:27.8245952Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:34: error: cannot find symbol
build	Build and Test	2026-07-19T18:15:27.8247652Z     private KLiteGeFlipperTask task;
build	Build and Test	2026-07-19T18:15:27.8248541Z             ^
build	Build and Test	2026-07-19T18:15:27.8249361Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:15:27.8250195Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:15:28.0208173Z
build	Build and Test	2026-07-19T18:15:28.0282232Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-19T18:15:28.0325145Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-19T18:15:28.0355079Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-19T18:15:28.0384881Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-19T18:15:28.1205355Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-19T18:15:28.1234879Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-19T18:15:28.1264632Z > Task :runelite-api:build
build	Build and Test	2026-07-19T18:15:28.2217340Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-19T18:15:28.4226623Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:54: error: cannot find symbol
build	Build and Test	2026-07-19T18:15:28.4228118Z
build	Build and Test	2026-07-19T18:15:28.4228809Z         task = new KLiteGeFlipperTask(this, webWalker);
build	Build and Test	2026-07-19T18:15:28.4229466Z > Task :klite-ge-flipper:compileJava FAILED
build	Build and Test	2026-07-19T18:15:28.4254737Z                    ^
build	Build and Test	2026-07-19T18:15:28.4276725Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:15:28.4298129Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:15:28.4318319Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:266: error: cannot find symbol
build	Build and Test	2026-07-19T18:15:28.4339151Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:15:28.4362545Z         ^
build	Build and Test	2026-07-19T18:15:28.4384152Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:15:28.4424854Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:15:28.4426621Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:272: error: cannot find symbol
build	Build and Test	2026-07-19T18:15:28.4455064Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:15:28.4473570Z         ^
build	Build and Test	2026-07-19T18:15:28.4474557Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:15:28.4504866Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:15:28.4515588Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:278: error: cannot find symbol
build	Build and Test	2026-07-19T18:15:28.4517459Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:15:28.4534990Z         ^
build	Build and Test	2026-07-19T18:15:28.4535640Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:15:28.4536360Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:15:28.4537798Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:284: error: cannot find symbol
build	Build and Test	2026-07-19T18:15:28.4539909Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:15:28.4541060Z         ^
build	Build and Test	2026-07-19T18:15:28.4541809Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:15:28.4542658Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:15:28.4544499Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:290: error: cannot find symbol
build	Build and Test	2026-07-19T18:15:28.4546171Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:15:28.4546987Z         ^
build	Build and Test	2026-07-19T18:15:28.4547638Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:15:28.4548494Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:15:28.4550119Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:296: error: cannot find symbol
build	Build and Test	2026-07-19T18:15:28.4551803Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:15:28.4552658Z         ^
build	Build and Test	2026-07-19T18:15:28.4553435Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:15:28.4554669Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:15:28.4555539Z 8 errors
build	Build and Test	2026-07-19T18:15:36.6206266Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-19T18:15:36.6207707Z
build	Build and Test	2026-07-19T18:15:36.6224809Z > Task :client:javadoc
build	Build and Test	2026-07-19T18:15:36.6254795Z 	 * @param duration
build	Build and Test	2026-07-19T18:15:36.6259768Z 	   ^
build	Build and Test	2026-07-19T18:15:36.6270970Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-19T18:15:36.6280150Z 	 * @param duration
build	Build and Test	2026-07-19T18:15:36.8225102Z 	public CompletableFuture<Optional<Point>> mapPoint(Point point)
build	Build and Test	2026-07-19T18:15:36.8243052Z 	                                          ^
build	Build and Test	2026-07-19T18:15:36.8245156Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:74: warning: no @param for bounds
build	Build and Test	2026-07-19T18:15:36.8247279Z 	public CompletableFuture<Optional<Rectangle>> mapBounds(Rectangle bounds)
build	Build and Test	2026-07-19T18:15:36.8248321Z 	                                              ^
build	Build and Test	2026-07-19T18:15:36.8249980Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:74: warning: no @return
build	Build and Test	2026-07-19T18:15:36.8251925Z 	public CompletableFuture<Optional<Rectangle>> mapBounds(Rectangle bounds)
build	Build and Test	2026-07-19T18:15:36.8252934Z 	                                              ^
build	Build and Test	2026-07-19T18:15:36.8254838Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:80: warning: no @param for point
build	Build and Test	2026-07-19T18:15:36.8256831Z 	public CompletableFuture<KLiteInteractionResult> clickPoint(Point point)
build	Build and Test	2026-07-19T18:15:36.8258290Z 	                                                 ^
build	Build and Test	2026-07-19T18:15:36.8260007Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:80: warning: no @return
build	Build and Test	2026-07-19T18:15:36.8262157Z 	public CompletableFuture<KLiteInteractionResult> clickPoint(Point point)
build	Build and Test	2026-07-19T18:15:36.8263209Z 	                                                 ^
build	Build and Test	2026-07-19T18:15:36.8265203Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:106: warning: no @param for bounds
build	Build and Test	2026-07-19T18:15:36.8267282Z 	public CompletableFuture<KLiteInteractionResult> clickBounds(Rectangle bounds)
build	Build and Test	2026-07-19T18:15:36.8268372Z 	                                                 ^
build	Build and Test	2026-07-19T18:15:36.8270054Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/klite/api/KLiteCanvasInput.java:106: warning: no @return
build	Build and Test	2026-07-19T18:15:36.8272027Z 	public CompletableFuture<KLiteInteractionResult> clickBounds(Rectangle bounds)
build	Build and Test	2026-07-19T18:15:36.8273094Z 	                                                 ^
build	Build and Test	2026-07-19T18:15:37.1207947Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-19T18:15:37.1210753Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:15:37.1212080Z 	            ^
build	Build and Test	2026-07-19T18:15:37.1213910Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-19T18:15:37.1216707Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:15:37.1218075Z 	            ^
build	Build and Test	2026-07-19T18:15:37.1219857Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-19T18:15:37.1222394Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:15:37.1223685Z 	            ^
build	Build and Test	2026-07-19T18:15:37.1225408Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-19T18:15:37.1227693Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:15:37.1229067Z 	            ^
build	Build and Test	2026-07-19T18:15:37.1230790Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-19T18:15:37.1233390Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:15:37.1235080Z 	            ^
build	Build and Test	2026-07-19T18:15:37.1236829Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-19T18:15:37.1239400Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:15:37.1240823Z 	            ^
build	Build and Test	2026-07-19T18:15:37.1242383Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-19T18:15:37.1246212Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:15:37.1250449Z 	            ^
build	Build and Test	2026-07-19T18:15:37.1253484Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-19T18:15:37.1256654Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:15:37.1258255Z 	            ^
build	Build and Test	2026-07-19T18:15:37.1260190Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-19T18:15:37.1263159Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-19T18:15:37.1265233Z 	            ^
build	Build and Test	2026-07-19T18:15:37.1267255Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-19T18:15:37.1290314Z 	 * @param itemId
build	Build and Test	2026-07-19T18:15:37.1291029Z 	   ^
build	Build and Test	2026-07-19T18:15:37.1292660Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-19T18:15:37.1294753Z 	 * @return
build	Build and Test	2026-07-19T18:15:37.1295384Z 	   ^
build	Build and Test	2026-07-19T18:15:37.5357808Z 		public CrypticClue.CrypticClueBuilder solution(final String solution) {
build	Build and Test	2026-07-19T18:15:37.5358777Z 		                                      ^
build	Build and Test	2026-07-19T18:15:37.5360592Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/cluescrolls/clues/CrypticClue.java:353: warning: no @param for questionText
build	Build and Test	2026-07-19T18:15:37.5362712Z 		public CrypticClue.CrypticClueBuilder questionText(@Nullable final String questionText) {
build	Build and Test	2026-07-19T18:15:37.5364225Z 		                                      ^
build	Build and Test	2026-07-19T18:15:37.5365965Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/cluescrolls/clues/CrypticClue.java:361: warning: no @param for answer
build	Build and Test	2026-07-19T18:15:37.5368386Z 		public CrypticClue.CrypticClueBuilder answer(@Nullable final String answer) {
build	Build and Test	2026-07-19T18:15:37.5375251Z 		                                      ^
build	Build and Test	2026-07-19T18:15:37.5377100Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/cluescrolls/clues/CrypticClue.java:369: warning: no @param for requiresLight
build	Build and Test	2026-07-19T18:15:37.5379287Z 		public CrypticClue.CrypticClueBuilder requiresLight(final boolean requiresLight) {
build	Build and Test	2026-07-19T18:15:37.5380346Z 		                                      ^
build	Build and Test	2026-07-19T18:15:37.6226897Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:97: warning: no @return
build	Build and Test	2026-07-19T18:15:37.6229934Z 	public boolean isClearChildren() {
build	Build and Test	2026-07-19T18:15:37.6230801Z 	               ^
build	Build and Test	2026-07-19T18:15:37.6232349Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:104: warning: no @return
build	Build and Test	2026-07-19T18:15:37.6234335Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-19T18:15:37.6235124Z 	               ^
build	Build and Test	2026-07-19T18:15:43.0196801Z 100 warnings
build	Build and Test	2026-07-19T18:15:44.3196284Z
build	Build and Test	2026-07-19T18:15:44.3197415Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784484893365.json
build	Build and Test	2026-07-19T18:15:44.3198565Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-19T18:15:44.3198974Z
build	Build and Test	2026-07-19T18:15:44.3199169Z * What went wrong:
build	Build and Test	2026-07-19T18:15:44.3199741Z Execution failed for task ':klite-ge-flipper:compileJava'.
build	Build and Test	2026-07-19T18:15:44.3200558Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-19T18:15:44.3201105Z
build	Build and Test	2026-07-19T18:15:44.3201267Z * Try:
build	Build and Test	2026-07-19T18:15:44.3201716Z > Run with --info option to get more log output.
build	Build and Test	2026-07-19T18:15:44.3202328Z > Run with --scan to get full insights.
build	Build and Test	2026-07-19T18:15:44.3202700Z
build	Build and Test	2026-07-19T18:15:44.3202878Z BUILD FAILED in 1m 4s
build	Build and Test	2026-07-19T18:15:44.3236095Z 63 actionable tasks: 25 executed, 38 from cache
build	Build and Test	2026-07-19T18:15:44.7583887Z ##[error]Process completed with exit code 1.
```

## CI: Add GE Flipper plugin entrypoint

- Run: [29698350334](https://github.com/KSPOG/klite/actions/runs/29698350334)
- Conclusion: `failure`
- Event: `push`
- Commit: `11b011a1cd5551512bf70f1a078b69fc83031d28`
- Created: `2026-07-19T18:13:52Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-19T18:14:52.2743198Z > Task :copper-tin-miner:classes UP-TO-DATE
build	Build and Test	2026-07-19T18:14:52.2775577Z > Task :copper-tin-miner:jar
build	Build and Test	2026-07-19T18:14:52.2799122Z > Task :copper-tin-miner:assemble
build	Build and Test	2026-07-19T18:14:52.6705920Z > Task :copper-tin-miner:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-19T18:14:52.6717979Z > Task :copper-tin-miner:compileTestJava NO-SOURCE
build	Build and Test	2026-07-19T18:14:52.6745127Z > Task :copper-tin-miner:testClasses UP-TO-DATE
build	Build and Test	2026-07-19T18:14:52.6775358Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-19T18:14:52.6793026Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-19T18:14:52.6814985Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-19T18:14:52.6834999Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-19T18:14:52.6855207Z > Task :client:jar
build	Build and Test	2026-07-19T18:14:52.6875049Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-19T18:14:52.7708327Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-19T18:14:52.7735459Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-19T18:14:52.7753876Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-19T18:14:52.7765431Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-19T18:14:52.8687375Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-19T18:14:52.8693335Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-19T18:14:52.8695046Z > Task :runelite-api:build
build	Build and Test	2026-07-19T18:14:53.0678967Z
build	Build and Test	2026-07-19T18:14:53.0686209Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:34: error: cannot find symbol
build	Build and Test	2026-07-19T18:14:53.0687699Z     private KLiteGeFlipperTask task;
build	Build and Test	2026-07-19T18:14:53.0735270Z             ^
build	Build and Test	2026-07-19T18:14:53.0735832Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:14:53.0736497Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:14:53.0737934Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:35: error: cannot find symbol
build	Build and Test	2026-07-19T18:14:53.0739345Z     private KLiteGeFlipperOverlay overlay;
build	Build and Test	2026-07-19T18:14:53.0739946Z             ^
build	Build and Test	2026-07-19T18:14:53.0740424Z   symbol:   class KLiteGeFlipperOverlay
build	Build and Test	2026-07-19T18:14:53.0741053Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:14:53.0742413Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:47: error: cannot find symbol
build	Build and Test	2026-07-19T18:14:53.0743829Z         overlay = new KLiteGeFlipperOverlay(this);
build	Build and Test	2026-07-19T18:14:53.0744694Z                       ^
build	Build and Test	2026-07-19T18:14:53.0745215Z   symbol:   class KLiteGeFlipperOverlay
build	Build and Test	2026-07-19T18:14:53.0745854Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:14:53.0747212Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:54: error: cannot find symbol
build	Build and Test	2026-07-19T18:14:53.0748651Z         task = new KLiteGeFlipperTask(this, webWalker);
build	Build and Test	2026-07-19T18:14:53.0749279Z                    ^
build	Build and Test	2026-07-19T18:14:53.0749774Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:14:53.0750366Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:14:53.0750986Z > Task :klite-ge-flipper:compileJava FAILED
build	Build and Test	2026-07-19T18:14:53.0752400Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:266: error: cannot find symbol
build	Build and Test	2026-07-19T18:14:53.0763501Z
build	Build and Test	2026-07-19T18:14:53.0784985Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:14:53.0805111Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-19T18:14:53.0815130Z         ^
build	Build and Test	2026-07-19T18:14:53.0845073Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:14:53.0865310Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:14:53.0876015Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:272: error: cannot find symbol
build	Build and Test	2026-07-19T18:14:53.0879950Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:14:53.0881232Z         ^
build	Build and Test	2026-07-19T18:14:53.0881860Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:14:53.0882678Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:14:53.0884178Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:278: error: cannot find symbol
build	Build and Test	2026-07-19T18:14:53.0885962Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:14:53.0886734Z         ^
build	Build and Test	2026-07-19T18:14:53.0887693Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:14:53.0888456Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:14:53.0892961Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:284: error: cannot find symbol
build	Build and Test	2026-07-19T18:14:53.0894887Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:14:53.0895683Z         ^
build	Build and Test	2026-07-19T18:14:53.0896376Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:14:53.0897197Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:14:53.0898666Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:290: error: cannot find symbol
build	Build and Test	2026-07-19T18:14:53.0900102Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:14:53.0900839Z         ^
build	Build and Test	2026-07-19T18:14:53.0901441Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:14:53.0902193Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:14:53.0903624Z /home/runner/work/klite/klite/plugins/klite-ge-flipper/src/main/java/com/kspog/klite/geflipper/KLiteGeFlipperPlugin.java:296: error: cannot find symbol
build	Build and Test	2026-07-19T18:14:53.0905721Z         KLiteGeFlipperTask current = task;
build	Build and Test	2026-07-19T18:14:53.0906432Z         ^
build	Build and Test	2026-07-19T18:14:53.0907042Z   symbol:   class KLiteGeFlipperTask
build	Build and Test	2026-07-19T18:14:53.0907796Z   location: class KLiteGeFlipperPlugin
build	Build and Test	2026-07-19T18:14:53.0908530Z 10 errors
build	Build and Test	2026-07-19T18:14:53.1679942Z
build	Build and Test	2026-07-19T18:14:53.1681482Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784484865139.json
build	Build and Test	2026-07-19T18:14:53.1682849Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-19T18:14:53.1683483Z 62 actionable tasks: 24 executed, 38 from cache
build	Build and Test	2026-07-19T18:14:53.1684181Z
build	Build and Test	2026-07-19T18:14:53.1684959Z * What went wrong:
build	Build and Test	2026-07-19T18:14:53.1685785Z Execution failed for task ':klite-ge-flipper:compileJava'.
build	Build and Test	2026-07-19T18:14:53.1686885Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-19T18:14:53.1687601Z
build	Build and Test	2026-07-19T18:14:53.1687938Z * Try:
build	Build and Test	2026-07-19T18:14:53.1688579Z > Run with --info option to get more log output.
build	Build and Test	2026-07-19T18:14:53.1689426Z > Run with --scan to get full insights.
build	Build and Test	2026-07-19T18:14:53.1689988Z
build	Build and Test	2026-07-19T18:14:53.1690353Z BUILD FAILED in 36s
build	Build and Test	2026-07-19T18:14:53.6256545Z ##[error]Process completed with exit code 1.
```

