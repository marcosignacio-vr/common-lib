plugins {
    kotlin("jvm") version "1.9.25"
    `maven-publish`
}

group = "com.github.marcosignacio-vr"
version = "0.0.2"

repositories {
    mavenCentral()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"]) // incluye tu código Kotlin compilado
            artifactId = "common-lib"
            groupId ="com.github.marcosignacio-vr"
            version = "0.0.2"
        }
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