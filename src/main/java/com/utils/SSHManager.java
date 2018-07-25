package com.utils;

import com.jcraft.jsch.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.joda.time.LocalDate;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SSHManager {
    private final static Logger logger = LogManager.getLogger(SSHManager.class);
    private String pathToKey = System.getProperty("user.dir") + File.separator + "src"
            + File.separator + "main" + File.separator + "resources" + File.separator + "ssh" + File.separator + "id_rsa.ppk";

    List<String> response = new ArrayList<>();

    private Session session;
    private ChannelExec channel;

    public SSHManager() throws IOException {
        try {
            // create connection to our console
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
                channel = (ChannelExec) session.openChannel("exec"); //open c onsole
                channel.setCommand(query); // set coomand in console whic we want to execute
                channel.connect(); // in this moment command executing
                BufferedReader in = new BufferedReader(new InputStreamReader(channel.getInputStream())); // reading response from console
                String msg = null;

                while ((msg = in.readLine()) != null) {
                    response.add(msg); //concatinate response
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

    private void executeSqlQueryAgainstPsupApp(String sqlQuery) {
        executeQuery("docker exec -t psup-db-stage mysql -pmypass psup_app -e \"" + sqlQuery + ";\"");
    }

    public String getUserID(String user) {
        StringBuilder userId = new StringBuilder();
        executeSqlQueryAgainstPsupApp("select id from players where email='" + user + "'\\G");
        for (int i = 0; i < response.size(); i++) {
            if (response.get(i).matches("id: [0-9]{1,11}")) {
                userId.append(response.get(i));
            }
        }
        response.clear();
        String id = String.valueOf(userId);
        return id.substring(id.indexOf(" ") + 1, id.length());
    }

    public void updateUserForSocial(String oldName, String newName) {
        //TODO: make this more clear and pretty
        executeSqlQueryAgainstPsupApp("UPDATE players SET email='" + newName + "', login='" + newName + "', social_id = NULL, social_data = NULL," +
                " 1gp_login = NULL, full_name = NULL, real_name = NULL WHERE email = '" + oldName + "';\" -e \"select id from players where email='" + newName + "'\\G");
        logger.info("User name and email changed from: " + oldName + "  to: " + newName);
        // executeQuery("docker exec -t psup-db-stage mysql -pmypass psup_app -e \"select id from players where email='"+newName+"'\\G;\"");

//getting only ID from response
        for (int i = 0; i < response.size(); i++) {
            if (response.get(i).matches("id: [0-9]{1,11}")) {
                logger.info(" Old user ID is :" + response.get(i));
            }
        }
        response.clear();
    }

    public void disconnectFromConsole() {
        session.disconnect();
    }

    public void removeAllAgeAchievements(User user) {
        executeSqlQueryAgainstPsupApp("delete from achievement_players where player_id = '" + getUserID(user.getLogin()) + "'" +
                "and achievement_id in (select id from achievements where achievement_category_id = 1)");
        for (String message : response) {
            logger.info(message);
        }
        response.clear();
    }

    public void removeAllDepsAchievements(User user) {
        executeSqlQueryAgainstPsupApp("delete from achievement_players where player_id = '" + getUserID(user.getLogin()) + "'" +
                "and achievement_id in (select id from achievements where achievement_category_id = 2)");
        for (String message : response) {
            logger.info(message);
        }
        response.clear();
    }

    public void makeRewards() {
        executeQuery("docker exec -i psup-app-stage sh -c \"./app/console achievements:issue-age-rewards\"");
        for (String message : response) {
            logger.info(message);
        }
        response.clear();
    }

    public void setRegistrationDate(LocalDate localDate, User user) {
        executeSqlQueryAgainstPsupApp("update players set created_at = '" + localDate + "' where email='" + user.getLogin() + "'");
        logger.info("Registration date was changed to " + localDate + " for user " + user.getLogin());
    }
}

