plugins {
    kotlin("jvm")
}

dependencies {
    api(project(":qqbot-common"))

    api(libs.okhttp)
    api(libs.fastjson.kotlin)
    api(libs.kotlin.logging)
}