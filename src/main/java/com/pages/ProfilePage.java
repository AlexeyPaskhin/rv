package com.pages;

import com.Elements.Button;
import com.Elements.Element;
import com.Elements.InputBox;
import com.popups.CashBoxPopup;
import com.popups.ChangesSavedConfirmPopUp;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

/**
 * Lichnyj kabinet / Profile page - /users/profile
 */
@Getter
public class ProfilePage extends AbstractPage {
    private final String PROFILE_PAGE_TITLE = "Ваш профиль в казино";

    private Button CHANGE_PASS_BUTTON = new Button(By.xpath("//a[text()='Изменить пароль']"));
    private Button CANCEL_CHANGING_PASS_BUTTON = new Button(By.xpath("//a[text()='Не менять пароль']"));
    private InputBox OLD_PASS_INPUT = new InputBox(By.xpath("//input[@name='old_password']"));
    private InputBox NEW_PASS_INPUT = new InputBox(By.xpath("//input[@name='new_password']"));
    private InputBox NEW_PASS_REPEAT_INPUT = new InputBox(By.xpath("//input[@name='new_password_repeat']"));
    private Button CONFIRM_EMAIL_BUTTON = new Button(By.xpath("//a[text()='Подтвердить e-mail']"));
    private Element EMAIL_SENT_INSCRIPTION = new Element(By.xpath("//a[text()='Ссылка подтверждения отправлена на почту']"));
    private Button RECHARGE_BUTTON = new Button(By.xpath("//form[@action='/users/profile']//span[text()='Пополнить счет']/.."));
    private InputBox FULL_NAME_INPUT = new InputBox(By.xpath("//form[@action='/users/profile']//input[@name='full_name']"));
    private InputBox PHONE_INPUT = new InputBox(By.xpath("//form[@data-form-role='profile']//input[@name='phone']"));
    private Button RECEIVE_SMS_CODE_BUTTON = new Button(By.xpath("//input[@id='confirm-phone-btn']"));
    private InputBox SMS_CODE_INPUT = new InputBox(By.xpath("//input[@id='confirm-phone-code']"));
    private Button CONFIRM_SMS_CODE_BUTTON = new Button(By.xpath("//input[@id='confirm-phone-code-bnt']"));
    private Button SAVE_BUTTON = new Button(By.xpath("//form[@data-form-role='profile']//span[text()='Сохранить']/.."));
    private Button VIP_CLUB_DETAILS_BUTTON = new Button(By.xpath("//a[text()='Подробнее о VIP-клубе']"));
    private Element WRONG_PASS_VALIDATION_MESSAGE = new Element(By.xpath("//span[text()='Неправильный пароль']"));
    private Element NOT_EQUAL_PASS_VALIDATION_MESSAGE = new Element(By.xpath("//span[text()='Значения полей не совпадают']"));
    private Element INVALID_PHONE_VALIDATION_MESSAGE = new Element(By.xpath("//span[text()='Введите корректный номер телефона']"));

    private Element BONUSES_TAB = new Element(By.xpath("//div[@class='profile-switch']//a[@href='/users/bonuses']"));

    public ProfilePage() {
        FULL_NAME_INPUT.waitForElementToBeClickable(5);
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
        OLD_PASS_INPUT.waitForElementToBeClickable(5);
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
    public ChangesSavedConfirmPopUp successfulSaveChanges() {
        SAVE_BUTTON.click();
        return new ChangesSavedConfirmPopUp();
    }

    @Step
    public ProfilePage failedSaveChanges() {
        SAVE_BUTTON.click();
        waitForPageToLoad();
        return this;
    }

    @Step
    public ChangesSavedConfirmPopUp successfulChangePass(String oldPass, String newPass) {
        return clickChangePass()
                .setToOldPassField(oldPass)
                .setToNewPassField(newPass)
                .setToConfirmPassField(newPass)
                .successfulSaveChanges();
    }

    @Step
    public ProfilePage failedChangePass(String oldPass, String newPass) {
        return clickChangePass()
                .setToOldPassField(oldPass)
                .setToNewPassField(newPass)
                .setToConfirmPassField(newPass)
                .failedSaveChanges();
    }

    @Step
    public ProfilePage clickConfirmEmail() {
        CONFIRM_EMAIL_BUTTON.waitForElementToBeClickable(5);
        CONFIRM_EMAIL_BUTTON.click();
        return this;
    }

    @Step
    public CashBoxPopup clickRechargeButton() {
        RECHARGE_BUTTON.click();
        return new CashBoxPopup();
    }

    @Step
    public ProfilePage setToPhoneField(String phone) {
        PHONE_INPUT.cleaIn();
        PHONE_INPUT.sendKeys(phone);
        return this;
    }

    @Step
    public ProfilePage setToSmsCodeField(String code) {
        SMS_CODE_INPUT.cleaIn();
        SMS_CODE_INPUT.sendKeys(code);
        return this;
    }

    @Step
    public ProfilePage setToNameField(String phone) {
        FULL_NAME_INPUT.cleaIn();
        FULL_NAME_INPUT.sendKeys(phone);
        return this;
    }

    @Step
    public ProfilePage clickReceiveSmsCode() {
        RECEIVE_SMS_CODE_BUTTON.click();
        return this;
    }

    @Step
    public ProfilePage clickConfirmSmsCode() {
        CONFIRM_SMS_CODE_BUTTON.click();
        return this;
    }

    @Step
    public VipPage clickVipClubDetailsLink() {
        VIP_CLUB_DETAILS_BUTTON.click();
        return new VipPage();
    }

    @Step
    public BonusesPage clickBonuses() {
        BONUSES_TAB.click();
        return new BonusesPage();
    }
}
