package com.pages;

import com.Elements.Button;
import com.Elements.Panel;
import com.popups.FastRegisterPopup;
import com.popups.GiftPopup;
import org.openqa.selenium.By;

public class HomePage extends AbstractPage {
    private final Button REGISTER_BUTTON = new Button(By.cssSelector(".btn-registration-top"));
    private final Panel USER_PANE = new Panel(By.xpath("//div[@class='top-user-zone']"));
    private final Panel CONTENT_PANE = new Panel(By.xpath("//div[@class='wrap cf']"));
    private final GiftPopup GIFT_POPUP = new GiftPopup();

    public FastRegisterPopup clickRegister() {
        REGISTER_BUTTON.click();
        return new FastRegisterPopup();
    }

    public boolean RegisterButtonIsPresent() {
        homePageLoaded();
        return REGISTER_BUTTON.isPresent();
    }

    public boolean UserZoneIsPresent() {
        homePageLoaded();
        return USER_PANE.isPresent();
    }

    public GiftPopup getGiftPopup() {
        return GIFT_POPUP;
    }

    private void homePageLoaded() {
        CONTENT_PANE.waitForElementToBeVisible(10);
    }
}
