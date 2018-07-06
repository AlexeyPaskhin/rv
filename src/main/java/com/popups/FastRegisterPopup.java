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
import lombok.Getter;
import org.openqa.selenium.By;

import static com.utils.DriverManager.getDriver;

/**
 * Pop-up and page 'Bistraya registratsyja'
 * + from header
 * + from LogIn pop-up
 * + from the Lotteries page
 */

@Getter
public class FastRegisterPopup extends AbstractPage {
    private InputBox ENTER_EMAIL_INPUT = new InputBox(By.id("register-form-login"));
    private static final InputBox ENTER_PASS_INPUT = new InputBox(By.id("register-form-password"));
    private static final Button REGISTER_BUTTON_POP_UP = new Button(By.xpath("//button[@class='btn-popup-register']/span"));
    private static final Button REGISTER_BUTTON_PAGE = new Button(By.xpath("//*[@class='form-line']//button[@class='btn-popup-register']/span"));
    private static final Checkbox CURRENCY_RUB_CHECKBOX_POP_UP = new Checkbox(By.xpath("//div[@id='popup_register']//input[@name='currency' and @value='RUB']"));
    private static final Checkbox CURRENCY_RUB_CHECKBOX_PAGE = new Checkbox(By.xpath("//div[@class='inlineForm']//form[@data-form-role='register' and @action='/users/register']//input[@name='currency' and @value='RUB']"));
    private static final Checkbox CURRENCY_USD_CHECKBOX_POP_UP = new Checkbox(By.xpath("//div[@id='popup_register']//input[@name='currency' and @value='USD']"));
    private static final Checkbox CURRENCY_USD_CHECKBOX_PAGE = new Checkbox(By.xpath("//div[@class='inlineForm']//form[@data-form-role='register' and @action='/users/register']//input[@name='currency' and @value='USD']"));
    private static final Checkbox AGREE_CHECKBOX_POP_UP = new Checkbox(By.xpath("//div[@id='popup_register']//input[@name='agree' and @type='checkbox']"));
    private static final Checkbox AGREE_CHECKBOX_PAGE = new Checkbox(By.xpath("//form[@class='popup-form page-form']//input[@name='agree' and @type='checkbox']"));
    // Social networks buttons
    private static final Button VK_BUTTON_HOME_POP_UP = new Button(By.xpath("//div[@id='popup_register']//div[@class='social-vk']"));
    public static final Button VK_BUTTON_HOME_PAGE = new Button(By.xpath("//div[@class='inlineForm']//div[@class='form-line centered']//div[@class='social-vk']"));
    private static final Button FB_BUTTON_HOME_POP_UP = new Button(By.xpath("//div[@id='popup_register']//div[ @class='social-fb']"));
    public static final Button FB_BUTTON_HOME_PAGE = new Button(By.xpath("//div[@class='inlineForm']//div[@class='form-line centered']//div[@class='social-fb']"));
    private static final Button OK_BUTTON_HOME_POP_UP = new Button(By.xpath("//div[@id='popup_register']//div[@class='social-ok']"));
    public static final Button OK_BUTTON_HOME_PAGE = new Button(By.xpath("//div[@class='inlineForm']//div[@class='form-line centered']//div[@class='social-ok']"));
    private static final Button YA_BUTTON_HOME_POP_UP = new Button(By.xpath("//div[@id='popup_register']//div[@class='social-ya']"));
    public static final Button YA_BUTTON_HOME_PAGE = new Button(By.xpath("//div[@class='inlineForm']//div[@class='form-line centered']//div[@class='social-ya']"));
    private static final Button MAIL_RU_BUTTON_HOME_POP_UP = new Button(By.xpath("//div[@id='popup_register']//div[@class='social-mr']"));
    public static final Button MAIL_RU_BUTTON_HOME_PAGE = new Button(By.xpath("//div[@class='inlineForm']//div[@class='form-line centered']//div[@class='social-mr']"));
    // Validation error messages (page and pop-up)
    public static final Element ENTER_VALID_EMAIL_ERROR = new Element(By.xpath("//span[contains(text(), 'Введите корректный e-mail')]"));
    public static final Element AGREE_WITH_RULES_ERROR = new Element(By.xpath("//span[contains(text(), 'Вы должны согласиться с правилами и условиями')]"));
    public static final Element EMPTY_EMAIL_FIELD_ERROR = new Element(By.xpath("//p[1]//span[contains(text(), 'Поле не должно быть пустым')]"));
    public static final Element EMPTY_PASSWORD_FIELD_ERROR = new Element(By.xpath("//p[2]//span[contains(text(), 'Поле не должно быть пустым')]"));
    public static final Element ENTER_REAL_EMAIL_ERROR = new Element(By.xpath("//span[contains(text(), 'Введите настоящий e-mail')]"));

    private static final Element RULES_AND_CONDITIONS_LINK_POP_UP = new Element(By.xpath("//div[@id='popup_register']//a[text()='правилами и условиями']"));
    private static final Element RULES_AND_CONDITIONS_LINK_PAGE = new Element(By.xpath("//div[@class='inlineForm']//a[text()='правилами и условиями']"));
    private static final Button CLOSE_FAST_REGISTER_POP_UP_BUTTON = new Button(By.xpath("//*[@id='popup_register']/a"));
    private static final Element CLICK_AUTH_LINK_POP_UP = new Element(By.xpath("//*[@id='popup_register']//a[@data-popup-open='auth']"));
    private static final Element CLICK_AUTH_LINK_PAGE = new Element(By.xpath("//div[@class='inlineForm']//a[@data-popup-open='auth']"));

    private String parent = getDriver().getWindowHandle();

