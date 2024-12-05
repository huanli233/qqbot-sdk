package me.zhenxin.qqbot.api.impl;

import me.zhenxin.qqbot.api.BaseApi;
import me.zhenxin.qqbot.entity.AccessInfo;
import me.zhenxin.qqbot.entity.Message;
import me.zhenxin.qqbot.entity.MessageEmbed;
import me.zhenxin.qqbot.entity.MessageMarkdown;
import me.zhenxin.qqbot.entity.ark.MessageArk;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class C2CMessageApi extends BaseApi {

    public C2CMessageApi(AccessInfo accessInfo) {
        super(accessInfo);
    }

    /**
     * 发送私聊文字消息
     */
    public Message sendMessage(String openId, String content, String messageId) {
        Map<String, Object> data = new HashMap<>();
        data.put("content", content);
        data.put("msg_type", 0);
        data.put("msg_id", messageId);
        return sendMessage(openId, data);
    }

    /**
     * 发送私聊Ark消息
     */
    public Message sendMessage(String groupOpenId, MessageArk ark, String messageId) {
        Map<String, Object> data = new HashMap<>();
        data.put("ark", ark);
        data.put("msg_type", 3);
        data.put("msg_id", messageId);
        return sendMessage(groupOpenId, data);
    }

    /**
     * 发送私聊Embed消息
     */
    public Message sendMessage(String openId, MessageEmbed embed, String messageId) {
        Map<String, Object> data = new HashMap<>();
        data.put("embed", embed);
        data.put("msg_type", 4);
        data.put("msg_id", messageId);
        return sendMessage(openId, data);
    }

    /**
     * 发送私聊Markdown消息
     */
    public Message sendMessage(String openId, MessageMarkdown markdown) {
        Map<String, Object> data = new HashMap<>();
        data.put("msg_type", 2);
        data.put("markdown", markdown);
        return sendMessage(openId, data);
    }

    private Message sendMessage(String openId, Map<String, Object> data) {
        return post("/v2/users/" + openId + "/messages", data, Message.class);
    }

}
