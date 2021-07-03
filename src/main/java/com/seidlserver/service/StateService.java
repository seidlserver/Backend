package com.seidlserver.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seidlserver.message.StateMessage;
import com.seidlserver.pojos.state.State;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/*
    Created by: Jonas Seidl
    Date: 03.07.2021
    Time: 15:18
*/
@Data
@Slf4j
@Service
public class StateService {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private static final String DESTINATION = "/server/state";

    StateService(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void sendNewState(StateMessage message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        simpMessagingTemplate.convertAndSend(StateService.DESTINATION, mapper.writeValueAsString(message));
    }
}