rootProject.name = "infrastructure-layer"

include("persistence-postgresql")

val externalProjectsPaths = arrayOf(
    "../domain-layer",
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
