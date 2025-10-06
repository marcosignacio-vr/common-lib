plugins {
    kotlin("jvm") version "1.9.25"
    `maven-publish`

}

group = "com.github.marcosignacio-vr"
version = "0.0.1"

repositories {
    mavenCentral()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"]) // incluye tu código Kotlin compilado
            artifactId = "common-lib"
            groupId ="com.github.marcosignacio-vr"
            version = "0.0.1"
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/marcosignacio-vr/common-lib")
            credentials {
                username = "marcosignacio-vr"
                password = ""
            }
        }
    }
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}