package com.pages.landing;

import com.Elements.Button;
import com.pages.AbstractPage;
import com.pages.Helpers.Dictionaries.LandingRegistrationFormType;
import org.openqa.selenium.By;

public class LandingWithButton extends AbstractPage {
    Button REGISTER_BUTTON = new Button(By.xpath("//a[@href='/users/register']"));

    public LandingWithButton clickRegisterButton() {
        REGISTER_BUTTON.click();

        return this;
    }

   public FastRegisterLanding switchToRegistration(){

        return new FastRegisterLanding(new LandingRegistrationFormType());
    }

}
