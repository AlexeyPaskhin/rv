package com.pages.landing;

import com.pages.AbstractPage;
import com.pages.Helpers.Dictionaries.LandingWithFormType;

public class LandingWithForm extends AbstractPage {

    public FastRegister switchToRegistration() {
        return new FastRegister(new LandingWithFormType());
    }
}
