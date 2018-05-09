package com.popups;

import com.Elements.Element;
import com.pages.AbstractPage;
import org.openqa.selenium.By;

/**
 * Pop-up 'Vhod' - Authorization from pop-up
 */
public class AuthPopup extends AbstractPage {
    private static final Element AUTH_POP_UP_HEADER = new Element(By.xpath("//*[@id=\"popup_auth\"]//div[@class='popup-header']"));

    public boolean isAuthPopupOpened() {
        AUTH_POP_UP_HEADER.waitForElementToBeVisible(1);
        return AUTH_POP_UP_HEADER.isVisible();
    }

    // TODO: 2018-05-08 Add tests for Auth pop-up page version  - check FastRegisterPopup class
}
