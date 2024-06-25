package com.back.back.config;

import org.springframework.context.annotation.Bean;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.Transport;

@org.springframework.context.annotation.Configuration
public class SocketIOServerConfig {

    @Bean
    protected SocketIOServer socketIOServer() {
<<<<<<< HEAD
=======

>>>>>>> 8233bf14626911f72de1b65a4c0c6356778ad8a4
    Configuration config = new Configuration();

    config.setHostname("localhost"); 
    config.setPort(9092); 
    config.setTransports(Transport.POLLING, Transport.WEBSOCKET);

    return new SocketIOServer(config);
    }

}
