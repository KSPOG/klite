plugins {
    java
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

tasks.jar {
    archiveFileName = "klite-copper-tin-miner-1.0.0.jar"
}
