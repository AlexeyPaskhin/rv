package com.popups;

import com.Elements.Button;
import com.pages.AbstractPage;
import com.pages.HomePage;
import org.openqa.selenium.By;

/**
 * Pop-up Zayavka Prinjata
 * + pop-up showed after filling and sending password recovery form
 */

public class ZayavkaPrinyataPopUp extends AbstractPage {
    private final Button CLOSE_POP_UP_BUTTON = new Button(By.xpath("//*[@id=\"popup_alert\"]/a"));

    public HomePage closePopUpZayavkaPriniata() {
        CLOSE_POP_UP_BUTTON.click();
        return new HomePage();
    }
}
