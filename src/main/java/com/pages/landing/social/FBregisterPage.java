package com.pages.landing.social;

import com.Elements.Button;
import com.Elements.InputBox;
import com.pages.AbstractPage;
import com.pages.mobile.HomeMobilePage;
import com.popups.ConfirmEmailPopup;
import com.utils.PropertyLoader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

public class FBregisterPage extends AbstractPage implements SocialFrame {
    private final static Logger logger = LogManager.getLogger(PropertyLoader.class);

    private final InputBox EMAIL_INPUT = new InputBox(By.name("email"));
    private final InputBox PASS_INPUT = new InputBox(By.name("pass"));
    private final Button LOGIN_BUTTON = new Button(By.name("login"));
    private String parentWindow;

    public FBregisterPage(String parentWindow) {
        this.parentWindow = parentWindow;
    }

    public FBregisterPage() {
    }

    @Override
    public SocialFrame setEmail(String email) {
        try {
            EMAIL_INPUT.cleaIn();
            EMAIL_INPUT.fillIn(email);
        } catch (StaleElementReferenceException e) {
            logger.info("---  The FB page was reloaded unexpectedly!");
            EMAIL_INPUT.cleaIn();
            EMAIL_INPUT.fillIn(email);  //sometimes the facebook page reloads immediately after opening.
        }

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
        LOGIN_BUTTON.click();
        return this;
    }

    public ConfirmEmailPopup switchToConfirmEmail() {
        switchToWindow(parentWindow);
        return new ConfirmEmailPopup();
    }
}
