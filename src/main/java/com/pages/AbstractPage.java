package com.pages;

import com.Elements.Panel;
import org.openqa.selenium.By;

import static com.utils.DriverManager.getDriver;

public abstract class AbstractPage implements IAbstractPage {

    public Panel PRELOADER = new Panel(By.id("popup_spinner"));
    public String SOCIAL_LOGIN_WINDOW = "uLogin_window";

    public void swithToSocialFrame() {

        waitForCountOfWindows(2);
        for (String winHandle : getDriver().getWindowHandles()) {
            swithToWindow(winHandle);
        }
        waitForPageToLoad();
    }
}
