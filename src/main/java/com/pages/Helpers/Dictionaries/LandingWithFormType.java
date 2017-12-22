package com.pages.Helpers.Dictionaries;

import com.Elements.Button;
import com.Elements.Checkbox;
import com.Elements.InputBox;
import com.Elements.RadioButton;
import org.openqa.selenium.By;

public class LandingWithFormType implements RegistrationFormType {

    public InputBox EMAIL_INPUT = new InputBox(By.xpath("//div[@class='landing-form']//input[@name='email']"));
    public InputBox PASSWORD_INPUT = new InputBox(By.xpath("//div[@class='landing-form']//input[@name='password']"));
    public RadioButton CURRENCY_RUB_RADIO = new RadioButton(By.xpath("//div[@class='landing-form']//input[@name='currency' and @value='RUB']"));
    public RadioButton CURRENCY_USD_RADIO= new RadioButton(By.xpath("//div[@class='landing-form']//input[@name='currency' and @value='USD']"));
    public Checkbox AGREE_CHECKBOX = new Checkbox(By.xpath("//div[@class='landing-form']//input[@name='agree' and @type='checkbox']"));
    public Button REGISTER_BUTTON = new Button(By.xpath("//div[@class='landing-form']//button"));

    @Override
    public InputBox getEmailInput() {
        return  this.EMAIL_INPUT;
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
