package cdu.zch.demo11nettysocketio.handler;

import cdu.zch.demo11nettysocketio.config.DbTemplate;
import cdu.zch.demo11nettysocketio.config.Event;
import cdu.zch.demo11nettysocketio.payload.BroadcastMessageRequest;
import cdu.zch.demo11nettysocketio.payload.GroupMessageRequest;
import cdu.zch.demo11nettysocketio.payload.JoinRequest;
import cdu.zch.demo11nettysocketio.payload.SingleMessageRequest;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.ObjectUtil;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Zch
 **/
@Component
@Slf4j
public class MessageEventHandler {

    @Autowired
    private SocketIOServer server;

    @Autowired
    private DbTemplate dbTemplate;

    @OnConnect
    public void onConnect(SocketIOClient client) {
        if (client != null) {
            String token = client.getHandshakeData().getSingleUrlParam("token");
            // 模拟用户id和token一致
            String userId = client.getHandshakeData().getSingleUrlParam("token");
            UUID sessionId = client.getSessionId();

            dbTemplate.save(userId, sessionId);

            log.info("连接成功，[token] = {}, [sessionId] = {}", token, sessionId);
        } else {
            log.error("客户端为空");
        }
    }

    @OnDisconnect
    public void onDisConnect(SocketIOClient client) {
        if (client != null) {
            String token = client.getHandshakeData().getSingleUrlParam("token");
            // 模拟用户id和token一致
            String userId = client.getHandshakeData().getSingleUrlParam("token");
            UUID sessionId = client.getSessionId();

            dbTemplate.save(userId, sessionId);

            log.info("断开连接，[token] = {}, [sessionId] = {}", token, sessionId);
            client.disconnect();
        } else {
            log.error("客户端为空");
        }
    }

    @OnEvent(value = Event.JOIN)
    public void onJoinEvent(SocketIOClient client, AckRequest request, JoinRequest data) {
        log.info("用户：{} 已加入群聊：{}", data.getUserId(), data.getGroupId());
        client.joinRoom(data.getGroupId());

        server.getRoomOperations(data.getGroupId()).sendEvent(Event.JOIN, data);
    }

    @OnEvent(value = Event.CHAT)
    public void onChatEvent(SocketIOClient client, AckRequest request, SingleMessageRequest data) {
        Optional<UUID> toUser = dbTemplate.findByUserId(data.getToUid());
        if(toUser.isPresent()) {
            log.info("用户 {} 向用户 {} 发送了: {}", data.getFromUid(), data.getToUid(), data.getMessage());
            sendToSingle(toUser.get(), data);
            request.sendAckData(Dict.create().set("flag", true).set("message", "发送成功"));
        } else {
            request.sendAckData(Dict.create().set("flag", false).set("message", "发送成败，对方不想理你！"));
        }
    }

    @OnEvent(value = Event.GROUP)
    public void OnGroupEvent(SocketIOClient client, AckRequest request, GroupMessageRequest data) {
        Collection<SocketIOClient> clients = server.getRoomOperations(data.getGroupId()).getClients();

        boolean inGroup = false;
        for (SocketIOClient c: clients) {
            if (ObjectUtil.equal(c.getSessionId(), client.getSessionId())) {
                inGroup = true;
                break;
            }
        }
        if (inGroup) {
            log.info("群号 {} 收到来自 {} 的群聊消息：{}", data.getGroupId(), data.getFromUid(), data.getMessage());
            sendToGroup(data);
        } else {
            request.sendAckData("请先加群！");
        }
    }

    public void sendToSingle(UUID sessionId, SingleMessageRequest message) {
        server.getClient(sessionId).sendEvent(Event.CHAT, message);
    }

    public void sendToBroadcast(BroadcastMessageRequest message) {
        log.info("系统紧急广播一条通知：{}", message.getMessage());
        for (UUID id: dbTemplate.findAll()) {
            if (server.getClient(id) == null) {
                continue;
            }
            server.getClient(id).sendEvent(Event.BROADCAST, message);
        }
    }

    public void sendToGroup(GroupMessageRequest message) {
        server.getRoomOperations(message.getGroupId()).sendEvent(Event.GROUP, message);
    }
}
