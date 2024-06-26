package com.back.back.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import com.corundumstudio.socketio.Transport;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;

@org.springframework.context.annotation.Configuration
public class SocketIOServerConfig {

    @Value("${chat.room}")
    private String hostname;

    @Bean
    protected SocketIOServer socketIOServer() {
        
        Configuration config = new Configuration();
        config.setHostname(hostname); 
        config.setPort(9092); 
        config.setTransports(Transport.POLLING, Transport.WEBSOCKET);
        return new SocketIOServer(config);
    }

}
