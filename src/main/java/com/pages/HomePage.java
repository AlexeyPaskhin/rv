package com.pages;

import com.Elements.Panel;
import com.popups.GiftPopup;
import org.openqa.selenium.By;

public class HomePage extends AbstractPage {
    private final Panel CONTENT_PANE = new Panel(By.xpath("//div[@class='wrap cf']"));
    private final GiftPopup GIFT_POPUP = new GiftPopup();

    public GiftPopup getGiftPopup() {
        return GIFT_POPUP;
    }

    public void homePageLoaded() {
        CONTENT_PANE.waitForElementToBeVisible(10);
    }
}
