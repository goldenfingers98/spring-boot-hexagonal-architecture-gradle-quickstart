rootProject.name = "ms-bootloader"
include("launcher")

val externalProjectsPaths = arrayOf(
    "../domain-layer",
    "../infrastructure-layer",
    "../application-layer",
    "../plugins"
)

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositories {
        mavenLocal()
        mavenCentral()
    }
    externalProjectsPaths.filter { File(it).exists() }
        .forEach { includeBuild(it) }
}

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenLocal()
    }
}