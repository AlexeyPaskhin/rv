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
    private Button CHOOSE_CASHBACK = new Button(By.xpath("//*[@class='choose-gift left']"));
    private Button CHOOSE_BONUS = new Button(By.xpath("//*[@class='choose-gift right']"));
    private Button GIVE_UP_A_GIFT = new Button(By.xpath("//*[text()='Отказаться от подарка' or text()='Играть без подарка']"));

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
    public LandingWithBonus clickGiveUpAGift() {
        GIVE_UP_A_GIFT.waitForElementToBeClickable(10);
        GIVE_UP_A_GIFT.click();
        return this;
    }
}
