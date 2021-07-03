package com.seidlserver.scheduled;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.seidlserver.SeidlserverApplication;
import com.seidlserver.message.StateMessage;
import com.seidlserver.pojos.state.Action;
import com.seidlserver.pojos.state.State;
import com.seidlserver.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
    Created by: Jonas Seidl
    Date: 03.07.2021
    Time: 15:15
*/
@Component
public class ScheduledTasks {
    @Autowired
    private SimpMessagingTemplate template;

    private State previousState = null;

    @Scheduled(fixedRate = 1000)
    public void checkState() {
        //TODO Check state
        State state = SeidlserverApplication.state;
        if(!state.equals(previousState)){
            StateMessage stateMessage = new StateMessage(Action.INFO, state);
            Message message = MessageBuilder.withPayload(stateMessage).build();
            template.send("/server/state", message);
            previousState = state;
        }
    }

}
