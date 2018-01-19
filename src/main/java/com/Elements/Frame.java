package com.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.utils.DriverManager.getDriver;

/**
 * Created by ai on 2018-01-17.
 */
public class Frame extends Element{
    public Frame(By by) {
        super(by);
    }

    public void waitForFrameAVailable(long seconds){
        new WebDriverWait(getDriver(),seconds).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }
}
