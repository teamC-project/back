package com.back.back.provider;

import org.springframework.stereotype.Component;

import com.corundumstudio.socketio.SocketIOServer;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SocketIOProvider {
    
    private final SocketIOServer socketIOServer;

    @PostConstruct
    private void startServer () {
        socketIOServer.addConnectListener(client -> System.out.println("Client connected : " + client.getSessionId()));
        socketIOServer.addDisconnectListener(client -> System.out.println("Client disconnected : " + client.getSessionId()));

        socketIOServer.addEventListener("message", String.class, (client, data, ackRequest) -> {
            System.out.println("Received message : " + data);
            client .sendEvent("message", "message recive");
        });

        socketIOServer.start();
    }
    
    @PreDestroy
    private void stopServer () {
        socketIOServer.stop();
    }

}
