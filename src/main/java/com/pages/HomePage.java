package com.pages;

import com.Elements.Button;
import com.Elements.Frame;
import com.Elements.Panel;
import com.pages.landing.social.*;
import com.popups.CashBoxPopup;
import com.popups.FastRegisterPopup;
import com.popups.GiftPopup;
import org.openqa.selenium.By;

import static com.utils.DriverManager.getDriver;

public class HomePage extends AbstractPage {
    private final Button REGISTER_BUTTON = new Button(By.cssSelector(".btn-registration-top"));
    private final Panel USER_PANE = new Panel(By.xpath("//div[@class='top-user-zone']"));
    private final Panel CONTENT_PANE = new Panel(By.xpath("//div[@class='wrap cf']"));
    private final GiftPopup GIFT_POPUP = new GiftPopup();
    private final CashBoxPopup CASH_BOX_POPUP = new CashBoxPopup();

    private final Button HEAD_VK_BUTTON = new Button(By.xpath("//form[@id='top-user-form']//div[@class='social-vk']"));
    private final Button HEAD_FB_BUTTON = new Button(By.xpath("//form[@id='top-user-form']//div[@class='social-fb']"));
    private final Button HEAD_OK_BUTTON = new Button(By.xpath("//form[@id='top-user-form']//div[@class='social-ok']"));
    private final Button HEAD_MailRU_BUTTON = new Button(By.xpath("//form[@id='top-user-form']//div[@class='social-mr']"));
    private final Button HEAD_YA_BUTTON = new Button(By.xpath("//form[@id='top-user-form']//div[@class='social-ya']"));

    private final Frame BLANK_IFRAME = new Frame(By.xpath("//iframe [@src=\"/blank-iframe\"]"));

    private final Button HEAD_CASHBOX_BUTTON = new Button(By.xpath("//a[@class='btn-recharge-top']//span"));

    public VkRegisterPage clickHeadVK(){
        HEAD_VK_BUTTON.click();
        swithToSocialFrame();
        return new VkRegisterPage();
    }

    public FBregisterPage clickHeadFB(){
        HEAD_FB_BUTTON.click();
        swithToSocialFrame();
        return new FBregisterPage();
    }

    public OKRegisterPage clickHeadOK(){
        HEAD_OK_BUTTON.click();
        swithToSocialFrame();
        return new OKRegisterPage();
    }

    public MailRuRegisterPage clickHeadMailRU(){
        HEAD_MailRU_BUTTON.click();
        swithToSocialFrame();
        return new MailRuRegisterPage();
    }

    public YARegisterPage clickHeadYA(){
        HEAD_YA_BUTTON.click();
        swithToSocialFrame();
        return new YARegisterPage();
    }

    public FastRegisterPopup clickRegister() {
        REGISTER_BUTTON.click();
        return new FastRegisterPopup();
    }

    public CashBoxPopup clickHeadCashBox() {
        HEAD_CASHBOX_BUTTON.waitForElementToBeVisible(5);
        BLANK_IFRAME.waitForElementToBeInvisible(5);
        HEAD_CASHBOX_BUTTON.click();
        return new CashBoxPopup();
    }

    public boolean RegisterButtonIsPresent() {
        homePageLoaded();
        return REGISTER_BUTTON.isPresent();
    }

    public boolean UserZoneIsPresent() {
        homePageLoaded();
        return USER_PANE.isPresent();
    }

    public GiftPopup getGiftPopup() {
        return GIFT_POPUP;
    }

    private void homePageLoaded() {
        CONTENT_PANE.waitForElementToBeVisible(10);
    }
}
