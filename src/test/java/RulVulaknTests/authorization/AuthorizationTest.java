package RulVulaknTests.authorization;

import RulVulaknTests.BaseTestPage;
import com.listeners.RussianVulcanListener;
import com.pages.HomePage;
import com.utils.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import sun.security.krb5.internal.AuthorizationData;

/**
 * Created by ai on 2018-01-15.
 */

@Listeners({RussianVulcanListener.class})
public class AuthorizationTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(AuthorizationTest.class);

    @Test(dataProvider = "authorizationUserForVK", dataProviderClass = AuthorizationData.class, groups = {"auth", "vk"})
    public void authorizationUserFromVK(User user){
        new HomePage().clickHeadVK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister();

        try {
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON MAIN PAGE");
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "authorizationUserForFB", dataProviderClass = AuthorizationData.class, groups = {"auth", "fb"})
    public void authorizationUserFromFB(User user){
        new HomePage().clickHeadFB()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister();

        try {
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON MAIN PAGE");
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "authorizationUserForOK", dataProviderClass = AuthorizationData.class, groups = {"auth", "ok"})
    public void authorizationUserFromOK(User user){
        new HomePage().clickHeadOK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister();

        try {
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON MAIN PAGE");
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "authorizationUserForMailRU", dataProviderClass = AuthorizationData.class, groups = {"auth", "mailru"})
    public void authorizationUserFromMailRU(User user){
        new HomePage().clickHeadMailRU()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister();

        try {
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON MAIN PAGE");
            logger.error(e);
            Assert.fail();
        }
    }

    @Test(dataProvider = "authorizationUserForYA", dataProviderClass = AuthorizationData.class, groups = {"auth", "ya"})
    public void authorizationUserFromYA(User user){
        new HomePage().clickHeadYA()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister();

        try {
            Assert.assertTrue(home.UserZoneIsPresent(), "USER ZONE NOT PRESENT");
            Assert.assertFalse(home.RegisterButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
        } catch (Exception e) {
            logger.error("ERROR ON MAIN PAGE");
            logger.error(e);
            Assert.fail();
        }
    }

}
