package com.pages.Helpers.Dictionaries;

import com.Elements.Button;
import com.Elements.Checkbox;
import com.Elements.InputBox;
import com.Elements.RadioButton;

public interface RegistrationFormType {
    InputBox getEmailInput();

    InputBox getPasswordInput();

    RadioButton getCurrencyRubRadio();

    RadioButton getCurrencyUsdRadio();

    Checkbox getAgreeCheckbox();

    Button getRegisterButton();

}
