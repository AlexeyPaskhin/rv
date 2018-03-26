package com.popups.cashBoxFrames;

import com.Elements.Button;
import com.Elements.InputBox;
import com.Elements.Panel;
import com.pages.AbstractPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CashBoxWithdrawalFrame extends AbstractPage implements SwitchToFrame {

    private Button CARD_PAYMENT_BUTTON = new Button(By.xpath("//div[@data-widget-id='1']"));
    private Button QIWI_PAYMENT_BUTTON = new Button(By.xpath("//div[@data-widget-id='6']"));
    private Button YANDEX_PAYMENT_BUTTON = new Button(By.xpath("//div[@data-widget-id='3']"));
    List<WebElement> PAYMENT_METHODS = new Button(By.xpath("//div[@class='widget payout_widget ']")).getAllWebElements();

    private InputBox CARD_WITHDRAWAL_SUM_INPUT_FIELD = new InputBox(By.xpath("//input[@class='zf custom_amount']"));
    private InputBox PHONE_NUMBER_INPUT_FIELD = new InputBox(By.xpath("//input[@id='billing_phone']"));
    private Button GET_BUTTON = new Button(By.xpath("//button[@class='zf zf-submit']"));
    private Button INACTIVE_GET_BUTTON = new Button(By.xpath("//button[@class='zf zf-submit zf-disabled']"));
    private Button OKAY_BUTTON = new Button(By.xpath("//div[@class='kassa_terminal_message']//button[@class='pretty_button']"));
    private Panel SUCCESS_MESSAGE = new Panel(By.xpath("//div[@class='message_content_inner success']"));
    private Panel NOT_ENOUGH_MONEY_MESSAGE = new Panel(By.xpath("//div[@class='message_content_inner fail']"));

    public CashBoxWithdrawalFrame clickCardPaymentMethod() {
        CARD_PAYMENT_BUTTON.click();
        return this;
    }

    @Step
    public List<WebElement> checkPaymentsMethodInWithdrawalFrame() {
        List<WebElement> BASIC_PAYMENT_METHODS = Arrays
                .asList(CARD_PAYMENT_BUTTON.slaveElement(), QIWI_PAYMENT_BUTTON.slaveElement(), YANDEX_PAYMENT_BUTTON.slaveElement());
        List<WebElement> response = new ArrayList<>();
        for (int i = 0; i < BASIC_PAYMENT_METHODS.size(); i++) {
            if (PAYMENT_METHODS.contains(BASIC_PAYMENT_METHODS.get(i))) {
                response.add(BASIC_PAYMENT_METHODS.get(i));
            }
        }
        return response;
    }

    @Step
    public CashBoxWithdrawalFrame typeCardWithdrawalSum(String withdrawalSum) {
        CARD_WITHDRAWAL_SUM_INPUT_FIELD.fillIn(withdrawalSum);
        return this;
    }

    @Step
    public CashBoxWithdrawalFrame typePhoneNumberInCardDepositFrame(String phoneNumber) {
        PHONE_NUMBER_INPUT_FIELD.fillIn(phoneNumber);
        return this;
    }

    @Step
    public CashBoxWithdrawalFrame clickGetButton() {
        GET_BUTTON.click();
        return this;
    }

    public boolean getButtonIsActive() {
        return INACTIVE_GET_BUTTON.isEnabled();
    }

    @Step
    public CashBoxWithdrawalFrame clickOnOkayButton() {
        OKAY_BUTTON.waitForElementToBeClickable(8);
        OKAY_BUTTON.click();
        return this;
    }

    public boolean successMessageIsPresent() {
        SUCCESS_MESSAGE.waitForElementToBeVisible(2);
        return SUCCESS_MESSAGE.isPresent();
    }

    public boolean notEnoughMessageIsPresent() {
        NOT_ENOUGH_MONEY_MESSAGE.waitForElementToBeVisible(2);
        return NOT_ENOUGH_MONEY_MESSAGE.isPresent();
    }
}
