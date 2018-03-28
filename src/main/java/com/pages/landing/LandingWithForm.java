package com.pages.landing;

import com.pages.AbstractPage;
import com.pages.Helpers.Dictionaries.LandingWithFormType;
import io.qameta.allure.Step;

public class LandingWithForm extends AbstractPage {

    @Step
    public FastRegister switchToRegistration() {
        return new FastRegister(new LandingWithFormType());
    }
}
