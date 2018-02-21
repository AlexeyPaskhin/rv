package RulVulaknTests.pages;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.authorization.AuthorizationData;
import RulVulaknTests.cashbox.CashboxTest;
import com.listeners.RussianVulcanListener;
import com.pages.HomePage;
import com.pages.ProfilePage;
import com.utils.User;
import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({RussianVulcanListener.class})
public class ProfilePageTest extends BaseTestPage{
    private final static Logger logger = LogManager.getLogger(CashboxTest.class);
    ProfilePage profilePage;

    // TODO: 2018-02-20 Check Profile page here
    @Test(dataProvider = "authorizationUserEmail", dataProviderClass = AuthorizationData.class, groups = {"regression"})
    @Description("Is User's name clickable for authorized user and linked to Profile page")
    public void isUserNameIconPresentAndClickableForAuthorizedUser(User user) {
        new HomePage()
                .getNotAuthorizedHeader()
                .typeEmailInHeadField(user.getLogin())
                .typePassInHeadField(user.getPass())
                .clickLogin()
                .getAuthorizedHeader()
                .clickUserName()
                .waitForPageToLoad();
        try {
            profilePage = new ProfilePage();
            Assert.assertTrue(profilePage.isProfilePageOpened());
        } catch (Exception e) {
            logger.error(e);
            Assert.fail();
        }
    }
}
