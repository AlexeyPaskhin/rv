package com.popups;

import com.Elements.Button;
import com.Elements.Checkbox;
import com.Elements.InputBox;
import com.pages.AbstractPage;
import org.openqa.selenium.By;

public class FastRegisterPopup extends AbstractPage  {
    private static final InputBox ENTER_EMAIL_INPUT = new InputBox(By.id("register-form-login"));
    private static final InputBox ENTER_PASS_INPUT = new InputBox(By.id("register-form-password"));
    private static final Button REGISTER_BUTTON = new Button(By.xpath("//button[@class='btn-popup-register']/span"));
    private static final Checkbox CURRENCY_RUB_CHECKBOX = new Checkbox(By.xpath("//div[@id='popup_register']//input[@name='currency' and @value='RUB']"));
    private static final Checkbox CURRENCY_USD_CHECKBOX = new Checkbox(By.xpath("//div[@id='popup_register']//input[@name='currency' and @value='USD']"));
    private static final Checkbox AGREE_CHECKBOX = new Checkbox(By.xpath("//div[@id='popup_register']//input[@name='agree' and @type='checkbox']"));

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
}
