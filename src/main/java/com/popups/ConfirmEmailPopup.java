package com.popups;

import com.Elements.Button;
import com.Elements.Checkbox;
import com.Elements.InputBox;
import com.Elements.RadioButton;
import com.pages.AbstractPage;
import com.pages.HomePage;
import org.openqa.selenium.By;

public class ConfirmEmailPopup extends AbstractPage {
    private final InputBox EMAIL_INPUTBOX = new InputBox(By.id("complete-form-login"));
    private final RadioButton CURRENCY_RUB = new RadioButton(By.xpath("//div[@id='popup_complete-registration']//input[@name='currency' and @value='RUB']"));
    private final Checkbox AGREE_CHECKBOX = new Checkbox(By.xpath("//div[@id='popup_complete-registration']//input[@name='agree' and @type='checkbox']"));
    private final Button COMPLETE_REGISTER_BUTTON = new Button(By.xpath("//button[@class='btn-popup-complete-registration']"));

    public ConfirmEmailPopup agreeWithRules(){
        AGREE_CHECKBOX.waitForElementToBeVisible(3);
        AGREE_CHECKBOX.click();
        return this;
    }

    public GiftPopup clickCompleteRegister(){
        COMPLETE_REGISTER_BUTTON.click();
        return new GiftPopup();
    }




}
