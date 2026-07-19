# Recent GitHub Actions failures

Generated: 2026-07-19T18:15:15.211717+00:00
Repository: `KSPOG/klite`
Failed runs inspected: **1**

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

