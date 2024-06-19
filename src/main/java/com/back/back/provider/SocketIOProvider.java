package com.back.back.provider;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.back.back.common.object.ChatMessage;
import com.back.back.entity.ChatMessageEntity;
import com.back.back.repository.ChatMessageRepository;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SocketIOProvider {

  private final SocketIOServer socketIOServer;
  private final ChatMessageRepository chatMessageRepository;

  @PostConstruct
  private void startServer() {
    socketIOServer.addConnectListener(client -> System.out.println("Client connected : " + client.getSessionId()));
    socketIOServer
        .addDisconnectListener(client -> System.out.println("Client disconnected : " + client.getSessionId()));

    socketIOServer.addEventListener("senderMessage", ChatMessage.class, (sendClient, data, ackRequest) -> {
      List<SocketIOClient> clients = new ArrayList<>(socketIOServer.getAllClients());

      for (SocketIOClient client : clients) {
        Set<String> rooms = client.getAllRooms();
        if (rooms.contains(data.getRoomId().toString())) client.sendEvent("receiveMessage", data);
      }

      ChatMessageEntity chatMessageEntity = new ChatMessageEntity(data);
      chatMessageRepository.save(chatMessageEntity);
    });

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
