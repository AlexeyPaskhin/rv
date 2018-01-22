package com.pages;

import com.Elements.Button;
import com.Elements.InputBox;
import com.Elements.Panel;
import com.pages.landing.social.*;
import com.popups.FastRegisterPopup;
import org.openqa.selenium.By;

public class HeaderNotAutorizedUser extends AbstractPage {
    HomePage homePage;

    private final Button REGISTER_BUTTON = new Button(By.cssSelector(".btn-registration-top"));

    private final Button HEAD_VK_BUTTON = new Button(By.xpath("//form[@id='top-user-form']//div[@class='social-vk']"));
    private final Button HEAD_FB_BUTTON = new Button(By.xpath("//form[@id='top-user-form']//div[@class='social-fb']"));
    private final Button HEAD_OK_BUTTON = new Button(By.xpath("//form[@id='top-user-form']//div[@class='social-ok']"));
    private final Button HEAD_MailRU_BUTTON = new Button(By.xpath("//form[@id='top-user-form']//div[@class='social-mr']"));
    private final Button HEAD_YA_BUTTON = new Button(By.xpath("//form[@id='top-user-form']//div[@class='social-ya']"));

    private final InputBox EMAIL_INPUT_BOX_IN_HEADER = new InputBox(By.xpath("//input[@id='top-user-form__login']"));
    private final InputBox PASS_INPUT_BOX_IN_HEADER = new InputBox(By.xpath("//input[@id='top-user-form__password']"));
    private final Button LOGIN_BUTTON_IN_HEADER = new Button(By.xpath("//button[@class='btn-auth-top']//span"));

    public VkRegisterPage clickHeadVK() {
        HEAD_VK_BUTTON.click();
        swithToSocialFrame();
        return new VkRegisterPage();
    }

    public FBregisterPage clickHeadFB() {
        HEAD_FB_BUTTON.click();
        swithToSocialFrame();
        return new FBregisterPage();
    }

    public OKRegisterPage clickHeadOK() {
        HEAD_OK_BUTTON.click();
        swithToSocialFrame();
        return new OKRegisterPage();
    }

    public MailRuRegisterPage clickHeadMailRU() {
        HEAD_MailRU_BUTTON.click();
        swithToSocialFrame();
        return new MailRuRegisterPage();
    }

    public YARegisterPage clickHeadYA() {
        HEAD_YA_BUTTON.click();
        swithToSocialFrame();
        return new YARegisterPage();
    }

    public FastRegisterPopup clickRegister() {
        REGISTER_BUTTON.click();
        return new FastRegisterPopup();
    }

    public HeaderAutorizedUser clickLogin() {
        LOGIN_BUTTON_IN_HEADER.click();
        return new HeaderAutorizedUser();
    }

    public HeaderNotAutorizedUser typeEmailInHeadField(String email) {
        EMAIL_INPUT_BOX_IN_HEADER.fillIn(email);
        return this;
    }

    public HeaderNotAutorizedUser typePassInHeadField(String pass) {
        PASS_INPUT_BOX_IN_HEADER.fillIn(pass);
        return this;
    }

    public boolean registerButtonIsPresent() {
        homePage = new HomePage();
        homePage.homePageLoaded();
        return REGISTER_BUTTON.isPresent();
    }

}
