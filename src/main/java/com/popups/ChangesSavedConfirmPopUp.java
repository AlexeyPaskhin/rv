package com.popups;

import com.Elements.Button;
import com.pages.AbstractPage;
import com.pages.ProfilePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ChangesSavedConfirmPopUp extends AbstractPage {
    public Button CLOSE_POPUP_SUCCESS_CHANGES_BUTTON = new Button(By.xpath("//div[@id='popup_alert']/a[@class='popup-close']"));

    public ChangesSavedConfirmPopUp() {
        CLOSE_POPUP_SUCCESS_CHANGES_BUTTON.waitForElementToBeClickable(5);
    }

    @Step
    public ProfilePage closeConfirmPopUp() {
        CLOSE_POPUP_SUCCESS_CHANGES_BUTTON.waitForElementToBeVisible(5);
        CLOSE_POPUP_SUCCESS_CHANGES_BUTTON.click();
        return new ProfilePage();
    }

}