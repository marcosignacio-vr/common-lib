plugins {
    kotlin("jvm") version "1.9.25"
    `maven-publish`
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.github.marcosignacio-vr"
version = "0.0.3"

repositories {
    mavenCentral()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"]) // incluye tu código Kotlin compilado
            artifactId = "common-lib"
            groupId ="com.github.marcosignacio-vr"
            version = "0.0.3"
        }
    }

}
dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:3.5.6")
    }
}
dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter-web")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}