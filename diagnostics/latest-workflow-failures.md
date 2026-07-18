# Recent GitHub Actions failures

Generated: 2026-07-18T02:00:38.848840+00:00
Repository: `KSPOG/klite`
Failed runs inspected: **15**

## Install release preview homepage: Install the approved KLite release preview

- Run: [29626244343](https://github.com/KSPOG/klite/actions/runs/29626244343)
- Conclusion: `failure`
- Event: `push`
- Commit: `a182ae7651b304c7b4344377036b7010bdc23f2f`
- Created: `2026-07-18T02:00:01Z`

### Failed jobs and steps

- **install** — `failure`
  - Step 4: **Verify generated homepage** — `failure`

### Relevant log context

```text
install	Verify generated homepage	﻿2026-07-18T02:00:12.7442379Z ##[group]Run grep -Fq '/release-preview.css?v=3' marketplace-site/public/index.html
install	Verify generated homepage	2026-07-18T02:00:12.7443115Z ^[[36;1mgrep -Fq '/release-preview.css?v=3' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T02:00:12.7443740Z ^[[36;1mgrep -Fq '/obsidian-release.css?v=1' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T02:00:12.7444403Z ^[[36;1mgrep -Fq '/homepage-featured.js?v=1' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T02:00:12.7445080Z ^[[36;1mgrep -Fq 'class="release-wordmark">KLite</h1>' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T02:00:12.7445715Z ^[[36;1mgrep -Fq 'class="client-window"' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T02:00:12.7446346Z ^[[36;1mgrep -Fq 'id="featured-plugin-list"' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T02:00:12.7446928Z ^[[36;1m! grep -Fq 'GPU Plugin' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T02:00:12.7447488Z ^[[36;1m! grep -Fq 'class="landing-hero"' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T02:00:12.7484401Z shell: /usr/bin/bash -e {0}
install	Verify generated homepage	2026-07-18T02:00:12.7484970Z ##[endgroup]
install	Verify generated homepage	2026-07-18T02:00:12.7571260Z ##[error]Process completed with exit code 1.
```

## Install release preview homepage: Install the approved KLite release preview

- Run: [29626236108](https://github.com/KSPOG/klite/actions/runs/29626236108)
- Conclusion: `failure`
- Event: `push`
- Commit: `5485e23182cc08207584496ec0c866720dca20b2`
- Created: `2026-07-18T01:59:44Z`

### Failed jobs and steps

- **install** — `failure`
  - Step 4: **Verify generated homepage** — `failure`

### Relevant log context

```text
install	Verify generated homepage	﻿2026-07-18T01:59:55.2023248Z ##[group]Run grep -Fq '/release-preview.css?v=3' marketplace-site/public/index.html
install	Verify generated homepage	2026-07-18T01:59:55.2025316Z ^[[36;1mgrep -Fq '/release-preview.css?v=3' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T01:59:55.2027347Z ^[[36;1mgrep -Fq '/obsidian-release.css?v=1' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T01:59:55.2029364Z ^[[36;1mgrep -Fq '/homepage-featured.js?v=1' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T01:59:55.2031612Z ^[[36;1mgrep -Fq 'class="release-wordmark">KLite</h1>' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T01:59:55.2033742Z ^[[36;1mgrep -Fq 'class="client-window"' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T01:59:55.2035716Z ^[[36;1mgrep -Fq 'id="featured-plugin-list"' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T01:59:55.2037599Z ^[[36;1m! grep -Fq 'GPU Plugin' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T01:59:55.2039323Z ^[[36;1m! grep -Fq 'class="landing-hero"' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T01:59:55.2072092Z shell: /usr/bin/bash -e {0}
install	Verify generated homepage	2026-07-18T01:59:55.2073225Z ##[endgroup]
install	Verify generated homepage	2026-07-18T01:59:55.2159313Z ##[error]Process completed with exit code 1.
```

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29626228894](https://github.com/KSPOG/klite/actions/runs/29626228894)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `2c020dbb3d71aa8acc3ab26230ce5978ab0e89a9`
- Created: `2026-07-18T01:59:29Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 3: **Collect recent failure details** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29626216102](https://github.com/KSPOG/klite/actions/runs/29626216102)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `2eec27e7fc673e16baaa0f77302ae663f885e7e3`
- Created: `2026-07-18T01:59:04Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 3: **Collect recent failure details** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## CI: Apply authentic obsidian release styling

- Run: [29626190445](https://github.com/KSPOG/klite/actions/runs/29626190445)
- Conclusion: `failure`
- Event: `push`
- Commit: `2eec27e7fc673e16baaa0f77302ae663f885e7e3`
- Created: `2026-07-18T01:58:09Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T01:58:51.6385540Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T01:58:51.6428434Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T01:58:52.1393488Z > Task :client:jar
build	Build and Test	2026-07-18T01:58:52.1398535Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T01:58:52.3391516Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:58:52.3392930Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T01:58:52.3393814Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T01:58:52.3394640Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T01:58:52.3395478Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T01:58:52.3396215Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T01:58:52.3396949Z > Task :runelite-api:build
build	Build and Test	2026-07-18T01:58:52.4380965Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T01:58:59.0386168Z
build	Build and Test	2026-07-18T01:58:59.0387099Z > Task :client:javadoc
build	Build and Test	2026-07-18T01:58:59.0389293Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T01:58:59.0390880Z 	 * @param duration
build	Build and Test	2026-07-18T01:58:59.0391335Z 	   ^
build	Build and Test	2026-07-18T01:58:59.0392767Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T01:58:59.0394417Z 	 * @param duration
build	Build and Test	2026-07-18T01:58:59.0394867Z 	   ^
build	Build and Test	2026-07-18T01:58:59.4410055Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:58:59.4459245Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:59.4460622Z 	            ^
build	Build and Test	2026-07-18T01:58:59.4493362Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:58:59.4518927Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:59.4520097Z 	            ^
build	Build and Test	2026-07-18T01:58:59.4521815Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:58:59.4524189Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:59.4525342Z 	            ^
build	Build and Test	2026-07-18T01:58:59.4526822Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:58:59.4529347Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:59.4530475Z 	            ^
build	Build and Test	2026-07-18T01:58:59.4532346Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:58:59.4535594Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:59.4558525Z 	            ^
build	Build and Test	2026-07-18T01:58:59.4570743Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:58:59.4573339Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:59.4574787Z 	            ^
build	Build and Test	2026-07-18T01:58:59.4576373Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:58:59.4578959Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:59.4580352Z 	            ^
build	Build and Test	2026-07-18T01:58:59.4582160Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:58:59.4584788Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:59.4586186Z 	            ^
build	Build and Test	2026-07-18T01:58:59.4588277Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:58:59.4590984Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:59.4618463Z 	            ^
build	Build and Test	2026-07-18T01:58:59.5433964Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T01:58:59.5488355Z 	 * @param itemId
build	Build and Test	2026-07-18T01:58:59.5488939Z 	   ^
build	Build and Test	2026-07-18T01:58:59.5529559Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T01:58:59.5558419Z 	 * @return
build	Build and Test	2026-07-18T01:58:59.5558946Z 	   ^
build	Build and Test	2026-07-18T01:59:00.0455046Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T01:59:00.0455756Z 	               ^
build	Build and Test	2026-07-18T01:59:00.0457303Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T01:59:00.0459272Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T01:59:00.0460044Z 	             ^
build	Build and Test	2026-07-18T01:59:00.0461708Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T01:59:00.0463694Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T01:59:00.0464623Z 	            ^
build	Build and Test	2026-07-18T01:59:00.0466267Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T01:59:00.0473738Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T01:59:00.0474704Z 	            ^
build	Build and Test	2026-07-18T01:59:00.0476394Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T01:59:00.0478742Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T01:59:00.0480398Z 	            ^
build	Build and Test	2026-07-18T01:59:00.0482097Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T01:59:00.0483965Z 	public void select(Color color) {
build	Build and Test	2026-07-18T01:59:00.0484718Z 	            ^
build	Build and Test	2026-07-18T01:59:00.1383138Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T01:59:00.1399195Z 	 * @param dimmed
build	Build and Test	2026-07-18T01:59:00.1399956Z 	   ^
build	Build and Test	2026-07-18T01:59:00.1401612Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T01:59:00.1403619Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:59:00.1404519Z 	            ^
build	Build and Test	2026-07-18T01:59:00.1406197Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T01:59:00.1408365Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:59:00.1409115Z 	            ^
build	Build and Test	2026-07-18T01:59:00.2382042Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T01:59:00.2386007Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T01:59:00.2387157Z 		                                          ^
build	Build and Test	2026-07-18T01:59:04.5380040Z 100 warnings
build	Build and Test	2026-07-18T01:59:06.9380459Z
build	Build and Test	2026-07-18T01:59:06.9381331Z > Task :client:javadocJar
build	Build and Test	2026-07-18T01:59:06.9382257Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T01:59:11.5381420Z > Task :client:shadowJar
build	Build and Test	2026-07-18T01:59:11.5382662Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T01:59:11.5383585Z > Task :client:assemble
build	Build and Test	2026-07-18T01:59:11.9388928Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:59:11.9419045Z > Task :client:testClasses
build	Build and Test	2026-07-18T01:59:12.2432085Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T01:59:31.6399921Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T01:59:36.9390066Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T01:59:41.5380353Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T01:59:42.0398540Z > Task :client:pmdMain
build	Build and Test	2026-07-18T01:59:42.2380926Z > Task :client:test
build	Build and Test	2026-07-18T01:59:43.7388115Z
build	Build and Test	2026-07-18T01:59:43.7435784Z /tmp/junit11437552094463446864/junit3358380902139930863/vert.glsl.vert
build	Build and Test	2026-07-18T01:59:43.7569006Z /tmp/junit11437552094463446864/junit3358380902139930863/frag.glsl.frag
build	Build and Test	2026-07-18T01:59:43.9418930Z /tmp/junit11437552094463446864/junit7786974085606018280/vertui.glsl.vert
build	Build and Test	2026-07-18T01:59:43.9538964Z /tmp/junit11437552094463446864/junit7786974085606018280/fragui.glsl.frag
build	Build and Test	2026-07-18T01:59:47.1411758Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T01:59:47.3440017Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T01:59:47.5390275Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T01:59:47.5450180Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T01:59:53.7388081Z
build	Build and Test	2026-07-18T01:59:53.7442312Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T01:59:59.1381839Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784339918046.json
build	Build and Test	2026-07-18T01:59:59.1385464Z
build	Build and Test	2026-07-18T01:59:59.1387001Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T01:59:59.1398750Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T01:59:59.1399367Z
build	Build and Test	2026-07-18T01:59:59.1399724Z * What went wrong:
build	Build and Test	2026-07-18T01:59:59.1400430Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T01:59:59.1401601Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T01:59:59.1403308Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T01:59:59.1404476Z
build	Build and Test	2026-07-18T01:59:59.1404796Z * Try:
build	Build and Test	2026-07-18T01:59:59.1405490Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T01:59:59.1405925Z
build	Build and Test	2026-07-18T01:59:59.1406137Z BUILD FAILED in 1m 28s
build	Build and Test	2026-07-18T01:59:59.6790752Z ##[error]Process completed with exit code 1.
```

## CI: Add obsidian fracture background artwork

- Run: [29626172779](https://github.com/KSPOG/klite/actions/runs/29626172779)
- Conclusion: `failure`
- Event: `push`
- Commit: `6101960a049537e27a923f7dbaa15b532c2636a9`
- Created: `2026-07-18T01:57:33Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T01:58:13.4472684Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T01:58:13.4505525Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T01:58:13.8366263Z > Task :client:jar
build	Build and Test	2026-07-18T01:58:13.8366893Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T01:58:14.1366188Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:58:14.1395718Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T01:58:14.1396725Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T01:58:14.2370637Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T01:58:14.2395868Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T01:58:14.2425563Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T01:58:14.2445396Z > Task :runelite-api:build
build	Build and Test	2026-07-18T01:58:14.3346077Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T01:58:20.3375256Z
build	Build and Test	2026-07-18T01:58:20.3384104Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T01:58:20.3395717Z 	 * @param duration
build	Build and Test	2026-07-18T01:58:20.3396241Z > Task :client:javadoc
build	Build and Test	2026-07-18T01:58:20.3425804Z 	   ^
build	Build and Test	2026-07-18T01:58:20.3427448Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T01:58:20.3429227Z 	 * @param duration
build	Build and Test	2026-07-18T01:58:20.3429824Z 	   ^
build	Build and Test	2026-07-18T01:58:20.8346445Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:58:20.8391207Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:20.8414497Z 	            ^
build	Build and Test	2026-07-18T01:58:20.8446754Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:58:20.8476042Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:20.8477406Z 	            ^
build	Build and Test	2026-07-18T01:58:20.8506846Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:58:20.8536228Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:20.8565590Z 	            ^
build	Build and Test	2026-07-18T01:58:20.8596422Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:58:20.8598935Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:20.8650871Z 	            ^
build	Build and Test	2026-07-18T01:58:20.8727086Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:58:20.8758194Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:20.8788897Z 	            ^
build	Build and Test	2026-07-18T01:58:20.8816773Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:58:20.8819993Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:20.8821403Z 	            ^
build	Build and Test	2026-07-18T01:58:20.8823039Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:58:20.8825734Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:20.8827259Z 	            ^
build	Build and Test	2026-07-18T01:58:20.8829098Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:58:20.8831761Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:20.8833537Z 	            ^
build	Build and Test	2026-07-18T01:58:20.8835512Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:58:20.8838153Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:58:20.8839511Z 	            ^
build	Build and Test	2026-07-18T01:58:20.8841074Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T01:58:20.8842874Z 	 * @param itemId
build	Build and Test	2026-07-18T01:58:20.8843512Z 	   ^
build	Build and Test	2026-07-18T01:58:20.8845318Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T01:58:20.8847158Z 	 * @return
build	Build and Test	2026-07-18T01:58:20.8847765Z 	   ^
build	Build and Test	2026-07-18T01:58:21.3428596Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T01:58:21.3429347Z 	               ^
build	Build and Test	2026-07-18T01:58:21.3430911Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T01:58:21.3432564Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T01:58:21.3433278Z 	             ^
build	Build and Test	2026-07-18T01:58:21.3435109Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T01:58:21.3437084Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T01:58:21.3438069Z 	            ^
build	Build and Test	2026-07-18T01:58:21.3439724Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T01:58:21.3444297Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T01:58:21.3475702Z 	            ^
build	Build and Test	2026-07-18T01:58:21.3494213Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T01:58:21.3496503Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T01:58:21.3497429Z 	            ^
build	Build and Test	2026-07-18T01:58:21.3499029Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T01:58:21.3500943Z 	public void select(Color color) {
build	Build and Test	2026-07-18T01:58:21.3501745Z 	            ^
build	Build and Test	2026-07-18T01:58:21.4350875Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T01:58:21.4360227Z 	 * @param dimmed
build	Build and Test	2026-07-18T01:58:21.4361090Z 	   ^
build	Build and Test	2026-07-18T01:58:21.4362781Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T01:58:21.4364769Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:58:21.4366009Z 	            ^
build	Build and Test	2026-07-18T01:58:21.4369978Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T01:58:21.4372099Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:58:21.4373029Z 	            ^
build	Build and Test	2026-07-18T01:58:21.5367185Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T01:58:21.5369364Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T01:58:21.5378032Z 		                                          ^
build	Build and Test	2026-07-18T01:58:25.6344304Z 100 warnings
build	Build and Test	2026-07-18T01:58:28.0344353Z
build	Build and Test	2026-07-18T01:58:28.0345503Z > Task :client:javadocJar
build	Build and Test	2026-07-18T01:58:28.0346327Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T01:58:32.7370292Z > Task :client:shadowJar
build	Build and Test	2026-07-18T01:58:32.7389313Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T01:58:32.7395770Z > Task :client:assemble
build	Build and Test	2026-07-18T01:58:33.0379606Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:58:33.0395695Z > Task :client:testClasses
build	Build and Test	2026-07-18T01:58:33.2366108Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T01:58:52.0366017Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T01:58:56.4447027Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T01:59:02.1372891Z /tmp/junit6600105109584189800/junit6987792290711066786/vert.glsl.vert
build	Build and Test	2026-07-18T01:59:02.1420106Z /tmp/junit6600105109584189800/junit6987792290711066786/frag.glsl.frag
build	Build and Test	2026-07-18T01:59:02.3345719Z /tmp/junit6600105109584189800/junit3960614600824316411/vertui.glsl.vert
build	Build and Test	2026-07-18T01:59:02.3375661Z /tmp/junit6600105109584189800/junit3960614600824316411/fragui.glsl.frag
build	Build and Test	2026-07-18T01:59:02.7385973Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T01:59:03.1349777Z > Task :client:pmdMain
build	Build and Test	2026-07-18T01:59:03.2365945Z > Task :client:test
build	Build and Test	2026-07-18T01:59:06.5385479Z
build	Build and Test	2026-07-18T01:59:06.5436135Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T01:59:06.8366957Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T01:59:07.0348089Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T01:59:07.0417617Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T01:59:12.8368258Z
build	Build and Test	2026-07-18T01:59:12.8425816Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T01:59:17.9348069Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784339881265.json
build	Build and Test	2026-07-18T01:59:17.9349320Z
build	Build and Test	2026-07-18T01:59:17.9367235Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T01:59:17.9395761Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T01:59:17.9396710Z
build	Build and Test	2026-07-18T01:59:17.9404662Z * What went wrong:
build	Build and Test	2026-07-18T01:59:17.9405669Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T01:59:17.9406627Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T01:59:17.9408124Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T01:59:17.9408931Z
build	Build and Test	2026-07-18T01:59:17.9409076Z * Try:
build	Build and Test	2026-07-18T01:59:17.9409450Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T01:59:17.9409801Z
build	Build and Test	2026-07-18T01:59:17.9409986Z BUILD FAILED in 1m 24s
build	Build and Test	2026-07-18T01:59:18.4906600Z ##[error]Process completed with exit code 1.
```

## CI: Serialize release-preview homepage generation

- Run: [29626159892](https://github.com/KSPOG/klite/actions/runs/29626159892)
- Conclusion: `failure`
- Event: `push`
- Commit: `2e7b9bc9e22dbf755cc23ab24493ccd92fc822e1`
- Created: `2026-07-18T01:57:06Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T01:57:50.2912520Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T01:57:50.2913501Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T01:57:50.3785756Z > Task :client:jar
build	Build and Test	2026-07-18T01:57:50.3834007Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T01:57:50.6765861Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T01:57:50.7785938Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:57:50.7805251Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T01:57:50.7825184Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T01:57:50.8759299Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T01:57:50.8768411Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T01:57:50.8769242Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T01:57:50.8770146Z > Task :runelite-api:build
build	Build and Test	2026-07-18T01:57:57.8756310Z
build	Build and Test	2026-07-18T01:57:57.8760844Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T01:57:57.8762771Z > Task :client:javadoc
build	Build and Test	2026-07-18T01:57:57.8785828Z 	 * @param duration
build	Build and Test	2026-07-18T01:57:57.8790832Z 	   ^
build	Build and Test	2026-07-18T01:57:57.8792327Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T01:57:57.8794074Z 	 * @param duration
build	Build and Test	2026-07-18T01:57:57.8794895Z 	   ^
build	Build and Test	2026-07-18T01:57:58.3772207Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:57:58.3775960Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:57:58.3793338Z 	            ^
build	Build and Test	2026-07-18T01:57:58.3795292Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:57:58.3797645Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:57:58.3798929Z 	            ^
build	Build and Test	2026-07-18T01:57:58.3800584Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:57:58.3802901Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:57:58.3804160Z 	            ^
build	Build and Test	2026-07-18T01:57:58.3805953Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:57:58.3808265Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:57:58.3809574Z 	            ^
build	Build and Test	2026-07-18T01:57:58.3811235Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:57:58.3814834Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:57:58.3816138Z 	            ^
build	Build and Test	2026-07-18T01:57:58.3817777Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:57:58.3820171Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:57:58.3821435Z 	            ^
build	Build and Test	2026-07-18T01:57:58.3822925Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:57:58.3825361Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:57:58.3826680Z 	            ^
build	Build and Test	2026-07-18T01:57:58.3828440Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:57:58.3830917Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:57:58.3832179Z 	            ^
build	Build and Test	2026-07-18T01:57:58.3833898Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:57:58.3836515Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:57:58.3837799Z 	            ^
build	Build and Test	2026-07-18T01:57:58.4756807Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T01:57:58.4785505Z 	 * @param itemId
build	Build and Test	2026-07-18T01:57:58.4815267Z 	   ^
build	Build and Test	2026-07-18T01:57:58.4816946Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T01:57:58.4848854Z 	 * @return
build	Build and Test	2026-07-18T01:57:58.4863047Z 	   ^
build	Build and Test	2026-07-18T01:57:58.8160372Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T01:57:58.8161002Z 	               ^
build	Build and Test	2026-07-18T01:57:58.8162310Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T01:57:58.8163771Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T01:57:58.8164377Z 	             ^
build	Build and Test	2026-07-18T01:57:58.8165986Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T01:57:58.8167653Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T01:57:58.8168394Z 	            ^
build	Build and Test	2026-07-18T01:57:58.8169790Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T01:57:58.8171389Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T01:57:58.8172108Z 	            ^
build	Build and Test	2026-07-18T01:57:58.8173540Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T01:57:58.8175359Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T01:57:58.8176128Z 	            ^
build	Build and Test	2026-07-18T01:57:58.8751577Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T01:57:58.8753449Z 	public void select(Color color) {
build	Build and Test	2026-07-18T01:57:58.8754242Z 	            ^
build	Build and Test	2026-07-18T01:57:58.8797368Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T01:57:58.8799449Z 	 * @param dimmed
build	Build and Test	2026-07-18T01:57:58.8800022Z 	   ^
build	Build and Test	2026-07-18T01:57:58.9750418Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T01:57:58.9752377Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:57:58.9753237Z 	            ^
build	Build and Test	2026-07-18T01:57:58.9755074Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T01:57:58.9758645Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:57:58.9759552Z 	            ^
build	Build and Test	2026-07-18T01:57:58.9761107Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T01:57:58.9768655Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T01:57:58.9769607Z 		                                          ^
build	Build and Test	2026-07-18T01:58:03.2749641Z 100 warnings
build	Build and Test	2026-07-18T01:58:05.5750756Z
build	Build and Test	2026-07-18T01:58:05.5751714Z > Task :client:javadocJar
build	Build and Test	2026-07-18T01:58:05.5752591Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T01:58:10.1749592Z > Task :client:shadowJar
build	Build and Test	2026-07-18T01:58:10.1751271Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T01:58:10.1752065Z > Task :client:assemble
build	Build and Test	2026-07-18T01:58:10.5749600Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:58:10.5778708Z > Task :client:testClasses
build	Build and Test	2026-07-18T01:58:10.7787797Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T01:58:30.7765573Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T01:58:31.4756006Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T01:58:40.1768333Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T01:58:40.5785559Z > Task :client:pmdMain
build	Build and Test	2026-07-18T01:58:40.7797961Z > Task :client:test
build	Build and Test	2026-07-18T01:58:41.5764955Z
build	Build and Test	2026-07-18T01:58:41.5865641Z /tmp/junit8044041276315886904/junit11678023863944073386/vert.glsl.vert
build	Build and Test	2026-07-18T01:58:41.5985603Z /tmp/junit8044041276315886904/junit11678023863944073386/frag.glsl.frag
build	Build and Test	2026-07-18T01:58:41.7776934Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T01:58:41.7835578Z /tmp/junit8044041276315886904/junit13457538239066738775/vertui.glsl.vert
build	Build and Test	2026-07-18T01:58:41.7892713Z /tmp/junit8044041276315886904/junit13457538239066738775/fragui.glsl.frag
build	Build and Test	2026-07-18T01:58:42.0776809Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T01:58:42.2777131Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T01:58:42.2856802Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T01:58:48.2777088Z
build	Build and Test	2026-07-18T01:58:48.2865679Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T01:58:54.2750041Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784339857228.json
build	Build and Test	2026-07-18T01:58:54.2753243Z
build	Build and Test	2026-07-18T01:58:54.2753516Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T01:58:54.2756210Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T01:58:54.2756871Z
build	Build and Test	2026-07-18T01:58:54.2757260Z * What went wrong:
build	Build and Test	2026-07-18T01:58:54.2757948Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T01:58:54.2759133Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T01:58:54.2760816Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T01:58:54.2761938Z
build	Build and Test	2026-07-18T01:58:54.2762259Z * Try:
build	Build and Test	2026-07-18T01:58:54.2762909Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T01:58:54.2763474Z
build	Build and Test	2026-07-18T01:58:54.2763802Z BUILD FAILED in 1m 28s
build	Build and Test	2026-07-18T01:58:54.7958703Z ##[error]Process completed with exit code 1.
```

## Install release preview homepage: Install the approved KLite release preview

- Run: [29626159862](https://github.com/KSPOG/klite/actions/runs/29626159862)
- Conclusion: `failure`
- Event: `push`
- Commit: `2e7b9bc9e22dbf755cc23ab24493ccd92fc822e1`
- Created: `2026-07-18T01:57:05Z`

### Failed jobs and steps

- **install** — `failure`
  - Step 4: **Verify generated homepage** — `failure`

### Relevant log context

```text
install	Verify generated homepage	﻿2026-07-18T01:57:16.7604652Z ##[group]Run grep -Fq '/release-preview.css?v=3' marketplace-site/public/index.html
install	Verify generated homepage	2026-07-18T01:57:16.7605571Z ^[[36;1mgrep -Fq '/release-preview.css?v=3' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T01:57:16.7606394Z ^[[36;1mgrep -Fq '/obsidian-release.css?v=1' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T01:57:16.7607192Z ^[[36;1mgrep -Fq '/homepage-featured.js?v=1' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T01:57:16.7608538Z ^[[36;1mgrep -Fq 'class="release-wordmark">KLite</h1>' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T01:57:16.7609524Z ^[[36;1mgrep -Fq 'class="client-window"' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T01:57:16.7610417Z ^[[36;1mgrep -Fq 'id="featured-plugin-list"' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T01:57:16.7611098Z ^[[36;1m! grep -Fq 'GPU Plugin' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T01:57:16.7611737Z ^[[36;1m! grep -Fq 'class="landing-hero"' marketplace-site/public/index.html^[[0m
install	Verify generated homepage	2026-07-18T01:57:16.7676196Z shell: /usr/bin/bash -e {0}
install	Verify generated homepage	2026-07-18T01:57:16.7677853Z ##[endgroup]
install	Verify generated homepage	2026-07-18T01:57:16.7804864Z ##[error]Process completed with exit code 1.
```

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29625946594](https://github.com/KSPOG/klite/actions/runs/29625946594)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `3be79e7168ecbc256d8a144331c068c6e80329be`
- Created: `2026-07-18T01:50:01Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 3: **Collect recent failure details** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## CI: Collapse all duplicate header closing tags

- Run: [29625906944](https://github.com/KSPOG/klite/actions/runs/29625906944)
- Conclusion: `failure`
- Event: `push`
- Commit: `b1d028e3927fadc8e9ccee4a985e872f8e6fbab9`
- Created: `2026-07-18T01:48:39Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T01:49:17.3318464Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T01:49:17.3319034Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T01:49:17.8314922Z > Task :client:jar
build	Build and Test	2026-07-18T01:49:17.8315961Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T01:49:18.0302463Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:49:18.0314135Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T01:49:18.0315393Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T01:49:18.0324246Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T01:49:18.0324883Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T01:49:18.0345374Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T01:49:18.0345948Z > Task :runelite-api:build
build	Build and Test	2026-07-18T01:49:18.1315788Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T01:49:26.0328200Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T01:49:26.0329685Z
build	Build and Test	2026-07-18T01:49:26.0330082Z 	 * @param duration
build	Build and Test	2026-07-18T01:49:26.0330629Z 	   ^
build	Build and Test	2026-07-18T01:49:26.0332034Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T01:49:26.0334314Z 	 * @param duration
build	Build and Test	2026-07-18T01:49:26.0334745Z 	   ^
build	Build and Test	2026-07-18T01:49:26.0359353Z > Task :client:javadoc
build	Build and Test	2026-07-18T01:49:26.5305749Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:49:26.5345345Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:49:26.5404239Z 	            ^
build	Build and Test	2026-07-18T01:49:26.5435413Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:49:26.5437794Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:49:26.5464138Z 	            ^
build	Build and Test	2026-07-18T01:49:26.5465746Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:49:26.5468008Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:49:26.5469082Z 	            ^
build	Build and Test	2026-07-18T01:49:26.5470467Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:49:26.5472651Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:49:26.5474122Z 	            ^
build	Build and Test	2026-07-18T01:49:26.5475763Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:49:26.5478423Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:49:26.5479533Z 	            ^
build	Build and Test	2026-07-18T01:49:26.5481087Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:49:26.5483346Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:49:26.6316764Z 	            ^
build	Build and Test	2026-07-18T01:49:26.6345375Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:49:26.6364751Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:49:26.6398969Z 	            ^
build	Build and Test	2026-07-18T01:49:26.6405662Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:49:26.6445485Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:49:26.6446930Z 	            ^
build	Build and Test	2026-07-18T01:49:26.6448853Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:49:26.6451714Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:49:26.6453243Z 	            ^
build	Build and Test	2026-07-18T01:49:26.6455246Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T01:49:26.6457017Z 	 * @param itemId
build	Build and Test	2026-07-18T01:49:26.6457718Z 	   ^
build	Build and Test	2026-07-18T01:49:26.6459290Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T01:49:26.6460976Z 	 * @return
build	Build and Test	2026-07-18T01:49:26.6461578Z 	   ^
build	Build and Test	2026-07-18T01:49:27.2397187Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T01:49:27.2397881Z 	               ^
build	Build and Test	2026-07-18T01:49:27.2399307Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T01:49:27.2401000Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T01:49:27.2401728Z 	             ^
build	Build and Test	2026-07-18T01:49:27.2403250Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T01:49:27.2405340Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T01:49:27.2406224Z 	            ^
build	Build and Test	2026-07-18T01:49:27.2407788Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T01:49:27.2409597Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T01:49:27.2410421Z 	            ^
build	Build and Test	2026-07-18T01:49:27.2411962Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T01:49:27.2414084Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T01:49:27.2414944Z 	            ^
build	Build and Test	2026-07-18T01:49:27.2416434Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T01:49:27.2418048Z 	public void select(Color color) {
build	Build and Test	2026-07-18T01:49:27.2418720Z 	            ^
build	Build and Test	2026-07-18T01:49:27.3302284Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T01:49:27.3306267Z 	 * @param dimmed
build	Build and Test	2026-07-18T01:49:27.3306925Z 	   ^
build	Build and Test	2026-07-18T01:49:27.3308360Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T01:49:27.3310054Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:49:27.3311091Z 	            ^
build	Build and Test	2026-07-18T01:49:27.3312632Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T01:49:27.3314662Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:49:27.3315450Z 	            ^
build	Build and Test	2026-07-18T01:49:27.4302724Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T01:49:27.4306215Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T01:49:27.4307312Z 		                                          ^
build	Build and Test	2026-07-18T01:49:32.2304579Z 100 warnings
build	Build and Test	2026-07-18T01:49:34.7301029Z
build	Build and Test	2026-07-18T01:49:34.7302588Z > Task :client:javadocJar
build	Build and Test	2026-07-18T01:49:34.7303202Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T01:49:39.4344820Z > Task :client:shadowJar
build	Build and Test	2026-07-18T01:49:39.4345902Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T01:49:39.4364491Z > Task :client:assemble
build	Build and Test	2026-07-18T01:49:39.8302001Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:49:39.8334243Z > Task :client:testClasses
build	Build and Test	2026-07-18T01:49:39.9308233Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T01:49:59.8394765Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T01:50:02.9302083Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T01:50:09.4314553Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T01:50:09.9304513Z > Task :client:pmdMain
build	Build and Test	2026-07-18T01:50:09.9364268Z > Task :client:test
build	Build and Test	2026-07-18T01:50:11.9384697Z
build	Build and Test	2026-07-18T01:50:11.9414708Z /tmp/junit1136244390164458942/junit1537257946731587085/vert.glsl.vert
build	Build and Test	2026-07-18T01:50:11.9465614Z /tmp/junit1136244390164458942/junit1537257946731587085/frag.glsl.frag
build	Build and Test	2026-07-18T01:50:12.0324706Z /tmp/junit1136244390164458942/junit1094064462841315984/vertui.glsl.vert
build	Build and Test	2026-07-18T01:50:12.0354350Z /tmp/junit1136244390164458942/junit1094064462841315984/fragui.glsl.frag
build	Build and Test	2026-07-18T01:50:12.5325651Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T01:50:12.7325912Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T01:50:12.9302812Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T01:50:12.9376003Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T01:50:18.4300607Z
build	Build and Test	2026-07-18T01:50:18.4334589Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T01:50:24.0308642Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784339344309.json
build	Build and Test	2026-07-18T01:50:24.0312356Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T01:50:24.0312818Z
build	Build and Test	2026-07-18T01:50:24.0320608Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T01:50:24.0321138Z
build	Build and Test	2026-07-18T01:50:24.0324499Z * What went wrong:
build	Build and Test	2026-07-18T01:50:24.0325291Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T01:50:24.0326631Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T01:50:24.0328136Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T01:50:24.0331265Z
build	Build and Test	2026-07-18T01:50:24.0331448Z * Try:
build	Build and Test	2026-07-18T01:50:24.0331891Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T01:50:24.0332304Z
build	Build and Test	2026-07-18T01:50:24.0332494Z BUILD FAILED in 1m 32s
build	Build and Test	2026-07-18T01:50:24.5358198Z ##[error]Process completed with exit code 1.
```

## CI: Remove duplicate header closing tag during generation

- Run: [29625856273](https://github.com/KSPOG/klite/actions/runs/29625856273)
- Conclusion: `failure`
- Event: `push`
- Commit: `c9bdc9d376fadca11a6aafb5d89356522f4d18c8`
- Created: `2026-07-18T01:46:56Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T01:47:45.2940632Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T01:47:45.2944970Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T01:47:45.3907329Z > Task :runelite-api:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:47:45.3942532Z > Task :runelite-api:processTestResources NO-SOURCE
build	Build and Test	2026-07-18T01:47:45.3974467Z > Task :runelite-api:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T01:47:45.4922896Z > Task :runelite-api:checkstyleTest FROM-CACHE
build	Build and Test	2026-07-18T01:47:45.5898987Z > Task :runelite-api:test FROM-CACHE
build	Build and Test	2026-07-18T01:47:45.5911961Z > Task :runelite-api:check UP-TO-DATE
build	Build and Test	2026-07-18T01:47:45.5913621Z > Task :runelite-api:build
build	Build and Test	2026-07-18T01:47:45.6919794Z > Task :client:jar
build	Build and Test	2026-07-18T01:47:45.6939159Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T01:47:46.1899591Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T01:47:56.3918325Z
build	Build and Test	2026-07-18T01:47:56.3923083Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T01:47:56.3928070Z > Task :client:javadoc
build	Build and Test	2026-07-18T01:47:56.3930184Z 	 * @param duration
build	Build and Test	2026-07-18T01:47:56.3932074Z 	   ^
build	Build and Test	2026-07-18T01:47:56.3936481Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T01:47:56.3950646Z 	 * @param duration
build	Build and Test	2026-07-18T01:47:56.3981719Z 	   ^
build	Build and Test	2026-07-18T01:47:57.3932890Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:47:57.3940081Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:47:57.3971868Z 	            ^
build	Build and Test	2026-07-18T01:47:57.4026380Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:47:57.4083735Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:47:57.4111708Z 	            ^
build	Build and Test	2026-07-18T01:47:57.4175631Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:47:57.4223396Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:47:57.4281878Z 	            ^
build	Build and Test	2026-07-18T01:47:57.4314632Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:47:57.4373597Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:47:57.4401595Z 	            ^
build	Build and Test	2026-07-18T01:47:57.4406557Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:47:57.4454834Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:47:57.4458690Z 	            ^
build	Build and Test	2026-07-18T01:47:57.4464358Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:47:57.4492368Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:47:57.4496378Z 	            ^
build	Build and Test	2026-07-18T01:47:57.4501138Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T01:47:57.4508150Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:47:57.4512105Z 	            ^
build	Build and Test	2026-07-18T01:47:57.4517060Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T01:47:57.4555664Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:47:57.4572128Z 	            ^
build	Build and Test	2026-07-18T01:47:57.4577337Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T01:47:57.4584906Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T01:47:57.4588583Z 	            ^
build	Build and Test	2026-07-18T01:47:57.4907683Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T01:47:57.4913222Z 	 * @param itemId
build	Build and Test	2026-07-18T01:47:57.4914981Z 	   ^
build	Build and Test	2026-07-18T01:47:57.4919801Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T01:47:57.4925394Z 	 * @return
build	Build and Test	2026-07-18T01:47:57.4927095Z 	   ^
build	Build and Test	2026-07-18T01:47:58.1983031Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T01:47:58.1984725Z 	               ^
build	Build and Test	2026-07-18T01:47:58.1988596Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T01:47:58.1993572Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T01:47:58.1995387Z 	             ^
build	Build and Test	2026-07-18T01:47:58.2017908Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T01:47:58.2023314Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T01:47:58.2025435Z 	            ^
build	Build and Test	2026-07-18T01:47:58.2029665Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T01:47:58.2034860Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T01:47:58.2036817Z 	            ^
build	Build and Test	2026-07-18T01:47:58.2041528Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T01:47:58.2046717Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T01:47:58.2048761Z 	            ^
build	Build and Test	2026-07-18T01:47:58.2901588Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T01:47:58.2929212Z 	public void select(Color color) {
build	Build and Test	2026-07-18T01:47:58.2931474Z 	            ^
build	Build and Test	2026-07-18T01:47:58.4901430Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T01:47:58.4908849Z 	 * @param dimmed
build	Build and Test	2026-07-18T01:47:58.4910521Z 	   ^
build	Build and Test	2026-07-18T01:47:58.5900542Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T01:47:58.5908126Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:47:58.5910489Z 	            ^
build	Build and Test	2026-07-18T01:47:58.5915518Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T01:47:58.5921277Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T01:47:58.5923503Z 	            ^
build	Build and Test	2026-07-18T01:47:58.7917554Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T01:47:58.7952577Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T01:47:58.7961772Z 		                                          ^
build	Build and Test	2026-07-18T01:48:05.4897130Z 100 warnings
build	Build and Test	2026-07-18T01:48:09.4897680Z
build	Build and Test	2026-07-18T01:48:09.4899194Z > Task :client:javadocJar
build	Build and Test	2026-07-18T01:48:09.4902090Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T01:48:17.5897937Z > Task :client:shadowJar
build	Build and Test	2026-07-18T01:48:17.5901509Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T01:48:17.5903733Z > Task :client:assemble
build	Build and Test	2026-07-18T01:48:18.1992623Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T01:48:18.1994665Z > Task :client:testClasses
build	Build and Test	2026-07-18T01:48:18.3960296Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T01:48:47.5902269Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T01:48:48.1912136Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T01:48:48.2932177Z > Task :client:pmdMain
build	Build and Test	2026-07-18T01:48:48.3942252Z > Task :client:test
build	Build and Test	2026-07-18T01:49:05.1921438Z
build	Build and Test	2026-07-18T01:49:05.1979708Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/externalplugins/KLiteDevelopmentPluginManager.java:447:	UnusedPrivateField:	Avoid unused private fields such as 'jar'.
build	Build and Test	2026-07-18T01:49:11.4898934Z /tmp/junit1883002507561648448/junit10527254522151436126/vert.glsl.vert
build	Build and Test	2026-07-18T01:49:11.4932278Z /tmp/junit1883002507561648448/junit10527254522151436126/frag.glsl.frag
build	Build and Test	2026-07-18T01:49:11.7962923Z /tmp/junit1883002507561648448/junit8981146417300601597/vertui.glsl.vert
build	Build and Test	2026-07-18T01:49:11.8081965Z /tmp/junit1883002507561648448/junit8981146417300601597/fragui.glsl.frag
build	Build and Test	2026-07-18T01:49:23.7956535Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/debug/KLiteClientLogBuffer.java:35:	UseDiamondOperator:	Explicit type arguments can be replaced by a diamond: `new AppenderBase<>()`
build	Build and Test	2026-07-18T01:49:24.1925371Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteMarketplacePersistenceService.java:339:	ImmutableField:	Field 'schemaVersion' may be declared final
build	Build and Test	2026-07-18T01:49:24.4927162Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:295:	IdenticalCatchBranches:	'catch' branch identical to 'IOException | ClassNotFoundException | PluginInstantiationException' branch
build	Build and Test	2026-07-18T01:49:24.4938227Z /home/runner/work/klite/klite/runelite-client/src/main/java/net/runelite/client/plugins/klite/marketplace/KLiteStreamedPluginService.java:400:	PreserveStackTrace:	Thrown exception does not preserve the stack trace of exception 'ex' on all code paths
build	Build and Test	2026-07-18T01:49:36.4898954Z
build	Build and Test	2026-07-18T01:49:36.4911926Z > Task :client:pmdMain FAILED
build	Build and Test	2026-07-18T01:49:49.7906098Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784339242661.json
build	Build and Test	2026-07-18T01:49:49.8914449Z
build	Build and Test	2026-07-18T01:49:49.8915648Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T01:49:49.8949475Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T01:49:49.8971334Z
build	Build and Test	2026-07-18T01:49:49.8981853Z * What went wrong:
build	Build and Test	2026-07-18T01:49:49.9012034Z Execution failed for task ':client:pmdMain'.
build	Build and Test	2026-07-18T01:49:49.9043464Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.PmdAction
build	Build and Test	2026-07-18T01:49:49.9074859Z    > 5 PMD rule violations were found. See the report at: file:///home/runner/work/klite/klite/runelite-client/build/reports/pmd/main.html
build	Build and Test	2026-07-18T01:49:49.9101491Z
build	Build and Test	2026-07-18T01:49:49.9111875Z * Try:
build	Build and Test	2026-07-18T01:49:49.9142174Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T01:49:49.9143571Z
build	Build and Test	2026-07-18T01:49:49.9144767Z BUILD FAILED in 2m 36s
build	Build and Test	2026-07-18T01:49:50.5553412Z ##[error]Process completed with exit code 1.
```

## Install release preview homepage: Install the approved KLite release preview

- Run: [29625856267](https://github.com/KSPOG/klite/actions/runs/29625856267)
- Conclusion: `failure`
- Event: `push`
- Commit: `c9bdc9d376fadca11a6aafb5d89356522f4d18c8`
- Created: `2026-07-18T01:46:56Z`

### Failed jobs and steps

- **install** — `failure`
  - Step 3: **Install release preview** — `failure`

### Relevant log context

```text
install	Install release preview	﻿2026-07-18T01:47:09.1521586Z ##[group]Run python3 scripts/install_release_preview.py
install	Install release preview	2026-07-18T01:47:09.1522272Z ^[[36;1mpython3 scripts/install_release_preview.py^[[0m
install	Install release preview	2026-07-18T01:47:09.1583462Z shell: /usr/bin/bash -e {0}
install	Install release preview	2026-07-18T01:47:09.1584080Z ##[endgroup]
install	Install release preview	2026-07-18T01:47:09.3071323Z Traceback (most recent call last):
install	Install release preview	2026-07-18T01:47:09.3072711Z   File "/home/runner/work/klite/klite/scripts/install_release_preview.py", line 93, in <module>
install	Install release preview	2026-07-18T01:47:09.3073560Z     main()
install	Install release preview	2026-07-18T01:47:09.3074104Z   File "/home/runner/work/klite/klite/scripts/install_release_preview.py", line 76, in main
install	Install release preview	2026-07-18T01:47:09.3074749Z     raise RuntimeError("Duplicate header closing tag remains")
install	Install release preview	2026-07-18T01:47:09.3075262Z RuntimeError: Duplicate header closing tag remains
install	Install release preview	2026-07-18T01:47:09.3240086Z ##[error]Process completed with exit code 1.
```

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29625854025](https://github.com/KSPOG/klite/actions/runs/29625854025)
- Conclusion: `failure`
- Event: `workflow_run`
- Commit: `9ce6f3ce32f40a4ff27a9f5bd988ef9593a39834`
- Created: `2026-07-18T01:46:52Z`

### Failed jobs and steps

- **diagnose** — `failure`
  - Step 4: **Publish diagnostic report** — `failure`

### Relevant log context

```text
diagnose	Publish diagnostic report	﻿2026-07-18T01:47:21.6046109Z ##[group]Run set -euo pipefail
diagnose	Publish diagnostic report	2026-07-18T01:47:21.6119520Z ^[[36;1mset -euo pipefail^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:47:21.6120002Z ^[[36;1mgit config user.name "github-actions[bot]"^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:47:21.6120796Z ^[[36;1mgit config user.email "41898282+github-actions[bot]@users.noreply.github.com"^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:47:21.6121690Z ^[[36;1mgit add diagnostics/latest-workflow-failures.md^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:47:21.6122298Z ^[[36;1mif git diff --cached --quiet; then^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:47:21.6122784Z ^[[36;1m  echo "The failure report did not change."^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:47:21.6123237Z ^[[36;1m  exit 0^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:47:21.6123542Z ^[[36;1mfi^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:47:21.6123981Z ^[[36;1mgit commit -m "Update workflow failure diagnostics [skip ci]"^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:47:21.6124531Z ^[[36;1mgit push^[[0m
diagnose	Publish diagnostic report	2026-07-18T01:47:21.6194534Z shell: /usr/bin/bash --noprofile --norc -e -o pipefail {0}
diagnose	Publish diagnostic report	2026-07-18T01:47:21.6194942Z ##[endgroup]
diagnose	Publish diagnostic report	2026-07-18T01:47:21.7930734Z [main bfe9e61a4] Update workflow failure diagnostics [skip ci]
diagnose	Publish diagnostic report	2026-07-18T01:47:21.7931571Z  1 file changed, 452 insertions(+), 358 deletions(-)
diagnose	Publish diagnostic report	2026-07-18T01:47:21.9889411Z To https://github.com/KSPOG/klite
diagnose	Publish diagnostic report	2026-07-18T01:47:21.9889913Z  ! [rejected]            main -> main (non-fast-forward)
diagnose	Publish diagnostic report	2026-07-18T01:47:21.9890650Z error: failed to push some refs to 'https://github.com/KSPOG/klite'
diagnose	Publish diagnostic report	2026-07-18T01:47:21.9922650Z hint: Updates were rejected because the tip of your current branch is behind
diagnose	Publish diagnostic report	2026-07-18T01:47:21.9923495Z hint: its remote counterpart. If you want to integrate the remote changes,
diagnose	Publish diagnostic report	2026-07-18T01:47:21.9924170Z hint: use 'git pull' before pushing again.
diagnose	Publish diagnostic report	2026-07-18T01:47:21.9924851Z hint: See the 'Note about fast-forwards' in 'git push --help' for details.
diagnose	Publish diagnostic report	2026-07-18T01:47:21.9941615Z ##[error]Process completed with exit code 1.
```

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29625853059](https://github.com/KSPOG/klite/actions/runs/29625853059)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `9ce6f3ce32f40a4ff27a9f5bd988ef9593a39834`
- Created: `2026-07-18T01:46:50Z`

### Failed jobs and steps

No failed job metadata was returned.

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

## Diagnose failed workflow runs: Diagnose failed workflow runs

- Run: [29625847992](https://github.com/KSPOG/klite/actions/runs/29625847992)
- Conclusion: `cancelled`
- Event: `workflow_run`
- Commit: `9ce6f3ce32f40a4ff27a9f5bd988ef9593a39834`
- Created: `2026-07-18T01:46:39Z`

### Failed jobs and steps

- **diagnose** — `cancelled`
  - Step 2: **Check out repository** — `cancelled`

### Relevant log context

No matching error lines were available from `gh run view --log-failed`.

