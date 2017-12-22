package com.utils;

import com.jcraft.jsch.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;


public class SSHManager {
   private final static Logger logger = LogManager.getLogger(SSHManager.class);
    private String pathToKey = System.getProperty("user.dir") + File.separator + "src"
            + File.separator + "main" + File.separator + "resources" + File.separator + "ssh" + File.separator + "id_rsa";

    private PrintStream ps;
    private Session session;
    private Channel channel;

    public SSHManager() throws IOException {
        try {
            JSch jsch = new JSch();
            jsch.addIdentity(pathToKey);
            session = jsch.getSession("root", "144.76.43.170", 22);

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            channel = session.openChannel("shell");
            OutputStream ops = channel.getOutputStream();
            this.ps = new PrintStream(ops, true);

            channel.connect();
        } catch (JSchException e) {
            logger.error("Unable to connect to console");
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        ps.println(query);
    }

    public void disconnectFromConsole() {
        ps.close();
        channel.disconnect();
        session.disconnect();
    }


}

