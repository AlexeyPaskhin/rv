package com.pages.mobile;

import com.Elements.Button;
import com.Elements.InputBox;
import com.pages.AbstractPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AuthMobilePage extends AbstractPage {
    private InputBox EMAIL_INPUT_BOX = new InputBox(By.id("auth-form-login"));
    private InputBox PASS_INPUT_BOX = new InputBox(By.id("auth-form-password"));
    private Button LOGIN_BUTTON = new Button(By.className("btn-send"));

    @Step
    public AuthMobilePage fillEmail(String login) {
        EMAIL_INPUT_BOX.cleaIn();
        EMAIL_INPUT_BOX.fillIn(login);
        return this;
    }

    @Step
    public AuthMobilePage fillPass(String pass) {
        PASS_INPUT_BOX.cleaIn();
        PASS_INPUT_BOX.fillIn(pass);
        return this;
    }

    @Step
    public HomeMobilePage clickLogin() {
        LOGIN_BUTTON.click();
        return new HomeMobilePage();
    }
}
