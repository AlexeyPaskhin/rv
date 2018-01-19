package com.popups.cashBoxFrames;

import com.Elements.Button;
import com.Elements.Frame;
import com.pages.AbstractPage;
import org.openqa.selenium.By;

/**
 * Created by ai on 2018-01-17.
 */
public class CashBoxWithdrawalFrame extends AbstractPage implements SwithToFrame{

    private Button CARD_PAYMENT_BUTTON = new Button(By.xpath("//div[@data-widget-id='1']"));

    public CashBoxWithdrawalFrame clickCardPaymentMethod() {
        CARD_PAYMENT_BUTTON.click();
        return this;
    }
}
