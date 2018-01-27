package com.popups;

import com.Elements.Button;
import com.Elements.Frame;
import com.pages.AbstractPage;
import com.pages.HomePage;
import com.popups.cashBoxFrames.CashBoxDepositFrame;
import com.popups.cashBoxFrames.CashBoxWithdrawalFrame;
import com.popups.cashBoxFrames.SwitchToFrame;
import org.openqa.selenium.By;

public class CashBoxPopup extends AbstractPage implements SwitchToFrame {
    private final Button TAB_DEPOSIT = new Button(By.xpath("//a[@class='profile-switch__tab tab-deposit']"));
    private final Button TAB_WITHDRAWAL = new Button(By.xpath("//a[@class='profile-switch__tab tab-withdrawal"));
    private final Button TAB_PAYMENT_HISTORY = new Button(By.xpath("//a[@class='profile-switch__tab tab-history']"));
    private final Button CLOSE_CASHBOX_POPUP = new Button(By.xpath("//div[@id='popup_cashbox']//a[@class='popup-close']"));

    private Frame CASH_BOX_DEPOSIT_FRAME = new Frame(By.xpath("//div[@id='deposit-iframe-wrap']//iframe"));
    private Frame CASH_BOX_WITHDRAWAL_FRAME = new Frame(By.xpath("//div[@id='withdrawal-iframe-wrap']//iframe"));

    public CashBoxDepositFrame clickTabDeposit() {
        TAB_DEPOSIT.click();
        return new CashBoxDepositFrame();
    }

    public CashBoxWithdrawalFrame clickTabWithdrawal() {
        TAB_WITHDRAWAL.click();
        return new CashBoxWithdrawalFrame();
    }

    public CashBoxPopup clickTabPaymentHistory() {
        TAB_PAYMENT_HISTORY.click();
        return this;
    }

    public HomePage clickCloseCashboxPopup() {
        CLOSE_CASHBOX_POPUP.click();
        return new HomePage();
    }

    public CashBoxDepositFrame switchToCashBoxDepositFrame() {
        switсhToFrame(CASH_BOX_DEPOSIT_FRAME);
        wait(1000);
        return new CashBoxDepositFrame();
    }

    public CashBoxWithdrawalFrame switchToCashBoxWithdrawalFrame() {
        switсhToFrame(CASH_BOX_WITHDRAWAL_FRAME);
        wait(1000);
        return new CashBoxWithdrawalFrame();
    }
}
