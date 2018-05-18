package com.pages.landing;

import com.Elements.Button;
import com.pages.AbstractPage;
import com.pages.Helpers.Dictionaries.LandingWithFormType;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Class for mapping Landing Pages 3, 6, 8, 9, 10, 11, 13
 */

public class LandingWithForm extends AbstractPage {
    private Button CHOOSE_CASHBACK = new Button(By.xpath("//a[@class='select-cashback']"));
    private Button CHOOSE_BONUS = new Button(By.xpath("//a[@class='select-bonus']"));

    @Step
    public FastRegisterLP switchToRegistration() {
        return new FastRegisterLP(new LandingWithFormType());
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
