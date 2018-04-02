package com.pages.landing.social;

import com.Elements.Button;
import com.Elements.InputBox;
import com.pages.AbstractPage;
import com.popups.ConfirmEmailPopup;
import org.openqa.selenium.By;

public class VkRegisterPage extends AbstractPage implements SocialFrame {

    private final InputBox EMAIL_INPUT = new InputBox(By.name("email"));
    private final InputBox PASS_INPUT = new InputBox(By.name("pass"));
    private final Button LOGIN_BUTTON = new Button(By.id("install_allow"));
    private String parentWindow;

    public VkRegisterPage(String parentWindow) {
        this.parentWindow = parentWindow;
    }

    public VkRegisterPage() {
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
        swithToWindow(this.parentWindow);
        return new ConfirmEmailPopup();

    }

    public ConfirmEmailPopup switchToConfirmEmail() {
        swithToWindow(parentWindow);
        return new ConfirmEmailPopup();
    }
}