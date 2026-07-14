# Maintaining the RuneLite base

The repository keeps the official RuneLite repository as the `upstream` remote.
KLite changes should remain small and isolated so updates can be reviewed rather
than accepted blindly.

## Update procedure

```powershell
git fetch upstream master
git switch main
git merge --no-ff upstream/master
.\gradlew.bat :client:compileJava
.\gradlew.bat :client:test
```

Before merging an update:

1. Read the upstream commits and release notes.
2. Resolve conflicts in favor of upstream behavior unless a documented KLite
   requirement applies.
3. Confirm that `KLite`, `KLite Core`, the `runKLite` task, and the shaded
   JAR manifest still point to the KLite-owned entry point.
4. Compile and run the relevant tests before publishing.

Do not import Microbot commits or packages. Architectural research is acceptable;
KLite implementation must remain project-owned or come from RuneLite under its
existing license and attribution.
