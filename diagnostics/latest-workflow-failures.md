# Recent GitHub Actions failures

Generated: 2026-07-17T23:01:31.638546+00:00
Repository: `KSPOG/klite`
Failed runs inspected: **15**

## CI: Clean obsolete workflow runs after SDK publication

- Run: [29619210710](https://github.com/KSPOG/klite/actions/runs/29619210710)
- Conclusion: `failure`
- Event: `push`
- Commit: `ffc8d1107ae54e8265f057b0d1275fb178c1b417`
- Created: `2026-07-17T22:53:59Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log lines

```text
build	Build and Test	2026-07-17T22:54:44.0618766Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:54:44.0620999Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:44.0624229Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:54:44.0626944Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:44.0629805Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:54:44.0632052Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:44.0634879Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:54:44.0637207Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:44.0640200Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:54:44.0646264Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:44.0653020Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:54:44.0655565Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:44.0659084Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:54:44.0661161Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:44.0663957Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:54:44.0666585Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:44.0669903Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:54:44.0672568Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:44.6644548Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T22:54:44.6649034Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T22:55:06.2620854Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:55:06.2797750Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:55:06.9657546Z 2 errors
build	Build and Test	2026-07-17T22:55:07.0695453Z > Task :client:compileTestJava FAILED
build	Build and Test	2026-07-17T22:55:15.7617679Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T22:55:15.7620816Z Execution failed for task ':client:compileTestJava'.
build	Build and Test	2026-07-17T22:55:15.7621722Z > Compilation failed; see the compiler error output for details.
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

### Relevant log lines

```text
build-sdk	Compile generated standalone starter	2026-07-17T22:56:32.0555593Z ^[[36;1m    raise SystemExit("Generated starter plugin is missing runelite_plugin.json")^[[0m
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2289775Z FAILURE: Build failed with an exception.
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2326909Z * Exception is:
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2328438Z org.gradle.api.InvalidUserCodeException: Build was configured to prefer settings repositories over project repositories but repository 'MavenRepo' was added by build file 'build.gradle.kts'
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2578595Z 	at org.gradle.tooling.internal.provider.SessionFailureReportingActionExecuter.execute(SessionFailureReportingActionExecuter.java:51)
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2580130Z 	at org.gradle.tooling.internal.provider.SessionFailureReportingActionExecuter.execute(SessionFailureReportingActionExecuter.java:39)
build-sdk	Compile generated standalone starter	2026-07-17T22:56:44.2613509Z 	at org.gradle.internal.concurrent.ExecutorPolicy$CatchAndRecordFailures.onExecute(ExecutorPolicy.java:64)
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

### Relevant log lines

```text
build	Build and Test	2026-07-17T22:54:26.8375864Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:54:26.8419554Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:26.8474634Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:54:26.8499273Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:26.8551878Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:54:26.8579250Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:26.8581635Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:54:26.8583654Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:26.8586235Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:54:26.8591860Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:26.8594330Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:54:26.8596719Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:26.8599849Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:54:26.8601765Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:26.8604309Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:54:26.8606425Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:26.8622966Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:54:26.8625276Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:54:27.5421916Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T22:54:27.5444855Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T22:54:48.6376596Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:54:48.6613252Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:54:49.2358811Z > Task :client:compileTestJava FAILED
build	Build and Test	2026-07-17T22:54:49.2478771Z 2 errors
build	Build and Test	2026-07-17T22:55:00.0363609Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T22:55:00.0364971Z Execution failed for task ':client:compileTestJava'.
build	Build and Test	2026-07-17T22:55:00.0365464Z > Compilation failed; see the compiler error output for details.
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

### Relevant log lines

```text
build	Build and Test	2026-07-17T22:52:19.7213711Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:52:19.7238109Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:52:19.7240690Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:52:19.7242855Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:52:19.7245295Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:52:19.7247617Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:52:19.7249999Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:52:19.7252218Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:52:19.7255008Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:52:19.7258044Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:52:19.7260732Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:52:19.7263007Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:52:19.7265587Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:52:19.7298049Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:52:19.7300833Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:52:19.7303155Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:52:19.7305878Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:52:19.7308409Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:52:20.4152516Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T22:52:20.4158005Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T22:52:41.5151255Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:52:41.5418819Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:52:42.3297777Z 2 errors
build	Build and Test	2026-07-17T22:52:42.4188154Z > Task :client:compileTestJava FAILED
build	Build and Test	2026-07-17T22:52:52.1156731Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T22:52:52.1168840Z Execution failed for task ':client:compileTestJava'.
build	Build and Test	2026-07-17T22:52:52.1169686Z > Compilation failed; see the compiler error output for details.
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

### Relevant log lines

```text
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.4143569Z FAILURE: Build failed with an exception.
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.4195001Z * Exception is:
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.4196023Z org.gradle.api.InvalidUserCodeException: Build was configured to prefer settings repositories over project repositories but repository 'MavenRepo' was added by build file 'build.gradle.kts'
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.5066079Z 	at org.gradle.tooling.internal.provider.SessionFailureReportingActionExecuter.execute(SessionFailureReportingActionExecuter.java:51)
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.5067089Z 	at org.gradle.tooling.internal.provider.SessionFailureReportingActionExecuter.execute(SessionFailureReportingActionExecuter.java:39)
build-sdk	Compile generated standalone starter	2026-07-17T22:47:39.5088542Z 	at org.gradle.internal.concurrent.ExecutorPolicy$CatchAndRecordFailures.onExecute(ExecutorPolicy.java:64)
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

### Relevant log lines

```text
build	Build and Test	2026-07-17T22:45:22.2183101Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:45:22.2222142Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:45:22.2312660Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:45:22.2315074Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:45:22.2317924Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:45:22.2320353Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:45:22.2382411Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:45:22.2412121Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:45:22.2472590Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:45:22.2492280Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:45:22.2496012Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:45:22.2498303Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:45:22.2522701Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:45:22.2525029Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:45:22.2527819Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:45:22.2530124Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:45:22.2533038Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:45:22.2535331Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:45:23.0193221Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T22:45:23.0204464Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T22:45:44.0201518Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:45:44.0292552Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:45:44.8222391Z > Task :client:compileTestJava FAILED
build	Build and Test	2026-07-17T22:45:44.8252125Z 2 errors
build	Build and Test	2026-07-17T22:45:55.2181347Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T22:45:55.2184456Z Execution failed for task ':client:compileTestJava'.
build	Build and Test	2026-07-17T22:45:55.2185521Z > Compilation failed; see the compiler error output for details.
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

### Relevant log lines

```text
build	Build and Test	2026-07-17T22:39:59.2974326Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:39:59.3007777Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:39:59.3043164Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:39:59.3075750Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:39:59.3137942Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:39:59.3167147Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:39:59.3197607Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:39:59.3247223Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:39:59.3268343Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:39:59.3271468Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:39:59.3278377Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:39:59.3280766Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:39:59.3284165Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:39:59.3286711Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:39:59.3289827Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:39:59.3292319Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:39:59.3295241Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:39:59.3297766Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:39:59.9970342Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T22:39:59.9978076Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T22:40:19.9978181Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:40:20.0167323Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:40:20.5976892Z > Task :client:compileTestJava FAILED
build	Build and Test	2026-07-17T22:40:20.6232323Z 2 errors
build	Build and Test	2026-07-17T22:40:31.1999032Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T22:40:31.2001114Z Execution failed for task ':client:compileTestJava'.
build	Build and Test	2026-07-17T22:40:31.2001955Z > Compilation failed; see the compiler error output for details.
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

### Relevant log lines

```text
build	Build and Test	2026-07-17T22:36:53.9347550Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:36:53.9376498Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:53.9437169Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:36:53.9456556Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:53.9547134Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:36:53.9576513Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:53.9636868Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:36:53.9666533Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:53.9717419Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:36:53.9740211Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:53.9743622Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:36:53.9746533Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:53.9749534Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:36:53.9751847Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:53.9764412Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:36:53.9767236Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:53.9770257Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:36:53.9772759Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:54.7326842Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T22:36:54.7329098Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T22:37:16.1317104Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:37:16.1467368Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:37:16.9406853Z > Task :client:compileTestJava FAILED
build	Build and Test	2026-07-17T22:37:16.9465756Z 2 errors
build	Build and Test	2026-07-17T22:37:26.0376129Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T22:37:26.0417659Z Execution failed for task ':client:compileTestJava'.
build	Build and Test	2026-07-17T22:37:26.0418930Z > Compilation failed; see the compiler error output for details.
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

### Relevant log lines

```text
build	Build and Test	2026-07-17T22:36:46.9660009Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:36:46.9678210Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:46.9737193Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:36:46.9769111Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:46.9799719Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:36:46.9832964Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:46.9866677Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:36:46.9869693Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:46.9873156Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:36:46.9881239Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:46.9884399Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:36:46.9887026Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:46.9919013Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:36:46.9921394Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:46.9924365Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:36:46.9926770Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:46.9930092Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:36:46.9932540Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:36:47.8631720Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T22:36:47.8636581Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T22:37:10.9709829Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:37:10.9939139Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:37:11.6689114Z > Task :client:compileTestJava FAILED
build	Build and Test	2026-07-17T22:37:11.6719065Z 2 errors
build	Build and Test	2026-07-17T22:37:22.2638051Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T22:37:22.2639988Z Execution failed for task ':client:compileTestJava'.
build	Build and Test	2026-07-17T22:37:22.2640795Z > Compilation failed; see the compiler error output for details.
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

### Relevant log lines

```text
build	Build and Test	2026-07-17T22:33:12.6788906Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:33:12.6807659Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:33:12.6868149Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:33:12.6870495Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:33:12.6873118Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:33:12.6875307Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:33:12.6878067Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:33:12.6880261Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:33:12.6883052Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:33:12.6886072Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:33:12.6889072Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:33:12.6910158Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:33:12.6913338Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:33:12.6915886Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:33:12.6918721Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:33:12.6921064Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:33:12.6923793Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:33:12.6926109Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:33:13.4780291Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T22:33:13.4785752Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T22:33:35.8789573Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:33:35.8897705Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:33:36.7876952Z 2 errors
build	Build and Test	2026-07-17T22:33:36.8788051Z > Task :client:compileTestJava FAILED
build	Build and Test	2026-07-17T22:33:47.5779141Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T22:33:47.5779875Z Execution failed for task ':client:compileTestJava'.
build	Build and Test	2026-07-17T22:33:47.5780335Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-17T22:33:47.5782159Z BUILD FAILED in 1m 5s
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

### Relevant log lines

```text
build-sdk	Compile generated standalone starter	2026-07-17T22:35:38.3425573Z FAILURE: Build failed with an exception.
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

### Relevant log lines

```text
build	Build and Test	2026-07-17T22:32:48.0817666Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:32:48.0836792Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:48.0867830Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:32:48.0896682Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:48.0937508Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:32:48.0966879Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:48.1017005Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:32:48.1046782Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:48.1077331Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:32:48.1110022Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:48.1136408Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:32:48.1138904Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:48.1141826Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:32:48.1144059Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:48.1147129Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:32:48.1149604Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:48.1152747Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:32:48.1155262Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:48.6801696Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T22:32:48.6818276Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T22:33:08.5787428Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:33:08.5897064Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:33:09.1966012Z 2 errors
build	Build and Test	2026-07-17T22:33:09.2796503Z > Task :client:compileTestJava FAILED
build	Build and Test	2026-07-17T22:33:19.4783466Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T22:33:19.4793476Z Execution failed for task ':client:compileTestJava'.
build	Build and Test	2026-07-17T22:33:19.4796597Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-17T22:33:19.4798117Z BUILD FAILED in 57s
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

### Relevant log lines

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

### Relevant log lines

```text
build	Build and Test	2026-07-17T22:32:11.0078445Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:32:11.0129587Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:11.0200416Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:32:11.0231079Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:11.0393489Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:32:11.0469712Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:11.0569897Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:32:11.0599576Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:11.0602817Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:32:11.0606195Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:11.0609458Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:32:11.0611617Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:11.0614034Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:32:11.0615907Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:11.0648711Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:32:11.0651149Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:11.0653821Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:32:11.0656105Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:11.7100308Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T22:32:11.7190639Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T22:32:34.3077894Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:32:34.3309714Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:32:34.8157231Z 2 errors
build	Build and Test	2026-07-17T22:32:34.9099047Z > Task :client:compileTestJava FAILED
build	Build and Test	2026-07-17T22:32:44.4099042Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T22:32:44.4100932Z Execution failed for task ':client:compileTestJava'.
build	Build and Test	2026-07-17T22:32:44.4101733Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-17T22:32:44.4104092Z BUILD FAILED in 1m 3s
build	Build and Test	2026-07-17T22:32:44.9263305Z ##[error]Process completed with exit code 1.
```

## CI: Add plugin starter ignore rules

- Run: [29618120553](https://github.com/KSPOG/klite/actions/runs/29618120553)
- Conclusion: `failure`
- Event: `push`
- Commit: `139b447586d96d17fcdcbe66418c08d397931137`
- Created: `2026-07-17T22:31:03Z`

### Failed jobs and steps

- **build** — `failure`
  - Step 6: **Build and Test** — `failure`

### Relevant log lines

```text
build	Build and Test	2026-07-17T22:32:40.0325134Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:32:40.0361621Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:40.0378885Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:32:40.0381487Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:40.0385618Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:60: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:32:40.0389390Z 	public void play(File file, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:40.0402232Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:32:40.0405552Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:40.0408811Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:32:40.0411466Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:40.0414928Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:73: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:32:40.0417583Z 	public void play(Class<?> c, String path, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:40.0420562Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for java.io.IOException
build	Build and Test	2026-07-17T22:32:40.0422905Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:40.0426314Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.UnsupportedAudioFileException
build	Build and Test	2026-07-17T22:32:40.0429051Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:40.0432466Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/audio/AudioPlayer.java:85: warning: no @throws for javax.sound.sampled.LineUnavailableException
build	Build and Test	2026-07-17T22:32:40.0435682Z 	public void play(InputStream stream, float gain) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
build	Build and Test	2026-07-17T22:32:40.8325062Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for title
build	Build and Test	2026-07-17T22:32:40.8331179Z /home/runner/work/klite/klite/runelite-client/build/generated/sources/delombok/java/main/net/runelite/client/ui/components/PluginErrorPanel.java:69: warning: no @param for description
build	Build and Test	2026-07-17T22:33:04.7325773Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:33:04.7475283Z /home/runner/work/klite/klite/runelite-client/src/test/java/net/runelite/client/plugins/klite/walker/pathfinder/StaticCollisionMapTest.java:21: error: cannot find symbol
build	Build and Test	2026-07-17T22:33:05.4326155Z > Task :client:compileTestJava FAILED
build	Build and Test	2026-07-17T22:33:05.4444336Z 2 errors
build	Build and Test	2026-07-17T22:33:10.4327980Z FAILURE: Build failed with an exception.
build	Build and Test	2026-07-17T22:33:10.4330913Z Execution failed for task ':client:compileTestJava'.
build	Build and Test	2026-07-17T22:33:10.4332201Z > Compilation failed; see the compiler error output for details.
build	Build and Test	2026-07-17T22:33:10.4334909Z BUILD FAILED in 1m 46s
build	Build and Test	2026-07-17T22:33:10.9099507Z ##[error]Process completed with exit code 1.
```

