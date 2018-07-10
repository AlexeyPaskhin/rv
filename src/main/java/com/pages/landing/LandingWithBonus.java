package com.pages.landing;

import com.Elements.Button;
import com.pages.AbstractPage;
import com.pages.Helpers.Dictionaries.LandingWithChooseBonusType;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
/**
 * Class for choosing bonuses in Landing Pages 7 and 12
 */

public class LandingWithBonus extends AbstractPage {
    private Button CHOOSE_CASHBACK = new Button(By.xpath("//label[@class='choose-gift left']"));
    private Button CHOOSE_BONUS = new Button(By.xpath("//label[@class='choose-gift right']"));
    private Button WITHDRAW_FROM_GIFT = new Button(By.xpath("//label[@class='link-like']"));

    public FastRegisterLP switchToRegistration() {
        return new FastRegisterLP(new LandingWithChooseBonusType());
    }

    @Step
    public LandingWithBonus clickCashBack() {
        CHOOSE_CASHBACK.click();
        return this;
    }

    @Step
    public LandingWithBonus clickBonus() {
        CHOOSE_BONUS.click();
        return this;
    }

    @Step
    public LandingWithBonus clickWithDrawFromGift() {
        WITHDRAW_FROM_GIFT.waitForElementToBeClickable(10);
        WITHDRAW_FROM_GIFT.click();
        return this;
    }
}
