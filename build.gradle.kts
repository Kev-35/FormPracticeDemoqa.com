plugins {
    id("java")
}

group = "ru.kev35"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("com.codeborne:selenide:7.10.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.13.0")
    testImplementation("org.junit.platform:junit-platform-launcher")
    testRuntimeOnly("org.slf4j:slf4j-simple:2.0.17")
}

tasks.test {
    useJUnitPlatform()
}