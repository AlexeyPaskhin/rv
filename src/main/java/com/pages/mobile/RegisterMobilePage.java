package com.pages.mobile;

import com.Elements.Button;
import com.Elements.Checkbox;
import com.Elements.Element;
import com.Elements.InputBox;
import com.pages.AbstractPage;
import com.pages.landing.social.*;
import com.popups.WelcomeBonusGiftPopup;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static com.utils.DriverManager.getDriver;

@Getter
public class RegisterMobilePage extends AbstractPage {
    private InputBox EMAIL_INPUT_BOX = new InputBox(By.xpath("//input[@id='register-form-login']"));
    private Element INVALID_EMAIL_MESSAGE = EMAIL_INPUT_BOX.getSubElementByXpath("/../span[@class='errors']");
    private InputBox PASS_INPUT_BOX = new InputBox(By.xpath("//input[@id='register-form-password']"));
    private Element INVALID_PASS_MESSAGE = PASS_INPUT_BOX.getSubElementByXpath("/../span[@class='errors']");
    private Checkbox AGREE_WITH_RULES = new Checkbox(By.xpath("//label[@for='terms_confirm']"));
    private Element NOT_MARKED_AGREE_WITH_RULES = AGREE_WITH_RULES.getSubElementByXpath("/../span[contains(@class, 'errors')]");
    private Button REGISTER_BUTTON = new Button(By.xpath("//div[@id='popup_registration']//button[@class='btn-fastreg-profile']"));
    private Button VK_REGISTER = new Button(By.xpath("//div[@id='popup_registration']//div[@class='social-vk']"));
    private Button OK_REGISTER = new Button(By.xpath("//div[@id='popup_registration']//div[@class='social-ok']"));
    private Button MR_REGISTER = new Button(By.xpath("//div[@id='popup_registration']//div[@class='social-mr']"));
    private Button FB_REGISTER = new Button(By.xpath("//div[@id='popup_registration']//div[@class='social-fb']"));
    private Button YA_REGISTER = new Button(By.xpath("//div[@id='popup_registration']//div[@class='social-ya']"));

    @Step
    public RegisterMobilePage fillEmail(String email) {
        EMAIL_INPUT_BOX.cleaIn();
        EMAIL_INPUT_BOX.fillIn(email);
        return this;
    }

    @Step
    public RegisterMobilePage fillPass(String pass) {
        PASS_INPUT_BOX.cleaIn();
        PASS_INPUT_BOX.fillIn(pass);
        return this;
    }

    @Step
    public RegisterMobilePage agreeWithRules() {
        Actions builder = new Actions(getDriver());
        Action action = builder.moveToElement(AGREE_WITH_RULES.slaveElement(), 5, 1).click().build();
        action.perform(); //our checkbox -- pseudo element ::before. and we have a href inside the label. so we are forced to click specific coordinates of the element
//        AGREE_WITH_RULES.click();
        return this;
    }

    @Step
    public WelcomeBonusGiftPopup clickRegisterButton() {
        REGISTER_BUTTON.click();
        return new WelcomeBonusGiftPopup();
    }

    @Step
    public RegisterMobilePage clickRegisterInInvalidForm() {
        REGISTER_BUTTON.click();
        return new RegisterMobilePage();
    }

    @Step
    public FBregisterPage clickFB() {
        FB_REGISTER.waitForElementToBeClickable(5);
        FB_REGISTER.click();
        switchToSocialFrame();
        return new FBregisterPage();
    }

    @Step
    public VkRegisterPage clickVK() {
        VK_REGISTER.waitForElementToBeClickable(5);
        VK_REGISTER.click();
        switchToSocialFrame();
        return new VkRegisterPage();
    }

    @Step
    public OKRegisterPage clickOK() {
        OK_REGISTER.waitForElementToBeClickable(5);
        OK_REGISTER.click();
        switchToSocialFrame();
        return new OKRegisterPage();
    }

    @Step
    public MailRuRegisterPage clickMR() {
        MR_REGISTER.waitForElementToBeClickable(5);
        MR_REGISTER.click();
        switchToSocialFrame();
        return new MailRuRegisterPage();
    }

    @Step
    public YARegisterPage clickYA() {
        YA_REGISTER.waitForElementToBeClickable(5);
        YA_REGISTER.click();
        switchToSocialFrame();
        return new YARegisterPage();
    }
}
