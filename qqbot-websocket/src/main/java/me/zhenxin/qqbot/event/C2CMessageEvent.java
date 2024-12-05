package me.zhenxin.qqbot.event;

import lombok.Getter;
import me.zhenxin.qqbot.entity.Message;

import java.util.EventObject;

@Getter
public class C2CMessageEvent extends EventObject {
    private final Message message;

    public C2CMessageEvent(Object source, Message message) {
        super(source);
        this.message = message;
    }
}
