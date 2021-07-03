package com.seidlserver.controller;

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
    @MessageMapping("/server")
    @SendTo("/state")
    public State state(StateMessage stateMessage) throws InterruptedException {
        Thread.sleep(1000);
        if(stateMessage.equals("START")){
            return State.UP;
        }else{
            return State.DOWN;
        }
    }
}
