plugins {
    id("tn.ksoftwares.hexagonal.library") version ApplicationVersions.PLUGIN_VERSION
}

dependencies {
    api("org.springframework.boot:spring-boot-starter-web:${CommonVersions.SPRING_VERSION}")
    api("${ProjectArtifact.GROUP}:core:${ApplicationVersions.DOMAIN_CORE_VERSION}")
    api("org.springframework.security:spring-security-web:${ApplicationVersions.SPRING_SECURITY}")
    testImplementation("org.springframework.boot:spring-boot-starter-test:${CommonVersions.SPRING_VERSION}")
}

description = "rest"
