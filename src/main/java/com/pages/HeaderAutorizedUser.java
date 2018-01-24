package com.pages;

import com.Elements.Element;
import com.Elements.Panel;
import org.openqa.selenium.*;

public class HeaderAutorizedUser extends AbstractPage {

    private final Panel USER_PANE = new Panel(By.xpath("//div[@class='top-user-zone']"));
    private final Panel REAL_BALANCE_PANEL = new Panel(By.xpath("//span[@id='user_balance_real']"));
    private final Element GIFT_ICON = new Element((By.xpath("//span[@class='gift-icon']")));

    public boolean userZoneIsPresent() {
        new HomePage().homePageLoaded();
        return USER_PANE.isPresent();
    }

    public boolean giftIconIsPresent() {
        return GIFT_ICON.isPresent();
    }

    public double getUserBalance() {
        double sum = Double.parseDouble(REAL_BALANCE_PANEL.getText().replaceAll(" ",""));
        return sum;
    }

    public void waitForBalanceChange(double oldBalance) {
        while(oldBalance== getUserBalance()){
            refreshPage();
            REAL_BALANCE_PANEL.waitForElementToBeVisible(5);
            if (oldBalance!=getUserBalance()) break;
        }
    }
}
