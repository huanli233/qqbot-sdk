plugins {
    kotlin("jvm")
}

dependencies {
    api(project(":qqbot-api"))
    api(project(":qqbot-common"))

    api(libs.fastjson.kotlin)
    api(libs.kotlin.logging)
    api(libs.java.websocket)
}