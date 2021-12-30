package me.zhenxin.qqbot.core;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import me.zhenxin.qqbot.entity.ws.Payload;
import me.zhenxin.qqbot.enums.Intent;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * WebSocket 客户端
 *
 * @author 真心
 * @since 2021/12/11 20:21
 */
@Slf4j
class WSClient extends WebSocketListener {
    private final WSEvent event;
    @Setter
    @Getter
    private String token;
    @Setter
    @Getter
    private List<Intent> intents;
    @Setter
    @Getter
    private EventHandler eventHandler;
    @Getter
    private Integer seq;
    @Getter
    private Boolean open = false;

    private final String url;
    private WebSocket ws = null;

    public WSClient(String url) {
        this.url = url;
        event = new WSEvent();
        event.setClient(this);
    }

    @Override
    public void onClosed(@NotNull WebSocket webSocket, int code, @NotNull String reason) {
        event.onClientClose(code, reason);
    }

    @Override
    public void onClosing(@NotNull WebSocket webSocket, int code, @NotNull String reason) {
        open = false;
    }

    @Override
    public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable t, @Nullable Response response) {
        log.info("发生错误: " + t.getMessage());
        t.printStackTrace();
        event.onClientClose(4000, "error");
    }

    @Override
    public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
        log.debug("收到消息: " + text);
        Payload payload = JSON.parseObject(text, Payload.class);
        if (payload.getS() != null) seq = payload.getS();
        switch (payload.getOp()) {
            case 0:
                event.onDispatch(payload);
                break;
            case 7:
                event.onReconnect();
                break;
            case 9:
                event.onInvalidSession();
                break;
            case 10:
                event.onHello(payload);
                break;
            case 11:
                event.onHeartbeatACK();
                break;
            default:
                log.warn("未知消息类型: OpCode " + payload.getOp());
        }
    }

    @Override
    public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
        Thread.currentThread().setName("WebSocket");
        log.info("连接成功!");
        open = true;
    }

    public void connect() {
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().get().url(url).build();
        ws = client.newWebSocket(request, this);
    }

    public void reconnect() {
        connect();
    }

    public void send(String text) {
        log.debug("发送消息: " + text);
        ws.send(text);
    }
}
