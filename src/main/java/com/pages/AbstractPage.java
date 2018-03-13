package com.pages;

import com.Elements.Button;
import com.Elements.Panel;
import com.utils.CustomDataProvider;
import org.openqa.selenium.By;

import static com.utils.DriverManager.getDriver;

public abstract class AbstractPage implements IAbstractPage {
    public Button CLOSE_POPUP = new Button(By.xpath("//noindex//a[@class='popup-close']"));
    public Panel PRELOADER = new Panel(By.id("popup_spinner"));
    public String SOCIAL_LOGIN_WINDOW = "uLogin_window";
    public CustomDataProvider provider = new CustomDataProvider();

    public void swithToSocialFrame() {
        waitForCountOfWindows(2);
        for (String winHandle : getDriver().getWindowHandles()) {
            swithToWindow(winHandle);
        }
        waitForPageToLoad();
    }


}
