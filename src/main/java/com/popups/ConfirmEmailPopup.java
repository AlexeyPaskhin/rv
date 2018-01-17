package com.popups;

import com.Elements.Button;
import com.Elements.Checkbox;
import com.Elements.InputBox;
import com.Elements.RadioButton;
import com.pages.AbstractPage;
import com.pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ConfirmEmailPopup extends AbstractPage {
    private final InputBox EMAIL_INPUTBOX = new InputBox(By.xpath("//input[contains(@id,'complete') and @name='email']"));
    private final RadioButton CURRENCY_RUB = new RadioButton(By.xpath("//div[@id='popup_complete-registration']//input[@name='currency' and @value='RUB']"));
    private final Checkbox AGREE_CHECKBOX = new Checkbox(By.xpath("//div[@id='popup_complete-registration']//input[@name='agree' and @type='checkbox']"));
    private final Button COMPLETE_REGISTER_BUTTON = new Button(By.xpath("//*[text()='Завершить регистрацию']"));

    @Step
    public ConfirmEmailPopup agreeWithRules(){
        AGREE_CHECKBOX.waitForElementToBeVisible(3);
        AGREE_CHECKBOX.click();
        return this;
    }
    @Step
    public ConfirmEmailPopup setEmail(String email){
        EMAIL_INPUTBOX.fillIn(email);
        return this;
    }
    @Step
    public HomePage clickCompleteRegister(){
        COMPLETE_REGISTER_BUTTON.click();
        return new HomePage();
    }
}
