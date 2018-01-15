package com.pages.landing;

import com.Elements.Button;
import com.pages.AbstractPage;

import com.pages.Helpers.Dictionaries.LandingWithChooseBonusType;
import org.openqa.selenium.By;

public class LandingChooseBonusWinthContinue extends AbstractPage{

    private Button CHOOSE_CASHBACK = new Button(By.xpath("//label[@class='gift-option option-one']"));
    private Button CHOOSE_BONUS = new Button(By.xpath("//label[@class='gift-option option-two']"));
    private Button WITHDRAW_FROM_GIFT = new Button(By.xpath("//label[@class='link-like']"));
    private Button CONTINUE_BUTTON = new Button(By.xpath("//button[@id='choose-gift-landing-12-submit']"));

    public FastRegister switchToRegistration(){
        return new FastRegister(new LandingWithChooseBonusType());
    }

    public LandingChooseBonusWinthContinue clickCashBack(){
        CHOOSE_CASHBACK.click();
        return this;
    }
    public LandingChooseBonusWinthContinue clickBonus(){
        CHOOSE_BONUS.click();
        return this;
    }
    public LandingChooseBonusWinthContinue clickWithDrawFromGift(){
        WITHDRAW_FROM_GIFT.click();
        return this;
    }

    public LandingChooseBonusWinthContinue clickContinue(){
        CONTINUE_BUTTON.click();
        return this;
    }
}
