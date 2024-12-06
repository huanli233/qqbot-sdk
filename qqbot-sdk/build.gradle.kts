plugins {
    kotlin("jvm")
}

dependencies {
    api(project(":qqbot-api"))
    api(project(":qqbot-websocket"))
    api(project(":qqbot-logging"))
}
