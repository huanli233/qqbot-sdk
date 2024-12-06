package me.zhenxin.qqbot.entity.message.ark

/**
 * MessageArkKv
 */
data class MessageArkKv(
    val key: String,
    val value: String,
    val obj: List<MessageArkObj>?
)
