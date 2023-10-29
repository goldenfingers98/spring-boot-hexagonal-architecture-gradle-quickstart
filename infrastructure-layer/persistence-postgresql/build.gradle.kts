plugins {
    id("tn.ksoftwares.hexagonal.library") version InfrastructureVersions.PLUGIN_VERSION
}

dependencies {
    api("${ProjectArtifact.GROUP}:core:${InfrastructureVersions.DOMAIN_CORE_VERSION}")
    api("org.springframework.boot:spring-boot-starter-data-jpa:${CommonVersions.SPRING_VERSION}")
    api("org.hibernate:hibernate-core:${InfrastructureVersions.HIBERNATE_VERSION}")
    api("org.hibernate:hibernate-entitymanager:${InfrastructureVersions.HIBERNATE_VERSION}")
    runtimeOnly("org.postgresql:postgresql:${InfrastructureVersions.POSTGRES_VERSION}")
    testImplementation("com.h2database:h2:${InfrastructureVersions.H2_VERSION}")
    testImplementation("org.springframework.boot:spring-boot-starter-test:${CommonVersions.SPRING_VERSION}")

}

description = "persistence-postgresql"
