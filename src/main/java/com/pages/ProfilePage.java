package com.pages;

import com.Elements.Button;
import com.Elements.Element;
import com.Elements.InputBox;
import com.popups.CashBoxPopup;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

/**
 * Lichnyj kabinet / Profile page - /users/profile
 */
public class ProfilePage extends AbstractPage {
    private final String PROFILE_PAGE_TITLE = "Ваш профиль в казино";

    public Button CHANGE_PASS_BUTTON = new Button(By.xpath("//a[text()='Изменить пароль']"));
    public Button CANCEL_CHANGING_PASS_BUTTON = new Button(By.xpath("//a[text()='Не менять пароль']"));
    public InputBox OLD_PASS_INPUT = new InputBox(By.xpath("//input[@name='old_password']"));
    public InputBox NEW_PASS_INPUT = new InputBox(By.xpath("//input[@name='new_password']"));
    public InputBox NEW_PASS_REPEAT_INPUT = new InputBox(By.xpath("//input[@name='new_password_repeat']"));
    public Button CONFIRM_EMAIL_BUTTON = new Button(By.xpath("//a[text()='Подтвердить e-mail']"));
    public Element EMAIL_SENT_INSCRIPTION = new Element(By.xpath("//a[text()='Ссылка подтверждения отправлена на почту']"));
    public Button RECHARGE_BUTTON = new Button(By.xpath("//form[@action='/users/profile']//span[text()='Пополнить счет']/.."));
    public InputBox FULL_NAME_INPUT = new InputBox(By.xpath("//form[@action='/users/profile']//input[@name='full_name']"));
    public InputBox PHONE_INPUT = new InputBox(By.xpath("//form[@data-form-role='profile']//input[@name='phone']"));
    public Button RECEIVE_SMS_CODE_BUTTON = new Button(By.xpath("//input[@id='confirm-phone-btn']"));
    public Button CONFIRM_SMS_CODE_BUTTON = new Button(By.xpath("//input[@id='confirm-phone-code-bnt']"));
    public Button SAVE_BUTTON = new Button(By.xpath("//form[@data-form-role='profile']//span[text()='Сохранить']/.."));
    public Button VIP_CLUB_DETAILS_BUTTON = new Button(By.xpath("//a[text()='Подробнее о VIP-клубе']"));
    public Button CLOSE_POPUP_SUCCESS_CHANGES_BUTTON = new Button(By.xpath("//div[@id='popup_alert']/a[@class='popup-close']"));
    public Element WRONG_PASS_VALIDATION_MESSAGE = new Element(By.xpath("//span[text()='Неправильный пароль']"));
    public Element NOT_EQUAL_PASS_VALIDATION_MESSAGE = new Element(By.xpath("//span[text()='Значения полей не совпадают']"));
    public Element INVALID_PHONE_VALIDATION_MESSAGE = new Element(By.xpath("//span[text()='Введите корректный номер телефона']"));

    public ProfilePage() {
        CONFIRM_EMAIL_BUTTON.waitForElementToBeClickable(5);
    }

    public boolean isProfilePageOpened() {
        return this.getTitle().equals(PROFILE_PAGE_TITLE);
    }

    @Step
    public ProfilePage clickChangePass() {
        CHANGE_PASS_BUTTON.waitForElementToBeClickable(5);
        CHANGE_PASS_BUTTON.click();
        return this;
    }

    @Step
    public ProfilePage clickCancelChangePass() {
        CANCEL_CHANGING_PASS_BUTTON.click();
        return this;
    }

    @Step
    public ProfilePage setToOldPassField(String pass) {
        OLD_PASS_INPUT.sendKeys(pass);
        return this;
    }

    @Step
    public ProfilePage setToNewPassField(String pass) {
        NEW_PASS_INPUT.sendKeys(pass);
        return this;
    }

    @Step
    public ProfilePage setToConfirmPassField(String pass) {
        NEW_PASS_REPEAT_INPUT.sendKeys(pass);
        return this;
    }

    @Step
    public ProfilePage successfulSaveChanges() {
        SAVE_BUTTON.click();
        CLOSE_POPUP_SUCCESS_CHANGES_BUTTON.waitForElementToBeVisible(5);
        return this;
    }

    @Step
    public ProfilePage failedSaveChanges() {
        SAVE_BUTTON.click();
        SAVE_BUTTON.waitForElementToBeVisible(5);
        return this;
    }

    @Step
    public ProfilePage closeConfirmPopUp() {
        CLOSE_POPUP_SUCCESS_CHANGES_BUTTON.click();
        return this;
    }

    @Step
    public ProfilePage successfulChangePass(String oldPass, String newPass) {
        clickChangePass()
                .setToOldPassField(oldPass)
                .setToNewPassField(newPass)
                .setToConfirmPassField(newPass)
                .successfulSaveChanges();
        return this;
    }

    @Step
    public ProfilePage failedChangePass(String oldPass, String newPass) {
        clickChangePass()
                .setToOldPassField(oldPass)
                .setToNewPassField(newPass)
                .setToConfirmPassField(newPass)
                .failedSaveChanges();
        return this;
    }

    public ProfilePage clickConfirmEmail() {
        CONFIRM_EMAIL_BUTTON.waitForElementToBeClickable(5);
        CONFIRM_EMAIL_BUTTON.click();
        return this;
    }

    public CashBoxPopup clickRechargeButton() {
        RECHARGE_BUTTON.click();
        return new CashBoxPopup();
    }

    public ProfilePage setToPhoneField(String phone) {
        PHONE_INPUT.cleaIn();
        PHONE_INPUT.sendKeys(phone);
        return this;
    }

    public ProfilePage setToNameField(String phone) {
        FULL_NAME_INPUT.cleaIn();
        FULL_NAME_INPUT.sendKeys(phone);
        return this;
    }

    public ProfilePage clickReceiveCode() {
        RECEIVE_SMS_CODE_BUTTON.click();
        return this;
    }

    public VipPage clickVipClubDetailsLink() {
        VIP_CLUB_DETAILS_BUTTON.click();
        return new VipPage();
    }
}
