package RulVulaknTests.authorization;

import RulVulaknTests.BaseTestPage;
import com.listeners.RussianVulcanListener;
import com.pages.HeaderNotAutorizedUser;
import com.pages.HomePage;
import com.popups.RedHelperFrame;
import com.utils.User;
import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Authorization
 * + from header
 */

@Listeners({RussianVulcanListener.class})
public class AuthorizationTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(AuthorizationTest.class);

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"auth"})
    @Description("Simple authorization from HeaderTest.")
    public void authorizationUserFromMail(User user) {
        new HomePage()
                .getNotAuthorizedHeader()
                .typeEmailInHeadField(user.getLogin())
                .typePassInHeadField(user.getPass())
                .clickLogin();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON MAIN PAGE");
            logger.error(e);
            Assert.fail();
        }
    }


    @Test(dataProvider = "authorizationUserForVK", dataProviderClass = AuthorizationData.class, groups = {"auth", "vk"})
    @Description("Social authorization from HeaderTest - via VK.com")
    public void authorizationUserFromVK(User user) {
        new HeaderNotAutorizedUser().clickHeadVK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON MAIN PAGE");
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "authorizationUserForFB", dataProviderClass = AuthorizationData.class, groups = {"auth", "fb"})
    @Description("Social authorization from HeaderTest - via FaceBook.com")
    public void authorizationUserFromFB(User user) {
        new HeaderNotAutorizedUser().clickHeadFB()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON MAIN PAGE");
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "authorizationUserForOK", dataProviderClass = AuthorizationData.class, groups = {"auth", "ok"})
    @Description("Social authorization from HeaderTest - via OK.ru")
    public void authorizationUserFromOK(User user) {
        new HeaderNotAutorizedUser().clickHeadOK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON MAIN PAGE");
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "authorizationUserForMailRU", dataProviderClass = AuthorizationData.class, groups = {"auth", "mailru"})
    @Description("Social authorization from HeaderTest - via Mail.ru")
    public void authorizationUserFromMailRU(User user) {
        new HeaderNotAutorizedUser().clickHeadMailRU()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON MAIN PAGE");
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "authorizationUserForYA", dataProviderClass = AuthorizationData.class, groups = {"auth", "ya"})
    @Description("Social authorization from HeaderTest - via Yandex.ru")
    public void authorizationUserFromYA(User user) {
        new HeaderNotAutorizedUser().clickHeadYA()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister();
        try {
            Assert.assertTrue(headerAutorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON MAIN PAGE");
            logger.error(e);
            Assert.fail();
        }
    }

}