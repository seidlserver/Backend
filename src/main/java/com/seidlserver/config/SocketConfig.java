package com.seidlserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

/*
    Created by: Jonas Seidl
    Date: 03.07.2021
    Time: 09:55
*/
@Configuration
@EnableWebSocketMessageBroker
@EnableWebSocket
public class SocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/server");
        config.setApplicationDestinationPrefixes("/server");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/endpoint").setAllowedOrigins("http://localhost:3000").withSockJS();
    }

}