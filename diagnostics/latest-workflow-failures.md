# Recent GitHub Actions failures

Generated: 2026-07-19T18:24:01.668760+00:00
Repository: `KSPOG/klite`
Failed runs inspected: **3**

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

