package com.popups;

import com.Elements.Button;
import com.Elements.Checkbox;
import com.Elements.InputBox;
import com.pages.AbstractPage;
import com.pages.landing.social.*;
import org.openqa.selenium.By;

import static com.utils.DriverManager.getDriver;

public class FastRegisterPopup extends AbstractPage  {
    private static final InputBox ENTER_EMAIL_INPUT = new InputBox(By.id("register-form-login"));
    private static final InputBox ENTER_PASS_INPUT = new InputBox(By.id("register-form-password"));
    private static final Button REGISTER_BUTTON = new Button(By.xpath("//button[@class='btn-popup-register']/span"));
    private static final Checkbox CURRENCY_RUB_CHECKBOX = new Checkbox(By.xpath("//div[@id='popup_register']//input[@name='currency' and @value='RUB']"));
    private static final Checkbox CURRENCY_USD_CHECKBOX = new Checkbox(By.xpath("//div[@id='popup_register']//input[@name='currency' and @value='USD']"));
    private static final Checkbox AGREE_CHECKBOX = new Checkbox(By.xpath("//div[@id='popup_register']//input[@name='agree' and @type='checkbox']"));

    private final Button VK_BUTTON = new Button(By.xpath("//div[@id='popup_register']//div[@class='social-vk']"));
    private final Button MAILRU_BUTTON = new Button(By.xpath("//div[@id='popup_register']//div[@class='social-mr']"));

    private static final Button VK_BUTTON_HOME_PAGE = new Button(By.xpath("//div[@id='popup_register']//div[@class='social-vk']"));
    private static final Button FB_BUTTON_HOME_PAGE = new Button(By.xpath("//div[@id='popup_register']//div[@class='social-fb']"));
    private static final Button OK_BUTTON_HOME_PAGE = new Button(By.xpath("//div[@id='popup_register']//div[@class='social-ok']"));
    private static final Button YA_BUTTON_HOME_PAGE = new Button(By.xpath("//div[@id='popup_register']//div[@class='social-ya']"));
    private static final Button MAILRU_BUTTON_HOME_PAGE = new Button(By.xpath("//div[@id='popup_register']//div[@class='social-mr']"));

    public FastRegisterPopup typeLogin(String login){
        ENTER_EMAIL_INPUT.fillIn(login);
        return this;
    }

    public FastRegisterPopup typePass(String pass){
        ENTER_PASS_INPUT.fillIn(pass);
        return this;
    }

    public FastRegisterPopup selectCurrencyRUB(){
        CURRENCY_RUB_CHECKBOX.click();
        return this;

    }

    public FastRegisterPopup selectCurrencyUSD(){
        CURRENCY_USD_CHECKBOX.click();
        return this;

    }
    public FastRegisterPopup agreeWithRules(){
        AGREE_CHECKBOX.click();
        return this;
    }

    public GiftPopup clickRegisterButton(){
        REGISTER_BUTTON.clickUntilDisappeared();
        return new GiftPopup();
    }

    public SocialFrame clickVK() {
        VK_BUTTON.click();
        swithToSocialFrame();
        return new VkRegisterPage();
    }

    public SocialFrame clickMailRu() {
        MAILRU_BUTTON.click();
        swithToSocialFrame();
        return new MailRuRegisterPage();
    }
    public SocialFrame clickFB() {
        FB_BUTTON_HOME_PAGE.click();
        swithToSocialFrame();
        return new FBregisterPage();
    }
}
