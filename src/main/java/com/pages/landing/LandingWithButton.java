package com.pages.landing;

import com.Elements.Button;
import com.pages.AbstractPage;
import com.pages.Helpers.Dictionaries.LandingRegistrationFormType;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
/**
 * Class for mapping Landing Pages 1, 2, 4, 5, 14
 */

public class LandingWithButton extends AbstractPage {
    private Button REGISTER_BUTTON = new Button(By.xpath("//a[@href='/users/register']"));

    @Step
    public LandingWithButton clickRegisterButton() {
        REGISTER_BUTTON.click();
        return this;
    }

    @Step
    public FastRegisterLP switchToRegistration() {
        return new FastRegisterLP(new LandingRegistrationFormType());
    }
}
