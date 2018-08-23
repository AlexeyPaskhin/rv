package com.popups;

import com.Elements.Button;
import com.Elements.Frame;
import com.Elements.Panel;
import com.pages.AbstractPage;
import com.pages.HomePage;
import com.popups.cashBoxFrames.CashBoxDepositFrame;
import com.popups.cashBoxFrames.CashBoxWithdrawalFrame;
import com.popups.cashBoxFrames.SwitchToFrame;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CashBoxPopup extends AbstractPage implements SwitchToFrame {
    private final Button TAB_DEPOSIT = new Button(By.xpath("//a[@class='profile-switch__tab tab-deposit']"));
    private final Button TAB_WITHDRAWAL = new Button(By.xpath("//a[@class='profile-switch__tab tab-withdrawal']"));
    private final Button TAB_PAYMENT_HISTORY = new Button(By.xpath("//a[@class='profile-switch__tab tab-history']"));
    private final Button CLOSE_CASHBOX_POPUP = new Button(By.xpath("//*[@id=\"popup_cashbox-deposit\"]/a"));

    private final Frame CASH_BOX_DEPOSIT_FRAME = new Frame(By.xpath("//div[@id='deposit-iframe-wrap']//iframe"));
    private final Frame CASH_BOX_WITHDRAWAL_FRAME = new Frame(By.xpath("//div[@id='withdrawal-iframe-wrap']//iframe"));

    private final Button MAKE_DEPOSIT_HISTORY_TAB = new Button(By.xpath("//table[@class='payments-history']//a"));
    private final Button ACTIVE_TAB_DEPOSIT = new Button(By.xpath("//a[@class='profile-switch__tab tab-deposit active']"));
    private final Button CANCEL_WITHDRAWAL_BUTTON = new Button(By.xpath("//tr[@class='payments-history__row-withdrawal-new ']//a"));
    private final Panel CANCELED_WITHDRAWAL_STRING = new Panel(By.xpath("//tr[@class='payments-history__row-withdrawal-new ']//td[contains(text(),'Отменен')]"));

    @Step
    public CashBoxPopup clickTabDeposit() {
        TAB_DEPOSIT.click();
        return this;
    }

    @Step
    public CashBoxPopup clickTabWithdrawal() {
        TAB_WITHDRAWAL.waitForElementToBeClickable(5);
        TAB_WITHDRAWAL.click();
        return this;
    }

    @Step
    public CashBoxPopup clickTabPaymentHistory() {
        TAB_PAYMENT_HISTORY.waitForElementToBeClickable(5);
        TAB_PAYMENT_HISTORY.click();
        return this;
    }

    @Step
    public HomePage clickCloseCashboxPopup() {
        CLOSE_CASHBOX_POPUP.waitForElementToBeClickable(5);
        CLOSE_CASHBOX_POPUP.click();
        return new HomePage();
    }

    @Step
    public CashBoxDepositFrame switchToCashBoxDepositFrame() {
        CASH_BOX_DEPOSIT_FRAME.waitForFrameToBeAvailableAndSwitchToIt(10);
        wait(1000);
        return new CashBoxDepositFrame();
    }

    @Step
    public CashBoxWithdrawalFrame switchToCashBoxWithdrawalFrame() {
        CASH_BOX_WITHDRAWAL_FRAME.waitForFrameToBeAvailableAndSwitchToIt(10);
        wait(1000);
        return new CashBoxWithdrawalFrame();
    }

    @Step
    public CashBoxPopup clickOnMakeDepositFromHistoryTab() {
        MAKE_DEPOSIT_HISTORY_TAB.waitForElementToBeClickable(8);
        MAKE_DEPOSIT_HISTORY_TAB.click();
        return this;
    }

    public boolean depositTabIsActive() {
        return ACTIVE_TAB_DEPOSIT.isVisible();
    }

    @Step
    public CashBoxPopup clickOnCancelWithdrawalFromHistoryTab() {
        CANCEL_WITHDRAWAL_BUTTON.waitForElementToBeClickable(8);
        CANCEL_WITHDRAWAL_BUTTON.click();
        return this;
    }

    public boolean canceledWithdrawalStringPresent() {
        CANCELED_WITHDRAWAL_STRING.waitForElementToBeVisible(5);
        return CANCELED_WITHDRAWAL_STRING.isVisible();
    }
}
