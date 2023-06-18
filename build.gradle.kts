import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.22"
    // подключить плагин Spring
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

val springVersion = "2.7.6"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.22")
    implementation("org.springframework.boot:spring-boot-starter-web:3.1.0")
}

tasks.test {
    useJUnitPlatform()
}

//tasks.withType<KotlinCompile> {
//    kotlinOptions.jvmTarget = "1.8"
//}

application {
    mainClass.set("MainKt")
}