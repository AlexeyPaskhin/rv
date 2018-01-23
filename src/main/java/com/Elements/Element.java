package com.Elements;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static com.utils.DriverManager.getDriver;
import static com.utils.DriverManager.setImplicity;

public class Element {

    private final static Logger logger = LogManager.getLogger(Element.class);
    By by;

    public Element(By by) {
        this.by = by;
    }

    public By getBy() {
        return by;
    }

    public WebElement slaveElement() {
        WebElement element;
        logger.info("Trying to find element " + by);
        element = getDriver().findElement(by);
        logger.info("--OK! Element " + by + " found successfully");
        return element;
    }

    public void sendKeys(CharSequence sequence) {
        sendKeys(slaveElement(), sequence);
    }

    private void sendKeys(WebElement element, CharSequence sequence) {
        new FluentWait<>(getDriver()).ignoring(NoSuchElementException.class, ElementNotInteractableException.class)
                .pollingEvery(200, TimeUnit.MILLISECONDS)
                .withTimeout(3, TimeUnit.SECONDS)
                .until(new Function<WebDriver, Boolean>() {
                    @Override
                    public Boolean apply(WebDriver driver) {
                        element.sendKeys(sequence);
                        return true;
                    }
                });
    }

    public void click() {
        click(slaveElement());
    }

    public String getText() {

        return new FluentWait<>(getDriver()).withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(200, TimeUnit.MILLISECONDS)
                .ignoring(StaleElementReferenceException.class)
                .until(driver -> slaveElement().getText());
    }

    private void click(WebElement element) {
        new FluentWait<>(getDriver())
                .withTimeout(20, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class, ElementNotVisibleException.class)
                .pollingEvery(200, TimeUnit.MILLISECONDS).until((Function<WebDriver, Boolean>) driver -> {
            element.click();
            return true;
        });
    }

    public boolean isPresent() {
        setImplicity(0);
        List<WebElement> list = getDriver().findElements(by);
        setImplicity(15);
        if (list.size() == 0) {
            return false;
        } else {
            return list.get(0).isDisplayed();
        }
    }

    public boolean isVisible() {
        return slaveElement().isDisplayed();
    }

    public String getAttribute(String attr) {
        return slaveElement().getAttribute(attr);
    }

    private void executeJS(String script) {
        ((JavascriptExecutor) getDriver()).executeScript(script, slaveElement());
    }

    public void scrollToElement() {
        executeJS("arguments[0].scrollIntoView(true);");
    }

    public List<WebElement> getAllElements() {
        return getDriver().findElements(by);
    }

    public void waitForElementToBePresent(int seconds) {
        new WebDriverWait(getDriver(), seconds).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForElementToBeClickable(int seconds) {
        new WebDriverWait(getDriver(), seconds).until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForElementToBeVisible(int seconds) {
        new WebDriverWait(getDriver(), seconds).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForElementToBeInvisible(int seconds) {
        new WebDriverWait(getDriver(), seconds).until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void doubleClick() {
        Actions doubleClick = new Actions(getDriver());
        doubleClick.doubleClick(slaveElement()).build().perform();
    }

    public void clickUntilDisappeared() {
        click();
        for (int i = 0; i < 2; i++) {
            try {
                waitForElementToBeInvisible(2);
            } catch (Exception e) {
                click();
            }
        }
    }

    public void clickWithJS() {
        executeJS("arguments[0].click();");
    }

}