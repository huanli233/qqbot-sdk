package me.zhenxin.qqbot.entity.message.ark

/**
 * MessageArk
 */
data class MessageArk(
    /**
     * 模板ID
     */
    val templateId: Int,
    val kv: List<MessageArkKv>
)
