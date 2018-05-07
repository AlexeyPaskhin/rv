package com.popups;

import com.Elements.Button;
import com.Elements.Checkbox;
import com.Elements.Element;
import com.Elements.InputBox;
import com.pages.AbstractPage;
import com.pages.HomePage;
import com.pages.RulesPage;
import com.pages.landing.social.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.utils.DriverManager.getDriver;

/**
 * Pop-up 'Bistraya registratsyja'
 * + from header
 * + from LogIn pop-up
 */

public class FastRegisterPopup extends AbstractPage {
    private static final InputBox ENTER_EMAIL_INPUT = new InputBox(By.id("register-form-login"));
    private static final InputBox ENTER_PASS_INPUT = new InputBox(By.id("register-form-password"));
    private static final Button REGISTER_BUTTON = new Button(By.xpath("//button[@class='btn-popup-register']/span"));
    private static final Checkbox CURRENCY_RUB_CHECKBOX = new Checkbox(By.xpath("//div[@id='popup_register']//input[@name='currency' and @value='RUB']"));
    private static final Checkbox CURRENCY_USD_CHECKBOX = new Checkbox(By.xpath("//div[@id='popup_register']//input[@name='currency' and @value='USD']"));
    private static final Checkbox AGREE_CHECKBOX_POP_UP = new Checkbox(By.xpath("//div[@id='popup_register']//input[@name='agree' and @type='checkbox']"));
    private static final Checkbox AGREE_CHECKBOX_PAGE = new Checkbox(By.xpath("//form[@class='popup-form page-form']//input[@name='agree' and @type='checkbox']"));
    // Social networks buttons
    private static final Button VK_BUTTON_HOME_PAGE = new Button(By.xpath("//div[@id='popup_register']//div[@class='social-vk']"));
    private static final Button FB_BUTTON_HOME_PAGE = new Button(By.xpath("//div[@id='popup_register']//div[@class='social-fb']"));
    private static final Button OK_BUTTON_HOME_PAGE = new Button(By.xpath("//div[@id='popup_register']//div[@class='social-ok']"));
    private static final Button YA_BUTTON_HOME_PAGE = new Button(By.xpath("//div[@id='popup_register']//div[@class='social-ya']"));
    private static final Button MAILRU_BUTTON_HOME_PAGE = new Button(By.xpath("//div[@id='popup_register']//div[@class='social-mr']"));
    // Validation error messages
    public static final Element ENTER_VALID_EMAIL_ERROR = new Element(By.xpath("//span[contains(text(), 'Введите корректный e-mail')]"));
    public static final Element AGREE_WITH_RULES_ERROR = new Element(By.xpath("//span[contains(text(), 'Вы должны согласиться с правилами и условиями')]"));
    public static final Element EMPTY_EMAIL_FIELD_ERROR = new Element(By.xpath("//p[1]//span[contains(text(), 'Поле не должно быть пустым')]"));
    public static final Element EMPTY_PASSWORD_FIELD_ERROR = new Element(By.xpath("//p[2]//span[contains(text(), 'Поле не должно быть пустым')]"));
    public static final Element ENTER_REAL_EMAIL_ERROR = new Element(By.xpath("//span[contains(text(), 'Введите настоящий e-mail')]"));

    private static final Element RULES_AND_CONDITIONS_LINK = new Element(By.xpath("//div[@id='popup_register']//a[text()='правилами и условиями']"));
    private static final Button CLOSE_FAST_REGISTER_POP_UP_BUTTON = new Button(By.xpath("//*[@id=\"popup_register\"]/a"));
    private static final Element CLICK_AUTH_LINK = new Element(By.xpath("//*[@id=\"popup_register\"]//a[@data-popup-open='auth']"));

    public static final Button CLOSE_BUTTON = new Button(By.xpath("//*[@id=\"popup_register\"]/a"));
    private String parent = getDriver().getWindowHandle();

    @Step
    public FastRegisterPopup typeLogin(String login) {
        ENTER_EMAIL_INPUT.fillIn(login);
        return this;
    }

    @Step
    public FastRegisterPopup typePass(String pass) {
        ENTER_PASS_INPUT.fillIn(pass);
        return this;
    }

