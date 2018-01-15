package com.pages.landing;

import com.Elements.Button;
import com.pages.AbstractPage;
import com.pages.Helpers.Dictionaries.LandingRegistrationFormType;
import org.openqa.selenium.By;

public class LandingWithButton extends AbstractPage {
    private Button REGISTER_BUTTON = new Button(By.xpath("//a[@href='/users/register']"));

    public LandingWithButton clickRegisterButton() {
        REGISTER_BUTTON.click();
        return this;
    }

    public FastRegister switchToRegistration() {
        return new FastRegister(new LandingRegistrationFormType());
    }
}
