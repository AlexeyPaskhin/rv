package com.popups;

import com.Elements.Button;
import com.Elements.Element;
import com.Elements.InputBox;
import com.pages.AbstractPage;
import com.pages.HeaderAutorizedUser;
import com.pages.HeaderNotAutorizedUser;
import com.pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.utils.DriverManager.getDriver;

/**
 * Log-In pop-up ('Vhod')
 */
public class LogInPopUp extends AbstractPage {

    private final InputBox EMAIL_INPUT_BOX_IN_POPUP = new InputBox(By.xpath("//input[@id='auth-form-login']"));
    private final InputBox PASS_INPUT_BOX_IN_POPUP = new InputBox(By.xpath("//input[@id='auth-form-password']"));
    private final Button LOGIN_BUTTON_IN_POPUP = new Button(By.xpath("//button[@class='btn-popup-enter']//span[(text()='Вход')]"));
    // Validation error messages
    public static final Element EMPTY_EMAIL_FIELD_ERROR = new Element(By.xpath("//span[contains(text(), 'Поле не должно быть пустым')]"));
    public static final Element INCORRECT_PASS_OR_EMAIL_ERROR = new Element(By.xpath("//span[contains(text(), 'Неправильные имя пользователя и/или пароль')]"));
    public static final Button CLOSE_BUTTON = new Button(By.xpath("//*[@id='popup_auth']/a"));

    private final Element RESET_PASSWORD_LINK = new Element(By.xpath("//div[@id='popup_auth']//a[@data-popup-open = 'restore-password']"));
    private final Element REGISTRATION_LINK = new Element(By.xpath("//*[@id='popup_auth']//a[2]"));

    public String fieldEmailShouldNotBeEmpty() {
        EMPTY_EMAIL_FIELD_ERROR.waitForElementToBePresent(4);
        return EMPTY_EMAIL_FIELD_ERROR.getText();
    }

    public String fieldPasswordShouldNotBeEmpty() {
        EMPTY_EMAIL_FIELD_ERROR.waitForElementToBePresent(4);
        return EMPTY_EMAIL_FIELD_ERROR.getText();
    }

    public String incorrectPassOrEmailError() {
        INCORRECT_PASS_OR_EMAIL_ERROR.waitForElementToBePresent(5);
        return INCORRECT_PASS_OR_EMAIL_ERROR.getText();
    }

    @Step
    public HomePage pressButtonClose() {
        CLOSE_BUTTON.waitForElementToBeClickable(5);
        CLOSE_BUTTON.click();
        return new HomePage();
    }

    @Step
    public LogInPopUp typeEmailInPopupField(String email) {
        EMAIL_INPUT_BOX_IN_POPUP.waitForElementToBePresent(3);
        EMAIL_INPUT_BOX_IN_POPUP.cleaIn();
        EMAIL_INPUT_BOX_IN_POPUP.fillIn(email);
        return this;
    }

    @Step
    public LogInPopUp typePassInPopupField(String pass) {
        PASS_INPUT_BOX_IN_POPUP.cleaIn();
        PASS_INPUT_BOX_IN_POPUP.fillIn(pass);
        return this;
    }

    @Step
    public HomePage pressLoginIn() {
        LOGIN_BUTTON_IN_POPUP.waitForElementToBePresent(4);
        LOGIN_BUTTON_IN_POPUP.click();
        return new HomePage();
    }

    @Step
    public ResetPasswordPopUp clickForgotPasswordLink() {
        RESET_PASSWORD_LINK.waitForElementToBePresent(4);
        RESET_PASSWORD_LINK.click();
        return new ResetPasswordPopUp();
    }

    @Step
    public FastRegisterPopup clickRegistrationLink(){
        REGISTRATION_LINK.waitForElementToBePresent(3);
        REGISTRATION_LINK.click();
        return new FastRegisterPopup();
    }
}
