package com.utils;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

import static com.utils.DriverManager.getDriver;
import static org.testng.Assert.fail;

public class RestManager {
    private final static Logger logger = LogManager.getLogger(RestManager.class);
    private JSONParser parser = new JSONParser();

    public void makeCustomGameRoundsForUser(String userId, int rounds, String betId, String winId) throws IOException, ParseException {
        JSONObject userData = (JSONObject) parser.parse(new FileReader("src/main/resources/jsonFiles/rabbitMQ/dataContentForRabbitMQPayload.json"));
        userData.put("player_id", userId);
        userData.put("bet_id", betId);
        userData.put("win_id", winId);

        JSONObject payload = (JSONObject) parser.parse(new FileReader("src/main/resources/jsonFiles/rabbitMQ/payloadContentForRabbitMQ.json"));
        payload.put("player_id", userId);
        payload.put("data", userData);
        payload.put("time", System.currentTimeMillis()/1000);

        JSONObject bodyForPublish = (JSONObject) parser.parse(new FileReader("src/main/resources/jsonFiles/rabbitMQ/bodyForRabbitMQPublish.json"));
        bodyForPublish.put("payload", payload.toString());
        logger.info(bodyForPublish);
        for (int i = 0; i < rounds; i++) {
            try (CloseableHttpClient client = HttpClientBuilder.create().setConnectionManagerShared(true).build()) {
                HttpUriRequest request = buildPostRequest(bodyForPublish, "http://rabbitmq.dev.rusvulcan.com/api/exchanges/%2F/player_games/publish", "Basic cm9vdDpteXBhc3M=");
                HttpResponse response = client.execute(request);

                logger.info("Status of transaction register: " + response.getStatusLine().getStatusCode());
                if (response.getStatusLine().getStatusCode() == 200) {
                    JSONObject result = (JSONObject) parser.parse(IOUtils.toString(response.getEntity().getContent(), "utf-8"));
                    Boolean routed = (Boolean) result.get("routed");
                    if (routed) {
                        logger.info("Game round " + (i+1) + " was sent to RabbitMQ");
                    } else {
                        fail("Game round " + (i+1) + " was not sent to RabbitMQ!!!");
                    }
                } else {
                    JSONObject result = (JSONObject) parser.parse(IOUtils.toString(response.getEntity().getContent(), "utf-8"));
                    fail(result.get("Error").toString());

                }
            }
        }

    }

    public void makeDepositNTimes(String userId, int times, int sum) throws ParseException {
        for (int i = 0; i < times; i++) {
            getDriver().getCurrentUrl(); //to avoid driver time-out exception
            try (CloseableHttpClient client = HttpClientBuilder.create().setConnectionManagerShared(true).build()) {
                JSONObject dataToRegisterDeposit = new JSONObject();
                dataToRegisterDeposit.put("player_id", userId);
                dataToRegisterDeposit.put("amount", sum);
                HttpUriRequest request = buildPostRequest(dataToRegisterDeposit, "http://app.dev.rusvulcan.com/api/deposits", "");
                HttpResponse response = client.execute(request);

                logger.info("Status of transaction register: " + response.getStatusLine().getStatusCode());
                if (response.getStatusLine().getStatusCode() == 200) {
                    JSONObject result = (JSONObject) parser.parse(IOUtils.toString(response.getEntity().getContent(), "utf-8"));
                    String transactionId = (String) result.get("transaction_id");
                    JSONObject dataToCommitDeposit = new JSONObject();
                    dataToCommitDeposit.put("action", "commit");
                    request = buildPostRequest(dataToCommitDeposit, "http://app.dev.rusvulcan.com/api/deposits/" + transactionId, "");
                    response = client.execute(request);

                    logger.info("Status of transaction commit: " + response.getStatusLine().getStatusCode());
                    if (response.getStatusLine().getStatusCode() == 200) {
                        logger.info("Deposit " + (i + 1) + " was committed");
                    } else {
                        result = (JSONObject) parser.parse(IOUtils.toString(response.getEntity().getContent(), "utf-8"));
                        fail(result.get("Error").toString());
                    }

                } else {
                    JSONObject result = (JSONObject) parser.parse(IOUtils.toString(response.getEntity().getContent(), "utf-8"));
                    fail(result.get("Error").toString());

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private HttpUriRequest buildPostRequest(JSONObject data, String requestUrl, String basicAuth) {
        return RequestBuilder.create("POST")
                .setUri(requestUrl)
                .setHeader("Content-Type", "application/json; charset=utf-8")
                .setHeader("authorization", basicAuth)
                .setEntity(new StringEntity(data.toString(), "utf-8"))
                .build();
    }

}
