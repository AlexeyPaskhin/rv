package com.popups;

import com.Elements.Element;
import com.pages.AbstractPage;
import com.pages.HomePage;
import org.openqa.selenium.By;

/**
 * Class of pop-up "Ваш аккаунт временно заблокирован" - if user enter invalid pass more then 5 times - user banned
 */

public class UserBannedPopUp extends AbstractPage {

    private final Element USER_BANNED_POP_UP_HEADER = new Element(By.xpath("//*[@id=\"popup_account-temporarily-blocked\"]//div[@class='popup-header']"));
    StayPopUp stayPopUp = new StayPopUp();

    public boolean isUserBannedPopUpPresent() {
        if (stayPopUp.isStayPopUpOpened()) {
            stayPopUp.closeStayPopUp();
        }
        if (USER_BANNED_POP_UP_HEADER.isPresent()) {
            return true;
        } else {
            return false;
        }
    }
}
