package com.back.back.provider;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.back.back.entity.ChatMessageEntity;
import com.back.back.common.object.ChatMessage;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.back.back.repository.ChatMessageRepository;
import com.back.back.common.object.ChatMessageListItem;

import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import jakarta.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class SocketIOProvider {

    private final SocketIOServer socketIOServer;
    private final ChatMessageRepository chatMessageRepository;

    @PostConstruct
    private void startServer() {

        socketIOServer.addConnectListener(client -> System.out.println("Client connected : " + client.getSessionId()));
        socketIOServer.addDisconnectListener(client -> System.out.println("Client disconnected : " + client.getSessionId()));
        socketIOServer.addEventListener("senderMessage", ChatMessage.class, (sendClient, data, ackRequest) -> {
        
            List<SocketIOClient> clients = new ArrayList<>(socketIOServer.getAllClients());

            ChatMessageEntity chatMessageEntity = new ChatMessageEntity(data);
            chatMessageRepository.save(chatMessageEntity);

            ChatMessageListItem chatMessageListItem = new ChatMessageListItem(chatMessageEntity);
            for (SocketIOClient client : clients) {
            Set<String> rooms = client.getAllRooms();
            if (rooms.contains(data.getChatroomId().toString())) client.sendEvent("receiveMessage", chatMessageListItem);
        }});

        socketIOServer.addEventListener("joinRoom", String.class, (client, roomId, ackRequest) -> {
            client.joinRoom(roomId);
        });

        socketIOServer.addEventListener("leaveRoom", String.class, (client, roomId, ackRequest) -> {
            client.leaveRoom(roomId);
        });

        socketIOServer.start();
    }

    @PreDestroy
    private void stopServer() {
        
        socketIOServer.stop();
    }

}
