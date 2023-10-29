package tn.ksoftwares.hexagonal.plugin

import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.api.tasks.javadoc.Javadoc
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.named
import org.gradle.kotlin.dsl.repositories
import org.gradle.kotlin.dsl.withType

class CommonConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.plugins.apply("java")
        project.plugins.apply("maven-publish")
        project.repositories {
            mavenLocal()
            mavenCentral()
        }
        project.dependencies.add("compileOnly", "org.projectlombok:lombok:${CommonVersions.LOMBOK_VERSION}")
        project.dependencies.add("annotationProcessor", "org.projectlombok:lombok:${CommonVersions.LOMBOK_VERSION}")
        // Use JUnit Jupiter for testing.
        project.dependencies.add("testImplementation","org.junit.jupiter:junit-jupiter:${CommonVersions.JUNIT_JUPITER_VERSION}")
        project.dependencies.add("testImplementation","junit:junit:${CommonVersions.JUNIT_VERSION}")
        project.dependencies.add("testCompileOnly","org.projectlombok:lombok:${CommonVersions.LOMBOK_VERSION}")
        project.dependencies.add("testAnnotationProcessor","org.projectlombok:lombok:${CommonVersions.LOMBOK_VERSION}")
        project.dependencies.add("testImplementation","nl.jqno.equalsverifier:equalsverifier:${CommonVersions.EQUALS_VERIFIER_VERSION}")


        project.group = ProjectArtifact.GROUP

        val publishing = project.extensions.getByType(PublishingExtension::class.java)
        publishing.publications {
            create<MavenPublication>("mavenJava") {
                from(project.components.findByName("java"))
                version = ProjectArtifact.VERSION
            }
        }

        project.tasks.named<Test>("test") {
            // Use JUnit Platform for unit tests.
            useJUnitPlatform()
        }

        project.tasks.withType(JavaCompile::class) {
            sourceCompatibility = JavaVersion.VERSION_11.toString()
            targetCompatibility = JavaVersion.VERSION_11.toString()
        }

        project.tasks.withType<JavaCompile>() {
            options.encoding = "UTF-8"
        }

        project.tasks.withType<Javadoc>() {
            options.encoding = "UTF-8"
        }
    }
}