    @Step
    public FastRegisterPopup selectCurrencyRUB() {
        CURRENCY_RUB_CHECKBOX.waitForElementToBeVisible(6);
        CURRENCY_RUB_CHECKBOX.click();
        return this;
    }

    @Step
    public FastRegisterPopup selectCurrencyUSD() {
        CURRENCY_USD_CHECKBOX.waitForElementToBeVisible(6);
        CURRENCY_USD_CHECKBOX.click();
        return this;
    }

    @Step
    public FastRegisterPopup agreeWithRules() {
        if (AGREE_CHECKBOX_POP_UP.isPresent()) { AGREE_CHECKBOX_POP_UP.click(); }
        else { AGREE_CHECKBOX_PAGE.click(); }
        return this;
    }

    @Step
    public WelcomeBonusGiftPopup clickRegisterButton() {
        REGISTER_BUTTON.clickUntilDisappeared();
        return new WelcomeBonusGiftPopup();
    }

    @Step
    public SocialFrame clickVK() {
        VK_BUTTON_HOME_PAGE.click();
        swithToSocialFrame();
        return new VkRegisterPage(parent);
    }

    @Step
    public SocialFrame clickMailRu() {
        MAILRU_BUTTON_HOME_PAGE.click();
        swithToSocialFrame();
        return new MailRuRegisterPage(parent);
    }

    @Step
    public SocialFrame clickFB() {
        FB_BUTTON_HOME_PAGE.waitForElementToBeClickable(4);
        FB_BUTTON_HOME_PAGE.click();
        swithToSocialFrame();
        return new FBregisterPage(parent);
    }

    @Step
    public SocialFrame clickOK() {
        OK_BUTTON_HOME_PAGE.waitForElementToBeClickable(4);
        OK_BUTTON_HOME_PAGE.click();
        swithToSocialFrame();
        return new OKRegisterPage(parent);
    }

    @Step
    public SocialFrame clickYA() {
        YA_BUTTON_HOME_PAGE.waitForElementToBeClickable(4);
        YA_BUTTON_HOME_PAGE.click();
        swithToSocialFrame();
        return new YARegisterPage(parent);
    }

    @Step
    public RulesPage checkRulesAndConditionsLink() {
        RULES_AND_CONDITIONS_LINK.waitForElementToBeClickable(3);
        RULES_AND_CONDITIONS_LINK.click();
        return new RulesPage();
    }

    @Step
    public HomePage closeFastRegisterPopUp() {
        CLOSE_FAST_REGISTER_POP_UP_BUTTON.click();
        return new HomePage();
    }

    @Step
    public AuthPopup clickAuthLink() {
        CLICK_AUTH_LINK.click();
        return new AuthPopup();
    }

    @Step
    public FastRegisterPopup clickRegisterButtonAndDoNothing() {
        REGISTER_BUTTON.clickUntilDisappeared();
        return new FastRegisterPopup();
    }

    public String getValidEmailMessageText() {
        ENTER_VALID_EMAIL_ERROR.waitForElementToBePresent(6);
        return ENTER_VALID_EMAIL_ERROR.getText();
    }

    public String getAgreeWithRulesValidationMessageText() {
        AGREE_WITH_RULES_ERROR.waitForElementToBeVisible(9);
        return AGREE_WITH_RULES_ERROR.getText();
    }


    public String getEmailFieldEmptyErrorMessaheText() {
        EMPTY_EMAIL_FIELD_ERROR.waitForElementToBeVisible(9);
        return EMPTY_EMAIL_FIELD_ERROR.getText();
    }

    public String getPasswordFilledErrorMessageText() {
        EMPTY_PASSWORD_FIELD_ERROR.waitForElementToBeInvisible(7);
        return EMPTY_PASSWORD_FIELD_ERROR.getText();
    }

    public String getRealEmailText() {
        ENTER_REAL_EMAIL_ERROR.waitForElementToBeVisible(6);
        return ENTER_REAL_EMAIL_ERROR.getText();
    }

    @Step
    public HomePage pressButtonClosepopUp() {
        CLOSE_BUTTON.click();
        return new HomePage();
    }
}
