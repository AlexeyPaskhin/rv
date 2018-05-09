package com.pages.landing;

import com.Elements.*;
import com.pages.AbstractPage;
import com.pages.Helpers.Dictionaries.RegistrationFormType;
import com.pages.HomePage;
import com.pages.landing.social.*;
import com.popups.FastRegisterPopup;
import com.popups.WelcomeBonusGiftPopup;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.utils.DriverManager.getDriver;

public class FastRegisterLP extends AbstractPage {

    private InputBox EMAIL_INPUT;
    private InputBox PASSWORD_INPUT;
    private RadioButton CURRENCY_RUB_RADIO;
    private RadioButton CURRENCY_USD_RADIO;
    private Checkbox AGREE_CHECKBOX;
    private Button REGISTER_BUTTON;
    // pop-up - Social networks buttons
    private static final Button VK_BUTTON = new Button(By.xpath("//div[@class='social-vk']"));
    private static final Button FB_BUTTON = new Button(By.xpath("//div[@class='social-fb']"));
    private static final Button MAILRU_BUTTON = new Button(By.xpath("//div[@class='social-mr']"));
    private static final Button OK_BUTTON = new Button(By.xpath("//div[@class='social-ok']"));
    private static final Button YA_BUTTON = new Button(By.xpath("//div[@class='social-ya']"));

    private String parent = getDriver().getWindowHandle();

    FastRegisterPopup fastRegisterPopup = new FastRegisterPopup();

    public FastRegisterLP(RegistrationFormType registrationType) {
        this.EMAIL_INPUT = registrationType.getEmailInput();
        this.PASSWORD_INPUT = registrationType.getPasswordInput();
        this.CURRENCY_RUB_RADIO = registrationType.getCurrencyRubRadio();
        this.CURRENCY_USD_RADIO = registrationType.getCurrencyUsdRadio();
        this.AGREE_CHECKBOX = registrationType.getAgreeCheckbox();
        this.REGISTER_BUTTON = registrationType.getRegisterButton();
    }

    @Step
    public FastRegisterLP typeLogin(String login) {
        EMAIL_INPUT.waitForElementToBePresent(5);
        EMAIL_INPUT.fillIn(login);
        return this;
    }

    @Step
    public FastRegisterLP typePass(String pass) {
        PASSWORD_INPUT.fillIn(pass);
        return this;
    }

    @Step
    public FastRegisterLP selectCurrencyRUB() {
        CURRENCY_RUB_RADIO.waitForElementToBePresent(5);
        CURRENCY_RUB_RADIO.click();
        return this;
    }

    @Step
    public FastRegisterLP selectCurrencyUSD() {
        CURRENCY_USD_RADIO.waitForElementToBePresent(5);
        CURRENCY_USD_RADIO.click();
        return this;
    }

    @Step
    public FastRegisterLP agreeWithRules() {
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
        REGISTER_BUTTON.waitForElementToBePresent(5);
        REGISTER_BUTTON.click();
        return new HomePage();
    }

    @Step("Click VK button")
    public SocialFrame clickVK() {
        if (VK_BUTTON.isPresent()) {
            VK_BUTTON.click();;
        } else if(fastRegisterPopup.VK_BUTTON_HOME_PAGE.isPresent()){
            System.out.println("CLICK VK BUTTON IN PAGE VERSION!!!");
            fastRegisterPopup.VK_BUTTON_HOME_PAGE.click();
        } else {
            System.out.println("DO NOT CLICK FIRST TIME!!!!!");
            VK_BUTTON.waitForElementToBePresent(5);
            VK_BUTTON.click();
        }

        swithToSocialFrame();
        return new VkRegisterPage(parent);
    }

    @Step("Click FB button")
    public SocialFrame clickFB() {
        if (FB_BUTTON.isPresent()) {
            FB_BUTTON.click();
        }else if(fastRegisterPopup.FB_BUTTON_HOME_PAGE.isPresent()){
            System.out.println("CLICK FB BUTTON IN PAGE VERSION!!!");
            fastRegisterPopup.FB_BUTTON_HOME_PAGE.click();
        } else {
            System.out.println("DO NOT CLICK FIRST TIME!!!!!");
            FB_BUTTON.waitForElementToBePresent(5);
            FB_BUTTON.click();
        }
        swithToSocialFrame();
        return new FBregisterPage(parent);
    }

    @Step("Click OK button")
    public SocialFrame clickOK() {
        if (OK_BUTTON.isPresent()) {
            OK_BUTTON.click();
        }else if(fastRegisterPopup.OK_BUTTON_HOME_PAGE.isPresent()){
            System.out.println("CLICK BUTTON IN PAGE VERSION!!!");
            fastRegisterPopup.OK_BUTTON_HOME_PAGE.click();
        } else {
            System.out.println("DO NOT CLICK FIRST TIME!!!!!");
            OK_BUTTON.waitForElementToBePresent(5);
            OK_BUTTON.click();
        }
        swithToSocialFrame();
        return new OKRegisterPage(parent);
    }

    @Step("Click YA button")
    public SocialFrame clickYA() {
        if (YA_BUTTON.isPresent()) {
            YA_BUTTON.click();
        }else if(fastRegisterPopup.YA_BUTTON_HOME_PAGE.isPresent()){
            System.out.println("CLICK BUTTON IN PAGE VERSION!!!");
            fastRegisterPopup.YA_BUTTON_HOME_PAGE.click();
        } else {
            System.out.println("DO NOT CLICK FIRST TIME!!!!!");
            YA_BUTTON.waitForElementToBePresent(5);
            YA_BUTTON.click();
        }
        swithToSocialFrame();
        return new YARegisterPage(parent);
    }

    @Step("Click MR button")
    public SocialFrame clickMailRu() {
        if (MAILRU_BUTTON.isPresent()) {
            MAILRU_BUTTON.click();
        }else if(fastRegisterPopup.MAIL_RU_BUTTON_HOME_PAGE.isPresent()){
            System.out.println("CLICK BUTTON IN PAGE VERSION!!!");
            fastRegisterPopup.MAIL_RU_BUTTON_HOME_PAGE.click();
        } else {
            System.out.println("DO NOT CLICK FIRST TIME!!!!!");
            MAILRU_BUTTON.waitForElementToBePresent(5);
            MAILRU_BUTTON.click();
        }
        swithToSocialFrame();
        return new MailRuRegisterPage(parent);
    }
}
