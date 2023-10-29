/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    // Support convention plugins written in Kotlin. Convention plugins are build scripts in 'src/main' that automatically become available as plugins in the main build.
    `kotlin-dsl`
    `maven-publish`
}

repositories {
    // Use the plugin portal to apply community plugins in convention plugins.
    gradlePluginPortal()
}

val projectGroup = "tn.ksoftwares.hexagonal"

gradlePlugin {
    plugins {
        create("common-convention") {
            id = "$projectGroup.common"
            implementationClass = "$projectGroup.plugin.CommonConventionPlugin"
        }
        create("library-convention") {
            id = "$projectGroup.library"
            implementationClass = "$projectGroup.plugin.LibraryConventionPlugin"
        }
        create("application-convention") {
            id = "$projectGroup.application"
            implementationClass = "$projectGroup.plugin.ApplicationConventionPlugin"
        }
    }
}

group = projectGroup
version = "1.0.0"