    @Step // the same locator for page and pop-up
    public FastRegisterPopup typeLogin(String login) {
        ENTER_EMAIL_INPUT.fillIn(login);
        return this;
    }

    @Step // the same locator for page and pop-up
    public FastRegisterPopup typePass(String pass) {
        ENTER_PASS_INPUT.fillIn(pass);
        return this;
    }

    @Step
    public FastRegisterPopup selectCurrencyRUB() {
        if (CURRENCY_RUB_CHECKBOX_POP_UP.isPresent()) {
            CURRENCY_RUB_CHECKBOX_POP_UP.click();
        } else {
            CURRENCY_RUB_CHECKBOX_PAGE.click();
        }
        return this;
    }

    @Step
    public FastRegisterPopup selectCurrencyUSD() {
        if (CURRENCY_USD_CHECKBOX_POP_UP.isPresent()) {
            CURRENCY_USD_CHECKBOX_POP_UP.click();
        } else {
            CURRENCY_USD_CHECKBOX_PAGE.click();
        }
        return this;
    }

    @Step
    public FastRegisterPopup agreeWithRules() {
        if (AGREE_CHECKBOX_POP_UP.isPresent()) {
            AGREE_CHECKBOX_POP_UP.click();
        } else {
            AGREE_CHECKBOX_PAGE.click();
        }
        return this;
    }

    @Step // the same locator for page and pop-up
    public WelcomeBonusGiftPopup clickRegisterButton() {
        REGISTER_BUTTON_POP_UP.clickUntilDisappeared();
        return new WelcomeBonusGiftPopup();
    }

    @Step
    public SocialFrame clickVK() {
        if (VK_BUTTON_HOME_POP_UP.isPresent()) {
            VK_BUTTON_HOME_POP_UP.click();
        } else {
            VK_BUTTON_HOME_PAGE.click();
        }
        switchToSocialFrame();
        return new VkRegisterPage(parent);
    }

    @Step
    public SocialFrame clickMailRu() {
        if (MAIL_RU_BUTTON_HOME_POP_UP.isPresent()) {
            MAIL_RU_BUTTON_HOME_POP_UP.click();
        } else {
            MAIL_RU_BUTTON_HOME_PAGE.click();
        }
        switchToSocialFrame();
        return new MailRuRegisterPage(parent);
    }

    @Step
    public SocialFrame clickFB() {
        if (FB_BUTTON_HOME_POP_UP.isPresent()) {
            FB_BUTTON_HOME_POP_UP.click();
        } else {
            FB_BUTTON_HOME_PAGE.click();
        }
        switchToSocialFrame();
        return new FBregisterPage(parent);
    }

    @Step
    public SocialFrame clickOK() {
        if (OK_BUTTON_HOME_POP_UP.isPresent()) {
            OK_BUTTON_HOME_POP_UP.click();
        } else {
            OK_BUTTON_HOME_PAGE.click();
        }
        switchToSocialFrame();
        return new OKRegisterPage(parent);
    }

    @Step
    public SocialFrame clickYA() {
        if (YA_BUTTON_HOME_POP_UP.isPresent()) {
            YA_BUTTON_HOME_POP_UP.click();
        } else {
            YA_BUTTON_HOME_PAGE.click();
        }
        switchToSocialFrame();
        return new YARegisterPage(parent);
    }

    @Step
    public RulesPage checkRulesAndConditionsLink() {
        if (RULES_AND_CONDITIONS_LINK_POP_UP.isPresent()) {
            RULES_AND_CONDITIONS_LINK_POP_UP.click();
        } else {
            RULES_AND_CONDITIONS_LINK_PAGE.click();
        }
        return new RulesPage();
    }

    @Step // only pop-up
    public HomePage closeFastRegisterPopUp() {
        CLOSE_FAST_REGISTER_POP_UP_BUTTON.click();
        return new HomePage();
    }

    @Step
    public LogInPopUp clickAuthLink() {
        if (CLICK_AUTH_LINK_POP_UP.isPresent()) {
            CLICK_AUTH_LINK_POP_UP.click();
        } else {
            CLICK_AUTH_LINK_PAGE.click();
        }
        return new LogInPopUp();
    }

    @Step
    public FastRegisterPopup clickRegisterButtonAndDoNothing() {
        if (REGISTER_BUTTON_POP_UP.isVisible()) {
            REGISTER_BUTTON_POP_UP.clickUntilDisappeared();
        } else {
            REGISTER_BUTTON_PAGE.click();
        }
        return new FastRegisterPopup();
    }

    public String getValidEmailMessageText() {
//        ENTER_VALID_EMAIL_ERROR.waitForElementToBePresent(6);
        return ENTER_VALID_EMAIL_ERROR.getText();
    }

    public String getAgreeWithRulesValidationMessageText() {
//        AGREE_WITH_RULES_ERROR.waitForElementToBeVisible(9);
        return AGREE_WITH_RULES_ERROR.getText();
    }


    public String getEmailFieldEmptyErrorMessaheText() {
//        EMPTY_EMAIL_FIELD_ERROR.waitForElementToBeVisible(9);
        return EMPTY_EMAIL_FIELD_ERROR.getText();
    }

    public String getPasswordFilledErrorMessageText() {
        EMPTY_PASSWORD_FIELD_ERROR.waitForElementToBeInvisible(7);
        return EMPTY_PASSWORD_FIELD_ERROR.getText();
    }

    public String getRealEmailText() {
//        ENTER_REAL_EMAIL_ERROR.waitForElementToBeVisible(6);
        return ENTER_REAL_EMAIL_ERROR.getText();
    }
}
