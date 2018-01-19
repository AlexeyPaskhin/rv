package com.pages;

import com.Elements.Panel;
import org.openqa.selenium.By;

public class HeaderAutorizedUser extends AbstractPage {


    private final Panel USER_PANE = new Panel(By.xpath("//div[@class='top-user-zone']"));

    public boolean userZoneIsPresent() {
        new HomePage().homePageLoaded();
        return USER_PANE.isPresent();
    }
}
