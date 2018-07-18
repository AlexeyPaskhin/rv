package com.pages.Helpers.Dictionaries;

import com.Elements.Button;
import com.Elements.Checkbox;
import com.Elements.InputBox;
import com.Elements.RadioButton;
import org.openqa.selenium.By;

/**
 * Class with locators for registration form with only register form on page like landing 3 )
 */
public class LandingWithFormType implements RegistrationFormType {

    private InputBox EMAIL_INPUT = new InputBox(By.xpath("//div[@class='landing-form']//input[@name='email']"));
    private InputBox PASSWORD_INPUT = new InputBox(By.xpath("//div[@class='landing-form']//input[@name='password']"));
    private RadioButton CURRENCY_RUB_RADIO = new RadioButton(By.xpath("//div[@class='landing-form']//input[@name='currency' and @value='RUB']"));
    private RadioButton CURRENCY_USD_RADIO = new RadioButton(By.xpath("//div[@class='landing-form']//input[@name='currency' and @value='USD']"));
    private Checkbox AGREE_CHECKBOX = new Checkbox(By.xpath("//form[@data-form-role='register']//label[@class='fullwidth agree']"));
    private Button REGISTER_BUTTON = new Button(By.xpath("//div[@class='landing-form']//button"));

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
