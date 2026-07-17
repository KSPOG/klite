import java.util.jar.JarFile

plugins {
    java
}

group = "com.example.klite"
version = "0.1.0"

val pluginId = "starter-plugin"
val pluginDisplayName = "Starter Plugin"
val pluginMainClass = "com.example.klite.StarterPlugin"
val pluginAuthor = "Your name"
val pluginDescription = "A standalone KLite plugin starter project."

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

dependencies {
    // Compile-only means none of these runtime classes are copied into the plugin JAR.
    compileOnly(files("libs/KLite-Plugin-SDK.jar"))
    compileOnly("com.google.inject:guice:5.1.0")
    compileOnly("javax.inject:javax.inject:1")
    compileOnly("org.slf4j:slf4j-api:1.7.36")
    compileOnly("com.google.code.findbugs:jsr305:3.0.2")

    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
    options.release.set(11)
}

tasks.processResources {
    filesMatching("runelite_plugin.json") {
        expand(
            mapOf(
                "pluginId" to pluginId,
                "pluginDisplayName" to pluginDisplayName,
                "pluginVersion" to project.version.toString(),
                "pluginAuthor" to pluginAuthor,
                "pluginDescription" to pluginDescription,
                "pluginMainClass" to pluginMainClass
            )
        )
    }
}

tasks.jar {
    archiveFileName.set("$pluginId-${project.version}.jar")
    isPreserveFileTimestamps = false
    isReproducibleFileOrder = true

    doLast {
        val output = archiveFile.get().asFile
        JarFile(output).use { jar ->
            require(jar.getEntry("runelite_plugin.json") != null) {
                "runelite_plugin.json is missing from ${output.name}"
            }
            val bundledRuntimeClasses = jar.entries().asSequence()
                .map { it.name }
                .filter {
                    it.startsWith("net/runelite/") ||
                        it.startsWith("com/google/inject/") ||
                        it.startsWith("javax/inject/")
                }
                .toList()
            require(bundledRuntimeClasses.isEmpty()) {
                "The plugin JAR must not bundle KLite/RuneLite runtime classes: $bundledRuntimeClasses"
            }
        }
        println("Verified standalone plugin JAR: ${output.absolutePath}")
    }
}

tasks.test {
    useJUnitPlatform()
}

val developmentPluginDirectory = file(
    System.getenv("KLITE_DEV_PLUGIN_DIR")
        ?: "${System.getProperty("user.home")}/.runelite/klite-dev-plugins"
)

tasks.register("installDevPlugin") {
    group = "KLite development"
    description = "Build and copy a versioned plugin JAR into the installed KLite development folder."
    dependsOn(tasks.jar)

    doLast {
        developmentPluginDirectory.mkdirs()
        val source = tasks.jar.get().archiveFile.get().asFile
        val target = developmentPluginDirectory.resolve(
            "$pluginId-${project.version}-${System.currentTimeMillis()}.jar"
        )
        source.copyTo(target, overwrite = false)
        println("Installed development plugin: ${target.absolutePath}")
        println("KLite will detect and reload it automatically when development plugins are enabled.")
    }
}

tasks.register("showDevPluginDirectory") {
    group = "KLite development"
    description = "Print the local KLite development plugin directory."
    doLast {
        println(developmentPluginDirectory.absolutePath)
    }
}
