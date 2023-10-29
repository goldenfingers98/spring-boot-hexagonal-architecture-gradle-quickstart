package tn.ksoftwares.hexagonal.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class LibraryConventionPlugin: Plugin<Project> {
    override fun apply(project: Project) {
        // Apply the common convention plugin for shared build configuration between library and application projects.
        project.plugins.apply("tn.ksoftwares.hexagonal.common")

        // Apply the java-library plugin for API and implementation separation.
        project.plugins.apply("java-library")

    }
}