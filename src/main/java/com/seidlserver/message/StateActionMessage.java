package com.seidlserver.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.seidlserver.pojos.state.Action;
import com.seidlserver.pojos.state.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*
    Created by: Jonas Seidl
    Date: 03.07.2021
    Time: 10:29
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StateActionMessage implements Serializable {
    private Action action;
    private boolean successful;
}
