package com.back.back.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.back.back.common.object.ChatMessage;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SocketIOProvider {

  private final SocketIOServer socketIOServer;

  @PostConstruct
  private void startServer() {
    socketIOServer.addConnectListener(client -> System.out.println("Client connected : " + client.getSessionId()));
    socketIOServer
        .addDisconnectListener(client -> System.out.println("Client disconnected : " + client.getSessionId()));

    socketIOServer.addEventListener("senderMessage", ChatMessage.class, (sendClient, data, ackRequest) -> {

      List<SocketIOClient> clients = new ArrayList<>(socketIOServer.getAllClients());
      for (SocketIOClient client : clients) {
        client.sendEvent("receiveMessage", data);
      }
      
    });

    socketIOServer.start();
  }

  @PreDestroy
  private void stopServer() {
    socketIOServer.stop();
  }

}
