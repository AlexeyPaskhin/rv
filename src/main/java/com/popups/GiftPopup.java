package com.popups;

import com.Elements.Button;
import com.Elements.Element;
import com.Elements.RadioButton;
import com.pages.AbstractPage;
import com.pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

/**
 * Class of pop-up Choose gift - after registration
 */

public class GiftPopup extends AbstractPage {
    private static final Button WITHDRAW_FROM_GIFT = new Button(By.xpath("//label[@for='gift_none']"));
    private static final Button SAVE_GIFT_BUTTON = new Button(By.xpath("//button[@class='btn-save-gift']"));

    private static final RadioButton ONE_HUNDRED_PERCENT_BONUS_GIFT = new RadioButton(By.xpath("//label[@for='gift_two_container']"));
    private static final RadioButton TEN_PERCENT_BONUS_GIFT = new RadioButton(By.xpath("//label[@for='gift_one_container']"));

    @Step
    public HomePage clickWithdrawFromGift() {
        WITHDRAW_FROM_GIFT.click();
        return new HomePage();
    }

    @Step
    public GiftPopup check100PercentGift() {
        ONE_HUNDRED_PERCENT_BONUS_GIFT.check();
        return this;
    }

    @Step
    public GiftPopup checkCashBackGift() {
        TEN_PERCENT_BONUS_GIFT.check();
        return this;
    }

    @Step
    public HomePage clickButtonSaveGift() {
        SAVE_GIFT_BUTTON.click();
        return new HomePage();
    }

    @Step
    public HomePage withdrawFromGift() {
        WITHDRAW_FROM_GIFT.click();
        return new HomePage();
    }
}
