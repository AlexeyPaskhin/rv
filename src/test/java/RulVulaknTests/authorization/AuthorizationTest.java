package RulVulaknTests.authorization;

import RulVulaknTests.BaseTestPage;
import com.listeners.RussianVulcanListener;
import com.pages.HeaderNotAutorizedUser;
import com.pages.HomePage;
import com.utils.User;
import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

/**
 * Authorization
 * + from header
 */

@Listeners({RussianVulcanListener.class})
public class AuthorizationTest extends BaseTestPage {

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"auth", "prodSmoke"}, alwaysRun = true)
    @Description("Simple authorization from HeaderNotAutorizedUserTest.")
    public void authorizationUserFromMail(User user) {
        new HomePage()
                .getNotAuthorizedHeader()
                .typeEmailInHeadField(user.getLogin()/*+"fkmjfklmjfkmjfgmjfgmj"*/)
                .typePassInHeadField(user.getPass())
                .clickLogin();
        Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
        Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
    }

    @Test(dataProvider = "authorizationUserForVK", dataProviderClass = AuthorizationData.class, groups = {"auth", "vk", "prodSmoke"}, alwaysRun = true)
    @Description("Social authorization from HeaderNotAutorizedUserTest - via VK.com")
    public void authorizationUserFromVK(User user) {
        new HeaderNotAutorizedUser().clickHeadVK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister();
        Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
        Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
    }

    @Test(dataProvider = "authorizationUserForFB", dataProviderClass = AuthorizationData.class, groups = {"auth", "fb", "prodSmoke"}, alwaysRun = true)
    @Description("Social authorization from HeaderNotAutorizedUserTest - via FaceBook.com")
    public void authorizationUserFromFB(User user) {
        new HeaderNotAutorizedUser()
                .clickHeadFB()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister();
        Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
        Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
    }

    @Test(dataProvider = "authorizationUserForOK", dataProviderClass = AuthorizationData.class, groups = {"auth", "ok", "prodSmoke"}, alwaysRun = true)
    @Description("Social authorization from HeaderNotAutorizedUserTest - via OK.ru")
    public void authorizationUserFromOK(User user) {
        new HeaderNotAutorizedUser().clickHeadOK()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister();
        Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
        Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
    }

    @Test(dataProvider = "authorizationUserForMailRU", dataProviderClass = AuthorizationData.class, groups = {"auth", "mailru", "prodSmoke"}, alwaysRun = true)
    @Description("Social authorization from HeaderNotAutorizedUserTest - via Mail.ru")
    public void authorizationUserFromMailRU(User user) {
        new HeaderNotAutorizedUser().clickHeadMailRU()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister();
        Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
        Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
    }

    @Test(dataProvider = "authorizationUserForYA", dataProviderClass = AuthorizationData.class, groups = {"auth", "ya", "prodSmoke"}, alwaysRun = true)
    @Description("Social authorization from HeaderNotAutorizedUserTest - via Yandex.ru")
    public void authorizationUserFromYA(User user) {
        new HeaderNotAutorizedUser().clickHeadYA()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickRegister();
        Assert.assertTrue(headerAuthorizedUser.userZoneIsPresent(), "USER ZONE NOT PRESENT");
        Assert.assertFalse(headerNotAutorizedUser.registerButtonIsPresent(), "REGISTER BUTTON IS DISPLAYED");
    }
}