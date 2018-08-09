package com.listeners;

import com.JiraUtils.HttpProvider;
import com.JiraUtils.JiraTicketManager;
import com.loggers.StringAppender;
import com.utils.CustomDataProvider;
import com.utils.FilesUtility;
import com.utils.SlackNotificationSender;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;

import static com.utils.DriverManager.BROWSER;
import static com.utils.DriverManager.getDriver;
import static com.utils.DriverManager.sessionId;

public class RussianVulcanListener implements ITestListener, ISuiteListener {
    private final static Logger logger = LogManager.getLogger(RussianVulcanListener.class);
    private JiraTicketManager jiraManager;
    private CustomDataProvider dp;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.info("Test method " + iTestResult.getMethod().getMethodName() + " started" + " . Thread # " + Thread.currentThread().getId());
    }

    /**
     * After test success copies success logs and clears log buffer
     * @param iTestResult
     */
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.info("OK! Test " + iTestResult.getMethod().getMethodName() + " finished successfully" + " . Thread # " + Thread.currentThread().getId());
        FilesUtility.copySuccessLogs(iTestResult);
        StringAppender.resetAppender();
    }

    /**
     * Creating ticket in Jira if tests was failed
     *
     * sending notification to slack about a failure
     * @param iTestResult
     */
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        //sending to slack
        for (String group : iTestResult.getMethod().getGroups()) {
            if (group.equals("prodSmoke")) {
                SlackNotificationSender sender = new SlackNotificationSender();
                sender.sendDefaultSlackNotification("@channel Test " + iTestResult.getName() + " was failed on the Production! See the "
                        + "<http://autotest.rvkernel.com:4444/video/" + sessionId + ".mp4" + "|video>" + " of execution. Please check it out! Browser -- " + BROWSER);
            }
        }

//        String pathToScreenshot = FilesUtility.captureScreenshot(iTestResult);
//        EventFiringWebDriver d = (EventFiringWebDriver) getDriver();
//
//        String pathToVideo = System.getProperty("user.dir") + File.separator + ((RemoteWebDriver) d.getWrappedDriver()).getSessionId().toString() + ".mp4";
//        String downloadPathToVideo = "http://autotest.rvkernel.com:4444/video/" + ((RemoteWebDriver) d.getWrappedDriver()).getSessionId().toString() + ".mp4";

//        URL url = null;
//        HttpURLConnection http;
//        int statusCode = 0;
//        File file = null;
//        try {
//            url = new URL(downloadPathToVideo);
//            System.out.println(System.nanoTime());
//            while (statusCode != 200) {
//                http = (HttpURLConnection) url.openConnection();
//                statusCode = http.getResponseCode();
//            }
//            System.out.println(System.nanoTime());
//            file = new File(pathToVideo);
//
//            logger.error(iTestResult.getThrowable().getMessage());
//            String issueLog = StringAppender.getLoggedMessages();
//            StringAppender.resetAppender();
//            System.out.println(statusCode);

//            if (statusCode == 200) {
//                FileUtils.copyURLToFile(url,file,5000,5000);
//                jiraManager.addScreenshotToTicket("");
//                jiraManager.addVideoToTicket("");
//                jiraManager.createTicketWithAttachment("PROD"," Test Case : " +
//                                iTestResult.getMethod().getMethodName() +
//                                " failed " + " Browser: " + dp.getBrowser(),
//                        issueLog,"Automation Fail", pathToVideo);
////                FileUtils.forceDelete(file);
//            } else {
//                jiraManager.createTicketWithAttachment("PROD", " Test Case : " +
//                                iTestResult.getMethod().getMethodName() +
//                                " failed " + " Browser: " + dp.getBrowser(),
//                        issueLog, "Automation Fail", pathToScreenshot);
//            }
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        logger.error(iTestResult.getThrowable().getMessage());
//        String issueLog = StringAppender.getLoggedMessages();
//        StringAppender.resetAppender();

//        if (statusCode != 200) {
//            jiraManager.createTicketWithAttachment("PROD", " Test Case : " +
//                            iTestResult.getMethod().getMethodName() +
//                            " failed " + " Browser: " + dp.getBrowser(),
//                    issueLog, "Automation Fail", pathToScreenshot);
//        } else {
//            jiraManager.createTicketWithAttachment("PROD"," Test Case : " +
//                            iTestResult.getMethod().getMethodName() +
//                            " failed " + " Browser: " + dp.getBrowser(),
//                    issueLog,"Automation Fail", pathToVideo);
//        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        //sending to slack
        for (String group : iTestResult.getMethod().getGroups()) {
            if (group.equals("prodSmoke")) {
                SlackNotificationSender sender = new SlackNotificationSender();
                sender.sendDefaultSlackNotification("@channel Test " + iTestResult.getName() + " was skipped due to some technical problems on the Production! See the "
                        + "<http://autotest.rvkernel.com:4444/video/" + sessionId + ".mp4" + "|video>" + " of execution. And check out corresponding logs! Browser -- " + BROWSER);
            }
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        logger.info("===================================================" +
                "==================================================");
    }


    @Override
    public void onStart(ISuite iSuite) {
        jiraManager = new JiraTicketManager(new HttpProvider());
        dp = new CustomDataProvider();
    }

    @Override
    public void onFinish(ISuite iSuite) {
    }
}
