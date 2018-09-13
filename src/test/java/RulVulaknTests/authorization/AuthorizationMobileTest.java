package RulVulaknTests.authorization;

import RulVulaknTests.BaseTestPage;
import com.listeners.RussianVulcanListener;
import com.pages.mobile.HomeMobilePage;
import com.utils.User;
import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

import static com.utils.DriverManager.getDriver;
import static org.testng.Assert.*;

@Listeners({RussianVulcanListener.class})
public class AuthorizationMobileTest extends BaseTestPage {
    private final static Logger logger = LogManager.getLogger(AuthorizationMobileTest.class);


    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"androidAuth", "androidSmoke"})
    @Description("Simple authorization via email and pass")
    public void authorizationUserFromMail(User user) {
        HomeMobilePage homeMobilePage =
                new HomeMobilePage()
                        .clickLogin()
                        .fillEmail(user.getLogin())
                        .fillPass(user.getPass())
                        .clickLogin();
        assertTrue(homeMobilePage.getPROFILE_BUTTON().isPresent(), "USER ZONE NOT PRESENT");
        assertFalse(homeMobilePage.getLOGIN_BUTTON().isPresent(), "REGISTER BUTTON IS DISPLAYED");
    }

    @Test(dataProvider = "authorizationUserForVK", dataProviderClass = AuthorizationData.class, groups = {"androidAuth", "androidSmoke"})
    @Description("Social authorization - via VK.com")
    public void authorizationUserFromVK(User user) {
        HomeMobilePage homeMobilePage =
                new HomeMobilePage()
                        .clickLogin()
                        .clickVkLogin()
                        .setEmail(user.getLogin())
                        .setPassword(user.getPass())
                        .clickLogInMobile();
        assertTrue(homeMobilePage.getPROFILE_BUTTON().isPresent(), "USER ZONE NOT PRESENT");
        assertFalse(homeMobilePage.getLOGIN_BUTTON().isPresent(), "REGISTER BUTTON IS DISPLAYED");
    }

    @Test(dataProvider = "authorizationUserForFB", dataProviderClass = AuthorizationData.class, groups = {"androidAuth", "androidSmoke"})
    @Description("Social authorization - via FaceBook.com")
    public void authorizationUserFromFB(User user) {
        HomeMobilePage homeMobilePage =
                new HomeMobilePage()
                        .clickLogin()
                        .clickFbLogin()
                        .setEmail(user.getLogin())
                        .setPassword(user.getPass())
                        .clickLogInMobile();
        assertTrue(homeMobilePage.getPROFILE_BUTTON().isPresent(), "USER ZONE NOT PRESENT");
        assertFalse(homeMobilePage.getLOGIN_BUTTON().isPresent(), "REGISTER BUTTON IS DISPLAYED");
    }

    @Test(dataProvider = "authorizationUserForOK", dataProviderClass = AuthorizationData.class, groups = {"androidAuth", "androidSmoke"})
    @Description("Social authorization - via OK.ru")
    public void authorizationUserFromOK(User user) {
        HomeMobilePage homeMobilePage =
                new HomeMobilePage()
                        .clickLogin()
                        .clickOkLogin()
                        .setEmail(user.getLogin())
                        .setPassword(user.getPass())
                        .clickLogInMobile();
        assertTrue(homeMobilePage.getPROFILE_BUTTON().isPresent(), "USER ZONE NOT PRESENT");
        assertFalse(homeMobilePage.getLOGIN_BUTTON().isPresent(), "REGISTER BUTTON IS DISPLAYED");
    }

    @Test(dataProvider = "authorizationUserForMailRU", dataProviderClass = AuthorizationData.class, groups = {"androidAuth", "androidSmoke"})
    @Description("Social authorization - via Mail.ru")
    public void authorizationUserFromMailRU(User user) {
        HomeMobilePage homeMobilePage =
                new HomeMobilePage()
                        .clickLogin()
                        .clickMrLogin()
                        .setEmail(user.getLogin())
                        .setPassword(user.getPass())
                        .clickLogInMobile();
        assertTrue(homeMobilePage.getPROFILE_BUTTON().isPresent(), "USER ZONE NOT PRESENT");
        assertFalse(homeMobilePage.getLOGIN_BUTTON().isPresent(), "REGISTER BUTTON IS DISPLAYED");
    }

    @Test(dataProvider = "authorizationUserForYA", dataProviderClass = AuthorizationData.class, groups = {"androidAuth", "androidSmoke"})
    @Description("Social authorization - via Yandex.ru")
    public void authorizationUserFromYA(User user) {
        HomeMobilePage homeMobilePage =
                new HomeMobilePage()
                        .clickLogin()
                        .clickYaLogin()
                        .setEmail(user.getLogin())
                        .setPassword(user.getPass())
                        .clickLogInMobile();
        assertTrue(homeMobilePage.getPROFILE_BUTTON().isPresent(), "USER ZONE NOT PRESENT");
        assertFalse(homeMobilePage.getLOGIN_BUTTON().isPresent(), "REGISTER BUTTON IS DISPLAYED");
    }

}
