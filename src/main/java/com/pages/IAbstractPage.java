package com.pages;

import com.google.common.base.Function;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.utils.DriverManager.getDriver;

public interface IAbstractPage {

    default String getTitle() {
        return getDriver().getTitle();
    }

    default String getURL() {
        return getDriver().getCurrentUrl();
    }

    default void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    default void swithToWindow(String window) {
        getDriver().switchTo().window(window);
    }

    default String handleCurrentWindow() {
        return getDriver().getWindowHandle();
    }

    default void waitForPageToLoad() {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), 15);
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                System.out.println(String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
    }

    default void waitForCountOfWindows(int windowsCount) {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.numberOfWindowsToBe(windowsCount));
    }

    default void swithToSocialFrame() {
        AbstractPage.parentWindow = getDriver().getWindowHandle();
        waitForCountOfWindows(2);
        for (String winHandle : getDriver().getWindowHandles()) {
            swithToWindow(winHandle);
        }
        waitForPageToLoad();
    }

    default HomePage refreshPage() {
        getDriver().navigate().refresh();
        return new HomePage();
    }
}
