package com.popups;

import com.Elements.Element;
import com.pages.AbstractPage;
import org.openqa.selenium.By;

/**
 * Log-In pop-up ('Vhod')
 */
public class EnterPopUp extends AbstractPage {
    // Validation error messages
    public static final Element EMPTY_EMAIL_FIELD_ERROR = new Element(By.xpath("//span[contains(text(), 'Поле не должно быть пустым')]"));
    public static final Element INCORRECT_PASS_OR_EMAIL_ERROR = new Element(By.xpath("//span[contains(text(), 'Неправильные имя пользователя и/или пароль')]"));

    public String fieldEmailShouldNotBeEmpty() {
        EMPTY_EMAIL_FIELD_ERROR.waitForElementToBeVisible(3);
        return EMPTY_EMAIL_FIELD_ERROR.getText();
    }

    public String fieldPasswordShouldNotBeEmpty() {
        EMPTY_EMAIL_FIELD_ERROR.waitForElementToBeVisible(3);
        return EMPTY_EMAIL_FIELD_ERROR.getText();
    }

    public String incorrectPassOrEmailError() {
        INCORRECT_PASS_OR_EMAIL_ERROR.waitForElementToBeVisible(3);
        return INCORRECT_PASS_OR_EMAIL_ERROR.getText();
    }

}
