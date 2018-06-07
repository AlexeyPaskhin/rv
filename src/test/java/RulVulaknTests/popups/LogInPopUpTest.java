package RulVulaknTests.popups;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.authorization.AuthorizationData;
import RulVulaknTests.cashbox.CashboxTest;
import com.listeners.RussianVulcanListener;
import com.pages.HomePage;
import com.utils.User;
import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Log-in pop-up ('Vhod')
 * + close pop-up
 * + authorization success
 * + link Forgot Password works
 * + link Register works
 */

@Listeners({RussianVulcanListener.class})
public class LogInPopUpTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(CashboxTest.class);

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"regression", "negative", "auth"})
    @Description("Press button 'Close' in Log-In pop-up")
    public void pressButtonCloseInLogInPopUp(User user) {
        new HomePage()
                .getNotAuthorizedHeader()
                .pressButtonLogIn()
                .pressButtonClose()
                .waitForHomePageLoaded();
        try {
            Assert.assertTrue(home.isHomePageOpenedForNotAuthorized());
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"regression", "auth"})
    @Description("Login from Log-In pop-up")
    public void logInFromPopUp(User user) {
        new HomePage()
                .getNotAuthorizedHeader()
                .pressButtonLogIn()
                .typeEmailInPopupField(user.getLogin())
                .typePassInPopupField(user.getPass())
                .pressLoginIn()
                .waitForHomePageLoaded();
        try {
            Assert.assertTrue(home.isHomePageOpenedForAuthorizedUser());
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"regression"})
    @Description("Check is link Forgot Password works in Log-In pop-up")
    public void checkLinkForgotPasswordInLogInPopUp(User user) {
        new HomePage()
                .getNotAuthorizedHeader()
                .pressButtonLogIn()
                .clickForgotPasswordLink()
                .pressButtonClosepopUp()
                .waitForHomePageLoaded();
        try {
            Assert.assertTrue(home.isHomePageOpenedForNotAuthorized());
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"regression"})
    @Description("Try to register from Log-In pop-up")
    public void registrationFromLogInPopUp(User user) {
        new HomePage()
                .getNotAuthorizedHeader()
                .pressButtonLogIn()
                .clickRegistrationLink()
                .closeFastRegisterPopUp()
                .waitForHomePageLoaded();
        try {
            Assert.assertTrue(home.isHomePageOpenedForNotAuthorized());
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }
}
