package com.seidlserver.util;

import com.jcraft.jsch.JSchException;
import com.seidlserver.pojos.state.State;
import com.seidlserver.wol.WakeOnLan;

/*
    Created by: Jonas Seidl
    Date: 17.09.2021
    Time: 19:53
*/
public class StateUtil {

    public static boolean start(){
        try {
            WakeOnLan.wake();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean stop(){
        try {
            SSHUtil.getInstance().execute("sudo shutdown -P now");
            return true;
        } catch (JSchException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean restart(){
        try {
            SSHUtil.getInstance().execute("sudo restart");
            return true;
        } catch (JSchException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static State getState(){
        return State.DOWN;
    }
}
