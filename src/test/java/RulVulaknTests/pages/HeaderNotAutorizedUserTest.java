package RulVulaknTests.pages;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.cashbox.CashboxTest;
import com.listeners.RussianVulcanListener;
import com.pages.HeaderNotAutorizedUser;
import com.pages.HomePage;
import com.popups.EnterPopUp;
import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Un-authorized user - HEADER
 * + logo icon is visible
 * + after click on Logo page - opening Home Page
 * + try to log-in from header - with empty fields e-mail/password
 * + try to log-in from header - with invalid field e-mail and correct password
 * + try to log-in from header - with invalid field password and correct e-mail
 */
@Listeners({RussianVulcanListener.class})
public class HeaderNotAutorizedUserTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(CashboxTest.class);
    EnterPopUp enterPopUp;

    @Test(groups = {"regression"})
    @Description("After click on logo icon on HeaderNotAutorizedUserTest for un-authorized user opened Home Page and Logo icon is visible")
    public void clickLogoToOpenHomePage() {
        new HeaderNotAutorizedUser()
                .clickLogoIcon()
                .homePageLoaded();
        try {
            Assert.assertTrue(home.isHomePageOpenedForNotAuthorized());
            Assert.assertTrue(headerNotAutorizedUser.isLogoIconVisible(), "Logo icon is NOT VISIBLE for un-authorized user");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(groups = {"regression", "negative"})
    @Description("Try to log-in from header with empty fields login/password")
    public void pressButtonVojtiWithEmptyFields() {
        new HomePage()
                .getNotAuthorizedHeader()
                .pressButtonVoyti();
        try {
            enterPopUp = new EnterPopUp();
            Assert.assertEquals(enterPopUp.fieldEmailShouldNotBeEmpty(), "Поле не должно быть пустым");
            Assert.assertEquals(enterPopUp.fieldPasswordShouldNotBeEmpty(), "Поле не должно быть пустым");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(groups = {"regression", "negative"})
    @Description("Try to log-in from header - with invalid e-mail.")
    public void authFromHeaderWithInvalidEmail() {
        new HomePage()
                .getNotAuthorizedHeader()
                .typeEmailInHeadField("invalidEmail")
                .typePassInHeadField("123456")
                .pressButtonVoyti();
        try {
            enterPopUp = new EnterPopUp();
            Assert.assertEquals(enterPopUp.incorrectPassOrEmailError(), "Неправильные имя пользователя и/или пароль");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(groups = {"regression", "negative"})
    @Description("Try to log-in from header - with invalid password.")
    public void authFromHeaderWithInvalidPassword() {
        new HomePage()
                .getNotAuthorizedHeader()
                .typeEmailInHeadField("yr+2@playtini.ua")
                .typePassInHeadField("invalidPass")
                .pressButtonVoyti();
        try {
            enterPopUp = new EnterPopUp();
            Assert.assertEquals(enterPopUp.incorrectPassOrEmailError(), "Неправильные имя пользователя и/или пароль");
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }
}
