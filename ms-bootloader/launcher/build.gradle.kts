plugins {
    id("tn.ksoftwares.hexagonal.application") version LauncherVersions.PLUGIN_VERSION
    id("org.springframework.boot") version LauncherVersions.SPRING_PLUGIN_VERSION
    id("io.spring.dependency-management") version LauncherVersions.SPRING_DEPENDENCY_MANAGEMENT_VERSION
}

dependencies {
    implementation("${ProjectArtifact.GROUP}:core:${LauncherVersions.DOMAIN_CORE_VERSION}")
    implementation("${ProjectArtifact.GROUP}:persistence-postgresql:${LauncherVersions.INFRASTRUCTURE_VERSION}")
    implementation("${ProjectArtifact.GROUP}:rest:${LauncherVersions.APPLICATION_VERSION}")
}

application {
    mainClass.set("${ProjectArtifact.GROUP}.Application")
}

tasks.jar {
    enabled = true
}

tasks.bootJar {
    archiveClassifier.set("application")
}


description = "ms-bootloader"
