plugins {
    kotlin("android") version "2.1.0" apply false
}


buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal() // Ensures all plugins are resolved properly
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.2") // Update Gradle version if needed
        classpath("com.google.gms:google-services:4.3.15") // Firebase plugin
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:2.1.0")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

val newBuildDir: Directory = rootProject.layout.buildDirectory.dir("../../build").get()
rootProject.layout.buildDirectory.value(newBuildDir)

subprojects {
    val newSubprojectBuildDir: Directory = newBuildDir.dir(project.name)
    project.layout.buildDirectory.value(newSubprojectBuildDir)
}
subprojects {
    project.evaluationDependsOn(":app")
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}
