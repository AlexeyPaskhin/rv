package com.pages.landing.social;

import com.Elements.Button;
import com.Elements.InputBox;
import com.pages.AbstractPage;
import com.pages.mobile.HomeMobilePage;
import com.popups.ConfirmEmailPopup;
import org.openqa.selenium.By;

public class YARegisterPage extends AbstractPage implements SocialFrame {
    private final InputBox EMAIL_INPUT = new InputBox(By.name("login"));
    private final InputBox PASS_INPUT = new InputBox(By.name("passwd"));
    private final Button LOGIN_BUTTON = new Button(By.xpath("//button[@class='passport-Button']"));
    private String parentWindow;

    public YARegisterPage(String parentWindow) {
        this.parentWindow = parentWindow;
    }

    public YARegisterPage() {
    }

    @Override
    public SocialFrame setEmail(String email) {
        EMAIL_INPUT.fillIn(email);
        return this;
    }

    @Override
    public SocialFrame setPassword(String password) {
        PASS_INPUT.fillIn(password);
        return this;
    }

    @Override
    public ConfirmEmailPopup clickRegister() {
        LOGIN_BUTTON.click();
        waitForCountOfWindows(1);
        switchToWindow(this.parentWindow);
        return new ConfirmEmailPopup();
    }

    @Override
    public HomeMobilePage clickLogInMobile() {
        LOGIN_BUTTON.click();
        return new HomeMobilePage();
    }

    @Override
    public SocialFrame clickLogInNotForVulkanAuth() {
        return null;
    }

    public ConfirmEmailPopup switchToConfirmEmail() {
        switchToWindow(parentWindow);
        return new ConfirmEmailPopup();
    }
}
