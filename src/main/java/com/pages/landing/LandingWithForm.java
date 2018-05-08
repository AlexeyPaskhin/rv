package com.pages.landing;

import com.Elements.Button;
import com.pages.AbstractPage;
import com.pages.Helpers.Dictionaries.LandingWithFormType;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

/**
 * Class for choosing bonuses in Landing Pages 11
 */

public class LandingWithForm extends AbstractPage {
    private Button CHOOSE_CASHBACK = new Button(By.xpath("//a[@class='select-cashback']"));
    private Button CHOOSE_BONUS = new Button(By.xpath("//a[@class='select-bonus']"));

    @Step
    public FastRegister switchToRegistration() {
        return new FastRegister(new LandingWithFormType());
    }

    @Step
    public LandingWithForm clickCashBackLP11() {
        CHOOSE_CASHBACK.click();
        return this;
    }

    @Step
    public LandingWithForm clickBonusLP11() {
        CHOOSE_BONUS.click();
        return this;
    }
}
