package com.pages;

import com.Elements.Button;
import com.Elements.Element;
import com.Elements.Frame;
import com.Elements.Panel;
import com.popups.CashBoxPopup;
import com.popups.GiftPopup;
import com.popups.RedHelperFrame;
import org.openqa.selenium.By;

public class HomePage extends AbstractPage {
    private final Panel CONTENT_PANE = new Panel(By.xpath("//div[@class='wrap cf']"));
    private final GiftPopup GIFT_POPUP = new GiftPopup();

    private final Frame BLANK_IFRAME = new Frame(By.xpath("//iframe [@src=\"/blank-iframe\"]"));
    private final Button HEAD_CASHBOX_BUTTON = new Button(By.xpath("//a[@class='btn-recharge-top']//span"));

    private final Button RED_HELPER_BUTTON = new Button(By.xpath("//*[@id=\"rh-badge\"]//img"));

    public CashBoxPopup clickHeadCashBox() {
        HEAD_CASHBOX_BUTTON.waitForElementToBeVisible(5);
        BLANK_IFRAME.waitForElementToBeInvisible(5);
        HEAD_CASHBOX_BUTTON.click();
        return new CashBoxPopup();
    }

    public HeaderNotAutorizedUser getNotAuthorizedHeader() {
        return new HeaderNotAutorizedUser();
    }

    public HeaderAutorizedUser getAuthorizedHeader() {
        return new HeaderAutorizedUser();
    }

    public GiftPopup getGiftPopup() {
        return GIFT_POPUP;
    }

    public void homePageLoaded() {
        CONTENT_PANE.waitForElementToBeVisible(10);
        PRELOADER.waitForElementToBeInvisible(5);
    }

    public RedHelperFrame openRedHelperFrame() {
        if (RED_HELPER_BUTTON.isVisible()) {
            RED_HELPER_BUTTON.click();
        } else {
            RED_HELPER_BUTTON.waitForElementToBeClickable(3);
            RED_HELPER_BUTTON.click();
        }
        return new RedHelperFrame();
    }
}
