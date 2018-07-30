package com.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

import static com.utils.DriverManager.getDriver;
import static org.testng.Assert.fail;

public class RestManager {
    private final static Logger logger = LogManager.getLogger(RestManager.class);
    private JSONParser parser = new JSONParser();

    public void makeDepositNTimes(String userId, int times) throws ParseException {
        for (int i = 0; i < times; i++) {
            getDriver().getCurrentUrl(); //to avoid driver time-out exception
            try (CloseableHttpClient client = HttpClientBuilder.create().setConnectionManagerShared(true).build()) {
//            JSONObject data = (JSONObject) parser.parse(new FileReader("src/test/resources/cpaInfo.json"));
                JSONObject dataToRegisterDeposit = new JSONObject();
                dataToRegisterDeposit.put("player_id", userId);
                dataToRegisterDeposit.put("amount", 1);
                HttpUriRequest request = buildPostRequest(dataToRegisterDeposit, "http://app.dev.rusvulcan.com/api/deposits");
                HttpResponse response = client.execute(request);

                logger.info("Status of transaction register: " + response.getStatusLine().getStatusCode());
                if (response.getStatusLine().getStatusCode() == 200) {
                    JSONObject result = (JSONObject) parser.parse(IOUtils.toString(response.getEntity().getContent(), "utf-8"));
                    String transactionId = (String) result.get("transaction_id");
                    JSONObject dataToCommitDeposit = new JSONObject();
                    dataToCommitDeposit.put("action", "commit");
                    request = buildPostRequest(dataToCommitDeposit, "http://app.dev.rusvulcan.com/api/deposits/" + transactionId);
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

    private HttpUriRequest buildPostRequest(JSONObject data, String requestUrl) {
        return RequestBuilder.create("POST")
                .setUri(requestUrl)
                .setHeader("Content-Type", "application/json; charset=utf-8")
                .setEntity(new StringEntity(data.toString(), "utf-8"))
                .build();
    }

}
