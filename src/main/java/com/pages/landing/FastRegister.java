package com.pages.landing;

import com.Elements.Button;
import com.Elements.Checkbox;
import com.Elements.InputBox;
import com.Elements.RadioButton;
import com.pages.AbstractPage;
import com.pages.Helpers.Dictionaries.RegistrationFormType;
import com.pages.HomePage;
import com.pages.landing.social.*;
import com.popups.WelcomeBonusGiftPopup;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.utils.DriverManager.getDriver;

public class FastRegister extends AbstractPage {

    private InputBox EMAIL_INPUT;
    private InputBox PASSWORD_INPUT;
    private RadioButton CURRENCY_RUB_RADIO;
    private RadioButton CURRENCY_USD_RADIO;
    private Checkbox AGREE_CHECKBOX;
    private Button REGISTER_BUTTON;
    private final Button VK_BUTTON = new Button(By.xpath("//div[@class='social-vk']"));
    private final Button FB_BUTTON = new Button(By.xpath("//div[@class='social-fb']"));
    private final Button MAILRU_BUTTON = new Button(By.xpath("//div[@class='social-mr']"));
    private final Button OK_BUTTON = new Button(By.xpath("//div[@class='social-ok']"));
    private final Button YA_BUTTON = new Button(By.xpath("//div[@class='social-ya']"));
    private String parent = getDriver().getWindowHandle();

    public FastRegister(RegistrationFormType registrationType) {
        this.EMAIL_INPUT = registrationType.getEmailInput();
        this.PASSWORD_INPUT = registrationType.getPasswordInput();
        this.CURRENCY_RUB_RADIO = registrationType.getCurrencyRubRadio();
        this.CURRENCY_USD_RADIO = registrationType.getCurrencyUsdRadio();
        this.AGREE_CHECKBOX = registrationType.getAgreeCheckbox();
        this.REGISTER_BUTTON = registrationType.getRegisterButton();
    }

    @Step
    public FastRegister typeLogin(String login) {
        EMAIL_INPUT.waitForElementToBePresent(4);
        EMAIL_INPUT.fillIn(login);
        return this;
    }

    @Step
    public FastRegister typePass(String pass) {
        PASSWORD_INPUT.fillIn(pass);
        return this;
    }

    @Step
    public FastRegister selectCurrencyRUB() {
        CURRENCY_RUB_RADIO.waitForElementToBePresent(3);
        CURRENCY_RUB_RADIO.click();
        return this;
    }

    @Step
    public FastRegister selectCurrencyUSD() {
        CURRENCY_USD_RADIO.waitForElementToBePresent(3);
        CURRENCY_USD_RADIO.click();
        return this;
    }

    @Step
    public FastRegister agreeWithRules() {
        AGREE_CHECKBOX.clickUntilDisappeared();
        return this;
    }

    @Step
    public WelcomeBonusGiftPopup clickRegisterButtonToGift() {
        REGISTER_BUTTON.clickUntilDisappeared();
        waitForPageToLoad();
        return new WelcomeBonusGiftPopup();
    }

    @Step("Click Register button to Home")
    public HomePage clickRegisterButtonToHome() {
        REGISTER_BUTTON.waitForElementToBePresent(2);
        REGISTER_BUTTON.clickUntilDisappeared();
        return new HomePage();
    }

    @Step("Click VK button")
    public SocialFrame clickVK() {
        VK_BUTTON.waitForElementToBePresent(2);
        VK_BUTTON.clickUntilDisappeared();
        swithToSocialFrame();
        return new VkRegisterPage(parent);
    }

    @Step("Click FB button")
    public SocialFrame clickFB() {
        FB_BUTTON.waitForElementToBePresent(2);
        FB_BUTTON.clickUntilDisappeared();
        swithToSocialFrame();
        return new FBregisterPage(parent);
    }

    @Step("Click OK button")
    public SocialFrame clickOK() {
        OK_BUTTON.waitForElementToBePresent(2);
        OK_BUTTON.clickUntilDisappeared();
        swithToSocialFrame();
        return new OKRegisterPage(parent);
    }

    @Step("Click YA button")
    public SocialFrame clickYA() {
        YA_BUTTON.waitForElementToBePresent(2);
        YA_BUTTON.clickUntilDisappeared();
        swithToSocialFrame();
        return new YARegisterPage(parent);
    }

    @Step("Click MR button")
    public SocialFrame clickMailRu() {
        MAILRU_BUTTON.waitForElementToBePresent(2);
        MAILRU_BUTTON.clickUntilDisappeared();
        swithToSocialFrame();
        return new MailRuRegisterPage(parent);
    }
}
