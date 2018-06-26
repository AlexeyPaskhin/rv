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

    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"mobile"})
    @Description("Simple authorization via email and pass")
    public void authorizationUserFromMail(User user) {
        HomeMobilePage homeMobilePage =
                new HomeMobilePage()
                        .clickLogin()
                        .fillEmail(user.getLogin())
                        .fillPass(user.getPass())
                        .clickLogin();
        assertTrue(homeMobilePage.GAMES_BUTTON.isPresent(), "USER ZONE NOT PRESENT");
        assertFalse(homeMobilePage.LOGIN_BUTTON.isPresent(), "REGISTER BUTTON IS DISPLAYED");
    }
}
