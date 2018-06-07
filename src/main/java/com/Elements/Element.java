package com.Elements;

import com.google.common.collect.Lists;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static com.utils.DriverManager.getDriver;
import static com.utils.DriverManager.setImplicity;

/**
 * Main Element with all main  methods which are available for all elements
 * If u create any custom element please extend it from this


 */
public class Element{

    private final static Logger logger = LogManager.getLogger(Element.class);
    By by;

    public Element(By by) {
        this.by = by;
    }

    public By getBy() {
        return by;
    }


    /**
     * This method allows you to work with any WebDriver native methods
     * Used for creating custom Methods and waiters
     * @return WebElement from By object
     */
    public WebElement slaveElement() {
        WebElement element;
        logger.info("Trying to find element " + by);
        element = getDriver().findElement(by);
        logger.info("--OK! Element " + by + " is found successfully");
        return element;
    }


    public void sendKeys(CharSequence sequence) {
        sendKeys(slaveElement(), sequence);
    }

    /**
     * private method for sendkeys with waiters and ignorig exception
     * DO NOT USE IT GLOBALLY, USE {@link  #sendKeys(CharSequence)} method
     * @param element
     * @param sequence
     */

    private void sendKeys(WebElement element, CharSequence sequence) {
        new FluentWait<>(getDriver())
                .ignoring(NoSuchElementException.class, ElementNotInteractableException.class)
                .pollingEvery(200, TimeUnit.MILLISECONDS)
                .withTimeout(3, TimeUnit.SECONDS)
                .until(driver -> {
                    element.sendKeys(sequence);
                    return true;
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

    /**
     * private method for global click with waiters and ignoring exceptions
     * DON'T USE THIS GLOBALLY, PLEASE USE {@link #click()} method
     * @param element
     */
    private void click(WebElement element) {
        new FluentWait<>(getDriver())
                .withTimeout(20, TimeUnit.SECONDS)
                .ignoreAll(Lists.newArrayList(NoSuchElementException.class,ElementNotVisibleException.class))
                .pollingEvery(200, TimeUnit.MILLISECONDS).until(driver -> {
            element.click();
            return true;
        });
    }

    public boolean isPresent() {
        //todo поставил 1 сек неявное ожидание вместо 0, пока не пойму, зачем оно вообще здесь
        setImplicity(1);
        List<WebElement> list = getDriver().findElements(by);
        setImplicity(10);
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

    public String getValue() {
        return getAttribute("value");
    }

    private void executeJS(String script) {
        ((JavascriptExecutor) getDriver()).executeScript(script, slaveElement());
    }

    public void scrollToElement() {
        executeJS("arguments[0].scrollIntoView(true);");
    }

    /**
     * Method gets all elements from the page with current element locator
     * Each element created via reflection getClass from current object,
     * get constructor and then creates new instance of current object
     * Can throw reflection exceptions. If it will be then you should use same method which commented after current
     * @return returns List of Elements with current locator
     */


    public synchronized   <T extends Element>  List<T> getAllElements() {
        List<WebElement> elements = getDriver().findElements(by);
        List<T> customElements = new ArrayList<>();

        for(int i=0; i<elements.size();i++){
            T element = null;
            try{
                element = (T) this.getClass().getConstructor( new Class[]{By.class} ).newInstance( By.xpath("("+getXpath(by)+")["+i+1+"]") );
            }catch(Exception e){
                logger.error("Something gone wrong with reflection in ELEMENT");
            }
            customElements.add(element);
        }
        return customElements;
    }

    public List<WebElement> getAllWebElements(){
        return getDriver().findElements(by);
    }



/*
This method we have in case that method above will produce errors
*
 */

    //
//    public synchronized   <T extends Element>  List<T> getAllElements(Class<T> clazz) {
//        List<WebElement> elements = getDriver().findElements(by);
//        List<T> customElements = new ArrayList<>();
//
//        for(int i=0; i<elements.size();i++){
//            T element = null;
//            try{
//                element = clazz.getConstructor( new Class[]{By.class} ).newInstance( By.xpath("("+getXpath(by)+")["+i+1+"]") );
//            }catch(Exception e){
//              logger.error("Something gone wrong with reflection in ELEMENT");
//            }
//            customElements.add(element);
//        }
//        return customElements;
//    }

    /**
     * Use this if u want to create sub element from element
     * Example : Button button = anotherButton.getElementByXpath(xpath);
     * ONLY USE IF U WANT TO GET ELEMENT OF THE SAME TYPE
     * Otherwise see next method as example :
     * @see Panel#getPanelByXpath(String)
     * @param xpath
     * @param <T>
     * @return sub element from current element
     */


    public <T extends Element> T getElementByXpath(String xpath) {
        String fullXpath = getXpath(by) + xpath;
        T element = null;
        try {
            element= (T) this.getClass().getConstructor(new Class[]{By.class}).newInstance(By.xpath(fullXpath));
        }
        catch (Exception e){

        }
        return element;
    }

    /**
     * Get's Xpath from By object
     * @param by Object of By type which xpath you want to get
     * @return string with xpath from By param
     */

    String getXpath(By by) {
        String stringOfBy = by.toString();
        String clearXpath = stringOfBy.substring(stringOfBy.indexOf("/"), stringOfBy.length());
        return clearXpath;
    }

    public void waitForElementToBePresent(int seconds) {
        new WebDriverWait(getDriver(), seconds).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForElementToBeClickable(int seconds) {
        setImplicity(0);
        new WebDriverWait(getDriver(), seconds).until(ExpectedConditions.elementToBeClickable(by));
        setImplicity(10);
    }

    public void waitForElementToBeVisible(int seconds) {
        setImplicity(0);
        new WebDriverWait(getDriver(), seconds).until(ExpectedConditions.visibilityOfElementLocated(by));
        setImplicity(10);
    }

    public void waitForElementToBeInvisible(int seconds) {
        setImplicity(0);
        new WebDriverWait(getDriver(), seconds).until(ExpectedConditions.invisibilityOfElementLocated(by));
        setImplicity(10);
    }

    public void doubleClick() {
        Actions doubleClick = new Actions(getDriver());
        doubleClick.doubleClick(slaveElement()).build().perform();
    }

    /**
     * MEthod created for "Register" button which not clickable after first click
     * It click on element, waits until it will be invisible, if element not invisible click one more time
     * Catching StaleElementReferenceException because we can try to click in moment when page loads
     */

    public void clickUntilDisappeared() {
        click();
        for (int i = 0; i < 2; i++) {
            try {
                waitForElementToBeInvisible(6);
            } catch (TimeoutException e) {
                try {click();}
                catch (StaleElementReferenceException e1){}
            }
        }
    }

    /**
     * Same as {@link #click()} but via browser Javascript
     */

    public void clickWithJS() {
        executeJS("arguments[0].click();");
    }

    public boolean isEnabled() {
        return slaveElement().isEnabled();
    }

}