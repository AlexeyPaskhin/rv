package com.pages;

import com.Elements.Button;
import com.Elements.Element;
import com.Elements.Panel;
import com.utils.CustomDataProvider;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;

import static com.pages.Header.BLANK_IFRAME;
import static com.utils.DriverManager.getDriver;

@Getter
public abstract class AbstractPage implements IAbstractPage {
    public Panel PRELOADER = new Panel(By.id("popup_spinner"));
    public String SOCIAL_LOGIN_WINDOW = "uLogin_window";
    public CustomDataProvider provider = new CustomDataProvider();
    private Button WINNINGS_FOOTER_BTN = new Button(By.xpath("//div[@class='bottom-content']//span[text()='Выигрыши']/.."));
    private Element POPUP_PUSH_NOTIFICATIONS = new Element(By.id("popup_push-notifications-invite"));
    private Button REJECT_NOTIFICATIONS = new Button(By.xpath("//a[contains(text(), 'Отказаться')]"));
    private Button CLOSE_POP_UP_BUTTON = new Button(By.xpath("//div[contains(@style, 'display: block')]/a[@class='popup-close']"));  //fits to any pop up

    public AbstractPage() {
        try {
            if (POPUP_PUSH_NOTIFICATIONS.isPresent()) {
                REJECT_NOTIFICATIONS.click();    //temp decision for android 4.4 - the page loads more than 15 sec
            }
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
    }

    public void eliminatePopUp() {
        try {
            if (BLANK_IFRAME.isPresent()) {
                BLANK_IFRAME.waitForElementToBeInvisible(5);
            }
        } catch (TimeoutException e) {
            CLOSE_POP_UP_BUTTON.click();
        }
    }

    public AbstractPage goTo(String url) {
        getDriver().navigate().to(url);
        return this;
    }

    public void switchToSocialFrame() {
        waitForCountOfWindows(2);
        for (String winHandle : getDriver().getWindowHandles()) {
            switchToWindow(winHandle);
        }
        waitForPageToLoad();
    }

    @Step
    public AbstractPage goBack() {
        getDriver().navigate().back();
        return this;
    }

    public Footer getFooter() {
        return new Footer();
    }

    @Step
    public WinningsPage clickWinningsBtn() {
        return getFooter().clickWinnings();
    }

}
