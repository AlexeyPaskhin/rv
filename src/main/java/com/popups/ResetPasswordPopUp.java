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
    private final InputBox ENTER_EMAIL = new InputBox(By.xpath("//input[@id='restore-form-login']"));
    private final Button CLOSE_BUTTON = new Button(By.xpath("//*[@id=\"popup_restore-password\"]/a"));

    // Validation error messages
    public static final Element EMAIL_FIELD_ERROR = new Element(By.xpath("//*[@id=\"popup_restore-password\"]//span[@class='errors']"));

    @Step
    public ResetPasswordPopUp fillEmailField(String email) {
        ENTER_EMAIL.cleaIn();
        ENTER_EMAIL.fillIn(email);
        return this;
    }

    @Step
    public ZayavkaPrinyataPopUp pressButtonVosstanovit() {
        RESET_BUTTON.click();
        waitForPageToLoad();
        return new ZayavkaPrinyataPopUp();
    }

    @Step
    public HomePage pressButtonClosepopUp() {
        CLOSE_BUTTON.click();
        return new HomePage();
    }

    public String emailFieldErrorMessage() {
        EMAIL_FIELD_ERROR.waitForElementToBeVisible(3);
        return EMAIL_FIELD_ERROR.getText();
    }

}
