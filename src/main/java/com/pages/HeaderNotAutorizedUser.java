package com.pages;

import com.Elements.Button;
import com.Elements.Element;
import com.Elements.InputBox;
import com.pages.landing.social.*;
import com.popups.FastRegisterPopup;
import com.popups.ResetPasswordPopUp;
import com.popups.LogInPopUp;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.utils.DriverManager.getDriver;

public class HeaderNotAutorizedUser extends AbstractPage implements Header {
    HomePage homePage;

    private final Button REGISTER_BUTTON = new Button(By.cssSelector(".btn-registration-top"));
    // social network buttons
    private final Button HEAD_VK_BUTTON = new Button(By.xpath("//form[@id='top-user-form']//div[@class='social-vk']"));
    private final Button HEAD_FB_BUTTON = new Button(By.xpath("//form[@id='top-user-form']//div[@class='social-fb']"));
    private final Button HEAD_OK_BUTTON = new Button(By.xpath("//form[@id='top-user-form']//div[@class='social-ok']"));
    private final Button HEAD_MailRU_BUTTON = new Button(By.xpath("//form[@id='top-user-form']//div[@class='social-mr']"));
    private final Button HEAD_YA_BUTTON = new Button(By.xpath("//form[@id='top-user-form']//div[@class='social-ya']"));
    // header
    private final InputBox EMAIL_INPUT_BOX_IN_HEADER = new InputBox(By.xpath("//input[@id='top-user-form__login']"));
    private final InputBox PASS_INPUT_BOX_IN_HEADER = new InputBox(By.xpath("//input[@id='top-user-form__password']"));
    private final Button LOGIN_BUTTON_IN_HEADER = new Button(By.xpath("//button[@class='btn-auth-top']//span"));

    private String parent = getDriver().getWindowHandle();

    private final Element LOGO_ICON = new Element(By.xpath("//a[@class='logo']"));
    private final Element RESET_PASSWORD_LINK = new Element(By.xpath("//*[@id=\"top-user-form\"]//a"));
    private final Button VOITI_BUTTON_IN_HEADER = new Button(By.xpath("//*[@id=\"top-user-form\"]//button"));
    private final Element LOG_OUT = new Element(By.xpath("//a[@class='logout']"));

    @Step
    public VkRegisterPage clickHeadVK() {
        HEAD_VK_BUTTON.click();
        swithToSocialFrame();
        return new VkRegisterPage(parent);
    }

    @Step
    public FBregisterPage clickHeadFB() {
        HEAD_FB_BUTTON.click();
        swithToSocialFrame();
        return new FBregisterPage(parent);
    }

    @Step
    public OKRegisterPage clickHeadOK() {
        HEAD_OK_BUTTON.click();
        swithToSocialFrame();
        return new OKRegisterPage(parent);
    }

    @Step
    public MailRuRegisterPage clickHeadMailRU() {
        HEAD_MailRU_BUTTON.click();
        swithToSocialFrame();
        return new MailRuRegisterPage(parent);
    }

    @Step
    public YARegisterPage clickHeadYA() {
        HEAD_YA_BUTTON.click();
        swithToSocialFrame();
        return new YARegisterPage(parent);
    }

    @Step
    public FastRegisterPopup clickRegister() {
        REGISTER_BUTTON.click();
        return new FastRegisterPopup();
    }

    @Step
    public HomePage clickLogin() {
        LOGIN_BUTTON_IN_HEADER.waitForElementToBeClickable(3);
        LOGIN_BUTTON_IN_HEADER.clickUntilDisappeared();
        return new HomePage();
    }

    @Step
    public HeaderNotAutorizedUser typeEmailInHeadField(String email) {
        EMAIL_INPUT_BOX_IN_HEADER.cleaIn();
        EMAIL_INPUT_BOX_IN_HEADER.fillIn(email);
        return this;
    }

    @Step
    public HeaderNotAutorizedUser typePassInHeadField(String pass) {
        PASS_INPUT_BOX_IN_HEADER.cleaIn();
        PASS_INPUT_BOX_IN_HEADER.fillIn(pass);
        return this;
    }

    @Step
    public boolean registerButtonIsPresent() {
        homePage = new HomePage();
        homePage.homePageLoaded();
        return REGISTER_BUTTON.isPresent();
    }

    @Step
    public HomePage clickLogoIcon() {
        LOGO_ICON.waitForElementToBeClickable(3);
        LOGO_ICON.click();
        return new HomePage();
    }

    @Step
    public boolean isLogoIconVisible() {
        return LOGO_ICON.isVisible();
    }

    @Step
    public ResetPasswordPopUp clickResetPasswordLink() {
        RESET_PASSWORD_LINK.click();
        return new ResetPasswordPopUp();
    }

    @Step
    public LogInPopUp pressButtonLoginForInvalidCredentials() {
        VOITI_BUTTON_IN_HEADER.waitForElementToBeClickable(3);
        VOITI_BUTTON_IN_HEADER.click();
        return new LogInPopUp();
    }
}
