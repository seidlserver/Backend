package com.seidlserver.controller;

import com.seidlserver.message.StateActionMessage;
import com.seidlserver.message.StateUpdateMessage;
import com.seidlserver.pojos.state.State;
import com.seidlserver.util.StateUtil;
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
    public StateActionMessage state(StateActionMessage stateMessage) {
        switch(stateMessage.getAction()){
            case START:
                if(StateUtil.getState().equals(State.DOWN)){
                    if(StateUtil.start()){
                        return new StateActionMessage(stateMessage.getAction(), true);
                    }
                }
                return new StateActionMessage(stateMessage.getAction(), false);
            case STOP:
                if(StateUtil.getState().equals(State.UP)){
                    if(StateUtil.stop()){
                        return new StateActionMessage(stateMessage.getAction(), true);
                    }
                }
                return new StateActionMessage(stateMessage.getAction(), false);
            case RESTART:
                if(StateUtil.getState().equals(State.UP)){
                    if(StateUtil.restart()){
                        return new StateActionMessage(stateMessage.getAction(), true);
                    }
                }
                return new StateActionMessage(stateMessage.getAction(), false);
        }
        return new StateActionMessage(stateMessage.getAction(), false);
    }

    @MessageMapping("/info")
    @SendTo("/server/state")
    public StateUpdateMessage info(StateActionMessage stateMessage) {
        return new StateUpdateMessage(StateUtil.getState());
    }
}
