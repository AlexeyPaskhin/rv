package com.pages.Helpers.Dictionaries;

import com.Elements.Button;
import com.Elements.Checkbox;
import com.Elements.InputBox;
import com.Elements.RadioButton;

/**
 * Interface for different registation types to use strategy
 */
public interface RegistrationFormType {
    InputBox getEmailInput();
    InputBox getPasswordInput();
    RadioButton getCurrencyRubRadio();
    RadioButton getCurrencyUsdRadio();
    Checkbox getAgreeCheckbox();
    Button getRegisterButton();

}
