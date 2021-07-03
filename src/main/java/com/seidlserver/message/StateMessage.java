package com.seidlserver.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    Created by: Jonas Seidl
    Date: 03.07.2021
    Time: 10:29
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateMessage {
    private String action;
}
