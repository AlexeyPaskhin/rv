package com.pages;

import com.Elements.Button;
import com.Elements.Element;
import com.Elements.Frame;
import com.Elements.Panel;
import com.popups.CashBoxPopup;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.*;

@Getter
public class HeaderAutorizedUser extends AbstractPage implements Header {

    private final Panel USER_PANE = new Panel(By.xpath("//div[@class='top-user-zone']"));
    private final Element GIFT_ICON = new Element((By.xpath("//span[@class='gift-icon']")));
    private final Panel REAL_BALANCE_PANEL = new Panel(By.xpath("//span[@id='user_balance_real']"));
    private final Element LOGO_ICON = new Element(By.xpath("//a[@class='logo' and @href='/']"));
    private final Element VIP_ICON = new Element(By.xpath("//a[@href='/vip' and @class='vip_user_zone_vip']"));
    private final Element USER_NAME_LINK = new Element(By.xpath("//a[@class='profile']"));
    private final Element NOTIFICATIONS_ICON = new Element(By.xpath("//a[@class='notification']"));
    private final Button CASH_BOX_BUTTON = new Button(By.xpath("//a[@class='btn-recharge-top']"));
    private final Element LOG_OUT = new Element(By.xpath("//a[@class='logout']"));

    private final Frame BLANK_IFRAME = new Frame(By.xpath("//iframe [@src=\"/blank-iframe\"]"));

    public boolean userZoneIsPresent() {
        new HomePage().homePageLoaded();
        return USER_PANE.isPresent();
    }

    public boolean giftIconIsPresent() {
        GIFT_ICON.waitForElementToBePresent(5);
        return GIFT_ICON.isPresent();
    }

    public double getUserBalance() {
        double sum = Double.parseDouble(REAL_BALANCE_PANEL.getText().replaceAll(" ", ""));
        return sum;
    }

    @Step
    public void waitForBalanceChange(double oldBalance) {
        for (int i = 0; oldBalance == getUserBalance() && i < 10; i++) {
            refreshPage();
            REAL_BALANCE_PANEL.waitForElementToBeVisible(5);
        }
    }

    @Step
    public HomePage clickLogoIcon() {
        LOGO_ICON.waitForElementToBePresent(6);
        LOGO_ICON.clickUntilDisappeared();
        return new HomePage();
    }

    @Step
    public VipPage clickVipStatusIcon() {
        VIP_ICON.waitForElementToBePresent(5);
        VIP_ICON.click();
        return new VipPage();
    }

    @Step
    public ProfilePage clickUserName() {
        USER_NAME_LINK.waitForElementToBeClickable(4);
        USER_NAME_LINK.click();
        return new ProfilePage();
    }

    @Step
    public NotificationsPage clickNotificationsIcon() {
        NOTIFICATIONS_ICON.waitForElementToBeClickable(4);
        NOTIFICATIONS_ICON.click();
        return new NotificationsPage();
    }

    @Step
    public BonusesPage clickGiftIcon() {
        GIFT_ICON.waitForElementToBeClickable(4);
        GIFT_ICON.click();
        return new BonusesPage();
    }

    @Step
    public CashBoxPopup pressCashBoxButton() {
        CASH_BOX_BUTTON.waitForElementToBeVisible(5);
        BLANK_IFRAME.waitForElementToBeInvisible(5);
        CASH_BOX_BUTTON.click();
        return new CashBoxPopup();
    }

    @Step
    public HomePage clickExit() {
        LOG_OUT.click();
        return new HomePage();
    }
}
