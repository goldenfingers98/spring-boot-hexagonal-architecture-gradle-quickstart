rootProject.name = "infrastructure-layer"

include("persistence-postgresql")

val externalProjectsPaths = mapOf(
    "../domain-layer" to listOf(
        "tn.ksoftwares.hexagonal:core" to ":core"
    )
)

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositories {
        mavenLocal()
        mavenCentral()
    }
    externalProjectsPaths.filter { File(it.key).exists() }
        .forEach {
            includeBuild(it.key) {
                dependencySubstitution {
                    it.value.forEach { sub ->
                        substitute(module(sub.first)).using(project(sub.second))
                    }
                }
            }
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
