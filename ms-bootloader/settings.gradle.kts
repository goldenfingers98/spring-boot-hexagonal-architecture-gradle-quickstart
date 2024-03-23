rootProject.name = "ms-bootloader"
include("launcher")

val externalProjectsPaths = mapOf(
    "../domain-layer" to listOf(
        "tn.ksoftwares.hexagonal:core" to ":core"
    ),
    "../infrastructure-layer" to listOf(
        "tn.ksoftwares.hexagonal:persistence-postgresql" to ":persistence-postgresql"
    ),
    "../application-layer" to listOf(
        "tn.ksoftwares.hexagonal:rest" to ":rest"
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
