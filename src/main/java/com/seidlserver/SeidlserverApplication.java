package com.seidlserver;

import com.seidlserver.pojos.state.State;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/*
    Created by: Jonas Seidl
    Date: 17.03.2021
    Time: 18:21
*/

/***
 * Application Class to start the application and the StatBuilder
 */
@SpringBootApplication
@EnableScheduling
public class SeidlserverApplication {
    public static State state = State.DOWN;

    public static void main(String[] args) {
        SpringApplication.run(SeidlserverApplication.class, args);
    }

}