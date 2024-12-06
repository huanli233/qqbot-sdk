import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "2.0.10"
}

allprojects {
    group = "me.zhenxin"
    version = "2.0.0-dev"

    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        mavenLocal()
        gradlePluginPortal()
    }
}

subprojects {
    tasks.withType<KotlinCompile> {
        compilerOptions.jvmTarget.set(JvmTarget.JVM_17)
    }
}


