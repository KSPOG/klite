plugins {
    java
}

group = "com.kspog.klite"
version = "0.3.13"

val pluginId = "klite-ge-flipper"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

dependencies {
    compileOnly(project(":client"))
}

checkstyle {
    configFile = rootProject.file("config/checkstyle/checkstyle.xml")
}

tasks.withType<org.gradle.api.plugins.quality.Checkstyle>().configureEach {
    configDirectory.set(rootProject.layout.projectDirectory.dir("config/checkstyle"))
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
    options.release.set(11)
}

tasks.processResources {
    filesMatching("runelite_plugin.json") {
        expand(
            "pluginId" to pluginId,
            "pluginDisplayName" to "KLite GE Flipper",
            "pluginVersion" to project.version.toString(),
            "pluginAuthor" to "Choken, afss0, KSP Plugins",
            "pluginDescription" to "KLite API port of the Flipping Copilot automation helper.",
            "pluginMainClass" to "com.kspog.klite.geflipper.KLiteGeFlipperPlugin"
        )
    }
}

tasks.jar {
    archiveFileName.set("$pluginId-${project.version}.jar")
    isPreserveFileTimestamps = false
    isReproducibleFileOrder = true
}
