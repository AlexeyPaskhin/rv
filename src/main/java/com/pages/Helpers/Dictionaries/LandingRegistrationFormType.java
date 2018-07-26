package com.pages.Helpers.Dictionaries;

import com.Elements.Button;
import com.Elements.Checkbox;
import com.Elements.InputBox;
import com.Elements.RadioButton;
import org.openqa.selenium.By;

/**
 * Class with locators for registration form with button register ( like landing 1 , 2 )
 */
public class LandingRegistrationFormType implements RegistrationFormType {

    private InputBox EMAIL_INPUT = new InputBox(By.xpath("//input[@id='register-form-login' or @id='register-landing-form-login']")); //for mobile and desktop
    private InputBox PASSWORD_INPUT = new InputBox(By.xpath("//input[@id='register-form-password' or @id='register-landing-form-password']"));//for mobile and desktop
    private RadioButton CURRENCY_RUB_RADIO = new RadioButton(By.xpath("//div[@id='popup_register-landing']//input[@name='currency' and @value='RUB']"));
    private RadioButton CURRENCY_USD_RADIO = new RadioButton(By.xpath("//div[@id='popup_register-landing']//input[@name='currency' and @value='USD']"));
    private Checkbox AGREE_CHECKBOX = new Checkbox(By.xpath("//form[@data-form-role='register']//label[@for='terms_confirm' or @class='fullwidth agree']"));//for mobile and desktop
    private Button REGISTER_BUTTON = new Button(By.xpath("//form[@data-form-role='register']/button[@class='btn-popup-register-landing' or @class='btn-fastreg-profile']"));//for mobile and desktop

    @Override
    public InputBox getEmailInput() {
        return this.EMAIL_INPUT;
    }

    @Override
    public InputBox getPasswordInput() {
        return this.PASSWORD_INPUT;
    }

    @Override
    public RadioButton getCurrencyRubRadio() {
        return this.CURRENCY_RUB_RADIO;
    }

    @Override
    public RadioButton getCurrencyUsdRadio() {
        return this.CURRENCY_USD_RADIO;
    }

    @Override
    public Checkbox getAgreeCheckbox() {
        return this.AGREE_CHECKBOX;
    }

    @Override
    public Button getRegisterButton() {
        return this.REGISTER_BUTTON;
    }
}
