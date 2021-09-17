package com.seidlserver.scheduled;

import com.seidlserver.message.StateActionMessage;
import com.seidlserver.message.StateUpdateMessage;
import com.seidlserver.pojos.state.Action;
import com.seidlserver.pojos.state.State;
import com.seidlserver.util.StateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
        State state = StateUtil.getState();
        if(!state.equals(previousState)){
            StateUpdateMessage stateMessage = new StateUpdateMessage(state);
            Message message = MessageBuilder.withPayload(stateMessage).build();
            template.send("/server/state", message);
            previousState = state;
        }
    }

}
