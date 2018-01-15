package com.loggers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebDriverEventHandler implements WebDriverEventListener {
   private final static Logger logger = LogManager.getLogger(WebDriverEventHandler.class);

    // Element initilazes in beforeFind by method, and we can use it  ;
    private By lastBy;
    private String originalValue;

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {
    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        logger.info("open page: "+s);
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        this.lastBy = by;
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        logger.info("Trying to click on " + webElement);
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        logger.info("-- OK! Element " + lastBy + " Successfully clicked");
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        originalValue = webElement.getAttribute("value");
        if (originalValue == null) {
            originalValue = webElement.getText();
        }
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        String newValue = "";
        try {
            newValue = webElement.getAttribute("value");
            if (newValue == null) {
                newValue = webElement.getText();
            }
        } catch (StaleElementReferenceException e) {
        }
        logger.info(" In element " + lastBy + " value changed from '" + originalValue + "' to '" + newValue + "'");
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {
        logger.info("Trying to execute script " + s);
    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {
        logger.info("--OK! Script executed successfully");
    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        if (throwable.getClass().equals(NoSuchElementException.class)) {
            logger.error("Element not found " + lastBy);
        } else if (throwable.getClass().equals(ElementNotVisibleException.class)) {
            logger.error("Element not visible " + lastBy);
        } else if (throwable.getClass().equals(StaleElementReferenceException.class)) {
            logger.error("Element was changed in runtime " + lastBy);
        }
    }
}
