package com.popups;

import com.Elements.Button;
import com.Elements.Element;
import com.Elements.InputBox;
import com.pages.AbstractPage;
import com.pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

/**
 * Pop-up Forgot Password
 * + opened from header for un-authorized user
 * + opened from pop-up (page) "Vhod" (Log-in)
 */
public class ResetPasswordPopUp extends AbstractPage {
    private final Button RESET_BUTTON = new Button(By.xpath("//button[@class='btn-popup-restore']"));
    private final Button RESET_BUTTON_WITHOUT_JS = new Button(By.xpath("//button[@class='btn btn-popup-enter']"));
    private final InputBox ENTER_EMAIL = new InputBox(By.xpath("//input[@id='restore-form-login']"));
    private final Button CLOSE_BUTTON = new Button(By.xpath("//*[@id=\"popup_restore-password\"]/a"));

    // Validation error messages
    public static final Element INVALID_EMAIL_FIELD_ERROR = new Element(By.xpath("//span[@class='errors' and text()='Введите настоящий e-mail']"));
    public Element EMPTY_EMAIL_FIELD_ERROR = new Element(By.xpath("//span[@class='errors' and text()='Поле не должно быть пустым']"));

    @Step
    public ResetPasswordPopUp fillEmailField(String email) {
        ENTER_EMAIL.cleaIn();
        ENTER_EMAIL.fillIn(email);
        return this;
    }

    @Step
    public ZayavkaPrinyataPopUp successfulPressButtonVosstanovit() {
        if (RESET_BUTTON.isVisible()) {
            RESET_BUTTON.click();
        } else {
            RESET_BUTTON_WITHOUT_JS.click();  //sometimes js isn't loaded in opera browser so we use the version without js
        }
        waitForPageToLoad();
        return new ZayavkaPrinyataPopUp();
    }

    @Step
    public ResetPasswordPopUp forbiddenPressButtonVosstanovit() {
        if (RESET_BUTTON.isVisible()) {
            RESET_BUTTON.click();
        } else {
            RESET_BUTTON_WITHOUT_JS.click();  //sometimes js isn't loaded in opera browser so we use the version without js
        }
        return this;
    }

    @Step
    public HomePage pressButtonClosepopUp() {
        CLOSE_BUTTON.click();
        return new HomePage();
    }

    public String getEmailFieldErrorMessage() {
        return INVALID_EMAIL_FIELD_ERROR.getText();
    }

}
