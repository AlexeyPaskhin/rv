package com.listeners;

import com.JiraUtils.HttpProvider;
import com.JiraUtils.JiraTicketManager;
import com.loggers.StringAppender;
import com.utils.CustomDataProvider;
import com.utils.FilesUtility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.*;

import java.io.*;
import java.util.stream.Collectors;

import static com.utils.DriverManager.getDriver;

public class RussianVulcanListener implements ITestListener, ISuiteListener {
private final static Logger logger =  LogManager.getLogger(RussianVulcanListener.class);
 JiraTicketManager jiraManager;
 CustomDataProvider dp;

 @Override
    public void onTestStart(ITestResult iTestResult) {


   logger.info("Test method "+iTestResult.getMethod().getMethodName()+" started");

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    logger.info("OK! Test "+ iTestResult.getMethod().getMethodName()+" finished successfully");
        FilesUtility.copySuccessLogs(iTestResult);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
//  String issueLog="";
//        logger.error(iTestResult.getThrowable().getMessage());
//       String path = FilesUtility.copyFailLogs(iTestResult);
       String pathScrenshot=FilesUtility.captureScreenshot(iTestResult);
//     try {
//      BufferedReader reader = new BufferedReader(new FileReader(path));
//
//      issueLog = reader.lines().collect(Collectors.joining("\n")).replaceAll("\\u0000", "");
//     } catch (FileNotFoundException e) {
//         logger.error("--Error! Log file not found");
//         e.printStackTrace();
//     }


        logger.error(iTestResult.getThrowable().getMessage());
        String issueLog =StringAppender.getLoggedMessages();
        System.out.println("NEW APPENDER STARTED!!!!!!!!" +issueLog);

        jiraManager.createTicketWithScreenshot("PROD", " Test Case : "+iTestResult.getMethod().getMethodName() +" failed "+ " Browser: "+ dp.getBrowser(),
                issueLog,"Automation Fail",pathScrenshot);


    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

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
  dp=new CustomDataProvider();
 }

 @Override
 public void onFinish(ISuite iSuite) {

 }
}
