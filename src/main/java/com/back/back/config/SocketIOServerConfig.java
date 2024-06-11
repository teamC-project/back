package com.back.back.config;

import org.springframework.context.annotation.Bean;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.Transport;

@org.springframework.context.annotation.Configuration
public class SocketIOServerConfig {
    
    @Bean
    protected SocketIOServer socketIOServer () {
        Configuration config = new Configuration();
        config.setHostname("localhost"); // 호스트 이름
        config.setPort(9092); // 포트 번호 

        config.setTransports(Transport.POLLING, Transport.WEBSOCKET);

        return new SocketIOServer(config);
    }

}
