package me.zhenxin.qqbot.entity.message

data class MessageReference(
    /**
     * 消息ID
     */
    val messageId: String,
    
    /**
     * 是否忽略获取引用消息详情错误
     */
    val ignoreError: Boolean = false
)