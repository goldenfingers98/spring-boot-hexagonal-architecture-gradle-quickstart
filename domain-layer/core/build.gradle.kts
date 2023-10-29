plugins {
    id("tn.ksoftwares.hexagonal.library") version DomainVersions.PLUGIN_VERSION
}


dependencies {
    api(project(":model"))
    api("org.springframework.boot:spring-boot-starter-aop:${CommonVersions.SPRING_VERSION}")
    api("org.springframework.boot:spring-boot-starter-validation:${CommonVersions.SPRING_VERSION}")
    testImplementation("org.springframework.boot:spring-boot-starter-test:${CommonVersions.SPRING_VERSION}")
}