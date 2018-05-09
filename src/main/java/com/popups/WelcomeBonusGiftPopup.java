package com.popups;

import com.Elements.Button;
import com.Elements.Element;
import com.Elements.RadioButton;
import com.pages.AbstractPage;
import com.pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

/**
 * Class of pop-up Welcome Bonus - after registration
 */

public class WelcomeBonusGiftPopup extends AbstractPage {
    private static final Button WITHDRAW_FROM_GIFT = new Button(By.xpath("//button[@class='welcome-btn-reject']"));
    private static final Button PLAY_WITH_BONUS = new Button(By.xpath("//button[@class='btn-save-gift']"));

    @Step
    public HomePage clickWithdrawFromGift() {
        WITHDRAW_FROM_GIFT.click();
        return new HomePage();
    }

    @Step
    public HomePage pressPlayWithBonus() {
        PLAY_WITH_BONUS.click();
        return new HomePage();
    }
}
