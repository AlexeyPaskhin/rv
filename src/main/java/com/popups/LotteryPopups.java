package com.popups;

import com.Elements.Button;
import com.Elements.Element;
import com.pages.AbstractPage;
import com.pages.HomePage;
import org.openqa.selenium.By;

/**
 * We have 2 lottery pop-ups
 * + Reminder pop-up - reminder about active lottery
 * + Result pop-up - remainder what lottery is finished and users can ckeck results
 */

public class LotteryPopups extends AbstractPage {
    Button CLOSE_LOTTERY_REMINDER_POPUP = new Button(By.xpath("//div[@id='popup_lottery-reminder']//a[@class='popup-close']"));
    Button CLOSE_LOTTERY_RESULT_POPUP = new Button(By.xpath("//div[@id='popup_lottery-results']//a[@class='popup-close']"));

    Element REMINDER_POP_UP_HEADER = new Element(By.xpath("//div[@id='popup_lottery-reminder']"));
    Element RESULT_POP_UP_HEADER = new Element(By.xpath("//div[@id='popup_lottery-results']"));

    public HomePage closeLotteryReminderPopup() {
        if (REMINDER_POP_UP_HEADER.isVisible()) {
            CLOSE_LOTTERY_REMINDER_POPUP.clickUntilDisappeared();
        }
        return new HomePage();
    }

    public HomePage closeResultLotteryPopUp() {
        if (REMINDER_POP_UP_HEADER.isVisible()) {
            CLOSE_LOTTERY_REMINDER_POPUP.clickUntilDisappeared();
        }
        return new HomePage();
    }

}
