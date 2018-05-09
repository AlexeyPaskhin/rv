package RulVulaknTests.pages;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.authorization.AuthorizationData;
import RulVulaknTests.cashbox.CashboxTest;
import RulVulaknTests.registration.RegisterData;
import com.listeners.RussianVulcanListener;
import com.pages.*;
import com.popups.CashBoxPopup;
import com.utils.User;
import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Authorized user - HEADER
 * + logo icon
 * + Status icon
 * + User's name
 * + NotificationsPage icon
 * + Gift icon
 * + Exit button
 * + 'Popolnit schet' button
 */

@Listeners({RussianVulcanListener.class})
public class HeaderAutorizedUserTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(CashboxTest.class);
    VipPage vipPage;
    NotificationsPage notificationsPage;

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"regression"})
    @Description("Is Logo icon present for authorized user and linked to Home page")
    public void isLogoIconPresentAndClickableForAuthorizedUser(User user) {
        new HomePage()
                .getNotAuthorizedHeader()
                .typeEmailInHeadField(user.getLogin())
                .typePassInHeadField(user.getPass())
                .clickLogin()
                .getAuthorizedHeader()
                .clickLogoIcon()
                .homePageLoaded();
        try {
            Assert.assertTrue(home.isHomePageOpenedForAuthorizedUser());
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"regression"})
    @Description("Is Logo icon present for authorized user and linked to Vip page")
    public void isStatusIconPresentAndClickableForAuthorizedUser(User user) {
        new HomePage()
                .getNotAuthorizedHeader()
                .typeEmailInHeadField(user.getLogin())
                .typePassInHeadField(user.getPass())
                .clickLogin()
                .getAuthorizedHeader()
                .clickVipStatusIcon()
                .waitForPageToLoad();
        try {
            vipPage = new VipPage();
            Assert.assertTrue(vipPage.isVipPageOpened());
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"regression"})
    @Description("Is NotificationsPage icon clickable for authorized user and linked to NotificationsPage page")
    public void isLettersIconPresentAndClickableForAuthorizedUser(User user) {
        new HomePage()
                .getNotAuthorizedHeader()
                .typeEmailInHeadField(user.getLogin())
                .typePassInHeadField(user.getPass())
                .clickLogin()
                .getAuthorizedHeader()
                .clickNotificationsIcon()
                .waitForPageToLoad();
        try {
            notificationsPage = new NotificationsPage();
            Assert.assertTrue(notificationsPage.isNotificationsPageOpened());
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"regression", "cashbox", "header"})
    @Description("Open (and close) cashbox pop-up from header for authorized user")
    public void openCashBoxPopUpFromHeader(User user) {
        new HomePage()
                .getNotAuthorizedHeader()
                .typeEmailInHeadField(user.getLogin())
                .typePassInHeadField(user.getPass())
                .clickLogin()
                .getAuthorizedHeader()
                .pressCashBoxButton()
                .clickCloseCashboxPopup()
                .homePageLoaded();
        try {
            Assert.assertTrue(home.isHomePageOpenedForAuthorizedUser());
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"regression", "cashbox", "header"})
    @Description("Press button Exit in Header")
    public void pressButtonExitInHeader(User user) {
        new HomePage()
                .getNotAuthorizedHeader()
                .typeEmailInHeadField(user.getLogin())
                .typePassInHeadField(user.getPass())
                .clickLogin()
                .getAuthorizedHeader()
                .clickExit()
                .homePageLoaded();
        try {
            Assert.assertTrue(home.isHomePageOpenedForNotAuthorized());
            Assert.assertTrue(headerNotAutorizedUser.registerButtonIsPresent());
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }
}
