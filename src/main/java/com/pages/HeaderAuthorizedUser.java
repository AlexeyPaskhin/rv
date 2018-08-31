package com.pages;

import com.Elements.Button;
import com.Elements.Element;
import com.Elements.Panel;
import com.popups.CashBoxPopup;
import com.popups.cashBoxFrames.CashBoxWithdrawalFrame;
import com.utils.Card;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.*;

@Getter
public class HeaderAuthorizedUser extends AbstractPage implements Header {

    private final Panel USER_PANE = new Panel(By.xpath("//div[@class='top-user-zone']"));
    private final Element GIFT_ICON = new Element((By.xpath("//span[@class='gift-icon']")));
    private final Panel REAL_BALANCE_PANEL = new Panel(By.xpath("//span[@id='user_balance_real']"));
    private final Element LOGO_ICON = new Element(By.xpath("//a[@class='logo' and @href='/']"));
    private final Element VIP_ICON = new Element(By.xpath("//a[@href='/vip' and @class='vip_user_zone_vip']")); // works only for status VIP
    private final Button ACHIEVEMENTS_BUTTON = new Button(By.xpath("//a[@href='/users/achievements']"));
    private final Element USER_NAME_LINK = new Element(By.xpath("//a[@class='profile']"));
    private final Element NOTIFICATIONS_ICON = new Element(By.xpath("//a[@class='notification']"));
    private final Button CASH_BOX_BUTTON = new Button(By.xpath("//a[@class='btn-recharge-top']"));
    private final Element LOG_OUT = new Element(By.xpath("//a[@class='logout']"));

    private final Element ACHIEVEMENT_NOTIFICATION = new Element(By.xpath("//section[@id='for-notification']"));
    private Element LINK_NEW_ACHIEVEMENT = ACHIEVEMENT_NOTIFICATION.getSubElementByXpath("//a[@href]");
    private Element LINK_NEW_DEPS_ACHIEVEMENT = ACHIEVEMENT_NOTIFICATION.getSubElementByXpath("//a[@href='/users/achievements#deps']");
    private Element CLOSE_ACHIEVEMENT_BUTTON = ACHIEVEMENT_NOTIFICATION.getSubElementByXpath("//a[@class='personal_close']");

    public boolean userZoneIsPresent() {
        new HomePage().waitForHomePageLoaded();
        USER_PANE.waitForElementToBeVisible(8);
        return USER_PANE.isPresent();
    }

    public boolean giftIconIsPresent() {
        refreshPage();
        waitForPageToLoad();
        try {
            GIFT_ICON.waitForElementToBeVisible(10);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public double getUserBalance() {
        double sum = Double.parseDouble(REAL_BALANCE_PANEL.getText().replaceAll(" ", ""));
        return sum;
    }

    @Step
    public void makeDeposit(Card card, String sum) {
        pressCashBoxButton()
                .switchToCashBoxDepositFrame()
                .clickCardPaymentMethod()
                .typeCardNumber(card.getNumber())
                .typeCardHolder(card.getHolder())
                .typeCardCVV(card.getCvv())
                .clickOnInputButton()
                .cleanDepositInputField()
                .typeCardDepositSum(sum)
                .clickOnConfirmButton()
                .clickOnOkayButton()
                .switchToParent();
    }

    @Step
    public CashBoxWithdrawalFrame makeWithdrawal(String sum) {
        return pressCashBoxButton()
                .clickTabWithdrawal()
                .switchToCashBoxWithdrawalFrame()
                .clickCardPaymentMethod()
                .typeCardWithdrawalSum(sum)
                .typePhoneNumberInCardDepositFrame("9101234567")
                .clickGetButton();
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
        BLANK_IFRAME.waitForElementToBeInvisible(5);
        LOGO_ICON.click();
        return new HomePage();
    }

    @Step
    public VipPage clickVipStatusIcon() {
        VIP_ICON.waitForElementToBePresent(5);
        VIP_ICON.click();
        return new VipPage();
    }

    @Step
    public AchievementsPage clickAchievements() {
        ACHIEVEMENTS_BUTTON.click();
        return new AchievementsPage();
    }

    @Step
    public ProfilePage clickUserName() {
        waitForPageToLoad();
//        USER_NAME_LINK.waitForElementToBeClickable(5);
        eliminatePopUp();
        USER_NAME_LINK.click();
        return new ProfilePage();
    }

    @Step
    public NotificationsPage clickNotificationsIcon() {
        NOTIFICATIONS_ICON.waitForElementToBeClickable(5);
        NOTIFICATIONS_ICON.click();
        return new NotificationsPage();
    }

    @Step
    public BonusesPage clickGiftIcon() {
        refreshPage();
        GIFT_ICON.waitForElementToBeClickable(10);
        GIFT_ICON.click();
        return new BonusesPage();
    }

    @Step
    public CashBoxPopup pressCashBoxButton() {
        CASH_BOX_BUTTON.waitForElementToBeClickable(10);
        BLANK_IFRAME.waitForElementToBeInvisible(5);
        CASH_BOX_BUTTON.click();
        return new CashBoxPopup();
    }

    @Step
    public HomePage clickExit() {
        LOG_OUT.click();
        return new HomePage();
    }

    public HeaderAuthorizedUser waitForAchievementNotification() {
        ACHIEVEMENT_NOTIFICATION.waitForElementToBeVisible(20);
        return this;
    }

    public HeaderAuthorizedUser waitForDepsAchievementNotificationClosingUnnecessary() {
        do {
            ACHIEVEMENT_NOTIFICATION.waitForElementToBeVisible(30);
            if (!LINK_NEW_DEPS_ACHIEVEMENT.isPresent()) {
                try {
                    CLOSE_ACHIEVEMENT_BUTTON.click();
                } catch (StaleElementReferenceException e) {
                    e.printStackTrace();
                    refreshPage();
                }
            }
        }
        while (!LINK_NEW_DEPS_ACHIEVEMENT.isPresent());
        return this;
    }

    public HeaderAuthorizedUser waitForNotificationWithSpecialTitleClosingUnnecessary(String title) {

        do {
            ACHIEVEMENT_NOTIFICATION.waitForElementToBeVisible(30);
            if (!ACHIEVEMENT_NOTIFICATION.getSubElementByXpath("//p").getText().equals(title)) {
                try {
                    CLOSE_ACHIEVEMENT_BUTTON.click();
                } catch (StaleElementReferenceException e) {
                    e.printStackTrace();
                    refreshPage();
                }
            }
        }
        while (!ACHIEVEMENT_NOTIFICATION.getSubElementByXpath("//p[text()='" + title + "']").isPresent());
        return this;
    }

    public AchievementsPage clickLinkInAchievementNotification() {
        LINK_NEW_ACHIEVEMENT.click();
        return new AchievementsPage();
    }

    public AchievementsTasksPage clickLinkInAchievementForTaskNotification() {
        LINK_NEW_ACHIEVEMENT.click();
        return new AchievementsTasksPage();
    }
}
