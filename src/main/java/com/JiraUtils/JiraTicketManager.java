package com.JiraUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.StringReader;

public class JiraTicketManager {
    private final static Logger logger = LogManager.getLogger(JiraTicketManager.class);
    HttpProvider httpProvider;

    public JiraTicketManager(HttpProvider httpProvider) {
        this.httpProvider = httpProvider;
    }

    public void createIssueTicket(String projectKey, String summary, String description, String issueType) {

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode fieldsNode = mapper.createObjectNode();
        ObjectNode projectNode = mapper.createObjectNode();
        ObjectNode issueNode = mapper.createObjectNode();
        ObjectNode rootNode = mapper.createObjectNode();

        projectNode.put("key", projectKey);
        issueNode.put("name", issueType);
        fieldsNode.put("project", projectNode);
        fieldsNode.put("summary", summary);
        fieldsNode.put("description", description);
        fieldsNode.put("issuetype", issueNode);
        rootNode.put("fields", fieldsNode);

        HttpResponse response=  httpProvider.executePost(httpProvider.createPostRequestJSON("https://playtini.atlassian.net/rest/api/2/issue", rootNode.toString()));
        try {
            System.out.println("create ticket method" +EntityUtils.toString(response.getEntity(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addScreenshotToTicket(String pathToScreenshot) {
        httpProvider.executePost(httpProvider.createPostRequestFile("https://playtini.atlassian.net/rest/api/2/issue/PROD-5787/attachments", "C:\\Users\\ai\\Documents\\autotest-rv\\Screenshot_5.png"));
    }

    public void addVideoToTicket(String pathToVideo) {
        httpProvider.executePost(httpProvider.createPostRequestFile("https://playtini.atlassian.net/rest/api/2/issue/PROD-5787/attachments", "C:\\Users\\ai\\Documents\\autotest-rv\\2157eb815aba5c193f5d1df8e2793fdc.mp4"));
    }

    public void createTicketWithAttachment(String projectKey, String summary, String description, String issueType, String pathToAttachment){

        HttpResponse response;
        String issueKey;

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode fieldsNode = mapper.createObjectNode();
        ObjectNode projectNode = mapper.createObjectNode();
        ObjectNode issueNode = mapper.createObjectNode();
        ObjectNode rootNode = mapper.createObjectNode();

        projectNode.put("key", projectKey);
        issueNode.put("name", issueType);
        fieldsNode.put("project", projectNode);
        fieldsNode.put("summary", summary);
        fieldsNode.put("description", description);
        fieldsNode.put("issuetype", issueNode);
        rootNode.put("fields", fieldsNode);

        System.out.println(pathToAttachment);

    try{
     response  = httpProvider.executePost(httpProvider.createPostRequestJSON("https://playtini.atlassian.net/rest/api/2/issue", rootNode.toString()));
     issueKey =getIssueKey(response);
        EntityUtils.consume(response.getEntity());
        if(issueKey!=null) {
            response = httpProvider.executePost(httpProvider.createPostRequestFile("https://playtini.atlassian.net/rest/api/2/issue/" + issueKey + "/attachments", pathToAttachment));
            EntityUtils.consume(response.getEntity());
        }
        else{ logger.error("Ticket was not created");

        }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getIssueKey(HttpResponse httpResponse){
        try {
            JsonNode rootNode = new ObjectMapper().readTree(new StringReader(EntityUtils.toString(httpResponse.getEntity())));
           return rootNode.get("key").asText();
        } catch (IOException e) {
            return null;
        }
    }
}
