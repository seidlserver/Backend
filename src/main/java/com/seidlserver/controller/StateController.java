package com.seidlserver.controller;

import com.seidlserver.SeidlserverApplication;
import com.seidlserver.message.StateMessage;
import com.seidlserver.pojos.state.State;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/*
    Created by: Jonas Seidl
    Date: 03.07.2021
    Time: 10:26
*/
@Controller
public class StateController {
    @MessageMapping("/change")
    @SendTo("/server/state")
    public State state(StateMessage stateMessage) {
        //TODO Implement state changing
        switch(stateMessage.getAction()){
            case START:
                SeidlserverApplication.state = State.UP;
                break;
            case STOP:
                SeidlserverApplication.state = State.DOWN;
                break;
            case RESTART:
                SeidlserverApplication.state = State.UP;
                break;
        }
        return SeidlserverApplication.state;
    }
}
