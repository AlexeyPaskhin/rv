package com.popups;

import com.Elements.Button;
import com.pages.AbstractPage;
import com.pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LotteryPopup extends AbstractPage {
    Button CLOSE_POPUP = new Button(By.xpath("//div[@id='popup_lottery-reminder']//a[@class='popup-close']"));

    @Step
    public HomePage closePopup(){
        CLOSE_POPUP.click();
        return new HomePage();
    }
}
