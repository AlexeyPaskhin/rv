package com.popups;

import com.Elements.Button;
import com.pages.HomePage;
import org.openqa.selenium.By;

public class GiftPopup {
    private static final Button WITHDRAW_FROM_GIFT = new Button (By.xpath("//label[@for='gift_none']"));

    public HomePage withdrawFromGift(){
        WITHDRAW_FROM_GIFT.click();
        return new HomePage();
    }

}
