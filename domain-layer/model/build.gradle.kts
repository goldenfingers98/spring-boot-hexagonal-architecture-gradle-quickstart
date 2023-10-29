plugins {
    id("tn.ksoftwares.hexagonal.library") version DomainVersions.PLUGIN_VERSION
}


dependencies {
    api("javax.validation:validation-api:${DomainVersions.VALIDATION_VERSION}")
    api("com.fasterxml.jackson.core:jackson-core:${DomainVersions.JACKSON_VERSION}")
    api("com.fasterxml.jackson.core:jackson-annotations:${DomainVersions.JACKSON_VERSION}")
    api("com.fasterxml.jackson.core:jackson-databind:${DomainVersions.JACKSON_VERSION}")
    api("org.springframework.boot:spring-boot-devtools:${CommonVersions.SPRING_VERSION}")
}