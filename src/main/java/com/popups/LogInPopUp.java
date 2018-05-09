package com.popups;

import com.Elements.Button;
import com.Elements.Element;
import com.Elements.InputBox;
import com.pages.AbstractPage;
import com.pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

/**
 * Log-In pop-up ('Vhod')
 * Log-In page ( /users/auth )
 */
public class LogInPopUp extends AbstractPage {

    private final InputBox EMAIL_INPUT_BOX = new InputBox(By.id("auth-form-login"));
    private final InputBox PASS_INPUT_BOX = new InputBox(By.id("auth-form-password"));
    private final Button LOGIN_BUTTON_IN_POPUP = new Button(By.xpath("//button[@class='btn-popup-enter']//span[(text()='Вход')]"));
    private final Button LOGIN_BUTTON_IN_PAGE = new Button(By.xpath("//*[@class='inlineForm']//button[@class='btn-popup-enter']//span[(text()='Войти')]"));
    // Validation error messages
    public static final Element EMPTY_EMAIL_FIELD_ERROR = new Element(By.xpath("//span[contains(text(), 'Поле не должно быть пустым')]"));
    public static final Element INCORRECT_PASS_OR_EMAIL_ERROR = new Element(By.xpath("//span[contains(text(), 'Неправильные имя пользователя и/или пароль')]"));
    public static final Button CLOSE_BUTTON = new Button(By.xpath("//*[@id='popup_auth']/a"));

    private final Element RESET_PASSWORD_LINK_POP_UP = new Element(By.xpath("//div[@id='popup_auth']//a[@data-popup-open = 'restore-password']"));
    private final Element RESET_PASSWORD_LINK_PAGE = new Element(By.xpath("//*[@class='inlineForm']//div[@class='related-popups']//a[@data-popup-open = 'restore-password']"));
    private final Element REGISTRATION_LINK_POP_UP = new Element(By.xpath("//*[@id='popup_auth']//a[2]"));
    private final Element REGISTRATION_LINK_PAGE = new Element(By.xpath("//*[@class='inlineForm']//div[@class='related-popups']//a[2]"));

    private static final Element AUTH_HEADER_POP_UP = new Element(By.xpath("//*[@id='popup_auth']//div[@class='popup-header']"));

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

    @Step // only for pop-up
    public HomePage pressButtonClose() {
        CLOSE_BUTTON.waitForElementToBeClickable(5);
        CLOSE_BUTTON.click();
        return new HomePage();
    }

    @Step // the same for page or pop-up
    public LogInPopUp typeEmailInPopupField(String email) {
        EMAIL_INPUT_BOX.waitForElementToBePresent(3);
        EMAIL_INPUT_BOX.cleaIn();
        EMAIL_INPUT_BOX.fillIn(email);
        return this;
    }

    @Step // the same for page or pop-up
    public LogInPopUp typePassInPopupField(String pass) {
        PASS_INPUT_BOX.cleaIn();
        PASS_INPUT_BOX.fillIn(pass);
        return this;
    }

    @Step // page or pop-up
    public HomePage pressLoginIn() {
        if (LOGIN_BUTTON_IN_POPUP.isPresent()) {
            LOGIN_BUTTON_IN_POPUP.click();
        } else if (LOGIN_BUTTON_IN_PAGE.isPresent()){
            LOGIN_BUTTON_IN_PAGE.click();
        } else {
            LOGIN_BUTTON_IN_POPUP.waitForElementToBePresent(4);
            LOGIN_BUTTON_IN_POPUP.click();
        }
        return new HomePage();
    }

    @Step // page or pop-up
    public ResetPasswordPopUp clickForgotPasswordLink() {
        if (RESET_PASSWORD_LINK_POP_UP.isPresent()) {
            RESET_PASSWORD_LINK_POP_UP.click();
        } else if (RESET_PASSWORD_LINK_PAGE.isPresent()) {
            RESET_PASSWORD_LINK_PAGE.click();
        } else {
            RESET_PASSWORD_LINK_POP_UP.waitForElementToBePresent(4);
            RESET_PASSWORD_LINK_POP_UP.click();
        }
        return new ResetPasswordPopUp();
    }

    @Step // page or pop-up
    public FastRegisterPopup clickRegistrationLink(){
        if (REGISTRATION_LINK_POP_UP.isPresent()) {
            REGISTRATION_LINK_POP_UP.click();
        } else if (REGISTRATION_LINK_PAGE.isPresent()) {
            REGISTRATION_LINK_PAGE.click();
        } else {
            REGISTRATION_LINK_POP_UP.waitForElementToBePresent(3);
            REGISTRATION_LINK_POP_UP.click();
        }
        return new FastRegisterPopup();
    }

    // pop-up only
    public boolean isLoginPopUpOpened() {
            AUTH_HEADER_POP_UP.waitForElementToBeVisible(4);
            AUTH_HEADER_POP_UP.click();
        return AUTH_HEADER_POP_UP.isVisible();
    }
}
