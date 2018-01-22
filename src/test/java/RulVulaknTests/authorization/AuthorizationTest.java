package RulVulaknTests.authorization;

import RulVulaknTests.BaseTestPage;
import com.listeners.RussianVulcanListener;
import com.pages.HeaderNotAutorizedUser;
import com.pages.HomePage;
import com.utils.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({RussianVulcanListener.class})
public class AuthorizationTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(AuthorizationTest.class);

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"auth"})
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
