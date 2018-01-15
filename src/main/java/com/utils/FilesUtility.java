package com.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.utils.DriverManager.getDriver;

public class FilesUtility {
    private final static Logger logger = LogManager.getLogger(FilesUtility.class);

    private static String getFormattedDate(){
        SimpleDateFormat smd = new SimpleDateFormat("dd.MMM hh.mm");
        return smd.format(new Date());
    }

    public static String copyFailLogs(ITestResult iTestResult){
        String fromPath = System.getProperty("user.dir")+ File.separator+"selenium-log.log";
        String toPath=System.getProperty("user.dir")+File.separator+"fails"+File.separator+
                iTestResult.getMethod().getMethodName()+"  "+getFormattedDate()+".log";
        try {
            Files.copy(Paths.get(fromPath),
                    Paths.get(toPath), StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            System.out.println("Fuckingfuckfuckfuckfuck");
        }
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(fromPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.print("start");
        writer.close();
        return toPath;
    };

    public static String captureScreenshot(ITestResult iTestResult){
        File src= ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        String fromPath=src.getPath();
        String toPath=System.getProperty("user.dir")+File.separator+"fails"+File.separator+ iTestResult.getMethod().getMethodName()+"  "+getFormattedDate()+".png";
        try {
            Files.copy(Paths.get(fromPath),Paths.get(toPath),StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            logger.error("Something wrong with screenshots");
            e.printStackTrace();
        }
        return toPath;
    }

    public static String copySuccessLogs(ITestResult iTestResult){
        String fromPath = System.getProperty("user.dir")+ File.separator+"selenium-log.log";
        String toPath=System.getProperty("user.dir")+File.separator+"success"+File.separator+
                iTestResult.getMethod().getMethodName()+"  "+getFormattedDate()+".log";
        try {
            Files.copy(Paths.get(fromPath),
                    Paths.get(toPath), StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            //   e.printStackTrace();
        }
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(fromPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.print("start");
        writer.close();
        return toPath;
    };
}
