package tn.ksoftwares.hexagonal.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class ApplicationConventionPlugin: Plugin<Project> {
    override fun apply(project: Project) {
        // Apply the common convention plugin for shared build configuration between library and application projects.
        project.plugins.apply("tn.ksoftwares.hexagonal.common")
        project.plugins.apply("application")

    }
}