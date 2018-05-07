package com.popups;

import com.Elements.Element;
import com.pages.AbstractPage;
import com.pages.HomePage;
import org.openqa.selenium.By;

public class StayPopUp extends AbstractPage {
    private final Element CLOSE_STAY_POP_UP_BUTTON = new Element(By.xpath("//*[@id=\"stay-popup\"]/div/a"));

    public HomePage closeStayPopUp() {
        CLOSE_STAY_POP_UP_BUTTON.waitForElementToBePresent(3);
        CLOSE_STAY_POP_UP_BUTTON.click();
        return new HomePage();
    }

    public boolean isStayPopUpOpened() {
        if(CLOSE_STAY_POP_UP_BUTTON.isVisible())
            return true;
        else
            return false;
    }
}
