rootProject.name = "qqbot-sdk"

pluginManagement {
    plugins {
        kotlin("jvm") version "2.0.21"
    }
}

include(
    ":qqbot-api",
    ":qqbot-common",
    ":qqbot-logging",
    ":qqbot-sdk",
    ":qqbot-websocket"
)
