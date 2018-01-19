package com.pages;

import com.Elements.Element;
import com.Elements.Panel;
import org.openqa.selenium.By;

public class HeaderAutorizedUser extends AbstractPage {
    HomePage homePage;

    private final Panel USER_PANE = new Panel(By.xpath("//div[@class='top-user-zone']"));
    private final Element GIFT_ICON = new Element((By.xpath("//span[@class='gift-icon']")));

    public boolean userZoneIsPresent() {
        homePage = new HomePage();
        homePage.homePageLoaded();
        return USER_PANE.isPresent();
    }

    public boolean giftIconIsPresent() {
        return GIFT_ICON.isPresent();
    }
}
