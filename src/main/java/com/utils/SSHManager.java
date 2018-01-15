package com.utils;

import com.jcraft.jsch.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SSHManager {
    private final static Logger logger = LogManager.getLogger(SSHManager.class);
    private String pathToKey = System.getProperty("user.dir") + File.separator + "src"
            + File.separator + "main" + File.separator + "resources" + File.separator + "ssh" + File.separator + "id_rsa";

    List<String> responce = new ArrayList<>();

    private Session session;
    private ChannelExec channel;

    public SSHManager() throws IOException {
        try {
            JSch jsch = new JSch();
            jsch.addIdentity(pathToKey);
            session = jsch.getSession("root", "144.76.43.170", 22);

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
        } catch (JSchException e) {
            logger.error("Unable to connect to console");
            e.printStackTrace();
        }
    }

    private void executeQuery(String query) {
        if (session.isConnected()) {
            try {
                channel = (ChannelExec) session.openChannel("exec");
                channel.setCommand(query);
                channel.connect();
                BufferedReader in = new BufferedReader(new InputStreamReader(channel.getInputStream()));
                String msg = null;

                while ((msg = in.readLine()) != null) {
                    responce.add(msg);
                }
                channel.disconnect();
            } catch (JSchException e) {
                logger.error("Unable to open channel");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            logger.error("Console session disconnected");
        }
    }

    public void getUserID(String user) {

        executeQuery("docker exec -t psup-db-stage mysql -pmypass psup_app -e \"select id from players where email='" + user + "'\\G;\"");
        for (int i = 0; i < responce.size(); i++) {
            if (responce.get(i).matches("id: [0-9]{1,11}")) {
                logger.info("New user ID is :" + responce.get(i));
            }
        }
        responce.clear();
    }

    public void updateUserForSocial(String oldName, String newName) {

        executeQuery("docker exec -t psup-db-stage mysql -pmypass psup_app -e \"UPDATE players SET email='" + newName + "', login='" + newName + "', social_id = NULL, social_data = NULL," +
                " 1gp_login = NULL, full_name = NULL, real_name = NULL WHERE email = '" + oldName + "';\" -e \"select id from players where email='" + newName + "'\\G;\"");

        logger.info("User name and email changed from: " + oldName + "  to: " + newName);
        // executeQuery("docker exec -t psup-db-stage mysql -pmypass psup_app -e \"select id from players where email='"+newName+"'\\G;\"");

        for (int i = 0; i < responce.size(); i++) {
            if (responce.get(i).matches("id: [0-9]{1,11}")) {
                logger.info(" Old user ID is :" + responce.get(i));
            }
        }
        responce.clear();
    }

    public void disconnectFromConsole() {
        session.disconnect();
    }
}

