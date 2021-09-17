package com.seidlserver.util;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.ByteArrayOutputStream;

/*
    Created by: Jonas Seidl
    Date: 17.09.2021
    Time: 15:14
*/
public class SSHUtil {
    private static SSHUtil instance;

    private Session session;
    private ChannelExec channel;

    private SSHUtil(String host, String username, String password) throws JSchException {
        session = new JSch().getSession(username, host, 22);
        session.setPassword(password);
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();
    }

    public static SSHUtil getInstance(){
        if(instance==null){
            try {
                instance = new SSHUtil("10.0.0.1", "seidlserver", "seidlserver");
            } catch (JSchException e) {
                return null;
            }
        }
        return instance;
    }

    public String execute(String command) throws JSchException, InterruptedException {
        try{
            channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand(command);
            ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
            channel.setOutputStream(responseStream);
            channel.connect();

            while (channel.isConnected()) {
                Thread.sleep(100);
            }
            return responseStream.toString();
        }catch(JSchException | InterruptedException ex){
            if (channel != null) {
                channel.disconnect();
            }
            throw ex;
        }
    }
}
