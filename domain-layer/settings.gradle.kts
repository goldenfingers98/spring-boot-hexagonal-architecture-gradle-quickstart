rootProject.name = "domain-layer"
include("model")
include("core")

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositories {
        mavenLocal()
        mavenCentral()
    }
}

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenLocal()
    }

    listOf("../plugins").filter { File(it).exists() }
        .forEach {
            includeBuild(it)
        }
}
