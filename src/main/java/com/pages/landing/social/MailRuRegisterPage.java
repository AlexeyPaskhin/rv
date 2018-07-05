package com.pages.landing.social;

import com.Elements.Button;
import com.Elements.InputBox;
import com.pages.AbstractPage;
import com.popups.ConfirmEmailPopup;
import org.openqa.selenium.By;

public class MailRuRegisterPage extends AbstractPage implements SocialFrame {
    private final InputBox EMAIL_INPUT = new InputBox(By.name("Login"));
    private final InputBox PASS_INPUT = new InputBox(By.name("Password"));
    private final Button LOGIN_BUTTON = new Button(By.xpath("//div[@class='login-form__footer']/button"));
    private String parentWindow;

    public MailRuRegisterPage() {
    }

    public MailRuRegisterPage(String parentWindow) {
        this.parentWindow = parentWindow;
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
    public SocialFrame clickLogIn() {
        return null;
    }

    public ConfirmEmailPopup switchToConfirmEmail() {
        switchToWindow(this.parentWindow);
        return new ConfirmEmailPopup();
    }
}
