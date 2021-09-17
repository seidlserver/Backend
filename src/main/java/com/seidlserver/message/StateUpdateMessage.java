package com.seidlserver.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.seidlserver.pojos.state.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    Created by: Jonas Seidl
    Date: 17.09.2021
    Time: 20:07
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StateUpdateMessage {
    private State state;
}
