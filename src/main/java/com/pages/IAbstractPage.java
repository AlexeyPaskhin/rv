package com.pages;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.utils.DriverManager.getDriver;
import static com.utils.DriverManager.setImplicity;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public interface IAbstractPage {

    default String getTitle() {
        return getDriver().getTitle();
    }

    default String getURL() {
        waitForPageToLoad();
        return getDriver().getCurrentUrl();
    }

    default void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    default void switchToWindow(String window) {
        getDriver().switchTo().window(window);
    }

    /**
     * pass to this method a set of old window handles to exclude them from switching
     */
    default void switchToNewlyOpenedWindow(Set<String> oldWindowHandles) {
        new WebDriverWait(getDriver(), 10).until(not(numberOfWindowsToBe(1)));
        for (String handleFromWholeSet :
                getDriver().getWindowHandles()) {
            if (!oldWindowHandles.contains(handleFromWholeSet)) {
                switchToWindow(handleFromWholeSet);
            }
        }
    }

    default List<WebElement> getAllVisibleElements(String xPathLocator) {
        List<WebElement> visibleElements = new ArrayList<>();
        for (WebElement element:
                findElementsByXPath(xPathLocator)) {
            if (element.isDisplayed()) {
                visibleElements.add(element);
            }
        }
        return visibleElements;
    }

    default List<WebElement> findElementsByXPath(String xPathLocator) {
        return getDriver().findElements(By.xpath(xPathLocator));
    }

    default String handleCurrentWindow() {
        return getDriver().getWindowHandle();
    }

    default void waitForElementToBeVisible(String xPathLocator) {
        new WebDriverWait(getDriver(), 10).until(visibilityOfElementLocated(By.xpath(xPathLocator)));
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

    default void refreshPage() {
        getDriver().navigate().refresh();
    }

    default void switchToNewTab() {
        for (String winHandle : getDriver().getWindowHandles()) {
            switchToWindow(winHandle);
        }
    }
}
