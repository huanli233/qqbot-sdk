package me.zhenxin.qqbot.entity.message

data class MessageEmbed(
    /**
     * 标题
     */
    val title: String,
    
    /**
     * 消息弹窗内容
     */
    val prompt: String,
    
    /**
     * 缩略图
     */
    val thumbnail: MessageEmbedThumbnail?,
    
    /**
     * MessageEmbedField 对象数组
     */
    val fields: List<MessageEmbedField>?
)