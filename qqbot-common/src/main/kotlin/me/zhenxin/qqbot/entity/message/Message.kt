package me.zhenxin.qqbot.entity.message

import me.zhenxin.qqbot.entity.Member
import me.zhenxin.qqbot.entity.User
import me.zhenxin.qqbot.entity.message.ark.MessageArk
import java.time.LocalDateTime

data class Message(
    /**
     * 消息ID
     */
    val id: String,

    /**
     * 子频道ID
     */
    val channelId: String?,

    /**
     * 频道ID
     */
    val guildId: String?,

    /**
     * 群聊ID
     */
    val groupId: String?,

    /**
     * 消息内容
     */
    val content: String?,

    /**
     * 消息创建时间
     */
    val timestamp: LocalDateTime,

    /**
     * 消息编辑时间
     */
    val editedTimestamp: LocalDateTime?,

    /**
     * 是否为 @全体成员 消息
     */
    val mentionEveryone: Boolean = false,

    /**
     * 消息创建人
     */
    val author: User,

    /**
     * 消息附件
     */
    val attachments: List<MessageAttachment>?,

    /**
     * Embed
     */
    val embeds: List<MessageEmbed>?,

    /**
     * 消息中@的人
     */
    val mentions: List<User> = emptyList(),

    /**
     * 消息创建者的信息
     */
    val member: Member?,

    /**
     * Ark消息
     */
    val ark: MessageArk?,

    /**
     * 消息序号
     * <p>
     * 子频道消息的序号，用于消息间的排序。<br/>
     * 在同一子频道中按从先到后的顺序递增。<br/>
     * 不同的子频道之间消息无法排序。
     * </p>
     */
    val seqInChannel: String?,

    /**
     * 引用消息
     */
    val messageReference: MessageReference?,

    /**
     * 来源频道ID
     * <p>
     * 用于私信场景下识别真实的来源频道。
     * </p>
     */
    val srcGuildId: String?
)