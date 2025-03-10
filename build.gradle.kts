plugins {
    kotlin("jvm") version "2.0.21"

    // Plugin para serializar
    kotlin("plugin.serialization") version "1.6.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    // LOGGER
    implementation("org.lighthousegames:logging:1.5.0")
    implementation("ch.qos.logback:logback-classic:1.5.12")

    //DOKKA
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:2.0.0")

    // Serializable JSON
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
    // Serializable XML
    implementation("io.github.pdvrieze.xmlutil:serialization-jvm:0.90.3")
    //MockK
    testImplementation("io.mockk:mockk:1.13.16")
}

tasks.test {
    useJUnitPlatform()
}
tasks.jar {
    manifest {
        attributes["Main-Class"] = "MainKt"
    }
    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
    archiveFileName.set("Proyecto-Futbol.jar")
}
kotlin {
    jvmToolchain(21)
}