package com.seidlserver.scheduled;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.seidlserver.SeidlserverApplication;
import com.seidlserver.pojos.state.State;
import com.seidlserver.service.StateService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/*
    Created by: Jonas Seidl
    Date: 03.07.2021
    Time: 15:15
*/
@Component
public class ScheduledTasks {

    private State previousState = null;

    private final StateService stateService;

    public ScheduledTasks(StateService stateService) {
        this.stateService = stateService;
    }

    @Scheduled(fixedRate = 1000)
    public void checkState() {
        //TODO Check state
        State s = SeidlserverApplication.state;
        if(!s.equals(previousState)){
            try {
                stateService.sendNewState(s);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }
}
