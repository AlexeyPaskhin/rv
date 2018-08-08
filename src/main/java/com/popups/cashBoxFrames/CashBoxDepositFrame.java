package com.popups.cashBoxFrames;

import com.Elements.Button;
import com.Elements.InputBox;
import com.Elements.RadioButton;
import com.pages.AbstractPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CashBoxDepositFrame extends AbstractPage implements SwitchToFrame {

    private Button CARD_PAYMENT_BUTTON = new Button(By.xpath("//div[@data-widget-id='1']"));
    private Button QIWI_PAYMENT_BUTTON = new Button(By.xpath("//div[@data-widget-id='6']"));
    private Button YANDEX_PAYMENT_BUTTON = new Button(By.xpath("//div[@data-widget-id='3']"));
    private Button WEBMONEY_PAYMENT_BUTTON = new Button(By.xpath("//div[@data-widget-id='2']"));
    private Button MONETARU_PAYMENT_BUTTON = new Button(By.xpath("//div[@data-widget-id='5']"));
    private Button ALPHA_CLICK_PAYMENT_BUTTON = new Button(By.xpath("//div[@data-widget-id='8']"));
    private Button PROMSVIAZ_BANK_PAYMENT_BUTTON = new Button(By.xpath("//div[@data-widget-id='33']"));
    List<WebElement> PAYMENT_METHODS = new Button(By.xpath("//div[@class='widget deposit_widget']")).getAllWebElements();

    private InputBox CARD_NUMBER_INPUT_FIELD = new InputBox(By.xpath("//input[@name='card_number']"));
    private InputBox CARD_HOLDER_INPUT_FIELD = new InputBox(By.xpath("//input[@id='card_holder']"));
    private InputBox CARD_CVV_INPUT_FIELD = new InputBox(By.xpath("//input[@id='cvv']"));
    private InputBox CARD_CVV_STORED_INPUT_FIELD = new InputBox(By.xpath("//input[@id='cvv_stored']"));
    private InputBox CARD_DEPOSIT_SUM_INPUT_FIELD = new InputBox(By.xpath("//input[@id='amount_input']"));
    private RadioButton CARD_DEPOSIT_500_RUB = new RadioButton(By.xpath("//label[@id='label_amount_500']"));
    private RadioButton CARD_DEPOSIT_1000_RUB = new RadioButton(By.xpath("//label[@id='label_amount_1000']"));
    private RadioButton CARD_DEPOSIT_3000_RUB = new RadioButton(By.xpath("//label[@id='label_amount_3000']"));
    private RadioButton CARD_DEPOSIT_10000_RUB = new RadioButton(By.xpath("//label[@id='label_amount_10000']"));
    private RadioButton CARD_DEPOSIT_30000_RUB = new RadioButton(By.xpath("//label[@id='label_amount_30000']"));
    private RadioButton INPUT_SUM_RADIOBUTTON = new RadioButton(By.xpath("//label[@id='label_custom_amount']"));
    private Button CONFIRM_BUTTON = new Button(By.xpath("//button[@id='submit_button']"));
    private Button PROCEED_BUTTON = new Button(By.xpath("//span[text()='Продолжить']/.."));   //accessible only on prod
    private Button OKAY_BUTTON = new Button(By.xpath("//div[@class='payment_message success']//button[@class='pretty_button']"));
    private Button QUICK_PAYMENT = new Button(By.xpath("//li[@class='zf-option zf-selected']"));

    @Step
    public List<WebElement> checkPaymentsMethodInDepositFrame() {
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

    public boolean checkDepositCardIsSaved() {
        QUICK_PAYMENT.waitForElementToBePresent(5);
        return QUICK_PAYMENT.isPresent();
    }

    @Step
    public CashBoxDepositFrame clickCardPaymentMethod() {
        CARD_PAYMENT_BUTTON.waitForElementToBeClickable(5);
        CARD_PAYMENT_BUTTON.click();
        return this;
    }

    @Step
    public CashBoxDepositFrame clickQiwiPaymentMethod() {
        QIWI_PAYMENT_BUTTON.waitForElementToBeClickable(5);
        QIWI_PAYMENT_BUTTON.click();
        return this;
    }

    @Step
    public CashBoxDepositFrame clickYandexPaymentMethod() {
        YANDEX_PAYMENT_BUTTON.waitForElementToBeClickable(5);
        YANDEX_PAYMENT_BUTTON.click();
        return this;
    }

    @Step
    public CashBoxDepositFrame clickWebmoneyPaymentMethod() {
        WEBMONEY_PAYMENT_BUTTON.waitForElementToBeClickable(5);
        WEBMONEY_PAYMENT_BUTTON.click();
        return this;
    }

    @Step
    public CashBoxDepositFrame clickMonetaruPaymentMethod() {
        MONETARU_PAYMENT_BUTTON.waitForElementToBeClickable(5);
        MONETARU_PAYMENT_BUTTON.click();
        return this;
    }

    @Step
    public CashBoxDepositFrame clickAlphaClickPaymentMethod() {
        ALPHA_CLICK_PAYMENT_BUTTON.waitForElementToBeClickable(5);
        ALPHA_CLICK_PAYMENT_BUTTON.click();
        return this;
    }

    @Step
    public CashBoxDepositFrame clickPromsviazBankPaymentMethod() {
        PROMSVIAZ_BANK_PAYMENT_BUTTON.waitForElementToBeClickable(5);
        PROMSVIAZ_BANK_PAYMENT_BUTTON.click();
        return this;
    }

    @Step
    public CashBoxDepositFrame typeCardNumber(String cardNumber) {
        for (int i = 0; i < cardNumber.length(); i++) {
            char symbol = cardNumber.charAt(i);
            CARD_NUMBER_INPUT_FIELD.fillIn(String.valueOf(symbol));
        }
        return this;
    }

    @Step
    public CashBoxDepositFrame typeCardHolder(String cardHolder) {
        CARD_HOLDER_INPUT_FIELD.fillIn(cardHolder);
        return this;
    }

    @Step
    public CashBoxDepositFrame typeCardCVV(String cvv) {
        CARD_CVV_INPUT_FIELD.fillIn(cvv);
        return this;
    }

    @Step
    public CashBoxDepositFrame typeCardStoredCVV(String cvv) {
        CARD_CVV_STORED_INPUT_FIELD.fillIn(cvv);
        return this;
    }

    @Step
    public CashBoxDepositFrame typeCardDepositSum(String depositSum) {
        CARD_DEPOSIT_SUM_INPUT_FIELD.fillIn(depositSum);
        return this;
    }

    @Step
    public CashBoxDepositFrame clickOn500RubButton() {
        CARD_DEPOSIT_500_RUB.click();
        return this;
    }

    @Step
    public CashBoxDepositFrame clickOn1000RubButton() {
        CARD_DEPOSIT_1000_RUB.click();
        return this;
    }

    @Step
    public CashBoxDepositFrame clickOn3000RubButton() {
        CARD_DEPOSIT_3000_RUB.click();
        return this;
    }

    @Step
    public CashBoxDepositFrame clickOn10000RubButton() {
        CARD_DEPOSIT_10000_RUB.click();
        return this;
    }

    @Step
    public CashBoxDepositFrame clickOn30000RubButton() {
        CARD_DEPOSIT_30000_RUB.click();
        return this;
    }

    @Step
    public CashBoxDepositFrame clickOnInputButton() {
        INPUT_SUM_RADIOBUTTON.click();
        return this;
    }

    @Step
    public CashBoxDepositFrame cleanDepositInputField() {
        CARD_DEPOSIT_SUM_INPUT_FIELD.cleaIn();
        return this;
    }

    @Step
    public CashBoxDepositFrame clickOnConfirmButton() {
        CONFIRM_BUTTON.click();
        return this;
    }

    @Step
    public CashBoxDepositFrame clickProceedButton() {
        PROCEED_BUTTON.waitForElementToBeClickable(10);
        PROCEED_BUTTON.click();
        return this;
    }

    @Step
    public CashBoxDepositFrame clickOnOkayButton() {
        OKAY_BUTTON.waitForElementToBeClickable(8);
        OKAY_BUTTON.click();
        return this;
    }

    public boolean checkAvailableConfirmButton() {
        return CONFIRM_BUTTON.isEnabled();
    }
}
