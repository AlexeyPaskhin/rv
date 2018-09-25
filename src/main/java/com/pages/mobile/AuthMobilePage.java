package com.pages.mobile;

import com.Elements.Button;
import com.Elements.InputBox;
import com.pages.AbstractPage;
import com.pages.landing.social.*;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class AuthMobilePage extends AbstractPage {
    private InputBox EMAIL_INPUT_BOX = new InputBox(By.id("auth-form-login"));
    private InputBox PASS_INPUT_BOX = new InputBox(By.id("auth-form-password"));
    private Button LOGIN_BUTTON = new Button(By.className("btn-send"));
    private Button VK_LOGIN = new Button(By.xpath("//div[@id='popup_authorization']//div[@class='social-vk']"));
    private Button OK_LOGIN = new Button(By.xpath("//div[@id='popup_authorization']//div[@class='social-ok']"));
    private Button MR_LOGIN = new Button(By.xpath("//div[@id='popup_authorization']//div[@class='social-mr']"));
    private Button FB_LOGIN = new Button(By.xpath("//div[@id='popup_authorization']//div[@class='social-fb']"));
    private Button YA_LOGIN = new Button(By.xpath("//div[@id='popup_authorization']//div[@class='social-ya']"));

    public AuthMobilePage() {
        waitForPageToLoad();
    }

    @Step
    public AuthMobilePage fillEmail(String login) {
        EMAIL_INPUT_BOX.cleaIn();
        EMAIL_INPUT_BOX.fillIn(login);
        return this;
    }

    @Step
    public AuthMobilePage fillPass(String pass) {
        PASS_INPUT_BOX.cleaIn();
        PASS_INPUT_BOX.fillIn(pass);
        return this;
    }

    @Step
    public HomeMobilePage clickLogin() {
        LOGIN_BUTTON.click();
        return new HomeMobilePage();
    }

    @Step
    public VkRegisterPage clickVkLogin() {
        VK_LOGIN.waitForElementToBeClickable(5);
        VK_LOGIN.click();
        switchToSocialFrame();
        return new VkRegisterPage();
    }

    @Step
    public FBregisterPage clickFbLogin() {
        FB_LOGIN.waitForElementToBeClickable(5);
        FB_LOGIN.click();
        switchToSocialFrame();
        return new FBregisterPage();
    }

    @Step
    public OKRegisterPage clickOkLogin() {
        OK_LOGIN.waitForElementToBeClickable(5);
        OK_LOGIN.click();
        switchToSocialFrame();
        return new OKRegisterPage();
    }

    @Step
    public MailRuRegisterPage clickMrLogin() {
        MR_LOGIN.waitForElementToBeClickable(5);
        MR_LOGIN.click();
        switchToSocialFrame();
        return new MailRuRegisterPage();
    }

    @Step
    public YARegisterPage clickYaLogin() {
        YA_LOGIN.waitForElementToBeClickable(5);
        YA_LOGIN.click();
        switchToSocialFrame();
        return new YARegisterPage();
    }
}
