package com.seidlserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    Created by: Jonas Seidl
    Date: 07.04.2021
    Time: 11:15
*/

/***
 * Data class for the login request
 * Used for extracting data from JSON
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginModel {
    public String username;
    private String password;
}
