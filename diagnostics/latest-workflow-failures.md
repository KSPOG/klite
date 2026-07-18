# Recent GitHub Actions failures

Generated: 2026-07-18T19:37:05.432119+00:00
Repository: `KSPOG/klite`
Failed runs inspected: **3**

## CI: Restore and refine credit wallet styling

- Run: [29658066897](https://github.com/KSPOG/klite/actions/runs/29658066897)
- Conclusion: `failure`
- Event: `push`
- Commit: `aeb482fce1246b37dc75b4511f4110ea273d29cd`
- Created: `2026-07-18T19:34:52Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log context

```text
build	Build and Test	2026-07-18T19:35:34.3434015Z > Task :copper-tin-miner:jar
build	Build and Test	2026-07-18T19:35:34.3464793Z > Task :copper-tin-miner:assemble
build	Build and Test	2026-07-18T19:35:34.4334904Z > Task :copper-tin-miner:checkstyleMain FROM-CACHE
build	Build and Test	2026-07-18T19:35:34.4344701Z > Task :copper-tin-miner:compileTestJava NO-SOURCE
build	Build and Test	2026-07-18T19:35:34.4346371Z > Task :copper-tin-miner:testClasses UP-TO-DATE
build	Build and Test	2026-07-18T19:35:34.5334344Z > Task :copper-tin-miner:checkstyleTest NO-SOURCE
build	Build and Test	2026-07-18T19:35:34.5341065Z > Task :copper-tin-miner:test NO-SOURCE
build	Build and Test	2026-07-18T19:35:34.5342472Z > Task :copper-tin-miner:check UP-TO-DATE
build	Build and Test	2026-07-18T19:35:34.5343285Z > Task :copper-tin-miner:build
build	Build and Test	2026-07-18T19:35:34.7333951Z > Task :client:jar
build	Build and Test	2026-07-18T19:35:34.7336355Z > Task :client:jarSign SKIPPED
build	Build and Test	2026-07-18T19:35:34.8334368Z > Task :client:delombok FROM-CACHE
build	Build and Test	2026-07-18T19:35:41.4351857Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:81: warning: no description for @param
build	Build and Test	2026-07-18T19:35:41.4353218Z
build	Build and Test	2026-07-18T19:35:41.4357504Z > Task :client:javadoc
build	Build and Test	2026-07-18T19:35:41.4385089Z 	 * @param duration
build	Build and Test	2026-07-18T19:35:41.4385589Z 	   ^
build	Build and Test	2026-07-18T19:35:41.4386915Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/infobox/Timer.java:91: warning: no description for @param
build	Build and Test	2026-07-18T19:35:41.4388571Z 	 * @param duration
build	Build and Test	2026-07-18T19:35:41.4388967Z 	   ^
build	Build and Test	2026-07-18T19:35:41.9341875Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T19:35:41.9356991Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T19:35:41.9381032Z 	            ^
build	Build and Test	2026-07-18T19:35:41.9386741Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T19:35:41.9389594Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T19:35:41.9391045Z 	            ^
build	Build and Test	2026-07-18T19:35:41.9392999Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T19:35:41.9395694Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T19:35:41.9396883Z 	            ^
build	Build and Test	2026-07-18T19:35:41.9398407Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T19:35:41.9400581Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T19:35:41.9401850Z 	            ^
build	Build and Test	2026-07-18T19:35:41.9403609Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T19:35:41.9407024Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T19:35:41.9412396Z 	            ^
build	Build and Test	2026-07-18T19:35:41.9414017Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T19:35:41.9416284Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T19:35:41.9417522Z 	            ^
build	Build and Test	2026-07-18T19:35:41.9418964Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-18T19:35:41.9421017Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T19:35:41.9422302Z 	            ^
build	Build and Test	2026-07-18T19:35:41.9424052Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-18T19:35:41.9426481Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T19:35:41.9427677Z 	            ^
build	Build and Test	2026-07-18T19:35:41.9429282Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-18T19:35:41.9431604Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-18T19:35:41.9432932Z 	            ^
build	Build and Test	2026-07-18T19:35:42.0379105Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:41: warning: no description for @param
build	Build and Test	2026-07-18T19:35:42.0381437Z 	 * @param itemId
build	Build and Test	2026-07-18T19:35:42.0382356Z 	   ^
build	Build and Test	2026-07-18T19:35:42.0406343Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/plugins/banktags/BankTag.java:42: warning: no description for @return
build	Build and Test	2026-07-18T19:35:42.0413324Z 	 * @return
build	Build and Test	2026-07-18T19:35:42.0413947Z 	   ^
build	Build and Test	2026-07-18T19:35:42.4355564Z 	public boolean isDynamicFont() {
build	Build and Test	2026-07-18T19:35:42.4356234Z 	               ^
build	Build and Test	2026-07-18T19:35:42.4357606Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:111: warning: no @return
build	Build and Test	2026-07-18T19:35:42.4359146Z 	public Color getPreferredColor() {
build	Build and Test	2026-07-18T19:35:42.4359840Z 	             ^
build	Build and Test	2026-07-18T19:35:42.4361308Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:118: warning: no @param for clearChildren
build	Build and Test	2026-07-18T19:35:42.4363051Z 	public void setClearChildren(final boolean clearChildren) {
build	Build and Test	2026-07-18T19:35:42.4364057Z 	            ^
build	Build and Test	2026-07-18T19:35:42.4370318Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:125: warning: no @param for dynamicFont
build	Build and Test	2026-07-18T19:35:42.4372081Z 	public void setDynamicFont(final boolean dynamicFont) {
build	Build and Test	2026-07-18T19:35:42.4372879Z 	            ^
build	Build and Test	2026-07-18T19:35:42.4374546Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/OverlayPanel.java:132: warning: no @param for preferredColor
build	Build and Test	2026-07-18T19:35:42.4376313Z 	public void setPreferredColor(final Color preferredColor) {
build	Build and Test	2026-07-18T19:35:42.4377114Z 	            ^
build	Build and Test	2026-07-18T19:35:42.5336464Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/colorpicker/HuePanel.java:69: warning: no @param for color
build	Build and Test	2026-07-18T19:35:42.5353341Z 	public void select(Color color) {
build	Build and Test	2026-07-18T19:35:42.5354520Z 	            ^
build	Build and Test	2026-07-18T19:35:42.5356165Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/DimmableJPanel.java:66: warning: no description for @param
build	Build and Test	2026-07-18T19:35:42.5358640Z 	 * @param dimmed
build	Build and Test	2026-07-18T19:35:42.5363466Z 	   ^
build	Build and Test	2026-07-18T19:35:42.6335434Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-18T19:35:42.6355673Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T19:35:42.6359970Z 	            ^
build	Build and Test	2026-07-18T19:35:42.6361904Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-18T19:35:42.6363940Z 	public void setContent(String title, String description)
build	Build and Test	2026-07-18T19:35:42.6364855Z 	            ^
build	Build and Test	2026-07-18T19:35:42.7334558Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/overlay/components/LineComponent.java:202: warning: no @param for left
build	Build and Test	2026-07-18T19:35:42.7337779Z 		public LineComponent.LineComponentBuilder left(final String left) {
build	Build and Test	2026-07-18T19:35:42.7338894Z 		                                          ^
build	Build and Test	2026-07-18T19:35:46.8333342Z 100 warnings
build	Build and Test	2026-07-18T19:35:48.8333374Z
build	Build and Test	2026-07-18T19:35:48.8334788Z > Task :client:javadocJar
build	Build and Test	2026-07-18T19:35:48.8336304Z > Task :client:javadocJarSign SKIPPED
build	Build and Test	2026-07-18T19:35:53.1357495Z > Task :client:shadowJar
build	Build and Test	2026-07-18T19:35:53.1385243Z > Task :client:shadowJarSign SKIPPED
build	Build and Test	2026-07-18T19:35:53.1403275Z > Task :client:assemble
build	Build and Test	2026-07-18T19:35:53.4355081Z > Task :client:compileTestJava FROM-CACHE
build	Build and Test	2026-07-18T19:35:53.4383750Z > Task :client:testClasses
build	Build and Test	2026-07-18T19:35:53.6335216Z > Task :client:pmdTest SKIPPED
build	Build and Test	2026-07-18T19:36:14.5333306Z /tmp/junit13252198799555290927/junit10150523862542471110/vert.glsl.vert
build	Build and Test	2026-07-18T19:36:14.5411478Z /tmp/junit13252198799555290927/junit10150523862542471110/frag.glsl.frag
build	Build and Test	2026-07-18T19:36:14.6355406Z /tmp/junit13252198799555290927/junit10854077339737909568/vertui.glsl.vert
build	Build and Test	2026-07-18T19:36:14.6385405Z /tmp/junit13252198799555290927/junit10854077339737909568/fragui.glsl.frag
build	Build and Test	2026-07-18T19:36:21.5355145Z > Task :client:pmdMain
build	Build and Test	2026-07-18T19:36:23.0333901Z > Task :client:checkstyleMain
build	Build and Test	2026-07-18T19:36:23.4334248Z > Task :client:checkstyleTest
build	Build and Test	2026-07-18T19:36:23.5333510Z > Task :client:test
build	Build and Test	2026-07-18T19:36:33.4332847Z > Task :client:checkstyleTest FAILED
build	Build and Test	2026-07-18T19:36:44.6332272Z
build	Build and Test	2026-07-18T19:36:44.6333526Z gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1784403320933.json
build	Build and Test	2026-07-18T19:36:44.6360678Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-18T19:36:44.6361334Z
build	Build and Test	2026-07-18T19:36:44.6361611Z 68 actionable tasks: 29 executed, 39 from cache
build	Build and Test	2026-07-18T19:36:44.6362600Z * What went wrong:
build	Build and Test	2026-07-18T19:36:44.6363151Z Execution failed for task ':client:checkstyleTest'.
build	Build and Test	2026-07-18T19:36:44.6364547Z > A failure occurred while executing org.gradle.api.plugins.quality.internal.CheckstyleAction
build	Build and Test	2026-07-18T19:36:44.6365916Z    > An unexpected error occurred configuring and executing Checkstyle.
build	Build and Test	2026-07-18T19:36:44.6366934Z       > Unable to create Root Module: config {/home/runner/work/klite/klite/config/checkstyle/checkstyle.xml}, classpath {null}.
build	Build and Test	2026-07-18T19:36:44.6367620Z
build	Build and Test	2026-07-18T19:36:44.6367805Z * Try:
build	Build and Test	2026-07-18T19:36:44.6368208Z > Run with --stacktrace option to get the stack trace.
build	Build and Test	2026-07-18T19:36:44.6368785Z > Run with --info or --debug option to get more log output.
build	Build and Test	2026-07-18T19:36:44.6369316Z > Run with --scan to get full insights.
build	Build and Test	2026-07-18T19:36:44.6369804Z > Get more help at https://help.gradle.org.
build	Build and Test	2026-07-18T19:36:44.6370152Z
build	Build and Test	2026-07-18T19:36:44.6370356Z BUILD FAILED in 1m 32s
build	Build and Test	2026-07-18T19:36:45.0989447Z ##[error]Process completed with exit code 1.
```

## Verify live KLite Windows update: Verify live KLite Windows update

- Run: [29655062412](https://github.com/KSPOG/klite/actions/runs/29655062412)
- Conclusion: `failure`
- Event: `workflow_dispatch`
- Commit: `ab78585fe34de4472e262899d88a5574b283dc14`
- Created: `2026-07-18T18:01:51Z`

### Failed jobs and steps

- **verify-live-update** — `failure`
  - Step 3: **Wait for the Pages deployment** — `failure`

### Relevant log context

```text
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:02.3491150Z ##[endgroup]
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:02.3493483Z ##[group]Determining the checkout info
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:02.3501397Z [command]/usr/bin/git branch --list --remote origin/main
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:02.3532491Z   origin/main
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:02.3541927Z ##[endgroup]
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:02.3547742Z [command]/usr/bin/git sparse-checkout disable
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:02.3599303Z [command]/usr/bin/git config --local --unset-all extensions.worktreeConfig
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:02.3633767Z ##[group]Checking out the ref
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:02.3639633Z [command]/usr/bin/git checkout --progress --force -B main refs/remotes/origin/main
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:02.6131208Z Switched to a new branch 'main'
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:02.6133216Z branch 'main' set up to track 'origin/main'.
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:02.6151760Z ##[endgroup]
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:02.6200500Z [command]/usr/bin/git log -1 --format=%H
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:02.6229032Z ab78585fe34de4472e262899d88a5574b283dc14
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:02.6425920Z ##[group]Run set -euo pipefail
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:02.6426418Z ^[[36;1mset -euo pipefail^[[0m
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:02.6427310Z ^[[36;1mexpected_asset="$(jq -r '.assetName' marketplace-site/public/client/windows/latest.json)"^[[0m
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:02.6427865Z ^[[36;1m^[[0m
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:02.6428132Z ^[[36;1mfor attempt in $(seq 1 20); do^[[0m
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:02.6428470Z ^[[36;1m  headers="$(mktemp)"^[[0m
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:02.6428832Z ^[[36;1m  if curl --silent --show-error --fail --head \^[[0m
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:02.6429270Z ^[[36;1m    --header 'Cache-Control: no-store' \^[[0m
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:02.6429633Z ^[[36;1m    --output /dev/null \^[[0m
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:02.6429960Z ^[[36;1m    --dump-header "$headers" \^[[0m
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:02.6430707Z ^[[36;1m    "https://klite-marketplace.pages.dev/download/windows?deployment_probe=${GITHUB_RUN_ID}-${attempt}"; then^[[0m
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:02.6431640Z ^[[36;1m    live_asset="$(awk -F': ' 'tolower($1) == "x-klite-installer-asset" {gsub("\\r", "", $2); print $2}' "$headers" | tail -n 1)"^[[0m
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:02.6432292Z ^[[36;1m    if [ "$live_asset" = "$expected_asset" ]; then^[[0m
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:02.6432792Z ^[[36;1m      echo "The live Pages Function is serving the expected asset: $live_asset"^[[0m
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:17.7898264Z Attempt 2: live asset '' does not yet match 'KLite-Setup-1.0.91-bfa58602e6710716.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:32.8338970Z Attempt 3: live asset '' does not yet match 'KLite-Setup-1.0.91-bfa58602e6710716.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T18:02:47.8773948Z Attempt 4: live asset '' does not yet match 'KLite-Setup-1.0.91-bfa58602e6710716.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T18:03:02.9291103Z Attempt 5: live asset '' does not yet match 'KLite-Setup-1.0.91-bfa58602e6710716.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T18:03:17.9738316Z Attempt 6: live asset '' does not yet match 'KLite-Setup-1.0.91-bfa58602e6710716.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T18:03:33.0198680Z Attempt 7: live asset '' does not yet match 'KLite-Setup-1.0.91-bfa58602e6710716.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T18:03:48.0697813Z Attempt 8: live asset '' does not yet match 'KLite-Setup-1.0.91-bfa58602e6710716.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T18:04:03.1237349Z Attempt 9: live asset '' does not yet match 'KLite-Setup-1.0.91-bfa58602e6710716.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T18:04:18.1687326Z Attempt 10: live asset '' does not yet match 'KLite-Setup-1.0.91-bfa58602e6710716.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T18:04:33.2146588Z Attempt 11: live asset '' does not yet match 'KLite-Setup-1.0.91-bfa58602e6710716.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T18:04:48.2627615Z Attempt 12: live asset '' does not yet match 'KLite-Setup-1.0.91-bfa58602e6710716.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T18:05:03.3072290Z Attempt 13: live asset '' does not yet match 'KLite-Setup-1.0.91-bfa58602e6710716.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T18:05:18.3520657Z Attempt 14: live asset '' does not yet match 'KLite-Setup-1.0.91-bfa58602e6710716.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T18:05:33.3971142Z Attempt 15: live asset '' does not yet match 'KLite-Setup-1.0.91-bfa58602e6710716.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T18:05:48.4410219Z Attempt 16: live asset '' does not yet match 'KLite-Setup-1.0.91-bfa58602e6710716.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T18:06:03.4851148Z Attempt 17: live asset '' does not yet match 'KLite-Setup-1.0.91-bfa58602e6710716.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T18:06:18.5283594Z Attempt 18: live asset '' does not yet match 'KLite-Setup-1.0.91-bfa58602e6710716.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T18:06:33.5776462Z Attempt 19: live asset '' does not yet match 'KLite-Setup-1.0.91-bfa58602e6710716.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T18:06:48.6217495Z Attempt 20: live asset '' does not yet match 'KLite-Setup-1.0.91-bfa58602e6710716.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T18:07:03.6245471Z Cloudflare Pages did not publish the expected download function in time.
verify-live-update	UNKNOWN STEP	2026-07-18T18:07:03.6263680Z ##[error]Process completed with exit code 1.
verify-live-update	UNKNOWN STEP	2026-07-18T18:07:03.6482523Z Node 20 is being deprecated. This workflow is running with Node 24 by default. If you need to temporarily use Node 20, you can set the ACTIONS_ALLOW_USE_UNSECURE_NODE_VERSION=true environment variable. For more information see: https://github.blog/changelog/2025-09-19-deprecation-of-node-20-on-github-actions-runners/
verify-live-update	UNKNOWN STEP	2026-07-18T18:07:03.6484045Z Post job cleanup.
verify-live-update	UNKNOWN STEP	2026-07-18T18:07:03.7464614Z [command]/usr/bin/git version
verify-live-update	UNKNOWN STEP	2026-07-18T18:07:03.7510254Z git version 2.54.0
verify-live-update	UNKNOWN STEP	2026-07-18T18:07:03.7555385Z Temporarily overriding HOME='/home/runner/work/_temp/4c031975-e539-4582-9f5a-e1679b727e6b' before making global git config changes
verify-live-update	UNKNOWN STEP	2026-07-18T18:07:03.7559279Z Adding repository directory to the temporary git global config as a safe directory
verify-live-update	UNKNOWN STEP	2026-07-18T18:07:03.7561949Z [command]/usr/bin/git config --global --add safe.directory /home/runner/work/klite/klite
```

## Verify live KLite Windows update: Merge PR #37: secure KLite Launcher and managed updates

- Run: [29654826839](https://github.com/KSPOG/klite/actions/runs/29654826839)
- Conclusion: `failure`
- Event: `push`
- Commit: `31206e72d5b761bc3044d6088d7cc0f95e29721e`
- Created: `2026-07-18T17:54:36Z`

### Failed jobs and steps

- **verify-live-update** — `failure`
  - Step 3: **Wait for the Pages deployment** — `failure`

### Relevant log context

```text
verify-live-update	UNKNOWN STEP	2026-07-18T17:54:48.1753128Z ##[endgroup]
verify-live-update	UNKNOWN STEP	2026-07-18T17:54:48.1755542Z ##[group]Determining the checkout info
verify-live-update	UNKNOWN STEP	2026-07-18T17:54:48.1757524Z [command]/usr/bin/git branch --list --remote origin/main
verify-live-update	UNKNOWN STEP	2026-07-18T17:54:48.1762061Z   origin/main
verify-live-update	UNKNOWN STEP	2026-07-18T17:54:48.1774689Z ##[endgroup]
verify-live-update	UNKNOWN STEP	2026-07-18T17:54:48.1776806Z [command]/usr/bin/git sparse-checkout disable
verify-live-update	UNKNOWN STEP	2026-07-18T17:54:48.1813142Z [command]/usr/bin/git config --local --unset-all extensions.worktreeConfig
verify-live-update	UNKNOWN STEP	2026-07-18T17:54:48.1840516Z ##[group]Checking out the ref
verify-live-update	UNKNOWN STEP	2026-07-18T17:54:48.1844001Z [command]/usr/bin/git checkout --progress --force -B main refs/remotes/origin/main
verify-live-update	UNKNOWN STEP	2026-07-18T17:54:48.3872436Z Switched to a new branch 'main'
verify-live-update	UNKNOWN STEP	2026-07-18T17:54:48.3874246Z branch 'main' set up to track 'origin/main'.
verify-live-update	UNKNOWN STEP	2026-07-18T17:54:48.3882781Z ##[endgroup]
verify-live-update	UNKNOWN STEP	2026-07-18T17:54:48.3917689Z [command]/usr/bin/git log -1 --format=%H
verify-live-update	UNKNOWN STEP	2026-07-18T17:54:48.3941671Z 31206e72d5b761bc3044d6088d7cc0f95e29721e
verify-live-update	UNKNOWN STEP	2026-07-18T17:54:48.4114816Z ##[group]Run set -euo pipefail
verify-live-update	UNKNOWN STEP	2026-07-18T17:54:48.4115486Z ^[[36;1mset -euo pipefail^[[0m
verify-live-update	UNKNOWN STEP	2026-07-18T17:54:48.4116050Z ^[[36;1mexpected_asset="$(jq -r '.assetName' marketplace-site/public/client/windows/latest.json)"^[[0m
verify-live-update	UNKNOWN STEP	2026-07-18T17:54:48.4116578Z ^[[36;1m^[[0m
verify-live-update	UNKNOWN STEP	2026-07-18T17:54:48.4116943Z ^[[36;1mfor attempt in $(seq 1 20); do^[[0m
verify-live-update	UNKNOWN STEP	2026-07-18T17:54:48.4117338Z ^[[36;1m  headers="$(mktemp)"^[[0m
verify-live-update	UNKNOWN STEP	2026-07-18T17:54:48.4117775Z ^[[36;1m  if curl --silent --show-error --fail --head \^[[0m
verify-live-update	UNKNOWN STEP	2026-07-18T17:54:48.4118265Z ^[[36;1m    --header 'Cache-Control: no-store' \^[[0m
verify-live-update	UNKNOWN STEP	2026-07-18T17:54:48.4118664Z ^[[36;1m    --output /dev/null \^[[0m
verify-live-update	UNKNOWN STEP	2026-07-18T17:54:48.4119068Z ^[[36;1m    --dump-header "$headers" \^[[0m
verify-live-update	UNKNOWN STEP	2026-07-18T17:54:48.4119803Z ^[[36;1m    "https://klite-marketplace.pages.dev/download/windows?deployment_probe=${GITHUB_RUN_ID}-${attempt}"; then^[[0m
verify-live-update	UNKNOWN STEP	2026-07-18T17:54:48.4120726Z ^[[36;1m    live_asset="$(awk -F': ' 'tolower($1) == "x-klite-installer-asset" {gsub("\\r", "", $2); print $2}' "$headers" | tail -n 1)"^[[0m
verify-live-update	UNKNOWN STEP	2026-07-18T17:54:48.4121354Z ^[[36;1m    if [ "$live_asset" = "$expected_asset" ]; then^[[0m
verify-live-update	UNKNOWN STEP	2026-07-18T17:54:48.4121876Z ^[[36;1m      echo "The live Pages Function is serving the expected asset: $live_asset"^[[0m
verify-live-update	UNKNOWN STEP	2026-07-18T17:55:03.7227826Z Attempt 2: live asset '' does not yet match 'KLite-Setup-1.0.90-93c9fda1d285be25.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T17:55:18.8020831Z Attempt 3: live asset '' does not yet match 'KLite-Setup-1.0.90-93c9fda1d285be25.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T17:55:33.8786538Z Attempt 4: live asset '' does not yet match 'KLite-Setup-1.0.90-93c9fda1d285be25.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T17:55:48.9448064Z Attempt 5: live asset '' does not yet match 'KLite-Setup-1.0.90-93c9fda1d285be25.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T17:56:04.0280275Z Attempt 6: live asset '' does not yet match 'KLite-Setup-1.0.90-93c9fda1d285be25.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T17:56:19.0884294Z Attempt 7: live asset '' does not yet match 'KLite-Setup-1.0.90-93c9fda1d285be25.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T17:56:34.1410768Z Attempt 8: live asset '' does not yet match 'KLite-Setup-1.0.90-93c9fda1d285be25.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T17:56:49.2006925Z Attempt 9: live asset '' does not yet match 'KLite-Setup-1.0.90-93c9fda1d285be25.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T17:57:04.2672169Z Attempt 10: live asset '' does not yet match 'KLite-Setup-1.0.90-93c9fda1d285be25.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T17:57:19.3240002Z Attempt 11: live asset '' does not yet match 'KLite-Setup-1.0.90-93c9fda1d285be25.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T17:57:34.3873364Z Attempt 12: live asset '' does not yet match 'KLite-Setup-1.0.90-93c9fda1d285be25.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T17:57:49.4571550Z Attempt 13: live asset '' does not yet match 'KLite-Setup-1.0.90-93c9fda1d285be25.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T17:58:04.5265555Z Attempt 14: live asset '' does not yet match 'KLite-Setup-1.0.90-93c9fda1d285be25.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T17:58:19.5843376Z Attempt 15: live asset '' does not yet match 'KLite-Setup-1.0.90-93c9fda1d285be25.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T17:58:34.6420062Z Attempt 16: live asset '' does not yet match 'KLite-Setup-1.0.90-93c9fda1d285be25.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T17:58:49.7060260Z Attempt 17: live asset '' does not yet match 'KLite-Setup-1.0.90-93c9fda1d285be25.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T17:59:04.7864300Z Attempt 18: live asset '' does not yet match 'KLite-Setup-1.0.90-93c9fda1d285be25.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T17:59:19.8818336Z Attempt 19: live asset '' does not yet match 'KLite-Setup-1.0.90-93c9fda1d285be25.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T17:59:34.9516608Z Attempt 20: live asset '' does not yet match 'KLite-Setup-1.0.90-93c9fda1d285be25.exe'.
verify-live-update	UNKNOWN STEP	2026-07-18T17:59:49.9538290Z Cloudflare Pages did not publish the expected download function in time.
verify-live-update	UNKNOWN STEP	2026-07-18T17:59:49.9553248Z ##[error]Process completed with exit code 1.
verify-live-update	UNKNOWN STEP	2026-07-18T17:59:49.9711103Z Node 20 is being deprecated. This workflow is running with Node 24 by default. If you need to temporarily use Node 20, you can set the ACTIONS_ALLOW_USE_UNSECURE_NODE_VERSION=true environment variable. For more information see: https://github.blog/changelog/2025-09-19-deprecation-of-node-20-on-github-actions-runners/
verify-live-update	UNKNOWN STEP	2026-07-18T17:59:49.9713079Z Post job cleanup.
verify-live-update	UNKNOWN STEP	2026-07-18T17:59:50.0545161Z [command]/usr/bin/git version
verify-live-update	UNKNOWN STEP	2026-07-18T17:59:50.0578347Z git version 2.54.0
verify-live-update	UNKNOWN STEP	2026-07-18T17:59:50.0621019Z Temporarily overriding HOME='/home/runner/work/_temp/e87a5187-d7c8-4bcc-8637-f048ca07f71c' before making global git config changes
verify-live-update	UNKNOWN STEP	2026-07-18T17:59:50.0622599Z Adding repository directory to the temporary git global config as a safe directory
verify-live-update	UNKNOWN STEP	2026-07-18T17:59:50.0625013Z [command]/usr/bin/git config --global --add safe.directory /home/runner/work/klite/klite
```

