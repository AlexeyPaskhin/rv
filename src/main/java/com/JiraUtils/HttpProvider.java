package com.JiraUtils;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class HttpProvider {

    private final static Logger logger = LogManager.getLogger(HttpProvider.class);
    private String authHeader;
    private HttpClient httpclient;
    private String login = "autobot@playtini.ua";
    private String pass = "deiVim6haid01";

    public HttpProvider() {
        httpclient = HttpClientBuilder.create().build();
        setCredentials(login, pass);
    }

    protected HttpClient setHeader;

    /**
     * Creates post request with content type JSON
     * @param uri URL for POST endpoint
     * @param body JSON body
     * @return HttpPOST method
     */

    public HttpPost createPostRequestJSON(String uri, String body) {
        HttpPost postMethod = new HttpPost(uri);
        postMethod.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        StringEntity requestEntity = new StringEntity(
                body,
                ContentType.APPLICATION_JSON);
        postMethod.setEntity(requestEntity);

        return postMethod;
    }

    /**
     * post Request with file content type
     * ATTENTION: THIS METHOD CREATED FOR JIRA API YOU NEED TO REMOVE HEADER IF YOU WANT USE IT IN ANOTHE PLACE
     * @param uri URL for POST endpoint
     * @param PathToFile Path to file you want to upload
     * @return
     */

    public HttpPost createPostRequestFile(String uri, String PathToFile) {
        HttpPost postMethod = new HttpPost(uri);
        postMethod.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        postMethod.setHeader("X-Atlassian-Token", "no-check");

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        FileBody fileBody = new FileBody(new File(PathToFile), "application/octect-stream");
        builder.addPart("file", fileBody);
        HttpEntity entity = builder.build();
        postMethod.setEntity(entity);
        return postMethod;
    }

    /**
     * Send prepared post request
     * @param request
     * @return
     */
    public HttpResponse executePost(HttpPost request) {

        try {

            HttpResponse response = httpclient.execute(request);
            // System.out.println("EXECUTION METHOD"+EntityUtils.toString(response.getEntity(), "UTF-8"));
            //
            return response;

        } catch (IOException e) {
            logger.error("Something wrong with jira server");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Setup credentials to each request in Base64
     * @param login
     * @param pass
     */
    private void setCredentials(String login, String pass) {
        String auth = login + ":" + pass;
        byte[] encodedAuth = Base64.encodeBase64(
                auth.getBytes(Charset.forName("ISO-8859-1")));
        authHeader = "Basic " + new String(encodedAuth);
    }

    public HttpClient getHttpClient() {
        return this.httpclient;
    }
}
