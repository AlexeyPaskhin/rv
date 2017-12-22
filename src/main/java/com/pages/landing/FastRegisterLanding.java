package com.pages.landing;

import com.Elements.Button;
import com.Elements.Checkbox;
import com.Elements.InputBox;
import com.Elements.RadioButton;
import com.pages.AbstractPage;
import com.pages.Helpers.Dictionaries.RegistrationFormType;
import com.pages.landing.social.*;
import com.popups.GiftPopup;
import org.openqa.selenium.By;

import static com.utils.DriverManager.getDriver;

public class FastRegisterLanding extends AbstractPage {

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


    public FastRegisterLanding(RegistrationFormType registrationType) {

        this.EMAIL_INPUT = registrationType.getEmailInput();
        this.PASSWORD_INPUT = registrationType.getPasswordInput();
        this.CURRENCY_RUB_RADIO = registrationType.getCurrencyRubRadio();
        this.CURRENCY_USD_RADIO = registrationType.getCurrencyUsdRadio();
        this.AGREE_CHECKBOX = registrationType.getAgreeCheckbox();
        this.REGISTER_BUTTON = registrationType.getRegisterButton();

    }

    public FastRegisterLanding typeLogin(String login) {
        EMAIL_INPUT.fillIn(login);
        return this;
    }

    public FastRegisterLanding typePass(String pass) {
        PASSWORD_INPUT.fillIn(pass);
        return this;
    }

    public FastRegisterLanding selectCurrencyRUB() {
        CURRENCY_RUB_RADIO.click();
        return this;
    }

    public FastRegisterLanding selectCurrencyUSD() {
        CURRENCY_USD_RADIO.click();
        return this;

    }

    public FastRegisterLanding agreeWithRules() {
        AGREE_CHECKBOX.click();
        return this;
    }

    public GiftPopup clickRegisterButtonToGift() {
        //wait(1500);
        REGISTER_BUTTON.clickUntilDisappeared();
        return new GiftPopup();
    }

    public SocialFrame clickVK() {
        VK_BUTTON.click();
        swithToSocialFrame();
        return new VkRegisterPage();
    }

    public SocialFrame clickFB() {
        FB_BUTTON.click();
        swithToSocialFrame();
        return new FBregisterPage();
    }

    public SocialFrame clickOK() {
        OK_BUTTON.click();
        swithToSocialFrame();
        return new OKRegisterPage();
    }

    public SocialFrame clickYA() {
        YA_BUTTON.click();
        swithToSocialFrame();
        return new YARegisterPage();
    }

    public SocialFrame clickMailRu() {
        MAILRU_BUTTON.click();
        swithToSocialFrame();
        return new MailRuRegisterPage();
    }

    private void swithToSocialFrame() {
        AbstractPage.parentWindow = getDriver().getWindowHandle();
        waitForCountOfWindows(2);
        for (String winHandle : getDriver().getWindowHandles()) {
            swithToWindow(winHandle);
        }
        waitForPageToLoad();
    }
}
